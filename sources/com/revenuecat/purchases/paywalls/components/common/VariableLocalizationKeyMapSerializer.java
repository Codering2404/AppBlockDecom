package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class VariableLocalizationKeyMapSerializer implements KSerializer<Map<VariableLocalizationKey, ? extends String>> {
    public static final VariableLocalizationKeyMapSerializer INSTANCE = new VariableLocalizationKeyMapSerializer();
    private static final KSerializer<Map<String, String>> delegate;
    private static final SerialDescriptor descriptor;

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        KSerializer<Map<String, String>> kSerializerK = BuiltinSerializersKt.k(BuiltinSerializersKt.I(stringCompanionObject), BuiltinSerializersKt.I(stringCompanionObject));
        delegate = kSerializerK;
        descriptor = kSerializerK.getDescriptor();
    }

    private VariableLocalizationKeyMapSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<VariableLocalizationKey, String> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<VariableLocalizationKey, String> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return MapExtensionsKt.mapNotNullKeys((Map) decoder.G(delegate), new Function1<Map.Entry<? extends String, ? extends String>, VariableLocalizationKey>() { // from class: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKeyMapSerializer.deserialize.1
            @Override // kotlin.jvm.functions.Function1
            public final VariableLocalizationKey invoke(Map.Entry<String, String> entry) {
                Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                try {
                    String upperCase = entry.getKey().toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    return VariableLocalizationKey.valueOf(upperCase);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
        });
    }
}
