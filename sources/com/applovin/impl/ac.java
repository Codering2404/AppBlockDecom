package com.applovin.impl;

import com.applovin.impl.a;
import com.applovin.impl.dp;
import com.applovin.impl.e9;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ac implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f58227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f58228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zg f58229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f58230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f58231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e9 f58232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f58233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f58234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f58235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f58236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f58237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f58238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f58239m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f58240n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f58241o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f58242p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f58243q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f58244r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f58245s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f58246t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f58247u;

    public ac(String str) {
        this.f58227a = str;
        ah ahVar = new ah(1024);
        this.f58228b = ahVar;
        this.f58229c = new zg(ahVar.c());
        this.f58237k = -9223372036854775807L;
    }

    private int c(zg zgVar) throws ch {
        int iB = zgVar.b();
        a.b bVarA = a.a(zgVar, true);
        this.f58247u = bVarA.f58135c;
        this.f58244r = bVarA.f58133a;
        this.f58246t = bVarA.f58134b;
        return iB - zgVar.b();
    }

    private void d(zg zgVar) {
        int iA = zgVar.a(3);
        this.f58241o = iA;
        if (iA == 0) {
            zgVar.d(8);
            return;
        }
        if (iA == 1) {
            zgVar.d(9);
            return;
        }
        if (iA == 3 || iA == 4 || iA == 5) {
            zgVar.d(6);
        } else {
            if (iA != 6 && iA != 7) {
                throw new IllegalStateException();
            }
            zgVar.d(1);
        }
    }

    private int e(zg zgVar) throws ch {
        int iA;
        if (this.f58241o != 0) {
            throw ch.a(null, null);
        }
        int i3 = 0;
        do {
            iA = zgVar.a(8);
            i3 += iA;
        } while (iA == 255);
        return i3;
    }

    private void f(zg zgVar) throws ch {
        boolean zF;
        int iA = zgVar.a(1);
        int iA2 = iA == 1 ? zgVar.a(1) : 0;
        this.f58239m = iA2;
        if (iA2 != 0) {
            throw ch.a(null, null);
        }
        if (iA == 1) {
            a(zgVar);
        }
        if (!zgVar.f()) {
            throw ch.a(null, null);
        }
        this.f58240n = zgVar.a(6);
        int iA3 = zgVar.a(4);
        int iA4 = zgVar.a(3);
        if (iA3 != 0 || iA4 != 0) {
            throw ch.a(null, null);
        }
        if (iA == 0) {
            int iE = zgVar.e();
            int iC = c(zgVar);
            zgVar.c(iE);
            byte[] bArr = new byte[(iC + 7) / 8];
            zgVar.a(bArr, 0, iC);
            e9 e9VarA = new e9.b().c(this.f58231e).f("audio/mp4a-latm").a(this.f58247u).c(this.f58246t).n(this.f58244r).a(Collections.singletonList(bArr)).e(this.f58227a).a();
            if (!e9VarA.equals(this.f58232f)) {
                this.f58232f = e9VarA;
                this.f58245s = 1024000000 / ((long) e9VarA.A);
                this.f58230d.a(e9VarA);
            }
        } else {
            zgVar.d(((int) a(zgVar)) - c(zgVar));
        }
        d(zgVar);
        boolean zF2 = zgVar.f();
        this.f58242p = zF2;
        this.f58243q = 0L;
        if (zF2) {
            if (iA == 1) {
                this.f58243q = a(zgVar);
            } else {
                do {
                    zF = zgVar.f();
                    this.f58243q = (this.f58243q << 8) + ((long) zgVar.a(8));
                } while (zF);
            }
        }
        if (zgVar.f()) {
            zgVar.d(8);
        }
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) throws ch {
        b1.b(this.f58230d);
        while (ahVar.a() > 0) {
            int i3 = this.f58233g;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iW = ahVar.w();
                    if ((iW & 224) == 224) {
                        this.f58236j = iW;
                        this.f58233g = 2;
                    } else if (iW != 86) {
                        this.f58233g = 0;
                    }
                } else if (i3 == 2) {
                    int iW2 = ((this.f58236j & (-225)) << 8) | ahVar.w();
                    this.f58235i = iW2;
                    if (iW2 > this.f58228b.c().length) {
                        a(this.f58235i);
                    }
                    this.f58234h = 0;
                    this.f58233g = 3;
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(ahVar.a(), this.f58235i - this.f58234h);
                    ahVar.a(this.f58229c.f65436a, this.f58234h, iMin);
                    int i4 = this.f58234h + iMin;
                    this.f58234h = i4;
                    if (i4 == this.f58235i) {
                        this.f58229c.c(0);
                        b(this.f58229c);
                        this.f58233g = 0;
                    }
                }
            } else if (ahVar.w() == 86) {
                this.f58233g = 1;
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    private void b(zg zgVar) throws ch {
        if (!zgVar.f()) {
            this.f58238l = true;
            f(zgVar);
        } else if (!this.f58238l) {
            return;
        }
        if (this.f58239m != 0) {
            throw ch.a(null, null);
        }
        if (this.f58240n != 0) {
            throw ch.a(null, null);
        }
        a(zgVar, e(zgVar));
        if (this.f58242p) {
            zgVar.d((int) this.f58243q);
        }
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f58230d = l8Var.a(dVar.c(), 1);
        this.f58231e = dVar.b();
    }

    private static long a(zg zgVar) {
        return zgVar.a((zgVar.a(2) + 1) * 8);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f58237k = j3;
        }
    }

    private void a(zg zgVar, int i3) {
        int iE = zgVar.e();
        if ((iE & 7) == 0) {
            this.f58228b.f(iE >> 3);
        } else {
            zgVar.a(this.f58228b.c(), 0, i3 * 8);
            this.f58228b.f(0);
        }
        this.f58230d.a(this.f58228b, i3);
        long j3 = this.f58237k;
        if (j3 != -9223372036854775807L) {
            this.f58230d.a(j3, 1, i3, 0, null);
            this.f58237k += this.f58245s;
        }
    }

    private void a(int i3) {
        this.f58228b.d(i3);
        this.f58229c.a(this.f58228b.c());
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f58233g = 0;
        this.f58237k = -9223372036854775807L;
        this.f58238l = false;
    }
}
