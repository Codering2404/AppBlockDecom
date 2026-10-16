package com.applovin.impl;

import com.applovin.impl.e9;
import com.applovin.impl.ij;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class q0 implements j8 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f62529r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f62532u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f62533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f62534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f62535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f62536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f62537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f62539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f62540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f62541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f62542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f62543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private l8 f62544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private qo f62545m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ij f62546n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f62547o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final n8 f62527p = new n8() { // from class: com.applovin.impl.t00
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return q0.c();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f62528q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f62530s = xp.c("#!AMR\n");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f62531t = xp.c("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f62529r = iArr;
        f62532u = iArr[8];
    }

    public q0() {
        this(0);
    }

    private void b() {
        b1.b(this.f62545m);
        xp.a(this.f62544l);
    }

    private boolean c(int i3) {
        if (i3 < 0 || i3 > 15) {
            return false;
        }
        return d(i3) || b(i3);
    }

    private boolean d(int i3) {
        if (this.f62535c) {
            return i3 < 10 || i3 > 13;
        }
        return false;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public q0(int i3) {
        this.f62534b = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f62533a = new byte[1];
        this.f62541i = -1;
    }

    private static int a(int i3, long j3) {
        return (int) ((((long) (i3 * 8)) * 1000000) / j3);
    }

    private boolean c(k8 k8Var) {
        byte[] bArr = f62530s;
        if (a(k8Var, bArr)) {
            this.f62535c = false;
            k8Var.a(bArr.length);
            return true;
        }
        byte[] bArr2 = f62531t;
        if (!a(k8Var, bArr2)) {
            return false;
        }
        this.f62535c = true;
        k8Var.a(bArr2.length);
        return true;
    }

    private void d() {
        if (this.f62547o) {
            return;
        }
        this.f62547o = true;
        boolean z2 = this.f62535c;
        this.f62545m.a(new e9.b().f(z2 ? "audio/amr-wb" : "audio/3gpp").i(f62532u).c(1).n(z2 ? 16000 : 8000).a());
    }

    private ij a(long j3, boolean z2) {
        return new o4(j3, this.f62540h, a(this.f62541i, 20000L), this.f62541i, z2);
    }

    private boolean b(int i3) {
        if (this.f62535c) {
            return false;
        }
        return i3 < 12 || i3 > 14;
    }

    private int b(k8 k8Var) throws ch {
        k8Var.b();
        k8Var.c(this.f62533a, 0, 1);
        byte b3 = this.f62533a[0];
        if ((b3 & 131) <= 0) {
            return a((b3 >> 3) & 15);
        }
        throw ch.a("Invalid padding bits for frame header " + ((int) b3), null);
    }

    private int a(int i3) throws ch {
        if (c(i3)) {
            return this.f62535c ? f62529r[i3] : f62528q[i3];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f62535c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i3);
        throw ch.a(sb.toString(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] c() {
        return new j8[]{new q0()};
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f62544l = l8Var;
        this.f62545m = l8Var.a(0, 1);
        l8Var.c();
    }

    private int d(k8 k8Var) throws ch {
        if (this.f62538f == 0) {
            try {
                int iB = b(k8Var);
                this.f62537e = iB;
                this.f62538f = iB;
                if (this.f62541i == -1) {
                    this.f62540h = k8Var.f();
                    this.f62541i = this.f62537e;
                }
                if (this.f62541i == this.f62537e) {
                    this.f62542j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iA = this.f62545m.a((f5) k8Var, this.f62538f, true);
        if (iA == -1) {
            return -1;
        }
        int i3 = this.f62538f - iA;
        this.f62538f = i3;
        if (i3 > 0) {
            return 0;
        }
        this.f62545m.a(this.f62543k + this.f62536d, 1, this.f62537e, 0, null);
        this.f62536d += 20000;
        return 0;
    }

    private void a(long j3, int i3) {
        int i4;
        if (this.f62539g) {
            return;
        }
        int i5 = this.f62534b;
        if ((i5 & 1) != 0 && j3 != -1 && ((i4 = this.f62541i) == -1 || i4 == this.f62537e)) {
            if (this.f62542j >= 20 || i3 == -1) {
                ij ijVarA = a(j3, (i5 & 2) != 0);
                this.f62546n = ijVarA;
                this.f62544l.a(ijVarA);
                this.f62539g = true;
                return;
            }
            return;
        }
        ij.b bVar = new ij.b(-9223372036854775807L);
        this.f62546n = bVar;
        this.f62544l.a(bVar);
        this.f62539g = true;
    }

    private static boolean a(k8 k8Var, byte[] bArr) {
        k8Var.b();
        byte[] bArr2 = new byte[bArr.length];
        k8Var.c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        b();
        if (k8Var.f() == 0 && !c(k8Var)) {
            throw ch.a("Could not find AMR header.", null);
        }
        d();
        int iD = d(k8Var);
        a(k8Var.a(), iD);
        return iD;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f62536d = 0L;
        this.f62537e = 0;
        this.f62538f = 0;
        if (j3 != 0) {
            ij ijVar = this.f62546n;
            if (ijVar instanceof o4) {
                this.f62543k = ((o4) ijVar).d(j3);
                return;
            }
        }
        this.f62543k = 0L;
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        return c(k8Var);
    }
}
