package org.koin.core.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class InstanceRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Koin f146050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f146051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f146052c;

    public InstanceRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.f146050a = _koin;
        this.f146051b = KoinPlatformTools.f146106a.g();
        this.f146052c = new HashMap();
    }

    private final void a(Module module) {
        for (SingleInstanceFactory singleInstanceFactory : module.a()) {
            this.f146052c.put(Integer.valueOf(singleInstanceFactory.hashCode()), singleInstanceFactory);
        }
    }

    private final void c(Collection collection) {
        if (collection.isEmpty()) {
            return;
        }
        InstanceContext instanceContext = new InstanceContext(this.f146050a.f(), this.f146050a.j().d(), null, 4, null);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((SingleInstanceFactory) it.next()).b(instanceContext);
        }
    }

    private final void f(Module module, boolean z2) throws DefinitionOverrideException {
        for (Map.Entry entry : module.c().entrySet()) {
            k(this, z2, (String) entry.getKey(), (InstanceFactory) entry.getValue(), false, 8, null);
        }
    }

    public static /* synthetic */ void k(InstanceRegistry instanceRegistry, boolean z2, String str, InstanceFactory instanceFactory, boolean z3, int i3, Object obj) throws DefinitionOverrideException {
        if ((i3 & 8) != 0) {
            z3 = true;
        }
        instanceRegistry.j(z2, str, instanceFactory, z3);
    }

    public final void b() {
        Collection collectionValues = this.f146052c.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "eagerInstances.values");
        c(collectionValues);
        this.f146052c.clear();
    }

    public final void d(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Collection collectionValues = this.f146051b.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof ScopedInstanceFactory) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ((ScopedInstanceFactory) obj2).e(scope);
        }
    }

    public final Map e() {
        return this.f146051b;
    }

    public final void g(Set modules, boolean z2) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator it = modules.iterator();
        while (it.hasNext()) {
            Module module = (Module) it.next();
            f(module, z2);
            a(module);
        }
    }

    public final InstanceFactory h(KClass clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        return (InstanceFactory) this.f146051b.get(BeanDefinitionKt.a(clazz, qualifier, scopeQualifier));
    }

    public final Object i(Qualifier qualifier, KClass clazz, Qualifier scopeQualifier, InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        InstanceFactory instanceFactoryH = h(clazz, qualifier, scopeQualifier);
        Object objB = instanceFactoryH != null ? instanceFactoryH.b(instanceContext) : null;
        if (objB == null) {
            return null;
        }
        return objB;
    }

    public final void j(boolean z2, String mapping, InstanceFactory factory, boolean z3) throws DefinitionOverrideException {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this.f146051b.containsKey(mapping)) {
            if (!z2) {
                ModuleKt.c(factory, mapping);
            } else if (z3) {
                Logger loggerF = this.f146050a.f();
                String str = "(+) override index '" + mapping + "' -> '" + factory.c() + '\'';
                Level level = Level.WARNING;
                if (loggerF.c(level)) {
                    loggerF.a(level, str);
                }
            }
        }
        Logger loggerF2 = this.f146050a.f();
        String str2 = "(+) index '" + mapping + "' -> '" + factory.c() + '\'';
        Level level2 = Level.DEBUG;
        if (loggerF2.c(level2)) {
            loggerF2.a(level2, str2);
        }
        this.f146051b.put(mapping, factory);
    }

    public final int l() {
        return this.f146051b.size();
    }
}
