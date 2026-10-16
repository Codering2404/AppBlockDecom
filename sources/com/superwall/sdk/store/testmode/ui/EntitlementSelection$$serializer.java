package com.superwall.sdk.store.testmode.ui;

import com.facebook.internal.ServerProtocol;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class EntitlementSelection$$serializer implements GeneratedSerializer<EntitlementSelection> {
    public static final EntitlementSelection$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        EntitlementSelection$$serializer entitlementSelection$$serializer = new EntitlementSelection$$serializer();
        INSTANCE = entitlementSelection$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.testmode.ui.EntitlementSelection", entitlementSelection$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p(ServerProtocol.DIALOG_PARAM_STATE, true);
        pluginGeneratedSerialDescriptor.p("offerType", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private EntitlementSelection$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = EntitlementSelection.$childSerializers;
        return new KSerializer[]{StringSerializer.f142891a, kSerializerArr[1], kSerializerArr[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EntitlementSelection deserialize(Decoder decoder) {
        int i3;
        String str;
        EntitlementStateOption entitlementStateOption;
        OfferTypeOption offerTypeOption;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = EntitlementSelection.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            EntitlementStateOption entitlementStateOption2 = (EntitlementStateOption) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            offerTypeOption = (OfferTypeOption) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            str = strM2;
            i3 = 7;
            entitlementStateOption = entitlementStateOption2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            EntitlementStateOption entitlementStateOption3 = null;
            OfferTypeOption offerTypeOption2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    entitlementStateOption3 = (EntitlementStateOption) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], entitlementStateOption3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    offerTypeOption2 = (OfferTypeOption) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], offerTypeOption2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = strM;
            entitlementStateOption = entitlementStateOption3;
            offerTypeOption = offerTypeOption2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new EntitlementSelection(i3, str, entitlementStateOption, offerTypeOption, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EntitlementSelection value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        EntitlementSelection.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
