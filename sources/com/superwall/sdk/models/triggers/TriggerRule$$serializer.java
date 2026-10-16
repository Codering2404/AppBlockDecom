package com.superwall.sdk.models.triggers;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.triggers.TriggerRule;
import java.util.List;
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
public /* synthetic */ class TriggerRule$$serializer implements GeneratedSerializer<TriggerRule> {
    public static final TriggerRule$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TriggerRule$$serializer triggerRule$$serializer = new TriggerRule$$serializer();
        INSTANCE = triggerRule$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.triggers.TriggerRule", triggerRule$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("experiment_id", false);
        pluginGeneratedSerialDescriptor.p("experiment_group_id", false);
        pluginGeneratedSerialDescriptor.p("variants", false);
        pluginGeneratedSerialDescriptor.p("expression", true);
        pluginGeneratedSerialDescriptor.p("expression_js", true);
        pluginGeneratedSerialDescriptor.p("expression_cel", true);
        pluginGeneratedSerialDescriptor.p("occurrence", true);
        pluginGeneratedSerialDescriptor.p("computed_properties", true);
        pluginGeneratedSerialDescriptor.p("preload", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TriggerRule$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TriggerRule.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializerArr[2], BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(TriggerRuleOccurrence$$serializer.INSTANCE), kSerializerArr[7], TriggerRule.TriggerPreloadSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final TriggerRule deserialize(Decoder decoder) {
        int i3;
        TriggerRule.TriggerPreload triggerPreload;
        TriggerRuleOccurrence triggerRuleOccurrence;
        List list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = TriggerRule.$childSerializers;
        int i4 = 8;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            List list3 = (List) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str6 = (String) compositeDecoderB.n(serialDescriptor, 3, stringSerializer, null);
            String str7 = (String) compositeDecoderB.n(serialDescriptor, 4, stringSerializer, null);
            String str8 = (String) compositeDecoderB.n(serialDescriptor, 5, stringSerializer, null);
            TriggerRuleOccurrence triggerRuleOccurrence2 = (TriggerRuleOccurrence) compositeDecoderB.n(serialDescriptor, 6, TriggerRuleOccurrence$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(serialDescriptor, 7, kSerializerArr[7], null);
            str4 = strM2;
            triggerRuleOccurrence = triggerRuleOccurrence2;
            str = str8;
            str3 = str6;
            triggerPreload = (TriggerRule.TriggerPreload) compositeDecoderB.y(serialDescriptor, 8, TriggerRule.TriggerPreloadSerializer.INSTANCE, null);
            str2 = str7;
            i3 = 511;
            list2 = list3;
            str5 = strM3;
        } else {
            boolean z2 = true;
            int i5 = 0;
            TriggerRule.TriggerPreload triggerPreload2 = null;
            TriggerRuleOccurrence triggerRuleOccurrence3 = null;
            List list4 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String strM4 = null;
            List list5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i4 = 8;
                        break;
                    case 1:
                        strM4 = compositeDecoderB.m(serialDescriptor, 1);
                        i5 |= 2;
                        i4 = 8;
                        break;
                    case 2:
                        list5 = (List) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], list5);
                        i5 |= 4;
                        i4 = 8;
                        break;
                    case 3:
                        str11 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, str11);
                        i5 |= 8;
                        i4 = 8;
                        break;
                    case 4:
                        str10 = (String) compositeDecoderB.n(serialDescriptor, 4, StringSerializer.f142891a, str10);
                        i5 |= 16;
                        i4 = 8;
                        break;
                    case 5:
                        str9 = (String) compositeDecoderB.n(serialDescriptor, 5, StringSerializer.f142891a, str9);
                        i5 |= 32;
                        i4 = 8;
                        break;
                    case 6:
                        triggerRuleOccurrence3 = (TriggerRuleOccurrence) compositeDecoderB.n(serialDescriptor, 6, TriggerRuleOccurrence$$serializer.INSTANCE, triggerRuleOccurrence3);
                        i5 |= 64;
                        i4 = 8;
                        break;
                    case 7:
                        list4 = (List) compositeDecoderB.y(serialDescriptor, 7, kSerializerArr[7], list4);
                        i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        triggerPreload2 = (TriggerRule.TriggerPreload) compositeDecoderB.y(serialDescriptor, i4, TriggerRule.TriggerPreloadSerializer.INSTANCE, triggerPreload2);
                        i5 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            triggerPreload = triggerPreload2;
            triggerRuleOccurrence = triggerRuleOccurrence3;
            list = list4;
            str = str9;
            str2 = str10;
            str3 = str11;
            str4 = strM;
            str5 = strM4;
            list2 = list5;
        }
        compositeDecoderB.c(serialDescriptor);
        return new TriggerRule(i3, str4, str5, list2, str3, str2, str, triggerRuleOccurrence, list, triggerPreload, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TriggerRule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        TriggerRule.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
