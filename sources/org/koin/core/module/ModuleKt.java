package org.koin.core.module;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.InstanceFactory;

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
public final class ModuleKt {
    public static final Set a(List modules, Set newModules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(newModules, "newModules");
        while (!modules.isEmpty()) {
            Module module = (Module) CollectionsKt.first(modules);
            if (module == null) {
                throw new IllegalStateException("Flatten - No head element in list");
            }
            modules = modules.subList(1, modules.size());
            if (module.b().isEmpty()) {
                newModules = SetsKt.plus((Set<? extends Module>) newModules, module);
            } else {
                modules = CollectionsKt.plus((Collection) module.b(), (Iterable) modules);
                newModules = SetsKt.plus((Set<? extends Module>) newModules, module);
            }
        }
        return newModules;
    }

    public static /* synthetic */ Set b(List list, Set set, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return a(list, set);
    }

    public static final void c(InstanceFactory factory, String mapping) throws DefinitionOverrideException {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + factory.c() + " at " + mapping);
    }
}
