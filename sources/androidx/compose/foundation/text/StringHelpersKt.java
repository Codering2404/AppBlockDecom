package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
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
public final class StringHelpersKt {
    public static final int a(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        while (i3 < length) {
            if (charSequence.charAt(i3) == '\n') {
                return i3;
            }
            i3++;
        }
        return charSequence.length();
    }

    public static final int b(CharSequence charSequence, int i3) {
        while (i3 > 0) {
            if (charSequence.charAt(i3 - 1) == '\n') {
                return i3;
            }
            i3--;
        }
        return 0;
    }

    public static final long c(CharSequence charSequence, int i3) {
        return TextRangeKt.b(b(charSequence, i3), a(charSequence, i3));
    }
}
