package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.ui.unit.IntOffset;
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
public final class LazyGridSnapLayoutInfoProviderKt {
    public static final int a(LazyGridLayoutInfo lazyGridLayoutInfo) {
        return (int) (lazyGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyGridLayoutInfo.a() & 4294967295L : lazyGridLayoutInfo.a() >> 32);
    }

    public static final int b(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        return orientation == Orientation.f6031a ? IntOffset.l(lazyGridItemInfo.f()) : IntOffset.k(lazyGridItemInfo.f());
    }

    public static final int c(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        return (int) (orientation == Orientation.f6031a ? lazyGridItemInfo.a() & 4294967295L : lazyGridItemInfo.a() >> 32);
    }
}
