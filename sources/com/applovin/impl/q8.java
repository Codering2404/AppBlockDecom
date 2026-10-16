package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class q8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f62586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f62587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62589f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f62584a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f62585b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f62588e = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f62590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f62591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f62592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f62593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f62594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f62595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean[] f62596g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f62597h;

        public long a() {
            long j3 = this.f62594e;
            if (j3 == 0) {
                return 0L;
            }
            return this.f62595f / j3;
        }

        public long b() {
            return this.f62595f;
        }

        public boolean c() {
            long j3 = this.f62593d;
            if (j3 == 0) {
                return false;
            }
            return this.f62596g[a(j3 - 1)];
        }

        public boolean d() {
            return this.f62593d > 15 && this.f62597h == 0;
        }

        public void e() {
            this.f62593d = 0L;
            this.f62594e = 0L;
            this.f62595f = 0L;
            this.f62597h = 0;
            Arrays.fill(this.f62596g, false);
        }

        private static int a(long j3) {
            return (int) (j3 % 15);
        }

        public void b(long j3) {
            long j4 = this.f62593d;
            if (j4 == 0) {
                this.f62590a = j3;
            } else if (j4 == 1) {
                long j5 = j3 - this.f62590a;
                this.f62591b = j5;
                this.f62595f = j5;
                this.f62594e = 1L;
            } else {
                long j6 = j3 - this.f62592c;
                int iA = a(j4);
                if (Math.abs(j6 - this.f62591b) <= 1000000) {
                    this.f62594e++;
                    this.f62595f += j6;
                    boolean[] zArr = this.f62596g;
                    if (zArr[iA]) {
                        zArr[iA] = false;
                        this.f62597h--;
                    }
                } else {
                    boolean[] zArr2 = this.f62596g;
                    if (!zArr2[iA]) {
                        zArr2[iA] = true;
                        this.f62597h++;
                    }
                }
            }
            this.f62593d++;
            this.f62592c = j3;
        }
    }

    public long a() {
        if (e()) {
            return this.f62584a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f62584a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f62589f;
    }

    public long d() {
        if (e()) {
            return this.f62584a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f62584a.d();
    }

    public void f() {
        this.f62584a.e();
        this.f62585b.e();
        this.f62586c = false;
        this.f62588e = -9223372036854775807L;
        this.f62589f = 0;
    }

    public void a(long j3) {
        this.f62584a.b(j3);
        if (this.f62584a.d() && !this.f62587d) {
            this.f62586c = false;
        } else if (this.f62588e != -9223372036854775807L) {
            if (!this.f62586c || this.f62585b.c()) {
                this.f62585b.e();
                this.f62585b.b(this.f62588e);
            }
            this.f62586c = true;
            this.f62585b.b(j3);
        }
        if (this.f62586c && this.f62585b.d()) {
            a aVar = this.f62584a;
            this.f62584a = this.f62585b;
            this.f62585b = aVar;
            this.f62586c = false;
            this.f62587d = false;
        }
        this.f62588e = j3;
        this.f62589f = this.f62584a.d() ? 0 : this.f62589f + 1;
    }
}
