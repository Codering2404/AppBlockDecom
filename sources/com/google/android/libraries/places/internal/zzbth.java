package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbth extends zzbte {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbua f76850b;

    zzbth(zzbua zzbuaVar) {
        Objects.requireNonNull(zzbuaVar);
        this.f76850b = zzbuaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void d() {
        zzbua zzbuaVar = this.f76850b;
        ((zzbvn) zzbuaVar.A()).f76960b.f76971j.Y.a(zzbuaVar, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void e() {
        zzbua zzbuaVar = this.f76850b;
        ((zzbvn) zzbuaVar.A()).f76960b.f76971j.Y.a(zzbuaVar, false);
    }
}
