package androidx.compose.foundation.lazy.layout;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class LazyLayoutMeasuredItemKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f8147a = new Comparator() { // from class: androidx.compose.foundation.lazy.layout.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LazyLayoutMeasuredItemKt.b((LazyLayoutMeasuredItem) obj, (LazyLayoutMeasuredItem) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, LazyLayoutMeasuredItem lazyLayoutMeasuredItem2) {
        return Intrinsics.compare(lazyLayoutMeasuredItem.getIndex(), lazyLayoutMeasuredItem2.getIndex());
    }

    public static final List c(int i3, int i4, List list, List list2) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt.toMutableList((Collection) list2);
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem = (LazyLayoutMeasuredItem) list.get(i5);
            int index = lazyLayoutMeasuredItem.getIndex();
            if (i3 <= index && index <= i4) {
                mutableList.add(lazyLayoutMeasuredItem);
            }
        }
        CollectionsKt.sortWith(mutableList, f8147a);
        return mutableList;
    }
}
