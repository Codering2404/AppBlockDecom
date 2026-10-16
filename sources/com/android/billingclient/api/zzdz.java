package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f57591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BillingResult f57592b;

    public zzdz(BillingResult billingResult, List list) {
        this.f57591a = list;
        this.f57592b = billingResult;
    }

    public final BillingResult a() {
        return this.f57592b;
    }

    public final List b() {
        return this.f57591a;
    }
}
