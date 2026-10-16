package com.revenuecat.purchases.paywalls.components.common;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class LocalizedVariableLocalizationKeyMapSerializer implements KSerializer<Map<LocaleId, ? extends Map<VariableLocalizationKey, ? extends String>>> {
    public static final LocalizedVariableLocalizationKeyMapSerializer INSTANCE = new LocalizedVariableLocalizationKeyMapSerializer();
    private static final KSerializer<Map<LocaleId, Map<VariableLocalizationKey, String>>> delegate;
    private static final SerialDescriptor descriptor;

    static {
        KSerializer<Map<LocaleId, Map<VariableLocalizationKey, String>>> kSerializerK = BuiltinSerializersKt.k(LocaleId.Companion.serializer(), VariableLocalizationKeyMapSerializer.INSTANCE);
        delegate = kSerializerK;
        descriptor = kSerializerK.getDescriptor();
    }

    private LocalizedVariableLocalizationKeyMapSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<LocaleId, Map<VariableLocalizationKey, String>> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (Map) delegate.deserialize(decoder);
    }
}
