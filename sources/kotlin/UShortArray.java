package kotlin;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
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
public final class UShortArray implements Collection<UShort>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final short[] f139804a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final short[] f139805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f139806b;

        public Iterator(short[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.f139805a = array;
        }

        public short a() {
            int i3 = this.f139806b;
            short[] sArr = this.f139805a;
            if (i3 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f139806b));
            }
            this.f139806b = i3 + 1;
            return UShort.b(sArr[i3]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f139806b < this.f139805a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UShort next() {
            return UShort.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(QaXmqxvjHhxVy.ISgAsEU);
        }
    }

    private /* synthetic */ UShortArray(short[] sArr) {
        this.f139804a = sArr;
    }

    public static final /* synthetic */ UShortArray a(short[] sArr) {
        return new UShortArray(sArr);
    }

    public static short[] b(int i3) {
        return d(new short[i3]);
    }

    public static short[] d(short[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    public static boolean f(short[] sArr, short s2) {
        return ArraysKt.contains(sArr, s2);
    }

    public static boolean g(short[] sArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UShort) || !ArraysKt.contains(sArr, ((UShort) obj).f())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).v());
    }

    public static final short l(short[] sArr, int i3) {
        return UShort.b(sArr[i3]);
    }

    public static int o(short[] sArr) {
        return sArr.length;
    }

    public static int p(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean q(short[] sArr) {
        return sArr.length == 0;
    }

    public static java.util.Iterator s(short[] sArr) {
        return new Iterator(sArr);
    }

    public static final void t(short[] sArr, int i3, short s2) {
        sArr[i3] = s2;
    }

    public static String u(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return e(((UShort) obj).f());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return g(this.f139804a, elements);
    }

    public boolean e(short s2) {
        return f(this.f139804a, s2);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return h(this.f139804a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return p(this.f139804a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return q(this.f139804a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return s(this.f139804a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f139804a);
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
        return u(this.f139804a);
    }

    public final /* synthetic */ short[] v() {
        return this.f139804a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
