package cz.mobilesoft.coreblock.util.compose;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeTypographyKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FontFamily f128225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final FontFamily f128226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TextStyle f128227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TextStyle f128228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lazy f128229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f128230f;

    static {
        Font fontB = FontKt.b(R.font.f95586c, null, 0, 0, 14, null);
        int i3 = R.font.f95585b;
        FontWeight.Companion companion = FontWeight.f29233b;
        FontFamily fontFamilyC = FontFamilyKt.c(fontB, FontKt.b(i3, companion.l(), 0, 0, 12, null));
        f128225a = fontFamilyC;
        f128226b = FontFamilyKt.c(FontKt.b(R.font.f95588e, null, 0, 0, 14, null));
        f128227c = new TextStyle(0L, 0L, companion.b(), (FontStyle) null, (FontSynthesis) null, fontFamilyC, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777179, (DefaultConstructorMarker) null);
        f128228d = new TextStyle(0L, 0L, companion.g(), (FontStyle) null, (FontSynthesis) null, fontFamilyC, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777179, (DefaultConstructorMarker) null);
        f128229e = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ComposeTypographyKt.k();
            }
        });
        f128230f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ComposeTypographyKt.j();
            }
        });
    }

    private static final Typography c(AppBlockColorPalette appBlockColorPalette) {
        TextStyle textStyle = f128227c;
        long jI = TextUnitKt.i(34);
        long jI2 = TextUnitKt.i(41);
        long jL = appBlockColorPalette.L();
        FontWeight.Companion companion = FontWeight.f29233b;
        TextStyle textStyleE = TextStyle.e(textStyle, jL, jI, companion.c(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, jI2, null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE2 = TextStyle.e(textStyle, appBlockColorPalette.L(), TextUnitKt.i(28), companion.c(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(33), null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE3 = TextStyle.e(textStyle, appBlockColorPalette.L(), TextUnitKt.i(20), companion.c(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE4 = TextStyle.e(textStyle, appBlockColorPalette.L(), TextUnitKt.i(17), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(22), null, null, null, 0, 0, null, 16646140, null);
        FontWeight fontWeightH = companion.h();
        TextStyle textStyleE5 = TextStyle.e(textStyle, appBlockColorPalette.L(), TextUnitKt.i(15), fontWeightH, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(20), null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE6 = TextStyle.e(textStyle, appBlockColorPalette.L(), TextUnitKt.i(13), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(18), null, null, null, 0, 0, null, 16646140, null);
        TextStyle textStyle2 = f128228d;
        TextStyle textStyleE7 = TextStyle.e(textStyle2, appBlockColorPalette.L(), TextUnitKt.i(17), companion.f(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(22), null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE8 = TextStyle.e(textStyle2, appBlockColorPalette.L(), TextUnitKt.i(15), companion.f(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(20), null, null, null, 0, 0, null, 16646136, null);
        TextStyle textStyleE9 = TextStyle.e(textStyle2, appBlockColorPalette.L(), TextUnitKt.i(13), companion.f(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(18), null, null, null, 0, 0, null, 16646136, null);
        long jI3 = TextUnitKt.i(17);
        long jI4 = TextUnitKt.i(22);
        return new Typography(null, textStyleE, textStyleE2, textStyleE3, textStyleE4, textStyleE5, textStyleE6, null, null, textStyleE7, textStyleE8, TextStyle.e(textStyle2, appBlockColorPalette.L(), jI3, companion.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, jI4, null, null, null, 0, 0, null, 16646136, null), textStyleE9, null, 8577, null);
    }

    public static final FontFamily d() {
        return f128225a;
    }

    public static final Brush e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1367280433, i3, -1, "cz.mobilesoft.coreblock.util.compose.<get-gradientBrush> (ComposeTypography.kt:117)");
        }
        Brush brushM = Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ComposeColorsKt.j(composer, 0).b()), Color.n(ComposeColorsKt.j(composer, 0).d())}), 0.0f, 0.0f, 0, 14, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return brushM;
    }

    public static final FontFamily f() {
        return f128226b;
    }

    public static final Typography g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1743625938, i3, -1, "cz.mobilesoft.coreblock.util.compose.<get-typography> (ComposeTypography.kt:113)");
        }
        Typography typographyH = DarkThemeKt.a(composer, 0) ? h() : i();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return typographyH;
    }

    private static final Typography h() {
        return (Typography) f128230f.getValue();
    }

    private static final Typography i() {
        return (Typography) f128229e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typography j() {
        return c(ComposeColorsKt.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typography k() {
        return c(ComposeColorsKt.f());
    }
}
