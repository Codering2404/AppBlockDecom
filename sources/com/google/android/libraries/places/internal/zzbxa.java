package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxa extends zzbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbxc f77121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f77122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbxc f77123c;

    zzbxa(zzbxc zzbxcVar, zzbxc zzbxcVar2) {
        Objects.requireNonNull(zzbxcVar);
        this.f77123c = zzbxcVar;
        this.f77122b = new AtomicBoolean(false);
        this.f77121a = (zzbxc) Preconditions.u(zzbxcVar2, "pickFirstLeafLoadBalancer");
    }

    @Override // com.google.android.libraries.places.internal.zzbln
    public final zzbli a(zzblj zzbljVar) {
        if (this.f77122b.compareAndSet(false, true)) {
            zzbxc zzbxcVar = this.f77123c;
            final zzbxc zzbxcVar2 = this.f77121a;
            zzbnx zzbnxVarD = zzbxcVar.i().d();
            Objects.requireNonNull(zzbxcVar2);
            zzbnxVarD.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbwz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzbxcVar2.d();
                }
            });
            zzbnxVarD.zza();
        }
        return zzbli.d();
    }
}
