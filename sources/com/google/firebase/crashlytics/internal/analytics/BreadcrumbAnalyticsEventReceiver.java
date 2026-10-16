package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BreadcrumbHandler f88295a;

    private static String b(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public void a(BreadcrumbHandler breadcrumbHandler) {
        this.f88295a = breadcrumbHandler;
        Logger.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String str, Bundle bundle) {
        BreadcrumbHandler breadcrumbHandler = this.f88295a;
        if (breadcrumbHandler != null) {
            try {
                breadcrumbHandler.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                Logger.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
