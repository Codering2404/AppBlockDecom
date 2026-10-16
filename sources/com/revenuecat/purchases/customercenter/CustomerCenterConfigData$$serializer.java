package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
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
public final class CustomerCenterConfigData$$serializer implements GeneratedSerializer<CustomerCenterConfigData> {
    public static final CustomerCenterConfigData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$$serializer customerCenterConfigData$$serializer = new CustomerCenterConfigData$$serializer();
        INSTANCE = customerCenterConfigData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData", customerCenterConfigData$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("screens", false);
        pluginGeneratedSerialDescriptor.p("appearance", false);
        pluginGeneratedSerialDescriptor.p("localization", false);
        pluginGeneratedSerialDescriptor.p("support", false);
        pluginGeneratedSerialDescriptor.p("last_published_app_version", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ScreenMapSerializer.INSTANCE, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, CustomerCenterConfigData$Localization$$serializer.INSTANCE, CustomerCenterConfigData$Support$$serializer.INSTANCE, BuiltinSerializersKt.u(EmptyStringToNullSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData deserialize(Decoder decoder) {
        int i3;
        Map map;
        CustomerCenterConfigData.Appearance appearance;
        CustomerCenterConfigData.Localization localization;
        CustomerCenterConfigData.Support support;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        Map map2 = null;
        if (compositeDecoderB.p()) {
            Map map3 = (Map) compositeDecoderB.y(descriptor2, 0, ScreenMapSerializer.INSTANCE, null);
            CustomerCenterConfigData.Appearance appearance2 = (CustomerCenterConfigData.Appearance) compositeDecoderB.y(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, null);
            CustomerCenterConfigData.Localization localization2 = (CustomerCenterConfigData.Localization) compositeDecoderB.y(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, null);
            map = map3;
            support = (CustomerCenterConfigData.Support) compositeDecoderB.y(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, null);
            str = (String) compositeDecoderB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, null);
            localization = localization2;
            appearance = appearance2;
            i3 = 31;
        } else {
            boolean z2 = true;
            int i4 = 0;
            CustomerCenterConfigData.Appearance appearance3 = null;
            CustomerCenterConfigData.Localization localization3 = null;
            CustomerCenterConfigData.Support support2 = null;
            String str2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    map2 = (Map) compositeDecoderB.y(descriptor2, 0, ScreenMapSerializer.INSTANCE, map2);
                    i4 |= 1;
                } else if (iO == 1) {
                    appearance3 = (CustomerCenterConfigData.Appearance) compositeDecoderB.y(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, appearance3);
                    i4 |= 2;
                } else if (iO == 2) {
                    localization3 = (CustomerCenterConfigData.Localization) compositeDecoderB.y(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, localization3);
                    i4 |= 4;
                } else if (iO == 3) {
                    support2 = (CustomerCenterConfigData.Support) compositeDecoderB.y(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, support2);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    str2 = (String) compositeDecoderB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str2);
                    i4 |= 16;
                }
            }
            i3 = i4;
            map = map2;
            appearance = appearance3;
            localization = localization3;
            support = support2;
            str = str2;
        }
        compositeDecoderB.c(descriptor2);
        return new CustomerCenterConfigData(i3, map, appearance, localization, support, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        CustomerCenterConfigData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
