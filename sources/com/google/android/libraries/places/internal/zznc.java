package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznc implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaoc f78240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzne f78241b;

    zznc(zzne zzneVar, zzaoc zzaocVar) {
        this.f78240a = zzaocVar;
        Objects.requireNonNull(zzneVar);
        this.f78241b = zzneVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        this.f78241b.c(this.f78240a);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        if (!str.isEmpty()) {
            zzaoc zzaocVar = this.f78240a;
            zzbhk zzbhkVarG = zzbhl.G();
            zzbhkVarG.y(str);
            zzaocVar.J(zzbhkVarG);
        }
        this.f78241b.c(this.f78240a);
    }
}
