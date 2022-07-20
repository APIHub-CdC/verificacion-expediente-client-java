package mx.com.cdc.apihub.ve.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.apihub.ve.constants.HeaderConstants;
import mx.com.cdc.apihub.ve.facade.dto.ExpedienteFacade;
import mx.com.cdc.apihub.ve.security.interfaces.SignatureHelper;

public final class ApiClient {

	private static final Logger log = LoggerFactory.getLogger(ApiClient.class);
	
	private final String url;
	private final String apiKey;
	private final String username;
	private final String password;
	private final SignatureHelper signatureHelper;
	
	private ApiClient(
			String url, 
			String apiKey, 
			String username, 
			String password, 
			SignatureHelper signatureHelper) {
		
		this.url				= url;
		this.apiKey				= apiKey;
		this.username			= username;
		this.password			= password;
		this.signatureHelper	= signatureHelper;
	}
	
	public static class Builder {
		private String url;
		private String apiKey;
		private String username;
		private String password;
		private SignatureHelper signatureHelper;
		
		public Builder url(String url) {
			this.url = url;
			return this;
		}
		
		public Builder apiKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}
		
		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder signatureHelper(SignatureHelper signatureHelper) {
			this.signatureHelper = signatureHelper;
			return this;
		}
		
		public ApiClient build() {
			return new ApiClient(url, apiKey, username, password, signatureHelper);
		}
	}
	
	public String verificarExpediente(ExpedienteFacade facade) throws Exception {
		
		String payloadJson	= facade.toJsonString();
		StringEntity entity = new StringEntity(payloadJson, ContentType.APPLICATION_JSON);
		String hexSignature = signatureHelper.signAsHexString(payloadJson);
		
		log.debug("{}: {}", HeaderConstants.SIGNATURE, hexSignature);
		
		CloseableHttpClient client = HttpClients.createDefault();
	
		HttpPost post = new HttpPost(url);
		post.setHeader(HeaderConstants.API_KEY, apiKey);
		post.setHeader(HeaderConstants.SIGNATURE, hexSignature);
		post.setHeader(HeaderConstants.USERNAME, username);
		post.setHeader(HeaderConstants.PASSWORD, password);
		post.setEntity(entity);
		
		log.debug("Making HTTP Request to [{}] ...", url);
		
		CloseableHttpResponse response = client.execute(post);
		String responsePayload = EntityUtils.toString(response.getEntity());
		
		response.close();
		client.close();
		
		log.debug("HTTP Request to [{}] finished", url);
		
		return responsePayload;
	}
}
