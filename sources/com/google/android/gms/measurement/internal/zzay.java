package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzay {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Handler f73449d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzjg f73450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f73451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f73452c;

    zzay(zzjg zzjgVar) {
        Preconditions.m(zzjgVar);
        this.f73450a = zzjgVar;
        this.f73451b = new zzax(this, zzjgVar);
    }

    private final Handler f() {
        Handler handler;
        if (f73449d != null) {
            return f73449d;
        }
        synchronized (zzay.class) {
            try {
                if (f73449d == null) {
                    f73449d = new com.google.android.gms.internal.measurement.zzcn(this.f73450a.d().getMainLooper());
                }
                handler = f73449d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public abstract void a();

    public final void b(long j3) {
        d();
        if (j3 >= 0) {
            zzjg zzjgVar = this.f73450a;
            this.f73452c = zzjgVar.e().currentTimeMillis();
            if (f().postDelayed(this.f73451b, j3)) {
                return;
            }
            zzjgVar.a().o().b("Failed to schedule delayed post. time", Long.valueOf(j3));
        }
    }

    public final boolean c() {
        return this.f73452c != 0;
    }

    final void d() {
        this.f73452c = 0L;
        f().removeCallbacks(this.f73451b);
    }

    final /* synthetic */ void e(long j3) {
        this.f73452c = 0L;
    }
}
