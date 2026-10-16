package cz.mobilesoft.coreblock.scene.schedule;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ScheduleDTO implements Serializable {
    private final long A;
    private final ScheduleEmoji B;
    private final boolean C;
    private final List D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f114449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f114450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f114451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f114452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f114453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f114454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f114455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f114456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f114457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Profile.BlockingMode f114458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Profile.AllowlistWebBrowsingMode f114459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ConditionDTO.LocationDTO f114460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ConditionDTO.UsageLimitDTO f114461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ConditionDTO.LaunchCountDTO f114462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ConditionDTO.TimeDTO f114463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ConditionDTO.WifisDTO f114464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ArrayList f114465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ArrayList f114466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ArrayList f114467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList f114468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Profile.PausedUntil f114469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f114470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f114471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final boolean f114472y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long f114473z;

    public ScheduleDTO(Long l3, String title, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i3, Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode webBrowsingMode, ConditionDTO.LocationDTO locationDTO, ConditionDTO.UsageLimitDTO usageLimitDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.TimeDTO timeDTO, ConditionDTO.WifisDTO wifisDTO, ArrayList applications, ArrayList websites, ArrayList keywords, ArrayList selectedSubApps, Profile.PausedUntil pausedUntil, boolean z8, boolean z9, boolean z10, long j3, long j4, ScheduleEmoji emoji, boolean z11, List categories) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(webBrowsingMode, "webBrowsingMode");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(selectedSubApps, "selectedSubApps");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.f114449a = l3;
        this.f114450b = title;
        this.f114451c = z2;
        this.f114452d = z3;
        this.f114453f = z4;
        this.f114454g = z5;
        this.f114455h = z6;
        this.f114456i = z7;
        this.f114457j = i3;
        this.f114458k = blockingMode;
        this.f114459l = webBrowsingMode;
        this.f114460m = locationDTO;
        this.f114461n = usageLimitDTO;
        this.f114462o = launchCountDTO;
        this.f114463p = timeDTO;
        this.f114464q = wifisDTO;
        this.f114465r = applications;
        this.f114466s = websites;
        this.f114467t = keywords;
        this.f114468u = selectedSubApps;
        this.f114469v = pausedUntil;
        this.f114470w = z8;
        this.f114471x = z9;
        this.f114472y = z10;
        this.f114473z = j3;
        this.A = j4;
        this.B = emoji;
        this.C = z11;
        this.D = categories;
    }

    public static /* synthetic */ ScheduleDTO b(ScheduleDTO scheduleDTO, Long l3, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i3, Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, ConditionDTO.LocationDTO locationDTO, ConditionDTO.UsageLimitDTO usageLimitDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.TimeDTO timeDTO, ConditionDTO.WifisDTO wifisDTO, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Profile.PausedUntil pausedUntil, boolean z8, boolean z9, boolean z10, long j3, long j4, ScheduleEmoji scheduleEmoji, boolean z11, List list, int i4, Object obj) {
        List list2;
        ScheduleEmoji scheduleEmoji2;
        ConditionDTO.WifisDTO wifisDTO2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        Profile.PausedUntil pausedUntil2;
        boolean z12;
        boolean z13;
        ConditionDTO.TimeDTO timeDTO2;
        boolean z14;
        long j5;
        long j6;
        boolean z15;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        int i5;
        Profile.BlockingMode blockingMode2;
        Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode2;
        ConditionDTO.LocationDTO locationDTO2;
        ConditionDTO.UsageLimitDTO usageLimitDTO2;
        ConditionDTO.LaunchCountDTO launchCountDTO2;
        Long l4;
        ScheduleDTO scheduleDTO2;
        Long l5 = (i4 & 1) != 0 ? scheduleDTO.f114449a : l3;
        String str3 = (i4 & 2) != 0 ? scheduleDTO.f114450b : str;
        boolean z22 = (i4 & 4) != 0 ? scheduleDTO.f114451c : z2;
        boolean z23 = (i4 & 8) != 0 ? scheduleDTO.f114452d : z3;
        boolean z24 = (i4 & 16) != 0 ? scheduleDTO.f114453f : z4;
        boolean z25 = (i4 & 32) != 0 ? scheduleDTO.f114454g : z5;
        boolean z26 = (i4 & 64) != 0 ? scheduleDTO.f114455h : z6;
        boolean z27 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? scheduleDTO.f114456i : z7;
        int i6 = (i4 & Function.MAX_NARGS) != 0 ? scheduleDTO.f114457j : i3;
        Profile.BlockingMode blockingMode3 = (i4 & 512) != 0 ? scheduleDTO.f114458k : blockingMode;
        Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode3 = (i4 & 1024) != 0 ? scheduleDTO.f114459l : allowlistWebBrowsingMode;
        ConditionDTO.LocationDTO locationDTO3 = (i4 & 2048) != 0 ? scheduleDTO.f114460m : locationDTO;
        ConditionDTO.UsageLimitDTO usageLimitDTO3 = (i4 & 4096) != 0 ? scheduleDTO.f114461n : usageLimitDTO;
        ConditionDTO.LaunchCountDTO launchCountDTO3 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? scheduleDTO.f114462o : launchCountDTO;
        Long l6 = l5;
        ConditionDTO.TimeDTO timeDTO3 = (i4 & 16384) != 0 ? scheduleDTO.f114463p : timeDTO;
        ConditionDTO.WifisDTO wifisDTO3 = (i4 & 32768) != 0 ? scheduleDTO.f114464q : wifisDTO;
        ArrayList arrayList9 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? scheduleDTO.f114465r : arrayList;
        ArrayList arrayList10 = (i4 & 131072) != 0 ? scheduleDTO.f114466s : arrayList2;
        ArrayList arrayList11 = (i4 & 262144) != 0 ? scheduleDTO.f114467t : arrayList3;
        ArrayList arrayList12 = (i4 & 524288) != 0 ? scheduleDTO.f114468u : arrayList4;
        Profile.PausedUntil pausedUntil3 = (i4 & 1048576) != 0 ? scheduleDTO.f114469v : pausedUntil;
        boolean z28 = (i4 & 2097152) != 0 ? scheduleDTO.f114470w : z8;
        boolean z29 = (i4 & 4194304) != 0 ? scheduleDTO.f114471x : z9;
        boolean z30 = (i4 & 8388608) != 0 ? scheduleDTO.f114472y : z10;
        ConditionDTO.TimeDTO timeDTO4 = timeDTO3;
        long j7 = (i4 & 16777216) != 0 ? scheduleDTO.f114473z : j3;
        long j8 = (i4 & 33554432) != 0 ? scheduleDTO.A : j4;
        ScheduleEmoji scheduleEmoji3 = (i4 & 67108864) != 0 ? scheduleDTO.B : scheduleEmoji;
        boolean z31 = (i4 & 134217728) != 0 ? scheduleDTO.C : z11;
        if ((i4 & 268435456) != 0) {
            scheduleEmoji2 = scheduleEmoji3;
            list2 = scheduleDTO.D;
            wifisDTO2 = wifisDTO3;
            arrayList5 = arrayList9;
            arrayList6 = arrayList10;
            arrayList7 = arrayList11;
            arrayList8 = arrayList12;
            pausedUntil2 = pausedUntil3;
            z12 = z28;
            z13 = z29;
            z14 = z30;
            j5 = j7;
            j6 = j8;
            z15 = z31;
            str2 = str3;
            z16 = z22;
            z17 = z23;
            z18 = z24;
            z19 = z25;
            z20 = z26;
            z21 = z27;
            blockingMode2 = blockingMode3;
            allowlistWebBrowsingMode2 = allowlistWebBrowsingMode3;
            locationDTO2 = locationDTO3;
            usageLimitDTO2 = usageLimitDTO3;
            launchCountDTO2 = launchCountDTO3;
            l4 = l6;
            timeDTO2 = timeDTO4;
            scheduleDTO2 = scheduleDTO;
            i5 = i6;
        } else {
            list2 = list;
            scheduleEmoji2 = scheduleEmoji3;
            wifisDTO2 = wifisDTO3;
            arrayList5 = arrayList9;
            arrayList6 = arrayList10;
            arrayList7 = arrayList11;
            arrayList8 = arrayList12;
            pausedUntil2 = pausedUntil3;
            z12 = z28;
            z13 = z29;
            timeDTO2 = timeDTO4;
            z14 = z30;
            j5 = j7;
            j6 = j8;
            z15 = z31;
            str2 = str3;
            z16 = z22;
            z17 = z23;
            z18 = z24;
            z19 = z25;
            z20 = z26;
            z21 = z27;
            i5 = i6;
            blockingMode2 = blockingMode3;
            allowlistWebBrowsingMode2 = allowlistWebBrowsingMode3;
            locationDTO2 = locationDTO3;
            usageLimitDTO2 = usageLimitDTO3;
            launchCountDTO2 = launchCountDTO3;
            l4 = l6;
            scheduleDTO2 = scheduleDTO;
        }
        return scheduleDTO2.a(l4, str2, z16, z17, z18, z19, z20, z21, i5, blockingMode2, allowlistWebBrowsingMode2, locationDTO2, usageLimitDTO2, launchCountDTO2, timeDTO2, wifisDTO2, arrayList5, arrayList6, arrayList7, arrayList8, pausedUntil2, z12, z13, z14, j5, j6, scheduleEmoji2, z15, list2);
    }

    public final ConditionDTO.UsageLimitDTO A() {
        return this.f114461n;
    }

    public final Profile.AllowlistWebBrowsingMode B() {
        return this.f114459l;
    }

    public final ArrayList C() {
        return this.f114466s;
    }

    public final ConditionDTO.WifisDTO D() {
        return this.f114464q;
    }

    public final boolean E() {
        return this.f114472y;
    }

    public final boolean F() {
        return this.C;
    }

    public final boolean G() {
        return this.f114471x;
    }

    public final boolean H() {
        return this.f114470w;
    }

    public final boolean I() {
        return this.f114458k == Profile.BlockingMode.Blocklist && this.f114465r.isEmpty() && this.f114466s.isEmpty() && this.f114467t.isEmpty() && this.f114468u.isEmpty() && this.D.isEmpty() && !this.f114451c && !this.f114452d && !this.f114453f && !this.f114454g;
    }

    public final boolean J() {
        if (this.f114471x) {
            return false;
        }
        return this.f114458k != Profile.BlockingMode.Allowlist || this.f114465r.isEmpty();
    }

    public final ScheduleDTO a(Long l3, String title, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i3, Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode webBrowsingMode, ConditionDTO.LocationDTO locationDTO, ConditionDTO.UsageLimitDTO usageLimitDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.TimeDTO timeDTO, ConditionDTO.WifisDTO wifisDTO, ArrayList applications, ArrayList websites, ArrayList keywords, ArrayList selectedSubApps, Profile.PausedUntil pausedUntil, boolean z8, boolean z9, boolean z10, long j3, long j4, ScheduleEmoji emoji, boolean z11, List categories) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(webBrowsingMode, "webBrowsingMode");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(selectedSubApps, "selectedSubApps");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(categories, "categories");
        return new ScheduleDTO(l3, title, z2, z3, z4, z5, z6, z7, i3, blockingMode, webBrowsingMode, locationDTO, usageLimitDTO, launchCountDTO, timeDTO, wifisDTO, applications, websites, keywords, selectedSubApps, pausedUntil, z8, z9, z10, j3, j4, emoji, z11, categories);
    }

    public final boolean c() {
        return this.f114451c;
    }

    public final boolean d() {
        return (ProfileType.USAGE_LIMIT.isSetTo(this.f114457j) || ProfileType.LAUNCH_COUNT.isSetTo(this.f114457j)) ? false : true;
    }

    public final ArrayList e() {
        return this.f114465r;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleDTO)) {
            return false;
        }
        ScheduleDTO scheduleDTO = (ScheduleDTO) obj;
        return Intrinsics.areEqual(this.f114449a, scheduleDTO.f114449a) && Intrinsics.areEqual(this.f114450b, scheduleDTO.f114450b) && this.f114451c == scheduleDTO.f114451c && this.f114452d == scheduleDTO.f114452d && this.f114453f == scheduleDTO.f114453f && this.f114454g == scheduleDTO.f114454g && this.f114455h == scheduleDTO.f114455h && this.f114456i == scheduleDTO.f114456i && this.f114457j == scheduleDTO.f114457j && this.f114458k == scheduleDTO.f114458k && this.f114459l == scheduleDTO.f114459l && Intrinsics.areEqual(this.f114460m, scheduleDTO.f114460m) && Intrinsics.areEqual(this.f114461n, scheduleDTO.f114461n) && Intrinsics.areEqual(this.f114462o, scheduleDTO.f114462o) && Intrinsics.areEqual(this.f114463p, scheduleDTO.f114463p) && Intrinsics.areEqual(this.f114464q, scheduleDTO.f114464q) && Intrinsics.areEqual(this.f114465r, scheduleDTO.f114465r) && Intrinsics.areEqual(this.f114466s, scheduleDTO.f114466s) && Intrinsics.areEqual(this.f114467t, scheduleDTO.f114467t) && Intrinsics.areEqual(this.f114468u, scheduleDTO.f114468u) && Intrinsics.areEqual(this.f114469v, scheduleDTO.f114469v) && this.f114470w == scheduleDTO.f114470w && this.f114471x == scheduleDTO.f114471x && this.f114472y == scheduleDTO.f114472y && this.f114473z == scheduleDTO.f114473z && this.A == scheduleDTO.A && this.B == scheduleDTO.B && this.C == scheduleDTO.C && Intrinsics.areEqual(this.D, scheduleDTO.D);
    }

    public final boolean f() {
        return this.f114453f;
    }

    public final boolean g() {
        return this.f114454g;
    }

    public final boolean h() {
        return this.f114456i;
    }

    public int hashCode() {
        Long l3 = this.f114449a;
        int iHashCode = (((((((((((((((((((((l3 == null ? 0 : l3.hashCode()) * 31) + this.f114450b.hashCode()) * 31) + Boolean.hashCode(this.f114451c)) * 31) + Boolean.hashCode(this.f114452d)) * 31) + Boolean.hashCode(this.f114453f)) * 31) + Boolean.hashCode(this.f114454g)) * 31) + Boolean.hashCode(this.f114455h)) * 31) + Boolean.hashCode(this.f114456i)) * 31) + Integer.hashCode(this.f114457j)) * 31) + this.f114458k.hashCode()) * 31) + this.f114459l.hashCode()) * 31;
        ConditionDTO.LocationDTO locationDTO = this.f114460m;
        int iHashCode2 = (iHashCode + (locationDTO == null ? 0 : locationDTO.hashCode())) * 31;
        ConditionDTO.UsageLimitDTO usageLimitDTO = this.f114461n;
        int iHashCode3 = (iHashCode2 + (usageLimitDTO == null ? 0 : usageLimitDTO.hashCode())) * 31;
        ConditionDTO.LaunchCountDTO launchCountDTO = this.f114462o;
        int iHashCode4 = (iHashCode3 + (launchCountDTO == null ? 0 : launchCountDTO.hashCode())) * 31;
        ConditionDTO.TimeDTO timeDTO = this.f114463p;
        int iHashCode5 = (iHashCode4 + (timeDTO == null ? 0 : timeDTO.hashCode())) * 31;
        ConditionDTO.WifisDTO wifisDTO = this.f114464q;
        return ((((((((((((((((((((((((((iHashCode5 + (wifisDTO != null ? wifisDTO.hashCode() : 0)) * 31) + this.f114465r.hashCode()) * 31) + this.f114466s.hashCode()) * 31) + this.f114467t.hashCode()) * 31) + this.f114468u.hashCode()) * 31) + this.f114469v.hashCode()) * 31) + Boolean.hashCode(this.f114470w)) * 31) + Boolean.hashCode(this.f114471x)) * 31) + Boolean.hashCode(this.f114472y)) * 31) + Long.hashCode(this.f114473z)) * 31) + Long.hashCode(this.A)) * 31) + this.B.hashCode()) * 31) + Boolean.hashCode(this.C)) * 31) + this.D.hashCode();
    }

    public final boolean i() {
        return this.f114455h;
    }

    public final boolean j() {
        return this.f114452d;
    }

    public final Profile.BlockingMode k() {
        return this.f114458k;
    }

    public final List l() {
        return this.D;
    }

    public final ConditionDTO.CombinationDTO m() {
        return new ConditionDTO.CombinationDTO(SetsKt.setOfNotNull((Object[]) new ConditionDTO[]{this.f114460m, this.f114461n, this.f114462o, this.f114463p, this.f114464q}));
    }

    public final ScheduleEmoji n() {
        return this.B;
    }

    public final Long o() {
        return this.f114449a;
    }

    public final ArrayList p() {
        return this.f114467t;
    }

    public final ConditionDTO.LaunchCountDTO q() {
        return this.f114462o;
    }

    public final ConditionDTO.LocationDTO r() {
        return this.f114460m;
    }

    public final long s() {
        return this.A;
    }

    public final long t() {
        return this.f114473z;
    }

    public String toString() {
        return "ScheduleDTO(id=" + this.f114449a + ", title=" + this.f114450b + ", addNewApplications=" + this.f114451c + ", blockUnsupportedBrowsers=" + this.f114452d + ", blockAdultContent=" + this.f114453f + ", blockInAppPurchases=" + this.f114454g + ", blockNotifications=" + this.f114455h + ", blockLaunch=" + this.f114456i + ", typeCombinations=" + this.f114457j + ", blockingMode=" + this.f114458k + ", webBrowsingMode=" + this.f114459l + ", location=" + this.f114460m + ", usageLimit=" + this.f114461n + ", launchCount=" + this.f114462o + ", time=" + this.f114463p + ", wifis=" + this.f114464q + ", applications=" + this.f114465r + ", websites=" + this.f114466s + ", keywords=" + this.f114467t + ", selectedSubApps=" + this.f114468u + ", pausedUntil=" + this.f114469v + ", isFirstConditionSet=" + this.f114470w + ", isFirstBlockingSet=" + this.f114471x + ", isChargerLocked=" + this.f114472y + ", lockedByTimerUntil=" + this.f114473z + ", lockedByStrictModeFrom=" + this.A + ", emoji=" + this.B + ", isCurrentlyActive=" + this.C + ", categories=" + this.D + ")";
    }

    public final Profile.PausedUntil u() {
        return this.f114469v;
    }

    public final ProfileType v() {
        boolean z2;
        boolean z3;
        boolean z4;
        ProfileHelper profileHelper = ProfileHelper.f129250a;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = this.f114463p != null;
        if (this.f114460m != null) {
            z2 = false;
            z5 = true;
        } else {
            z2 = false;
        }
        if (this.f114464q != null) {
            z3 = true;
        } else {
            z3 = true;
            z6 = z2;
        }
        if (this.f114461n != null) {
            z4 = z2;
            z2 = z3;
        } else {
            z4 = z2;
        }
        if (this.f114462o == null) {
            z3 = z4;
        }
        return profileHelper.v(profileHelper.w(z7, z5, z6, z2, z3));
    }

    public final ArrayList w() {
        return this.f114468u;
    }

    public final ConditionDTO.TimeDTO x() {
        return this.f114463p;
    }

    public final String y() {
        return this.f114450b;
    }

    public final int z() {
        return this.f114457j;
    }

    public /* synthetic */ ScheduleDTO(Long l3, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i3, Profile.BlockingMode blockingMode, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, ConditionDTO.LocationDTO locationDTO, ConditionDTO.UsageLimitDTO usageLimitDTO, ConditionDTO.LaunchCountDTO launchCountDTO, ConditionDTO.TimeDTO timeDTO, ConditionDTO.WifisDTO wifisDTO, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Profile.PausedUntil pausedUntil, boolean z8, boolean z9, boolean z10, long j3, long j4, ScheduleEmoji scheduleEmoji, boolean z11, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Long l4;
        boolean z12;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        Long l5 = (i4 & 1) != 0 ? null : l3;
        String str2 = (i4 & 2) != 0 ? "" : str;
        boolean z13 = (i4 & 4) != 0 ? false : z2;
        boolean z14 = (i4 & 8) != 0 ? false : z3;
        boolean z15 = (i4 & 16) != 0 ? false : z4;
        boolean z16 = (i4 & 32) != 0 ? false : z5;
        boolean z17 = (i4 & 64) != 0 ? true : z6;
        boolean z18 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? z7 : true;
        int i5 = (i4 & Function.MAX_NARGS) != 0 ? 0 : i3;
        Profile.BlockingMode blockingMode2 = (i4 & 512) != 0 ? Profile.BlockingMode.Blocklist : blockingMode;
        Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode2 = (i4 & 1024) != 0 ? Profile.AllowlistWebBrowsingMode.Allowed : allowlistWebBrowsingMode;
        ConditionDTO.LocationDTO locationDTO2 = (i4 & 2048) != 0 ? null : locationDTO;
        ConditionDTO.UsageLimitDTO usageLimitDTO2 = (i4 & 4096) != 0 ? null : usageLimitDTO;
        ConditionDTO.LaunchCountDTO launchCountDTO2 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : launchCountDTO;
        ConditionDTO.TimeDTO timeDTO2 = (i4 & 16384) != 0 ? null : timeDTO;
        ConditionDTO.WifisDTO wifisDTO2 = (i4 & 32768) != 0 ? null : wifisDTO;
        if ((i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            l4 = l5;
            z12 = false;
            arrayList5 = new ArrayList(0);
        } else {
            l4 = l5;
            z12 = false;
            arrayList5 = arrayList;
        }
        ArrayList arrayList9 = arrayList5;
        if ((i4 & 131072) != 0) {
            arrayList6 = new ArrayList(z12 ? 1 : 0);
        } else {
            arrayList6 = arrayList2;
        }
        ArrayList arrayList10 = arrayList6;
        if ((i4 & 262144) != 0) {
            arrayList7 = new ArrayList(z12 ? 1 : 0);
        } else {
            arrayList7 = arrayList3;
        }
        ArrayList arrayList11 = arrayList7;
        if ((i4 & 524288) != 0) {
            arrayList8 = new ArrayList(z12 ? 1 : 0);
        } else {
            arrayList8 = arrayList4;
        }
        this(l4, str2, z13, z14, z15, z16, z17, z18, i5, blockingMode2, allowlistWebBrowsingMode2, locationDTO2, usageLimitDTO2, launchCountDTO2, timeDTO2, wifisDTO2, arrayList9, arrayList10, arrayList11, arrayList8, (i4 & 1048576) != 0 ? Profile.PausedUntil.NotPaused.f126480b : pausedUntil, (i4 & 2097152) != 0 ? z12 ? 1 : 0 : z8, (i4 & 4194304) != 0 ? z12 ? 1 : 0 : z9, (i4 & 8388608) != 0 ? z12 ? 1 : 0 : z10, (i4 & 16777216) != 0 ? 0L : j3, (i4 & 33554432) == 0 ? j4 : 0L, (i4 & 67108864) != 0 ? ScheduleEmoji.NoIcon : scheduleEmoji, (i4 & 134217728) == 0 ? z11 : z12, (i4 & 268435456) != 0 ? CollectionsKt.emptyList() : list);
    }
}
