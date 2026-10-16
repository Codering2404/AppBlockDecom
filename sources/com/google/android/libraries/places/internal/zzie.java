package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzie implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettableFuture f77947a;

    zzie(zzja zzjaVar, SettableFuture settableFuture) {
        this.f77947a = settableFuture;
        Objects.requireNonNull(zzjaVar);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        com.google.android.libraries.places.api.auth.zza zzaVarD = com.google.android.libraries.places.api.auth.zzb.d();
        zzaVarD.a(true);
        zzaVarD.b("eyJlcnJvciI6IlVOS05PV05fRVJST1IifQ==");
        zzaVarD.c(th.getMessage());
        this.f77947a.B(zzaVarD.d());
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        com.google.android.libraries.places.api.auth.zza zzaVarD = com.google.android.libraries.places.api.auth.zzb.d();
        zzaVarD.a(true);
        zzaVarD.b((String) obj);
        zzaVarD.c(null);
        this.f77947a.B(zzaVarD.d());
    }
}
