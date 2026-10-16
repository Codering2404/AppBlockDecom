package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final int maxArraySize = 2147483639;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int i3, int i4, int i5) {
            if (i3 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("startIndex: " + i3 + ", endIndex: " + i4 + ", size: " + i5);
            }
            if (i3 <= i4) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i3 + " > endIndex: " + i4);
        }

        public final void checkElementIndex$kotlin_stdlib(int i3, int i4) {
            if (i3 < 0 || i3 >= i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i3, int i4) {
            if (i3 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i3, int i4, int i5) {
            if (i3 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("fromIndex: " + i3 + ", toIndex: " + i4 + ", size: " + i5);
            }
            if (i3 <= i4) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i3 + " > toIndex: " + i4);
        }

        public final int newCapacity$kotlin_stdlib(int i3, int i4) {
            int i5 = i3 + (i3 >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            return i5 - AbstractList.maxArraySize > 0 ? i4 > AbstractList.maxArraySize ? Api.BaseClientBuilder.API_PRIORITY_OTHER : AbstractList.maxArraySize : i5;
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> c3, Collection<?> other) {
            Intrinsics.checkNotNullParameter(c3, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            if (c3.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c3.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> c3) {
            Intrinsics.checkNotNullParameter(c3, "c");
            Iterator<?> it = c3.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;

        public IteratorImpl() {
        }

        protected final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            int i3 = this.index;
            this.index = i3 + 1;
            return abstractList.get(i3);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        protected final void setIndex(int i3) {
            this.index = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        public ListIteratorImpl(int i3) {
            super();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, AbstractList.this.size());
            setIndex(i3);
        }

        @Override // java.util.ListIterator
        public void add(E e3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return getIndex() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            setIndex(getIndex() - 1);
            return abstractList.get(getIndex());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> list, int i3, int i4) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.fromIndex = i3;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, list.size());
            this._size = i4 - i3;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i3) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this._size);
            return this.list.get(this.fromIndex + i3);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this._size;
        }

        @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
        public List<E> subList(int i3, int i4) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, this._size);
            AbstractList<E> abstractList = this.list;
            int i5 = this.fromIndex;
            return new SubList(abstractList, i3 + i5, i5 + i4);
        }
    }

    protected AbstractList() {
    }

    @Override // java.util.List
    public void add(int i3, E e3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i3);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), obj)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public E remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i3, E e3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i3, int i4) {
        return new SubList(this, i3, i4);
    }

    public ListIterator<E> listIterator(int i3) {
        return new ListIteratorImpl(i3);
    }
}
