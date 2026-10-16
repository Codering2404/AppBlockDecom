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
public final class ThemeVideoUrls$$serializer implements GeneratedSerializer<ThemeVideoUrls> {
    public static final ThemeVideoUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ThemeVideoUrls$$serializer themeVideoUrls$$serializer = new ThemeVideoUrls$$serializer();
        INSTANCE = themeVideoUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls", themeVideoUrls$$serializer, 2);
        pluginGeneratedSerialDescriptor.p("light", false);
        pluginGeneratedSerialDescriptor.p("dark", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ThemeVideoUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        VideoUrls$$serializer videoUrls$$serializer = VideoUrls$$serializer.INSTANCE;
        return new KSerializer[]{videoUrls$$serializer, BuiltinSerializersKt.u(videoUrls$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ThemeVideoUrls deserialize(Decoder decoder) {
        VideoUrls videoUrls;
        int i3;
        VideoUrls videoUrls2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            VideoUrls$$serializer videoUrls$$serializer = VideoUrls$$serializer.INSTANCE;
            videoUrls2 = (VideoUrls) compositeDecoderB.y(descriptor2, 0, videoUrls$$serializer, null);
            videoUrls = (VideoUrls) compositeDecoderB.n(descriptor2, 1, videoUrls$$serializer, null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            videoUrls = null;
            VideoUrls videoUrls3 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    videoUrls3 = (VideoUrls) compositeDecoderB.y(descriptor2, 0, VideoUrls$$serializer.INSTANCE, videoUrls3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    videoUrls = (VideoUrls) compositeDecoderB.n(descriptor2, 1, VideoUrls$$serializer.INSTANCE, videoUrls);
                    i4 |= 2;
                }
            }
            i3 = i4;
            videoUrls2 = videoUrls3;
        }
        compositeDecoderB.c(descriptor2);
        return new ThemeVideoUrls(i3, videoUrls2, videoUrls, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ThemeVideoUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ThemeVideoUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
