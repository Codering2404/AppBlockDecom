package com.applovin.impl;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.impl.e9;
import com.applovin.impl.ij;
import com.applovin.impl.j1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class of implements j8, ij {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n8 f62270y = new n8() { // from class: com.applovin.impl.k00
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return of.f();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f62271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f62272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f62273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ah f62274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ah f62275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f62276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final mj f62277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f62278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f62279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f62280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f62281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f62282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ah f62283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f62284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f62285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f62286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f62287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private l8 f62288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a[] f62289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long[][] f62290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f62291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f62292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f62293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private mf f62294x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lo f62295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ro f62296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final qo f62297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f62298d;

        public a(lo loVar, ro roVar, qo qoVar) {
            this.f62295a = loVar;
            this.f62296b = roVar;
            this.f62297c = qoVar;
        }
    }

    public of() {
        this(0);
    }

    private static int a(int i3) {
        if (i3 != 1751476579) {
            return i3 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static boolean c(int i3) {
        return i3 == 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124;
    }

    private void e() {
        this.f62279i = 0;
        this.f62282l = 0;
    }

    private void f(long j3) {
        for (a aVar : this.f62289s) {
            ro roVar = aVar.f62296b;
            int iA = roVar.a(j3);
            if (iA == -1) {
                iA = roVar.b(j3);
            }
            aVar.f62298d = iA;
        }
    }

    private void g() {
        if (this.f62293w != 2 || (this.f62271a & 2) == 0) {
            return;
        }
        l8 l8Var = (l8) b1.a(this.f62288r);
        l8Var.a(0, 4).a(new e9.b().a(this.f62294x == null ? null : new af(this.f62294x)).a());
        l8Var.c();
        l8Var.a(new ij.b(-9223372036854775807L));
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f62292v;
    }

    public of(int i3) {
        this.f62271a = i3;
        this.f62279i = (i3 & 4) != 0 ? 3 : 0;
        this.f62277g = new mj();
        this.f62278h = new ArrayList();
        this.f62275e = new ah(16);
        this.f62276f = new ArrayDeque();
        this.f62272b = new ah(yf.f65192a);
        this.f62273c = new ah(4);
        this.f62274d = new ah();
        this.f62284n = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ lo a(lo loVar) {
        return loVar;
    }

    private int c(long j3) {
        int i3 = -1;
        int i4 = -1;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        boolean z3 = true;
        long j6 = Long.MAX_VALUE;
        for (int i5 = 0; i5 < ((a[]) xp.a((Object) this.f62289s)).length; i5++) {
            a aVar = this.f62289s[i5];
            int i6 = aVar.f62298d;
            ro roVar = aVar.f62296b;
            if (i6 != roVar.f62896b) {
                long j7 = roVar.f62897c[i6];
                long j8 = ((long[][]) xp.a((Object) this.f62290t))[i5][i6];
                long j9 = j7 - j3;
                boolean z4 = j9 < 0 || j9 >= 262144;
                if ((!z4 && z3) || (z4 == z3 && j9 < j6)) {
                    j5 = j8;
                    z3 = z4;
                    i4 = i5;
                    j6 = j9;
                }
                if (j8 < j4) {
                    j4 = j8;
                    z2 = z4;
                    i3 = i5;
                }
            }
        }
        return (j4 == Long.MAX_VALUE || !z2 || j5 < j4 + 10485760) ? i4 : i3;
    }

    private void d(long j3) {
        while (!this.f62276f.isEmpty() && ((j1.a) this.f62276f.peek()).f60572b == j3) {
            j1.a aVar = (j1.a) this.f62276f.pop();
            if (aVar.f60571a == 1836019574) {
                a(aVar);
                this.f62276f.clear();
                this.f62279i = 2;
            } else if (!this.f62276f.isEmpty()) {
                ((j1.a) this.f62276f.peek()).a(aVar);
            }
        }
        if (this.f62279i != 2) {
            e();
        }
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    private static boolean b(int i3) {
        return i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473;
    }

    private void e(long j3) {
        if (this.f62280j == 1836086884) {
            long j4 = this.f62282l;
            this.f62294x = new mf(0L, j3, -9223372036854775807L, j3 + j4, this.f62281k - j4);
        }
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            jArr[i3] = new long[aVarArr[i3].f62296b.f62896b];
            jArr2[i3] = aVarArr[i3].f62296b.f62900f[0];
        }
        long j3 = 0;
        int i4 = 0;
        while (i4 < aVarArr.length) {
            long j4 = Long.MAX_VALUE;
            int i5 = -1;
            for (int i6 = 0; i6 < aVarArr.length; i6++) {
                if (!zArr[i6]) {
                    long j5 = jArr2[i6];
                    if (j5 <= j4) {
                        i5 = i6;
                        j4 = j5;
                    }
                }
            }
            int i7 = iArr[i5];
            long[] jArr3 = jArr[i5];
            jArr3[i7] = j3;
            ro roVar = aVarArr[i5].f62296b;
            j3 += (long) roVar.f62898d[i7];
            int i8 = i7 + 1;
            iArr[i5] = i8;
            if (i8 < jArr3.length) {
                jArr2[i5] = roVar.f62900f[i8];
            } else {
                zArr[i5] = true;
                i4++;
            }
        }
        return jArr;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        long j4;
        long jA;
        long j5;
        long j6;
        int iB;
        if (((a[]) b1.a(this.f62289s)).length == 0) {
            return new ij.a(kj.f61037c);
        }
        int i3 = this.f62291u;
        if (i3 != -1) {
            ro roVar = this.f62289s[i3].f62296b;
            int iA = a(roVar, j3);
            if (iA == -1) {
                return new ij.a(kj.f61037c);
            }
            long j7 = roVar.f62900f[iA];
            j4 = roVar.f62897c[iA];
            if (j7 >= j3 || iA >= roVar.f62896b - 1 || (iB = roVar.b(j3)) == -1 || iB == iA) {
                j6 = -1;
                j5 = -9223372036854775807L;
            } else {
                j5 = roVar.f62900f[iB];
                j6 = roVar.f62897c[iB];
            }
            jA = j6;
            j3 = j7;
        } else {
            j4 = Long.MAX_VALUE;
            jA = -1;
            j5 = -9223372036854775807L;
        }
        int i4 = 0;
        while (true) {
            a[] aVarArr = this.f62289s;
            if (i4 >= aVarArr.length) {
                break;
            }
            if (i4 != this.f62291u) {
                ro roVar2 = aVarArr[i4].f62296b;
                long jA2 = a(roVar2, j3, j4);
                if (j5 != -9223372036854775807L) {
                    jA = a(roVar2, j5, jA);
                }
                j4 = jA2;
            }
            i4++;
        }
        kj kjVar = new kj(j3, j4);
        if (j5 == -9223372036854775807L) {
            return new ij.a(kjVar);
        }
        return new ij.a(kjVar, new kj(j5, jA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] f() {
        return new j8[]{new of()};
    }

    private boolean c(k8 k8Var) throws ch {
        j1.a aVar;
        if (this.f62282l == 0) {
            if (!k8Var.a(this.f62275e.c(), 0, 8, true)) {
                g();
                return false;
            }
            this.f62282l = 8;
            this.f62275e.f(0);
            this.f62281k = this.f62275e.y();
            this.f62280j = this.f62275e.j();
        }
        long j3 = this.f62281k;
        if (j3 == 1) {
            k8Var.d(this.f62275e.c(), 8, 8);
            this.f62282l += 8;
            this.f62281k = this.f62275e.B();
        } else if (j3 == 0) {
            long jA = k8Var.a();
            if (jA == -1 && (aVar = (j1.a) this.f62276f.peek()) != null) {
                jA = aVar.f60572b;
            }
            if (jA != -1) {
                this.f62281k = (jA - k8Var.f()) + ((long) this.f62282l);
            }
        }
        if (this.f62281k >= this.f62282l) {
            if (b(this.f62280j)) {
                long jF = k8Var.f();
                long j4 = this.f62281k;
                long j5 = this.f62282l;
                long j6 = (jF + j4) - j5;
                if (j4 != j5 && this.f62280j == 1835365473) {
                    b(k8Var);
                }
                this.f62276f.push(new j1.a(this.f62280j, j6));
                if (this.f62281k == this.f62282l) {
                    d(j6);
                } else {
                    e();
                }
            } else if (c(this.f62280j)) {
                b1.b(this.f62282l == 8);
                b1.b(this.f62281k <= 2147483647L);
                ah ahVar = new ah((int) this.f62281k);
                System.arraycopy(this.f62275e.c(), 0, ahVar.c(), 0, 8);
                this.f62283m = ahVar;
                this.f62279i = 1;
            } else {
                e(k8Var.f() - ((long) this.f62282l));
                this.f62283m = null;
                this.f62279i = 1;
            }
            return true;
        }
        throw ch.a("Atom size less than header length (unsupported).");
    }

    private int d(k8 k8Var, th thVar) throws ch {
        int iA = this.f62277g.a(k8Var, thVar, this.f62278h);
        if (iA == 1 && thVar.f63943a == 0) {
            e();
        }
        return iA;
    }

    private static int a(ro roVar, long j3) {
        int iA = roVar.a(j3);
        return iA == -1 ? roVar.b(j3) : iA;
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f62288r = l8Var;
    }

    private static long a(ro roVar, long j3, long j4) {
        int iA = a(roVar, j3);
        return iA == -1 ? j4 : Math.min(roVar.f62897c[iA], j4);
    }

    private void b(k8 k8Var) {
        this.f62274d.d(8);
        k8Var.c(this.f62274d.c(), 0, 8);
        k1.a(this.f62274d);
        k8Var.a(this.f62274d.d());
        k8Var.b();
    }

    private static int a(ah ahVar) {
        ahVar.f(8);
        int iA = a(ahVar.j());
        if (iA != 0) {
            return iA;
        }
        ahVar.g(4);
        while (ahVar.a() > 0) {
            int iA2 = a(ahVar.j());
            if (iA2 != 0) {
                return iA2;
            }
        }
        return 0;
    }

    private boolean b(k8 k8Var, th thVar) {
        boolean z2;
        long j3 = this.f62281k - ((long) this.f62282l);
        long jF = k8Var.f() + j3;
        ah ahVar = this.f62283m;
        if (ahVar != null) {
            k8Var.d(ahVar.c(), this.f62282l, (int) j3);
            if (this.f62280j == 1718909296) {
                this.f62293w = a(ahVar);
            } else if (!this.f62276f.isEmpty()) {
                ((j1.a) this.f62276f.peek()).a(new j1.b(this.f62280j, ahVar));
            }
        } else if (j3 < 262144) {
            k8Var.a((int) j3);
        } else {
            thVar.f63943a = k8Var.f() + j3;
            z2 = true;
            d(jF);
            return (z2 || this.f62279i == 2) ? false : true;
        }
        z2 = false;
        d(jF);
        if (z2) {
        }
    }

    private void a(j1.a aVar) {
        af afVar;
        af afVar2;
        List list;
        int i3;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        boolean z4 = this.f62293w == 1;
        y9 y9Var = new y9();
        j1.b bVarE = aVar.e(1969517665);
        if (bVarE != null) {
            Pair pairA = k1.a(bVarE);
            af afVar3 = (af) pairA.first;
            af afVar4 = (af) pairA.second;
            if (afVar3 != null) {
                y9Var.a(afVar3);
            }
            afVar = afVar4;
            afVar2 = afVar3;
        } else {
            afVar = null;
            afVar2 = null;
        }
        j1.a aVarD = aVar.d(1835365473);
        af afVarB = aVarD != null ? k1.b(aVarD) : null;
        List listA = k1.a(aVar, y9Var, -9223372036854775807L, (x6) null, (this.f62271a & 1) != 0, z4, new Function() { // from class: com.applovin.impl.j00
            @Override // com.applovin.exoplayer2.common.base.Function
            public final Object apply(Object obj) {
                return of.a((lo) obj);
            }
        });
        l8 l8Var = (l8) b1.a(this.f62288r);
        int size = listA.size();
        long j3 = -9223372036854775807L;
        int i4 = 0;
        int size2 = -1;
        while (i4 < size) {
            ro roVar = (ro) listA.get(i4);
            if (roVar.f62896b == 0) {
                list = listA;
                i3 = size;
                z2 = z3;
            } else {
                lo loVar = roVar.f62895a;
                int i5 = size2;
                long j4 = loVar.f61253e;
                if (j4 == -9223372036854775807L) {
                    j4 = roVar.f62902h;
                }
                long jMax = Math.max(j3, j4);
                list = listA;
                i3 = size;
                a aVar2 = new a(loVar, roVar, l8Var.a(i4, loVar.f61250b));
                int i6 = roVar.f62899e + 30;
                e9.b bVarA = loVar.f61254f.a();
                bVarA.i(i6);
                if (loVar.f61250b != 2 || j4 <= 0) {
                    z2 = true;
                } else {
                    int i7 = roVar.f62896b;
                    z2 = true;
                    if (i7 > 1) {
                        bVarA.a(i7 / (j4 / 1000000.0f));
                    }
                }
                gf.a(loVar.f61250b, y9Var, bVarA);
                gf.a(loVar.f61250b, afVar2, afVarB, bVarA, afVar, this.f62278h.isEmpty() ? null : new af(this.f62278h));
                aVar2.f62297c.a(bVarA.a());
                size2 = (loVar.f61250b == 2 && i5 == -1) ? arrayList.size() : i5;
                arrayList.add(aVar2);
                j3 = jMax;
            }
            i4++;
            z3 = z2;
            listA = list;
            size = i3;
        }
        this.f62291u = size2;
        this.f62292v = j3;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.f62289s = aVarArr;
        this.f62290t = a(aVarArr);
        l8Var.c();
        l8Var.a(this);
    }

    private int c(k8 k8Var, th thVar) throws ch {
        long jF = k8Var.f();
        if (this.f62284n == -1) {
            int iC = c(jF);
            this.f62284n = iC;
            if (iC == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) xp.a((Object) this.f62289s))[this.f62284n];
        qo qoVar = aVar.f62297c;
        int i3 = aVar.f62298d;
        ro roVar = aVar.f62296b;
        long j3 = roVar.f62897c[i3];
        int i4 = roVar.f62898d[i3];
        long j4 = (j3 - jF) + ((long) this.f62285o);
        if (j4 >= 0 && j4 < 262144) {
            if (aVar.f62295a.f61255g == 1) {
                j4 += 8;
                i4 -= 8;
            }
            k8Var.a((int) j4);
            lo loVar = aVar.f62295a;
            if (loVar.f61258j != 0) {
                byte[] bArrC = this.f62273c.c();
                bArrC[0] = 0;
                bArrC[1] = 0;
                bArrC[2] = 0;
                int i5 = aVar.f62295a.f61258j;
                int i6 = 4 - i5;
                while (this.f62286p < i4) {
                    int i7 = this.f62287q;
                    if (i7 == 0) {
                        k8Var.d(bArrC, i6, i5);
                        this.f62285o += i5;
                        this.f62273c.f(0);
                        int iJ = this.f62273c.j();
                        if (iJ >= 0) {
                            this.f62287q = iJ;
                            this.f62272b.f(0);
                            qoVar.a(this.f62272b, 4);
                            this.f62286p += 4;
                            i4 += i6;
                        } else {
                            throw ch.a("Invalid NAL length", null);
                        }
                    } else {
                        int iA = qoVar.a((f5) k8Var, i7, false);
                        this.f62285o += iA;
                        this.f62286p += iA;
                        this.f62287q -= iA;
                    }
                }
            } else {
                if ("audio/ac4".equals(loVar.f61254f.f59394m)) {
                    if (this.f62286p == 0) {
                        n.a(i4, this.f62274d);
                        qoVar.a(this.f62274d, 7);
                        this.f62286p += 7;
                    }
                    i4 += 7;
                }
                while (true) {
                    int i8 = this.f62286p;
                    if (i8 >= i4) {
                        break;
                    }
                    int iA2 = qoVar.a((f5) k8Var, i4 - i8, false);
                    this.f62285o += iA2;
                    this.f62286p += iA2;
                    this.f62287q -= iA2;
                }
            }
            int i9 = i4;
            ro roVar2 = aVar.f62296b;
            qoVar.a(roVar2.f62900f[i3], roVar2.f62901g[i3], i9, 0, null);
            aVar.f62298d++;
            this.f62284n = -1;
            this.f62285o = 0;
            this.f62286p = 0;
            this.f62287q = 0;
            return 0;
        }
        thVar.f63943a = j3;
        return 1;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        while (true) {
            int i3 = this.f62279i;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return c(k8Var, thVar);
                    }
                    if (i3 == 3) {
                        return d(k8Var, thVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(k8Var, thVar)) {
                    return 1;
                }
            } else if (!c(k8Var)) {
                return -1;
            }
        }
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f62276f.clear();
        this.f62282l = 0;
        this.f62284n = -1;
        this.f62285o = 0;
        this.f62286p = 0;
        this.f62287q = 0;
        if (j3 == 0) {
            if (this.f62279i != 3) {
                e();
                return;
            } else {
                this.f62277g.a();
                this.f62278h.clear();
                return;
            }
        }
        if (this.f62289s != null) {
            f(j4);
        }
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        return lk.a(k8Var, (this.f62271a & 2) != 0);
    }
}
