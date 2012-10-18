package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize {
	public AdSize(int width, int height) {
		this(width, height, null);
		if (isInvalid()) {
			custom = false;
			type = TYPE_MB;
		} else {
			custom = true;
		}
	}

	int width;
	int height;
	boolean custom;
	String type;
	public static final String TYPE_MB = "mb";
	public static final String TYPE_AS = "as";
	public static final int FULL_WIDTH = -1;
	public static final int AUTO_HEIGHT = -2;
	public static final int LANDSCAPE_AD_HEIGHT = 32;
	public static final int PORTRAIT_AD_HEIGHT = 50;
	public static final int LARGE_AD_HEIGHT = 90;
	public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
	public static final AdSize BANNER = new AdSize(320, 50, "mb");
	public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
	public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
	public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
	public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");

	private AdSize(int width, int height, String type) {
		this.width = width;
		this.height = height;
		this.type = type;
		custom = false;
	}

	public static AdSize createAdSize(AdSize adSize, Context context) {
		if (context == null || !adSize.isInvalid()) {
			return adSize.isInvalid() ? BANNER : adSize;
		} else {
			int i = adSize.isFullWidth() ? autoWidth(context) : adSize
					.getWidth();
			int j = adSize.isAutoHeight() ? autoHeight(context) : adSize
					.getHeight();
			AdSize adsize = new AdSize(i, j, adSize.type);
			adsize.custom = adSize.custom;
			return adsize;
		}
	}

	public boolean equals(Object other) {
		if (!(other instanceof AdSize)) {
			return false;
		} else {
			AdSize adsize = (AdSize) other;
			return width == adsize.width && height == adsize.height;
		}
	}

	public int hashCode() {
		return Integer.valueOf(width).hashCode() << 16
				| Integer.valueOf(height).hashCode() & 0xffff;
	}

	public int getWidth() {
		if (width < 0)
			throw new UnsupportedOperationException(
					"Ad size was not set before getWidth() was called.");
		else
			return width;
	}

	public int getHeight() {
		if (height < 0)
			throw new UnsupportedOperationException(
					"Ad size was not set before getHeight() was called.");
		else
			return height;
	}

	private boolean isInvalid() {
		return height < 0 || width < 0;
	}

	public boolean isFullWidth() {
		return width == -1;
	}

	public boolean isAutoHeight() {
		return height == -2;
	}

	public boolean isCustomAdSize() {
		return custom;
	}

	public String toString() {
		return getWidth() + "x" + getHeight()
				+ (type != null ? "_" + type : "");
	}

	public int getWidthInPixels(Context context) {
		return (int) TypedValue.applyDimension(1, width, context.getResources()
				.getDisplayMetrics());
	}

	public int getHeightInPixels(Context context) {
		return (int) TypedValue.applyDimension(1, height, context
				.getResources().getDisplayMetrics());
	}

	public boolean isSizeAppropriate(int width, int height) {
		return (double) width <= (double) this.width * 1.25
				&& (double) width >= (double) this.width * 0.8
				&& (double) height <= (double) this.height * 1.25
				&& (double) height >= (double) this.height * 0.8;
	}

	public AdSize findBestSize(AdSize options[]) {
		AdSize bestSize = null;
		double bestDiff = 0;
		if (options != null) {
			for (int j = 0; j < options.length; j++) {
				AdSize checkSize = options[j];
				if (!isSizeAppropriate(checkSize.width, checkSize.height))
					continue;
				double diff = ((double) checkSize.width * (double) checkSize.height)
						/ ((double) width * (double) height);
				if (diff > 1)
					diff = 1 / diff;
				if (diff > bestDiff) {
					bestSize = checkSize;
					bestDiff = diff;
				}
			}

		}
		return bestSize;
	}

	private static int autoWidth(Context context) {
		DisplayMetrics displaymetrics = context.getResources()
				.getDisplayMetrics();
		return (int) ((float) displaymetrics.widthPixels / displaymetrics.density);
	}

	private static int autoHeight(Context context) {
		DisplayMetrics displaymetrics = context.getResources()
				.getDisplayMetrics();
		int i = (int) ((float) displaymetrics.heightPixels / displaymetrics.density);
		if (i <= 400)
			return 32;
		return i > 720 ? 90 : 50;
	}
}
