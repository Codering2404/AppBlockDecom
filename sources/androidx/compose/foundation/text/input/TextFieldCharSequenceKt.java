package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
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
public final class TextFieldCharSequenceKt {
    public static final CharSequence a(TextFieldCharSequence textFieldCharSequence) {
        return textFieldCharSequence.subSequence(TextRange.l(textFieldCharSequence.g()), TextRange.k(textFieldCharSequence.g()));
    }

    public static final CharSequence b(TextFieldCharSequence textFieldCharSequence, int i3) {
        return textFieldCharSequence.subSequence(TextRange.k(textFieldCharSequence.g()), Math.min(TextRange.k(textFieldCharSequence.g()) + i3, textFieldCharSequence.length()));
    }

    public static final CharSequence c(TextFieldCharSequence textFieldCharSequence, int i3) {
        return textFieldCharSequence.subSequence(Math.max(0, TextRange.l(textFieldCharSequence.g()) - i3), TextRange.l(textFieldCharSequence.g()));
    }
}
