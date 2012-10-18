package com.google.ads;

import android.app.Activity;

public class InterstitialAd implements Ad {
	
	public InterstitialAd(Activity activity, String adUnitId)
	{
		this(activity, adUnitId, false);
	}

	public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout)
	{
	}

	public boolean isReady() {
		return false;
	}

	public void loadAd(AdRequest adrequest) {
		// IGNORE
	}
	
	public void show() {
		// IGNORE
	}

	public void setAdListener(AdListener adlistener) {
		// IGNORE
	}

	public void stopLoading() {
		// IGNORE
	}

}
