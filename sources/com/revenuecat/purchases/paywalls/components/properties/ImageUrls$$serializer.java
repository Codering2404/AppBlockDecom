package com.revenuecat.purchases.paywalls.components.properties;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
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
import kotlinx.serialization.internal.UIntSerializer;

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
public final class ImageUrls$$serializer implements GeneratedSerializer<ImageUrls> {
    public static final ImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ImageUrls$$serializer imageUrls$$serializer = new ImageUrls$$serializer();
        INSTANCE = imageUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.ImageUrls", imageUrls$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("original", false);
        pluginGeneratedSerialDescriptor.p("webp", false);
        pluginGeneratedSerialDescriptor.p("webp_low_res", false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImageUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        UIntSerializer uIntSerializer = UIntSerializer.f142909a;
        return new KSerializer[]{uRLSerializer, uRLSerializer, uRLSerializer, uIntSerializer, uIntSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ImageUrls deserialize(Decoder decoder) {
        int i3;
        URL url;
        URL url2;
        URL url3;
        UInt uInt;
        UInt uInt2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        URL url4 = null;
        if (compositeDecoderB.p()) {
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            URL url5 = (URL) compositeDecoderB.y(descriptor2, 0, uRLSerializer, null);
            URL url6 = (URL) compositeDecoderB.y(descriptor2, 1, uRLSerializer, null);
            URL url7 = (URL) compositeDecoderB.y(descriptor2, 2, uRLSerializer, null);
            UIntSerializer uIntSerializer = UIntSerializer.f142909a;
            url3 = url7;
            uInt = (UInt) compositeDecoderB.y(descriptor2, 3, uIntSerializer, null);
            uInt2 = (UInt) compositeDecoderB.y(descriptor2, 4, uIntSerializer, null);
            i3 = 31;
            url2 = url6;
            url = url5;
        } else {
            boolean z2 = true;
            int i4 = 0;
            URL url8 = null;
            URL url9 = null;
            UInt uInt3 = null;
            UInt uInt4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    url4 = (URL) compositeDecoderB.y(descriptor2, 0, URLSerializer.INSTANCE, url4);
                    i4 |= 1;
                } else if (iO == 1) {
                    url8 = (URL) compositeDecoderB.y(descriptor2, 1, URLSerializer.INSTANCE, url8);
                    i4 |= 2;
                } else if (iO == 2) {
                    url9 = (URL) compositeDecoderB.y(descriptor2, 2, URLSerializer.INSTANCE, url9);
                    i4 |= 4;
                } else if (iO == 3) {
                    uInt3 = (UInt) compositeDecoderB.y(descriptor2, 3, UIntSerializer.f142909a, uInt3);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    uInt4 = (UInt) compositeDecoderB.y(descriptor2, 4, UIntSerializer.f142909a, uInt4);
                    i4 |= 16;
                }
            }
            i3 = i4;
            url = url4;
            url2 = url8;
            url3 = url9;
            uInt = uInt3;
            uInt2 = uInt4;
        }
        compositeDecoderB.c(descriptor2);
        return new ImageUrls(i3, url, url2, url3, uInt, uInt2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ImageUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ImageUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
