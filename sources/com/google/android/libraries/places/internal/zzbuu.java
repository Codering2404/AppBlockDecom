package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuu implements zzbwc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvr f76927a;

    /* synthetic */ zzbuu(zzbvr zzbvrVar, byte[] bArr) {
        Objects.requireNonNull(zzbvrVar);
        this.f76927a = zzbvrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void a(zzbnp zzbnpVar) {
        Preconditions.A(this.f76927a.u().get(), "Channel must have been shut down");
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zzc(boolean z2) {
        zzbvr zzbvrVar = this.f76927a;
        zzbvrVar.Y.a(zzbvrVar.s(), z2);
        if (z2) {
            zzbvrVar.X();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zze() {
        zzbvr zzbvrVar = this.f76927a;
        Preconditions.A(zzbvrVar.u().get(), "Channel must have been shut down");
        zzbvrVar.y(true);
        zzbvrVar.c0(false);
        zzbvrVar.b0();
        zzbvrVar.j0();
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zzb() {
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final zzbio b(zzbio zzbioVar) {
        return zzbioVar;
    }
}
