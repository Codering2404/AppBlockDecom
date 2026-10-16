package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
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
public final class ProfileViewDTO implements Serializable {
    private final Profile.PausedUntil A;
    private final ScheduleEmoji B;
    private final boolean C;
    private final boolean D;
    private final boolean E;
    private final boolean F;
    private final Boolean G;
    private final Boolean H;
    private final ProfileType I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f99952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f99953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f99954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Profile.BlockingMode f99955d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f99956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f99957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Long f99958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f99959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f99960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f99961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f99962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f99963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f99964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f99965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f99966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Integer f99967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f99968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f99969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f99970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f99971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f99972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f99973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f99974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final boolean f99975y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f99976z;

    public ProfileViewDTO(long j3, boolean z2, String title, Profile.BlockingMode blockingMode, boolean z3, boolean z4, Long l3, boolean z5, boolean z6, boolean z7, boolean z8, List applications, List webs, List selectedCategories, List subApps, Integer num, String str, String str2, String str3, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Profile.PausedUntil pausedUntil, ScheduleEmoji emojiIcon, boolean z15, boolean z16, boolean z17, boolean z18, Boolean bool, Boolean bool2, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(webs, "webs");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(emojiIcon, "emojiIcon");
        this.f99952a = j3;
        this.f99953b = z2;
        this.f99954c = title;
        this.f99955d = blockingMode;
        this.f99956f = z3;
        this.f99957g = z4;
        this.f99958h = l3;
        this.f99959i = z5;
        this.f99960j = z6;
        this.f99961k = z7;
        this.f99962l = z8;
        this.f99963m = applications;
        this.f99964n = webs;
        this.f99965o = selectedCategories;
        this.f99966p = subApps;
        this.f99967q = num;
        this.f99968r = str;
        this.f99969s = str2;
        this.f99970t = str3;
        this.f99971u = z9;
        this.f99972v = z10;
        this.f99973w = z11;
        this.f99974x = z12;
        this.f99975y = z13;
        this.f99976z = z14;
        this.A = pausedUntil;
        this.B = emojiIcon;
        this.C = z15;
        this.D = z16;
        this.E = z17;
        this.F = z18;
        this.G = bool;
        this.H = bool2;
        this.I = profileType;
    }

    public static /* synthetic */ ProfileViewDTO b(ProfileViewDTO profileViewDTO, long j3, boolean z2, String str, Profile.BlockingMode blockingMode, boolean z3, boolean z4, Long l3, boolean z5, boolean z6, boolean z7, boolean z8, List list, List list2, List list3, List list4, Integer num, String str2, String str3, String str4, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Profile.PausedUntil pausedUntil, ScheduleEmoji scheduleEmoji, boolean z15, boolean z16, boolean z17, boolean z18, Boolean bool, Boolean bool2, ProfileType profileType, int i3, int i4, Object obj) {
        ProfileType profileType2;
        Boolean bool3;
        Integer num2;
        String str5;
        String str6;
        String str7;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        Profile.PausedUntil pausedUntil2;
        ScheduleEmoji scheduleEmoji2;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        Boolean bool4;
        ProfileViewDTO profileViewDTO2;
        List list5;
        List list6;
        boolean z29;
        String str8;
        Profile.BlockingMode blockingMode2;
        boolean z30;
        boolean z31;
        Long l4;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        List list7;
        List list8;
        long j4;
        long j5 = (i3 & 1) != 0 ? profileViewDTO.f99952a : j3;
        boolean z36 = (i3 & 2) != 0 ? profileViewDTO.f99953b : z2;
        String str9 = (i3 & 4) != 0 ? profileViewDTO.f99954c : str;
        Profile.BlockingMode blockingMode3 = (i3 & 8) != 0 ? profileViewDTO.f99955d : blockingMode;
        boolean z37 = (i3 & 16) != 0 ? profileViewDTO.f99956f : z3;
        boolean z38 = (i3 & 32) != 0 ? profileViewDTO.f99957g : z4;
        Long l5 = (i3 & 64) != 0 ? profileViewDTO.f99958h : l3;
        boolean z39 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? profileViewDTO.f99959i : z5;
        boolean z40 = (i3 & Function.MAX_NARGS) != 0 ? profileViewDTO.f99960j : z6;
        boolean z41 = (i3 & 512) != 0 ? profileViewDTO.f99961k : z7;
        boolean z42 = (i3 & 1024) != 0 ? profileViewDTO.f99962l : z8;
        List list9 = (i3 & 2048) != 0 ? profileViewDTO.f99963m : list;
        List list10 = (i3 & 4096) != 0 ? profileViewDTO.f99964n : list2;
        long j6 = j5;
        List list11 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? profileViewDTO.f99965o : list3;
        List list12 = (i3 & 16384) != 0 ? profileViewDTO.f99966p : list4;
        Integer num3 = (i3 & 32768) != 0 ? profileViewDTO.f99967q : num;
        String str10 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? profileViewDTO.f99968r : str2;
        String str11 = (i3 & 131072) != 0 ? profileViewDTO.f99969s : str3;
        String str12 = (i3 & 262144) != 0 ? profileViewDTO.f99970t : str4;
        boolean z43 = (i3 & 524288) != 0 ? profileViewDTO.f99971u : z9;
        boolean z44 = (i3 & 1048576) != 0 ? profileViewDTO.f99972v : z10;
        boolean z45 = (i3 & 2097152) != 0 ? profileViewDTO.f99973w : z11;
        boolean z46 = (i3 & 4194304) != 0 ? profileViewDTO.f99974x : z12;
        boolean z47 = (i3 & 8388608) != 0 ? profileViewDTO.f99975y : z13;
        boolean z48 = (i3 & 16777216) != 0 ? profileViewDTO.f99976z : z14;
        Profile.PausedUntil pausedUntil3 = (i3 & 33554432) != 0 ? profileViewDTO.A : pausedUntil;
        ScheduleEmoji scheduleEmoji3 = (i3 & 67108864) != 0 ? profileViewDTO.B : scheduleEmoji;
        boolean z49 = (i3 & 134217728) != 0 ? profileViewDTO.C : z15;
        boolean z50 = (i3 & 268435456) != 0 ? profileViewDTO.D : z16;
        boolean z51 = (i3 & 536870912) != 0 ? profileViewDTO.E : z17;
        boolean z52 = (i3 & 1073741824) != 0 ? profileViewDTO.F : z18;
        Boolean bool5 = (i3 & Integer.MIN_VALUE) != 0 ? profileViewDTO.G : bool;
        Boolean bool6 = (i4 & 1) != 0 ? profileViewDTO.H : bool2;
        if ((i4 & 2) != 0) {
            bool3 = bool6;
            profileType2 = profileViewDTO.I;
            str5 = str10;
            str6 = str11;
            str7 = str12;
            z19 = z43;
            z20 = z44;
            z21 = z45;
            z22 = z46;
            z23 = z47;
            z24 = z48;
            pausedUntil2 = pausedUntil3;
            scheduleEmoji2 = scheduleEmoji3;
            z25 = z49;
            z26 = z50;
            z27 = z51;
            z28 = z52;
            bool4 = bool5;
            list5 = list11;
            list6 = list12;
            z29 = z36;
            str8 = str9;
            blockingMode2 = blockingMode3;
            z30 = z37;
            z31 = z38;
            l4 = l5;
            z32 = z39;
            z33 = z40;
            z34 = z41;
            z35 = z42;
            list7 = list9;
            list8 = list10;
            j4 = j6;
            num2 = num3;
            profileViewDTO2 = profileViewDTO;
        } else {
            profileType2 = profileType;
            bool3 = bool6;
            num2 = num3;
            str5 = str10;
            str6 = str11;
            str7 = str12;
            z19 = z43;
            z20 = z44;
            z21 = z45;
            z22 = z46;
            z23 = z47;
            z24 = z48;
            pausedUntil2 = pausedUntil3;
            scheduleEmoji2 = scheduleEmoji3;
            z25 = z49;
            z26 = z50;
            z27 = z51;
            z28 = z52;
            bool4 = bool5;
            profileViewDTO2 = profileViewDTO;
            list5 = list11;
            list6 = list12;
            z29 = z36;
            str8 = str9;
            blockingMode2 = blockingMode3;
            z30 = z37;
            z31 = z38;
            l4 = l5;
            z32 = z39;
            z33 = z40;
            z34 = z41;
            z35 = z42;
            list7 = list9;
            list8 = list10;
            j4 = j6;
        }
        return profileViewDTO2.a(j4, z29, str8, blockingMode2, z30, z31, l4, z32, z33, z34, z35, list7, list8, list5, list6, num2, str5, str6, str7, z19, z20, z21, z22, z23, z24, pausedUntil2, scheduleEmoji2, z25, z26, z27, z28, bool4, bool3, profileType2);
    }

    public final boolean A() {
        return this.f99973w;
    }

    public final boolean B() {
        return (this.A instanceof Profile.PausedUntil.DisabledByUser) || C();
    }

    public final boolean C() {
        return this.A instanceof Profile.PausedUntil.DisabledByPremium;
    }

    public final boolean D() {
        return this.f99960j;
    }

    public final boolean E() {
        return this.f99976z;
    }

    public final boolean F() {
        return this.f99961k || this.f99962l;
    }

    public final boolean G() {
        return this.f99962l;
    }

    public final boolean H() {
        return this.f99971u;
    }

    public final boolean I() {
        return this.f99972v;
    }

    public final boolean J() {
        return this.f99961k;
    }

    public final boolean K() {
        return this.f99959i;
    }

    public final boolean L() {
        return this.f99975y;
    }

    public final Long M() {
        return this.f99958h;
    }

    public final boolean N() {
        return this.f99953b;
    }

    public final ProfileViewDTO a(long j3, boolean z2, String title, Profile.BlockingMode blockingMode, boolean z3, boolean z4, Long l3, boolean z5, boolean z6, boolean z7, boolean z8, List applications, List webs, List selectedCategories, List subApps, Integer num, String str, String str2, String str3, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Profile.PausedUntil pausedUntil, ScheduleEmoji emojiIcon, boolean z15, boolean z16, boolean z17, boolean z18, Boolean bool, Boolean bool2, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(webs, "webs");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        Intrinsics.checkNotNullParameter(emojiIcon, "emojiIcon");
        return new ProfileViewDTO(j3, z2, title, blockingMode, z3, z4, l3, z5, z6, z7, z8, applications, webs, selectedCategories, subApps, num, str, str2, str3, z9, z10, z11, z12, z13, z14, pausedUntil, emojiIcon, z15, z16, z17, z18, bool, bool2, profileType);
    }

    public final boolean c() {
        return this.C;
    }

    public final List d() {
        return this.f99963m;
    }

    public final boolean e() {
        return this.E;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileViewDTO)) {
            return false;
        }
        ProfileViewDTO profileViewDTO = (ProfileViewDTO) obj;
        return this.f99952a == profileViewDTO.f99952a && this.f99953b == profileViewDTO.f99953b && Intrinsics.areEqual(this.f99954c, profileViewDTO.f99954c) && this.f99955d == profileViewDTO.f99955d && this.f99956f == profileViewDTO.f99956f && this.f99957g == profileViewDTO.f99957g && Intrinsics.areEqual(this.f99958h, profileViewDTO.f99958h) && this.f99959i == profileViewDTO.f99959i && this.f99960j == profileViewDTO.f99960j && this.f99961k == profileViewDTO.f99961k && this.f99962l == profileViewDTO.f99962l && Intrinsics.areEqual(this.f99963m, profileViewDTO.f99963m) && Intrinsics.areEqual(this.f99964n, profileViewDTO.f99964n) && Intrinsics.areEqual(this.f99965o, profileViewDTO.f99965o) && Intrinsics.areEqual(this.f99966p, profileViewDTO.f99966p) && Intrinsics.areEqual(this.f99967q, profileViewDTO.f99967q) && Intrinsics.areEqual(this.f99968r, profileViewDTO.f99968r) && Intrinsics.areEqual(this.f99969s, profileViewDTO.f99969s) && Intrinsics.areEqual(this.f99970t, profileViewDTO.f99970t) && this.f99971u == profileViewDTO.f99971u && this.f99972v == profileViewDTO.f99972v && this.f99973w == profileViewDTO.f99973w && this.f99974x == profileViewDTO.f99974x && this.f99975y == profileViewDTO.f99975y && this.f99976z == profileViewDTO.f99976z && Intrinsics.areEqual(this.A, profileViewDTO.A) && this.B == profileViewDTO.B && this.C == profileViewDTO.C && this.D == profileViewDTO.D && this.E == profileViewDTO.E && this.F == profileViewDTO.F && Intrinsics.areEqual(this.G, profileViewDTO.G) && Intrinsics.areEqual(this.H, profileViewDTO.H) && this.I == profileViewDTO.I;
    }

    public final boolean f() {
        return this.F;
    }

    public final boolean g() {
        return this.D;
    }

    public final Profile.BlockingMode h() {
        return this.f99955d;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.f99952a) * 31) + Boolean.hashCode(this.f99953b)) * 31) + this.f99954c.hashCode()) * 31) + this.f99955d.hashCode()) * 31) + Boolean.hashCode(this.f99956f)) * 31) + Boolean.hashCode(this.f99957g)) * 31;
        Long l3 = this.f99958h;
        int iHashCode2 = (((((((((((((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f99959i)) * 31) + Boolean.hashCode(this.f99960j)) * 31) + Boolean.hashCode(this.f99961k)) * 31) + Boolean.hashCode(this.f99962l)) * 31) + this.f99963m.hashCode()) * 31) + this.f99964n.hashCode()) * 31) + this.f99965o.hashCode()) * 31) + this.f99966p.hashCode()) * 31;
        Integer num = this.f99967q;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f99968r;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f99969s;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f99970t;
        int iHashCode6 = (((((((((((((((((((((((((iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.f99971u)) * 31) + Boolean.hashCode(this.f99972v)) * 31) + Boolean.hashCode(this.f99973w)) * 31) + Boolean.hashCode(this.f99974x)) * 31) + Boolean.hashCode(this.f99975y)) * 31) + Boolean.hashCode(this.f99976z)) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + Boolean.hashCode(this.C)) * 31) + Boolean.hashCode(this.D)) * 31) + Boolean.hashCode(this.E)) * 31) + Boolean.hashCode(this.F)) * 31;
        Boolean bool = this.G;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.H;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ProfileType profileType = this.I;
        return iHashCode8 + (profileType != null ? profileType.hashCode() : 0);
    }

    public final ScheduleEmoji i() {
        return this.B;
    }

    public final boolean j() {
        return this.f99974x;
    }

    public final long k() {
        return this.f99952a;
    }

    public final Profile.PausedUntil l() {
        return this.A;
    }

    public final List m() {
        return this.f99965o;
    }

    public final boolean n() {
        if (this.I == ProfileType.USAGE_LIMIT && Intrinsics.areEqual(this.G, Boolean.FALSE)) {
            return true;
        }
        return (this.I == ProfileType.LAUNCH_COUNT && Intrinsics.areEqual(this.H, Boolean.FALSE)) || w();
    }

    public final String o() {
        return this.f99969s;
    }

    public final Integer p() {
        return this.f99967q;
    }

    public final String q() {
        return this.f99970t;
    }

    public final String r() {
        return this.f99968r;
    }

    public final List s() {
        return this.f99966p;
    }

    public final String t() {
        String str;
        String str2 = this.f99969s;
        return (str2 == null || (str = this.f99970t) == null) ? str2 == null ? this.f99970t : str2 : StringHelperExtKt.p(str2, str, ", ");
    }

    public String toString() {
        return "ProfileViewDTO(id=" + this.f99952a + ", isQuickBlock=" + this.f99953b + ", title=" + this.f99954c + ", blockingMode=" + this.f99955d + ", isCurrentlyOn=" + this.f99956f + ", isCurrentlyOnIgnoringPause=" + this.f99957g + ", isOnTemporarilyUntil=" + this.f99958h + ", isMissingPermissions=" + this.f99959i + ", isExceedingLimits=" + this.f99960j + ", isLockedNotByStrictMode=" + this.f99961k + ", isLockedByStrictMode=" + this.f99962l + ", applications=" + this.f99963m + ", webs=" + this.f99964n + ", selectedCategories=" + this.f99965o + ", subApps=" + this.f99966p + ", stateIconResId=" + this.f99967q + ", stateTitle=" + this.f99968r + ", stateFirstLine=" + this.f99969s + ", stateSecondLine=" + this.f99970t + ", isLockedForSelecting=" + this.f99971u + ", isLockedForUnselecting=" + this.f99972v + ", isDetailOpeningEnabled=" + this.f99973w + ", hasPremiumFeature=" + this.f99974x + ", isMoreButtonHidden=" + this.f99975y + ", isForSelection=" + this.f99976z + ", pausedUntil=" + this.A + ", emojiIcon=" + this.B + ", addNewApps=" + this.C + ", blockUnsupportedBrowsers=" + this.D + ", blockAdultContent=" + this.E + ", blockInAppPurchases=" + this.F + ", isUsageTimeLimitReached=" + this.G + ", isLaunchCountLimitReached=" + this.H + ", mainProfileType=" + this.I + ")";
    }

    public final String u() {
        return this.f99954c;
    }

    public final List v() {
        return this.f99964n;
    }

    public final boolean w() {
        if (this.I != ProfileType.COMBINED) {
            return false;
        }
        Boolean bool = this.G;
        Boolean bool2 = Boolean.TRUE;
        return (Intrinsics.areEqual(bool, bool2) || Intrinsics.areEqual(this.H, bool2)) ? false : true;
    }

    public final boolean x() {
        return this.f99956f;
    }

    public final boolean y() {
        return this.f99957g;
    }

    public final boolean z() {
        return B() || this.A.a() > TimeHelperExt.f128663a.f();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ProfileViewDTO(long r39, boolean r41, java.lang.String r42, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.BlockingMode r43, boolean r44, boolean r45, java.lang.Long r46, boolean r47, boolean r48, boolean r49, boolean r50, java.util.List r51, java.util.List r52, java.util.List r53, java.util.List r54, java.lang.Integer r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, boolean r59, boolean r60, boolean r61, boolean r62, boolean r63, boolean r64, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.PausedUntil r65, cz.mobilesoft.coreblock.enums.ScheduleEmoji r66, boolean r67, boolean r68, boolean r69, boolean r70, java.lang.Boolean r71, java.lang.Boolean r72, cz.mobilesoft.coreblock.enums.ProfileType r73, int r74, int r75, kotlin.jvm.internal.DefaultConstructorMarker r76) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO.<init>(long, boolean, java.lang.String, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode, boolean, boolean, java.lang.Long, boolean, boolean, boolean, boolean, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$PausedUntil, cz.mobilesoft.coreblock.enums.ScheduleEmoji, boolean, boolean, boolean, boolean, java.lang.Boolean, java.lang.Boolean, cz.mobilesoft.coreblock.enums.ProfileType, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
