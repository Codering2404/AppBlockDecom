package com.superwall.sdk.models.paywall;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class PaywallURL$$serializer implements GeneratedSerializer<PaywallURL> {
    public static final PaywallURL$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaywallURL$$serializer paywallURL$$serializer = new PaywallURL$$serializer();
        INSTANCE = paywallURL$$serializer;
        InlineClassDescriptor inlineClassDescriptor = new InlineClassDescriptor("com.superwall.sdk.models.paywall.PaywallURL", paywallURL$$serializer);
        inlineClassDescriptor.p("value", false);
        descriptor = inlineClassDescriptor;
    }

    private PaywallURL$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.f142891a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return PaywallURL.m1296boximpl(m1303deserializeFL48qAY(decoder));
    }

    /* JADX INFO: renamed from: deserialize-FL48qAY, reason: not valid java name */
    public final String m1303deserializeFL48qAY(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return PaywallURL.m1297constructorimpl(decoder.q(descriptor).z());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m1304serialize1pAmztU(encoder, ((PaywallURL) obj).m1302unboximpl());
    }

    /* JADX INFO: renamed from: serialize-1pAmztU, reason: not valid java name */
    public final void m1304serialize1pAmztU(Encoder encoder, String value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Encoder encoderL = encoder.l(descriptor);
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
