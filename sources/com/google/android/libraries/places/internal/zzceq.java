package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzceq extends zzcem {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzces f77726f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzceq(zzces zzcesVar, Object obj, zzble zzbleVar) {
        super(zzcesVar, obj, zzbleVar);
        Objects.requireNonNull(zzcesVar);
        this.f77726f = zzcesVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcem
    protected final zzcel a() {
        return new zzcep(this);
    }
}
