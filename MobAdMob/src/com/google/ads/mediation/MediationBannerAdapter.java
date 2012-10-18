package com.google.ads.mediation;

import com.google.ads.AdSize;

import android.app.Activity;
import android.view.View;

public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
		extends MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
	public abstract void requestBannerAd(
			MediationBannerListener mediationBannerListener, Activity activity,
			MediationServerParameters mediationServerParameters, AdSize adsize,
			MediationAdRequest mediationAdRequest, NetworkExtras networkExtras);

	public abstract View getBannerView();
}
