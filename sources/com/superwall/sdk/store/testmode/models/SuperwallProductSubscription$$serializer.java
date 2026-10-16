package com.superwall.sdk.store.testmode.models;

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
public /* synthetic */ class SuperwallProductSubscription$$serializer implements GeneratedSerializer<SuperwallProductSubscription> {
    public static final SuperwallProductSubscription$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SuperwallProductSubscription$$serializer superwallProductSubscription$$serializer = new SuperwallProductSubscription$$serializer();
        INSTANCE = superwallProductSubscription$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.store.testmode.models.SuperwallProductSubscription", superwallProductSubscription$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("period", false);
        pluginGeneratedSerialDescriptor.p("period_count", true);
        pluginGeneratedSerialDescriptor.p("trial_period_days", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SuperwallProductSubscription$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = SuperwallProductSubscription.$childSerializers[0];
        IntSerializer intSerializer = IntSerializer.f142823a;
        return new KSerializer[]{kSerializer, intSerializer, BuiltinSerializersKt.u(intSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SuperwallProductSubscription deserialize(Decoder decoder) {
        int i3;
        int i4;
        SuperwallSubscriptionPeriod superwallSubscriptionPeriod;
        Integer num;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = SuperwallProductSubscription.$childSerializers;
        if (compositeDecoderB.p()) {
            SuperwallSubscriptionPeriod superwallSubscriptionPeriod2 = (SuperwallSubscriptionPeriod) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], null);
            i3 = compositeDecoderB.i(serialDescriptor, 1);
            superwallSubscriptionPeriod = superwallSubscriptionPeriod2;
            num = (Integer) compositeDecoderB.n(serialDescriptor, 2, IntSerializer.f142823a, null);
            i4 = 7;
        } else {
            boolean z2 = true;
            i3 = 0;
            SuperwallSubscriptionPeriod superwallSubscriptionPeriod3 = null;
            Integer num2 = null;
            int i5 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    superwallSubscriptionPeriod3 = (SuperwallSubscriptionPeriod) compositeDecoderB.y(serialDescriptor, 0, kSerializerArr[0], superwallSubscriptionPeriod3);
                    i5 |= 1;
                } else if (iO == 1) {
                    i3 = compositeDecoderB.i(serialDescriptor, 1);
                    i5 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    num2 = (Integer) compositeDecoderB.n(serialDescriptor, 2, IntSerializer.f142823a, num2);
                    i5 |= 4;
                }
            }
            i4 = i5;
            superwallSubscriptionPeriod = superwallSubscriptionPeriod3;
            num = num2;
        }
        int i6 = i3;
        compositeDecoderB.c(serialDescriptor);
        return new SuperwallProductSubscription(i4, superwallSubscriptionPeriod, i6, num, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SuperwallProductSubscription value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SuperwallProductSubscription.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
