package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class AdView extends RelativeLayout implements Ad {
	public AdView(Activity activity, AdSize adSize, String adUnitId) {
		super(activity.getApplicationContext());
	}

	protected AdView(Activity activity, AdSize adSizes[], String adUnitId) {
		this(activity, new AdSize(0, 0), adUnitId);
	}

	public AdView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AdView(Context context, AttributeSet attrs, int defStyle) {
		this(context, attrs);
	}
	
	public void destroy() {
		// IGNORE
	}

	public boolean isReady() {
		return false;
	}

	public boolean isRefreshing() {
		return false;
	}

	public void loadAd(AdRequest adrequest) {
		// IGNORE
	}

	public void setAdListener(AdListener adlistener) {
		// IGNORE
	}

	protected void setAppEventListener(AppEventListener appEventListener) {
		// IGNORE
	}
	
	protected void setSupportedAdSizes(AdSize adSizes[]) {
		// IGNORE
	}

	public void stopLoading() {
		// IGNORE
	}
}
