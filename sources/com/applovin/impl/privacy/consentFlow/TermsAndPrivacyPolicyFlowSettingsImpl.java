package com.applovin.impl.privacy.consentFlow;

import android.net.Uri;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TermsAndPrivacyPolicyFlowSettingsImpl implements AppLovinTermsAndPrivacyPolicyFlowSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f62509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdkConfiguration.ConsentFlowUserGeography f62510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f62511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f62512d;

    public TermsAndPrivacyPolicyFlowSettingsImpl(boolean z2, AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, Uri uri, Uri uri2) {
        this.f62509a = z2;
        this.f62510b = consentFlowUserGeography;
        this.f62511c = uri;
        this.f62512d = uri2;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return this.f62510b;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public Uri getPrivacyPolicyUri() {
        return this.f62511c;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public Uri getTermsOfServiceUri() {
        return this.f62512d;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public boolean isEnabled() {
        return this.f62509a;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        n.g("ConsentFlowSettingsImpl", "Setting user debug geography: " + consentFlowUserGeography);
        this.f62510b = consentFlowUserGeography;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setEnabled(boolean z2) {
        n.g("ConsentFlowSettingsImpl", "Setting Terms and Privacy Policy Flow enabled: " + z2);
        this.f62509a = z2;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setPrivacyPolicyUri(Uri uri) {
        n.g("ConsentFlowSettingsImpl", "Setting privacy policy: " + uri);
        this.f62511c = uri;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setTermsOfServiceUri(Uri uri) {
        n.g("ConsentFlowSettingsImpl", "Setting terms of service: " + uri);
        this.f62512d = uri;
    }

    public String toString() {
        return "ConsentFlowSettings{isEnabled=" + this.f62509a + ", privacyPolicyUri=" + this.f62511c + ", termsOfServiceUri=" + this.f62512d + '}';
    }
}
