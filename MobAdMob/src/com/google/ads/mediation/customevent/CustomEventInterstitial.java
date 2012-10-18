package com.google.ads.mediation.customevent;

import android.app.Activity;

import com.google.ads.mediation.MediationAdRequest;

public interface CustomEventInterstitial {
	public abstract void requestInterstitialAd(
			CustomEventInterstitialListener customeventinterstitiallistener,
			Activity activity, String s, String s1,
			MediationAdRequest mediationadrequest);

	public abstract void showInterstitial();
}
