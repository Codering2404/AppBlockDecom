package cz.mobilesoft.statistics.di;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import cz.mobilesoft.statistics.model.dao.RecordDao;
import cz.mobilesoft.statistics.model.datasource.MigrationsKt;
import cz.mobilesoft.statistics.model.datasource.StatisticsDatabase;
import cz.mobilesoft.statistics.scene.graph.DailyGraphViewModel;
import cz.mobilesoft.statistics.scene.graph.WeeklyGraphViewModel;
import cz.mobilesoft.statistics.util.Transformer;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import org.koin.android.ext.koin.ModuleExtKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.StringQualifier;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppModuleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Module f133598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Module f133599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List f133600c;

    static {
        Module moduleB = ModuleDSLKt.b(false, new Function1() { // from class: cz.mobilesoft.statistics.di.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.m((Module) obj);
            }
        }, 1, null);
        f133598a = moduleB;
        Module moduleB2 = ModuleDSLKt.b(false, new Function1() { // from class: cz.mobilesoft.statistics.di.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppModuleKt.j((Module) obj);
            }
        }, 1, null);
        f133599b = moduleB2;
        f133600c = CollectionsKt.listOf((Object[]) new Module[]{moduleB, moduleB2});
    }

    public static final List i() {
        return f133600c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: cz.mobilesoft.statistics.di.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.k((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(StatisticsDatabase.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function22 = new Function2() { // from class: cz.mobilesoft.statistics.di.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.l((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(RecordDao.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsDatabase k(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        Context applicationContext = ModuleExtKt.a(single).getApplicationContext();
        File databasePath = applicationContext.getDatabasePath("statistics-db");
        if (databasePath.exists()) {
            String path = databasePath.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            databasePath.renameTo(new File(new Regex("-db$").replace(path, ".db")));
        }
        File databasePath2 = applicationContext.getDatabasePath("statistics-db-shm");
        if (databasePath2.exists()) {
            String path2 = databasePath2.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            databasePath2.renameTo(new File(new Regex("-db-shm$").replace(path2, ".db-shm")));
        }
        File databasePath3 = applicationContext.getDatabasePath("statistics-db-wal");
        if (databasePath3.exists()) {
            String path3 = databasePath3.getPath();
            Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
            databasePath3.renameTo(new File(new Regex("-db-wal$").replace(path3, ".db-wal")));
        }
        File databasePath4 = applicationContext.getDatabasePath("statistics-db-journal");
        if (databasePath4.exists()) {
            String path4 = databasePath4.getPath();
            Intrinsics.checkNotNullExpressionValue(path4, "getPath(...)");
            databasePath4.renameTo(new File(new Regex("-db-journal$").replace(path4, ".db-journal")));
        }
        return (StatisticsDatabase) Room.a(ModuleExtKt.a(single), StatisticsDatabase.class, "statistics.db").b(MigrationsKt.c(), MigrationsKt.d(), MigrationsKt.e()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordDao l(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return ((StatisticsDatabase) single.e(Reflection.b(StatisticsDatabase.class), null, null)).p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: cz.mobilesoft.statistics.di.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.n((Scope) obj, (ParametersHolder) obj2);
            }
        };
        ScopeRegistry.Companion companion = ScopeRegistry.f146057e;
        StringQualifier stringQualifierA = companion.a();
        Kind kind = Kind.Factory;
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(stringQualifierA, Reflection.b(WeeklyGraphViewModel.class), null, function2, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory);
        new KoinDefinition(module, factoryInstanceFactory);
        Function2 function22 = new Function2() { // from class: cz.mobilesoft.statistics.di.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.o((Scope) obj, (ParametersHolder) obj2);
            }
        };
        InstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(DailyGraphViewModel.class), null, function22, kind, CollectionsKt.emptyList()));
        module.f(factoryInstanceFactory2);
        new KoinDefinition(module, factoryInstanceFactory2);
        Function2 function23 = new Function2() { // from class: cz.mobilesoft.statistics.di.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.p((Scope) obj, (ParametersHolder) obj2);
            }
        };
        StringQualifier stringQualifierA2 = companion.a();
        Kind kind2 = Kind.Singleton;
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(stringQualifierA2, Reflection.b(Transformer.class), null, function23, kind2, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory);
        if (module.e()) {
            module.g(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory);
        Function2 function24 = new Function2() { // from class: cz.mobilesoft.statistics.di.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppModuleKt.q((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(new BeanDefinition(companion.a(), Reflection.b(Repository.class), null, function24, kind2, CollectionsKt.emptyList()));
        module.f(singleInstanceFactory2);
        if (module.e()) {
            module.g(singleInstanceFactory2);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyGraphViewModel n(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new WeeklyGraphViewModel((Repository) viewModel.e(Reflection.b(Repository.class), null, null), new Application());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DailyGraphViewModel o(Scope viewModel, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        Intrinsics.checkNotNullParameter(it, "it");
        return new DailyGraphViewModel((Repository) viewModel.e(Reflection.b(Repository.class), null, null), new Application());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Transformer p(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new Transformer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Repository q(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new Repository((StatisticsDatabase) single.e(Reflection.b(StatisticsDatabase.class), null, null));
    }
}
