package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
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
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNodeBaseIterator[] f24462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24464c = true;

    public PersistentHashMapBaseIterator(TrieNode trieNode, TrieNodeBaseIterator[] trieNodeBaseIteratorArr) {
        this.f24462a = trieNodeBaseIteratorArr;
        trieNodeBaseIteratorArr[0].i(trieNode.p(), trieNode.m() * 2);
        this.f24463b = 0;
        c();
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void c() {
        if (this.f24462a[this.f24463b].e()) {
            return;
        }
        for (int i3 = this.f24463b; -1 < i3; i3--) {
            int iE = e(i3);
            if (iE == -1 && this.f24462a[i3].f()) {
                this.f24462a[i3].h();
                iE = e(i3);
            }
            if (iE != -1) {
                this.f24463b = iE;
                return;
            }
            if (i3 > 0) {
                this.f24462a[i3 - 1].h();
            }
            this.f24462a[i3].i(TrieNode.f24482e.a().p(), 0);
        }
        this.f24464c = false;
    }

    private final int e(int i3) {
        if (this.f24462a[i3].e()) {
            return i3;
        }
        if (!this.f24462a[i3].f()) {
            return -1;
        }
        TrieNode trieNodeB = this.f24462a[i3].b();
        if (i3 == 6) {
            this.f24462a[i3 + 1].i(trieNodeB.p(), trieNodeB.p().length);
        } else {
            this.f24462a[i3 + 1].i(trieNodeB.p(), trieNodeB.m() * 2);
        }
        return e(i3 + 1);
    }

    protected final Object b() {
        a();
        return this.f24462a[this.f24463b].a();
    }

    protected final TrieNodeBaseIterator[] d() {
        return this.f24462a;
    }

    protected final void f(int i3) {
        this.f24463b = i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24464c;
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        T next = this.f24462a[this.f24463b].next();
        c();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
