package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.events.BackendEvent;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class BackendEvent$PresentedOfferingContextData$$serializer implements GeneratedSerializer<BackendEvent.PresentedOfferingContextData> {
    public static final BackendEvent$PresentedOfferingContextData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$PresentedOfferingContextData$$serializer backendEvent$PresentedOfferingContextData$$serializer = new BackendEvent$PresentedOfferingContextData$$serializer();
        INSTANCE = backendEvent$PresentedOfferingContextData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.events.BackendEvent.PresentedOfferingContextData", backendEvent$PresentedOfferingContextData$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("placement_identifier", true);
        pluginGeneratedSerialDescriptor.p("targeting_revision", true);
        pluginGeneratedSerialDescriptor.p("targeting_rule_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$PresentedOfferingContextData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), BuiltinSerializersKt.u(IntSerializer.f142823a), BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.PresentedOfferingContextData deserialize(Decoder decoder) {
        int i3;
        String str;
        Integer num;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        String str3 = null;
        if (compositeDecoderB.p()) {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str4 = (String) compositeDecoderB.n(descriptor2, 0, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, null);
            str2 = (String) compositeDecoderB.n(descriptor2, 2, stringSerializer, null);
            i3 = 7;
            num = num2;
            str = str4;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Integer num3 = null;
            String str5 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    str3 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str3);
                    i4 |= 1;
                } else if (iO == 1) {
                    num3 = (Integer) compositeDecoderB.n(descriptor2, 1, IntSerializer.f142823a, num3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    str5 = (String) compositeDecoderB.n(descriptor2, 2, StringSerializer.f142891a, str5);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = str3;
            num = num3;
            str2 = str5;
        }
        compositeDecoderB.c(descriptor2);
        return new BackendEvent.PresentedOfferingContextData(i3, str, num, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.PresentedOfferingContextData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        BackendEvent.PresentedOfferingContextData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
