package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> grouping, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(kKeyOf);
            linkedHashMap.put(kKeyOf, operation.invoke(kKeyOf, obj, next, Boolean.valueOf(obj == null && !linkedHashMap.containsKey(kKeyOf))));
        }
        return linkedHashMap;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> grouping, M destination, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object obj = destination.get(kKeyOf);
            destination.put(kKeyOf, operation.invoke(kKeyOf, obj, next, Boolean.valueOf(obj == null && !destination.containsKey(kKeyOf))));
        }
        return destination;
    }

    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> grouping, M destination) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            K kKeyOf = grouping.keyOf(itSourceIterator.next());
            Object obj = destination.get(kKeyOf);
            if (obj == null && !destination.containsKey(kKeyOf)) {
                obj = 0;
            }
            destination.put(kKeyOf, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, Function2<? super K, ? super T, ? extends R> initialValueSelector, Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        Intrinsics.checkNotNullParameter(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object objInvoke = linkedHashMap.get(kKeyOf);
            if (objInvoke == null && !linkedHashMap.containsKey(kKeyOf)) {
                objInvoke = initialValueSelector.invoke(kKeyOf, next);
            }
            linkedHashMap.put(kKeyOf, operation.invoke(kKeyOf, objInvoke, next));
        }
        return linkedHashMap;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M destination, Function2<? super K, ? super T, ? extends R> initialValueSelector, Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object objInvoke = destination.get(kKeyOf);
            if (objInvoke == null && !destination.containsKey(kKeyOf)) {
                objInvoke = initialValueSelector.invoke(kKeyOf, next);
            }
            destination.put(kKeyOf, operation.invoke(kKeyOf, objInvoke, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> grouping, Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object next = itSourceIterator.next();
            Object objKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(objKeyOf);
            if (!(obj == null && !linkedHashMap.containsKey(objKeyOf))) {
                next = operation.invoke(objKeyOf, obj, next);
            }
            linkedHashMap.put(objKeyOf, next);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> grouping, M destination, Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object next = itSourceIterator.next();
            Object objKeyOf = grouping.keyOf(next);
            Object obj = destination.get(objKeyOf);
            if (!(obj == null && !destination.containsKey(objKeyOf))) {
                next = operation.invoke(objKeyOf, obj, next);
            }
            destination.put(objKeyOf, next);
        }
        return destination;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M destination, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object obj = destination.get(kKeyOf);
            if (obj == null && !destination.containsKey(kKeyOf)) {
                obj = r2;
            }
            destination.put(kKeyOf, operation.invoke(obj, next));
        }
        return destination;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(kKeyOf);
            if (obj == null && !linkedHashMap.containsKey(kKeyOf)) {
                obj = r2;
            }
            linkedHashMap.put(kKeyOf, operation.invoke(obj, next));
        }
        return linkedHashMap;
    }
}
