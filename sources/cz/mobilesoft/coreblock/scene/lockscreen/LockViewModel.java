package cz.mobilesoft.coreblock.scene.lockscreen;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.util.CodeClickHelper;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.mp.KoinPlatformTools;

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
public final class LockViewModel extends BaseStatefulViewModel<LockViewState, LockViewEvent, LockViewCommand> implements KoinComponent {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f105476u = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LockScreenProviderV2 f105477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f105478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f105479q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ProfileType f105480r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final CodeClickHelper f105481s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LockViewModel$lockProviderListener$1 f105482t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$lockProviderListener$1] */
    public LockViewModel(Application application, PremiumRepositoryV2 premiumRepository) {
        super(application, new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, premiumRepository.J(), -1, 7, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.f105478p = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.f105479q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr3, objArr4);
            }
        });
        this.f105481s = new CodeClickHelper();
        this.f105482t = new LockScreenProviderV2.LockProviderListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$lockProviderListener$1
            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void a(boolean z2) {
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onCloseSelected$1(this.f105487a, z2, null), 3, null);
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void b() {
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onInterstitialRequested$1(this.f105487a, null), 3, null);
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void c(String source) {
                Intrinsics.checkNotNullParameter(source, "source");
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onInAppUpdateRequested$1(this.f105487a, source, null), 3, null);
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void d() {
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onShowIntroScheduleActivity$1(this.f105487a, null), 3, null);
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void e(ProfileType profileType) {
                this.f105487a.f105480r = profileType;
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void f(RevenueCatPlacement placement, DiscountSource dSource) {
                Intrinsics.checkNotNullParameter(placement, "placement");
                Intrinsics.checkNotNullParameter(dSource, "dSource");
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onShowDiscountActivity$1(this.f105487a, placement, dSource, null), 3, null);
            }

            @Override // cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockProviderListener
            public void h(long j3, CampaignSource campaignSource, String source) {
                Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
                Intrinsics.checkNotNullParameter(source, "source");
                BuildersKt__Builders_commonKt.d(this.f105487a.C0(), null, null, new LockViewModel$lockProviderListener$1$onShowCampaignActivity$1(this.f105487a, j3, campaignSource, source, null), 3, null);
            }
        };
    }

    private final void a1(LockScreenIntentState lockScreenIntentState) {
        LockScreenProviderV2 lockScreenProviderV2 = new LockScreenProviderV2(A0(), false, this.f105482t);
        if ((lockScreenIntentState != null ? lockScreenIntentState.d() : null) != null) {
            ProfileType profileTypeD = lockScreenIntentState.d();
            String strB = lockScreenIntentState.b();
            if (strB == null) {
                strB = "";
            }
            lockScreenProviderV2.E0(strB, lockScreenIntentState.a(), profileTypeD, lockScreenIntentState.c(), lockScreenIntentState.e());
        } else {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new LockViewModel$initLockProviderFromActivity$1$2(this, null), 3, null);
        }
        this.f105477o = lockScreenProviderV2;
        l1();
    }

    private final void b1(LockOverlayIntentState lockOverlayIntentState) {
        LockScreenProviderV2 lockScreenProviderV2 = new LockScreenProviderV2(A0(), true, this.f105482t);
        if (lockOverlayIntentState != null) {
            String strD = lockOverlayIntentState.d();
            if (strD == null) {
                strD = "";
            }
            lockScreenProviderV2.D0(strD, lockOverlayIntentState.c(), lockOverlayIntentState.a(), lockOverlayIntentState.e(), lockOverlayIntentState.h(), lockOverlayIntentState.b(), lockOverlayIntentState.g(), lockOverlayIntentState.j(), lockOverlayIntentState.f(), lockOverlayIntentState.i());
        } else {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new LockViewModel$initLockProviderFromService$1$1(this, null), 3, null);
        }
        this.f105477o = lockScreenProviderV2;
        l1();
    }

    private final boolean c1(String str, ProfileType profileType) {
        if (str != null && str.length() != 0 && profileType != null) {
            return true;
        }
        CrashHelper.j(new IllegalStateException(profileType == null ? "profileType is null" : str == null ? "Package name is null" : "Package name is empty"));
        return false;
    }

    private final void d1() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new LockViewModel$onBackdoorDialogSuccess$1(this, null), 3, null);
        if (this.f105480r == ProfileType.STRICT_MODE) {
            j1();
        }
    }

    private final void e1() {
        this.f105481s.a(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockViewModel.f1(this.f105772a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(LockViewModel lockViewModel) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(lockViewModel), null, null, new LockViewModel$onCodeClicked$1$1(lockViewModel, null), 3, null);
        return Unit.f139807a;
    }

    private final void h1() {
        LockScreenProviderV2 lockScreenProviderV2 = this.f105477o;
        if (lockScreenProviderV2 != null) {
            AnswersHelper.f128199a.a1(lockScreenProviderV2.m0());
        }
        LockScreenProviderV2 lockScreenProviderV22 = this.f105477o;
        if (lockScreenProviderV22 != null) {
            lockScreenProviderV22.X();
        }
    }

    private final void i1() {
        LockScreenProviderV2 lockScreenProviderV2 = this.f105477o;
        if (lockScreenProviderV2 != null) {
            lockScreenProviderV2.V();
        }
    }

    private final void j1() {
        LockScreenProviderV2 lockScreenProviderV2 = this.f105477o;
        if (lockScreenProviderV2 != null) {
            lockScreenProviderV2.U();
        }
    }

    private final void k1() {
        LockScreenProviderV2 lockScreenProviderV2 = this.f105477o;
        if (lockScreenProviderV2 != null) {
            lockScreenProviderV2.S0();
        }
    }

    private final void l1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new LockViewModel$setLockProviderViewStateListener$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f105479q.getValue();
    }

    public final Set X0() {
        Set setJ0;
        LockScreenProviderV2 lockScreenProviderV2 = this.f105477o;
        return (lockScreenProviderV2 == null || (setJ0 = lockScreenProviderV2.j0()) == null) ? SetsKt.emptySet() : setJ0;
    }

    public final CoreMultiProcessDataStore Y0() {
        return (CoreMultiProcessDataStore) this.f105478p.getValue();
    }

    public final LockScreenProviderV2 Z0() {
        return this.f105477o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void O0(LockViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Log.d(LockViewModel.class.getName(), "onEvent invoked");
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a)) {
            e1();
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.OnBackdoorDialogSuccess.f105475a)) {
            d1();
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenAvailableSettingsClickEvent.f105463a)) {
            G0(new LockViewModel$onEvent$1(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenAllowThisAppClickEvent.f105462a)) {
            G0(new LockViewModel$onEvent$2(this, null));
            return;
        }
        if (event instanceof LockViewEvent.LockScreenPopupCloseEvent) {
            LockViewEvent.LockScreenPopupCloseEvent lockScreenPopupCloseEvent = (LockViewEvent.LockScreenPopupCloseEvent) event;
            AnswersHelper.f128199a.L3(lockScreenPopupCloseEvent.a());
            if (lockScreenPopupCloseEvent.a()) {
                G0(new LockViewModel$onEvent$3(this, null));
                return;
            } else {
                k1();
                return;
            }
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenCloseButtonClickEvent.f105467a) || Intrinsics.areEqual(event, LockViewEvent.LockScreenBackToAppClickEvent.f105464a)) {
            k1();
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenCampaignCardClickEvent.f105466a)) {
            h1();
            return;
        }
        if (event instanceof LockViewEvent.LockScreenContactSupportClickEvent) {
            if (((LockViewEvent.LockScreenContactSupportClickEvent) event).a()) {
                AnswersHelper.f128199a.i7();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new LockViewModel$onEvent$4(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenInAppUpdateCardClickEvent.f105472a)) {
            i1();
            return;
        }
        if (Intrinsics.areEqual(event, LockViewEvent.LockScreenRequestCloseEvent.f105474a)) {
            j1();
            return;
        }
        if (event instanceof LockViewEvent.LockProviderInitFromActivityEvent) {
            LockViewEvent.LockProviderInitFromActivityEvent lockProviderInitFromActivityEvent = (LockViewEvent.LockProviderInitFromActivityEvent) event;
            if (c1(lockProviderInitFromActivityEvent.a().b(), lockProviderInitFromActivityEvent.a().d())) {
                a1(lockProviderInitFromActivityEvent.a());
                return;
            } else {
                G0(new LockViewModel$onEvent$5(this, null));
                return;
            }
        }
        if (event instanceof LockViewEvent.LockProviderInitFromServiceEvent) {
            b1(((LockViewEvent.LockProviderInitFromServiceEvent) event).a());
        } else if (event instanceof LockViewEvent.LockScreenExcludeBrowserClickEvent) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new LockViewModel$onEvent$6(this, event, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, LockViewEvent.LockScreenCustomBlockCreateNowClickEvent.f105470a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new LockViewModel$onEvent$7(this, null), 3, null);
        }
    }
}
