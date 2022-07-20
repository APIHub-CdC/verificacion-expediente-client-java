package mx.com.cdc.apihub.ve.security;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Security;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.apihub.ve.security.interfaces.PrivateKeyHelper;

/**
 * This class requires the BouncyCastle library.
 * 
 * @author rarubioa
 *
 */
public class EcdsaPrivateKeyHelper implements PrivateKeyHelper {

	private final static Logger log = LoggerFactory.getLogger(EcdsaPrivateKeyHelper.class);
	
	private String privateKeyString;
	
	/**
	 * Constructor.
	 * 
	 * @param filePath A path of some file containing an ECDSA private key.
	 * @throws IOException
	 */
	public EcdsaPrivateKeyHelper(Path filePath) throws IOException {
		
		if (!Files.exists(filePath)) {
			throw new IllegalArgumentException(
					String.format("The file provided '%s' doesn't exist!", filePath.toString()));
		}
		
		String privateKeyFileContent = Files.readString(filePath);
		log.debug("Private Key file content:\n{}", privateKeyFileContent);
		
		privateKeyString = parsePrivateKeyString(privateKeyFileContent);
		log.debug("Private Key:\n{}", privateKeyString);
	}
	
	private String parsePrivateKeyString(String privateKey) {
		
		if (privateKey.contains(CryptoConstants.PRIVATE_KEY_PARAMS_HEADER) 
				&& privateKey.contains(CryptoConstants.PRIVATE_KEY_PARAMS_FOOTER)) {
		
			int startIndex = privateKey.indexOf(CryptoConstants.PRIVATE_KEY_HEADER);
			int endIndex = privateKey.indexOf(CryptoConstants.PRIVATE_KEY_FOOTER) 
					+ CryptoConstants.PRIVATE_KEY_FOOTER.length();
			
			return privateKey.substring(startIndex, endIndex).trim();
		}
		
		return privateKey;
	}
	
	/**
	 * Constructor.
	 * 
	 * @param privateKeyString An ECDSA private key.
	 */
	public EcdsaPrivateKeyHelper(String privateKeyString) {
		this.privateKeyString = privateKeyString;
	}
	
	/**
	 * Get the private key as String.
	 */
	@Override
	public String getPrivateKeyAsString() {
		return privateKeyString;
	}

	public String getPrivateKeyAsHex() {
		return Hex.encodeHexString(getPrivateKeyAsBytes(), true);
	}
	
	/**
	 * Get the private key as bytes using a Base64 decoder.
	 * 
	 */
	@Override
	public byte[] getPrivateKeyAsBytes() {
		int startIndex = privateKeyString.lastIndexOf(CryptoConstants.PRIVATE_KEY_HEADER) 
				+ CryptoConstants.PRIVATE_KEY_HEADER.length();
		int endIndex = privateKeyString.indexOf(CryptoConstants.PRIVATE_KEY_FOOTER);
		
		String privateKeyNotHeaders = privateKeyString.substring(startIndex, endIndex).trim().replaceAll("\n", "");
		
		log.debug("Private Key without headers: {}", privateKeyNotHeaders);
		return Base64.getDecoder().decode(privateKeyNotHeaders.getBytes());
	}

	@Override
	public PrivateKey getPrivateKey() {
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			Object objParsed = new PEMParser(new StringReader(getPrivateKeyAsString())).readObject();
			KeyPair keyPair = new JcaPEMKeyConverter().getKeyPair((PEMKeyPair)objParsed);
			
			return keyPair.getPrivate();
			
		} catch (Exception exception) {
			
			log.error("Fatal error trying to load ECDSA Private Key: {}", exception);
			
			throw new RuntimeException(
					String.format("Fatal error trying to load ECDSA Private Key: %s", exception.getMessage()), 
					exception);
		}
	}
}
