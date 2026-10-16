package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.common.ResilientPromoOfferConfigSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class PackageComponent$$serializer implements GeneratedSerializer<PackageComponent> {
    public static final PackageComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PackageComponent$$serializer packageComponent$$serializer = new PackageComponent$$serializer();
        INSTANCE = packageComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("package", packageComponent$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("package_id", false);
        pluginGeneratedSerialDescriptor.p("is_selected_by_default", false);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("play_store_offer", true);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PackageComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PackageComponent.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{stringSerializer, booleanSerializer, StackComponent$$serializer.INSTANCE, BuiltinSerializersKt.u(ResilientPromoOfferConfigSerializer.INSTANCE), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(booleanSerializer), kSerializerArr[6]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PackageComponent deserialize(Decoder decoder) {
        int i3;
        List list;
        Boolean bool;
        boolean z2;
        String str;
        StackComponent stackComponent;
        PromoOfferConfig promoOfferConfig;
        String str2;
        char c3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PackageComponent.$childSerializers;
        int i4 = 5;
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            boolean zC = compositeDecoderB.C(descriptor2, 1);
            StackComponent stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            PromoOfferConfig promoOfferConfig2 = (PromoOfferConfig) compositeDecoderB.n(descriptor2, 3, ResilientPromoOfferConfigSerializer.INSTANCE, null);
            String str3 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 5, BooleanSerializer.f142767a, null);
            list = (List) compositeDecoderB.y(descriptor2, 6, kSerializerArr[6], null);
            str = strM;
            bool = bool2;
            promoOfferConfig = promoOfferConfig2;
            str2 = str3;
            stackComponent = stackComponent2;
            i3 = 127;
            z2 = zC;
        } else {
            boolean z3 = true;
            int i5 = 0;
            List list2 = null;
            String strM2 = null;
            StackComponent stackComponent3 = null;
            PromoOfferConfig promoOfferConfig3 = null;
            String str4 = null;
            boolean zC2 = false;
            Boolean bool3 = null;
            while (z3) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z3 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        strM2 = compositeDecoderB.m(descriptor2, 0);
                        i4 = 5;
                        break;
                    case 1:
                        c3 = 2;
                        zC2 = compositeDecoderB.C(descriptor2, 1);
                        i5 |= 2;
                        i4 = 5;
                        break;
                    case 2:
                        c3 = 2;
                        stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent3);
                        i5 |= 4;
                        i4 = 5;
                        break;
                    case 3:
                        promoOfferConfig3 = (PromoOfferConfig) compositeDecoderB.n(descriptor2, 3, ResilientPromoOfferConfigSerializer.INSTANCE, promoOfferConfig3);
                        i5 |= 8;
                        break;
                    case 4:
                        str4 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str4);
                        i5 |= 16;
                        break;
                    case 5:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, i4, BooleanSerializer.f142767a, bool3);
                        i5 |= 32;
                        break;
                    case 6:
                        list2 = (List) compositeDecoderB.y(descriptor2, 6, kSerializerArr[6], list2);
                        i5 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            list = list2;
            bool = bool3;
            z2 = zC2;
            str = strM2;
            stackComponent = stackComponent3;
            promoOfferConfig = promoOfferConfig3;
            str2 = str4;
        }
        compositeDecoderB.c(descriptor2);
        return new PackageComponent(i3, str, z2, stackComponent, promoOfferConfig, str2, bool, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PackageComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PackageComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
