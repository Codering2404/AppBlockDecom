package com.applovin.impl;

import com.applovin.impl.af;
import com.applovin.impl.e9;
import com.applovin.impl.lj;
import com.applovin.impl.sf;
import com.applovin.impl.wa;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class nf implements j8 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final n8 f62023u = new n8() { // from class: com.applovin.impl.uz
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return nf.d();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final wa.a f62024v = new wa.a() { // from class: com.applovin.impl.vz
        @Override // com.applovin.impl.wa.a
        public final boolean a(int i3, int i4, int i5, int i6, int i7) {
            return nf.a(i3, i4, i5, i6, i7);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f62025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f62026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f62027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final sf.a f62028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y9 f62029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ya f62030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final qo f62031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l8 f62032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private qo f62033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private qo f62034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f62035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private af f62036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f62037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f62038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f62039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f62040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private lj f62041q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f62042r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f62043s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f62044t;

    public nf() {
        this(0);
    }

    private void b() {
        b1.b(this.f62033i);
        xp.a(this.f62032h);
    }

    private boolean d(k8 k8Var) {
        lj ljVar = this.f62041q;
        if (ljVar != null) {
            long jC = ljVar.c();
            if (jC != -1 && k8Var.d() > jC - 4) {
                return true;
            }
        }
        try {
            return !k8Var.b(this.f62027c.c(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public void c() {
        this.f62042r = true;
    }

    public nf(int i3) {
        this(i3, -9223372036854775807L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 67 && i5 == 79 && i6 == 77 && (i7 == 77 || i3 == 2)) {
            return true;
        }
        if (i4 == 77 && i5 == 76 && i6 == 76) {
            return i7 == 84 || i3 == 2;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.applovin.impl.lj c(com.applovin.impl.k8 r11) {
        /*
            r10 = this;
            com.applovin.impl.ah r5 = new com.applovin.impl.ah
            com.applovin.impl.sf$a r0 = r10.f62028d
            int r0 = r0.f63704c
            r5.<init>(r0)
            byte[] r0 = r5.c()
            com.applovin.impl.sf$a r1 = r10.f62028d
            int r1 = r1.f63704c
            r6 = 0
            r11.c(r0, r6, r1)
            com.applovin.impl.sf$a r0 = r10.f62028d
            int r1 = r0.f63702a
            r2 = 1
            r1 = r1 & r2
            if (r1 == 0) goto L25
            int r0 = r0.f63706e
            if (r0 == r2) goto L29
            r0 = 36
        L23:
            r7 = r0
            goto L2f
        L25:
            int r0 = r0.f63706e
            if (r0 == r2) goto L2c
        L29:
            r0 = 21
            goto L23
        L2c:
            r0 = 13
            goto L23
        L2f:
            int r8 = a(r5, r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L5e
            if (r8 != r9) goto L3e
            goto L5e
        L3e:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L59
            long r0 = r11.a()
            long r2 = r11.f()
            com.applovin.impl.sf$a r4 = r10.f62028d
            com.applovin.impl.pq r0 = com.applovin.impl.pq.a(r0, r2, r4, r5)
            com.applovin.impl.sf$a r1 = r10.f62028d
            int r1 = r1.f63704c
            r11.a(r1)
            return r0
        L59:
            r11.b()
            r11 = 0
            return r11
        L5e:
            long r0 = r11.a()
            long r2 = r11.f()
            com.applovin.impl.sf$a r4 = r10.f62028d
            com.applovin.impl.ds r0 = com.applovin.impl.ds.a(r0, r2, r4, r5)
            if (r0 == 0) goto L98
            com.applovin.impl.y9 r1 = r10.f62029e
            boolean r1 = r1.a()
            if (r1 != 0) goto L98
            r11.b()
            int r7 = r7 + 141
            r11.c(r7)
            com.applovin.impl.ah r1 = r10.f62027c
            byte[] r1 = r1.c()
            r2 = 3
            r11.c(r1, r6, r2)
            com.applovin.impl.ah r1 = r10.f62027c
            r1.f(r6)
            com.applovin.impl.y9 r1 = r10.f62029e
            com.applovin.impl.ah r2 = r10.f62027c
            int r2 = r2.z()
            r1.a(r2)
        L98:
            com.applovin.impl.sf$a r1 = r10.f62028d
            int r1 = r1.f63704c
            r11.a(r1)
            if (r0 == 0) goto Lae
            boolean r1 = r0.b()
            if (r1 != 0) goto Lae
            if (r8 != r9) goto Lae
            com.applovin.impl.lj r11 = r10.a(r11, r6)
            return r11
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.nf.c(com.applovin.impl.k8):com.applovin.impl.lj");
    }

    private int e(k8 k8Var) throws Throwable {
        if (this.f62035k == 0) {
            try {
                b(k8Var, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f62041q == null) {
            lj ljVarB = b(k8Var);
            this.f62041q = ljVarB;
            this.f62032h.a(ljVarB);
            this.f62034j.a(new e9.b().f(this.f62028d.f63703b).i(4096).c(this.f62028d.f63706e).n(this.f62028d.f63705d).e(this.f62029e.f65174a).f(this.f62029e.f65175b).a((this.f62025a & 8) != 0 ? null : this.f62036l).a());
            this.f62039o = k8Var.f();
        } else if (this.f62039o != 0) {
            long jF = k8Var.f();
            long j3 = this.f62039o;
            if (jF < j3) {
                k8Var.a((int) (j3 - jF));
            }
        }
        return f(k8Var);
    }

    private int f(k8 k8Var) {
        if (this.f62040p == 0) {
            k8Var.b();
            if (d(k8Var)) {
                return -1;
            }
            this.f62027c.f(0);
            int iJ = this.f62027c.j();
            if (!a(iJ, this.f62035k) || sf.b(iJ) == -1) {
                k8Var.a(1);
                this.f62035k = 0;
                return 0;
            }
            this.f62028d.a(iJ);
            if (this.f62037m == -9223372036854775807L) {
                this.f62037m = this.f62041q.a(k8Var.f());
                if (this.f62026b != -9223372036854775807L) {
                    this.f62037m += this.f62026b - this.f62041q.a(0L);
                }
            }
            sf.a aVar = this.f62028d;
            this.f62040p = aVar.f63704c;
            lj ljVar = this.f62041q;
            if (ljVar instanceof mb) {
                mb mbVar = (mb) ljVar;
                mbVar.a(a(this.f62038n + ((long) aVar.f63708g)), k8Var.f() + ((long) this.f62028d.f63704c));
                if (this.f62043s && mbVar.c(this.f62044t)) {
                    this.f62043s = false;
                    this.f62034j = this.f62033i;
                }
            }
        }
        int iA = this.f62034j.a((f5) k8Var, this.f62040p, true);
        if (iA == -1) {
            return -1;
        }
        int i3 = this.f62040p - iA;
        this.f62040p = i3;
        if (i3 > 0) {
            return 0;
        }
        this.f62034j.a(a(this.f62038n), 1, this.f62028d.f63704c, 0, null);
        this.f62038n += (long) this.f62028d.f63708g;
        this.f62040p = 0;
        return 0;
    }

    public nf(int i3, long j3) {
        this.f62025a = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f62026b = j3;
        this.f62027c = new ah(10);
        this.f62028d = new sf.a();
        this.f62029e = new y9();
        this.f62037m = -9223372036854775807L;
        this.f62030f = new ya();
        h7 h7Var = new h7();
        this.f62031g = h7Var;
        this.f62034j = h7Var;
    }

    private static boolean a(int i3, long j3) {
        return ((long) (i3 & (-128000))) == (j3 & (-128000));
    }

    private lj b(k8 k8Var) {
        long jA;
        long jC;
        lj ljVarC = c(k8Var);
        jf jfVarA = a(this.f62036l, k8Var.f());
        if (this.f62042r) {
            return new lj.a();
        }
        if ((this.f62025a & 4) != 0) {
            if (jfVarA != null) {
                jA = jfVarA.d();
                jC = jfVarA.c();
            } else if (ljVarC != null) {
                jA = ljVarC.d();
                jC = ljVarC.c();
            } else {
                jA = a(this.f62036l);
                jC = -1;
            }
            ljVarC = new mb(jA, k8Var.f(), jC);
        } else if (jfVarA != null) {
            ljVarC = jfVarA;
        } else if (ljVarC == null) {
            ljVarC = null;
        }
        if (ljVarC == null || !(ljVarC.b() || (this.f62025a & 1) == 0)) {
            return a(k8Var, (this.f62025a & 2) != 0);
        }
        return ljVarC;
    }

    private long a(long j3) {
        return this.f62037m + ((j3 * 1000000) / ((long) this.f62028d.f63705d));
    }

    private lj a(k8 k8Var, boolean z2) {
        k8Var.c(this.f62027c.c(), 0, 4);
        this.f62027c.f(0);
        this.f62028d.a(this.f62027c.j());
        return new p4(k8Var.a(), k8Var.f(), this.f62028d, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] d() {
        return new j8[]{new nf()};
    }

    private static long a(af afVar) {
        if (afVar == null) {
            return -9223372036854775807L;
        }
        int iC = afVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            af.b bVarA = afVar.a(i3);
            if (bVarA instanceof zn) {
                zn znVar = (zn) bVarA;
                if (znVar.f64884a.equals("TLEN")) {
                    return t2.a(Long.parseLong(znVar.f65472c));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int a(ah ahVar, int i3) {
        if (ahVar.e() >= i3 + 4) {
            ahVar.f(i3);
            int iJ = ahVar.j();
            if (iJ == 1483304551 || iJ == 1231971951) {
                return iJ;
            }
        }
        if (ahVar.e() < 40) {
            return 0;
        }
        ahVar.f(36);
        return ahVar.j() == 1447187017 ? 1447187017 : 0;
    }

    private boolean b(k8 k8Var, boolean z2) throws Throwable {
        int iD;
        int i3;
        int iB;
        int i4 = z2 ? 32768 : 131072;
        k8Var.b();
        if (k8Var.f() == 0) {
            af afVarA = this.f62030f.a(k8Var, (this.f62025a & 8) == 0 ? null : f62024v);
            this.f62036l = afVarA;
            if (afVarA != null) {
                this.f62029e.a(afVarA);
            }
            iD = (int) k8Var.d();
            if (!z2) {
                k8Var.a(iD);
            }
            i3 = 0;
        } else {
            iD = 0;
            i3 = 0;
        }
        int i5 = i3;
        int i6 = i5;
        while (true) {
            if (!d(k8Var)) {
                this.f62027c.f(0);
                int iJ = this.f62027c.j();
                if ((i3 == 0 || a(iJ, i3)) && (iB = sf.b(iJ)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.f62028d.a(iJ);
                        i3 = iJ;
                    }
                    k8Var.c(iB - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 == i4) {
                        if (z2) {
                            return false;
                        }
                        throw ch.a("Searched too many bytes.", null);
                    }
                    if (z2) {
                        k8Var.b();
                        k8Var.c(iD + i7);
                    } else {
                        k8Var.a(1);
                    }
                    i5 = 0;
                    i6 = i7;
                    i3 = 0;
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            k8Var.a(iD + i6);
        } else {
            k8Var.b();
        }
        this.f62035k = i3;
        return true;
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f62032h = l8Var;
        qo qoVarA = l8Var.a(0, 1);
        this.f62033i = qoVarA;
        this.f62034j = qoVarA;
        this.f62032h.c();
    }

    private static jf a(af afVar, long j3) {
        if (afVar == null) {
            return null;
        }
        int iC = afVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            af.b bVarA = afVar.a(i3);
            if (bVarA instanceof Cif) {
                return jf.a(j3, (Cif) bVarA, a(afVar));
            }
        }
        return null;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws Throwable {
        b();
        int iE = e(k8Var);
        if (iE == -1 && (this.f62041q instanceof mb)) {
            long jA = a(this.f62038n);
            if (this.f62041q.d() != jA) {
                ((mb) this.f62041q).d(jA);
                this.f62032h.a(this.f62041q);
            }
        }
        return iE;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f62035k = 0;
        this.f62037m = -9223372036854775807L;
        this.f62038n = 0L;
        this.f62040p = 0;
        this.f62044t = j4;
        lj ljVar = this.f62041q;
        if (!(ljVar instanceof mb) || ((mb) ljVar).c(j4)) {
            return;
        }
        this.f62043s = true;
        this.f62034j = this.f62031g;
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        return b(k8Var, true);
    }
}
