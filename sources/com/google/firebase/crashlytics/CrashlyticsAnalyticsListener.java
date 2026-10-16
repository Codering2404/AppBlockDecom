package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnalyticsEventReceiver f88261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnalyticsEventReceiver f88262b;

    CrashlyticsAnalyticsListener() {
    }

    private static void b(AnalyticsEventReceiver analyticsEventReceiver, String str, Bundle bundle) {
        if (analyticsEventReceiver == null) {
            return;
        }
        analyticsEventReceiver.onEvent(str, bundle);
    }

    private void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.f88261a : this.f88262b, str, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void a(int i3, Bundle bundle) {
        String string;
        Logger.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i3), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public void d(AnalyticsEventReceiver analyticsEventReceiver) {
        this.f88262b = analyticsEventReceiver;
    }

    public void e(AnalyticsEventReceiver analyticsEventReceiver) {
        this.f88261a = analyticsEventReceiver;
    }
}
