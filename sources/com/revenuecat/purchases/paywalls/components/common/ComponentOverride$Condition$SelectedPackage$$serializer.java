package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import java.util.List;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class ComponentOverride$Condition$SelectedPackage$$serializer implements GeneratedSerializer<ComponentOverride.Condition.SelectedPackage> {
    public static final ComponentOverride$Condition$SelectedPackage$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ComponentOverride$Condition$SelectedPackage$$serializer componentOverride$Condition$SelectedPackage$$serializer = new ComponentOverride$Condition$SelectedPackage$$serializer();
        INSTANCE = componentOverride$Condition$SelectedPackage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.SelectedPackage", componentOverride$Condition$SelectedPackage$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("operator", false);
        pluginGeneratedSerialDescriptor.p("packages", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ComponentOverride$Condition$SelectedPackage$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ComponentOverride.Condition.SelectedPackage.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ComponentOverride.Condition.SelectedPackage deserialize(Decoder decoder) {
        List list;
        ComponentOverride.ArrayOperator arrayOperator;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = ComponentOverride.Condition.SelectedPackage.$childSerializers;
        if (compositeDecoderB.p()) {
            arrayOperator = (ComponentOverride.ArrayOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], null);
            list = (List) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list2 = null;
            ComponentOverride.ArrayOperator arrayOperator2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    arrayOperator2 = (ComponentOverride.ArrayOperator) compositeDecoderB.y(descriptor2, 0, kSerializerArr[0], arrayOperator2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) compositeDecoderB.y(descriptor2, 1, kSerializerArr[1], list2);
                    i4 |= 2;
                }
            }
            list = list2;
            arrayOperator = arrayOperator2;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor2);
        return new ComponentOverride.Condition.SelectedPackage(i3, arrayOperator, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ComponentOverride.Condition.SelectedPackage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ComponentOverride.Condition.SelectedPackage.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
