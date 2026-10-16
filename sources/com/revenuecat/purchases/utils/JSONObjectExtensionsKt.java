package com.revenuecat.purchases.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class JSONObjectExtensionsKt {
    public static final JSONObject copy(JSONObject jSONObject, boolean z2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new JSONObject(toMap(jSONObject, z2));
    }

    public static /* synthetic */ JSONObject copy$default(JSONObject jSONObject, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return copy(jSONObject, z2);
    }

    public static final Date getDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        Date date = Iso8601Utils.parse(jSONObject.getString(jsonKey));
        Intrinsics.checkNotNullExpressionValue(date, "parse(getString(jsonKey))");
        return date;
    }

    public static final Integer getNullableInt(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (jSONObject.isNull(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return Integer.valueOf(jSONObject.getInt(name));
        }
        return null;
    }

    public static final String getNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (jSONObject.isNull(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.getString(name);
        }
        return null;
    }

    public static final Date optDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        if (jSONObject.isNull(jsonKey)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getDate(jSONObject, jsonKey);
        }
        return null;
    }

    public static final Integer optNullableInt(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableInt(jSONObject, name);
        }
        return null;
    }

    public static final String optNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableString(jSONObject, name);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> replaceJsonNullWithKotlinNull(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<K of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull, V of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull?>");
                value = replaceJsonNullWithKotlinNull((Map) value);
            } else if (value instanceof List) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<V of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull?>");
                value = JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull((List) value);
            } else if (Intrinsics.areEqual(value, JSONObject.NULL)) {
                value = null;
            }
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    public static final <T> Map<String, T> toMap(final JSONObject jSONObject, final boolean z2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "this.keys()");
        return MapsKt.toMap(SequencesKt.M(SequencesKt.e(itKeys), new Function1<String, Pair<? extends String, ? extends T>>() { // from class: com.revenuecat.purchases.utils.JSONObjectExtensionsKt.toMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, T> invoke(String str) throws JSONException {
                if (!z2) {
                    return TuplesKt.a(str, jSONObject.get(str));
                }
                Object list = jSONObject.get(str);
                if (list instanceof JSONObject) {
                    list = JSONObjectExtensionsKt.toMap((JSONObject) list, true);
                } else if (list instanceof JSONArray) {
                    list = JSONArrayExtensionsKt.toList((JSONArray) list);
                }
                return TuplesKt.a(str, list);
            }
        }));
    }

    public static /* synthetic */ Map toMap$default(JSONObject jSONObject, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return toMap(jSONObject, z2);
    }
}
