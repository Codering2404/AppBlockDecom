package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
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
public class PersistentOrderedMapLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f140838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f140839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f140840c;

    public PersistentOrderedMapLinksIterator(Object obj, Map hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        this.f140838a = obj;
        this.f140839b = hashMap;
    }

    public final Object a() {
        return this.f140838a;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinkedValue next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f140839b.get(this.f140838a);
        if (obj != null) {
            LinkedValue linkedValue = (LinkedValue) obj;
            this.f140840c++;
            this.f140838a = linkedValue.c();
            return linkedValue;
        }
        throw new ConcurrentModificationException("Hash code of a key (" + a() + ") has changed after it was added to the persistent map.");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140840c < this.f140839b.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
