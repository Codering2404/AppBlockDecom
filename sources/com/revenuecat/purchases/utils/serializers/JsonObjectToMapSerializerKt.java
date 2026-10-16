package com.revenuecat.purchases.utils.serializers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
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
public final class JsonObjectToMapSerializerKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final Object toAny(JsonElement jsonElement) {
        if (jsonElement instanceof JsonNull) {
            return null;
        }
        if (!(jsonElement instanceof JsonPrimitive)) {
            if (jsonElement instanceof JsonObject) {
                return toAnyMap((JsonObject) jsonElement);
            }
            if (!(jsonElement instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) jsonElement).iterator();
            while (it.hasNext()) {
                Object any = toAny((JsonElement) it.next());
                if (any != null) {
                    arrayList.add(any);
                }
            }
            return arrayList;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
        if (jsonPrimitive.b()) {
            return jsonPrimitive.a();
        }
        if (JsonElementKt.f(jsonPrimitive) != null) {
            Boolean boolF = JsonElementKt.f(jsonPrimitive);
            Intrinsics.checkNotNull(boolF);
            return boolF;
        }
        if (JsonElementKt.m(jsonPrimitive) != null) {
            Integer numM = JsonElementKt.m(jsonPrimitive);
            Intrinsics.checkNotNull(numM);
            return numM;
        }
        if (JsonElementKt.s(jsonPrimitive) != null) {
            Long lS = JsonElementKt.s(jsonPrimitive);
            Intrinsics.checkNotNull(lS);
            return lS;
        }
        if (JsonElementKt.i(jsonPrimitive) == null) {
            return jsonPrimitive.a();
        }
        Double dI = JsonElementKt.i(jsonPrimitive);
        Intrinsics.checkNotNull(dI);
        return dI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> toAnyMap(JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonObject.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object any = toAny((JsonElement) entry.getValue());
            Pair pairA = any == null ? null : TuplesKt.a(str, any);
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
