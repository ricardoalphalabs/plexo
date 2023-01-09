package test;


import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.Reference;
import uy.com.plexo.models.ReferenceType;

public class Query {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Reference reference = new Reference();
        reference.setType(ReferenceType.PlexoTransactionId);
        reference.setMetaReference("XXXXX"); //transactionID

		//process(reference);
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.query(reference);

		
	}


	
	
}
