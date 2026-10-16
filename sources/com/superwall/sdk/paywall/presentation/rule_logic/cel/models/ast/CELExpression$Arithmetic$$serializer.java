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
public /* synthetic */ class CELExpression$Arithmetic$$serializer implements GeneratedSerializer<CELExpression.Arithmetic> {
    public static final CELExpression$Arithmetic$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CELExpression$Arithmetic$$serializer cELExpression$Arithmetic$$serializer = new CELExpression$Arithmetic$$serializer();
        INSTANCE = cELExpression$Arithmetic$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("Arithmetic", cELExpression$Arithmetic$$serializer, 3);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_LEFT_KEY, false);
        pluginGeneratedSerialDescriptor.p("op", false);
        pluginGeneratedSerialDescriptor.p("right", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CELExpression$Arithmetic$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CELExpression.Arithmetic.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], kSerializerArr[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CELExpression.Arithmetic deserialize(Decoder decoder) {
        int i3;
        CELExpression cELExpression;
        CELArithmeticOp cELArithmeticOp;
        CELExpression cELExpression2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = CELExpression.Arithmetic.$childSerializers;
        CELExpression cELExpression3 = null;
        if (compositeDecoderB.p()) {
            CELExpression cELExpression4 = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            CELArithmeticOp cELArithmeticOp2 = (CELArithmeticOp) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            cELExpression2 = (CELExpression) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            cELExpression = cELExpression4;
            i3 = 7;
            cELArithmeticOp = cELArithmeticOp2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            CELArithmeticOp cELArithmeticOp3 = null;
            CELExpression cELExpression5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    cELExpression3 = (CELExpression) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], cELExpression3);
                    i4 |= 1;
                } else if (iO == 1) {
                    cELArithmeticOp3 = (CELArithmeticOp) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], cELArithmeticOp3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    cELExpression5 = (CELExpression) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], cELExpression5);
                    i4 |= 4;
                }
            }
            i3 = i4;
            cELExpression = cELExpression3;
            cELArithmeticOp = cELArithmeticOp3;
            cELExpression2 = cELExpression5;
        }
        compositeDecoderB.c(serialDescriptor);
        return new CELExpression.Arithmetic(i3, cELExpression, cELArithmeticOp, cELExpression2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CELExpression.Arithmetic value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        CELExpression.Arithmetic.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
