package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class ModuleNameRetriever {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ModuleNameRetriever f139915a = new ModuleNameRetriever();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Cache f139916b = new Cache(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Cache f139917c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Cache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f139918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f139919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f139920c;

        public Cache(Method method, Method method2, Method method3) {
            this.f139918a = method;
            this.f139919b = method2;
            this.f139920c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache a(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache = new Cache(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f139917c = cache;
            return cache;
        } catch (Exception unused) {
            Cache cache2 = f139916b;
            f139917c = cache2;
            return cache2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Cache cacheA = f139917c;
        if (cacheA == null) {
            cacheA = a(continuation);
        }
        if (cacheA != f139916b && (method = cacheA.f139918a) != null && (objInvoke = method.invoke(continuation.getClass(), null)) != null && (method2 = cacheA.f139919b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = cacheA.f139920c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
