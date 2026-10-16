package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class CustomerCenterConfigData$Screen$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Screen> {
    public static final CustomerCenterConfigData$Screen$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Screen$$serializer customerCenterConfigData$Screen$$serializer = new CustomerCenterConfigData$Screen$$serializer();
        INSTANCE = customerCenterConfigData$Screen$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen", customerCenterConfigData$Screen$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("subtitle", true);
        pluginGeneratedSerialDescriptor.p("paths", false);
        pluginGeneratedSerialDescriptor.p("offering", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Screen$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CustomerCenterConfigData.Screen.$childSerializers[0], StringSerializer.f142891a, BuiltinSerializersKt.u(EmptyStringToNullSerializer.INSTANCE), HelpPathsSerializer.INSTANCE, BuiltinSerializersKt.u(CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Screen deserialize(Decoder decoder) {
        int i3;
        CustomerCenterConfigData.Screen.ScreenType screenType;
        String str;
        String str2;
        List list;
        CustomerCenterConfigData.ScreenOffering screenOffering;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.Screen.$childSerializers;
        int i4 = 0;
        CustomerCenterConfigData.Screen.ScreenType screenType2 = null;
        if (compositeDecoderB.p()) {
            CustomerCenterConfigData.Screen.ScreenType screenType3 = (CustomerCenterConfigData.Screen.ScreenType) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            String strM = compositeDecoderB.m(descriptor2, 1);
            String str3 = (String) compositeDecoderB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, null);
            screenType = screenType3;
            str = strM;
            list = (List) compositeDecoderB.y(descriptor2, 3, HelpPathsSerializer.INSTANCE, null);
            screenOffering = (CustomerCenterConfigData.ScreenOffering) compositeDecoderB.n(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, null);
            str2 = str3;
            i3 = 31;
        } else {
            int i5 = 1;
            int i6 = 0;
            String strM2 = null;
            String str4 = null;
            List list2 = null;
            CustomerCenterConfigData.ScreenOffering screenOffering2 = null;
            while (i5 != 0) {
                int iO = compositeDecoderB.o(descriptor2);
                int i7 = i4;
                if (iO == -1) {
                    i4 = i7;
                    i5 = i4;
                } else if (iO != 0) {
                    if (iO == 1) {
                        strM2 = compositeDecoderB.m(descriptor2, 1);
                        i6 |= 2;
                    } else if (iO == 2) {
                        str4 = (String) compositeDecoderB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str4);
                        i6 |= 4;
                    } else if (iO == 3) {
                        list2 = (List) compositeDecoderB.y(descriptor2, 3, HelpPathsSerializer.INSTANCE, list2);
                        i6 |= 8;
                    } else {
                        if (iO != 4) {
                            throw new UnknownFieldException(iO);
                        }
                        screenOffering2 = (CustomerCenterConfigData.ScreenOffering) compositeDecoderB.n(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, screenOffering2);
                        i6 |= 16;
                    }
                    i4 = i7;
                } else {
                    screenType2 = (CustomerCenterConfigData.Screen.ScreenType) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i7], screenType2);
                    i6 |= 1;
                    i4 = i7;
                }
            }
            i3 = i6;
            screenType = screenType2;
            str = strM2;
            str2 = str4;
            list = list2;
            screenOffering = screenOffering2;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData.Screen(i3, screenType, str, str2, list, screenOffering, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Screen value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.Screen.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
