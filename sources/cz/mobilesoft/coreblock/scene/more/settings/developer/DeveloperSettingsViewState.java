package cz.mobilesoft.coreblock.scene.more.settings.developer;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeveloperSettingsViewState implements ViewState {
    private final DevPrefState A;
    private final boolean B;
    private final boolean C;
    private final boolean D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private final boolean H;
    private final boolean I;
    private final boolean J;
    private final RatingDialogType K;
    private final InAppUpdatesMockSettingsDTO L;
    private final String M;
    private final boolean N;
    private final boolean O;
    private final String P;
    private final long Q;
    private final boolean R;
    private final boolean S;
    private final boolean T;
    private final boolean U;
    private final boolean V;
    private final boolean W;
    private final boolean X;
    private final boolean Y;
    private final DeveloperDialogType Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakDebugHelper.Snapshot f108976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f108977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f108978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f108979d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f108980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f108981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f108982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f108983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PremiumDevState f108984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RevenueCatOffering f108985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f108986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f108987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f108988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f108989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f108990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f108991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f108992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f108993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f108994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DevPrefState f108995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final DevPrefState f108996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final DevPrefState f108997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final DevPrefState f108998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final DevPrefState f108999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final DevPrefState f109000z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeveloperDialogType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeveloperDialogType[] $VALUES;
        public static final DeveloperDialogType ShowPremiumStateDialog = new DeveloperDialogType("ShowPremiumStateDialog", 0);
        public static final DeveloperDialogType ShowPremiumProductDialog = new DeveloperDialogType("ShowPremiumProductDialog", 1);
        public static final DeveloperDialogType ShowActivateCampaignDialog = new DeveloperDialogType("ShowActivateCampaignDialog", 2);
        public static final DeveloperDialogType ShowQuestionnaireDialog = new DeveloperDialogType("ShowQuestionnaireDialog", 3);
        public static final DeveloperDialogType ShowTimeChangeLimitDialog = new DeveloperDialogType("ShowTimeChangeLimitDialog", 4);
        public static final DeveloperDialogType ShowRemoteConfigMockDialog = new DeveloperDialogType("ShowRemoteConfigMockDialog", 5);
        public static final DeveloperDialogType ShowParseSupportJsonDialog = new DeveloperDialogType("ShowParseSupportJsonDialog", 6);
        public static final DeveloperDialogType ShowInAppUpdatesMockDialog = new DeveloperDialogType("ShowInAppUpdatesMockDialog", 7);
        public static final DeveloperDialogType ShowWhatsNewVersionsDialog = new DeveloperDialogType("ShowWhatsNewVersionsDialog", 8);
        public static final DeveloperDialogType ShowAdsDialog = new DeveloperDialogType("ShowAdsDialog", 9);
        public static final DeveloperDialogType ShowSkipDiscountTimerDialog = new DeveloperDialogType("ShowSkipDiscountTimerDialog", 10);
        public static final DeveloperDialogType ShowAllDiscountsDialog = new DeveloperDialogType("ShowAllDiscountsDialog", 11);
        public static final DeveloperDialogType ShowIntroDialog = new DeveloperDialogType("ShowIntroDialog", 12);
        public static final DeveloperDialogType ShowWhatsNewCard = new DeveloperDialogType("ShowWhatsNewCard", 13);
        public static final DeveloperDialogType ShowAniaInfoDialog = new DeveloperDialogType("ShowAniaInfoDialog", 14);
        public static final DeveloperDialogType OverridePaywallSettings = new DeveloperDialogType("OverridePaywallSettings", 15);
        public static final DeveloperDialogType ShowForceRatingDialogType = new DeveloperDialogType("ShowForceRatingDialogType", 16);
        public static final DeveloperDialogType ShowTestTargetingGroupDialog = new DeveloperDialogType("ShowTestTargetingGroupDialog", 17);
        public static final DeveloperDialogType ShowOnboardingFlowVariantDialog = new DeveloperDialogType("ShowOnboardingFlowVariantDialog", 18);
        public static final DeveloperDialogType ShowStreakSeedDialog = new DeveloperDialogType("ShowStreakSeedDialog", 19);

        private static final /* synthetic */ DeveloperDialogType[] $values() {
            return new DeveloperDialogType[]{ShowPremiumStateDialog, ShowPremiumProductDialog, ShowActivateCampaignDialog, ShowQuestionnaireDialog, ShowTimeChangeLimitDialog, ShowRemoteConfigMockDialog, ShowParseSupportJsonDialog, ShowInAppUpdatesMockDialog, ShowWhatsNewVersionsDialog, ShowAdsDialog, ShowSkipDiscountTimerDialog, ShowAllDiscountsDialog, ShowIntroDialog, ShowWhatsNewCard, ShowAniaInfoDialog, OverridePaywallSettings, ShowForceRatingDialogType, ShowTestTargetingGroupDialog, ShowOnboardingFlowVariantDialog, ShowStreakSeedDialog};
        }

        static {
            DeveloperDialogType[] developerDialogTypeArr$values = $values();
            $VALUES = developerDialogTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(developerDialogTypeArr$values);
        }

        private DeveloperDialogType(String str, int i3) {
        }

        public static EnumEntries<DeveloperDialogType> getEntries() {
            return $ENTRIES;
        }

        public static DeveloperDialogType valueOf(String str) {
            return (DeveloperDialogType) Enum.valueOf(DeveloperDialogType.class, str);
        }

        public static DeveloperDialogType[] values() {
            return (DeveloperDialogType[]) $VALUES.clone();
        }
    }

    public DeveloperSettingsViewState(StreakDebugHelper.Snapshot snapshot, String searchQuery, List allCategories, List filteredCategories, Set expandedCategoryIds, boolean z2, boolean z3, boolean z4, PremiumDevState premiumState, RevenueCatOffering revenueCatOffering, boolean z5, boolean z6, boolean z7, boolean z8, String testTargetingGroup, String str, String str2, String str3, boolean z9, DevPrefState showAdsState, DevPrefState skipDiscountTimerState, DevPrefState showAllDiscountsState, DevPrefState showIntroState, DevPrefState whatsNewCardState, DevPrefState showAniaInfoDialogState, DevPrefState overridePaywallSettings, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, RatingDialogType ratingDialogType, InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, String mockRemoteConfig, boolean z19, boolean z20, String questionnaireConfigJson, long j3, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, DeveloperDialogType developerDialogType) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(allCategories, "allCategories");
        Intrinsics.checkNotNullParameter(filteredCategories, "filteredCategories");
        Intrinsics.checkNotNullParameter(expandedCategoryIds, "expandedCategoryIds");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(testTargetingGroup, "testTargetingGroup");
        Intrinsics.checkNotNullParameter(showAdsState, "showAdsState");
        Intrinsics.checkNotNullParameter(skipDiscountTimerState, "skipDiscountTimerState");
        Intrinsics.checkNotNullParameter(showAllDiscountsState, "showAllDiscountsState");
        Intrinsics.checkNotNullParameter(showIntroState, "showIntroState");
        Intrinsics.checkNotNullParameter(whatsNewCardState, "whatsNewCardState");
        Intrinsics.checkNotNullParameter(showAniaInfoDialogState, "showAniaInfoDialogState");
        Intrinsics.checkNotNullParameter(overridePaywallSettings, "overridePaywallSettings");
        Intrinsics.checkNotNullParameter(mockRemoteConfig, "mockRemoteConfig");
        Intrinsics.checkNotNullParameter(questionnaireConfigJson, "questionnaireConfigJson");
        this.f108976a = snapshot;
        this.f108977b = searchQuery;
        this.f108978c = allCategories;
        this.f108979d = filteredCategories;
        this.f108980f = expandedCategoryIds;
        this.f108981g = z2;
        this.f108982h = z3;
        this.f108983i = z4;
        this.f108984j = premiumState;
        this.f108985k = revenueCatOffering;
        this.f108986l = z5;
        this.f108987m = z6;
        this.f108988n = z7;
        this.f108989o = z8;
        this.f108990p = testTargetingGroup;
        this.f108991q = str;
        this.f108992r = str2;
        this.f108993s = str3;
        this.f108994t = z9;
        this.f108995u = showAdsState;
        this.f108996v = skipDiscountTimerState;
        this.f108997w = showAllDiscountsState;
        this.f108998x = showIntroState;
        this.f108999y = whatsNewCardState;
        this.f109000z = showAniaInfoDialogState;
        this.A = overridePaywallSettings;
        this.B = z10;
        this.C = z11;
        this.D = z12;
        this.E = z13;
        this.F = z14;
        this.G = z15;
        this.H = z16;
        this.I = z17;
        this.J = z18;
        this.K = ratingDialogType;
        this.L = inAppUpdatesMockSettingsDTO;
        this.M = mockRemoteConfig;
        this.N = z19;
        this.O = z20;
        this.P = questionnaireConfigJson;
        this.Q = j3;
        this.R = z21;
        this.S = z22;
        this.T = z23;
        this.U = z24;
        this.V = z25;
        this.W = z26;
        this.X = z27;
        this.Y = z28;
        this.Z = developerDialogType;
    }

    public static /* synthetic */ DeveloperSettingsViewState b(DeveloperSettingsViewState developerSettingsViewState, StreakDebugHelper.Snapshot snapshot, String str, List list, List list2, Set set, boolean z2, boolean z3, boolean z4, PremiumDevState premiumDevState, RevenueCatOffering revenueCatOffering, boolean z5, boolean z6, boolean z7, boolean z8, String str2, String str3, String str4, String str5, boolean z9, DevPrefState devPrefState, DevPrefState devPrefState2, DevPrefState devPrefState3, DevPrefState devPrefState4, DevPrefState devPrefState5, DevPrefState devPrefState6, DevPrefState devPrefState7, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, RatingDialogType ratingDialogType, InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, String str6, boolean z19, boolean z20, String str7, long j3, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, DeveloperDialogType developerDialogType, int i3, int i4, Object obj) {
        String str8;
        String str9;
        long j4;
        StreakDebugHelper.Snapshot snapshot2 = (i3 & 1) != 0 ? developerSettingsViewState.f108976a : snapshot;
        String str10 = (i3 & 2) != 0 ? developerSettingsViewState.f108977b : str;
        List list3 = (i3 & 4) != 0 ? developerSettingsViewState.f108978c : list;
        List list4 = (i3 & 8) != 0 ? developerSettingsViewState.f108979d : list2;
        Set set2 = (i3 & 16) != 0 ? developerSettingsViewState.f108980f : set;
        boolean z29 = (i3 & 32) != 0 ? developerSettingsViewState.f108981g : z2;
        boolean z30 = (i3 & 64) != 0 ? developerSettingsViewState.f108982h : z3;
        boolean z31 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? developerSettingsViewState.f108983i : z4;
        PremiumDevState premiumDevState2 = (i3 & Function.MAX_NARGS) != 0 ? developerSettingsViewState.f108984j : premiumDevState;
        RevenueCatOffering revenueCatOffering2 = (i3 & 512) != 0 ? developerSettingsViewState.f108985k : revenueCatOffering;
        boolean z32 = (i3 & 1024) != 0 ? developerSettingsViewState.f108986l : z5;
        boolean z33 = (i3 & 2048) != 0 ? developerSettingsViewState.f108987m : z6;
        boolean z34 = (i3 & 4096) != 0 ? developerSettingsViewState.f108988n : z7;
        StreakDebugHelper.Snapshot snapshot3 = snapshot2;
        boolean z35 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? developerSettingsViewState.f108989o : z8;
        String str11 = (i3 & 16384) != 0 ? developerSettingsViewState.f108990p : str2;
        String str12 = (i3 & 32768) != 0 ? developerSettingsViewState.f108991q : str3;
        String str13 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? developerSettingsViewState.f108992r : str4;
        String str14 = (i3 & 131072) != 0 ? developerSettingsViewState.f108993s : str5;
        boolean z36 = (i3 & 262144) != 0 ? developerSettingsViewState.f108994t : z9;
        DevPrefState devPrefState8 = (i3 & 524288) != 0 ? developerSettingsViewState.f108995u : devPrefState;
        DevPrefState devPrefState9 = (i3 & 1048576) != 0 ? developerSettingsViewState.f108996v : devPrefState2;
        DevPrefState devPrefState10 = (i3 & 2097152) != 0 ? developerSettingsViewState.f108997w : devPrefState3;
        DevPrefState devPrefState11 = (i3 & 4194304) != 0 ? developerSettingsViewState.f108998x : devPrefState4;
        DevPrefState devPrefState12 = (i3 & 8388608) != 0 ? developerSettingsViewState.f108999y : devPrefState5;
        DevPrefState devPrefState13 = (i3 & 16777216) != 0 ? developerSettingsViewState.f109000z : devPrefState6;
        DevPrefState devPrefState14 = (i3 & 33554432) != 0 ? developerSettingsViewState.A : devPrefState7;
        boolean z37 = (i3 & 67108864) != 0 ? developerSettingsViewState.B : z10;
        boolean z38 = (i3 & 134217728) != 0 ? developerSettingsViewState.C : z11;
        boolean z39 = (i3 & 268435456) != 0 ? developerSettingsViewState.D : z12;
        boolean z40 = (i3 & 536870912) != 0 ? developerSettingsViewState.E : z13;
        boolean z41 = (i3 & 1073741824) != 0 ? developerSettingsViewState.F : z14;
        boolean z42 = (i3 & Integer.MIN_VALUE) != 0 ? developerSettingsViewState.G : z15;
        boolean z43 = (i4 & 1) != 0 ? developerSettingsViewState.H : z16;
        boolean z44 = (i4 & 2) != 0 ? developerSettingsViewState.I : z17;
        boolean z45 = (i4 & 4) != 0 ? developerSettingsViewState.J : z18;
        RatingDialogType ratingDialogType2 = (i4 & 8) != 0 ? developerSettingsViewState.K : ratingDialogType;
        InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO2 = (i4 & 16) != 0 ? developerSettingsViewState.L : inAppUpdatesMockSettingsDTO;
        String str15 = (i4 & 32) != 0 ? developerSettingsViewState.M : str6;
        boolean z46 = (i4 & 64) != 0 ? developerSettingsViewState.N : z19;
        boolean z47 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? developerSettingsViewState.O : z20;
        String str16 = (i4 & Function.MAX_NARGS) != 0 ? developerSettingsViewState.P : str7;
        if ((i4 & 512) != 0) {
            str8 = str11;
            str9 = str10;
            j4 = developerSettingsViewState.Q;
        } else {
            str8 = str11;
            str9 = str10;
            j4 = j3;
        }
        return developerSettingsViewState.a(snapshot3, str9, list3, list4, set2, z29, z30, z31, premiumDevState2, revenueCatOffering2, z32, z33, z34, z35, str8, str12, str13, str14, z36, devPrefState8, devPrefState9, devPrefState10, devPrefState11, devPrefState12, devPrefState13, devPrefState14, z37, z38, z39, z40, z41, z42, z43, z44, z45, ratingDialogType2, inAppUpdatesMockSettingsDTO2, str15, z46, z47, str16, j4, (i4 & 1024) != 0 ? developerSettingsViewState.R : z21, (i4 & 2048) != 0 ? developerSettingsViewState.S : z22, (i4 & 4096) != 0 ? developerSettingsViewState.T : z23, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? developerSettingsViewState.U : z24, (i4 & 16384) != 0 ? developerSettingsViewState.V : z25, (i4 & 32768) != 0 ? developerSettingsViewState.W : z26, (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? developerSettingsViewState.X : z27, (i4 & 131072) != 0 ? developerSettingsViewState.Y : z28, (i4 & 262144) != 0 ? developerSettingsViewState.Z : developerDialogType);
    }

    public final boolean A() {
        return this.I;
    }

    public final DevPrefState B() {
        return this.f108995u;
    }

    public final DevPrefState C() {
        return this.f108997w;
    }

    public final boolean D() {
        return this.D;
    }

    public final DevPrefState E() {
        return this.f109000z;
    }

    public final DevPrefState F() {
        return this.f108998x;
    }

    public final boolean G() {
        return this.B;
    }

    public final boolean H() {
        return this.E;
    }

    public final boolean I() {
        return this.F;
    }

    public final boolean J() {
        return this.f108988n;
    }

    public final boolean K() {
        return this.f108989o;
    }

    public final DevPrefState L() {
        return this.f108996v;
    }

    public final boolean M() {
        return this.f108983i;
    }

    public final StreakDebugHelper.Snapshot N() {
        return this.f108976a;
    }

    public final boolean O() {
        return this.X;
    }

    public final String P() {
        return this.f108990p;
    }

    public final long Q() {
        return this.Q;
    }

    public final boolean R() {
        return this.W;
    }

    public final boolean S() {
        return this.f108987m;
    }

    public final boolean T() {
        return this.J;
    }

    public final boolean U() {
        return this.C;
    }

    public final boolean V() {
        return this.f108981g;
    }

    public final DevPrefState W() {
        return this.f108999y;
    }

    public final boolean X() {
        return this.f108994t;
    }

    public final boolean Y() {
        return this.O;
    }

    public final boolean Z() {
        return this.f108982h;
    }

    public final DeveloperSettingsViewState a(StreakDebugHelper.Snapshot snapshot, String searchQuery, List allCategories, List filteredCategories, Set expandedCategoryIds, boolean z2, boolean z3, boolean z4, PremiumDevState premiumState, RevenueCatOffering revenueCatOffering, boolean z5, boolean z6, boolean z7, boolean z8, String testTargetingGroup, String str, String str2, String str3, boolean z9, DevPrefState showAdsState, DevPrefState skipDiscountTimerState, DevPrefState showAllDiscountsState, DevPrefState showIntroState, DevPrefState whatsNewCardState, DevPrefState showAniaInfoDialogState, DevPrefState overridePaywallSettings, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, RatingDialogType ratingDialogType, InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, String mockRemoteConfig, boolean z19, boolean z20, String questionnaireConfigJson, long j3, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, DeveloperDialogType developerDialogType) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(allCategories, "allCategories");
        Intrinsics.checkNotNullParameter(filteredCategories, "filteredCategories");
        Intrinsics.checkNotNullParameter(expandedCategoryIds, "expandedCategoryIds");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(testTargetingGroup, "testTargetingGroup");
        Intrinsics.checkNotNullParameter(showAdsState, "showAdsState");
        Intrinsics.checkNotNullParameter(skipDiscountTimerState, "skipDiscountTimerState");
        Intrinsics.checkNotNullParameter(showAllDiscountsState, "showAllDiscountsState");
        Intrinsics.checkNotNullParameter(showIntroState, "showIntroState");
        Intrinsics.checkNotNullParameter(whatsNewCardState, "whatsNewCardState");
        Intrinsics.checkNotNullParameter(showAniaInfoDialogState, "showAniaInfoDialogState");
        Intrinsics.checkNotNullParameter(overridePaywallSettings, "overridePaywallSettings");
        Intrinsics.checkNotNullParameter(mockRemoteConfig, "mockRemoteConfig");
        Intrinsics.checkNotNullParameter(questionnaireConfigJson, "questionnaireConfigJson");
        return new DeveloperSettingsViewState(snapshot, searchQuery, allCategories, filteredCategories, expandedCategoryIds, z2, z3, z4, premiumState, revenueCatOffering, z5, z6, z7, z8, testTargetingGroup, str, str2, str3, z9, showAdsState, skipDiscountTimerState, showAllDiscountsState, showIntroState, whatsNewCardState, showAniaInfoDialogState, overridePaywallSettings, z10, z11, z12, z13, z14, z15, z16, z17, z18, ratingDialogType, inAppUpdatesMockSettingsDTO, mockRemoteConfig, z19, z20, questionnaireConfigJson, j3, z21, z22, z23, z24, z25, z26, z27, z28, developerDialogType);
    }

    public final boolean a0() {
        return this.Y;
    }

    public final List c() {
        return this.f108978c;
    }

    public final boolean d() {
        return this.R;
    }

    public final boolean e() {
        return this.T;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeveloperSettingsViewState)) {
            return false;
        }
        DeveloperSettingsViewState developerSettingsViewState = (DeveloperSettingsViewState) obj;
        return Intrinsics.areEqual(this.f108976a, developerSettingsViewState.f108976a) && Intrinsics.areEqual(this.f108977b, developerSettingsViewState.f108977b) && Intrinsics.areEqual(this.f108978c, developerSettingsViewState.f108978c) && Intrinsics.areEqual(this.f108979d, developerSettingsViewState.f108979d) && Intrinsics.areEqual(this.f108980f, developerSettingsViewState.f108980f) && this.f108981g == developerSettingsViewState.f108981g && this.f108982h == developerSettingsViewState.f108982h && this.f108983i == developerSettingsViewState.f108983i && this.f108984j == developerSettingsViewState.f108984j && this.f108985k == developerSettingsViewState.f108985k && this.f108986l == developerSettingsViewState.f108986l && this.f108987m == developerSettingsViewState.f108987m && this.f108988n == developerSettingsViewState.f108988n && this.f108989o == developerSettingsViewState.f108989o && Intrinsics.areEqual(this.f108990p, developerSettingsViewState.f108990p) && Intrinsics.areEqual(this.f108991q, developerSettingsViewState.f108991q) && Intrinsics.areEqual(this.f108992r, developerSettingsViewState.f108992r) && Intrinsics.areEqual(this.f108993s, developerSettingsViewState.f108993s) && this.f108994t == developerSettingsViewState.f108994t && this.f108995u == developerSettingsViewState.f108995u && this.f108996v == developerSettingsViewState.f108996v && this.f108997w == developerSettingsViewState.f108997w && this.f108998x == developerSettingsViewState.f108998x && this.f108999y == developerSettingsViewState.f108999y && this.f109000z == developerSettingsViewState.f109000z && this.A == developerSettingsViewState.A && this.B == developerSettingsViewState.B && this.C == developerSettingsViewState.C && this.D == developerSettingsViewState.D && this.E == developerSettingsViewState.E && this.F == developerSettingsViewState.F && this.G == developerSettingsViewState.G && this.H == developerSettingsViewState.H && this.I == developerSettingsViewState.I && this.J == developerSettingsViewState.J && this.K == developerSettingsViewState.K && Intrinsics.areEqual(this.L, developerSettingsViewState.L) && Intrinsics.areEqual(this.M, developerSettingsViewState.M) && this.N == developerSettingsViewState.N && this.O == developerSettingsViewState.O && Intrinsics.areEqual(this.P, developerSettingsViewState.P) && this.Q == developerSettingsViewState.Q && this.R == developerSettingsViewState.R && this.S == developerSettingsViewState.S && this.T == developerSettingsViewState.T && this.U == developerSettingsViewState.U && this.V == developerSettingsViewState.V && this.W == developerSettingsViewState.W && this.X == developerSettingsViewState.X && this.Y == developerSettingsViewState.Y && this.Z == developerSettingsViewState.Z;
    }

    public final String f() {
        return this.f108993s;
    }

    public final DeveloperDialogType g() {
        return this.Z;
    }

    public final boolean h() {
        return this.S;
    }

    public int hashCode() {
        StreakDebugHelper.Snapshot snapshot = this.f108976a;
        int iHashCode = (((((((((((((((((snapshot == null ? 0 : snapshot.hashCode()) * 31) + this.f108977b.hashCode()) * 31) + this.f108978c.hashCode()) * 31) + this.f108979d.hashCode()) * 31) + this.f108980f.hashCode()) * 31) + Boolean.hashCode(this.f108981g)) * 31) + Boolean.hashCode(this.f108982h)) * 31) + Boolean.hashCode(this.f108983i)) * 31) + this.f108984j.hashCode()) * 31;
        RevenueCatOffering revenueCatOffering = this.f108985k;
        int iHashCode2 = (((((((((((iHashCode + (revenueCatOffering == null ? 0 : revenueCatOffering.hashCode())) * 31) + Boolean.hashCode(this.f108986l)) * 31) + Boolean.hashCode(this.f108987m)) * 31) + Boolean.hashCode(this.f108988n)) * 31) + Boolean.hashCode(this.f108989o)) * 31) + this.f108990p.hashCode()) * 31;
        String str = this.f108991q;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f108992r;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f108993s;
        int iHashCode5 = (((((((((((((((((((((((((((((((((((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.f108994t)) * 31) + this.f108995u.hashCode()) * 31) + this.f108996v.hashCode()) * 31) + this.f108997w.hashCode()) * 31) + this.f108998x.hashCode()) * 31) + this.f108999y.hashCode()) * 31) + this.f109000z.hashCode()) * 31) + this.A.hashCode()) * 31) + Boolean.hashCode(this.B)) * 31) + Boolean.hashCode(this.C)) * 31) + Boolean.hashCode(this.D)) * 31) + Boolean.hashCode(this.E)) * 31) + Boolean.hashCode(this.F)) * 31) + Boolean.hashCode(this.G)) * 31) + Boolean.hashCode(this.H)) * 31) + Boolean.hashCode(this.I)) * 31) + Boolean.hashCode(this.J)) * 31;
        RatingDialogType ratingDialogType = this.K;
        int iHashCode6 = (iHashCode5 + (ratingDialogType == null ? 0 : ratingDialogType.hashCode())) * 31;
        InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO = this.L;
        int iHashCode7 = (((((((((((((((((((((((((((iHashCode6 + (inAppUpdatesMockSettingsDTO == null ? 0 : inAppUpdatesMockSettingsDTO.hashCode())) * 31) + this.M.hashCode()) * 31) + Boolean.hashCode(this.N)) * 31) + Boolean.hashCode(this.O)) * 31) + this.P.hashCode()) * 31) + Long.hashCode(this.Q)) * 31) + Boolean.hashCode(this.R)) * 31) + Boolean.hashCode(this.S)) * 31) + Boolean.hashCode(this.T)) * 31) + Boolean.hashCode(this.U)) * 31) + Boolean.hashCode(this.V)) * 31) + Boolean.hashCode(this.W)) * 31) + Boolean.hashCode(this.X)) * 31) + Boolean.hashCode(this.Y)) * 31;
        DeveloperDialogType developerDialogType = this.Z;
        return iHashCode7 + (developerDialogType != null ? developerDialogType.hashCode() : 0);
    }

    public final Set i() {
        return this.f108980f;
    }

    public final String j() {
        return this.f108991q;
    }

    public final List k() {
        return this.f108979d;
    }

    public final boolean l() {
        return this.G;
    }

    public final boolean m() {
        return this.H;
    }

    public final RatingDialogType n() {
        return this.K;
    }

    public final InAppUpdatesMockSettingsDTO o() {
        return this.L;
    }

    public final boolean p() {
        return this.U;
    }

    public final String q() {
        return this.M;
    }

    public final boolean r() {
        return this.N;
    }

    public final boolean s() {
        return this.f108986l;
    }

    public final DevPrefState t() {
        return this.A;
    }

    public String toString() {
        return "DeveloperSettingsViewState(streakSnapshot=" + this.f108976a + ", searchQuery=" + this.f108977b + ", allCategories=" + this.f108978c + ", filteredCategories=" + this.f108979d + ", expandedCategoryIds=" + this.f108980f + ", useProductionServer=" + this.f108981g + ", isInternetEnabled=" + this.f108982h + ", speedUpTimers=" + this.f108983i + ", premiumState=" + this.f108984j + ", premiumProductState=" + this.f108985k + ", offerDeveloperLifetime=" + this.f108986l + ", trialAlwaysEligible=" + this.f108987m + ", simulateActiveTrial=" + this.f108988n + ", simulateBillingError=" + this.f108989o + ", testTargetingGroup=" + this.f108990p + ", fcmToken=" + this.f108991q + ", revenueCatId=" + this.f108992r + ", customerId=" + this.f108993s + ", isCustomerSignedIn=" + this.f108994t + ", showAdsState=" + this.f108995u + ", skipDiscountTimerState=" + this.f108996v + ", showAllDiscountsState=" + this.f108997w + ", showIntroState=" + this.f108998x + ", whatsNewCardState=" + this.f108999y + ", showAniaInfoDialogState=" + this.f109000z + ", overridePaywallSettings=" + this.A + ", showPirateVersionSheet=" + this.B + ", useNewPaywall=" + this.C + ", showAllTrendItems=" + this.D + ", showPremiumExpiring=" + this.E + ", showPremiumExpiringCards=" + this.F + ", forceAutoTrialExpired=" + this.G + ", forceAutoTrialExpiredCard=" + this.H + ", shortenAutoTrialWait=" + this.I + ", useFakeReviewManager=" + this.J + ", forceRatingDialogType=" + this.K + ", inAppUpdateMockSettings=" + this.L + ", mockRemoteConfig=" + this.M + ", mockTrialComparisonData=" + this.N + jlWo.BVZBelhy + this.O + ", questionnaireConfigJson=" + this.P + ", timeChangeLimit=" + this.Q + ", alwaysShowEmailConsent=" + this.R + ", disableBackdoorCodeCheck=" + this.S + ", alwaysValidateEmergencyString=" + this.T + ", logLockService=" + this.U + ", pomodoroInSeconds=" + this.V + ", timeNudgeShortIntervals=" + this.W + ", strictModePauseInSeconds=" + this.X + ", isLoading=" + this.Y + ", developerDialogType=" + this.Z + ")";
    }

    public final boolean u() {
        return this.V;
    }

    public final RevenueCatOffering v() {
        return this.f108985k;
    }

    public final PremiumDevState w() {
        return this.f108984j;
    }

    public final String x() {
        return this.P;
    }

    public final String y() {
        return this.f108992r;
    }

    public final String z() {
        return this.f108977b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeveloperSettingsViewState(StreakDebugHelper.Snapshot snapshot, String str, List list, List list2, Set set, boolean z2, boolean z3, boolean z4, PremiumDevState premiumDevState, RevenueCatOffering revenueCatOffering, boolean z5, boolean z6, boolean z7, boolean z8, String str2, String str3, String str4, String str5, boolean z9, DevPrefState devPrefState, DevPrefState devPrefState2, DevPrefState devPrefState3, DevPrefState devPrefState4, DevPrefState devPrefState5, DevPrefState devPrefState6, DevPrefState devPrefState7, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, RatingDialogType ratingDialogType, InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, String str6, boolean z19, boolean z20, String str7, long j3, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, DeveloperDialogType developerDialogType, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        StreakDebugHelper.Snapshot snapshot2 = (i3 & 1) != 0 ? null : snapshot;
        this(snapshot2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) != 0 ? SetsKt.emptySet() : set, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? true : z3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z4, (i3 & Function.MAX_NARGS) != 0 ? PremiumDevState.REAL_STATE : premiumDevState, (i3 & 512) != 0 ? null : revenueCatOffering, (i3 & 1024) != 0 ? false : z5, (i3 & 2048) != 0 ? false : z6, (i3 & 4096) != 0 ? false : z7, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z8, (i3 & 16384) != 0 ? "" : str2, (i3 & 32768) != 0 ? null : str3, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : str4, (i3 & 131072) != 0 ? null : str5, (i3 & 262144) != 0 ? false : z9, (i3 & 524288) != 0 ? DevPrefState.REAL : devPrefState, (i3 & 1048576) != 0 ? DevPrefState.REAL : devPrefState2, (i3 & 2097152) != 0 ? DevPrefState.REAL : devPrefState3, (i3 & 4194304) != 0 ? DevPrefState.REAL : devPrefState4, (i3 & 8388608) != 0 ? DevPrefState.REAL : devPrefState5, (i3 & 16777216) != 0 ? DevPrefState.REAL : devPrefState6, (i3 & 33554432) != 0 ? DevPrefState.REAL : devPrefState7, (i3 & 67108864) != 0 ? false : z10, (i3 & 134217728) != 0 ? false : z11, (i3 & 268435456) != 0 ? false : z12, (i3 & 536870912) != 0 ? false : z13, (i3 & 1073741824) != 0 ? false : z14, (i3 & Integer.MIN_VALUE) != 0 ? false : z15, (i4 & 1) != 0 ? false : z16, (i4 & 2) != 0 ? false : z17, (i4 & 4) != 0 ? false : z18, (i4 & 8) != 0 ? null : ratingDialogType, (i4 & 16) != 0 ? null : inAppUpdatesMockSettingsDTO, (i4 & 32) != 0 ? "" : str6, (i4 & 64) != 0 ? false : z19, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z20, (i4 & Function.MAX_NARGS) == 0 ? str7 : "", (i4 & 512) != 0 ? 0L : j3, (i4 & 1024) != 0 ? false : z21, (i4 & 2048) != 0 ? false : z22, (i4 & 4096) != 0 ? false : z23, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z24, (i4 & 16384) != 0 ? false : z25, (i4 & 32768) != 0 ? false : z26, (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z27, (i4 & 131072) != 0 ? false : z28, (i4 & 262144) != 0 ? null : developerDialogType);
    }
}
