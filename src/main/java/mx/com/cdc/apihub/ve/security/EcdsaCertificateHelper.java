package mx.com.cdc.apihub.ve.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcdsaCertificateHelper implements mx.com.cdc.apihub.ve.security.interfaces.CertificateHelper {

	private final static Logger log = LoggerFactory.getLogger(EcdsaCertificateHelper.class);
	
	private String certificateString;
	private String publicKeyString;
	
	/**
	 * Constructor.
	 * 
	 * @param filePath A path of some file containing an ECDSA certificate.
	 * @throws IOException
	 */
	public EcdsaCertificateHelper(Path filePath) throws IOException {
		
		if (!Files.exists(filePath)) {
			throw new IllegalArgumentException(
					String.format("The file provided '%s' doesn't exist!", filePath.toString()));
		}
		
		certificateString = Files.readString(filePath);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param certificateString An ECDSA certificate.
	 */
	public EcdsaCertificateHelper(String certificateString) {
		this.certificateString = certificateString;
	}
	
	@Override
	public String getCertificateAsString() {
		return certificateString;
	}

	@Override
	public PublicKey getPublicKey() throws CertificateException {
		CertificateFactory factory = CertificateFactory.getInstance("x.509");
		
		Certificate certificate = factory.generateCertificate(
				new ByteArrayInputStream(certificateString.getBytes())
				);
		
		return certificate.getPublicKey();
	}
	
	/**
	 * Get an ECDSA Public Key as String encoded in Base64 with public key format headers.
	 */
	@Override
	public String getPublicKeyAsString() throws CertificateException {
		
		if (publicKeyString != null) {
			return publicKeyString;
		}
		
		PublicKey publicKey = getPublicKey();
		
		StringBuffer stringBuffer = new StringBuffer(CryptoConstants.PUBLIC_KEY_HEADER + CryptoConstants.NEW_LINE);
		
		String publicKeyNotHeaders = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		
		log.debug("ECDSA Public Key as Base64 String without headers: {}", publicKeyNotHeaders);
		
		while(!publicKeyNotHeaders.isEmpty()) {
			
			if (publicKeyNotHeaders.length() < 64) {
				stringBuffer.append(publicKeyNotHeaders + CryptoConstants.NEW_LINE);
				break;
			}
			
			stringBuffer.append(publicKeyNotHeaders.substring(0, 64) + CryptoConstants.NEW_LINE);
			publicKeyNotHeaders = publicKeyNotHeaders.substring(64, publicKeyNotHeaders.length());
		}
		
		stringBuffer.append(CryptoConstants.PUBLIC_KEY_FOOTER);
		publicKeyString = stringBuffer.toString();
		
		log.debug("ECDSA Public Key as Base64 String with headers:\n {}", publicKeyString);
		
		return publicKeyString;
	}

	/**
	 * Get an ECDSA Public Key as bytes decoded with Base64.
	 */
	@Override
	public byte[] getPublicKeyAsBytes() {
		
		String tmpKeyString = null;
		
		if (publicKeyString.contains(CryptoConstants.PUBLIC_KEY_HEADER)
				&& publicKeyString.contains(CryptoConstants.PUBLIC_KEY_FOOTER)) {
			
			tmpKeyString = publicKeyString
					.substring(
							publicKeyString.indexOf(CryptoConstants.PUBLIC_KEY_HEADER) 
							+ CryptoConstants.PUBLIC_KEY_HEADER.length(), 
							publicKeyString.indexOf(CryptoConstants.PUBLIC_KEY_FOOTER)
							)
					.replace("\n", "")
					.strip();
			
			log.debug(tmpKeyString);
			
			return Base64.getDecoder().decode(tmpKeyString.getBytes());
		}
		
		throw new IllegalArgumentException("No public key found in the current certificate object!");
	}
}
