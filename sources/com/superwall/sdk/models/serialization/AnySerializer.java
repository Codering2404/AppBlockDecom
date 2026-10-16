package com.superwall.sdk.models.serialization;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonDecoder;
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
public final class AnySerializer implements KSerializer<Object> {
    public static final AnySerializer INSTANCE = new AnySerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.h("Any", StructureKind.OBJECT.f142756a, new SerialDescriptor[0], null, 8, null);
    private static final SerialDescriptor listDescriptor = SerialDescriptorsKt.h("List<Any>", StructureKind.LIST.f142754a, new SerialDescriptor[0], null, 8, null);
    private static final SerialDescriptor mapDescriptor = SerialDescriptorsKt.h("Map<String, Any>", StructureKind.MAP.f142755a, new SerialDescriptor[0], null, 8, null);

    private AnySerializer() {
    }

    private final List<Object> deserializeArray(JsonArray jsonArray) {
        Object objDeserializeArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
        for (JsonElement jsonElement : jsonArray) {
            if (jsonElement instanceof JsonPrimitive) {
                objDeserializeArray = INSTANCE.deserializePrimitive((JsonPrimitive) jsonElement);
            } else if (jsonElement instanceof JsonObject) {
                objDeserializeArray = INSTANCE.deserializeObject((JsonObject) jsonElement);
            } else {
                if (!(jsonElement instanceof JsonArray)) {
                    throw new SerializationException("Unknown type in JsonArray");
                }
                objDeserializeArray = INSTANCE.deserializeArray((JsonArray) jsonElement);
            }
            arrayList.add(objDeserializeArray);
        }
        return arrayList;
    }

    private final Map<String, Object> deserializeObject(JsonObject jsonObject) {
        Object objDeserializeArray;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject.size()));
        Iterator<T> it = jsonObject.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (jsonElement instanceof JsonPrimitive) {
                objDeserializeArray = INSTANCE.deserializePrimitive((JsonPrimitive) jsonElement);
            } else if (jsonElement instanceof JsonObject) {
                objDeserializeArray = INSTANCE.deserializeObject((JsonObject) jsonElement);
            } else {
                if (!(jsonElement instanceof JsonArray)) {
                    throw new SerializationException("Unknown type in JsonObject");
                }
                objDeserializeArray = INSTANCE.deserializeArray((JsonArray) jsonElement);
            }
            linkedHashMap.put(key, objDeserializeArray);
        }
        return MapsKt.toMap(linkedHashMap);
    }

    private final Object deserializePrimitive(JsonPrimitive jsonPrimitive) {
        if (jsonPrimitive.b()) {
            return jsonPrimitive.a();
        }
        if (JsonElementKt.f(jsonPrimitive) != null) {
            return Boolean.valueOf(JsonElementKt.e(jsonPrimitive));
        }
        if (JsonElementKt.m(jsonPrimitive) != null) {
            return Integer.valueOf(JsonElementKt.l(jsonPrimitive));
        }
        if (JsonElementKt.s(jsonPrimitive) != null) {
            return Long.valueOf(JsonElementKt.r(jsonPrimitive));
        }
        if (JsonElementKt.i(jsonPrimitive) != null) {
            return Double.valueOf(JsonElementKt.h(jsonPrimitive));
        }
        throw new SerializationException("Unknown primitive type");
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("This class can be loaded only by Json");
        }
        JsonElement jsonElementG = jsonDecoder.g();
        if (jsonElementG instanceof JsonPrimitive) {
            return deserializePrimitive((JsonPrimitive) jsonElementG);
        }
        if (jsonElementG instanceof JsonObject) {
            return deserializeObject((JsonObject) jsonElementG);
        }
        if (jsonElementG instanceof JsonArray) {
            return deserializeArray((JsonArray) jsonElementG);
        }
        throw new SerializationException("Unknown type");
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof String) {
            encoder.G((String) value);
            return;
        }
        if (value instanceof Boolean) {
            encoder.r(((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Integer) {
            encoder.B(((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            encoder.m(((Number) value).longValue());
            return;
        }
        if (value instanceof Float) {
            encoder.t(((Number) value).floatValue());
            return;
        }
        if (value instanceof Double) {
            encoder.g(((Number) value).doubleValue());
            return;
        }
        if (value instanceof List) {
            encoder.e(BuiltinSerializersKt.h(INSTANCE), CollectionsKt.filterNotNull((Iterable) value));
            return;
        }
        if (!(value instanceof Map)) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "Warning: Unsupported type " + Reflection.b(value.getClass()) + ", skipping...", (Map) null, (Throwable) null, 24, (Object) null);
            encoder.o();
            return;
        }
        Set setEntrySet = ((Map) value).entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((Map.Entry) obj).getValue() != null) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            Map.Entry entry = (Map.Entry) obj2;
            String strValueOf = String.valueOf(entry.getKey());
            Object value2 = entry.getValue();
            Intrinsics.checkNotNull(value2);
            Pair pairA = TuplesKt.a(strValueOf, value2);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        encoder.e(BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), INSTANCE), linkedHashMap);
    }

    public final KSerializer<Object> serializerFor(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer<Object> kSerializerI = value instanceof String ? BuiltinSerializersKt.I(StringCompanionObject.f140150a) : value instanceof Boolean ? BuiltinSerializersKt.A(BooleanCompanionObject.f140120a) : value instanceof Integer ? BuiltinSerializersKt.F(IntCompanionObject.f140132a) : value instanceof Long ? BuiltinSerializersKt.G(LongCompanionObject.f140133a) : value instanceof Float ? BuiltinSerializersKt.E(FloatCompanionObject.f140130a) : value instanceof Double ? BuiltinSerializersKt.D(DoubleCompanionObject.f140128a) : value instanceof List ? BuiltinSerializersKt.h(INSTANCE) : value instanceof Map ? BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), INSTANCE) : INSTANCE;
        Intrinsics.checkNotNull(kSerializerI, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return kSerializerI;
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private static /* synthetic */ void getListDescriptor$annotations() {
    }

    private static /* synthetic */ void getMapDescriptor$annotations() {
    }
}
