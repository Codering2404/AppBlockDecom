package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

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
public final class ComponentOverride$Condition$Variable$$serializer implements GeneratedSerializer<ComponentOverride.Condition.Variable> {
    public static final ComponentOverride$Condition$Variable$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ComponentOverride$Condition$Variable$$serializer componentOverride$Condition$Variable$$serializer = new ComponentOverride$Condition$Variable$$serializer();
        INSTANCE = componentOverride$Condition$Variable$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Variable", componentOverride$Condition$Variable$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("operator", false);
        pluginGeneratedSerialDescriptor.p("variable", false);
        pluginGeneratedSerialDescriptor.p("value", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ComponentOverride$Condition$Variable$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ComponentOverride.Condition.Variable.$childSerializers[0], StringSerializer.f142891a, JsonPrimitiveSerializer.f143032a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ComponentOverride.Condition.Variable deserialize(Decoder decoder) {
        int i3;
        ComponentOverride.EqualityOperator equalityOperator;
        String strM;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ComponentOverride.Condition.Variable.$childSerializers;
        ComponentOverride.EqualityOperator equalityOperator2 = null;
        if (compositeDecoderB.p()) {
            equalityOperator = (ComponentOverride.EqualityOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            strM = compositeDecoderB.m(descriptor2, 1);
            jsonPrimitive = (JsonPrimitive) compositeDecoderB.y(descriptor2, 2, JsonPrimitiveSerializer.f143032a, null);
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM2 = null;
            JsonPrimitive jsonPrimitive2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    equalityOperator2 = (ComponentOverride.EqualityOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], equalityOperator2);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM2 = compositeDecoderB.m(descriptor2, 1);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    jsonPrimitive2 = (JsonPrimitive) compositeDecoderB.y(descriptor2, 2, JsonPrimitiveSerializer.f143032a, jsonPrimitive2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            equalityOperator = equalityOperator2;
            strM = strM2;
            jsonPrimitive = jsonPrimitive2;
        }
        compositeDecoderB.c(descriptor2);
        return new ComponentOverride.Condition.Variable(i3, equalityOperator, strM, jsonPrimitive, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ComponentOverride.Condition.Variable value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ComponentOverride.Condition.Variable.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
