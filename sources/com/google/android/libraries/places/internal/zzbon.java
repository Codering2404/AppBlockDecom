package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f76556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzboo f76557b;

    /* synthetic */ zzbon(zzboo zzbooVar, long j3, byte[] bArr) {
        Objects.requireNonNull(zzbooVar);
        this.f76557b = zzbooVar;
        this.f76556a = j3;
    }

    public final void a() {
        zzboo zzbooVar = this.f76557b;
        AtomicLong atomicLongD = zzbooVar.d();
        long j3 = this.f76556a;
        long jMax = Math.max(j3 + j3, j3);
        if (atomicLongD.compareAndSet(j3, jMax)) {
            String strC = zzbooVar.c();
            zzboo.f76558c.logp(Level.WARNING, "io.grpc.internal.AtomicBackoff$State", "backoff", "Increased {0} to {1}", new Object[]{strC, Long.valueOf(jMax)});
        }
    }
}
