package com.google.ads.mediation.customevent;

public interface CustomEventListener {
	public abstract void onFailedToReceiveAd();

	public abstract void onPresentScreen();

	public abstract void onDismissScreen();

	public abstract void onLeaveApplication();
}
