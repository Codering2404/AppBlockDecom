package com.applovin.impl;

import android.app.Activity;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class sm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f63816h;

    public sm(com.applovin.impl.sdk.j jVar) {
        super("TaskInitializeSdk", jVar, true);
        this.f63816h = jVar;
    }

    private void g() {
        if (this.f63816h.K().c()) {
            return;
        }
        Activity activityM0 = this.f63816h.m0();
        if (activityM0 != null) {
            this.f63816h.K().a(activityM0);
        } else {
            this.f63816h.i0().a(new jn(this.f63816h, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.d50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59087a.e();
                }
            }), tm.b.CORE, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f63816h.K().a(this.f63816h.e().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        sr.f(this.f63816h);
    }

    private void h() {
        String str;
        boolean zC = this.f63816h.g0().c();
        Map mapM = this.f63816h.x().m();
        Map mapG = this.f63816h.x().G();
        String strA = zC ? this.f63816h.x().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        if (zC) {
            str = mapM.get("idfv") + " (use this for test devices)";
        } else {
            str = "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        }
        pc pcVar = new pc();
        pcVar.a().a(rnFwbPAQmQTnL.QVFmsGqFM);
        pcVar.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.f63816h.a(sj.K3)).a("Ad Review Version", v.b()).a("OM SDK Version", this.f63816h.V().c());
        pcVar.a("===Device Info===").a("OS", yp.d()).a("GAID", strA).a("App Set ID", str).a("Model", mapM.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)).a("Locale", mapM.get("locale")).a("Emulator", mapM.get("sim")).a("Tablet", mapM.get("is_tablet"));
        pcVar.a("===App Info===").a("Application ID", mapG.get("package_name")).a("Target SDK", mapG.get("target_sdk")).a("ExoPlayer Version", Integer.valueOf(yp.f()));
        pcVar.a("===SDK Settings===").a("SDK Key", this.f63816h.a0()).a("Mediation Provider", this.f63816h.N()).a("TG", wp.a(this.f63816h)).a("MD", this.f63816h.a(sj.f63797v)).a("Test Mode On", Boolean.valueOf(this.f63816h.k0().c())).a("Verbose Logging On", Boolean.valueOf(zC));
        pcVar.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(a4.a(a()));
        pcVar.a("===MAX Terms and Privcay Policy Flow===");
        h4 h4VarU = this.f63816h.u();
        boolean zJ = h4VarU.j();
        pcVar.a("Enabled", Boolean.valueOf(zJ));
        if (zJ) {
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f63816h.s().getConsentFlowUserGeography();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyE = h4VarU.e();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            String str2 = "Other";
            pcVar.a("Consent Flow Geography", consentFlowUserGeography == consentFlowUserGeography2 ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            if (yp.c(this.f63816h)) {
                if (consentFlowUserGeographyE == consentFlowUserGeography2) {
                    str2 = "GDPR";
                } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                    str2 = "None";
                }
                pcVar.a("Debug User Geography", str2);
            }
        }
        pcVar.a("Privacy Policy URI", h4VarU.g()).a("Terms of Service URI", h4VarU.h());
        pcVar.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.f63816h.j0().j());
        pcVar.a();
        com.applovin.impl.sdk.n.g("AppLovinSdk", pcVar.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0243 A[PHI: r8 r9 r10
      0x0243: PHI (r8v23 com.applovin.impl.sdk.n) = (r8v16 com.applovin.impl.sdk.n), (r8v81 com.applovin.impl.sdk.n) binds: [B:51:0x0241, B:35:0x01b8] A[DONT_GENERATE, DONT_INLINE]
      0x0243: PHI (r9v17 java.lang.String) = (r9v13 java.lang.String), (r9v28 java.lang.String) binds: [B:51:0x0241, B:35:0x01b8] A[DONT_GENERATE, DONT_INLINE]
      0x0243: PHI (r10v7 java.lang.StringBuilder) = (r10v6 java.lang.StringBuilder), (r10v11 java.lang.StringBuilder) binds: [B:51:0x0241, B:35:0x01b8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sm.run():void");
    }
}
