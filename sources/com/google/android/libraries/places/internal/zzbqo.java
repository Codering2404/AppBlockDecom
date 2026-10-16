package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqo extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbiw f76658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final zzbnp f76659c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbqo(zzbqu zzbquVar, zzbiw zzbiwVar, zzbnp zzbnpVar) {
        super(zzbquVar.j());
        Objects.requireNonNull(zzbquVar);
        this.f76658b = zzbiwVar;
        this.f76659c = zzbnpVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        this.f76658b.c(this.f76659c, new zzbmg());
    }
}
