package mx.com.cdc.apihub.ve.security;

public final class CryptoConstants {

	public final static String CRYPTO_PROVIDER_BOUNCY_CASTLE	= "BC";
	public final static String ALGORITHM_AES					= "AES";
	public final static String ALGORITHM_AES_GCM_NO_PADDING		= "AES/GCM/NoPadding";
	public final static String KEY_AGREEMENT_ALGORITHM_ECDH		= "ECDH";
	public final static String CERTIFICATE_FORMAT_X509			= "x.509";
	public final static String ALGORITHM_ECDSA_SHA256			= "SHA256withECDSA";
	public final static String PUBLIC_KEY_HEADER				= "-----BEGIN PUBLIC KEY-----";
	public final static String PUBLIC_KEY_FOOTER				= "-----END PUBLIC KEY-----";
	public final static String PRIVATE_KEY_HEADER				= "-----BEGIN EC PRIVATE KEY-----";
	public final static String PRIVATE_KEY_FOOTER				= "-----END EC PRIVATE KEY-----";
	public final static String PRIVATE_KEY_PARAMS_HEADER		= "-----BEGIN EC PARAMETERS-----";
	public final static String PRIVATE_KEY_PARAMS_FOOTER		= "-----END EC PARAMETERS-----";
	public final static String NEW_LINE 						= "\n";
	
	/**
	 * Prevent instantiation of this class.
	 */
	private CryptoConstants() {}
}
