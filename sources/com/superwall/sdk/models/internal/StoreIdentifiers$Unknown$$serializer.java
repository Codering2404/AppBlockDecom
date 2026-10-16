package com.superwall.sdk.models.internal;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.internal.StoreIdentifiers;
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
public /* synthetic */ class StoreIdentifiers$Unknown$$serializer implements GeneratedSerializer<StoreIdentifiers.Unknown> {
    public static final StoreIdentifiers$Unknown$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StoreIdentifiers$Unknown$$serializer storeIdentifiers$Unknown$$serializer = new StoreIdentifiers$Unknown$$serializer();
        INSTANCE = storeIdentifiers$Unknown$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("UNKNOWN", storeIdentifiers$Unknown$$serializer, 1);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.PROPERTIES_KEY, false);
        pluginGeneratedSerialDescriptor.x(new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(ProductResponseJsonKeys.STORE));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StoreIdentifiers$Unknown$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StoreIdentifiers.Unknown.$childSerializers[0]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StoreIdentifiers.Unknown deserialize(Decoder decoder) {
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = StoreIdentifiers.Unknown.$childSerializers;
        int i3 = 1;
        if (compositeDecoderB.p()) {
            map = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            Map map2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    map2 = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], map2);
                    i4 = 1;
                }
            }
            map = map2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StoreIdentifiers.Unknown(i3, map, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StoreIdentifiers.Unknown value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StoreIdentifiers.Unknown.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
