package kotlinx.collections.immutable.implementations.immutableSet;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;

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
public class PersistentHashSetIterator<E> implements Iterator<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f140786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140788c;

    public PersistentHashSetIterator(TrieNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        List listMutableListOf = CollectionsKt.mutableListOf(new TrieNodeIterator());
        this.f140786a = listMutableListOf;
        this.f140788c = true;
        TrieNodeIterator.i((TrieNodeIterator) listMutableListOf.get(0), node.l(), 0, 2, null);
        this.f140787b = 0;
        b();
    }

    private final void b() {
        if (((TrieNodeIterator) this.f140786a.get(this.f140787b)).d()) {
            return;
        }
        int i3 = this.f140787b;
        if (i3 >= 0) {
            while (true) {
                int i4 = i3 - 1;
                int iD = d(i3);
                if (iD == -1 && ((TrieNodeIterator) this.f140786a.get(i3)).c()) {
                    ((TrieNodeIterator) this.f140786a.get(i3)).f();
                    iD = d(i3);
                }
                if (iD != -1) {
                    this.f140787b = iD;
                    return;
                }
                if (i3 > 0) {
                    ((TrieNodeIterator) this.f140786a.get(i3 - 1)).f();
                }
                ((TrieNodeIterator) this.f140786a.get(i3)).h(TrieNode.f140793d.a().l(), 0);
                if (i4 < 0) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        this.f140788c = false;
    }

    private final int d(int i3) {
        if (((TrieNodeIterator) this.f140786a.get(i3)).d()) {
            return i3;
        }
        if (!((TrieNodeIterator) this.f140786a.get(i3)).e()) {
            return -1;
        }
        TrieNode trieNodeB = ((TrieNodeIterator) this.f140786a.get(i3)).b();
        int i4 = i3 + 1;
        if (i4 == this.f140786a.size()) {
            this.f140786a.add(new TrieNodeIterator());
        }
        TrieNodeIterator.i((TrieNodeIterator) this.f140786a.get(i4), trieNodeB.l(), 0, 2, null);
        return d(i4);
    }

    protected final Object a() {
        CommonFunctionsKt.a(hasNext());
        return ((TrieNodeIterator) this.f140786a.get(this.f140787b)).a();
    }

    protected final List c() {
        return this.f140786a;
    }

    protected final void e(int i3) {
        this.f140787b = i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140788c;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f140788c) {
            throw new NoSuchElementException();
        }
        Object objG = ((TrieNodeIterator) this.f140786a.get(this.f140787b)).g();
        b();
        return objG;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
