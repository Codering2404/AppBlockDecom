package com.applovin.impl;

import com.applovin.impl.dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ea implements p7 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double[] f59437q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f59438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f59439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final vp f59440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ah f59441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final xf f59442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f59443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f59444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f59445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f59446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f59447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f59448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f59449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f59450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f59451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f59452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f59453p;

    public ea() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
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
    @Override // com.applovin.impl.p7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.applovin.impl.ah r20) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ea.a(com.applovin.impl.ah):void");
    }

    ea(vp vpVar) {
        this.f59440c = vpVar;
        this.f59443f = new boolean[4];
        this.f59444g = new a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        if (vpVar != null) {
            this.f59442e = new xf(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f59441d = new ah();
        } else {
            this.f59442e = null;
            this.f59441d = null;
        }
        this.f59449l = -9223372036854775807L;
        this.f59451n = -9223372036854775807L;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final byte[] f59454e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f59455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f59458d;

        public a(int i3) {
            this.f59458d = new byte[i3];
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f59455a) {
                int i5 = i4 - i3;
                byte[] bArr2 = this.f59458d;
                int length = bArr2.length;
                int i6 = this.f59456b + i5;
                if (length < i6) {
                    this.f59458d = Arrays.copyOf(bArr2, i6 * 2);
                }
                System.arraycopy(bArr, i3, this.f59458d, this.f59456b, i5);
                this.f59456b += i5;
            }
        }

        public boolean a(int i3, int i4) {
            if (this.f59455a) {
                int i5 = this.f59456b - i4;
                this.f59456b = i5;
                if (this.f59457c == 0 && i3 == 181) {
                    this.f59457c = i5;
                } else {
                    this.f59455a = false;
                    return true;
                }
            } else if (i3 == 179) {
                this.f59455a = true;
            }
            byte[] bArr = f59454e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void a() {
            this.f59455a = false;
            this.f59456b = 0;
            this.f59457c = 0;
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f59438a = dVar.b();
        this.f59439b = l8Var.a(dVar.c(), 2);
        vp vpVar = this.f59440c;
        if (vpVar != null) {
            vpVar.a(l8Var, dVar);
        }
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        this.f59449l = j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair a(com.applovin.impl.ea.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f59458d
            int r1 = r8.f59456b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3e
            r7 = 3
            if (r6 == r7) goto L38
            if (r6 == r1) goto L30
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L30:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L35:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L44
        L38:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L35
        L3e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L35
        L44:
            com.applovin.impl.e9$b r6 = new com.applovin.impl.e9$b
            r6.<init>()
            com.applovin.impl.e9$b r9 = r6.c(r9)
            java.lang.String r6 = "video/mpeg2"
            com.applovin.impl.e9$b r9 = r9.f(r6)
            com.applovin.impl.e9$b r9 = r9.q(r2)
            com.applovin.impl.e9$b r9 = r9.g(r4)
            com.applovin.impl.e9$b r9 = r9.b(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.applovin.impl.e9$b r9 = r9.a(r1)
            com.applovin.impl.e9 r9 = r9.a()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L98
            double[] r2 = com.applovin.impl.ea.f59437q
            int r4 = r2.length
            if (r1 >= r4) goto L98
            r1 = r2[r1]
            int r8 = r8.f59457c
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L90
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L90:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9a
        L98:
            r0 = 0
        L9a:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ea.a(com.applovin.impl.ea$a, java.lang.String):android.util.Pair");
    }

    @Override // com.applovin.impl.p7
    public void a() {
        yf.a(this.f59443f);
        this.f59444g.a();
        xf xfVar = this.f59442e;
        if (xfVar != null) {
            xfVar.b();
        }
        this.f59445h = 0L;
        this.f59446i = false;
        this.f59449l = -9223372036854775807L;
        this.f59451n = -9223372036854775807L;
    }
}
