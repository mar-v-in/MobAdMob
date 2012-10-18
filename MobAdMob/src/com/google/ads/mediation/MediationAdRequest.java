package com.google.ads.mediation;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import android.content.Context;
import android.location.Location;

import com.google.ads.AdRequest;

public class MediationAdRequest {
	public MediationAdRequest(AdRequest request, Context context,
			boolean shareLocation) {
		adRequest = request;
	}

	public com.google.ads.AdRequest.Gender getGender() {
		return adRequest.getGender();
	}

	public Date getBirthday() {
		return adRequest.getBirthday();
	}

	public Integer getAgeInYears() {
		if (adRequest.getBirthday() != null) {
			Calendar calendar = Calendar.getInstance();
			Calendar calendar1 = Calendar.getInstance();
			calendar.setTime(adRequest.getBirthday());
			Integer integer = Integer.valueOf(calendar1.get(1)
					- calendar.get(1));
			if (calendar1.get(Calendar.DAY_OF_YEAR) < calendar
					.get(Calendar.DAY_OF_YEAR)) {
				integer = Integer.valueOf(integer.intValue() - 1);
			}
			return integer;
		} else {
			return null;
		}
	}

	public Set<String> getKeywords() {
		if (adRequest.getKeywords() == null)
			return null;
		else
			return Collections.unmodifiableSet(adRequest.getKeywords());
	}

	public Location getLocation() {
		return null;
	}

	public boolean isTesting() {
		return false;
	}

	private AdRequest adRequest;
}
