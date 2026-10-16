package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1<T> implements Function1<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ Function1<T, K> $selector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public AnonymousClass1(Function1 function1, Comparable comparable) {
            this.$selector = function1;
            this.$key = comparable;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(T t2) {
            return Integer.valueOf(ComparisonsKt.d((Comparable) this.$selector.invoke(t2), this.$key));
        }
    }

    private static final <T> List<T> List(int i3, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(init.invoke(Integer.valueOf(i4)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int i3, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(init.invoke(Integer.valueOf(i4)));
        }
        return arrayList;
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> Collection<T> asCollection(T[] tArr, boolean z2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, z2);
    }

    public static /* synthetic */ Collection asCollection$default(Object[] objArr, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return asCollection(objArr, z2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i3, i4);
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iD = ComparisonsKt.d(list.get(i6), t2);
            if (iD < 0) {
                i3 = i6 + 1;
            } else {
                if (iD <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = list.size();
        }
        return binarySearch((List<? extends Comparable>) list, comparable, i3, i4);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k3, int i3, int i4, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return binarySearch(list, i3, i4, new AnonymousClass1(selector, k3));
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i3, int i4, Function1 selector, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = list.size();
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return binarySearch(list, i3, i4, new AnonymousClass1(selector, comparable));
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listCreateListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        builderAction.invoke(listCreateListBuilder);
        return CollectionsKt__CollectionsJVMKt.build(listCreateListBuilder);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int i3 = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return objArr;
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.containsAll(elements);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection collection, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return !collection.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt___ArraysJvmKt.asList(elements) : emptyList();
    }

    public static <T> List<T> listOfNotNull(T t2) {
        return t2 != null ? CollectionsKt__CollectionsJVMKt.listOf(t2) : emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : CollectionsKt__CollectionsJVMKt.listOf(list.get(0)) : emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? emptyList() : collection;
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i3, int i4, int i5) {
        if (i4 > i5) {
            throw new IllegalArgumentException("fromIndex (" + i4 + ") is greater than toIndex (" + i5 + ").");
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i4 + ") is less than zero.");
        }
        if (i5 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + i3 + ").");
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        CollectionsKt___CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(asCollection(elements, true));
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i3, int i4, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = list.size();
        }
        return binarySearch(list, obj, comparator, i3, i4);
    }

    private static final <E> List<E> buildList(int i3, Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listCreateListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(i3);
        builderAction.invoke(listCreateListBuilder);
        return CollectionsKt__CollectionsJVMKt.build(listCreateListBuilder);
    }

    private static final <T> List<T> listOf() {
        return emptyList();
    }

    public static <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.filterNotNull(elements);
    }

    public static <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(asCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? emptyList() : list;
    }

    public static /* synthetic */ int binarySearch$default(List list, int i3, int i4, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = list.size();
        }
        return binarySearch(list, i3, i4, function1);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t2, Comparator<? super T> comparator, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i3, i4);
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iCompare = comparator.compare(list.get(i6), t2);
            if (iCompare < 0) {
                i3 = i6 + 1;
            } else {
                if (iCompare <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        int i3 = 0;
        if (collection.isEmpty()) {
            return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(0, array);
        }
        int length = array.length;
        Object[] objArr = array;
        if (length < collection.size()) {
            objArr = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(array, collection.size());
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(collection.size(), objArr);
    }

    public static <T> int binarySearch(List<? extends T> list, int i3, int i4, Function1<? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i3, i4);
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iIntValue = ((Number) comparison.invoke(list.get(i6))).intValue();
            if (iIntValue < 0) {
                i3 = i6 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }
}
