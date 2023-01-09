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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.ClientRequest;
import uy.com.plexo.models.ClientRequestClient;
import uy.com.plexo.models.ClientRequestSimple;
import uy.com.plexo.models.CommerceIdRequest;
import uy.com.plexo.models.CommerceIssuerIdRequest;
import uy.com.plexo.models.CommerceModifyRequest;
import uy.com.plexo.models.CommerceRequest;
import uy.com.plexo.models.FieldType;
import uy.com.plexo.models.FinancialInclusion;
import uy.com.plexo.models.InclusionType;
import uy.com.plexo.models.IssuerData;
import uy.com.plexo.models.Item;
import uy.com.plexo.models.PaymentInstrumentInput;
import uy.com.plexo.models.PaymentRequest;
import uy.com.plexo.models.ServerResponse;
import uy.com.plexo.models.SignedObject;
import uy.com.plexo.models.SignedObjectGeneric;
import uy.com.plexo.models.SignedServerResponseGeneric;
import uy.com.plexo.models.StateObject;
import uy.com.plexo.models.StateObjectGeneric;

public class ABMCommerce {

	private static ObjectMapper mapper = new SignatureHelper().getMapper();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		
		
		CommerceRequest crequest = new CommerceRequest();
		crequest.setName("Comercio");
		client.addCommerce(crequest);
		
		
		//configurar Medios de pago para el comercio
		IssuerData data = new IssuerData();
		data.setCommerceId(new Integer(XX)); //INSERTAR EL ID retornado en paso previo
		data.setIssuerId(new Integer(4)); //MCard
		//data.setIssuerId(new Integer(11)); //VISA
		//data.setIssuerId(new Integer(15)); //OCA
		//data.setIssuerId(new Integer(16)); //Creditel
		//data.setIssuerId(new Integer(17)); //PAsscard
		//data.setIssuerId(new Integer(14)); //CDirectos
		//data.setIssuerId(new Integer(29)); //ANDA
		Map<FieldType, String> metadata = new HashMap<>();
		metadata.put(FieldType.ProviderCommerceNumber, "98001122");//En el caso de FData es el codigo de terminal
		//metadata.put(FieldType.TerminalNumber, "XXXX");//ANDA, PASSCARD, OCA, CABAL
		//metadata.put(FieldType.TerminalNumber, "P1629001,P1629002,P1629003,P1629004");//CDIrectos
		//metadata.put(FieldType.ProviderCommerceNumber, "visanetuy_px_xxxxxxxx716");//VISA
		
		//PAYFAC
		metadata.put(FieldType.PaymentFacilitatorId, ""); //enviar vacio para eliminar
		metadata.put(FieldType.PaymentFacilitatorCommerceId, ""); //enviar vacio para eliminar
		
		//MULTIADQUIRENCIA
		metadata.put(FieldType.PaymentProcessorId, "oca"); //oca - visanet - fiserv //si envia vacio borra la config*/
		data.setMetadata(metadata);
		client.addCommerceIssuer(data);
	}
	
		
}
