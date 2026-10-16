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
public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f139793a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f139794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f139795b;

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f139794a = array;
        }

        public int a() {
            int i3 = this.f139795b;
            int[] iArr = this.f139794a;
            if (i3 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f139795b));
            }
            this.f139795b = i3 + 1;
            return UInt.b(iArr[i3]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f139795b < this.f139794a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.f139793a = iArr;
    }

    public static final /* synthetic */ UIntArray a(int[] iArr) {
        return new UIntArray(iArr);
    }

    public static int[] b(int i3) {
        return d(new int[i3]);
    }

    public static int[] d(int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean f(int[] iArr, int i3) {
        return ArraysKt.contains(iArr, i3);
    }

    public static boolean g(int[] iArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UInt) || !ArraysKt.contains(iArr, ((UInt) obj).f())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).v());
    }

    public static final int l(int[] iArr, int i3) {
        return UInt.b(iArr[i3]);
    }

    public static int o(int[] iArr) {
        return iArr.length;
    }

    public static int p(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean q(int[] iArr) {
        return iArr.length == 0;
    }

    public static java.util.Iterator s(int[] iArr) {
        return new Iterator(iArr);
    }

    public static final void t(int[] iArr, int i3, int i4) {
        iArr[i3] = i4;
    }

    public static String u(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return e(((UInt) obj).f());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return g(this.f139793a, elements);
    }

    public boolean e(int i3) {
        return f(this.f139793a, i3);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return h(this.f139793a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return p(this.f139793a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return q(this.f139793a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return s(this.f139793a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f139793a);
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
        return u(this.f139793a);
    }

    public final /* synthetic */ int[] v() {
        return this.f139793a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
