package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
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
final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f142791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap f142792b;

    public ConcurrentHashMapParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f142791a = compute;
        this.f142792b = new ConcurrentHashMap();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public Object a(KClass key, List types) {
        Object objB;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        ConcurrentHashMap concurrentHashMap = this.f142792b;
        Class clsA = JvmClassMappingKt.a(key);
        Object parametrizedCacheEntry = concurrentHashMap.get(clsA);
        if (parametrizedCacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (parametrizedCacheEntry = new ParametrizedCacheEntry()))) != null) {
            parametrizedCacheEntry = objPutIfAbsent;
        }
        ParametrizedCacheEntry parametrizedCacheEntry2 = (ParametrizedCacheEntry) parametrizedCacheEntry;
        List list = types;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap concurrentHashMap2 = parametrizedCacheEntry2.f142861a;
        Object obj = concurrentHashMap2.get(arrayList);
        if (obj == null) {
            try {
                Result.Companion companion = Result.f139772b;
                objB = Result.b((KSerializer) this.f142791a.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            Result resultA = Result.a(objB);
            Object objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(arrayList, resultA);
            obj = objPutIfAbsent2 == null ? resultA : objPutIfAbsent2;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return ((Result) obj).j();
    }
}
