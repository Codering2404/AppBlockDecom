package com.superwall.sdk.models.product;

import com.superwall.sdk.models.product.StripeProductType;
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
import kotlinx.serialization.internal.IntSerializer;
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
public /* synthetic */ class StripeProductType$StripeSubscriptionPeriod$$serializer implements GeneratedSerializer<StripeProductType.StripeSubscriptionPeriod> {
    public static final StripeProductType$StripeSubscriptionPeriod$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StripeProductType$StripeSubscriptionPeriod$$serializer stripeProductType$StripeSubscriptionPeriod$$serializer = new StripeProductType$StripeSubscriptionPeriod$$serializer();
        INSTANCE = stripeProductType$StripeSubscriptionPeriod$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.product.StripeProductType.StripeSubscriptionPeriod", stripeProductType$StripeSubscriptionPeriod$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("unit", false);
        pluginGeneratedSerialDescriptor.p("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StripeProductType$StripeSubscriptionPeriod$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StripeProductType.StripeSubscriptionPeriod.$childSerializers[0], IntSerializer.f142823a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StripeProductType.StripeSubscriptionPeriod deserialize(Decoder decoder) {
        StripeProductType.StripeSubscriptionPeriod.Unit unit;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = StripeProductType.StripeSubscriptionPeriod.$childSerializers;
        if (compositeDecoderB.p()) {
            unit = (StripeProductType.StripeSubscriptionPeriod.Unit) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            i3 = compositeDecoderB.i(serialDescriptor, 1);
            i4 = 3;
        } else {
            boolean z2 = true;
            int i5 = 0;
            int i6 = 0;
            StripeProductType.StripeSubscriptionPeriod.Unit unit2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    unit2 = (StripeProductType.StripeSubscriptionPeriod.Unit) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], unit2);
                    i6 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    i5 = compositeDecoderB.i(serialDescriptor, 1);
                    i6 |= 2;
                }
            }
            unit = unit2;
            i3 = i5;
            i4 = i6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new StripeProductType.StripeSubscriptionPeriod(i4, unit, i3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StripeProductType.StripeSubscriptionPeriod value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        StripeProductType.StripeSubscriptionPeriod.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
