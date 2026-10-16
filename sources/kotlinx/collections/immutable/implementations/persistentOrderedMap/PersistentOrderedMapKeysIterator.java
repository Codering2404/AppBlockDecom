package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
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
public final class PersistentOrderedMapKeysIterator<K, V> implements Iterator<K>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PersistentOrderedMapLinksIterator f140837a;

    public PersistentOrderedMapKeysIterator(PersistentOrderedMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f140837a = new PersistentOrderedMapLinksIterator(map.d(), map.e());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140837a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object objA = this.f140837a.a();
        this.f140837a.next();
        return objA;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
