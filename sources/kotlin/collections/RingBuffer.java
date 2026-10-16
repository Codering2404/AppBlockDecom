package kotlin.collections;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
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
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (i3 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i3).toString());
        }
        if (i3 <= buffer.length) {
            this.capacity = buffer.length;
            this.size = i3;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i3 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    private final int forward(int i3, int i4) {
        return (i3 + i4) % this.capacity;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t2) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = t2;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int i3) {
        Object[] array;
        int i4 = this.capacity;
        int iK = RangesKt.k(i4 + (i4 >> 1) + 1, i3);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, iK);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iK]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i3, size());
        return (T) this.buffer[(this.startIndex + i3) % this.capacity];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer.iterator.1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            {
                this.this$0 = this;
                this.count = this.size();
                this.index = ((RingBuffer) this).startIndex;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                if (this.count == 0) {
                    done();
                    return;
                }
                setNext(((RingBuffer) this.this$0).buffer[this.index]);
                this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                this.count--;
            }
        };
    }

    public final void removeFirst(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i3).toString());
        }
        if (i3 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i3 + ", size = " + size()).toString());
        }
        if (i3 > 0) {
            int i4 = this.startIndex;
            int i5 = (i4 + i3) % this.capacity;
            if (i4 > i5) {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i4, this.capacity);
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, 0, i5);
            } else {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i4, i5);
            }
            this.startIndex = i5;
            this.size = size() - i3;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, tDEtWsFLJfe.SJlGPADNcFatfU);
        int length = tArr.length;
        Object[] objArr = tArr;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = this.startIndex; i4 < size && i5 < this.capacity; i5++) {
            objArr[i4] = this.buffer[i5];
            i4++;
        }
        while (i4 < size) {
            objArr[i4] = this.buffer[i3];
            i4++;
            i3++;
        }
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(size, objArr);
    }

    public RingBuffer(int i3) {
        this(new Object[i3], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
