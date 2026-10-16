package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxf extends zzbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbli f77146a;

    zzbxf(zzbli zzbliVar) {
        this.f77146a = (zzbli) Preconditions.u(zzbliVar, "result");
    }

    @Override // com.google.android.libraries.places.internal.zzbln
    public final zzbli a(zzblj zzbljVar) {
        return this.f77146a;
    }

    public final String toString() {
        return MoreObjects.b(zzbxf.class).d("result", this.f77146a).toString();
    }
}
