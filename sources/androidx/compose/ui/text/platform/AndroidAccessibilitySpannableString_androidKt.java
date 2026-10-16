package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
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
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void a(SpannableString spannableString, SpanStyle spanStyle, int i3, int i4, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m(spannableString, spanStyle.g(), i3, i4);
        SpannableExtensions_androidKt.q(spannableString, spanStyle.k(), density, i3, i4);
        if (spanStyle.n() != null || spanStyle.l() != null) {
            FontWeight fontWeightN = spanStyle.n();
            if (fontWeightN == null) {
                fontWeightN = FontWeight.f29233b.g();
            }
            FontStyle fontStyleL = spanStyle.l();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.c(fontWeightN, fontStyleL != null ? fontStyleL.i() : FontStyle.f29211b.b())), i3, i4, 33);
        }
        if (spanStyle.i() != null) {
            if (spanStyle.i() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.i()).g()), i3, i4, 33);
            } else {
                FontFamily fontFamilyI = spanStyle.i();
                FontSynthesis fontSynthesisM = spanStyle.m();
                Object value = FontFamily.Resolver.b(resolver, fontFamilyI, null, 0, fontSynthesisM != null ? fontSynthesisM.m() : FontSynthesis.f29215b.a(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.f29512a.a((Typeface) value), i3, i4, 33);
            }
        }
        if (spanStyle.s() != null) {
            TextDecoration textDecorationS = spanStyle.s();
            TextDecoration.Companion companion = TextDecoration.f29625b;
            if (textDecorationS.d(companion.d())) {
                spannableString.setSpan(new UnderlineSpan(), i3, i4, 33);
            }
            if (spanStyle.s().d(companion.b())) {
                spannableString.setSpan(new StrikethroughSpan(), i3, i4, 33);
            }
        }
        if (spanStyle.u() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.u().b()), i3, i4, 33);
        }
        SpannableExtensions_androidKt.u(spannableString, spanStyle.p(), i3, i4);
        SpannableExtensions_androidKt.i(spannableString, spanStyle.d(), i3, i4);
    }

    public static final SpannableString b(AnnotatedString annotatedString, Density density, FontFamily.Resolver resolver, URLSpanCache uRLSpanCache) {
        SpannableString spannableString = new SpannableString(annotatedString.k());
        List listH = annotatedString.h();
        if (listH != null) {
            int size = listH.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnnotatedString.Range range = (AnnotatedString.Range) listH.get(i3);
                a(spannableString, SpanStyle.b((SpanStyle) range.a(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65503, null), range.b(), range.c(), density, resolver);
            }
        }
        List listL = annotatedString.l(0, annotatedString.length());
        int size2 = listL.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range2 = (AnnotatedString.Range) listL.get(i4);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.a((TtsAnnotation) range2.a()), range2.b(), range2.c(), 33);
        }
        List listM = annotatedString.m(0, annotatedString.length());
        int size3 = listM.size();
        for (int i5 = 0; i5 < size3; i5++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) listM.get(i5);
            spannableString.setSpan(uRLSpanCache.c((UrlAnnotation) range3.a()), range3.b(), range3.c(), 33);
        }
        List listE = annotatedString.e(0, annotatedString.length());
        int size4 = listE.size();
        for (int i6 = 0; i6 < size4; i6++) {
            AnnotatedString.Range range4 = (AnnotatedString.Range) listE.get(i6);
            if (range4.h() != range4.f()) {
                LinkAnnotation linkAnnotation = (LinkAnnotation) range4.g();
                if ((linkAnnotation instanceof LinkAnnotation.Url) && linkAnnotation.a() == null) {
                    spannableString.setSpan(uRLSpanCache.b(c(range4)), range4.h(), range4.f(), 33);
                } else {
                    spannableString.setSpan(uRLSpanCache.a(range4), range4.h(), range4.f(), 33);
                }
            }
        }
        return spannableString;
    }

    private static final AnnotatedString.Range c(AnnotatedString.Range range) {
        Object objG = range.g();
        Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new AnnotatedString.Range((LinkAnnotation.Url) objG, range.h(), range.f());
    }
}
