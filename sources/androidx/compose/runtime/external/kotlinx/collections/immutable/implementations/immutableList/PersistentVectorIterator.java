package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f24439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TrieIterator f24440d;

    public PersistentVectorIterator(Object[] objArr, Object[] objArr2, int i3, int i4, int i5) {
        super(i3, i4);
        this.f24439c = objArr2;
        int iD = UtilsKt.d(i4);
        this.f24440d = new TrieIterator(objArr, RangesKt.k(i3, iD), iD, i5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        if (this.f24440d.hasNext()) {
            e(c() + 1);
            return this.f24440d.next();
        }
        Object[] objArr = this.f24439c;
        int iC = c();
        e(iC + 1);
        return objArr[iC - this.f24440d.d()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        b();
        if (c() <= this.f24440d.d()) {
            e(c() - 1);
            return this.f24440d.previous();
        }
        Object[] objArr = this.f24439c;
        e(c() - 1);
        return objArr[c() - this.f24440d.d()];
    }
}
