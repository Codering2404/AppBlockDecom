package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilder f24471d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f24472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24474h;

    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder persistentHashMapBuilder, TrieNodeBaseIterator[] trieNodeBaseIteratorArr) {
        super(persistentHashMapBuilder.c(), trieNodeBaseIteratorArr);
        this.f24471d = persistentHashMapBuilder;
        this.f24474h = persistentHashMapBuilder.b();
    }

    private final void g() {
        if (this.f24471d.b() != this.f24474h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void h() {
        if (!this.f24473g) {
            throw new IllegalStateException();
        }
    }

    private final void i(int i3, TrieNode trieNode, Object obj, int i4) {
        int i5 = i4 * 5;
        if (i5 > 30) {
            d()[i4].j(trieNode.p(), trieNode.p().length, 0);
            while (!Intrinsics.areEqual(d()[i4].a(), obj)) {
                d()[i4].g();
            }
            f(i4);
            return;
        }
        int iF = 1 << TrieNodeKt.f(i3, i5);
        if (trieNode.q(iF)) {
            d()[i4].j(trieNode.p(), trieNode.m() * 2, trieNode.n(iF));
            f(i4);
        } else {
            int iO = trieNode.O(iF);
            TrieNode trieNodeN = trieNode.N(iO);
            d()[i4].j(trieNode.p(), trieNode.m() * 2, iO);
            i(i3, trieNodeN, obj, i4 + 1);
        }
    }

    public final void j(Object obj, Object obj2) {
        if (this.f24471d.containsKey(obj)) {
            if (hasNext()) {
                Object objB = b();
                this.f24471d.put(obj, obj2);
                i(objB != null ? objB.hashCode() : 0, this.f24471d.c(), objB, 0);
            } else {
                this.f24471d.put(obj, obj2);
            }
            this.f24474h = this.f24471d.b();
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public Object next() {
        g();
        this.f24472f = b();
        this.f24473g = true;
        return super.next();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        h();
        if (hasNext()) {
            Object objB = b();
            TypeIntrinsics.d(this.f24471d).remove(this.f24472f);
            i(objB != null ? objB.hashCode() : 0, this.f24471d.c(), objB, 0);
        } else {
            TypeIntrinsics.d(this.f24471d).remove(this.f24472f);
        }
        this.f24472f = null;
        this.f24473g = false;
        this.f24474h = this.f24471d.b();
    }
}
