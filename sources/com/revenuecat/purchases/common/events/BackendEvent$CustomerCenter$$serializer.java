package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
public final class BackendEvent$CustomerCenter$$serializer implements GeneratedSerializer<BackendEvent.CustomerCenter> {
    public static final BackendEvent$CustomerCenter$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$CustomerCenter$$serializer backendEvent$CustomerCenter$$serializer = new BackendEvent$CustomerCenter$$serializer();
        INSTANCE = backendEvent$CustomerCenter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("customer_center", backendEvent$CustomerCenter$$serializer, 12);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("revision_id", false);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("app_user_id", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.p("timestamp", false);
        pluginGeneratedSerialDescriptor.p("dark_mode", false);
        pluginGeneratedSerialDescriptor.p("locale", false);
        pluginGeneratedSerialDescriptor.p("display_mode", false);
        pluginGeneratedSerialDescriptor.p("path", false);
        pluginGeneratedSerialDescriptor.p("url", false);
        pluginGeneratedSerialDescriptor.p("survey_option_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$CustomerCenter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = BackendEvent.CustomerCenter.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, IntSerializer.f142823a, kSerializerArr[2], stringSerializer, stringSerializer, LongSerializer.f142836a, BooleanSerializer.f142767a, stringSerializer, kSerializerArr[8], BuiltinSerializersKt.u(kSerializerArr[9]), BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.CustomerCenter deserialize(Decoder decoder) {
        CustomerCenterEventType customerCenterEventType;
        String str;
        String str2;
        int i3;
        String str3;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterDisplayMode customerCenterDisplayMode;
        String str4;
        String str5;
        String str6;
        boolean z2;
        int i4;
        long j3;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = BackendEvent.CustomerCenter.$childSerializers;
        int i7 = 10;
        int i8 = 7;
        int i9 = 6;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            int i10 = compositeDecoderB.i(descriptor2, 1);
            CustomerCenterEventType customerCenterEventType2 = (CustomerCenterEventType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], null);
            String strM3 = compositeDecoderB.m(descriptor2, 3);
            String strM4 = compositeDecoderB.m(descriptor2, 4);
            long jF = compositeDecoderB.f(descriptor2, 5);
            boolean zC = compositeDecoderB.C(descriptor2, 6);
            String strM5 = compositeDecoderB.m(descriptor2, 7);
            CustomerCenterDisplayMode customerCenterDisplayMode2 = (CustomerCenterDisplayMode) compositeDecoderB.y(descriptor2, 8, kSerializerArr[8], null);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderB.n(descriptor2, 9, kSerializerArr[9], null);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str7 = (String) compositeDecoderB.n(descriptor2, 10, stringSerializer, null);
            pathType = pathType2;
            str = strM2;
            str2 = (String) compositeDecoderB.n(descriptor2, 11, stringSerializer, null);
            str3 = str7;
            str6 = strM5;
            z2 = zC;
            customerCenterDisplayMode = customerCenterDisplayMode2;
            str4 = strM3;
            str5 = strM4;
            i3 = 4095;
            customerCenterEventType = customerCenterEventType2;
            i4 = i10;
            j3 = jF;
        } else {
            CustomerCenterEventType customerCenterEventType3 = null;
            String str8 = null;
            String strM6 = null;
            boolean z3 = true;
            int i11 = 0;
            boolean zC2 = false;
            int i12 = 0;
            long jF2 = 0;
            String str9 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterDisplayMode customerCenterDisplayMode3 = null;
            String strM7 = null;
            String strM8 = null;
            while (z3) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z3 = false;
                        break;
                    case 0:
                        i11 |= 1;
                        i9 = i9;
                        strM = compositeDecoderB.m(descriptor2, 0);
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 1:
                        i5 = i9;
                        i12 = compositeDecoderB.i(descriptor2, 1);
                        i11 |= 2;
                        i9 = i5;
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 2:
                        i5 = i9;
                        customerCenterEventType3 = (CustomerCenterEventType) compositeDecoderB.y(descriptor2, 2, kSerializerArr[2], customerCenterEventType3);
                        i11 |= 4;
                        i9 = i5;
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 3:
                        i6 = i9;
                        strM7 = compositeDecoderB.m(descriptor2, 3);
                        i11 |= 8;
                        i9 = i6;
                        i7 = 10;
                        break;
                    case 4:
                        i6 = i9;
                        strM8 = compositeDecoderB.m(descriptor2, 4);
                        i11 |= 16;
                        i9 = i6;
                        i7 = 10;
                        break;
                    case 5:
                        jF2 = compositeDecoderB.f(descriptor2, 5);
                        i11 |= 32;
                        i9 = i9;
                        i7 = 10;
                        break;
                    case 6:
                        int i13 = i9;
                        zC2 = compositeDecoderB.C(descriptor2, i13);
                        i11 |= 64;
                        i9 = i13;
                        break;
                    case 7:
                        strM6 = compositeDecoderB.m(descriptor2, i8);
                        i11 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        i9 = 6;
                        break;
                    case 8:
                        customerCenterDisplayMode3 = (CustomerCenterDisplayMode) compositeDecoderB.y(descriptor2, 8, kSerializerArr[8], customerCenterDisplayMode3);
                        i11 |= Function.MAX_NARGS;
                        i9 = 6;
                        break;
                    case 9:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderB.n(descriptor2, 9, kSerializerArr[9], pathType3);
                        i11 |= 512;
                        i9 = 6;
                        break;
                    case 10:
                        str9 = (String) compositeDecoderB.n(descriptor2, i7, StringSerializer.f142891a, str9);
                        i11 |= 1024;
                        i9 = 6;
                        break;
                    case 11:
                        str8 = (String) compositeDecoderB.n(descriptor2, 11, StringSerializer.f142891a, str8);
                        i11 |= 2048;
                        i9 = 6;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            customerCenterEventType = customerCenterEventType3;
            str = strM;
            str2 = str8;
            i3 = i11;
            str3 = str9;
            pathType = pathType3;
            customerCenterDisplayMode = customerCenterDisplayMode3;
            str4 = strM7;
            str5 = strM8;
            str6 = strM6;
            z2 = zC2;
            i4 = i12;
            j3 = jF2;
        }
        compositeDecoderB.c(descriptor2);
        return new BackendEvent.CustomerCenter(i3, str, i4, customerCenterEventType, str4, str5, j3, z2, str6, customerCenterDisplayMode, pathType, str3, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.CustomerCenter value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        BackendEvent.CustomerCenter.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
