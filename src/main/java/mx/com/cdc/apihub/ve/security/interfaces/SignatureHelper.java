package mx.com.cdc.apihub.ve.security.interfaces;

public interface SignatureHelper {

	byte[] signAsBytes(String data);
	
	boolean verifyHexSignature(String data, String hexSignature);
	
	boolean verifyBase64Signature(String data, String base64Signature);
	
	String signAsBase64String(String data);
	
	String signAsHexString(String data);
}
