package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
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
public interface RowColumnMeasurePolicy {
    static /* synthetic */ long h(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i3, int i4, int i5, int i6, boolean z2, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConstraints-xF2OJ5Q");
        }
        if ((i7 & 16) != 0) {
            z2 = false;
        }
        return rowColumnMeasurePolicy.a(i3, i4, i5, i6, z2);
    }

    long a(int i3, int i4, int i5, int i6, boolean z2);

    void c(int i3, int[] iArr, int[] iArr2, MeasureScope measureScope);

    MeasureResult d(Placeable[] placeableArr, MeasureScope measureScope, int i3, int[] iArr, int i4, int i5, int[] iArr2, int i6, int i7, int i8);

    int e(Placeable placeable);

    int f(Placeable placeable);
}
