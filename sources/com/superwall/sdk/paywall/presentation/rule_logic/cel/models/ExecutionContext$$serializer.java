package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
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
public /* synthetic */ class ExecutionContext$$serializer implements GeneratedSerializer<ExecutionContext> {
    public static final ExecutionContext$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ExecutionContext$$serializer executionContext$$serializer = new ExecutionContext$$serializer();
        INSTANCE = executionContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ExecutionContext", executionContext$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("variables", false);
        pluginGeneratedSerialDescriptor.p("expression", false);
        pluginGeneratedSerialDescriptor.p("computed", false);
        pluginGeneratedSerialDescriptor.p(DeviceRequestsHelper.DEVICE_INFO_DEVICE, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ExecutionContext$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ExecutionContext.$childSerializers;
        return new KSerializer[]{PassableMap$$serializer.INSTANCE, StringSerializer.f142891a, kSerializerArr[2], kSerializerArr[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ExecutionContext deserialize(Decoder decoder) {
        int i3;
        PassableMap passableMap;
        String str;
        Map map;
        Map map2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = ExecutionContext.$childSerializers;
        PassableMap passableMap2 = null;
        if (compositeDecoderB.p()) {
            PassableMap passableMap3 = (PassableMap) compositeDecoderB.y(serialDescriptor, 0, PassableMap$$serializer.INSTANCE, null);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            Map map3 = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            map2 = (Map) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            passableMap = passableMap3;
            i3 = 15;
            map = map3;
            str = strM;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM2 = null;
            Map map4 = null;
            Map map5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    passableMap2 = (PassableMap) compositeDecoderB.y(serialDescriptor, 0, PassableMap$$serializer.INSTANCE, passableMap2);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    map4 = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], map4);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    map5 = (Map) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], map5);
                    i4 |= 8;
                }
            }
            i3 = i4;
            passableMap = passableMap2;
            str = strM2;
            map = map4;
            map2 = map5;
        }
        compositeDecoderB.c(serialDescriptor);
        return new ExecutionContext(i3, passableMap, str, map, map2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ExecutionContext value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        ExecutionContext.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
