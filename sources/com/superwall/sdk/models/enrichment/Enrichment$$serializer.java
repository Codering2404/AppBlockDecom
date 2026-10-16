package com.superwall.sdk.models.enrichment;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

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
@Deprecated
public /* synthetic */ class Enrichment$$serializer implements GeneratedSerializer<Enrichment> {
    public static final Enrichment$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Enrichment$$serializer enrichment$$serializer = new Enrichment$$serializer();
        INSTANCE = enrichment$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.enrichment.Enrichment", enrichment$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("user", false);
        pluginGeneratedSerialDescriptor.p(DeviceRequestsHelper.DEVICE_INFO_DEVICE, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Enrichment$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        JsonObjectSerializer jsonObjectSerializer = JsonObjectSerializer.f143027a;
        return new KSerializer[]{jsonObjectSerializer, jsonObjectSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Enrichment deserialize(Decoder decoder) {
        JsonObject jsonObject;
        int i3;
        JsonObject jsonObject2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            JsonObjectSerializer jsonObjectSerializer = JsonObjectSerializer.f143027a;
            jsonObject2 = (JsonObject) compositeDecoderB.y(serialDescriptor, 0, jsonObjectSerializer, null);
            jsonObject = (JsonObject) compositeDecoderB.y(serialDescriptor, 1, jsonObjectSerializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            jsonObject = null;
            JsonObject jsonObject3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    jsonObject3 = (JsonObject) compositeDecoderB.y(serialDescriptor, 0, JsonObjectSerializer.f143027a, jsonObject3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    jsonObject = (JsonObject) compositeDecoderB.y(serialDescriptor, 1, JsonObjectSerializer.f143027a, jsonObject);
                    i4 |= 2;
                }
            }
            i3 = i4;
            jsonObject2 = jsonObject3;
        }
        compositeDecoderB.c(serialDescriptor);
        return new Enrichment(i3, jsonObject2, jsonObject, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Enrichment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        Enrichment.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
