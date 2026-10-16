package com.revenuecat.purchases;

import com.revenuecat.purchases.UiConfig;
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
public final class UiConfig$AppConfig$$serializer implements GeneratedSerializer<UiConfig.AppConfig> {
    public static final UiConfig$AppConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UiConfig$AppConfig$$serializer uiConfig$AppConfig$$serializer = new UiConfig$AppConfig$$serializer();
        INSTANCE = uiConfig$AppConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.UiConfig.AppConfig", uiConfig$AppConfig$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("colors", true);
        pluginGeneratedSerialDescriptor.p("fonts", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UiConfig$AppConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = UiConfig.AppConfig.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UiConfig.AppConfig deserialize(Decoder decoder) {
        Map map;
        Map map2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = UiConfig.AppConfig.$childSerializers;
        if (compositeDecoderB.p()) {
            map2 = (Map) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            map = (Map) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Map map3 = null;
            Map map4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    map4 = (Map) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], map4);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    map3 = (Map) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], map3);
                    i4 |= 2;
                }
            }
            map = map3;
            map2 = map4;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new UiConfig.AppConfig(i3, map2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig.AppConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        UiConfig.AppConfig.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
