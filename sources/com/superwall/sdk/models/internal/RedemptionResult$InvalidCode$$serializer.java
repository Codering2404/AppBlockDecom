package com.superwall.sdk.models.internal;

import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.models.internal.RedemptionResult;
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
import kotlinx.serialization.internal.StringSerializer;

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
public /* synthetic */ class RedemptionResult$InvalidCode$$serializer implements GeneratedSerializer<RedemptionResult.InvalidCode> {
    public static final RedemptionResult$InvalidCode$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedemptionResult$InvalidCode$$serializer redemptionResult$InvalidCode$$serializer = new RedemptionResult$InvalidCode$$serializer();
        INSTANCE = redemptionResult$InvalidCode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("INVALID_CODE", redemptionResult$InvalidCode$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("code", false);
        pluginGeneratedSerialDescriptor.x(new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedemptionResult$InvalidCode$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedemptionResult.InvalidCode deserialize(Decoder decoder) {
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i3 = 1;
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
        } else {
            boolean z2 = true;
            int i4 = 0;
            strM = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedemptionResult.InvalidCode(i3, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedemptionResult.InvalidCode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedemptionResult.InvalidCode.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
