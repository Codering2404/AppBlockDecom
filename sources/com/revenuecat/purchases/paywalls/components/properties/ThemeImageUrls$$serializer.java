package com.revenuecat.purchases.paywalls.components.properties;

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
public final class ThemeImageUrls$$serializer implements GeneratedSerializer<ThemeImageUrls> {
    public static final ThemeImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ThemeImageUrls$$serializer themeImageUrls$$serializer = new ThemeImageUrls$$serializer();
        INSTANCE = themeImageUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls", themeImageUrls$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("light", false);
        pluginGeneratedSerialDescriptor.p("dark", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ThemeImageUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
        return new KSerializer[]{imageUrls$$serializer, BuiltinSerializersKt.u(imageUrls$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ThemeImageUrls deserialize(Decoder decoder) {
        ImageUrls imageUrls;
        int i3;
        ImageUrls imageUrls2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
            imageUrls2 = (ImageUrls) compositeDecoderB.y(descriptor2, 0, imageUrls$$serializer, null);
            imageUrls = (ImageUrls) compositeDecoderB.n(descriptor2, 1, imageUrls$$serializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            imageUrls = null;
            ImageUrls imageUrls3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    imageUrls3 = (ImageUrls) compositeDecoderB.y(descriptor2, 0, ImageUrls$$serializer.INSTANCE, imageUrls3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    imageUrls = (ImageUrls) compositeDecoderB.n(descriptor2, 1, ImageUrls$$serializer.INSTANCE, imageUrls);
                    i4 |= 2;
                }
            }
            i3 = i4;
            imageUrls2 = imageUrls3;
        }
        compositeDecoderB.c(descriptor2);
        return new ThemeImageUrls(i3, imageUrls2, imageUrls, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ThemeImageUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ThemeImageUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
