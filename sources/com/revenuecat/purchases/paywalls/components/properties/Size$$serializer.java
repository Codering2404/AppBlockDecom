package com.revenuecat.purchases.paywalls.components.properties;

import com.facebook.appevents.internal.ViewHierarchyConstants;
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
public final class Size$$serializer implements GeneratedSerializer<Size> {
    public static final Size$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Size$$serializer size$$serializer = new Size$$serializer();
        INSTANCE = size$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.Size", size$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Size$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        SizeConstraintDeserializer sizeConstraintDeserializer = SizeConstraintDeserializer.INSTANCE;
        return new KSerializer[]{sizeConstraintDeserializer, sizeConstraintDeserializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Size deserialize(Decoder decoder) {
        SizeConstraint sizeConstraint;
        int i3;
        SizeConstraint sizeConstraint2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            SizeConstraintDeserializer sizeConstraintDeserializer = SizeConstraintDeserializer.INSTANCE;
            sizeConstraint2 = (SizeConstraint) compositeDecoderB.y(descriptor2, 0, sizeConstraintDeserializer, null);
            sizeConstraint = (SizeConstraint) compositeDecoderB.y(descriptor2, 1, sizeConstraintDeserializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            sizeConstraint = null;
            SizeConstraint sizeConstraint3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    sizeConstraint3 = (SizeConstraint) compositeDecoderB.y(descriptor2, 0, SizeConstraintDeserializer.INSTANCE, sizeConstraint3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    sizeConstraint = (SizeConstraint) compositeDecoderB.y(descriptor2, 1, SizeConstraintDeserializer.INSTANCE, sizeConstraint);
                    i4 |= 2;
                }
            }
            i3 = i4;
            sizeConstraint2 = sizeConstraint3;
        }
        compositeDecoderB.c(descriptor2);
        return new Size(i3, sizeConstraint2, sizeConstraint, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Size value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        Size.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
