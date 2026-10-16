package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtr extends zzbsl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbpl f76866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbts f76867b;

    zzbtr(zzbts zzbtsVar, zzbpl zzbplVar) {
        this.f76866a = zzbplVar;
        Objects.requireNonNull(zzbtsVar);
        this.f76867b = zzbtsVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbsl, com.google.android.libraries.places.internal.zzbpl
    public final void a(zzbpn zzbpnVar) {
        this.f76867b.f().a();
        this.f76866a.a(new zzbtq(this, zzbpnVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbsl
    protected final zzbpl d() {
        return this.f76866a;
    }
}
