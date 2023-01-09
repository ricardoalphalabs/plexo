package uy.com.plexo.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class Authorization extends AuthorizationInfo implements Serializable {

	private static final long serialVersionUID = 2288205143836006038L;
	public ActionType action;
    public String redirectUri;
    public String optionalMetadata;
    public Map<FieldType, String> clientInformation;
    public List<String> limitIssuers;
    public Map<String,String> promotionInfoIssuers;
    public String extendableInstrumentToken;
    public Boolean doNotUseCallback; 
    public Integer optionalCommerceId;
    public List<String> limitBanks;
    public WebFormSettingsDto webFormSettings;
	public Authorization() {
		// TODO Auto-generated constructor stub
	}

	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getOptionalMetadata() {
		return optionalMetadata;
	}

	public void setOptionalMetadata(String optionalMetadata) {
		this.optionalMetadata = optionalMetadata;
	}

	public Map<FieldType,String> getClientInformation() {
		return clientInformation;
	}

	public void setClientInformation(Map<FieldType,String> clientInformation) {
		this.clientInformation = clientInformation;
	}

	public List<String> getLimitIssuers() {
		return limitIssuers;
	}

	public void setLimitIssuers(List<String> limitIssuers) {
		this.limitIssuers = limitIssuers;
	}

	public Map<String, String> getPromotionInfoIssuers() {
		return promotionInfoIssuers;
	}

	public void setPromotionInfoIssuers(Map<String, String> promotionInfoIssuers) {
		this.promotionInfoIssuers = promotionInfoIssuers;
	}

	public String getExtendableInstrumentToken() {
		return extendableInstrumentToken;
	}

	public void setExtendableInstrumentToken(String extendableInstrumentToken) {
		this.extendableInstrumentToken = extendableInstrumentToken;
	}

	public Boolean getDoNotUseCallback() {
		return doNotUseCallback;
	}

	public void setDoNotUseCallback(Boolean doNotUseCallback) {
		this.doNotUseCallback = doNotUseCallback;
	}

	public Integer getOptionalCommerceId() {
		return optionalCommerceId;
	}

	public void setOptionalCommerceId(Integer optionalCommerceId) {
		this.optionalCommerceId = optionalCommerceId;
	}

	public List<String> getLimitBanks() {
		return limitBanks;
	}

	public WebFormSettingsDto getWebFormSettings() {
		return webFormSettings;
	}

	public void setLimitBanks(List<String> limitBanks) {
		this.limitBanks = limitBanks;
	}

	public void setWebFormSettings(WebFormSettingsDto webFormSettings) {
		this.webFormSettings = webFormSettings;
	}

}
