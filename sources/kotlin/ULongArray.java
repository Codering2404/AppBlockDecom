package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@JvmInline
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f139798a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f139799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f139800b;

        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f139799a = array;
        }

        public long a() {
            int i3 = this.f139800b;
            long[] jArr = this.f139799a;
            if (i3 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f139800b));
            }
            this.f139800b = i3 + 1;
            return ULong.b(jArr[i3]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f139800b < this.f139799a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.f139798a = jArr;
    }

    public static final /* synthetic */ ULongArray a(long[] jArr) {
        return new ULongArray(jArr);
    }

    public static long[] b(int i3) {
        return d(new long[i3]);
    }

    public static long[] d(long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean f(long[] jArr, long j3) {
        return ArraysKt.contains(jArr, j3);
    }

    public static boolean g(long[] jArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof ULong) || !ArraysKt.contains(jArr, ((ULong) obj).g())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).v());
    }

    public static final long l(long[] jArr, int i3) {
        return ULong.b(jArr[i3]);
    }

    public static int o(long[] jArr) {
        return jArr.length;
    }

    public static int p(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean q(long[] jArr) {
        return jArr.length == 0;
    }

    public static java.util.Iterator s(long[] jArr) {
        return new Iterator(jArr);
    }

    public static final void t(long[] jArr, int i3, long j3) {
        jArr[i3] = j3;
    }

    public static String u(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return e(((ULong) obj).g());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return g(this.f139798a, elements);
    }

    public boolean e(long j3) {
        return f(this.f139798a, j3);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return h(this.f139798a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return p(this.f139798a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return q(this.f139798a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return s(this.f139798a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f139798a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public String toString() {
        return u(this.f139798a);
    }

    public final /* synthetic */ long[] v() {
        return this.f139798a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
