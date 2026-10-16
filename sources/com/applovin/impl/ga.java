package com.applovin.impl;

import android.util.SparseArray;
import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.applovin.impl.yf;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ga implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nj f59895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f59896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f59897c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f59901g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f59903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private qo f59904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f59905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f59906l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f59908n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f59902h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final xf f59898d = new xf(7, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final xf f59899e = new xf(8, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final xf f59900f = new xf(6, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f59907m = -9223372036854775807L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f59909o = new ah();

    public ga(nj njVar, boolean z2, boolean z3) {
        this.f59895a = njVar;
        this.f59896b = z2;
        this.f59897c = z3;
    }

    private void c() {
        b1.b(this.f59904j);
        xp.a(this.f59905k);
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        c();
        int iD = ahVar.d();
        int iE = ahVar.e();
        byte[] bArrC = ahVar.c();
        this.f59901g += (long) ahVar.a();
        this.f59904j.a(ahVar, ahVar.a());
        while (true) {
            int iA = yf.a(bArrC, iD, iE, this.f59902h);
            if (iA == iE) {
                a(bArrC, iD, iE);
                return;
            }
            int iB = yf.b(bArrC, iA);
            int i3 = iA - iD;
            if (i3 > 0) {
                a(bArrC, iD, iA);
            }
            int i4 = iE - iA;
            long j3 = this.f59901g - ((long) i4);
            a(j3, i4, i3 < 0 ? -i3 : 0, this.f59907m);
            a(j3, iB, this.f59907m);
            iD = iA + 3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f59903i = dVar.b();
        qo qoVarA = l8Var.a(dVar.c(), 2);
        this.f59904j = qoVarA;
        this.f59905k = new b(qoVarA, this.f59896b, this.f59897c);
        this.f59895a.a(l8Var, dVar);
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    private void a(long j3, int i3, int i4, long j4) {
        if (!this.f59906l || this.f59905k.a()) {
            this.f59898d.a(i4);
            this.f59899e.a(i4);
            if (!this.f59906l) {
                if (this.f59898d.a() && this.f59899e.a()) {
                    ArrayList arrayList = new ArrayList();
                    xf xfVar = this.f59898d;
                    arrayList.add(Arrays.copyOf(xfVar.f64974d, xfVar.f64975e));
                    xf xfVar2 = this.f59899e;
                    arrayList.add(Arrays.copyOf(xfVar2.f64974d, xfVar2.f64975e));
                    xf xfVar3 = this.f59898d;
                    yf.b bVarC = yf.c(xfVar3.f64974d, 3, xfVar3.f64975e);
                    xf xfVar4 = this.f59899e;
                    yf.a aVarB = yf.b(xfVar4.f64974d, 3, xfVar4.f64975e);
                    this.f59904j.a(new e9.b().c(this.f59903i).f("video/avc").a(o3.a(bVarC.f65199a, bVarC.f65200b, bVarC.f65201c)).q(bVarC.f65203e).g(bVarC.f65204f).b(bVarC.f65205g).a(arrayList).a());
                    this.f59906l = true;
                    this.f59905k.a(bVarC);
                    this.f59905k.a(aVarB);
                    this.f59898d.b();
                    this.f59899e.b();
                }
            } else if (this.f59898d.a()) {
                xf xfVar5 = this.f59898d;
                this.f59905k.a(yf.c(xfVar5.f64974d, 3, xfVar5.f64975e));
                this.f59898d.b();
            } else if (this.f59899e.a()) {
                xf xfVar6 = this.f59899e;
                this.f59905k.a(yf.b(xfVar6.f64974d, 3, xfVar6.f64975e));
                this.f59899e.b();
            }
        }
        if (this.f59900f.a(i4)) {
            xf xfVar7 = this.f59900f;
            this.f59909o.a(this.f59900f.f64974d, yf.c(xfVar7.f64974d, xfVar7.f64975e));
            this.f59909o.f(4);
            this.f59895a.a(j4, this.f59909o);
        }
        if (this.f59905k.a(j3, i3, this.f59906l, this.f59908n)) {
            this.f59908n = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f59910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f59911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f59912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SparseArray f59913d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final SparseArray f59914e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final bh f59915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f59916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f59917h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f59918i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f59919j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f59920k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f59921l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private a f59922m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private a f59923n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f59924o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private long f59925p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f59926q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f59927r;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f59928a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f59929b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private yf.b f59930c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f59931d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f59932e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f59933f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f59934g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f59935h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f59936i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f59937j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private boolean f59938k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private int f59939l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private int f59940m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private int f59941n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private int f59942o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private int f59943p;

            private a() {
            }

            public boolean b() {
                if (!this.f59929b) {
                    return false;
                }
                int i3 = this.f59932e;
                return i3 == 7 || i3 == 2;
            }

            public void a() {
                this.f59929b = false;
                this.f59928a = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(a aVar) {
                int i3;
                int i4;
                int i5;
                boolean z2;
                if (!this.f59928a) {
                    return false;
                }
                if (!aVar.f59928a) {
                    return true;
                }
                yf.b bVar = (yf.b) b1.b(this.f59930c);
                yf.b bVar2 = (yf.b) b1.b(aVar.f59930c);
                return (this.f59933f == aVar.f59933f && this.f59934g == aVar.f59934g && this.f59935h == aVar.f59935h && (!this.f59936i || !aVar.f59936i || this.f59937j == aVar.f59937j) && (((i3 = this.f59931d) == (i4 = aVar.f59931d) || (i3 != 0 && i4 != 0)) && (((i5 = bVar.f65209k) != 0 || bVar2.f65209k != 0 || (this.f59940m == aVar.f59940m && this.f59941n == aVar.f59941n)) && ((i5 != 1 || bVar2.f65209k != 1 || (this.f59942o == aVar.f59942o && this.f59943p == aVar.f59943p)) && (z2 = this.f59938k) == aVar.f59938k && (!z2 || this.f59939l == aVar.f59939l))))) ? false : true;
            }

            public void a(yf.b bVar, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, int i7, int i8, int i9, int i10, int i11) {
                this.f59930c = bVar;
                this.f59931d = i3;
                this.f59932e = i4;
                this.f59933f = i5;
                this.f59934g = i6;
                this.f59935h = z2;
                this.f59936i = z3;
                this.f59937j = z4;
                this.f59938k = z5;
                this.f59939l = i7;
                this.f59940m = i8;
                this.f59941n = i9;
                this.f59942o = i10;
                this.f59943p = i11;
                this.f59928a = true;
                this.f59929b = true;
            }

            public void a(int i3) {
                this.f59932e = i3;
                this.f59929b = true;
            }
        }

        public b(qo qoVar, boolean z2, boolean z3) {
            this.f59910a = qoVar;
            this.f59911b = z2;
            this.f59912c = z3;
            this.f59922m = new a();
            this.f59923n = new a();
            byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
            this.f59916g = bArr;
            this.f59915f = new bh(bArr, 0, 0);
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x015d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r23, int r24, int r25) {
            /*
                Method dump skipped, instruction units count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ga.b.a(byte[], int, int):void");
        }

        public void b() {
            this.f59920k = false;
            this.f59924o = false;
            this.f59923n.a();
        }

        public boolean a(long j3, int i3, boolean z2, boolean z3) {
            boolean z4 = false;
            if (this.f59918i == 9 || (this.f59912c && this.f59923n.a(this.f59922m))) {
                if (z2 && this.f59924o) {
                    a(i3 + ((int) (j3 - this.f59919j)));
                }
                this.f59925p = this.f59919j;
                this.f59926q = this.f59921l;
                this.f59927r = false;
                this.f59924o = true;
            }
            if (this.f59911b) {
                z3 = this.f59923n.b();
            }
            boolean z5 = this.f59927r;
            int i4 = this.f59918i;
            if (i4 == 5 || (z3 && i4 == 1)) {
                z4 = true;
            }
            boolean z6 = z5 | z4;
            this.f59927r = z6;
            return z6;
        }

        public boolean a() {
            return this.f59912c;
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
        private void a(int i3) {
            long j3 = this.f59926q;
            if (j3 == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f59927r;
            this.f59910a.a(j3, z2 ? 1 : 0, (int) (this.f59919j - this.f59925p), i3, null);
        }

        public void a(yf.a aVar) {
            this.f59914e.append(aVar.f65196a, aVar);
        }

        public void a(yf.b bVar) {
            this.f59913d.append(bVar.f65202d, bVar);
        }

        public void a(long j3, int i3, long j4) {
            this.f59918i = i3;
            this.f59921l = j4;
            this.f59919j = j3;
            if (!this.f59911b || i3 != 1) {
                if (!this.f59912c) {
                    return;
                }
                if (i3 != 5 && i3 != 1 && i3 != 2) {
                    return;
                }
            }
            a aVar = this.f59922m;
            this.f59922m = this.f59923n;
            this.f59923n = aVar;
            aVar.a();
            this.f59917h = 0;
            this.f59920k = true;
        }
    }

    private void a(byte[] bArr, int i3, int i4) {
        if (!this.f59906l || this.f59905k.a()) {
            this.f59898d.a(bArr, i3, i4);
            this.f59899e.a(bArr, i3, i4);
        }
        this.f59900f.a(bArr, i3, i4);
        this.f59905k.a(bArr, i3, i4);
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f59907m = j3;
        }
        this.f59908n |= (i3 & 2) != 0;
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f59901g = 0L;
        this.f59908n = false;
        this.f59907m = -9223372036854775807L;
        yf.a(this.f59902h);
        this.f59898d.b();
        this.f59899e.b();
        this.f59900f.b();
        b bVar = this.f59905k;
        if (bVar != null) {
            bVar.b();
        }
    }

    private void a(long j3, int i3, long j4) {
        if (!this.f59906l || this.f59905k.a()) {
            this.f59898d.b(i3);
            this.f59899e.b(i3);
        }
        this.f59900f.b(i3);
        this.f59905k.a(j3, i3, j4);
    }
}
