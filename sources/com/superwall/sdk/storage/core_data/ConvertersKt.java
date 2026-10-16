package com.superwall.sdk.storage.core_data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.json.JSONArray;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConvertersKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object convertFromJsonElement(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonNull) {
            return null;
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            return jsonPrimitive.b() ? jsonPrimitive.a() : JsonElementKt.m(jsonPrimitive) != null ? Double.valueOf(JsonElementKt.l(jsonPrimitive)) : JsonElementKt.s(jsonPrimitive) != null ? Long.valueOf(JsonElementKt.r(jsonPrimitive)) : JsonElementKt.i(jsonPrimitive) != null ? Double.valueOf(JsonElementKt.h(jsonPrimitive)) : JsonElementKt.f(jsonPrimitive) != null ? Boolean.valueOf(JsonElementKt.e(jsonPrimitive)) : jsonPrimitive.a();
        }
        if (jsonElement instanceof JsonArray) {
            Iterable iterable = (Iterable) jsonElement;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(convertFromJsonElement((JsonElement) it.next()));
            }
            return arrayList;
        }
        if (!(jsonElement instanceof JsonObject)) {
            throw new NoWhenBranchMatchedException();
        }
        Map map = (Map) jsonElement;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList2.add(TuplesKt.a((String) entry.getKey(), convertFromJsonElement((JsonElement) entry.getValue())));
        }
        return MapsKt.toMap(arrayList2);
    }

    public static final JsonElement convertToJsonElement(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof String) {
            return JsonElementKt.c((String) obj);
        }
        if (obj instanceof Number) {
            return JsonElementKt.b((Number) obj);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.a((Boolean) obj);
        }
        if (obj instanceof Date) {
            return JsonElementKt.b(Long.valueOf(((Date) obj).getTime()));
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            IntRange intRangeB = RangesKt.B(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
            Iterator<Integer> it = intRangeB.iterator();
            while (it.hasNext()) {
                arrayList.add(convertToJsonElement(jSONArray.get(((IntIterator) it).nextInt())));
            }
            return new JsonArray(arrayList);
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            Sequence sequenceE = SequencesKt.e(itKeys);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : sequenceE) {
                linkedHashMap.put(obj2, convertToJsonElement(jSONObject.get((String) obj2)));
            }
            return new JsonObject(linkedHashMap);
        }
        if (obj instanceof List) {
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(convertToJsonElement(it2.next()));
            }
            return new JsonArray(arrayList2);
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            ArrayList arrayList3 = new ArrayList(objArr.length);
            for (Object obj3 : objArr) {
                arrayList3.add(convertToJsonElement(obj3));
            }
            return new JsonArray(arrayList3);
        }
        if (!(obj instanceof Map)) {
            if (!Date.class.isInstance(obj)) {
                return JsonNull.INSTANCE;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.Date");
            return JsonElementKt.b(Long.valueOf(((Date) obj).getTime()));
        }
        Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Pair pairA = TuplesKt.a(String.valueOf(entry.getKey()), convertToJsonElement(entry.getValue()));
            linkedHashMap2.put(pairA.e(), pairA.f());
        }
        return new JsonObject(linkedHashMap2);
    }

    public static final String fromTypedMap(Json json, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), convertToJsonElement(entry.getValue()));
        }
        JsonObject jsonObject = new JsonObject(MapsKt.toMap(linkedHashMap));
        json.a();
        return json.b(JsonObject.Companion.serializer(), jsonObject);
    }

    public static final Map<String, Object> toNullableTypedMap(Json json, String jsonStr) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        json.a();
        return toNullableTypedMap((JsonObject) json.d(JsonObject.Companion.serializer(), jsonStr));
    }

    public static final Map<String, Object> toTypedMap(Json json, String jsonStr) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        json.a();
        JsonObject jsonObject = (JsonObject) json.d(JsonObject.Companion.serializer(), jsonStr);
        ArrayList arrayList = new ArrayList(jsonObject.size());
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            arrayList.add(TuplesKt.a(entry.getKey(), convertFromJsonElement(entry.getValue())));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((Pair) obj).f() != null) {
                arrayList2.add(obj);
            }
        }
        Map<String, Object> map = MapsKt.toMap(arrayList2);
        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        return map;
    }

    public static final Map<String, Object> toNullableTypedMap(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        ArrayList arrayList = new ArrayList(jsonObject.size());
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            arrayList.add(TuplesKt.a(entry.getKey(), convertFromJsonElement(entry.getValue())));
        }
        Map<String, Object> map = MapsKt.toMap(arrayList);
        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        return map;
    }
}
