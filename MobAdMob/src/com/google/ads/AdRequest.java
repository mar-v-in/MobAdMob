package com.google.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.location.Location;

public class AdRequest {
	public enum Gender {
		UNKNOWN, MALE, FEMALE;
	}

	public enum ErrorCode {
		INVALID_REQUEST("Invalid Ad request."), NO_FILL(
				"Ad request successful, but no ad returned due to lack of ad inventory."), NETWORK_ERROR(
				"A network error occurred."), INTERNAL_ERROR(
				"There was an internal error.");
		private String description;

		private ErrorCode(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return description;
		}
	}

	public AdRequest setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	public Gender getGender() {
		return gender;
	}

	public AdRequest setBirthday(String birthday) {
		if (birthday == "" || birthday == null)
			this.birthday = null;
		else
			try {
				this.birthday = dateFormat.parse(birthday);
			} catch (ParseException parseException) {
				this.birthday = null;
			}
		return this;
	}

	public AdRequest setBirthday(Date birthday) {
		if (birthday == null)
			this.birthday = null;
		else
			this.birthday = new Date(birthday.getTime());
		return this;
	}

	public AdRequest setBirthday(Calendar calendar) {
		if (calendar == null)
			this.birthday = null;
		else
			setBirthday(calendar.getTime());
		return this;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public AdRequest clearBirthday() {
		this.birthday = null;
		return this;
	}

	public AdRequest setPlusOneOptOut(boolean plusOneOptOut) {
		// IGNORE
		return this;
	}

	public boolean getPlusOneOptOut() {
		return true;
	}

	public AdRequest setKeywords(Set<String> keywords) {
		this.keywords = keywords;
		return this;
	}

	public AdRequest addKeyword(String keyword) {
		if (keywords == null)
			keywords = new HashSet<String>();
		keywords.add(keyword);
		return this;
	}

	public AdRequest addKeywords(Set<String> keywords) {
		if (this.keywords == null)
			this.keywords = new HashSet<String>();
		this.keywords.addAll(keywords);
		return this;
	}

	public Set<String> getKeywords() {
		if (keywords == null)
			return null;
		else
			return Collections.unmodifiableSet(keywords);
	}

	public AdRequest setExtras(Map<String, Object> extras) {
		// IGNORE
		return this;
	}

	public AdRequest addExtra(String key, Object value) {
		// IGNORE
		return this;
	}
	
	public AdRequest setMediationExtras(Map<String, Object> extras) {
		// IGNORE
		return this;
	}

	public AdRequest addMediationExtra(String key, Object value) {
		// IGNORE
		return this;
	}
	
	public AdRequest setLocation(Location location)
	{
		this.location = location;
		return this;
	}

	public Location getLocation()
	{
		return location;
	}
	
	public AdRequest setTesting(boolean testing)
	{
		// IGNORE
		return this;
	}
	
	public Map<String,Object> getRequestMap(Context context) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		if (keywords != null) 
			map.put("kw", keywords);
		if (gender != null) 
			map.put("cust_gender", Integer.valueOf(gender.ordinal()));
		if (birthday != null)
			map.put("cust_age", dateFormat.format(birthday));
		return map;
	}
	

	public AdRequest addTestDevice(String testDevice)
	{
		// IGNORE
		return this;
	}

	public AdRequest setTestDevices(Set<String> testDevices)
	{
		// IGNORE
		return this;
	}

	public boolean isTestDevice(Context context)
	{
		return false;
	}

	public static final String VERSION = "6.1.0";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMdd");
	private Gender gender;
	private Date birthday;
	private Location location;
	private Set<String> keywords = new HashSet<String>();
	public static final String LOGTAG = "Ads";
	public static final String TEST_EMULATOR = "UNKNOWN";
}
