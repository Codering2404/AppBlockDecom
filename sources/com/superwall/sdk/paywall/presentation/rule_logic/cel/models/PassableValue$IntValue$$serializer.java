package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.facebook.LegacyTokenHelper;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

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
public /* synthetic */ class PassableValue$IntValue$$serializer implements GeneratedSerializer<PassableValue.IntValue> {
    public static final PassableValue$IntValue$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PassableValue$IntValue$$serializer passableValue$IntValue$$serializer = new PassableValue$IntValue$$serializer();
        INSTANCE = passableValue$IntValue$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(LegacyTokenHelper.TYPE_INTEGER, passableValue$IntValue$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PassableValue$IntValue$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.f142823a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PassableValue.IntValue deserialize(Decoder decoder) {
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i4 = 1;
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(serialDescriptor, 0);
        } else {
            boolean z2 = true;
            i3 = 0;
            int i5 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    i3 = compositeDecoderB.i(serialDescriptor, 0);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PassableValue.IntValue(i4, i3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PassableValue.IntValue value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        compositeEncoderB.w(serialDescriptor, 0, value.value);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
