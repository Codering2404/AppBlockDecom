package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
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
public final class BlockScreenSettingsDTO {

    @SerializedName("blockScreens")
    private final List<BlockScreenConfigDTO> blockScreens;

    @SerializedName("selectedId")
    private final String selectedId;

    public BlockScreenSettingsDTO(String selectedId, List blockScreens) {
        Intrinsics.checkNotNullParameter(selectedId, "selectedId");
        Intrinsics.checkNotNullParameter(blockScreens, "blockScreens");
        this.selectedId = selectedId;
        this.blockScreens = blockScreens;
    }

    public final List a() {
        return this.blockScreens;
    }

    public final String b() {
        return this.selectedId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockScreenSettingsDTO)) {
            return false;
        }
        BlockScreenSettingsDTO blockScreenSettingsDTO = (BlockScreenSettingsDTO) obj;
        return Intrinsics.areEqual(this.selectedId, blockScreenSettingsDTO.selectedId) && Intrinsics.areEqual(this.blockScreens, blockScreenSettingsDTO.blockScreens);
    }

    public int hashCode() {
        return (this.selectedId.hashCode() * 31) + this.blockScreens.hashCode();
    }

    public String toString() {
        return "BlockScreenSettingsDTO(selectedId=" + this.selectedId + ", blockScreens=" + this.blockScreens + ")";
    }
}
