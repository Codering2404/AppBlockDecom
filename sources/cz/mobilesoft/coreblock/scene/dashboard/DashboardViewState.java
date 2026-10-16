package cz.mobilesoft.coreblock.scene.dashboard;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel;
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
public final class DashboardViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumState f99451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PauseTimerState f99452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f99453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DashboardActivity.NavBarItem f99454d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DashboardViewModel.StrictModeScreenType f99455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f99456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f99457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f99458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Boolean f99459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f99460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f99461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f99462m;

    public DashboardViewState(PremiumState premiumState, PauseTimerState pauseTimerState, List navBarItems, DashboardActivity.NavBarItem navBarItem, DashboardViewModel.StrictModeScreenType strictModeScreenType, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(pauseTimerState, "pauseTimerState");
        Intrinsics.checkNotNullParameter(navBarItems, "navBarItems");
        Intrinsics.checkNotNullParameter(strictModeScreenType, "strictModeScreenType");
        this.f99451a = premiumState;
        this.f99452b = pauseTimerState;
        this.f99453c = navBarItems;
        this.f99454d = navBarItem;
        this.f99455f = strictModeScreenType;
        this.f99456g = z2;
        this.f99457h = z3;
        this.f99458i = z4;
        this.f99459j = bool;
        this.f99460k = z5;
        this.f99461l = z6;
        this.f99462m = z7;
    }

    public static /* synthetic */ DashboardViewState b(DashboardViewState dashboardViewState, PremiumState premiumState, PauseTimerState pauseTimerState, List list, DashboardActivity.NavBarItem navBarItem, DashboardViewModel.StrictModeScreenType strictModeScreenType, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            premiumState = dashboardViewState.f99451a;
        }
        if ((i3 & 2) != 0) {
            pauseTimerState = dashboardViewState.f99452b;
        }
        if ((i3 & 4) != 0) {
            list = dashboardViewState.f99453c;
        }
        if ((i3 & 8) != 0) {
            navBarItem = dashboardViewState.f99454d;
        }
        if ((i3 & 16) != 0) {
            strictModeScreenType = dashboardViewState.f99455f;
        }
        if ((i3 & 32) != 0) {
            z2 = dashboardViewState.f99456g;
        }
        if ((i3 & 64) != 0) {
            z3 = dashboardViewState.f99457h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z4 = dashboardViewState.f99458i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            bool = dashboardViewState.f99459j;
        }
        if ((i3 & 512) != 0) {
            z5 = dashboardViewState.f99460k;
        }
        if ((i3 & 1024) != 0) {
            z6 = dashboardViewState.f99461l;
        }
        if ((i3 & 2048) != 0) {
            z7 = dashboardViewState.f99462m;
        }
        boolean z8 = z6;
        boolean z9 = z7;
        Boolean bool2 = bool;
        boolean z10 = z5;
        boolean z11 = z3;
        boolean z12 = z4;
        DashboardViewModel.StrictModeScreenType strictModeScreenType2 = strictModeScreenType;
        boolean z13 = z2;
        return dashboardViewState.a(premiumState, pauseTimerState, list, navBarItem, strictModeScreenType2, z13, z11, z12, bool2, z10, z8, z9);
    }

    public final DashboardViewState a(PremiumState premiumState, PauseTimerState pauseTimerState, List navBarItems, DashboardActivity.NavBarItem navBarItem, DashboardViewModel.StrictModeScreenType strictModeScreenType, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(pauseTimerState, "pauseTimerState");
        Intrinsics.checkNotNullParameter(navBarItems, "navBarItems");
        Intrinsics.checkNotNullParameter(strictModeScreenType, "strictModeScreenType");
        return new DashboardViewState(premiumState, pauseTimerState, navBarItems, navBarItem, strictModeScreenType, z2, z3, z4, bool, z5, z6, z7);
    }

    public final List c() {
        return this.f99453c;
    }

    public final boolean d() {
        return this.f99461l;
    }

    public final PauseTimerState e() {
        return this.f99452b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DashboardViewState)) {
            return false;
        }
        DashboardViewState dashboardViewState = (DashboardViewState) obj;
        return Intrinsics.areEqual(this.f99451a, dashboardViewState.f99451a) && Intrinsics.areEqual(this.f99452b, dashboardViewState.f99452b) && Intrinsics.areEqual(this.f99453c, dashboardViewState.f99453c) && Intrinsics.areEqual(this.f99454d, dashboardViewState.f99454d) && this.f99455f == dashboardViewState.f99455f && this.f99456g == dashboardViewState.f99456g && this.f99457h == dashboardViewState.f99457h && this.f99458i == dashboardViewState.f99458i && Intrinsics.areEqual(this.f99459j, dashboardViewState.f99459j) && this.f99460k == dashboardViewState.f99460k && this.f99461l == dashboardViewState.f99461l && this.f99462m == dashboardViewState.f99462m;
    }

    public final boolean f() {
        return this.f99457h;
    }

    public final boolean g() {
        return this.f99458i;
    }

    public final boolean h() {
        return this.f99460k;
    }

    public int hashCode() {
        int iHashCode = ((((this.f99451a.hashCode() * 31) + this.f99452b.hashCode()) * 31) + this.f99453c.hashCode()) * 31;
        DashboardActivity.NavBarItem navBarItem = this.f99454d;
        int iHashCode2 = (((((((((iHashCode + (navBarItem == null ? 0 : navBarItem.hashCode())) * 31) + this.f99455f.hashCode()) * 31) + Boolean.hashCode(this.f99456g)) * 31) + Boolean.hashCode(this.f99457h)) * 31) + Boolean.hashCode(this.f99458i)) * 31;
        Boolean bool = this.f99459j;
        return ((((((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + Boolean.hashCode(this.f99460k)) * 31) + Boolean.hashCode(this.f99461l)) * 31) + Boolean.hashCode(this.f99462m);
    }

    public final boolean i() {
        return this.f99462m;
    }

    public final DashboardActivity.NavBarItem j() {
        return this.f99454d;
    }

    public final DashboardViewModel.StrictModeScreenType k() {
        return this.f99455f;
    }

    public final Boolean l() {
        return this.f99459j;
    }

    public final boolean m() {
        return this.f99456g;
    }

    public String toString() {
        return "DashboardViewState(premiumState=" + this.f99451a + ", pauseTimerState=" + this.f99452b + ", navBarItems=" + this.f99453c + ", startNavItem=" + this.f99454d + ", strictModeScreenType=" + this.f99455f + ", isStrictModeOn=" + this.f99456g + ", showPirateVersionDialog=" + this.f99457h + ", showPirateVersionDialogDevSettings=" + this.f99458i + ", userProdServer=" + this.f99459j + ", showRegistrationDialogOnStart=" + this.f99460k + ", noBlockingSetup=" + this.f99461l + ", showWeeklyInsightsDialog=" + this.f99462m + ")";
    }

    public /* synthetic */ DashboardViewState(PremiumState premiumState, PauseTimerState pauseTimerState, List list, DashboardActivity.NavBarItem navBarItem, DashboardViewModel.StrictModeScreenType strictModeScreenType, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(premiumState, (i3 & 2) != 0 ? new PauseTimerState(0L, 0L, 0.0f, false, 15, null) : pauseTimerState, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? null : navBarItem, (i3 & 16) != 0 ? DashboardViewModel.StrictModeScreenType.UNKNOWN : strictModeScreenType, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? false : z3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z4, (i3 & Function.MAX_NARGS) == 0 ? bool : null, (i3 & 512) != 0 ? false : z5, (i3 & 1024) != 0 ? false : z6, (i3 & 2048) != 0 ? false : z7);
    }
}
