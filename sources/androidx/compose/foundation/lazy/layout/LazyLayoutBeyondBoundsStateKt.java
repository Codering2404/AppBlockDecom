package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;

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
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List a(LazyLayoutItemProvider lazyLayoutItemProvider, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo) {
        if (!lazyLayoutBeyondBoundsInfo.d() && lazyLayoutPinnedItemList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        IntRange intRange = lazyLayoutBeyondBoundsInfo.d() ? new IntRange(lazyLayoutBeyondBoundsInfo.c(), Math.min(lazyLayoutBeyondBoundsInfo.b(), lazyLayoutItemProvider.a() - 1)) : IntRange.f140218f.a();
        int size = lazyLayoutPinnedItemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            LazyLayoutPinnedItemList.PinnedItem pinnedItem = lazyLayoutPinnedItemList.get(i3);
            int iA = LazyLayoutItemProviderKt.a(lazyLayoutItemProvider, pinnedItem.getKey(), pinnedItem.getIndex());
            int iG = intRange.g();
            if ((iA > intRange.h() || iG > iA) && iA >= 0 && iA < lazyLayoutItemProvider.a()) {
                arrayList.add(Integer.valueOf(iA));
            }
        }
        int iG2 = intRange.g();
        int iH = intRange.h();
        if (iG2 <= iH) {
            while (true) {
                arrayList.add(Integer.valueOf(iG2));
                if (iG2 == iH) {
                    break;
                }
                iG2++;
            }
        }
        return arrayList;
    }
}
