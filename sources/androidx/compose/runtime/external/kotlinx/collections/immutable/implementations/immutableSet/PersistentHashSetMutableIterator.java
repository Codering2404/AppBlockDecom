package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashSetBuilder f24508d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f24509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24511h;

    public PersistentHashSetMutableIterator(PersistentHashSetBuilder persistentHashSetBuilder) {
        super(persistentHashSetBuilder.d());
        this.f24508d = persistentHashSetBuilder;
        this.f24511h = persistentHashSetBuilder.b();
    }

    private final void f() {
        if (this.f24508d.b() != this.f24511h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void g() {
        if (!this.f24510g) {
            throw new IllegalStateException();
        }
    }

    private final boolean h(TrieNode trieNode) {
        return trieNode.m() == 0;
    }

    private final void i(int i3, TrieNode trieNode, Object obj, int i4) {
        if (h(trieNode)) {
            int iIndexOf = ArraysKt.indexOf(trieNode.n(), obj);
            CommonFunctionsKt.a(iIndexOf != -1);
            ((TrieNodeIterator) c().get(i4)).h(trieNode.n(), iIndexOf);
            e(i4);
            return;
        }
        int iP = trieNode.p(1 << TrieNodeKt.d(i3, i4 * 5));
        ((TrieNodeIterator) c().get(i4)).h(trieNode.n(), iP);
        Object obj2 = trieNode.n()[iP];
        if (obj2 instanceof TrieNode) {
            i(i3, (TrieNode) obj2, obj, i4 + 1);
        } else {
            e(i4);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public Object next() {
        f();
        Object next = super.next();
        this.f24509f = next;
        this.f24510g = true;
        return next;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public void remove() {
        g();
        if (hasNext()) {
            Object objA = a();
            TypeIntrinsics.a(this.f24508d).remove(this.f24509f);
            i(objA != null ? objA.hashCode() : 0, this.f24508d.d(), objA, 0);
        } else {
            TypeIntrinsics.a(this.f24508d).remove(this.f24509f);
        }
        this.f24509f = null;
        this.f24510g = false;
        this.f24511h = this.f24508d.b();
    }
}
