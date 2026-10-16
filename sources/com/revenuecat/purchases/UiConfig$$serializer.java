package com.revenuecat.purchases;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.common.LocalizedVariableLocalizationKeyMapSerializer;
import java.util.Map;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@Deprecated
public final class UiConfig$$serializer implements GeneratedSerializer<UiConfig> {
    public static final UiConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UiConfig$$serializer uiConfig$$serializer = new UiConfig$$serializer();
        INSTANCE = uiConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.UiConfig", uiConfig$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("app", true);
        pluginGeneratedSerialDescriptor.p("localizations", true);
        pluginGeneratedSerialDescriptor.p("variable_config", true);
        pluginGeneratedSerialDescriptor.p("custom_variables", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UiConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{UiConfig$AppConfig$$serializer.INSTANCE, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, UiConfig$VariableConfig$$serializer.INSTANCE, UiConfig.$childSerializers[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UiConfig deserialize(Decoder decoder) {
        int i3;
        UiConfig.AppConfig appConfig;
        Map map;
        UiConfig.VariableConfig variableConfig;
        Map map2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = UiConfig.$childSerializers;
        UiConfig.AppConfig appConfig2 = null;
        if (compositeDecoderB.p()) {
            UiConfig.AppConfig appConfig3 = (UiConfig.AppConfig) compositeDecoderB.y(descriptor2, 0, UiConfig$AppConfig$$serializer.INSTANCE, null);
            Map map3 = (Map) compositeDecoderB.y(descriptor2, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, null);
            UiConfig.VariableConfig variableConfig2 = (UiConfig.VariableConfig) compositeDecoderB.y(descriptor2, 2, UiConfig$VariableConfig$$serializer.INSTANCE, null);
            map2 = (Map) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], null);
            appConfig = appConfig3;
            variableConfig = variableConfig2;
            i3 = 15;
            map = map3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Map map4 = null;
            UiConfig.VariableConfig variableConfig3 = null;
            Map map5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    appConfig2 = (UiConfig.AppConfig) compositeDecoderB.y(descriptor2, 0, UiConfig$AppConfig$$serializer.INSTANCE, appConfig2);
                    i4 |= 1;
                } else if (iO == 1) {
                    map4 = (Map) compositeDecoderB.y(descriptor2, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, map4);
                    i4 |= 2;
                } else if (iO == 2) {
                    variableConfig3 = (UiConfig.VariableConfig) compositeDecoderB.y(descriptor2, 2, UiConfig$VariableConfig$$serializer.INSTANCE, variableConfig3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    map5 = (Map) compositeDecoderB.y(descriptor2, 3, kSerializerArr[3], map5);
                    i4 |= 8;
                }
            }
            i3 = i4;
            appConfig = appConfig2;
            map = map4;
            variableConfig = variableConfig3;
            map2 = map5;
        }
        compositeDecoderB.c(descriptor2);
        return new UiConfig(i3, appConfig, map, variableConfig, map2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        UiConfig.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
