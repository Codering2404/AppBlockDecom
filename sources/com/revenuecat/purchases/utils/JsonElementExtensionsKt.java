package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

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
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = JsonElementKt.o(jsonElement).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pairA = TuplesKt.a(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    private static final Object getExtractedContent(JsonElement jsonElement) {
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitiveP = JsonElementKt.p(jsonElement);
            if (jsonPrimitiveP.b()) {
                return jsonPrimitiveP.a();
            }
            Object objF = JsonElementKt.f(jsonPrimitiveP);
            return (objF == null && (objF = JsonElementKt.m(jsonPrimitiveP)) == null && (objF = JsonElementKt.s(jsonPrimitiveP)) == null && (objF = JsonElementKt.k(jsonPrimitiveP)) == null && (objF = JsonElementKt.i(jsonPrimitiveP)) == null) ? JsonElementKt.g(jsonPrimitiveP) : objF;
        }
        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArrayN = JsonElementKt.n(jsonElement);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArrayN, 10));
            Iterator<JsonElement> it = jsonArrayN.iterator();
            while (it.hasNext()) {
                arrayList.add(getExtractedContent(it.next()));
            }
            return arrayList;
        }
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = JsonElementKt.o(jsonElement).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Pair pairA = TuplesKt.a(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }
}
