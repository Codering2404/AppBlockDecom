package org.koin.dsl;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.KoinDefinition;

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
public final class DefinitionBindingKt {
    public static final KoinDefinition a(KoinDefinition koinDefinition, KClass[] classes) {
        Intrinsics.checkNotNullParameter(koinDefinition, "<this>");
        Intrinsics.checkNotNullParameter(classes, "classes");
        BeanDefinition beanDefinitionC = koinDefinition.a().c();
        beanDefinitionC.g(CollectionsKt.plus((Collection) beanDefinitionC.f(), (Object[]) classes));
        for (KClass kClass : classes) {
            koinDefinition.b().h(BeanDefinitionKt.a(kClass, koinDefinition.a().c().d(), koinDefinition.a().c().e()), koinDefinition.a());
        }
        return koinDefinition;
    }
}
