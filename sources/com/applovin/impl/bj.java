package com.applovin.impl;

import android.os.Looper;
import com.applovin.impl.a7;
import com.applovin.impl.bj;
import com.applovin.impl.qo;
import com.applovin.impl.y6;
import com.applovin.impl.z6;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bj implements qo {
    private boolean A;
    private e9 B;
    private e9 C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aj f58670a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a7 f58673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final z6.a f58674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Looper f58675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f58676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e9 f58677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private y6 f58678i;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f58686q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f58687r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f58688s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f58689t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f58693x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f58671b = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f58679j = 1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f58680k = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long[] f58681l = new long[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long[] f58684o = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int[] f58683n = new int[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f58682m = new int[1000];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private qo.a[] f58685p = new qo.a[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final qk f58672c = new qk(new q4() { // from class: com.applovin.impl.zt
        @Override // com.applovin.impl.q4
        public final void accept(Object obj) {
            bj.a((bj.c) obj);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f58690u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f58691v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f58692w = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f58695z = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f58694y = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f58696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f58697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public qo.a f58698c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e9 f58699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a7.b f58700b;

        private c(e9 e9Var, a7.b bVar) {
            this.f58699a = e9Var;
            this.f58700b = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void a(e9 e9Var);
    }

    protected bj(n0 n0Var, Looper looper, a7 a7Var, z6.a aVar) {
        this.f58675f = looper;
        this.f58673d = a7Var;
        this.f58674e = aVar;
        this.f58670a = new aj(n0Var);
    }

    private synchronized boolean a(long j3) {
        if (this.f58686q == 0) {
            return j3 > this.f58691v;
        }
        if (d() >= j3) {
            return false;
        }
        b(this.f58687r + b(j3));
        return true;
    }

    private boolean h() {
        return this.f58689t != this.f58686q;
    }

    private void m() {
        y6 y6Var = this.f58678i;
        if (y6Var != null) {
            y6Var.a(this.f58674e);
            this.f58678i = null;
            this.f58677h = null;
        }
    }

    private synchronized void o() {
        this.f58689t = 0;
        this.f58670a.c();
    }

    public final synchronized long c() {
        return this.f58692w;
    }

    public final synchronized long d() {
        return Math.max(this.f58691v, c(this.f58689t));
    }

    public final int e() {
        return this.f58687r + this.f58689t;
    }

    public final synchronized e9 f() {
        return this.f58695z ? null : this.C;
    }

    public final int g() {
        return this.f58687r + this.f58686q;
    }

    public final synchronized boolean i() {
        return this.f58693x;
    }

    public void j() {
        y6 y6Var = this.f58678i;
        if (y6Var != null && y6Var.b() == 1) {
            throw ((y6.a) b1.a(this.f58678i.getError()));
        }
    }

    public void k() {
        b();
        m();
    }

    public void l() {
        b(true);
        m();
    }

    public final void n() {
        b(false);
    }

    private int b(long j3) {
        int i3 = this.f58686q;
        int iD = d(i3 - 1);
        while (i3 > this.f58689t && this.f58684o[iD] >= j3) {
            i3--;
            iD--;
            if (iD == -1) {
                iD = this.f58679j - 1;
            }
        }
        return i3;
    }

    private long c(int i3) {
        long jMax = Long.MIN_VALUE;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int iD = d(i3 - 1);
        for (int i4 = 0; i4 < i3; i4++) {
            jMax = Math.max(jMax, this.f58684o[iD]);
            if ((this.f58683n[iD] & 1) != 0) {
                return jMax;
            }
            iD--;
            if (iD == -1) {
                iD = this.f58679j - 1;
            }
        }
        return jMax;
    }

    private int d(int i3) {
        int i4 = this.f58688s + i3;
        int i5 = this.f58679j;
        return i4 < i5 ? i4 : i4 - i5;
    }

    private boolean e(int i3) {
        y6 y6Var = this.f58678i;
        if (y6Var == null || y6Var.b() == 4) {
            return true;
        }
        return (this.f58683n[i3] & 1073741824) == 0 && this.f58678i.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void f(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.f58689t     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f58686q     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            com.applovin.impl.b1.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f58689t     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f58689t = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.bj.f(int):void");
    }

    private synchronized void a(long j3, int i3, long j4, int i4, qo.a aVar) {
        a7.b bVarB;
        try {
            int i5 = this.f58686q;
            if (i5 > 0) {
                int iD = d(i5 - 1);
                b1.a(this.f58681l[iD] + ((long) this.f58682m[iD]) <= j4);
            }
            this.f58693x = (536870912 & i3) != 0;
            this.f58692w = Math.max(this.f58692w, j3);
            int iD2 = d(this.f58686q);
            this.f58684o[iD2] = j3;
            this.f58681l[iD2] = j4;
            this.f58682m[iD2] = i4;
            this.f58683n[iD2] = i3;
            this.f58685p[iD2] = aVar;
            this.f58680k[iD2] = this.D;
            if (this.f58672c.c() || !((c) this.f58672c.b()).f58699a.equals(this.C)) {
                a7 a7Var = this.f58673d;
                if (a7Var != null) {
                    bVarB = a7Var.b((Looper) b1.a(this.f58675f), this.f58674e, this.C);
                } else {
                    bVarB = a7.b.f58216a;
                }
                this.f58672c.a(g(), new c((e9) b1.a(this.C), bVarB));
            }
            int i6 = this.f58686q + 1;
            this.f58686q = i6;
            int i7 = this.f58679j;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                qo.a[] aVarArr = new qo.a[i8];
                int i9 = this.f58688s;
                int i10 = i7 - i9;
                System.arraycopy(this.f58681l, i9, jArr, 0, i10);
                System.arraycopy(this.f58684o, this.f58688s, jArr2, 0, i10);
                System.arraycopy(this.f58683n, this.f58688s, iArr2, 0, i10);
                System.arraycopy(this.f58682m, this.f58688s, iArr3, 0, i10);
                System.arraycopy(this.f58685p, this.f58688s, aVarArr, 0, i10);
                System.arraycopy(this.f58680k, this.f58688s, iArr, 0, i10);
                int i11 = this.f58688s;
                System.arraycopy(this.f58681l, 0, jArr, i10, i11);
                System.arraycopy(this.f58684o, 0, jArr2, i10, i11);
                System.arraycopy(this.f58683n, 0, iArr2, i10, i11);
                System.arraycopy(this.f58682m, 0, iArr3, i10, i11);
                System.arraycopy(this.f58685p, 0, aVarArr, i10, i11);
                System.arraycopy(this.f58680k, 0, iArr, i10, i11);
                this.f58681l = jArr;
                this.f58684o = jArr2;
                this.f58683n = iArr2;
                this.f58682m = iArr3;
                this.f58685p = aVarArr;
                this.f58680k = iArr;
                this.f58688s = 0;
                this.f58679j = i8;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(long j3, boolean z2, boolean z3) {
        this.f58670a.a(a(j3, z2, z3));
    }

    public final void c(long j3) {
        this.f58690u = j3;
    }

    private synchronized boolean c(e9 e9Var) {
        try {
            this.f58695z = false;
            if (xp.a(e9Var, this.C)) {
                return false;
            }
            if (!this.f58672c.c() && ((c) this.f58672c.b()).f58699a.equals(e9Var)) {
                this.C = ((c) this.f58672c.b()).f58699a;
            } else {
                this.C = e9Var;
            }
            e9 e9Var2 = this.C;
            this.E = hf.a(e9Var2.f59394m, e9Var2.f59391j);
            this.F = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        this.f58670a.a(a());
    }

    private long b(int i3) {
        int iG = g() - i3;
        boolean z2 = false;
        b1.a(iG >= 0 && iG <= this.f58686q - this.f58689t);
        int i4 = this.f58686q - iG;
        this.f58686q = i4;
        this.f58692w = Math.max(this.f58691v, c(i4));
        if (iG == 0 && this.f58693x) {
            z2 = true;
        }
        this.f58693x = z2;
        this.f58672c.a(i3);
        int i5 = this.f58686q;
        if (i5 == 0) {
            return 0L;
        }
        int iD = d(i5 - 1);
        return this.f58681l[iD] + ((long) this.f58682m[iD]);
    }

    protected e9 b(e9 e9Var) {
        return (this.G == 0 || e9Var.f59398q == Long.MAX_VALUE) ? e9Var : e9Var.a().a(e9Var.f59398q + this.G).a();
    }

    public void b(boolean z2) {
        this.f58670a.b();
        this.f58686q = 0;
        this.f58687r = 0;
        this.f58688s = 0;
        this.f58689t = 0;
        this.f58694y = true;
        this.f58690u = Long.MIN_VALUE;
        this.f58691v = Long.MIN_VALUE;
        this.f58692w = Long.MIN_VALUE;
        this.f58693x = false;
        this.f58672c.a();
        if (z2) {
            this.B = null;
            this.C = null;
            this.f58695z = true;
        }
    }

    public final synchronized boolean b(long j3, boolean z2) throws Throwable {
        try {
            try {
                o();
                int iD = d(this.f58689t);
                if (!h() || j3 < this.f58684o[iD] || (j3 > this.f58692w && !z2)) {
                    return false;
                }
                int iA = a(iD, this.f58686q - this.f58689t, j3, true);
                if (iA == -1) {
                    return false;
                }
                this.f58690u = j3;
                this.f58689t += iA;
                return true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private synchronized long a(long j3, boolean z2, boolean z3) throws Throwable {
        Throwable th;
        try {
            try {
                int i3 = this.f58686q;
                if (i3 != 0) {
                    long[] jArr = this.f58684o;
                    int i4 = this.f58688s;
                    if (j3 >= jArr[i4]) {
                        if (z3) {
                            try {
                                int i5 = this.f58689t;
                                if (i5 != i3) {
                                    i3 = i5 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        int iA = a(i4, i3, j3, z2);
                        if (iA == -1) {
                            return -1L;
                        }
                        return a(iA);
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    private synchronized long a() {
        int i3 = this.f58686q;
        if (i3 == 0) {
            return -1L;
        }
        return a(i3);
    }

    private long a(int i3) {
        this.f58691v = Math.max(this.f58691v, c(i3));
        this.f58686q -= i3;
        int i4 = this.f58687r + i3;
        this.f58687r = i4;
        int i5 = this.f58688s + i3;
        this.f58688s = i5;
        int i6 = this.f58679j;
        if (i5 >= i6) {
            this.f58688s = i5 - i6;
        }
        int i7 = this.f58689t - i3;
        this.f58689t = i7;
        if (i7 < 0) {
            this.f58689t = 0;
        }
        this.f58672c.b(i4);
        if (this.f58686q == 0) {
            int i8 = this.f58688s;
            if (i8 == 0) {
                i8 = this.f58679j;
            }
            int i9 = i8 - 1;
            return this.f58681l[i9] + ((long) this.f58682m[i9]);
        }
        return this.f58681l[this.f58688s];
    }

    private int a(int i3, int i4, long j3, boolean z2) {
        int i5 = -1;
        for (int i6 = 0; i6 < i4; i6++) {
            long j4 = this.f58684o[i3];
            if (j4 > j3) {
                break;
            }
            if (!z2 || (this.f58683n[i3] & 1) != 0) {
                if (j4 == j3) {
                    return i6;
                }
                i5 = i6;
            }
            i3++;
            if (i3 == this.f58679j) {
                i3 = 0;
            }
        }
        return i5;
    }

    @Override // com.applovin.impl.qo
    public final void a(e9 e9Var) {
        e9 e9VarB = b(e9Var);
        this.A = false;
        this.B = e9Var;
        boolean zC = c(e9VarB);
        d dVar = this.f58676g;
        if (dVar == null || !zC) {
            return;
        }
        dVar.a(e9VarB);
    }

    public final synchronized int a(long j3, boolean z2) {
        Throwable th;
        try {
            try {
                int iD = d(this.f58689t);
                if (!h() || j3 < this.f58684o[iD]) {
                    return 0;
                }
                if (j3 > this.f58692w && z2) {
                    try {
                        return this.f58686q - this.f58689t;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    int iA = a(iD, this.f58686q - this.f58689t, j3, true);
                    if (iA == -1) {
                        return 0;
                    }
                    return iA;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    public synchronized boolean a(boolean z2) {
        e9 e9Var;
        boolean z3 = true;
        if (!h()) {
            if (!z2 && !this.f58693x && ((e9Var = this.C) == null || e9Var == this.f58677h)) {
                z3 = false;
            }
            return z3;
        }
        if (((c) this.f58672c.c(e())).f58699a != this.f58677h) {
            return true;
        }
        return e(d(this.f58689t));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar) {
        cVar.f58700b.a();
    }

    private void a(e9 e9Var, f9 f9Var) {
        e9 e9Var2 = this.f58677h;
        boolean z2 = e9Var2 == null;
        x6 x6Var = z2 ? null : e9Var2.f59397p;
        this.f58677h = e9Var;
        x6 x6Var2 = e9Var.f59397p;
        a7 a7Var = this.f58673d;
        f9Var.f59641b = a7Var != null ? e9Var.a(a7Var.a(e9Var)) : e9Var;
        f9Var.f59640a = this.f58678i;
        if (this.f58673d == null) {
            return;
        }
        if (z2 || !xp.a(x6Var, x6Var2)) {
            y6 y6Var = this.f58678i;
            y6 y6VarA = this.f58673d.a((Looper) b1.a(this.f58675f), this.f58674e, e9Var);
            this.f58678i = y6VarA;
            f9Var.f59640a = y6VarA;
            if (y6Var != null) {
                y6Var.a(this.f58674e);
            }
        }
    }

    private synchronized int a(f9 f9Var, o5 o5Var, boolean z2, boolean z3, b bVar) {
        try {
            o5Var.f62184d = false;
            if (!h()) {
                if (!z3 && !this.f58693x) {
                    e9 e9Var = this.C;
                    if (e9Var == null || (!z2 && e9Var == this.f58677h)) {
                        return -3;
                    }
                    a((e9) b1.a(e9Var), f9Var);
                    return -5;
                }
                o5Var.e(4);
                return -4;
            }
            e9 e9Var2 = ((c) this.f58672c.c(e())).f58699a;
            if (!z2 && e9Var2 == this.f58677h) {
                int iD = d(this.f58689t);
                if (!e(iD)) {
                    o5Var.f62184d = true;
                    return -3;
                }
                o5Var.e(this.f58683n[iD]);
                long j3 = this.f58684o[iD];
                o5Var.f62185f = j3;
                if (j3 < this.f58690u) {
                    o5Var.b(Integer.MIN_VALUE);
                }
                bVar.f58696a = this.f58682m[iD];
                bVar.f58697b = this.f58681l[iD];
                bVar.f58698c = this.f58685p[iD];
                return -4;
            }
            a(e9Var2, f9Var);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int a(f9 f9Var, o5 o5Var, int i3, boolean z2) {
        int iA = a(f9Var, o5Var, (i3 & 2) != 0, z2, this.f58671b);
        if (iA == -4 && !o5Var.e()) {
            boolean z3 = (i3 & 1) != 0;
            if ((i3 & 4) == 0) {
                if (z3) {
                    this.f58670a.a(o5Var, this.f58671b);
                } else {
                    this.f58670a.b(o5Var, this.f58671b);
                }
            }
            if (!z3) {
                this.f58689t++;
            }
        }
        return iA;
    }

    @Override // com.applovin.impl.qo
    public final int a(f5 f5Var, int i3, boolean z2, int i4) {
        return this.f58670a.a(f5Var, i3, z2);
    }

    @Override // com.applovin.impl.qo
    public final void a(ah ahVar, int i3, int i4) {
        this.f58670a.a(ahVar, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @Override // com.applovin.impl.qo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r12, int r14, int r15, int r16, com.applovin.impl.qo.a r17) {
        /*
            r11 = this;
            boolean r1 = r11.A
            if (r1 == 0) goto Lf
            com.applovin.impl.e9 r1 = r11.B
            java.lang.Object r1 = com.applovin.impl.b1.b(r1)
            com.applovin.impl.e9 r1 = (com.applovin.impl.e9) r1
            r11.a(r1)
        Lf:
            r1 = r14 & 1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L17
            r4 = r3
            goto L18
        L17:
            r4 = r2
        L18:
            boolean r5 = r11.f58694y
            if (r5 == 0) goto L21
            if (r4 != 0) goto L1f
            goto L64
        L1f:
            r11.f58694y = r2
        L21:
            long r5 = r11.G
            long r5 = r5 + r12
            boolean r7 = r11.E
            if (r7 == 0) goto L53
            long r7 = r11.f58690u
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 >= 0) goto L2f
            goto L64
        L2f:
            if (r1 != 0) goto L53
            boolean r1 = r11.F
            if (r1 != 0) goto L4f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "Overriding unexpected non-sync sample for format: "
            r1.append(r7)
            com.applovin.impl.e9 r7 = r11.C
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r7 = "SampleQueue"
            com.applovin.impl.oc.d(r7, r1)
            r11.F = r3
        L4f:
            r1 = r14 | 1
            r3 = r1
            goto L54
        L53:
            r3 = r14
        L54:
            boolean r1 = r11.H
            if (r1 == 0) goto L65
            if (r4 == 0) goto L64
            boolean r1 = r11.a(r5)
            if (r1 != 0) goto L61
            goto L64
        L61:
            r11.H = r2
            goto L65
        L64:
            return
        L65:
            com.applovin.impl.aj r1 = r11.f58670a
            long r1 = r1.a()
            long r7 = (long) r15
            long r1 = r1 - r7
            r7 = r16
            long r7 = (long) r7
            long r1 = r1 - r7
            r9 = r5
            r4 = r1
            r1 = r9
            r0 = r11
            r6 = r15
            r7 = r17
            r0.a(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.bj.a(long, int, int, int, com.applovin.impl.qo$a):void");
    }

    public final void a(d dVar) {
        this.f58676g = dVar;
    }

    public static bj a(n0 n0Var, Looper looper, a7 a7Var, z6.a aVar) {
        return new bj(n0Var, (Looper) b1.a(looper), (a7) b1.a(a7Var), (z6.a) b1.a(aVar));
    }
}
