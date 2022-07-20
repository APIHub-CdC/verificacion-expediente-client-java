package mx.com.cdc.apihub.ve.security;

import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.apihub.ve.security.interfaces.CertificateHelper;
import mx.com.cdc.apihub.ve.security.interfaces.PrivateKeyHelper;
import mx.com.cdc.apihub.ve.security.interfaces.SignatureHelper;

/**
 * This class requires the apache commons codec library.
 * 
 * @author rarubioa
 *
 */
public class EcdsaSignatureHelper implements SignatureHelper {

	private final static Logger log = LoggerFactory.getLogger(EcdsaSignatureHelper.class);
	
	private CertificateHelper helperCertificate;
	private PrivateKeyHelper helperPrivateKey;
	
	public EcdsaSignatureHelper(CertificateHelper helperCertificate, PrivateKeyHelper helperPrivateKey) {
		this.helperCertificate = helperCertificate;
		this.helperPrivateKey = helperPrivateKey;
	}
	
	public EcdsaSignatureHelper(PrivateKeyHelper helperPrivateKey) {
		this.helperPrivateKey = helperPrivateKey;
	}
	
	@Override
	public String signAsBase64String(String data) {
		return Base64.getEncoder().encodeToString(signAsBytes(data));
	}

	@Override
	public String signAsHexString(String data) {
		return Hex.encodeHexString(signAsBytes(data), true);
	}

	@Override
	public byte[] signAsBytes(String data) {
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			Signature signatureService = Signature.getInstance(CryptoConstants.ALGORITHM_ECDSA_SHA256);
			signatureService.initSign(helperPrivateKey.getPrivateKey());
			signatureService.update(data.getBytes());
			
			return signatureService.sign();
			
		} catch (Exception exception) {
			
			log.error("Fatal error trying to sign data with {} algorithm: {}", 
					CryptoConstants.ALGORITHM_ECDSA_SHA256, 
					exception);
			
			throw new RuntimeException(
					String.format("Fatal error trying to sign data: %s", exception.getMessage()), exception);
		}
	}

	@Override
	public boolean verifyHexSignature(String data, String hexSignature) {
		
		if (helperCertificate == null) {
			throw new RuntimeException(
					"Missing HelperCertificate object, cannot verify the signature without a certificate.");
		}
		
		try {
			CertificateFactory factory = CertificateFactory.getInstance(CryptoConstants.CERTIFICATE_FORMAT_X509);
			Certificate certificate = factory.generateCertificate(
					new ByteArrayInputStream(helperCertificate.getCertificateAsString().getBytes()));
			
			PublicKey publicKey = certificate.getPublicKey();
			
			Signature signatureService = Signature.getInstance(CryptoConstants.ALGORITHM_ECDSA_SHA256);
			signatureService.initVerify(publicKey);
			signatureService.update(data.getBytes());
		
			return signatureService.verify(Hex.decodeHex(hexSignature));
			
		} catch (Exception exception) {
			
			log.error("Fatal error trying to verify the signature: {}", exception);
			
			throw new RuntimeException(String.format(
					"Fatal error trying to verify the signature: ", 
					exception.getMessage()),
					exception
					);
		}
	}

	@Override
	public boolean verifyBase64Signature(String data, String base64Signature) {
		
		if (helperCertificate == null) {
			throw new RuntimeException(
					"Missing HelperCertificate object, cannot verify the signature without a certificate.");
		}
		
		try {
			CertificateFactory factory = CertificateFactory.getInstance(CryptoConstants.CERTIFICATE_FORMAT_X509);
			Certificate certificate = factory.generateCertificate(
					new ByteArrayInputStream(helperCertificate.getCertificateAsString().getBytes()));
			
			PublicKey publicKey = certificate.getPublicKey();
			
			Signature signatureService = Signature.getInstance(CryptoConstants.ALGORITHM_ECDSA_SHA256);
			signatureService.initVerify(publicKey);
			signatureService.update(data.getBytes());
		
			return signatureService.verify(Base64.getDecoder().decode(base64Signature.getBytes()));
			
		} catch (Exception exception) {
			
			log.error("Fatal error trying to verify the signature: ", exception);
			
			throw new RuntimeException(String.format(
					"Fatal error trying to verify the signature: ", 
					exception.getMessage()),
					exception
					);
		}
	}
}
