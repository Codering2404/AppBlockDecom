package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.Rgb;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Rgb extends ColorSpace {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f26039t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final DoubleFunction f26040u = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.i
        @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
        public final double a(double d3) {
            return Rgb.t(d3);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WhitePoint f26041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f26042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f26043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TransferParameters f26044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f26045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f26046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f26047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DoubleFunction f26048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Function1 f26049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final DoubleFunction f26050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final DoubleFunction f26051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Function1 f26052p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final DoubleFunction f26053q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f26054r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f26055s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double A(TransferParameters transferParameters, double d3) {
            return ColorSpaceKt.o(d3, transferParameters.a(), transferParameters.b(), transferParameters.c(), transferParameters.d(), transferParameters.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double B(TransferParameters transferParameters, double d3) {
            return ColorSpaceKt.p(d3, transferParameters.a(), transferParameters.b(), transferParameters.c(), transferParameters.d(), transferParameters.e(), transferParameters.f(), transferParameters.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean C(float[] fArr, WhitePoint whitePoint, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f3, float f4, int i3) {
            if (i3 == 0) {
                return true;
            }
            ColorSpaces colorSpaces = ColorSpaces.f25979a;
            if (!ColorSpaceKt.g(fArr, colorSpaces.H()) || !ColorSpaceKt.f(whitePoint, Illuminant.f26016a.e()) || f3 != 0.0f || f4 != 1.0f) {
                return false;
            }
            Rgb rgbG = colorSpaces.G();
            for (double d3 = 0.0d; d3 <= 1.0d; d3 += 0.00392156862745098d) {
                if (!p(d3, doubleFunction, rgbG.F()) || !p(d3, doubleFunction2, rgbG.B())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean D(float[] fArr, float f3, float f4) {
            float fO = o(fArr);
            ColorSpaces colorSpaces = ColorSpaces.f25979a;
            if (fO / o(colorSpaces.C()) <= 0.9f || !r(fArr, colorSpaces.H())) {
                return f3 < 0.0f && f4 > 1.0f;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] E(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length != 9) {
                ArraysKt.copyInto$default(fArr, fArr2, 0, 0, 6, 6, (Object) null);
                return fArr2;
            }
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = f3 + f4 + fArr[2];
            fArr2[0] = f3 / f5;
            fArr2[1] = f4 / f5;
            float f6 = fArr[3];
            float f7 = fArr[4];
            float f8 = f6 + f7 + fArr[5];
            fArr2[2] = f6 / f8;
            fArr2[3] = f7 / f8;
            float f9 = fArr[6];
            float f10 = fArr[7];
            float f11 = f9 + f10 + fArr[8];
            fArr2[4] = f9 / f11;
            fArr2[5] = f10 / f11;
            return fArr2;
        }

        private final float o(float[] fArr) {
            if (fArr.length < 6) {
                return 0.0f;
            }
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            float f6 = fArr[3];
            float f7 = fArr[4];
            float f8 = fArr[5];
            float f9 = ((((((f3 * f6) + (f4 * f7)) + (f5 * f8)) - (f6 * f7)) - (f4 * f5)) - (f3 * f8)) * 0.5f;
            return f9 < 0.0f ? -f9 : f9;
        }

        private final boolean p(double d3, DoubleFunction doubleFunction, DoubleFunction doubleFunction2) {
            return Math.abs(doubleFunction.a(d3) - doubleFunction2.a(d3)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] q(float[] fArr, WhitePoint whitePoint) {
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            float f6 = fArr[3];
            float f7 = fArr[4];
            float f8 = fArr[5];
            float fA = whitePoint.a();
            float fB = whitePoint.b();
            float f9 = 1;
            float f10 = (f9 - f3) / f4;
            float f11 = (f9 - f5) / f6;
            float f12 = (f9 - f7) / f8;
            float f13 = (f9 - fA) / fB;
            float f14 = f3 / f4;
            float f15 = (f5 / f6) - f14;
            float f16 = (fA / fB) - f14;
            float f17 = f11 - f10;
            float f18 = (f7 / f8) - f14;
            float f19 = (((f13 - f10) * f15) - (f16 * f17)) / (((f12 - f10) * f15) - (f17 * f18));
            float f20 = (f16 - (f18 * f19)) / f15;
            float f21 = (1.0f - f20) - f19;
            float f22 = f21 / f4;
            float f23 = f20 / f6;
            float f24 = f19 / f8;
            return new float[]{f22 * f3, f21, f22 * ((1.0f - f3) - f4), f23 * f5, f20, f23 * ((1.0f - f5) - f6), f24 * f7, f19, f24 * ((1.0f - f7) - f8)};
        }

        private final boolean r(float[] fArr, float[] fArr2) {
            float f3 = fArr[0];
            float f4 = fArr2[0];
            float f5 = fArr[1];
            float f6 = fArr2[1];
            float f7 = fArr[2];
            float f8 = fArr2[2];
            float f9 = fArr[3];
            float f10 = fArr2[3];
            float f11 = fArr[4];
            float f12 = fArr2[4];
            float f13 = fArr[5];
            float f14 = fArr2[5];
            float[] fArr3 = {f3 - f4, f5 - f6, f7 - f8, f9 - f10, f11 - f12, f13 - f14};
            float f15 = fArr3[0];
            float f16 = fArr3[1];
            if (((f6 - f14) * f15) - ((f4 - f12) * f16) >= 0.0f && ((f4 - f8) * f16) - ((f6 - f10) * f15) >= 0.0f) {
                float f17 = fArr3[2];
                float f18 = fArr3[3];
                if (((f10 - f6) * f17) - ((f8 - f4) * f18) >= 0.0f && ((f8 - f12) * f18) - ((f10 - f14) * f17) >= 0.0f) {
                    float f19 = fArr3[4];
                    float f20 = fArr3[5];
                    if (((f14 - f10) * f19) - ((f12 - f8) * f20) >= 0.0f && ((f12 - f4) * f20) - ((f14 - f6) * f19) >= 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction s(final TransferParameters transferParameters) {
            return transferParameters.h() ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.l
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.t(transferParameters, d3);
                }
            } : transferParameters.i() ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.m
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.u(transferParameters, d3);
                }
            } : (transferParameters.e() == 0.0d && transferParameters.f() == 0.0d) ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.n
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.v(transferParameters, d3);
                }
            } : new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.o
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.w(transferParameters, d3);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double t(TransferParameters transferParameters, double d3) {
            return ColorSpaces.f25979a.J(transferParameters, d3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double u(TransferParameters transferParameters, double d3) {
            return ColorSpaces.f25979a.L(transferParameters, d3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double v(TransferParameters transferParameters, double d3) {
            return ColorSpaceKt.q(d3, transferParameters.a(), transferParameters.b(), transferParameters.c(), transferParameters.d(), transferParameters.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double w(TransferParameters transferParameters, double d3) {
            return ColorSpaceKt.r(d3, transferParameters.a(), transferParameters.b(), transferParameters.c(), transferParameters.d(), transferParameters.e(), transferParameters.f(), transferParameters.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction x(final TransferParameters transferParameters) {
            return transferParameters.h() ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.p
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.y(transferParameters, d3);
                }
            } : transferParameters.i() ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.q
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.z(transferParameters, d3);
                }
            } : (transferParameters.e() == 0.0d && transferParameters.f() == 0.0d) ? new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.r
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.A(transferParameters, d3);
                }
            } : new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.s
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d3) {
                    return Rgb.Companion.B(transferParameters, d3);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double y(TransferParameters transferParameters, double d3) {
            return ColorSpaces.f25979a.K(transferParameters, d3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double z(TransferParameters transferParameters, double d3) {
            return ColorSpaces.f25979a.M(transferParameters, d3);
        }

        private Companion() {
        }
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f3, float f4, TransferParameters transferParameters, int i3) {
        super(str, ColorModel.f25969b.b(), i3, null);
        this.f26041e = whitePoint;
        this.f26042f = f3;
        this.f26043g = f4;
        this.f26044h = transferParameters;
        this.f26048l = doubleFunction;
        this.f26049m = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            {
                super(1);
            }

            public final Double c(double d3) {
                return Double.valueOf(RangesKt.n(this.f26057a.F().a(d3), this.f26057a.f26042f, this.f26057a.f26043g));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).doubleValue());
            }
        };
        this.f26050n = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.g
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return Rgb.K(this.f26067a, d3);
            }
        };
        this.f26051o = doubleFunction2;
        this.f26052p = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            {
                super(1);
            }

            public final Double c(double d3) {
                return Double.valueOf(this.f26056a.B().a(RangesKt.n(d3, this.f26056a.f26042f, this.f26056a.f26043g)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).doubleValue());
            }
        };
        this.f26053q = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.h
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return Rgb.y(this.f26068a, d3);
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Invalid range: min=" + f3 + ", max=" + f4 + "; min must be strictly < max");
        }
        Companion companion = f26039t;
        float[] fArrE = companion.E(fArr);
        this.f26045i = fArrE;
        if (fArr2 == null) {
            this.f26046j = companion.q(fArrE, whitePoint);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.f26046j = fArr2;
        }
        this.f26047k = ColorSpaceKt.k(this.f26046j);
        this.f26054r = companion.D(fArrE, f3, f4);
        this.f26055s = companion.C(fArrE, whitePoint, doubleFunction, doubleFunction2, f3, f4, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double K(Rgb rgb, double d3) {
        return RangesKt.n(rgb.f26048l.a(d3), rgb.f26042f, rgb.f26043g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double u(double d3, double d4) {
        if (d4 < 0.0d) {
            d4 = 0.0d;
        }
        return Math.pow(d4, 1.0d / d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double v(double d3, double d4) {
        if (d4 < 0.0d) {
            d4 = 0.0d;
        }
        return Math.pow(d4, d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double y(Rgb rgb, double d3) {
        return rgb.f26051o.a(RangesKt.n(d3, rgb.f26042f, rgb.f26043g));
    }

    public final DoubleFunction A() {
        return this.f26053q;
    }

    public final DoubleFunction B() {
        return this.f26051o;
    }

    public final float[] C() {
        return this.f26047k;
    }

    public final Function1 D() {
        return this.f26049m;
    }

    public final DoubleFunction E() {
        return this.f26050n;
    }

    public final DoubleFunction F() {
        return this.f26048l;
    }

    public final float[] G() {
        return this.f26045i;
    }

    public final TransferParameters H() {
        return this.f26044h;
    }

    public final float[] I() {
        return this.f26046j;
    }

    public final WhitePoint J() {
        return this.f26041e;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] b(float[] fArr) {
        ColorSpaceKt.n(this.f26047k, fArr);
        if (fArr.length < 3) {
            return fArr;
        }
        fArr[0] = (float) this.f26050n.a(fArr[0]);
        fArr[1] = (float) this.f26050n.a(fArr[1]);
        fArr[2] = (float) this.f26050n.a(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float e(int i3) {
        return this.f26043g;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.f26042f, this.f26042f) != 0 || Float.compare(rgb.f26043g, this.f26043g) != 0 || !Intrinsics.areEqual(this.f26041e, rgb.f26041e) || !Arrays.equals(this.f26045i, rgb.f26045i)) {
            return false;
        }
        TransferParameters transferParameters = this.f26044h;
        if (transferParameters != null) {
            return Intrinsics.areEqual(transferParameters, rgb.f26044h);
        }
        if (rgb.f26044h == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.f26048l, rgb.f26048l)) {
            return Intrinsics.areEqual(this.f26051o, rgb.f26051o);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float f(int i3) {
        return this.f26042f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int iHashCode = ((((super.hashCode() * 31) + this.f26041e.hashCode()) * 31) + Arrays.hashCode(this.f26045i)) * 31;
        float f3 = this.f26042f;
        int iFloatToIntBits = (iHashCode + (f3 == 0.0f ? 0 : Float.floatToIntBits(f3))) * 31;
        float f4 = this.f26043g;
        int iFloatToIntBits2 = (iFloatToIntBits + (f4 == 0.0f ? 0 : Float.floatToIntBits(f4))) * 31;
        TransferParameters transferParameters = this.f26044h;
        int iHashCode2 = iFloatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        return this.f26044h == null ? (((iHashCode2 * 31) + this.f26048l.hashCode()) * 31) + this.f26051o.hashCode() : iHashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean i() {
        return this.f26055s;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long j(float f3, float f4, float f5) {
        float fA = (float) this.f26053q.a(f3);
        float fA2 = (float) this.f26053q.a(f4);
        float fA3 = (float) this.f26053q.a(f5);
        float[] fArr = this.f26046j;
        if (fArr.length < 9) {
            return 0L;
        }
        return (((long) Float.floatToRawIntBits(((fArr[0] * fA) + (fArr[3] * fA2)) + (fArr[6] * fA3))) << 32) | (((long) Float.floatToRawIntBits((fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3))) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] l(float[] fArr) {
        if (fArr.length < 3) {
            return fArr;
        }
        fArr[0] = (float) this.f26053q.a(fArr[0]);
        fArr[1] = (float) this.f26053q.a(fArr[1]);
        fArr[2] = (float) this.f26053q.a(fArr[2]);
        return ColorSpaceKt.n(this.f26046j, fArr);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float m(float f3, float f4, float f5) {
        float fA = (float) this.f26053q.a(f3);
        float fA2 = (float) this.f26053q.a(f4);
        float fA3 = (float) this.f26053q.a(f5);
        float[] fArr = this.f26046j;
        return (fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long n(float f3, float f4, float f5, float f6, ColorSpace colorSpace) {
        float[] fArr = this.f26047k;
        return ColorKt.a((float) this.f26050n.a((fArr[0] * f3) + (fArr[3] * f4) + (fArr[6] * f5)), (float) this.f26050n.a((fArr[1] * f3) + (fArr[4] * f4) + (fArr[7] * f5)), (float) this.f26050n.a((fArr[2] * f3) + (fArr[5] * f4) + (fArr[8] * f5)), f6, colorSpace);
    }

    public final Function1 z() {
        return this.f26052p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double t(double d3) {
        return d3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, TransferParameters transferParameters, int i3) {
        Companion companion = f26039t;
        this(str, fArr, whitePoint, null, companion.x(transferParameters), companion.s(transferParameters), 0.0f, 1.0f, transferParameters, i3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final double d3, float f3, float f4, int i3) {
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2;
        if (d3 == 1.0d) {
            doubleFunction = f26040u;
        } else {
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.j
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d4) {
                    return Rgb.u(d3, d4);
                }
            };
        }
        DoubleFunction doubleFunction3 = doubleFunction;
        if (d3 == 1.0d) {
            doubleFunction2 = f26040u;
        } else {
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.k
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double a(double d4) {
                    return Rgb.v(d3, d4);
                }
            };
        }
        this(str, fArr, whitePoint, null, doubleFunction3, doubleFunction2, f3, f4, new TransferParameters(d3, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i3);
    }

    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint) {
        this(rgb.h(), rgb.f26045i, whitePoint, fArr, rgb.f26048l, rgb.f26051o, rgb.f26042f, rgb.f26043g, rgb.f26044h, -1);
    }
}
