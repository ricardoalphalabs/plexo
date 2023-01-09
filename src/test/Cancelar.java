package test;

import java.math.BigDecimal;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.CancelRequest;
import uy.com.plexo.models.ReferenceType;

public class Cancelar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		CancelRequest crequest = new CancelRequest();
		crequest.setType(ReferenceType.PlexoTransactionId);
		//crequest.setType(ReferenceType.ClientPurchaseReferenceId);
		crequest.setClientReferenceId(String.valueOf(System.currentTimeMillis()));
		crequest.setMetaReference("XXXXX");
		

		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.cancel(crequest);

	}

	
}
