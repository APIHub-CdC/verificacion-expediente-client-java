package mx.com.cdc.apihub.ve.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cdc.apihub.signer.manager.interceptor.SignerInterceptor;

import mx.com.cdc.apihub.ve.client.ApiClient;
import mx.com.cdc.apihub.ve.model.CatalogoEstados;
import mx.com.cdc.apihub.ve.model.CatalogoSexo;
import mx.com.cdc.apihub.ve.model.DomicilioPeticion;
import mx.com.cdc.apihub.ve.model.Domicilios;
import mx.com.cdc.apihub.ve.model.PersonaPeticion;
import mx.com.cdc.apihub.ve.model.Personas;
import mx.com.cdc.apihub.ve.model.PersonasPeticion;
import mx.com.cdc.apihub.ve.model.Respuesta;
import okhttp3.OkHttpClient;

public class ApiTest {

	private final ApiVerificacionExpediente api = new ApiVerificacionExpediente();

	private ApiClient apiClient;

	private String url		= "cdc-api-url";
	private String xApiKey	= "your-x-api-key";
	private String username	= "your-username";
	private String password	= "your-password";

	private String keystoreFile		= "";
	private String cdcCertFile		= "";
	private String keystorePassword = "";
	private String keyAlias			= "";
	private String keyPassword		= "";

	@Before()
	public void setUp() {

		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);

		OkHttpClient okHttpClient = new OkHttpClient()
				.newBuilder()
				.readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(new SignerInterceptor(
						keystoreFile, 
						cdcCertFile, 
						keystorePassword, 
						keyAlias, 
						keyPassword))
				.build();

		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getReporteTest() throws Exception {

		DomicilioPeticion domicilioPeticion = new DomicilioPeticion();
		domicilioPeticion.setCiudad("");
		domicilioPeticion.setDelegacionMunicipio("");
		domicilioPeticion.setCiudad("");
		domicilioPeticion.setEstado(CatalogoEstados.DF);
		domicilioPeticion.setCodigoPostal("");
		domicilioPeticion.setNumeroTelefono("");

		List<DomicilioPeticion> domicilioPeticionList = new ArrayList<DomicilioPeticion>();
		domicilioPeticionList.add(domicilioPeticion);

		Domicilios domicilios = new Domicilios();
		domicilios.setList(domicilioPeticionList);

		PersonasPeticion personasPeticion = new PersonasPeticion();
		personasPeticion.setNombres("");
		personasPeticion.setApellidoPaterno("");
		personasPeticion.setApellidoMaterno("");
		personasPeticion.setFechaNacimiento("");
		personasPeticion.setRFC("");
		personasPeticion.setCURP("");
		personasPeticion.setClaveElectorIFE("");
		personasPeticion.setSexo(CatalogoSexo.M);
		personasPeticion.setDomicilios(domicilios);

		List<PersonasPeticion> personasPeticionList = new ArrayList<PersonasPeticion>();
		personasPeticionList.add(personasPeticion);

		Personas personas = new Personas();
		personas.setFolio("");
		personas.setList(personasPeticionList);

		PersonaPeticion personaPeticion = new PersonaPeticion();
		personaPeticion.setFolioOtorgante("");
		personaPeticion.setPersonas(personas);

		Respuesta respuesta = api.getReporte(xApiKey, username, password, personaPeticion);

		Assert.assertTrue(respuesta.getPersonas().getFolio() != null);
	}
}
