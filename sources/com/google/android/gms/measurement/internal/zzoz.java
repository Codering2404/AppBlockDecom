package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzoz implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzr f74412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzpg f74413b;

    zzoz(zzpg zzpgVar, zzr zzrVar) {
        this.f74412a = zzrVar;
        Objects.requireNonNull(zzpgVar);
        this.f74413b = zzpgVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzr zzrVar = this.f74412a;
        String str = (String) Preconditions.m(zzrVar.f74500a);
        zzpg zzpgVar = this.f74413b;
        zzjl zzjlVarG = zzpgVar.g(str);
        zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
        if (zzjlVarG.o(zzjkVar) && zzjl.f(zzrVar.f74518t, 100).o(zzjkVar)) {
            return zzpgVar.o0(zzrVar).p0();
        }
        zzpgVar.a().w().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
