package com.superwall.sdk.models.events;

import com.superwall.sdk.models.serialization.AnySerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class EventData {
    private final Date createdAt;
    private final String id;
    private final String name;
    private final Map<String, Object> parameters;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new LinkedHashMapSerializer(StringSerializer.f142891a, AnySerializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventData> serializer() {
            return EventData$$serializer.INSTANCE;
        }

        public final EventData stub() {
            return new EventData((String) null, "opened_application", MapsKt.emptyMap(), new Date(), 1, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ EventData(int i3, String str, String str2, Map map, Date date, SerializationConstructorMarker serializationConstructorMarker) {
        if (14 != (i3 & 14)) {
            PluginExceptionsKt.b(i3, 14, EventData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = str;
        }
        this.name = str2;
        this.parameters = map;
        this.createdAt = date;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventData copy$default(EventData eventData, String str, String str2, Map map, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eventData.id;
        }
        if ((i3 & 2) != 0) {
            str2 = eventData.name;
        }
        if ((i3 & 4) != 0) {
            map = eventData.parameters;
        }
        if ((i3 & 8) != 0) {
            date = eventData.createdAt;
        }
        return eventData.copy(str, str2, map, date);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(EventData eventData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(eventData.id, UUID.randomUUID().toString())) {
            compositeEncoder.y(serialDescriptor, 0, eventData.id);
        }
        compositeEncoder.y(serialDescriptor, 1, eventData.name);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], eventData.parameters);
        compositeEncoder.C(serialDescriptor, 3, DateSerializer.INSTANCE, eventData.createdAt);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Map<String, Object> component3() {
        return this.parameters;
    }

    public final Date component4() {
        return this.createdAt;
    }

    public final EventData copy(String id, String name, Map<String, ? extends Object> parameters, Date createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new EventData(id, name, parameters, createdAt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventData)) {
            return false;
        }
        EventData eventData = (EventData) obj;
        return Intrinsics.areEqual(this.id, eventData.id) && Intrinsics.areEqual(this.name, eventData.name) && Intrinsics.areEqual(this.parameters, eventData.parameters) && Intrinsics.areEqual(this.createdAt, eventData.createdAt);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "EventData(id=" + this.id + ", name=" + this.name + ", parameters=" + this.parameters + ", createdAt=" + this.createdAt + ")";
    }

    public EventData(String id, String name, Map<String, ? extends Object> parameters, Date createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = id;
        this.name = name;
        this.parameters = parameters;
        this.createdAt = createdAt;
    }

    public /* synthetic */ EventData(String str, String str2, Map map, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UUID.randomUUID().toString() : str, str2, map, date);
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getParameters$annotations() {
    }
}
