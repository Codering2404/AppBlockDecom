package com.google.android.libraries.places.internal;

import android.os.Build;
import android.os.Trace;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayDeque;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f78505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final zzqs f78506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap f78507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzrg f78508d;

    static {
        ImmutableSet.E("androidx.fragment.app.FragmentViewLifecycleOwner.handleLifecycleEvent", "com.google.android.libraries.logging.logger.transmitters.clearcut", "com.google.android.libraries.performance.primes.transmitter.clearcut", "com.google.android.libraries.performance.primes.metrics.crash.CrashMetricServiceImpl", "com.google.android.libraries.performance.primes.metrics.crash.applicationexit.ApplicationExitMetricServiceImpl");
        f78505a = new AtomicReference(ImmutableSet.z());
        f78506b = new zzqs("tiktok_systrace");
        f78507c = new WeakHashMap();
        f78508d = new zzrg();
        new ArrayDeque();
        new ArrayDeque();
    }

    static ImmutableSet a() {
        return (ImmutableSet) f78505a.get();
    }

    static zzrv b(boolean z2) {
        zzrt zzrtVarD = d();
        zzrv zzrvVar = zzrtVarD.f78537b;
        return (zzrvVar == null || zzrvVar == zzrl.f78513g) ? zzrk.b(zzrtVarD) : zzrvVar;
    }

    public static zzrv c(zzrt zzrtVar, zzrv zzrvVar) {
        zzrv zzrvVar2;
        zzse zzseVar = zzrtVar.f78538c;
        zzrv zzrvVar3 = zzrtVar.f78537b;
        if (zzrvVar3 != zzrvVar) {
            if (zzrvVar3 == null) {
                zzrtVar.f78536a = Build.VERSION.SDK_INT >= 29 ? Trace.isEnabled() : zzqu.a(f78506b);
            }
            if (zzrtVar.f78536a) {
                if (zzrvVar3 != null) {
                    zzrvVar2 = zzrvVar != null ? zzrvVar : null;
                    zzru.b(zzrvVar3);
                } else {
                    zzrvVar2 = zzrvVar;
                }
                if (zzrvVar2 != null) {
                    zzru.a(zzrvVar2);
                }
            }
            if (zzrvVar3 != zzrvVar) {
                if (zzrvVar == null) {
                    zzrvVar = null;
                }
                zzrtVar.f78537b = zzrvVar;
                return zzrvVar3;
            }
        }
        return zzrvVar;
    }

    public static zzrt d() {
        return (zzrt) f78508d.get();
    }

    public static boolean e() {
        zzrv zzrvVar = d().f78537b;
        return (zzrvVar == null || zzrvVar == zzrl.f78513g) ? false : true;
    }
}
