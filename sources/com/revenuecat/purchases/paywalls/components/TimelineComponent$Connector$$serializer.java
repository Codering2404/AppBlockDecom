package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
public final class TimelineComponent$Connector$$serializer implements GeneratedSerializer<TimelineComponent.Connector> {
    public static final TimelineComponent$Connector$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimelineComponent$Connector$$serializer timelineComponent$Connector$$serializer = new TimelineComponent$Connector$$serializer();
        INSTANCE = timelineComponent$Connector$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.TimelineComponent.Connector", timelineComponent$Connector$$serializer, 3);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p("margin", false);
        pluginGeneratedSerialDescriptor.p("color", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimelineComponent$Connector$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.f142823a, Padding$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimelineComponent.Connector deserialize(Decoder decoder) {
        int i3;
        int i4;
        Padding padding;
        ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(descriptor2, 0);
            Padding padding2 = (Padding) compositeDecoderB.y(descriptor2, 1, Padding$$serializer.INSTANCE, null);
            colorScheme = (ColorScheme) compositeDecoderB.y(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            padding = padding2;
            i4 = 7;
        } else {
            boolean z2 = true;
            i3 = 0;
            Padding padding3 = null;
            ColorScheme colorScheme2 = null;
            int i5 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(descriptor2, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    padding3 = (Padding) compositeDecoderB.y(descriptor2, 1, Padding$$serializer.INSTANCE, padding3);
                    i5 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    colorScheme2 = (ColorScheme) compositeDecoderB.y(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i5 |= 4;
                }
            }
            i4 = i5;
            padding = padding3;
            colorScheme = colorScheme2;
        }
        int i6 = i3;
        compositeDecoderB.c(descriptor2);
        return new TimelineComponent.Connector(i4, i6, padding, colorScheme, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimelineComponent.Connector value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TimelineComponent.Connector.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
