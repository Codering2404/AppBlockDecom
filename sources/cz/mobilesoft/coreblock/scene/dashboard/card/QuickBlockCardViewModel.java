package cz.mobilesoft.coreblock.scene.dashboard.card;

import android.app.Application;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewEvent;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class QuickBlockCardViewModel extends BaseStatefulViewModel<QuickBlockViewState, QuickBlockViewEvent, QuickBlockViewCommand> {
    public static final Companion A = new Companion(null);
    public static final int B = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Params f100440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f100441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f100442q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f100443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f100444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f100445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f100446u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f100447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f100448w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MutableStateFlow f100449x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Job f100450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f100451z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f100452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f100453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f100454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f100455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f100456e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f100457f;

        public Params(boolean z2, boolean z3, boolean z4, boolean z5, long j3, boolean z6) {
            this.f100452a = z2;
            this.f100453b = z3;
            this.f100454c = z4;
            this.f100455d = z5;
            this.f100456e = j3;
            this.f100457f = z6;
        }

        public final boolean a() {
            return this.f100454c;
        }

        public final boolean b() {
            return this.f100455d;
        }

        public final boolean c() {
            return this.f100453b;
        }

        public final boolean d() {
            return this.f100452a;
        }

        public final boolean e() {
            return this.f100457f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f100452a == params.f100452a && this.f100453b == params.f100453b && this.f100454c == params.f100454c && this.f100455d == params.f100455d && this.f100456e == params.f100456e && this.f100457f == params.f100457f;
        }

        public final long f() {
            return this.f100456e;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.f100452a) * 31) + Boolean.hashCode(this.f100453b)) * 31) + Boolean.hashCode(this.f100454c)) * 31) + Boolean.hashCode(this.f100455d)) * 31) + Long.hashCode(this.f100456e)) * 31) + Boolean.hashCode(this.f100457f);
        }

        public String toString() {
            return "Params(showQuickBlockTimeSelector=" + this.f100452a + ", showPomodoro=" + this.f100453b + ", openPermissionScreen=" + this.f100454c + ", openPremiumScreen=" + this.f100455d + ", widgetTimer=" + this.f100456e + ", showStrictModeWarning=" + this.f100457f + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class StateDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QuickBlockProfileDTO f100458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PremiumState f100459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f100460c;

        public StateDTO(QuickBlockProfileDTO quickBlockProfileDTO, PremiumState premiumState, int i3) {
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f100458a = quickBlockProfileDTO;
            this.f100459b = premiumState;
            this.f100460c = i3;
        }

        public final QuickBlockProfileDTO a() {
            return this.f100458a;
        }

        public final PremiumState b() {
            return this.f100459b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StateDTO)) {
                return false;
            }
            StateDTO stateDTO = (StateDTO) obj;
            return Intrinsics.areEqual(this.f100458a, stateDTO.f100458a) && Intrinsics.areEqual(this.f100459b, stateDTO.f100459b) && this.f100460c == stateDTO.f100460c;
        }

        public int hashCode() {
            QuickBlockProfileDTO quickBlockProfileDTO = this.f100458a;
            return ((((quickBlockProfileDTO == null ? 0 : quickBlockProfileDTO.hashCode()) * 31) + this.f100459b.hashCode()) * 31) + Integer.hashCode(this.f100460c);
        }

        public String toString() {
            return "StateDTO(profile=" + this.f100458a + ", premiumState=" + this.f100459b + ", countdownTrigger=" + this.f100460c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f100461a;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f100461a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuickBlockCardViewModel(Application application, Params params) {
        super(application, new QuickBlockViewState(null, null, null, null, null, null, false, null, 0L, 0L, false, false, null, false, null, false, false, false, false, false, 1048575, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f100440o = params;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = null == true ? 1 : 0;
        this.f100441p = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = null == true ? 1 : 0;
        final Object[] objArr3 = null == true ? 1 : 0;
        this.f100442q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockTimerHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockTimerHistoryDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = null == true ? 1 : 0;
        final Object[] objArr5 = null == true ? 1 : 0;
        this.f100443r = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = null == true ? 1 : 0;
        final Object[] objArr7 = null == true ? 1 : 0;
        this.f100444s = LazyKt.a(lazyThreadSafetyModeB4, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = null == true ? 1 : 0;
        final Object[] objArr9 = null == true ? 1 : 0;
        this.f100445t = LazyKt.a(lazyThreadSafetyModeB5, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = null == true ? 1 : 0;
        final Object[] objArr11 = null == true ? 1 : 0;
        this.f100446u = LazyKt.a(lazyThreadSafetyModeB6, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = null == true ? 1 : 0;
        final Object[] objArr13 = null == true ? 1 : 0;
        this.f100447v = LazyKt.a(lazyThreadSafetyModeB7, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = null == true ? 1 : 0;
        final Object[] objArr15 = null == true ? 1 : 0;
        this.f100448w = LazyKt.a(lazyThreadSafetyModeB8, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr14, objArr15);
            }
        });
        this.f100449x = StateFlowKt.a(0);
        p1();
        o1();
    }

    private final void A1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$onAdClosed$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(QuickBlockViewState quickBlockViewState, long j3) {
        QuickBlockViewCommand showStrictModeActiveDialog;
        if (w1().E(quickBlockViewState.d().size())) {
            showStrictModeActiveDialog = new QuickBlockViewCommand.ShowPremiumFeatureScreen(PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED, "qb_apps_unlimited");
        } else if (w1().G(quickBlockViewState.t().size())) {
            showStrictModeActiveDialog = new QuickBlockViewCommand.ShowPremiumFeatureScreen(PremiumFeature.QUICK_BLOCK_WEBS_UNLIMITED, "qb_webs_unlimited");
        } else {
            if (!z1()) {
                D1(quickBlockViewState, j3);
                return;
            }
            showStrictModeActiveDialog = new QuickBlockViewCommand.ShowStrictModeActiveDialog(j3);
        }
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$onPermissionsGranted$1$1(this, showStrictModeActiveDialog, null), 3, null);
    }

    private final void D1(QuickBlockViewState quickBlockViewState, long j3) {
        QuickBlockViewCommand tryToShowInterstitialAd;
        if (j3 == -1) {
            tryToShowInterstitialAd = quickBlockViewState.x() ? QuickBlockViewCommand.ShowTimeSelectBottomSheet.f100557a : new QuickBlockViewCommand.ShowPremiumFeatureScreen(PremiumFeature.QUICK_BLOCK_TIMER, "qb_timer");
        } else {
            if (j3 != 0) {
                G1(j3);
                return;
            }
            tryToShowInterstitialAd = new QuickBlockViewCommand.TryToShowInterstitialAd(v1().J());
        }
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$onStartConfirmed$1(this, tryToShowInterstitialAd, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(Long l3) {
        G0(new QuickBlockCardViewModel$startBlocking$1(this, l3, null));
    }

    static /* synthetic */ void F1(QuickBlockCardViewModel quickBlockCardViewModel, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        quickBlockCardViewModel.E1(l3);
    }

    private final void G1(long j3) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$startBlockingWithTimer$1(this, j3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1() {
        w1().P();
        if (((QuickBlockViewState) I0()).m() != null) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.p1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QuickBlockCardViewModel.I1((QuickBlockViewState) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockViewState I1(QuickBlockViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return QuickBlockViewState.b(updateState, null, null, null, null, null, null, false, null, 0L, 0L, false, false, null, false, null, false, false, false, false, false, 1032191, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(long j3) {
        Job job = this.f100450y;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f100450y = FlowKt.Q(FlowKt.V(FlowKt.g(TimeHelperExt.f128663a.a(System.currentTimeMillis() + j3, 500L)), new QuickBlockCardViewModel$updateCountDown$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$updateMissingPermissions$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L1() {
        boolean zY1 = y1();
        boolean z2 = !zY1;
        if (zY1) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$validateProfile$1(this, null), 3, null);
        }
        return z2;
    }

    public static final /* synthetic */ QuickBlockViewState U0(QuickBlockCardViewModel quickBlockCardViewModel) {
        return (QuickBlockViewState) quickBlockCardViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(long j3) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$checkPermissionsAndStartBlocking$1(this, j3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
    
        if (r2.M(r10, r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n1(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.n1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void o1() {
        FlowExtKt.i(r1().F(), C0(), new QuickBlockCardViewModel$collectPreferences$1(this));
    }

    private final void p1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$collectProfileAndPremium$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper q1() {
        return (ConsentHelper) this.f100447v.getValue();
    }

    private final QuickBlockDataStore r1() {
        return (QuickBlockDataStore) this.f100444s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore s1() {
        return (EventDataStore) this.f100445t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f100443r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t1(Continuation continuation) {
        QuickBlockViewState quickBlockViewState = (QuickBlockViewState) I0();
        return PermissionsManager.f129021a.q(quickBlockViewState.g(), quickBlockViewState.h(), quickBlockViewState.j() == Profile.BlockingMode.Allowlist || quickBlockViewState.c() || quickBlockViewState.i() || quickBlockViewState.f() || !quickBlockViewState.d().isEmpty() || !quickBlockViewState.q().isEmpty(), !quickBlockViewState.t().isEmpty() || quickBlockViewState.e(), !quickBlockViewState.s().isEmpty(), quickBlockViewState.f(), A0(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 v1() {
        return (PremiumRepositoryV2) this.f100448w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository w1() {
        return (QuickBlockRepository) this.f100446u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockTimerHistoryDao x1() {
        return (QuickBlockTimerHistoryDao) this.f100442q.getValue();
    }

    private final boolean y1() {
        QuickBlockViewState quickBlockViewState = (QuickBlockViewState) I0();
        int i3 = WhenMappings.f100461a[quickBlockViewState.j().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        List listD = quickBlockViewState.d();
        if ((listD instanceof Collection) && listD.isEmpty()) {
            return false;
        }
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) it.next()).a().d(), LockieApplication.f95360f)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void O0(QuickBlockViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnAdClosed.f100561a)) {
            A1();
            return;
        }
        if (event instanceof QuickBlockViewEvent.OnPermissionsGranted) {
            C1((QuickBlockViewState) I0(), ((QuickBlockViewEvent.OnPermissionsGranted) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnResumed.f100565a)) {
            K1();
            return;
        }
        if (event instanceof QuickBlockViewEvent.OnStartClicked) {
            m1(((QuickBlockViewEvent.OnStartClicked) event).a());
            return;
        }
        if (event instanceof QuickBlockViewEvent.OnStartConfirmed) {
            D1((QuickBlockViewState) I0(), ((QuickBlockViewEvent.OnStartConfirmed) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnStopClicked.f100568a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnStopConfirmed.f100569a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockCardViewModel$onEvent$2(this, null), 3, null);
            return;
        }
        if (event instanceof QuickBlockViewEvent.OnViewInitialized) {
            if (this.f100451z) {
                return;
            }
            this.f100451z = true;
            BuildersKt__Builders_commonKt.d(B0(), null, null, new QuickBlockCardViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnTimerClicked.f100570a)) {
            G0(new QuickBlockCardViewModel$onEvent$4(this, null));
        } else if (Intrinsics.areEqual(event, QuickBlockViewEvent.OnPomodoroClicked.f100564a)) {
            G0(new QuickBlockCardViewModel$onEvent$5(this, null));
        } else {
            if (!Intrinsics.areEqual(event, QuickBlockViewEvent.OnPomodoroBreakSkip.f100563a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new QuickBlockCardViewModel$onEvent$6(this, null));
        }
    }

    public final Params u1() {
        return this.f100440o;
    }

    public final boolean z1() {
        return t0().n();
    }
}
