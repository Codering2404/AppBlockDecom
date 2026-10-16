package com.revenuecat.purchases;

import com.revenuecat.purchases.PresentedOfferingContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PresentedOfferingContextSerializer implements KSerializer<PresentedOfferingContext> {
    private static final int OFFERING_IDENTIFIER_INDEX = 0;
    private static final int PLACEMENT_IDENTIFIER_INDEX = 1;
    private static final int TARGETING_CONTEXT_INDEX = 2;
    public static final PresentedOfferingContextSerializer INSTANCE = new PresentedOfferingContextSerializer();
    private static final KSerializer<String> nullableStringSerializer = BuiltinSerializersKt.u(BuiltinSerializersKt.I(StringCompanionObject.f140150a));
    private static final KSerializer<PresentedOfferingContext.TargetingContext> nullableTargetingContextSerializer = BuiltinSerializersKt.u(TargetingContextSerializer.INSTANCE);
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("PresentedOfferingContext", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.PresentedOfferingContextSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "offeringIdentifier", BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "placementIdentifier", PresentedOfferingContextSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "targetingContext", PresentedOfferingContextSerializer.nullableTargetingContextSerializer.getDescriptor(), null, false, 12, null);
        }
    });

    private PresentedOfferingContextSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PresentedOfferingContext deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = "";
        String str = null;
        PresentedOfferingContext.TargetingContext targetingContext = null;
        while (true) {
            PresentedOfferingContextSerializer presentedOfferingContextSerializer = INSTANCE;
            int iO = compositeDecoderB.o(presentedOfferingContextSerializer.getDescriptor());
            if (iO == -1) {
                PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(strM, str, targetingContext);
                compositeDecoderB.c(descriptor2);
                return presentedOfferingContext;
            }
            if (iO == 0) {
                strM = compositeDecoderB.m(presentedOfferingContextSerializer.getDescriptor(), 0);
            } else if (iO == 1) {
                str = (String) CompositeDecoder.DefaultImpls.c(compositeDecoderB, presentedOfferingContextSerializer.getDescriptor(), 1, nullableStringSerializer, null, 8, null);
            } else {
                if (iO != 2) {
                    throw new IllegalStateException(("Unexpected index: " + iO).toString());
                }
                targetingContext = (PresentedOfferingContext.TargetingContext) CompositeDecoder.DefaultImpls.c(compositeDecoderB, presentedOfferingContextSerializer.getDescriptor(), 2, nullableTargetingContextSerializer, null, 8, null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PresentedOfferingContext value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PresentedOfferingContextSerializer presentedOfferingContextSerializer = INSTANCE;
        compositeEncoderB.y(presentedOfferingContextSerializer.getDescriptor(), 0, value.getOfferingIdentifier());
        compositeEncoderB.C(presentedOfferingContextSerializer.getDescriptor(), 1, nullableStringSerializer, value.getPlacementIdentifier());
        compositeEncoderB.C(presentedOfferingContextSerializer.getDescriptor(), 2, nullableTargetingContextSerializer, value.getTargetingContext());
        compositeEncoderB.c(descriptor2);
    }
}
