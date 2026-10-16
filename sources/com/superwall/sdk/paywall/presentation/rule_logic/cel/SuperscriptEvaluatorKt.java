package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
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
public final class SuperscriptEvaluatorKt {
    public static final PassableValue toPassableValue(Object obj) {
        Object passableValue;
        PassableValue passableValue2;
        PassableValue passableValue3;
        PassableValue passableValue4;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof Integer) {
            return new PassableValue.IntValue(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new PassableValue.UIntValue(ULong.b(((Number) obj).longValue()), null);
        }
        if (obj instanceof ULong) {
            return new PassableValue.UIntValue(((ULong) obj).g(), null);
        }
        if (obj instanceof Float) {
            return new PassableValue.FloatValue(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new PassableValue.FloatValue(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            return new PassableValue.StringValue(StringsKt.O((String) obj, "$", "", false, 4, null));
        }
        if (obj instanceof byte[]) {
            return new PassableValue.BytesValue((byte[]) obj);
        }
        if (obj instanceof Boolean) {
            return new PassableValue.BoolValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof List) {
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object obj2 : iterable) {
                if (obj2 == null || (passableValue4 = toPassableValue(obj2)) == null) {
                    passableValue4 = PassableValue.NullValue.INSTANCE;
                }
                arrayList.add(passableValue4);
            }
            return new PassableValue.ListValue(arrayList);
        }
        if (obj instanceof LinkedHashMap) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap2.put((String) key, entry2.getValue());
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                Object key2 = entry3.getKey();
                Object value = entry3.getValue();
                if (value == null || (passableValue3 = toPassableValue(value)) == null) {
                    passableValue3 = PassableValue.NullValue.INSTANCE;
                }
                linkedHashMap3.put(key2, passableValue3);
            }
            return new PassableValue.MapValue(MapsKt.toMap(linkedHashMap3));
        }
        if (obj instanceof Map) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry entry4 : ((Map) obj).entrySet()) {
                if (entry4.getKey() instanceof String) {
                    linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                }
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap4.size()));
            for (Map.Entry entry5 : linkedHashMap4.entrySet()) {
                Object key3 = entry5.getKey();
                Intrinsics.checkNotNull(key3, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap5.put((String) key3, entry5.getValue());
            }
            LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap5.size()));
            for (Map.Entry entry6 : linkedHashMap5.entrySet()) {
                Object key4 = entry6.getKey();
                Object value2 = entry6.getValue();
                if (value2 == null || (passableValue2 = toPassableValue(value2)) == null) {
                    passableValue2 = PassableValue.NullValue.INSTANCE;
                }
                linkedHashMap6.put(key4, passableValue2);
            }
            return new PassableValue.MapValue(MapsKt.toMap(linkedHashMap6));
        }
        if (obj instanceof JsonElement) {
            return toPassableValue((JsonElement) obj);
        }
        if (obj instanceof PassableValue) {
            return (PassableValue) obj;
        }
        try {
            try {
                Map map = (Map) obj;
                ArrayList arrayList2 = new ArrayList(map.size());
                for (Map.Entry entry7 : map.entrySet()) {
                    String strValueOf = String.valueOf(entry7.getKey());
                    Object value3 = entry7.getValue();
                    if (value3 == null || (passableValue = toPassableValue(value3)) == null) {
                        passableValue = PassableValue.NullValue.INSTANCE;
                    }
                    arrayList2.add(TuplesKt.a(strValueOf, passableValue));
                }
                return new PassableValue.MapValue(MapsKt.toMap(arrayList2));
            } catch (Exception unused) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.jsEvaluator, "Cannot serialize " + obj + "::class, evaluating as string", (Map) null, (Throwable) null, 24, (Object) null);
                return new PassableValue.StringValue(obj.toString());
            }
        } catch (Exception unused2) {
            Json.Default r02 = Json.f142959d;
            return toPassableValue(r02.e(SerializersKt.a(r02.a(), Reflection.b(Object.class)), obj));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final PassableValue toPassableValue(JsonElement jsonElement) {
        if (jsonElement instanceof JsonNull) {
            return PassableValue.NullValue.INSTANCE;
        }
        if (jsonElement instanceof JsonObject) {
            Map map = (Map) jsonElement;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), toPassableValue((JsonElement) entry.getValue()));
            }
            return new PassableValue.MapValue(MapsKt.toMap(linkedHashMap));
        }
        if (jsonElement instanceof JsonArray) {
            Iterable iterable = (Iterable) jsonElement;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(toPassableValue((JsonElement) it.next()));
            }
            return new PassableValue.ListValue(arrayList);
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            return jsonPrimitive.b() ? new PassableValue.StringValue(jsonPrimitive.a()) : JsonElementKt.f(jsonPrimitive) != null ? new PassableValue.BoolValue(JsonElementKt.e(jsonPrimitive)) : JsonElementKt.m(jsonPrimitive) != null ? new PassableValue.IntValue(JsonElementKt.l(jsonPrimitive)) : JsonElementKt.s(jsonPrimitive) != null ? new PassableValue.UIntValue(ULong.b(JsonElementKt.r(jsonPrimitive)), null) : JsonElementKt.i(jsonPrimitive) != null ? new PassableValue.FloatValue(JsonElementKt.h(jsonPrimitive)) : new PassableValue.StringValue(jsonPrimitive.a());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> PassableValue.MapValue toPassableValue(Map<String, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), toPassableValue(entry.getValue()));
        }
        return new PassableValue.MapValue(MapsKt.toMap(linkedHashMap));
    }
}
