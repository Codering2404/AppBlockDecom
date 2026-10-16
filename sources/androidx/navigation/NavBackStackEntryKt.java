package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.serialization.RouteDeserializerKt;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializersKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavBackStackEntryKt {
    public static final Object a(NavBackStackEntry navBackStackEntry, KClass route) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Bundle bundleB = navBackStackEntry.b();
        if (bundleB == null) {
            Map mapEmptyMap = MapsKt.emptyMap();
            if (mapEmptyMap.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                for (Map.Entry entry : mapEmptyMap.entrySet()) {
                    arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            SavedStateWriter.a(bundleB);
        }
        Map mapH = navBackStackEntry.d().h();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapH.size()));
        for (Map.Entry entry2 : mapH.entrySet()) {
            linkedHashMap.put(entry2.getKey(), ((NavArgument) entry2.getValue()).a());
        }
        return RouteDeserializerKt.a(SerializersKt.c(route), bundleB, linkedHashMap);
    }
}
