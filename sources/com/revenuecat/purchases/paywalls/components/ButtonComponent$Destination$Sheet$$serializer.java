package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class ButtonComponent$Destination$Sheet$$serializer implements GeneratedSerializer<ButtonComponent.Destination.Sheet> {
    public static final ButtonComponent$Destination$Sheet$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ButtonComponent$Destination$Sheet$$serializer buttonComponent$Destination$Sheet$$serializer = new ButtonComponent$Destination$Sheet$$serializer();
        INSTANCE = buttonComponent$Destination$Sheet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Sheet", buttonComponent$Destination$Sheet$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("name", false);
        pluginGeneratedSerialDescriptor.p("stack", false);
        pluginGeneratedSerialDescriptor.p("background_blur", false);
        pluginGeneratedSerialDescriptor.p("size", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ButtonComponent$Destination$Sheet$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), StackComponent$$serializer.INSTANCE, BooleanSerializer.f142767a, BuiltinSerializersKt.u(Size$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ButtonComponent.Destination.Sheet deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        String str;
        String str2;
        StackComponent stackComponent;
        Size size;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        if (compositeDecoderB.p()) {
            String strM = compositeDecoderB.m(descriptor2, 0);
            String str3 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, null);
            StackComponent stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            str = strM;
            zC = compositeDecoderB.C(descriptor2, 3);
            size = (Size) compositeDecoderB.n(descriptor2, 4, Size$$serializer.INSTANCE, null);
            stackComponent = stackComponent2;
            str2 = str3;
            i3 = 31;
        } else {
            boolean z2 = true;
            boolean zC2 = false;
            String strM2 = null;
            String str4 = null;
            StackComponent stackComponent3 = null;
            Size size2 = null;
            int i4 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM2 = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    str4 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str4);
                    i4 |= 2;
                } else if (iO == 2) {
                    stackComponent3 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent3);
                    i4 |= 4;
                } else if (iO == 3) {
                    zC2 = compositeDecoderB.C(descriptor2, 3);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    size2 = (Size) compositeDecoderB.n(descriptor2, 4, Size$$serializer.INSTANCE, size2);
                    i4 |= 16;
                }
            }
            zC = zC2;
            i3 = i4;
            str = strM2;
            str2 = str4;
            stackComponent = stackComponent3;
            size = size2;
        }
        compositeDecoderB.c(descriptor2);
        return new ButtonComponent.Destination.Sheet(i3, str, str2, stackComponent, zC, size, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ButtonComponent.Destination.Sheet value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ButtonComponent.Destination.Sheet.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
