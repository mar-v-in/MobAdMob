package com.google.ads.mediation.customevent;

import android.view.View;

public interface CustomEventBannerListener extends CustomEventListener {

	public abstract void onReceivedAd(View view);

	public abstract void onClick();
}
