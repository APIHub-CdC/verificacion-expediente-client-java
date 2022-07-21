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
    
    private String url			= "https://eoxer6snf871egr.m.pipedream.net";
    private String xApiKey		= "your-x-api-key";
    private String username		= "your-username";
    private String password		= "your-password";
    
    private String keystoreFile		= "/Users/rarubioa/Documents/Certificates/QA-qa_apple-29-jun-2022/signature-cdc-java/qa-apple-keystore.jks";
	private String cdcCertFile		= "/Users/rarubioa/Documents/Certificates/QA-qa_apple-29-jun-2022/cdc_cert_1492692233.pem";
	private String keystorePassword	= "Z1K8jSL4vC2aHSqM";
	private String keyAlias			= "qa-apple-pkcs";
	private String keyPassword		= "X60q35SkmAjx7sMM";
    
    @Before()
    public void setUp() {
        this.apiClient = api.getApiClient();
         this.apiClient.setBasePath(url);
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new SignerInterceptor(keystoreFile, cdcCertFile, keystorePassword, keyAlias, keyPassword))
                .build();
         apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void getReporteTest() throws Exception {
        
        PersonaPeticion request = new PersonaPeticion();
        
        Personas personas = new Personas();
        
        List<PersonasPeticion> personasPeticionList = new ArrayList<PersonasPeticion>();
        
        PersonasPeticion personasPeticion = new PersonasPeticion();
        
        Domicilios domicilios = new Domicilios();
        
        List<DomicilioPeticion> domicilioPeticionList = new ArrayList<DomicilioPeticion>();
        
        DomicilioPeticion domicilioPeticion = new DomicilioPeticion();
        
        domicilioPeticion.setCiudad("INSURGENTES SUR 1007");
        domicilioPeticion.setDelegacionMunicipio(" MIGUEL HIDALGO");
        domicilioPeticion.setCiudad("MEXICO");
        domicilioPeticion.setEstado(CatalogoEstados.DF);
        domicilioPeticion.setCodigoPostal("11230");
        domicilioPeticion.setNumeroTelefono("5517207788");
        
        domicilioPeticionList.add(domicilioPeticion);
        
        domicilios.setList(domicilioPeticionList);
        
        
        personasPeticion.setNombres("JUAN");
        personasPeticion.setApellidoPaterno("PRUEBA");
        personasPeticion.setApellidoMaterno("SIETE");
        personasPeticion.setFechaNacimiento("1980-01-07");
        personasPeticion.setRFC("PUSJ800107");
        personasPeticion.setCURP("SAZR010101HCMLNS09");
        personasPeticion.setClaveElectorIFE("000000000000");
        personasPeticion.setSexo(CatalogoSexo.F);
        personasPeticion.setDomicilios(domicilios);
        
        personasPeticionList.add(personasPeticion);
        
        personas.setFolio("1234");
        personas.setList(personasPeticionList);
        
        request.setFolioOtorgante("1001");
        request.setPersonas(personas);
        
        Respuesta response = api.getReporte(
        		xApiKey,
        		username,
        		password, 
        		request);
        
        Assert.assertTrue(response.getPersonas().getFolio() != null);
    }
}
