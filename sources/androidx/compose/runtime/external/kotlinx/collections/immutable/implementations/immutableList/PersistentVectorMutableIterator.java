package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
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
public final class PersistentVectorMutableIterator<T> extends AbstractListIterator<T> implements ListIterator<T>, KMutableListIterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentVectorBuilder f24441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TrieIterator f24443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24444g;

    public PersistentVectorMutableIterator(PersistentVectorBuilder persistentVectorBuilder, int i3) {
        super(i3, persistentVectorBuilder.size());
        this.f24441c = persistentVectorBuilder;
        this.f24442d = persistentVectorBuilder.d();
        this.f24444g = -1;
        j();
    }

    private final void g() {
        if (this.f24442d != this.f24441c.d()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void h() {
        if (this.f24444g == -1) {
            throw new IllegalStateException();
        }
    }

    private final void i() {
        f(this.f24441c.size());
        this.f24442d = this.f24441c.d();
        this.f24444g = -1;
        j();
    }

    private final void j() {
        Object[] objArrE = this.f24441c.e();
        if (objArrE == null) {
            this.f24443f = null;
            return;
        }
        int iD = UtilsKt.d(this.f24441c.size());
        int iK = RangesKt.k(c(), iD);
        int iF = (this.f24441c.f() / 5) + 1;
        TrieIterator trieIterator = this.f24443f;
        if (trieIterator == null) {
            this.f24443f = new TrieIterator(objArrE, iK, iD, iF);
        } else {
            Intrinsics.checkNotNull(trieIterator);
            trieIterator.j(objArrE, iK, iD, iF);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void add(Object obj) {
        g();
        this.f24441c.add(c(), obj);
        e(c() + 1);
        i();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public Object next() {
        g();
        a();
        this.f24444g = c();
        TrieIterator trieIterator = this.f24443f;
        if (trieIterator == null) {
            Object[] objArrG = this.f24441c.g();
            int iC = c();
            e(iC + 1);
            return objArrG[iC];
        }
        if (trieIterator.hasNext()) {
            e(c() + 1);
            return trieIterator.next();
        }
        Object[] objArrG2 = this.f24441c.g();
        int iC2 = c();
        e(iC2 + 1);
        return objArrG2[iC2 - trieIterator.d()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        g();
        b();
        this.f24444g = c() - 1;
        TrieIterator trieIterator = this.f24443f;
        if (trieIterator == null) {
            Object[] objArrG = this.f24441c.g();
            e(c() - 1);
            return objArrG[c()];
        }
        if (c() <= trieIterator.d()) {
            e(c() - 1);
            return trieIterator.previous();
        }
        Object[] objArrG2 = this.f24441c.g();
        e(c() - 1);
        return objArrG2[c() - trieIterator.d()];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public void remove() {
        g();
        h();
        this.f24441c.remove(this.f24444g);
        if (this.f24444g < c()) {
            e(this.f24444g);
        }
        i();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void set(Object obj) {
        g();
        h();
        this.f24441c.set(this.f24444g, obj);
        this.f24442d = this.f24441c.d();
        j();
    }
}
