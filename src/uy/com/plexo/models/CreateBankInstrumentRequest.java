package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class CreateBankInstrumentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7393161935844641605L;
    public Integer issuerId;
    public AuthorizationInfo user;
    public Map<FieldType, String> instrumentData;
    //public SortedMap<FieldType, String> instrumentData;
	public CreateBankInstrumentRequest() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIssuerId() {
		return issuerId;
	}
	public AuthorizationInfo getUser() {
		return user;
	}
	public Map<FieldType, String> getInstrumentData() {
		return instrumentData;
		/*Map<FieldType, String> sortedinstrumentdata = new HashMap<FieldType, String>();
		for (Entry<FieldType, String> entry  : entriesSortedByValues(instrumentData)) {
		    sortedinstrumentdata.put(entry.getKey(), entry.getValue());
		}
		return sortedinstrumentdata;*/
	}
	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
	}
	public void setUser(AuthorizationInfo user) {
		this.user = user;
	}
	public void setInstrumentData(Map<FieldType, String> instrumentData) {
		this.instrumentData = instrumentData;
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    //int res = e1.getValue().compareTo(e2.getValue());
                	int res = ((FieldType)e1.getKey()).name().compareToIgnoreCase(((FieldType)e2.getKey()).name());
                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
	

}
