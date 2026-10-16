package androidx.compose.foundation.internal;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class MutableSpanStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FontWeight f6523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FontStyle f6524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FontSynthesis f6525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FontFamily f6526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f6527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaselineShift f6529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextGeometricTransform f6530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LocaleList f6531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f6532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextDecoration f6533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Shadow f6534n;

    public /* synthetic */ MutableSpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j5, baselineShift, textGeometricTransform, localeList, j6, textDecoration, shadow);
    }

    public final void a(long j3) {
        this.f6532l = j3;
    }

    public final void b(BaselineShift baselineShift) {
        this.f6529i = baselineShift;
    }

    public final void c(long j3) {
        this.f6521a = j3;
    }

    public final void d(String str) {
        this.f6527g = str;
    }

    public final void e(long j3) {
        this.f6522b = j3;
    }

    public final void f(FontStyle fontStyle) {
        this.f6524d = fontStyle;
    }

    public final void g(FontSynthesis fontSynthesis) {
        this.f6525e = fontSynthesis;
    }

    public final void h(FontWeight fontWeight) {
        this.f6523c = fontWeight;
    }

    public final void i(long j3) {
        this.f6528h = j3;
    }

    public final void j(Shadow shadow) {
        this.f6534n = shadow;
    }

    public final void k(TextDecoration textDecoration) {
        this.f6533m = textDecoration;
    }

    public final void l(TextGeometricTransform textGeometricTransform) {
        this.f6530j = textGeometricTransform;
    }

    public final SpanStyle m() {
        return new SpanStyle(this.f6521a, this.f6522b, this.f6523c, this.f6524d, this.f6525e, this.f6526f, this.f6527g, this.f6528h, this.f6529i, this.f6530j, this.f6531k, this.f6532l, this.f6533m, this.f6534n, (PlatformSpanStyle) null, (DrawStyle) null, 49152, (DefaultConstructorMarker) null);
    }

    private MutableSpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow) {
        this.f6521a = j3;
        this.f6522b = j4;
        this.f6523c = fontWeight;
        this.f6524d = fontStyle;
        this.f6525e = fontSynthesis;
        this.f6526f = fontFamily;
        this.f6527g = str;
        this.f6528h = j5;
        this.f6529i = baselineShift;
        this.f6530j = textGeometricTransform;
        this.f6531k = localeList;
        this.f6532l = j6;
        this.f6533m = textDecoration;
        this.f6534n = shadow;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MutableSpanStyle(long j3, long j4, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j5, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j6, TextDecoration textDecoration, Shadow shadow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
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
}
