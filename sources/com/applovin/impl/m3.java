package com.applovin.impl;

import com.applovin.sdk.AppLovinSdkConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinSdkConfiguration.ConsentFlowUserGeography f61333a;

    public m3(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        this.f61333a = consentFlowUserGeography;
    }

    protected boolean a(Object obj) {
        return obj instanceof m3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        if (!m3Var.a(this)) {
            return false;
        }
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA = a();
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA2 = m3Var.a();
        return consentFlowUserGeographyA != null ? consentFlowUserGeographyA.equals(consentFlowUserGeographyA2) : consentFlowUserGeographyA2 == null;
    }

    public int hashCode() {
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA = a();
        return (consentFlowUserGeographyA == null ? 43 : consentFlowUserGeographyA.hashCode()) + 59;
    }

    public String toString() {
        return "CmpAdapterParameters(debugUserGeography=" + a() + ")";
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography a() {
        return this.f61333a;
    }
}
