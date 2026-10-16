package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
public final class PriceSerializer implements KSerializer<Price> {
    private static final int AMOUNT_MICROS_INDEX = 1;
    private static final int CURRENCY_CODE_INDEX = 2;
    private static final int FORMATTED_INDEX = 0;
    public static final PriceSerializer INSTANCE = new PriceSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("Price", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.models.PriceSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "formatted", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "amount_micros", BuiltinSerializersKt.G(LongCompanionObject.f140133a).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "currency_code", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
        }
    });

    private PriceSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Price deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = "";
        long jF = 0;
        String strM2 = "";
        while (true) {
            PriceSerializer priceSerializer = INSTANCE;
            int iO = compositeDecoderB.o(priceSerializer.getDescriptor());
            if (iO == -1) {
                Price price = new Price(strM, jF, strM2);
                compositeDecoderB.c(descriptor2);
                return price;
            }
            if (iO == 0) {
                strM = compositeDecoderB.m(priceSerializer.getDescriptor(), 0);
            } else if (iO == 1) {
                jF = compositeDecoderB.f(priceSerializer.getDescriptor(), 1);
            } else {
                if (iO != 2) {
                    throw new IllegalStateException(("Unexpected index: " + iO).toString());
                }
                strM2 = compositeDecoderB.m(priceSerializer.getDescriptor(), 2);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Price value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PriceSerializer priceSerializer = INSTANCE;
        compositeEncoderB.y(priceSerializer.getDescriptor(), 0, value.getFormatted());
        compositeEncoderB.F(priceSerializer.getDescriptor(), 1, value.getAmountMicros());
        compositeEncoderB.y(priceSerializer.getDescriptor(), 2, value.getCurrencyCode());
        compositeEncoderB.c(descriptor2);
    }
}
