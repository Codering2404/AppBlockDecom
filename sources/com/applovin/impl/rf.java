package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.applovin.impl.sf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class rf implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f62815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final sf.a f62816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f62817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f62818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f62819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f62821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f62822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f62823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f62824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f62825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f62826l;

    public rf() {
        this(null);
    }

    private void c(ah ahVar) {
        int iMin = Math.min(ahVar.a(), this.f62825k - this.f62821g);
        this.f62818d.a(ahVar, iMin);
        int i3 = this.f62821g + iMin;
        this.f62821g = i3;
        int i4 = this.f62825k;
        if (i3 < i4) {
            return;
        }
        long j3 = this.f62826l;
        if (j3 != -9223372036854775807L) {
            this.f62818d.a(j3, 1, i4, 0, null);
            this.f62826l += this.f62824j;
        }
        this.f62821g = 0;
        this.f62820f = 0;
    }

    private void d(ah ahVar) {
        int iMin = Math.min(ahVar.a(), 4 - this.f62821g);
        ahVar.a(this.f62815a.c(), this.f62821g, iMin);
        int i3 = this.f62821g + iMin;
        this.f62821g = i3;
        if (i3 < 4) {
            return;
        }
        this.f62815a.f(0);
        if (!this.f62816b.a(this.f62815a.j())) {
            this.f62821g = 0;
            this.f62820f = 1;
            return;
        }
        sf.a aVar = this.f62816b;
        this.f62825k = aVar.f63704c;
        if (!this.f62822h) {
            this.f62824j = (((long) aVar.f63708g) * 1000000) / ((long) aVar.f63705d);
            this.f62818d.a(new e9.b().c(this.f62819e).f(this.f62816b.f63703b).i(4096).c(this.f62816b.f63706e).n(this.f62816b.f63705d).e(this.f62817c).a());
            this.f62822h = true;
        }
        this.f62815a.f(0);
        this.f62818d.a(this.f62815a, 4);
        this.f62820f = 2;
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f62818d);
        while (ahVar.a() > 0) {
            int i3 = this.f62820f;
            if (i3 == 0) {
                b(ahVar);
            } else if (i3 == 1) {
                d(ahVar);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException();
                }
                c(ahVar);
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    public rf(String str) {
        this.f62820f = 0;
        ah ahVar = new ah(4);
        this.f62815a = ahVar;
        ahVar.c()[0] = -1;
        this.f62816b = new sf.a();
        this.f62826l = -9223372036854775807L;
        this.f62817c = str;
    }

    private void b(ah ahVar) {
        byte[] bArrC = ahVar.c();
        int iE = ahVar.e();
        for (int iD = ahVar.d(); iD < iE; iD++) {
            byte b3 = bArrC[iD];
            boolean z2 = (b3 & 255) == 255;
            boolean z3 = this.f62823i && (b3 & 224) == 224;
            this.f62823i = z2;
            if (z3) {
                ahVar.f(iD + 1);
                this.f62823i = false;
                this.f62815a.c()[1] = bArrC[iD];
                this.f62821g = 2;
                this.f62820f = 1;
                return;
            }
        }
        ahVar.f(iE);
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f62819e = dVar.b();
        this.f62818d = l8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f62826l = j3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f62820f = 0;
        this.f62821g = 0;
        this.f62823i = false;
        this.f62826l = -9223372036854775807L;
    }
}
