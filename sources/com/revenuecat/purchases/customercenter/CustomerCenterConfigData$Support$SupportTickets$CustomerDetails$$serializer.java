package com.revenuecat.purchases.customercenter;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Support.SupportTickets.CustomerDetails> {
    public static final CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer = new CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer();
        INSTANCE = customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerDetails", customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer, 14);
        pluginGeneratedSerialDescriptor.p("active_entitlements", true);
        pluginGeneratedSerialDescriptor.p("app_user_id", true);
        pluginGeneratedSerialDescriptor.p("att_consent", true);
        pluginGeneratedSerialDescriptor.p(UserDataStore.COUNTRY, true);
        pluginGeneratedSerialDescriptor.p("device_version", true);
        pluginGeneratedSerialDescriptor.p(AuthenticationTokenClaims.JSON_KEY_EMAIL, true);
        pluginGeneratedSerialDescriptor.p("facebook_anon_id", true);
        pluginGeneratedSerialDescriptor.p("idfa", true);
        pluginGeneratedSerialDescriptor.p("idfv", true);
        pluginGeneratedSerialDescriptor.p("ip", true);
        pluginGeneratedSerialDescriptor.p("last_opened", true);
        pluginGeneratedSerialDescriptor.p("last_seen_app_version", true);
        pluginGeneratedSerialDescriptor.p("total_spent", true);
        pluginGeneratedSerialDescriptor.p("user_since", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Support.SupportTickets.CustomerDetails deserialize(Decoder decoder) {
        int i3;
        boolean z2;
        boolean z3;
        boolean zC;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean zC2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 0;
        if (compositeDecoderB.p()) {
            boolean zC3 = compositeDecoderB.C(descriptor2, 0);
            boolean zC4 = compositeDecoderB.C(descriptor2, 1);
            boolean zC5 = compositeDecoderB.C(descriptor2, 2);
            boolean zC6 = compositeDecoderB.C(descriptor2, 3);
            boolean zC7 = compositeDecoderB.C(descriptor2, 4);
            boolean zC8 = compositeDecoderB.C(descriptor2, 5);
            boolean zC9 = compositeDecoderB.C(descriptor2, 6);
            boolean zC10 = compositeDecoderB.C(descriptor2, 7);
            boolean zC11 = compositeDecoderB.C(descriptor2, 8);
            boolean zC12 = compositeDecoderB.C(descriptor2, 9);
            boolean zC13 = compositeDecoderB.C(descriptor2, 10);
            boolean zC14 = compositeDecoderB.C(descriptor2, 11);
            z2 = zC3;
            z3 = zC4;
            zC = compositeDecoderB.C(descriptor2, 12);
            z4 = zC14;
            z5 = zC13;
            z6 = zC12;
            z7 = zC10;
            z8 = zC9;
            z9 = zC8;
            z10 = zC6;
            z11 = zC11;
            z12 = zC7;
            z13 = zC5;
            zC2 = compositeDecoderB.C(descriptor2, 13);
            i3 = 16383;
        } else {
            int i5 = 13;
            boolean zC15 = false;
            boolean zC16 = false;
            boolean zC17 = false;
            boolean zC18 = false;
            boolean zC19 = false;
            boolean zC20 = false;
            boolean zC21 = false;
            boolean zC22 = false;
            boolean zC23 = false;
            boolean zC24 = false;
            boolean zC25 = false;
            boolean zC26 = false;
            boolean zC27 = false;
            boolean zC28 = false;
            boolean z14 = true;
            while (z14) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z14 = false;
                        i5 = 13;
                        break;
                    case 0:
                        zC15 = compositeDecoderB.C(descriptor2, 0);
                        i4 |= 1;
                        i5 = 13;
                        break;
                    case 1:
                        zC16 = compositeDecoderB.C(descriptor2, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        zC27 = compositeDecoderB.C(descriptor2, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        zC24 = compositeDecoderB.C(descriptor2, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        zC26 = compositeDecoderB.C(descriptor2, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        zC23 = compositeDecoderB.C(descriptor2, 5);
                        i4 |= 32;
                        break;
                    case 6:
                        zC22 = compositeDecoderB.C(descriptor2, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        zC21 = compositeDecoderB.C(descriptor2, 7);
                        i4 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        zC25 = compositeDecoderB.C(descriptor2, 8);
                        i4 |= Function.MAX_NARGS;
                        break;
                    case 9:
                        zC20 = compositeDecoderB.C(descriptor2, 9);
                        i4 |= 512;
                        break;
                    case 10:
                        zC19 = compositeDecoderB.C(descriptor2, 10);
                        i4 |= 1024;
                        break;
                    case 11:
                        zC18 = compositeDecoderB.C(descriptor2, 11);
                        i4 |= 2048;
                        break;
                    case 12:
                        zC17 = compositeDecoderB.C(descriptor2, 12);
                        i4 |= 4096;
                        break;
                    case 13:
                        zC28 = compositeDecoderB.C(descriptor2, i5);
                        i4 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            z2 = zC15;
            z3 = zC16;
            zC = zC17;
            z4 = zC18;
            z5 = zC19;
            z6 = zC20;
            z7 = zC21;
            z8 = zC22;
            z9 = zC23;
            z10 = zC24;
            z11 = zC25;
            z12 = zC26;
            z13 = zC27;
            zC2 = zC28;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Support.SupportTickets.CustomerDetails(i3, z2, z3, z13, z10, z12, z9, z8, z7, z11, z6, z5, z4, zC, zC2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Support.SupportTickets.CustomerDetails value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
