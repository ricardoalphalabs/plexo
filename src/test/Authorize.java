package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.ActionType;
import uy.com.plexo.models.Authorization;
import uy.com.plexo.models.AuthorizationType;
import uy.com.plexo.models.FieldType;

public class Authorize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Authorization auth = new Authorization();
		auth.setRedirectUri("http://MiURL/PlexoRest/plexo/redirect"); //URL de Redirect a donde hace GET la Web de Plexo al recibir respuesta del callback
		//auth.setRedirectUri("https://laisla.com.uy/checkout/plexo/retorno");
		auth.setType(AuthorizationType.ClientReference);
		//auth.setType(AuthorizationType.Anonymous);
		//auth.setAction(ActionType.SelectAndRegisterInstrument);
		//auth.setAction(ActionType.SelectInstrument);
		//auth.setAction(ActionType.RegisterInstrument);
		//auth.setAction(ActionType.DeleteInstrument);
		//auth.setExtendableInstrumentToken("XXXXX");
		//auth.setAction(ActionType.RegisterInstrumentWithTemporaryItems);
		//auth.setAction(ActionType.SelectAndRegisterInstrumentWithTemporaryItems);
		//auth.setAction(ActionType.SelectInstrument);
		//auth.setAction(ActionType.AskForTemporaryItems);
		//auth.setAction(ActionType.SelectItWithTemporaryItems);
		//auth.setAction(ActionType.DeleteAndRegister);
		//auth.setAction(ActionType.SelectDeleteAndRegisterInstrument);
		auth.setAction(ActionType.SelectDeleteAndRegisterInstrumentWithTemporaryItems);
		Map<FieldType, String> clientInfo = new HashMap<>();
		clientInfo.put(FieldType.Address, "Av Italia 2020");
		clientInfo.put(FieldType.Email, "fvidal@plexo.com.uy");
		clientInfo.put(FieldType.Identification, "12345678");
		clientInfo.put(FieldType.IdentificationType, "0");
		clientInfo.put(FieldType.Name, "Francisco Vidal");
		clientInfo.put(FieldType.Cellphone, "094951148");
		
		//auth.setClientInformation(clientInfo);
		ArrayList<String> limitIssuers = new ArrayList<String>();
		//limitIssuers.add("3");
		limitIssuers.add("4");
		limitIssuers.add("18");
		limitIssuers.add("11");
		limitIssuers.add("15");
		limitIssuers.add("13");
		limitIssuers.add("14");
		limitIssuers.add("19");
		limitIssuers.add("24");
		limitIssuers.add("16");
		limitIssuers.add("12");
		//limitIssuers.add("27");//Brou desa
		//limitIssuers.add("29");//Lider desa
		//limitIssuers.add("30");//MidineroPrepaga
		limitIssuers.add("21");//Lider TEST
		auth.setLimitIssuers(limitIssuers);
		auth.setMetaReference("fvidal@plexo.com.uy");   // es el identificador del usuario relacionado con el token
		auth.setDoNotUseCallback(false);
		auth.setOptionalMetadata("bli bli bli");
		
		//process(auth);
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.authorize(auth);

	}
	
	
	
}

