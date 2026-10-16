package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;
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
public final class KoinExtKt {
    public static final KoinApplication a(KoinApplication koinApplication, final Context androidContext) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(androidContext, "androidContext");
        Logger loggerF = koinApplication.b().f();
        Level level = Level.INFO;
        if (loggerF.c(level)) {
            Logger loggerF2 = koinApplication.b().f();
            if (loggerF2.c(level)) {
                loggerF2.a(level, "[init] declare Android Context");
            }
        }
        if (androidContext instanceof Application) {
            Koin.l(koinApplication.b(), CollectionsKt.listOf(ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Module module) {
                    Intrinsics.checkNotNullParameter(module, "$this$module");
                    final Context context = androidContext;
                    SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(ScopeRegistry.f146057e.a(), Reflection.b(Application.class), null, new Function2<Scope, ParametersHolder, Application>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final Application invoke(Scope single, ParametersHolder it) {
                            Intrinsics.checkNotNullParameter(single, "$this$single");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return (Application) context;
                        }
                    }, Kind.Singleton, CollectionsKt.emptyList()));
                    module.f(singleInstanceFactory);
                    if (module.e()) {
                        module.g(singleInstanceFactory);
                    }
                    DefinitionBindingKt.a(new KoinDefinition(module, singleInstanceFactory), new KClass[]{Reflection.b(Context.class), Reflection.b(Application.class)});
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Module) obj);
                    return Unit.f139807a;
                }
            }, 1, null)), false, 2, null);
            return koinApplication;
        }
        Koin.l(koinApplication.b(), CollectionsKt.listOf(ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                final Context context = androidContext;
                Function2<Scope, ParametersHolder, Context> function2 = new Function2<Scope, ParametersHolder, Context>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Context invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return context;
                    }
                };
                SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(ScopeRegistry.f146057e.a(), Reflection.b(Context.class), null, function2, Kind.Singleton, CollectionsKt.emptyList()));
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
        }, 1, null)), false, 2, null);
        return koinApplication;
    }
}
