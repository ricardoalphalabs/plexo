package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.ActionType;
import uy.com.plexo.models.Authorization;
import uy.com.plexo.models.AuthorizationType;
import uy.com.plexo.models.CodeAction;
import uy.com.plexo.models.CodeRequest;
import uy.com.plexo.models.FieldType;
import uy.com.plexo.models.FinancialInclusion;
import uy.com.plexo.models.InclusionType;
import uy.com.plexo.models.IssuerRequest;
import uy.com.plexo.models.Item;
import uy.com.plexo.models.PaymentInstrumentInput;
import uy.com.plexo.models.PaymentRequest;
import uy.com.plexo.models.ReserveRequest;
import uy.com.plexo.models.SignedObjectGeneric;

public class Reserve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mnt1 = "1";  //Amount - Item
		//String mnt2 = "10";  //Taxed
		//String mnt3 = "10";  //Tip
		
		BigDecimal bd = new BigDecimal(mnt1);
        bd = bd.setScale(2);  //// IMPORTANTE MANDAR SIEMPRE ASI!
        
        double taxedAmnd = bd.doubleValue()/1.22;
        BigDecimal bd2 = new BigDecimal(String.valueOf(taxedAmnd));
        bd2 = bd2.setScale(2,BigDecimal.ROUND_HALF_UP);  //// IMPORTANTE MANDAR SIEMPRE ASI!
        
        BigDecimal bd3 = new BigDecimal(mnt1);
        bd3 = bd3.setScale(2);  //
        
       // BigDecimal bd4 = new BigDecimal(mnt3);
        //bd4 = bd4.setScale(2);//

        ReserveRequest prequest = new ReserveRequest();
        prequest.setExpirationUTC(System.currentTimeMillis()+1800000);//30 minutos
		prequest.setClientReferenceId(String.valueOf(System.currentTimeMillis()));
		prequest.setCurrencyId(1);//1 peso, 2 dolar
		FinancialInclusion fc = new FinancialInclusion();
		fc.setBilledAmount(bd);
		fc.setInvoiceNumber(123472);
		fc.setTaxedAmount(bd2);
		fc.setType(InclusionType.Law19210);
		prequest.setFinancialInclusion(fc);
		prequest.setInstallments(1);
		List<Item> items = new LinkedList<>();
		Item item = new Item();
		item.setAmount(bd);
		item.setClientItemReferenceId("fvidal");
		items.add(item);
		prequest.setItems(items);
		PaymentInstrumentInput paymentInstrumentInput = new PaymentInstrumentInput();
		Map<FieldType, String> nonStorableItems = new HashMap<>();
		//paymentInstrumentInput.setInstrumentToken("XXXXX");//INSERT TOKEN
		//nonStorableItems.put(FieldType.CVC, "005");//959
		//paymentInstrumentInput.setNonStorableItems(nonStorableItems);  //descomentar para agregar CVC
		
		//Cybersource y otros, fields opcionales.
	    //Map<FieldType, String> optionalFields = new HashMap<>();
		//optionalFields.put(FieldType.CybersourceDeviceFingerprint, "prueba24");
		
		prequest.setPaymentInstrumentInput(paymentInstrumentInput);
		prequest.setOptionalCommerceId(XX); //Insert commerce ID
		
		//process(prequest);
		//process(auth);
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
				
		client.startReserve(prequest);
	
	}
}

