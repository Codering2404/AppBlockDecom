package com.google.android.libraries.places.internal;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuz extends zzblg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    zzboq f76933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbvr f76934b;

    /* synthetic */ zzbuz(zzbvr zzbvrVar, byte[] bArr) {
        Objects.requireNonNull(zzbvrVar);
        this.f76934b = zzbvrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final /* bridge */ /* synthetic */ zzblm a(zzbld zzbldVar) {
        zzbvr zzbvrVar = this.f76934b;
        zzbvrVar.f77001n.b();
        Preconditions.A(!zzbvrVar.x(), "Channel is being terminated");
        return new zzbvp(zzbvrVar, zzbldVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final void c() {
        zzbnx zzbnxVar = this.f76934b.f77001n;
        zzbnxVar.b();
        zzbnxVar.a(new zzbuy(this));
        zzbnxVar.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final zzbnx d() {
        return this.f76934b.f77001n;
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final ScheduledExecutorService e() {
        return this.f76934b.p0();
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final void b(zzbjn zzbjnVar, zzbln zzblnVar) {
        zzbvr zzbvrVar = this.f76934b;
        zzbvrVar.f77001n.b();
        Preconditions.u(zzbjnVar, "newState");
        Preconditions.u(zzblnVar, "newPicker");
        if (this != zzbvrVar.m() || zzbvrVar.n()) {
            return;
        }
        zzbvrVar.h0(zzblnVar);
        if (zzbjnVar != zzbjn.SHUTDOWN) {
            zzbvrVar.D().b(2, QgXempTBEfV.cnXAHBjFckEZ, zzbjnVar, zzblnVar);
            zzbvrVar.i().a(zzbjnVar);
        }
    }
}
