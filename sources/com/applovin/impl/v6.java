package com.applovin.impl;

import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f64390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f64391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f64392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f64393d;

    public v6(Object obj, long j3) {
        this.f64391b = obj;
        this.f64390a = j3;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) obj;
            this.f64392c = bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null;
            this.f64393d = "AppLovin";
        } else if (obj instanceof fe) {
            fe feVar = (fe) obj;
            this.f64392c = feVar.getFormat().getLabel();
            this.f64393d = feVar.getNetworkName();
        }
    }

    public Object a() {
        return this.f64391b;
    }

    public long b() {
        return this.f64390a;
    }

    public String c() {
        String str = this.f64392c;
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public String d() {
        String str = this.f64393d;
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
