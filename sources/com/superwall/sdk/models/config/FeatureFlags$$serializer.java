package com.superwall.sdk.models.config;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
import kotlinx.serialization.internal.BooleanSerializer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class FeatureFlags$$serializer implements GeneratedSerializer<FeatureFlags> {
    public static final FeatureFlags$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        FeatureFlags$$serializer featureFlags$$serializer = new FeatureFlags$$serializer();
        INSTANCE = featureFlags$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.config.FeatureFlags", featureFlags$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("enable_config_refresh_v2", false);
        pluginGeneratedSerialDescriptor.p("enable_session_events", false);
        pluginGeneratedSerialDescriptor.p("enable_postback", false);
        pluginGeneratedSerialDescriptor.p("enable_userid_seed", false);
        pluginGeneratedSerialDescriptor.p("disable_verbose_events", false);
        pluginGeneratedSerialDescriptor.p("enable_multiple_paywall_urls", false);
        pluginGeneratedSerialDescriptor.p("enable_cel_logging", false);
        pluginGeneratedSerialDescriptor.p("web_2_app", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FeatureFlags$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.f142767a;
        return new KSerializer[]{booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final FeatureFlags deserialize(Decoder decoder) {
        boolean zC;
        boolean zC2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i3 = 0;
        if (compositeDecoderB.p()) {
            zC = compositeDecoderB.C(serialDescriptor, 0);
            boolean zC3 = compositeDecoderB.C(serialDescriptor, 1);
            boolean zC4 = compositeDecoderB.C(serialDescriptor, 2);
            boolean zC5 = compositeDecoderB.C(serialDescriptor, 3);
            boolean zC6 = compositeDecoderB.C(serialDescriptor, 4);
            boolean zC7 = compositeDecoderB.C(serialDescriptor, 5);
            boolean zC8 = compositeDecoderB.C(serialDescriptor, 6);
            i3 = 255;
            zC2 = compositeDecoderB.C(serialDescriptor, 7);
            z2 = zC8;
            z3 = zC7;
            z4 = zC5;
            z5 = zC6;
            z6 = zC4;
            z7 = zC3;
        } else {
            boolean z8 = true;
            zC = false;
            boolean zC9 = false;
            boolean zC10 = false;
            boolean zC11 = false;
            boolean zC12 = false;
            boolean zC13 = false;
            boolean zC14 = false;
            boolean zC15 = false;
            while (z8) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z8 = false;
                        break;
                    case 0:
                        i3 |= 1;
                        zC = compositeDecoderB.C(serialDescriptor, 0);
                        continue;
                    case 1:
                        zC15 = compositeDecoderB.C(serialDescriptor, 1);
                        i3 |= 2;
                        continue;
                    case 2:
                        zC14 = compositeDecoderB.C(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        zC12 = compositeDecoderB.C(serialDescriptor, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        zC13 = compositeDecoderB.C(serialDescriptor, 4);
                        i3 |= 16;
                        break;
                    case 5:
                        zC11 = compositeDecoderB.C(serialDescriptor, 5);
                        i3 |= 32;
                        break;
                    case 6:
                        zC10 = compositeDecoderB.C(serialDescriptor, 6);
                        i3 |= 64;
                        break;
                    case 7:
                        zC9 = compositeDecoderB.C(serialDescriptor, 7);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            zC2 = zC9;
            z2 = zC10;
            z3 = zC11;
            z4 = zC12;
            z5 = zC13;
            z6 = zC14;
            z7 = zC15;
        }
        boolean z9 = zC;
        int i4 = i3;
        compositeDecoderB.c(serialDescriptor);
        return new FeatureFlags(i4, z9, z7, z6, z4, z5, z3, z2, zC2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, FeatureFlags value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        FeatureFlags.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
