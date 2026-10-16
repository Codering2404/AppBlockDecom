package com.superwall.sdk.models.events;

import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.models.events.EventsResponse;
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
public /* synthetic */ class EventsResponse$$serializer implements GeneratedSerializer<EventsResponse> {
    public static final EventsResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        EventsResponse$$serializer eventsResponse$$serializer = new EventsResponse$$serializer();
        INSTANCE = eventsResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.events.EventsResponse", eventsResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.p(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, false);
        pluginGeneratedSerialDescriptor.p("invalidIndexes", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private EventsResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StatusSerializer.INSTANCE, BuiltinSerializersKt.u(EventsResponse.$childSerializers[1])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EventsResponse deserialize(Decoder decoder) {
        List list;
        EventsResponse.Status status;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = EventsResponse.$childSerializers;
        if (compositeDecoderB.p()) {
            status = (EventsResponse.Status) compositeDecoderB.y(serialDescriptor, 0, StatusSerializer.INSTANCE, null);
            list = (List) compositeDecoderB.n(serialDescriptor, 1, kSerializerArr[1], null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list2 = null;
            EventsResponse.Status status2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    status2 = (EventsResponse.Status) compositeDecoderB.y(serialDescriptor, 0, StatusSerializer.INSTANCE, status2);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) compositeDecoderB.n(serialDescriptor, 1, kSerializerArr[1], list2);
                    i4 |= 2;
                }
            }
            list = list2;
            status = status2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new EventsResponse(i3, status, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EventsResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        EventsResponse.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
