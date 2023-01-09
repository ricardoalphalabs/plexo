package test;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.AuthorizationType;
import uy.com.plexo.models.DeleteInstrumentRequest;

public class InstrumentDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DeleteInstrumentRequest deleteRequest = new DeleteInstrumentRequest();
		deleteRequest.setInstrumentToken("XXXXXX");
		deleteRequest.setMetaReference("fvidal@plexo.com.uy");
		deleteRequest.setType(AuthorizationType.ClientReference);
		
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.instrumentsDelete(deleteRequest);

	}


}
