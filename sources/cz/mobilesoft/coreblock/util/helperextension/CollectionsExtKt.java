package cz.mobilesoft.coreblock.util.helperextension;

import android.util.LongSparseArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CollectionsExtKt {
    public static final boolean a(Collection collection, Collection elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Set set = elements instanceof Set ? (Set) elements : CollectionsKt.toSet(elements);
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return false;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (set.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(Collection collection, Object... elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return a(collection, ArraysKt.toSet(elements));
    }

    public static final int c(LongSparseArray longSparseArray, Object obj, boolean z2) {
        Intrinsics.checkNotNullParameter(longSparseArray, "<this>");
        if (z2) {
            for (int size = longSparseArray.size() - 1; -1 < size; size--) {
                Object objValueAt = longSparseArray.valueAt(size);
                if (objValueAt != null && objValueAt.equals(obj)) {
                    return size;
                }
            }
        } else {
            int size2 = longSparseArray.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Object objValueAt2 = longSparseArray.valueAt(i3);
                if (objValueAt2 != null && objValueAt2.equals(obj)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static final Collection d(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (collection.isEmpty()) {
            return null;
        }
        return collection;
    }
}
