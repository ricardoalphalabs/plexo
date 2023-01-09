package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
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
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.AuthorizationInfo;
import uy.com.plexo.models.AuthorizationType;
import uy.com.plexo.models.ClientRequest;
import uy.com.plexo.models.FinancialInclusion;
import uy.com.plexo.models.InclusionType;
import uy.com.plexo.models.Item;
import uy.com.plexo.models.PaymentInstrumentInput;
import uy.com.plexo.models.PaymentRequest;
import uy.com.plexo.models.ServerResponse;
import uy.com.plexo.models.SignedObjectGeneric;
import uy.com.plexo.models.SignedServerResponseGeneric;
import uy.com.plexo.models.StateObjectGeneric;

public class Issuers {

	private static ObjectMapper mapper = new SignatureHelper().getMapper();
	
	//Ver Medios de pago soportados
	public static void main(String[] args) {
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.getIssuers();

	}


}
