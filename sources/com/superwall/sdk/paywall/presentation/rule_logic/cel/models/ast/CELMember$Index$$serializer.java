package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELMember;
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
public /* synthetic */ class CELMember$Index$$serializer implements GeneratedSerializer<CELMember.Index> {
    public static final CELMember$Index$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private CELMember$Index$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CELMember.Index.$childSerializers[0]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CELMember.Index deserialize(Decoder decoder) {
        CELExpression cELExpression;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = CELMember.Index.$childSerializers;
        int i3 = 1;
        if (compositeDecoderB.p()) {
            cELExpression = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            CELExpression cELExpression2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    cELExpression2 = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], cELExpression2);
                    i4 = 1;
                }
            }
            cELExpression = cELExpression2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new CELMember.Index(i3, cELExpression, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CELMember.Index value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CELMember.Index.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        CELMember$Index$$serializer cELMember$Index$$serializer = new CELMember$Index$$serializer();
        INSTANCE = cELMember$Index$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("Index", cELMember$Index$$serializer, 1);
        pluginGeneratedSerialDescriptor.p(QaXmqxvjHhxVy.gUyjDrF, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
