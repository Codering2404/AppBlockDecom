package com.revenuecat.purchases.paywalls;

import com.facebook.AuthenticationToken;
import com.revenuecat.purchases.paywalls.PaywallData;
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
public final class PaywallData$Configuration$Images$$serializer implements GeneratedSerializer<PaywallData.Configuration.Images> {
    public static final PaywallData$Configuration$Images$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = new PaywallData$Configuration$Images$$serializer();
        INSTANCE = paywallData$Configuration$Images$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images", paywallData$Configuration$Images$$serializer, 3);
        pluginGeneratedSerialDescriptor.p(AuthenticationToken.HEADER_KEY, true);
        pluginGeneratedSerialDescriptor.p("background", true);
        pluginGeneratedSerialDescriptor.p("icon", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Images$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.u(emptyStringToNullSerializer), BuiltinSerializersKt.u(emptyStringToNullSerializer), BuiltinSerializersKt.u(emptyStringToNullSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.Images deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String str4 = null;
        if (compositeDecoderB.p()) {
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            String str5 = (String) compositeDecoderB.n(descriptor2, 0, emptyStringToNullSerializer, null);
            String str6 = (String) compositeDecoderB.n(descriptor2, 1, emptyStringToNullSerializer, null);
            str3 = (String) compositeDecoderB.n(descriptor2, 2, emptyStringToNullSerializer, null);
            i3 = 7;
            str2 = str6;
            str = str5;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str7 = null;
            String str8 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    str4 = (String) compositeDecoderB.n(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, str4);
                    i4 |= 1;
                } else if (iO == 1) {
                    str7 = (String) compositeDecoderB.n(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, str7);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    str8 = (String) compositeDecoderB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str8);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = str4;
            str2 = str7;
            str3 = str8;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallData.Configuration.Images(i3, str, str2, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.Images value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.Configuration.Images.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
