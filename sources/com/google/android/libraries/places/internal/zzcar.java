package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcar extends zzcaw {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcat f77346b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcar(zzcat zzcatVar, zzccy zzccyVar) {
        super(zzccyVar);
        Objects.requireNonNull(zzcatVar);
        this.f77346b = zzcatVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcaw, com.google.android.libraries.places.internal.zzccy
    public final void G(int i3, zzccv zzccvVar) {
        zzcat zzcatVar = this.f77346b;
        zzcatVar.n(zzcatVar.m() + 1);
        super.G(i3, zzccvVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcaw, com.google.android.libraries.places.internal.zzccy
    public final void L0(boolean z2, int i3, int i4) {
        if (z2) {
            zzcat zzcatVar = this.f77346b;
            zzcatVar.n(zzcatVar.m() + 1);
        }
        super.L0(z2, i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzcaw, com.google.android.libraries.places.internal.zzccy
    public final void v2(zzcdk zzcdkVar) {
        zzcat zzcatVar = this.f77346b;
        zzcatVar.n(zzcatVar.m() + 1);
        super.v2(zzcdkVar);
    }
}
