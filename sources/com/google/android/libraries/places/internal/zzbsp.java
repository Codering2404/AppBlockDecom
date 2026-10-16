package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzbsp extends zzbmy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbmy f76799b;

    zzbsp(zzbmy zzbmyVar) {
        Preconditions.u(zzbmyVar, "delegate can not be null");
        this.f76799b = zzbmyVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final String a() {
        return this.f76799b.a();
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public void b(zzbmu zzbmuVar) {
        this.f76799b.b(zzbmuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public void c() {
        this.f76799b.c();
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void d() {
        this.f76799b.d();
    }

    public final String toString() {
        return MoreObjects.c(this).d("delegate", this.f76799b).toString();
    }
}
