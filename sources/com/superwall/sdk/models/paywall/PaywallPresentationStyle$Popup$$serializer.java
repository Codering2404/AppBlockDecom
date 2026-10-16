package com.superwall.sdk.models.paywall;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
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
import kotlinx.serialization.internal.DoubleSerializer;
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
public /* synthetic */ class PaywallPresentationStyle$Popup$$serializer implements GeneratedSerializer<PaywallPresentationStyle.Popup> {
    public static final PaywallPresentationStyle$Popup$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaywallPresentationStyle$Popup$$serializer paywallPresentationStyle$Popup$$serializer = new PaywallPresentationStyle$Popup$$serializer();
        INSTANCE = paywallPresentationStyle$Popup$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("POPUP", paywallPresentationStyle$Popup$$serializer, 3);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p("corner_radius", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallPresentationStyle$Popup$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.f142796a;
        return new KSerializer[]{doubleSerializer, doubleSerializer, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaywallPresentationStyle.Popup deserialize(Decoder decoder) {
        int i3;
        double dF;
        double d3;
        double d4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            double dF2 = compositeDecoderB.F(serialDescriptor, 0);
            double dF3 = compositeDecoderB.F(serialDescriptor, 1);
            dF = compositeDecoderB.F(serialDescriptor, 2);
            i3 = 7;
            d3 = dF2;
            d4 = dF3;
        } else {
            double dF4 = 0.0d;
            boolean z2 = true;
            int i4 = 0;
            double dF5 = 0.0d;
            double dF6 = 0.0d;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    dF5 = compositeDecoderB.F(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    dF6 = compositeDecoderB.F(serialDescriptor, 1);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    dF4 = compositeDecoderB.F(serialDescriptor, 2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            dF = dF4;
            d3 = dF5;
            d4 = dF6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PaywallPresentationStyle.Popup(i3, d3, d4, dF, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaywallPresentationStyle.Popup value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PaywallPresentationStyle.Popup.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
