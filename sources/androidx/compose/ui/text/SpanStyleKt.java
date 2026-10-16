package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SpanStyleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f28871a = TextUnitKt.i(14);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f28872b = TextUnitKt.i(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f28873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f28874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TextForegroundStyle f28875e;

    static {
        Color.Companion companion = Color.f25715b;
        f28873c = companion.j();
        long jA = companion.a();
        f28874d = jA;
        f28875e = TextForegroundStyle.f29638a.b(jA);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a A[PHI: r11
      0x003a: PHI (r11v7 long) = 
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v1 long)
      (r11v8 long)
     binds: [B:41:0x00ab, B:53:0x00dd, B:50:0x00d1, B:47:0x00c5, B:44:0x00b9, B:39:0x009d, B:34:0x008e, B:28:0x0076, B:25:0x006e, B:22:0x0062, B:19:0x0056, B:9:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.text.SpanStyle b(androidx.compose.ui.text.SpanStyle r23, long r24, androidx.compose.ui.graphics.Brush r26, float r27, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.text.PlatformSpanStyle r44, androidx.compose.ui.graphics.drawscope.DrawStyle r45) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.b(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }

    public static final SpanStyle c(SpanStyle spanStyle, SpanStyle spanStyle2, float f3) {
        TextForegroundStyle textForegroundStyleB = TextDrawStyleKt.b(spanStyle.t(), spanStyle2.t(), f3);
        FontFamily fontFamily = (FontFamily) d(spanStyle.i(), spanStyle2.i(), f3);
        long jF = f(spanStyle.k(), spanStyle2.k(), f3);
        FontWeight fontWeightN = spanStyle.n();
        if (fontWeightN == null) {
            fontWeightN = FontWeight.f29233b.g();
        }
        FontWeight fontWeightN2 = spanStyle2.n();
        if (fontWeightN2 == null) {
            fontWeightN2 = FontWeight.f29233b.g();
        }
        FontWeight fontWeightA = FontWeightKt.a(fontWeightN, fontWeightN2, f3);
        FontStyle fontStyle = (FontStyle) d(spanStyle.l(), spanStyle2.l(), f3);
        FontSynthesis fontSynthesis = (FontSynthesis) d(spanStyle.m(), spanStyle2.m(), f3);
        String str = (String) d(spanStyle.j(), spanStyle2.j(), f3);
        long jF2 = f(spanStyle.o(), spanStyle2.o(), f3);
        BaselineShift baselineShiftE = spanStyle.e();
        float fJ = baselineShiftE != null ? baselineShiftE.j() : BaselineShift.e(0.0f);
        BaselineShift baselineShiftE2 = spanStyle2.e();
        float fA = BaselineShiftKt.a(fJ, baselineShiftE2 != null ? baselineShiftE2.j() : BaselineShift.e(0.0f), f3);
        TextGeometricTransform textGeometricTransformU = spanStyle.u();
        if (textGeometricTransformU == null) {
            textGeometricTransformU = TextGeometricTransform.f29643c.a();
        }
        TextGeometricTransform textGeometricTransformU2 = spanStyle2.u();
        if (textGeometricTransformU2 == null) {
            textGeometricTransformU2 = TextGeometricTransform.f29643c.a();
        }
        TextGeometricTransform textGeometricTransformA = TextGeometricTransformKt.a(textGeometricTransformU, textGeometricTransformU2, f3);
        LocaleList localeList = (LocaleList) d(spanStyle.p(), spanStyle2.p(), f3);
        long jI = ColorKt.i(spanStyle.d(), spanStyle2.d(), f3);
        TextDecoration textDecoration = (TextDecoration) d(spanStyle.s(), spanStyle2.s(), f3);
        Shadow shadowR = spanStyle.r();
        if (shadowR == null) {
            shadowR = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadowR2 = spanStyle2.r();
        if (shadowR2 == null) {
            shadowR2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleB, jF, fontWeightA, fontStyle, fontSynthesis, fontFamily, str, jF2, BaselineShift.d(fA), textGeometricTransformA, localeList, jI, textDecoration, ShadowKt.a(shadowR, shadowR2, f3), e(spanStyle.q(), spanStyle2.q(), f3), (DrawStyle) d(spanStyle.h(), spanStyle2.h(), f3), (DefaultConstructorMarker) null);
    }

    public static final Object d(Object obj, Object obj2, float f3) {
        return ((double) f3) < 0.5d ? obj : obj2;
    }

    private static final PlatformSpanStyle e(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f3) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.f28769a.a();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.f28769a.a();
        }
        return AndroidTextStyle_androidKt.c(platformSpanStyle, platformSpanStyle2, f3);
    }

    public static final long f(long j3, long j4, float f3) {
        return (TextUnit.f(j3) == 0 || TextUnit.f(j4) == 0) ? ((TextUnit) d(TextUnit.b(j3), TextUnit.b(j4), f3)).m() : TextUnitKt.k(j3, j4, f3);
    }

    private static final PlatformSpanStyle g(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        return spanStyle.q() == null ? platformSpanStyle : platformSpanStyle == null ? spanStyle.q() : spanStyle.q().b(platformSpanStyle);
    }

    public static final SpanStyle h(SpanStyle spanStyle) {
        TextForegroundStyle textForegroundStyleB = spanStyle.t().b(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TextForegroundStyle invoke() {
                return SpanStyleKt.f28875e;
            }
        });
        long jK = TextUnit.f(spanStyle.k()) == 0 ? f28871a : spanStyle.k();
        FontWeight fontWeightN = spanStyle.n();
        if (fontWeightN == null) {
            fontWeightN = FontWeight.f29233b.g();
        }
        FontWeight fontWeight = fontWeightN;
        FontStyle fontStyleL = spanStyle.l();
        FontStyle fontStyleC = FontStyle.c(fontStyleL != null ? fontStyleL.i() : FontStyle.f29211b.b());
        FontSynthesis fontSynthesisM = spanStyle.m();
        FontSynthesis fontSynthesisE = FontSynthesis.e(fontSynthesisM != null ? fontSynthesisM.m() : FontSynthesis.f29215b.a());
        FontFamily fontFamilyI = spanStyle.i();
        if (fontFamilyI == null) {
            fontFamilyI = FontFamily.f29155b.b();
        }
        FontFamily fontFamily = fontFamilyI;
        String strJ = spanStyle.j();
        if (strJ == null) {
            strJ = "";
        }
        String str = strJ;
        long jO = TextUnit.f(spanStyle.o()) == 0 ? f28872b : spanStyle.o();
        BaselineShift baselineShiftE = spanStyle.e();
        BaselineShift baselineShiftD = BaselineShift.d(baselineShiftE != null ? baselineShiftE.j() : BaselineShift.f29554b.a());
        TextGeometricTransform textGeometricTransformU = spanStyle.u();
        if (textGeometricTransformU == null) {
            textGeometricTransformU = TextGeometricTransform.f29643c.a();
        }
        TextGeometricTransform textGeometricTransform = textGeometricTransformU;
        LocaleList localeListP = spanStyle.p();
        if (localeListP == null) {
            localeListP = LocaleList.f29471c.a();
        }
        LocaleList localeList = localeListP;
        long jD = spanStyle.d();
        if (jD == 16) {
            jD = f28873c;
        }
        long j3 = jD;
        TextDecoration textDecorationS = spanStyle.s();
        if (textDecorationS == null) {
            textDecorationS = TextDecoration.f29625b.c();
        }
        TextDecoration textDecoration = textDecorationS;
        Shadow shadowR = spanStyle.r();
        if (shadowR == null) {
            shadowR = Shadow.f25903d.a();
        }
        Shadow shadow = shadowR;
        PlatformSpanStyle platformSpanStyleQ = spanStyle.q();
        DrawStyle drawStyleH = spanStyle.h();
        if (drawStyleH == null) {
            drawStyleH = Fill.f26098a;
        }
        return new SpanStyle(textForegroundStyleB, jK, fontWeight, fontStyleC, fontSynthesisE, fontFamily, str, jO, baselineShiftD, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyleQ, drawStyleH, (DefaultConstructorMarker) null);
    }
}
