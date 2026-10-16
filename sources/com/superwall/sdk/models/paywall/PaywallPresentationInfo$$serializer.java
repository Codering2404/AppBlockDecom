package com.superwall.sdk.models.paywall;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
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
import kotlinx.serialization.internal.LongSerializer;
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
public /* synthetic */ class PaywallPresentationInfo$$serializer implements GeneratedSerializer<PaywallPresentationInfo> {
    public static final PaywallPresentationInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaywallPresentationInfo$$serializer paywallPresentationInfo$$serializer = new PaywallPresentationInfo$$serializer();
        INSTANCE = paywallPresentationInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.paywall.PaywallPresentationInfo", paywallPresentationInfo$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, false);
        pluginGeneratedSerialDescriptor.p("delay", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallPresentationInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallPresentationInfo.$childSerializers[0], LongSerializer.f142836a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaywallPresentationInfo deserialize(Decoder decoder) {
        int i3;
        PaywallPresentationStyle paywallPresentationStyle;
        long jF;
        Intrinsics.checkNotNullParameter(decoder, sKeKFMqmvNzY.WoWJhbvvppkV);
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = PaywallPresentationInfo.$childSerializers;
        PaywallPresentationStyle paywallPresentationStyle2 = null;
        if (compositeDecoderB.p()) {
            paywallPresentationStyle = (PaywallPresentationStyle) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            jF = compositeDecoderB.f(serialDescriptor, 1);
            i3 = 3;
        } else {
            long jF2 = 0;
            boolean z2 = true;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    paywallPresentationStyle2 = (PaywallPresentationStyle) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], paywallPresentationStyle2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    jF2 = compositeDecoderB.f(serialDescriptor, 1);
                    i4 |= 2;
                }
            }
            i3 = i4;
            paywallPresentationStyle = paywallPresentationStyle2;
            jF = jF2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PaywallPresentationInfo(i3, paywallPresentationStyle, jF, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaywallPresentationInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PaywallPresentationInfo.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
