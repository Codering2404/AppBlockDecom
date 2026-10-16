package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SerializersKt {
    public static final KSerializer a(SerializersModule serializersModule, KClass kClass) {
        return SerializersKt__SerializersKt.d(serializersModule, kClass);
    }

    public static final KSerializer b(KClass kClass, List list, Function0 function0) {
        return SerializersKt__SerializersKt.f(kClass, list, function0);
    }

    public static final KSerializer c(KClass kClass) {
        return SerializersKt__SerializersKt.g(kClass);
    }

    public static final KSerializer d(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.h(serializersModule, kType);
    }

    public static final KSerializer e(KClass kClass) {
        return SerializersKt__SerializersKt.k(kClass);
    }

    public static final KSerializer f(KType kType) {
        return SerializersKt__SerializersKt.l(kType);
    }

    public static final KSerializer g(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.m(serializersModule, kType);
    }

    public static final List h(SerializersModule serializersModule, List list, boolean z2) {
        return SerializersKt__SerializersKt.n(serializersModule, list, z2);
    }
}
