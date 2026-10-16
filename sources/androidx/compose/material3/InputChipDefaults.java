package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;

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
public final class InputChipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InputChipDefaults f17993a = new InputChipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f17994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f17996d;

    static {
        InputChipTokens inputChipTokens = InputChipTokens.f22880a;
        f17994b = inputChipTokens.d();
        f17995c = inputChipTokens.m();
        f17996d = inputChipTokens.b();
    }

    private InputChipDefaults() {
    }

    public final SelectableChipColors a(ColorScheme colorScheme) {
        SelectableChipColors selectableChipColorsX = colorScheme.x();
        if (selectableChipColorsX != null) {
            return selectableChipColorsX;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        InputChipTokens inputChipTokens = InputChipTokens.f22880a;
        SelectableChipColors selectableChipColors = new SelectableChipColors(j3, ColorSchemeKt.g(colorScheme, inputChipTokens.s()), ColorSchemeKt.g(colorScheme, inputChipTokens.t()), ColorSchemeKt.g(colorScheme, inputChipTokens.w()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, inputChipTokens.f()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, inputChipTokens.g()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, inputChipTokens.i()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, inputChipTokens.n()), Color.r(ColorSchemeKt.g(colorScheme, inputChipTokens.h()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, inputChipTokens.o()), ColorSchemeKt.g(colorScheme, inputChipTokens.p()), ColorSchemeKt.g(colorScheme, inputChipTokens.r()), null);
        colorScheme.U0(selectableChipColors);
        return selectableChipColors;
    }

    public final float b() {
        return f17994b;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1052444143, i3, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1721)");
        }
        Shape shapeE = ShapesKt.e(InputChipTokens.f22880a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final BorderStroke d(boolean z2, boolean z3, long j3, long j4, long j5, long j6, float f3, float f4, Composer composer, int i3, int i4) {
        long jI = (i4 & 4) != 0 ? ColorSchemeKt.i(InputChipTokens.f22880a.u(), composer, 6) : j3;
        long j7 = (i4 & 8) != 0 ? Color.f25715b.j() : j4;
        long jR = (i4 & 16) != 0 ? Color.r(ColorSchemeKt.i(InputChipTokens.f22880a.j(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long j8 = (i4 & 32) != 0 ? Color.f25715b.j() : j6;
        float fV = (i4 & 64) != 0 ? InputChipTokens.f22880a.v() : f3;
        float fQ = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? InputChipTokens.f22880a.q() : f4;
        if (ComposerKt.M()) {
            ComposerKt.U(2050575347, i3, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1709)");
        }
        if (!z2) {
            jI = z3 ? j8 : jR;
        } else if (z3) {
            jI = j7;
        }
        if (z3) {
            fV = fQ;
        }
        BorderStroke borderStrokeA = BorderStrokeKt.a(fV, jI);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStrokeA;
    }

    public final SelectableChipColors e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-770375587, i3, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1568)");
        }
        SelectableChipColors selectableChipColorsA = a(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return selectableChipColorsA;
    }

    public final SelectableChipElevation f(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = InputChipTokens.f22880a.c();
        }
        if ((i4 & 2) != 0) {
            f4 = f3;
        }
        if ((i4 & 4) != 0) {
            f5 = f3;
        }
        if ((i4 & 8) != 0) {
            f6 = f3;
        }
        if ((i4 & 16) != 0) {
            f7 = InputChipTokens.f22880a.k();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = f3;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1745270109, i3, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1672)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return selectableChipElevation;
    }
}
