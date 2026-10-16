package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.applovin.impl.n;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zg f61306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f61307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f61308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f61309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private qo f61310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f61311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f61312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f61313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f61314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f61315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e9 f61316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f61317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f61318m;

    public m() {
        this(null);
    }

    private void c() {
        this.f61306a.c(0);
        n.b bVarA = n.a(this.f61306a);
        e9 e9Var = this.f61316k;
        if (e9Var == null || bVarA.f61949c != e9Var.f59407z || bVarA.f61948b != e9Var.A || !"audio/ac4".equals(e9Var.f59394m)) {
            e9 e9VarA = new e9.b().c(this.f61309d).f("audio/ac4").c(bVarA.f61949c).n(bVarA.f61948b).e(this.f61308c).a();
            this.f61316k = e9VarA;
            this.f61310e.a(e9VarA);
        }
        this.f61317l = bVarA.f61950d;
        this.f61315j = (((long) bVarA.f61951e) * 1000000) / ((long) this.f61316k.A);
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f61310e);
        while (ahVar.a() > 0) {
            int i3 = this.f61311f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int iMin = Math.min(ahVar.a(), this.f61317l - this.f61312g);
                        this.f61310e.a(ahVar, iMin);
                        int i4 = this.f61312g + iMin;
                        this.f61312g = i4;
                        int i5 = this.f61317l;
                        if (i4 == i5) {
                            long j3 = this.f61318m;
                            if (j3 != -9223372036854775807L) {
                                this.f61310e.a(j3, 1, i5, 0, null);
                                this.f61318m += this.f61315j;
                            }
                            this.f61311f = 0;
                        }
                    }
                } else if (a(ahVar, this.f61307b.c(), 16)) {
                    c();
                    this.f61307b.f(0);
                    this.f61310e.a(this.f61307b, 16);
                    this.f61311f = 2;
                }
            } else if (b(ahVar)) {
                this.f61311f = 1;
                this.f61307b.c()[0] = -84;
                this.f61307b.c()[1] = (byte) (this.f61314i ? 65 : 64);
                this.f61312g = 2;
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    public m(String str) {
        zg zgVar = new zg(new byte[16]);
        this.f61306a = zgVar;
        this.f61307b = new ah(zgVar.f65436a);
        this.f61311f = 0;
        this.f61312g = 0;
        this.f61313h = false;
        this.f61314i = false;
        this.f61318m = -9223372036854775807L;
        this.f61308c = str;
    }

    private boolean b(ah ahVar) {
        int iW;
        while (true) {
            if (ahVar.a() <= 0) {
                return false;
            }
            if (this.f61313h) {
                iW = ahVar.w();
                this.f61313h = iW == 172;
                if (iW == 64 || iW == 65) {
                    break;
                }
            } else {
                this.f61313h = ahVar.w() == 172;
            }
        }
        this.f61314i = iW == 65;
        return true;
    }

    private boolean a(ah ahVar, byte[] bArr, int i3) {
        int iMin = Math.min(ahVar.a(), i3 - this.f61312g);
        ahVar.a(bArr, this.f61312g, iMin);
        int i4 = this.f61312g + iMin;
        this.f61312g = i4;
        return i4 == i3;
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f61309d = dVar.b();
        this.f61310e = l8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f61318m = j3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f61311f = 0;
        this.f61312g = 0;
        this.f61313h = false;
        this.f61314i = false;
        this.f61318m = -9223372036854775807L;
    }
}
