package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.applovin.impl.k;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zg f60546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f60547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f60548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f60549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private qo f60550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f60551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f60552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f60553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f60554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e9 f60555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f60556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f60557l;

    public j() {
        this(null);
    }

    private void c() {
        this.f60546a.c(0);
        k.b bVarA = k.a(this.f60546a);
        e9 e9Var = this.f60555j;
        if (e9Var == null || bVarA.f60839d != e9Var.f59407z || bVarA.f60838c != e9Var.A || !xp.a((Object) bVarA.f60836a, (Object) e9Var.f59394m)) {
            e9 e9VarA = new e9.b().c(this.f60549d).f(bVarA.f60836a).c(bVarA.f60839d).n(bVarA.f60838c).e(this.f60548c).a();
            this.f60555j = e9VarA;
            this.f60550e.a(e9VarA);
        }
        this.f60556k = bVarA.f60840e;
        this.f60554i = (((long) bVarA.f60841f) * 1000000) / ((long) this.f60555j.A);
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f60550e);
        while (ahVar.a() > 0) {
            int i3 = this.f60551f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int iMin = Math.min(ahVar.a(), this.f60556k - this.f60552g);
                        this.f60550e.a(ahVar, iMin);
                        int i4 = this.f60552g + iMin;
                        this.f60552g = i4;
                        int i5 = this.f60556k;
                        if (i4 == i5) {
                            long j3 = this.f60557l;
                            if (j3 != -9223372036854775807L) {
                                this.f60550e.a(j3, 1, i5, 0, null);
                                this.f60557l += this.f60554i;
                            }
                            this.f60551f = 0;
                        }
                    }
                } else if (a(ahVar, this.f60547b.c(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) {
                    c();
                    this.f60547b.f(0);
                    this.f60550e.a(this.f60547b, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f60551f = 2;
                }
            } else if (b(ahVar)) {
                this.f60551f = 1;
                this.f60547b.c()[0] = Ascii.VT;
                this.f60547b.c()[1] = 119;
                this.f60552g = 2;
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    public j(String str) {
        zg zgVar = new zg(new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD]);
        this.f60546a = zgVar;
        this.f60547b = new ah(zgVar.f65436a);
        this.f60551f = 0;
        this.f60557l = -9223372036854775807L;
        this.f60548c = str;
    }

    private boolean b(ah ahVar) {
        while (true) {
            if (ahVar.a() <= 0) {
                return false;
            }
            if (this.f60553h) {
                int iW = ahVar.w();
                if (iW == 119) {
                    this.f60553h = false;
                    return true;
                }
                this.f60553h = iW == 11;
            } else {
                this.f60553h = ahVar.w() == 11;
            }
        }
    }

    private boolean a(ah ahVar, byte[] bArr, int i3) {
        int iMin = Math.min(ahVar.a(), i3 - this.f60552g);
        ahVar.a(bArr, this.f60552g, iMin);
        int i4 = this.f60552g + iMin;
        this.f60552g = i4;
        return i4 == i3;
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f60549d = dVar.b();
        this.f60550e = l8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f60557l = j3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f60551f = 0;
        this.f60552g = 0;
        this.f60553h = false;
        this.f60557l = -9223372036854775807L;
    }
}
