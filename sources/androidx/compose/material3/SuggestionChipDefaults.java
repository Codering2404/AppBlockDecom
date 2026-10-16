package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
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
public final class SuggestionChipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SuggestionChipDefaults f20346a = new SuggestionChipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f20347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f20348c;

    static {
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.f23441a;
        f20347b = suggestionChipTokens.a();
        f20348c = suggestionChipTokens.w();
    }

    private SuggestionChipDefaults() {
    }

    public final ChipColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1671233087, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1857)");
        }
        ChipColors chipColorsC = c(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipColorsC;
    }

    public final ChipElevation b(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = SuggestionChipTokens.f23441a.i();
        }
        if ((i4 & 2) != 0) {
            f4 = SuggestionChipTokens.f23441a.n();
        }
        if ((i4 & 4) != 0) {
            f5 = SuggestionChipTokens.f23441a.l();
        }
        if ((i4 & 8) != 0) {
            f6 = SuggestionChipTokens.f23441a.m();
        }
        if ((i4 & 16) != 0) {
            f7 = SuggestionChipTokens.f23441a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = SuggestionChipTokens.f23441a.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1118088467, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1932)");
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

    public final ChipColors c(ColorScheme colorScheme) {
        ChipColors chipColorsN = colorScheme.n();
        if (chipColorsN != null) {
            return chipColorsN;
        }
        SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.f23441a;
        long jG = ColorSchemeKt.g(colorScheme, suggestionChipTokens.h());
        long jG2 = ColorSchemeKt.g(colorScheme, suggestionChipTokens.t());
        long jG3 = ColorSchemeKt.g(colorScheme, suggestionChipTokens.v());
        Color.Companion companion = Color.f25715b;
        long jK = companion.k();
        long jG4 = ColorSchemeKt.g(colorScheme, suggestionChipTokens.j());
        AssistChipTokens assistChipTokens = AssistChipTokens.f22294a;
        ChipColors chipColors = new ChipColors(jG, jG2, jG3, jK, Color.r(jG4, assistChipTokens.l(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, suggestionChipTokens.c()), suggestionChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, assistChipTokens.c()), assistChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), companion.k(), null);
        colorScheme.K0(chipColors);
        return chipColors;
    }

    public final float d() {
        return f20347b;
    }

    public final Shape e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(641188183, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1943)");
        }
        Shape shapeE = ShapesKt.e(SuggestionChipTokens.f23441a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final ChipBorder f(long j3, long j4, float f3, Composer composer, int i3, int i4) {
        long jR;
        long jI = (i4 & 1) != 0 ? ColorSchemeKt.i(SuggestionChipTokens.f23441a.r(), composer, 6) : j3;
        if ((i4 & 2) != 0) {
            SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.f23441a;
            jR = Color.r(ColorSchemeKt.i(suggestionChipTokens.p(), composer, 6), suggestionChipTokens.q(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j4;
        }
        float fS = (i4 & 4) != 0 ? SuggestionChipTokens.f23441a.s() : f3;
        if (ComposerKt.M()) {
            ComposerKt.U(439283919, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1845)");
        }
        ChipBorder chipBorder = new ChipBorder(jI, jR, fS, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipBorder;
    }

    public final BorderStroke g(boolean z2, long j3, long j4, float f3, Composer composer, int i3, int i4) {
        long jR;
        long jI = (i4 & 2) != 0 ? ColorSchemeKt.i(SuggestionChipTokens.f23441a.r(), composer, 6) : j3;
        if ((i4 & 4) != 0) {
            SuggestionChipTokens suggestionChipTokens = SuggestionChipTokens.f23441a;
            jR = Color.r(ColorSchemeKt.i(suggestionChipTokens.p(), composer, 6), suggestionChipTokens.q(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j4;
        }
        float fS = (i4 & 8) != 0 ? SuggestionChipTokens.f23441a.s() : f3;
        if (ComposerKt.M()) {
            ComposerKt.U(-637354809, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1818)");
        }
        if (!z2) {
            jI = jR;
        }
        BorderStroke borderStrokeA = BorderStrokeKt.a(fS, jI);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStrokeA;
    }

    public final ChipColors h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1918570697, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1739)");
        }
        ChipColors chipColorsS = ChipKt.s(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipColorsS;
    }

    public final ChipElevation i(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = SuggestionChipTokens.f23441a.o();
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
            f7 = SuggestionChipTokens.f23441a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = f3;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1929994057, i3, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1792)");
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
}
