package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.CancelRequest;
import uy.com.plexo.models.FieldType;
import uy.com.plexo.models.FinancialInclusion;
import uy.com.plexo.models.InclusionType;
import uy.com.plexo.models.ReferenceType;
import uy.com.plexo.models.RefundRequest;

public class Refund {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigDecimal bd = new BigDecimal(1);
	    bd = bd.setScale(2);  //// IMPORTANTE MANDAR SIEMPRE ASI para distinguir de enteros!
	
		RefundRequest crequest = new RefundRequest();
		crequest.setType(ReferenceType.PlexoTransactionId);
		//crequest.setType(ReferenceType.ClientPurchaseReferenceId);
		crequest.setClientReferenceId("20192002");
		crequest.setMetaReference("XXXXXX");//transactionId
		//crequest.setOptionalClientId(21);
		crequest.setAmount(bd);
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.refund(crequest);

	}

	
}
