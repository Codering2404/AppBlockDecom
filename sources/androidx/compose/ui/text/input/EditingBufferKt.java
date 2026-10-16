package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class EditingBufferKt {
    public static final long a(long j3, long j4) {
        int iJ;
        int iL = TextRange.l(j3);
        int iK = TextRange.k(j3);
        if (TextRange.p(j4, j3)) {
            if (TextRange.d(j4, j3)) {
                iL = TextRange.l(j4);
                iK = iL;
            } else {
                if (TextRange.d(j3, j4)) {
                    iJ = TextRange.j(j4);
                } else if (TextRange.e(j4, iL)) {
                    iL = TextRange.l(j4);
                    iJ = TextRange.j(j4);
                } else {
                    iK = TextRange.l(j4);
                }
                iK -= iJ;
            }
        } else if (iK > TextRange.l(j4)) {
            iL -= TextRange.j(j4);
            iJ = TextRange.j(j4);
            iK -= iJ;
        }
        return TextRangeKt.b(iL, iK);
    }
}
