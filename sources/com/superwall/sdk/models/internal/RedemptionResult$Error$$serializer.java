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
public /* synthetic */ class RedemptionResult$Error$$serializer implements GeneratedSerializer<RedemptionResult.Error> {
    public static final RedemptionResult$Error$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedemptionResult$Error$$serializer redemptionResult$Error$$serializer = new RedemptionResult$Error$$serializer();
        INSTANCE = redemptionResult$Error$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ERROR", redemptionResult$Error$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("code", false);
        pluginGeneratedSerialDescriptor.p("error", false);
        pluginGeneratedSerialDescriptor.x(new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedemptionResult$Error$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a, ErrorInfo$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedemptionResult.Error deserialize(Decoder decoder) {
        String strM;
        ErrorInfo errorInfo;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            errorInfo = (ErrorInfo) compositeDecoderB.y(serialDescriptor, 1, ErrorInfo$$serializer.INSTANCE, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            strM = null;
            ErrorInfo errorInfo2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    errorInfo2 = (ErrorInfo) compositeDecoderB.y(serialDescriptor, 1, ErrorInfo$$serializer.INSTANCE, errorInfo2);
                    i4 |= 2;
                }
            }
            errorInfo = errorInfo2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedemptionResult.Error(i3, strM, errorInfo, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedemptionResult.Error value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedemptionResult.Error.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
