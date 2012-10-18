package com.google.ads.mediation.admob;

import java.util.HashMap;
import java.util.Map;

import com.google.ads.mediation.NetworkExtras;

public class AdMobAdapterExtras implements NetworkExtras{
	
	Map<String, Object> extras;
	public AdMobAdapterExtras() {
		clearExtras();
	}

	public AdMobAdapterExtras(AdMobAdapterExtras original) {
		this();
	}

	public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
		// IGNORE
		return this;
	}

	public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
		// IGNORE
		return this;
	}

	public boolean getUseExactAdSize() {
		return false;
	}

	public boolean getPlusOneOptOut() {
		return true;
	}

	public AdMobAdapterExtras clearExtras() {
		extras = new HashMap<String, Object>();
		return this;
	}

	public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
		if (extras == null) throw new IllegalArgumentException("Argument 'extras' may not be null");
		this.extras = extras;
		return this;
	}

	public AdMobAdapterExtras addExtra(String key, Object value) {
		extras.put(key, value);
		return this;
	}
	
	public Map<String, Object> getExtras() {
		return extras;
	}
}
