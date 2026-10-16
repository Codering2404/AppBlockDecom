package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
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
public final class CountdownComponent$$serializer implements GeneratedSerializer<CountdownComponent> {
    public static final CountdownComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CountdownComponent$$serializer countdownComponent$$serializer = new CountdownComponent$$serializer();
        INSTANCE = countdownComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("countdown", countdownComponent$$serializer, 5);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, false);
        pluginGeneratedSerialDescriptor.p("count_from", true);
        pluginGeneratedSerialDescriptor.p("countdown_stack", false);
        pluginGeneratedSerialDescriptor.p("end_stack", true);
        pluginGeneratedSerialDescriptor.p("fallback", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CountdownComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = CountdownComponent.$childSerializers[1];
        StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
        return new KSerializer[]{CountdownComponent$CountdownStyle$$serializer.INSTANCE, kSerializer, stackComponent$$serializer, BuiltinSerializersKt.u(stackComponent$$serializer), BuiltinSerializersKt.u(stackComponent$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CountdownComponent deserialize(Decoder decoder) {
        int i3;
        CountdownComponent.CountdownStyle countdownStyle;
        CountdownComponent.CountFrom countFrom;
        StackComponent stackComponent;
        StackComponent stackComponent2;
        StackComponent stackComponent3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CountdownComponent.$childSerializers;
        CountdownComponent.CountdownStyle countdownStyle2 = null;
        if (compositeDecoderB.p()) {
            CountdownComponent.CountdownStyle countdownStyle3 = (CountdownComponent.CountdownStyle) compositeDecoderB.y(descriptor2, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, null);
            CountdownComponent.CountFrom countFrom2 = (CountdownComponent.CountFrom) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], null);
            StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
            StackComponent stackComponent4 = (StackComponent) compositeDecoderB.y(descriptor2, 2, stackComponent$$serializer, null);
            countFrom = countFrom2;
            countdownStyle = countdownStyle3;
            stackComponent2 = (StackComponent) compositeDecoderB.n(descriptor2, 3, stackComponent$$serializer, null);
            stackComponent3 = (StackComponent) compositeDecoderB.n(descriptor2, 4, stackComponent$$serializer, null);
            stackComponent = stackComponent4;
            i3 = 31;
        } else {
            boolean z2 = true;
            int i4 = 0;
            CountdownComponent.CountFrom countFrom3 = null;
            StackComponent stackComponent5 = null;
            StackComponent stackComponent6 = null;
            StackComponent stackComponent7 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    countdownStyle2 = (CountdownComponent.CountdownStyle) compositeDecoderB.y(descriptor2, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, countdownStyle2);
                    i4 |= 1;
                } else if (iO == 1) {
                    countFrom3 = (CountdownComponent.CountFrom) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], countFrom3);
                    i4 |= 2;
                } else if (iO == 2) {
                    stackComponent5 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent5);
                    i4 |= 4;
                } else if (iO == 3) {
                    stackComponent6 = (StackComponent) compositeDecoderB.n(descriptor2, 3, StackComponent$$serializer.INSTANCE, stackComponent6);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    stackComponent7 = (StackComponent) compositeDecoderB.n(descriptor2, 4, StackComponent$$serializer.INSTANCE, stackComponent7);
                    i4 |= 16;
                }
            }
            i3 = i4;
            countdownStyle = countdownStyle2;
            countFrom = countFrom3;
            stackComponent = stackComponent5;
            stackComponent2 = stackComponent6;
            stackComponent3 = stackComponent7;
        }
        compositeDecoderB.c(descriptor2);
        return new CountdownComponent(i3, countdownStyle, countFrom, stackComponent, stackComponent2, stackComponent3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CountdownComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CountdownComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
