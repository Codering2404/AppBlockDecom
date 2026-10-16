package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
public final class AssistChipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AssistChipDefaults f15894a = new AssistChipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15896c;

    static {
        AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
        f15895b = assistChipTokens.a();
        f15896c = assistChipTokens.v();
    }

    private AssistChipDefaults() {
    }

    public final ChipBorder a(long j3, long j4, float f3, Composer composer, int i3, int i4) {
        long jR;
        long jI = (i4 & 1) != 0 ? ColorSchemeKt.i(AssistChipTokens.f22294a.s(), composer, 6) : j3;
        if ((i4 & 2) != 0) {
            AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
            jR = Color.r(ColorSchemeKt.i(assistChipTokens.q(), composer, 6), assistChipTokens.r(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j4;
        }
        float fT = (i4 & 4) != 0 ? AssistChipTokens.f22294a.t() : f3;
        if (ComposerKt.M()) {
            ComposerKt.U(382372847, i3, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1152)");
        }
        ChipBorder chipBorder = new ChipBorder(jI, jR, fT, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipBorder;
    }

    public final BorderStroke b(boolean z2, long j3, long j4, float f3, Composer composer, int i3, int i4) {
        long jR;
        long jI = (i4 & 2) != 0 ? ColorSchemeKt.i(AssistChipTokens.f22294a.s(), composer, 6) : j3;
        if ((i4 & 4) != 0) {
            AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
            jR = Color.r(ColorSchemeKt.i(assistChipTokens.q(), composer, 6), assistChipTokens.r(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j4;
        }
        float fT = (i4 & 8) != 0 ? AssistChipTokens.f22294a.t() : f3;
        if (ComposerKt.M()) {
            ComposerKt.U(-1458649561, i3, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1124)");
        }
        if (!z2) {
            jI = jR;
        }
        BorderStroke borderStrokeA = BorderStrokeKt.a(fT, jI);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStrokeA;
    }

    public final ChipColors c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1961061417, i3, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1019)");
        }
        ChipColors chipColorsG = g(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipColorsG;
    }

    public final ChipElevation d(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = AssistChipTokens.f22294a.p();
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
            f7 = AssistChipTokens.f22294a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = f3;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(245366099, i3, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1098)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        ChipElevation chipElevation = new ChipElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipElevation;
    }

    public final ChipColors e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(655175583, i3, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1163)");
        }
        ChipColors chipColorsH = h(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipColorsH;
    }

    public final ChipElevation f(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = AssistChipTokens.f22294a.i();
        }
        if ((i4 & 2) != 0) {
            f4 = AssistChipTokens.f22294a.o();
        }
        if ((i4 & 4) != 0) {
            f5 = AssistChipTokens.f22294a.m();
        }
        if ((i4 & 8) != 0) {
            f6 = AssistChipTokens.f22294a.n();
        }
        if ((i4 & 16) != 0) {
            f7 = AssistChipTokens.f22294a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = AssistChipTokens.f22294a.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1457698077, i3, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1244)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        ChipElevation chipElevation = new ChipElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipElevation;
    }

    public final ChipColors g(ColorScheme colorScheme) {
        ChipColors chipColorsD = colorScheme.d();
        if (chipColorsD != null) {
            return chipColorsD;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
        ChipColors chipColors = new ChipColors(j3, ColorSchemeKt.g(colorScheme, assistChipTokens.w()), ColorSchemeKt.g(colorScheme, assistChipTokens.u()), ColorSchemeKt.g(colorScheme, assistChipTokens.u()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.e()), assistChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.c()), assistChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.c()), assistChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.A0(chipColors);
        return chipColors;
    }

    public final ChipColors h(ColorScheme colorScheme) {
        ChipColors chipColorsJ = colorScheme.j();
        if (chipColorsJ != null) {
            return chipColorsJ;
        }
        AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
        ChipColors chipColors = new ChipColors(ColorSchemeKt.g(colorScheme, assistChipTokens.h()), ColorSchemeKt.g(colorScheme, assistChipTokens.w()), ColorSchemeKt.g(colorScheme, assistChipTokens.u()), ColorSchemeKt.g(colorScheme, assistChipTokens.u()), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.j()), assistChipTokens.l(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.e()), assistChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.c()), assistChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.c()), assistChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.G0(chipColors);
        return chipColors;
    }

    public final float i() {
        return f15895b;
    }

    public final Shape j(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1988153916, i3, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1255)");
        }
        Shape shapeE = ShapesKt.e(AssistChipTokens.f22294a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }
}
