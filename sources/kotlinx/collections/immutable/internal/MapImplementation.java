package kotlinx.collections.immutable.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class MapImplementation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MapImplementation f140868a = new MapImplementation();

    private MapImplementation() {
    }

    public final boolean a(Map map, Map.Entry element) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(element, "element");
        Object obj = map.get(element.getKey());
        Boolean boolValueOf = obj == null ? null : Boolean.valueOf(Intrinsics.areEqual(obj, element.getValue()));
        return boolValueOf == null ? element.getValue() == null && map.containsKey(element.getKey()) : boolValueOf.booleanValue();
    }

    public final boolean b(Map thisMap, Map otherMap) {
        Intrinsics.checkNotNullParameter(thisMap, "thisMap");
        Intrinsics.checkNotNullParameter(otherMap, "otherMap");
        if (thisMap.size() != otherMap.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (otherMap.isEmpty()) {
            return true;
        }
        Iterator it = otherMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!f140868a.a(thisMap, (Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int c(Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return map.entrySet().hashCode();
    }
}
