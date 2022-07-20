package mx.com.cdc.apihub.ve.security.interfaces;

import java.security.PublicKey;
import java.security.cert.CertificateException;

public interface CertificateHelper {

	String getCertificateAsString();
	String getPublicKeyAsString() throws CertificateException;
	byte[] getPublicKeyAsBytes();
	PublicKey getPublicKey() throws CertificateException;
}
