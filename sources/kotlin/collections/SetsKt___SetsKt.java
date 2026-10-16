package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static <T> Set<T> minus(Set<? extends T> set, T t2) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(set.size()));
        boolean z2 = false;
        for (T t3 : set) {
            boolean z3 = true;
            if (!z2 && Intrinsics.areEqual(t3, t2)) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                linkedHashSet.add(t3);
            }
        }
        return linkedHashSet;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> set, T t2) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return minus(set, t2);
    }

    public static <T> Set<T> plus(Set<? extends T> set, T t2) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t2);
        return linkedHashSet;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> set, T t2) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return plus(set, t2);
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T[] elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(set.size() + elements.length));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T[] elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Integer numCollectionSizeOrNull = CollectionsKt__IterablesKt.collectionSizeOrNull(elements);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> collectionConvertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(elements);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return CollectionsKt___CollectionsKt.toSet(set);
        }
        if (collectionConvertToListIfNotCollection instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : set) {
                if (!((Set) collectionConvertToListIfNotCollection).contains(t2)) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(collectionConvertToListIfNotCollection);
        return linkedHashSet2;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }
}
