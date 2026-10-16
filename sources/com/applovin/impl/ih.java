package com.applovin.impl;

import com.applovin.impl.dp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ih implements dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p7 f60457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zg f60458b = new zg(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f60459c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ho f60461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f60462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f60463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f60464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f60466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f60467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f60468l;

    public ih(p7 p7Var) {
        this.f60457a = p7Var;
    }

    private boolean b() {
        this.f60458b.c(0);
        int iA = this.f60458b.a(24);
        if (iA != 1) {
            oc.d("PesReader", "Unexpected start code prefix: " + iA);
            this.f60466j = -1;
            return false;
        }
        this.f60458b.d(8);
        int iA2 = this.f60458b.a(16);
        this.f60458b.d(5);
        this.f60467k = this.f60458b.f();
        this.f60458b.d(2);
        this.f60462f = this.f60458b.f();
        this.f60463g = this.f60458b.f();
        this.f60458b.d(6);
        int iA3 = this.f60458b.a(8);
        this.f60465i = iA3;
        if (iA2 == 0) {
            this.f60466j = -1;
        } else {
            int i3 = (iA2 - 3) - iA3;
            this.f60466j = i3;
            if (i3 < 0) {
                oc.d("PesReader", "Found negative packet payload size: " + this.f60466j);
                this.f60466j = -1;
            }
        }
        return true;
    }

    private void c() {
        this.f60458b.c(0);
        this.f60468l = -9223372036854775807L;
        if (this.f60462f) {
            this.f60458b.d(4);
            long jA = ((long) this.f60458b.a(3)) << 30;
            this.f60458b.d(1);
            long jA2 = jA | ((long) (this.f60458b.a(15) << 15));
            this.f60458b.d(1);
            long jA3 = jA2 | ((long) this.f60458b.a(15));
            this.f60458b.d(1);
            if (!this.f60464h && this.f60463g) {
                this.f60458b.d(4);
                long jA4 = ((long) this.f60458b.a(3)) << 30;
                this.f60458b.d(1);
                long jA5 = jA4 | ((long) (this.f60458b.a(15) << 15));
                this.f60458b.d(1);
                long jA6 = jA5 | ((long) this.f60458b.a(15));
                this.f60458b.d(1);
                this.f60461e.b(jA6);
                this.f60464h = true;
            }
            this.f60468l = this.f60461e.b(jA3);
        }
    }

    @Override // com.applovin.impl.dp
    public final void a(ah ahVar, int i3) {
        b1.b(this.f60461e);
        if ((i3 & 1) != 0) {
            int i4 = this.f60459c;
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    oc.d("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i4 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f60466j != -1) {
                        oc.d("PesReader", "Unexpected start indicator: expected " + this.f60466j + " more bytes");
                    }
                    this.f60457a.b();
                }
            }
            a(1);
        }
        while (ahVar.a() > 0) {
            int i5 = this.f60459c;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        if (a(ahVar, this.f60458b.f65436a, Math.min(10, this.f60465i)) && a(ahVar, (byte[]) null, this.f60465i)) {
                            c();
                            i3 |= this.f60467k ? 4 : 0;
                            this.f60457a.a(this.f60468l, i3);
                            a(3);
                        }
                    } else {
                        if (i5 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = ahVar.a();
                        int i6 = this.f60466j;
                        int i7 = i6 != -1 ? iA - i6 : 0;
                        if (i7 > 0) {
                            iA -= i7;
                            ahVar.e(ahVar.d() + iA);
                        }
                        this.f60457a.a(ahVar);
                        int i8 = this.f60466j;
                        if (i8 != -1) {
                            int i9 = i8 - iA;
                            this.f60466j = i9;
                            if (i9 == 0) {
                                this.f60457a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(ahVar, this.f60458b.f65436a, 9)) {
                    a(b() ? 2 : 0);
                }
            } else {
                ahVar.g(ahVar.a());
            }
        }
    }

    private boolean a(ah ahVar, byte[] bArr, int i3) {
        int iMin = Math.min(ahVar.a(), i3 - this.f60460d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            ahVar.g(iMin);
        } else {
            ahVar.a(bArr, this.f60460d, iMin);
        }
        int i4 = this.f60460d + iMin;
        this.f60460d = i4;
        return i4 == i3;
    }

    @Override // com.applovin.impl.dp
    public void a(ho hoVar, l8 l8Var, dp.d dVar) {
        this.f60461e = hoVar;
        this.f60457a.a(l8Var, dVar);
    }

    @Override // com.applovin.impl.dp
    public final void a() {
        this.f60459c = 0;
        this.f60460d = 0;
        this.f60464h = false;
        this.f60457a.a();
    }

    private void a(int i3) {
        this.f60459c = i3;
        this.f60460d = 0;
    }
}
