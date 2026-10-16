package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
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
public final class ProfileWebsiteDTO {

    @SerializedName("blockingType")
    private final int blockingType;

    @SerializedName("isAnywhereInUrl")
    private final boolean isAnywhereInUrl;

    @SerializedName("url")
    private final String url;

    public ProfileWebsiteDTO(int i3, String url, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.blockingType = i3;
        this.url = url;
        this.isAnywhereInUrl = z2;
    }

    public final int a() {
        return this.blockingType;
    }

    public final String b() {
        return this.url;
    }

    public final boolean c() {
        return this.isAnywhereInUrl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWebsiteDTO)) {
            return false;
        }
        ProfileWebsiteDTO profileWebsiteDTO = (ProfileWebsiteDTO) obj;
        return this.blockingType == profileWebsiteDTO.blockingType && Intrinsics.areEqual(this.url, profileWebsiteDTO.url) && this.isAnywhereInUrl == profileWebsiteDTO.isAnywhereInUrl;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.blockingType) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.isAnywhereInUrl);
    }

    public String toString() {
        return "ProfileWebsiteDTO(blockingType=" + this.blockingType + ", url=" + this.url + ", isAnywhereInUrl=" + this.isAnywhereInUrl + ")";
    }
}
