package cz.mobilesoft.coreblock.dto.events;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class EventWithIdsDTO {
    public static final int $stable = 8;
    private final List<Long> ids;
    private final long timestamp;

    public EventWithIdsDTO(long j3, List<Long> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.timestamp = j3;
        this.ids = ids;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventWithIdsDTO copy$default(EventWithIdsDTO eventWithIdsDTO, long j3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = eventWithIdsDTO.timestamp;
        }
        if ((i3 & 2) != 0) {
            list = eventWithIdsDTO.ids;
        }
        return eventWithIdsDTO.copy(j3, list);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final List<Long> component2() {
        return this.ids;
    }

    public final EventWithIdsDTO copy(long j3, List<Long> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return new EventWithIdsDTO(j3, ids);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventWithIdsDTO)) {
            return false;
        }
        EventWithIdsDTO eventWithIdsDTO = (EventWithIdsDTO) obj;
        return this.timestamp == eventWithIdsDTO.timestamp && Intrinsics.areEqual(this.ids, eventWithIdsDTO.ids);
    }

    public final List<Long> getIds() {
        return this.ids;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (Long.hashCode(this.timestamp) * 31) + this.ids.hashCode();
    }

    public String toString() {
        return "EventWithIdsDTO(timestamp=" + this.timestamp + ", ids=" + this.ids + ")";
    }
}
