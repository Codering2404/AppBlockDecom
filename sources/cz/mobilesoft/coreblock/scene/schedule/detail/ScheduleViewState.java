package cz.mobilesoft.coreblock.scene.schedule.detail;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.util.AdultContentDownloadWorker;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ScheduleViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DetailViewState f116584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdultContentDownloadWorker.AdultContentSyncState f116585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f116586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DetailBottomSheetType f116587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f116588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f116589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f116590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f116591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImmutableList f116592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f116593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final GraphData f116594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ProfileWithConfiguration f116595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f116596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f116597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MainCardSummaryData f116598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ScheduleDescriptor f116599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final PremiumState f116600r;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DetailBottomSheetType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DetailBottomSheetType[] $VALUES;
        public static final DetailBottomSheetType AdultContentBottomSheet = new DetailBottomSheetType("AdultContentBottomSheet", 0);
        public static final DetailBottomSheetType CopyBlockingBottomSheet = new DetailBottomSheetType("CopyBlockingBottomSheet", 1);

        private static final /* synthetic */ DetailBottomSheetType[] $values() {
            return new DetailBottomSheetType[]{AdultContentBottomSheet, CopyBlockingBottomSheet};
        }

        static {
            DetailBottomSheetType[] detailBottomSheetTypeArr$values = $values();
            $VALUES = detailBottomSheetTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(detailBottomSheetTypeArr$values);
        }

        private DetailBottomSheetType(String str, int i3) {
        }

        public static EnumEntries<DetailBottomSheetType> getEntries() {
            return $ENTRIES;
        }

        public static DetailBottomSheetType valueOf(String str) {
            return (DetailBottomSheetType) Enum.valueOf(DetailBottomSheetType.class, str);
        }

        public static DetailBottomSheetType[] values() {
            return (DetailBottomSheetType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MainCardSummaryData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f116635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f116636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f116637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f116638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f116639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableList f116640f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f116641g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f116642h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Integer f116643i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f116644j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f116645k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Long f116646l;

        public MainCardSummaryData(String title, String subtitle, List labels, int i3, Integer num, ImmutableList immutableList, String str, String chipDescription, Integer num2, String estimatedTimeString, boolean z2, Long l3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(labels, "labels");
            Intrinsics.checkNotNullParameter(chipDescription, "chipDescription");
            Intrinsics.checkNotNullParameter(estimatedTimeString, "estimatedTimeString");
            this.f116635a = title;
            this.f116636b = subtitle;
            this.f116637c = labels;
            this.f116638d = i3;
            this.f116639e = num;
            this.f116640f = immutableList;
            this.f116641g = str;
            this.f116642h = chipDescription;
            this.f116643i = num2;
            this.f116644j = estimatedTimeString;
            this.f116645k = z2;
            this.f116646l = l3;
        }

        public static /* synthetic */ MainCardSummaryData b(MainCardSummaryData mainCardSummaryData, String str, String str2, List list, int i3, Integer num, ImmutableList immutableList, String str3, String str4, Integer num2, String str5, boolean z2, Long l3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = mainCardSummaryData.f116635a;
            }
            if ((i4 & 2) != 0) {
                str2 = mainCardSummaryData.f116636b;
            }
            if ((i4 & 4) != 0) {
                list = mainCardSummaryData.f116637c;
            }
            if ((i4 & 8) != 0) {
                i3 = mainCardSummaryData.f116638d;
            }
            if ((i4 & 16) != 0) {
                num = mainCardSummaryData.f116639e;
            }
            if ((i4 & 32) != 0) {
                immutableList = mainCardSummaryData.f116640f;
            }
            if ((i4 & 64) != 0) {
                str3 = mainCardSummaryData.f116641g;
            }
            if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                str4 = mainCardSummaryData.f116642h;
            }
            if ((i4 & Function.MAX_NARGS) != 0) {
                num2 = mainCardSummaryData.f116643i;
            }
            if ((i4 & 512) != 0) {
                str5 = mainCardSummaryData.f116644j;
            }
            if ((i4 & 1024) != 0) {
                z2 = mainCardSummaryData.f116645k;
            }
            if ((i4 & 2048) != 0) {
                l3 = mainCardSummaryData.f116646l;
            }
            boolean z3 = z2;
            Long l4 = l3;
            Integer num3 = num2;
            String str6 = str5;
            String str7 = str3;
            String str8 = str4;
            Integer num4 = num;
            ImmutableList immutableList2 = immutableList;
            return mainCardSummaryData.a(str, str2, list, i3, num4, immutableList2, str7, str8, num3, str6, z3, l4);
        }

        public final MainCardSummaryData a(String title, String subtitle, List labels, int i3, Integer num, ImmutableList immutableList, String str, String chipDescription, Integer num2, String estimatedTimeString, boolean z2, Long l3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(labels, "labels");
            Intrinsics.checkNotNullParameter(chipDescription, "chipDescription");
            Intrinsics.checkNotNullParameter(estimatedTimeString, "estimatedTimeString");
            return new MainCardSummaryData(title, subtitle, labels, i3, num, immutableList, str, chipDescription, num2, estimatedTimeString, z2, l3);
        }

        public final Integer c() {
            return this.f116639e;
        }

        public final String d() {
            return this.f116642h;
        }

        public final Integer e() {
            return this.f116643i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MainCardSummaryData)) {
                return false;
            }
            MainCardSummaryData mainCardSummaryData = (MainCardSummaryData) obj;
            return Intrinsics.areEqual(this.f116635a, mainCardSummaryData.f116635a) && Intrinsics.areEqual(this.f116636b, mainCardSummaryData.f116636b) && Intrinsics.areEqual(this.f116637c, mainCardSummaryData.f116637c) && this.f116638d == mainCardSummaryData.f116638d && Intrinsics.areEqual(this.f116639e, mainCardSummaryData.f116639e) && Intrinsics.areEqual(this.f116640f, mainCardSummaryData.f116640f) && Intrinsics.areEqual(this.f116641g, mainCardSummaryData.f116641g) && Intrinsics.areEqual(this.f116642h, mainCardSummaryData.f116642h) && Intrinsics.areEqual(this.f116643i, mainCardSummaryData.f116643i) && Intrinsics.areEqual(this.f116644j, mainCardSummaryData.f116644j) && this.f116645k == mainCardSummaryData.f116645k && Intrinsics.areEqual(this.f116646l, mainCardSummaryData.f116646l);
        }

        public final String f() {
            return this.f116644j;
        }

        public final ImmutableList g() {
            return this.f116640f;
        }

        public final List h() {
            return this.f116637c;
        }

        public int hashCode() {
            int iHashCode = ((((((this.f116635a.hashCode() * 31) + this.f116636b.hashCode()) * 31) + this.f116637c.hashCode()) * 31) + Integer.hashCode(this.f116638d)) * 31;
            Integer num = this.f116639e;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            ImmutableList immutableList = this.f116640f;
            int iHashCode3 = (iHashCode2 + (immutableList == null ? 0 : immutableList.hashCode())) * 31;
            String str = this.f116641g;
            int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.f116642h.hashCode()) * 31;
            Integer num2 = this.f116643i;
            int iHashCode5 = (((((iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.f116644j.hashCode()) * 31) + Boolean.hashCode(this.f116645k)) * 31;
            Long l3 = this.f116646l;
            return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
        }

        public final Long i() {
            return this.f116646l;
        }

        public final int j() {
            return this.f116638d;
        }

        public final String k() {
            return this.f116636b;
        }

        public final String l() {
            return this.f116641g;
        }

        public final String m() {
            return this.f116635a;
        }

        public final boolean n() {
            return this.f116645k;
        }

        public String toString() {
            return "MainCardSummaryData(title=" + this.f116635a + ", subtitle=" + this.f116636b + ", labels=" + this.f116637c + ", sessionsCount=" + this.f116638d + ", activeIndex=" + this.f116639e + ", intervals=" + this.f116640f + ", timeDescription=" + this.f116641g + ", chipDescription=" + this.f116642h + ", chipIconResId=" + this.f116643i + ", estimatedTimeString=" + this.f116644j + ", isCombineProfile=" + this.f116645k + ", nextIntervalStartInMinutes=" + this.f116646l + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProfileToCopy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f116647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProfileWithConfiguration f116648b;

        public ProfileToCopy(ImmutableList packageNames, ProfileWithConfiguration profileWithConfiguration) {
            Intrinsics.checkNotNullParameter(packageNames, "packageNames");
            Intrinsics.checkNotNullParameter(profileWithConfiguration, "profileWithConfiguration");
            this.f116647a = packageNames;
            this.f116648b = profileWithConfiguration;
        }

        public final ImmutableList a() {
            return this.f116647a;
        }

        public final ProfileWithConfiguration b() {
            return this.f116648b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProfileToCopy)) {
                return false;
            }
            ProfileToCopy profileToCopy = (ProfileToCopy) obj;
            return Intrinsics.areEqual(this.f116647a, profileToCopy.f116647a) && Intrinsics.areEqual(this.f116648b, profileToCopy.f116648b);
        }

        public int hashCode() {
            return (this.f116647a.hashCode() * 31) + this.f116648b.hashCode();
        }

        public String toString() {
            return "ProfileToCopy(packageNames=" + this.f116647a + ", profileWithConfiguration=" + this.f116648b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116649a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileType.BLUETOOTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProfileType.COMBINED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProfileType.STRICT_MODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProfileType.QUICK_BLOCK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f116649a = iArr;
        }
    }

    public ScheduleViewState(DetailViewState detail, AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState, boolean z2, DetailBottomSheetType bottomSheetType, boolean z3, boolean z4, boolean z5, boolean z6, ImmutableList otherProfiles, List conflictingSchedules, GraphData graphData, ProfileWithConfiguration profileWithConfiguration, List aggregatedAppDataForSummary, boolean z7, MainCardSummaryData mainCardSummaryData, ScheduleDescriptor scheduleDescriptor, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(adultContentSyncState, "adultContentSyncState");
        Intrinsics.checkNotNullParameter(bottomSheetType, "bottomSheetType");
        Intrinsics.checkNotNullParameter(otherProfiles, "otherProfiles");
        Intrinsics.checkNotNullParameter(conflictingSchedules, "conflictingSchedules");
        Intrinsics.checkNotNullParameter(aggregatedAppDataForSummary, "aggregatedAppDataForSummary");
        Intrinsics.checkNotNullParameter(scheduleDescriptor, "scheduleDescriptor");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f116584a = detail;
        this.f116585b = adultContentSyncState;
        this.f116586c = z2;
        this.f116587d = bottomSheetType;
        this.f116588f = z3;
        this.f116589g = z4;
        this.f116590h = z5;
        this.f116591i = z6;
        this.f116592j = otherProfiles;
        this.f116593k = conflictingSchedules;
        this.f116594l = graphData;
        this.f116595m = profileWithConfiguration;
        this.f116596n = aggregatedAppDataForSummary;
        this.f116597o = z7;
        this.f116598p = mainCardSummaryData;
        this.f116599q = scheduleDescriptor;
        this.f116600r = premiumState;
    }

    public static /* synthetic */ ScheduleViewState b(ScheduleViewState scheduleViewState, DetailViewState detailViewState, AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState, boolean z2, DetailBottomSheetType detailBottomSheetType, boolean z3, boolean z4, boolean z5, boolean z6, ImmutableList immutableList, List list, GraphData graphData, ProfileWithConfiguration profileWithConfiguration, List list2, boolean z7, MainCardSummaryData mainCardSummaryData, ScheduleDescriptor scheduleDescriptor, PremiumState premiumState, int i3, Object obj) {
        PremiumState premiumState2;
        ScheduleDescriptor scheduleDescriptor2;
        DetailViewState detailViewState2;
        ScheduleViewState scheduleViewState2;
        MainCardSummaryData mainCardSummaryData2;
        AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState2;
        boolean z8;
        DetailBottomSheetType detailBottomSheetType2;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        ImmutableList immutableList2;
        List list3;
        GraphData graphData2;
        ProfileWithConfiguration profileWithConfiguration2;
        List list4;
        boolean z13;
        DetailViewState detailViewState3 = (i3 & 1) != 0 ? scheduleViewState.f116584a : detailViewState;
        AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState3 = (i3 & 2) != 0 ? scheduleViewState.f116585b : adultContentSyncState;
        boolean z14 = (i3 & 4) != 0 ? scheduleViewState.f116586c : z2;
        DetailBottomSheetType detailBottomSheetType3 = (i3 & 8) != 0 ? scheduleViewState.f116587d : detailBottomSheetType;
        boolean z15 = (i3 & 16) != 0 ? scheduleViewState.f116588f : z3;
        boolean z16 = (i3 & 32) != 0 ? scheduleViewState.f116589g : z4;
        boolean z17 = (i3 & 64) != 0 ? scheduleViewState.f116590h : z5;
        boolean z18 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? scheduleViewState.f116591i : z6;
        ImmutableList immutableList3 = (i3 & Function.MAX_NARGS) != 0 ? scheduleViewState.f116592j : immutableList;
        List list5 = (i3 & 512) != 0 ? scheduleViewState.f116593k : list;
        GraphData graphData3 = (i3 & 1024) != 0 ? scheduleViewState.f116594l : graphData;
        ProfileWithConfiguration profileWithConfiguration3 = (i3 & 2048) != 0 ? scheduleViewState.f116595m : profileWithConfiguration;
        List list6 = (i3 & 4096) != 0 ? scheduleViewState.f116596n : list2;
        boolean z19 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? scheduleViewState.f116597o : z7;
        DetailViewState detailViewState4 = detailViewState3;
        MainCardSummaryData mainCardSummaryData3 = (i3 & 16384) != 0 ? scheduleViewState.f116598p : mainCardSummaryData;
        ScheduleDescriptor scheduleDescriptor3 = (i3 & 32768) != 0 ? scheduleViewState.f116599q : scheduleDescriptor;
        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            scheduleDescriptor2 = scheduleDescriptor3;
            premiumState2 = scheduleViewState.f116600r;
            mainCardSummaryData2 = mainCardSummaryData3;
            adultContentSyncState2 = adultContentSyncState3;
            z8 = z14;
            detailBottomSheetType2 = detailBottomSheetType3;
            z9 = z15;
            z10 = z16;
            z11 = z17;
            z12 = z18;
            immutableList2 = immutableList3;
            list3 = list5;
            graphData2 = graphData3;
            profileWithConfiguration2 = profileWithConfiguration3;
            list4 = list6;
            z13 = z19;
            detailViewState2 = detailViewState4;
            scheduleViewState2 = scheduleViewState;
        } else {
            premiumState2 = premiumState;
            scheduleDescriptor2 = scheduleDescriptor3;
            detailViewState2 = detailViewState4;
            scheduleViewState2 = scheduleViewState;
            mainCardSummaryData2 = mainCardSummaryData3;
            adultContentSyncState2 = adultContentSyncState3;
            z8 = z14;
            detailBottomSheetType2 = detailBottomSheetType3;
            z9 = z15;
            z10 = z16;
            z11 = z17;
            z12 = z18;
            immutableList2 = immutableList3;
            list3 = list5;
            graphData2 = graphData3;
            profileWithConfiguration2 = profileWithConfiguration3;
            list4 = list6;
            z13 = z19;
        }
        return scheduleViewState2.a(detailViewState2, adultContentSyncState2, z8, detailBottomSheetType2, z9, z10, z11, z12, immutableList2, list3, graphData2, profileWithConfiguration2, list4, z13, mainCardSummaryData2, scheduleDescriptor2, premiumState2);
    }

    public final ScheduleViewState a(DetailViewState detail, AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState, boolean z2, DetailBottomSheetType bottomSheetType, boolean z3, boolean z4, boolean z5, boolean z6, ImmutableList otherProfiles, List conflictingSchedules, GraphData graphData, ProfileWithConfiguration profileWithConfiguration, List aggregatedAppDataForSummary, boolean z7, MainCardSummaryData mainCardSummaryData, ScheduleDescriptor scheduleDescriptor, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(adultContentSyncState, "adultContentSyncState");
        Intrinsics.checkNotNullParameter(bottomSheetType, "bottomSheetType");
        Intrinsics.checkNotNullParameter(otherProfiles, "otherProfiles");
        Intrinsics.checkNotNullParameter(conflictingSchedules, "conflictingSchedules");
        Intrinsics.checkNotNullParameter(aggregatedAppDataForSummary, "aggregatedAppDataForSummary");
        Intrinsics.checkNotNullParameter(scheduleDescriptor, "scheduleDescriptor");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return new ScheduleViewState(detail, adultContentSyncState, z2, bottomSheetType, z3, z4, z5, z6, otherProfiles, conflictingSchedules, graphData, profileWithConfiguration, aggregatedAppDataForSummary, z7, mainCardSummaryData, scheduleDescriptor, premiumState);
    }

    public final AdultContentDownloadWorker.AdultContentSyncState c() {
        return this.f116585b;
    }

    public final List d() {
        return this.f116596n;
    }

    public final DetailBottomSheetType e() {
        return this.f116587d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleViewState)) {
            return false;
        }
        ScheduleViewState scheduleViewState = (ScheduleViewState) obj;
        return Intrinsics.areEqual(this.f116584a, scheduleViewState.f116584a) && Intrinsics.areEqual(this.f116585b, scheduleViewState.f116585b) && this.f116586c == scheduleViewState.f116586c && this.f116587d == scheduleViewState.f116587d && this.f116588f == scheduleViewState.f116588f && this.f116589g == scheduleViewState.f116589g && this.f116590h == scheduleViewState.f116590h && this.f116591i == scheduleViewState.f116591i && Intrinsics.areEqual(this.f116592j, scheduleViewState.f116592j) && Intrinsics.areEqual(this.f116593k, scheduleViewState.f116593k) && Intrinsics.areEqual(this.f116594l, scheduleViewState.f116594l) && Intrinsics.areEqual(this.f116595m, scheduleViewState.f116595m) && Intrinsics.areEqual(this.f116596n, scheduleViewState.f116596n) && this.f116597o == scheduleViewState.f116597o && Intrinsics.areEqual(this.f116598p, scheduleViewState.f116598p) && Intrinsics.areEqual(this.f116599q, scheduleViewState.f116599q) && Intrinsics.areEqual(this.f116600r, scheduleViewState.f116600r);
    }

    public final List f() {
        return this.f116593k;
    }

    public final DetailViewState g() {
        return this.f116584a;
    }

    public final ProfileWithConfiguration h() {
        return this.f116595m;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.f116584a.hashCode() * 31) + this.f116585b.hashCode()) * 31) + Boolean.hashCode(this.f116586c)) * 31) + this.f116587d.hashCode()) * 31) + Boolean.hashCode(this.f116588f)) * 31) + Boolean.hashCode(this.f116589g)) * 31) + Boolean.hashCode(this.f116590h)) * 31) + Boolean.hashCode(this.f116591i)) * 31) + this.f116592j.hashCode()) * 31) + this.f116593k.hashCode()) * 31;
        GraphData graphData = this.f116594l;
        int iHashCode2 = (iHashCode + (graphData == null ? 0 : graphData.hashCode())) * 31;
        ProfileWithConfiguration profileWithConfiguration = this.f116595m;
        int iHashCode3 = (((((iHashCode2 + (profileWithConfiguration == null ? 0 : profileWithConfiguration.hashCode())) * 31) + this.f116596n.hashCode()) * 31) + Boolean.hashCode(this.f116597o)) * 31;
        MainCardSummaryData mainCardSummaryData = this.f116598p;
        return ((((iHashCode3 + (mainCardSummaryData != null ? mainCardSummaryData.hashCode() : 0)) * 31) + this.f116599q.hashCode()) * 31) + this.f116600r.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0172 A[LOOP:2: B:47:0x0170->B:48:0x0172, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a9 A[LOOP:3: B:50:0x01a3->B:52:0x01a9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5 A[LOOP:4: B:54:0x01df->B:56:0x01e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0225 A[LOOP:5: B:58:0x021f->B:60:0x0225, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO i(android.content.Context r49, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r50) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState.i(android.content.Context, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO):cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO");
    }

    public final ImmutableList j() {
        return this.f116592j;
    }

    public final GraphData k() {
        return this.f116594l;
    }

    public final PremiumState l() {
        return this.f116600r;
    }

    public final ScheduleDescriptor m() {
        return this.f116599q;
    }

    public final boolean n() {
        return this.f116589g;
    }

    public final boolean o() {
        return this.f116590h;
    }

    public final boolean p() {
        return this.f116591i;
    }

    public final boolean q() {
        return this.f116586c;
    }

    public final MainCardSummaryData r() {
        return this.f116598p;
    }

    public final boolean s() {
        return this.f116588f;
    }

    public String toString() {
        return "ScheduleViewState(detail=" + this.f116584a + ", adultContentSyncState=" + this.f116585b + ", showDetailBottomSheet=" + this.f116586c + ", bottomSheetType=" + this.f116587d + ", isAdultContentDownloaded=" + this.f116588f + ", showAllowCategoriesBottomSheet=" + this.f116589g + ", showCategoriesIcon=" + this.f116590h + ", showCategoryLoading=" + this.f116591i + ", otherProfiles=" + this.f116592j + ", conflictingSchedules=" + this.f116593k + ", peakGraphData=" + this.f116594l + ", newProfileWithConfiguration=" + this.f116595m + ", aggregatedAppDataForSummary=" + this.f116596n + ", summaryIsLiveActive=" + this.f116597o + ", summaryMainCardData=" + this.f116598p + ", scheduleDescriptor=" + this.f116599q + ", premiumState=" + this.f116600r + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DetailViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewModelState f116601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f116602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f116603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f116604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f116605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableList f116606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ImmutableList f116607g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Blocking f116608h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f116609i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final AppBlockingSettings f116610j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final MissingPermissions f116611k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final PremiumState f116612l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final ImmutableList f116613m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final boolean f116614n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final boolean f116615o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final Long f116616p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f116617q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f116618r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final boolean f116619s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final boolean f116620t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f116621u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final boolean f116622v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final boolean f116623w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final String f116624x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final ScheduleEmoji f116625y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final ImmutableList f116626z;

        public DetailViewState(ViewModelState state, String title, String str, boolean z2, boolean z3, ImmutableList conditions, ImmutableList disabledConditions, Blocking blocking, boolean z4, AppBlockingSettings appBlockingSettings, MissingPermissions missingPermissions, PremiumState premiumState, ImmutableList exceededLimits, boolean z5, boolean z6, Long l3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str2, ScheduleEmoji selectedEmoji, ImmutableList extraOptions) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            Intrinsics.checkNotNullParameter(disabledConditions, "disabledConditions");
            Intrinsics.checkNotNullParameter(blocking, "blocking");
            Intrinsics.checkNotNullParameter(appBlockingSettings, "appBlockingSettings");
            Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            Intrinsics.checkNotNullParameter(exceededLimits, "exceededLimits");
            Intrinsics.checkNotNullParameter(selectedEmoji, "selectedEmoji");
            Intrinsics.checkNotNullParameter(extraOptions, "extraOptions");
            this.f116601a = state;
            this.f116602b = title;
            this.f116603c = str;
            this.f116604d = z2;
            this.f116605e = z3;
            this.f116606f = conditions;
            this.f116607g = disabledConditions;
            this.f116608h = blocking;
            this.f116609i = z4;
            this.f116610j = appBlockingSettings;
            this.f116611k = missingPermissions;
            this.f116612l = premiumState;
            this.f116613m = exceededLimits;
            this.f116614n = z5;
            this.f116615o = z6;
            this.f116616p = l3;
            this.f116617q = z7;
            this.f116618r = z8;
            this.f116619s = z9;
            this.f116620t = z10;
            this.f116621u = z11;
            this.f116622v = z12;
            this.f116623w = z13;
            this.f116624x = str2;
            this.f116625y = selectedEmoji;
            this.f116626z = extraOptions;
        }

        public static /* synthetic */ DetailViewState b(DetailViewState detailViewState, ViewModelState viewModelState, String str, String str2, boolean z2, boolean z3, ImmutableList immutableList, ImmutableList immutableList2, Blocking blocking, boolean z4, AppBlockingSettings appBlockingSettings, MissingPermissions missingPermissions, PremiumState premiumState, ImmutableList immutableList3, boolean z5, boolean z6, Long l3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str3, ScheduleEmoji scheduleEmoji, ImmutableList immutableList4, int i3, Object obj) {
            ImmutableList immutableList5;
            ScheduleEmoji scheduleEmoji2;
            ViewModelState viewModelState2 = (i3 & 1) != 0 ? detailViewState.f116601a : viewModelState;
            String str4 = (i3 & 2) != 0 ? detailViewState.f116602b : str;
            String str5 = (i3 & 4) != 0 ? detailViewState.f116603c : str2;
            boolean z14 = (i3 & 8) != 0 ? detailViewState.f116604d : z2;
            boolean z15 = (i3 & 16) != 0 ? detailViewState.f116605e : z3;
            ImmutableList immutableList6 = (i3 & 32) != 0 ? detailViewState.f116606f : immutableList;
            ImmutableList immutableList7 = (i3 & 64) != 0 ? detailViewState.f116607g : immutableList2;
            Blocking blocking2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? detailViewState.f116608h : blocking;
            boolean z16 = (i3 & Function.MAX_NARGS) != 0 ? detailViewState.f116609i : z4;
            AppBlockingSettings appBlockingSettings2 = (i3 & 512) != 0 ? detailViewState.f116610j : appBlockingSettings;
            MissingPermissions missingPermissions2 = (i3 & 1024) != 0 ? detailViewState.f116611k : missingPermissions;
            PremiumState premiumState2 = (i3 & 2048) != 0 ? detailViewState.f116612l : premiumState;
            ImmutableList immutableList8 = (i3 & 4096) != 0 ? detailViewState.f116613m : immutableList3;
            boolean z17 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? detailViewState.f116614n : z5;
            ViewModelState viewModelState3 = viewModelState2;
            boolean z18 = (i3 & 16384) != 0 ? detailViewState.f116615o : z6;
            Long l4 = (i3 & 32768) != 0 ? detailViewState.f116616p : l3;
            boolean z19 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? detailViewState.f116617q : z7;
            boolean z20 = (i3 & 131072) != 0 ? detailViewState.f116618r : z8;
            boolean z21 = (i3 & 262144) != 0 ? detailViewState.f116619s : z9;
            boolean z22 = (i3 & 524288) != 0 ? detailViewState.f116620t : z10;
            boolean z23 = (i3 & 1048576) != 0 ? detailViewState.f116621u : z11;
            boolean z24 = (i3 & 2097152) != 0 ? detailViewState.f116622v : z12;
            boolean z25 = (i3 & 4194304) != 0 ? detailViewState.f116623w : z13;
            String str6 = (i3 & 8388608) != 0 ? detailViewState.f116624x : str3;
            ScheduleEmoji scheduleEmoji3 = (i3 & 16777216) != 0 ? detailViewState.f116625y : scheduleEmoji;
            if ((i3 & 33554432) != 0) {
                scheduleEmoji2 = scheduleEmoji3;
                immutableList5 = detailViewState.f116626z;
            } else {
                immutableList5 = immutableList4;
                scheduleEmoji2 = scheduleEmoji3;
            }
            return detailViewState.a(viewModelState3, str4, str5, z14, z15, immutableList6, immutableList7, blocking2, z16, appBlockingSettings2, missingPermissions2, premiumState2, immutableList8, z17, z18, l4, z19, z20, z21, z22, z23, z24, z25, str6, scheduleEmoji2, immutableList5);
        }

        public final boolean A() {
            ImmutableList immutableList = this.f116606f;
            if (immutableList != null && immutableList.isEmpty()) {
                return false;
            }
            Iterator<E> it = immutableList.iterator();
            while (it.hasNext()) {
                if (ProfileType.Companion.b(((Condition) it.next()).b().mask()).contains(ProfileType.USAGE_LIMIT)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean B() {
            return this.f116614n;
        }

        public final boolean C() {
            return this.f116619s;
        }

        public final boolean D() {
            return this.f116604d;
        }

        public final boolean E() {
            return this.f116605e;
        }

        public final boolean F() {
            return this.f116617q;
        }

        public final DetailViewState a(ViewModelState state, String title, String str, boolean z2, boolean z3, ImmutableList conditions, ImmutableList disabledConditions, Blocking blocking, boolean z4, AppBlockingSettings appBlockingSettings, MissingPermissions missingPermissions, PremiumState premiumState, ImmutableList exceededLimits, boolean z5, boolean z6, Long l3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str2, ScheduleEmoji selectedEmoji, ImmutableList extraOptions) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            Intrinsics.checkNotNullParameter(disabledConditions, "disabledConditions");
            Intrinsics.checkNotNullParameter(blocking, "blocking");
            Intrinsics.checkNotNullParameter(appBlockingSettings, "appBlockingSettings");
            Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            Intrinsics.checkNotNullParameter(exceededLimits, "exceededLimits");
            Intrinsics.checkNotNullParameter(selectedEmoji, "selectedEmoji");
            Intrinsics.checkNotNullParameter(extraOptions, "extraOptions");
            return new DetailViewState(state, title, str, z2, z3, conditions, disabledConditions, blocking, z4, appBlockingSettings, missingPermissions, premiumState, exceededLimits, z5, z6, l3, z7, z8, z9, z10, z11, z12, z13, str2, selectedEmoji, extraOptions);
        }

        public final AppBlockingSettings c() {
            return this.f116610j;
        }

        public final Blocking d() {
            return this.f116608h;
        }

        public final ImmutableList e() {
            return this.f116606f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DetailViewState)) {
                return false;
            }
            DetailViewState detailViewState = (DetailViewState) obj;
            return Intrinsics.areEqual(this.f116601a, detailViewState.f116601a) && Intrinsics.areEqual(this.f116602b, detailViewState.f116602b) && Intrinsics.areEqual(this.f116603c, detailViewState.f116603c) && this.f116604d == detailViewState.f116604d && this.f116605e == detailViewState.f116605e && Intrinsics.areEqual(this.f116606f, detailViewState.f116606f) && Intrinsics.areEqual(this.f116607g, detailViewState.f116607g) && Intrinsics.areEqual(this.f116608h, detailViewState.f116608h) && this.f116609i == detailViewState.f116609i && Intrinsics.areEqual(this.f116610j, detailViewState.f116610j) && Intrinsics.areEqual(this.f116611k, detailViewState.f116611k) && Intrinsics.areEqual(this.f116612l, detailViewState.f116612l) && Intrinsics.areEqual(this.f116613m, detailViewState.f116613m) && this.f116614n == detailViewState.f116614n && this.f116615o == detailViewState.f116615o && Intrinsics.areEqual(this.f116616p, detailViewState.f116616p) && this.f116617q == detailViewState.f116617q && this.f116618r == detailViewState.f116618r && this.f116619s == detailViewState.f116619s && this.f116620t == detailViewState.f116620t && this.f116621u == detailViewState.f116621u && this.f116622v == detailViewState.f116622v && this.f116623w == detailViewState.f116623w && Intrinsics.areEqual(this.f116624x, detailViewState.f116624x) && this.f116625y == detailViewState.f116625y && Intrinsics.areEqual(this.f116626z, detailViewState.f116626z);
        }

        public final ImmutableList f() {
            return this.f116607g;
        }

        public final ImmutableList g() {
            return this.f116613m;
        }

        public final ImmutableList h() {
            return this.f116626z;
        }

        public int hashCode() {
            int iHashCode = ((this.f116601a.hashCode() * 31) + this.f116602b.hashCode()) * 31;
            String str = this.f116603c;
            int iHashCode2 = (((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f116604d)) * 31) + Boolean.hashCode(this.f116605e)) * 31) + this.f116606f.hashCode()) * 31) + this.f116607g.hashCode()) * 31) + this.f116608h.hashCode()) * 31) + Boolean.hashCode(this.f116609i)) * 31) + this.f116610j.hashCode()) * 31) + this.f116611k.hashCode()) * 31) + this.f116612l.hashCode()) * 31) + this.f116613m.hashCode()) * 31) + Boolean.hashCode(this.f116614n)) * 31) + Boolean.hashCode(this.f116615o)) * 31;
            Long l3 = this.f116616p;
            int iHashCode3 = (((((((((((((((iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f116617q)) * 31) + Boolean.hashCode(this.f116618r)) * 31) + Boolean.hashCode(this.f116619s)) * 31) + Boolean.hashCode(this.f116620t)) * 31) + Boolean.hashCode(this.f116621u)) * 31) + Boolean.hashCode(this.f116622v)) * 31) + Boolean.hashCode(this.f116623w)) * 31;
            String str2 = this.f116624x;
            return ((((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f116625y.hashCode()) * 31) + this.f116626z.hashCode();
        }

        public final boolean i() {
            if (this.f116606f.size() != 2) {
                return false;
            }
            ImmutableList<Condition> immutableList = this.f116606f;
            if (immutableList != null && immutableList.isEmpty()) {
                return true;
            }
            for (Condition condition : immutableList) {
                ProfileType.Companion companion = ProfileType.Companion;
                if (!companion.b(condition.b().mask()).contains(ProfileType.USAGE_LIMIT) && !companion.b(condition.b().mask()).contains(ProfileType.LAUNCH_COUNT)) {
                    return false;
                }
            }
            return true;
        }

        public final Long j() {
            return this.f116616p;
        }

        public final ProfileType k() {
            ProfileHelper profileHelper = ProfileHelper.f129250a;
            ImmutableList immutableList = this.f116606f;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
            Iterator<E> it = immutableList.iterator();
            while (it.hasNext()) {
                arrayList.add(((Condition) it.next()).b());
            }
            return profileHelper.v(arrayList);
        }

        public final MissingPermissions l() {
            return this.f116611k;
        }

        public final PremiumState m() {
            return this.f116612l;
        }

        public final String n() {
            return this.f116603c;
        }

        public final String o() {
            return this.f116624x;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String p() {
            /*
                r10 = this;
                android.content.Context r0 = cz.mobilesoft.coreblock.LockieApplication.g()
                boolean r1 = r10.f116605e
                if (r1 == 0) goto Lb
                int r1 = cz.mobilesoft.coreblock.R.string.fr
                goto Ld
            Lb:
                int r1 = cz.mobilesoft.coreblock.R.string.iu
            Ld:
                java.lang.String r1 = r0.getString(r1)
                java.lang.String r2 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                boolean r3 = r10.f116618r
                if (r3 == 0) goto L31
                int r3 = cz.mobilesoft.coreblock.R.string.nu
                java.lang.String r3 = r0.getString(r3)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
                int r2 = cz.mobilesoft.coreblock.R.string.pu
                java.lang.Object[] r1 = new java.lang.Object[]{r1, r3}
                java.lang.String r0 = r0.getString(r2, r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                return r0
            L31:
                java.lang.Long r3 = r10.f116616p
                if (r3 == 0) goto L54
                long r3 = r3.longValue()
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r6 = r5.toHours(r3)
                r8 = 24
                int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r6 <= 0) goto L4a
                java.lang.String r3 = cz.mobilesoft.coreblock.util.helperextension.DateHelper.k(r0, r3)
                goto L52
            L4a:
                long r3 = r5.toSeconds(r3)
                java.lang.String r3 = cz.mobilesoft.coreblock.util.helperextension.DateHelper.e(r3)
            L52:
                if (r3 != 0) goto L56
            L54:
                java.lang.String r3 = "00:00"
            L56:
                int r4 = cz.mobilesoft.coreblock.R.string.ou
                java.lang.Object[] r3 = new java.lang.Object[]{r3}
                java.lang.String r3 = r0.getString(r4, r3)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
                int r2 = cz.mobilesoft.coreblock.R.string.pu
                java.lang.Object[] r1 = new java.lang.Object[]{r1, r3}
                java.lang.String r0 = r0.getString(r2, r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState.DetailViewState.p():java.lang.String");
        }

        public final int q() {
            return this.f116618r ? R.drawable.f95502d0 : R.drawable.r6;
        }

        public final ScheduleEmoji r() {
            return this.f116625y;
        }

        public final boolean s() {
            return this.f116609i;
        }

        public final boolean t() {
            return this.f116621u;
        }

        public String toString() {
            return "DetailViewState(state=" + this.f116601a + ", title=" + this.f116602b + ", saveButtonText=" + this.f116603c + ", isNewSchedule=" + this.f116604d + ", isQuickBlock=" + this.f116605e + ", conditions=" + this.f116606f + ", disabledConditions=" + this.f116607g + ", blocking=" + this.f116608h + ", showCopyFromButton=" + this.f116609i + ", appBlockingSettings=" + this.f116610j + ", missingPermissions=" + this.f116611k + ", premiumState=" + this.f116612l + ", exceededLimits=" + this.f116613m + ", isFirstConditionSet=" + this.f116614n + ", isFirstBlockingSet=" + this.f116615o + ", lockRemainingTimeInMS=" + this.f116616p + ", isScheduleLocked=" + this.f116617q + ", isScheduleLockedByCharger=" + this.f116618r + ", isLockedByStrictMode=" + this.f116619s + ", isAddConditionAllowed=" + this.f116620t + ", showLockButton=" + this.f116621u + ", showUnlockButton=" + this.f116622v + ", showQuickBlockTileHint=" + this.f116623w + ", savingValidationMessage=" + this.f116624x + ", selectedEmoji=" + this.f116625y + ", extraOptions=" + this.f116626z + ")";
        }

        public final boolean u() {
            return this.f116623w;
        }

        public final boolean v() {
            return this.f116622v;
        }

        public final ViewModelState w() {
            return this.f116601a;
        }

        public final String x() {
            return this.f116602b;
        }

        public final boolean y() {
            return this.f116620t;
        }

        public final boolean z() {
            ImmutableList immutableList = this.f116606f;
            if (immutableList != null && immutableList.isEmpty()) {
                return false;
            }
            Iterator<E> it = immutableList.iterator();
            while (it.hasNext()) {
                if (ProfileType.Companion.b(((Condition) it.next()).b().mask()).contains(ProfileType.LAUNCH_COUNT)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ConditionCardContent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ProfileType f116627a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f116628b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f116629c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f116630d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final int f116631e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f116632f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final boolean f116633g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final ImmutableList f116634h;

            public ConditionCardContent(ProfileType profileType, String title, String str, String secondLine, int i3, int i4, boolean z2, ImmutableList secondLineList) {
                Intrinsics.checkNotNullParameter(profileType, "profileType");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(secondLine, "secondLine");
                Intrinsics.checkNotNullParameter(secondLineList, "secondLineList");
                this.f116627a = profileType;
                this.f116628b = title;
                this.f116629c = str;
                this.f116630d = secondLine;
                this.f116631e = i3;
                this.f116632f = i4;
                this.f116633g = z2;
                this.f116634h = secondLineList;
            }

            public final int a() {
                return this.f116632f;
            }

            public final String b() {
                return this.f116629c;
            }

            public final int c() {
                return this.f116631e;
            }

            public final ProfileType d() {
                return this.f116627a;
            }

            public final String e() {
                return this.f116630d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConditionCardContent)) {
                    return false;
                }
                ConditionCardContent conditionCardContent = (ConditionCardContent) obj;
                return this.f116627a == conditionCardContent.f116627a && Intrinsics.areEqual(this.f116628b, conditionCardContent.f116628b) && Intrinsics.areEqual(this.f116629c, conditionCardContent.f116629c) && Intrinsics.areEqual(this.f116630d, conditionCardContent.f116630d) && this.f116631e == conditionCardContent.f116631e && this.f116632f == conditionCardContent.f116632f && this.f116633g == conditionCardContent.f116633g && Intrinsics.areEqual(this.f116634h, conditionCardContent.f116634h);
            }

            public final ImmutableList f() {
                return this.f116634h;
            }

            public final String g() {
                return this.f116628b;
            }

            public int hashCode() {
                int iHashCode = ((this.f116627a.hashCode() * 31) + this.f116628b.hashCode()) * 31;
                String str = this.f116629c;
                return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f116630d.hashCode()) * 31) + Integer.hashCode(this.f116631e)) * 31) + Integer.hashCode(this.f116632f)) * 31) + Boolean.hashCode(this.f116633g)) * 31) + this.f116634h.hashCode();
            }

            public String toString() {
                return "ConditionCardContent(profileType=" + this.f116627a + ", title=" + this.f116628b + ", firstLine=" + this.f116629c + ", secondLine=" + this.f116630d + ", iconResId=" + this.f116631e + ", disabledIconResId=" + this.f116632f + ", isCombineProfile=" + this.f116633g + ", secondLineList=" + this.f116634h + ")";
            }

            public /* synthetic */ ConditionCardContent(ProfileType profileType, String str, String str2, String str3, int i3, int i4, boolean z2, ImmutableList immutableList, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this(profileType, str, str2, str3, i3, i4, (i5 & 64) != 0 ? false : z2, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ExtensionsKt.a() : immutableList);
            }
        }

        public /* synthetic */ DetailViewState(ViewModelState viewModelState, String str, String str2, boolean z2, boolean z3, ImmutableList immutableList, ImmutableList immutableList2, Blocking blocking, boolean z4, AppBlockingSettings appBlockingSettings, MissingPermissions missingPermissions, PremiumState premiumState, ImmutableList immutableList3, boolean z5, boolean z6, Long l3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str3, ScheduleEmoji scheduleEmoji, ImmutableList immutableList4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? Loading.f127895a : viewModelState, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 64) != 0 ? ExtensionsKt.a() : immutableList2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new Blocking(null, null, false, null, null, null, null, null, 255, null) : blocking, (i3 & Function.MAX_NARGS) != 0 ? false : z4, (i3 & 512) != 0 ? new AppBlockingSettings(false, false, false, false, 15, null) : appBlockingSettings, (i3 & 1024) != 0 ? new MissingPermissions(null, false, 3, null) : missingPermissions, (i3 & 2048) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 4096) != 0 ? ExtensionsKt.a() : immutableList3, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z5, (i3 & 16384) != 0 ? false : z6, (i3 & 32768) != 0 ? null : l3, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? true : z7, (i3 & 131072) != 0 ? false : z8, (i3 & 262144) != 0 ? false : z9, (i3 & 524288) != 0 ? true : z10, (i3 & 1048576) != 0 ? false : z11, (i3 & 2097152) != 0 ? false : z12, (i3 & 4194304) != 0 ? false : z13, (i3 & 8388608) != 0 ? null : str3, (i3 & 16777216) != 0 ? ScheduleEmoji.NoIcon : scheduleEmoji, (i3 & 33554432) != 0 ? ExtensionsKt.a() : immutableList4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ScheduleViewState(DetailViewState detailViewState, AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState, boolean z2, DetailBottomSheetType detailBottomSheetType, boolean z3, boolean z4, boolean z5, boolean z6, ImmutableList immutableList, List list, GraphData graphData, ProfileWithConfiguration profileWithConfiguration, List list2, boolean z7, MainCardSummaryData mainCardSummaryData, ScheduleDescriptor scheduleDescriptor, PremiumState premiumState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        AdultContentDownloadWorker.AdultContentSyncState adultContentSyncState2;
        DetailViewState detailViewState2 = (i3 & 1) != 0 ? new DetailViewState(null, null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67108863, null) : detailViewState;
        ViewModelState viewModelState = null;
        Object[] objArr = 0;
        if ((i3 & 2) != 0) {
            adultContentSyncState2 = new AdultContentDownloadWorker.AdultContentSyncState(viewModelState, 0.0f, 3, objArr == true ? 1 : 0);
        } else {
            adultContentSyncState2 = adultContentSyncState;
        }
        this(detailViewState2, adultContentSyncState2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? DetailBottomSheetType.CopyBlockingBottomSheet : detailBottomSheetType, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? false : z4, (i3 & 64) != 0 ? true : z5, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z6, (i3 & Function.MAX_NARGS) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 512) != 0 ? ExtensionsKt.a() : list, (i3 & 1024) != 0 ? null : graphData, (i3 & 2048) != 0 ? null : profileWithConfiguration, (i3 & 4096) != 0 ? CollectionsKt.emptyList() : list2, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z7, (i3 & 16384) != 0 ? null : mainCardSummaryData, (i3 & 32768) != 0 ? new ScheduleDescriptor.NewSchedule(null, null, false, false, null, null, 63, null) : scheduleDescriptor, premiumState);
    }
}
