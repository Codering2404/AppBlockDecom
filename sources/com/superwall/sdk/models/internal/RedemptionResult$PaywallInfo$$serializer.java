package com.superwall.sdk.models.internal;

import com.applovin.sdk.AppLovinEventTypes;
import com.superwall.sdk.models.internal.RedemptionResult;
import java.util.Map;
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
public /* synthetic */ class RedemptionResult$PaywallInfo$$serializer implements GeneratedSerializer<RedemptionResult.PaywallInfo> {
    public static final RedemptionResult$PaywallInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RedemptionResult$PaywallInfo$$serializer redemptionResult$PaywallInfo$$serializer = new RedemptionResult$PaywallInfo$$serializer();
        INSTANCE = redemptionResult$PaywallInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.internal.RedemptionResult.PaywallInfo", redemptionResult$PaywallInfo$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p("placementName", false);
        pluginGeneratedSerialDescriptor.p("placementParams", false);
        pluginGeneratedSerialDescriptor.p("variantId", false);
        pluginGeneratedSerialDescriptor.p("experimentId", false);
        pluginGeneratedSerialDescriptor.p("productIdentifier", true);
        pluginGeneratedSerialDescriptor.p(AppLovinEventTypes.USER_VIEWED_PRODUCT, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RedemptionResult$PaywallInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = RedemptionResult.PaywallInfo.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializerArr[2], stringSerializer, stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RedemptionResult.PaywallInfo deserialize(Decoder decoder) {
        int i3;
        RedemptionResult.PaywallInfo.PaywallProduct paywallProduct;
        String str;
        String str2;
        String str3;
        Map map;
        String str4;
        String str5;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = RedemptionResult.PaywallInfo.$childSerializers;
        int i5 = 6;
        int i6 = 2;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            Map map2 = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            String strM4 = compositeDecoderB.m(serialDescriptor, 3);
            String strM5 = compositeDecoderB.m(serialDescriptor, 4);
            String str6 = (String) compositeDecoderB.n(serialDescriptor, 5, StringSerializer.f142891a, null);
            map = map2;
            str2 = strM2;
            paywallProduct = (RedemptionResult.PaywallInfo.PaywallProduct) compositeDecoderB.n(serialDescriptor, 6, RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE, null);
            str = str6;
            str4 = strM4;
            str5 = strM5;
            i3 = 127;
            str3 = strM3;
        } else {
            boolean z2 = true;
            int i7 = 0;
            RedemptionResult.PaywallInfo.PaywallProduct paywallProduct2 = null;
            String str7 = null;
            String strM6 = null;
            Map map3 = null;
            String strM7 = null;
            String strM8 = null;
            while (z2) {
                int i8 = i6;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i6 = i8;
                        break;
                    case 0:
                        i7 |= 1;
                        i6 = i8;
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i5 = 6;
                        break;
                    case 1:
                        i4 = i8;
                        strM6 = compositeDecoderB.m(serialDescriptor, 1);
                        i7 |= 2;
                        i6 = i4;
                        i5 = 6;
                        break;
                    case 2:
                        i4 = i8;
                        map3 = (Map) compositeDecoderB.y(serialDescriptor, i4, kSerializerArr[i8], map3);
                        i7 |= 4;
                        i6 = i4;
                        i5 = 6;
                        break;
                    case 3:
                        strM7 = compositeDecoderB.m(serialDescriptor, 3);
                        i7 |= 8;
                        i6 = i8;
                        break;
                    case 4:
                        strM8 = compositeDecoderB.m(serialDescriptor, 4);
                        i7 |= 16;
                        i6 = i8;
                        break;
                    case 5:
                        str7 = (String) compositeDecoderB.n(serialDescriptor, 5, StringSerializer.f142891a, str7);
                        i7 |= 32;
                        i6 = i8;
                        break;
                    case 6:
                        paywallProduct2 = (RedemptionResult.PaywallInfo.PaywallProduct) compositeDecoderB.n(serialDescriptor, i5, RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE, paywallProduct2);
                        i7 |= 64;
                        i6 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i7;
            paywallProduct = paywallProduct2;
            str = str7;
            str2 = strM;
            str3 = strM6;
            map = map3;
            str4 = strM7;
            str5 = strM8;
        }
        compositeDecoderB.c(serialDescriptor);
        return new RedemptionResult.PaywallInfo(i3, str2, str3, map, str4, str5, str, paywallProduct, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RedemptionResult.PaywallInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        RedemptionResult.PaywallInfo.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
