package com.applovin.impl;

import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.impl.e9;
import com.applovin.impl.ij;
import com.applovin.impl.j1;
import com.applovin.impl.x6;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class i9 implements j8 {
    public static final n8 I = new n8() { // from class: com.applovin.impl.xx
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return i9.d();
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final e9 K = new e9.b().f("application/x-emsg").a();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private l8 E;
    private qo[] F;
    private qo[] G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f60373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final lo f60374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f60375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f60376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ah f60377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ah f60378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ah f60379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f60380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ah f60381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ho f60382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final x7 f60383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ah f60384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ArrayDeque f60385m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque f60386n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final qo f60387o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f60388p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f60389q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f60390r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f60391s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ah f60392t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f60393u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f60394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f60395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f60396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f60397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b f60398z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f60399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60400b;

        public a(long j3, int i3) {
            this.f60399a = j3;
            this.f60400b = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qo f60401a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ro f60404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public k6 f60405e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f60406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f60407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f60408h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f60409i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f60412l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final no f60402b = new no();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ah f60403c = new ah();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ah f60410j = new ah(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ah f60411k = new ah();

        public b(qo qoVar, ro roVar, k6 k6Var) {
            this.f60401a = qoVar;
            this.f60404d = roVar;
            this.f60405e = k6Var;
            a(roVar, k6Var);
        }

        public long b() {
            return !this.f60412l ? this.f60404d.f62897c[this.f60406f] : this.f60402b.f62105g[this.f60408h];
        }

        public long c() {
            return !this.f60412l ? this.f60404d.f62900f[this.f60406f] : this.f60402b.a(this.f60406f);
        }

        public int d() {
            return !this.f60412l ? this.f60404d.f62898d[this.f60406f] : this.f60402b.f62107i[this.f60406f];
        }

        public mo e() {
            if (!this.f60412l) {
                return null;
            }
            int i3 = ((k6) xp.a(this.f60402b.f62099a)).f60934a;
            mo moVarA = this.f60402b.f62113o;
            if (moVarA == null) {
                moVarA = this.f60404d.f62895a.a(i3);
            }
            if (moVarA == null || !moVarA.f61916a) {
                return null;
            }
            return moVarA;
        }

        public boolean f() {
            this.f60406f++;
            if (!this.f60412l) {
                return false;
            }
            int i3 = this.f60407g + 1;
            this.f60407g = i3;
            int[] iArr = this.f60402b.f62106h;
            int i4 = this.f60408h;
            if (i3 != iArr[i4]) {
                return true;
            }
            this.f60408h = i4 + 1;
            this.f60407g = 0;
            return false;
        }

        public void g() {
            this.f60402b.a();
            this.f60406f = 0;
            this.f60408h = 0;
            this.f60407g = 0;
            this.f60409i = 0;
            this.f60412l = false;
        }

        public void h() {
            mo moVarE = e();
            if (moVarE == null) {
                return;
            }
            ah ahVar = this.f60402b.f62114p;
            int i3 = moVarE.f61919d;
            if (i3 != 0) {
                ahVar.g(i3);
            }
            if (this.f60402b.c(this.f60406f)) {
                ahVar.g(ahVar.C() * 6);
            }
        }

        public int a() {
            int i3;
            if (!this.f60412l) {
                i3 = this.f60404d.f62901g[this.f60406f];
            } else {
                i3 = this.f60402b.f62110l[this.f60406f] ? 1 : 0;
            }
            return e() != null ? i3 | 1073741824 : i3;
        }

        public int a(int i3, int i4) {
            ah ahVar;
            mo moVarE = e();
            if (moVarE == null) {
                return 0;
            }
            int length = moVarE.f61919d;
            if (length != 0) {
                ahVar = this.f60402b.f62114p;
            } else {
                byte[] bArr = (byte[]) xp.a((Object) moVarE.f61920e);
                this.f60411k.a(bArr, bArr.length);
                ah ahVar2 = this.f60411k;
                length = bArr.length;
                ahVar = ahVar2;
            }
            boolean zC = this.f60402b.c(this.f60406f);
            boolean z2 = zC || i4 != 0;
            this.f60410j.c()[0] = (byte) ((z2 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 0) | length);
            this.f60410j.f(0);
            this.f60401a.a(this.f60410j, 1, 1);
            this.f60401a.a(ahVar, length, 1);
            if (!z2) {
                return length + 1;
            }
            if (!zC) {
                this.f60403c.d(8);
                byte[] bArrC = this.f60403c.c();
                bArrC[0] = 0;
                bArrC[1] = 1;
                bArrC[2] = (byte) ((i4 >> 8) & 255);
                bArrC[3] = (byte) (i4 & 255);
                bArrC[4] = (byte) ((i3 >> 24) & 255);
                bArrC[5] = (byte) ((i3 >> 16) & 255);
                bArrC[6] = (byte) ((i3 >> 8) & 255);
                bArrC[7] = (byte) (i3 & 255);
                this.f60401a.a(this.f60403c, 8, 1);
                return length + 9;
            }
            ah ahVar3 = this.f60402b.f62114p;
            int iC = ahVar3.C();
            ahVar3.g(-2);
            int i5 = (iC * 6) + 2;
            if (i4 != 0) {
                this.f60403c.d(i5);
                byte[] bArrC2 = this.f60403c.c();
                ahVar3.a(bArrC2, 0, i5);
                int i6 = (((bArrC2[2] & 255) << 8) | (bArrC2[3] & 255)) + i4;
                bArrC2[2] = (byte) ((i6 >> 8) & 255);
                bArrC2[3] = (byte) (i6 & 255);
                ahVar3 = this.f60403c;
            }
            this.f60401a.a(ahVar3, i5, 1);
            return length + 1 + i5;
        }

        public void a(ro roVar, k6 k6Var) {
            this.f60404d = roVar;
            this.f60405e = k6Var;
            this.f60401a.a(roVar.f62895a.f61254f);
            g();
        }

        public void a(long j3) {
            int i3 = this.f60406f;
            while (true) {
                no noVar = this.f60402b;
                if (i3 >= noVar.f62104f || noVar.a(i3) >= j3) {
                    return;
                }
                if (this.f60402b.f62110l[i3]) {
                    this.f60409i = i3;
                }
                i3++;
            }
        }

        public void a(x6 x6Var) {
            mo moVarA = this.f60404d.f62895a.a(((k6) xp.a(this.f60402b.f62099a)).f60934a);
            this.f60401a.a(this.f60404d.f62895a.f61254f.a().a(x6Var.a(moVarA != null ? moVarA.f61917b : null)).a());
        }
    }

    public i9() {
        this(0);
    }

    private static boolean b(int i3) {
        return i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1836019558 || i3 == 1953653094 || i3 == 1836475768 || i3 == 1701082227;
    }

    private static boolean c(int i3) {
        return i3 == 1751411826 || i3 == 1835296868 || i3 == 1836476516 || i3 == 1936286840 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1668576371 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1937011571 || i3 == 1952867444 || i3 == 1952868452 || i3 == 1953196132 || i3 == 1953654136 || i3 == 1953658222 || i3 == 1886614376 || i3 == 1935763834 || i3 == 1935763823 || i3 == 1936027235 || i3 == 1970628964 || i3 == 1935828848 || i3 == 1936158820 || i3 == 1701606260 || i3 == 1835362404 || i3 == 1701671783;
    }

    private static Pair d(ah ahVar) {
        ahVar.f(12);
        return Pair.create(Integer.valueOf(ahVar.j()), new k6(ahVar.j() - 1, ahVar.j(), ahVar.j(), ahVar.j()));
    }

    protected lo a(lo loVar) {
        return loVar;
    }

    public i9(int i3) {
        this(i3, null);
    }

    private void b() {
        this.f60388p = 0;
        this.f60391s = 0;
    }

    private void c() {
        int i3;
        qo[] qoVarArr = new qo[2];
        this.F = qoVarArr;
        qo qoVar = this.f60387o;
        int i4 = 0;
        if (qoVar != null) {
            qoVarArr[0] = qoVar;
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i5 = 100;
        if ((this.f60373a & 4) != 0) {
            qoVarArr[i3] = this.E.a(100, 5);
            i5 = 101;
            i3++;
        }
        qo[] qoVarArr2 = (qo[]) xp.a(this.F, i3);
        this.F = qoVarArr2;
        for (qo qoVar2 : qoVarArr2) {
            qoVar2.a(K);
        }
        this.G = new qo[this.f60375c.size()];
        while (i4 < this.G.length) {
            qo qoVarA = this.E.a(i5, 3);
            qoVarA.a((e9) this.f60375c.get(i4));
            this.G[i4] = qoVarA;
            i4++;
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean e(k8 k8Var) throws ch {
        boolean z2;
        int i3;
        int iA;
        b bVarA = this.f60398z;
        Throwable th = null;
        if (bVarA == null) {
            bVarA = a(this.f60376d);
            if (bVarA == null) {
                int iF = (int) (this.f60393u - k8Var.f());
                if (iF < 0) {
                    throw ch.a("Offset to end of mdat was negative.", null);
                }
                k8Var.a(iF);
                b();
                return false;
            }
            int iB = (int) (bVarA.b() - k8Var.f());
            if (iB < 0) {
                oc.d("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iB = 0;
            }
            k8Var.a(iB);
            this.f60398z = bVarA;
        }
        int i4 = 4;
        int i5 = 1;
        if (this.f60388p == 3) {
            int iD = bVarA.d();
            this.A = iD;
            if (bVarA.f60406f < bVarA.f60409i) {
                k8Var.a(iD);
                bVarA.h();
                if (!bVarA.f()) {
                    this.f60398z = null;
                }
                this.f60388p = 3;
                return true;
            }
            if (bVarA.f60404d.f62895a.f61255g == 1) {
                this.A = iD - 8;
                k8Var.a(8);
            }
            if ("audio/ac4".equals(bVarA.f60404d.f62895a.f61254f.f59394m)) {
                this.B = bVarA.a(this.A, 7);
                n.a(this.A, this.f60381i);
                bVarA.f60401a.a(this.f60381i, 7);
                this.B += 7;
            } else {
                this.B = bVarA.a(this.A, 0);
            }
            this.A += this.B;
            this.f60388p = 4;
            this.C = 0;
        }
        lo loVar = bVarA.f60404d.f62895a;
        qo qoVar = bVarA.f60401a;
        long jC = bVarA.c();
        ho hoVar = this.f60382j;
        if (hoVar != null) {
            jC = hoVar.a(jC);
        }
        if (loVar.f61258j == 0) {
            z2 = 1;
            while (true) {
                int i6 = this.B;
                int i7 = this.A;
                if (i6 >= i7) {
                    break;
                }
                this.B += qoVar.a((f5) k8Var, i7 - i6, false);
            }
        } else {
            byte[] bArrC = this.f60378f.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i8 = loVar.f61258j;
            int i9 = i8 + 1;
            int i10 = 4 - i8;
            while (this.B < this.A) {
                int i11 = this.C;
                if (i11 == 0) {
                    k8Var.d(bArrC, i10, i9);
                    this.f60378f.f(0);
                    int iJ = this.f60378f.j();
                    if (iJ < i5) {
                        throw ch.a("Invalid NAL length", th);
                    }
                    this.C = iJ - 1;
                    this.f60377e.f(0);
                    qoVar.a(this.f60377e, i4);
                    qoVar.a(this.f60378f, i5);
                    this.D = (this.G.length <= 0 || !yf.a(loVar.f61254f.f59394m, bArrC[i4])) ? 0 : i5;
                    this.B += 5;
                    this.A += i10;
                } else {
                    if (this.D) {
                        this.f60379g.d(i11);
                        k8Var.d(this.f60379g.c(), 0, this.C);
                        qoVar.a(this.f60379g, this.C);
                        iA = this.C;
                        int iC = yf.c(this.f60379g.c(), this.f60379g.e());
                        i3 = i5;
                        this.f60379g.f("video/hevc".equals(loVar.f61254f.f59394m) ? 1 : 0);
                        this.f60379g.e(iC);
                        c3.a(jC, this.f60379g, this.G);
                    } else {
                        i3 = i5;
                        iA = qoVar.a((f5) k8Var, i11, false);
                    }
                    this.B += iA;
                    this.C -= iA;
                    i5 = i3;
                    th = null;
                    i4 = 4;
                }
            }
            z2 = i5;
        }
        int iA2 = bVarA.a();
        mo moVarE = bVarA.e();
        qoVar.a(jC, iA2, this.A, 0, moVarE != null ? moVarE.f61918c : null);
        a(jC);
        if (!bVarA.f()) {
            this.f60398z = null;
        }
        this.f60388p = 3;
        return z2;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public i9(int i3, ho hoVar) {
        this(i3, hoVar, null, Collections.EMPTY_LIST);
    }

    private static int a(int i3) throws ch {
        if (i3 >= 0) {
            return i3;
        }
        throw ch.a("Unexpected negative value: " + i3, null);
    }

    public i9(int i3, ho hoVar, lo loVar, List list) {
        this(i3, hoVar, loVar, list, null);
    }

    private k6 a(SparseArray sparseArray, int i3) {
        if (sparseArray.size() == 1) {
            return (k6) sparseArray.valueAt(0);
        }
        return (k6) b1.a((k6) sparseArray.get(i3));
    }

    private void b(j1.a aVar) throws ch {
        a(aVar, this.f60376d, this.f60374b != null, this.f60373a, this.f60380h);
        x6 x6VarA = a(aVar.f60573c);
        if (x6VarA != null) {
            int size = this.f60376d.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((b) this.f60376d.valueAt(i3)).a(x6VarA);
            }
        }
        if (this.f60395w != -9223372036854775807L) {
            int size2 = this.f60376d.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((b) this.f60376d.valueAt(i4)).a(this.f60395w);
            }
            this.f60395w = -9223372036854775807L;
        }
    }

    public i9(int i3, ho hoVar, lo loVar, List list, qo qoVar) {
        this.f60373a = i3;
        this.f60382j = hoVar;
        this.f60374b = loVar;
        this.f60375c = Collections.unmodifiableList(list);
        this.f60387o = qoVar;
        this.f60383k = new x7();
        this.f60384l = new ah(16);
        this.f60377e = new ah(yf.f65192a);
        this.f60378f = new ah(5);
        this.f60379g = new ah();
        byte[] bArr = new byte[16];
        this.f60380h = bArr;
        this.f60381i = new ah(bArr);
        this.f60385m = new ArrayDeque();
        this.f60386n = new ArrayDeque();
        this.f60376d = new SparseArray();
        this.f60396x = -9223372036854775807L;
        this.f60395w = -9223372036854775807L;
        this.f60397y = -9223372036854775807L;
        this.E = l8.f61166e;
        this.F = new qo[0];
        this.G = new qo[0];
    }

    private static x6 a(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            j1.b bVar = (j1.b) list.get(i3);
            if (bVar.f60571a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrC = bVar.f60575b.c();
                UUID uuidC = ji.c(bArrC);
                if (uuidC == null) {
                    oc.d("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new x6.b(uuidC, "video/mp4", bArrC));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new x6(arrayList);
    }

    private void d(k8 k8Var) throws ch {
        int size = this.f60376d.size();
        long j3 = Long.MAX_VALUE;
        b bVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            no noVar = ((b) this.f60376d.valueAt(i3)).f60402b;
            if (noVar.f62115q) {
                long j4 = noVar.f62102d;
                if (j4 < j3) {
                    bVar = (b) this.f60376d.valueAt(i3);
                    j3 = j4;
                }
            }
        }
        if (bVar == null) {
            this.f60388p = 3;
            return;
        }
        int iF = (int) (j3 - k8Var.f());
        if (iF >= 0) {
            k8Var.a(iF);
            bVar.f60402b.a(k8Var);
            return;
        }
        throw ch.a("Offset to encryption data was negative.", null);
    }

    private static long b(ah ahVar) {
        ahVar.f(8);
        return j1.c(ahVar.j()) == 0 ? ahVar.y() : ahVar.B();
    }

    private static b a(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar2 = (b) sparseArray.valueAt(i3);
            if ((bVar2.f60412l || bVar2.f60406f != bVar2.f60404d.f62896b) && (!bVar2.f60412l || bVar2.f60408h != bVar2.f60402b.f62103e)) {
                long jB = bVar2.b();
                if (jB < j3) {
                    bVar = bVar2;
                    j3 = jB;
                }
            }
        }
        return bVar;
    }

    private static void b(ah ahVar, no noVar) throws ch {
        a(ahVar, 0, noVar);
    }

    private void c(j1.a aVar) {
        int i3 = 0;
        b1.b(this.f60374b == null, "Unexpected moov box.");
        x6 x6VarA = a(aVar.f60573c);
        j1.a aVar2 = (j1.a) b1.a(aVar.d(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = aVar2.f60573c.size();
        long jB = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            j1.b bVar = (j1.b) aVar2.f60573c.get(i4);
            int i5 = bVar.f60571a;
            if (i5 == 1953654136) {
                Pair pairD = d(bVar.f60575b);
                sparseArray.put(((Integer) pairD.first).intValue(), (k6) pairD.second);
            } else if (i5 == 1835362404) {
                jB = b(bVar.f60575b);
            }
        }
        List listA = k1.a(aVar, new y9(), jB, x6VarA, (this.f60373a & 16) != 0, false, new Function() { // from class: com.applovin.impl.yx
            @Override // com.applovin.exoplayer2.common.base.Function
            public final Object apply(Object obj) {
                return this.f65269a.a((lo) obj);
            }
        });
        int size2 = listA.size();
        if (this.f60376d.size() == 0) {
            while (i3 < size2) {
                ro roVar = (ro) listA.get(i3);
                lo loVar = roVar.f62895a;
                this.f60376d.put(loVar.f61249a, new b(this.E.a(i3, loVar.f61250b), roVar, a(sparseArray, loVar.f61249a)));
                this.f60396x = Math.max(this.f60396x, loVar.f61253e);
                i3++;
            }
            this.E.c();
            return;
        }
        b1.b(this.f60376d.size() == size2);
        while (i3 < size2) {
            ro roVar2 = (ro) listA.get(i3);
            lo loVar2 = roVar2.f62895a;
            ((b) this.f60376d.get(loVar2.f61249a)).a(roVar2, a(sparseArray, loVar2.f61249a));
            i3++;
        }
    }

    private static void b(j1.a aVar, SparseArray sparseArray, boolean z2, int i3, byte[] bArr) throws ch {
        b bVarA = a(((j1.b) b1.a(aVar.e(1952868452))).f60575b, sparseArray, z2);
        if (bVarA == null) {
            return;
        }
        no noVar = bVarA.f60402b;
        long j3 = noVar.f62116r;
        boolean z3 = noVar.f62117s;
        bVarA.g();
        bVarA.f60412l = true;
        j1.b bVarE = aVar.e(1952867444);
        if (bVarE != null && (i3 & 2) == 0) {
            noVar.f62116r = c(bVarE.f60575b);
            noVar.f62117s = true;
        } else {
            noVar.f62116r = j3;
            noVar.f62117s = z3;
        }
        a(aVar, bVarA, i3);
        mo moVarA = bVarA.f60404d.f62895a.a(((k6) b1.a(noVar.f62099a)).f60934a);
        j1.b bVarE2 = aVar.e(1935763834);
        if (bVarE2 != null) {
            a((mo) b1.a(moVarA), bVarE2.f60575b, noVar);
        }
        j1.b bVarE3 = aVar.e(1935763823);
        if (bVarE3 != null) {
            a(bVarE3.f60575b, noVar);
        }
        j1.b bVarE4 = aVar.e(1936027235);
        if (bVarE4 != null) {
            b(bVarE4.f60575b, noVar);
        }
        a(aVar, moVarA != null ? moVarA.f61917b : null, noVar);
        int size = aVar.f60573c.size();
        for (int i4 = 0; i4 < size; i4++) {
            j1.b bVar = (j1.b) aVar.f60573c.get(i4);
            if (bVar.f60571a == 1970628964) {
                a(bVar.f60575b, noVar, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] d() {
        return new j8[]{new i9()};
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.E = l8Var;
        b();
        c();
        lo loVar = this.f60374b;
        if (loVar != null) {
            this.f60376d.put(0, new b(l8Var.a(0, loVar.f61250b), new ro(this.f60374b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new k6(0, 0, 0, 0)));
            this.E.c();
        }
    }

    private void a(j1.a aVar) throws ch {
        int i3 = aVar.f60571a;
        if (i3 == 1836019574) {
            c(aVar);
        } else if (i3 == 1836019558) {
            b(aVar);
        } else {
            if (this.f60385m.isEmpty()) {
                return;
            }
            ((j1.a) this.f60385m.peek()).a(aVar);
        }
    }

    private void a(ah ahVar) {
        String str;
        String str2;
        long jC;
        long jC2;
        long jY;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        if (iC != 0) {
            if (iC != 1) {
                oc.d("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jY2 = ahVar.y();
            jA = xp.c(ahVar.B(), 1000000L, jY2);
            long jC3 = xp.c(ahVar.y(), 1000L, jY2);
            long jY3 = ahVar.y();
            str = (String) b1.a((Object) ahVar.t());
            str2 = (String) b1.a((Object) ahVar.t());
            jC2 = jC3;
            jY = jY3;
            jC = -9223372036854775807L;
        } else {
            str = (String) b1.a((Object) ahVar.t());
            str2 = (String) b1.a((Object) ahVar.t());
            long jY4 = ahVar.y();
            jC = xp.c(ahVar.y(), 1000000L, jY4);
            long j3 = this.f60397y;
            long j4 = j3 != -9223372036854775807L ? j3 + jC : -9223372036854775807L;
            jC2 = xp.c(ahVar.y(), 1000L, jY4);
            jY = ahVar.y();
            jA = j4;
        }
        String str3 = str;
        String str4 = str2;
        byte[] bArr = new byte[ahVar.a()];
        ahVar.a(bArr, 0, ahVar.a());
        ah ahVar2 = new ah(this.f60383k.a(new v7(str3, str4, jC2, jY, bArr)));
        int iA = ahVar2.a();
        for (qo qoVar : this.F) {
            ahVar2.f(0);
            qoVar.a(ahVar2, iA);
        }
        if (jA == -9223372036854775807L) {
            this.f60386n.addLast(new a(jC, iA));
            this.f60394v += iA;
            return;
        }
        ho hoVar = this.f60382j;
        if (hoVar != null) {
            jA = hoVar.a(jA);
        }
        long j5 = jA;
        for (qo qoVar2 : this.F) {
            qoVar2.a(j5, 1, iA, 0, null);
        }
    }

    private void b(long j3) throws ch {
        while (!this.f60385m.isEmpty() && ((j1.a) this.f60385m.peek()).f60572b == j3) {
            a((j1.a) this.f60385m.pop());
        }
        b();
    }

    private static long c(ah ahVar) {
        ahVar.f(8);
        return j1.c(ahVar.j()) == 1 ? ahVar.B() : ahVar.y();
    }

    private boolean b(k8 k8Var) throws ch {
        if (this.f60391s == 0) {
            if (!k8Var.a(this.f60384l.c(), 0, 8, true)) {
                return false;
            }
            this.f60391s = 8;
            this.f60384l.f(0);
            this.f60390r = this.f60384l.y();
            this.f60389q = this.f60384l.j();
        }
        long j3 = this.f60390r;
        if (j3 == 1) {
            k8Var.d(this.f60384l.c(), 8, 8);
            this.f60391s += 8;
            this.f60390r = this.f60384l.B();
        } else if (j3 == 0) {
            long jA = k8Var.a();
            if (jA == -1 && !this.f60385m.isEmpty()) {
                jA = ((j1.a) this.f60385m.peek()).f60572b;
            }
            if (jA != -1) {
                this.f60390r = (jA - k8Var.f()) + ((long) this.f60391s);
            }
        }
        if (this.f60390r >= this.f60391s) {
            long jF = k8Var.f() - ((long) this.f60391s);
            int i3 = this.f60389q;
            if ((i3 == 1836019558 || i3 == 1835295092) && !this.H) {
                this.E.a(new ij.b(this.f60396x, jF));
                this.H = true;
            }
            if (this.f60389q == 1836019558) {
                int size = this.f60376d.size();
                for (int i4 = 0; i4 < size; i4++) {
                    no noVar = ((b) this.f60376d.valueAt(i4)).f60402b;
                    noVar.f62100b = jF;
                    noVar.f62102d = jF;
                    noVar.f62101c = jF;
                }
            }
            int i5 = this.f60389q;
            if (i5 == 1835295092) {
                this.f60398z = null;
                this.f60393u = jF + this.f60390r;
                this.f60388p = 2;
                return true;
            }
            if (b(i5)) {
                long jF2 = (k8Var.f() + this.f60390r) - 8;
                this.f60385m.push(new j1.a(this.f60389q, jF2));
                if (this.f60390r == this.f60391s) {
                    b(jF2);
                } else {
                    b();
                }
            } else if (c(this.f60389q)) {
                if (this.f60391s == 8) {
                    long j4 = this.f60390r;
                    if (j4 <= 2147483647L) {
                        ah ahVar = new ah((int) j4);
                        System.arraycopy(this.f60384l.c(), 0, ahVar.c(), 0, 8);
                        this.f60392t = ahVar;
                        this.f60388p = 1;
                    } else {
                        throw ch.a("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw ch.a("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.f60390r <= 2147483647L) {
                this.f60392t = null;
                this.f60388p = 1;
            } else {
                throw ch.a("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ch.a("Atom size less than header length (unsupported).");
    }

    private void c(k8 k8Var) throws ch {
        int i3 = ((int) this.f60390r) - this.f60391s;
        ah ahVar = this.f60392t;
        if (ahVar != null) {
            k8Var.d(ahVar.c(), 8, i3);
            a(new j1.b(this.f60389q, ahVar), k8Var.f());
        } else {
            k8Var.a(i3);
        }
        b(k8Var.f());
    }

    private void a(j1.b bVar, long j3) throws ch {
        if (!this.f60385m.isEmpty()) {
            ((j1.a) this.f60385m.peek()).a(bVar);
            return;
        }
        int i3 = bVar.f60571a;
        if (i3 != 1936286840) {
            if (i3 == 1701671783) {
                a(bVar.f60575b);
            }
        } else {
            Pair pairA = a(bVar.f60575b, j3);
            this.f60397y = ((Long) pairA.first).longValue();
            this.E.a((ij) pairA.second);
            this.H = true;
        }
    }

    private void a(long j3) {
        while (!this.f60386n.isEmpty()) {
            a aVar = (a) this.f60386n.removeFirst();
            this.f60394v -= aVar.f60400b;
            long jA = aVar.f60399a + j3;
            ho hoVar = this.f60382j;
            if (hoVar != null) {
                jA = hoVar.a(jA);
            }
            long j4 = jA;
            for (qo qoVar : this.F) {
                qoVar.a(j4, 1, aVar.f60400b, this.f60394v, null);
            }
        }
    }

    private static void a(j1.a aVar, SparseArray sparseArray, boolean z2, int i3, byte[] bArr) throws ch {
        int size = aVar.f60574d.size();
        for (int i4 = 0; i4 < size; i4++) {
            j1.a aVar2 = (j1.a) aVar.f60574d.get(i4);
            if (aVar2.f60571a == 1953653094) {
                b(aVar2, sparseArray, z2, i3, bArr);
            }
        }
    }

    private static void a(ah ahVar, no noVar) throws ch {
        ahVar.f(8);
        int iJ = ahVar.j();
        if ((j1.b(iJ) & 1) == 1) {
            ahVar.g(8);
        }
        int iA = ahVar.A();
        if (iA == 1) {
            noVar.f62102d += j1.c(iJ) == 0 ? ahVar.y() : ahVar.B();
        } else {
            throw ch.a("Unexpected saio entry count: " + iA, null);
        }
    }

    private static void a(mo moVar, ah ahVar, no noVar) throws ch {
        int i3;
        int i4 = moVar.f61919d;
        ahVar.f(8);
        if ((j1.b(ahVar.j()) & 1) == 1) {
            ahVar.g(8);
        }
        int iW = ahVar.w();
        int iA = ahVar.A();
        if (iA <= noVar.f62104f) {
            if (iW == 0) {
                boolean[] zArr = noVar.f62112n;
                i3 = 0;
                for (int i5 = 0; i5 < iA; i5++) {
                    int iW2 = ahVar.w();
                    i3 += iW2;
                    zArr[i5] = iW2 > i4;
                }
            } else {
                i3 = iW * iA;
                Arrays.fill(noVar.f62112n, 0, iA, iW > i4);
            }
            Arrays.fill(noVar.f62112n, iA, noVar.f62104f, false);
            if (i3 > 0) {
                noVar.b(i3);
                return;
            }
            return;
        }
        throw ch.a("Saiz sample count " + iA + " is greater than fragment sample count" + noVar.f62104f, null);
    }

    private static void a(j1.a aVar, String str, no noVar) throws ch {
        byte[] bArr = null;
        ah ahVar = null;
        ah ahVar2 = null;
        for (int i3 = 0; i3 < aVar.f60573c.size(); i3++) {
            j1.b bVar = (j1.b) aVar.f60573c.get(i3);
            ah ahVar3 = bVar.f60575b;
            int i4 = bVar.f60571a;
            if (i4 == 1935828848) {
                ahVar3.f(12);
                if (ahVar3.j() == 1936025959) {
                    ahVar = ahVar3;
                }
            } else if (i4 == 1936158820) {
                ahVar3.f(12);
                if (ahVar3.j() == 1936025959) {
                    ahVar2 = ahVar3;
                }
            }
        }
        if (ahVar == null || ahVar2 == null) {
            return;
        }
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        ahVar.g(4);
        if (iC == 1) {
            ahVar.g(4);
        }
        if (ahVar.j() == 1) {
            ahVar2.f(8);
            int iC2 = j1.c(ahVar2.j());
            ahVar2.g(4);
            if (iC2 == 1) {
                if (ahVar2.y() == 0) {
                    throw ch.a("Variable length description in sgpd found (unsupported)");
                }
            } else if (iC2 >= 2) {
                ahVar2.g(4);
            }
            if (ahVar2.y() == 1) {
                ahVar2.g(1);
                int iW = ahVar2.w();
                int i5 = (iW & 240) >> 4;
                int i6 = iW & 15;
                boolean z2 = ahVar2.w() == 1;
                if (z2) {
                    int iW2 = ahVar2.w();
                    byte[] bArr2 = new byte[16];
                    ahVar2.a(bArr2, 0, 16);
                    if (iW2 == 0) {
                        int iW3 = ahVar2.w();
                        bArr = new byte[iW3];
                        ahVar2.a(bArr, 0, iW3);
                    }
                    noVar.f62111m = true;
                    noVar.f62113o = new mo(z2, str, iW2, bArr2, i5, i6, bArr);
                    return;
                }
                return;
            }
            throw ch.a("Entry count in sgpd != 1 (unsupported).");
        }
        throw ch.a("Entry count in sbgp != 1 (unsupported).");
    }

    private static void a(ah ahVar, int i3, no noVar) throws ch {
        ahVar.f(i3 + 8);
        int iB = j1.b(ahVar.j());
        if ((iB & 1) == 0) {
            boolean z2 = (iB & 2) != 0;
            int iA = ahVar.A();
            if (iA == 0) {
                Arrays.fill(noVar.f62112n, 0, noVar.f62104f, false);
                return;
            }
            if (iA == noVar.f62104f) {
                Arrays.fill(noVar.f62112n, 0, iA, z2);
                noVar.b(ahVar.a());
                noVar.a(ahVar);
                return;
            } else {
                throw ch.a("Senc sample count " + iA + " is different from fragment sample count" + noVar.f62104f, null);
            }
        }
        throw ch.a("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static Pair a(ah ahVar, long j3) throws ch {
        long jB;
        long jB2;
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        ahVar.g(4);
        long jY = ahVar.y();
        if (iC == 0) {
            jB = ahVar.y();
            jB2 = ahVar.y();
        } else {
            jB = ahVar.B();
            jB2 = ahVar.B();
        }
        long j4 = j3 + jB2;
        long jC = xp.c(jB, 1000000L, jY);
        ahVar.g(2);
        int iC2 = ahVar.C();
        int[] iArr = new int[iC2];
        long[] jArr = new long[iC2];
        long[] jArr2 = new long[iC2];
        long[] jArr3 = new long[iC2];
        long j5 = j4;
        long jC2 = jC;
        int i3 = 0;
        while (i3 < iC2) {
            int iJ = ahVar.j();
            if ((Integer.MIN_VALUE & iJ) == 0) {
                long jY2 = ahVar.y();
                iArr[i3] = iJ & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                jArr[i3] = j5;
                jArr3[i3] = jC2;
                jB += jY2;
                long[] jArr4 = jArr3;
                jC2 = xp.c(jB, 1000000L, jY);
                jArr2[i3] = jC2 - jArr4[i3];
                ahVar.g(4);
                j5 += (long) iArr[i3];
                i3++;
                jArr3 = jArr4;
            } else {
                throw ch.a("Unhandled indirect reference", null);
            }
        }
        return Pair.create(Long.valueOf(jC), new g3(iArr, jArr, jArr2, jArr3));
    }

    private static b a(ah ahVar, SparseArray sparseArray, boolean z2) {
        int iJ;
        int iJ2;
        int iJ3;
        int iJ4;
        ahVar.f(8);
        int iB = j1.b(ahVar.j());
        b bVar = (b) (z2 ? sparseArray.valueAt(0) : sparseArray.get(ahVar.j()));
        if (bVar == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jB = ahVar.B();
            no noVar = bVar.f60402b;
            noVar.f62101c = jB;
            noVar.f62102d = jB;
        }
        k6 k6Var = bVar.f60405e;
        if ((iB & 2) != 0) {
            iJ = ahVar.j() - 1;
        } else {
            iJ = k6Var.f60934a;
        }
        if ((iB & 8) != 0) {
            iJ2 = ahVar.j();
        } else {
            iJ2 = k6Var.f60935b;
        }
        if ((iB & 16) != 0) {
            iJ3 = ahVar.j();
        } else {
            iJ3 = k6Var.f60936c;
        }
        if ((iB & 32) != 0) {
            iJ4 = ahVar.j();
        } else {
            iJ4 = k6Var.f60937d;
        }
        bVar.f60402b.f62099a = new k6(iJ, iJ2, iJ3, iJ4);
        return bVar;
    }

    private static int a(b bVar, int i3, int i4, ah ahVar, int i5) throws ch {
        boolean z2;
        int iJ;
        int i6;
        int i7;
        int i8;
        long[] jArr;
        ahVar.f(8);
        int iB = j1.b(ahVar.j());
        lo loVar = bVar.f60404d.f62895a;
        no noVar = bVar.f60402b;
        k6 k6Var = (k6) xp.a(noVar.f62099a);
        noVar.f62106h[i3] = ahVar.A();
        long[] jArr2 = noVar.f62105g;
        long j3 = noVar.f62101c;
        jArr2[i3] = j3;
        if ((iB & 1) != 0) {
            jArr2[i3] = j3 + ((long) ahVar.j());
        }
        boolean z3 = (iB & 4) != 0;
        int iJ2 = k6Var.f60937d;
        if (z3) {
            iJ2 = ahVar.j();
        }
        boolean z4 = (iB & com.sun.jna.Function.MAX_NARGS) != 0;
        boolean z5 = (iB & 512) != 0;
        boolean z6 = (iB & 1024) != 0;
        boolean z7 = (iB & 2048) != 0;
        long[] jArr3 = loVar.f61256h;
        long jC = 0;
        if (jArr3 != null && jArr3.length == 1 && jArr3[0] == 0) {
            jC = xp.c(((long[]) xp.a(loVar.f61257i))[0], 1000000L, loVar.f61251c);
        }
        int[] iArr = noVar.f62107i;
        int[] iArr2 = noVar.f62108j;
        long[] jArr4 = noVar.f62109k;
        boolean z8 = z7;
        boolean[] zArr = noVar.f62110l;
        boolean z9 = loVar.f61250b == 2 && (i4 & 1) != 0;
        int i9 = i5 + noVar.f62106h[i3];
        boolean z10 = z3;
        long j4 = loVar.f61251c;
        int i10 = i5;
        long j5 = noVar.f62116r;
        while (i10 < i9) {
            int iA = a(z4 ? ahVar.j() : k6Var.f60935b);
            int iA2 = a(z5 ? ahVar.j() : k6Var.f60936c);
            if (z6) {
                z2 = z9;
                iJ = ahVar.j();
            } else if (i10 == 0 && z10) {
                z2 = z9;
                iJ = iJ2;
            } else {
                z2 = z9;
                iJ = k6Var.f60937d;
            }
            if (z8) {
                i6 = iJ;
                i7 = i9;
                iArr2[i10] = (int) ((((long) ahVar.j()) * 1000000) / j4);
            } else {
                i6 = iJ;
                i7 = i9;
                iArr2[i10] = 0;
            }
            long j6 = j5;
            long jC2 = xp.c(j5, 1000000L, j4) - jC;
            jArr4[i10] = jC2;
            int i11 = i10;
            if (noVar.f62117s) {
                i8 = iA2;
                jArr = jArr4;
            } else {
                i8 = iA2;
                jArr = jArr4;
                jArr[i11] = jC2 + bVar.f60404d.f62902h;
            }
            iArr[i11] = i8;
            zArr[i11] = ((i6 >> 16) & 1) == 0 && (!z2 || i11 == 0);
            j5 = j6 + ((long) iA);
            i10 = i11 + 1;
            z9 = z2;
            jArr4 = jArr;
            i9 = i7;
        }
        int i12 = i9;
        noVar.f62116r = j5;
        return i12;
    }

    private static void a(j1.a aVar, b bVar, int i3) throws ch {
        List list = aVar.f60573c;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            j1.b bVar2 = (j1.b) list.get(i6);
            if (bVar2.f60571a == 1953658222) {
                ah ahVar = bVar2.f60575b;
                ahVar.f(12);
                int iA = ahVar.A();
                if (iA > 0) {
                    i5 += iA;
                    i4++;
                }
            }
        }
        bVar.f60408h = 0;
        bVar.f60407g = 0;
        bVar.f60406f = 0;
        bVar.f60402b.a(i4, i5);
        int i7 = 0;
        int iA2 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            j1.b bVar3 = (j1.b) list.get(i8);
            if (bVar3.f60571a == 1953658222) {
                iA2 = a(bVar, i7, i3, bVar3.f60575b, iA2);
                i7++;
            }
        }
    }

    private static void a(ah ahVar, no noVar, byte[] bArr) throws ch {
        ahVar.f(8);
        ahVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            a(ahVar, 16, noVar);
        }
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        while (true) {
            int i3 = this.f60388p;
            if (i3 != 0) {
                if (i3 == 1) {
                    c(k8Var);
                } else if (i3 != 2) {
                    if (e(k8Var)) {
                        return 0;
                    }
                } else {
                    d(k8Var);
                }
            } else if (!b(k8Var)) {
                return -1;
            }
        }
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        int size = this.f60376d.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((b) this.f60376d.valueAt(i3)).g();
        }
        this.f60386n.clear();
        this.f60394v = 0;
        this.f60395w = j4;
        this.f60385m.clear();
        b();
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        return lk.a(k8Var);
    }
}
