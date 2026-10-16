package androidx.compose.foundation.text.input.internal;

import android.content.ClipData;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class StatelessInputConnection_androidKt {
    private static final FontFamily b(String str) {
        if (str != null && str.length() != 0) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typeface = Typeface.DEFAULT;
            if (Intrinsics.areEqual(typefaceCreate, typeface) || Intrinsics.areEqual(typefaceCreate, Typeface.create(typeface, 0))) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null) {
                return AndroidTypeface_androidKt.a(typefaceCreate);
            }
        }
        return null;
    }

    private static final AnnotatedString.Annotation c(Object obj) {
        if (obj instanceof BackgroundColorSpan) {
            return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, ColorKt.b(((BackgroundColorSpan) obj).getBackgroundColor()), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63487, (DefaultConstructorMarker) null);
        }
        if (obj instanceof ForegroundColorSpan) {
            return new SpanStyle(ColorKt.b(((ForegroundColorSpan) obj).getForegroundColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
        }
        if (obj instanceof StrikethroughSpan) {
            return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.b(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null);
        }
        if (obj instanceof StyleSpan) {
            return f((StyleSpan) obj);
        }
        if (obj instanceof TypefaceSpan) {
            return g((TypefaceSpan) obj);
        }
        if (obj instanceof UnderlineSpan) {
            return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null);
        }
        return null;
    }

    public static final List d(Spanned spanned) {
        ArrayList arrayList = null;
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            AnnotatedString.Annotation annotationC = c(obj);
            if (annotationC != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new AnnotatedString.Range(annotationC, spanned.getSpanStart(obj), spanned.getSpanEnd(obj)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExtractedText e(TextFieldCharSequence textFieldCharSequence) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldCharSequence;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldCharSequence.length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.l(textFieldCharSequence.g());
        extractedText.selectionEnd = TextRange.k(textFieldCharSequence.g());
        extractedText.flags = !StringsKt.Z(textFieldCharSequence, '\n', false, 2, null) ? 1 : 0;
        return extractedText;
    }

    private static final SpanStyle f(StyleSpan styleSpan) {
        int style = styleSpan.getStyle();
        if (style == 1) {
            return new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null);
        }
        if (style == 2) {
            return new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null);
        }
        if (style != 3) {
            return null;
        }
        return new SpanStyle(0L, 0L, FontWeight.f29233b.b(), FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle g(TypefaceSpan typefaceSpan) {
        String family = typefaceSpan.getFamily();
        FontFamily.Companion companion = FontFamily.f29155b;
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, Intrinsics.areEqual(family, companion.a().g()) ? companion.a() : Intrinsics.areEqual(family, companion.c().g()) ? companion.c() : Intrinsics.areEqual(family, companion.d().g()) ? companion.d() : Intrinsics.areEqual(family, companion.e().g()) ? companion.e() : b(typefaceSpan.getFamily()), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (DefaultConstructorMarker) null);
    }

    public static final TransferableContent h(InputContentInfoCompat inputContentInfoCompat, Bundle bundle) {
        ClipEntry clipEntryA = AndroidClipboardManager_androidKt.a(new ClipData(inputContentInfoCompat.b(), new ClipData.Item(inputContentInfoCompat.a())));
        int iC = TransferableContent.Source.f5205b.c();
        ClipMetadata clipMetadataB = AndroidClipboardManager_androidKt.b(inputContentInfoCompat.b());
        Uri uriC = inputContentInfoCompat.c();
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        return new TransferableContent(clipEntryA, clipMetadataB, iC, new PlatformTransferableContent(uriC, bundle), null);
    }
}
