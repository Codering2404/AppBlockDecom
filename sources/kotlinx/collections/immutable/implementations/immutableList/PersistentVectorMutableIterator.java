package kotlinx.collections.immutable.implementations.immutableList;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentVectorMutableIterator<T> extends AbstractListIterator<T> implements ListIterator<T>, KMutableListIterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentVectorBuilder f140720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140721d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TrieIterator f140722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f140723g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorMutableIterator(PersistentVectorBuilder builder, int i3) {
        super(i3, builder.size());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f140720c = builder;
        this.f140721d = builder.d();
        this.f140723g = -1;
        j();
    }

    private final void g() {
        if (this.f140721d != this.f140720c.d()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void h() {
        if (this.f140723g == -1) {
            throw new IllegalStateException();
        }
    }

    private final void i() {
        f(this.f140720c.size());
        this.f140721d = this.f140720c.d();
        this.f140723g = -1;
        j();
    }

    private final void j() {
        Object[] objArrE = this.f140720c.e();
        if (objArrE == null) {
            this.f140722f = null;
            return;
        }
        int iC = UtilsKt.c(this.f140720c.size());
        int iK = RangesKt.k(c(), iC);
        int iF = (this.f140720c.f() / 5) + 1;
        TrieIterator trieIterator = this.f140722f;
        if (trieIterator == null) {
            this.f140722f = new TrieIterator(objArrE, iK, iC, iF);
        } else {
            Intrinsics.checkNotNull(trieIterator);
            trieIterator.j(objArrE, iK, iC, iF);
        }
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void add(Object obj) {
        g();
        this.f140720c.add(c(), obj);
        e(c() + 1);
        i();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public Object next() {
        g();
        a();
        this.f140723g = c();
        TrieIterator trieIterator = this.f140722f;
        if (trieIterator == null) {
            Object[] objArrG = this.f140720c.g();
            int iC = c();
            e(iC + 1);
            return objArrG[iC];
        }
        if (trieIterator.hasNext()) {
            e(c() + 1);
            return trieIterator.next();
        }
        Object[] objArrG2 = this.f140720c.g();
        int iC2 = c();
        e(iC2 + 1);
        return objArrG2[iC2 - trieIterator.d()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        g();
        b();
        this.f140723g = c() - 1;
        TrieIterator trieIterator = this.f140722f;
        if (trieIterator == null) {
            Object[] objArrG = this.f140720c.g();
            e(c() - 1);
            return objArrG[c()];
        }
        if (c() <= trieIterator.d()) {
            e(c() - 1);
            return trieIterator.previous();
        }
        Object[] objArrG2 = this.f140720c.g();
        e(c() - 1);
        return objArrG2[c() - trieIterator.d()];
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public void remove() {
        g();
        h();
        this.f140720c.remove(this.f140723g);
        if (this.f140723g < c()) {
            e(this.f140723g);
        }
        i();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void set(Object obj) {
        g();
        h();
        this.f140720c.set(this.f140723g, obj);
        this.f140721d = this.f140720c.d();
        j();
    }
}
