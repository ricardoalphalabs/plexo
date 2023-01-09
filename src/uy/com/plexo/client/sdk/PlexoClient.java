package uy.com.plexo.client.sdk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.util.Calendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.SignatureHelper;
import uy.com.plexo.models.Authorization;
import uy.com.plexo.models.AuthorizationInfo;
import uy.com.plexo.models.BlacklistRequest;
import uy.com.plexo.models.CancelRequest;
import uy.com.plexo.models.CheckRequest;
import uy.com.plexo.models.ClientRequest;
import uy.com.plexo.models.ClientRequestSimple;
import uy.com.plexo.models.CodeRequest;
import uy.com.plexo.models.CommerceIdRequest;
import uy.com.plexo.models.CommerceIssuerIdRequest;
import uy.com.plexo.models.CommerceRequest;
import uy.com.plexo.models.CreateBankInstrumentRequest;
import uy.com.plexo.models.DeleteInstrumentRequest;
import uy.com.plexo.models.IssuerData;
import uy.com.plexo.models.IssuerRequest;
import uy.com.plexo.models.PaymentRequest;
import uy.com.plexo.models.Reference;
import uy.com.plexo.models.RefundRequest;
import uy.com.plexo.models.Reserve;
import uy.com.plexo.models.ReserveRequest;
import uy.com.plexo.models.ServerResponse;
import uy.com.plexo.models.SignedObject;
import uy.com.plexo.models.SignedObjectGeneric;
import uy.com.plexo.models.SignedServerResponseGeneric;
import uy.com.plexo.models.StateObjectGeneric;
import uy.com.plexo.models.TransactionQuery;

public class PlexoClient {
	
	private SignatureHelper signatureHelper = null;
	private ObjectMapper mapper = null;
	private int readTimeuout = 500000;
	private int connectionTimeout = 500000;
	private boolean mute = false;
	private String responseInfo = "";

	public PlexoClient(String clientName, String certFileName, String certPassword, String URL) {
		signatureHelper = new SignatureHelper(clientName, certFileName, certPassword, URL);
		mapper = signatureHelper.getMapper();
	}
	
	public void authorize (Authorization authorization){
		
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<Authorization> crequest = wrapClient(authorization);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        //System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Auth");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	    	


	}
		
	public void transactionQuery (TransactionQuery query){
		
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<TransactionQuery> crequest = wrapClient(query);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Transactions");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	    	


	}
	
	public void transactionQueryCSV (TransactionQuery query){
		
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<TransactionQuery> crequest = wrapClient(query);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Transactions/CSV");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	    	


	}
		
		
		
		
		private void authorize(JsonNode jsonObject){
			try {
				URLConnection connection = getURLConnection("/Auth");
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				String envio = jsonObject.toString();
				long start = System.currentTimeMillis();
				System.out.println("Envio: " +envio);
				out.write(envio);
				out.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String result = in.readLine(); 

				
				System.out.println("Respuesta: " +result);
				System.out.println("Tiempo Respuesta: " +(System.currentTimeMillis()-start/1000) + "segundos");

	          
	            //agarrar la respuesta y canonizarla.
				JsonNode jobj = mapper.readTree(result);
				SignedServerResponseGeneric<ServerResponse> response = mapper.readValue(jobj.toString(), SignedServerResponseGeneric.class);
				String fingerprint = response.getObject().getFingerprint();
				
				JsonNode objectNode1 = jobj.get("Object"); ///Obtengo el Objeto firmado
				String serverResponse = signatureHelper.canonicalizeNode(objectNode1); // Lo canonicalizo, porque viene desordenado del servidor.
				if (!mute)
				System.out.println("Respuesta converted: "+serverResponse);

				JsonNode signatureNode1 = jobj.get("Signature");
				String resultCode = objectNode1.get("Object").get("ResultCode").asText(); //validar con los ResultCodes
				String errorMessage = "";
				JsonNode errMsg = objectNode1.get("Object").get("ErrorMessage");
				if (errMsg !=null)
					errorMessage = errMsg.asText(); //validar con los ResultCodes
				if (!mute)
				System.out.println("RESULTCODE:"+resultCode + " - " +errorMessage);    


				//String serverKey = signatureHelper.getServerPublicKey(fingerprint);
				            
				//boolean isValid = signatureHelper.validateServerResponse(serverResponse, serverKey, signatureNode1.textValue());
				boolean isValid = signatureHelper.validateServerResponse(serverResponse, fingerprint, signatureNode1.textValue());

				
				in.close();
				
				System.out.println("Es valida la respuesta? : " +isValid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
	
	private <T> ClientRequest<T> wrapClient(T request)
    {
		ClientRequest<T> cr = new ClientRequest<>();
		cr.setClient(signatureHelper.getClientName());
		cr.setRequest(request);
        return cr;
    }
	
	
	private URLConnection getURLConnection(String path){
		URLConnection connection =signatureHelper.getURLConnection(path);
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setConnectTimeout(connectionTimeout);
		connection.setReadTimeout(readTimeuout);
		return connection;
	}
	
	
	
	public void pay(PaymentRequest prequest)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<PaymentRequest> crequest = wrapClient(prequest);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		//stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		long verga = 4697273396000L;
		stateObj.setUTCUnixTimeExpiration(verga);

        try {
    		
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//purchase(jobj);
        	process(jobj, "/Operation/Purchase");
    		
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
  
    }
	
	public String payWithResponse(PaymentRequest prequest)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<PaymentRequest> crequest = wrapClient(prequest);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		//stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		long verga = 4697273396000L;
		stateObj.setUTCUnixTimeExpiration(verga);

        try {
    		
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	//System.out.println(mapper.writeValueAsString(signed));
        	//purchase(jobj);
        	return process(jobj, "/Operation/Purchase");
    		
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "";
        
  
    }
	
	public void query(Reference request){
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<Reference> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

        try {
            
        	//JsonNode jobj = new SignatureHelper().sign(signed, stateObj);
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//query(jobj);
        	process(jobj, "/Operation/Status");
           
    		
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void vbvCheck(CheckRequest request){
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<CheckRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

        try {
            
        	//JsonNode jobj = new SignatureHelper().sign(signed, stateObj);
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//query(jobj);
        	process(jobj, "/VerifiedByVisa/Check");
           
    		
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void cancel(CancelRequest request)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<CancelRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
            
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//cancel(jobj);
        	process(jobj, "/Operation/Cancel");
           
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
       

    }
	
	public String cancelWithResponse(CancelRequest request)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<CancelRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
            
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//cancel(jobj);
        	return process(jobj, "/Operation/Cancel");
           
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "";

    }
	
	public void refund(RefundRequest request)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<RefundRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
            
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//cancel(jobj);
        	process(jobj, "/Operation/Refund");
           
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
       

    }
	
	public void instruments(AuthorizationInfo authInfo)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<AuthorizationInfo> crequest = wrapClient(authInfo);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
    		
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	process(jobj, "/Instruments");
    		
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
  
    }
	
	
	public void instrumentsDelete(DeleteInstrumentRequest deleteRequest)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<DeleteInstrumentRequest> crequest = wrapClient(deleteRequest);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
    		
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	process(jobj, "/Instruments/Delete");
    		
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
  
    }
	
	public void instrumentsBank(CreateBankInstrumentRequest bankRequest)
    {
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<CreateBankInstrumentRequest> crequest = wrapClient(bankRequest);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
        try {
    		
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	process(jobj, "/Instruments/Bank");
    		
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
  
    }
		
	private void purchase(JsonNode jsonObject){
		try {
			URLConnection connection = getURLConnection("/Operation/Purchase");
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			String envio = jsonObject.toString();
			long start = System.currentTimeMillis();
			System.out.println("Envio: " +envio);
			out.write(envio);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = in.readLine(); 

			
			System.out.println("Respuesta: " +result);
			System.out.println("Tiempo Respuesta: " +(System.currentTimeMillis()-start/1000) + "segundos");
            //agarrar la respuesta y canonizarla.
			JsonNode jobj = mapper.readTree(result);
			SignedServerResponseGeneric<ServerResponse> response = mapper.readValue(jobj.toString(), SignedServerResponseGeneric.class);
			String fingerprint = response.getObject().getFingerprint();
			
			JsonNode objectNode1 = jobj.get("Object"); ///Obtengo el Objeto firmado
			String serverResponse = signatureHelper.canonicalizeNode(objectNode1); // Lo canonicalizo, porque viene desordenado del servidor.
			if (!mute)
				System.out.println("Respuesta converted: "+serverResponse);

			JsonNode signatureNode1 = jobj.get("Signature");
			String resultCode = objectNode1.get("Object").get("ResultCode").asText(); //validar con los ResultCodes
			String errorMessage = "";
			JsonNode errMsg = objectNode1.get("Object").get("ErrorMessage");
			if (errMsg !=null)
				errorMessage = errMsg.asText(); //validar con los ResultCodes
			System.out.println("RESULTCODE:"+resultCode + " - " +errorMessage);     
			
			/*String serverKey = new SignatureHelper().getServerPublicKey(fingerprint);
			            
			boolean isValid = new SignatureHelper().validateServerResponse(serverResponse, serverKey, signatureNode1.textValue());*/
			boolean isValid = signatureHelper.validateServerResponse(serverResponse, fingerprint, signatureNode1.textValue());

			
			in.close();
			
			System.out.println("Es valida la respuesta firmada? : " +isValid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private String process(JsonNode jsonObject, String operation){
		try {
			long start = System.currentTimeMillis();
			URLConnection connection = getURLConnection(operation);
			long sec = (System.currentTimeMillis()-start);
	        System.out.println("Tiempo CONN: " + sec);
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			String envio = jsonObject.toString();
			//System.out.println("Tiempo BEFORE WRITE: " + (System.currentTimeMillis()-start));

			if (!mute)
				System.out.println("Operation: " + operation + " - Envio: " +envio);
			out.write(envio);
			out.close();
			//System.out.println("Tiempo AFTER WRITE: " + (System.currentTimeMillis()-start));

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//System.out.println("Tiempo AFTER BufferedReader: " + (System.currentTimeMillis()-start));
			String result = in.readLine(); 
			System.out.println("Tiempo AFTER READLINE: " + (System.currentTimeMillis()-start));
			in.close();
			if (!mute){
				System.out.println("Respuesta: " +result);
				System.out.println("Tiempo Respuesta: " +((System.currentTimeMillis()-start)/1000) + "segundos");
			}
            //agarrar la respuesta y canonizarla.
			JsonNode jobj = mapper.readTree(result);
			SignedServerResponseGeneric<ServerResponse> response = mapper.readValue(jobj.toString(), SignedServerResponseGeneric.class);
			String fingerprint = response.getObject().getFingerprint();
			JsonNode objectNode1 = jobj.get("Object"); ///Obtengo el Objeto firmado
			String serverResponse = signatureHelper.canonicalizeNode(objectNode1); // Lo canonicalizo, porque viene desordenado del servidor.
			if (!mute)
				System.out.println("Respuesta converted: "+serverResponse);

			JsonNode signatureNode1 = jobj.get("Signature");
			String resultCode = objectNode1.get("Object").get("ResultCode").asText(); //validar con los ResultCodes
			JsonNode responseObj = objectNode1.get("Object").get("Response");
			JsonNode trnId = objectNode1.get("Object").get("Response").get("TransactionId");
			String transId = "";
			if (trnId != null){
				transId = trnId.asText();	
			}
			
			JsonNode transactions =responseObj.get("Transactions");
			String purchaseStatus = "96";
			String purchaseResultCode = "96";
			String purchaseResultTText = "ERROR";
			if (operation.equalsIgnoreCase("/Operation/Purchase")){
				try{
			 purchaseStatus =transactions.get("Purchase").get("Status").asText();
			 purchaseResultCode =transactions.get("Purchase").get("TransactionCode").asText();
			 purchaseResultTText =transactions.get("Purchase").get("TransactionResultText").asText();
				}catch(Exception e){
					System.out.println("Error evaluando respuesta!");
				}
			//responseInfo = objectNode1.get("Object").get("Response").toString();
			 
			 
			}
			else if (operation.equalsIgnoreCase("/Operation/Cancel")){
				purchaseStatus =transactions.get("Cancel").get("Status").asText();
				 purchaseResultCode =transactions.get("Cancel").get("TransactionCode").asText();
				 purchaseResultTText =transactions.get("Cancel").get("TransactionResultText").asText();
			}
			responseInfo = responseObj.toString();
			String errorMessage = "";
			JsonNode errMsg = objectNode1.get("Object").get("ErrorMessage");
			if (errMsg !=null)
				errorMessage = errMsg.asText(); //validar con los ResultCodes
			
			if (!mute)
				System.out.println("RESULTCODE:"+resultCode + " - " +errorMessage);     
			sec = (System.currentTimeMillis()-start)/1000;
	        //System.out.println("Tiempo PROCESS: " +sec+ "segundos");

			//saco validacion a ver si mejora tiempo

			//String serverKey = signatureHelper.getServerPublicKey(fingerprint);
			//boolean isValid = signatureHelper.validateServerResponse(serverResponse, serverKey, signatureNode1.textValue());
			
			
			//in.close();
			
			//if (!mute)
			//	System.out.println("Es valida la respuesta firmada? : " +isValid);
			//return serverResponse;
			return transId+","+purchaseStatus+","+purchaseResultCode+","+purchaseResultTText;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
	public String getCommerces(){
		
		try {
			SignedObject signed = new SignedObject();
			JsonNode jsonObject = null;
			ClientRequestSimple crequest = new ClientRequestSimple();
			crequest.setClient(signatureHelper.getClientName());
			StateObjectGeneric<ClientRequestSimple> stateObj = new StateObjectGeneric<>();

			stateObj.setObject(crequest);
			stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
			try {
				//jsonObject = new SignatureHelper().sign(signed, stateObj);
				jsonObject = signatureHelper.sign(signed, stateObj);
				System.out.println(mapper.writeValueAsString(signed));
				return process(jsonObject, "/Commerce");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";
		
	}
	
public String getIssuers(){
		
		try {
			SignedObject signed = new SignedObject();
			JsonNode jsonObject = null;
			ClientRequestSimple crequest = new ClientRequestSimple();
			crequest.setClient(signatureHelper.getClientName());
			StateObjectGeneric<ClientRequestSimple> stateObj = new StateObjectGeneric<>();

			stateObj.setObject(crequest);
			stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
			try {
				jsonObject = signatureHelper.sign(signed, stateObj);
				System.out.println(mapper.writeValueAsString(signed));
				return process(jsonObject, "/Issuer");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";
		
	}
	
	public String  startCommerceIdRequest(CommerceIdRequest prequest, String type){
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<CommerceIdRequest> crequest = wrapClient(prequest);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj =  signatureHelper.sign(signedGen, stateObjGen);
			//System.out.println(mapper.writeValueAsString(signedGen));
			return process(jobj,"/Commerce/"+type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
	public void addCommerceIssuer(IssuerData request)
    {
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<IssuerData> crequest = wrapClient(request);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj =  signatureHelper.sign(signedGen, stateObjGen);
			System.out.println(mapper.writeValueAsString(signedGen));
			process(jobj,"/Commerce/Issuer/Add");
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
	public void deleteCommerceIssuer(CommerceIssuerIdRequest request)
    {
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<CommerceIssuerIdRequest> crequest = wrapClient(request);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj =  signatureHelper.sign(signedGen, stateObjGen);
			System.out.println(mapper.writeValueAsString(signedGen));
			process(jobj,"/Commerce/Issuer/Delete");
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
	public void addCommerce(CommerceRequest request)
    {
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<CommerceRequest> crequest = wrapClient(request);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj = signatureHelper.sign(signedGen, stateObjGen);
			System.out.println(mapper.writeValueAsString(signedGen));
			process(jobj,"/Commerce/Add");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
	public void getTaxiCode(CommerceRequest request)
    {
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<CommerceRequest> crequest = wrapClient(request);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj = signatureHelper.sign(signedGen, stateObjGen);
			System.out.println(mapper.writeValueAsString(signedGen));
			process(jobj,"/Commerce/GetProvidedCodeCommerce");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
	public void deleteCommerce(CommerceIdRequest prequest)
    {
		SignedObjectGeneric<ClientRequest> signedGen = new SignedObjectGeneric<>();
		StateObjectGeneric<ClientRequest> stateObjGen = new StateObjectGeneric<>();
		JsonNode jobj = null;
		ClientRequest<CommerceIdRequest> crequest = wrapClient(prequest);
		stateObjGen.setObject(crequest);
		stateObjGen.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
		try {
			jobj = signatureHelper.sign(signedGen, stateObjGen);
			System.out.println(mapper.writeValueAsString(signedGen));
			process(jobj,"/Commerce/Delete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	public String getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}
	
	
	public void overTheCounter(IssuerRequest<CodeRequest> crequest){
		
		SignedObjectGeneric<IssuerRequest> signed = new SignedObjectGeneric<>();
		StateObjectGeneric<IssuerRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        //System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Code");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	        
	    	


	}
	
	public void startReserve (ReserveRequest request){
		
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<ReserveRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        //System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Operation/StartReserve");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	    	


	}
	
	public void endReserve (Reserve request){
		
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<Reserve> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

	        
	    try {
	      	JsonNode jobj = signatureHelper.sign(signed, stateObj);
	        //System.out.println(mapper.writeValueAsString(signed));
	        //authorize(jobj);
	        process (jobj,"/Operation/EndReserve");
	    		
	    } catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	    	


	}
	
	public void blacklist(BlacklistRequest request, String type){
		SignedObjectGeneric<ClientRequest> signed = new SignedObjectGeneric<>();
		ClientRequest<BlacklistRequest> crequest = wrapClient(request);
		StateObjectGeneric<ClientRequest> stateObj = new StateObjectGeneric<>();
		stateObj.setObject(crequest);
		stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());

        try {
            
        	//JsonNode jobj = new SignatureHelper().sign(signed, stateObj);
        	JsonNode jobj = signatureHelper.sign(signed, stateObj);
        	System.out.println(mapper.writeValueAsString(signed));
        	//query(jobj);
        	process(jobj, "/Blacklist/"+ type);
           
    		
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBlacklist(){
		
		try {
			SignedObject signed = new SignedObject();
			JsonNode jsonObject = null;
			ClientRequestSimple crequest = new ClientRequestSimple();
			crequest.setClient(signatureHelper.getClientName());
			StateObjectGeneric<ClientRequestSimple> stateObj = new StateObjectGeneric<>();

			stateObj.setObject(crequest);
			stateObj.setUTCUnixTimeExpiration(Calendar.getInstance().getTimeInMillis());
			try {
				//jsonObject = new SignatureHelper().sign(signed, stateObj);
				jsonObject = signatureHelper.sign(signed, stateObj);
				System.out.println(mapper.writeValueAsString(signed));
				return process(jsonObject, "/Blacklist");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";
		
	}
	

}
