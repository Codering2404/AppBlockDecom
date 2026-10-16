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
import kotlin.jvm.functions.Function0;
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
final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f142785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassValueReferences f142786b;

    public ClassValueParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f142785a = compute;
        this.f142786b = new ClassValueReferences();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public Object a(KClass key, List types) {
        Object objB;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        Object obj = this.f142786b.get(JvmClassMappingKt.a(key));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object objA = mutableSoftReference.f142847a.get();
        if (objA == null) {
            objA = mutableSoftReference.a(new Function0<T>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new ParametrizedCacheEntry();
                }
            });
        }
        ParametrizedCacheEntry parametrizedCacheEntry = (ParametrizedCacheEntry) objA;
        List list = types;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = parametrizedCacheEntry.f142861a;
        Object obj2 = concurrentHashMap.get(arrayList);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.f139772b;
                objB = Result.b((KSerializer) this.f142785a.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            Result resultA = Result.a(objB);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, resultA);
            obj2 = objPutIfAbsent == null ? resultA : objPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "getOrPut(...)");
        return ((Result) obj2).j();
    }
}
