package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
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
public class PersistentOrderedMapBuilderLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f24540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PersistentOrderedMapBuilder f24541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24542c = EndOfChain.f24577a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24543d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24545g;

    public PersistentOrderedMapBuilderLinksIterator(Object obj, PersistentOrderedMapBuilder persistentOrderedMapBuilder) {
        this.f24540a = obj;
        this.f24541b = persistentOrderedMapBuilder;
        this.f24544f = persistentOrderedMapBuilder.b().b();
    }

    private final void a() {
        if (this.f24541b.b().b() != this.f24544f) {
            throw new ConcurrentModificationException();
        }
    }

    private final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void c() {
        if (!this.f24543d) {
            throw new IllegalStateException();
        }
    }

    public final PersistentOrderedMapBuilder d() {
        return this.f24541b;
    }

    public final Object e() {
        return this.f24542c;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinkedValue next() {
        a();
        b();
        this.f24542c = this.f24540a;
        this.f24543d = true;
        this.f24545g++;
        V v2 = this.f24541b.b().get(this.f24540a);
        if (v2 != null) {
            LinkedValue linkedValue = (LinkedValue) v2;
            this.f24540a = linkedValue.c();
            return linkedValue;
        }
        throw new ConcurrentModificationException("Hash code of a key (" + this.f24540a + ") has changed after it was added to the persistent map.");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24545g < this.f24541b.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        c();
        TypeIntrinsics.d(this.f24541b).remove(this.f24542c);
        this.f24542c = null;
        this.f24543d = false;
        this.f24544f = this.f24541b.b().b();
        this.f24545g--;
    }
}
