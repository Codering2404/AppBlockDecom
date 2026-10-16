package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.h4;
import com.applovin.impl.privacy.consentFlow.TermsAndPrivacyPolicyFlowSettingsImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class h4 implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m4 f60125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f60126c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f60127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f4 f60128b;

        public a() {
        }

        public boolean b() {
            return this.f60127a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a((Object) this) || b() != aVar.b()) {
                return false;
            }
            f4 f4VarA = a();
            f4 f4VarA2 = aVar.a();
            return f4VarA != null ? f4VarA.equals(f4VarA2) : f4VarA2 == null;
        }

        public int hashCode() {
            int i3 = b() ? 79 : 97;
            f4 f4VarA = a();
            return ((i3 + 59) * 59) + (f4VarA == null ? 43 : f4VarA.hashCode());
        }

        public String toString() {
            return "ConsentFlowManager.FlowCompletionStatus(cmpPromptShown=" + b() + ", error=" + a() + ")";
        }

        public a(f4 f4Var) {
            this.f60128b = f4Var;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public f4 a() {
            return this.f60128b;
        }

        public void a(boolean z2) {
            this.f60127a = z2;
        }

        public void a(f4 f4Var) {
            this.f60128b = f4Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(a aVar);
    }

    public h4(com.applovin.impl.sdk.j jVar) {
        this.f60124a = jVar;
        this.f60125b = new m4(jVar);
    }

    public Uri g() {
        return d().getPrivacyPolicyUri();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public Uri h() {
        return d().getTermsOfServiceUri();
    }

    public boolean i() {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f63329u0;
        if (!jVar.y0()) {
            return false;
        }
        h4 h4VarU = jVar.u();
        List list = h4VarU.f60126c;
        if (h4VarU.f60125b.b()) {
            return true;
        }
        return list != null && list.size() > 0;
    }

    public boolean j() {
        Map<String, String> extraParameters = this.f60124a.f0().getExtraParameters();
        return extraParameters.containsKey("consent_flow_enabled") ? Boolean.parseBoolean(extraParameters.get("consent_flow_enabled")) : d().isEnabled();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (h() == null || !appLovinCommunicatorMessage.getMessageData().getBoolean("include_tos")) {
            this.f60126c = n4.a(this.f60124a);
        } else {
            this.f60126c = n4.b(this.f60124a);
        }
        if (this.f60126c.size() == 0) {
            yp.a("No Consent Flow Available", (String) null, this.f60124a.m0());
        } else {
            b(this.f60124a.m0(), new b() { // from class: com.applovin.impl.nx
                @Override // com.applovin.impl.h4.b
                public final void a(h4.a aVar) {
                    this.f62143a.a(aVar);
                }
            });
        }
    }

    public static TermsAndPrivacyPolicyFlowSettingsImpl a(Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to get default Terms and Privacy Policy flow settings.");
            return new TermsAndPrivacyPolicyFlowSettingsImpl(false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, null, null);
        }
        String strA = yp.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (com.applovin.impl.sdk.j) null);
        JSONObject jSONObject = JsonUtils.getJSONObject(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject(), "consent_flow_settings", new JSONObject());
        Boolean bool = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", Boolean.FALSE);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", null);
        Uri uri = URLUtil.isValidUrl(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", null);
        return new TermsAndPrivacyPolicyFlowSettingsImpl(bool.booleanValue(), a(string), URLUtil.isValidUrl(string3) ? Uri.parse(string3) : null, uri);
    }

    public Uri b() {
        return Uri.parse((String) this.f60124a.a(this.f60124a.z0() ? sj.p6 : sj.o6));
    }

    public JSONObject c() {
        TermsAndPrivacyPolicyFlowSettingsImpl termsAndPrivacyPolicyFlowSettingsImplD = d();
        Uri privacyPolicyUri = termsAndPrivacyPolicyFlowSettingsImplD.getPrivacyPolicyUri();
        Uri termsOfServiceUri = termsAndPrivacyPolicyFlowSettingsImplD.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "enabled", String.valueOf(j()));
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : "");
        JsonUtils.putString(jSONObject, "terms_of_service_url", termsOfServiceUri != null ? termsOfServiceUri.toString() : "");
        return jSONObject;
    }

    public TermsAndPrivacyPolicyFlowSettingsImpl d() {
        return (TermsAndPrivacyPolicyFlowSettingsImpl) this.f60124a.f0().getTermsAndPrivacyPolicyFlowSettings();
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography e() {
        return d().getDebugUserGeography();
    }

    public String f() {
        d();
        Object objG = g();
        Object objH = h();
        StringBuilder sb = new StringBuilder();
        sb.append("\nConsent Flow Enabled - ");
        sb.append(j());
        sb.append("\nPrivacy Policy - ");
        if (objG == null) {
            objG = "undefined";
        }
        sb.append(objG);
        sb.append("\nTerms of Service - ");
        if (objH == null) {
            objH = "undefined";
        }
        sb.append(objH);
        return sb.toString();
    }

    public void b(final Activity activity, final b bVar) {
        if (!j()) {
            bVar.a(new a(new f4(f4.f59629d, "Failed to start consent flow. Please make sure that the consent flow is enabled.")));
        } else if (CollectionUtils.isEmpty(this.f60126c)) {
            this.f60124a.b(uj.f64239o, Boolean.FALSE);
            bVar.a(new a(new f4(f4.f59628c, "User may not be eligible for flow.")));
        } else {
            a(activity, new Runnable() { // from class: com.applovin.impl.px
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62519a.a(activity, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i3) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    public void a() {
        if (j()) {
            this.f60124a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f60124a.I().a("AppLovinSdk", "Generating Consent Flow...");
            }
            this.f60126c = g4.c(this.f60124a);
        }
        if (yp.i(com.applovin.impl.sdk.j.m())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.m()).subscribe(this, "start_sdk_consent_flow");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i3) {
        tp.a(uri, com.applovin.impl.sdk.j.m(), this.f60124a);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        final Uri uriB = b();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.qx
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f62686a.a(uriB, dialogInterface, i3);
            }
        }).setNegativeButton("DISMISS", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.rx
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h4.b(uriB, dialogInterface, i3);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, a aVar) {
        if (aVar.f60128b != null) {
            if (aVar.f60128b.a() != f4.f59630e) {
                this.f60126c = null;
            }
        } else {
            this.f60124a.b(uj.f64239o, Boolean.FALSE);
            this.f60126c = null;
        }
        bVar.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, final b bVar) {
        this.f60124a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f60124a.I().a("ConsentFlowManager", "Starting consent flow with states: " + this.f60126c);
        }
        if (!this.f60124a.r0()) {
            this.f60124a.b(uj.f64239o, Boolean.TRUE);
        }
        this.f60125b.a(this.f60126c, activity, new b() { // from class: com.applovin.impl.ox
            @Override // com.applovin.impl.h4.b
            public final void a(h4.a aVar) {
                this.f62390a.a(bVar, aVar);
            }
        });
    }

    private void a(final Activity activity, Runnable runnable) {
        if (d().getPrivacyPolicyUri() != null) {
            runnable.run();
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61940a.a(activity);
                }
            });
        }
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography a(String str) {
        if ("gdpr".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        if ("other".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER;
        }
        return AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar) {
        AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.m()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }
}
