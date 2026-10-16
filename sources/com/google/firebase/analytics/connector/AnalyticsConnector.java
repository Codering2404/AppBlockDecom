package com.google.firebase.analytics.connector;

import android.os.Bundle;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface AnalyticsConnector {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AnalyticsConnectorHandle {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AnalyticsConnectorListener {
        void a(int i3, Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ConditionalUserProperty {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f87657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f87658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f87659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f87660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f87661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f87662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f87663g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f87664h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Bundle f87665i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f87666j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f87667k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Bundle f87668l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f87669m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f87670n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f87671o;
    }

    void a(ConditionalUserProperty conditionalUserProperty);

    void b(String str, String str2, Bundle bundle);

    void c(String str, String str2, Object obj);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    Map d(boolean z2);

    int e(String str);

    List f(String str, String str2);

    AnalyticsConnectorHandle g(String str, AnalyticsConnectorListener analyticsConnectorListener);
}
