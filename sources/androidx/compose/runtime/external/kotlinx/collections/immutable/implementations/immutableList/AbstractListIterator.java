package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class AbstractListIterator<E> implements ListIterator<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24421b;

    public AbstractListIterator(int i3, int i4) {
        this.f24420a = i3;
        this.f24421b = i4;
    }

    public final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void b() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
    }

    public final int c() {
        return this.f24420a;
    }

    public final int d() {
        return this.f24421b;
    }

    public final void e(int i3) {
        this.f24420a = i3;
    }

    public final void f(int i3) {
        this.f24421b = i3;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f24420a < this.f24421b;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f24420a > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f24420a;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f24420a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
