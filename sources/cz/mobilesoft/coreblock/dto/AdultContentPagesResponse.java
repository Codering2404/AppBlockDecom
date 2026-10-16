package cz.mobilesoft.coreblock.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
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
public final class AdultContentPagesResponse implements Serializable {

    @SerializedName("date")
    private final Date date;

    @SerializedName("page")
    private final int page;

    @SerializedName("pageSize")
    private final int pageSize;

    @SerializedName("sites")
    private final List<AdultContentWebsiteDTO> sites;

    @SerializedName("totalPages")
    private final int totalPages;

    public final Date a() {
        return this.date;
    }

    public final List b() {
        return this.sites;
    }

    public final int c() {
        return this.totalPages;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdultContentPagesResponse)) {
            return false;
        }
        AdultContentPagesResponse adultContentPagesResponse = (AdultContentPagesResponse) obj;
        return Intrinsics.areEqual(this.sites, adultContentPagesResponse.sites) && this.page == adultContentPagesResponse.page && this.pageSize == adultContentPagesResponse.pageSize && this.totalPages == adultContentPagesResponse.totalPages && Intrinsics.areEqual(this.date, adultContentPagesResponse.date);
    }

    public int hashCode() {
        return (((((((this.sites.hashCode() * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.pageSize)) * 31) + Integer.hashCode(this.totalPages)) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "AdultContentPagesResponse(sites=" + this.sites + ", page=" + this.page + ", pageSize=" + this.pageSize + ", totalPages=" + this.totalPages + ", date=" + this.date + ")";
    }
}
