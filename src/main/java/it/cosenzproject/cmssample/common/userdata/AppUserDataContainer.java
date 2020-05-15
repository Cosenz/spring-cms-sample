package it.cosenzproject.cmssample.common.userdata;

import it.cosenzproject.cmssample.common.model.AppUserDetails;
import it.cosenzproject.cmssample.core.userdata.AbstractUserDataContainer;

public class AppUserDataContainer extends AbstractUserDataContainer<AppUserDetails> {

	@Override
	public Class<AppUserDetails> getUserDetailsType() {
		return AppUserDetails.class;
	}

}
