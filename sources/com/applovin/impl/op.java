package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class op extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f62353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dc f62354b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return d.values().length;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return i3 == d.SETTINGS.ordinal() ? op.this.c() : op.this.a();
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return i3 == d.SETTINGS.ordinal() ? e.values().length : c.values().length;
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return i3 == d.SETTINGS.ordinal() ? new fj("SETTINGS") : new fj("GDPR APPLICABILITY");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f62356a;

        b(com.applovin.impl.sdk.j jVar) {
            this.f62356a = jVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            if (kbVar.b() == d.SETTINGS.ordinal()) {
                if (kbVar.a() == e.PRIVACY_POLICY_URL.ordinal()) {
                    if (this.f62356a.u().g() != null) {
                        tp.a(this.f62356a.u().g(), com.applovin.impl.sdk.j.m(), this.f62356a);
                        return;
                    } else {
                        yp.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", op.this);
                        return;
                    }
                }
                if (kbVar.a() != e.TERMS_OF_SERVICE_URL.ordinal() || this.f62356a.u().h() == null) {
                    return;
                }
                tp.a(this.f62356a.u().h(), com.applovin.impl.sdk.j.m(), this.f62356a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c {
        DESCRIPTION,
        CONSENT_FLOW_GEOGRAPHY,
        DEBUG_USER_GEOGRAPHY
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum d {
        SETTINGS,
        GDPR_APPLICABILITY
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum e {
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(e.values().length);
        arrayList.add(b());
        arrayList.add(d());
        return arrayList;
    }

    private cc d() {
        cc.b bVarD = cc.a().d("Terms of Service URL");
        if (this.f62353a.u().h() != null) {
            bVarD.a(R.drawable.applovin_ic_check_mark_bordered);
            bVarD.b(t3.a(R.color.applovin_sdk_checkmarkColor, this));
            bVarD.a(true);
        } else {
            bVarD.c("None");
            bVarD.a(false);
        }
        return bVarD.a();
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f62353a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f62353a = jVar;
        a aVar = new a(this);
        this.f62354b = aVar;
        aVar.a(new b(jVar));
        this.f62354b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("MAX Terms and Privacy Policy Flow");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f62354b);
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dc dcVar = this.f62354b;
        if (dcVar != null) {
            dcVar.a((dc.a) null);
        }
    }

    private cc a(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z2) {
        return cc.a().d("Consent Flow Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN).b(z2).a();
    }

    private cc b(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z2) {
        return cc.a().d("Debug User Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "None").b(z2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        ArrayList arrayList = new ArrayList(c.values().length);
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f62353a.s().getConsentFlowUserGeography();
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyE = this.f62353a.u().e();
        boolean z2 = yp.c(this.f62353a) && consentFlowUserGeographyE != AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
        arrayList.add(cc.a().d("AppLovin determines whether the user is located in a GDPR region. If the user is in a GDPR region, the MAX SDK presents Google UMP.\n\nYou can test the flow on debug mode by overriding the region check by setting the debug user geography.").a());
        arrayList.add(a(consentFlowUserGeography, !z2));
        arrayList.add(b(consentFlowUserGeographyE, z2));
        return arrayList;
    }

    private cc b() {
        boolean z2 = this.f62353a.u().g() != null;
        return cc.a().d("Privacy Policy URL").a(z2 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(z2 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this)).a(true).a();
    }
}
