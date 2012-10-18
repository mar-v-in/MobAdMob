package com.google.ads.mediation;

import java.lang.annotation.Annotation;
import java.util.Map;

public abstract class MediationServerParameters {
	public static class MappingException extends Exception {
		public MappingException(String message) {
			super(message);
		}
	}

	protected static interface Parameter extends Annotation {
		public abstract String name();

		public abstract boolean required();
	}

	public void load(Map<String, String> parameters) throws MappingException {

	}
}
