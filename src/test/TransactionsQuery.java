package test;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import uy.com.plexo.client.sdk.PlexoClient;
import uy.com.plexo.models.ClientRequest;
import uy.com.plexo.models.QueryOperation;
import uy.com.plexo.models.TransactionField;
import uy.com.plexo.models.TransactionOperator;
import uy.com.plexo.models.TransactionQuery;

public class TransactionsQuery {

	private static ObjectMapper mapper = new SignatureHelper().getMapper();
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		
		List<uy.com.plexo.models.Query> queries = new LinkedList<uy.com.plexo.models.Query>();
		uy.com.plexo.models.Query q = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q1 = new uy.com.plexo.models.Query();
		q.setField(TransactionField.CreationDate);//Field
		q.setOperator(TransactionOperator.BiggerOrEqualThan);//Operator
		
		java.text.SimpleDateFormat dateFormatGmt = new java.text.SimpleDateFormat("MM-dd-yyyy HH:mm");
		dateFormatGmt.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
		
		//Local time zone   
		java.text.SimpleDateFormat dateFormatLocal = new java.text.SimpleDateFormat("MM-dd-yyyy HH:mm");
		try {
			q.setValue(dateFormatGmt.format(dateFormatLocal.parse("02-01-2019 00:00")));  //= 2018/01/04
			q1.setValue(dateFormatGmt.format(dateFormatLocal.parse("03-01-2019 00:00")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//q.setValue("2017-08-01");
		q.setQueryOperator(QueryOperation.And); 
		

		q1.setField(TransactionField.CreationDate);//Field
		q1.setOperator(TransactionOperator.SmallerThan);
		//q1.setValue("02-28-2019 20:59");  
		q1.setQueryOperator(QueryOperation.And); 
		
		uy.com.plexo.models.Query q2 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q3 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q4 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q5 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q6 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q7 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q8 = new uy.com.plexo.models.Query();
		uy.com.plexo.models.Query q9 = new uy.com.plexo.models.Query();
		
		q2.setField(TransactionField.Metadata);
		q3.setField(TransactionField.PurchaseStatus);
		q4.setField(TransactionField.CancelStatus);
		q5.setField(TransactionField.TransactionId);
		q6.setField(TransactionField.CommerceId);
		q7.setField(TransactionField.PurchaseExternalId);	
		q8.setField(TransactionField.IssuerId);
		q9.setField(TransactionField.TransactionState);
		
		q6.setOperator(TransactionOperator.Equal);//Operator
		q7.setOperator(TransactionOperator.Equal);//Operator
		q3.setOperator(TransactionOperator.Equal);//Operator
		q4.setOperator(TransactionOperator.NotEqual);//Operator
		q5.setOperator(TransactionOperator.Equal);
		q8.setOperator(TransactionOperator.Equal);//Operator
		q9.setOperator(TransactionOperator.Equal);//Operator
		//q3.setOperator(TransactionOperator.NotEqual);//Operator
		q2.setOperator(TransactionOperator.Contains);//Operator
		q2.setValue("Richter");
		q3.setValue("0");
		q4.setValue("0");
		q5.setValue("8a0f483c694d42e2897473ae56b9b48d");
		q8.setValue("4");
		//q3.setValue("21");
		q9.setValue("1"); //status 1 = Purchase, 2 = Cancel, 3 = Refund
		
		q7.setValue("5838");
		q2.setValue("5838");//value en metadata
		q2.setQueryOperator(QueryOperation.And);
		q3.setQueryOperator(QueryOperation.And);
		q4.setQueryOperator(QueryOperation.And);
		q5.setQueryOperator(QueryOperation.And);
		q6.setQueryOperator(QueryOperation.And);
		q7.setQueryOperator(QueryOperation.And);
		q8.setQueryOperator(QueryOperation.And);
		q9.setQueryOperator(QueryOperation.And);
		queries.add(q); //Fecha desde
		queries.add(q1); //Fecha hasta
		//queries.add(q2); // Metadata contains
		queries.add(q3); //Purchase status = 0
		//queries.add(q4); //Cancel status = null
		//queries.add(q5); //Transaction ID
		q6.setValue("704");
		queries.add(q6); //CommerceID
		//queries.add(q7); //PurchaseExternalId		
		//queries.add(q8); //IssuerId
		queries.add(q9); //TransactionStatus
		
		TransactionQuery tranQ = new TransactionQuery();
		tranQ.setQueries(queries);
		tranQ.setLimit(100);
		tranQ.setSkip(0);
		
		//process(auth);
		PlexoClient client = new PlexoClient("Alphalabs", "Alphalabs.pfx", "4pNHgWKKX0Hzc8wTXRKc", "https://testing.plexo.com.uy:4043/SecurePaymentGateway.svc");
		client.transactionQuery(tranQ);
		//client.transactionQueryCSV(tranQ);

	}

	
	
	
	private static <T> ClientRequest<T> wrapClient(T request)
    {
		ClientRequest<T> cr = new ClientRequest<>();
		cr.setClient(new SignatureHelper().getClientName());
		cr.setRequest(request);
        return cr;
    }
	
	public static void doQuery(String cliente, String pfxFile, String password, String URL){
		PlexoClient client = new PlexoClient(cliente, pfxFile, password, URL);
		List<uy.com.plexo.models.Query> queries = new LinkedList<uy.com.plexo.models.Query>();
		uy.com.plexo.models.Query q = new uy.com.plexo.models.Query();
		q.setField(TransactionField.CreationDate);//Field
		q.setOperator(TransactionOperator.BiggerOrEqualThan);//Operator
		q.setValue("01-08-2017");
		//q.setValue("2017-08-01");
		q.setQueryOperator(QueryOperation.And); 
		uy.com.plexo.models.Query q2 = new uy.com.plexo.models.Query();
		q2.setField(TransactionField.PurchaseStatus);
		q2.setOperator(TransactionOperator.Equal);//Operator
		q2.setValue("0");
		q2.setQueryOperator(QueryOperation.And);
		queries.add(q);
		queries.add(q2);
		TransactionQuery tranQ = new TransactionQuery();
		tranQ.setQueries(queries);
		tranQ.setLimit(100);
		tranQ.setSkip(0);
		
		client.transactionQuery(tranQ);
	}
	
	
}

