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
import uy.com.plexo.models.ReferenceType;
import uy.com.plexo.models.ReserveRequest;
import uy.com.plexo.models.SignedObjectGeneric;

public class EndReserve {

	public static void main(String[] args) {
		

        uy.com.plexo.models.Reserve prequest = new uy.com.plexo.models.Reserve();
        prequest.setCommit(true);
		prequest.setType(ReferenceType.PlexoTransactionId);
		prequest.setMetaReference("XXXX");
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		

		client.endReserve(prequest);
	
	}
}

