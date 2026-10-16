package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
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
public final class TimelineComponent$$serializer implements GeneratedSerializer<TimelineComponent> {
    public static final TimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimelineComponent$$serializer timelineComponent$$serializer = new TimelineComponent$$serializer();
        INSTANCE = timelineComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("timeline", timelineComponent$$serializer, 10);
        pluginGeneratedSerialDescriptor.p("item_spacing", false);
        pluginGeneratedSerialDescriptor.p("text_spacing", false);
        pluginGeneratedSerialDescriptor.p("column_gutter", false);
        pluginGeneratedSerialDescriptor.p("icon_alignment", false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("items", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimelineComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TimelineComponent.$childSerializers;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializer = kSerializerArr[8];
        KSerializer<?> kSerializer2 = kSerializerArr[9];
        IntSerializer intSerializer = IntSerializer.f142823a;
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, TimelineIconAlignmentDeserializer.INSTANCE, kSerializerU, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, kSerializer, kSerializer2};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimelineComponent deserialize(Decoder decoder) {
        int i3;
        List list;
        List list2;
        Padding padding;
        Padding padding2;
        Size size;
        Boolean bool;
        TimelineComponent.IconAlignment iconAlignment;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = TimelineComponent.$childSerializers;
        int i7 = 9;
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(descriptor2, 0);
            int i8 = compositeDecoderB.i(descriptor2, 1);
            int i9 = compositeDecoderB.i(descriptor2, 2);
            TimelineComponent.IconAlignment iconAlignment2 = (TimelineComponent.IconAlignment) compositeDecoderB.y(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 4, BooleanSerializer.f142767a, null);
            Size size2 = (Size) compositeDecoderB.y(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 6, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 7, padding$$serializer, null);
            List list3 = (List) compositeDecoderB.y(descriptor2, 8, kSerializerArr[8], null);
            list = (List) compositeDecoderB.y(descriptor2, 9, kSerializerArr[9], null);
            padding2 = padding4;
            padding = padding3;
            size = size2;
            iconAlignment = iconAlignment2;
            bool = bool2;
            i4 = i9;
            i5 = 1023;
            list2 = list3;
            i6 = i8;
        } else {
            boolean z2 = true;
            i3 = 0;
            int i10 = 0;
            int i11 = 0;
            List list4 = null;
            List list5 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Size size3 = null;
            Boolean bool3 = null;
            int i12 = 0;
            TimelineComponent.IconAlignment iconAlignment3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i10 |= 1;
                        i3 = compositeDecoderB.i(descriptor2, 0);
                        i7 = 9;
                        break;
                    case 1:
                        i11 = compositeDecoderB.i(descriptor2, 1);
                        i10 |= 2;
                        i7 = 9;
                        break;
                    case 2:
                        i12 = compositeDecoderB.i(descriptor2, 2);
                        i10 |= 4;
                        i7 = 9;
                        break;
                    case 3:
                        iconAlignment3 = (TimelineComponent.IconAlignment) compositeDecoderB.y(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, iconAlignment3);
                        i10 |= 8;
                        i7 = 9;
                        break;
                    case 4:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 4, BooleanSerializer.f142767a, bool3);
                        i10 |= 16;
                        i7 = 9;
                        break;
                    case 5:
                        size3 = (Size) compositeDecoderB.y(descriptor2, 5, Size$$serializer.INSTANCE, size3);
                        i10 |= 32;
                        i7 = 9;
                        break;
                    case 6:
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i10 |= 64;
                        i7 = 9;
                        break;
                    case 7:
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i10 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i7 = 9;
                        break;
                    case 8:
                        list5 = (List) compositeDecoderB.y(descriptor2, 8, kSerializerArr[8], list5);
                        i10 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        list4 = (List) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i7], list4);
                        i10 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            list = list4;
            list2 = list5;
            padding = padding5;
            padding2 = padding6;
            size = size3;
            bool = bool3;
            iconAlignment = iconAlignment3;
            i4 = i12;
            i5 = i10;
            i6 = i11;
        }
        int i13 = i3;
        compositeDecoderB.c(descriptor2);
        return new TimelineComponent(i5, i13, i6, i4, iconAlignment, bool, size, padding, padding2, list2, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimelineComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TimelineComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
