package com.revenuecat.purchases.common.events;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
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
public final class BackendEvent$Ad$$serializer implements GeneratedSerializer<BackendEvent.Ad> {
    public static final BackendEvent$Ad$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$Ad$$serializer backendEvent$Ad$$serializer = new BackendEvent$Ad$$serializer();
        INSTANCE = backendEvent$Ad$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ad", backendEvent$Ad$$serializer, 16);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("version", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("timestamp_ms", false);
        pluginGeneratedSerialDescriptor.p("network_name", true);
        pluginGeneratedSerialDescriptor.p("mediator_name", false);
        pluginGeneratedSerialDescriptor.p("ad_format", true);
        pluginGeneratedSerialDescriptor.p("placement", false);
        pluginGeneratedSerialDescriptor.p("ad_unit_id", false);
        pluginGeneratedSerialDescriptor.p("impression_id", false);
        pluginGeneratedSerialDescriptor.p("app_user_id", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.p("revenue_micros", true);
        pluginGeneratedSerialDescriptor.p(AppLovinEventParameters.REVENUE_CURRENCY, true);
        pluginGeneratedSerialDescriptor.p("precision", true);
        pluginGeneratedSerialDescriptor.p("mediator_error_code", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$Ad$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        IntSerializer intSerializer = IntSerializer.f142823a;
        LongSerializer longSerializer = LongSerializer.f142836a;
        return new KSerializer[]{stringSerializer, intSerializer, stringSerializer, longSerializer, BuiltinSerializersKt.u(stringSerializer), stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), stringSerializer, BuiltinSerializersKt.u(stringSerializer), stringSerializer, stringSerializer, BuiltinSerializersKt.u(longSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(intSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.Ad deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        String str3;
        int i4;
        Integer num;
        String str4;
        String str5;
        String str6;
        Long l3;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        int i5 = 11;
        int i6 = 10;
        char c3 = '\t';
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            int i7 = compositeDecoderB.i(descriptor2, 1);
            String strM2 = compositeDecoderB.m(descriptor2, 2);
            long jF = compositeDecoderB.f(descriptor2, 3);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str13 = (String) compositeDecoderB.n(descriptor2, 4, stringSerializer, null);
            String strM3 = compositeDecoderB.m(descriptor2, 5);
            String str14 = (String) compositeDecoderB.n(descriptor2, 6, stringSerializer, null);
            String str15 = (String) compositeDecoderB.n(descriptor2, 7, stringSerializer, null);
            String strM4 = compositeDecoderB.m(descriptor2, 8);
            String str16 = (String) compositeDecoderB.n(descriptor2, 9, stringSerializer, null);
            String strM5 = compositeDecoderB.m(descriptor2, 10);
            String strM6 = compositeDecoderB.m(descriptor2, 11);
            Long l4 = (Long) compositeDecoderB.n(descriptor2, 12, LongSerializer.f142836a, null);
            String str17 = (String) compositeDecoderB.n(descriptor2, 13, stringSerializer, null);
            String str18 = (String) compositeDecoderB.n(descriptor2, 14, stringSerializer, null);
            num = (Integer) compositeDecoderB.n(descriptor2, 15, IntSerializer.f142823a, null);
            str8 = strM2;
            i3 = i7;
            i4 = 65535;
            str12 = strM6;
            str11 = strM5;
            str6 = str16;
            str = str15;
            str2 = str14;
            str9 = strM3;
            str3 = str13;
            str10 = strM4;
            str5 = str17;
            str4 = str18;
            l3 = l4;
            j3 = jF;
            str7 = strM;
        } else {
            boolean z2 = true;
            int i8 = 0;
            String str19 = null;
            String str20 = null;
            Integer num2 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            Long l5 = null;
            String strM7 = null;
            String strM8 = null;
            String strM9 = null;
            String strM10 = null;
            long jF2 = 0;
            int i9 = 0;
            String str24 = null;
            String strM11 = null;
            String strM12 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i5 = 11;
                        c3 = '\t';
                        break;
                    case 0:
                        strM11 = compositeDecoderB.m(descriptor2, 0);
                        i9 |= 1;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 1:
                        i9 |= 2;
                        i8 = compositeDecoderB.i(descriptor2, 1);
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 2:
                        strM12 = compositeDecoderB.m(descriptor2, 2);
                        i9 |= 4;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 3:
                        jF2 = compositeDecoderB.f(descriptor2, 3);
                        i9 |= 8;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 4:
                        str24 = (String) compositeDecoderB.n(descriptor2, 4, StringSerializer.f142891a, str24);
                        i9 |= 16;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 5:
                        strM7 = compositeDecoderB.m(descriptor2, 5);
                        i9 |= 32;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 6:
                        str20 = (String) compositeDecoderB.n(descriptor2, 6, StringSerializer.f142891a, str20);
                        i9 |= 64;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 7:
                        str19 = (String) compositeDecoderB.n(descriptor2, 7, StringSerializer.f142891a, str19);
                        i9 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i5 = 11;
                        i6 = 10;
                        c3 = '\t';
                        break;
                    case 8:
                        strM8 = compositeDecoderB.m(descriptor2, 8);
                        i9 |= Function.MAX_NARGS;
                        c3 = c3;
                        i5 = 11;
                        break;
                    case 9:
                        str23 = (String) compositeDecoderB.n(descriptor2, 9, StringSerializer.f142891a, str23);
                        i9 |= 512;
                        c3 = '\t';
                        i5 = 11;
                        break;
                    case 10:
                        strM9 = compositeDecoderB.m(descriptor2, i6);
                        i9 |= 1024;
                        c3 = '\t';
                        break;
                    case 11:
                        strM10 = compositeDecoderB.m(descriptor2, i5);
                        i9 |= 2048;
                        c3 = '\t';
                        break;
                    case 12:
                        l5 = (Long) compositeDecoderB.n(descriptor2, 12, LongSerializer.f142836a, l5);
                        i9 |= 4096;
                        c3 = '\t';
                        break;
                    case 13:
                        str22 = (String) compositeDecoderB.n(descriptor2, 13, StringSerializer.f142891a, str22);
                        i9 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        c3 = '\t';
                        break;
                    case 14:
                        str21 = (String) compositeDecoderB.n(descriptor2, 14, StringSerializer.f142891a, str21);
                        i9 |= 16384;
                        c3 = '\t';
                        break;
                    case 15:
                        num2 = (Integer) compositeDecoderB.n(descriptor2, 15, IntSerializer.f142823a, num2);
                        i9 |= 32768;
                        c3 = '\t';
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i8;
            str = str19;
            str2 = str20;
            str3 = str24;
            i4 = i9;
            num = num2;
            str4 = str21;
            str5 = str22;
            str6 = str23;
            l3 = l5;
            str7 = strM11;
            str8 = strM12;
            str9 = strM7;
            str10 = strM8;
            str11 = strM9;
            str12 = strM10;
            j3 = jF2;
        }
        compositeDecoderB.c(descriptor2);
        return new BackendEvent.Ad(i4, str7, i3, str8, j3, str3, str9, str2, str, str10, str6, str11, str12, l3, str5, str4, num, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.Ad value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        BackendEvent.Ad.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
