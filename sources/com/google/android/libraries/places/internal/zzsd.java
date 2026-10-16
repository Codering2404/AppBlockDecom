package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzrv f78545a;

    private zzsd(zzrv zzrvVar) {
        this.f78545a = zzrvVar;
    }

    public static zzsd a() {
        return new zzsd(zzrh.b(false));
    }

    public static Runnable b(zzsd zzsdVar, Runnable runnable) {
        zzrv trace = zzsdVar.f78545a;
        Preconditions.u(trace, "Trying to propagate null trace");
        int i3 = zzsc.f78544a;
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new zzsa(trace, runnable);
    }

    public final String toString() {
        return this.f78545a.toString();
    }
}
