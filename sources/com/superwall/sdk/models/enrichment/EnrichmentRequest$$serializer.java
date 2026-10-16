package com.superwall.sdk.models.enrichment;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
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
public /* synthetic */ class EnrichmentRequest$$serializer implements GeneratedSerializer<EnrichmentRequest> {
    public static final EnrichmentRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        EnrichmentRequest$$serializer enrichmentRequest$$serializer = new EnrichmentRequest$$serializer();
        INSTANCE = enrichmentRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.enrichment.EnrichmentRequest", enrichmentRequest$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("user", false);
        pluginGeneratedSerialDescriptor.p(DeviceRequestsHelper.DEVICE_INFO_DEVICE, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private EnrichmentRequest$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = EnrichmentRequest.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EnrichmentRequest deserialize(Decoder decoder) {
        Map map;
        Map map2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = EnrichmentRequest.$childSerializers;
        if (compositeDecoderB.p()) {
            map2 = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            map = (Map) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Map map3 = null;
            Map map4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    map4 = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], map4);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    map3 = (Map) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], map3);
                    i4 |= 2;
                }
            }
            map = map3;
            map2 = map4;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new EnrichmentRequest(i3, map2, map, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EnrichmentRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        EnrichmentRequest.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
