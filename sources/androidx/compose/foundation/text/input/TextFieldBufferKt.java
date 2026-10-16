package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class TextFieldBufferKt {
    public static final long a(long j3, int i3, int i4, int i5) {
        int i6;
        int iL = TextRange.l(j3);
        int iK = TextRange.k(j3);
        if (iK < i3) {
            return j3;
        }
        if (iL <= i3 && i4 <= iK) {
            i6 = i5 - (i4 - i3);
            if (iL == iK) {
                iL += i6;
            }
            i3 = iK + i6;
        } else if (iL > i3 && iK < i4) {
            i3 += i5;
            iL = i3;
        } else if (iL >= i4) {
            i6 = i5 - (i4 - i3);
            iL += i6;
            i3 = iK + i6;
        } else if (i3 < iL) {
            iL = i3 + i5;
            i6 = i5 - (i4 - i3);
            i3 = iK + i6;
        }
        return TextRangeKt.b(iL, i3);
    }

    public static final void b(TextFieldBuffer textFieldBuffer, int i3, int i4) {
        textFieldBuffer.p(i3, i4, "");
    }

    public static final void c(TextFieldBuffer textFieldBuffer, int i3, int i4) {
        textFieldBuffer.x(TextRangeKt.b(RangesKt.p(i3, 0, textFieldBuffer.j()), RangesKt.p(i4, 0, textFieldBuffer.j())));
    }

    public static /* synthetic */ void d(TextFieldBuffer textFieldBuffer, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = i3;
        }
        c(textFieldBuffer, i3, i4);
    }
}
