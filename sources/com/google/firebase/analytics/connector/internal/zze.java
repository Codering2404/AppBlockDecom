package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zze implements zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f87686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f87687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppMeasurementSdk f87688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzd f87689d;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f87687b = analyticsConnectorListener;
        this.f87688c = appMeasurementSdk;
        zzd zzdVar = new zzd(this);
        this.f87689d = zzdVar;
        appMeasurementSdk.f(zzdVar);
        this.f87686a = new HashSet();
    }

    final /* synthetic */ AnalyticsConnector.AnalyticsConnectorListener a() {
        return this.f87687b;
    }
}
