package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class q5 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f62565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f62566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f62567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m0[] f62568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f62569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f62571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m0[] f62572h;

    public q5(boolean z2, int i3) {
        this(z2, i3, 0);
    }

    @Override // com.applovin.impl.n0
    public synchronized void a(m0 m0Var) {
        m0[] m0VarArr = this.f62568d;
        m0VarArr[0] = m0Var;
        a(m0VarArr);
    }

    @Override // com.applovin.impl.n0
    public synchronized m0 b() {
        m0 m0Var;
        try {
            this.f62570f++;
            int i3 = this.f62571g;
            if (i3 > 0) {
                m0[] m0VarArr = this.f62572h;
                int i4 = i3 - 1;
                this.f62571g = i4;
                m0Var = (m0) b1.a(m0VarArr[i4]);
                this.f62572h[this.f62571g] = null;
            } else {
                m0Var = new m0(new byte[this.f62566b], 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return m0Var;
    }

    @Override // com.applovin.impl.n0
    public int c() {
        return this.f62566b;
    }

    public synchronized int d() {
        return this.f62570f * this.f62566b;
    }

    public synchronized void e() {
        if (this.f62565a) {
            a(0);
        }
    }

    public q5(boolean z2, int i3, int i4) {
        b1.a(i3 > 0);
        b1.a(i4 >= 0);
        this.f62565a = z2;
        this.f62566b = i3;
        this.f62571g = i4;
        this.f62572h = new m0[i4 + 100];
        if (i4 > 0) {
            this.f62567c = new byte[i4 * i3];
            for (int i5 = 0; i5 < i4; i5++) {
                this.f62572h[i5] = new m0(this.f62567c, i5 * i3);
            }
        } else {
            this.f62567c = null;
        }
        this.f62568d = new m0[1];
    }

    @Override // com.applovin.impl.n0
    public synchronized void a(m0[] m0VarArr) {
        try {
            int i3 = this.f62571g;
            int length = m0VarArr.length + i3;
            m0[] m0VarArr2 = this.f62572h;
            if (length >= m0VarArr2.length) {
                this.f62572h = (m0[]) Arrays.copyOf(m0VarArr2, Math.max(m0VarArr2.length * 2, i3 + m0VarArr.length));
            }
            for (m0 m0Var : m0VarArr) {
                m0[] m0VarArr3 = this.f62572h;
                int i4 = this.f62571g;
                this.f62571g = i4 + 1;
                m0VarArr3[i4] = m0Var;
            }
            this.f62570f -= m0VarArr.length;
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(int i3) {
        boolean z2 = i3 < this.f62569e;
        this.f62569e = i3;
        if (z2) {
            a();
        }
    }

    @Override // com.applovin.impl.n0
    public synchronized void a() {
        try {
            int i3 = 0;
            int iMax = Math.max(0, xp.a(this.f62569e, this.f62566b) - this.f62570f);
            int i4 = this.f62571g;
            if (iMax >= i4) {
                return;
            }
            if (this.f62567c != null) {
                int i5 = i4 - 1;
                while (i3 <= i5) {
                    m0 m0Var = (m0) b1.a(this.f62572h[i3]);
                    if (m0Var.f61319a == this.f62567c) {
                        i3++;
                    } else {
                        m0 m0Var2 = (m0) b1.a(this.f62572h[i5]);
                        if (m0Var2.f61319a != this.f62567c) {
                            i5--;
                        } else {
                            m0[] m0VarArr = this.f62572h;
                            m0VarArr[i3] = m0Var2;
                            m0VarArr[i5] = m0Var;
                            i5--;
                            i3++;
                        }
                    }
                }
                iMax = Math.max(iMax, i3);
                if (iMax >= this.f62571g) {
                    return;
                }
            }
            Arrays.fill(this.f62572h, iMax, this.f62571g, (Object) null);
            this.f62571g = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }
}
