package com.google.android.libraries.places.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f78541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzrv f78542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Runnable f78543c;

    zzsb(Ref.ObjectRef objectRef, zzrv zzrvVar, Runnable runnable) {
        this.f78541a = objectRef;
        this.f78542b = zzrvVar;
        this.f78543c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (((zzsh) this.f78541a.f140144a) != null) {
            throw null;
        }
        zzrv zzrvVar = this.f78542b;
        Intrinsics.checkNotNull(zzrvVar, "null cannot be cast to non-null type com.google.apps.tiktok.tracing.Trace");
        Runnable runnable = this.f78543c;
        zzrv zzrvVarC = zzrh.c(zzrh.d(), zzrvVar);
        try {
            runnable.run();
            Unit unit = Unit.f139807a;
        } finally {
        }
    }

    public final String toString() {
        Runnable runnable = this.f78543c;
        StringBuilder sb = new StringBuilder(runnable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(runnable);
        sb.append("]");
        return sb.toString();
    }
}
