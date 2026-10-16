package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class ColorSpaceVerificationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ColorSpaceVerificationHelper f25735a = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    public static final ColorSpace c(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace colorSpaceA;
        ColorSpaces colorSpaces = ColorSpaces.f25979a;
        if (Intrinsics.areEqual(colorSpace, colorSpaces.G())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.m())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.n())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.o())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.p())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.s())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.t())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.u())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.w())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.x())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.y())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.z())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.A())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.B())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.E())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.F())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (Build.VERSION.SDK_INT >= 34 && (colorSpaceA = ColorSpaceVerificationHelperV34.a(colorSpace)) != null) {
            return colorSpaceA;
        }
        if (!(colorSpace instanceof Rgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Rgb rgb = (Rgb) colorSpace;
        float[] fArrC = rgb.J().c();
        TransferParameters transferParametersH = rgb.H();
        ColorSpace.Rgb.TransferParameters transferParameters = transferParametersH != null ? new ColorSpace.Rgb.TransferParameters(transferParametersH.a(), transferParametersH.b(), transferParametersH.c(), transferParametersH.d(), transferParametersH.e(), transferParametersH.f(), transferParametersH.g()) : null;
        if (transferParameters != null) {
            return new ColorSpace.Rgb(colorSpace.h(), rgb.G(), fArrC, transferParameters);
        }
        String strH = colorSpace.h();
        float[] fArrG = rgb.G();
        final Function1 function1D = rgb.D();
        DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.l0
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d3) {
                return ColorSpaceVerificationHelper.d(function1D, d3);
            }
        };
        final Function1 function1Z = rgb.z();
        return new ColorSpace.Rgb(strH, fArrG, fArrC, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.m0
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d3) {
                return ColorSpaceVerificationHelper.e(function1Z, d3);
            }
        }, colorSpace.f(0), colorSpace.e(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double d(Function1 function1, double d3) {
        return ((Number) function1.invoke(Double.valueOf(d3))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double e(Function1 function1, double d3) {
        return ((Number) function1.invoke(Double.valueOf(d3))).doubleValue();
    }
}
