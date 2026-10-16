package com.google.android.libraries.places.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzrw f78539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f78540b;

    zzsa(zzrw zzrwVar, Runnable runnable) {
        this.f78539a = zzrwVar;
        this.f78540b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzrw zzrwVar = this.f78539a;
        Intrinsics.checkNotNull(zzrwVar, "null cannot be cast to non-null type com.google.apps.tiktok.tracing.Trace");
        zzrv zzrvVarC = zzrh.c(zzrh.d(), (zzrv) zzrwVar);
        try {
            this.f78540b.run();
            Unit unit = Unit.f139807a;
        } finally {
        }
    }

    public final String toString() {
        Runnable runnable = this.f78540b;
        StringBuilder sb = new StringBuilder(runnable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(runnable);
        sb.append("]");
        return sb.toString();
    }
}
