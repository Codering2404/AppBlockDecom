package org.koin.core;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.extension.ExtensionManager;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTimeTools;

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
public final class Koin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScopeRegistry f145887a = new ScopeRegistry(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InstanceRegistry f145888b = new InstanceRegistry(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PropertyRegistry f145889c = new PropertyRegistry(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExtensionManager f145890d = new ExtensionManager(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Logger f145891e = new EmptyLogger();

    public static /* synthetic */ Scope c(Koin koin, String str, Qualifier qualifier, Object obj, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            obj = null;
        }
        return koin.b(str, qualifier, obj);
    }

    public static /* synthetic */ Object h(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qualifier = null;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        return koin.g(kClass, qualifier, function0);
    }

    public static /* synthetic */ void l(Koin koin, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        koin.k(list, z2);
    }

    public final void a() {
        Logger logger = this.f145891e;
        Level level = Level.DEBUG;
        if (logger.c(level)) {
            logger.a(level, "Eager instances ...");
        }
        long jA = KoinPlatformTimeTools.f146105a.a();
        this.f145888b.b();
        double dDoubleValue = ((Number) new Pair(Unit.f139807a, Double.valueOf((r0.a() - jA) / 1000000.0d)).f()).doubleValue();
        Logger logger2 = this.f145891e;
        String str = "Eager instances created in " + dDoubleValue + " ms";
        if (logger2.c(level)) {
            logger2.a(level, str);
        }
    }

    public final Scope b(String scopeId, Qualifier qualifier, Object obj) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        return this.f145887a.b(scopeId, qualifier, obj);
    }

    public final Object d(KClass clazz, Qualifier qualifier, Function0 function0) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.f145887a.d().e(clazz, qualifier, function0);
    }

    public final InstanceRegistry e() {
        return this.f145888b;
    }

    public final Logger f() {
        return this.f145891e;
    }

    public final Object g(KClass clazz, Qualifier qualifier, Function0 function0) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.f145887a.d().i(clazz, qualifier, function0);
    }

    public final Scope i(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return this.f145887a.e(scopeId);
    }

    public final ScopeRegistry j() {
        return this.f145887a;
    }

    public final void k(List modules, boolean z2) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Set setB = ModuleKt.b(modules, null, 2, null);
        this.f145888b.g(setB, z2);
        this.f145887a.g(setB);
    }

    public final void m(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f145891e = logger;
    }
}
