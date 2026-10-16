package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.internal.MapImplementation;

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
public final class PersistentHashMapBuilderEntries<K, V> extends AbstractMapBuilderEntries<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PersistentHashMapBuilder f140760a;

    public PersistentHashMapBuilderEntries(PersistentHashMapBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f140760a = builder;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.AbstractMapBuilderEntries
    public boolean a(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.f140760a.remove(element.getKey(), element.getValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f140760a.clear();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.AbstractMapBuilderEntries
    public boolean containsEntry(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return MapImplementation.f140868a.a(this.f140760a, element);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f140760a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentHashMapBuilderEntriesIterator(this.f140760a);
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        throw new UnsupportedOperationException();
    }
}
