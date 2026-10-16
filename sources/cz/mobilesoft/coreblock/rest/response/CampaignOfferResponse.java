package cz.mobilesoft.coreblock.rest.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Deprecated;
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
public final class CampaignOfferResponse implements Serializable {
    public static final int $stable = 0;

    @SerializedName("body")
    private final String body;

    @SerializedName("discount")
    private final String discount;

    @SerializedName("id")
    private final long id;

    @SerializedName("imagePath")
    private final String imagePath;

    @SerializedName("productGoogle")
    private final String product;

    @SerializedName("title")
    private final String title;

    public CampaignOfferResponse(long j3, String title, String body, String imagePath, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        this.id = j3;
        this.title = title;
        this.body = body;
        this.imagePath = imagePath;
        this.product = str;
        this.discount = str2;
    }

    public static /* synthetic */ CampaignOfferResponse copy$default(CampaignOfferResponse campaignOfferResponse, long j3, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = campaignOfferResponse.id;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            str = campaignOfferResponse.title;
        }
        String str6 = str;
        if ((i3 & 4) != 0) {
            str2 = campaignOfferResponse.body;
        }
        String str7 = str2;
        if ((i3 & 8) != 0) {
            str3 = campaignOfferResponse.imagePath;
        }
        String str8 = str3;
        if ((i3 & 16) != 0) {
            str4 = campaignOfferResponse.product;
        }
        String str9 = str4;
        if ((i3 & 32) != 0) {
            str5 = campaignOfferResponse.discount;
        }
        return campaignOfferResponse.copy(j4, str6, str7, str8, str9, str5);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.body;
    }

    public final String component4() {
        return this.imagePath;
    }

    public final String component5() {
        return this.product;
    }

    public final String component6() {
        return this.discount;
    }

    public final CampaignOfferResponse copy(long j3, String title, String body, String imagePath, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        return new CampaignOfferResponse(j3, title, body, imagePath, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignOfferResponse)) {
            return false;
        }
        CampaignOfferResponse campaignOfferResponse = (CampaignOfferResponse) obj;
        return this.id == campaignOfferResponse.id && Intrinsics.areEqual(this.title, campaignOfferResponse.title) && Intrinsics.areEqual(this.body, campaignOfferResponse.body) && Intrinsics.areEqual(this.imagePath, campaignOfferResponse.imagePath) && Intrinsics.areEqual(this.product, campaignOfferResponse.product) && Intrinsics.areEqual(this.discount, campaignOfferResponse.discount);
    }

    public final String getBody() {
        return this.body;
    }

    public final String getDiscount() {
        return this.discount;
    }

    public final long getId() {
        return this.id;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final String getProduct() {
        return this.product;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.imagePath.hashCode()) * 31;
        String str = this.product;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.discount;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CampaignOfferResponse(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", imagePath=" + this.imagePath + ", product=" + this.product + ", discount=" + this.discount + ")";
    }

    @Deprecated
    public static /* synthetic */ void getProduct$annotations() {
    }
}
