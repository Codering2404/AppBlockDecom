package com.superwall.sdk.models.config;

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
public /* synthetic */ class WebToAppConfig$$serializer implements GeneratedSerializer<WebToAppConfig> {
    public static final WebToAppConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        WebToAppConfig$$serializer webToAppConfig$$serializer = new WebToAppConfig$$serializer();
        INSTANCE = webToAppConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.config.WebToAppConfig", webToAppConfig$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("entitlements_max_age_ms", true);
        pluginGeneratedSerialDescriptor.p("restore_access_url", true);
        pluginGeneratedSerialDescriptor.p("url_schema", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebToAppConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{LongSerializer.f142836a, BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final WebToAppConfig deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        String str3 = null;
        if (compositeDecoderB.p()) {
            long jF = compositeDecoderB.f(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str4 = (String) compositeDecoderB.n(serialDescriptor, 1, stringSerializer, null);
            str2 = (String) compositeDecoderB.n(serialDescriptor, 2, stringSerializer, null);
            i3 = 7;
            str = str4;
            j3 = jF;
        } else {
            boolean z2 = true;
            int i4 = 0;
            long jF2 = 0;
            String str5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    jF2 = compositeDecoderB.f(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    str3 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, str3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    str5 = (String) compositeDecoderB.n(serialDescriptor, 2, StringSerializer.f142891a, str5);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = str3;
            str2 = str5;
            j3 = jF2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new WebToAppConfig(i3, j3, str, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, WebToAppConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        WebToAppConfig.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
