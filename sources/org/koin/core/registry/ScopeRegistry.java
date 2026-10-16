package org.koin.core.registry;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

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
public final class ScopeRegistry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f146057e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final StringQualifier f146058f = QualifierKt.a("_root_");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Koin f146059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f146060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f146061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Scope f146062d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StringQualifier a() {
            return ScopeRegistry.f146058f;
        }

        private Companion() {
        }
    }

    public ScopeRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.f146059a = _koin;
        HashSet hashSet = new HashSet();
        this.f146060b = hashSet;
        Map mapG = KoinPlatformTools.f146106a.g();
        this.f146061c = mapG;
        Scope scope = new Scope(f146058f, "_root_", true, _koin);
        this.f146062d = scope;
        hashSet.add(scope.k());
        mapG.put(scope.g(), scope);
    }

    private final void f(Module module) {
        this.f146060b.addAll(module.d());
    }

    public final Scope b(String scopeId, Qualifier qualifier, Object obj) throws ScopeAlreadyCreatedException {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Logger loggerF = this.f146059a.f();
        String str = "|- (+) Scope - id:'" + scopeId + "' q:" + qualifier;
        Level level = Level.DEBUG;
        if (loggerF.c(level)) {
            loggerF.a(level, str);
        }
        if (!this.f146060b.contains(qualifier)) {
            Logger loggerF2 = this.f146059a.f();
            String str2 = "| Scope '" + qualifier + "' not defined. Creating it ...";
            Level level2 = Level.WARNING;
            if (loggerF2.c(level2)) {
                loggerF2.a(level2, str2);
            }
            this.f146060b.add(qualifier);
        }
        if (this.f146061c.containsKey(scopeId)) {
            throw new ScopeAlreadyCreatedException("Scope with id '" + scopeId + "' is already created");
        }
        Scope scope = new Scope(qualifier, scopeId, false, this.f146059a, 4, null);
        if (obj != null) {
            scope.s(obj);
        }
        scope.o(this.f146062d);
        this.f146061c.put(scopeId, scope);
        return scope;
    }

    public final void c(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f146059a.e().d(scope);
        this.f146061c.remove(scope.g());
    }

    public final Scope d() {
        return this.f146062d;
    }

    public final Scope e(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return (Scope) this.f146061c.get(scopeId);
    }

    public final void g(Set modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator it = modules.iterator();
        while (it.hasNext()) {
            f((Module) it.next());
        }
    }
}
