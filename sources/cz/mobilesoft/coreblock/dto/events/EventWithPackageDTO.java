package cz.mobilesoft.coreblock.dto.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class EventWithPackageDTO {
    public static final int $stable = 0;
    private final String packageName;
    private final long timestamp;

    public EventWithPackageDTO() {
        this(0L, null, 3, null);
    }

    public static /* synthetic */ EventWithPackageDTO copy$default(EventWithPackageDTO eventWithPackageDTO, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = eventWithPackageDTO.timestamp;
        }
        if ((i3 & 2) != 0) {
            str = eventWithPackageDTO.packageName;
        }
        return eventWithPackageDTO.copy(j3, str);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.packageName;
    }

    public final EventWithPackageDTO copy(long j3, String str) {
        return new EventWithPackageDTO(j3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventWithPackageDTO)) {
            return false;
        }
        EventWithPackageDTO eventWithPackageDTO = (EventWithPackageDTO) obj;
        return this.timestamp == eventWithPackageDTO.timestamp && Intrinsics.areEqual(this.packageName, eventWithPackageDTO.packageName);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.timestamp) * 31;
        String str = this.packageName;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "EventWithPackageDTO(timestamp=" + this.timestamp + ", packageName=" + this.packageName + ")";
    }

    public EventWithPackageDTO(long j3, String str) {
        this.timestamp = j3;
        this.packageName = str;
    }

    public /* synthetic */ EventWithPackageDTO(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : str);
    }
}
