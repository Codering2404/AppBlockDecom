package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SpanStyle implements AnnotatedString.Annotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextForegroundStyle f28855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f28856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontWeight f28857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FontStyle f28858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FontSynthesis f28859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FontFamily f28860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f28861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f28862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BaselineShift f28863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextGeometricTransform f28864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LocaleList f28865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f28866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextDecoration f28867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Shadow f28868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final PlatformSpanStyle f28869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final DrawStyle f28870p;

    public /* synthetic */ SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    public static /* synthetic */ SpanStyle b(SpanStyle spanStyle, long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i3, Object obj) {
        long jG = (i3 & 1) != 0 ? spanStyle.g() : j3;
        return spanStyle.a(jG, (i3 & 2) != 0 ? spanStyle.f28856b : j4, (i3 & 4) != 0 ? spanStyle.f28857c : fontWeight, (i3 & 8) != 0 ? spanStyle.f28858d : fontStyle, (i3 & 16) != 0 ? spanStyle.f28859e : fontSynthesis, (i3 & 32) != 0 ? spanStyle.f28860f : fontFamily, (i3 & 64) != 0 ? spanStyle.f28861g : str, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? spanStyle.f28862h : j5, (i3 & Function.MAX_NARGS) != 0 ? spanStyle.f28863i : baselineShift, (i3 & 512) != 0 ? spanStyle.f28864j : textGeometricTransform, (i3 & 1024) != 0 ? spanStyle.f28865k : localeList, (i3 & 2048) != 0 ? spanStyle.f28866l : j6, (i3 & 4096) != 0 ? spanStyle.f28867m : textDecoration, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? spanStyle.f28868n : shadow, (i3 & 16384) != 0 ? spanStyle.f28869o : platformSpanStyle, (i3 & 32768) != 0 ? spanStyle.f28870p : drawStyle);
    }

    public final SpanStyle a(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        return new SpanStyle(Color.t(j3, g()) ? this.f28855a : TextForegroundStyle.f29638a.b(j3), j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    public final float c() {
        return this.f28855a.a();
    }

    public final long d() {
        return this.f28866l;
    }

    public final BaselineShift e() {
        return this.f28863i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return v(spanStyle) && w(spanStyle);
    }

    public final Brush f() {
        return this.f28855a.e();
    }

    public final long g() {
        return this.f28855a.d();
    }

    public final DrawStyle h() {
        return this.f28870p;
    }

    public int hashCode() {
        int iZ = Color.z(g()) * 31;
        Brush brushF = f();
        int iHashCode = (((((iZ + (brushF != null ? brushF.hashCode() : 0)) * 31) + Float.hashCode(c())) * 31) + TextUnit.i(this.f28856b)) * 31;
        FontWeight fontWeight = this.f28857c;
        int iHashCode2 = (iHashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.f28858d;
        int iG = (iHashCode2 + (fontStyle != null ? FontStyle.g(fontStyle.i()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.f28859e;
        int i3 = (iG + (fontSynthesis != null ? FontSynthesis.i(fontSynthesis.m()) : 0)) * 31;
        FontFamily fontFamily = this.f28860f;
        int iHashCode3 = (i3 + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.f28861g;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.i(this.f28862h)) * 31;
        BaselineShift baselineShift = this.f28863i;
        int iH = (iHashCode4 + (baselineShift != null ? BaselineShift.h(baselineShift.j()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.f28864j;
        int iHashCode5 = (iH + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.f28865k;
        int iHashCode6 = (((iHashCode5 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.z(this.f28866l)) * 31;
        TextDecoration textDecoration = this.f28867m;
        int iHashCode7 = (iHashCode6 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        Shadow shadow = this.f28868n;
        int iHashCode8 = (iHashCode7 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.f28869o;
        int iHashCode9 = (iHashCode8 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle = this.f28870p;
        return iHashCode9 + (drawStyle != null ? drawStyle.hashCode() : 0);
    }

    public final FontFamily i() {
        return this.f28860f;
    }

    public final String j() {
        return this.f28861g;
    }

    public final long k() {
        return this.f28856b;
    }

    public final FontStyle l() {
        return this.f28858d;
    }

    public final FontSynthesis m() {
        return this.f28859e;
    }

    public final FontWeight n() {
        return this.f28857c;
    }

    public final long o() {
        return this.f28862h;
    }

    public final LocaleList p() {
        return this.f28865k;
    }

    public final PlatformSpanStyle q() {
        return this.f28869o;
    }

    public final Shadow r() {
        return this.f28868n;
    }

    public final TextDecoration s() {
        return this.f28867m;
    }

    public final TextForegroundStyle t() {
        return this.f28855a;
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) Color.A(g())) + ", brush=" + f() + ", alpha=" + c() + ", fontSize=" + ((Object) TextUnit.l(this.f28856b)) + ", fontWeight=" + this.f28857c + ", fontStyle=" + this.f28858d + ", fontSynthesis=" + this.f28859e + ", fontFamily=" + this.f28860f + ", fontFeatureSettings=" + this.f28861g + ", letterSpacing=" + ((Object) TextUnit.l(this.f28862h)) + ", baselineShift=" + this.f28863i + ", textGeometricTransform=" + this.f28864j + ", localeList=" + this.f28865k + ", background=" + ((Object) Color.A(this.f28866l)) + ", textDecoration=" + this.f28867m + ", shadow=" + this.f28868n + ", platformStyle=" + this.f28869o + ", drawStyle=" + this.f28870p + ')';
    }

    public final TextGeometricTransform u() {
        return this.f28864j;
    }

    public final boolean v(SpanStyle spanStyle) {
        if (this == spanStyle) {
            return true;
        }
        return TextUnit.e(this.f28856b, spanStyle.f28856b) && Intrinsics.areEqual(this.f28857c, spanStyle.f28857c) && Intrinsics.areEqual(this.f28858d, spanStyle.f28858d) && Intrinsics.areEqual(this.f28859e, spanStyle.f28859e) && Intrinsics.areEqual(this.f28860f, spanStyle.f28860f) && Intrinsics.areEqual(this.f28861g, spanStyle.f28861g) && TextUnit.e(this.f28862h, spanStyle.f28862h) && Intrinsics.areEqual(this.f28863i, spanStyle.f28863i) && Intrinsics.areEqual(this.f28864j, spanStyle.f28864j) && Intrinsics.areEqual(this.f28865k, spanStyle.f28865k) && Color.t(this.f28866l, spanStyle.f28866l) && Intrinsics.areEqual(this.f28869o, spanStyle.f28869o);
    }

    public final boolean w(SpanStyle spanStyle) {
        return Intrinsics.areEqual(this.f28855a, spanStyle.f28855a) && Intrinsics.areEqual(this.f28867m, spanStyle.f28867m) && Intrinsics.areEqual(this.f28868n, spanStyle.f28868n) && Intrinsics.areEqual(this.f28870p, spanStyle.f28870p);
    }

    public final int x() {
        int i3 = TextUnit.i(this.f28856b) * 31;
        FontWeight fontWeight = this.f28857c;
        int iHashCode = (i3 + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.f28858d;
        int iG = (iHashCode + (fontStyle != null ? FontStyle.g(fontStyle.i()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.f28859e;
        int i4 = (iG + (fontSynthesis != null ? FontSynthesis.i(fontSynthesis.m()) : 0)) * 31;
        FontFamily fontFamily = this.f28860f;
        int iHashCode2 = (i4 + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.f28861g;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.i(this.f28862h)) * 31;
        BaselineShift baselineShift = this.f28863i;
        int iH = (iHashCode3 + (baselineShift != null ? BaselineShift.h(baselineShift.j()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.f28864j;
        int iHashCode4 = (iH + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.f28865k;
        int iHashCode5 = (((iHashCode4 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.z(this.f28866l)) * 31;
        PlatformSpanStyle platformSpanStyle = this.f28869o;
        return iHashCode5 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0);
    }

    public final SpanStyle y(SpanStyle spanStyle) {
        return spanStyle == null ? this : SpanStyleKt.b(this, spanStyle.f28855a.d(), spanStyle.f28855a.e(), spanStyle.f28855a.a(), spanStyle.f28856b, spanStyle.f28857c, spanStyle.f28858d, spanStyle.f28859e, spanStyle.f28860f, spanStyle.f28861g, spanStyle.f28862h, spanStyle.f28863i, spanStyle.f28864j, spanStyle.f28865k, spanStyle.f28866l, spanStyle.f28867m, spanStyle.f28868n, spanStyle.f28869o, spanStyle.f28870p);
    }

    public final SpanStyle z(SpanStyle spanStyle) {
        return y(spanStyle);
    }

    public /* synthetic */ SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow);
    }

    public /* synthetic */ SpanStyle(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f3, j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this.f28855a = textForegroundStyle;
        this.f28856b = j3;
        this.f28857c = fontWeight;
        this.f28858d = fontStyle;
        this.f28859e = fontSynthesis;
        this.f28860f = fontFamily;
        this.f28861g = str;
        this.f28862h = j4;
        this.f28863i = baselineShift;
        this.f28864j = textGeometricTransform;
        this.f28865k = localeList;
        this.f28866l = j5;
        this.f28867m = textDecoration;
        this.f28868n = shadow;
        this.f28869o = platformSpanStyle;
        this.f28870p = drawStyle;
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, (i3 & 2) != 0 ? TextUnit.f30006b.a() : j3, (i3 & 4) != 0 ? null : fontWeight, (i3 & 8) != 0 ? null : fontStyle, (i3 & 16) != 0 ? null : fontSynthesis, (i3 & 32) != 0 ? null : fontFamily, (i3 & 64) != 0 ? null : str, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TextUnit.f30006b.a() : j4, (i3 & Function.MAX_NARGS) != 0 ? null : baselineShift, (i3 & 512) != 0 ? null : textGeometricTransform, (i3 & 1024) != 0 ? null : localeList, (i3 & 2048) != 0 ? Color.f25715b.k() : j5, (i3 & 4096) != 0 ? null : textDecoration, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : shadow, (i3 & 16384) != 0 ? null : platformSpanStyle, (i3 & 32768) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        long jK = (i3 & 1) != 0 ? Color.f25715b.k() : j3;
        long jA = (i3 & 2) != 0 ? TextUnit.f30006b.a() : j4;
        FontWeight fontWeight2 = (i3 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i3 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i3 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i3 & 32) != 0 ? null : fontFamily;
        String str2 = (i3 & 64) != 0 ? null : str;
        long jA2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TextUnit.f30006b.a() : j5;
        BaselineShift baselineShift2 = (i3 & Function.MAX_NARGS) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i3 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i3 & 1024) != 0 ? null : localeList;
        long jK2 = (i3 & 2048) != 0 ? Color.f25715b.k() : j6;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = jA2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = jK2;
        this(jK, jA, fontWeight2, fontStyle3, fontSynthesis3, fontFamily3, str3, j7, baselineShift3, textGeometricTransform3, localeList3, j8, (i3 & 4096) != 0 ? null : textDecoration, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : shadow, null);
    }

    private SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow) {
        this(TextForegroundStyle.f29638a.b(j3), j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, 32768, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        long jK = (i3 & 1) != 0 ? Color.f25715b.k() : j3;
        long jA = (i3 & 2) != 0 ? TextUnit.f30006b.a() : j4;
        FontWeight fontWeight2 = (i3 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i3 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i3 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i3 & 32) != 0 ? null : fontFamily;
        String str2 = (i3 & 64) != 0 ? null : str;
        long jA2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TextUnit.f30006b.a() : j5;
        BaselineShift baselineShift2 = (i3 & Function.MAX_NARGS) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i3 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i3 & 1024) != 0 ? null : localeList;
        long jK2 = (i3 & 2048) != 0 ? Color.f25715b.k() : j6;
        TextDecoration textDecoration2 = (i3 & 4096) != 0 ? null : textDecoration;
        long j7 = jK;
        Shadow shadow2 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : shadow;
        PlatformSpanStyle platformSpanStyle2 = (i3 & 16384) != 0 ? null : platformSpanStyle;
        long j8 = jA;
        FontWeight fontWeight3 = fontWeight2;
        TextDecoration textDecoration3 = textDecoration2;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j9 = jA2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j10 = jK2;
        this(j7, j8, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str3, j9, baselineShift3, textGeometricTransform3, localeList3, j10, textDecoration3, shadow2, platformSpanStyle2, (i3 & 32768) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.f29638a.b(j3), j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(Brush brush, float f3, long j3, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j4, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j5, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.f29638a.a(brush, f3), j3, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j4, baselineShift, textGeometricTransform, localeList, j5, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
