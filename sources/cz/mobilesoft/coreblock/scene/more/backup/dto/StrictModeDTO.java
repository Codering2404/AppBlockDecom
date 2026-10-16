package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
public final class StrictModeDTO {

    @SerializedName("accessMethod")
    private final String accessMethod;

    @SerializedName("followSchedulesVariant")
    private final long followSchedulesVariant;

    @SerializedName(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)
    private final List<String> options;

    public StrictModeDTO(String str, List options, long j3) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.accessMethod = str;
        this.options = options;
        this.followSchedulesVariant = j3;
    }

    public final String a() {
        return this.accessMethod;
    }

    public final long b() {
        return this.followSchedulesVariant;
    }

    public final List c() {
        return this.options;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeDTO)) {
            return false;
        }
        StrictModeDTO strictModeDTO = (StrictModeDTO) obj;
        return Intrinsics.areEqual(this.accessMethod, strictModeDTO.accessMethod) && Intrinsics.areEqual(this.options, strictModeDTO.options) && this.followSchedulesVariant == strictModeDTO.followSchedulesVariant;
    }

    public int hashCode() {
        String str = this.accessMethod;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.options.hashCode()) * 31) + Long.hashCode(this.followSchedulesVariant);
    }

    public String toString() {
        return "StrictModeDTO(accessMethod=" + this.accessMethod + ", options=" + this.options + ", followSchedulesVariant=" + this.followSchedulesVariant + ")";
    }
}
