package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class BackendEvent$CustomPaywall$$serializer implements GeneratedSerializer<BackendEvent.CustomPaywall> {
    public static final BackendEvent$CustomPaywall$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$CustomPaywall$$serializer backendEvent$CustomPaywall$$serializer = new BackendEvent$CustomPaywall$$serializer();
        INSTANCE = backendEvent$CustomPaywall$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("custom_paywall_event", backendEvent$CustomPaywall$$serializer, 8);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("version", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("app_user_id", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.APP_SESSION_ID_KEY, true);
        pluginGeneratedSerialDescriptor.p("timestamp", false);
        pluginGeneratedSerialDescriptor.p("paywall_id", true);
        pluginGeneratedSerialDescriptor.p("offering_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$CustomPaywall$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, IntSerializer.f142823a, stringSerializer, stringSerializer, BuiltinSerializersKt.u(stringSerializer), LongSerializer.f142836a, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.CustomPaywall deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        int i4;
        String str3;
        String str4;
        String str5;
        String str6;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            int i5 = compositeDecoderB.i(descriptor2, 1);
            String strM2 = compositeDecoderB.m(descriptor2, 2);
            String strM3 = compositeDecoderB.m(descriptor2, 3);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str7 = (String) compositeDecoderB.n(descriptor2, 4, stringSerializer, null);
            long jF = compositeDecoderB.f(descriptor2, 5);
            String str8 = (String) compositeDecoderB.n(descriptor2, 6, stringSerializer, null);
            str3 = strM;
            str = (String) compositeDecoderB.n(descriptor2, 7, stringSerializer, null);
            str2 = str8;
            i3 = 255;
            str5 = strM3;
            str6 = str7;
            str4 = strM2;
            i4 = i5;
            j3 = jF;
        } else {
            boolean z2 = true;
            int i6 = 0;
            String str9 = null;
            String strM4 = null;
            String str10 = null;
            long jF2 = 0;
            int i7 = 0;
            String str11 = null;
            String strM5 = null;
            String strM6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i6 |= 1;
                        strM5 = compositeDecoderB.m(descriptor2, 0);
                        continue;
                    case 1:
                        i6 |= 2;
                        i7 = compositeDecoderB.i(descriptor2, 1);
                        continue;
                    case 2:
                        strM6 = compositeDecoderB.m(descriptor2, 2);
                        i6 |= 4;
                        continue;
                    case 3:
                        strM4 = compositeDecoderB.m(descriptor2, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        str10 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str10);
                        i6 |= 16;
                        break;
                    case 5:
                        jF2 = compositeDecoderB.f(descriptor2, 5);
                        i6 |= 32;
                        break;
                    case 6:
                        str11 = (String) compositeDecoderB.n(descriptor2, 6, StringSerializer.f142891a, str11);
                        i6 |= 64;
                        break;
                    case 7:
                        str9 = (String) compositeDecoderB.n(descriptor2, 7, StringSerializer.f142891a, str9);
                        i6 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i6;
            str = str9;
            str2 = str11;
            i4 = i7;
            str3 = strM5;
            str4 = strM6;
            str5 = strM4;
            str6 = str10;
            j3 = jF2;
        }
        compositeDecoderB.c(descriptor2);
        return new BackendEvent.CustomPaywall(i3, str3, i4, str4, str5, str6, j3, str2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.CustomPaywall value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        BackendEvent.CustomPaywall.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
