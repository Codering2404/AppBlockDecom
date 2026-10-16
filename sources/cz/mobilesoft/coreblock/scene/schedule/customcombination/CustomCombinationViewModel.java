package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.SharedLocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModelKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModelKt;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerHelperKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import org.threeten.bp.DayOfWeek;

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
public final class CustomCombinationViewModel extends BaseStatefulViewModel<CustomCombinationViewState, CustomCombinationViewEvent, CustomCombinationViewCommand> implements TimeConditionHandler, WifiConditionHandler, LocationConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f116282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f116283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f116284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f116285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f116286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f116287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final FusedLocationProviderClient f116288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LocationRequest f116289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private LocationCallback f116290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Job f116291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f116292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f116293z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$2", f = "CustomCombinationViewModel.kt", l = {157}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f116294a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.CombinationDTO f116296c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ConditionDTO.CombinationDTO combinationDTO, Continuation continuation) {
            super(2, continuation);
            this.f116296c = combinationDTO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CustomCombinationViewState q(CustomCombinationViewModel customCombinationViewModel, boolean z2, ConditionDTO.CombinationDTO combinationDTO, boolean z3, boolean z4, CustomCombinationViewState customCombinationViewState) {
            ConditionDTO.LocationDTO locationDTOE;
            GeoAddressDTO geoAddressDTOE;
            ImmutableSet immutableSetK = ((CustomCombinationViewState) customCombinationViewModel.L0()).j().k();
            ImmutableList<Wifi> immutableListE = customCombinationViewState.j().e();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableListE, 10));
            for (Wifi wifi : immutableListE) {
                arrayList.add(Wifi.b(wifi, null, null, false, false, !customCombinationViewState.m() && z4 && immutableSetK.contains(wifi.c()), false, 47, null));
            }
            ImmutableList immutableListH = ExtensionsKt.h(arrayList);
            return CustomCombinationViewState.b(customCombinationViewState, false, z3, false, null, null, null, LocationConfigurationViewState.d(customCombinationViewState.e(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z2), null, null, null, (combinationDTO == null || (locationDTOE = combinationDTO.e()) == null || (geoAddressDTOE = locationDTOE.e()) == null) ? null : customCombinationViewModel.C(geoAddressDTOE.q(), geoAddressDTOE.i()), 3932159, null), WifiConfigurationViewState.d(customCombinationViewState.j(), null, false, false, null, null, customCombinationViewModel.j0(immutableListH, customCombinationViewState.j().j()), immutableListH, false, false, false, 927, null), null, 317, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CustomCombinationViewModel.this.new AnonymousClass2(this.f116296c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f116294a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StrictModeRepository strictModeRepositoryT0 = CustomCombinationViewModel.this.t0();
                Long lW = CustomCombinationViewModel.this.w();
                this.f116294a = 1;
                obj = strictModeRepositoryT0.q(lW, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            final boolean z2 = (CustomCombinationViewModel.this.X() || this.f116296c == null || !zBooleanValue) ? false : true;
            final boolean z3 = CustomCombinationViewModel.this.S() && CustomCombinationViewModel.d1(CustomCombinationViewModel.this).k();
            final CustomCombinationViewModel customCombinationViewModel = CustomCombinationViewModel.this;
            final ConditionDTO.CombinationDTO combinationDTO = this.f116296c;
            customCombinationViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.d1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return CustomCombinationViewModel.AnonymousClass2.q(customCombinationViewModel, z3, combinationDTO, z2, zBooleanValue, (CustomCombinationViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomCombinationViewModel(Application application, ConditionDTO.CombinationDTO combinationDTO, Long l3, boolean z2, boolean z3, PremiumRepositoryV2 premiumRepository) {
        List listEmptyList;
        ConditionDTO.LocationDTO locationDTOE;
        ConditionDTO.UsageLimitDTO usageLimitDTOG;
        UsageLimit.PeriodType periodTypeG;
        ConditionDTO.UsageLimitDTO usageLimitDTOG2;
        ConditionDTO.UsageLimitDTO usageLimitDTOG3;
        ConditionDTO.UsageLimitDTO usageLimitDTOG4;
        ConditionDTO.UsageLimitDTO usageLimitDTOG5;
        ConditionDTO.LaunchCountDTO launchCountDTOD;
        UsageLimit.PeriodType periodTypeG2;
        ConditionDTO.LaunchCountDTO launchCountDTOD2;
        ConditionDTO.LaunchCountDTO launchCountDTOD3;
        ConditionDTO.LaunchCountDTO launchCountDTOD4;
        Set setC;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        if (combinationDTO == null || (setC = combinationDTO.c()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            Set set = setC;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                listEmptyList.add(((ConditionDTO) it.next()).a());
            }
        }
        List list = listEmptyList;
        boolean z4 = l3 == null;
        final Qualifier qualifier = null;
        Object[] objArr = 0;
        TimeConditionConfigurationViewState timeConditionConfigurationViewStateB = TimeConditionViewModelKt.b(application, combinationDTO != null ? combinationDTO.f() : null, premiumRepository.J().g(), (combinationDTO != null ? combinationDTO.f() : null) == null, premiumRepository.J().f(Product.TIMES));
        boolean zF = premiumRepository.J().f(Product.LAUNCH_COUNT);
        long jE = (combinationDTO == null || (launchCountDTOD4 = combinationDTO.d()) == null) ? 10L : launchCountDTOD4.e();
        Long lF = (combinationDTO == null || (launchCountDTOD3 = combinationDTO.d()) == null) ? null : launchCountDTOD3.f();
        long j3 = 0;
        LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState = new LaunchCountConditionConfigurationViewState(jE, lF, (combinationDTO == null || (launchCountDTOD2 = combinationDTO.d()) == null) ? 0L : launchCountDTOD2.j(), zF, (combinationDTO == null || (launchCountDTOD = combinationDTO.d()) == null || (periodTypeG2 = launchCountDTOD.g()) == null) ? UsageLimit.PeriodType.DAILY : periodTypeG2);
        boolean zF2 = premiumRepository.J().f(Product.USAGE_LIMIT);
        TimePickerState timePickerStateB = TimePickerHelperKt.b(((combinationDTO == null || (usageLimitDTOG5 = combinationDTO.g()) == null) ? null : usageLimitDTOG5.g()) == UsageLimit.PeriodType.HOURLY ? new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null) : TimePickerConfig.f133036h.b(), (combinationDTO == null || (usageLimitDTOG4 = combinationDTO.g()) == null) ? TimeUnit.MINUTES.toMillis(15L) : usageLimitDTOG4.e());
        Long lF2 = (combinationDTO == null || (usageLimitDTOG3 = combinationDTO.g()) == null) ? null : usageLimitDTOG3.f();
        if (combinationDTO != null && (usageLimitDTOG2 = combinationDTO.g()) != null) {
            j3 = usageLimitDTOG2.j();
        }
        super(application, new CustomCombinationViewState(z4, false, z3, timeConditionConfigurationViewStateB, launchCountConditionConfigurationViewState, new UsageLimitConfigurationViewState(lF2, j3, zF2, (combinationDTO == null || (usageLimitDTOG = combinationDTO.g()) == null || (periodTypeG = usageLimitDTOG.g()) == null) ? UsageLimit.PeriodType.DAILY : periodTypeG, timePickerStateB), new LocationConfigurationViewState((combinationDTO == null || (locationDTOE = combinationDTO.e()) == null) ? null : locationDTOE.e()), WifiConditionViewModelKt.c(combinationDTO != null ? combinationDTO.h() : null), list, 2, null));
        this.f116282o = l3;
        this.f116283p = z2;
        this.f116284q = premiumRepository;
        this.f116285r = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCombinationViewModel.B1(this.f116373a);
            }
        });
        this.f116286s = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCombinationViewModel.A1(this.f116437a);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr2 = objArr == true ? 1 : 0;
        this.f116287t = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr2);
            }
        });
        FusedLocationProviderClient fusedLocationProviderClientA = LocationServices.a(application);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClientA, "getFusedLocationProviderClient(...)");
        this.f116288u = fusedLocationProviderClientA;
        LocationRequest locationRequestP2 = LocationRequest.M().R2(100).Q2(5000L).P2(1000L);
        Intrinsics.checkNotNullExpressionValue(locationRequestP2, "setFastestInterval(...)");
        this.f116289v = locationRequestP2;
        this.f116292y = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCombinationViewModel.g1();
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(combinationDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiManager A1(CustomCombinationViewModel customCombinationViewModel) {
        Object systemService = customCombinationViewModel.A0().getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return (WifiManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$wifiScanReceiver$2$1] */
    public static final CustomCombinationViewModel$wifiScanReceiver$2$1 B1(final CustomCombinationViewModel customCombinationViewModel) {
        return new BroadcastReceiver() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel$wifiScanReceiver$2$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                this.f116336a.l0(intent);
            }
        };
    }

    public static final /* synthetic */ CustomCombinationViewState d1(CustomCombinationViewModel customCombinationViewModel) {
        return (CustomCombinationViewState) customCombinationViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex g1() {
        return MutexKt.b(false, 1, null);
    }

    private final void h1(final LaunchCountConditionViewEvent launchCountConditionViewEvent) {
        if (launchCountConditionViewEvent instanceof LaunchCountConditionViewEvent.OnLaunchCountChanged) {
            if (((CustomCombinationViewState) I0()).p() && ((LaunchCountConditionViewEvent.OnLaunchCountChanged) launchCountConditionViewEvent).a() > 0) {
                LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewStateD = ((CustomCombinationViewState) I0()).d();
                if (launchCountConditionConfigurationViewStateD.l(launchCountConditionConfigurationViewStateD.f() + 1)) {
                    G0(new CustomCombinationViewModel$handleLaunchCountConditionEvent$2(this, null));
                    return;
                }
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomCombinationViewModel.i1(launchCountConditionViewEvent, (CustomCombinationViewState) obj);
                }
            });
            return;
        }
        if (!(launchCountConditionViewEvent instanceof LaunchCountConditionViewEvent.OnPeriodTypeChanged)) {
            if (!(launchCountConditionViewEvent instanceof LaunchCountConditionViewEvent.LaunchCountTimeConditionViewEvent) && !Intrinsics.areEqual(launchCountConditionViewEvent, LaunchCountConditionViewEvent.OnCloseClicked.f115235a) && !Intrinsics.areEqual(launchCountConditionViewEvent, LaunchCountConditionViewEvent.OnSaveClicked.f115238a)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        CustomCombinationViewState customCombinationViewState = (CustomCombinationViewState) I0();
        if (!customCombinationViewState.p() || customCombinationViewState.d().h() == null) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.u0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomCombinationViewModel.j1(launchCountConditionViewEvent, (CustomCombinationViewState) obj);
                }
            });
        } else {
            G0(new CustomCombinationViewModel$handleLaunchCountConditionEvent$4(this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState i1(LaunchCountConditionViewEvent launchCountConditionViewEvent, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, LaunchCountConditionConfigurationViewState.e(updateState.d(), RangesKt.g(updateState.d().f() + ((long) ((LaunchCountConditionViewEvent.OnLaunchCountChanged) launchCountConditionViewEvent).a()), 0L), null, 0L, false, null, 30, null), null, null, null, null, 495, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState j1(LaunchCountConditionViewEvent launchCountConditionViewEvent, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, LaunchCountConditionConfigurationViewState.e(updateState.d(), 0L, null, 0L, false, ((LaunchCountConditionViewEvent.OnPeriodTypeChanged) launchCountConditionViewEvent).a(), 15, null), null, null, null, null, 495, null);
    }

    private final void k1(LocationConditionViewEvent locationConditionViewEvent) {
        if (locationConditionViewEvent instanceof LocationConditionViewEvent.OnSharedLocationConditionViewEvent) {
            o0(((LocationConditionViewEvent.OnSharedLocationConditionViewEvent) locationConditionViewEvent).a());
            return;
        }
        if (locationConditionViewEvent instanceof LocationConditionViewEvent.LocationTimeConditionViewEvent) {
            return;
        }
        if (Intrinsics.areEqual(locationConditionViewEvent, LocationConditionViewEvent.OnCloseClicked.f115450a)) {
            G0(new CustomCombinationViewModel$handleLocationConditionEvent$1(this, null));
        } else if (!Intrinsics.areEqual(locationConditionViewEvent, LocationConditionViewEvent.OnSaveClicked.f115451a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void l1(TimeConditionViewEvent timeConditionViewEvent) {
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnDayCheckedChanged) {
            TimeConditionViewEvent.OnDayCheckedChanged onDayCheckedChanged = (TimeConditionViewEvent.OnDayCheckedChanged) timeConditionViewEvent;
            f(onDayCheckedChanged.b(), onDayCheckedChanged.a());
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalRemoveClicked) {
            a0(((TimeConditionViewEvent.OnIntervalRemoveClicked) timeConditionViewEvent).a());
            return;
        }
        if (Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnAddIntervalClicked.f115749a)) {
            x();
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalClicked) {
            p0(((TimeConditionViewEvent.OnIntervalClicked) timeConditionViewEvent).a());
            return;
        }
        if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnIntervalSet) {
            TimeConditionViewEvent.OnIntervalSet onIntervalSet = (TimeConditionViewEvent.OnIntervalSet) timeConditionViewEvent;
            g(onIntervalSet.b(), onIntervalSet.a(), onIntervalSet.c());
        } else if (timeConditionViewEvent instanceof TimeConditionViewEvent.OnAllDayLongCheckedChanged) {
            y(((TimeConditionViewEvent.OnAllDayLongCheckedChanged) timeConditionViewEvent).a());
        } else if (Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a)) {
            m();
        } else if (!Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnCloseClicked.f115751a) && !Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnSaveClicked.f115760a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void m1(final UsageLimitConditionViewEvent usageLimitConditionViewEvent) {
        if (usageLimitConditionViewEvent instanceof UsageLimitConditionViewEvent.OnTimePickerStateChanged) {
            if (((CustomCombinationViewState) I0()).p() && !X() && ((CustomCombinationViewState) I0()).h().l(((UsageLimitConditionViewEvent.OnTimePickerStateChanged) usageLimitConditionViewEvent).a().s())) {
                z1();
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.w0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomCombinationViewModel.n1(usageLimitConditionViewEvent, (CustomCombinationViewState) obj);
                    }
                });
                return;
            }
        }
        if (!(usageLimitConditionViewEvent instanceof UsageLimitConditionViewEvent.OnPeriodTypeChanged)) {
            if (!Intrinsics.areEqual(usageLimitConditionViewEvent, UsageLimitConditionViewEvent.OnCloseClicked.f115881a) && !Intrinsics.areEqual(usageLimitConditionViewEvent, UsageLimitConditionViewEvent.OnSaveClicked.f115883a) && !(usageLimitConditionViewEvent instanceof UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        final CustomCombinationViewState customCombinationViewState = (CustomCombinationViewState) I0();
        if (!customCombinationViewState.p() || customCombinationViewState.h().g() == null) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.x0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomCombinationViewModel.o1(usageLimitConditionViewEvent, customCombinationViewState, (CustomCombinationViewState) obj);
                }
            });
        } else {
            G0(new CustomCombinationViewModel$handleUsageLimitConditionEvent$2(this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState n1(UsageLimitConditionViewEvent usageLimitConditionViewEvent, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, UsageLimitConfigurationViewState.e(updateState.h(), null, 0L, false, null, ((UsageLimitConditionViewEvent.OnTimePickerStateChanged) usageLimitConditionViewEvent).a(), 15, null), null, null, null, 479, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState o1(UsageLimitConditionViewEvent usageLimitConditionViewEvent, CustomCombinationViewState customCombinationViewState, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        UsageLimitConditionViewEvent.OnPeriodTypeChanged onPeriodTypeChanged = (UsageLimitConditionViewEvent.OnPeriodTypeChanged) usageLimitConditionViewEvent;
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, UsageLimitConfigurationViewState.e(updateState.h(), null, 0L, false, onPeriodTypeChanged.a(), onPeriodTypeChanged.a() == UsageLimit.PeriodType.DAILY ? TimePickerHelperKt.b(TimePickerConfig.f133036h.b(), customCombinationViewState.h().i().s()) : TimePickerHelperKt.b(new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null), customCombinationViewState.h().i().n()), 7, null), null, null, null, 479, null);
    }

    private final void q1(ProfileType profileType, boolean z2) {
        boolean zContains = ((CustomCombinationViewState) L0()).f().contains(profileType);
        if (((CustomCombinationViewState) I0()).p() && !z2 && !X() && zContains) {
            G0(new CustomCombinationViewModel$onConditionChecked$1(this, null));
            return;
        }
        if (profileType == ProfileType.WIFI && z2) {
            I();
        } else if (profileType == ProfileType.LOCATION && z2) {
            final boolean zS = S();
            if (zS) {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomCombinationViewModel.r1(zS, (CustomCombinationViewState) obj);
                    }
                });
            } else {
                BuildersKt__Builders_commonKt.d(F0(), null, null, new CustomCombinationViewModel$onConditionChecked$3(this, null), 3, null);
            }
        }
        final List listPlus = z2 ? CollectionsKt.plus((Collection<? extends ProfileType>) ((CustomCombinationViewState) I0()).f(), profileType) : CollectionsKt.minus(((CustomCombinationViewState) I0()).f(), profileType);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCombinationViewModel.s1(listPlus, (CustomCombinationViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState r1(boolean z2, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, null, LocationConfigurationViewState.d(updateState.e(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z2), null, null, null, null, 8126463, null), null, null, 447, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState s1(List list, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, null, null, null, list, 255, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState u1(LocationConfigurationViewState locationConfigurationViewState, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, null, locationConfigurationViewState, null, null, 447, null);
    }

    private final void v1(ProfileType profileType) {
        ProfileType profileType2;
        if (((CustomCombinationViewState) I0()).p() && profileType == (profileType2 = ProfileType.LOCATION) && ((CustomCombinationViewState) L0()).f().contains(profileType2)) {
            G0(new CustomCombinationViewModel$onOpenCondition$1(this, null));
        } else {
            G0(new CustomCombinationViewModel$onOpenCondition$2(this, profileType, null));
        }
    }

    private final void w1() {
        CustomCombinationViewState customCombinationViewState = (CustomCombinationViewState) I0();
        if (customCombinationViewState.o()) {
            List listF = customCombinationViewState.f();
            ArrayList arrayList = new ArrayList();
            Iterator it = listF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ConditionConfiguration conditionConfigurationI = customCombinationViewState.i((ProfileType) it.next());
                ConditionDTO conditionDTOB = conditionConfigurationI != null ? conditionConfigurationI.b() : null;
                if (conditionDTOB != null) {
                    arrayList.add(conditionDTOB);
                }
            }
            ConditionDTO.CombinationDTO combinationDTO = new ConditionDTO.CombinationDTO(CollectionsKt.toSet(arrayList));
            if (combinationDTO.c().size() < 2) {
                G0(new CustomCombinationViewModel$onSaveClicked$1$1(this, null));
            } else {
                G0(new CustomCombinationViewModel$onSaveClicked$1$2(this, combinationDTO, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState x1(TimeConditionConfigurationViewState timeConditionConfigurationViewState, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, timeConditionConfigurationViewState, null, null, null, null, null, 503, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomCombinationViewState y1(WifiConfigurationViewState wifiConfigurationViewState, CustomCombinationViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return CustomCombinationViewState.b(updateState, false, false, false, null, null, null, null, wifiConfigurationViewState, null, 383, null);
    }

    private final void z1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f116293z > 2000) {
            this.f116293z = jCurrentTimeMillis;
            G0(new CustomCombinationViewModel$showStrictModeSnackbarThrottled$1(this, null));
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ List A(List list, List list2) {
        return super.A(list, list2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ LatLngBounds C(LatLng latLng, double d3) {
        return super.C(latLng, d3);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void D() {
        super.D();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void E(LatLng latLng) {
        super.E(latLng);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public LocationCallback F() {
        return this.f116290w;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ boolean G(String str) {
        return super.G(str);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public LocationRequest H() {
        return this.f116289v;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void I() {
        super.I();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiManager J() {
        return (WifiManager) this.f116286s.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public Mutex L() {
        return (Mutex) this.f116292y.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public CoroutineScope N() {
        return F0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((CustomCombinationViewState) I0()).p();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void P(Job job) {
        this.f116291x = job;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public Job Q() {
        return this.f116291x;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiConfigurationViewState R() {
        return ((CustomCombinationViewState) L0()).j();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ boolean S() {
        return super.S();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public FusedLocationProviderClient V() {
        return this.f116288u;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f116283p;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiConfigurationViewState Y() {
        return ((CustomCombinationViewState) I0()).j();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public CoroutineScope a() {
        return C0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void a0(IntervalDTO intervalDTO) {
        super.a0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void c(int i3) {
        G0(new CustomCombinationViewModel$onShowSnackbar$1(this, i3, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void c0() {
        G0(new CustomCombinationViewModel$requestLocationPermissions$1(this, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void f(boolean z2, DayOfWeek dayOfWeek) {
        super.f(z2, dayOfWeek);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void f0(final LocationConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCombinationViewModel.u1(newState, (CustomCombinationViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void g(IntervalDTO intervalDTO, long j3, long j4) {
        super.g(intervalDTO, j3, j4);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public Context getContext() {
        return A0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public CoroutineScope getScope() {
        return B0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean isPremium() {
        return this.f116284q.J().g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ ImmutableList j0(List list, String str) {
        return super.j0(list, str);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void k(SharedWifiConditionEvent sharedWifiConditionEvent) {
        super.k(sharedWifiConditionEvent);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void l() {
        G0(new CustomCombinationViewModel$checkLocationServicesAvailable$1(this, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void l0(Intent intent) {
        super.l0(intent);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void m() {
        super.m();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void m0() {
        super.m0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void n0(final TimeConditionConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCombinationViewModel.x1(newState, (CustomCombinationViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public LocationConfigurationViewState o() {
        return ((CustomCombinationViewState) I0()).e();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void o0(SharedLocationConditionViewEvent sharedLocationConditionViewEvent) {
        super.o0(sharedLocationConditionViewEvent);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p(IntervalDTO intervalDTO) {
        super.p(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p0(IntervalDTO intervalDTO) {
        super.p0(intervalDTO);
    }

    public final void p1(WifiConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof WifiConditionViewEvent.OnSharedWifiConditionEvent) {
            k(((WifiConditionViewEvent.OnSharedWifiConditionEvent) event).a());
        } else if (event instanceof WifiConditionViewEvent.OnCloseClicked) {
            G0(new CustomCombinationViewModel$handleWifiConditionEvent$1(this, null));
        } else if (!Intrinsics.areEqual(event, WifiConditionViewEvent.OnSaveClicked.f116042a) && !(event instanceof WifiConditionViewEvent.WifiTimeConditionViewEvent)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void q(List permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        G0(new CustomCombinationViewModel$requestManifestPermissions$1(this, permissions, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void q0(LocationCallback locationCallback) {
        this.f116290w = locationCallback;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void s(final WifiConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomCombinationViewModel.y1(newState, (CustomCombinationViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ List s0(List list, List list2) {
        return super.s0(list, list2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void t() {
        super.t();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public StrictModeRepository t0() {
        return (StrictModeRepository) this.f116287t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
    public void O0(CustomCombinationViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, CustomCombinationViewEvent.OnSaveClicked.f116279a)) {
            w1();
            return;
        }
        if (Intrinsics.areEqual(event, CustomCombinationViewEvent.OnWifiPermissionDeclined.f116280a)) {
            q1(ProfileType.WIFI, false);
            return;
        }
        if (Intrinsics.areEqual(event, CustomCombinationViewEvent.OnPermissionsDenied.f116278a)) {
            q1(ProfileType.WIFI, false);
            return;
        }
        if (event instanceof CustomCombinationViewEvent.OnConditionChecked) {
            CustomCombinationViewEvent.OnConditionChecked onConditionChecked = (CustomCombinationViewEvent.OnConditionChecked) event;
            q1(onConditionChecked.b(), onConditionChecked.a());
            return;
        }
        if (event instanceof CustomCombinationViewEvent.OpenCondition) {
            v1(((CustomCombinationViewEvent.OpenCondition) event).a());
            return;
        }
        if (event instanceof CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent) {
            l1(((CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent) event).a());
            return;
        }
        if (event instanceof CustomCombinationViewEvent.CustomCombinationUsageLimitConditionViewEvent) {
            m1(((CustomCombinationViewEvent.CustomCombinationUsageLimitConditionViewEvent) event).a());
            return;
        }
        if (event instanceof CustomCombinationViewEvent.CustomCombinationLaunchCountConditionViewEvent) {
            h1(((CustomCombinationViewEvent.CustomCombinationLaunchCountConditionViewEvent) event).a());
        } else if (event instanceof CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent) {
            p1(((CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent) event).a());
        } else {
            if (!(event instanceof CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            k1(((CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent) event).a());
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void u0(Wifi wifi, boolean z2) {
        super.u0(wifi, z2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f116282o;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ ImmutableList w0(List list) {
        return super.w0(list);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void x() {
        super.x();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public TimeConditionConfigurationViewState x0() {
        return ((CustomCombinationViewState) I0()).g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public BroadcastReceiver z() {
        return (BroadcastReceiver) this.f116285r.getValue();
    }
}
