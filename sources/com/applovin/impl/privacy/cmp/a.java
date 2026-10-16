package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.m3;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f62497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f62498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConsentForm f62499c;

    /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class C0117a implements ConsentInformation.OnConsentInfoUpdateSuccessListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f62500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f62501b;

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0118a implements UserMessagingPlatform.OnConsentFormLoadSuccessListener {
            C0118a() {
            }

            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
            public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                a.this.a("Successfully loaded consent form");
                a.this.f62499c = consentForm;
                C0117a.this.f62501b.onFlowLoaded(null);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a$b */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class b implements UserMessagingPlatform.OnConsentFormLoadFailureListener {
            b() {
            }

            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
            public void onConsentFormLoadFailure(FormError formError) {
                a.this.b("Failed to load with error: " + formError.getMessage());
                C0117a c0117a = C0117a.this;
                c0117a.f62501b.onFlowLoadFailed(a.this.a(formError, "Consent form load failed"));
            }
        }

        C0117a(Activity activity, d dVar) {
            this.f62500a = activity;
            this.f62501b = dVar;
        }

        @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
        public void onConsentInfoUpdateSuccess() {
            ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(this.f62500a);
            boolean zIsConsentFormAvailable = consentInformation.isConsentFormAvailable();
            int consentStatus = consentInformation.getConsentStatus();
            a.this.a("Loaded parameters consentStatus: " + consentStatus + ", consentFormAvailable: " + zIsConsentFormAvailable);
            if (!zIsConsentFormAvailable) {
                a.this.b("Failed to load form.");
                this.f62501b.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form unavailable"));
                return;
            }
            if (consentStatus == 2) {
                a.this.a("Successfully requested consent info");
                a.this.a("Loading consent form...");
                UserMessagingPlatform.loadConsentForm(this.f62500a, new C0118a(), new b());
                return;
            }
            a.this.b("Failed to load with consent status: " + consentStatus);
            this.f62501b.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_NOT_REQUIRED, "Consent form not required for consent status: " + consentStatus));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements ConsentInformation.OnConsentInfoUpdateFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f62505a;

        b(d dVar) {
            this.f62505a = dVar;
        }

        @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
        public void onConsentInfoUpdateFailure(FormError formError) {
            a.this.b("Failed to request consent info with error: " + formError.getMessage());
            this.f62505a.onFlowLoadFailed(a.this.a(formError, "Consent info update failed"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements ConsentForm.OnConsentFormDismissedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f62507a;

        c(d dVar) {
            this.f62507a = dVar;
        }

        @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
        public void onConsentFormDismissed(FormError formError) {
            if (formError == null) {
                a.this.a("Consent form finished showing");
                this.f62507a.onFlowHidden(null);
                return;
            }
            a.this.b("Failed to show with error: " + formError.getMessage());
            this.f62507a.onFlowShowFailed(a.this.a(formError, "Consent form show failed"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void onFlowHidden(Bundle bundle);

        void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl);

        void onFlowLoaded(Bundle bundle);

        void onFlowShowFailed(CmpErrorImpl cmpErrorImpl);
    }

    public a(j jVar) {
        this.f62497a = jVar;
        this.f62498b = jVar.I();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(j.m());
        a("Initializing with SDK Version: " + b() + ", consentStatus: " + consentInformation.getConsentStatus() + ", consentFormAvailable: " + consentInformation.isConsentFormAvailable());
    }

    public void a(Activity activity, m3 m3Var, d dVar) {
        ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
        if (yp.c(this.f62497a) && m3Var.a() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId(StringUtils.emptyIfNull(this.f62497a.f0().getExtraParameters().get("google_test_device_hashed_id"))).build());
        }
        UserMessagingPlatform.getConsentInformation(activity).requestConsentInfoUpdate(activity, builder.build(), new C0117a(activity, dVar), new b(dVar));
    }

    public String b() {
        return null;
    }

    public void c() {
        a("Resetting consent information");
        UserMessagingPlatform.getConsentInformation(j.m()).reset();
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    public void b(Activity activity, m3 m3Var, d dVar) {
        if (this.f62499c == null) {
            b("Failed to show - not ready yet");
            dVar.onFlowShowFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form not ready"));
        } else {
            a("Showing consent form...");
            this.f62499c.show(activity, new c(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (n.a()) {
            this.f62498b.b("GoogleCmpAdapter", str);
        }
    }

    public void a() {
        if (this.f62499c != null) {
            this.f62499c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.applovin.impl.privacy.cmp.CmpErrorImpl a(com.google.android.ump.FormError r4, java.lang.String r5) {
        /*
            r3 = this;
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.UNSPECIFIED
            int r1 = r4.getErrorCode()
            r2 = 1
            if (r1 == r2) goto L16
            r2 = 2
            if (r1 == r2) goto L16
            r2 = 3
            if (r1 == r2) goto L13
            r2 = 4
            if (r1 == r2) goto L16
            goto L18
        L13:
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.INTEGRATION_ERROR
            goto L18
        L16:
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.FORM_UNAVAILABLE
        L18:
            com.applovin.impl.privacy.cmp.CmpErrorImpl r1 = new com.applovin.impl.privacy.cmp.CmpErrorImpl
            int r2 = r4.getErrorCode()
            java.lang.String r4 = r4.getMessage()
            r1.<init>(r0, r5, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.privacy.cmp.a.a(com.google.android.ump.FormError, java.lang.String):com.applovin.impl.privacy.cmp.CmpErrorImpl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (n.a()) {
            this.f62498b.a("GoogleCmpAdapter", str);
        }
    }
}
