package com.revenuecat.purchases.paywalls.components.common;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;

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
public final class LocalizationKey$$serializer implements GeneratedSerializer<LocalizationKey> {
    public static final LocalizationKey$$serializer INSTANCE;
    private static final /* synthetic */ InlineClassDescriptor descriptor;

    static {
        LocalizationKey$$serializer localizationKey$$serializer = new LocalizationKey$$serializer();
        INSTANCE = localizationKey$$serializer;
        InlineClassDescriptor inlineClassDescriptor = new InlineClassDescriptor("com.revenuecat.purchases.paywalls.components.common.LocalizationKey", localizationKey$$serializer);
        inlineClassDescriptor.p("value", false);
        descriptor = inlineClassDescriptor;
    }

    private LocalizationKey$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return LocalizationKey.m648boximpl(m655deserialize4Zn71J0(decoder));
    }

    /* JADX INFO: renamed from: deserialize-4Zn71J0, reason: not valid java name */
    public String m655deserialize4Zn71J0(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return LocalizationKey.m649constructorimpl(decoder.q(getDescriptor()).z());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m656serialize7v81vok(encoder, ((LocalizationKey) obj).m654unboximpl());
    }

    /* JADX INFO: renamed from: serialize-7v81vok, reason: not valid java name */
    public void m656serialize7v81vok(Encoder encoder, String value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Encoder encoderL = encoder.l(getDescriptor());
        if (encoderL == null) {
            return;
        }
        encoderL.G(value);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
