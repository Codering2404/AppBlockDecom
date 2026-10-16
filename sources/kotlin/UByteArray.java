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
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f139788a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f139789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f139790b;

        public Iterator(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f139789a = array;
        }

        public byte a() {
            int i3 = this.f139790b;
            byte[] bArr = this.f139789a;
            if (i3 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f139790b));
            }
            this.f139790b = i3 + 1;
            return UByte.b(bArr[i3]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f139790b < this.f139789a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.f139788a = bArr;
    }

    public static final /* synthetic */ UByteArray a(byte[] bArr) {
        return new UByteArray(bArr);
    }

    public static byte[] b(int i3) {
        return d(new byte[i3]);
    }

    public static byte[] d(byte[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean f(byte[] bArr, byte b3) {
        return ArraysKt.contains(bArr, b3);
    }

    public static boolean g(byte[] bArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UByte) || !ArraysKt.contains(bArr, ((UByte) obj).f())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).v());
    }

    public static final byte l(byte[] bArr, int i3) {
        return UByte.b(bArr[i3]);
    }

    public static int o(byte[] bArr) {
        return bArr.length;
    }

    public static int p(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean q(byte[] bArr) {
        return bArr.length == 0;
    }

    public static java.util.Iterator s(byte[] bArr) {
        return new Iterator(bArr);
    }

    public static final void t(byte[] bArr, int i3, byte b3) {
        bArr[i3] = b3;
    }

    public static String u(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return e(((UByte) obj).f());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return g(this.f139788a, elements);
    }

    public boolean e(byte b3) {
        return f(this.f139788a, b3);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return h(this.f139788a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return p(this.f139788a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return q(this.f139788a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return s(this.f139788a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f139788a);
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
        return u(this.f139788a);
    }

    public final /* synthetic */ byte[] v() {
        return this.f139788a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
