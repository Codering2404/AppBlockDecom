package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class ComponentOverride$$serializer<T> implements GeneratedSerializer<ComponentOverride<T>> {
    private final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;
    private final /* synthetic */ KSerializer<?> typeSerial0;

    private ComponentOverride$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", this, 2);
        pluginGeneratedSerialDescriptor.p("conditions", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.PROPERTIES_KEY, false);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    private final KSerializer<T> getTypeSerial0() {
        return (KSerializer<T>) this.typeSerial0;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ComponentOverride.$childSerializers[0], this.typeSerial0};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ComponentOverride<T> deserialize(Decoder decoder) {
        List list;
        PartialComponent partialComponent;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor);
        KSerializer[] kSerializerArr = ComponentOverride.$childSerializers;
        SerializationConstructorMarker serializationConstructorMarker = null;
        if (compositeDecoderB.p()) {
            list = (List) compositeDecoderB.y(descriptor, 0, kSerializerArr[0], null);
            partialComponent = (PartialComponent) compositeDecoderB.y(descriptor, 1, this.typeSerial0, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list2 = null;
            PartialComponent partialComponent2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    list2 = (List) compositeDecoderB.y(descriptor, 0, kSerializerArr[0], list2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    partialComponent2 = (PartialComponent) compositeDecoderB.y(descriptor, 1, this.typeSerial0, partialComponent2);
                    i4 |= 2;
                }
            }
            list = list2;
            partialComponent = partialComponent2;
            i3 = i4;
        }
        compositeDecoderB.c(descriptor);
        return new ComponentOverride<>(i3, list, partialComponent, serializationConstructorMarker);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ComponentOverride<T> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor);
        ComponentOverride.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor, this.typeSerial0);
        compositeEncoderB.c(descriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return new KSerializer[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ ComponentOverride$$serializer(KSerializer typeSerial0) {
        this();
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
