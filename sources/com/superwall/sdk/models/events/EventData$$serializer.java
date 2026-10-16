package com.superwall.sdk.models.events;

import com.superwall.sdk.models.serialization.DateSerializer;
import java.util.Date;
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
public /* synthetic */ class EventData$$serializer implements GeneratedSerializer<EventData> {
    public static final EventData$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        EventData$$serializer eventData$$serializer = new EventData$$serializer();
        INSTANCE = eventData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.events.EventData", eventData$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("event_id", true);
        pluginGeneratedSerialDescriptor.p("event_name", false);
        pluginGeneratedSerialDescriptor.p("parameters", false);
        pluginGeneratedSerialDescriptor.p("created_at", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private EventData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = EventData.$childSerializers[2];
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer, DateSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EventData deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        Map map;
        Date date;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = EventData.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String strM3 = compositeDecoderB.m(serialDescriptor, 1);
            map = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            str = strM2;
            date = (Date) compositeDecoderB.y(serialDescriptor, 3, DateSerializer.INSTANCE, null);
            i3 = 15;
            str2 = strM3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String strM4 = null;
            Map map2 = null;
            Date date2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    map2 = (Map) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], map2);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    date2 = (Date) compositeDecoderB.y(serialDescriptor, 3, DateSerializer.INSTANCE, date2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            str = strM;
            str2 = strM4;
            map = map2;
            date = date2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new EventData(i3, str, str2, map, date, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EventData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        EventData.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
