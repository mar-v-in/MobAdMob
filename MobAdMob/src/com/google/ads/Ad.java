package com.google.ads;

public interface Ad {

	public abstract boolean isReady();

	public abstract void loadAd(AdRequest adrequest);

	public abstract void setAdListener(AdListener adlistener);

	public abstract void stopLoading();
}
