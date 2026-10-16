package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f74379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f74380b;

    public zzog(Clock clock) {
        Preconditions.m(clock);
        this.f74379a = clock;
    }

    public final void a() {
        this.f74380b = this.f74379a.a();
    }

    public final void b() {
        this.f74380b = 0L;
    }

    public final boolean c(long j3) {
        return this.f74380b == 0 || this.f74379a.a() - this.f74380b >= 3600000;
    }
}
