package com.superwall.sdk.game;

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
import kotlinx.serialization.internal.DoubleSerializer;
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
public /* synthetic */ class GameControllerEvent$$serializer implements GeneratedSerializer<GameControllerEvent> {
    public static final GameControllerEvent$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GameControllerEvent$$serializer gameControllerEvent$$serializer = new GameControllerEvent$$serializer();
        INSTANCE = gameControllerEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.game.GameControllerEvent", gameControllerEvent$$serializer, 6);
        pluginGeneratedSerialDescriptor.p("event_name", true);
        pluginGeneratedSerialDescriptor.p("controller_element", false);
        pluginGeneratedSerialDescriptor.p("value", false);
        pluginGeneratedSerialDescriptor.p("x", false);
        pluginGeneratedSerialDescriptor.p("y", false);
        pluginGeneratedSerialDescriptor.p("directional", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GameControllerEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        DoubleSerializer doubleSerializer = DoubleSerializer.f142796a;
        return new KSerializer[]{stringSerializer, stringSerializer, doubleSerializer, doubleSerializer, doubleSerializer, BooleanSerializer.f142767a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final GameControllerEvent deserialize(Decoder decoder) {
        String strM;
        boolean zC;
        double d3;
        int i3;
        String str;
        double d4;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            strM = compositeDecoderB.m(serialDescriptor, 0);
            String strM2 = compositeDecoderB.m(serialDescriptor, 1);
            double dF = compositeDecoderB.F(serialDescriptor, 2);
            double dF2 = compositeDecoderB.F(serialDescriptor, 3);
            double dF3 = compositeDecoderB.F(serialDescriptor, 4);
            zC = compositeDecoderB.C(serialDescriptor, 5);
            d3 = dF3;
            i3 = 63;
            str = strM2;
            d4 = dF;
            d5 = dF2;
        } else {
            strM = null;
            String strM3 = null;
            boolean z2 = true;
            int i4 = 0;
            double dF4 = 0.0d;
            double dF5 = 0.0d;
            boolean zC2 = false;
            double dF6 = 0.0d;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                switch (iO) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strM = compositeDecoderB.m(serialDescriptor, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        strM3 = compositeDecoderB.m(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        dF4 = compositeDecoderB.F(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        dF5 = compositeDecoderB.F(serialDescriptor, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        dF6 = compositeDecoderB.F(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        zC2 = compositeDecoderB.C(serialDescriptor, 5);
                        i4 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            zC = zC2;
            d3 = dF6;
            i3 = i4;
            str = strM3;
            d4 = dF4;
            d5 = dF5;
        }
        String str2 = strM;
        compositeDecoderB.c(serialDescriptor);
        return new GameControllerEvent(i3, str2, str, d4, d5, d3, zC, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GameControllerEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        GameControllerEvent.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
