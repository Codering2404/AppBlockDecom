package cz.mobilesoft.coreblock.util.discount;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PlacementShownTime {
    public static final int $stable = 0;
    private final String placement;
    private final long shownTime;

    public PlacementShownTime(String placement, long j3) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.placement = placement;
        this.shownTime = j3;
    }

    public static /* synthetic */ PlacementShownTime copy$default(PlacementShownTime placementShownTime, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = placementShownTime.placement;
        }
        if ((i3 & 2) != 0) {
            j3 = placementShownTime.shownTime;
        }
        return placementShownTime.copy(str, j3);
    }

    public final String component1() {
        return this.placement;
    }

    public final long component2() {
        return this.shownTime;
    }

    public final PlacementShownTime copy(String placement, long j3) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        return new PlacementShownTime(placement, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlacementShownTime)) {
            return false;
        }
        PlacementShownTime placementShownTime = (PlacementShownTime) obj;
        return Intrinsics.areEqual(this.placement, placementShownTime.placement) && this.shownTime == placementShownTime.shownTime;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public final long getShownTime() {
        return this.shownTime;
    }

    public int hashCode() {
        return (this.placement.hashCode() * 31) + Long.hashCode(this.shownTime);
    }

    public String toString() {
        return "PlacementShownTime(placement=" + this.placement + ", shownTime=" + this.shownTime + ")";
    }
}
