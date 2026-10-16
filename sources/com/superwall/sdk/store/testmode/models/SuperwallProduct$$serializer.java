package com.superwall.sdk.store.testmode.models;

import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
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
public /* synthetic */ class SuperwallProduct$$serializer implements GeneratedSerializer<SuperwallProduct> {
    public static final SuperwallProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SuperwallProduct$$serializer superwallProduct$$serializer = new SuperwallProduct$$serializer();
        INSTANCE = superwallProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.testmode.models.SuperwallProduct", superwallProduct$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("object", true);
        pluginGeneratedSerialDescriptor.p("identifier", false);
        pluginGeneratedSerialDescriptor.p("platform", false);
        pluginGeneratedSerialDescriptor.p("price", true);
        pluginGeneratedSerialDescriptor.p("subscription", true);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, true);
        pluginGeneratedSerialDescriptor.p("storefront", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SuperwallProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = SuperwallProduct.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), stringSerializer, kSerializerArr[2], BuiltinSerializersKt.u(SuperwallProductPrice$$serializer.INSTANCE), BuiltinSerializersKt.u(SuperwallProductSubscription$$serializer.INSTANCE), kSerializerArr[5], BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SuperwallProduct deserialize(Decoder decoder) {
        int i3;
        String str;
        List list;
        String str2;
        String str3;
        SuperwallProductPlatform superwallProductPlatform;
        SuperwallProductPrice superwallProductPrice;
        SuperwallProductSubscription superwallProductSubscription;
        int i4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = SuperwallProduct.$childSerializers;
        int i5 = 6;
        int i6 = 3;
        int i7 = 2;
        String str4 = null;
        if (compositeDecoderB.p()) {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str5 = (String) compositeDecoderB.n(serialDescriptor, 0, stringSerializer, null);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            SuperwallProductPlatform superwallProductPlatform2 = (SuperwallProductPlatform) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            SuperwallProductPrice superwallProductPrice2 = (SuperwallProductPrice) compositeDecoderB.n(serialDescriptor, 3, SuperwallProductPrice$$serializer.INSTANCE, null);
            SuperwallProductSubscription superwallProductSubscription2 = (SuperwallProductSubscription) compositeDecoderB.n(serialDescriptor, 4, SuperwallProductSubscription$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(serialDescriptor, 5, kSerializerArr[5], null);
            str = (String) compositeDecoderB.n(serialDescriptor, 6, stringSerializer, null);
            i3 = 127;
            superwallProductPrice = superwallProductPrice2;
            superwallProductSubscription = superwallProductSubscription2;
            superwallProductPlatform = superwallProductPlatform2;
            str3 = strM;
            str2 = str5;
        } else {
            boolean z2 = true;
            int i8 = 0;
            String str6 = null;
            List list2 = null;
            String strM2 = null;
            SuperwallProductPlatform superwallProductPlatform3 = null;
            SuperwallProductPrice superwallProductPrice3 = null;
            SuperwallProductSubscription superwallProductSubscription3 = null;
            while (z2) {
                int i9 = i7;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i6 = 3;
                        i7 = 2;
                        break;
                    case 0:
                        str4 = (String) compositeDecoderB.n(serialDescriptor, 0, StringSerializer.f142891a, str4);
                        i8 |= 1;
                        i5 = 6;
                        i6 = 3;
                        i7 = 2;
                        break;
                    case 1:
                        i4 = i9;
                        strM2 = compositeDecoderB.m(serialDescriptor, 1);
                        i8 |= 2;
                        i7 = i4;
                        i5 = 6;
                        break;
                    case 2:
                        i4 = i9;
                        superwallProductPlatform3 = (SuperwallProductPlatform) compositeDecoderB.y(serialDescriptor, i4, kSerializerArr[i9], superwallProductPlatform3);
                        i8 |= 4;
                        i7 = i4;
                        i5 = 6;
                        break;
                    case 3:
                        superwallProductPrice3 = (SuperwallProductPrice) compositeDecoderB.n(serialDescriptor, i6, SuperwallProductPrice$$serializer.INSTANCE, superwallProductPrice3);
                        i8 |= 8;
                        i7 = i9;
                        break;
                    case 4:
                        superwallProductSubscription3 = (SuperwallProductSubscription) compositeDecoderB.n(serialDescriptor, 4, SuperwallProductSubscription$$serializer.INSTANCE, superwallProductSubscription3);
                        i8 |= 16;
                        i7 = i9;
                        break;
                    case 5:
                        list2 = (List) compositeDecoderB.y(serialDescriptor, 5, kSerializerArr[5], list2);
                        i8 |= 32;
                        i7 = i9;
                        break;
                    case 6:
                        str6 = (String) compositeDecoderB.n(serialDescriptor, i5, StringSerializer.f142891a, str6);
                        i8 |= 64;
                        i7 = i9;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i8;
            str = str6;
            list = list2;
            str2 = str4;
            str3 = strM2;
            superwallProductPlatform = superwallProductPlatform3;
            superwallProductPrice = superwallProductPrice3;
            superwallProductSubscription = superwallProductSubscription3;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SuperwallProduct(i3, str2, str3, superwallProductPlatform, superwallProductPrice, superwallProductSubscription, list, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SuperwallProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SuperwallProduct.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
