package mx.com.cdc.apihub.ve.security.interfaces;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import javax.crypto.SecretKey;

public interface SharedSecretHelper {

	SecretKey generateSharedKey() 
			throws NoSuchAlgorithmException, 
			NoSuchProviderException, 
			InvalidKeyException, 
			IllegalStateException,
			CertificateException;
}
