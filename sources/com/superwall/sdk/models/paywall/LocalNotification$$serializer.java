package com.superwall.sdk.models.paywall;

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
public /* synthetic */ class LocalNotification$$serializer implements GeneratedSerializer<LocalNotification> {
    public static final LocalNotification$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LocalNotification$$serializer localNotification$$serializer = new LocalNotification$$serializer();
        INSTANCE = localNotification$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.paywall.LocalNotification", localNotification$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("id", true);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("subtitle", true);
        pluginGeneratedSerialDescriptor.p("body", false);
        pluginGeneratedSerialDescriptor.p("delay", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocalNotification$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, LocalNotificationTypeSerializer.INSTANCE, stringSerializer, BuiltinSerializersKt.u(stringSerializer), stringSerializer, LongSerializer.f142836a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LocalNotification deserialize(Decoder decoder) {
        int i3;
        String str;
        long jF;
        LocalNotificationType localNotificationType;
        String str2;
        String str3;
        String strM;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        String strM2 = null;
        if (compositeDecoderB.p()) {
            String strM3 = compositeDecoderB.m(serialDescriptor, 0);
            LocalNotificationType localNotificationType2 = (LocalNotificationType) compositeDecoderB.y(serialDescriptor, 1, LocalNotificationTypeSerializer.INSTANCE, null);
            String strM4 = compositeDecoderB.m(serialDescriptor, 2);
            str = strM3;
            i3 = 63;
            str3 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, null);
            strM = compositeDecoderB.m(serialDescriptor, 4);
            str2 = strM4;
            localNotificationType = localNotificationType2;
            jF = compositeDecoderB.f(serialDescriptor, 5);
        } else {
            long jF2 = 0;
            boolean z2 = true;
            int i4 = 0;
            LocalNotificationType localNotificationType3 = null;
            String strM5 = null;
            String str4 = null;
            String strM6 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strM2 = compositeDecoderB.m(serialDescriptor, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        localNotificationType3 = (LocalNotificationType) compositeDecoderB.y(serialDescriptor, 1, LocalNotificationTypeSerializer.INSTANCE, localNotificationType3);
                        i4 |= 2;
                        break;
                    case 2:
                        strM5 = compositeDecoderB.m(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        str4 = (String) compositeDecoderB.n(serialDescriptor, 3, StringSerializer.f142891a, str4);
                        i4 |= 8;
                        break;
                    case 4:
                        strM6 = compositeDecoderB.m(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        jF2 = compositeDecoderB.f(serialDescriptor, 5);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i4;
            str = strM2;
            jF = jF2;
            localNotificationType = localNotificationType3;
            str2 = strM5;
            str3 = str4;
            strM = strM6;
        }
        compositeDecoderB.c(serialDescriptor);
        return new LocalNotification(i3, str, localNotificationType, str2, str3, strM, jF, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LocalNotification value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        LocalNotification.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
