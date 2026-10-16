package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilder f140756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f140757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f140758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f140759h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder builder, TrieNodeBaseIterator[] path) {
        super(builder.c(), path);
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(path, "path");
        this.f140756d = builder;
        this.f140759h = builder.b();
    }

    private final void g() {
        if (this.f140756d.b() != this.f140759h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void h() {
        if (!this.f140758g) {
            throw new IllegalStateException();
        }
    }

    private final void i(int i3, TrieNode trieNode, Object obj, int i4) {
        int i5 = i4 * 5;
        if (i5 > 30) {
            d()[i4].j(trieNode.m(), trieNode.m().length, 0);
            while (!Intrinsics.areEqual(d()[i4].a(), obj)) {
                d()[i4].g();
            }
            f(i4);
            return;
        }
        int iE = 1 << TrieNodeKt.e(i3, i5);
        if (trieNode.n(iE)) {
            d()[i4].j(trieNode.m(), trieNode.i() * 2, trieNode.j(iE));
            f(i4);
        } else {
            int iJ = trieNode.J(iE);
            TrieNode trieNodeI = trieNode.I(iJ);
            d()[i4].j(trieNode.m(), trieNode.i() * 2, iJ);
            i(i3, trieNodeI, obj, i4 + 1);
        }
    }

    public final void j(Object obj, Object obj2) {
        if (this.f140756d.containsKey(obj)) {
            if (hasNext()) {
                Object objB = b();
                this.f140756d.put(obj, obj2);
                i(objB == null ? 0 : objB.hashCode(), this.f140756d.c(), objB, 0);
            } else {
                this.f140756d.put(obj, obj2);
            }
            this.f140759h = this.f140756d.b();
        }
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public Object next() {
        g();
        this.f140757f = b();
        this.f140758g = true;
        return super.next();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        h();
        if (hasNext()) {
            Object objB = b();
            this.f140756d.remove(this.f140757f);
            i(objB == null ? 0 : objB.hashCode(), this.f140756d.c(), objB, 0);
        } else {
            this.f140756d.remove(this.f140757f);
        }
        this.f140757f = null;
        this.f140758g = false;
        this.f140759h = this.f140756d.b();
    }
}
