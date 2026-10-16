package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
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
final class ClassValueCache<T> implements SerializerCache<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f142781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassValueReferences f142782b;

    public ClassValueCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f142781a = compute;
        this.f142782b = new ClassValueReferences();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer a(final KClass key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.f142782b.get(JvmClassMappingKt.a(key));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object objA = mutableSoftReference.f142847a.get();
        if (objA == null) {
            objA = mutableSoftReference.a(new Function0<T>() { // from class: kotlinx.serialization.internal.ClassValueCache$get$$inlined$getOrSet$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new CacheEntry((KSerializer) this.f142783a.b().invoke(key));
                }
            });
        }
        return ((CacheEntry) objA).f142774a;
    }

    public final Function1 b() {
        return this.f142781a;
    }
}
