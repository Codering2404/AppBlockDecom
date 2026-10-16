package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.UiConfig$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.JsonObjectToMapSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class PublishedWorkflow$$serializer implements GeneratedSerializer<PublishedWorkflow> {
    public static final PublishedWorkflow$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PublishedWorkflow$$serializer publishedWorkflow$$serializer = new PublishedWorkflow$$serializer();
        INSTANCE = publishedWorkflow$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.PublishedWorkflow", publishedWorkflow$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("display_name", false);
        pluginGeneratedSerialDescriptor.p("initial_step_id", false);
        pluginGeneratedSerialDescriptor.p("steps", false);
        pluginGeneratedSerialDescriptor.p("screens", false);
        pluginGeneratedSerialDescriptor.p("ui_config", false);
        pluginGeneratedSerialDescriptor.p("metadata", true);
        pluginGeneratedSerialDescriptor.p("hash", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PublishedWorkflow$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PublishedWorkflow.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, kSerializerArr[3], kSerializerArr[4], UiConfig$$serializer.INSTANCE, JsonObjectToMapSerializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PublishedWorkflow deserialize(Decoder decoder) {
        int i3;
        Map map;
        String str;
        UiConfig uiConfig;
        Map map2;
        String str2;
        String str3;
        String str4;
        Map map3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = PublishedWorkflow.$childSerializers;
        int i4 = 7;
        int i5 = 4;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String strM3 = compositeDecoderB.m(descriptor2, 1);
            String strM4 = compositeDecoderB.m(descriptor2, 2);
            Map map4 = (Map) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], null);
            Map map5 = (Map) compositeDecoderB.y(descriptor2, 4, kSerializerArr[4], null);
            UiConfig uiConfig2 = (UiConfig) compositeDecoderB.y(descriptor2, 5, UiConfig$$serializer.INSTANCE, null);
            Map map6 = (Map) compositeDecoderB.y(descriptor2, 6, JsonObjectToMapSerializer.INSTANCE, null);
            map2 = map5;
            str2 = strM2;
            str = (String) compositeDecoderB.n(descriptor2, 7, StringSerializer.f142891a, null);
            map = map6;
            uiConfig = uiConfig2;
            str4 = strM4;
            map3 = map4;
            i3 = 255;
            str3 = strM3;
        } else {
            boolean z2 = true;
            int i6 = 0;
            Map map7 = null;
            String str5 = null;
            UiConfig uiConfig3 = null;
            Map map8 = null;
            String strM5 = null;
            String strM6 = null;
            Map map9 = null;
            while (z2) {
                int i7 = i5;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i5 = 4;
                        break;
                    case 0:
                        i6 |= 1;
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i4 = 7;
                        i5 = 4;
                        break;
                    case 1:
                        i6 |= 2;
                        strM5 = compositeDecoderB.m(descriptor2, 1);
                        i4 = 7;
                        i5 = 4;
                        break;
                    case 2:
                        strM6 = compositeDecoderB.m(descriptor2, 2);
                        i6 |= 4;
                        i4 = 7;
                        i5 = 4;
                        break;
                    case 3:
                        map9 = (Map) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], map9);
                        i6 |= 8;
                        i4 = 7;
                        i5 = 4;
                        break;
                    case 4:
                        map8 = (Map) compositeDecoderB.y(descriptor2, i7, kSerializerArr[i7], map8);
                        i6 |= 16;
                        i5 = i7;
                        i4 = 7;
                        break;
                    case 5:
                        uiConfig3 = (UiConfig) compositeDecoderB.y(descriptor2, 5, UiConfig$$serializer.INSTANCE, uiConfig3);
                        i6 |= 32;
                        i5 = i7;
                        break;
                    case 6:
                        map7 = (Map) compositeDecoderB.y(descriptor2, 6, JsonObjectToMapSerializer.INSTANCE, map7);
                        i6 |= 64;
                        i5 = i7;
                        break;
                    case 7:
                        str5 = (String) compositeDecoderB.n(descriptor2, i4, StringSerializer.f142891a, str5);
                        i6 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i5 = i7;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i6;
            map = map7;
            str = str5;
            uiConfig = uiConfig3;
            map2 = map8;
            str2 = strM;
            str3 = strM5;
            str4 = strM6;
            map3 = map9;
        }
        compositeDecoderB.c(descriptor2);
        return new PublishedWorkflow(i3, str2, str3, str4, map3, map2, uiConfig, map, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PublishedWorkflow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PublishedWorkflow.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
