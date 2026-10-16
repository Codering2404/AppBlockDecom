package com.revenuecat.purchases.paywalls.components.properties;

import com.facebook.appevents.internal.ViewHierarchyConstants;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Deprecated
public final class Padding$$serializer implements GeneratedSerializer<Padding> {
    public static final Padding$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Padding$$serializer padding$$serializer = new Padding$$serializer();
        INSTANCE = padding$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.Padding", padding$$serializer, 4);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_TOP_KEY, true);
        pluginGeneratedSerialDescriptor.p("bottom", true);
        pluginGeneratedSerialDescriptor.p("leading", true);
        pluginGeneratedSerialDescriptor.p("trailing", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Padding$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.f142796a;
        return new KSerializer[]{doubleSerializer, doubleSerializer, doubleSerializer, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Padding deserialize(Decoder decoder) {
        int i3;
        double dF;
        double d3;
        double d4;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            double dF2 = compositeDecoderB.F(descriptor2, 0);
            double dF3 = compositeDecoderB.F(descriptor2, 1);
            double dF4 = compositeDecoderB.F(descriptor2, 2);
            dF = compositeDecoderB.F(descriptor2, 3);
            d3 = dF4;
            d4 = dF2;
            d5 = dF3;
            i3 = 15;
        } else {
            double dF5 = 0.0d;
            boolean z2 = true;
            int i4 = 0;
            double dF6 = 0.0d;
            double dF7 = 0.0d;
            double dF8 = 0.0d;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    dF7 = compositeDecoderB.F(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    dF8 = compositeDecoderB.F(descriptor2, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    dF6 = compositeDecoderB.F(descriptor2, 2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    dF5 = compositeDecoderB.F(descriptor2, 3);
                    i4 |= 8;
                }
            }
            i3 = i4;
            dF = dF5;
            d3 = dF6;
            d4 = dF7;
            d5 = dF8;
        }
        compositeDecoderB.c(descriptor2);
        return new Padding(i3, d4, d5, d3, dF, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Padding value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        Padding.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
