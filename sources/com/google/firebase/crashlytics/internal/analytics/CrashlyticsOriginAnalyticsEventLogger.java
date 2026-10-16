package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnalyticsConnector f88296a;

    public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector analyticsConnector) {
        this.f88296a = analyticsConnector;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void a(String str, Bundle bundle) {
        this.f88296a.b("clx", str, bundle);
    }
}
