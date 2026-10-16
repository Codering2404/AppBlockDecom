package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private int head;
    private int size;
    public static final Companion Companion = new Companion(null);
    private static final Object[] emptyElementData = new Object[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ArrayDeque(int i3) {
        Object[] objArr;
        if (i3 == 0) {
            objArr = emptyElementData;
        } else {
            if (i3 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i3);
            }
            objArr = new Object[i3];
        }
        this.elementData = objArr;
    }

    private final void copyCollectionElements(int i3, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (i3 < length && it.hasNext()) {
            this.elementData[i3] = it.next();
            i3++;
        }
        int i4 = this.head;
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            this.elementData[i5] = it.next();
        }
        this.size = size() + collection.size();
    }

    private final void copyElements(int i3) {
        Object[] objArr = new Object[i3];
        Object[] objArr2 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i4 = this.head;
        ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr, length - i4, 0, i4);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int i3) {
        return i3 == 0 ? ArraysKt___ArraysKt.getLastIndex(this.elementData) : i3 - 1;
    }

    private final void ensureCapacity(int i3) {
        if (i3 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (i3 <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            this.elementData = new Object[RangesKt.f(i3, 10)];
        } else {
            copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(objArr.length, i3));
        }
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> function1) {
        int iPositiveMod;
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.head + size());
            int i3 = this.head;
            if (i3 < iPositiveMod2) {
                iPositiveMod = i3;
                while (i3 < iPositiveMod2) {
                    Object obj = this.elementData[i3];
                    if (((Boolean) function1.invoke(obj)).booleanValue()) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z2 = true;
                    }
                    i3++;
                }
                ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, iPositiveMod, iPositiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z3 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (((Boolean) function1.invoke(obj2)).booleanValue()) {
                        this.elementData[i4] = obj2;
                        i4++;
                    } else {
                        z3 = true;
                    }
                    i3++;
                }
                iPositiveMod = positiveMod(i4);
                for (int i5 = 0; i5 < iPositiveMod2; i5++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (((Boolean) function1.invoke(obj3)).booleanValue()) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z2;
    }

    private final int incremented(int i3) {
        if (i3 == ArraysKt___ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return i3 + 1;
    }

    private final E internalGet(int i3) {
        return (E) this.elementData[i3];
    }

    private final int internalIndex(int i3) {
        return positiveMod(this.head + i3);
    }

    private final int negativeMod(int i3) {
        return i3 < 0 ? i3 + this.elementData.length : i3;
    }

    private final void nullifyNonEmpty(int i3, int i4) {
        if (i3 < i4) {
            ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i3, i4);
            return;
        }
        Object[] objArr = this.elementData;
        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i3, objArr.length);
        ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, 0, i4);
    }

    private final int positiveMod(int i3) {
        Object[] objArr = this.elementData;
        return i3 >= objArr.length ? i3 - objArr.length : i3;
    }

    private final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    private final void removeRangeShiftPreceding(int i3, int i4) {
        int iPositiveMod = positiveMod(this.head + (i3 - 1));
        int iPositiveMod2 = positiveMod(this.head + (i4 - 1));
        while (i3 > 0) {
            int i5 = iPositiveMod + 1;
            int iMin = Math.min(i3, Math.min(i5, iPositiveMod2 + 1));
            Object[] objArr = this.elementData;
            int i6 = iPositiveMod2 - iMin;
            int i7 = iPositiveMod - iMin;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i6 + 1, i7 + 1, i5);
            iPositiveMod = negativeMod(i7);
            iPositiveMod2 = negativeMod(i6);
            i3 -= iMin;
        }
    }

    private final void removeRangeShiftSucceeding(int i3, int i4) {
        int iPositiveMod = positiveMod(this.head + i4);
        int iPositiveMod2 = positiveMod(this.head + i3);
        int size = size();
        while (true) {
            size -= i4;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            i4 = Math.min(size, Math.min(objArr.length - iPositiveMod, objArr.length - iPositiveMod2));
            Object[] objArr2 = this.elementData;
            int i5 = iPositiveMod + i4;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, iPositiveMod2, iPositiveMod, i5);
            iPositiveMod = positiveMod(i5);
            iPositiveMod2 = positiveMod(iPositiveMod2 + i4);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e3) {
        addLast(e3);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E e3) {
        registerModification();
        ensureCapacity(size() + 1);
        int iDecremented = decremented(this.head);
        this.head = iDecremented;
        this.elementData[iDecremented] = e3;
        this.size = size() + 1;
    }

    public final void addLast(E e3) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e3;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, size());
        return (E) this.elementData[positiveMod(this.head + i3)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i3;
        int iPositiveMod = positiveMod(this.head + size());
        int length = this.head;
        if (length < iPositiveMod) {
            while (length < iPositiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[length])) {
                    i3 = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iPositiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (true) {
            if (length >= length2) {
                for (int i4 = 0; i4 < iPositiveMod; i4++) {
                    if (Intrinsics.areEqual(obj, this.elementData[i4])) {
                        length = i4 + this.elementData.length;
                        i3 = this.head;
                    }
                }
                return -1;
            }
            if (Intrinsics.areEqual(obj, this.elementData[length])) {
                i3 = this.head;
                break;
            }
            length++;
        }
        return length - i3;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        int i3;
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i3 = this.head) < positiveMod(this.head + size())) ? this.head : i3 - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i3;
        int iPositiveMod = positiveMod(this.head + size());
        int i4 = this.head;
        if (i4 < iPositiveMod) {
            lastIndex = iPositiveMod - 1;
            if (i4 <= lastIndex) {
                while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                    if (lastIndex != i4) {
                        lastIndex--;
                    }
                }
                i3 = this.head;
                return lastIndex - i3;
            }
            return -1;
        }
        if (i4 > iPositiveMod) {
            int i5 = iPositiveMod - 1;
            while (true) {
                if (-1 >= i5) {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(this.elementData);
                    int i6 = this.head;
                    if (i6 <= lastIndex) {
                        while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                            if (lastIndex != i6) {
                                lastIndex--;
                            }
                        }
                        i3 = this.head;
                    }
                } else {
                    if (Intrinsics.areEqual(obj, this.elementData[i5])) {
                        lastIndex = i5 + this.elementData.length;
                        i3 = this.head;
                        break;
                    }
                    i5--;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        int iPositiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.head + size());
            int i3 = this.head;
            if (i3 < iPositiveMod2) {
                iPositiveMod = i3;
                while (i3 < iPositiveMod2) {
                    Object obj = this.elementData[i3];
                    if (elements.contains(obj)) {
                        z2 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    }
                    i3++;
                }
                ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, iPositiveMod, iPositiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z3 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (elements.contains(obj2)) {
                        z3 = true;
                    } else {
                        this.elementData[i4] = obj2;
                        i4++;
                    }
                    i3++;
                }
                iPositiveMod = positiveMod(i4);
                for (int i5 = 0; i5 < iPositiveMod2; i5++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (elements.contains(obj3)) {
                        z3 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    }
                }
                z2 = z3;
            }
            if (z2) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z2;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, size());
        if (i3 == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i3 == 0) {
            return removeFirst();
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + i3);
        E e3 = (E) this.elementData[iPositiveMod];
        if (i3 < (size() >> 1)) {
            int i4 = this.head;
            if (iPositiveMod >= i4) {
                Object[] objArr = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i4 + 1, i4, iPositiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, iPositiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i5 = this.head;
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i5 + 1, i5, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i6 = this.head;
            objArr4[i6] = null;
            this.head = incremented(i6);
        } else {
            int iPositiveMod2 = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
            if (iPositiveMod <= iPositiveMod2) {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, iPositiveMod, iPositiveMod + 1, iPositiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, iPositiveMod, iPositiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, iPositiveMod2 + 1);
            }
            this.elementData[iPositiveMod2] = null;
        }
        this.size = size() - 1;
        return e3;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i3 = this.head;
        E e3 = (E) objArr[i3];
        objArr[i3] = null;
        this.head = incremented(i3);
        this.size = size() - 1;
        return e3;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
        Object[] objArr = this.elementData;
        E e3 = (E) objArr[iPositiveMod];
        objArr[iPositiveMod] = null;
        this.size = size() - 1;
        return e3;
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, size());
        int i5 = i4 - i3;
        if (i5 == 0) {
            return;
        }
        if (i5 == size()) {
            clear();
            return;
        }
        if (i5 == 1) {
            removeAt(i3);
            return;
        }
        registerModification();
        if (i3 < size() - i4) {
            removeRangeShiftPreceding(i3, i4);
            int iPositiveMod = positiveMod(this.head + i5);
            nullifyNonEmpty(this.head, iPositiveMod);
            this.head = iPositiveMod;
        } else {
            removeRangeShiftSucceeding(i3, i4);
            int iPositiveMod2 = positiveMod(this.head + size());
            nullifyNonEmpty(negativeMod(iPositiveMod2 - i5), iPositiveMod2);
        }
        this.size = size() - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        int iPositiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.head + size());
            int i3 = this.head;
            if (i3 < iPositiveMod2) {
                iPositiveMod = i3;
                while (i3 < iPositiveMod2) {
                    Object obj = this.elementData[i3];
                    if (elements.contains(obj)) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z2 = true;
                    }
                    i3++;
                }
                ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, iPositiveMod, iPositiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z3 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i4] = obj2;
                        i4++;
                    } else {
                        z3 = true;
                    }
                    i3++;
                }
                iPositiveMod = positiveMod(i4);
                for (int i5 = 0; i5 < iPositiveMod2; i5++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z2;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i3, E e3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, size());
        int iPositiveMod = positiveMod(this.head + i3);
        Object[] objArr = this.elementData;
        E e4 = (E) objArr[iPositiveMod];
        objArr[iPositiveMod] = e3;
        return e4;
    }

    public final void testRemoveRange$kotlin_stdlib(int i3, int i4) {
        removeRange(i3, i4);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(array, size());
        }
        T[] tArr = array;
        int iPositiveMod = positiveMod(this.head + size());
        int i3 = this.head;
        if (i3 < iPositiveMod) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, tArr, 0, i3, iPositiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(objArr, tArr, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, tArr, objArr2.length - this.head, 0, iPositiveMod);
        }
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(size(), tArr);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i3, E e3) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, size());
        if (i3 == size()) {
            addLast(e3);
            return;
        }
        if (i3 == 0) {
            addFirst(e3);
            return;
        }
        registerModification();
        ensureCapacity(size() + 1);
        int iPositiveMod = positiveMod(this.head + i3);
        if (i3 < ((size() + 1) >> 1)) {
            int iDecremented = decremented(iPositiveMod);
            int iDecremented2 = decremented(this.head);
            int i4 = this.head;
            if (iDecremented >= i4) {
                Object[] objArr = this.elementData;
                objArr[iDecremented2] = objArr[i4];
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i4, i4 + 1, iDecremented + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, iDecremented + 1);
            }
            this.elementData[iDecremented] = e3;
            this.head = iDecremented2;
        } else {
            int iPositiveMod2 = positiveMod(this.head + size());
            if (iPositiveMod < iPositiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, iPositiveMod + 1, iPositiveMod, iPositiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, iPositiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, iPositiveMod + 1, iPositiveMod, objArr6.length - 1);
            }
            this.elementData[iPositiveMod] = e3;
        }
        this.size = size() + 1;
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i3, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i3 == size()) {
            return addAll(elements);
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        int iPositiveMod = positiveMod(this.head + size());
        int iPositiveMod2 = positiveMod(this.head + i3);
        int size = elements.size();
        if (i3 < ((size() + 1) >> 1)) {
            int i4 = this.head;
            int length = i4 - size;
            if (iPositiveMod2 < i4) {
                Object[] objArr = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, length, i4, objArr.length);
                if (size >= iPositiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, iPositiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, iPositiveMod2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, length, i4, iPositiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i5 = iPositiveMod2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, length, i4, iPositiveMod2);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, length, i4, i4 + length2);
                    Object[] objArr7 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.head + length2, iPositiveMod2);
                }
            }
            this.head = length;
            copyCollectionElements(negativeMod(iPositiveMod2 - size), elements);
        } else {
            int i6 = iPositiveMod2 + size;
            if (iPositiveMod2 < iPositiveMod) {
                int i7 = size + iPositiveMod;
                Object[] objArr8 = this.elementData;
                if (i7 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6, iPositiveMod2, iPositiveMod);
                } else if (i6 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6 - objArr8.length, iPositiveMod2, iPositiveMod);
                } else {
                    int length3 = iPositiveMod - (i7 - objArr8.length);
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length3, iPositiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i6, iPositiveMod2, length3);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, iPositiveMod);
                Object[] objArr11 = this.elementData;
                if (i6 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i6 - objArr11.length, iPositiveMod2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i6, iPositiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(iPositiveMod2, elements);
        }
        return true;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
