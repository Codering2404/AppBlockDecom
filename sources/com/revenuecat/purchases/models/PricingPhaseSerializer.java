package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
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
public final class PricingPhaseSerializer implements KSerializer<PricingPhase> {
    private static final int BILLING_CYCLE_COUNT_INDEX = 2;
    private static final int BILLING_PERIOD_INDEX = 0;
    private static final int PRICE_INDEX = 3;
    private static final int RECURRENCE_MODE_INDEX = 1;
    public static final PricingPhaseSerializer INSTANCE = new PricingPhaseSerializer();
    private static final KSerializer<Integer> nullableIntSerializer = BuiltinSerializersKt.u(BuiltinSerializersKt.F(IntCompanionObject.f140132a));
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("PricingPhase", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.models.PricingPhaseSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "billing_period", PeriodSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "recurrence_mode", RecurrenceModeSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "billing_cycle_count", PricingPhaseSerializer.nullableIntSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "price", PriceSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        }
    });

    private PricingPhaseSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PricingPhase deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        Period period = null;
        RecurrenceMode recurrenceMode = null;
        Integer num = null;
        Price price = null;
        while (true) {
            PricingPhaseSerializer pricingPhaseSerializer = INSTANCE;
            int iO = compositeDecoderB.o(pricingPhaseSerializer.getDescriptor());
            if (iO == -1) {
                Intrinsics.checkNotNull(period);
                Intrinsics.checkNotNull(recurrenceMode);
                Intrinsics.checkNotNull(price);
                PricingPhase pricingPhase = new PricingPhase(period, recurrenceMode, num, price);
                compositeDecoderB.c(descriptor2);
                return pricingPhase;
            }
            if (iO == 0) {
                period = (Period) CompositeDecoder.DefaultImpls.c(compositeDecoderB, pricingPhaseSerializer.getDescriptor(), 0, PeriodSerializer.INSTANCE, null, 8, null);
            } else if (iO == 1) {
                recurrenceMode = (RecurrenceMode) CompositeDecoder.DefaultImpls.c(compositeDecoderB, pricingPhaseSerializer.getDescriptor(), 1, RecurrenceModeSerializer.INSTANCE, null, 8, null);
            } else if (iO == 2) {
                num = (Integer) CompositeDecoder.DefaultImpls.c(compositeDecoderB, pricingPhaseSerializer.getDescriptor(), 2, nullableIntSerializer, null, 8, null);
            } else {
                if (iO != 3) {
                    throw new IllegalStateException(("Unexpected index: " + iO).toString());
                }
                price = (Price) CompositeDecoder.DefaultImpls.c(compositeDecoderB, pricingPhaseSerializer.getDescriptor(), 3, PriceSerializer.INSTANCE, null, 8, null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PricingPhase value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PricingPhaseSerializer pricingPhaseSerializer = INSTANCE;
        compositeEncoderB.C(pricingPhaseSerializer.getDescriptor(), 0, PeriodSerializer.INSTANCE, value.getBillingPeriod());
        compositeEncoderB.C(pricingPhaseSerializer.getDescriptor(), 1, RecurrenceModeSerializer.INSTANCE, value.getRecurrenceMode());
        compositeEncoderB.C(pricingPhaseSerializer.getDescriptor(), 2, nullableIntSerializer, value.getBillingCycleCount());
        compositeEncoderB.C(pricingPhaseSerializer.getDescriptor(), 3, PriceSerializer.INSTANCE, value.getPrice());
        compositeEncoderB.c(descriptor2);
    }
}
