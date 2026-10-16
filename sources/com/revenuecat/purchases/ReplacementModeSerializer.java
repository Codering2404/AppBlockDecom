package com.revenuecat.purchases;

import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
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
public final class ReplacementModeSerializer implements KSerializer<ReplacementMode> {
    public static final ReplacementModeSerializer INSTANCE = new ReplacementModeSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("ReplacementMode", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.ReplacementModeSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "type", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "name", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
        }
    });

    private ReplacementModeSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ReplacementMode deserialize(Decoder decoder) {
        StoreReplacementMode storeReplacementMode;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = "";
        String strM2 = "";
        while (true) {
            ReplacementModeSerializer replacementModeSerializer = INSTANCE;
            int iO = compositeDecoderB.o(replacementModeSerializer.getDescriptor());
            if (iO == -1) {
                if (Intrinsics.areEqual(strM, "StoreReplacementMode")) {
                    storeReplacementMode = StoreReplacementMode.Companion.fromName$purchases_defaultsBc8Release(strM2);
                    if (storeReplacementMode == null) {
                        throw new SerializationException("Invalid StoreReplacementMode name: " + strM2);
                    }
                } else {
                    if (!Intrinsics.areEqual(strM, "GoogleReplacementMode")) {
                        throw new SerializationException("Unknown ReplacementMode type: " + strM);
                    }
                    try {
                        storeReplacementMode = StoreReplacementModeConversionsKt.toStoreReplacementMode(GoogleReplacementMode.valueOf(strM2));
                    } catch (IllegalArgumentException e3) {
                        throw new SerializationException("Invalid GoogleReplacementMode name: " + strM2, e3);
                    }
                }
                compositeDecoderB.c(descriptor2);
                return storeReplacementMode;
            }
            if (iO == 0) {
                strM = compositeDecoderB.m(replacementModeSerializer.getDescriptor(), 0);
            } else {
                if (iO != 1) {
                    throw new SerializationException("Unexpected index: " + iO);
                }
                strM2 = compositeDecoderB.m(replacementModeSerializer.getDescriptor(), 1);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ReplacementMode value) {
        StoreReplacementMode storeReplacementMode;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        if (value instanceof GoogleReplacementMode) {
            storeReplacementMode = StoreReplacementModeConversionsKt.toStoreReplacementMode((GoogleReplacementMode) value);
        } else {
            if (!(value instanceof StoreReplacementMode)) {
                throw new SerializationException("Unknown ReplacementMode type: " + Reflection.b(value.getClass()).m());
            }
            storeReplacementMode = (StoreReplacementMode) value;
        }
        ReplacementModeSerializer replacementModeSerializer = INSTANCE;
        compositeEncoderB.y(replacementModeSerializer.getDescriptor(), 0, "GoogleReplacementMode");
        compositeEncoderB.y(replacementModeSerializer.getDescriptor(), 1, StoreReplacementModeConversionsKt.toGoogleReplacementMode(storeReplacementMode).name());
        compositeEncoderB.c(descriptor2);
    }
}
