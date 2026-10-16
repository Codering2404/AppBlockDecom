package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
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
public final class TooltipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TooltipDefaults f21443a = new TooltipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21444b = DpKt.b(Dp.g(16), Dp.g(8));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21445c = 0;

    private TooltipDefaults() {
    }

    public final RichTooltipColors a(ColorScheme colorScheme) {
        RichTooltipColors richTooltipColorsI = colorScheme.I();
        if (richTooltipColorsI != null) {
            return richTooltipColorsI;
        }
        RichTooltipTokens richTooltipTokens = RichTooltipTokens.f23298a;
        RichTooltipColors richTooltipColors = new RichTooltipColors(ColorSchemeKt.g(colorScheme, richTooltipTokens.c()), ColorSchemeKt.g(colorScheme, richTooltipTokens.h()), ColorSchemeKt.g(colorScheme, richTooltipTokens.f()), ColorSchemeKt.g(colorScheme, richTooltipTokens.a()), null);
        colorScheme.g1(richTooltipColors);
        return richTooltipColors;
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(102696215, i3, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:244)");
        }
        long jI = ColorSchemeKt.i(PlainTooltipTokens.f23242a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(49570325, i3, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:240)");
        }
        Shape shapeE = ShapesKt.e(PlainTooltipTokens.f23242a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1982928937, i3, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:248)");
        }
        long jI = ColorSchemeKt.i(PlainTooltipTokens.f23242a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Shape e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1138709783, i3, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:252)");
        }
        Shape shapeE = ShapesKt.e(RichTooltipTokens.f23298a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final PopupPositionProvider f(float f3, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = TooltipKt.j();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1047866909, i3, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:302)");
        }
        final int iZ0 = ((Density) composer.q(CompositionLocalsKt.f())).z0(f3);
        boolean zE = composer.e(iZ0);
        Object objG = composer.G();
        if (zE || objG == Composer.f23746a.a()) {
            objG = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberPlainTooltipPositionProvider$1$1
                @Override // androidx.compose.ui.window.PopupPositionProvider
                public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
                    int iG = intRect.g() + ((intRect.l() - IntSize.g(j4)) / 2);
                    int iJ = (intRect.j() - IntSize.f(j4)) - iZ0;
                    if (iJ < 0) {
                        iJ = iZ0 + intRect.d();
                    }
                    return IntOffsetKt.a(iG, iJ);
                }
            };
            composer.w(objG);
        }
        TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 tooltipDefaults$rememberPlainTooltipPositionProvider$1$1 = (TooltipDefaults$rememberPlainTooltipPositionProvider$1$1) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return tooltipDefaults$rememberPlainTooltipPositionProvider$1$1;
    }

    public final PopupPositionProvider g(float f3, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = TooltipKt.j();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1538806795, i3, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:335)");
        }
        final int iZ0 = ((Density) composer.q(CompositionLocalsKt.f())).z0(f3);
        boolean zE = composer.e(iZ0);
        Object objG = composer.G();
        if (zE || objG == Composer.f23746a.a()) {
            objG = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberRichTooltipPositionProvider$1$1
                @Override // androidx.compose.ui.window.PopupPositionProvider
                public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
                    int iG = intRect.g();
                    if (IntSize.g(j4) + iG > IntSize.g(j3) && (iG = intRect.h() - IntSize.g(j4)) < 0) {
                        iG = intRect.g() + ((intRect.l() - IntSize.g(j4)) / 2);
                    }
                    int iJ = (intRect.j() - IntSize.f(j4)) - iZ0;
                    if (iJ < 0) {
                        iJ = iZ0 + intRect.d();
                    }
                    return IntOffsetKt.a(iG, iJ);
                }
            };
            composer.w(objG);
        }
        TooltipDefaults$rememberRichTooltipPositionProvider$1$1 tooltipDefaults$rememberRichTooltipPositionProvider$1$1 = (TooltipDefaults$rememberRichTooltipPositionProvider$1$1) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return tooltipDefaults$rememberRichTooltipPositionProvider$1$1;
    }

    public final RichTooltipColors h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1622312141, i3, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:261)");
        }
        RichTooltipColors richTooltipColorsA = a(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return richTooltipColorsA;
    }
}
