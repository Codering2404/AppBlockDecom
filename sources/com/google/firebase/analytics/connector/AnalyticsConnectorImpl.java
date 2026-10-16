package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjh;
import com.google.android.gms.measurement.internal.zzlt;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile AnalyticsConnector f87672c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AppMeasurementSdk f87673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f87674b;

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.m(appMeasurementSdk);
        this.f87673a = appMeasurementSdk;
        this.f87674b = new ConcurrentHashMap();
    }

    public static AnalyticsConnector h(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.m(firebaseApp);
        Preconditions.m(context);
        Preconditions.m(subscriber);
        Preconditions.m(context.getApplicationContext());
        if (f87672c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (f87672c == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.w()) {
                            subscriber.b(DataCollectionDefaultChange.class, zzb.f87695a, zza.f87694a);
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.v());
                        }
                        f87672c = new AnalyticsConnectorImpl(zzfb.zza(context, bundle).zzb());
                    }
                } finally {
                }
            }
        }
        return f87672c;
    }

    static /* synthetic */ void i(Event event) {
        boolean z2 = ((DataCollectionDefaultChange) event.a()).f87589a;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.m(f87672c)).f87673a.i(z2);
        }
    }

    private final boolean j(String str) {
        if (str.isEmpty()) {
            return false;
        }
        Map map = this.f87674b;
        return map.containsKey(str) && map.get(str) != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i3 = zzc.f87684g;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.f87657a) == null || str.isEmpty()) {
            return;
        }
        Object obj = conditionalUserProperty.f87659c;
        if ((obj == null || zzlt.b(obj) != null) && zzc.a(str) && zzc.d(str, conditionalUserProperty.f87658b)) {
            String str2 = conditionalUserProperty.f87667k;
            if (str2 == null || (zzc.b(str2, conditionalUserProperty.f87668l) && zzc.e(str, conditionalUserProperty.f87667k, conditionalUserProperty.f87668l))) {
                String str3 = conditionalUserProperty.f87664h;
                if (str3 == null || (zzc.b(str3, conditionalUserProperty.f87665i) && zzc.e(str, conditionalUserProperty.f87664h, conditionalUserProperty.f87665i))) {
                    String str4 = conditionalUserProperty.f87662f;
                    if (str4 == null || (zzc.b(str4, conditionalUserProperty.f87663g) && zzc.e(str, conditionalUserProperty.f87662f, conditionalUserProperty.f87663g))) {
                        AppMeasurementSdk appMeasurementSdk = this.f87673a;
                        Bundle bundle = new Bundle();
                        String str5 = conditionalUserProperty.f87657a;
                        if (str5 != null) {
                            bundle.putString("origin", str5);
                        }
                        String str6 = conditionalUserProperty.f87658b;
                        if (str6 != null) {
                            bundle.putString("name", str6);
                        }
                        Object obj2 = conditionalUserProperty.f87659c;
                        if (obj2 != null) {
                            zzjh.a(bundle, obj2);
                        }
                        String str7 = conditionalUserProperty.f87660d;
                        if (str7 != null) {
                            bundle.putString("trigger_event_name", str7);
                        }
                        bundle.putLong("trigger_timeout", conditionalUserProperty.f87661e);
                        String str8 = conditionalUserProperty.f87662f;
                        if (str8 != null) {
                            bundle.putString("timed_out_event_name", str8);
                        }
                        Bundle bundle2 = conditionalUserProperty.f87663g;
                        if (bundle2 != null) {
                            bundle.putBundle("timed_out_event_params", bundle2);
                        }
                        String str9 = conditionalUserProperty.f87664h;
                        if (str9 != null) {
                            bundle.putString("triggered_event_name", str9);
                        }
                        Bundle bundle3 = conditionalUserProperty.f87665i;
                        if (bundle3 != null) {
                            bundle.putBundle("triggered_event_params", bundle3);
                        }
                        bundle.putLong("time_to_live", conditionalUserProperty.f87666j);
                        String str10 = conditionalUserProperty.f87667k;
                        if (str10 != null) {
                            bundle.putString("expired_event_name", str10);
                        }
                        Bundle bundle4 = conditionalUserProperty.f87668l;
                        if (bundle4 != null) {
                            bundle.putBundle("expired_event_params", bundle4);
                        }
                        bundle.putLong("creation_timestamp", conditionalUserProperty.f87669m);
                        bundle.putBoolean("active", conditionalUserProperty.f87670n);
                        bundle.putLong("triggered_timestamp", conditionalUserProperty.f87671o);
                        appMeasurementSdk.g(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.a(str) && zzc.b(str2, bundle) && zzc.e(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.f87673a.e(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void c(String str, String str2, Object obj) {
        if (zzc.a(str) && zzc.d(str, str2)) {
            this.f87673a.h(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.b(str2, bundle)) {
            this.f87673a.a(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map d(boolean z2) {
        return this.f87673a.d(null, null, z2);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int e(String str) {
        return this.f87673a.c(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List f(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.f87673a.b(str, str2)) {
            int i3 = zzc.f87684g;
            Preconditions.m(bundle);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.f87657a = (String) Preconditions.m((String) zzjh.b(bundle, "origin", String.class, null));
            conditionalUserProperty.f87658b = (String) Preconditions.m((String) zzjh.b(bundle, "name", String.class, null));
            conditionalUserProperty.f87659c = zzjh.b(bundle, "value", Object.class, null);
            conditionalUserProperty.f87660d = (String) zzjh.b(bundle, "trigger_event_name", String.class, null);
            conditionalUserProperty.f87661e = ((Long) zzjh.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            conditionalUserProperty.f87662f = (String) zzjh.b(bundle, "timed_out_event_name", String.class, null);
            conditionalUserProperty.f87663g = (Bundle) zzjh.b(bundle, "timed_out_event_params", Bundle.class, null);
            conditionalUserProperty.f87664h = (String) zzjh.b(bundle, "triggered_event_name", String.class, null);
            conditionalUserProperty.f87665i = (Bundle) zzjh.b(bundle, "triggered_event_params", Bundle.class, null);
            conditionalUserProperty.f87666j = ((Long) zzjh.b(bundle, "time_to_live", Long.class, 0L)).longValue();
            conditionalUserProperty.f87667k = (String) zzjh.b(bundle, "expired_event_name", String.class, null);
            conditionalUserProperty.f87668l = (Bundle) zzjh.b(bundle, "expired_event_params", Bundle.class, null);
            conditionalUserProperty.f87670n = ((Boolean) zzjh.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.f87669m = ((Long) zzjh.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            conditionalUserProperty.f87671o = ((Long) zzjh.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle g(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.m(analyticsConnectorListener);
        if (zzc.a(str) && !j(str)) {
            AppMeasurementSdk appMeasurementSdk = this.f87673a;
            com.google.firebase.analytics.connector.internal.zza zzeVar = "fiam".equals(str) ? new zze(appMeasurementSdk, analyticsConnectorListener) : "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
            if (zzeVar != null) {
                this.f87674b.put(str, zzeVar);
                return new AnalyticsConnector.AnalyticsConnectorHandle(this) { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AnalyticsConnectorImpl f87676b;

                    {
                        Objects.requireNonNull(this);
                        this.f87676b = this;
                    }
                };
            }
        }
        return null;
    }
}
