package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import uy.com.plexo.models.ClientRequest;
import uy.com.plexo.models.SignedObject;
import uy.com.plexo.models.SignedObjectGeneric;
import uy.com.plexo.models.StateObject;
import uy.com.plexo.models.StateObjectGeneric;


public class SignatureHelper {
	
	PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");

	private String _password="4pNHgWKKX0Hzc8wTXRKc";  //
	private String _clientName = "Alphalabs";
	private String _pfxFile = "Alphalabs.pfx";
	private String _url = "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc"; //test
	//private String _url = "https://pagos.plexo.com.uy:4043/SecurePaymentGateway.svc"; //prod
	private String alias = "keycontainer";
	private String fingerprint = "";
	
	
	private char[] JKS_PASSWORD = "m1p4zzW0rd!".toCharArray();  //password de Keystore de Java 
	private char[] KEY_PASSWORD = "testtest".toCharArray(); //privateKeypassword
	
	
	private boolean mute = true;
	private boolean disableSSL = false;
	private ObjectMapper mapper = null;
	
	private String publicKey = null;
	public SignatureHelper() {
		getMapper();
	}
	
	public SignatureHelper(String clientName, String certFileName, String certPassword, String URL) {
		_clientName = clientName;
		_pfxFile = certFileName;
		_password = certPassword;
		_url = URL;
		getMapper();
	}
	
	public String getClientName(){
		return _clientName;
	};
	
	public String getURL(){
		return _url;
	};
	
	public URLConnection getURLConnection(String additional){
		URL url = null;
		URLConnection connection = null;
		try {
			url = new URL(getURL()+additional);
			//if (_url.startsWith("https"))
			if (disableSSL){
				disableSslVerification();
			}
				connection =url.openConnection();
				connection.setConnectTimeout(150000);
				connection.setReadTimeout(150000);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		return connection;
		
	}
	
	//public JsonNode sign(SignedObjectGeneric<ClientRequest> signed,StateObjectGeneric<ClientRequest> stateObj) throws InvalidKeyException, Exception{
	public JsonNode sign(SignedObjectGeneric signed,StateObjectGeneric stateObj) throws InvalidKeyException, Exception{
	
		long start = System.currentTimeMillis();
		getMapper();
		//InputStream fin =   Authorize.class.getClassLoader().getResourceAsStream(_pfxFile);
		InputStream fin = getClass().getResourceAsStream("/"+_pfxFile); 

		
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(fin, _password.toCharArray());
        
        //Opcion para Java Keystore
		/*KeyStore ks = KeyStore.getInstance("JKS");
    	InputStream readStream = new FileInputStream("C:\\Users\\fvidal\\.keystore");
    	ks.load(readStream, JKS_PASSWORD);*/
        
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, _password.toCharArray());
        Certificate cert = ks.getCertificate(alias);

        byte[] certBytes=cert.getEncoded();
        byte[] sha1=MessageDigest.getInstance("SHA1").digest(certBytes);
        byte[] signature = null;
        
        StringBuffer result = new StringBuffer();
        for (    byte b : sha1) {
            result.append(String.format("%02X", b));
        }
        if (!mute)
        System.out.println("\nFingerprint: " +result.toString());
        stateObj.setFingerprint(result.toString());
        signed.setObject(stateObj);
        
        String so = mapper.writeValueAsString(stateObj);
        JsonNode jobj = mapper.readTree(so);
        

        Signature dsa = Signature.getInstance("SHA512withRSA");
        dsa.initSign(privateKey);
        //Se canonicaliza el objeto JSON antes de firmarlo!!!
        String data = canonicalizeNode(jobj);
        if (!mute)
        	System.out.println("Data to sign: " + data);
        dsa.update(data.getBytes("UTF-8"));
        byte[]b = data.getBytes("UTF-8");
        signature = dsa.sign();
        String encoded = Base64.getEncoder().encodeToString(signature);
        //System.out.println("Encoded: " + encoded);
        signed.setSignature(encoded);
        
        so = mapper.writeValueAsString(signed);
        long sec = (System.currentTimeMillis()-start)/1000;
        //System.out.println("Tiempo SIGN: " +sec+ "segundos");
        return mapper.readTree(so);
	}
	
	public JsonNode sign(SignedObject signed,StateObject stateObj) throws InvalidKeyException, Exception{
		getMapper();
		InputStream fin =   Authorize.class.getClassLoader().getResourceAsStream(_pfxFile);
		
		/*StringWriter writer = new StringWriter();
		IOUtils.copy(fin, writer);
		String theString = writer.toString();*/
		
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(fin, _password.toCharArray());
        
        //Opcion para Java Keystore
		/*KeyStore ks = KeyStore.getInstance("JKS");
    	InputStream readStream = new FileInputStream("C:\\Users\\fvidal\\.keystore");
    	ks.load(readStream, JKS_PASSWORD);*/
        
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, _password.toCharArray());
        Certificate cert = ks.getCertificate(alias);
    	
        byte[] certBytes=cert.getEncoded();
        byte[] sha1=MessageDigest.getInstance("SHA1").digest(certBytes);
        byte[] signature = null;
        
        StringBuffer result = new StringBuffer();
        for (    byte b : sha1) {
            result.append(String.format("%02X", b));
        }
        if (!mute)
        System.out.println("\nFingerprint: " +result.toString());
        stateObj.setFingerprint(result.toString());
        signed.setObject(stateObj);
        
        String so = mapper.writeValueAsString(stateObj);
        JsonNode jobj = mapper.readTree(so);
        

        Signature dsa = Signature.getInstance("SHA512withRSA");
        dsa.initSign(privateKey);
        //Se canonicaliza el objeto JSON antes de firmarlo!!!
        String data = canonicalizeNode(jobj);
        //System.out.println("Data to sign: " + data);
        dsa.update(data.getBytes("UTF-8"));
        signature = dsa.sign();
        String encoded = Base64.getEncoder().encodeToString(signature);
        signed.setSignature(encoded);
        
        so = mapper.writeValueAsString(signed);
        return mapper.readTree(so);
	}
	
	public String canonicalizeNode(final JsonNode node) throws JsonProcessingException {
        Object obj = mapper.treeToValue(node, Object.class);
 	    String json = mapper.writeValueAsString(obj);
	    return json;
	}
	
	
	
		//se obtiene clave publica del Servidor de Plexo para validar las firmas de las respuesta.
		//la idea es llamar a este metodo una sola vez y guardar el valor y llamar para validar cada respuesta
		public String getServerPublicKey(String fingerprint) throws Exception{
			if (publicKey == null){
				
				URL url = new URL(_url+"/Key/"+fingerprint);
				URLConnection connection = url.openConnection();
	
				connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(50000);
				connection.setReadTimeout(50000);
	
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String result = in.readLine(); 
				
				JsonNode jobj = mapper.readTree(result);
				String objStr = jobj.toString();
				JsonNode node2 = mapper.readValue(objStr, JsonNode.class);
	
			    JsonNode objectNode = node2.get("Object");
			    objectNode = objectNode.get("Object");
			    //String resultCode = objectNode.get("ResultCode").asText();
			    
			    JsonNode keyNode = objectNode.get("Response").get("Key");
			    
				publicKey = keyNode.asText();
			}
			return publicKey;
		}
		
		public void refreshPublicKey(String fingerprint) throws Exception{
			publicKey = null;
			getServerPublicKey(fingerprint);
		}		
		
		// valida la firma de una respuesta, pasando el contenido que firma el servidor, con la clave public y la firma generada.
		public boolean validateServerResponse(String serverResponse, String serverKey, String signature) throws Exception{
	        byte[] encodedPublicKey = Base64.getDecoder().decode(serverKey.getBytes("UTF-8"));
	        
	        CertificateFactory fact = CertificateFactory.getInstance("X.509");
	        ByteArrayInputStream is = new ByteArrayInputStream(encodedPublicKey);
	        X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
	        PublicKey publicKey = cer.getPublicKey();
	        /*PublicKey publicKey = getServerPublicKey(getFingerprint());
	        byte[] publicBytes = Base64.decodeBase64(publicK);
	        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PublicKey pubKey = keyFactory.generatePublic(keySpec);*/

			Signature dsa = Signature.getInstance("SHA512withRSA");
	        dsa.initVerify(publicKey);
	        dsa.update(serverResponse.getBytes("UTF-8"));
	        final byte[] bytes = Base64.getDecoder().decode(signature);
	        return dsa.verify(bytes);
		}
		
		private String getFingerprint(){
			if (fingerprint == null){
				try{
					InputStream fin =   Authorize.class.getClassLoader().getResourceAsStream(_pfxFile);
			        KeyStore ks = KeyStore.getInstance("PKCS12");
			        ks.load(fin, _password.toCharArray());
			        
			        //Opcion para Java Keystore
					/*KeyStore ks = KeyStore.getInstance("JKS");
			    	InputStream readStream = new FileInputStream("C:\\Users\\fvidal\\.keystore");
			    	ks.load(readStream, JKS_PASSWORD);*/
			    	
			        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, _password.toCharArray());
			        Certificate cert = ks.getCertificate(alias);
					byte[] certBytes=cert.getEncoded();
			        byte[] sha1=MessageDigest.getInstance("SHA1").digest(certBytes);
			        byte[] signature = null;
			        
					StringBuffer result = new StringBuffer();
			        for (    byte b : sha1) {
			            result.append(String.format("%02X", b));
			        }
			        if (!mute)
			        System.out.println("\nFingerprint: " +result.toString());
			        fingerprint = result.toString();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			return fingerprint;
			
		}
		
		/*public boolean validateServerResponse(String serverResponse, String fingerprint, String signature) throws Exception{
			getServerPublicKey(fingerprint);
	        byte[] encodedPublicKey = Base64.getDecoder().decode(publicKey.getBytes("UTF-8"));
	        
	        CertificateFactory fact = CertificateFactory.getInstance("X.509");
	        ByteArrayInputStream is = new ByteArrayInputStream(encodedPublicKey);
	        X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
	        PublicKey publicKey = cer.getPublicKey();

			Signature dsa = Signature.getInstance("SHA512withRSA");
	        dsa.initVerify(publicKey);
	        dsa.update(serverResponse.getBytes("UTF-8"));
	        final byte[] bytes = Base64.getDecoder().decode(signature);
	        return dsa.verify(bytes);
		}*/
	
	//se inicializa el Mapper con valores para una correcta canonicalicacion del JSON
	public ObjectMapper getMapper(){
		if (mapper == null){
			mapper = new ObjectMapper();
	        mapper.setPropertyNamingStrategy(
	        	    PropertyNamingStrategy.UPPER_CAMEL_CASE);
	        mapper.setSerializationInclusion(Include.NON_NULL);
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		}
		return mapper;
	}
	

	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}

}