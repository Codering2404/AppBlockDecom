package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNodeBaseIterator[] f140743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140745c;

    public PersistentHashMapBaseIterator(TrieNode node, TrieNodeBaseIterator[] path) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(path, "path");
        this.f140743a = path;
        this.f140745c = true;
        path[0].i(node.m(), node.i() * 2);
        this.f140744b = 0;
        c();
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void c() {
        if (this.f140743a[this.f140744b].e()) {
            return;
        }
        int i3 = this.f140744b;
        if (i3 >= 0) {
            while (true) {
                int i4 = i3 - 1;
                int iE = e(i3);
                if (iE == -1 && this.f140743a[i3].f()) {
                    this.f140743a[i3].h();
                    iE = e(i3);
                }
                if (iE != -1) {
                    this.f140744b = iE;
                    return;
                }
                if (i3 > 0) {
                    this.f140743a[i3 - 1].h();
                }
                this.f140743a[i3].i(TrieNode.f140767e.a().m(), 0);
                if (i4 < 0) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        this.f140745c = false;
    }

    private final int e(int i3) {
        if (this.f140743a[i3].e()) {
            return i3;
        }
        if (!this.f140743a[i3].f()) {
            return -1;
        }
        TrieNode trieNodeB = this.f140743a[i3].b();
        if (i3 == 6) {
            this.f140743a[i3 + 1].i(trieNodeB.m(), trieNodeB.m().length);
        } else {
            this.f140743a[i3 + 1].i(trieNodeB.m(), trieNodeB.i() * 2);
        }
        return e(i3 + 1);
    }

    protected final Object b() {
        a();
        return this.f140743a[this.f140744b].a();
    }

    protected final TrieNodeBaseIterator[] d() {
        return this.f140743a;
    }

    protected final void f(int i3) {
        this.f140744b = i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140745c;
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        T next = this.f140743a[this.f140744b].next();
        c();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
