package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzbzy f77310c = new zzbzy(new zzbzu());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IdentityHashMap f77311a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f77312b;

    zzbzy(zzbzu zzbzuVar) {
    }

    public static Object a(zzbzx zzbzxVar) {
        return f77310c.c(zzbzxVar);
    }

    public static Object b(zzbzx zzbzxVar, Object obj) {
        f77310c.d(zzbzxVar, obj);
        return null;
    }

    final synchronized Object c(zzbzx zzbzxVar) {
        zzbzw zzbzwVar;
        try {
            IdentityHashMap identityHashMap = this.f77311a;
            zzbzwVar = (zzbzw) identityHashMap.get(zzbzxVar);
            if (zzbzwVar == null) {
                zzbzwVar = new zzbzw(zzbzxVar.zzb());
                identityHashMap.put(zzbzxVar, zzbzwVar);
            }
            ScheduledFuture scheduledFuture = zzbzwVar.f77309c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                zzbzwVar.f77309c = null;
            }
            zzbzwVar.f77308b++;
        } catch (Throwable th) {
            throw th;
        }
        return zzbzwVar.f77307a;
    }

    final synchronized Object d(zzbzx zzbzxVar, Object obj) {
        try {
            zzbzw zzbzwVar = (zzbzw) this.f77311a.get(zzbzxVar);
            if (zzbzwVar == null) {
                throw new IllegalArgumentException("No cached instance found for ".concat(String.valueOf(zzbzxVar)));
            }
            Preconditions.e(obj == zzbzwVar.f77307a, "Releasing the wrong instance");
            Preconditions.A(zzbzwVar.f77308b > 0, "Refcount has already reached zero");
            int i3 = zzbzwVar.f77308b - 1;
            zzbzwVar.f77308b = i3;
            if (i3 == 0) {
                Preconditions.A(zzbzwVar.f77309c == null, "Destroy task already scheduled");
                if (this.f77312b == null) {
                    this.f77312b = Executors.newSingleThreadScheduledExecutor(zzbsz.d("grpc-shared-destroyer-%d", true));
                }
                zzbzwVar.f77309c = this.f77312b.schedule(new zzbuf(new zzbzv(this, zzbzwVar, zzbzxVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }

    final /* synthetic */ IdentityHashMap e() {
        return this.f77311a;
    }

    final /* synthetic */ ScheduledExecutorService f() {
        return this.f77312b;
    }

    final /* synthetic */ void g(ScheduledExecutorService scheduledExecutorService) {
        this.f77312b = null;
    }
}
