package com.revenuecat.purchases.models;

import com.revenuecat.purchases.models.Period;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
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
public final class PeriodSerializer implements KSerializer<Period> {
    private static final int ISO8601_INDEX = 2;
    private static final int UNIT_INDEX = 1;
    private static final int VALUE_INDEX = 0;
    public static final PeriodSerializer INSTANCE = new PeriodSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("Period", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.models.PeriodSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "value", BuiltinSerializersKt.F(IntCompanionObject.f140132a).getDescriptor(), null, false, 12, null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "unit", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "iso8601", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
        }
    });

    private PeriodSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Period deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        Period.Unit unitValueOf = Period.Unit.UNKNOWN;
        String strM = "";
        int i3 = 0;
        while (true) {
            PeriodSerializer periodSerializer = INSTANCE;
            int iO = compositeDecoderB.o(periodSerializer.getDescriptor());
            if (iO == -1) {
                Period period = new Period(i3, unitValueOf, strM);
                compositeDecoderB.c(descriptor2);
                return period;
            }
            if (iO == 0) {
                i3 = compositeDecoderB.i(periodSerializer.getDescriptor(), 0);
            } else if (iO == 1) {
                unitValueOf = Period.Unit.valueOf(compositeDecoderB.m(periodSerializer.getDescriptor(), 1));
            } else {
                if (iO != 2) {
                    throw new IllegalStateException(("Unexpected index: " + iO).toString());
                }
                strM = compositeDecoderB.m(periodSerializer.getDescriptor(), 2);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Period value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PeriodSerializer periodSerializer = INSTANCE;
        compositeEncoderB.w(periodSerializer.getDescriptor(), 0, value.getValue());
        compositeEncoderB.y(periodSerializer.getDescriptor(), 1, value.getUnit().name());
        compositeEncoderB.y(periodSerializer.getDescriptor(), 2, value.getIso8601());
        compositeEncoderB.c(descriptor2);
    }
}
