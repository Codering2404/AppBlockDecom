package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
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
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:110:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long a(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.a(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long b(int i3) {
        return Color.o(ULong.b(ULong.b(i3) << 32));
    }

    public static final long c(int i3, int i4, int i5, int i6) {
        return b(((i3 & 255) << 16) | ((i6 & 255) << 24) | ((i4 & 255) << 8) | (i5 & 255));
    }

    public static final long d(long j3) {
        return Color.o(ULong.b(j3 << 32));
    }

    public static /* synthetic */ long e(float f3, float f4, float f5, float f6, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f6 = 1.0f;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpaces.f25979a.G();
        }
        return a(f3, f4, f5, f6, colorSpace);
    }

    public static /* synthetic */ long f(int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            i6 = 255;
        }
        return c(i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long g(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.g(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long h(long j3, long j4) {
        long jP = Color.p(j3, Color.w(j4));
        float fU = Color.u(j4);
        float fU2 = Color.u(jP);
        float f3 = 1.0f - fU2;
        float f4 = (fU * f3) + fU2;
        return g(f4 == 0.0f ? 0.0f : ((Color.y(jP) * fU2) + ((Color.y(j4) * fU) * f3)) / f4, f4 == 0.0f ? 0.0f : ((Color.x(jP) * fU2) + ((Color.x(j4) * fU) * f3)) / f4, f4 != 0.0f ? ((Color.v(jP) * fU2) + ((Color.v(j4) * fU) * f3)) / f4 : 0.0f, f4, Color.w(j4));
    }

    public static final long i(long j3, long j4, float f3) {
        ColorSpace colorSpaceD = ColorSpaces.f25979a.D();
        long jP = Color.p(j3, colorSpaceD);
        long jP2 = Color.p(j4, colorSpaceD);
        float fU = Color.u(jP);
        float fY = Color.y(jP);
        float fX = Color.x(jP);
        float fV = Color.v(jP);
        float fU2 = Color.u(jP2);
        float fY2 = Color.y(jP2);
        float fX2 = Color.x(jP2);
        float fV2 = Color.v(jP2);
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return Color.p(g(MathHelpersKt.b(fY, fY2, f3), MathHelpersKt.b(fX, fX2, f3), MathHelpersKt.b(fV, fV2, f3), MathHelpersKt.b(fU, fU2, f3), colorSpaceD), Color.w(j4));
    }

    public static final float j(long j3) {
        ColorSpace colorSpaceW = Color.w(j3);
        if (!ColorModel.f(colorSpaceW.g(), ColorModel.f25969b.b())) {
            InlineClassHelperKt.a("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.i(colorSpaceW.g())));
        }
        Intrinsics.checkNotNull(colorSpaceW, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction doubleFunctionA = ((Rgb) colorSpaceW).A();
        float fA = (float) ((doubleFunctionA.a(Color.y(j3)) * 0.2126d) + (doubleFunctionA.a(Color.x(j3)) * 0.7152d) + (doubleFunctionA.a(Color.v(j3)) * 0.0722d));
        if (fA < 0.0f) {
            fA = 0.0f;
        }
        if (fA > 1.0f) {
            return 1.0f;
        }
        return fA;
    }

    public static final int k(long j3) {
        return (int) ULong.b(Color.p(j3, ColorSpaces.f25979a.G()) >>> 32);
    }
}
