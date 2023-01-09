package uy.com.plexo.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({ "CardIssuer", "CardType","Cellphone", "City" ,"CommerceReferenceId", "CommerceReserveExpirationInSeconds" ,"Country", "CVC","CybersourceDeviceFingerprint"})
//@JsonPropertyOrder(alphabetic=true)
public enum FieldType {
	//User Generic Information
    Expiration, //257
    Name,	//258
    Address, //259
    ZipCode, //260
    Email,  //261
    Phone, //262
    Cellphone, //263
    AmountLimitExtension, //264
    Birthdate, //265
    InstrumentName,   //266
    Identification, 	//267
    IdentificationType,       //268                    // 0 - CI , 1 - Pasaport, 2 Otros, 3 RUT
    IdentificationTypeExtended, //269                  // 0 - CI , 1 - Pasaport, 2 Otros, 3 RUT
    AccountNumber, //270                               //Bank Account Number
    FirstName, //271
    LastName, //272
    City,//273
    State,//274
    
    //New OptionalFields
    Country, //513
    ShippingAddress,//514
    ShippingZipCode,//515
    ShippingCity,//516
    ShippingCountry,//517
    PromotionalCode,//518
    CommerceReferenceId,//519
    TransactionDateTime,//520
    DeferredMonths,//521
    Plan,//522
    RecurringPayment,//523
    IssuerId,//524
    PaymentLink,//525
    ShippingFirstName,//526
    ShippingLastName,//527
    ShippingPhoneNumber,//528
    InternalPaymentCallback,//529
    CustomInvoiceNumber,//530
    VATAmount,//531
    
    //Provider Related Information starts at 0x400
    Provider, //1025   - Example Visa

    //User/Provider Related Information starts at 0x500 // User Flag + Provider Flag
    SistarBancPaymentMethod, //1281
    RedPagosProductNumber, //1282
    RedPagosUserEnabled, //1283
    VisaNetUserId, //1284,
    CardType,  //1285,
    CardIssuer, //1286,
    CybersourceDeviceFingerprint, //1287
    ClientIP, //1288
    IntegerId,  //1289
    RefundIntegerId, //1290
    ReserveIntegerId,//1291
    BankId,//1292

    //Commerce Related Information starts at 0x800
    ProviderCommerceNumber, //2049  This Could be the commerce id (Master/Oca/Visa/Etc)
    OcaTaxiCode, //2050
    TerminalNumber, //2051
    PosNumber, //2052
    ProviderMerchantId, //2053
    ProviderBranchNumber, //2054
    CommerceReserveExpirationInSeconds, //2055
    SoftDescriptor, //2056
    MCC,//2057
    CommerceCountry,//2058
    CommerceCity,//2059
    CommerceRUT,//2060
    SubCommerceAddress,//2061
    AggregatorId,   //2062  
    SubmerchantId,  //2063 
    PaymentFacilitatorId,//2064
    PaymentFacilitatorCommerceId,//2065
    PaymentFacilitatorIntegratorId,//2066
    AvailableBanks,//2067
    CommerceIssuerInstallments,//2068
    PaymentProcessorId,//2069
    LoanPaybackDate,//2070
    LoanFeeAmount,//2071
    FingerprintOrgID,//2072
    FingerprintSessID,//2073
    
    //Secure Information Starts at 0x8100  //Private Flag + User Flag
    //Secure User Generic Information
    Pan, //33025
    Token, //33026
    UniqueId, //33027

    //Non Storable Secure Information 0x80;
    Pin, //33153
    Cvc, //33154
	
    //Cybersource
    //AuthServiceCommerceIndicator, //= 0x901, UY
    FIID, //= 0x901, MX
    AuthServiceXid, //= 0x902,
    AuthServiceEciRaw ,//= 0x903,
    AuthServiceCavv; //= 0x904,
	
	public String toDbValue() {
		if (this.name().equals("CVC"))
			return this.name().toLowerCase();
		else
			return this.name();
    }

    /*public static FieldType from(String status) {
        // Note: error if null, error if not "ACTIVE" nor "INACTIVE"
        return FieldType.valueOf(status.toUpperCase());
    }*/
   
}
