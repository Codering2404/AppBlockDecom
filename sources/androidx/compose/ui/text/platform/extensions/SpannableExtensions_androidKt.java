package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.Bullet;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.CustomBulletSpan;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

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
public final class SpannableExtensions_androidKt {
    public static final void A(Spannable spannable, TextIndent textIndent, float f3, Density density) {
        if (textIndent != null) {
            if ((TextUnit.e(textIndent.b(), TextUnitKt.i(0)) && TextUnit.e(textIndent.c(), TextUnitKt.i(0))) || TextUnit.f(textIndent.b()) == 0 || TextUnit.f(textIndent.c()) == 0) {
                return;
            }
            long jG = TextUnit.g(textIndent.b());
            TextUnitType.Companion companion = TextUnitType.f30010b;
            float fH = 0.0f;
            float fJ0 = TextUnitType.g(jG, companion.b()) ? density.J0(textIndent.b()) : TextUnitType.g(jG, companion.a()) ? TextUnit.h(textIndent.b()) * f3 : 0.0f;
            long jG2 = TextUnit.g(textIndent.c());
            if (TextUnitType.g(jG2, companion.b())) {
                fH = density.J0(textIndent.c());
            } else if (TextUnitType.g(jG2, companion.a())) {
                fH = TextUnit.h(textIndent.c()) * f3;
            }
            w(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fJ0), (int) Math.ceil(fH)), 0, spannable.length());
        }
    }

    private static final MetricAffectingSpan a(long j3, Density density) {
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            return new LetterSpacingSpanPx(density.J0(j3));
        }
        if (TextUnitType.g(jG, companion.a())) {
            return new LetterSpacingSpanEm(TextUnit.h(j3));
        }
        return null;
    }

    public static final void b(SpanStyle spanStyle, List list, Function3 function3) {
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            function3.invoke(f(spanStyle, (SpanStyle) ((AnnotatedString.Range) list.get(0)).g()), Integer.valueOf(((AnnotatedString.Range) list.get(0)).h()), Integer.valueOf(((AnnotatedString.Range) list.get(0)).f()));
            return;
        }
        int size = list.size();
        int i3 = size * 2;
        int[] iArr = new int[i3];
        List list2 = list;
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i4);
            iArr[i4] = range.h();
            iArr[i4 + size] = range.f();
        }
        ArraysKt.sort(iArr);
        int iFirst = ArraysKt.first(iArr);
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = iArr[i5];
            if (i6 != iFirst) {
                int size3 = list2.size();
                SpanStyle spanStyleF = spanStyle;
                for (int i7 = 0; i7 < size3; i7++) {
                    AnnotatedString.Range range2 = (AnnotatedString.Range) list.get(i7);
                    if (range2.h() != range2.f() && AnnotatedStringKt.i(iFirst, i6, range2.h(), range2.f())) {
                        spanStyleF = f(spanStyleF, (SpanStyle) range2.g());
                    }
                }
                if (spanStyleF != null) {
                    function3.invoke(spanStyleF, Integer.valueOf(iFirst), Integer.valueOf(i6));
                }
                iFirst = i6;
            }
        }
    }

    private static final boolean c(SpanStyle spanStyle) {
        long jG = TextUnit.g(spanStyle.o());
        TextUnitType.Companion companion = TextUnitType.f30010b;
        return TextUnitType.g(jG, companion.b()) || TextUnitType.g(TextUnit.g(spanStyle.o()), companion.a());
    }

    private static final boolean d(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.d(textStyle.P()) || textStyle.p() != null;
    }

    private static final boolean e(Density density) {
        return ((double) density.K1()) > 1.05d;
    }

    private static final SpanStyle f(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.y(spanStyle2);
    }

    private static final float g(long j3, float f3, Density density) {
        if (TextUnit.e(j3, TextUnit.f30006b.a())) {
            return f3;
        }
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            return density.J0(j3);
        }
        if (TextUnitType.g(jG, companion.a())) {
            return TextUnit.h(j3) * f3;
        }
        return Float.NaN;
    }

    private static final float h(long j3, float f3, Density density) {
        float fH;
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            if (!e(density)) {
                return density.J0(j3);
            }
            fH = TextUnit.h(j3) / TextUnit.h(density.v(f3));
        } else {
            if (!TextUnitType.g(jG, companion.a())) {
                return Float.NaN;
            }
            fH = TextUnit.h(j3);
        }
        return fH * f3;
    }

    public static final void i(Spannable spannable, long j3, int i3, int i4) {
        if (j3 != 16) {
            w(spannable, new BackgroundColorSpan(ColorKt.k(j3)), i3, i4);
        }
    }

    private static final void j(Spannable spannable, BaselineShift baselineShift, int i3, int i4) {
        if (baselineShift != null) {
            w(spannable, new BaselineShiftSpan(baselineShift.j()), i3, i4);
        }
    }

    private static final void k(Spannable spannable, Brush brush, float f3, int i3, int i4) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m(spannable, ((SolidColor) brush).a(), i3, i4);
            } else if (brush instanceof ShaderBrush) {
                w(spannable, new ShaderBrushSpan((ShaderBrush) brush, f3), i3, i4);
            }
        }
    }

    public static final void l(Spannable spannable, List list, float f3, Density density, TextIndent textIndent) {
        Density density2 = density;
        float fH = 0.0f;
        if (textIndent != null) {
            long jG = TextUnit.g(textIndent.b());
            TextUnitType.Companion companion = TextUnitType.f30010b;
            if (TextUnitType.g(jG, companion.b())) {
                fH = density2.J0(textIndent.b());
            } else if (TextUnitType.g(jG, companion.a())) {
                fH = TextUnit.h(textIndent.b()) * f3;
            }
        }
        float f4 = fH;
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
            Object objG = range.g();
            Bullet bullet = objG instanceof Bullet ? (Bullet) objG : null;
            if (bullet != null) {
                float fG = g(bullet.f(), f3, density2);
                float fG2 = g(bullet.d(), f3, density2);
                if (!Float.isNaN(fG) && !Float.isNaN(fG2)) {
                    w(spannable, new CustomBulletSpan(bullet.e(), fG, fG, fG2, bullet.b(), bullet.a(), bullet.c(), density2, f4), range.h(), range.f());
                }
            }
            i3++;
            density2 = density;
        }
    }

    public static final void m(Spannable spannable, long j3, int i3, int i4) {
        if (j3 != 16) {
            w(spannable, new ForegroundColorSpan(ColorKt.k(j3)), i3, i4);
        }
    }

    private static final void n(Spannable spannable, DrawStyle drawStyle, int i3, int i4) {
        if (drawStyle != null) {
            w(spannable, new DrawStyleSpan(drawStyle), i3, i4);
        }
    }

    private static final void o(final Spannable spannable, TextStyle textStyle, List list, final Function4 function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
            if ((range.g() instanceof SpanStyle) && (TextPaintExtensions_androidKt.d((SpanStyle) range.g()) || ((SpanStyle) range.g()).m() != null)) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                arrayList.add(range);
            }
        }
        b(d(textStyle) ? new SpanStyle(0L, 0L, textStyle.q(), textStyle.o(), textStyle.p(), textStyle.l(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (DefaultConstructorMarker) null) : null, arrayList, new Function3<SpanStyle, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final void c(SpanStyle spanStyle, int i4, int i5) {
                Spannable spannable2 = spannable;
                Function4 function42 = function4;
                FontFamily fontFamilyI = spanStyle.i();
                FontWeight fontWeightN = spanStyle.n();
                if (fontWeightN == null) {
                    fontWeightN = FontWeight.f29233b.g();
                }
                FontStyle fontStyleL = spanStyle.l();
                FontStyle fontStyleC = FontStyle.c(fontStyleL != null ? fontStyleL.i() : FontStyle.f29211b.b());
                FontSynthesis fontSynthesisM = spanStyle.m();
                spannable2.setSpan(new TypefaceSpan((Typeface) function42.invoke(fontFamilyI, fontWeightN, fontStyleC, FontSynthesis.e(fontSynthesisM != null ? fontSynthesisM.m() : FontSynthesis.f29215b.a()))), i4, i5, 33);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                c((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                return Unit.f139807a;
            }
        });
    }

    private static final void p(Spannable spannable, String str, int i3, int i4) {
        if (str != null) {
            w(spannable, new FontFeatureSpan(str), i3, i4);
        }
    }

    public static final void q(Spannable spannable, long j3, Density density, int i3, int i4) {
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.b())) {
            w(spannable, new AbsoluteSizeSpan(MathKt.d(density.J0(j3)), false), i3, i4);
        } else if (TextUnitType.g(jG, companion.a())) {
            w(spannable, new RelativeSizeSpan(TextUnit.h(j3)), i3, i4);
        }
    }

    private static final void r(Spannable spannable, TextGeometricTransform textGeometricTransform, int i3, int i4) {
        if (textGeometricTransform != null) {
            w(spannable, new ScaleXSpan(textGeometricTransform.b()), i3, i4);
            w(spannable, new SkewXSpan(textGeometricTransform.c()), i3, i4);
        }
    }

    public static final void s(Spannable spannable, long j3, float f3, Density density, LineHeightStyle lineHeightStyle) {
        float fH = h(j3, f3, density);
        if (Float.isNaN(fH)) {
            return;
        }
        w(spannable, new LineHeightStyleSpan(fH, 0, (spannable.length() == 0 || StringsKt.z1(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.h(lineHeightStyle.d()), LineHeightStyle.Trim.i(lineHeightStyle.d()), lineHeightStyle.b(), LineHeightStyle.Mode.f(lineHeightStyle.c(), LineHeightStyle.Mode.f29602b.b())), 0, spannable.length());
    }

    public static final void t(Spannable spannable, long j3, float f3, Density density) {
        float fH = h(j3, f3, density);
        if (Float.isNaN(fH)) {
            return;
        }
        w(spannable, new LineHeightSpan(fH), 0, spannable.length());
    }

    public static final void u(Spannable spannable, LocaleList localeList, int i3, int i4) {
        if (localeList != null) {
            w(spannable, LocaleListHelperMethods.f29529a.a(localeList), i3, i4);
        }
    }

    private static final void v(Spannable spannable, Shadow shadow, int i3, int i4) {
        if (shadow != null) {
            w(spannable, new ShadowSpan(ColorKt.k(shadow.c()), Float.intBitsToFloat((int) (shadow.d() >> 32)), Float.intBitsToFloat((int) (shadow.d() & 4294967295L)), TextPaintExtensions_androidKt.b(shadow.b())), i3, i4);
        }
    }

    public static final void w(Spannable spannable, Object obj, int i3, int i4) {
        spannable.setSpan(obj, i3, i4, 33);
    }

    private static final void x(Spannable spannable, SpanStyle spanStyle, int i3, int i4, Density density) {
        j(spannable, spanStyle.e(), i3, i4);
        m(spannable, spanStyle.g(), i3, i4);
        k(spannable, spanStyle.f(), spanStyle.c(), i3, i4);
        z(spannable, spanStyle.s(), i3, i4);
        q(spannable, spanStyle.k(), density, i3, i4);
        p(spannable, spanStyle.j(), i3, i4);
        r(spannable, spanStyle.u(), i3, i4);
        u(spannable, spanStyle.p(), i3, i4);
        i(spannable, spanStyle.d(), i3, i4);
        v(spannable, spanStyle.r(), i3, i4);
        n(spannable, spanStyle.h(), i3, i4);
    }

    public static final void y(Spannable spannable, TextStyle textStyle, List list, Density density, Function4 function4) {
        MetricAffectingSpan metricAffectingSpanA;
        o(spannable, textStyle, list, function4);
        List list2 = list;
        int size = list2.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
            if (range.g() instanceof SpanStyle) {
                int iH = range.h();
                int iF = range.f();
                if (iH >= 0 && iH < spannable.length() && iF > iH && iF <= spannable.length()) {
                    x(spannable, (SpanStyle) range.g(), iH, iF, density);
                    if (c((SpanStyle) range.g())) {
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            int size2 = list2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) list.get(i4);
                AnnotatedString.Annotation annotation = (AnnotatedString.Annotation) range2.g();
                if (annotation instanceof SpanStyle) {
                    int iH2 = range2.h();
                    int iF2 = range2.f();
                    if (iH2 >= 0 && iH2 < spannable.length() && iF2 > iH2 && iF2 <= spannable.length() && (metricAffectingSpanA = a(((SpanStyle) annotation).o(), density)) != null) {
                        w(spannable, metricAffectingSpanA, iH2, iF2);
                    }
                }
            }
        }
    }

    public static final void z(Spannable spannable, TextDecoration textDecoration, int i3, int i4) {
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.f29625b;
            w(spannable, new TextDecorationSpan(textDecoration.d(companion.d()), textDecoration.d(companion.b())), i3, i4);
        }
    }
}
