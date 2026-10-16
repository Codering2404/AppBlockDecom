package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class CornerRadiuses$Percentage$$serializer implements GeneratedSerializer<CornerRadiuses.Percentage> {
    public static final CornerRadiuses$Percentage$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CornerRadiuses$Percentage$$serializer cornerRadiuses$Percentage$$serializer = new CornerRadiuses$Percentage$$serializer();
        INSTANCE = cornerRadiuses$Percentage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses.Percentage", cornerRadiuses$Percentage$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("top_leading", false);
        pluginGeneratedSerialDescriptor.p("top_trailing", false);
        pluginGeneratedSerialDescriptor.p("bottom_leading", false);
        pluginGeneratedSerialDescriptor.p("bottom_trailing", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CornerRadiuses$Percentage$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CornerRadiuses.Percentage deserialize(Decoder decoder) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(descriptor2, 0);
            int i8 = compositeDecoderB.i(descriptor2, 1);
            int i9 = compositeDecoderB.i(descriptor2, 2);
            i4 = compositeDecoderB.i(descriptor2, 3);
            i5 = i9;
            i6 = i8;
            i7 = 15;
        } else {
            boolean z2 = true;
            i3 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(descriptor2, 0);
                    i13 |= 1;
                } else if (iO == 1) {
                    i12 = compositeDecoderB.i(descriptor2, 1);
                    i13 |= 2;
                } else if (iO == 2) {
                    i11 = compositeDecoderB.i(descriptor2, 2);
                    i13 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    i10 = compositeDecoderB.i(descriptor2, 3);
                    i13 |= 8;
                }
            }
            i4 = i10;
            i5 = i11;
            i6 = i12;
            i7 = i13;
        }
        int i14 = i3;
        compositeDecoderB.c(descriptor2);
        return new CornerRadiuses.Percentage(i7, i14, i6, i5, i4, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CornerRadiuses.Percentage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CornerRadiuses.Percentage.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
