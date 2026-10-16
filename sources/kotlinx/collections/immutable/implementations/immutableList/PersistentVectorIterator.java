package kotlinx.collections.immutable.implementations.immutableList;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f140718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TrieIterator f140719d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorIterator(Object[] root, Object[] tail, int i3, int i4, int i5) {
        super(i3, i4);
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.f140718c = tail;
        int iC = UtilsKt.c(i4);
        this.f140719d = new TrieIterator(root, RangesKt.k(i3, iC), iC, i5);
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        if (this.f140719d.hasNext()) {
            e(c() + 1);
            return this.f140719d.next();
        }
        Object[] objArr = this.f140718c;
        int iC = c();
        e(iC + 1);
        return objArr[iC - this.f140719d.d()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        b();
        if (c() <= this.f140719d.d()) {
            e(c() - 1);
            return this.f140719d.previous();
        }
        Object[] objArr = this.f140718c;
        e(c() - 1);
        return objArr[c() - this.f140719d.d()];
    }
}
