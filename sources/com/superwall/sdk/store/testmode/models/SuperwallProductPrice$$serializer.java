package com.superwall.sdk.store.testmode.models;

import com.applovin.sdk.AppLovinEventParameters;
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
public /* synthetic */ class SuperwallProductPrice$$serializer implements GeneratedSerializer<SuperwallProductPrice> {
    public static final SuperwallProductPrice$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SuperwallProductPrice$$serializer superwallProductPrice$$serializer = new SuperwallProductPrice$$serializer();
        INSTANCE = superwallProductPrice$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.testmode.models.SuperwallProductPrice", superwallProductPrice$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_AMOUNT, false);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_CURRENCY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SuperwallProductPrice$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.f142823a, StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SuperwallProductPrice deserialize(Decoder decoder) {
        int i3;
        String strM;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(serialDescriptor, 0);
            strM = compositeDecoderB.m(serialDescriptor, 1);
            i4 = 3;
        } else {
            boolean z2 = true;
            i3 = 0;
            int i5 = 0;
            String strM2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(serialDescriptor, 0);
                    i5 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    strM2 = compositeDecoderB.m(serialDescriptor, 1);
                    i5 |= 2;
                }
            }
            strM = strM2;
            i4 = i5;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SuperwallProductPrice(i4, i3, strM, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SuperwallProductPrice value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SuperwallProductPrice.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
