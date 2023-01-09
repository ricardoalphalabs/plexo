package uy.com.plexo.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class CreateExternalInstrumentRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer issuerId;
    public Authorization authorizationData;
    public Map<FieldType, String> instrumentData;
    public Boolean void3DS; 
	public CreateExternalInstrumentRequest() {
	}
	public Integer getIssuerId() {
		return issuerId;
	}

	public Map<FieldType, String> getInstrumentData() {
		return instrumentData;
	}
	public void setIssuerId(Integer issuerId) {
		this.issuerId = issuerId;
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
	public Authorization getAuthorizationData() {
		return authorizationData;
	}
	public void setAuthorizationData(Authorization authorizationData) {
		this.authorizationData = authorizationData;
	}
	public Boolean getVoid3DS() {
		return void3DS;
	}
	public void setVoid3DS(Boolean void3ds) {
		void3DS = void3ds;
	}
	

}
