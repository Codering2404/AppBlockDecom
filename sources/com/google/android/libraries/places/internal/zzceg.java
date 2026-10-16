package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzceg extends zzbkc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzceh f77708b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzceg(zzceh zzcehVar, zzbix zzbixVar) {
        super(zzbixVar);
        Objects.requireNonNull(zzcehVar);
        this.f77708b = zzcehVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbkd, com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, zzbmg zzbmgVar) {
        zzbmgVar.f(this.f77708b.b());
        f().a(zzbiwVar, zzbmgVar);
    }
}
