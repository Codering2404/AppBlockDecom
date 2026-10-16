package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.ContextualProvider;

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
public final class SerializersModuleKt$overwriteWith$1$1 implements SerializersModuleCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SerializersModuleBuilder f143207a;

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void a(KClass baseClass, KClass actualClass, KSerializer actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        this.f143207a.j(baseClass, actualClass, actualSerializer, true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void b(KClass baseClass, Function1 defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        this.f143207a.h(baseClass, defaultDeserializerProvider, true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void c(KClass kClass, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f143207a.l(kClass, new ContextualProvider.Argless(serializer), true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void d(KClass baseClass, Function1 defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        this.f143207a.i(baseClass, defaultSerializerProvider, true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void e(KClass kClass, Function1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f143207a.l(kClass, new ContextualProvider.WithTypeArguments(provider), true);
    }
}
