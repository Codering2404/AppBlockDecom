package com.revenuecat.purchases.paywalls.components.common;

import com.facebook.AuthenticationToken;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
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
public final class PaywallComponentsConfig$$serializer implements GeneratedSerializer<PaywallComponentsConfig> {
    public static final PaywallComponentsConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentsConfig$$serializer paywallComponentsConfig$$serializer = new PaywallComponentsConfig$$serializer();
        INSTANCE = paywallComponentsConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig", paywallComponentsConfig$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("background", false);
        pluginGeneratedSerialDescriptor.p("sticky_footer", true);
        pluginGeneratedSerialDescriptor.p(AuthenticationToken.HEADER_KEY, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentsConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StackComponent$$serializer.INSTANCE, BackgroundDeserializer.INSTANCE, BuiltinSerializersKt.u(StickyFooterComponent$$serializer.INSTANCE), BuiltinSerializersKt.u(HeaderComponent$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentsConfig deserialize(Decoder decoder) {
        int i3;
        StackComponent stackComponent;
        Background background;
        StickyFooterComponent stickyFooterComponent;
        HeaderComponent headerComponent;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        StackComponent stackComponent2 = null;
        if (compositeDecoderB.p()) {
            StackComponent stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.y(descriptor2, 1, BackgroundDeserializer.INSTANCE, null);
            StickyFooterComponent stickyFooterComponent2 = (StickyFooterComponent) compositeDecoderB.n(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, null);
            stackComponent = stackComponent3;
            headerComponent = (HeaderComponent) compositeDecoderB.n(descriptor2, 3, HeaderComponent$$serializer.INSTANCE, null);
            stickyFooterComponent = stickyFooterComponent2;
            background = background2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Background background3 = null;
            StickyFooterComponent stickyFooterComponent3 = null;
            HeaderComponent headerComponent2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 0, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i4 |= 1;
                } else if (iO == 1) {
                    background3 = (Background) compositeDecoderB.y(descriptor2, 1, BackgroundDeserializer.INSTANCE, background3);
                    i4 |= 2;
                } else if (iO == 2) {
                    stickyFooterComponent3 = (StickyFooterComponent) compositeDecoderB.n(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, stickyFooterComponent3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    headerComponent2 = (HeaderComponent) compositeDecoderB.n(descriptor2, 3, HeaderComponent$$serializer.INSTANCE, headerComponent2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            stackComponent = stackComponent2;
            background = background3;
            stickyFooterComponent = stickyFooterComponent3;
            headerComponent = headerComponent2;
        }
        compositeDecoderB.c(descriptor2);
        return new PaywallComponentsConfig(i3, stackComponent, background, stickyFooterComponent, headerComponent, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentsConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallComponentsConfig.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
