package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BlockingScreenViewState implements ViewState {
    private final boolean A;
    private final boolean B;
    private final int C;
    private final StreakDailyPresenter.Presentation.Banner D;
    private final boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MissingPermissionsState f99915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnnouncementCardState f99916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SchedulesSectionViewState f99917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f99918d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DiscountState f99919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Long f99920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f99921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduleTemplate f99922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f99923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f99924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f99925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f99926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f99927n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f99928o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f99929p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f99930q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f99931r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f99932s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f99933t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DonutChartDataCollection f99934u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Integer f99935v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Long f99936w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AutoTrialVariant f99937x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final boolean f99938y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f99939z;

    public BlockingScreenViewState(MissingPermissionsState missingPermissionsState, AnnouncementCardState announcementCardState, SchedulesSectionViewState schedulesSectionState, boolean z2, DiscountState discountState, Long l3, boolean z3, ScheduleTemplate scheduleTemplate, boolean z4, boolean z5, List helpItems, String deviceBrandName, boolean z6, long j3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, DonutChartDataCollection todayScreenTimeGraphData, Integer num, Long l4, AutoTrialVariant autoTrialVariant, boolean z12, boolean z13, boolean z14, boolean z15, int i3, StreakDailyPresenter.Presentation.Banner banner) {
        boolean z16;
        Intrinsics.checkNotNullParameter(missingPermissionsState, "missingPermissionsState");
        Intrinsics.checkNotNullParameter(announcementCardState, "announcementCardState");
        Intrinsics.checkNotNullParameter(schedulesSectionState, "schedulesSectionState");
        Intrinsics.checkNotNullParameter(helpItems, "helpItems");
        Intrinsics.checkNotNullParameter(deviceBrandName, "deviceBrandName");
        Intrinsics.checkNotNullParameter(todayScreenTimeGraphData, "todayScreenTimeGraphData");
        Intrinsics.checkNotNullParameter(autoTrialVariant, "autoTrialVariant");
        this.f99915a = missingPermissionsState;
        this.f99916b = announcementCardState;
        this.f99917c = schedulesSectionState;
        this.f99918d = z2;
        this.f99919f = discountState;
        this.f99920g = l3;
        this.f99921h = z3;
        this.f99922i = scheduleTemplate;
        this.f99923j = z4;
        this.f99924k = z5;
        this.f99925l = helpItems;
        this.f99926m = deviceBrandName;
        this.f99927n = z6;
        this.f99928o = j3;
        this.f99929p = z7;
        this.f99930q = z8;
        this.f99931r = z9;
        this.f99932s = z10;
        this.f99933t = z11;
        this.f99934u = todayScreenTimeGraphData;
        this.f99935v = num;
        this.f99936w = l4;
        this.f99937x = autoTrialVariant;
        this.f99938y = z12;
        this.f99939z = z13;
        this.A = z14;
        this.B = z15;
        this.C = i3;
        this.D = banner;
        if (z5) {
            List listD = missingPermissionsState.d();
            if (!listD.isEmpty()) {
                List list = listD;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (!(((PermissionDTO) it.next()).e() instanceof Permission.ACCESSIBILITY)) {
                        }
                    }
                }
                z16 = false;
            }
            z16 = true;
            break;
        }
        z16 = false;
        this.E = z16;
    }

    public static /* synthetic */ BlockingScreenViewState b(BlockingScreenViewState blockingScreenViewState, MissingPermissionsState missingPermissionsState, AnnouncementCardState announcementCardState, SchedulesSectionViewState schedulesSectionViewState, boolean z2, DiscountState discountState, Long l3, boolean z3, ScheduleTemplate scheduleTemplate, boolean z4, boolean z5, List list, String str, boolean z6, long j3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, DonutChartDataCollection donutChartDataCollection, Integer num, Long l4, AutoTrialVariant autoTrialVariant, boolean z12, boolean z13, boolean z14, boolean z15, int i3, StreakDailyPresenter.Presentation.Banner banner, int i4, Object obj) {
        StreakDailyPresenter.Presentation.Banner banner2;
        int i5;
        MissingPermissionsState missingPermissionsState2 = (i4 & 1) != 0 ? blockingScreenViewState.f99915a : missingPermissionsState;
        AnnouncementCardState announcementCardState2 = (i4 & 2) != 0 ? blockingScreenViewState.f99916b : announcementCardState;
        SchedulesSectionViewState schedulesSectionViewState2 = (i4 & 4) != 0 ? blockingScreenViewState.f99917c : schedulesSectionViewState;
        boolean z16 = (i4 & 8) != 0 ? blockingScreenViewState.f99918d : z2;
        DiscountState discountState2 = (i4 & 16) != 0 ? blockingScreenViewState.f99919f : discountState;
        Long l5 = (i4 & 32) != 0 ? blockingScreenViewState.f99920g : l3;
        boolean z17 = (i4 & 64) != 0 ? blockingScreenViewState.f99921h : z3;
        ScheduleTemplate scheduleTemplate2 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? blockingScreenViewState.f99922i : scheduleTemplate;
        boolean z18 = (i4 & Function.MAX_NARGS) != 0 ? blockingScreenViewState.f99923j : z4;
        boolean z19 = (i4 & 512) != 0 ? blockingScreenViewState.f99924k : z5;
        List list2 = (i4 & 1024) != 0 ? blockingScreenViewState.f99925l : list;
        String str2 = (i4 & 2048) != 0 ? blockingScreenViewState.f99926m : str;
        boolean z20 = (i4 & 4096) != 0 ? blockingScreenViewState.f99927n : z6;
        MissingPermissionsState missingPermissionsState3 = missingPermissionsState2;
        AnnouncementCardState announcementCardState3 = announcementCardState2;
        long j4 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? blockingScreenViewState.f99928o : j3;
        boolean z21 = (i4 & 16384) != 0 ? blockingScreenViewState.f99929p : z7;
        boolean z22 = (i4 & 32768) != 0 ? blockingScreenViewState.f99930q : z8;
        boolean z23 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? blockingScreenViewState.f99931r : z9;
        boolean z24 = (i4 & 131072) != 0 ? blockingScreenViewState.f99932s : z10;
        boolean z25 = (i4 & 262144) != 0 ? blockingScreenViewState.f99933t : z11;
        DonutChartDataCollection donutChartDataCollection2 = (i4 & 524288) != 0 ? blockingScreenViewState.f99934u : donutChartDataCollection;
        Integer num2 = (i4 & 1048576) != 0 ? blockingScreenViewState.f99935v : num;
        Long l6 = (i4 & 2097152) != 0 ? blockingScreenViewState.f99936w : l4;
        AutoTrialVariant autoTrialVariant2 = (i4 & 4194304) != 0 ? blockingScreenViewState.f99937x : autoTrialVariant;
        boolean z26 = (i4 & 8388608) != 0 ? blockingScreenViewState.f99938y : z12;
        boolean z27 = (i4 & 16777216) != 0 ? blockingScreenViewState.f99939z : z13;
        boolean z28 = (i4 & 33554432) != 0 ? blockingScreenViewState.A : z14;
        boolean z29 = (i4 & 67108864) != 0 ? blockingScreenViewState.B : z15;
        int i6 = (i4 & 134217728) != 0 ? blockingScreenViewState.C : i3;
        if ((i4 & 268435456) != 0) {
            i5 = i6;
            banner2 = blockingScreenViewState.D;
        } else {
            banner2 = banner;
            i5 = i6;
        }
        return blockingScreenViewState.a(missingPermissionsState3, announcementCardState3, schedulesSectionViewState2, z16, discountState2, l5, z17, scheduleTemplate2, z18, z19, list2, str2, z20, j4, z21, z22, z23, z24, z25, donutChartDataCollection2, num2, l6, autoTrialVariant2, z26, z27, z28, z29, i5, banner2);
    }

    public final boolean A() {
        return this.f99918d;
    }

    public final boolean B() {
        return this.B;
    }

    public final boolean C() {
        return this.f99932s;
    }

    public final boolean D() {
        return this.f99927n;
    }

    public final BlockingScreenViewState a(MissingPermissionsState missingPermissionsState, AnnouncementCardState announcementCardState, SchedulesSectionViewState schedulesSectionState, boolean z2, DiscountState discountState, Long l3, boolean z3, ScheduleTemplate scheduleTemplate, boolean z4, boolean z5, List helpItems, String deviceBrandName, boolean z6, long j3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, DonutChartDataCollection todayScreenTimeGraphData, Integer num, Long l4, AutoTrialVariant autoTrialVariant, boolean z12, boolean z13, boolean z14, boolean z15, int i3, StreakDailyPresenter.Presentation.Banner banner) {
        Intrinsics.checkNotNullParameter(missingPermissionsState, "missingPermissionsState");
        Intrinsics.checkNotNullParameter(announcementCardState, "announcementCardState");
        Intrinsics.checkNotNullParameter(schedulesSectionState, "schedulesSectionState");
        Intrinsics.checkNotNullParameter(helpItems, "helpItems");
        Intrinsics.checkNotNullParameter(deviceBrandName, "deviceBrandName");
        Intrinsics.checkNotNullParameter(todayScreenTimeGraphData, "todayScreenTimeGraphData");
        Intrinsics.checkNotNullParameter(autoTrialVariant, "autoTrialVariant");
        return new BlockingScreenViewState(missingPermissionsState, announcementCardState, schedulesSectionState, z2, discountState, l3, z3, scheduleTemplate, z4, z5, helpItems, deviceBrandName, z6, j3, z7, z8, z9, z10, z11, todayScreenTimeGraphData, num, l4, autoTrialVariant, z12, z13, z14, z15, i3, banner);
    }

    public final AnnouncementCardState c() {
        return this.f99916b;
    }

    public final Long d() {
        return this.f99920g;
    }

    public final boolean e() {
        return this.f99938y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockingScreenViewState)) {
            return false;
        }
        BlockingScreenViewState blockingScreenViewState = (BlockingScreenViewState) obj;
        return Intrinsics.areEqual(this.f99915a, blockingScreenViewState.f99915a) && Intrinsics.areEqual(this.f99916b, blockingScreenViewState.f99916b) && Intrinsics.areEqual(this.f99917c, blockingScreenViewState.f99917c) && this.f99918d == blockingScreenViewState.f99918d && Intrinsics.areEqual(this.f99919f, blockingScreenViewState.f99919f) && Intrinsics.areEqual(this.f99920g, blockingScreenViewState.f99920g) && this.f99921h == blockingScreenViewState.f99921h && this.f99922i == blockingScreenViewState.f99922i && this.f99923j == blockingScreenViewState.f99923j && this.f99924k == blockingScreenViewState.f99924k && Intrinsics.areEqual(this.f99925l, blockingScreenViewState.f99925l) && Intrinsics.areEqual(this.f99926m, blockingScreenViewState.f99926m) && this.f99927n == blockingScreenViewState.f99927n && this.f99928o == blockingScreenViewState.f99928o && this.f99929p == blockingScreenViewState.f99929p && this.f99930q == blockingScreenViewState.f99930q && this.f99931r == blockingScreenViewState.f99931r && this.f99932s == blockingScreenViewState.f99932s && this.f99933t == blockingScreenViewState.f99933t && Intrinsics.areEqual(this.f99934u, blockingScreenViewState.f99934u) && Intrinsics.areEqual(this.f99935v, blockingScreenViewState.f99935v) && Intrinsics.areEqual(this.f99936w, blockingScreenViewState.f99936w) && this.f99937x == blockingScreenViewState.f99937x && this.f99938y == blockingScreenViewState.f99938y && this.f99939z == blockingScreenViewState.f99939z && this.A == blockingScreenViewState.A && this.B == blockingScreenViewState.B && this.C == blockingScreenViewState.C && Intrinsics.areEqual(this.D, blockingScreenViewState.D);
    }

    public final boolean f() {
        return this.f99939z;
    }

    public final boolean g() {
        return this.A;
    }

    public final Long h() {
        return this.f99936w;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f99915a.hashCode() * 31) + this.f99916b.hashCode()) * 31) + this.f99917c.hashCode()) * 31) + Boolean.hashCode(this.f99918d)) * 31;
        DiscountState discountState = this.f99919f;
        int iHashCode2 = (iHashCode + (discountState == null ? 0 : discountState.hashCode())) * 31;
        Long l3 = this.f99920g;
        int iHashCode3 = (((iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f99921h)) * 31;
        ScheduleTemplate scheduleTemplate = this.f99922i;
        int iHashCode4 = (((((((((((((((((((((((((iHashCode3 + (scheduleTemplate == null ? 0 : scheduleTemplate.hashCode())) * 31) + Boolean.hashCode(this.f99923j)) * 31) + Boolean.hashCode(this.f99924k)) * 31) + this.f99925l.hashCode()) * 31) + this.f99926m.hashCode()) * 31) + Boolean.hashCode(this.f99927n)) * 31) + Long.hashCode(this.f99928o)) * 31) + Boolean.hashCode(this.f99929p)) * 31) + Boolean.hashCode(this.f99930q)) * 31) + Boolean.hashCode(this.f99931r)) * 31) + Boolean.hashCode(this.f99932s)) * 31) + Boolean.hashCode(this.f99933t)) * 31) + this.f99934u.hashCode()) * 31;
        Integer num = this.f99935v;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Long l4 = this.f99936w;
        int iHashCode6 = (((((((((((((iHashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31) + this.f99937x.hashCode()) * 31) + Boolean.hashCode(this.f99938y)) * 31) + Boolean.hashCode(this.f99939z)) * 31) + Boolean.hashCode(this.A)) * 31) + Boolean.hashCode(this.B)) * 31) + Integer.hashCode(this.C)) * 31;
        StreakDailyPresenter.Presentation.Banner banner = this.D;
        return iHashCode6 + (banner != null ? banner.hashCode() : 0);
    }

    public final AutoTrialVariant i() {
        return this.f99937x;
    }

    public final boolean j() {
        return this.f99933t;
    }

    public final Integer k() {
        return this.f99935v;
    }

    public final String l() {
        return this.f99926m;
    }

    public final DiscountState m() {
        return this.f99919f;
    }

    public final List n() {
        return this.f99925l;
    }

    public final MissingPermissionsState o() {
        return this.f99915a;
    }

    public final boolean p() {
        return this.f99930q;
    }

    public final boolean q() {
        return this.f99931r;
    }

    public final SchedulesSectionViewState r() {
        return this.f99917c;
    }

    public final ScheduleTemplate s() {
        return this.f99922i;
    }

    public final boolean t() {
        return this.E;
    }

    public String toString() {
        return "BlockingScreenViewState(missingPermissionsState=" + this.f99915a + ", announcementCardState=" + this.f99916b + ", schedulesSectionState=" + this.f99917c + ", isQuickBlockCardVisible=" + this.f99918d + ", discountState=" + this.f99919f + ", appTime=" + this.f99920g + ", showTemplates=" + this.f99921h + ", seasonalTemplate=" + this.f99922i + ", isPauseEnabled=" + this.f99923j + ", displayTroubleshootingCard=" + this.f99924k + ", helpItems=" + this.f99925l + ", deviceBrandName=" + this.f99926m + ", isTrialEligible=" + this.f99927n + ", initialTimeInMillis=" + this.f99928o + ", showPremiumExpiringCard=" + this.f99929p + ", profileCreatingAllowed=" + this.f99930q + ", profileEnablingAllowed=" + this.f99931r + ", isStrictModeActive=" + this.f99932s + ", dailyTrendBadgeOn=" + this.f99933t + ", todayScreenTimeGraphData=" + this.f99934u + ", daysLeftInPremium=" + this.f99935v + ", autoTrialRemainingMillis=" + this.f99936w + ", autoTrialVariant=" + this.f99937x + ", autoTrialCardDismissed=" + this.f99938y + ", autoTrialExpired=" + this.f99939z + ", autoTrialExpiredCardDismissed=" + this.A + ", isStreakVisible=" + this.B + ", streakCount=" + this.C + ", streakBanner=" + this.D + ")";
    }

    public final boolean u() {
        return this.f99929p;
    }

    public final boolean v() {
        return this.f99921h;
    }

    public final StreakDailyPresenter.Presentation.Banner w() {
        return this.D;
    }

    public final int x() {
        return this.C;
    }

    public final DonutChartDataCollection y() {
        return this.f99934u;
    }

    public final boolean z() {
        return this.f99923j;
    }

    public /* synthetic */ BlockingScreenViewState(MissingPermissionsState missingPermissionsState, AnnouncementCardState announcementCardState, SchedulesSectionViewState schedulesSectionViewState, boolean z2, DiscountState discountState, Long l3, boolean z3, ScheduleTemplate scheduleTemplate, boolean z4, boolean z5, List list, String str, boolean z6, long j3, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, DonutChartDataCollection donutChartDataCollection, Integer num, Long l4, AutoTrialVariant autoTrialVariant, boolean z12, boolean z13, boolean z14, boolean z15, int i3, StreakDailyPresenter.Presentation.Banner banner, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        AnnouncementCardState announcementCardState2;
        long jU0;
        MissingPermissionsState missingPermissionsState2;
        DonutChartDataCollection donutChartDataCollection2;
        MissingPermissionsState missingPermissionsState3 = (i4 & 1) != 0 ? new MissingPermissionsState(null, false, 3, null) : missingPermissionsState;
        AnnouncementCardState announcementCardState3 = (i4 & 2) != 0 ? new AnnouncementCardState(false, null, 3, null) : announcementCardState;
        SchedulesSectionViewState schedulesSectionViewState2 = (i4 & 4) != 0 ? new SchedulesSectionViewState(false, null, 3, null) : schedulesSectionViewState;
        boolean z16 = (i4 & 8) != 0 ? false : z2;
        DiscountState discountState2 = (i4 & 16) != 0 ? null : discountState;
        Long l5 = (i4 & 32) != 0 ? null : l3;
        boolean z17 = (i4 & 64) != 0 ? true : z3;
        ScheduleTemplate scheduleTemplate2 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : scheduleTemplate;
        boolean z18 = (i4 & Function.MAX_NARGS) == 0 ? z4 : true;
        boolean z19 = (i4 & 512) != 0 ? false : z5;
        List listEmptyList = (i4 & 1024) != 0 ? CollectionsKt.emptyList() : list;
        String str2 = (i4 & 2048) != 0 ? "" : str;
        boolean z20 = (i4 & 4096) != 0 ? false : z6;
        if ((i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            announcementCardState2 = announcementCardState3;
            jU0 = ((long) PrefManager.f126839a.U0()) * 60000;
        } else {
            announcementCardState2 = announcementCardState3;
            jU0 = j3;
        }
        boolean z21 = (i4 & 16384) != 0 ? false : z7;
        boolean z22 = (i4 & 32768) != 0 ? false : z8;
        boolean z23 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z9;
        boolean z24 = (i4 & 131072) != 0 ? false : z10;
        boolean z25 = (i4 & 262144) != 0 ? false : z11;
        if ((i4 & 524288) != 0) {
            missingPermissionsState2 = missingPermissionsState3;
            donutChartDataCollection2 = new DonutChartDataCollection(CollectionsKt.emptyList());
        } else {
            missingPermissionsState2 = missingPermissionsState3;
            donutChartDataCollection2 = donutChartDataCollection;
        }
        this(missingPermissionsState2, announcementCardState2, schedulesSectionViewState2, z16, discountState2, l5, z17, scheduleTemplate2, z18, z19, listEmptyList, str2, z20, jU0, z21, z22, z23, z24, z25, donutChartDataCollection2, (i4 & 1048576) != 0 ? null : num, (i4 & 2097152) != 0 ? null : l4, (i4 & 4194304) != 0 ? AutoTrialVariant.Off : autoTrialVariant, (i4 & 8388608) != 0 ? false : z12, (i4 & 16777216) != 0 ? false : z13, (i4 & 33554432) != 0 ? false : z14, (i4 & 67108864) != 0 ? false : z15, (i4 & 134217728) != 0 ? 0 : i3, (i4 & 268435456) != 0 ? null : banner);
    }
}
