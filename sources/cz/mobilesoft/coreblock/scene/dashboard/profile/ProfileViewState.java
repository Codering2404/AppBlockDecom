package cz.mobilesoft.coreblock.scene.dashboard.profile;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState;
import cz.mobilesoft.coreblock.scene.dashboard.profile.type.ProfileSectionItemType;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.util.SessionManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ProfileViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SessionManager.SignInState f101067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PremiumState f101068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f101069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f101070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f101071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f101072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f101073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f101074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f101075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Boolean f101076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f101077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f101078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f101079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f101080o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Integer f101081p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f101082q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f101083r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Long f101084s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AutoTrialVariant f101085t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f101086u;

    public ProfileViewState(SessionManager.SignInState signInState, PremiumState premiumState, List missingPermissions, boolean z2, boolean z3, List moreItems, List discoverItems, String str, String str2, Boolean bool, boolean z4, boolean z5, boolean z6, String str3, Integer num, boolean z7, String str4, Long l3, AutoTrialVariant autoTrialVariant, boolean z8) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(moreItems, "moreItems");
        Intrinsics.checkNotNullParameter(discoverItems, "discoverItems");
        Intrinsics.checkNotNullParameter(autoTrialVariant, "autoTrialVariant");
        this.f101067a = signInState;
        this.f101068b = premiumState;
        this.f101069c = missingPermissions;
        this.f101070d = z2;
        this.f101071f = z3;
        this.f101072g = moreItems;
        this.f101073h = discoverItems;
        this.f101074i = str;
        this.f101075j = str2;
        this.f101076k = bool;
        this.f101077l = z4;
        this.f101078m = z5;
        this.f101079n = z6;
        this.f101080o = str3;
        this.f101081p = num;
        this.f101082q = z7;
        this.f101083r = str4;
        this.f101084s = l3;
        this.f101085t = autoTrialVariant;
        this.f101086u = z8;
    }

    public static /* synthetic */ ProfileViewState b(ProfileViewState profileViewState, SessionManager.SignInState signInState, PremiumState premiumState, List list, boolean z2, boolean z3, List list2, List list3, String str, String str2, Boolean bool, boolean z4, boolean z5, boolean z6, String str3, Integer num, boolean z7, String str4, Long l3, AutoTrialVariant autoTrialVariant, boolean z8, int i3, Object obj) {
        boolean z9;
        AutoTrialVariant autoTrialVariant2;
        SessionManager.SignInState signInState2 = (i3 & 1) != 0 ? profileViewState.f101067a : signInState;
        PremiumState premiumState2 = (i3 & 2) != 0 ? profileViewState.f101068b : premiumState;
        List list4 = (i3 & 4) != 0 ? profileViewState.f101069c : list;
        boolean z10 = (i3 & 8) != 0 ? profileViewState.f101070d : z2;
        boolean z11 = (i3 & 16) != 0 ? profileViewState.f101071f : z3;
        List list5 = (i3 & 32) != 0 ? profileViewState.f101072g : list2;
        List list6 = (i3 & 64) != 0 ? profileViewState.f101073h : list3;
        String str5 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? profileViewState.f101074i : str;
        String str6 = (i3 & Function.MAX_NARGS) != 0 ? profileViewState.f101075j : str2;
        Boolean bool2 = (i3 & 512) != 0 ? profileViewState.f101076k : bool;
        boolean z12 = (i3 & 1024) != 0 ? profileViewState.f101077l : z4;
        boolean z13 = (i3 & 2048) != 0 ? profileViewState.f101078m : z5;
        boolean z14 = (i3 & 4096) != 0 ? profileViewState.f101079n : z6;
        String str7 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? profileViewState.f101080o : str3;
        SessionManager.SignInState signInState3 = signInState2;
        Integer num2 = (i3 & 16384) != 0 ? profileViewState.f101081p : num;
        boolean z15 = (i3 & 32768) != 0 ? profileViewState.f101082q : z7;
        String str8 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? profileViewState.f101083r : str4;
        Long l4 = (i3 & 131072) != 0 ? profileViewState.f101084s : l3;
        AutoTrialVariant autoTrialVariant3 = (i3 & 262144) != 0 ? profileViewState.f101085t : autoTrialVariant;
        if ((i3 & 524288) != 0) {
            autoTrialVariant2 = autoTrialVariant3;
            z9 = profileViewState.f101086u;
        } else {
            z9 = z8;
            autoTrialVariant2 = autoTrialVariant3;
        }
        return profileViewState.a(signInState3, premiumState2, list4, z10, z11, list5, list6, str5, str6, bool2, z12, z13, z14, str7, num2, z15, str8, l4, autoTrialVariant2, z9);
    }

    public final ProfileViewState a(SessionManager.SignInState signInState, PremiumState premiumState, List missingPermissions, boolean z2, boolean z3, List moreItems, List discoverItems, String str, String str2, Boolean bool, boolean z4, boolean z5, boolean z6, String str3, Integer num, boolean z7, String str4, Long l3, AutoTrialVariant autoTrialVariant, boolean z8) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(moreItems, "moreItems");
        Intrinsics.checkNotNullParameter(discoverItems, "discoverItems");
        Intrinsics.checkNotNullParameter(autoTrialVariant, "autoTrialVariant");
        return new ProfileViewState(signInState, premiumState, missingPermissions, z2, z3, moreItems, discoverItems, str, str2, bool, z4, z5, z6, str3, num, z7, str4, l3, autoTrialVariant, z8);
    }

    public final boolean c() {
        return this.f101086u;
    }

    public final Long d() {
        return this.f101084s;
    }

    public final AutoTrialVariant e() {
        return this.f101085t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileViewState)) {
            return false;
        }
        ProfileViewState profileViewState = (ProfileViewState) obj;
        return Intrinsics.areEqual(this.f101067a, profileViewState.f101067a) && Intrinsics.areEqual(this.f101068b, profileViewState.f101068b) && Intrinsics.areEqual(this.f101069c, profileViewState.f101069c) && this.f101070d == profileViewState.f101070d && this.f101071f == profileViewState.f101071f && Intrinsics.areEqual(this.f101072g, profileViewState.f101072g) && Intrinsics.areEqual(this.f101073h, profileViewState.f101073h) && Intrinsics.areEqual(this.f101074i, profileViewState.f101074i) && Intrinsics.areEqual(this.f101075j, profileViewState.f101075j) && Intrinsics.areEqual(this.f101076k, profileViewState.f101076k) && this.f101077l == profileViewState.f101077l && this.f101078m == profileViewState.f101078m && this.f101079n == profileViewState.f101079n && Intrinsics.areEqual(this.f101080o, profileViewState.f101080o) && Intrinsics.areEqual(this.f101081p, profileViewState.f101081p) && this.f101082q == profileViewState.f101082q && Intrinsics.areEqual(this.f101083r, profileViewState.f101083r) && Intrinsics.areEqual(this.f101084s, profileViewState.f101084s) && this.f101085t == profileViewState.f101085t && this.f101086u == profileViewState.f101086u;
    }

    public final Integer f() {
        return this.f101081p;
    }

    public final List g() {
        return this.f101073h;
    }

    public final boolean h() {
        return this.f101071f;
    }

    public int hashCode() {
        SessionManager.SignInState signInState = this.f101067a;
        int iHashCode = (((((((((((((signInState == null ? 0 : signInState.hashCode()) * 31) + this.f101068b.hashCode()) * 31) + this.f101069c.hashCode()) * 31) + Boolean.hashCode(this.f101070d)) * 31) + Boolean.hashCode(this.f101071f)) * 31) + this.f101072g.hashCode()) * 31) + this.f101073h.hashCode()) * 31;
        String str = this.f101074i;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f101075j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.f101076k;
        int iHashCode4 = (((((((iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.f101077l)) * 31) + Boolean.hashCode(this.f101078m)) * 31) + Boolean.hashCode(this.f101079n)) * 31;
        String str3 = this.f101080o;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f101081p;
        int iHashCode6 = (((iHashCode5 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.f101082q)) * 31;
        String str4 = this.f101083r;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l3 = this.f101084s;
        return ((((iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31) + this.f101085t.hashCode()) * 31) + Boolean.hashCode(this.f101086u);
    }

    public final List i() {
        return this.f101069c;
    }

    public final List j() {
        return this.f101072g;
    }

    public final boolean k() {
        return this.f101079n;
    }

    public final String l() {
        SessionManager.SignInState signInState = this.f101067a;
        SessionManager.SignedIn signedIn = signInState instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) signInState : null;
        if (signedIn != null) {
            return signedIn.b();
        }
        return null;
    }

    public final PremiumState m() {
        return this.f101068b;
    }

    public final String n() {
        return this.f101074i;
    }

    public final AccountDetailViewState.ProfileImageState o() {
        SessionManager.SignInState signInState = this.f101067a;
        SessionManager.SignedIn signedIn = signInState instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) signInState : null;
        return new AccountDetailViewState.ProfileImageState.Server(signedIn != null ? signedIn.f() : null);
    }

    public final boolean p() {
        return this.f101070d;
    }

    public final String q() {
        SessionManager.SignInState signInState = this.f101067a;
        SessionManager.SignedIn signedIn = signInState instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) signInState : null;
        if (signedIn != null) {
            return signedIn.g();
        }
        return null;
    }

    public final boolean r() {
        return this.f101078m;
    }

    public final boolean s() {
        return this.f101077l;
    }

    public final SessionManager.SignInState t() {
        return this.f101067a;
    }

    public String toString() {
        return "ProfileViewState(signInState=" + this.f101067a + ", premiumState=" + this.f101068b + ", missingPermissions=" + this.f101069c + ", referralsAvailable=" + this.f101070d + ", installedFromLegitimateSource=" + this.f101071f + ", moreItems=" + this.f101072g + ", discoverItems=" + this.f101073h + ", prevWeekAvg=" + this.f101074i + ", todayAvg=" + this.f101075j + ", isStatsImproved=" + this.f101076k + ", showPremiumExpiringCard=" + this.f101077l + ", showAdsRelevance=" + this.f101078m + ", newWeeklyInsightsAvailable=" + this.f101079n + ", premiumExpiryDate=" + this.f101080o + ", daysLeftInPremium=" + this.f101081p + ", isTrialEligible=" + this.f101082q + ", yearlySavingsText=" + this.f101083r + ", autoTrialRemainingMillis=" + this.f101084s + ", autoTrialVariant=" + this.f101085t + ", autoTrialExpired=" + this.f101086u + ")";
    }

    public final String u() {
        return this.f101075j;
    }

    public final String v() {
        return this.f101083r;
    }

    public final boolean w() {
        return this.f101067a instanceof SessionManager.SignedIn;
    }

    public final Boolean x() {
        return this.f101076k;
    }

    public final boolean y() {
        return this.f101082q;
    }

    public /* synthetic */ ProfileViewState(SessionManager.SignInState signInState, PremiumState premiumState, List list, boolean z2, boolean z3, List list2, List list3, String str, String str2, Boolean bool, boolean z4, boolean z5, boolean z6, String str3, Integer num, boolean z7, String str4, Long l3, AutoTrialVariant autoTrialVariant, boolean z8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : signInState, (i3 & 2) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? true : z2, z3, (i3 & 32) != 0 ? ExtensionsKt.a() : list2, (i3 & 64) != 0 ? CollectionsKt.listOf((Object[]) new ProfileSectionItemType[]{ProfileSectionItemType.MacOsxApp, ProfileSectionItemType.DiscordCommunity, ProfileSectionItemType.Academy}) : list3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str, (i3 & Function.MAX_NARGS) != 0 ? null : str2, (i3 & 512) != 0 ? null : bool, (i3 & 1024) != 0 ? false : z4, (i3 & 2048) != 0 ? false : z5, (i3 & 4096) != 0 ? true : z6, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str3, (i3 & 16384) != 0 ? null : num, (32768 & i3) != 0 ? false : z7, (65536 & i3) != 0 ? null : str4, (131072 & i3) != 0 ? null : l3, (262144 & i3) != 0 ? AutoTrialVariant.Off : autoTrialVariant, (i3 & 524288) != 0 ? false : z8);
    }
}
