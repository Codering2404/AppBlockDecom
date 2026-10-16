package com.superwall.sdk.models.internal;

import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.superwall.sdk.models.internal.RedemptionResult;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class RedemptionInfo$$serializer implements GeneratedSerializer<RedemptionInfo> {
    public static final RedemptionInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedemptionInfo$$serializer redemptionInfo$$serializer = new RedemptionInfo$$serializer();
        INSTANCE = redemptionInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.internal.RedemptionInfo", redemptionInfo$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("ownership", false);
        pluginGeneratedSerialDescriptor.p("purchaserInfo", false);
        pluginGeneratedSerialDescriptor.p("paywallInfo", true);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedemptionInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = RedemptionInfo.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], PurchaserInfo$$serializer.INSTANCE, BuiltinSerializersKt.u(RedemptionResult$PaywallInfo$$serializer.INSTANCE), kSerializerArr[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedemptionInfo deserialize(Decoder decoder) {
        int i3;
        RedemptionOwnership redemptionOwnership;
        PurchaserInfo purchaserInfo;
        RedemptionResult.PaywallInfo paywallInfo;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = RedemptionInfo.$childSerializers;
        RedemptionOwnership redemptionOwnership2 = null;
        if (compositeDecoderB.p()) {
            RedemptionOwnership redemptionOwnership3 = (RedemptionOwnership) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            PurchaserInfo purchaserInfo2 = (PurchaserInfo) compositeDecoderB.y(serialDescriptor, 1, PurchaserInfo$$serializer.INSTANCE, null);
            RedemptionResult.PaywallInfo paywallInfo2 = (RedemptionResult.PaywallInfo) compositeDecoderB.n(serialDescriptor, 2, RedemptionResult$PaywallInfo$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            redemptionOwnership = redemptionOwnership3;
            paywallInfo = paywallInfo2;
            i3 = 15;
            purchaserInfo = purchaserInfo2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PurchaserInfo purchaserInfo3 = null;
            RedemptionResult.PaywallInfo paywallInfo3 = null;
            List list2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    redemptionOwnership2 = (RedemptionOwnership) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], redemptionOwnership2);
                    i4 |= 1;
                } else if (iO == 1) {
                    purchaserInfo3 = (PurchaserInfo) compositeDecoderB.y(serialDescriptor, 1, PurchaserInfo$$serializer.INSTANCE, purchaserInfo3);
                    i4 |= 2;
                } else if (iO == 2) {
                    paywallInfo3 = (RedemptionResult.PaywallInfo) compositeDecoderB.n(serialDescriptor, 2, RedemptionResult$PaywallInfo$$serializer.INSTANCE, paywallInfo3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], list2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            redemptionOwnership = redemptionOwnership2;
            purchaserInfo = purchaserInfo3;
            paywallInfo = paywallInfo3;
            list = list2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedemptionInfo(i3, redemptionOwnership, purchaserInfo, paywallInfo, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedemptionInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedemptionInfo.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
