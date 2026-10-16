package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Stopwatch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ticker f83400a = Ticker.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f83401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f83402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f83403d;

    /* JADX INFO: renamed from: com.google.common.base.Stopwatch$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f83404a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f83404a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f83404a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f83404a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f83404a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f83404a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f83404a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f83404a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    Stopwatch() {
    }

    private static String a(TimeUnit timeUnit) {
        switch (AnonymousClass1.f83404a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j3) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j3, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j3, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j3, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j3, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j3, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j3, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static Stopwatch c() {
        return new Stopwatch().i();
    }

    public static Stopwatch d() {
        return new Stopwatch();
    }

    private long f() {
        return this.f83401b ? (this.f83400a.a() - this.f83403d) + this.f83402c : this.f83402c;
    }

    public long e(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    public boolean g() {
        return this.f83401b;
    }

    public Stopwatch h() {
        this.f83402c = 0L;
        this.f83401b = false;
        return this;
    }

    public Stopwatch i() {
        Preconditions.A(!this.f83401b, "This stopwatch is already running.");
        this.f83401b = true;
        this.f83403d = this.f83400a.a();
        return this;
    }

    public Stopwatch j() {
        long jA = this.f83400a.a();
        Preconditions.A(this.f83401b, "This stopwatch is already stopped.");
        this.f83401b = false;
        this.f83402c += jA - this.f83403d;
        return this;
    }

    public String toString() {
        long jF = f();
        TimeUnit timeUnitB = b(jF);
        return Platform.c(jF / TimeUnit.NANOSECONDS.convert(1L, timeUnitB)) + " " + a(timeUnitB);
    }
}
