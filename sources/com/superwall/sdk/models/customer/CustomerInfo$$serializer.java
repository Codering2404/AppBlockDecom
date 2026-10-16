package com.superwall.sdk.models.customer;

import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
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
public /* synthetic */ class CustomerInfo$$serializer implements GeneratedSerializer<CustomerInfo> {
    public static final CustomerInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CustomerInfo$$serializer customerInfo$$serializer = new CustomerInfo$$serializer();
        INSTANCE = customerInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.customer.CustomerInfo", customerInfo$$serializer, 5);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS, false);
        pluginGeneratedSerialDescriptor.p("nonSubscriptions", false);
        pluginGeneratedSerialDescriptor.p("userId", true);
        pluginGeneratedSerialDescriptor.p(CustomerInfoResponseJsonKeys.ENTITLEMENTS, false);
        pluginGeneratedSerialDescriptor.p("isPlaceholder", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CustomerInfo.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], StringSerializer.f142891a, kSerializerArr[3], BooleanSerializer.f142767a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CustomerInfo deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        List list;
        List list2;
        String str;
        List list3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = CustomerInfo.$childSerializers;
        int i4 = 0;
        if (compositeDecoderB.p()) {
            List list4 = (List) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            List list5 = (List) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            String strM = compositeDecoderB.m(serialDescriptor, 2);
            list3 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            list = list4;
            zC = compositeDecoderB.C(serialDescriptor, 4);
            str = strM;
            i3 = 31;
            list2 = list5;
        } else {
            int i5 = 1;
            boolean zC2 = false;
            List list6 = null;
            List list7 = null;
            String strM2 = null;
            List list8 = null;
            int i6 = 0;
            while (i5 != 0) {
                int iO = compositeDecoderB.o(serialDescriptor);
                int i7 = i4;
                if (iO == -1) {
                    i4 = i7;
                    i5 = i4;
                } else if (iO != 0) {
                    if (iO == 1) {
                        list7 = (List) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], list7);
                        i6 |= 2;
                    } else if (iO == 2) {
                        strM2 = compositeDecoderB.m(serialDescriptor, 2);
                        i6 |= 4;
                    } else if (iO == 3) {
                        list8 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], list8);
                        i6 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new UnknownFieldException(iO);
                        }
                        zC2 = compositeDecoderB.C(serialDescriptor, 4);
                        i6 |= 16;
                    }
                    i4 = i7;
                } else {
                    list6 = (List) compositeDecoderB.y(serialDescriptor, i7, kSerializerArr[i7], list6);
                    i6 |= 1;
                    i4 = i7;
                }
            }
            zC = zC2;
            i3 = i6;
            list = list6;
            list2 = list7;
            str = strM2;
            list3 = list8;
        }
        compositeDecoderB.c(serialDescriptor);
        return new CustomerInfo(i3, list, list2, str, list3, zC, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CustomerInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CustomerInfo.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
