package com.google.ads.mediation.customevent;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;

import android.app.Activity;

public interface CustomEventBanner {
	public abstract void requestBannerAd(
			CustomEventBannerListener customeventbannerlistener,
			Activity activity, String s, String s1, AdSize adsize,
			MediationAdRequest mediationadrequest);
}
