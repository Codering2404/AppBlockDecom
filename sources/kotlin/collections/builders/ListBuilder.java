package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

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
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = new Companion(null);
    private static final ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            public Itr(BuilderSubList<E> list, int i3) {
                Intrinsics.checkNotNullParameter(list, "list");
                this.list = list;
                this.index = i3;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) list).modCount;
            }

            private final void checkForComodification() {
                if (((AbstractList) ((BuilderSubList) this.list).root).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(E e3) {
                checkForComodification();
                BuilderSubList<E> builderSubList = this.list;
                int i3 = this.index;
                this.index = i3 + 1;
                builderSubList.add(i3, e3);
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.index < ((BuilderSubList) this.list).length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                checkForComodification();
                if (this.index >= ((BuilderSubList) this.list).length) {
                    throw new NoSuchElementException();
                }
                int i3 = this.index;
                this.index = i3 + 1;
                this.lastIndex = i3;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public E previous() {
                checkForComodification();
                int i3 = this.index;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.index = i4;
                this.lastIndex = i4;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                checkForComodification();
                int i3 = this.lastIndex;
                if (i3 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.list.removeAt(i3);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
            }

            @Override // java.util.ListIterator
            public void set(E e3) {
                checkForComodification();
                int i3 = this.lastIndex;
                if (i3 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.list.set(i3, e3);
            }
        }

        public BuilderSubList(E[] backing, int i3, int i4, BuilderSubList<E> builderSubList, ListBuilder<E> root) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            Intrinsics.checkNotNullParameter(root, "root");
            this.backing = backing;
            this.offset = i3;
            this.length = i4;
            this.parent = builderSubList;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void addAllInternal(int i3, Collection<? extends E> collection, int i4) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAllInternal(i3, collection, i4);
            } else {
                this.root.addAllInternal(i3, collection, i4);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i4;
        }

        private final void addAtInternal(int i3, E e3) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAtInternal(i3, e3);
            } else {
                this.root.addAtInternal(i3, e3);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void checkIsMutable() {
            if (isReadOnly()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean contentEquals(List<?> list) {
            return ListBuilderKt.subarrayContentEquals(this.backing, this.offset, this.length, list);
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        private final E removeAtInternal(int i3) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            this.length--;
            return builderSubList != null ? builderSubList.removeAtInternal(i3) : (E) this.root.removeAtInternal(i3);
        }

        private final void removeRangeInternal(int i3, int i4) {
            if (i4 > 0) {
                registerModification();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.removeRangeInternal(i3, i4);
            } else {
                this.root.removeRangeInternal(i3, i4);
            }
            this.length -= i4;
        }

        private final int retainOrRemoveAllInternal(int i3, int i4, Collection<? extends E> collection, boolean z2) {
            BuilderSubList<E> builderSubList = this.parent;
            int iRetainOrRemoveAllInternal = builderSubList != null ? builderSubList.retainOrRemoveAllInternal(i3, i4, collection, z2) : this.root.retainOrRemoveAllInternal(i3, i4, collection, z2);
            if (iRetainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length -= iRetainOrRemoveAllInternal;
            return iRetainOrRemoveAllInternal;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e3) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, e3);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            int size = elements.size();
            addAllInternal(this.offset + this.length, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            checkForComodification();
            if (obj != this) {
                return (obj instanceof List) && contentEquals((List) obj);
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i3) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
            return this.backing[this.offset + i3];
        }

        @Override // kotlin.collections.AbstractMutableList
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            checkForComodification();
            for (int i3 = 0; i3 < this.length; i3++) {
                if (Intrinsics.areEqual(this.backing[this.offset + i3], obj)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            checkForComodification();
            for (int i3 = this.length - 1; i3 >= 0; i3--) {
                if (Intrinsics.areEqual(this.backing[this.offset + i3], obj)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            checkIsMutable();
            checkForComodification();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                removeAt(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int i3) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
            return removeAtInternal(this.offset + i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int i3, E e3) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
            E[] eArr = this.backing;
            int i4 = this.offset;
            E e4 = eArr[i4 + i3];
            eArr[i4 + i3] = e3;
            return e4;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i3, int i4) {
            kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, this.length);
            return new BuilderSubList(this.backing, this.offset + i3, i4 - i3, this, this.root);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            checkForComodification();
            int length = array.length;
            int i3 = this.length;
            if (length >= i3) {
                E[] eArr = this.backing;
                int i4 = this.offset;
                ArraysKt.copyInto(eArr, array, 0, i4, i3 + i4);
                return (T[]) CollectionsKt.terminateCollectionToArray(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i5 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i5, i3 + i5, array.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
            return tArr;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return ListBuilderKt.subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i3) {
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
            return new Itr(this, i3);
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int i3, E e3) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
            addAtInternal(this.offset + i3, e3);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i3, Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
            int size = elements.size();
            addAllInternal(this.offset + i3, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] eArr = this.backing;
            int i3 = this.offset;
            return ArraysKt.copyOfRange(eArr, i3, this.length + i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> list, int i3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i3;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.list).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e3) {
            checkForComodification();
            ListBuilder<E> listBuilder = this.list;
            int i3 = this.index;
            this.index = i3 + 1;
            listBuilder.add(i3, e3);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i3 = this.index;
            this.index = i3 + 1;
            this.lastIndex = i3;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int i3 = this.index;
            if (i3 <= 0) {
                throw new NoSuchElementException();
            }
            int i4 = i3 - 1;
            this.index = i4;
            this.lastIndex = i4;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int i3 = this.lastIndex;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.list.removeAt(i3);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E e3) {
            checkForComodification();
            int i3 = this.lastIndex;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.list.set(i3, e3);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAllInternal(int i3, Collection<? extends E> collection, int i4) {
        registerModification();
        insertAtInternal(i3, i4);
        Iterator<? extends E> it = collection.iterator();
        for (int i5 = 0; i5 < i4; i5++) {
            this.backing[i3 + i5] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAtInternal(int i3, E e3) {
        registerModification();
        insertAtInternal(i3, 1);
        this.backing[i3] = e3;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.subarrayContentEquals(this.backing, 0, this.length, list);
    }

    private final void ensureCapacityInternal(int i3) {
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (i3 > eArr.length) {
            this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, kotlin.collections.AbstractList.Companion.newCapacity$kotlin_stdlib(eArr.length, i3));
        }
    }

    private final void ensureExtraCapacity(int i3) {
        ensureCapacityInternal(this.length + i3);
    }

    private final void insertAtInternal(int i3, int i4) {
        ensureExtraCapacity(i4);
        E[] eArr = this.backing;
        ArraysKt.copyInto(eArr, eArr, i3 + i4, i3, this.length);
        this.length += i4;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E removeAtInternal(int i3) {
        registerModification();
        E[] eArr = this.backing;
        E e3 = eArr[i3];
        ArraysKt.copyInto(eArr, eArr, i3, i3 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return e3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeRangeInternal(int i3, int i4) {
        if (i4 > 0) {
            registerModification();
        }
        E[] eArr = this.backing;
        ArraysKt.copyInto(eArr, eArr, i3, i3 + i4, this.length);
        E[] eArr2 = this.backing;
        int i5 = this.length;
        ListBuilderKt.resetRange(eArr2, i5 - i4, i5);
        this.length -= i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int retainOrRemoveAllInternal(int i3, int i4, Collection<? extends E> collection, boolean z2) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = i3 + i5;
            if (collection.contains(this.backing[i7]) == z2) {
                E[] eArr = this.backing;
                i5++;
                eArr[i6 + i3] = eArr[i7];
                i6++;
            } else {
                i5++;
            }
        }
        int i8 = i4 - i6;
        E[] eArr2 = this.backing;
        ArraysKt.copyInto(eArr2, eArr2, i3 + i6, i4 + i3, this.length);
        E[] eArr3 = this.backing;
        int i9 = this.length;
        ListBuilderKt.resetRange(eArr3, i9 - i8, i9);
        if (i8 > 0) {
            registerModification();
        }
        this.length -= i8;
        return i8;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e3) {
        checkIsMutable();
        addAtInternal(this.length, e3);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && contentEquals((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
        return this.backing[i3];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (Intrinsics.areEqual(this.backing[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i3 = this.length - 1; i3 >= 0; i3--) {
            if (Intrinsics.areEqual(this.backing[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            removeAt(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i3) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
        return removeAtInternal(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i3, E e3) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, this.length);
        E[] eArr = this.backing;
        E e4 = eArr[i3];
        eArr[i3] = e3;
        return e4;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i3, int i4) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, this.length);
        return new BuilderSubList(this.backing, i3, i4 - i3, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i3 = this.length;
        if (length >= i3) {
            ArraysKt.copyInto(this.backing, array, 0, 0, i3);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i3, array.getClass());
        Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.subarrayContentToString(this.backing, 0, this.length, this);
    }

    public ListBuilder(int i3) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i3) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
        return new Itr(this, i3);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i3, E e3) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
        addAtInternal(i3, e3);
    }

    public /* synthetic */ ListBuilder(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 10 : i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, this.length);
        int size = elements.size();
        addAllInternal(i3, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }
}
