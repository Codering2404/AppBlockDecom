package kotlinx.collections.immutable.implementations.immutableSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
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
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashSetBuilder f140789d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f140790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f140791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f140792h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashSetMutableIterator(PersistentHashSetBuilder builder) {
        super(builder.d());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f140789d = builder;
        this.f140792h = builder.b();
    }

    private final void f() {
        if (this.f140789d.b() != this.f140792h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void g() {
        if (!this.f140791g) {
            throw new IllegalStateException();
        }
    }

    private final boolean h(TrieNode trieNode) {
        return trieNode.k() == 0;
    }

    private final void i(int i3, TrieNode trieNode, Object obj, int i4) {
        if (h(trieNode)) {
            int iIndexOf = ArraysKt.indexOf(trieNode.l(), obj);
            CommonFunctionsKt.a(iIndexOf != -1);
            ((TrieNodeIterator) c().get(i4)).h(trieNode.l(), iIndexOf);
            e(i4);
            return;
        }
        int iN = trieNode.n(1 << TrieNodeKt.d(i3, i4 * 5));
        ((TrieNodeIterator) c().get(i4)).h(trieNode.l(), iN);
        Object obj2 = trieNode.l()[iN];
        if (obj2 instanceof TrieNode) {
            i(i3, (TrieNode) obj2, obj, i4 + 1);
        } else {
            e(i4);
        }
    }

    @Override // kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public Object next() {
        f();
        Object next = super.next();
        this.f140790f = next;
        this.f140791g = true;
        return next;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public void remove() {
        g();
        if (hasNext()) {
            Object objA = a();
            this.f140789d.remove(this.f140790f);
            i(objA == null ? 0 : objA.hashCode(), this.f140789d.d(), objA, 0);
        } else {
            this.f140789d.remove(this.f140790f);
        }
        this.f140790f = null;
        this.f140791g = false;
        this.f140792h = this.f140789d.b();
    }
}
