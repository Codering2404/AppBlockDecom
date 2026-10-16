package com.revenuecat.purchases.paywalls;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class PaywallData$Configuration$Colors$$serializer implements GeneratedSerializer<PaywallData.Configuration.Colors> {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 15);
        pluginGeneratedSerialDescriptor.p("background", false);
        pluginGeneratedSerialDescriptor.p("text_1", false);
        pluginGeneratedSerialDescriptor.p("text_2", true);
        pluginGeneratedSerialDescriptor.p("text_3", true);
        pluginGeneratedSerialDescriptor.p("call_to_action_background", false);
        pluginGeneratedSerialDescriptor.p("call_to_action_foreground", false);
        pluginGeneratedSerialDescriptor.p("call_to_action_secondary_background", true);
        pluginGeneratedSerialDescriptor.p("accent_1", true);
        pluginGeneratedSerialDescriptor.p("accent_2", true);
        pluginGeneratedSerialDescriptor.p("accent_3", true);
        pluginGeneratedSerialDescriptor.p("close_button", true);
        pluginGeneratedSerialDescriptor.p("tier_control_background", true);
        pluginGeneratedSerialDescriptor.p("tier_control_foreground", true);
        pluginGeneratedSerialDescriptor.p("tier_control_selected_background", true);
        pluginGeneratedSerialDescriptor.p("tier_control_selected_foreground", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new KSerializer[]{serializer, serializer, BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), serializer, serializer, BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer), BuiltinSerializersKt.u(serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.Colors deserialize(Decoder decoder) {
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        PaywallColor paywallColor6;
        PaywallColor paywallColor7;
        PaywallColor paywallColor8;
        PaywallColor paywallColor9;
        PaywallColor paywallColor10;
        PaywallColor paywallColor11;
        PaywallColor paywallColor12;
        PaywallColor paywallColor13;
        PaywallColor paywallColor14;
        PaywallColor paywallColor15;
        int i3;
        PaywallColor paywallColor16;
        PaywallColor paywallColor17;
        PaywallColor paywallColor18;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        PaywallColor paywallColor19 = null;
        if (compositeDecoderB.p()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            PaywallColor paywallColor20 = (PaywallColor) compositeDecoderB.y(descriptor2, 0, serializer, null);
            PaywallColor paywallColor21 = (PaywallColor) compositeDecoderB.y(descriptor2, 1, serializer, null);
            PaywallColor paywallColor22 = (PaywallColor) compositeDecoderB.n(descriptor2, 2, serializer, null);
            PaywallColor paywallColor23 = (PaywallColor) compositeDecoderB.n(descriptor2, 3, serializer, null);
            PaywallColor paywallColor24 = (PaywallColor) compositeDecoderB.y(descriptor2, 4, serializer, null);
            PaywallColor paywallColor25 = (PaywallColor) compositeDecoderB.y(descriptor2, 5, serializer, null);
            PaywallColor paywallColor26 = (PaywallColor) compositeDecoderB.n(descriptor2, 6, serializer, null);
            PaywallColor paywallColor27 = (PaywallColor) compositeDecoderB.n(descriptor2, 7, serializer, null);
            PaywallColor paywallColor28 = (PaywallColor) compositeDecoderB.n(descriptor2, 8, serializer, null);
            PaywallColor paywallColor29 = (PaywallColor) compositeDecoderB.n(descriptor2, 9, serializer, null);
            PaywallColor paywallColor30 = (PaywallColor) compositeDecoderB.n(descriptor2, 10, serializer, null);
            PaywallColor paywallColor31 = (PaywallColor) compositeDecoderB.n(descriptor2, 11, serializer, null);
            paywallColor = paywallColor21;
            PaywallColor paywallColor32 = (PaywallColor) compositeDecoderB.n(descriptor2, 12, serializer, null);
            PaywallColor paywallColor33 = (PaywallColor) compositeDecoderB.n(descriptor2, 13, serializer, null);
            paywallColor15 = (PaywallColor) compositeDecoderB.n(descriptor2, 14, serializer, null);
            i3 = 32767;
            paywallColor2 = paywallColor20;
            paywallColor5 = paywallColor31;
            paywallColor6 = paywallColor30;
            paywallColor11 = paywallColor29;
            paywallColor8 = paywallColor27;
            paywallColor9 = paywallColor26;
            paywallColor12 = paywallColor25;
            paywallColor13 = paywallColor23;
            paywallColor7 = paywallColor28;
            paywallColor10 = paywallColor24;
            paywallColor14 = paywallColor22;
            paywallColor3 = paywallColor33;
            paywallColor4 = paywallColor32;
        } else {
            boolean z2 = true;
            int i4 = 0;
            PaywallColor paywallColor34 = null;
            PaywallColor paywallColor35 = null;
            PaywallColor paywallColor36 = null;
            PaywallColor paywallColor37 = null;
            PaywallColor paywallColor38 = null;
            PaywallColor paywallColor39 = null;
            PaywallColor paywallColor40 = null;
            PaywallColor paywallColor41 = null;
            PaywallColor paywallColor42 = null;
            PaywallColor paywallColor43 = null;
            PaywallColor paywallColor44 = null;
            PaywallColor paywallColor45 = null;
            PaywallColor paywallColor46 = null;
            PaywallColor paywallColor47 = null;
            while (z2) {
                PaywallColor paywallColor48 = paywallColor34;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        paywallColor34 = paywallColor48;
                        paywallColor35 = paywallColor35;
                        i4 = i4;
                        break;
                    case 0:
                        paywallColor17 = paywallColor35;
                        paywallColor18 = paywallColor48;
                        paywallColor46 = (PaywallColor) compositeDecoderB.y(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor46);
                        i4 |= 1;
                        paywallColor47 = paywallColor47;
                        paywallColor34 = paywallColor18;
                        paywallColor35 = paywallColor17;
                        break;
                    case 1:
                        paywallColor17 = paywallColor35;
                        paywallColor18 = paywallColor48;
                        paywallColor47 = (PaywallColor) compositeDecoderB.y(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor47);
                        i4 |= 2;
                        paywallColor34 = paywallColor18;
                        paywallColor35 = paywallColor17;
                        break;
                    case 2:
                        paywallColor17 = paywallColor35;
                        paywallColor34 = (PaywallColor) compositeDecoderB.n(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor48);
                        i4 |= 4;
                        paywallColor35 = paywallColor17;
                        break;
                    case 3:
                        paywallColor45 = (PaywallColor) compositeDecoderB.n(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor45);
                        i4 |= 8;
                        paywallColor34 = paywallColor48;
                        break;
                    case 4:
                        paywallColor16 = paywallColor45;
                        paywallColor42 = (PaywallColor) compositeDecoderB.y(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor42);
                        i4 |= 16;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 5:
                        paywallColor16 = paywallColor45;
                        paywallColor44 = (PaywallColor) compositeDecoderB.y(descriptor2, 5, PaywallColor.Serializer.INSTANCE, paywallColor44);
                        i4 |= 32;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 6:
                        paywallColor16 = paywallColor45;
                        paywallColor41 = (PaywallColor) compositeDecoderB.n(descriptor2, 6, PaywallColor.Serializer.INSTANCE, paywallColor41);
                        i4 |= 64;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 7:
                        paywallColor16 = paywallColor45;
                        paywallColor40 = (PaywallColor) compositeDecoderB.n(descriptor2, 7, PaywallColor.Serializer.INSTANCE, paywallColor40);
                        i4 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 8:
                        paywallColor16 = paywallColor45;
                        paywallColor39 = (PaywallColor) compositeDecoderB.n(descriptor2, 8, PaywallColor.Serializer.INSTANCE, paywallColor39);
                        i4 |= Function.MAX_NARGS;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 9:
                        paywallColor16 = paywallColor45;
                        paywallColor43 = (PaywallColor) compositeDecoderB.n(descriptor2, 9, PaywallColor.Serializer.INSTANCE, paywallColor43);
                        i4 |= 512;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 10:
                        paywallColor16 = paywallColor45;
                        paywallColor38 = (PaywallColor) compositeDecoderB.n(descriptor2, 10, PaywallColor.Serializer.INSTANCE, paywallColor38);
                        i4 |= 1024;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 11:
                        paywallColor16 = paywallColor45;
                        paywallColor37 = (PaywallColor) compositeDecoderB.n(descriptor2, 11, PaywallColor.Serializer.INSTANCE, paywallColor37);
                        i4 |= 2048;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 12:
                        paywallColor16 = paywallColor45;
                        paywallColor36 = (PaywallColor) compositeDecoderB.n(descriptor2, 12, PaywallColor.Serializer.INSTANCE, paywallColor36);
                        i4 |= 4096;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 13:
                        paywallColor16 = paywallColor45;
                        paywallColor19 = (PaywallColor) compositeDecoderB.n(descriptor2, 13, PaywallColor.Serializer.INSTANCE, paywallColor19);
                        i4 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 14:
                        paywallColor16 = paywallColor45;
                        paywallColor35 = (PaywallColor) compositeDecoderB.n(descriptor2, 14, PaywallColor.Serializer.INSTANCE, paywallColor35);
                        i4 |= 16384;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            paywallColor = paywallColor47;
            paywallColor2 = paywallColor46;
            paywallColor3 = paywallColor19;
            paywallColor4 = paywallColor36;
            paywallColor5 = paywallColor37;
            paywallColor6 = paywallColor38;
            paywallColor7 = paywallColor39;
            paywallColor8 = paywallColor40;
            paywallColor9 = paywallColor41;
            paywallColor10 = paywallColor42;
            paywallColor11 = paywallColor43;
            paywallColor12 = paywallColor44;
            paywallColor13 = paywallColor45;
            paywallColor14 = paywallColor34;
            paywallColor15 = paywallColor35;
            i3 = i4;
        }
        PaywallColor paywallColor49 = paywallColor;
        compositeDecoderB.c(descriptor2);
        return new PaywallData.Configuration.Colors(i3, paywallColor2, paywallColor49, paywallColor14, paywallColor13, paywallColor10, paywallColor12, paywallColor9, paywallColor8, paywallColor7, paywallColor11, paywallColor6, paywallColor5, paywallColor4, paywallColor3, paywallColor15, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.Colors value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        PaywallData.Configuration.Colors.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
