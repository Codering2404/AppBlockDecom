package com.superwall.sdk.paywall.view.webview.templating.models;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import java.util.Map;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class Variables$$serializer implements GeneratedSerializer<Variables> {
    public static final Variables$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Variables$$serializer variables$$serializer = new Variables$$serializer();
        INSTANCE = variables$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.paywall.view.webview.templating.models.Variables", variables$$serializer, 7);
        pluginGeneratedSerialDescriptor.p("user", false);
        pluginGeneratedSerialDescriptor.p(DeviceRequestsHelper.DEVICE_INFO_DEVICE, false);
        pluginGeneratedSerialDescriptor.p(NativeProtocol.WEB_DIALOG_PARAMS, false);
        pluginGeneratedSerialDescriptor.p("products", true);
        pluginGeneratedSerialDescriptor.p("primary", true);
        pluginGeneratedSerialDescriptor.p("secondary", true);
        pluginGeneratedSerialDescriptor.p("tertiary", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Variables$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = Variables.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], kSerializerArr[2], kSerializerArr[3], kSerializerArr[4], kSerializerArr[5], kSerializerArr[6]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Variables deserialize(Decoder decoder) {
        int i3;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        Map map5;
        List list;
        Map map6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = Variables.$childSerializers;
        int i4 = 6;
        int i5 = 2;
        Map map7 = null;
        if (compositeDecoderB.p()) {
            Map map8 = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            Map map9 = (Map) compositeDecoderB.y(serialDescriptor, 1, kSerializerArr[1], null);
            Map map10 = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            List list2 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], null);
            Map map11 = (Map) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], null);
            Map map12 = (Map) compositeDecoderB.y(serialDescriptor, 5, kSerializerArr[5], null);
            map = (Map) compositeDecoderB.y(serialDescriptor, 6, kSerializerArr[6], null);
            map3 = map8;
            i3 = 127;
            map2 = map12;
            list = list2;
            map6 = map11;
            map5 = map10;
            map4 = map9;
        } else {
            int i6 = 1;
            boolean z2 = true;
            int i7 = 0;
            Map map13 = null;
            Map map14 = null;
            Map map15 = null;
            Map map16 = null;
            List list3 = null;
            Map map17 = null;
            while (z2) {
                int i8 = i5;
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 6;
                        i5 = 2;
                        i6 = 1;
                        break;
                    case 0:
                        map7 = (Map) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], map7);
                        i7 |= 1;
                        i4 = 6;
                        i5 = 2;
                        i6 = 1;
                        break;
                    case 1:
                        map15 = (Map) compositeDecoderB.y(serialDescriptor, i6, kSerializerArr[i6], map15);
                        i7 |= 2;
                        i4 = 6;
                        i5 = 2;
                        break;
                    case 2:
                        map16 = (Map) compositeDecoderB.y(serialDescriptor, i8, kSerializerArr[i8], map16);
                        i7 |= 4;
                        i5 = i8;
                        i4 = 6;
                        break;
                    case 3:
                        list3 = (List) compositeDecoderB.y(serialDescriptor, 3, kSerializerArr[3], list3);
                        i7 |= 8;
                        i5 = i8;
                        break;
                    case 4:
                        map17 = (Map) compositeDecoderB.y(serialDescriptor, 4, kSerializerArr[4], map17);
                        i7 |= 16;
                        i5 = i8;
                        break;
                    case 5:
                        map14 = (Map) compositeDecoderB.y(serialDescriptor, 5, kSerializerArr[5], map14);
                        i7 |= 32;
                        i5 = i8;
                        break;
                    case 6:
                        map13 = (Map) compositeDecoderB.y(serialDescriptor, i4, kSerializerArr[i4], map13);
                        i7 |= 64;
                        i5 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i7;
            map = map13;
            map2 = map14;
            map3 = map7;
            map4 = map15;
            map5 = map16;
            list = list3;
            map6 = map17;
        }
        compositeDecoderB.c(serialDescriptor);
        return new Variables(i3, map3, map4, map5, list, map6, map2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Variables value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        Variables.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
