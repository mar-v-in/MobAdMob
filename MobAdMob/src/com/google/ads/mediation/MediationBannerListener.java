package com.google.ads.mediation;

public interface MediationBannerListener
{

	public abstract void onReceivedAd(MediationBannerAdapter mediationbanneradapter);

	public abstract void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode);

	public abstract void onPresentScreen(MediationBannerAdapter mediationbanneradapter);

	public abstract void onDismissScreen(MediationBannerAdapter mediationbanneradapter);

	public abstract void onLeaveApplication(MediationBannerAdapter mediationbanneradapter);

	public abstract void onClick(MediationBannerAdapter mediationbanneradapter);
}
