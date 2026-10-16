package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbus extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbiw f76918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbnp f76919c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbus(zzbut zzbutVar, zzbiw zzbiwVar, zzbnp zzbnpVar) {
        super(zzbutVar.g());
        this.f76918b = zzbiwVar;
        this.f76919c = zzbnpVar;
        Objects.requireNonNull(zzbutVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        this.f76918b.c(this.f76919c, new zzbmg());
    }
}
