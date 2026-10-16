package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
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
public final class MathUtilsKt {
    private static final float a(long j3, Rect rect) {
        if (SelectionManagerKt.d(rect, j3)) {
            return 0.0f;
        }
        float fL = Offset.l(Offset.p(rect.t(), j3));
        if (fL >= Float.MAX_VALUE) {
            fL = Float.MAX_VALUE;
        }
        float fL2 = Offset.l(Offset.p(rect.u(), j3));
        if (fL2 < fL) {
            fL = fL2;
        }
        float fL3 = Offset.l(Offset.p(rect.k(), j3));
        if (fL3 < fL) {
            fL = fL3;
        }
        float fL4 = Offset.l(Offset.p(rect.l(), j3));
        return fL4 < fL ? fL4 : fL;
    }

    public static final int b(long j3, Rect rect, Rect rect2) {
        float fA = a(j3, rect);
        float fA2 = a(j3, rect2);
        if (fA == fA2) {
            return 0;
        }
        return fA < fA2 ? -1 : 1;
    }
}
