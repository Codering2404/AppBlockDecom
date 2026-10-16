package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
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
public final class IntervalListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(MutableVector mutableVector, int i3) {
        int iO = mutableVector.o() - 1;
        int i4 = 0;
        while (i4 < iO) {
            int i5 = ((iO - i4) / 2) + i4;
            int iB = ((IntervalList.Interval) mutableVector.f24389a[i5]).b();
            if (iB != i3) {
                if (iB < i3) {
                    i4 = i5 + 1;
                    if (i3 < ((IntervalList.Interval) mutableVector.f24389a[i4]).b()) {
                    }
                } else {
                    iO = i5 - 1;
                }
            }
            return i5;
        }
        return i4;
    }
}
