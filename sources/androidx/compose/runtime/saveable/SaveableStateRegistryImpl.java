package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class SaveableStateRegistryImpl implements SaveableStateRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f24877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterMap f24878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableScatterMap f24879c;

    public SaveableStateRegistryImpl(Map map, Function1 function1) {
        this.f24877a = function1;
        this.f24878b = (map == null || map.isEmpty()) ? null : SaveableStateRegistryKt.f(map);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean a(Object obj) {
        return ((Boolean) this.f24877a.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry b(final String str, final Function0 function0) {
        if (SaveableStateRegistryKt.d(str)) {
            throw new IllegalArgumentException("Registered key is empty or blank");
        }
        final MutableScatterMap mutableScatterMapC = this.f24879c;
        if (mutableScatterMapC == null) {
            mutableScatterMapC = ScatterMapKt.c();
            this.f24879c = mutableScatterMapC;
        }
        Object objE = mutableScatterMapC.e(str);
        if (objE == null) {
            objE = new ArrayList();
            mutableScatterMapC.x(str, objE);
        }
        ((List) objE).add(function0);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void a() {
                List list = (List) mutableScatterMapC.u(str);
                if (list != null) {
                    list.remove(function0);
                }
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                mutableScatterMapC.x(str, list);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map e() {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.e():java.util.Map");
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object f(String str) {
        MutableScatterMap mutableScatterMap;
        MutableScatterMap mutableScatterMap2 = this.f24878b;
        List list = mutableScatterMap2 != null ? (List) mutableScatterMap2.u(str) : null;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && (mutableScatterMap = this.f24878b) != null) {
        }
        return list.get(0);
    }
}
