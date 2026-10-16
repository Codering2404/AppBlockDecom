package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public class PersistentHashSetIterator<E> implements Iterator<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f24505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24507c;

    public PersistentHashSetIterator(TrieNode trieNode) {
        List listMutableListOf = CollectionsKt.mutableListOf(new TrieNodeIterator());
        this.f24505a = listMutableListOf;
        this.f24507c = true;
        TrieNodeIterator.i((TrieNodeIterator) listMutableListOf.get(0), trieNode.n(), 0, 2, null);
        this.f24506b = 0;
        b();
    }

    private final void b() {
        if (((TrieNodeIterator) this.f24505a.get(this.f24506b)).d()) {
            return;
        }
        for (int i3 = this.f24506b; -1 < i3; i3--) {
            int iD = d(i3);
            if (iD == -1 && ((TrieNodeIterator) this.f24505a.get(i3)).c()) {
                ((TrieNodeIterator) this.f24505a.get(i3)).f();
                iD = d(i3);
            }
            if (iD != -1) {
                this.f24506b = iD;
                return;
            }
            if (i3 > 0) {
                ((TrieNodeIterator) this.f24505a.get(i3 - 1)).f();
            }
            ((TrieNodeIterator) this.f24505a.get(i3)).h(TrieNode.f24512d.a().n(), 0);
        }
        this.f24507c = false;
    }

    private final int d(int i3) {
        if (((TrieNodeIterator) this.f24505a.get(i3)).d()) {
            return i3;
        }
        if (!((TrieNodeIterator) this.f24505a.get(i3)).e()) {
            return -1;
        }
        TrieNode trieNodeB = ((TrieNodeIterator) this.f24505a.get(i3)).b();
        int i4 = i3 + 1;
        if (i4 == this.f24505a.size()) {
            this.f24505a.add(new TrieNodeIterator());
        }
        TrieNodeIterator.i((TrieNodeIterator) this.f24505a.get(i4), trieNodeB.n(), 0, 2, null);
        return d(i4);
    }

    protected final Object a() {
        CommonFunctionsKt.a(hasNext());
        return ((TrieNodeIterator) this.f24505a.get(this.f24506b)).a();
    }

    protected final List c() {
        return this.f24505a;
    }

    protected final void e(int i3) {
        this.f24506b = i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24507c;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f24507c) {
            throw new NoSuchElementException();
        }
        Object objG = ((TrieNodeIterator) this.f24505a.get(this.f24506b)).g();
        b();
        return objG;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
