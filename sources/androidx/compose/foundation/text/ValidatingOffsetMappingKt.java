package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;

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
public final class ValidatingOffsetMappingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final OffsetMapping f10083a = new ValidatingOffsetMapping(OffsetMapping.f29394a.a(), 0, 0);

    public static final TransformedText c(VisualTransformation visualTransformation, AnnotatedString annotatedString) {
        TransformedText transformedTextA = visualTransformation.a(annotatedString);
        f(transformedTextA, annotatedString.length(), 0, 2, null);
        return new TransformedText(transformedTextA.b(), new ValidatingOffsetMapping(transformedTextA.a(), annotatedString.length(), transformedTextA.b().length()));
    }

    public static final OffsetMapping d() {
        return f10083a;
    }

    public static final void e(TransformedText transformedText, int i3, int i4) {
        int length = transformedText.b().length();
        int iMin = Math.min(i3, i4);
        for (int i5 = 0; i5 < iMin; i5++) {
            g(transformedText.a().b(i5), length, i5);
        }
        g(transformedText.a().b(i3), length, i3);
        int iMin2 = Math.min(length, i4);
        for (int i6 = 0; i6 < iMin2; i6++) {
            h(transformedText.a().a(i6), i3, i6);
        }
        h(transformedText.a().a(length), i3, length);
    }

    public static /* synthetic */ void f(TransformedText transformedText, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 100;
        }
        e(transformedText, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, int i4, int i5) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= i4) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.c("OffsetMapping.originalToTransformed returned invalid mapping: " + i5 + " -> " + i3 + " is not in range of transformed text [0, " + i4 + ']');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, int i4, int i5) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= i4) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.c("OffsetMapping.transformedToOriginal returned invalid mapping: " + i5 + " -> " + i3 + " is not in range of original text [0, " + i4 + ']');
    }
}
