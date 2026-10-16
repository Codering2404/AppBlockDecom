package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
public final class CardDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CardDefaults f16178a = new CardDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16179b = 0;

    private CardDefaults() {
    }

    public final CardColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1876034303, i3, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:476)");
        }
        CardColors cardColorsF = f(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardColorsF;
    }

    public final CardColors b(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        long j7;
        long jR;
        long jK = (i4 & 1) != 0 ? Color.f25715b.k() : j3;
        long jC = (i4 & 2) != 0 ? ColorSchemeKt.c(jK, composer, i3 & 14) : j4;
        long jK2 = (i4 & 4) != 0 ? Color.f25715b.k() : j5;
        if ((i4 & 8) != 0) {
            long j8 = jC;
            jR = Color.r(j8, 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jC;
            jR = j6;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1589582123, i3, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:494)");
        }
        CardColors cardColorsC = f(MaterialTheme.f18110a.a(composer, 6)).c(jK, j7, jK2, jR);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardColorsC;
    }

    public final CardElevation c(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FilledCardTokens.f22698a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = FilledCardTokens.f22698a.j();
        }
        if ((i4 & 4) != 0) {
            f5 = FilledCardTokens.f22698a.h();
        }
        if ((i4 & 8) != 0) {
            f6 = FilledCardTokens.f22698a.i();
        }
        if ((i4 & 16) != 0) {
            f7 = FilledCardTokens.f22698a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = FilledCardTokens.f22698a.e();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-574898487, i3, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:405)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        CardElevation cardElevation = new CardElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardElevation;
    }

    public final CardColors d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1610137975, i3, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:522)");
        }
        CardColors cardColorsG = g(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardColorsG;
    }

    public final CardElevation e(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = ElevatedCardTokens.f22520a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = ElevatedCardTokens.f22520a.j();
        }
        if ((i4 & 4) != 0) {
            f5 = ElevatedCardTokens.f22520a.h();
        }
        if ((i4 & 8) != 0) {
            f6 = ElevatedCardTokens.f22520a.i();
        }
        if ((i4 & 16) != 0) {
            f7 = ElevatedCardTokens.f22520a.g();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = ElevatedCardTokens.f22520a.e();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1154241939, i3, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:434)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        CardElevation cardElevation = new CardElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardElevation;
    }

    public final CardColors f(ColorScheme colorScheme) {
        CardColors cardColorsF = colorScheme.f();
        if (cardColorsF != null) {
            return cardColorsF;
        }
        FilledCardTokens filledCardTokens = FilledCardTokens.f22698a;
        CardColors cardColors = new CardColors(ColorSchemeKt.g(colorScheme, filledCardTokens.a()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledCardTokens.a())), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, filledCardTokens.d()), filledCardTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledCardTokens.a())), Color.r(ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, filledCardTokens.a())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.C0(cardColors);
        return cardColors;
    }

    public final CardColors g(ColorScheme colorScheme) {
        CardColors cardColorsL = colorScheme.l();
        if (cardColorsL != null) {
            return cardColorsL;
        }
        ElevatedCardTokens elevatedCardTokens = ElevatedCardTokens.f22520a;
        CardColors cardColors = new CardColors(ColorSchemeKt.g(colorScheme, elevatedCardTokens.a()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, elevatedCardTokens.a())), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, elevatedCardTokens.d()), elevatedCardTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, elevatedCardTokens.d())), Color.r(ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, elevatedCardTokens.a())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.I0(cardColors);
        return cardColors;
    }

    public final CardColors h(ColorScheme colorScheme) {
        CardColors cardColorsE = colorScheme.E();
        if (cardColorsE != null) {
            return cardColorsE;
        }
        OutlinedCardTokens outlinedCardTokens = OutlinedCardTokens.f23095a;
        CardColors cardColors = new CardColors(ColorSchemeKt.g(colorScheme, outlinedCardTokens.a()), ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, outlinedCardTokens.a())), ColorSchemeKt.g(colorScheme, outlinedCardTokens.a()), Color.r(ColorSchemeKt.b(colorScheme, ColorSchemeKt.g(colorScheme, outlinedCardTokens.a())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.b1(cardColors);
        return cardColors;
    }

    public final Shape i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-133496185, i3, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:380)");
        }
        Shape shapeE = ShapesKt.e(ElevatedCardTokens.f22520a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape j(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1095404023, i3, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:384)");
        }
        Shape shapeE = ShapesKt.e(OutlinedCardTokens.f23095a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape k(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1266660211, i3, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:376)");
        }
        Shape shapeE = ShapesKt.e(FilledCardTokens.f22698a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final BorderStroke l(boolean z2, Composer composer, int i3, int i4) {
        long jH;
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-392936593, i3, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:617)");
        }
        if (z2) {
            composer.a0(-134409770);
            jH = ColorSchemeKt.i(OutlinedCardTokens.f23095a.g(), composer, 6);
            composer.U();
        } else {
            composer.a0(-134330379);
            jH = ColorKt.h(Color.r(ColorSchemeKt.i(OutlinedCardTokens.f23095a.e(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.i(ElevatedCardTokens.f22520a.a(), composer, 6));
            composer.U();
        }
        boolean zF = composer.f(jH);
        Object objG = composer.G();
        if (zF || objG == Composer.f23746a.a()) {
            objG = BorderStrokeKt.a(OutlinedCardTokens.f23095a.h(), jH);
            composer.w(objG);
        }
        BorderStroke borderStroke = (BorderStroke) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStroke;
    }

    public final CardColors m(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1204388929, i3, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:571)");
        }
        CardColors cardColorsH = h(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardColorsH;
    }

    public final CardElevation n(float f3, float f4, float f5, float f6, float f7, float f8, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = OutlinedCardTokens.f23095a.b();
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
            f7 = OutlinedCardTokens.f23095a.f();
        }
        float f9 = f7;
        if ((i4 & 32) != 0) {
            f8 = OutlinedCardTokens.f23095a.d();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-97678773, i3, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:463)");
        }
        float f10 = f8;
        float f11 = f5;
        float f12 = f3;
        CardElevation cardElevation = new CardElevation(f12, f4, f11, f6, f9, f10, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cardElevation;
    }
}
