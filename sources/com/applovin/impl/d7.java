package com.applovin.impl;

import com.applovin.impl.dp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class d7 implements p7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f59115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f59116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qo f59117d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f59119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f59120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f59121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e9 f59122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f59123j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f59114a = new ah(new byte[18]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f59118e = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f59124k = -9223372036854775807L;

    public d7(String str) {
        this.f59115b = str;
    }

    private void c() {
        byte[] bArrC = this.f59114a.c();
        if (this.f59122i == null) {
            e9 e9VarA = e7.a(bArrC, this.f59116c, this.f59115b, null);
            this.f59122i = e9VarA;
            this.f59117d.a(e9VarA);
        }
        this.f59123j = e7.a(bArrC);
        this.f59121h = (int) ((((long) e7.d(bArrC)) * 1000000) / ((long) this.f59122i.A));
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f59117d);
        while (ahVar.a() > 0) {
            int i3 = this.f59118e;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(ahVar.a(), this.f59123j - this.f59119f);
                    this.f59117d.a(ahVar, iMin);
                    int i4 = this.f59119f + iMin;
                    this.f59119f = i4;
                    int i5 = this.f59123j;
                    if (i4 == i5) {
                        long j3 = this.f59124k;
                        if (j3 != -9223372036854775807L) {
                            this.f59117d.a(j3, 1, i5, 0, null);
                            this.f59124k += this.f59121h;
                        }
                        this.f59118e = 0;
                    }
                } else if (a(ahVar, this.f59114a.c(), 18)) {
                    c();
                    this.f59114a.f(0);
                    this.f59117d.a(this.f59114a, 18);
                    this.f59118e = 2;
                }
            } else if (b(ahVar)) {
                this.f59118e = 1;
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    private boolean b(ah ahVar) {
        while (ahVar.a() > 0) {
            int i3 = this.f59120g << 8;
            this.f59120g = i3;
            int iW = i3 | ahVar.w();
            this.f59120g = iW;
            if (e7.a(iW)) {
                byte[] bArrC = this.f59114a.c();
                int i4 = this.f59120g;
                bArrC[0] = (byte) ((i4 >> 24) & 255);
                bArrC[1] = (byte) ((i4 >> 16) & 255);
                bArrC[2] = (byte) ((i4 >> 8) & 255);
                bArrC[3] = (byte) (i4 & 255);
                this.f59119f = 4;
                this.f59120g = 0;
                return true;
            }
        }
        return false;
    }

    private boolean a(ah ahVar, byte[] bArr, int i3) {
        int iMin = Math.min(ahVar.a(), i3 - this.f59119f);
        ahVar.a(bArr, this.f59119f, iMin);
        int i4 = this.f59119f + iMin;
        this.f59119f = i4;
        return i4 == i3;
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f59116c = dVar.b();
        this.f59117d = l8Var.a(dVar.c(), 1);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f59124k = j3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f59118e = 0;
        this.f59119f = 0;
        this.f59120g = 0;
        this.f59124k = -9223372036854775807L;
    }
}
