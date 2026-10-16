package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ScreenMapSerializer implements KSerializer<Map<CustomerCenterConfigData.Screen.ScreenType, ? extends CustomerCenterConfigData.Screen>> {
    public static final ScreenMapSerializer INSTANCE = new ScreenMapSerializer();
    private static final SerialDescriptor descriptor = BuiltinSerializersKt.k(CustomerCenterConfigData.Screen.ScreenType.Companion.serializer(), CustomerCenterConfigData.Screen.Companion.serializer()).getDescriptor();

    private ScreenMapSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<CustomerCenterConfigData.Screen.ScreenType, CustomerCenterConfigData.Screen> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new IllegalStateException("Can be deserialized only by JSON");
        }
        for (Map.Entry<String, JsonElement> entry : JsonElementKt.o(jsonDecoder.g()).entrySet()) {
            String key = entry.getKey();
            try {
                linkedHashMap.put(CustomerCenterConfigData.Screen.ScreenType.valueOf(key), jsonDecoder.d().c(CustomerCenterConfigData.Screen.Companion.serializer(), entry.getValue()));
            } catch (IllegalArgumentException unused) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Unknown CustomerCenter ScreenType: " + key + ". Ignoring.");
                }
            }
        }
        return linkedHashMap;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<CustomerCenterConfigData.Screen.ScreenType, CustomerCenterConfigData.Screen> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        BuiltinSerializersKt.k(CustomerCenterConfigData.Screen.ScreenType.Companion.serializer(), CustomerCenterConfigData.Screen.Companion.serializer()).serialize(encoder, value);
    }
}
