package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public class Connector {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f26005g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorSpace f26006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorSpace f26007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorSpace f26008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorSpace f26009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f26010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f26011f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] b(ColorSpace colorSpace, ColorSpace colorSpace2, int i3) {
            if (!RenderIntent.f(i3, RenderIntent.f26033b.a())) {
                return null;
            }
            long jG = colorSpace.g();
            ColorModel.Companion companion = ColorModel.f25969b;
            boolean zF = ColorModel.f(jG, companion.b());
            boolean zF2 = ColorModel.f(colorSpace2.g(), companion.b());
            if (zF && zF2) {
                return null;
            }
            if (!zF && !zF2) {
                return null;
            }
            if (!zF) {
                colorSpace = colorSpace2;
            }
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) colorSpace;
            float[] fArrC = zF ? rgb.J().c() : Illuminant.f26016a.c();
            float[] fArrC2 = zF2 ? rgb.J().c() : Illuminant.f26016a.c();
            return new float[]{fArrC[0] / fArrC2[0], fArrC[1] / fArrC2[1], fArrC[2] / fArrC2[2]};
        }

        public final Connector c(final ColorSpace colorSpace) {
            final int iC = RenderIntent.f26033b.c();
            return new Connector(colorSpace, iC) { // from class: androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
                {
                    super(colorSpace, colorSpace, iC, null);
                }

                @Override // androidx.compose.ui.graphics.colorspace.Connector
                public long a(long j3) {
                    return j3;
                }
            };
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RgbConnector extends Connector {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Rgb f26012h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Rgb f26013i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f26014j;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i3);
        }

        private final float[] b(Rgb rgb, Rgb rgb2, int i3) {
            if (ColorSpaceKt.f(rgb.J(), rgb2.J())) {
                return ColorSpaceKt.l(rgb2.C(), rgb.I());
            }
            float[] fArrI = rgb.I();
            float[] fArrC = rgb2.C();
            float[] fArrC2 = rgb.J().c();
            float[] fArrC3 = rgb2.J().c();
            WhitePoint whitePointJ = rgb.J();
            Illuminant illuminant = Illuminant.f26016a;
            if (!ColorSpaceKt.f(whitePointJ, illuminant.b())) {
                fArrI = ColorSpaceKt.l(ColorSpaceKt.e(Adaptation.f25964b.a().b(), fArrC2, illuminant.f()), rgb.I());
            }
            if (!ColorSpaceKt.f(rgb2.J(), illuminant.b())) {
                fArrC = ColorSpaceKt.k(ColorSpaceKt.l(ColorSpaceKt.e(Adaptation.f25964b.a().b(), fArrC3, illuminant.f()), rgb2.I()));
            }
            if (RenderIntent.f(i3, RenderIntent.f26033b.a())) {
                fArrI = ColorSpaceKt.m(new float[]{fArrC2[0] / fArrC3[0], fArrC2[1] / fArrC3[1], fArrC2[2] / fArrC3[2]}, fArrI);
            }
            return ColorSpaceKt.l(fArrC, fArrI);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        public long a(long j3) {
            float fY = Color.y(j3);
            float fX = Color.x(j3);
            float fV = Color.v(j3);
            float fU = Color.u(j3);
            float fA = (float) this.f26012h.A().a(fY);
            float fA2 = (float) this.f26012h.A().a(fX);
            float fA3 = (float) this.f26012h.A().a(fV);
            float[] fArr = this.f26014j;
            return ColorKt.a((float) this.f26013i.E().a((fArr[0] * fA) + (fArr[3] * fA2) + (fArr[6] * fA3)), (float) this.f26013i.E().a((fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3)), (float) this.f26013i.E().a((fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3)), fU, this.f26013i);
        }

        private RgbConnector(Rgb rgb, Rgb rgb2, int i3) {
            super(rgb, rgb2, rgb, rgb2, i3, null, null);
            this.f26012h = rgb;
            this.f26013i = rgb2;
            this.f26014j = b(rgb, rgb2, i3);
        }
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, i3);
    }

    public long a(long j3) {
        float fY = Color.y(j3);
        float fX = Color.x(j3);
        float fV = Color.v(j3);
        float fU = Color.u(j3);
        long j4 = this.f26008c.j(fY, fX, fV);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j4 & 4294967295L));
        float fM = this.f26008c.m(fY, fX, fV);
        float[] fArr = this.f26011f;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            fM *= fArr[2];
        }
        float f3 = fIntBitsToFloat;
        return this.f26009d.n(f3, fIntBitsToFloat2, fM, fU, this.f26007b);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i3, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i3, fArr);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i3, float[] fArr) {
        this.f26006a = colorSpace;
        this.f26007b = colorSpace2;
        this.f26008c = colorSpace3;
        this.f26009d = colorSpace4;
        this.f26010e = i3;
        this.f26011f = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i3) {
        long jG = colorSpace.g();
        ColorModel.Companion companion = ColorModel.f25969b;
        this(colorSpace, colorSpace2, ColorModel.f(jG, companion.b()) ? ColorSpaceKt.d(colorSpace, Illuminant.f26016a.b(), null, 2, null) : colorSpace, ColorModel.f(colorSpace2.g(), companion.b()) ? ColorSpaceKt.d(colorSpace2, Illuminant.f26016a.b(), null, 2, null) : colorSpace2, i3, f26005g.b(colorSpace, colorSpace2, i3), null);
    }
}
