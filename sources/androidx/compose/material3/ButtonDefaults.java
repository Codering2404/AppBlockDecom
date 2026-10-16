package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
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
public final class ButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ButtonDefaults f16077a = new ButtonDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f16078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f16079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PaddingValues f16080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f16081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PaddingValues f16082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f16083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PaddingValues f16084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f16085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final PaddingValues f16086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f16087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f16088l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f16089m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f16090n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f16091o = 0;

    static {
        float fG = Dp.g(24);
        f16078b = fG;
        float f3 = 8;
        float fG2 = Dp.g(f3);
        f16079c = fG2;
        PaddingValues paddingValuesD = PaddingKt.d(fG, fG2, fG, fG2);
        f16080d = paddingValuesD;
        float f4 = 16;
        float fG3 = Dp.g(f4);
        f16081e = fG3;
        f16082f = PaddingKt.d(fG3, fG2, fG, fG2);
        float fG4 = Dp.g(12);
        f16083g = fG4;
        f16084h = PaddingKt.d(fG4, paddingValuesD.d(), fG4, paddingValuesD.a());
        float fG5 = Dp.g(f4);
        f16085i = fG5;
        f16086j = PaddingKt.d(fG4, paddingValuesD.d(), fG5, paddingValuesD.a());
        f16087k = Dp.g(58);
        f16088l = Dp.g(40);
        f16089m = FilledButtonTokens.f22676a.i();
        f16090n = Dp.g(f3);
    }

    private ButtonDefaults() {
    }

    public final ButtonColors A(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.k();
        }
        if ((i4 & 2) != 0) {
            j4 = Color.f25715b.k();
        }
        if ((i4 & 4) != 0) {
            j5 = Color.f25715b.k();
        }
        if ((i4 & 8) != 0) {
            j6 = Color.f25715b.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1402274782, i3, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:762)");
        }
        long j7 = j3;
        ButtonColors buttonColorsC = m(MaterialTheme.f18110a.a(composer, 6)).c(j7, j4, j5, j6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsC;
    }

    public final ButtonColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1449248637, i3, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:564)");
        }
        ButtonColors buttonColorsI = i(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsI;
    }

    public final ButtonColors b(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.k();
        }
        if ((i4 & 2) != 0) {
            j4 = Color.f25715b.k();
        }
        if ((i4 & 4) != 0) {
            j5 = Color.f25715b.k();
        }
        if ((i4 & 8) != 0) {
            j6 = Color.f25715b.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-339300779, i3, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:582)");
        }
        long j7 = j3;
        ButtonColors buttonColorsC = i(MaterialTheme.f18110a.a(composer, 6)).c(j7, j4, j5, j6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsC;
    }

    public final ButtonElevation c(float f3, float f4, float f5, float f6, float f7, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FilledButtonTokens.f22676a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = FilledButtonTokens.f22676a.k();
        }
        if ((i4 & 4) != 0) {
            f5 = FilledButtonTokens.f22676a.g();
        }
        if ((i4 & 8) != 0) {
            f6 = FilledButtonTokens.f22676a.h();
        }
        float f8 = f6;
        if ((i4 & 16) != 0) {
            f7 = FilledButtonTokens.f22676a.e();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1827791191, i3, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:802)");
        }
        float f9 = f7;
        float f10 = f5;
        ButtonElevation buttonElevation = new ButtonElevation(f3, f4, f10, f8, f9, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonElevation;
    }

    public final ButtonColors d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2025043443, i3, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:609)");
        }
        ButtonColors buttonColorsJ = j(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsJ;
    }

    public final ButtonElevation e(float f3, float f4, float f5, float f6, float f7, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = ElevatedButtonTokens.f22494a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = ElevatedButtonTokens.f22494a.l();
        }
        if ((i4 & 4) != 0) {
            f5 = ElevatedButtonTokens.f22494a.i();
        }
        if ((i4 & 8) != 0) {
            f6 = ElevatedButtonTokens.f22494a.j();
        }
        float f8 = f6;
        if ((i4 & 16) != 0) {
            f7 = ElevatedButtonTokens.f22494a.e();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1065482445, i3, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:829)");
        }
        float f9 = f7;
        float f10 = f5;
        ButtonElevation buttonElevation = new ButtonElevation(f3, f4, f10, f8, f9, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonElevation;
    }

    public final ButtonColors f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(824987837, i3, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:655)");
        }
        ButtonColors buttonColorsK = k(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsK;
    }

    public final ButtonElevation g(float f3, float f4, float f5, float f6, float f7, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FilledTonalButtonTokens.f22778a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = FilledTonalButtonTokens.f22778a.i();
        }
        if ((i4 & 4) != 0) {
            f5 = FilledTonalButtonTokens.f22778a.f();
        }
        if ((i4 & 8) != 0) {
            f6 = FilledTonalButtonTokens.f22778a.g();
        }
        float f8 = f6;
        if ((i4 & 16) != 0) {
            f7 = Dp.g(0);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(5982871, i3, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:859)");
        }
        float f9 = f7;
        ButtonElevation buttonElevation = new ButtonElevation(f3, f4, f5, f8, f9, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonElevation;
    }

    public final PaddingValues h() {
        return f16080d;
    }

    public final ButtonColors i(ColorScheme colorScheme) {
        ButtonColors buttonColorsE = colorScheme.e();
        if (buttonColorsE != null) {
            return buttonColorsE;
        }
        FilledButtonTokens filledButtonTokens = FilledButtonTokens.f22676a;
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.g(colorScheme, filledButtonTokens.a()), ColorSchemeKt.g(colorScheme, filledButtonTokens.j()), Color.r(ColorSchemeKt.g(colorScheme, filledButtonTokens.d()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledButtonTokens.f()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.B0(buttonColors);
        return buttonColors;
    }

    public final ButtonColors j(ColorScheme colorScheme) {
        ButtonColors buttonColorsK = colorScheme.k();
        if (buttonColorsK != null) {
            return buttonColorsK;
        }
        ElevatedButtonTokens elevatedButtonTokens = ElevatedButtonTokens.f22494a;
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.g(colorScheme, elevatedButtonTokens.a()), ColorSchemeKt.g(colorScheme, elevatedButtonTokens.k()), Color.r(ColorSchemeKt.g(colorScheme, elevatedButtonTokens.d()), elevatedButtonTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, elevatedButtonTokens.g()), elevatedButtonTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.H0(buttonColors);
        return buttonColors;
    }

    public final ButtonColors k(ColorScheme colorScheme) {
        ButtonColors buttonColorsR = colorScheme.r();
        if (buttonColorsR != null) {
            return buttonColorsR;
        }
        FilledTonalButtonTokens filledTonalButtonTokens = FilledTonalButtonTokens.f22778a;
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.g(colorScheme, filledTonalButtonTokens.a()), ColorSchemeKt.g(colorScheme, filledTonalButtonTokens.h()), Color.r(ColorSchemeKt.g(colorScheme, filledTonalButtonTokens.d()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, filledTonalButtonTokens.e()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.O0(buttonColors);
        return buttonColors;
    }

    public final ButtonColors l(ColorScheme colorScheme) {
        ButtonColors buttonColorsD = colorScheme.D();
        if (buttonColorsD != null) {
            return buttonColorsD;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        OutlinedButtonTokens outlinedButtonTokens = OutlinedButtonTokens.f23074a;
        ButtonColors buttonColors = new ButtonColors(j3, ColorSchemeKt.g(colorScheme, outlinedButtonTokens.c()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, outlinedButtonTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.a1(buttonColors);
        return buttonColors;
    }

    public final ButtonColors m(ColorScheme colorScheme) {
        ButtonColors buttonColorsN = colorScheme.N();
        if (buttonColorsN != null) {
            return buttonColorsN;
        }
        Color.Companion companion = Color.f25715b;
        long j3 = companion.j();
        TextButtonTokens textButtonTokens = TextButtonTokens.f23500a;
        ButtonColors buttonColors = new ButtonColors(j3, ColorSchemeKt.g(colorScheme, textButtonTokens.c()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, textButtonTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.l1(buttonColors);
        return buttonColors;
    }

    public final Shape n(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2143958791, i3, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:546)");
        }
        Shape shapeE = ShapesKt.e(ElevatedButtonTokens.f22494a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape o(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-886584987, i3, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:550)");
        }
        Shape shapeE = ShapesKt.e(FilledTonalButtonTokens.f22778a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float p() {
        return f16090n;
    }

    public final float q() {
        return f16088l;
    }

    public final float r() {
        return f16087k;
    }

    public final Shape s(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2045213065, i3, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:554)");
        }
        Shape shapeE = ShapesKt.e(OutlinedButtonTokens.f23074a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape t(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1234923021, i3, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:542)");
        }
        Shape shapeE = ShapesKt.e(FilledButtonTokens.f22676a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final PaddingValues u() {
        return f16084h;
    }

    public final Shape v(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-349121587, i3, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:558)");
        }
        Shape shapeE = ShapesKt.e(TextButtonTokens.f23500a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final BorderStroke w(boolean z2, Composer composer, int i3, int i4) {
        long jR;
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-626854767, i3, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:889)");
        }
        OutlinedButtonTokens outlinedButtonTokens = OutlinedButtonTokens.f23074a;
        float fE = outlinedButtonTokens.e();
        if (z2) {
            composer.a0(-855870548);
            jR = ColorSchemeKt.i(outlinedButtonTokens.d(), composer, 6);
            composer.U();
        } else {
            composer.a0(-855783004);
            jR = Color.r(ColorSchemeKt.i(outlinedButtonTokens.d(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            composer.U();
        }
        BorderStroke borderStrokeA = BorderStrokeKt.a(fE, jR);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return borderStrokeA;
    }

    public final ButtonColors x(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1344886725, i3, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:701)");
        }
        ButtonColors buttonColorsL = l(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsL;
    }

    public final ButtonColors y(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.k();
        }
        if ((i4 & 2) != 0) {
            j4 = Color.f25715b.k();
        }
        if ((i4 & 4) != 0) {
            j5 = Color.f25715b.k();
        }
        if ((i4 & 8) != 0) {
            j6 = Color.f25715b.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1778526249, i3, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:719)");
        }
        long j7 = j3;
        ButtonColors buttonColorsC = l(MaterialTheme.f18110a.a(composer, 6)).c(j7, j4, j5, j6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsC;
    }

    public final ButtonColors z(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1880341584, i3, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:744)");
        }
        ButtonColors buttonColorsM = m(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return buttonColorsM;
    }
}
