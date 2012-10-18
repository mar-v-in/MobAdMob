package com.google.ads.mediation;

public interface MediationInterstitialListener {
	public abstract void onReceivedAd(
			MediationInterstitialAdapter mediationinterstitialadapter);

	public abstract void onFailedToReceiveAd(
			MediationInterstitialAdapter mediationinterstitialadapter,
			com.google.ads.AdRequest.ErrorCode errorcode);

	public abstract void onPresentScreen(
			MediationInterstitialAdapter mediationinterstitialadapter);

	public abstract void onDismissScreen(
			MediationInterstitialAdapter mediationinterstitialadapter);

	public abstract void onLeaveApplication(
			MediationInterstitialAdapter mediationinterstitialadapter);
}
