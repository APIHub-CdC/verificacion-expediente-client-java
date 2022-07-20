package mx.com.cdc.apihub.ve;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.apihub.ve.client.ApiClient;
import mx.com.cdc.apihub.ve.constants.Estado;
import mx.com.cdc.apihub.ve.constants.Genero;
import mx.com.cdc.apihub.ve.facade.dto.DomicilioFacade;
import mx.com.cdc.apihub.ve.facade.dto.ExpedienteFacade;
import mx.com.cdc.apihub.ve.facade.dto.PersonaFacade;
import mx.com.cdc.apihub.ve.security.EcdsaPrivateKeyHelper;
import mx.com.cdc.apihub.ve.security.EcdsaSignatureHelper;
import mx.com.cdc.apihub.ve.security.interfaces.PrivateKeyHelper;
import mx.com.cdc.apihub.ve.security.interfaces.SignatureHelper;

public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static final void main(String[] args) throws Exception {
		
		try {
			// Create DTO objects
			DomicilioFacade domicilio = new DomicilioFacade.Builder()
					.direccion("")
					.delegacionMunicipio("")
					.ciudad("")
					.estado(Estado.DISTRITO_FEDERAL)
					.codigoPostal("")
					.numeroTelefono("")
					.build();
			
			PersonaFacade persona = new PersonaFacade.Builder()
					.nombre("")
					.apellidoPaterno("")
					.apellidoMaterno("")
					.fechaNacimiento(LocalDate.of(1980, 12, 31))
					.rfc("")
					.curp("")
					.claveElectorIfe("")
					.genero(Genero.MASCULINO)
					.addDomicilio(domicilio)
					.build();
			

			ExpedienteFacade expedienteFacade = new ExpedienteFacade.Builder()
					.folio("")
					.folioOtorgante("")
					.addPersona(persona)
					.build();
			
			// Path location of the private-key
			Path privateKeyFilePath = Path.of("/your-path/your-private-key.pem");
			
			PrivateKeyHelper privateKeyHelper	= new EcdsaPrivateKeyHelper(privateKeyFilePath);
			SignatureHelper signatureHelper		= new EcdsaSignatureHelper(privateKeyHelper);
			
			// Required data for HTTP request
			String url		= "";
			String apiKey	= "";
			String username	= "";
			String password	= "";
			
			// API HTTP client
			ApiClient client = new ApiClient.Builder()
					.url(url)
					.apiKey(apiKey)
					.username(username)
					.password(password)
					.signatureHelper(signatureHelper)
					.build();
			
			// Invoke API
			String response = client.verificarExpediente(expedienteFacade);
			
			log.info("HTTP Response: {}", response);
			
		} catch (Exception exception) {
			StringWriter error = new StringWriter();
			exception.printStackTrace(new PrintWriter(error));
			
			log.error(error.toString());
		}
	}
}
