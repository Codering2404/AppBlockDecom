package com.superwall.sdk.analytics.internal.trackable;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import java.util.List;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

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
public /* synthetic */ class InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer implements GeneratedSerializer<InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot> {
    public static final InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer internalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer = new InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer();
        INSTANCE = internalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot", internalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, false);
        pluginGeneratedSerialDescriptor.p("isPlaceholder", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot.$childSerializers[0], BooleanSerializer.f142767a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot deserialize(Decoder decoder) {
        List list;
        boolean zC;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, pMpIcGE.znwvcLsVktl);
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot.$childSerializers;
        if (compositeDecoderB.p()) {
            list = (List) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            zC = compositeDecoderB.C(serialDescriptor, 1);
            i3 = 3;
        } else {
            boolean z2 = true;
            boolean zC2 = false;
            int i4 = 0;
            List list2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    list2 = (List) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], list2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    zC2 = compositeDecoderB.C(serialDescriptor, 1);
                    i4 |= 2;
                }
            }
            list = list2;
            zC = zC2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot(i3, list, zC, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        InternalSuperwallEvent.CustomerInfoDidChange.EntitlementsSnapshot.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
