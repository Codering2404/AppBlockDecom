package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.List;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
public final class PaywallComponentsData$$serializer implements GeneratedSerializer<PaywallComponentsData> {
    public static final PaywallComponentsData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentsData$$serializer paywallComponentsData$$serializer = new PaywallComponentsData$$serializer();
        INSTANCE = paywallComponentsData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData", paywallComponentsData$$serializer, 10);
        pluginGeneratedSerialDescriptor.p("id", true);
        pluginGeneratedSerialDescriptor.p("template_name", false);
        pluginGeneratedSerialDescriptor.p("asset_base_url", false);
        pluginGeneratedSerialDescriptor.p("components_config", false);
        pluginGeneratedSerialDescriptor.p("components_localizations", false);
        pluginGeneratedSerialDescriptor.p("default_locale", false);
        pluginGeneratedSerialDescriptor.p("revision", true);
        pluginGeneratedSerialDescriptor.p("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.p("exit_offers", true);
        pluginGeneratedSerialDescriptor.p("play_store_product_change_mode", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentsData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallComponentsData.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), stringSerializer, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, kSerializerArr[4], LocaleId$$serializer.INSTANCE, IntSerializer.f142823a, GoogleListSerializer.INSTANCE, BuiltinSerializersKt.u(ExitOffers$$serializer.INSTANCE), BuiltinSerializersKt.u(ProductChangeConfigSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentsData deserialize(Decoder decoder) {
        Map map;
        URL url;
        int i3;
        ExitOffers exitOffers;
        ComponentsConfig componentsConfig;
        List list;
        ProductChangeConfig productChangeConfig;
        String str;
        int i4;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PaywallComponentsData.$childSerializers;
        int i5 = 9;
        int i6 = 7;
        int i7 = 6;
        int i8 = 4;
        ProductChangeConfig productChangeConfig2 = null;
        if (compositeDecoderB.p()) {
            String str4 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, null);
            String strM = compositeDecoderB.m(descriptor2, 1);
            URL url2 = (URL) compositeDecoderB.y(descriptor2, 2, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig2 = (ComponentsConfig) compositeDecoderB.y(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, null);
            Map map2 = (Map) compositeDecoderB.y(descriptor2, 4, kSerializerArr[4], null);
            LocaleId localeId = (LocaleId) compositeDecoderB.y(descriptor2, 5, LocaleId$$serializer.INSTANCE, null);
            String strM618unboximpl = localeId != null ? localeId.m618unboximpl() : null;
            int i9 = compositeDecoderB.i(descriptor2, 6);
            List list2 = (List) compositeDecoderB.y(descriptor2, 7, GoogleListSerializer.INSTANCE, null);
            ExitOffers exitOffers2 = (ExitOffers) compositeDecoderB.n(descriptor2, 8, ExitOffers$$serializer.INSTANCE, null);
            map = map2;
            str = str4;
            productChangeConfig = (ProductChangeConfig) compositeDecoderB.n(descriptor2, 9, ProductChangeConfigSerializer.INSTANCE, null);
            list = list2;
            i4 = i9;
            str2 = strM618unboximpl;
            componentsConfig = componentsConfig2;
            exitOffers = exitOffers2;
            url = url2;
            i3 = 1023;
            str3 = strM;
        } else {
            boolean z2 = true;
            int i10 = 0;
            int i11 = 0;
            Map map3 = null;
            ExitOffers exitOffers3 = null;
            ComponentsConfig componentsConfig3 = null;
            List list3 = null;
            String str5 = null;
            String strM618unboximpl2 = null;
            URL url3 = null;
            String strM2 = null;
            while (z2) {
                int i12 = i8;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        i8 = i12;
                        z2 = false;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 0:
                        i8 = i12;
                        str5 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str5);
                        i10 |= 1;
                        i5 = 9;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 1:
                        i8 = i12;
                        strM2 = compositeDecoderB.m(descriptor2, 1);
                        i10 |= 2;
                        i5 = 9;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 2:
                        i8 = i12;
                        url3 = (URL) compositeDecoderB.y(descriptor2, 2, URLSerializer.INSTANCE, url3);
                        i10 |= 4;
                        i5 = 9;
                        i6 = 7;
                        i7 = 6;
                        break;
                    case 3:
                        i8 = i12;
                        componentsConfig3 = (ComponentsConfig) compositeDecoderB.y(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, componentsConfig3);
                        i10 |= 8;
                        i5 = 9;
                        i6 = 7;
                        break;
                    case 4:
                        i8 = i12;
                        map3 = (Map) compositeDecoderB.y(descriptor2, i8, kSerializerArr[i12], map3);
                        i10 |= 16;
                        i5 = 9;
                        break;
                    case 5:
                        LocaleId localeId2 = (LocaleId) compositeDecoderB.y(descriptor2, 5, LocaleId$$serializer.INSTANCE, strM618unboximpl2 != null ? LocaleId.m612boximpl(strM618unboximpl2) : null);
                        strM618unboximpl2 = localeId2 != null ? localeId2.m618unboximpl() : null;
                        i10 |= 32;
                        i8 = i12;
                        i5 = 9;
                        break;
                    case 6:
                        i11 = compositeDecoderB.i(descriptor2, i7);
                        i10 |= 64;
                        i8 = i12;
                        break;
                    case 7:
                        list3 = (List) compositeDecoderB.y(descriptor2, i6, GoogleListSerializer.INSTANCE, list3);
                        i10 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i8 = i12;
                        break;
                    case 8:
                        exitOffers3 = (ExitOffers) compositeDecoderB.n(descriptor2, 8, ExitOffers$$serializer.INSTANCE, exitOffers3);
                        i10 |= Function.MAX_NARGS;
                        i8 = i12;
                        break;
                    case 9:
                        productChangeConfig2 = (ProductChangeConfig) compositeDecoderB.n(descriptor2, i5, ProductChangeConfigSerializer.INSTANCE, productChangeConfig2);
                        i10 |= 512;
                        i8 = i12;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            map = map3;
            url = url3;
            i3 = i10;
            exitOffers = exitOffers3;
            componentsConfig = componentsConfig3;
            list = list3;
            productChangeConfig = productChangeConfig2;
            str = str5;
            i4 = i11;
            str2 = strM618unboximpl2;
            str3 = strM2;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallComponentsData(i3, str, str3, url, componentsConfig, map, str2, i4, list, exitOffers, productChangeConfig, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentsData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallComponentsData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
