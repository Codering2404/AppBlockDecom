package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class PassableValue$FunctionValue$$serializer implements GeneratedSerializer<PassableValue.FunctionValue> {
    public static final PassableValue$FunctionValue$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PassableValue$FunctionValue$$serializer passableValue$FunctionValue$$serializer = new PassableValue$FunctionValue$$serializer();
        INSTANCE = passableValue$FunctionValue$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("function", passableValue$FunctionValue$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("value", false);
        pluginGeneratedSerialDescriptor.p("args", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PassableValue$FunctionValue$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a, BuiltinSerializersKt.u(PassableValue.FunctionValue.$childSerializers[1])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PassableValue.FunctionValue deserialize(Decoder decoder) {
        PassableValue passableValue;
        String strM;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = PassableValue.FunctionValue.$childSerializers;
        SerializationConstructorMarker serializationConstructorMarker = null;
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            passableValue = (PassableValue) compositeDecoderB.n(serialDescriptor, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PassableValue passableValue2 = null;
            String strM2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM2 = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    passableValue2 = (PassableValue) compositeDecoderB.n(serialDescriptor, 1, kSerializerArr[1], passableValue2);
                    i4 |= 2;
                }
            }
            passableValue = passableValue2;
            strM = strM2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PassableValue.FunctionValue(i3, strM, passableValue, serializationConstructorMarker);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PassableValue.FunctionValue value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PassableValue.FunctionValue.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
