package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ha implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nj f60157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f60158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qo f60159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f60160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60161e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f60168l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f60162f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final xf f60163g = new xf(32, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final xf f60164h = new xf(33, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final xf f60165i = new xf(34, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final xf f60166j = new xf(39, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final xf f60167k = new xf(40, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f60169m = -9223372036854775807L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ah f60170n = new ah();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f60171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f60172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f60173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f60174d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f60175e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f60176f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f60177g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f60178h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f60179i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f60180j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f60181k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f60182l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f60183m;

        public a(qo qoVar) {
            this.f60171a = qoVar;
        }

        private static boolean a(int i3) {
            return (32 <= i3 && i3 <= 35) || i3 == 39;
        }

        private static boolean b(int i3) {
            return i3 < 32 || i3 == 40;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void c(int i3) {
            long j3 = this.f60182l;
            if (j3 == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f60183m;
            this.f60171a.a(j3, z2 ? 1 : 0, (int) (this.f60172b - this.f60181k), i3, null);
        }

        public void a(long j3, int i3, boolean z2) {
            if (this.f60180j && this.f60177g) {
                this.f60183m = this.f60173c;
                this.f60180j = false;
            } else if (this.f60178h || this.f60177g) {
                if (z2 && this.f60179i) {
                    c(i3 + ((int) (j3 - this.f60172b)));
                }
                this.f60181k = this.f60172b;
                this.f60182l = this.f60175e;
                this.f60183m = this.f60173c;
                this.f60179i = true;
            }
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f60176f) {
                int i5 = this.f60174d;
                int i6 = (i3 + 2) - i5;
                if (i6 < i4) {
                    this.f60177g = (bArr[i6] & 128) != 0;
                    this.f60176f = false;
                } else {
                    this.f60174d = i5 + (i4 - i3);
                }
            }
        }

        public void a() {
            this.f60176f = false;
            this.f60177g = false;
            this.f60178h = false;
            this.f60179i = false;
            this.f60180j = false;
        }

        public void a(long j3, int i3, int i4, long j4, boolean z2) {
            this.f60177g = false;
            this.f60178h = false;
            this.f60175e = j4;
            this.f60174d = 0;
            this.f60172b = j3;
            if (!b(i4)) {
                if (this.f60179i && !this.f60180j) {
                    if (z2) {
                        c(i3);
                    }
                    this.f60179i = false;
                }
                if (a(i4)) {
                    this.f60178h = !this.f60180j;
                    this.f60180j = true;
                }
            }
            boolean z3 = i4 >= 16 && i4 <= 21;
            this.f60173c = z3;
            this.f60176f = z3 || i4 <= 9;
        }
    }

    public ha(nj njVar) {
        this.f60157a = njVar;
    }

    private void c() {
        b1.b(this.f60159c);
        xp.a(this.f60160d);
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        c();
        while (ahVar.a() > 0) {
            int iD = ahVar.d();
            int iE = ahVar.e();
            byte[] bArrC = ahVar.c();
            this.f60168l += (long) ahVar.a();
            this.f60159c.a(ahVar, ahVar.a());
            while (iD < iE) {
                int iA = yf.a(bArrC, iD, iE, this.f60162f);
                if (iA == iE) {
                    a(bArrC, iD, iE);
                    return;
                }
                int iA2 = yf.a(bArrC, iA);
                int i3 = iA - iD;
                if (i3 > 0) {
                    a(bArrC, iD, iA);
                }
                int i4 = iE - iA;
                long j3 = this.f60168l - ((long) i4);
                a(j3, i4, i3 < 0 ? -i3 : 0, this.f60169m);
                b(j3, i4, iA2, this.f60169m);
                iD = iA + 3;
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    private static void b(bh bhVar) {
        int iF = bhVar.f();
        boolean zC = false;
        int i3 = 0;
        for (int i4 = 0; i4 < iF; i4++) {
            if (i4 != 0) {
                zC = bhVar.c();
            }
            if (zC) {
                bhVar.g();
                bhVar.f();
                for (int i5 = 0; i5 <= i3; i5++) {
                    if (bhVar.c()) {
                        bhVar.g();
                    }
                }
            } else {
                int iF2 = bhVar.f();
                int iF3 = bhVar.f();
                int i6 = iF2 + iF3;
                for (int i7 = 0; i7 < iF2; i7++) {
                    bhVar.f();
                    bhVar.g();
                }
                for (int i8 = 0; i8 < iF3; i8++) {
                    bhVar.f();
                    bhVar.g();
                }
                i3 = i6;
            }
        }
    }

    private void b(long j3, int i3, int i4, long j4) {
        this.f60160d.a(j3, i3, i4, j4, this.f60161e);
        if (!this.f60161e) {
            this.f60163g.b(i4);
            this.f60164h.b(i4);
            this.f60165i.b(i4);
        }
        this.f60166j.b(i4);
        this.f60167k.b(i4);
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f60158b = dVar.b();
        qo qoVarA = l8Var.a(dVar.c(), 2);
        this.f60159c = qoVarA;
        this.f60160d = new a(qoVarA);
        this.f60157a.a(l8Var, dVar);
    }

    private void a(long j3, int i3, int i4, long j4) {
        this.f60160d.a(j3, i3, this.f60161e);
        if (!this.f60161e) {
            this.f60163g.a(i4);
            this.f60164h.a(i4);
            this.f60165i.a(i4);
            if (this.f60163g.a() && this.f60164h.a() && this.f60165i.a()) {
                this.f60159c.a(a(this.f60158b, this.f60163g, this.f60164h, this.f60165i));
                this.f60161e = true;
            }
        }
        if (this.f60166j.a(i4)) {
            xf xfVar = this.f60166j;
            this.f60170n.a(this.f60166j.f64974d, yf.c(xfVar.f64974d, xfVar.f64975e));
            this.f60170n.g(5);
            this.f60157a.a(j4, this.f60170n);
        }
        if (this.f60167k.a(i4)) {
            xf xfVar2 = this.f60167k;
            this.f60170n.a(this.f60167k.f64974d, yf.c(xfVar2.f64974d, xfVar2.f64975e));
            this.f60170n.g(5);
            this.f60157a.a(j4, this.f60170n);
        }
    }

    private void a(byte[] bArr, int i3, int i4) {
        this.f60160d.a(bArr, i3, i4);
        if (!this.f60161e) {
            this.f60163g.a(bArr, i3, i4);
            this.f60164h.a(bArr, i3, i4);
            this.f60165i.a(bArr, i3, i4);
        }
        this.f60166j.a(bArr, i3, i4);
        this.f60167k.a(bArr, i3, i4);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f60169m = j3;
        }
    }

    private static e9 a(String str, xf xfVar, xf xfVar2, xf xfVar3) {
        int i3 = xfVar.f64975e;
        byte[] bArr = new byte[xfVar2.f64975e + i3 + xfVar3.f64975e];
        System.arraycopy(xfVar.f64974d, 0, bArr, 0, i3);
        System.arraycopy(xfVar2.f64974d, 0, bArr, xfVar.f64975e, xfVar2.f64975e);
        System.arraycopy(xfVar3.f64974d, 0, bArr, xfVar.f64975e + xfVar2.f64975e, xfVar3.f64975e);
        bh bhVar = new bh(xfVar2.f64974d, 0, xfVar2.f64975e);
        bhVar.d(44);
        int iB = bhVar.b(3);
        bhVar.g();
        bhVar.d(88);
        bhVar.d(8);
        int i4 = 0;
        for (int i5 = 0; i5 < iB; i5++) {
            if (bhVar.c()) {
                i4 += 89;
            }
            if (bhVar.c()) {
                i4 += 8;
            }
        }
        bhVar.d(i4);
        if (iB > 0) {
            bhVar.d((8 - iB) * 2);
        }
        bhVar.f();
        int iF = bhVar.f();
        if (iF == 3) {
            bhVar.g();
        }
        int iF2 = bhVar.f();
        int iF3 = bhVar.f();
        if (bhVar.c()) {
            int iF4 = bhVar.f();
            int iF5 = bhVar.f();
            int iF6 = bhVar.f();
            int iF7 = bhVar.f();
            iF2 -= ((iF == 1 || iF == 2) ? 2 : 1) * (iF4 + iF5);
            iF3 -= (iF == 1 ? 2 : 1) * (iF6 + iF7);
        }
        bhVar.f();
        bhVar.f();
        int iF8 = bhVar.f();
        for (int i6 = bhVar.c() ? 0 : iB; i6 <= iB; i6++) {
            bhVar.f();
            bhVar.f();
            bhVar.f();
        }
        bhVar.f();
        bhVar.f();
        bhVar.f();
        bhVar.f();
        bhVar.f();
        bhVar.f();
        if (bhVar.c() && bhVar.c()) {
            a(bhVar);
        }
        bhVar.d(2);
        if (bhVar.c()) {
            bhVar.d(8);
            bhVar.f();
            bhVar.f();
            bhVar.g();
        }
        b(bhVar);
        if (bhVar.c()) {
            for (int i7 = 0; i7 < bhVar.f(); i7++) {
                bhVar.d(iF8 + 5);
            }
        }
        bhVar.d(2);
        float f3 = 1.0f;
        if (bhVar.c()) {
            if (bhVar.c()) {
                int iB2 = bhVar.b(8);
                if (iB2 == 255) {
                    int iB3 = bhVar.b(16);
                    int iB4 = bhVar.b(16);
                    if (iB3 != 0 && iB4 != 0) {
                        f3 = iB3 / iB4;
                    }
                } else {
                    float[] fArr = yf.f65193b;
                    if (iB2 < fArr.length) {
                        f3 = fArr[iB2];
                    } else {
                        oc.d("H265Reader", "Unexpected aspect_ratio_idc value: " + iB2);
                    }
                }
            }
            if (bhVar.c()) {
                bhVar.g();
            }
            if (bhVar.c()) {
                bhVar.d(4);
                if (bhVar.c()) {
                    bhVar.d(24);
                }
            }
            if (bhVar.c()) {
                bhVar.f();
                bhVar.f();
            }
            bhVar.g();
            if (bhVar.c()) {
                iF3 *= 2;
            }
        }
        bhVar.a(xfVar2.f64974d, 0, xfVar2.f64975e);
        bhVar.d(24);
        return new e9.b().c(str).f("video/hevc").a(o3.a(bhVar)).q(iF2).g(iF3).b(f3).a(Collections.singletonList(bArr)).a();
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f60168l = 0L;
        this.f60169m = -9223372036854775807L;
        yf.a(this.f60162f);
        this.f60163g.b();
        this.f60164h.b();
        this.f60165i.b();
        this.f60166j.b();
        this.f60167k.b();
        a aVar = this.f60160d;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void a(bh bhVar) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = 0;
            while (i4 < 6) {
                int i5 = 1;
                if (!bhVar.c()) {
                    bhVar.f();
                } else {
                    int iMin = Math.min(64, 1 << ((i3 << 1) + 4));
                    if (i3 > 1) {
                        bhVar.e();
                    }
                    for (int i6 = 0; i6 < iMin; i6++) {
                        bhVar.e();
                    }
                }
                if (i3 == 3) {
                    i5 = 3;
                }
                i4 += i5;
            }
        }
    }
}
