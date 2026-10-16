package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

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
final class ConcurrentHashMapCache<T> implements SerializerCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f142789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap f142790b;

    public ConcurrentHashMapCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f142789a = compute;
        this.f142790b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer a(KClass key) {
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f142790b;
        Class clsA = JvmClassMappingKt.a(key);
        Object cacheEntry = concurrentHashMap.get(clsA);
        if (cacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (cacheEntry = new CacheEntry((KSerializer) this.f142789a.invoke(key))))) != null) {
            cacheEntry = objPutIfAbsent;
        }
        return ((CacheEntry) cacheEntry).f142774a;
    }
}
