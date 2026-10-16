package androidx.compose.foundation.internal;

import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ClipboardUtils_androidKt {
    public static final AnnotatedString a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (!(charSequence instanceof Spanned)) {
            return new AnnotatedString(charSequence.toString(), null, 2, null);
        }
        Spanned spanned = (Spanned) charSequence;
        int i3 = 0;
        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(0, charSequence.length(), Annotation.class);
        ArrayList arrayList = new ArrayList();
        int lastIndex = ArraysKt.getLastIndex(annotationArr);
        if (lastIndex >= 0) {
            while (true) {
                Annotation annotation = annotationArr[i3];
                if (Intrinsics.areEqual(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                    arrayList.add(new AnnotatedString.Range(new DecodeHelper(annotation.getValue()).k(), spanned.getSpanStart(annotation), spanned.getSpanEnd(annotation)));
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return new AnnotatedString(charSequence.toString(), arrayList, null, 4, null);
    }

    public static final CharSequence b(AnnotatedString annotatedString) {
        if (annotatedString.g().isEmpty()) {
            return annotatedString.k();
        }
        SpannableString spannableString = new SpannableString(annotatedString.k());
        EncodeHelper encodeHelper = new EncodeHelper();
        List listG = annotatedString.g();
        int size = listG.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) listG.get(i3);
            SpanStyle spanStyle = (SpanStyle) range.a();
            int iB = range.b();
            int iC = range.c();
            encodeHelper.q();
            encodeHelper.e(spanStyle);
            spannableString.setSpan(new Annotation("androidx.compose.text.SpanStyle", encodeHelper.p()), iB, iC, 33);
        }
        return spannableString;
    }

    public static final boolean c(ClipEntry clipEntry) {
        return ClipboardUtils.a(clipEntry);
    }

    public static final AnnotatedString d(ClipEntry clipEntry) {
        return ClipboardUtils.b(clipEntry);
    }

    public static final String e(ClipEntry clipEntry) {
        return ClipboardUtils.c(clipEntry);
    }

    public static final ClipEntry f(AnnotatedString annotatedString) {
        return ClipboardUtils.d(annotatedString);
    }
}
