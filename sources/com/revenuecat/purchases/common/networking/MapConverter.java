package com.revenuecat.purchases.common.networking;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class MapConverter {
    private final /* synthetic */ <T> Object tryCast(Object obj, Function1<? super T, ? extends Object> function1) {
        Intrinsics.reifiedOperationMarker(3, "T");
        return obj != null ? function1.invoke(obj) : obj;
    }

    public final JSONObject convertToJSON$purchases_defaultsBc8Release(Map<String, ? extends Object> inputMap) throws JSONException {
        Intrinsics.checkNotNullParameter(inputMap, "inputMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(inputMap.size()));
        Iterator<T> it = inputMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof List) {
                Iterable iterable = (Iterable) value;
                if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                    value = new JSONObject(MapsKt.mapOf(TuplesKt.a("temp_key", new JSONArray((Collection) value)))).getJSONArray("temp_key");
                } else {
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        if (!(it2.next() instanceof String)) {
                            break;
                        }
                    }
                    value = new JSONObject(MapsKt.mapOf(TuplesKt.a("temp_key", new JSONArray((Collection) value)))).getJSONArray("temp_key");
                }
            } else if (value instanceof Map) {
                value = convertToJSON$purchases_defaultsBc8Release((Map) value);
            }
            linkedHashMap.put(key, value);
        }
        return createJSONObject$purchases_defaultsBc8Release(linkedHashMap);
    }

    public final JSONObject createJSONObject$purchases_defaultsBc8Release(Map<String, ? extends Object> inputMap) {
        Intrinsics.checkNotNullParameter(inputMap, "inputMap");
        return new JSONObject(inputMap);
    }
}
