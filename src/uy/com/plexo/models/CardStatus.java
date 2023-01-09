package uy.com.plexo.models;

import java.io.Serializable;

public enum CardStatus implements Serializable {
	 Ok,
     WarningExpirationInLessThanOneMonth,
     Expired,
     Disabled,
     WaitingForConfirmation
}
