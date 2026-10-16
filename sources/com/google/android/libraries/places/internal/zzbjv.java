package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjv implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzbju f76296d = new zzbjt(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f76297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f76298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f76299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f76300i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbju f76301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f76302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f76303c;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f76297f = nanos;
        f76298g = -nanos;
        f76299h = TimeUnit.SECONDS.toNanos(1L);
    }

    private zzbjv(zzbju zzbjuVar, long j3, long j4, boolean z2) {
        this.f76301a = zzbjuVar;
        long jMin = Math.min(f76297f, Math.max(f76298g, j4));
        this.f76302b = j3 + jMin;
        this.f76303c = jMin <= 0;
    }

    public static zzbjv a(long j3, TimeUnit timeUnit) {
        zzbju zzbjuVar = f76296d;
        Objects.requireNonNull(timeUnit, "units");
        return new zzbjv(zzbjuVar, System.nanoTime(), timeUnit.toNanos(j3), true);
    }

    public final boolean b() {
        if (!this.f76303c) {
            if (this.f76302b - System.nanoTime() > 0) {
                return false;
            }
            this.f76303c = true;
        }
        return true;
    }

    public final long c(TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        if (!this.f76303c && this.f76302b - jNanoTime <= 0) {
            this.f76303c = true;
        }
        return timeUnit.convert(this.f76302b - jNanoTime, TimeUnit.NANOSECONDS);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzbjv zzbjvVar) {
        zzbju zzbjuVar = this.f76301a;
        zzbju zzbjuVar2 = zzbjvVar.f76301a;
        if (zzbjuVar == zzbjuVar2) {
            return Long.compare(this.f76302b, zzbjvVar.f76302b);
        }
        String string = zzbjuVar.toString();
        String string2 = zzbjuVar2.toString();
        StringBuilder sb = new StringBuilder(string.length() + 14 + string2.length() + 58);
        sb.append("Tickers (");
        sb.append(string);
        sb.append(" and ");
        sb.append(string2);
        sb.append(") don't match. Custom Ticker should only be used in tests!");
        throw new AssertionError(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbjv)) {
            return false;
        }
        zzbjv zzbjvVar = (zzbjv) obj;
        return this.f76301a == zzbjvVar.f76301a && this.f76302b == zzbjvVar.f76302b;
    }

    public final int hashCode() {
        return Objects.hash(this.f76301a, Long.valueOf(this.f76302b));
    }

    public final String toString() {
        long jC = c(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jC);
        long j3 = f76299h;
        long j4 = jAbs / j3;
        long jAbs2 = Math.abs(jC) % j3;
        StringBuilder sb = new StringBuilder();
        if (jC < 0) {
            sb.append('-');
        }
        sb.append(j4);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        zzbju zzbjuVar = this.f76301a;
        if (zzbjuVar != f76296d) {
            String string = zzbjuVar.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 10);
            sb2.append(" (ticker=");
            sb2.append(string);
            sb2.append(")");
            sb.append(sb2.toString());
        }
        return sb.toString();
    }
}
