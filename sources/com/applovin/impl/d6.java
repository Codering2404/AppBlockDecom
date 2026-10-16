package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.impl.sd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class d6 implements jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f59088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f59089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f59090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f59091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f59092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f59093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f59094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f59095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f59096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f59097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f59098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f59099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f59100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f59101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f59102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f59103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f59104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f59105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f59106s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f59107a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f59108b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f59109c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f59110d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f59111e = t2.a(20L);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f59112f = t2.a(500L);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f59113g = 0.999f;

        public d6 a() {
            return new d6(this.f59107a, this.f59108b, this.f59109c, this.f59110d, this.f59111e, this.f59112f, this.f59113g);
        }
    }

    private d6(float f3, float f4, long j3, float f5, long j4, long j5, float f6) {
        this.f59088a = f3;
        this.f59089b = f4;
        this.f59090c = j3;
        this.f59091d = f5;
        this.f59092e = j4;
        this.f59093f = j5;
        this.f59094g = f6;
        this.f59095h = -9223372036854775807L;
        this.f59096i = -9223372036854775807L;
        this.f59098k = -9223372036854775807L;
        this.f59099l = -9223372036854775807L;
        this.f59102o = f3;
        this.f59101n = f4;
        this.f59103p = 1.0f;
        this.f59104q = -9223372036854775807L;
        this.f59097j = -9223372036854775807L;
        this.f59100m = -9223372036854775807L;
        this.f59105r = -9223372036854775807L;
        this.f59106s = -9223372036854775807L;
    }

    private static long a(long j3, long j4, float f3) {
        return (long) ((j3 * f3) + ((1.0f - f3) * j4));
    }

    private void b(long j3) {
        long j4 = this.f59105r + (this.f59106s * 3);
        if (this.f59100m > j4) {
            float fA = t2.a(this.f59090c);
            this.f59100m = rc.a(j4, this.f59097j, this.f59100m - (((long) ((this.f59103p - 1.0f) * fA)) + ((long) ((this.f59101n - 1.0f) * fA))));
            return;
        }
        long jB = xp.b(j3 - ((long) (Math.max(0.0f, this.f59103p - 1.0f) / this.f59091d)), this.f59100m, j4);
        this.f59100m = jB;
        long j5 = this.f59099l;
        if (j5 == -9223372036854775807L || jB <= j5) {
            return;
        }
        this.f59100m = j5;
    }

    private void c() {
        long j3 = this.f59095h;
        if (j3 != -9223372036854775807L) {
            long j4 = this.f59096i;
            if (j4 != -9223372036854775807L) {
                j3 = j4;
            }
            long j5 = this.f59098k;
            if (j5 != -9223372036854775807L && j3 < j5) {
                j3 = j5;
            }
            long j6 = this.f59099l;
            if (j6 != -9223372036854775807L && j3 > j6) {
                j3 = j6;
            }
        } else {
            j3 = -9223372036854775807L;
        }
        if (this.f59097j == j3) {
            return;
        }
        this.f59097j = j3;
        this.f59100m = j3;
        this.f59105r = -9223372036854775807L;
        this.f59106s = -9223372036854775807L;
        this.f59104q = -9223372036854775807L;
    }

    @Override // com.applovin.impl.jc
    public float a(long j3, long j4) {
        if (this.f59095h == -9223372036854775807L) {
            return 1.0f;
        }
        b(j3, j4);
        if (this.f59104q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f59104q < this.f59090c) {
            return this.f59103p;
        }
        this.f59104q = SystemClock.elapsedRealtime();
        b(j3);
        long j5 = j3 - this.f59100m;
        if (Math.abs(j5) < this.f59092e) {
            this.f59103p = 1.0f;
        } else {
            this.f59103p = xp.a((this.f59091d * j5) + 1.0f, this.f59102o, this.f59101n);
        }
        return this.f59103p;
    }

    @Override // com.applovin.impl.jc
    public long b() {
        return this.f59100m;
    }

    private void b(long j3, long j4) {
        long j5 = j3 - j4;
        long j6 = this.f59105r;
        if (j6 == -9223372036854775807L) {
            this.f59105r = j5;
            this.f59106s = 0L;
        } else {
            long jMax = Math.max(j5, a(j6, j5, this.f59094g));
            this.f59105r = jMax;
            this.f59106s = a(this.f59106s, Math.abs(j5 - jMax), this.f59094g);
        }
    }

    @Override // com.applovin.impl.jc
    public void a() {
        long j3 = this.f59100m;
        if (j3 == -9223372036854775807L) {
            return;
        }
        long j4 = j3 + this.f59093f;
        this.f59100m = j4;
        long j5 = this.f59099l;
        if (j5 != -9223372036854775807L && j4 > j5) {
            this.f59100m = j5;
        }
        this.f59104q = -9223372036854775807L;
    }

    @Override // com.applovin.impl.jc
    public void a(sd.f fVar) {
        this.f59095h = t2.a(fVar.f63079a);
        this.f59098k = t2.a(fVar.f63080b);
        this.f59099l = t2.a(fVar.f63081c);
        float f3 = fVar.f63082d;
        if (f3 == -3.4028235E38f) {
            f3 = this.f59088a;
        }
        this.f59102o = f3;
        float f4 = fVar.f63083f;
        if (f4 == -3.4028235E38f) {
            f4 = this.f59089b;
        }
        this.f59101n = f4;
        c();
    }

    @Override // com.applovin.impl.jc
    public void a(long j3) {
        this.f59096i = j3;
        c();
    }
}
