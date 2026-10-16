package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgw f73743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f73744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f73745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f73746d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f73747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f73748g;

    /* synthetic */ zzgx(String str, zzgw zzgwVar, int i3, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        Preconditions.m(zzgwVar);
        this.f73743a = zzgwVar;
        this.f73744b = i3;
        this.f73745c = th;
        this.f73746d = bArr;
        this.f73747f = str;
        this.f73748g = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f73743a.a(this.f73747f, this.f73744b, this.f73745c, this.f73746d, this.f73748g);
    }
}
