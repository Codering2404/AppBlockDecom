package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
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
public final class IconButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IconButtonDefaults f17866a = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final IconButtonColors a(ColorScheme colorScheme, long j3) {
        IconButtonColors iconButtonColorsV = colorScheme.v();
        if (iconButtonColorsV != null) {
            return iconButtonColorsV;
        }
        Color.Companion companion = Color.f25715b;
        IconButtonColors iconButtonColors = new IconButtonColors(companion.j(), j3, companion.j(), Color.r(j3, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.S0(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors b(ColorScheme colorScheme, long j3) {
        IconToggleButtonColors iconToggleButtonColorsW = colorScheme.w();
        if (iconToggleButtonColorsW != null) {
            return iconToggleButtonColorsW;
        }
        Color.Companion companion = Color.f25715b;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(companion.j(), j3, companion.j(), Color.r(j3, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), companion.j(), ColorSchemeKt.g(colorScheme, IconButtonTokens.f22867a.b()), null);
        colorScheme.T0(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors c(ColorScheme colorScheme, long j3) {
        IconButtonColors iconButtonColorsF = colorScheme.F();
        if (iconButtonColorsF != null) {
            return iconButtonColorsF;
        }
        Color.Companion companion = Color.f25715b;
        IconButtonColors iconButtonColors = new IconButtonColors(companion.j(), j3, companion.j(), Color.r(j3, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.c1(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors d(ColorScheme colorScheme, long j3) {
        IconToggleButtonColors iconToggleButtonColorsW = colorScheme.w();
        if (iconToggleButtonColorsW != null) {
            return iconToggleButtonColorsW;
        }
        Color.Companion companion = Color.f25715b;
        long j4 = companion.j();
        long j5 = companion.j();
        long jR = Color.r(j3, 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
        OutlinedIconButtonTokens outlinedIconButtonTokens = OutlinedIconButtonTokens.f23113a;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(j4, j3, j5, jR, ColorSchemeKt.g(colorScheme, outlinedIconButtonTokens.c()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, outlinedIconButtonTokens.c())), null);
        colorScheme.d1(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1857395287, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:719)");
        }
        IconButtonColors iconButtonColorsI = i(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iconButtonColorsI;
    }

    public final IconToggleButtonColors f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1554706367, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:766)");
        }
        IconToggleButtonColors iconToggleButtonColorsJ = j(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iconToggleButtonColorsJ;
    }

    public final IconButtonColors g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1099140437, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:830)");
        }
        IconButtonColors iconButtonColorsK = k(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iconButtonColorsK;
    }

    public final IconToggleButtonColors h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(434219587, i3, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:878)");
        }
        IconToggleButtonColors iconToggleButtonColorsL = l(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iconToggleButtonColorsL;
    }

    public final IconButtonColors i(ColorScheme colorScheme) {
        IconButtonColors iconButtonColorsP = colorScheme.p();
        if (iconButtonColorsP != null) {
            return iconButtonColorsP;
        }
        FilledIconButtonTokens filledIconButtonTokens = FilledIconButtonTokens.f22712a;
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.a()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledIconButtonTokens.a())), Color.r(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.f()), filledIconButtonTokens.g(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.e()), filledIconButtonTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.M0(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors j(ColorScheme colorScheme) {
        IconToggleButtonColors iconToggleButtonColorsQ = colorScheme.q();
        if (iconToggleButtonColorsQ != null) {
            return iconToggleButtonColorsQ;
        }
        FilledIconButtonTokens filledIconButtonTokens = FilledIconButtonTokens.f22712a;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.k()), ColorSchemeKt.g(colorScheme, filledIconButtonTokens.j()), Color.r(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.f()), filledIconButtonTokens.g(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledIconButtonTokens.e()), filledIconButtonTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledIconButtonTokens.i()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledIconButtonTokens.i())), null);
        colorScheme.N0(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors k(ColorScheme colorScheme) {
        IconButtonColors iconButtonColorsS = colorScheme.s();
        if (iconButtonColorsS != null) {
            return iconButtonColorsS;
        }
        FilledTonalIconButtonTokens filledTonalIconButtonTokens = FilledTonalIconButtonTokens.f22800a;
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.a()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.a())), Color.r(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.e()), filledTonalIconButtonTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.d()), filledTonalIconButtonTokens.g(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.P0(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors l(ColorScheme colorScheme) {
        IconToggleButtonColors iconToggleButtonColorsT = colorScheme.t();
        if (iconToggleButtonColorsT != null) {
            return iconToggleButtonColorsT;
        }
        FilledTonalIconButtonTokens filledTonalIconButtonTokens = FilledTonalIconButtonTokens.f22800a;
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.j()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.j())), Color.r(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.e()), filledTonalIconButtonTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.d()), filledTonalIconButtonTokens.g(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.h()), ColorSchemeKt.g(colorScheme, filledTonalIconButtonTokens.i()), null);
        colorScheme.Q0(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final Shape m(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1265841879, i3, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:584)");
        }
        Shape shapeE = ShapesKt.e(FilledIconButtonTokens.f22712a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape n(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1327125527, i3, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:588)");
        }
        Shape shapeE = ShapesKt.e(OutlinedIconButtonTokens.f23113a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final IconButtonColors o(Composer composer, int i3) {
        composer.a0(-1519621781);
        if (ComposerKt.M()) {
            ComposerKt.U(-1519621781, i3, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        }
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        IconButtonColors iconButtonColorsA = a(MaterialTheme.f18110a.a(composer, 6), jB);
        if (Color.t(iconButtonColorsA.e(), jB)) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return iconButtonColorsA;
        }
        IconButtonColors iconButtonColorsD = IconButtonColors.d(iconButtonColorsA, 0L, jB, 0L, Color.r(jB, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconButtonColorsD;
    }

    public final IconToggleButtonColors p(Composer composer, int i3) {
        composer.a0(-589987581);
        if (ComposerKt.M()) {
            ComposerKt.U(-589987581, i3, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:650)");
        }
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        IconToggleButtonColors iconToggleButtonColorsB = b(MaterialTheme.f18110a.a(composer, 6), jB);
        if (Color.t(iconToggleButtonColorsB.e(), jB)) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return iconToggleButtonColorsB;
        }
        IconToggleButtonColors iconToggleButtonColorsD = IconToggleButtonColors.d(iconToggleButtonColorsB, 0L, jB, 0L, Color.r(jB, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconToggleButtonColorsD;
    }

    public final BorderStroke q(boolean z2, Composer composer, int i3) {
        long jR;
        if (ComposerKt.M()) {
            ComposerKt.U(-511461558, i3, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:1091)");
        }
        if (z2) {
            composer.a0(1186104514);
            jR = ((Color) composer.q(ContentColorKt.a())).B();
            composer.U();
        } else {
            composer.a0(1186170420);
            jR = Color.r(((Color) composer.q(ContentColorKt.a())).B(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            composer.U();
        }
        boolean zF = composer.f(jR);
        Object objG = composer.G();
        if (zF || objG == Composer.f23746a.a()) {
            objG = BorderStrokeKt.a(OutlinedIconButtonTokens.f23113a.d(), jR);
            composer.w(objG);
        }
        BorderStroke borderStroke = (BorderStroke) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStroke;
    }

    public final IconButtonColors r(Composer composer, int i3) {
        composer.a0(389287465);
        if (ComposerKt.M()) {
            ComposerKt.U(389287465, i3, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:938)");
        }
        IconButtonColors iconButtonColorsC = c(MaterialTheme.f18110a.a(composer, 6), ((Color) composer.q(ContentColorKt.a())).B());
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        if (Color.t(iconButtonColorsC.e(), jB)) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return iconButtonColorsC;
        }
        IconButtonColors iconButtonColorsD = IconButtonColors.d(iconButtonColorsC, 0L, jB, 0L, Color.r(jB, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconButtonColorsD;
    }

    public final BorderStroke s(boolean z2, boolean z3, Composer composer, int i3) {
        composer.a0(1244729690);
        if (ComposerKt.M()) {
            ComposerKt.U(1244729690, i3, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:1078)");
        }
        if (z3) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return null;
        }
        BorderStroke borderStrokeQ = q(z2, composer, (i3 & 14) | ((i3 >> 3) & 112));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return borderStrokeQ;
    }

    public final IconToggleButtonColors t(Composer composer, int i3) {
        composer.a0(-779749183);
        if (ComposerKt.M()) {
            ComposerKt.U(-779749183, i3, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:1000)");
        }
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        IconToggleButtonColors iconToggleButtonColorsD = d(MaterialTheme.f18110a.a(composer, 6), jB);
        if (Color.t(iconToggleButtonColorsD.e(), jB)) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return iconToggleButtonColorsD;
        }
        IconToggleButtonColors iconToggleButtonColorsD2 = IconToggleButtonColors.d(iconToggleButtonColorsD, 0L, jB, 0L, Color.r(jB, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconToggleButtonColorsD2;
    }
}
