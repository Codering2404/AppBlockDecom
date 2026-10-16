package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
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
public final class FilterChipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FilterChipDefaults f17756a = new FilterChipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f17757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17758c;

    static {
        FilterChipTokens filterChipTokens = FilterChipTokens.f22825a;
        f17757b = filterChipTokens.a();
        f17758c = filterChipTokens.C();
    }

    private FilterChipDefaults() {
    }

    public final SelectableChipColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1082953289, i3, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1430)");
        }
        SelectableChipColors selectableChipColorsF = f(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return selectableChipColorsF;
    }

    public final SelectableChipElevation b(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FilterChipTokens.f22825a.h();
        }
        if ((i4 & 2) != 0) {
            f4 = FilterChipTokens.f22825a.n();
        }
        if ((i4 & 4) != 0) {
            f5 = FilterChipTokens.f22825a.l();
        }
        if ((i4 & 8) != 0) {
            f6 = FilterChipTokens.f22825a.m();
        }
        if ((i4 & 16) != 0) {
            f7 = FilterChipTokens.f22825a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = FilterChipTokens.f22825a.j();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(684803697, i3, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1536)");
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

    public final BorderStroke c(boolean z2, boolean z3, long j3, long j4, long j5, long j6, float f3, float f4, Composer composer, int i3, int i4) {
        long jR;
        long jI = (i4 & 4) != 0 ? ColorSchemeKt.i(FilterChipTokens.f22825a.A(), composer, 6) : j3;
        long j7 = (i4 & 8) != 0 ? Color.f25715b.j() : j4;
        if ((i4 & 16) != 0) {
            FilterChipTokens filterChipTokens = FilterChipTokens.f22825a;
            jR = Color.r(ColorSchemeKt.i(filterChipTokens.t(), composer, 6), filterChipTokens.u(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j5;
        }
        long j8 = (i4 & 32) != 0 ? Color.f25715b.j() : j6;
        float fB = (i4 & 64) != 0 ? FilterChipTokens.f22825a.B() : f3;
        float fY = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? FilterChipTokens.f22825a.y() : f4;
        if (ComposerKt.M()) {
            ComposerKt.U(-1138342447, i3, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1415)");
        }
        if (!z2) {
            jI = z3 ? j8 : jR;
        } else if (z3) {
            jI = j7;
        }
        if (z3) {
            fB = fY;
        }
        BorderStroke borderStrokeA = BorderStrokeKt.a(fB, jI);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStrokeA;
    }

    public final SelectableChipColors d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1743772077, i3, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1273)");
        }
        SelectableChipColors selectableChipColorsG = g(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return selectableChipColorsG;
    }

    public final SelectableChipElevation e(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FilterChipTokens.f22825a.q();
        }
        if ((i4 & 2) != 0) {
            f4 = FilterChipTokens.f22825a.z();
        }
        if ((i4 & 4) != 0) {
            f5 = FilterChipTokens.f22825a.w();
        }
        if ((i4 & 8) != 0) {
            f6 = FilterChipTokens.f22825a.x();
        }
        if ((i4 & 16) != 0) {
            f7 = FilterChipTokens.f22825a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = f3;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-757972185, i3, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1378)");
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

    public final SelectableChipColors f(ColorScheme colorScheme) {
        SelectableChipColors selectableChipColorsM = colorScheme.m();
        if (selectableChipColorsM != null) {
            return selectableChipColorsM;
        }
        FilterChipTokens filterChipTokens = FilterChipTokens.f22825a;
        SelectableChipColors selectableChipColors = new SelectableChipColors(ColorSchemeKt.g(colorScheme, filterChipTokens.p()), ColorSchemeKt.g(colorScheme, filterChipTokens.G()), ColorSchemeKt.g(colorScheme, filterChipTokens.H()), ColorSchemeKt.g(colorScheme, filterChipTokens.H()), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.i()), filterChipTokens.k(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.c()), filterChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.e()), filterChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.e()), filterChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filterChipTokens.o()), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.i()), filterChipTokens.k(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filterChipTokens.E()), ColorSchemeKt.g(colorScheme, filterChipTokens.F()), ColorSchemeKt.g(colorScheme, filterChipTokens.F()), null);
        colorScheme.J0(selectableChipColors);
        return selectableChipColors;
    }

    public final SelectableChipColors g(ColorScheme colorScheme) {
        SelectableChipColors selectableChipColorsU = colorScheme.u();
        if (selectableChipColorsU != null) {
            return selectableChipColorsU;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        FilterChipTokens filterChipTokens = FilterChipTokens.f22825a;
        SelectableChipColors selectableChipColors = new SelectableChipColors(j3, ColorSchemeKt.g(colorScheme, filterChipTokens.G()), ColorSchemeKt.g(colorScheme, filterChipTokens.H()), ColorSchemeKt.g(colorScheme, filterChipTokens.H()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.c()), filterChipTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.e()), filterChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.e()), filterChipTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filterChipTokens.v()), Color.r(ColorSchemeKt.g(colorScheme, filterChipTokens.r()), filterChipTokens.s(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filterChipTokens.E()), ColorSchemeKt.g(colorScheme, filterChipTokens.F()), ColorSchemeKt.g(colorScheme, filterChipTokens.F()), null);
        colorScheme.R0(selectableChipColors);
        return selectableChipColors;
    }

    public final float h() {
        return f17757b;
    }

    public final Shape i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1598643637, i3, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1547)");
        }
        Shape shapeE = ShapesKt.e(FilterChipTokens.f22825a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }
}
