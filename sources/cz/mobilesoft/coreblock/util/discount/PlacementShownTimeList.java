package cz.mobilesoft.coreblock.util.discount;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PlacementShownTimeList {
    public static final int $stable = 8;
    private final List<PlacementShownTime> placements;

    public PlacementShownTimeList(List<PlacementShownTime> list) {
        this.placements = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlacementShownTimeList copy$default(PlacementShownTimeList placementShownTimeList, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = placementShownTimeList.placements;
        }
        return placementShownTimeList.copy(list);
    }

    public final List<PlacementShownTime> component1() {
        return this.placements;
    }

    public final PlacementShownTimeList copy(List<PlacementShownTime> list) {
        return new PlacementShownTimeList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlacementShownTimeList) && Intrinsics.areEqual(this.placements, ((PlacementShownTimeList) obj).placements);
    }

    public final List<PlacementShownTime> getPlacements() {
        return this.placements;
    }

    public int hashCode() {
        List<PlacementShownTime> list = this.placements;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "PlacementShownTimeList(placements=" + this.placements + ")";
    }
}
