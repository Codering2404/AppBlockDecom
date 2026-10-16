package com.revenuecat.purchases.customercenter;

import com.facebook.AuthenticationTokenClaims;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class CustomerCenterConfigData$Support$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Support> {
    public static final CustomerCenterConfigData$Support$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Support$$serializer customerCenterConfigData$Support$$serializer = new CustomerCenterConfigData$Support$$serializer();
        INSTANCE = customerCenterConfigData$Support$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support", customerCenterConfigData$Support$$serializer, 4);
        pluginGeneratedSerialDescriptor.p(AuthenticationTokenClaims.JSON_KEY_EMAIL, true);
        pluginGeneratedSerialDescriptor.p("should_warn_customer_to_update", true);
        pluginGeneratedSerialDescriptor.p("display_virtual_currencies", true);
        pluginGeneratedSerialDescriptor.p("support_tickets", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Support$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(EmptyStringToNullSerializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{kSerializerU, BuiltinSerializersKt.u(booleanSerializer), BuiltinSerializersKt.u(booleanSerializer), CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Support deserialize(Decoder decoder) {
        int i3;
        String str;
        Boolean bool;
        Boolean bool2;
        CustomerCenterConfigData.Support.SupportTickets supportTickets;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String str2 = null;
        if (compositeDecoderB.p()) {
            String str3 = (String) compositeDecoderB.n(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
            Boolean bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, booleanSerializer, null);
            Boolean bool4 = (Boolean) compositeDecoderB.n(descriptor2, 2, booleanSerializer, null);
            str = str3;
            supportTickets = (CustomerCenterConfigData.Support.SupportTickets) compositeDecoderB.y(descriptor2, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, null);
            bool2 = bool4;
            bool = bool3;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Boolean bool5 = null;
            Boolean bool6 = null;
            CustomerCenterConfigData.Support.SupportTickets supportTickets2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    str2 = (String) compositeDecoderB.n(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, str2);
                    i4 |= 1;
                } else if (iO == 1) {
                    bool5 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool5);
                    i4 |= 2;
                } else if (iO == 2) {
                    bool6 = (Boolean) compositeDecoderB.n(descriptor2, 2, BooleanSerializer.f142767a, bool6);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    supportTickets2 = (CustomerCenterConfigData.Support.SupportTickets) compositeDecoderB.y(descriptor2, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, supportTickets2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            str = str2;
            bool = bool5;
            bool2 = bool6;
            supportTickets = supportTickets2;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Support(i3, str, bool, bool2, supportTickets, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Support value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
