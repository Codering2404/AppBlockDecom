package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.ij;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 implements j8 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n8 f60558m = new n8() { // from class: com.applovin.impl.gy
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return j0.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f60559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0 f60560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f60561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ah f60562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zg f60563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l8 f60564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f60565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f60566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f60568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f60569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f60570l;

    public j0() {
        this(0);
    }

    private void b(k8 k8Var) throws ch {
        int iA;
        if (this.f60568j) {
            return;
        }
        this.f60567i = -1;
        k8Var.b();
        long j3 = 0;
        if (k8Var.f() == 0) {
            c(k8Var);
        }
        int i3 = 0;
        int i4 = 0;
        do {
            try {
                if (!k8Var.b(this.f60562d.c(), 0, 2, true)) {
                    break;
                }
                this.f60562d.f(0);
                if (!k0.a(this.f60562d.C())) {
                    break;
                }
                if (!k8Var.b(this.f60562d.c(), 0, 4, true)) {
                    break;
                }
                this.f60563e.c(14);
                iA = this.f60563e.a(13);
                if (iA <= 6) {
                    this.f60568j = true;
                    throw ch.a("Malformed ADTS stream", null);
                }
                j3 += (long) iA;
                i4++;
                if (i4 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (k8Var.a(iA - 6, true));
        i3 = i4;
        k8Var.b();
        if (i3 > 0) {
            this.f60567i = (int) (j3 / ((long) i3));
        } else {
            this.f60567i = -1;
        }
        this.f60568j = true;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public j0(int i3) {
        this.f60559a = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f60560b = new k0(true);
        this.f60561c = new ah(2048);
        this.f60567i = -1;
        this.f60566h = -1L;
        ah ahVar = new ah(10);
        this.f60562d = ahVar;
        this.f60563e = new zg(ahVar.c());
    }

    private static int a(int i3, long j3) {
        return (int) ((((long) (i3 * 8)) * 1000000) / j3);
    }

    private int c(k8 k8Var) {
        int i3 = 0;
        while (true) {
            k8Var.c(this.f60562d.c(), 0, 10);
            this.f60562d.f(0);
            if (this.f60562d.z() != 4801587) {
                break;
            }
            this.f60562d.g(3);
            int iV = this.f60562d.v();
            i3 += iV + 10;
            k8Var.c(iV);
        }
        k8Var.b();
        k8Var.c(i3);
        if (this.f60566h == -1) {
            this.f60566h = i3;
        }
        return i3;
    }

    private ij a(long j3, boolean z2) {
        return new o4(j3, this.f60566h, a(this.f60567i, this.f60560b.d()), this.f60567i, z2);
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f60564f = l8Var;
        this.f60560b.a(l8Var, new dp.d(0, 1));
        l8Var.c();
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        b1.b(this.f60564f);
        long jA = k8Var.a();
        int i3 = this.f60559a;
        if ((i3 & 2) != 0 || ((i3 & 1) != 0 && jA != -1)) {
            b(k8Var);
        }
        int iA = k8Var.a(this.f60561c.c(), 0, 2048);
        boolean z2 = iA == -1;
        b(jA, z2);
        if (z2) {
            return -1;
        }
        this.f60561c.f(0);
        this.f60561c.e(iA);
        if (!this.f60569k) {
            this.f60560b.a(this.f60565g, 4);
            this.f60569k = true;
        }
        this.f60560b.a(this.f60561c);
        return 0;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f60569k = false;
        this.f60560b.a();
        this.f60565g = j4;
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        int iC = c(k8Var);
        int i3 = iC;
        int i4 = 0;
        int i5 = 0;
        do {
            k8Var.c(this.f60562d.c(), 0, 2);
            this.f60562d.f(0);
            if (k0.a(this.f60562d.C())) {
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                k8Var.c(this.f60562d.c(), 0, 4);
                this.f60563e.c(14);
                int iA = this.f60563e.a(13);
                if (iA <= 6) {
                    i3++;
                    k8Var.b();
                    k8Var.c(i3);
                } else {
                    k8Var.c(iA - 6);
                    i5 += iA;
                }
            } else {
                i3++;
                k8Var.b();
                k8Var.c(i3);
            }
            i4 = 0;
            i5 = 0;
        } while (i3 - iC < 8192);
        return false;
    }

    private void b(long j3, boolean z2) {
        if (this.f60570l) {
            return;
        }
        boolean z3 = (this.f60559a & 1) != 0 && this.f60567i > 0;
        if (z3 && this.f60560b.d() == -9223372036854775807L && !z2) {
            return;
        }
        if (z3 && this.f60560b.d() != -9223372036854775807L) {
            this.f60564f.a(a(j3, (this.f60559a & 2) != 0));
        } else {
            this.f60564f.a(new ij.b(-9223372036854775807L));
        }
        this.f60570l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new j0()};
    }
}
