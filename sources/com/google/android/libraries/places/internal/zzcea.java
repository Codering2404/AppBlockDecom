package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.AbstractFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcea extends AbstractFuture {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbix f77695i;

    zzcea(zzbix zzbixVar) {
        this.f77695i = zzbixVar;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final boolean B(Object obj) {
        return super.B(obj);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final boolean C(Throwable th) {
        return super.C(th);
    }

    final /* synthetic */ zzbix F() {
        return this.f77695i;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void w() {
        this.f77695i.e("GrpcFuture was cancelled", null);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final String y() {
        return MoreObjects.c(this).d("clientCall", this.f77695i).toString();
    }
}
