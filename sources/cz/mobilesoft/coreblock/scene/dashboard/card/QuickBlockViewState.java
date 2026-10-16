package cz.mobilesoft.coreblock.scene.dashboard.card;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
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
public final class QuickBlockViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final QuickBlockRepository.QuickBlockState f100572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Profile.BlockingMode f100573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f100574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f100575d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f100576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f100577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f100578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f100579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f100580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f100581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f100582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f100583m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f100584n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f100585o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Long f100586p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f100587q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f100588r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f100589s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f100590t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f100591u;

    public QuickBlockViewState(QuickBlockRepository.QuickBlockState quickBlockState, Profile.BlockingMode blockingMode, List apps, List webs, List selectedCategories, List subApps, boolean z2, List missingPermissions, long j3, long j4, boolean z3, boolean z4, List exceededLimits, boolean z5, Long l3, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(quickBlockState, "quickBlockState");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(webs, "webs");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(exceededLimits, "exceededLimits");
        this.f100572a = quickBlockState;
        this.f100573b = blockingMode;
        this.f100574c = apps;
        this.f100575d = webs;
        this.f100576f = selectedCategories;
        this.f100577g = subApps;
        this.f100578h = z2;
        this.f100579i = missingPermissions;
        this.f100580j = j3;
        this.f100581k = j4;
        this.f100582l = z3;
        this.f100583m = z4;
        this.f100584n = exceededLimits;
        this.f100585o = z5;
        this.f100586p = l3;
        this.f100587q = z6;
        this.f100588r = z7;
        this.f100589s = z8;
        this.f100590t = z9;
        this.f100591u = z10;
    }

    public static /* synthetic */ QuickBlockViewState b(QuickBlockViewState quickBlockViewState, QuickBlockRepository.QuickBlockState quickBlockState, Profile.BlockingMode blockingMode, List list, List list2, List list3, List list4, boolean z2, List list5, long j3, long j4, boolean z3, boolean z4, List list6, boolean z5, Long l3, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i3, Object obj) {
        boolean z11;
        boolean z12;
        QuickBlockRepository.QuickBlockState quickBlockState2 = (i3 & 1) != 0 ? quickBlockViewState.f100572a : quickBlockState;
        Profile.BlockingMode blockingMode2 = (i3 & 2) != 0 ? quickBlockViewState.f100573b : blockingMode;
        List list7 = (i3 & 4) != 0 ? quickBlockViewState.f100574c : list;
        List list8 = (i3 & 8) != 0 ? quickBlockViewState.f100575d : list2;
        List list9 = (i3 & 16) != 0 ? quickBlockViewState.f100576f : list3;
        List list10 = (i3 & 32) != 0 ? quickBlockViewState.f100577g : list4;
        boolean z13 = (i3 & 64) != 0 ? quickBlockViewState.f100578h : z2;
        List list11 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? quickBlockViewState.f100579i : list5;
        long j5 = (i3 & Function.MAX_NARGS) != 0 ? quickBlockViewState.f100580j : j3;
        long j6 = (i3 & 512) != 0 ? quickBlockViewState.f100581k : j4;
        boolean z14 = (i3 & 1024) != 0 ? quickBlockViewState.f100582l : z3;
        boolean z15 = (i3 & 2048) != 0 ? quickBlockViewState.f100583m : z4;
        QuickBlockRepository.QuickBlockState quickBlockState3 = quickBlockState2;
        List list12 = (i3 & 4096) != 0 ? quickBlockViewState.f100584n : list6;
        boolean z16 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? quickBlockViewState.f100585o : z5;
        Long l4 = (i3 & 16384) != 0 ? quickBlockViewState.f100586p : l3;
        boolean z17 = (i3 & 32768) != 0 ? quickBlockViewState.f100587q : z6;
        boolean z18 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? quickBlockViewState.f100588r : z7;
        boolean z19 = (i3 & 131072) != 0 ? quickBlockViewState.f100589s : z8;
        boolean z20 = (i3 & 262144) != 0 ? quickBlockViewState.f100590t : z9;
        if ((i3 & 524288) != 0) {
            z12 = z20;
            z11 = quickBlockViewState.f100591u;
        } else {
            z11 = z10;
            z12 = z20;
        }
        return quickBlockViewState.a(quickBlockState3, blockingMode2, list7, list8, list9, list10, z13, list11, j5, j6, z14, z15, list12, z16, l4, z17, z18, z19, z12, z11);
    }

    public final QuickBlockViewState a(QuickBlockRepository.QuickBlockState quickBlockState, Profile.BlockingMode blockingMode, List apps, List webs, List selectedCategories, List subApps, boolean z2, List missingPermissions, long j3, long j4, boolean z3, boolean z4, List exceededLimits, boolean z5, Long l3, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(quickBlockState, "quickBlockState");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(webs, "webs");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(exceededLimits, "exceededLimits");
        return new QuickBlockViewState(quickBlockState, blockingMode, apps, webs, selectedCategories, subApps, z2, missingPermissions, j3, j4, z3, z4, exceededLimits, z5, l3, z6, z7, z8, z9, z10);
    }

    public final boolean c() {
        return this.f100578h;
    }

    public final List d() {
        return this.f100574c;
    }

    public final boolean e() {
        return this.f100589s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockViewState)) {
            return false;
        }
        QuickBlockViewState quickBlockViewState = (QuickBlockViewState) obj;
        return Intrinsics.areEqual(this.f100572a, quickBlockViewState.f100572a) && this.f100573b == quickBlockViewState.f100573b && Intrinsics.areEqual(this.f100574c, quickBlockViewState.f100574c) && Intrinsics.areEqual(this.f100575d, quickBlockViewState.f100575d) && Intrinsics.areEqual(this.f100576f, quickBlockViewState.f100576f) && Intrinsics.areEqual(this.f100577g, quickBlockViewState.f100577g) && this.f100578h == quickBlockViewState.f100578h && Intrinsics.areEqual(this.f100579i, quickBlockViewState.f100579i) && this.f100580j == quickBlockViewState.f100580j && this.f100581k == quickBlockViewState.f100581k && this.f100582l == quickBlockViewState.f100582l && this.f100583m == quickBlockViewState.f100583m && Intrinsics.areEqual(this.f100584n, quickBlockViewState.f100584n) && this.f100585o == quickBlockViewState.f100585o && Intrinsics.areEqual(this.f100586p, quickBlockViewState.f100586p) && this.f100587q == quickBlockViewState.f100587q && this.f100588r == quickBlockViewState.f100588r && this.f100589s == quickBlockViewState.f100589s && this.f100590t == quickBlockViewState.f100590t && this.f100591u == quickBlockViewState.f100591u;
    }

    public final boolean f() {
        return this.f100590t;
    }

    public final boolean g() {
        return this.f100587q;
    }

    public final boolean h() {
        return this.f100588r;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((this.f100572a.hashCode() * 31) + this.f100573b.hashCode()) * 31) + this.f100574c.hashCode()) * 31) + this.f100575d.hashCode()) * 31) + this.f100576f.hashCode()) * 31) + this.f100577g.hashCode()) * 31) + Boolean.hashCode(this.f100578h)) * 31) + this.f100579i.hashCode()) * 31) + Long.hashCode(this.f100580j)) * 31) + Long.hashCode(this.f100581k)) * 31) + Boolean.hashCode(this.f100582l)) * 31) + Boolean.hashCode(this.f100583m)) * 31) + this.f100584n.hashCode()) * 31) + Boolean.hashCode(this.f100585o)) * 31;
        Long l3 = this.f100586p;
        return ((((((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f100587q)) * 31) + Boolean.hashCode(this.f100588r)) * 31) + Boolean.hashCode(this.f100589s)) * 31) + Boolean.hashCode(this.f100590t)) * 31) + Boolean.hashCode(this.f100591u);
    }

    public final boolean i() {
        return this.f100585o;
    }

    public final Profile.BlockingMode j() {
        return this.f100573b;
    }

    public final PomodoroSession.SessionMode k() {
        PomodoroSession pomodoroSessionB;
        QuickBlockRepository.QuickBlockState quickBlockState = this.f100572a;
        QuickBlockRepository.QuickBlockState.Pomodoro pomodoro = quickBlockState instanceof QuickBlockRepository.QuickBlockState.Pomodoro ? (QuickBlockRepository.QuickBlockState.Pomodoro) quickBlockState : null;
        if (pomodoro == null || (pomodoroSessionB = pomodoro.b()) == null) {
            return null;
        }
        return pomodoroSessionB.j();
    }

    public final List l() {
        return this.f100584n;
    }

    public final Long m() {
        return this.f100586p;
    }

    public final List n() {
        return this.f100579i;
    }

    public final QuickBlockRepository.QuickBlockState o() {
        return this.f100572a;
    }

    public final long p() {
        return this.f100580j;
    }

    public final List q() {
        return this.f100576f;
    }

    public final long r() {
        return this.f100581k;
    }

    public final List s() {
        return this.f100577g;
    }

    public final List t() {
        return this.f100575d;
    }

    public final boolean u() {
        return this.f100573b == Profile.BlockingMode.Allowlist || !this.f100574c.isEmpty() || !this.f100575d.isEmpty() || !this.f100576f.isEmpty() || !this.f100577g.isEmpty() || this.f100589s || this.f100590t || this.f100578h || this.f100585o;
    }

    public final boolean v() {
        return !(this.f100572a instanceof QuickBlockRepository.QuickBlockState.Stopped);
    }

    public final boolean w() {
        return this.f100591u;
    }

    public final boolean x() {
        return this.f100582l;
    }

    public final boolean y() {
        return this.f100583m;
    }

    public String toString() {
        return "QuickBlockViewState(quickBlockState=" + this.f100572a + ", blockingMode=" + this.f100573b + ", apps=" + this.f100574c + ", webs=" + this.f100575d + ", selectedCategories=" + this.f100576f + ", subApps=" + this.f100577g + ", addNewApps=" + this.f100578h + ", missingPermissions=" + this.f100579i + ", remainingTime=" + this.f100580j + ", startTime=" + this.f100581k + ", isPremiumActive=" + this.f100582l + ", isSetupFinished=" + this.f100583m + ", exceededLimits=" + this.f100584n + ", blockUnsupportedBrowsers=" + this.f100585o + HcgZcEUYo.cfTpsFXeMK + this.f100586p + ", blockLaunch=" + this.f100587q + ", blockNotifications=" + this.f100588r + ", blockAdultContent=" + this.f100589s + ", blockInAppPurchases=" + this.f100590t + ", isLoaded=" + this.f100591u + ")";
    }

    public /* synthetic */ QuickBlockViewState(QuickBlockRepository.QuickBlockState quickBlockState, Profile.BlockingMode blockingMode, List list, List list2, List list3, List list4, boolean z2, List list5, long j3, long j4, boolean z3, boolean z4, List list6, boolean z5, Long l3, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? QuickBlockRepository.QuickBlockState.Stopped.f97890b : quickBlockState, (i3 & 2) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list4, (i3 & 64) != 0 ? false : z2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? CollectionsKt.emptyList() : list5, (i3 & Function.MAX_NARGS) != 0 ? 0L : j3, (i3 & 512) == 0 ? j4 : 0L, (i3 & 1024) != 0 ? false : z3, (i3 & 2048) != 0 ? false : z4, (i3 & 4096) != 0 ? CollectionsKt.emptyList() : list6, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z5, (i3 & 16384) != 0 ? null : l3, (i3 & 32768) != 0 ? false : z6, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z7, (i3 & 131072) != 0 ? false : z8, (i3 & 262144) != 0 ? false : z9, (i3 & 524288) != 0 ? false : z10);
    }
}
