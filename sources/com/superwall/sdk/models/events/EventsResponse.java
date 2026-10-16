package com.superwall.sdk.models.events;

import com.superwall.sdk.models.SerializableEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class EventsResponse implements SerializableEntity {
    private final List<Integer> invalidIndexes;
    private final Status status;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(IntSerializer.f142823a)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<EventsResponse> serializer() {
            return EventsResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = StatusSerializer.class)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Companion Companion;
        public static final Status OK = new Status("OK", 0);
        public static final Status PARTIAL_SUCCESS = new Status("PARTIAL_SUCCESS", 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Status> serializer() {
                return StatusSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{OK, PARTIAL_SUCCESS};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.a(statusArr$values);
            Companion = new Companion(null);
        }

        private Status(String str, int i3) {
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public /* synthetic */ EventsResponse(int i3, Status status, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, EventsResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.status = status;
        if ((i3 & 2) == 0) {
            this.invalidIndexes = null;
        } else {
            this.invalidIndexes = list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventsResponse copy$default(EventsResponse eventsResponse, Status status, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            status = eventsResponse.status;
        }
        if ((i3 & 2) != 0) {
            list = eventsResponse.invalidIndexes;
        }
        return eventsResponse.copy(status, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(EventsResponse eventsResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, StatusSerializer.INSTANCE, eventsResponse.status);
        if (!compositeEncoder.z(serialDescriptor, 1) && eventsResponse.invalidIndexes == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, kSerializerArr[1], eventsResponse.invalidIndexes);
    }

    public final Status component1() {
        return this.status;
    }

    public final List<Integer> component2() {
        return this.invalidIndexes;
    }

    public final EventsResponse copy(Status status, List<Integer> list) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new EventsResponse(status, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventsResponse)) {
            return false;
        }
        EventsResponse eventsResponse = (EventsResponse) obj;
        return this.status == eventsResponse.status && Intrinsics.areEqual(this.invalidIndexes, eventsResponse.invalidIndexes);
    }

    public final List<Integer> getInvalidIndexes() {
        return this.invalidIndexes;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        List<Integer> list = this.invalidIndexes;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "EventsResponse(status=" + this.status + ", invalidIndexes=" + this.invalidIndexes + ")";
    }

    public EventsResponse(Status status, List<Integer> list) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.invalidIndexes = list;
    }

    public /* synthetic */ EventsResponse(Status status, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, (i3 & 2) != 0 ? null : list);
    }
}
