package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpe implements Runnable, zzbjp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f76589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f76590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f76591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ScheduledFuture f76592d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f76593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzbpk f76594g;

    zzbpe(zzbpk zzbpkVar, zzbjv zzbjvVar, boolean z2) {
        Objects.requireNonNull(zzbpkVar);
        this.f76594g = zzbpkVar;
        this.f76589a = z2;
        if (zzbjvVar == null) {
            this.f76590b = false;
            this.f76591c = 0L;
        } else {
            this.f76590b = true;
            this.f76591c = zzbjvVar.c(TimeUnit.NANOSECONDS);
        }
    }

    final void a() {
        if (this.f76593f) {
            return;
        }
        if (this.f76590b && !this.f76589a) {
            zzbpk zzbpkVar = this.f76594g;
            if (zzbpkVar.p() != null) {
                this.f76592d = zzbpkVar.p().schedule(new zzbuf(this), this.f76591c, TimeUnit.NANOSECONDS);
            }
        }
        zzbpk zzbpkVar2 = this.f76594g;
        zzbpkVar2.l().d(this, MoreExecutors.a());
        if (this.f76593f) {
            b();
        }
    }

    final void b() {
        this.f76593f = true;
        ScheduledFuture scheduledFuture = this.f76592d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    final zzbnp c() {
        long j3 = this.f76591c;
        long jAbs = Math.abs(j3);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit.toNanos(1L);
        long jAbs2 = Math.abs(j3) % timeUnit.toNanos(1L);
        StringBuilder sb = new StringBuilder();
        sb.append(true != this.f76589a ? "CallOptions" : "Context");
        sb.append(" deadline exceeded after ");
        if (j3 < 0) {
            sb.append('-');
        }
        sb.append(nanos);
        Locale locale = Locale.US;
        sb.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
        sb.append("s. ");
        zzbpk zzbpkVar = this.f76594g;
        sb.append(String.format(locale, "Name resolution delay %.9f seconds.", Double.valueOf(((Long) zzbpkVar.n().i(zzbje.f76277a)) == null ? 0.0d : r2.longValue() / zzbpk.f76607p)));
        if (zzbpkVar.o() != null) {
            zzbtf zzbtfVar = new zzbtf();
            zzbpkVar.o().g(zzbtfVar);
            sb.append(" ");
            sb.append(zzbtfVar);
        }
        return zzbnp.f76491h.e(sb.toString());
    }

    final /* synthetic */ long d() {
        return this.f76591c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76594g.o().c(c());
    }
}
