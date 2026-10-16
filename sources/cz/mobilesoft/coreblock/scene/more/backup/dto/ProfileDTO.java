package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
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
public final class ProfileDTO {

    @SerializedName("active")
    private final boolean active;

    @SerializedName("addNewApplications")
    private final Boolean addNewApplications;

    @SerializedName("appUsageLimits")
    private final List<AppUsageLimitDTO> appUsageLimits;

    @SerializedName("blockAdultContent")
    private final Boolean blockAdultContent;

    @SerializedName("blockApplications")
    private final Boolean blockApplications;

    @SerializedName("blockNotifications")
    private final Boolean blockNotifications;

    @SerializedName("blockUnsupportedBrowsers")
    private final Boolean blockUnsupportedBrowsers;

    @SerializedName("blockWebsites")
    private final Boolean blockWebsites;

    @SerializedName("blockingMode")
    private final Integer blockingMode;

    @SerializedName("dayFlags")
    private final Integer dayFlags;

    @SerializedName("emojiId")
    private final Integer emojiId;

    @SerializedName("geoAddresses")
    private final List<GeoAddressDTO> geoAddresses;

    @SerializedName("inAppPurchaseForbidden")
    private final Boolean inAppPurchaseForbidden;

    @SerializedName("operator")
    private final int operator;

    @SerializedName("profileApplications")
    private final List<ProfileApplicationDTO> profileApplications;

    @SerializedName("profileIntervals")
    private final List<ProfileIntervalDTO> profileIntervals;

    @SerializedName("profileSubApplications")
    private final List<ProfileSubApplicationDTO> profileSubApplications;

    @SerializedName("profileWebsites")
    private final List<ProfileWebsiteDTO> profileWebsites;

    @SerializedName("profileWifiNetworks")
    private final List<ProfileWifiNetworkDTO> profileWifiNetworks;

    @SerializedName("selectedCategories")
    private final int selectedCategories;

    @SerializedName("title")
    private final String title;

    @SerializedName("typeCombinations")
    private final int typeCombinations;

    public ProfileDTO(String title, boolean z2, Boolean bool, Integer num, Boolean bool2, Boolean bool3, Boolean bool4, int i3, int i4, List list, List list2, List list3, List list4, List list5, List list6, List list7, Integer num2, Integer num3, Boolean bool5, Boolean bool6, Boolean bool7, int i5) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.active = z2;
        this.addNewApplications = bool;
        this.dayFlags = num;
        this.blockNotifications = bool2;
        this.blockApplications = bool3;
        this.blockWebsites = bool4;
        this.typeCombinations = i3;
        this.operator = i4;
        this.appUsageLimits = list;
        this.geoAddresses = list2;
        this.profileApplications = list3;
        this.profileSubApplications = list4;
        this.profileIntervals = list5;
        this.profileWebsites = list6;
        this.profileWifiNetworks = list7;
        this.blockingMode = num2;
        this.emojiId = num3;
        this.blockAdultContent = bool5;
        this.inAppPurchaseForbidden = bool6;
        this.blockUnsupportedBrowsers = bool7;
        this.selectedCategories = i5;
    }

    public final boolean a() {
        return this.active;
    }

    public final Boolean b() {
        return this.addNewApplications;
    }

    public final List c() {
        return this.appUsageLimits;
    }

    public final Boolean d() {
        return this.blockAdultContent;
    }

    public final Boolean e() {
        return this.blockApplications;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDTO)) {
            return false;
        }
        ProfileDTO profileDTO = (ProfileDTO) obj;
        return Intrinsics.areEqual(this.title, profileDTO.title) && this.active == profileDTO.active && Intrinsics.areEqual(this.addNewApplications, profileDTO.addNewApplications) && Intrinsics.areEqual(this.dayFlags, profileDTO.dayFlags) && Intrinsics.areEqual(this.blockNotifications, profileDTO.blockNotifications) && Intrinsics.areEqual(this.blockApplications, profileDTO.blockApplications) && Intrinsics.areEqual(this.blockWebsites, profileDTO.blockWebsites) && this.typeCombinations == profileDTO.typeCombinations && this.operator == profileDTO.operator && Intrinsics.areEqual(this.appUsageLimits, profileDTO.appUsageLimits) && Intrinsics.areEqual(this.geoAddresses, profileDTO.geoAddresses) && Intrinsics.areEqual(this.profileApplications, profileDTO.profileApplications) && Intrinsics.areEqual(this.profileSubApplications, profileDTO.profileSubApplications) && Intrinsics.areEqual(this.profileIntervals, profileDTO.profileIntervals) && Intrinsics.areEqual(this.profileWebsites, profileDTO.profileWebsites) && Intrinsics.areEqual(this.profileWifiNetworks, profileDTO.profileWifiNetworks) && Intrinsics.areEqual(this.blockingMode, profileDTO.blockingMode) && Intrinsics.areEqual(this.emojiId, profileDTO.emojiId) && Intrinsics.areEqual(this.blockAdultContent, profileDTO.blockAdultContent) && Intrinsics.areEqual(this.inAppPurchaseForbidden, profileDTO.inAppPurchaseForbidden) && Intrinsics.areEqual(this.blockUnsupportedBrowsers, profileDTO.blockUnsupportedBrowsers) && this.selectedCategories == profileDTO.selectedCategories;
    }

    public final Boolean f() {
        return this.blockNotifications;
    }

    public final Boolean g() {
        return this.blockUnsupportedBrowsers;
    }

    public final Integer h() {
        return this.blockingMode;
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + Boolean.hashCode(this.active)) * 31;
        Boolean bool = this.addNewApplications;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.dayFlags;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool2 = this.blockNotifications;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.blockApplications;
        int iHashCode5 = (iHashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.blockWebsites;
        int iHashCode6 = (((((iHashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31) + Integer.hashCode(this.typeCombinations)) * 31) + Integer.hashCode(this.operator)) * 31;
        List<AppUsageLimitDTO> list = this.appUsageLimits;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<GeoAddressDTO> list2 = this.geoAddresses;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ProfileApplicationDTO> list3 = this.profileApplications;
        int iHashCode9 = (iHashCode8 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<ProfileSubApplicationDTO> list4 = this.profileSubApplications;
        int iHashCode10 = (iHashCode9 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<ProfileIntervalDTO> list5 = this.profileIntervals;
        int iHashCode11 = (iHashCode10 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<ProfileWebsiteDTO> list6 = this.profileWebsites;
        int iHashCode12 = (iHashCode11 + (list6 == null ? 0 : list6.hashCode())) * 31;
        List<ProfileWifiNetworkDTO> list7 = this.profileWifiNetworks;
        int iHashCode13 = (iHashCode12 + (list7 == null ? 0 : list7.hashCode())) * 31;
        Integer num2 = this.blockingMode;
        int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.emojiId;
        int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool5 = this.blockAdultContent;
        int iHashCode16 = (iHashCode15 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.inAppPurchaseForbidden;
        int iHashCode17 = (iHashCode16 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.blockUnsupportedBrowsers;
        return ((iHashCode17 + (bool7 != null ? bool7.hashCode() : 0)) * 31) + Integer.hashCode(this.selectedCategories);
    }

    public final Integer i() {
        return this.dayFlags;
    }

    public final Integer j() {
        return this.emojiId;
    }

    public final List k() {
        return this.geoAddresses;
    }

    public final Boolean l() {
        return this.inAppPurchaseForbidden;
    }

    public final int m() {
        return this.operator;
    }

    public final List n() {
        return this.profileApplications;
    }

    public final List o() {
        return this.profileIntervals;
    }

    public final List p() {
        return this.profileSubApplications;
    }

    public final List q() {
        return this.profileWebsites;
    }

    public final List r() {
        return this.profileWifiNetworks;
    }

    public final int s() {
        return this.selectedCategories;
    }

    public final String t() {
        return this.title;
    }

    public String toString() {
        return "ProfileDTO(title=" + this.title + ", active=" + this.active + ", addNewApplications=" + this.addNewApplications + ", dayFlags=" + this.dayFlags + ", blockNotifications=" + this.blockNotifications + ", blockApplications=" + this.blockApplications + ", blockWebsites=" + this.blockWebsites + ", typeCombinations=" + this.typeCombinations + ", operator=" + this.operator + ", appUsageLimits=" + this.appUsageLimits + ", geoAddresses=" + this.geoAddresses + ", profileApplications=" + this.profileApplications + ", profileSubApplications=" + this.profileSubApplications + ", profileIntervals=" + this.profileIntervals + ", profileWebsites=" + this.profileWebsites + ", profileWifiNetworks=" + this.profileWifiNetworks + ", blockingMode=" + this.blockingMode + ", emojiId=" + this.emojiId + ", blockAdultContent=" + this.blockAdultContent + ", inAppPurchaseForbidden=" + this.inAppPurchaseForbidden + ", blockUnsupportedBrowsers=" + this.blockUnsupportedBrowsers + ", selectedCategories=" + this.selectedCategories + ")";
    }

    public final int u() {
        return this.typeCombinations;
    }
}
