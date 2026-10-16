package com.revenuecat.purchases.paywalls.components.properties;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.Checksum$$serializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
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
public final class VideoUrls$$serializer implements GeneratedSerializer<VideoUrls> {
    public static final VideoUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        VideoUrls$$serializer videoUrls$$serializer = new VideoUrls$$serializer();
        INSTANCE = videoUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.VideoUrls", videoUrls$$serializer, 6);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, false);
        pluginGeneratedSerialDescriptor.p(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, false);
        pluginGeneratedSerialDescriptor.p("url", false);
        pluginGeneratedSerialDescriptor.p("checksum", true);
        pluginGeneratedSerialDescriptor.p("url_low_res", true);
        pluginGeneratedSerialDescriptor.p("checksum_low_res", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VideoUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        Checksum$$serializer checksum$$serializer = Checksum$$serializer.INSTANCE;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(checksum$$serializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(uRLSerializer);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(checksum$$serializer);
        UIntSerializer uIntSerializer = UIntSerializer.f142909a;
        return new KSerializer[]{uIntSerializer, uIntSerializer, uRLSerializer, kSerializerU, kSerializerU2, kSerializerU3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public VideoUrls deserialize(Decoder decoder) {
        int i3;
        UInt uInt;
        UInt uInt2;
        URL url;
        Checksum checksum;
        URL url2;
        Checksum checksum2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i4 = 5;
        UInt uInt3 = null;
        if (compositeDecoderB.p()) {
            UIntSerializer uIntSerializer = UIntSerializer.f142909a;
            UInt uInt4 = (UInt) compositeDecoderB.y(descriptor2, 0, uIntSerializer, null);
            UInt uInt5 = (UInt) compositeDecoderB.y(descriptor2, 1, uIntSerializer, null);
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            URL url3 = (URL) compositeDecoderB.y(descriptor2, 2, uRLSerializer, null);
            Checksum$$serializer checksum$$serializer = Checksum$$serializer.INSTANCE;
            Checksum checksum3 = (Checksum) compositeDecoderB.n(descriptor2, 3, checksum$$serializer, null);
            URL url4 = (URL) compositeDecoderB.n(descriptor2, 4, uRLSerializer, null);
            uInt2 = uInt5;
            checksum2 = (Checksum) compositeDecoderB.n(descriptor2, 5, checksum$$serializer, null);
            checksum = checksum3;
            url2 = url4;
            url = url3;
            i3 = 63;
            uInt = uInt4;
        } else {
            boolean z2 = true;
            int i5 = 0;
            UInt uInt6 = null;
            URL url5 = null;
            Checksum checksum4 = null;
            URL url6 = null;
            Checksum checksum5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 5;
                        break;
                    case 0:
                        uInt3 = (UInt) compositeDecoderB.y(descriptor2, 0, UIntSerializer.f142909a, uInt3);
                        i5 |= 1;
                        i4 = 5;
                        break;
                    case 1:
                        uInt6 = (UInt) compositeDecoderB.y(descriptor2, 1, UIntSerializer.f142909a, uInt6);
                        i5 |= 2;
                        break;
                    case 2:
                        url5 = (URL) compositeDecoderB.y(descriptor2, 2, URLSerializer.INSTANCE, url5);
                        i5 |= 4;
                        break;
                    case 3:
                        checksum4 = (Checksum) compositeDecoderB.n(descriptor2, 3, Checksum$$serializer.INSTANCE, checksum4);
                        i5 |= 8;
                        break;
                    case 4:
                        url6 = (URL) compositeDecoderB.n(descriptor2, 4, URLSerializer.INSTANCE, url6);
                        i5 |= 16;
                        break;
                    case 5:
                        checksum5 = (Checksum) compositeDecoderB.n(descriptor2, i4, Checksum$$serializer.INSTANCE, checksum5);
                        i5 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            uInt = uInt3;
            uInt2 = uInt6;
            url = url5;
            checksum = checksum4;
            url2 = url6;
            checksum2 = checksum5;
        }
        compositeDecoderB.c(descriptor2);
        return new VideoUrls(i3, uInt, uInt2, url, checksum, url2, checksum2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, VideoUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        VideoUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
