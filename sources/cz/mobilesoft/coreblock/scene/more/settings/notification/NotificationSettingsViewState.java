package cz.mobilesoft.coreblock.scene.more.settings.notification;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationPreference;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationSettingsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f110091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f110092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f110093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f110094d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f110095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f110096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f110097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NotificationPreference.NotificationBeforeUsageLimitEnd f110098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f110099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final NotificationPreference.ShowAfterScheduleEndBlockedNotifications f110100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f110101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications f110102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f110103n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f110104o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f110105p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f110106q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f110107r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f110108s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f110109t;

    public NotificationSettingsViewState(Boolean bool, ImmutableList preferences, boolean z2, boolean z3, boolean z4, boolean z5, int i3, NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, boolean z6, NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications, boolean z7, NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications, int i4, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.f110091a = bool;
        this.f110092b = preferences;
        this.f110093c = z2;
        this.f110094d = z3;
        this.f110095f = z4;
        this.f110096g = z5;
        this.f110097h = i3;
        this.f110098i = notificationBeforeUsageLimitEnd;
        this.f110099j = z6;
        this.f110100k = showAfterScheduleEndBlockedNotifications;
        this.f110101l = z7;
        this.f110102m = showAfterQuickBlockEndBlockedNotifications;
        this.f110103n = i4;
        this.f110104o = z8;
        this.f110105p = z9;
        this.f110106q = z10;
        this.f110107r = z11;
        this.f110108s = z12;
        this.f110109t = z13;
    }

    public static /* synthetic */ NotificationSettingsViewState b(NotificationSettingsViewState notificationSettingsViewState, Boolean bool, ImmutableList immutableList, boolean z2, boolean z3, boolean z4, boolean z5, int i3, NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, boolean z6, NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications, boolean z7, NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications, int i4, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i5, Object obj) {
        boolean z14;
        boolean z15;
        Boolean bool2 = (i5 & 1) != 0 ? notificationSettingsViewState.f110091a : bool;
        ImmutableList immutableList2 = (i5 & 2) != 0 ? notificationSettingsViewState.f110092b : immutableList;
        boolean z16 = (i5 & 4) != 0 ? notificationSettingsViewState.f110093c : z2;
        boolean z17 = (i5 & 8) != 0 ? notificationSettingsViewState.f110094d : z3;
        boolean z18 = (i5 & 16) != 0 ? notificationSettingsViewState.f110095f : z4;
        boolean z19 = (i5 & 32) != 0 ? notificationSettingsViewState.f110096g : z5;
        int i6 = (i5 & 64) != 0 ? notificationSettingsViewState.f110097h : i3;
        NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd2 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? notificationSettingsViewState.f110098i : notificationBeforeUsageLimitEnd;
        boolean z20 = (i5 & Function.MAX_NARGS) != 0 ? notificationSettingsViewState.f110099j : z6;
        NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications2 = (i5 & 512) != 0 ? notificationSettingsViewState.f110100k : showAfterScheduleEndBlockedNotifications;
        boolean z21 = (i5 & 1024) != 0 ? notificationSettingsViewState.f110101l : z7;
        NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications2 = (i5 & 2048) != 0 ? notificationSettingsViewState.f110102m : showAfterQuickBlockEndBlockedNotifications;
        int i7 = (i5 & 4096) != 0 ? notificationSettingsViewState.f110103n : i4;
        boolean z22 = (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? notificationSettingsViewState.f110104o : z8;
        Boolean bool3 = bool2;
        boolean z23 = (i5 & 16384) != 0 ? notificationSettingsViewState.f110105p : z9;
        boolean z24 = (i5 & 32768) != 0 ? notificationSettingsViewState.f110106q : z10;
        boolean z25 = (i5 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? notificationSettingsViewState.f110107r : z11;
        boolean z26 = (i5 & 131072) != 0 ? notificationSettingsViewState.f110108s : z12;
        if ((i5 & 262144) != 0) {
            z15 = z26;
            z14 = notificationSettingsViewState.f110109t;
        } else {
            z14 = z13;
            z15 = z26;
        }
        return notificationSettingsViewState.a(bool3, immutableList2, z16, z17, z18, z19, i6, notificationBeforeUsageLimitEnd2, z20, showAfterScheduleEndBlockedNotifications2, z21, showAfterQuickBlockEndBlockedNotifications2, i7, z22, z23, z24, z25, z15, z14);
    }

    public final NotificationSettingsViewState a(Boolean bool, ImmutableList preferences, boolean z2, boolean z3, boolean z4, boolean z5, int i3, NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, boolean z6, NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications, boolean z7, NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications, int i4, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new NotificationSettingsViewState(bool, preferences, z2, z3, z4, z5, i3, notificationBeforeUsageLimitEnd, z6, showAfterScheduleEndBlockedNotifications, z7, showAfterQuickBlockEndBlockedNotifications, i4, z8, z9, z10, z11, z12, z13);
    }

    public final boolean c() {
        return this.f110107r;
    }

    public final Boolean d() {
        return this.f110091a;
    }

    public final int e() {
        return this.f110097h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationSettingsViewState)) {
            return false;
        }
        NotificationSettingsViewState notificationSettingsViewState = (NotificationSettingsViewState) obj;
        return Intrinsics.areEqual(this.f110091a, notificationSettingsViewState.f110091a) && Intrinsics.areEqual(this.f110092b, notificationSettingsViewState.f110092b) && this.f110093c == notificationSettingsViewState.f110093c && this.f110094d == notificationSettingsViewState.f110094d && this.f110095f == notificationSettingsViewState.f110095f && this.f110096g == notificationSettingsViewState.f110096g && this.f110097h == notificationSettingsViewState.f110097h && Intrinsics.areEqual(this.f110098i, notificationSettingsViewState.f110098i) && this.f110099j == notificationSettingsViewState.f110099j && Intrinsics.areEqual(this.f110100k, notificationSettingsViewState.f110100k) && this.f110101l == notificationSettingsViewState.f110101l && Intrinsics.areEqual(this.f110102m, notificationSettingsViewState.f110102m) && this.f110103n == notificationSettingsViewState.f110103n && this.f110104o == notificationSettingsViewState.f110104o && this.f110105p == notificationSettingsViewState.f110105p && this.f110106q == notificationSettingsViewState.f110106q && this.f110107r == notificationSettingsViewState.f110107r && this.f110108s == notificationSettingsViewState.f110108s && this.f110109t == notificationSettingsViewState.f110109t;
    }

    public final int f() {
        return this.f110103n;
    }

    public final NotificationPreference.NotificationBeforeUsageLimitEnd g() {
        return this.f110098i;
    }

    public final boolean h() {
        return this.f110101l;
    }

    public int hashCode() {
        Boolean bool = this.f110091a;
        int iHashCode = (((((((((((((bool == null ? 0 : bool.hashCode()) * 31) + this.f110092b.hashCode()) * 31) + Boolean.hashCode(this.f110093c)) * 31) + Boolean.hashCode(this.f110094d)) * 31) + Boolean.hashCode(this.f110095f)) * 31) + Boolean.hashCode(this.f110096g)) * 31) + Integer.hashCode(this.f110097h)) * 31;
        NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd = this.f110098i;
        int iHashCode2 = (((iHashCode + (notificationBeforeUsageLimitEnd == null ? 0 : notificationBeforeUsageLimitEnd.hashCode())) * 31) + Boolean.hashCode(this.f110099j)) * 31;
        NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications = this.f110100k;
        int iHashCode3 = (((iHashCode2 + (showAfterScheduleEndBlockedNotifications == null ? 0 : showAfterScheduleEndBlockedNotifications.hashCode())) * 31) + Boolean.hashCode(this.f110101l)) * 31;
        NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications = this.f110102m;
        return ((((((((((((((iHashCode3 + (showAfterQuickBlockEndBlockedNotifications != null ? showAfterQuickBlockEndBlockedNotifications.hashCode() : 0)) * 31) + Integer.hashCode(this.f110103n)) * 31) + Boolean.hashCode(this.f110104o)) * 31) + Boolean.hashCode(this.f110105p)) * 31) + Boolean.hashCode(this.f110106q)) * 31) + Boolean.hashCode(this.f110107r)) * 31) + Boolean.hashCode(this.f110108s)) * 31) + Boolean.hashCode(this.f110109t);
    }

    public final NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications i() {
        return this.f110102m;
    }

    public final boolean j() {
        return this.f110099j;
    }

    public final NotificationPreference.ShowAfterScheduleEndBlockedNotifications k() {
        return this.f110100k;
    }

    public final boolean l() {
        return this.f110093c;
    }

    public final boolean m() {
        return this.f110106q;
    }

    public final boolean n() {
        return this.f110095f;
    }

    public final boolean o() {
        return this.f110094d;
    }

    public final boolean p() {
        return this.f110104o;
    }

    public final boolean q() {
        return this.f110105p;
    }

    public final boolean r() {
        return this.f110109t;
    }

    public final boolean s() {
        return this.f110108s;
    }

    public final boolean t() {
        return this.f110096g;
    }

    public String toString() {
        return "NotificationSettingsViewState(missingPermission=" + this.f110091a + ", preferences=" + this.f110092b + ", showBlockedApps=" + this.f110093c + ", showUsageLimit=" + this.f110094d + ", showStreakNudge=" + this.f110095f + ", isStreaksEnabled=" + this.f110096g + ", notificationBeforeIntervalStart=" + this.f110097h + ", notificationBeforeUsageLimitEnd=" + this.f110098i + ", showAfterScheduleEnd=" + this.f110099j + ", showAfterScheduleEndBlockedNotifications=" + this.f110100k + ", showAfterQuickBlockEnd=" + this.f110101l + ", showAfterQuickBlockEndBlockedNotifications=" + this.f110102m + ", notificationBeforePauseEnd=" + this.f110103n + ", showUsageStatisticsNotification=" + this.f110104o + ", showWeeklyStatisticsReportNotification=" + this.f110105p + ", showPomodoroNotifications=" + this.f110106q + ", areDailyInsightMotivationNotificationsEnabled=" + this.f110107r + ", isSignedIn=" + this.f110108s + ", isNewsletterEnabled=" + this.f110109t + ")";
    }

    public /* synthetic */ NotificationSettingsViewState(Boolean bool, ImmutableList immutableList, boolean z2, boolean z3, boolean z4, boolean z5, int i3, NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, boolean z6, NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications, boolean z7, NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications, int i4, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : bool, (i5 & 2) != 0 ? ExtensionsKt.a() : immutableList, (i5 & 4) != 0 ? false : z2, (i5 & 8) != 0 ? false : z3, (i5 & 16) != 0 ? true : z4, (i5 & 32) != 0 ? false : z5, (i5 & 64) != 0 ? 0 : i3, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : notificationBeforeUsageLimitEnd, (i5 & Function.MAX_NARGS) != 0 ? false : z6, (i5 & 512) != 0 ? null : showAfterScheduleEndBlockedNotifications, (i5 & 1024) != 0 ? false : z7, (i5 & 2048) == 0 ? showAfterQuickBlockEndBlockedNotifications : null, (i5 & 4096) != 0 ? 0 : i4, (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z8, (i5 & 16384) != 0 ? false : z9, (i5 & 32768) != 0 ? false : z10, (i5 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z11, (i5 & 131072) != 0 ? false : z12, (i5 & 262144) != 0 ? false : z13);
    }
}
