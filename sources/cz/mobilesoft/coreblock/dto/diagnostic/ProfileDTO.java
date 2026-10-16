package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.dto.diagnostic.ProfileApplicationDTO;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ProfileDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96970a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f96971b = 8;

    @SerializedName("addNewApplications")
    private final boolean addNewApplications;

    @SerializedName("blockAdultContent")
    private final boolean blockAdultContent;

    @SerializedName("blockInAppPurchases")
    private final boolean blockInAppPurchases;

    @SerializedName("blockLaunch")
    private final boolean blockLaunch;

    @SerializedName("blockNotifications")
    private final boolean blockNotifications;

    @SerializedName("blockUnsupportedBrowsers")
    private final boolean blockUnsupportedBrowsers;

    @SerializedName("blockingMode")
    private final int blockingMode;

    @SerializedName("blockingModeName")
    private final String blockingModeName;

    @SerializedName("dayFlags")
    private final int dayFlags;

    @SerializedName("days")
    private final List<String> days;

    @SerializedName("emojiId")
    private final int emojiId;

    @SerializedName("geoAddresses")
    private final List<GeoAddressDTO> geoAddresses;

    @SerializedName("id")
    private final long id;

    @SerializedName("isAllDay")
    private final boolean isAllDay;

    @SerializedName("isCurrentlyOn")
    private final boolean isCurrentlyOn;

    @SerializedName("lockedUntil")
    private final Long lockedUntil;

    @SerializedName("lockedUntilReadable")
    private final String lockedUntilReadable;

    @SerializedName("onConditions")
    private final int onConditions;

    @SerializedName("onConditionsNames")
    private final List<String> onConditionsNames;

    @SerializedName("onUntil")
    private final Long onUntil;

    @SerializedName("onUntilReadable")
    private final String onUntilReadable;

    @SerializedName("operator")
    private final int operator;

    @SerializedName("operatorName")
    private final String operatorName;

    @SerializedName("pausedUntil")
    private final long pausedUntil;

    @SerializedName("pausedUntilReadable")
    private final String pausedUntilReadable;

    @SerializedName("profileApplications")
    private final List<ProfileApplicationDTO> profileApplications;

    @SerializedName("profileIntervals")
    private final List<ProfileIntervalDTO> profileIntervals;

    @SerializedName("profileWebsites")
    private final List<ProfileWebsiteDTO> profileWebsites;

    @SerializedName("profileWifiNetworks")
    private final List<ProfileWifiNetworkDTO> profileWifiNetworks;

    @SerializedName("title")
    private final String title;

    @SerializedName("typeCombinations")
    private final int typeCombinations;

    @SerializedName("typeCombinationsNames")
    private final List<String> typoCombinationsNames;

    @SerializedName("usageLimits")
    private final List<UsageLimitDTO> usageLimits;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileDTO a(ProfileWithConfiguration profileWithConfiguration, Map applicationNames) {
            Intrinsics.checkNotNullParameter(profileWithConfiguration, "profileWithConfiguration");
            Intrinsics.checkNotNullParameter(applicationNames, "applicationNames");
            Profile profileP = profileWithConfiguration.p();
            Long lValueOf = Long.valueOf(profileP.u());
            long jLongValue = lValueOf.longValue();
            Long l3 = (jLongValue == 0 || jLongValue <= TimeHelperExt.f128663a.f()) ? null : lValueOf;
            Long lValueOf2 = Long.valueOf(profileP.w());
            long jLongValue2 = lValueOf2.longValue();
            Long l4 = (jLongValue2 == 0 || jLongValue2 <= TimeHelperExt.f128663a.f()) ? null : lValueOf2;
            Profile.PausedUntil pausedUntilY = profileP.y();
            Interval intervalR = ProfileHelper.f129250a.r(profileP, profileWithConfiguration.l());
            long jR = profileP.r();
            String strA = profileP.A();
            int id = profileP.q().getId();
            int id2 = profileP.o().getId();
            String lowerCase = profileP.o().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            long jA = pausedUntilY.a();
            String strO = pausedUntilY instanceof Profile.PausedUntil.Time ? DateHelperExtKt.o(((Profile.PausedUntil.Time) pausedUntilY).b()) : pausedUntilY.toString();
            String strO2 = l3 != null ? DateHelperExtKt.o(l3.longValue()) : null;
            int iP = profileP.p();
            List listJ = DayFlags.Companion.j(profileP.p());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ, 10));
            Iterator it = listJ.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((DayFlags) it.next()).name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                arrayList.add(lowerCase2);
            }
            boolean zM = profileP.m();
            boolean zL = profileP.l();
            boolean zI = profileP.i();
            boolean zJ = profileP.j();
            boolean zK = profileP.k();
            int iE = profileP.E();
            List listB = ProfileType.Companion.b(profileP.E());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
            Iterator it2 = listB.iterator();
            while (it2.hasNext()) {
                String lowerCase3 = ((ProfileType) it2.next()).name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                arrayList2.add(lowerCase3);
            }
            int iV = profileP.v();
            List listB2 = ProfileType.Companion.b(profileP.v());
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB2, 10));
            Iterator it3 = listB2.iterator();
            while (it3.hasNext()) {
                String lowerCase4 = ((ProfileType) it3.next()).name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                arrayList3.add(lowerCase4);
            }
            ArrayList arrayList4 = !arrayList3.isEmpty() ? arrayList3 : null;
            String strO3 = l4 != null ? DateHelperExtKt.o(l4.longValue()) : null;
            int iX = profileP.x();
            String str = profileP.x() == 0 ? "intersect" : "union";
            List listR = profileWithConfiguration.r();
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listR, 10));
            Iterator it4 = listR.iterator();
            while (it4.hasNext()) {
                arrayList5.add(UsageLimitDTO.f96977a.a((UsageLimit) it4.next()));
            }
            ArrayList arrayList6 = !arrayList5.isEmpty() ? arrayList5 : null;
            List listK = profileWithConfiguration.k();
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listK, 10));
            Iterator it5 = listK.iterator();
            while (it5.hasNext()) {
                arrayList7.add(new GeoAddressDTO((GeoAddress) it5.next(), false));
            }
            ArrayList arrayList8 = !arrayList7.isEmpty() ? arrayList7 : null;
            List<ApplicationProfileRelation> listG = profileWithConfiguration.g();
            ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listG, 10));
            for (ApplicationProfileRelation applicationProfileRelation : listG) {
                ProfileApplicationDTO.Companion companion = ProfileApplicationDTO.f96968a;
                String str2 = (String) applicationNames.get(applicationProfileRelation.d());
                if (str2 == null) {
                    str2 = "not found";
                }
                arrayList9.add(companion.a(applicationProfileRelation, str2));
            }
            ArrayList arrayList10 = !arrayList9.isEmpty() ? arrayList9 : null;
            List listL = profileWithConfiguration.l();
            ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listL, 10));
            Iterator it6 = listL.iterator();
            while (it6.hasNext()) {
                arrayList11.add(ProfileIntervalDTO.f96972a.a((Interval) it6.next()));
            }
            ArrayList arrayList12 = !arrayList11.isEmpty() ? arrayList11 : null;
            List listS = profileWithConfiguration.s();
            ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listS, 10));
            Iterator it7 = listS.iterator();
            while (it7.hasNext()) {
                arrayList13.add(ProfileWebsiteDTO.f96973a.a((WebsiteProfileRelation) it7.next()));
            }
            ArrayList arrayList14 = !arrayList13.isEmpty() ? arrayList13 : null;
            List listT = profileWithConfiguration.t();
            ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listT, 10));
            Iterator it8 = listT.iterator();
            while (it8.hasNext()) {
                arrayList15.add(ProfileWifiNetworkDTO.f96974a.a((WifiNetwork) it8.next()));
            }
            return new ProfileDTO(jR, strA, id, id2, lowerCase, jA, strO, l3, strO2, iP, arrayList, zM, zL, zI, zJ, zK, iE, arrayList2, iV, arrayList4, l4, strO3, iX, str, arrayList6, arrayList8, arrayList10, arrayList12, arrayList14, !arrayList15.isEmpty() ? arrayList15 : null, ProfileHelper.f129250a.B(profileP, profileWithConfiguration.l(), intervalR), intervalR != null && IntervalsHelperKt.k(intervalR), profileP.n());
        }

        private Companion() {
        }
    }

    public ProfileDTO(long j3, String title, int i3, int i4, String blockingModeName, long j4, String pausedUntilReadable, Long l3, String str, int i5, List days, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i6, List list, int i7, List list2, Long l4, String str2, int i8, String operatorName, List list3, List list4, List list5, List list6, List list7, List list8, boolean z7, boolean z8, boolean z9) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blockingModeName, "blockingModeName");
        Intrinsics.checkNotNullParameter(pausedUntilReadable, "pausedUntilReadable");
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(list, vgWWUoTKYyuC.igQ);
        Intrinsics.checkNotNullParameter(operatorName, "operatorName");
        this.id = j3;
        this.title = title;
        this.emojiId = i3;
        this.blockingMode = i4;
        this.blockingModeName = blockingModeName;
        this.pausedUntil = j4;
        this.pausedUntilReadable = pausedUntilReadable;
        this.lockedUntil = l3;
        this.lockedUntilReadable = str;
        this.dayFlags = i5;
        this.days = days;
        this.blockNotifications = z2;
        this.blockLaunch = z3;
        this.addNewApplications = z4;
        this.blockAdultContent = z5;
        this.blockInAppPurchases = z6;
        this.typeCombinations = i6;
        this.typoCombinationsNames = list;
        this.onConditions = i7;
        this.onConditionsNames = list2;
        this.onUntil = l4;
        this.onUntilReadable = str2;
        this.operator = i8;
        this.operatorName = operatorName;
        this.usageLimits = list3;
        this.geoAddresses = list4;
        this.profileApplications = list5;
        this.profileIntervals = list6;
        this.profileWebsites = list7;
        this.profileWifiNetworks = list8;
        this.isCurrentlyOn = z7;
        this.isAllDay = z8;
        this.blockUnsupportedBrowsers = z9;
    }

    public final boolean A() {
        return this.isAllDay;
    }

    public final boolean B() {
        return this.isCurrentlyOn;
    }

    public final boolean C() {
        return this.typeCombinations == 64;
    }

    public final boolean a() {
        return this.addNewApplications;
    }

    public final boolean b() {
        return this.blockAdultContent;
    }

    public final boolean c() {
        return this.blockInAppPurchases;
    }

    public final boolean d() {
        return this.blockLaunch;
    }

    public final boolean e() {
        return this.blockNotifications;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDTO)) {
            return false;
        }
        ProfileDTO profileDTO = (ProfileDTO) obj;
        return this.id == profileDTO.id && Intrinsics.areEqual(this.title, profileDTO.title) && this.emojiId == profileDTO.emojiId && this.blockingMode == profileDTO.blockingMode && Intrinsics.areEqual(this.blockingModeName, profileDTO.blockingModeName) && this.pausedUntil == profileDTO.pausedUntil && Intrinsics.areEqual(this.pausedUntilReadable, profileDTO.pausedUntilReadable) && Intrinsics.areEqual(this.lockedUntil, profileDTO.lockedUntil) && Intrinsics.areEqual(this.lockedUntilReadable, profileDTO.lockedUntilReadable) && this.dayFlags == profileDTO.dayFlags && Intrinsics.areEqual(this.days, profileDTO.days) && this.blockNotifications == profileDTO.blockNotifications && this.blockLaunch == profileDTO.blockLaunch && this.addNewApplications == profileDTO.addNewApplications && this.blockAdultContent == profileDTO.blockAdultContent && this.blockInAppPurchases == profileDTO.blockInAppPurchases && this.typeCombinations == profileDTO.typeCombinations && Intrinsics.areEqual(this.typoCombinationsNames, profileDTO.typoCombinationsNames) && this.onConditions == profileDTO.onConditions && Intrinsics.areEqual(this.onConditionsNames, profileDTO.onConditionsNames) && Intrinsics.areEqual(this.onUntil, profileDTO.onUntil) && Intrinsics.areEqual(this.onUntilReadable, profileDTO.onUntilReadable) && this.operator == profileDTO.operator && Intrinsics.areEqual(this.operatorName, profileDTO.operatorName) && Intrinsics.areEqual(this.usageLimits, profileDTO.usageLimits) && Intrinsics.areEqual(this.geoAddresses, profileDTO.geoAddresses) && Intrinsics.areEqual(this.profileApplications, profileDTO.profileApplications) && Intrinsics.areEqual(this.profileIntervals, profileDTO.profileIntervals) && Intrinsics.areEqual(this.profileWebsites, profileDTO.profileWebsites) && Intrinsics.areEqual(this.profileWifiNetworks, profileDTO.profileWifiNetworks) && this.isCurrentlyOn == profileDTO.isCurrentlyOn && this.isAllDay == profileDTO.isAllDay && this.blockUnsupportedBrowsers == profileDTO.blockUnsupportedBrowsers;
    }

    public final boolean f() {
        return this.blockUnsupportedBrowsers;
    }

    public final int g() {
        return this.blockingMode;
    }

    public final String h() {
        return this.blockingModeName;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.emojiId)) * 31) + Integer.hashCode(this.blockingMode)) * 31) + this.blockingModeName.hashCode()) * 31) + Long.hashCode(this.pausedUntil)) * 31) + this.pausedUntilReadable.hashCode()) * 31;
        Long l3 = this.lockedUntil;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str = this.lockedUntilReadable;
        int iHashCode3 = (((((((((((((((((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.dayFlags)) * 31) + this.days.hashCode()) * 31) + Boolean.hashCode(this.blockNotifications)) * 31) + Boolean.hashCode(this.blockLaunch)) * 31) + Boolean.hashCode(this.addNewApplications)) * 31) + Boolean.hashCode(this.blockAdultContent)) * 31) + Boolean.hashCode(this.blockInAppPurchases)) * 31) + Integer.hashCode(this.typeCombinations)) * 31) + this.typoCombinationsNames.hashCode()) * 31) + Integer.hashCode(this.onConditions)) * 31;
        List<String> list = this.onConditionsNames;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Long l4 = this.onUntil;
        int iHashCode5 = (iHashCode4 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str2 = this.onUntilReadable;
        int iHashCode6 = (((((iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.operator)) * 31) + this.operatorName.hashCode()) * 31;
        List<UsageLimitDTO> list2 = this.usageLimits;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<GeoAddressDTO> list3 = this.geoAddresses;
        int iHashCode8 = (iHashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<ProfileApplicationDTO> list4 = this.profileApplications;
        int iHashCode9 = (iHashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<ProfileIntervalDTO> list5 = this.profileIntervals;
        int iHashCode10 = (iHashCode9 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<ProfileWebsiteDTO> list6 = this.profileWebsites;
        int iHashCode11 = (iHashCode10 + (list6 == null ? 0 : list6.hashCode())) * 31;
        List<ProfileWifiNetworkDTO> list7 = this.profileWifiNetworks;
        return ((((((iHashCode11 + (list7 != null ? list7.hashCode() : 0)) * 31) + Boolean.hashCode(this.isCurrentlyOn)) * 31) + Boolean.hashCode(this.isAllDay)) * 31) + Boolean.hashCode(this.blockUnsupportedBrowsers);
    }

    public final int i() {
        return this.dayFlags;
    }

    public final List j() {
        return this.days;
    }

    public final int k() {
        return this.emojiId;
    }

    public final List l() {
        return this.geoAddresses;
    }

    public final long m() {
        return this.id;
    }

    public final Long n() {
        return this.lockedUntil;
    }

    public final int o() {
        return this.onConditions;
    }

    public final List p() {
        return this.onConditionsNames;
    }

    public final Long q() {
        return this.onUntil;
    }

    public final int r() {
        return this.operator;
    }

    public final long s() {
        return this.pausedUntil;
    }

    public final List t() {
        return this.profileApplications;
    }

    public String toString() {
        return "ProfileDTO(id=" + this.id + ", title=" + this.title + ", emojiId=" + this.emojiId + ", blockingMode=" + this.blockingMode + ", blockingModeName=" + this.blockingModeName + ", pausedUntil=" + this.pausedUntil + ", pausedUntilReadable=" + this.pausedUntilReadable + ", lockedUntil=" + this.lockedUntil + ", lockedUntilReadable=" + this.lockedUntilReadable + ", dayFlags=" + this.dayFlags + ", days=" + this.days + ", blockNotifications=" + this.blockNotifications + ", blockLaunch=" + this.blockLaunch + ", addNewApplications=" + this.addNewApplications + ", blockAdultContent=" + this.blockAdultContent + ", blockInAppPurchases=" + this.blockInAppPurchases + ", typeCombinations=" + this.typeCombinations + ", typoCombinationsNames=" + this.typoCombinationsNames + ", onConditions=" + this.onConditions + ", onConditionsNames=" + this.onConditionsNames + ", onUntil=" + this.onUntil + ", onUntilReadable=" + this.onUntilReadable + ", operator=" + this.operator + ", operatorName=" + this.operatorName + ", usageLimits=" + this.usageLimits + ", geoAddresses=" + this.geoAddresses + ", profileApplications=" + this.profileApplications + ", profileIntervals=" + this.profileIntervals + ", profileWebsites=" + this.profileWebsites + ", profileWifiNetworks=" + this.profileWifiNetworks + ", isCurrentlyOn=" + this.isCurrentlyOn + ", isAllDay=" + this.isAllDay + ", blockUnsupportedBrowsers=" + this.blockUnsupportedBrowsers + ")";
    }

    public final List u() {
        return this.profileIntervals;
    }

    public final List v() {
        return this.profileWebsites;
    }

    public final List w() {
        return this.profileWifiNetworks;
    }

    public final String x() {
        return this.title;
    }

    public final int y() {
        return this.typeCombinations;
    }

    public final List z() {
        return this.usageLimits;
    }
}
