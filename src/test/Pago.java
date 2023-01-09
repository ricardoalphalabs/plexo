package test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.ActionType;
import uy.com.plexo.models.Authorization;
import uy.com.plexo.models.AuthorizationType;
import uy.com.plexo.models.FieldType;
import uy.com.plexo.models.FinancialInclusion;
import uy.com.plexo.models.InclusionType;
import uy.com.plexo.models.Item;
import uy.com.plexo.models.PaymentInstrumentInput;
import uy.com.plexo.models.PaymentRequest;

public class Pago {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mnt1 = "1.00";  //Amount - Item
		//String mnt2 = "10";  //Taxed
		String mnt3 = "0";  //Tip
		
		BigDecimal bd = new BigDecimal(mnt1);
        bd = bd.setScale(2);  //// IMPORTANTE MANDAR SIEMPRE ASI!
        
        //double taxedAmnd = bd.doubleValue()/1.22;
        double taxedAmnd = 0.00;
        BigDecimal bd2 = new BigDecimal(String.valueOf(taxedAmnd));
        bd2 = bd2.setScale(2,BigDecimal.ROUND_HALF_UP);  //// IMPORTANTE MANDAR SIEMPRE ASI!
        //System.out.println(bd);
        
        BigDecimal bd3 = new BigDecimal(mnt1);
        bd3 = bd3.setScale(2);  //
        
        BigDecimal bd4 = new BigDecimal(mnt3);
        bd4 = bd4.setScale(2);

		PaymentRequest prequest = new PaymentRequest();
		prequest.setClientReferenceId("micorreo@gmail.com");
		//prequest.setClientReferenceId(String.valueOf(System.currentTimeMillis()));
		prequest.setCurrencyId(1);//1 peso, 2 dolar
		FinancialInclusion fc = new FinancialInclusion();
		fc.setBilledAmount(bd);
		fc.setInvoiceNumber(4445674);
		//fc.setInvoiceNumber(0);
	    //fc.setInvoiceNumberStr("A");
		fc.setTaxedAmount(bd2);
		fc.setType(InclusionType.Law19210); //InclusionType.None - InclusionType.17934
		prequest.setFinancialInclusion(fc);
		prequest.setInstallments(1); //cuotas
		List<Item> items = new LinkedList<>();
		Item item = new Item();
		item.setAmount(bd);
		item.setClientItemReferenceId("Item-1");
		items.add(item);
		//item.setMetaData("Cosas");
		item = new Item();
		item.setAmount(bd2);
		item.setClientItemReferenceId("Item 2");
		items.add(item);
		prequest.setItems(items);
		PaymentInstrumentInput paymentInstrumentInput = new PaymentInstrumentInput();
		
		//CVC
		Map<FieldType, String> nonStorableItems = new HashMap<>();
		nonStorableItems.put(FieldType.CVC, "123");
		
		//Cybersource y otros, fields opcionales.
		Map<FieldType, String> optionalFields = new HashMap<>();
		
		
		paymentInstrumentInput.setInstrumentToken("XXXXX");//INSERT TOKEN

		

		//OPTIONALS and NONSTORABLE
		//optionalFields.put(FieldType.CybersourceDeviceFingerprint, "1415285191585403013679");
		//optionalFields.put(FieldType.Country, "Uruguay"); //no en prod
		//optionalFields.put(FieldType.PromotionalCode, "VISA_17"); //no en prod
		//optionalFields.put(FieldType.TransactionDateTime, "20190727093923012"); //yyyyMMddHHmmssSSS //no en prod
		//optionalFields.put(FieldType.DeferredMonths, "0"); //no en prod 
		//optionalFields.put(FieldType.Plan, "016153570198200"); //se usa en la recurrencia
		//optionalFields.put(FieldType.IdentificationType, "1"); // mando RUT
		//optionalFields.put(FieldType.Identification, "212121210012"); //Nro RUT
		//optionalFields.put(FieldType.RecurringPayment, "true");

		//paymentInstrumentInput.setNonStorableItems(nonStorableItems);  //descomentar para agregar CVC		
		pymentInstrumentInput.setOptionalInstrumentFields(optionalFields);
		
		
		prequest.setPaymentInstrumentInput(paymentInstrumentInput);
		prequest.setOptionalCommerceId(XXX); //ID de Comercio provisto por Plexo
		
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");

		client.pay(prequest);
		
	}
	
	


}
