package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;

import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public class CustomEventAdapter
		implements
		MediationAdapter<EmptyNetworkExtras, CustomEventServerParameters>,
		MediationBannerAdapter<EmptyNetworkExtras, CustomEventServerParameters>,
		MediationInterstitialAdapter<EmptyNetworkExtras, CustomEventServerParameters> {

	public void requestInterstitialAd(
			MediationInterstitialListener mediationInterstitialListener,
			Activity activity,
			MediationServerParameters mediationServerParameters,
			MediationAdRequest mediationAdRequest, NetworkExtras networkExtras) {
		// IGNORE
	}

	public void showInterstitial() {
		// IGNORE
	}

	public void requestBannerAd(
			MediationBannerListener mediationBannerListener, Activity activity,
			MediationServerParameters mediationServerParameters, AdSize adsize,
			MediationAdRequest mediationAdRequest, NetworkExtras networkExtras) {
		// IGNORE
	}

	public View getBannerView() {
		// IGNORE
		return null;
	}

	public void destroy() {
		// IGNORE
	}

	public Class<EmptyNetworkExtras> getAdditionalParametersType() {
		return EmptyNetworkExtras.class;
	}

	public Class<CustomEventServerParameters> getServerParametersType() {
		return CustomEventServerParameters.class;
	}

}
