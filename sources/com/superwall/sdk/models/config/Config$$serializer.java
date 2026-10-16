package com.superwall.sdk.models.config;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.postback.PostbackRequest;
import com.superwall.sdk.models.postback.PostbackRequest$$serializer;
import java.util.List;
import java.util.Set;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class Config$$serializer implements GeneratedSerializer<Config> {
    public static final Config$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Config$$serializer config$$serializer = new Config$$serializer();
        INSTANCE = config$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.config.Config", config$$serializer, 17);
        pluginGeneratedSerialDescriptor.p("triggerOptions", false);
        pluginGeneratedSerialDescriptor.p("paywallResponses", false);
        pluginGeneratedSerialDescriptor.p("logLevel", false);
        pluginGeneratedSerialDescriptor.p("postback", false);
        pluginGeneratedSerialDescriptor.p("appSessionTimeoutMs", false);
        pluginGeneratedSerialDescriptor.p("toggles", false);
        pluginGeneratedSerialDescriptor.p("products", false);
        pluginGeneratedSerialDescriptor.p("products_v3", true);
        pluginGeneratedSerialDescriptor.p("disablePreload", false);
        pluginGeneratedSerialDescriptor.p("localization", false);
        pluginGeneratedSerialDescriptor.p("requestId", true);
        pluginGeneratedSerialDescriptor.p("locales", true);
        pluginGeneratedSerialDescriptor.p("web2app_config", true);
        pluginGeneratedSerialDescriptor.p("build_id", false);
        pluginGeneratedSerialDescriptor.p("bundle_id_config", true);
        pluginGeneratedSerialDescriptor.p("test_mode_user_ids", true);
        pluginGeneratedSerialDescriptor.p("prioritized_campaign_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Config$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = Config.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializer2 = kSerializerArr[1];
        KSerializer<?> kSerializer3 = kSerializerArr[5];
        KSerializer<?> kSerializer4 = kSerializerArr[6];
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(kSerializerArr[7]);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{kSerializer, kSerializer2, IntSerializer.f142823a, PostbackRequest$$serializer.INSTANCE, LongSerializer.f142836a, kSerializer3, kSerializer4, kSerializerU, PreloadingDisabled$$serializer.INSTANCE, LocalizationConfig$$serializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer), kSerializerArr[11], BuiltinSerializersKt.u(WebToAppConfig$$serializer.INSTANCE), stringSerializer, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(kSerializerArr[15]), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Config deserialize(Decoder decoder) {
        Set set;
        List list;
        List list2;
        PostbackRequest postbackRequest;
        String str;
        List list3;
        Set set2;
        WebToAppConfig webToAppConfig;
        PreloadingDisabled preloadingDisabled;
        List list4;
        String str2;
        String str3;
        long j3;
        LocalizationConfig localizationConfig;
        int i3;
        List list5;
        String str4;
        int i4;
        PostbackRequest postbackRequest2;
        List list6;
        PostbackRequest postbackRequest3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = Config.$childSerializers;
        String str5 = null;
        if (compositeDecoderB.p()) {
            Set set3 = (Set) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            List list7 = (List) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            int i5 = compositeDecoderB.i(serialDescriptor, 2);
            PostbackRequest postbackRequest4 = (PostbackRequest) compositeDecoderB.y(serialDescriptor, 3, PostbackRequest$$serializer.INSTANCE, null);
            long jF = compositeDecoderB.f(serialDescriptor, 4);
            List list8 = (List) compositeDecoderB.y(serialDescriptor, 5, kSerializerArr[5], null);
            List list9 = (List) compositeDecoderB.y(serialDescriptor, 6, kSerializerArr[6], null);
            List list10 = (List) compositeDecoderB.n(serialDescriptor, 7, kSerializerArr[7], null);
            PreloadingDisabled preloadingDisabled2 = (PreloadingDisabled) compositeDecoderB.y(serialDescriptor, 8, PreloadingDisabled$$serializer.INSTANCE, null);
            LocalizationConfig localizationConfig2 = (LocalizationConfig) compositeDecoderB.y(serialDescriptor, 9, LocalizationConfig$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str6 = (String) compositeDecoderB.n(serialDescriptor, 10, stringSerializer, null);
            Set set4 = (Set) compositeDecoderB.y(serialDescriptor, 11, kSerializerArr[11], null);
            WebToAppConfig webToAppConfig2 = (WebToAppConfig) compositeDecoderB.n(serialDescriptor, 12, WebToAppConfig$$serializer.INSTANCE, null);
            String strM = compositeDecoderB.m(serialDescriptor, 13);
            String str7 = (String) compositeDecoderB.n(serialDescriptor, 14, stringSerializer, null);
            list5 = (List) compositeDecoderB.n(serialDescriptor, 15, kSerializerArr[15], null);
            str3 = (String) compositeDecoderB.n(serialDescriptor, 16, stringSerializer, null);
            list = list8;
            list2 = list7;
            i4 = i5;
            list4 = list9;
            localizationConfig = localizationConfig2;
            postbackRequest = postbackRequest4;
            list3 = list10;
            preloadingDisabled = preloadingDisabled2;
            j3 = jF;
            i3 = 131071;
            str4 = strM;
            webToAppConfig = webToAppConfig2;
            str = str7;
            set2 = set4;
            set = set3;
            str2 = str6;
        } else {
            long jF2 = 0;
            int i6 = 5;
            int i7 = 1;
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 7;
            int i13 = 6;
            List list11 = null;
            LocalizationConfig localizationConfig3 = null;
            List list12 = null;
            PostbackRequest postbackRequest5 = null;
            List list13 = null;
            String str8 = null;
            List list14 = null;
            Set set5 = null;
            WebToAppConfig webToAppConfig3 = null;
            PreloadingDisabled preloadingDisabled3 = null;
            List list15 = null;
            String str9 = null;
            String strM2 = null;
            Set set6 = null;
            while (i8 != 0) {
                List list16 = list13;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        list13 = list16;
                        postbackRequest5 = postbackRequest5;
                        i8 = i10;
                        i9 = i9;
                        list11 = list11;
                        i7 = 1;
                        i6 = 5;
                        i13 = 6;
                        i12 = 7;
                        localizationConfig3 = localizationConfig3;
                        i10 = i8;
                        break;
                    case 0:
                        int i14 = i9;
                        int i15 = i10;
                        set6 = (Set) compositeDecoderB.y(serialDescriptor, i15, kSerializerArr[i10], set6);
                        i9 = i14 | 1;
                        i10 = i15;
                        localizationConfig3 = localizationConfig3;
                        list13 = list16;
                        postbackRequest5 = postbackRequest5;
                        list11 = list11;
                        i7 = 1;
                        i6 = 5;
                        i13 = 6;
                        i12 = 7;
                        break;
                    case 1:
                        List list17 = list11;
                        PostbackRequest postbackRequest6 = postbackRequest5;
                        int i16 = i7;
                        List list18 = (List) compositeDecoderB.y(serialDescriptor, i16, kSerializerArr[i7], list16);
                        i7 = i16;
                        i9 |= 2;
                        postbackRequest5 = postbackRequest6;
                        i6 = 5;
                        i13 = 6;
                        i12 = 7;
                        list13 = list18;
                        list11 = list17;
                        break;
                    case 2:
                        list6 = list11;
                        i11 = compositeDecoderB.i(serialDescriptor, 2);
                        i9 |= 4;
                        postbackRequest5 = postbackRequest5;
                        list11 = list6;
                        list13 = list16;
                        i6 = 5;
                        i13 = 6;
                        i12 = 7;
                        break;
                    case 3:
                        list6 = list11;
                        postbackRequest5 = (PostbackRequest) compositeDecoderB.y(serialDescriptor, 3, PostbackRequest$$serializer.INSTANCE, postbackRequest5);
                        i9 |= 8;
                        list11 = list6;
                        list13 = list16;
                        i6 = 5;
                        i13 = 6;
                        i12 = 7;
                        break;
                    case 4:
                        postbackRequest3 = postbackRequest5;
                        jF2 = compositeDecoderB.f(serialDescriptor, 4);
                        i9 |= 16;
                        list13 = list16;
                        postbackRequest5 = postbackRequest3;
                        i13 = 6;
                        i12 = 7;
                        break;
                    case 5:
                        postbackRequest3 = postbackRequest5;
                        list12 = (List) compositeDecoderB.y(serialDescriptor, i6, kSerializerArr[i6], list12);
                        i9 |= 32;
                        list13 = list16;
                        postbackRequest5 = postbackRequest3;
                        i13 = 6;
                        i12 = 7;
                        break;
                    case 6:
                        list15 = (List) compositeDecoderB.y(serialDescriptor, i13, kSerializerArr[i13], list15);
                        i9 |= 64;
                        list13 = list16;
                        postbackRequest5 = postbackRequest5;
                        i12 = 7;
                        break;
                    case 7:
                        postbackRequest2 = postbackRequest5;
                        list14 = (List) compositeDecoderB.n(serialDescriptor, i12, kSerializerArr[i12], list14);
                        i9 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 8:
                        postbackRequest2 = postbackRequest5;
                        preloadingDisabled3 = (PreloadingDisabled) compositeDecoderB.y(serialDescriptor, 8, PreloadingDisabled$$serializer.INSTANCE, preloadingDisabled3);
                        i9 |= Function.MAX_NARGS;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 9:
                        postbackRequest2 = postbackRequest5;
                        localizationConfig3 = (LocalizationConfig) compositeDecoderB.y(serialDescriptor, 9, LocalizationConfig$$serializer.INSTANCE, localizationConfig3);
                        i9 |= 512;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 10:
                        postbackRequest2 = postbackRequest5;
                        str9 = (String) compositeDecoderB.n(serialDescriptor, 10, StringSerializer.f142891a, str9);
                        i9 |= 1024;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 11:
                        postbackRequest2 = postbackRequest5;
                        set5 = (Set) compositeDecoderB.y(serialDescriptor, 11, kSerializerArr[11], set5);
                        i9 |= 2048;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 12:
                        postbackRequest2 = postbackRequest5;
                        webToAppConfig3 = (WebToAppConfig) compositeDecoderB.n(serialDescriptor, 12, WebToAppConfig$$serializer.INSTANCE, webToAppConfig3);
                        i9 |= 4096;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 13:
                        postbackRequest2 = postbackRequest5;
                        strM2 = compositeDecoderB.m(serialDescriptor, 13);
                        i9 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 14:
                        postbackRequest2 = postbackRequest5;
                        str8 = (String) compositeDecoderB.n(serialDescriptor, 14, StringSerializer.f142891a, str8);
                        i9 |= 16384;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 15:
                        postbackRequest2 = postbackRequest5;
                        list11 = (List) compositeDecoderB.n(serialDescriptor, 15, kSerializerArr[15], list11);
                        i9 |= 32768;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    case 16:
                        postbackRequest2 = postbackRequest5;
                        str5 = (String) compositeDecoderB.n(serialDescriptor, 16, StringSerializer.f142891a, str5);
                        i9 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        list13 = list16;
                        postbackRequest5 = postbackRequest2;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            set = set6;
            list = list12;
            list2 = list13;
            postbackRequest = postbackRequest5;
            str = str8;
            list3 = list14;
            set2 = set5;
            webToAppConfig = webToAppConfig3;
            preloadingDisabled = preloadingDisabled3;
            list4 = list15;
            str2 = str9;
            str3 = str5;
            j3 = jF2;
            localizationConfig = localizationConfig3;
            i3 = i9;
            list5 = list11;
            str4 = strM2;
            i4 = i11;
        }
        compositeDecoderB.c(serialDescriptor);
        return new Config(i3, set, list2, i4, postbackRequest, j3, list, list4, list3, preloadingDisabled, localizationConfig, str2, set2, webToAppConfig, str4, str, list5, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Config value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        Config.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
