package mx.com.cdc.apihub.ve.security.interfaces;

import java.security.PrivateKey;

public interface PrivateKeyHelper {

	byte[] getPrivateKeyAsBytes();
	
	String getPrivateKeyAsString();
	
	PrivateKey getPrivateKey();
}
