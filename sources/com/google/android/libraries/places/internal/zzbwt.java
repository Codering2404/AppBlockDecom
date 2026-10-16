package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwt implements zzblo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbxb f77108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbxc f77109b;

    /* synthetic */ zzbwt(zzbxc zzbxcVar, byte[] bArr) {
        Objects.requireNonNull(zzbxcVar);
        this.f77109b = zzbxcVar;
    }

    @Override // com.google.android.libraries.places.internal.zzblo
    public final void a(zzbjo zzbjoVar) {
        zzbxc zzbxcVar = this.f77109b;
        if (zzbxcVar.m()) {
            zzbxc.f77128s.logp(Level.WARNING, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Ignoring health status {0} for subchannel {1} as this is not under a petiole policy", new Object[]{zzbjoVar, this.f77108a.f()});
            return;
        }
        zzbxc.f77128s.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Received health status {0} for subchannel {1}", new Object[]{zzbjoVar, this.f77108a.f()});
        this.f77108a.i(zzbjoVar);
        if (zzbxcVar.k().a()) {
            if (this.f77108a == zzbxcVar.j().get(zzbxcVar.k().d())) {
                zzbxcVar.g(this.f77108a);
            }
        }
    }

    final /* synthetic */ void b(zzbxb zzbxbVar) {
        this.f77108a = zzbxbVar;
    }
}
