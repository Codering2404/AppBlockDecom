package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzg implements zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f87691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppMeasurementSdk f87692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzf f87693c;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f87691a = analyticsConnectorListener;
        this.f87692b = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.f87693c = zzfVar;
        appMeasurementSdk.f(zzfVar);
    }

    final /* synthetic */ AnalyticsConnector.AnalyticsConnectorListener a() {
        return this.f87691a;
    }
}
