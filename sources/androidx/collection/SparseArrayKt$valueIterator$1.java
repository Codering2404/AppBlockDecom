package androidx.collection;

import java.util.Iterator;
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
public final class SparseArrayKt$valueIterator$1 implements Iterator<Object>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SparseArrayCompat f3162b;

    SparseArrayKt$valueIterator$1(SparseArrayCompat sparseArrayCompat) {
        this.f3162b = sparseArrayCompat;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3161a < this.f3162b.q();
    }

    @Override // java.util.Iterator
    public Object next() {
        SparseArrayCompat sparseArrayCompat = this.f3162b;
        int i3 = this.f3161a;
        this.f3161a = i3 + 1;
        return sparseArrayCompat.r(i3);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
