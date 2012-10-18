package com.google.ads;

public interface AdListener
{

	public abstract void onReceiveAd(Ad ad);

	public abstract void onFailedToReceiveAd(Ad ad, AdRequest.ErrorCode errorcode);

	public abstract void onPresentScreen(Ad ad);

	public abstract void onDismissScreen(Ad ad);

	public abstract void onLeaveApplication(Ad ad);
}
