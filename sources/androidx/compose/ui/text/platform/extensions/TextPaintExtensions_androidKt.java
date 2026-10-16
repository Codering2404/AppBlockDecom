package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
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
public final class TextPaintExtensions_androidKt {
    public static final SpanStyle a(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z2) {
        long jG = TextUnit.g(spanStyle.k());
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            androidTextPaint.setTextSize(density.J0(spanStyle.k()));
        } else if (TextUnitType.g(jG, companion.a())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.h(spanStyle.k()));
        }
        if (d(spanStyle)) {
            FontFamily fontFamilyI = spanStyle.i();
            FontWeight fontWeightN = spanStyle.n();
            if (fontWeightN == null) {
                fontWeightN = FontWeight.f29233b.g();
            }
            FontStyle fontStyleL = spanStyle.l();
            FontStyle fontStyleC = FontStyle.c(fontStyleL != null ? fontStyleL.i() : FontStyle.f29211b.b());
            FontSynthesis fontSynthesisM = spanStyle.m();
            androidTextPaint.setTypeface((Typeface) function4.invoke(fontFamilyI, fontWeightN, fontStyleC, FontSynthesis.e(fontSynthesisM != null ? fontSynthesisM.m() : FontSynthesis.f29215b.a())));
        }
        if (spanStyle.p() != null && !Intrinsics.areEqual(spanStyle.p(), LocaleList.f29471c.a())) {
            LocaleListHelperMethods.f29529a.b(androidTextPaint, spanStyle.p());
        }
        if (spanStyle.j() != null && !Intrinsics.areEqual(spanStyle.j(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.j());
        }
        if (spanStyle.u() != null && !Intrinsics.areEqual(spanStyle.u(), TextGeometricTransform.f29643c.a())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.u().b());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.u().c());
        }
        androidTextPaint.f(spanStyle.g());
        androidTextPaint.e(spanStyle.f(), Size.f25617b.a(), spanStyle.c());
        androidTextPaint.h(spanStyle.r());
        androidTextPaint.i(spanStyle.s());
        androidTextPaint.g(spanStyle.h());
        if (TextUnitType.g(TextUnit.g(spanStyle.o()), companion.b()) && TextUnit.h(spanStyle.o()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float fJ0 = density.J0(spanStyle.o());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(fJ0 / textSize);
            }
        } else if (TextUnitType.g(TextUnit.g(spanStyle.o()), companion.a())) {
            androidTextPaint.setLetterSpacing(TextUnit.h(spanStyle.o()));
        }
        return c(spanStyle.o(), z2, spanStyle.d(), spanStyle.e());
    }

    public static final float b(float f3) {
        if (f3 == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f3;
    }

    private static final SpanStyle c(long j3, boolean z2, long j4, BaselineShift baselineShift) {
        long jK = j4;
        boolean z3 = false;
        boolean z4 = z2 && TextUnitType.g(TextUnit.g(j3), TextUnitType.f30010b.b()) && TextUnit.h(j3) != 0.0f;
        Color.Companion companion = Color.f25715b;
        boolean z5 = (Color.t(jK, companion.k()) || Color.t(jK, companion.j())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.g(baselineShift.j(), BaselineShift.f29554b.a())) {
                z3 = true;
            }
        }
        if (!z4 && !z5 && !z3) {
            return null;
        }
        long jA = z4 ? j3 : TextUnit.f30006b.a();
        if (!z5) {
            jK = companion.k();
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, jA, z3 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, jK, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (DefaultConstructorMarker) null);
    }

    public static final boolean d(SpanStyle spanStyle) {
        return (spanStyle.i() == null && spanStyle.l() == null && spanStyle.n() == null) ? false : true;
    }

    public static final void e(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        if (textMotion == null) {
            textMotion = TextMotion.f29651c.a();
        }
        androidTextPaint.setFlags(textMotion.c() ? androidTextPaint.getFlags() | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : androidTextPaint.getFlags() & (-129));
        int iB = textMotion.b();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.f29656b;
        if (TextMotion.Linearity.g(iB, companion.b())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.g(iB, companion.a())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!TextMotion.Linearity.g(iB, companion.c())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
