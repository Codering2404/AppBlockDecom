package com.superwall.sdk.models.serialization;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

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
public final class AnyMapSerializer implements KSerializer<Map<String, ? extends Object>> {
    public static final AnyMapSerializer INSTANCE = new AnyMapSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("AnyMap", new SerialDescriptor[0], new Function1() { // from class: com.superwall.sdk.models.serialization.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AnyMapSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
        }
    });

    private AnyMapSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        SerialDescriptorsKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), JsonElement.Companion.serializer().getDescriptor());
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<String, Object> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("This class can be loaded only by Json");
        }
        JsonObject jsonObjectO = JsonElementKt.o(jsonDecoder.g());
        ArrayList arrayList = new ArrayList(jsonObjectO.size());
        for (Map.Entry<String, JsonElement> entry : jsonObjectO.entrySet()) {
            arrayList.add(TuplesKt.a(entry.getKey(), JsonElementKt.p(entry.getValue()).a()));
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("This class can be saved only by Json");
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, ? extends Object> entry : value.entrySet()) {
            String key = entry.getKey();
            Object value2 = entry.getValue();
            if (value2 instanceof String) {
                jsonObjectBuilder.b(key, JsonElementKt.c((String) value2));
            } else if (value2 instanceof Integer) {
                jsonObjectBuilder.b(key, JsonElementKt.b((Number) value2));
            } else if (value2 instanceof Double) {
                jsonObjectBuilder.b(key, JsonElementKt.b((Number) value2));
            } else if (value2 instanceof Boolean) {
                jsonObjectBuilder.b(key, JsonElementKt.a((Boolean) value2));
            } else if (value2 == null) {
                jsonObjectBuilder.b(key, JsonNull.INSTANCE);
            } else {
                jsonObjectBuilder.b(key, JsonNull.INSTANCE);
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! Warning: Unsupported type " + Reflection.b(value2.getClass()) + ", skipping...", (Map) null, (Throwable) null, 24, (Object) null);
                Unit unit = Unit.f139807a;
            }
        }
        jsonEncoder.A(jsonObjectBuilder.a());
    }
}
