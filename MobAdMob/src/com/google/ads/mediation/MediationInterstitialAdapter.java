package com.google.ads.mediation;

import android.app.Activity;

public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
		extends MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
	public abstract void requestInterstitialAd(
			MediationInterstitialListener mediationInterstitialListener,
			Activity activity,
			MediationServerParameters mediationServerParameters,
			MediationAdRequest mediationAdRequest, NetworkExtras networkExtras);

	public abstract void showInterstitial();
}
