package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

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
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMapBuilderEntriesIterator f140733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f140734d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(PersistentHashMapBuilderEntriesIterator parentIterator, Object obj, Object obj2) {
        super(obj, obj2);
        Intrinsics.checkNotNullParameter(parentIterator, "parentIterator");
        this.f140733c = parentIterator;
        this.f140734d = obj2;
    }

    public void a(Object obj) {
        this.f140734d = obj;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public Object getValue() {
        return this.f140734d;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public Object setValue(Object obj) {
        Object value = getValue();
        a(obj);
        this.f140733c.b(getKey(), obj);
        return value;
    }
}
