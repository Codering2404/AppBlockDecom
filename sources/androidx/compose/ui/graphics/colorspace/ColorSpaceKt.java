package androidx.compose.ui.graphics.colorspace;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.Connector;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ColorSpaceKt {
    public static final double a(double d3, double d4, double d5, double d6, double d7, double d8) {
        return Math.copySign(o(d3 < 0.0d ? -d3 : d3, d4, d5, d6, d7, d8), d3);
    }

    public static final double b(double d3, double d4, double d5, double d6, double d7, double d8) {
        return Math.copySign(q(d3 < 0.0d ? -d3 : d3, d4, d5, d6, d7, d8), d3);
    }

    public static final ColorSpace c(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation) {
        if (ColorModel.f(colorSpace.g(), ColorModel.f25969b.b())) {
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) colorSpace;
            if (!f(rgb.J(), whitePoint)) {
                return new Rgb(rgb, l(e(adaptation.b(), rgb.J().c(), whitePoint.c()), rgb.I()), whitePoint);
            }
        }
        return colorSpace;
    }

    public static /* synthetic */ ColorSpace d(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            adaptation = Adaptation.f25964b.a();
        }
        return c(colorSpace, whitePoint, adaptation);
    }

    public static final float[] e(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArrN = n(fArr, fArr2);
        float[] fArrN2 = n(fArr, fArr3);
        return l(k(fArr), m(new float[]{fArrN2[0] / fArrN[0], fArrN2[1] / fArrN[1], fArrN2[2] / fArrN[2]}, fArr));
    }

    public static final boolean f(WhitePoint whitePoint, WhitePoint whitePoint2) {
        if (whitePoint == whitePoint2) {
            return true;
        }
        return Math.abs(whitePoint.a() - whitePoint2.a()) < 0.001f && Math.abs(whitePoint.b() - whitePoint2.b()) < 0.001f;
    }

    public static final boolean g(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (Float.compare(fArr[i3], fArr2[i3]) != 0 && Math.abs(fArr[i3] - fArr2[i3]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final Connector h(ColorSpace colorSpace, ColorSpace colorSpace2, int i3) {
        int iD = colorSpace.d();
        int iD2 = colorSpace2.d();
        if ((iD | iD2) < 0) {
            return j(colorSpace, colorSpace2, i3);
        }
        MutableIntObjectMap mutableIntObjectMapA = ConnectorKt.a();
        int i4 = iD | (iD2 << 6) | (i3 << 12);
        Object objB = mutableIntObjectMapA.b(i4);
        if (objB == null) {
            objB = j(colorSpace, colorSpace2, i3);
            mutableIntObjectMapA.r(i4, objB);
        }
        return (Connector) objB;
    }

    public static /* synthetic */ Connector i(ColorSpace colorSpace, ColorSpace colorSpace2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            colorSpace2 = ColorSpaces.f25979a.G();
        }
        if ((i4 & 2) != 0) {
            i3 = RenderIntent.f26033b.b();
        }
        return h(colorSpace, colorSpace2, i3);
    }

    private static final Connector j(ColorSpace colorSpace, ColorSpace colorSpace2, int i3) {
        if (colorSpace == colorSpace2) {
            return Connector.f26005g.c(colorSpace);
        }
        long jG = colorSpace.g();
        ColorModel.Companion companion = ColorModel.f25969b;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (!ColorModel.f(jG, companion.b()) || !ColorModel.f(colorSpace2.g(), companion.b())) {
            return new Connector(colorSpace, colorSpace2, i3, defaultConstructorMarker);
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Intrinsics.checkNotNull(colorSpace2, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        return new Connector.RgbConnector((Rgb) colorSpace, (Rgb) colorSpace2, i3, defaultConstructorMarker);
    }

    public static final float[] k(float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[3];
        float f5 = fArr[6];
        float f6 = fArr[1];
        float f7 = fArr[4];
        float f8 = fArr[7];
        float f9 = fArr[2];
        float f10 = fArr[5];
        float f11 = fArr[8];
        float f12 = (f7 * f11) - (f8 * f10);
        float f13 = (f8 * f9) - (f6 * f11);
        float f14 = (f6 * f10) - (f7 * f9);
        float f15 = (f3 * f12) + (f4 * f13) + (f5 * f14);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f12 / f15;
        fArr2[1] = f13 / f15;
        fArr2[2] = f14 / f15;
        fArr2[3] = ((f5 * f10) - (f4 * f11)) / f15;
        fArr2[4] = ((f11 * f3) - (f5 * f9)) / f15;
        fArr2[5] = ((f9 * f4) - (f10 * f3)) / f15;
        fArr2[6] = ((f4 * f8) - (f5 * f7)) / f15;
        fArr2[7] = ((f5 * f6) - (f8 * f3)) / f15;
        fArr2[8] = ((f3 * f7) - (f4 * f6)) / f15;
        return fArr2;
    }

    public static final float[] l(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        if (fArr.length < 9 || fArr2.length < 9) {
            return fArr3;
        }
        float f3 = fArr[0] * fArr2[0];
        float f4 = fArr[3];
        float f5 = fArr2[1];
        float f6 = fArr[6];
        float f7 = fArr2[2];
        fArr3[0] = f3 + (f4 * f5) + (f6 * f7);
        float f8 = fArr[1];
        float f9 = fArr2[0];
        float f10 = fArr[4];
        float f11 = fArr[7];
        fArr3[1] = (f8 * f9) + (f5 * f10) + (f11 * f7);
        float f12 = fArr[2] * f9;
        float f13 = fArr[5];
        float f14 = f12 + (fArr2[1] * f13);
        float f15 = fArr[8];
        fArr3[2] = f14 + (f7 * f15);
        float f16 = fArr[0];
        float f17 = fArr2[3] * f16;
        float f18 = fArr2[4];
        float f19 = f17 + (f4 * f18);
        float f20 = fArr2[5];
        fArr3[3] = f19 + (f6 * f20);
        float f21 = fArr[1];
        float f22 = fArr2[3];
        fArr3[4] = (f21 * f22) + (f10 * f18) + (f11 * f20);
        float f23 = fArr[2];
        fArr3[5] = (f22 * f23) + (f13 * fArr2[4]) + (f20 * f15);
        float f24 = f16 * fArr2[6];
        float f25 = fArr[3];
        float f26 = fArr2[7];
        float f27 = f24 + (f25 * f26);
        float f28 = fArr2[8];
        fArr3[6] = f27 + (f6 * f28);
        float f29 = fArr2[6];
        fArr3[7] = (f21 * f29) + (fArr[4] * f26) + (f11 * f28);
        fArr3[8] = (f23 * f29) + (fArr[5] * fArr2[7]) + (f15 * f28);
        return fArr3;
    }

    public static final float[] m(float[] fArr, float[] fArr2) {
        float f3 = fArr[0];
        float f4 = fArr2[0] * f3;
        float f5 = fArr[1];
        float f6 = fArr2[1] * f5;
        float f7 = fArr[2];
        return new float[]{f4, f6, fArr2[2] * f7, fArr2[3] * f3, fArr2[4] * f5, fArr2[5] * f7, f3 * fArr2[6], f5 * fArr2[7], f7 * fArr2[8]};
    }

    public static final float[] n(float[] fArr, float[] fArr2) {
        if (fArr.length < 9 || fArr2.length < 3) {
            return fArr2;
        }
        float f3 = fArr2[0];
        float f4 = fArr2[1];
        float f5 = fArr2[2];
        fArr2[0] = (fArr[0] * f3) + (fArr[3] * f4) + (fArr[6] * f5);
        fArr2[1] = (fArr[1] * f3) + (fArr[4] * f4) + (fArr[7] * f5);
        fArr2[2] = (fArr[2] * f3) + (fArr[5] * f4) + (fArr[8] * f5);
        return fArr2;
    }

    public static final double o(double d3, double d4, double d5, double d6, double d7, double d8) {
        return d3 >= d7 * d6 ? (Math.pow(d3, 1.0d / d8) - d5) / d4 : d3 / d6;
    }

    public static final double p(double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return d3 >= d7 * d6 ? (Math.pow(d3 - d8, 1.0d / d10) - d5) / d4 : (d3 - d9) / d6;
    }

    public static final double q(double d3, double d4, double d5, double d6, double d7, double d8) {
        return d3 >= d7 ? Math.pow((d4 * d3) + d5, d8) : d6 * d3;
    }

    public static final double r(double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return d3 >= d7 ? Math.pow((d4 * d3) + d5, d10) + d8 : (d6 * d3) + d9;
    }
}
