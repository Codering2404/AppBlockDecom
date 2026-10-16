package androidx.compose.ui.graphics.colorspace;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ColorSpaces {
    private static final Rgb A;
    private static final ColorSpace B;
    private static final ColorSpace[] C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ColorSpaces f25979a = new ColorSpaces();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f25980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float[] f25981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f25982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TransferParameters f25983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TransferParameters f25984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TransferParameters f25985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TransferParameters f25986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Rgb f25987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Rgb f25988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Rgb f25989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Rgb f25990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Rgb f25991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Rgb f25992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Rgb f25993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Rgb f25994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Rgb f25995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Rgb f25996r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Rgb f25997s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Rgb f25998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Rgb f25999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Rgb f26000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final ColorSpace f26001w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ColorSpace f26002x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Rgb f26003y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Rgb f26004z;

    private ColorSpaces() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double g(double d3) {
        return f25979a.K(f25985g, d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double h(double d3) {
        return f25979a.J(f25985g, d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double i(double d3) {
        return f25979a.M(f25986h, d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double j(double d3) {
        return f25979a.L(f25986h, d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double k(double d3) {
        return ColorSpaceKt.a(d3, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double l(double d3) {
        return ColorSpaceKt.b(d3, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    public final Rgb A() {
        return f25988j;
    }

    public final Rgb B() {
        return f25995q;
    }

    public final float[] C() {
        return f25981c;
    }

    public final ColorSpace D() {
        return B;
    }

    public final Rgb E() {
        return f25998t;
    }

    public final Rgb F() {
        return f25996r;
    }

    public final Rgb G() {
        return f25987i;
    }

    public final float[] H() {
        return f25980b;
    }

    public final Rgb I() {
        return f26003y;
    }

    public final double J(TransferParameters transferParameters, double d3) {
        double d4 = d3 < 0.0d ? -1.0d : 1.0d;
        double d5 = d3 * d4;
        double dA = transferParameters.a();
        double dB = transferParameters.b();
        double dC = transferParameters.c();
        double d6 = transferParameters.d();
        double dE = transferParameters.e();
        double d7 = dA * d5;
        return (transferParameters.f() + 1.0d) * d4 * (d7 <= 1.0d ? Math.pow(d7, dB) : Math.exp((d5 - dE) * dC) + d6);
    }

    public final double K(TransferParameters transferParameters, double d3) {
        double d4 = d3 < 0.0d ? -1.0d : 1.0d;
        double dA = 1.0d / transferParameters.a();
        double dB = 1.0d / transferParameters.b();
        double dC = 1.0d / transferParameters.c();
        double d5 = transferParameters.d();
        double dE = transferParameters.e();
        double dF = (d3 * d4) / (transferParameters.f() + 1.0d);
        return d4 * (dF <= 1.0d ? dA * Math.pow(dF, dB) : (dC * Math.log(dF - d5)) + dE);
    }

    public final double L(TransferParameters transferParameters, double d3) {
        double d4 = d3 < 0.0d ? -1.0d : 1.0d;
        double d5 = d3 * d4;
        return d4 * Math.pow(RangesKt.d(transferParameters.a() + (transferParameters.b() * Math.pow(d5, transferParameters.c())), 0.0d) / (transferParameters.d() + (transferParameters.e() * Math.pow(d5, transferParameters.c()))), transferParameters.f());
    }

    public final double M(TransferParameters transferParameters, double d3) {
        double d4 = d3 < 0.0d ? -1.0d : 1.0d;
        double d5 = d3 * d4;
        double d6 = -transferParameters.a();
        double d7 = transferParameters.d();
        double dF = 1.0d / transferParameters.f();
        return d4 * Math.pow(Math.max(d6 + (d7 * Math.pow(d5, dF)), 0.0d) / (transferParameters.b() + ((-transferParameters.e()) * Math.pow(d5, dF))), 1.0d / transferParameters.c());
    }

    public final Rgb m() {
        return f25999u;
    }

    public final Rgb n() {
        return f26000v;
    }

    public final Rgb o() {
        return f25997s;
    }

    public final Rgb p() {
        return f25992n;
    }

    public final Rgb q() {
        return f26004z;
    }

    public final Rgb r() {
        return A;
    }

    public final Rgb s() {
        return f25991m;
    }

    public final ColorSpace t() {
        return f26002x;
    }

    public final ColorSpace u() {
        return f26001w;
    }

    public final ColorSpace[] v() {
        return C;
    }

    public final Rgb w() {
        return f25993o;
    }

    public final Rgb x() {
        return f25994p;
    }

    public final Rgb y() {
        return f25989k;
    }

    public final Rgb z() {
        return f25990l;
    }

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        f25980b = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        f25981c = fArr2;
        float[] fArr3 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        f25982d = fArr3;
        TransferParameters transferParameters = new TransferParameters(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        f25983e = transferParameters;
        TransferParameters transferParameters2 = new TransferParameters(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        f25984f = transferParameters2;
        TransferParameters transferParameters3 = new TransferParameters(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        f25985g = transferParameters3;
        TransferParameters transferParameters4 = new TransferParameters(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        f25986h = transferParameters4;
        Illuminant illuminant = Illuminant.f26016a;
        Rgb rgb = new Rgb("sRGB IEC61966-2.1", fArr, illuminant.e(), transferParameters, 0);
        f25987i = rgb;
        Rgb rgb2 = new Rgb("sRGB IEC61966-2.1 (Linear)", fArr, illuminant.e(), 1.0d, 0.0f, 1.0f, 1);
        f25988j = rgb2;
        Rgb rgb3 = new Rgb("scRGB-nl IEC 61966-2-2:2003", fArr, illuminant.e(), null, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.a
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.k(d3);
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.b
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.l(d3);
            }
        }, -0.799f, 2.399f, transferParameters, 2);
        f25989k = rgb3;
        Rgb rgb4 = new Rgb("scRGB IEC 61966-2-2:2003", fArr, illuminant.e(), 1.0d, -0.5f, 7.499f, 3);
        f25990l = rgb4;
        Rgb rgb5 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, illuminant.e(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 4);
        f25991m = rgb5;
        Rgb rgb6 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, illuminant.e(), new TransferParameters(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, 0.0d, 0.0d, 96, null), 5);
        f25992n = rgb6;
        Rgb rgb7 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        f25993o = rgb7;
        Rgb rgb8 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, illuminant.e(), transferParameters, 7);
        f25994p = rgb8;
        Rgb rgb9 = new Rgb("NTSC (1953)", fArr2, illuminant.a(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 8);
        f25995q = rgb9;
        Rgb rgb10 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, illuminant.e(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 9);
        f25996r = rgb10;
        Rgb rgb11 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, illuminant.e(), 2.2d, 0.0f, 1.0f, 10);
        f25997s = rgb11;
        Rgb rgb12 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, illuminant.b(), new TransferParameters(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d, 0.0d, 0.0d, 96, null), 11);
        f25998t = rgb12;
        Rgb rgb13 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, illuminant.d(), 1.0d, -65504.0f, 65504.0f, 12);
        f25999u = rgb13;
        Rgb rgb14 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, illuminant.d(), 1.0d, -65504.0f, 65504.0f, 13);
        f26000v = rgb14;
        Xyz xyz = new Xyz("Generic XYZ", 14);
        f26001w = xyz;
        Lab lab = new Lab("Generic L*a*b*", 15);
        f26002x = lab;
        Rgb rgb15 = new Rgb(tDEtWsFLJfe.LszxVqu, fArr, illuminant.e(), transferParameters2, 16);
        f26003y = rgb15;
        Rgb rgb16 = new Rgb("Hybrid Log Gamma encoding", fArr3, illuminant.e(), null, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.c
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.g(d3);
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.d
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.h(d3);
            }
        }, 0.0f, 1.0f, transferParameters3, 17);
        f26004z = rgb16;
        Rgb rgb17 = new Rgb("Perceptual Quantizer encoding", fArr3, illuminant.e(), null, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.e
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.i(d3);
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.f
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double a(double d3) {
                return ColorSpaces.j(d3);
            }
        }, 0.0f, 1.0f, transferParameters4, 18);
        A = rgb17;
        Oklab oklab = new Oklab("Oklab", 19);
        B = oklab;
        C = new ColorSpace[]{rgb, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9, rgb10, rgb11, rgb12, rgb13, rgb14, xyz, lab, rgb15, rgb16, rgb17, oklab};
    }
}
