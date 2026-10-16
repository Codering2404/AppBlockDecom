package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
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
public final class PartialTimelineComponent$$serializer implements GeneratedSerializer<PartialTimelineComponent> {
    public static final PartialTimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialTimelineComponent$$serializer partialTimelineComponent$$serializer = new PartialTimelineComponent$$serializer();
        INSTANCE = partialTimelineComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTimelineComponent", partialTimelineComponent$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("item_spacing", true);
        pluginGeneratedSerialDescriptor.p("text_spacing", true);
        pluginGeneratedSerialDescriptor.p("column_gutter", true);
        pluginGeneratedSerialDescriptor.p("icon_alignment", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialTimelineComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        IntSerializer intSerializer = IntSerializer.f142823a;
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(intSerializer);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(TimelineIconAlignmentDeserializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, BuiltinSerializersKt.u(padding$$serializer), BuiltinSerializersKt.u(padding$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTimelineComponent deserialize(Decoder decoder) {
        int i3;
        Padding padding;
        Padding padding2;
        Size size;
        Boolean bool;
        Integer num;
        Integer num2;
        Integer num3;
        TimelineComponent.IconAlignment iconAlignment;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 7;
        Boolean bool2 = null;
        if (compositeDecoderB.p()) {
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, null);
            IntSerializer intSerializer = IntSerializer.f142823a;
            Integer num4 = (Integer) compositeDecoderB.n(descriptor2, 1, intSerializer, null);
            Integer num5 = (Integer) compositeDecoderB.n(descriptor2, 2, intSerializer, null);
            Integer num6 = (Integer) compositeDecoderB.n(descriptor2, 3, intSerializer, null);
            TimelineComponent.IconAlignment iconAlignment2 = (TimelineComponent.IconAlignment) compositeDecoderB.n(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderB.n(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.n(descriptor2, 6, padding$$serializer, null);
            bool = bool3;
            padding = (Padding) compositeDecoderB.n(descriptor2, 7, padding$$serializer, null);
            padding2 = padding3;
            size = size2;
            num3 = num6;
            iconAlignment = iconAlignment2;
            num2 = num5;
            num = num4;
            i3 = 255;
        } else {
            boolean z2 = true;
            int i5 = 0;
            Padding padding4 = null;
            Padding padding5 = null;
            Size size3 = null;
            Integer num7 = null;
            Integer num8 = null;
            Integer num9 = null;
            TimelineComponent.IconAlignment iconAlignment3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 7;
                        break;
                    case 0:
                        bool2 = (Boolean) compositeDecoderB.n(descriptor2, 0, BooleanSerializer.f142767a, bool2);
                        i5 |= 1;
                        i4 = 7;
                        break;
                    case 1:
                        num7 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, num7);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        num8 = (Integer) compositeDecoderB.n(descriptor2, 2, IntSerializer.f142823a, num8);
                        i5 |= 4;
                        i4 = 7;
                        break;
                    case 3:
                        num9 = (Integer) compositeDecoderB.n(descriptor2, 3, IntSerializer.f142823a, num9);
                        i5 |= 8;
                        i4 = 7;
                        break;
                    case 4:
                        iconAlignment3 = (TimelineComponent.IconAlignment) compositeDecoderB.n(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, iconAlignment3);
                        i5 |= 16;
                        break;
                    case 5:
                        size3 = (Size) compositeDecoderB.n(descriptor2, 5, Size$$serializer.INSTANCE, size3);
                        i5 |= 32;
                        break;
                    case 6:
                        padding5 = (Padding) compositeDecoderB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i5 |= 64;
                        break;
                    case 7:
                        padding4 = (Padding) compositeDecoderB.n(descriptor2, i4, Padding$$serializer.INSTANCE, padding4);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            padding = padding4;
            padding2 = padding5;
            size = size3;
            bool = bool2;
            num = num7;
            num2 = num8;
            num3 = num9;
            iconAlignment = iconAlignment3;
        }
        compositeDecoderB.c(descriptor2);
        return new PartialTimelineComponent(i3, bool, num, num2, num3, iconAlignment, size, padding2, padding, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTimelineComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PartialTimelineComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
