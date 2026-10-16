package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlinx.collections.immutable.internal.EndOfChain;

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
public class PersistentOrderedMapBuilderLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f140826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PersistentOrderedMapBuilder f140827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f140828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f140829d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f140830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f140831g;

    public PersistentOrderedMapBuilderLinksIterator(Object obj, PersistentOrderedMapBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f140826a = obj;
        this.f140827b = builder;
        this.f140828c = EndOfChain.f140866a;
        this.f140830f = builder.b().b();
    }

    private final void a() {
        if (this.f140827b.b().b() != this.f140830f) {
            throw new ConcurrentModificationException();
        }
    }

    private final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void c() {
        if (!this.f140829d) {
            throw new IllegalStateException();
        }
    }

    public final PersistentOrderedMapBuilder d() {
        return this.f140827b;
    }

    public final Object e() {
        return this.f140828c;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinkedValue next() {
        a();
        b();
        this.f140828c = this.f140826a;
        this.f140829d = true;
        this.f140831g++;
        V v2 = this.f140827b.b().get(this.f140826a);
        if (v2 != null) {
            LinkedValue linkedValue = (LinkedValue) v2;
            this.f140826a = linkedValue.c();
            return linkedValue;
        }
        throw new ConcurrentModificationException("Hash code of a key (" + this.f140826a + ") has changed after it was added to the persistent map.");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140831g < this.f140827b.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        c();
        this.f140827b.remove(this.f140828c);
        this.f140828c = null;
        this.f140829d = false;
        this.f140830f = this.f140827b.b().b();
        this.f140831g--;
    }
}
