package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TabsComponent;
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
public final class TabsComponent$Tab$$serializer implements GeneratedSerializer<TabsComponent.Tab> {
    public static final TabsComponent$Tab$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabsComponent$Tab$$serializer tabsComponent$Tab$$serializer = new TabsComponent$Tab$$serializer();
        INSTANCE = tabsComponent$Tab$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.TabsComponent.Tab", tabsComponent$Tab$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("stack", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabsComponent$Tab$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), StackComponent$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabsComponent.Tab deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        StackComponent stackComponent;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(descriptor2, 0);
            String str3 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, null);
            str = strM2;
            stackComponent = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            str2 = str3;
            i3 = 7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str4 = null;
            StackComponent stackComponent2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(descriptor2, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    str4 = (String) compositeDecoderB.n(descriptor2, 1, StringSerializer.f142891a, str4);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    stackComponent2 = (StackComponent) compositeDecoderB.y(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = strM;
            str2 = str4;
            stackComponent = stackComponent2;
        }
        compositeDecoderB.c(descriptor2);
        return new TabsComponent.Tab(i3, str, str2, stackComponent, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabsComponent.Tab value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TabsComponent.Tab.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
