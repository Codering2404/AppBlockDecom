package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.Collections;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class fa implements p7 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f59644l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vp f59645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f59646b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final xf f59649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f59650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f59651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f59652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private qo f59653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f59654j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f59647c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f59648d = new a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f59655k = -9223372036854775807L;

    fa(vp vpVar) {
        this.f59645a = vpVar;
        if (vpVar != null) {
            this.f59649e = new xf(178, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f59646b = new ah();
        } else {
            this.f59649e = null;
            this.f59646b = null;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f59650f);
        b1.b(this.f59653i);
        int iD = ahVar.d();
        int iE = ahVar.e();
        byte[] bArrC = ahVar.c();
        this.f59651g += (long) ahVar.a();
        this.f59653i.a(ahVar, ahVar.a());
        while (true) {
            int iA = yf.a(bArrC, iD, iE, this.f59647c);
            if (iA == iE) {
                break;
            }
            int i3 = iA + 3;
            int i4 = ahVar.c()[i3] & 255;
            int i5 = iA - iD;
            int i6 = 0;
            if (!this.f59654j) {
                if (i5 > 0) {
                    this.f59648d.a(bArrC, iD, iA);
                }
                if (this.f59648d.a(i4, i5 < 0 ? -i5 : 0)) {
                    qo qoVar = this.f59653i;
                    a aVar = this.f59648d;
                    qoVar.a(a(aVar, aVar.f59660d, (String) b1.a((Object) this.f59652h)));
                    this.f59654j = true;
                }
            }
            this.f59650f.a(bArrC, iD, iA);
            xf xfVar = this.f59649e;
            if (xfVar != null) {
                if (i5 > 0) {
                    xfVar.a(bArrC, iD, iA);
                } else {
                    i6 = -i5;
                }
                if (this.f59649e.a(i6)) {
                    xf xfVar2 = this.f59649e;
                    ((ah) xp.a(this.f59646b)).a(this.f59649e.f64974d, yf.c(xfVar2.f64974d, xfVar2.f64975e));
                    ((vp) xp.a(this.f59645a)).a(this.f59655k, this.f59646b);
                }
                if (i4 == 178 && ahVar.c()[iA + 2] == 1) {
                    this.f59649e.b(i4);
                }
            }
            int i7 = iE - iA;
            this.f59650f.a(this.f59651g - ((long) i7), i7, this.f59654j);
            this.f59650f.a(i4, this.f59655k);
            iD = i3;
        }
        if (!this.f59654j) {
            this.f59648d.a(bArrC, iD, iE);
        }
        this.f59650f.a(bArrC, iD, iE);
        xf xfVar3 = this.f59649e;
        if (xfVar3 != null) {
            xfVar3.a(bArrC, iD, iE);
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f59656f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f59657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f59658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f59660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f59661e;

        public a(int i3) {
            this.f59661e = new byte[i3];
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f59657a) {
                int i5 = i4 - i3;
                byte[] bArr2 = this.f59661e;
                int length = bArr2.length;
                int i6 = this.f59659c + i5;
                if (length < i6) {
                    this.f59661e = Arrays.copyOf(bArr2, i6 * 2);
                }
                System.arraycopy(bArr, i3, this.f59661e, this.f59659c, i5);
                this.f59659c += i5;
            }
        }

        public boolean a(int i3, int i4) {
            int i5 = this.f59658b;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i3 == 179 || i3 == 181) {
                                this.f59659c -= i4;
                                this.f59657a = false;
                                return true;
                            }
                        } else if ((i3 & 240) != 32) {
                            oc.d("H263Reader", "Unexpected start code value");
                            a();
                        } else {
                            this.f59660d = this.f59659c;
                            this.f59658b = 4;
                        }
                    } else if (i3 > 31) {
                        oc.d("H263Reader", "Unexpected start code value");
                        a();
                    } else {
                        this.f59658b = 3;
                    }
                } else if (i3 != 181) {
                    oc.d("H263Reader", "Unexpected start code value");
                    a();
                } else {
                    this.f59658b = 2;
                }
            } else if (i3 == 176) {
                this.f59658b = 1;
                this.f59657a = true;
            }
            byte[] bArr = f59656f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void a() {
            this.f59657a = false;
            this.f59659c = 0;
            this.f59658b = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f59662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f59663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f59664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f59665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f59666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f59667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f59668g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f59669h;

        public b(qo qoVar) {
            this.f59662a = qoVar;
        }

        public void a(byte[] bArr, int i3, int i4) {
            if (this.f59664c) {
                int i5 = this.f59667f;
                int i6 = (i3 + 1) - i5;
                if (i6 >= i4) {
                    this.f59667f = i5 + (i4 - i3);
                } else {
                    this.f59665d = ((bArr[i6] & 192) >> 6) == 0;
                    this.f59664c = false;
                }
            }
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
        public void a(long j3, int i3, boolean z2) {
            if (this.f59666e == 182 && z2 && this.f59663b) {
                long j4 = this.f59669h;
                if (j4 != -9223372036854775807L) {
                    this.f59662a.a(j4, this.f59665d ? 1 : 0, (int) (j3 - this.f59668g), i3, null);
                }
            }
            if (this.f59666e != 179) {
                this.f59668g = j3;
            }
        }

        public void a(int i3, long j3) {
            this.f59666e = i3;
            this.f59665d = false;
            this.f59663b = i3 == 182 || i3 == 179;
            this.f59664c = i3 == 182;
            this.f59667f = 0;
            this.f59669h = j3;
        }

        public void a() {
            this.f59663b = false;
            this.f59664c = false;
            this.f59665d = false;
            this.f59666e = -1;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f59652h = dVar.b();
        qo qoVarA = l8Var.a(dVar.c(), 2);
        this.f59653i = qoVarA;
        this.f59650f = new b(qoVarA);
        vp vpVar = this.f59645a;
        if (vpVar != null) {
            vpVar.a(l8Var, dVar);
        }
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f59655k = j3;
        }
    }

    private static e9 a(a aVar, int i3, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f59661e, aVar.f59659c);
        zg zgVar = new zg(bArrCopyOf);
        zgVar.e(i3);
        zgVar.e(4);
        zgVar.g();
        zgVar.d(8);
        if (zgVar.f()) {
            zgVar.d(4);
            zgVar.d(3);
        }
        int iA = zgVar.a(4);
        float f3 = 1.0f;
        String str2 = HcgZcEUYo.aZiJYwLvQJ;
        if (iA == 15) {
            int iA2 = zgVar.a(8);
            int iA3 = zgVar.a(8);
            if (iA3 == 0) {
                oc.d(str2, "Invalid aspect ratio");
            } else {
                f3 = iA2 / iA3;
            }
        } else {
            float[] fArr = f59644l;
            if (iA < fArr.length) {
                f3 = fArr[iA];
            } else {
                oc.d(str2, "Invalid aspect ratio");
            }
        }
        if (zgVar.f()) {
            zgVar.d(2);
            zgVar.d(1);
            if (zgVar.f()) {
                zgVar.d(15);
                zgVar.g();
                zgVar.d(15);
                zgVar.g();
                zgVar.d(15);
                zgVar.g();
                zgVar.d(3);
                zgVar.d(11);
                zgVar.g();
                zgVar.d(15);
                zgVar.g();
            }
        }
        if (zgVar.a(2) != 0) {
            oc.d(str2, "Unhandled video object layer shape");
        }
        zgVar.g();
        int iA4 = zgVar.a(16);
        zgVar.g();
        if (zgVar.f()) {
            if (iA4 == 0) {
                oc.d(str2, "Invalid vop_increment_time_resolution");
            } else {
                int i4 = 0;
                for (int i5 = iA4 - 1; i5 > 0; i5 >>= 1) {
                    i4++;
                }
                zgVar.d(i4);
            }
        }
        zgVar.g();
        int iA5 = zgVar.a(13);
        zgVar.g();
        int iA6 = zgVar.a(13);
        zgVar.g();
        zgVar.g();
        return new e9.b().c(str).f("video/mp4v-es").q(iA5).g(iA6).b(f3).a(Collections.singletonList(bArrCopyOf)).a();
    }

    @Override // com.applovin.impl.p7
    public void a() {
        yf.a(this.f59647c);
        this.f59648d.a();
        b bVar = this.f59650f;
        if (bVar != null) {
            bVar.a();
        }
        xf xfVar = this.f59649e;
        if (xfVar != null) {
            xfVar.b();
        }
        this.f59651g = 0L;
        this.f59655k = -9223372036854775807L;
    }
}
