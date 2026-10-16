package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextRangeKt {
    public static final long a(int i3) {
        return b(i3, i3);
    }

    public static final long b(int i3, int i4) {
        return TextRange.c(d(i3, i4));
    }

    public static final long c(long j3, int i3, int i4) {
        int iN = TextRange.n(j3);
        if (iN < i3) {
            iN = i3;
        }
        if (iN > i4) {
            iN = i4;
        }
        int i5 = TextRange.i(j3);
        if (i5 >= i3) {
            i3 = i5;
        }
        if (i3 <= i4) {
            i4 = i3;
        }
        return (iN == TextRange.n(j3) && i4 == TextRange.i(j3)) ? j3 : b(iN, i4);
    }

    private static final long d(int i3, int i4) {
        if (!(i3 >= 0 && i4 >= 0)) {
            InlineClassHelperKt.a("start and end cannot be negative. [start: " + i3 + ", end: " + i4 + ']');
        }
        return (((long) i4) & 4294967295L) | (((long) i3) << 32);
    }

    public static final String e(CharSequence charSequence, long j3) {
        return charSequence.subSequence(TextRange.l(j3), TextRange.k(j3)).toString();
    }
}
