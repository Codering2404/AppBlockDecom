package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
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
public final class CarouselComponent$AutoAdvancePages$$serializer implements GeneratedSerializer<CarouselComponent.AutoAdvancePages> {
    public static final CarouselComponent$AutoAdvancePages$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$AutoAdvancePages$$serializer carouselComponent$AutoAdvancePages$$serializer = new CarouselComponent$AutoAdvancePages$$serializer();
        INSTANCE = carouselComponent$AutoAdvancePages$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.CarouselComponent.AutoAdvancePages", carouselComponent$AutoAdvancePages$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("ms_time_per_page", false);
        pluginGeneratedSerialDescriptor.p("ms_transition_time", false);
        pluginGeneratedSerialDescriptor.p("transition_type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$AutoAdvancePages$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(CarouselTransitionTypeDeserializer.INSTANCE);
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{intSerializer, intSerializer, kSerializerU};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent.AutoAdvancePages deserialize(Decoder decoder) {
        int i3;
        int i4;
        int i5;
        CarouselComponent.AutoAdvancePages.TransitionType transitionType;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(descriptor2, 0);
            int i6 = compositeDecoderB.i(descriptor2, 1);
            transitionType = (CarouselComponent.AutoAdvancePages.TransitionType) compositeDecoderB.n(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, null);
            i4 = i6;
            i5 = 7;
        } else {
            boolean z2 = true;
            i3 = 0;
            int i7 = 0;
            CarouselComponent.AutoAdvancePages.TransitionType transitionType2 = null;
            int i8 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(descriptor2, 0);
                    i7 |= 1;
                } else if (iO == 1) {
                    i8 = compositeDecoderB.i(descriptor2, 1);
                    i7 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    transitionType2 = (CarouselComponent.AutoAdvancePages.TransitionType) compositeDecoderB.n(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, transitionType2);
                    i7 |= 4;
                }
            }
            i4 = i8;
            i5 = i7;
            transitionType = transitionType2;
        }
        int i9 = i3;
        compositeDecoderB.c(descriptor2);
        return new CarouselComponent.AutoAdvancePages(i5, i9, i4, transitionType, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent.AutoAdvancePages value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CarouselComponent.AutoAdvancePages.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
