package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextStyle {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f28924d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TextStyle f28925e = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777215, (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SpanStyle f28926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParagraphStyle f28927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlatformTextStyle f28928c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextStyle a() {
            return TextStyle.f28925e;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, drawStyle, i3, i4, j7, textIndent, platformTextStyle, lineHeightStyle, i5, i6, textMotion);
    }

    public static /* synthetic */ TextStyle c(TextStyle textStyle, Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, Object obj) {
        TextMotion textMotionK;
        int i8;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i9;
        int i10;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j7;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j8;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j9;
        long j10;
        Brush brush2;
        float f4;
        int i11;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float fC = (i7 & 2) != 0 ? textStyle.f28926a.c() : f3;
        long jK = (i7 & 4) != 0 ? textStyle.f28926a.k() : j3;
        FontWeight fontWeightN = (i7 & 8) != 0 ? textStyle.f28926a.n() : fontWeight;
        FontStyle fontStyleL = (i7 & 16) != 0 ? textStyle.f28926a.l() : fontStyle;
        FontSynthesis fontSynthesisM = (i7 & 32) != 0 ? textStyle.f28926a.m() : fontSynthesis;
        FontFamily fontFamilyI = (i7 & 64) != 0 ? textStyle.f28926a.i() : fontFamily;
        String strJ = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? textStyle.f28926a.j() : str;
        long jO = (i7 & Function.MAX_NARGS) != 0 ? textStyle.f28926a.o() : j4;
        BaselineShift baselineShiftE = (i7 & 512) != 0 ? textStyle.f28926a.e() : baselineShift;
        TextGeometricTransform textGeometricTransformU = (i7 & 1024) != 0 ? textStyle.f28926a.u() : textGeometricTransform;
        LocaleList localeListP = (i7 & 2048) != 0 ? textStyle.f28926a.p() : localeList;
        long jD = (i7 & 4096) != 0 ? textStyle.f28926a.d() : j5;
        float f5 = fC;
        TextDecoration textDecorationS = (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? textStyle.f28926a.s() : textDecoration;
        Shadow shadowR = (i7 & 16384) != 0 ? textStyle.f28926a.r() : shadow;
        DrawStyle drawStyleH = (i7 & 32768) != 0 ? textStyle.f28926a.h() : drawStyle;
        int iH = (i7 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? textStyle.f28927b.h() : i3;
        int i12 = (i7 & 131072) != 0 ? textStyle.f28927b.i() : i4;
        long jE = (i7 & 262144) != 0 ? textStyle.f28927b.e() : j6;
        TextIndent textIndentJ = (i7 & 524288) != 0 ? textStyle.f28927b.j() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i7 & 1048576) != 0 ? textStyle.f28928c : platformTextStyle;
        LineHeightStyle lineHeightStyleF = (i7 & 2097152) != 0 ? textStyle.f28927b.f() : lineHeightStyle;
        int iD = (i7 & 4194304) != 0 ? textStyle.f28927b.d() : i5;
        int iC = (i7 & 8388608) != 0 ? textStyle.f28927b.c() : i6;
        if ((i7 & 16777216) != 0) {
            i8 = iC;
            textMotionK = textStyle.f28927b.k();
            textDecoration2 = textDecorationS;
            drawStyle2 = drawStyleH;
            i9 = iH;
            i10 = i12;
            textIndent2 = textIndentJ;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyleF;
            i11 = iD;
            shadow2 = shadowR;
            j7 = jK;
            fontWeight2 = fontWeightN;
            fontStyle2 = fontStyleL;
            fontSynthesis2 = fontSynthesisM;
            fontFamily2 = fontFamilyI;
            str2 = strJ;
            j8 = jO;
            baselineShift2 = baselineShiftE;
            textGeometricTransform2 = textGeometricTransformU;
            localeList2 = localeListP;
            j9 = jD;
            j10 = jE;
            brush2 = brush;
            f4 = f5;
            textStyle2 = textStyle;
        } else {
            textMotionK = textMotion;
            i8 = iC;
            textDecoration2 = textDecorationS;
            drawStyle2 = drawStyleH;
            i9 = iH;
            i10 = i12;
            textIndent2 = textIndentJ;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyleF;
            shadow2 = shadowR;
            j7 = jK;
            fontWeight2 = fontWeightN;
            fontStyle2 = fontStyleL;
            fontSynthesis2 = fontSynthesisM;
            str2 = strJ;
            j8 = jO;
            baselineShift2 = baselineShiftE;
            textGeometricTransform2 = textGeometricTransformU;
            localeList2 = localeListP;
            j9 = jD;
            j10 = jE;
            brush2 = brush;
            f4 = f5;
            i11 = iD;
            textStyle2 = textStyle;
            fontFamily2 = fontFamilyI;
        }
        return textStyle2.b(brush2, f4, j7, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j8, baselineShift2, textGeometricTransform2, localeList2, j9, textDecoration2, shadow2, drawStyle2, i9, i10, j10, textIndent2, platformTextStyle2, lineHeightStyle2, i11, i8, textMotionK);
    }

    public static /* synthetic */ TextStyle e(TextStyle textStyle, long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, Object obj) {
        TextMotion textMotionK;
        int i8;
        long jG = (i7 & 1) != 0 ? textStyle.f28926a.g() : j3;
        long jK = (i7 & 2) != 0 ? textStyle.f28926a.k() : j4;
        FontWeight fontWeightN = (i7 & 4) != 0 ? textStyle.f28926a.n() : fontWeight;
        FontStyle fontStyleL = (i7 & 8) != 0 ? textStyle.f28926a.l() : fontStyle;
        FontSynthesis fontSynthesisM = (i7 & 16) != 0 ? textStyle.f28926a.m() : fontSynthesis;
        FontFamily fontFamilyI = (i7 & 32) != 0 ? textStyle.f28926a.i() : fontFamily;
        String strJ = (i7 & 64) != 0 ? textStyle.f28926a.j() : str;
        long jO = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? textStyle.f28926a.o() : j5;
        BaselineShift baselineShiftE = (i7 & Function.MAX_NARGS) != 0 ? textStyle.f28926a.e() : baselineShift;
        TextGeometricTransform textGeometricTransformU = (i7 & 512) != 0 ? textStyle.f28926a.u() : textGeometricTransform;
        LocaleList localeListP = (i7 & 1024) != 0 ? textStyle.f28926a.p() : localeList;
        long j8 = jG;
        long jD = (i7 & 2048) != 0 ? textStyle.f28926a.d() : j6;
        TextDecoration textDecorationS = (i7 & 4096) != 0 ? textStyle.f28926a.s() : textDecoration;
        Shadow shadowR = (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? textStyle.f28926a.r() : shadow;
        TextDecoration textDecoration2 = textDecorationS;
        DrawStyle drawStyleH = (i7 & 16384) != 0 ? textStyle.f28926a.h() : drawStyle;
        int iH = (i7 & 32768) != 0 ? textStyle.f28927b.h() : i3;
        int i9 = (i7 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? textStyle.f28927b.i() : i4;
        long jE = (i7 & 131072) != 0 ? textStyle.f28927b.e() : j7;
        TextIndent textIndentJ = (i7 & 262144) != 0 ? textStyle.f28927b.j() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i7 & 524288) != 0 ? textStyle.f28928c : platformTextStyle;
        LineHeightStyle lineHeightStyleF = (i7 & 1048576) != 0 ? textStyle.f28927b.f() : lineHeightStyle;
        int iD = (i7 & 2097152) != 0 ? textStyle.f28927b.d() : i5;
        int iC = (i7 & 4194304) != 0 ? textStyle.f28927b.c() : i6;
        if ((i7 & 8388608) != 0) {
            i8 = iC;
            textMotionK = textStyle.f28927b.k();
        } else {
            textMotionK = textMotion;
            i8 = iC;
        }
        return textStyle.d(j8, jK, fontWeightN, fontStyleL, fontSynthesisM, fontFamilyI, strJ, jO, baselineShiftE, textGeometricTransformU, localeListP, jD, textDecoration2, shadowR, drawStyleH, iH, i9, jE, textIndentJ, platformTextStyle2, lineHeightStyleF, iD, i8, textMotionK);
    }

    public final SpanStyle A() {
        return this.f28926a;
    }

    public final int B() {
        return this.f28927b.h();
    }

    public final TextDecoration C() {
        return this.f28926a.s();
    }

    public final int D() {
        return this.f28927b.i();
    }

    public final TextGeometricTransform E() {
        return this.f28926a.u();
    }

    public final TextIndent F() {
        return this.f28927b.j();
    }

    public final TextMotion G() {
        return this.f28927b.k();
    }

    public final boolean H(TextStyle textStyle) {
        return this == textStyle || this.f28926a.w(textStyle.f28926a);
    }

    public final boolean I(TextStyle textStyle) {
        if (this != textStyle) {
            return Intrinsics.areEqual(this.f28927b, textStyle.f28927b) && this.f28926a.v(textStyle.f28926a);
        }
        return true;
    }

    public final int J() {
        int iX = ((this.f28926a.x() * 31) + this.f28927b.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.f28928c;
        return iX + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final TextStyle K(ParagraphStyle paragraphStyle) {
        return new TextStyle(P(), O().l(paragraphStyle));
    }

    public final TextStyle L(TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual(textStyle, f28925e)) ? this : new TextStyle(P().y(textStyle.P()), O().l(textStyle.O()));
    }

    public final TextStyle M(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i5, int i6, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        SpanStyle spanStyleB = SpanStyleKt.b(this.f28926a, j3, null, Float.NaN, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.b() : null, drawStyle);
        ParagraphStyle paragraphStyleA = ParagraphStyleKt.a(this.f28927b, i3, i4, j7, textIndent, platformTextStyle != null ? platformTextStyle.a() : null, lineHeightStyle, i5, i6, textMotion);
        return (this.f28926a == spanStyleB && this.f28927b == paragraphStyleA) ? this : new TextStyle(spanStyleB, paragraphStyleA);
    }

    public final ParagraphStyle O() {
        return this.f28927b;
    }

    public final SpanStyle P() {
        return this.f28926a;
    }

    public final TextStyle b(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, f3, j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.b() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i3, i4, j6, textIndent, platformTextStyle != null ? platformTextStyle.a() : null, lineHeightStyle, i5, i6, textMotion, null), platformTextStyle);
    }

    public final TextStyle d(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.t(j3, this.f28926a.g()) ? this.f28926a.t() : TextForegroundStyle.f29638a.b(j3), j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.b() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i3, i4, j7, textIndent, platformTextStyle != null ? platformTextStyle.a() : null, lineHeightStyle, i5, i6, textMotion, null), platformTextStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.f28926a, textStyle.f28926a) && Intrinsics.areEqual(this.f28927b, textStyle.f28927b) && Intrinsics.areEqual(this.f28928c, textStyle.f28928c);
    }

    public final float f() {
        return this.f28926a.c();
    }

    public final long g() {
        return this.f28926a.d();
    }

    public final BaselineShift h() {
        return this.f28926a.e();
    }

    public int hashCode() {
        int iHashCode = ((this.f28926a.hashCode() * 31) + this.f28927b.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.f28928c;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final Brush i() {
        return this.f28926a.f();
    }

    public final long j() {
        return this.f28926a.g();
    }

    public final DrawStyle k() {
        return this.f28926a.h();
    }

    public final FontFamily l() {
        return this.f28926a.i();
    }

    public final String m() {
        return this.f28926a.j();
    }

    public final long n() {
        return this.f28926a.k();
    }

    public final FontStyle o() {
        return this.f28926a.l();
    }

    public final FontSynthesis p() {
        return this.f28926a.m();
    }

    public final FontWeight q() {
        return this.f28926a.n();
    }

    public final int r() {
        return this.f28927b.c();
    }

    public final long s() {
        return this.f28926a.o();
    }

    public final int t() {
        return this.f28927b.d();
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) Color.A(j())) + ", brush=" + i() + ", alpha=" + f() + ", fontSize=" + ((Object) TextUnit.l(n())) + ", fontWeight=" + q() + ", fontStyle=" + o() + ", fontSynthesis=" + p() + ", fontFamily=" + l() + ", fontFeatureSettings=" + m() + ", letterSpacing=" + ((Object) TextUnit.l(s())) + ", baselineShift=" + h() + ", textGeometricTransform=" + E() + ", localeList=" + w() + ", background=" + ((Object) Color.A(g())) + ", textDecoration=" + C() + ", shadow=" + z() + ", drawStyle=" + k() + ", textAlign=" + ((Object) TextAlign.m(B())) + ", textDirection=" + ((Object) TextDirection.l(D())) + ", lineHeight=" + ((Object) TextUnit.l(u())) + ", textIndent=" + F() + ", platformStyle=" + this.f28928c + ", lineHeightStyle=" + v() + ", lineBreak=" + ((Object) LineBreak.k(t())) + ", hyphens=" + ((Object) Hyphens.i(r())) + ", textMotion=" + G() + ')';
    }

    public final long u() {
        return this.f28927b.e();
    }

    public final LineHeightStyle v() {
        return this.f28927b.f();
    }

    public final LocaleList w() {
        return this.f28926a.p();
    }

    public final ParagraphStyle x() {
        return this.f28927b;
    }

    public final PlatformTextStyle y() {
        return this.f28928c;
    }

    public final Shadow z() {
        return this.f28926a.r();
    }

    public /* synthetic */ TextStyle(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f3, j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, drawStyle, i3, i4, j6, textIndent, platformTextStyle, lineHeightStyle, i5, i6, textMotion);
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.f28926a = spanStyle;
        this.f28927b = paragraphStyle;
        this.f28928c = platformTextStyle;
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.b(spanStyle.q(), paragraphStyle.g()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        long jK = (i7 & 1) != 0 ? Color.f25715b.k() : j3;
        long jA = (i7 & 2) != 0 ? TextUnit.f30006b.a() : j4;
        FontWeight fontWeight2 = (i7 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i7 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i7 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i7 & 32) != 0 ? null : fontFamily;
        String str2 = (i7 & 64) != 0 ? null : str;
        long jA2 = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TextUnit.f30006b.a() : j5;
        BaselineShift baselineShift2 = (i7 & Function.MAX_NARGS) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i7 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i7 & 1024) != 0 ? null : localeList;
        long jK2 = (i7 & 2048) != 0 ? Color.f25715b.k() : j6;
        TextDecoration textDecoration2 = (i7 & 4096) != 0 ? null : textDecoration;
        long j8 = jK;
        Shadow shadow2 = (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : shadow;
        DrawStyle drawStyle2 = (i7 & 16384) != 0 ? null : drawStyle;
        int iG = (i7 & 32768) != 0 ? TextAlign.f29616b.g() : i3;
        int iF = (i7 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? TextDirection.f29630b.f() : i4;
        long jA3 = (i7 & 131072) != 0 ? TextUnit.f30006b.a() : j7;
        TextIndent textIndent2 = (i7 & 262144) != 0 ? null : textIndent;
        PlatformTextStyle platformTextStyle2 = (i7 & 524288) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i7 & 1048576) != 0 ? null : lineHeightStyle;
        int iB = (i7 & 2097152) != 0 ? LineBreak.f29567b.b() : i5;
        int iC = (i7 & 4194304) != 0 ? Hyphens.f29562b.c() : i6;
        long j9 = jA;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j10 = jA2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j11 = jK2;
        this(j8, j9, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j10, baselineShift3, textGeometricTransform3, localeList3, j11, textDecoration3, shadow2, drawStyle2, iG, iF, jA3, textIndent2, platformTextStyle2, lineHeightStyle2, iB, iC, (i7 & 8388608) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j7, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        this(new SpanStyle(j3, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.b() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i3, i4, j7, textIndent, platformTextStyle != null ? platformTextStyle.a() : null, lineHeightStyle, i5, i6, textMotion, null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i7 & 2) != 0 ? Float.NaN : f3, (i7 & 4) != 0 ? TextUnit.f30006b.a() : j3, (i7 & 8) != 0 ? null : fontWeight, (i7 & 16) != 0 ? null : fontStyle, (i7 & 32) != 0 ? null : fontSynthesis, (i7 & 64) != 0 ? null : fontFamily, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str, (i7 & Function.MAX_NARGS) != 0 ? TextUnit.f30006b.a() : j4, (i7 & 512) != 0 ? null : baselineShift, (i7 & 1024) != 0 ? null : textGeometricTransform, (i7 & 2048) != 0 ? null : localeList, (i7 & 4096) != 0 ? Color.f25715b.k() : j5, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : textDecoration, (i7 & 16384) != 0 ? null : shadow, (32768 & i7) != 0 ? null : drawStyle, (65536 & i7) != 0 ? TextAlign.f29616b.g() : i3, (131072 & i7) != 0 ? TextDirection.f29630b.f() : i4, (262144 & i7) != 0 ? TextUnit.f30006b.a() : j6, (524288 & i7) != 0 ? null : textIndent, (1048576 & i7) != 0 ? null : platformTextStyle, (2097152 & i7) != 0 ? null : lineHeightStyle, (4194304 & i7) != 0 ? LineBreak.f29567b.b() : i5, (8388608 & i7) != 0 ? Hyphens.f29562b.c() : i6, (i7 & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i3, int i4, long j6, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i5, int i6, TextMotion textMotion) {
        this(new SpanStyle(brush, f3, j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.b() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i3, i4, j6, textIndent, platformTextStyle != null ? platformTextStyle.a() : null, lineHeightStyle, i5, i6, textMotion, null), platformTextStyle);
    }
}
