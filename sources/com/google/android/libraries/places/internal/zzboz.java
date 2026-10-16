package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzboz implements zzbpq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbpq f76579a;

    zzboz(zzbpq zzbpqVar, zzbip zzbipVar, Executor executor) {
        this.f76579a = (zzbpq) Preconditions.u(zzbpqVar, "delegate");
    }

    @Override // com.google.android.libraries.places.internal.zzbpq, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f76579a.close();
    }

    @Override // com.google.android.libraries.places.internal.zzbpq
    public final zzbqa l1(SocketAddress socketAddress, zzbpp zzbppVar, zzbiv zzbivVar) {
        return new zzboy(this, this.f76579a.l1(socketAddress, zzbppVar, zzbivVar), zzbppVar.a());
    }

    @Override // com.google.android.libraries.places.internal.zzbpq
    public final ScheduledExecutorService zzb() {
        return this.f76579a.zzb();
    }
}
