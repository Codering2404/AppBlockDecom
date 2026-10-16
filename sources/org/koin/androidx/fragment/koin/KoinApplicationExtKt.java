package org.koin.androidx.fragment.koin;

import androidx.fragment.app.FragmentFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.androidx.fragment.android.KoinFragmentFactory;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

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
public final class KoinApplicationExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Module f145712a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: org.koin.androidx.fragment.koin.KoinApplicationExtKt$fragmentFactoryModule$1
        public final void c(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, FragmentFactory>() { // from class: org.koin.androidx.fragment.koin.KoinApplicationExtKt$fragmentFactoryModule$1.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final FragmentFactory invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new KoinFragmentFactory(null, 1, 0 == true ? 1 : 0);
                }
            };
            SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(ScopeRegistry.f146057e.a(), Reflection.b(FragmentFactory.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            module.f(singleInstanceFactory);
            if (module.e()) {
                module.g(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Module) obj);
            return Unit.f139807a;
        }
    }, 1, null);
}
