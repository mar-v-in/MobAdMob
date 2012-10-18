package com.google.ads.mediation;

public interface MediationAdapter<ADDITIONAL_PARAMETERS,SERVER_PARAMETERS extends MediationServerParameters> {
	public abstract void destroy();

	public abstract Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

	public abstract Class<SERVER_PARAMETERS> getServerParametersType();
}
