package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NonEmptyList<A> implements List<A>, KMappedMarker {
    public static final int $stable = 8;
    private final List<A> all;

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptyList(List<? extends A> list) {
        this.all = list;
    }

    @Override // java.util.List
    public void add(int i3, A a3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(A a3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(A a3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.all.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.all.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return obj instanceof NonEmptyList ? Intrinsics.areEqual(this.all, ((NonEmptyList) obj).all) : Intrinsics.areEqual(this.all, obj);
    }

    @Override // java.util.List
    public A get(int i3) {
        return this.all.get(i3);
    }

    public final /* synthetic */ Object getHead() {
        return CollectionsKt.first((List) this.all);
    }

    public int getSize() {
        return this.all.size();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.all.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.all.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<A> iterator() {
        return this.all.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.all.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<A> listIterator() {
        return this.all.listIterator();
    }

    public final /* synthetic */ NonEmptyList map(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return new NonEmptyList(arrayList);
    }

    public final /* synthetic */ NonEmptyList mapIndexed(Function2 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i3), obj));
            i3 = i4;
        }
        return new NonEmptyList(arrayList);
    }

    @Override // java.util.List
    public A remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<A> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public A set(int i3, A a3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super A> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<A> subList(int i3, int i4) {
        return this.all.subList(i3, i4);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final /* synthetic */ List toList() {
        return this.all;
    }

    public String toString() {
        return "NonEmptyList(" + CollectionsKt.joinToString$default(this.all, null, null, null, 0, null, null, 63, null) + ')';
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(A a3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public ListIterator<A> listIterator(int i3) {
        return this.all.listIterator(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptyList(A a3, List<? extends A> tail) {
        this(CollectionsKt.plus((Collection) CollectionsKt.listOf(a3), (Iterable) tail));
        Intrinsics.checkNotNullParameter(tail, "tail");
    }
}
