package com.revenuecat.purchases.paywalls.components;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import java.util.List;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class TimelineComponent$Item$$serializer implements GeneratedSerializer<TimelineComponent.Item> {
    public static final TimelineComponent$Item$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private TimelineComponent$Item$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TimelineComponent.Item.$childSerializers;
        TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
        return new KSerializer[]{textComponent$$serializer, BuiltinSerializersKt.u(BooleanSerializer.f142767a), BuiltinSerializersKt.u(textComponent$$serializer), IconComponent$$serializer.INSTANCE, BuiltinSerializersKt.u(TimelineComponent$Connector$$serializer.INSTANCE), kSerializerArr[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimelineComponent.Item deserialize(Decoder decoder) {
        int i3;
        TextComponent textComponent;
        Boolean bool;
        TextComponent textComponent2;
        IconComponent iconComponent;
        TimelineComponent.Connector connector;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = TimelineComponent.Item.$childSerializers;
        int i4 = 3;
        TextComponent textComponent3 = null;
        if (compositeDecoderB.p()) {
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            TextComponent textComponent4 = (TextComponent) compositeDecoderB.y(descriptor2, 0, textComponent$$serializer, null);
            Boolean bool2 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, null);
            TextComponent textComponent5 = (TextComponent) compositeDecoderB.n(descriptor2, 2, textComponent$$serializer, null);
            IconComponent iconComponent2 = (IconComponent) compositeDecoderB.y(descriptor2, 3, IconComponent$$serializer.INSTANCE, null);
            TimelineComponent.Connector connector2 = (TimelineComponent.Connector) compositeDecoderB.n(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, null);
            list = (List) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            textComponent2 = textComponent5;
            iconComponent = iconComponent2;
            connector = connector2;
            i3 = 63;
            bool = bool2;
            textComponent = textComponent4;
        } else {
            boolean z2 = true;
            int i5 = 0;
            Boolean bool3 = null;
            TextComponent textComponent6 = null;
            IconComponent iconComponent3 = null;
            TimelineComponent.Connector connector3 = null;
            List list2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i4 = 3;
                        break;
                    case 0:
                        textComponent3 = (TextComponent) compositeDecoderB.y(descriptor2, 0, TextComponent$$serializer.INSTANCE, textComponent3);
                        i5 |= 1;
                        i4 = 3;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool3);
                        i5 |= 2;
                        break;
                    case 2:
                        textComponent6 = (TextComponent) compositeDecoderB.n(descriptor2, 2, TextComponent$$serializer.INSTANCE, textComponent6);
                        i5 |= 4;
                        break;
                    case 3:
                        iconComponent3 = (IconComponent) compositeDecoderB.y(descriptor2, i4, IconComponent$$serializer.INSTANCE, iconComponent3);
                        i5 |= 8;
                        break;
                    case 4:
                        connector3 = (TimelineComponent.Connector) compositeDecoderB.n(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, connector3);
                        i5 |= 16;
                        break;
                    case 5:
                        list2 = (List) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], list2);
                        i5 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            i3 = i5;
            textComponent = textComponent3;
            bool = bool3;
            textComponent2 = textComponent6;
            iconComponent = iconComponent3;
            connector = connector3;
            list = list2;
        }
        compositeDecoderB.c(descriptor2);
        return new TimelineComponent.Item(i3, textComponent, bool, textComponent2, iconComponent, connector, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimelineComponent.Item value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TimelineComponent.Item.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    static {
        TimelineComponent$Item$$serializer timelineComponent$Item$$serializer = new TimelineComponent$Item$$serializer();
        INSTANCE = timelineComponent$Item$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.TimelineComponent.Item", timelineComponent$Item$$serializer, 6);
        pluginGeneratedSerialDescriptor.p(qRMDmh.IBV, false);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("description", true);
        pluginGeneratedSerialDescriptor.p("icon", false);
        pluginGeneratedSerialDescriptor.p("connector", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
