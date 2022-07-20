package mx.com.cdc.apihub.ve.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.cert.CertificateException;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import mx.com.cdc.apihub.ve.security.interfaces.CertificateHelper;
import mx.com.cdc.apihub.ve.security.interfaces.PrivateKeyHelper;
import mx.com.cdc.apihub.ve.security.interfaces.SharedSecretHelper;

public class ECDHSharedSecretHelper implements SharedSecretHelper {
	
	private CertificateHelper helperCertificateA;
	private PrivateKeyHelper helperPrivateKeyB;
	
	public ECDHSharedSecretHelper(CertificateHelper helperCertificateA, PrivateKeyHelper helperPrivateKeyB) {
		this.helperCertificateA = helperCertificateA;
		this.helperPrivateKeyB = helperPrivateKeyB;
	}
	
	@Override
	public SecretKey generateSharedKey() 
			throws NoSuchAlgorithmException, 
			NoSuchProviderException, 
			InvalidKeyException, 
			IllegalStateException, 
			CertificateException {
		
		Security.addProvider(new BouncyCastleProvider());
		
		KeyAgreement keyAgreement = KeyAgreement.getInstance(
				CryptoConstants.KEY_AGREEMENT_ALGORITHM_ECDH, 
				CryptoConstants.CRYPTO_PROVIDER_BOUNCY_CASTLE
				);
		
		keyAgreement.init(helperPrivateKeyB.getPrivateKey());
		keyAgreement.doPhase(helperCertificateA.getPublicKey(), true);
		
		return keyAgreement.generateSecret(CryptoConstants.ALGORITHM_AES);
	}
}
