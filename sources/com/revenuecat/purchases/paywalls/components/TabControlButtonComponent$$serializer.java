package com.revenuecat.purchases.paywalls.components;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class TabControlButtonComponent$$serializer implements GeneratedSerializer<TabControlButtonComponent> {
    public static final TabControlButtonComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabControlButtonComponent$$serializer tabControlButtonComponent$$serializer = new TabControlButtonComponent$$serializer();
        INSTANCE = tabControlButtonComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tab_control_button", tabControlButtonComponent$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("tab_index", false);
        pluginGeneratedSerialDescriptor.p("tab_id", false);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabControlButtonComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{IntSerializer.f142823a, stringSerializer, StackComponent$$serializer.INSTANCE, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabControlButtonComponent deserialize(Decoder decoder) {
        int i3;
        int i4;
        String str;
        StackComponent stackComponent;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            i3 = compositeDecoderB.i(descriptor2, 0);
            String strM = compositeDecoderB.m(descriptor2, 1);
            StackComponent stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            str2 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, null);
            stackComponent = stackComponent2;
            str = strM;
            i4 = 15;
        } else {
            boolean z2 = true;
            i3 = 0;
            String strM2 = null;
            StackComponent stackComponent3 = null;
            String str3 = null;
            int i5 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    i3 = compositeDecoderB.i(descriptor2, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    strM2 = compositeDecoderB.m(descriptor2, 1);
                    i5 |= 2;
                } else if (iO == 2) {
                    stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent3);
                    i5 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    str3 = (String) compositeDecoderB.n(descriptor2, 3, StringSerializer.f142891a, str3);
                    i5 |= 8;
                }
            }
            i4 = i5;
            str = strM2;
            stackComponent = stackComponent3;
            str2 = str3;
        }
        int i6 = i3;
        compositeDecoderB.c(descriptor2);
        return new TabControlButtonComponent(i4, i6, str, stackComponent, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabControlButtonComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TabControlButtonComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
