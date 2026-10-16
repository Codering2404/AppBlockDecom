package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression;
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
public /* synthetic */ class CELExpression$Or$$serializer implements GeneratedSerializer<CELExpression.Or> {
    public static final CELExpression$Or$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CELExpression$Or$$serializer cELExpression$Or$$serializer = new CELExpression$Or$$serializer();
        INSTANCE = cELExpression$Or$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("Or", cELExpression$Or$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_LEFT_KEY, false);
        pluginGeneratedSerialDescriptor.p("right", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CELExpression$Or$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CELExpression.Or.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CELExpression.Or deserialize(Decoder decoder) {
        CELExpression cELExpression;
        CELExpression cELExpression2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = CELExpression.Or.$childSerializers;
        if (compositeDecoderB.p()) {
            cELExpression2 = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            cELExpression = (CELExpression) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            CELExpression cELExpression3 = null;
            CELExpression cELExpression4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    cELExpression4 = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], cELExpression4);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    cELExpression3 = (CELExpression) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], cELExpression3);
                    i4 |= 2;
                }
            }
            cELExpression = cELExpression3;
            cELExpression2 = cELExpression4;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new CELExpression.Or(i3, cELExpression2, cELExpression, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CELExpression.Or value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CELExpression.Or.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
