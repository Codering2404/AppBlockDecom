package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzpg f74428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f74429b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f74430c = d();

    public zzpe(zzpg zzpgVar) {
        this.f74428a = zzpgVar;
    }

    private final long d() {
        zzpg zzpgVar = this.f74428a;
        Preconditions.m(zzpgVar);
        long jLongValue = ((Long) zzfy.f73673v.b(null)).longValue();
        long jLongValue2 = ((Long) zzfy.f73675w.b(null)).longValue();
        for (int i3 = 1; i3 < this.f74429b; i3++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        return zzpgVar.e().currentTimeMillis() + Math.min(jLongValue, jLongValue2);
    }

    public final void a() {
        this.f74429b++;
        this.f74430c = d();
    }

    public final boolean b() {
        return this.f74428a.e().currentTimeMillis() >= this.f74430c;
    }

    final /* synthetic */ long c() {
        return this.f74430c;
    }
}
