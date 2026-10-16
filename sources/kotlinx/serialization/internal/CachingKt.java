package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class CachingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f142775a;

    static {
        boolean z2;
        try {
            Class.forName("java.lang.ClassValue");
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        f142775a = z2;
    }

    public static final SerializerCache a(Function1 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return f142775a ? new ClassValueCache(factory) : new ConcurrentHashMapCache(factory);
    }

    public static final ParametrizedSerializerCache b(Function2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return f142775a ? new ClassValueParametrizedCache(factory) : new ConcurrentHashMapParametrizedCache(factory);
    }
}
