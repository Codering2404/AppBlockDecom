package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModelKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class LocationConditionScreenViewModel extends BaseStatefulViewModel<LocationConditionScreenViewState, LocationConditionViewEvent, LocationConditionScreenViewCommand> implements TimeConditionHandler, LocationConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f115421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f115422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f115423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final FusedLocationProviderClient f115424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final LocationRequest f115425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LocationCallback f115426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Job f115427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f115428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f115429w;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$1", f = "LocationConditionScreenViewModel.kt", l = {98}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115430a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.LocationDTO f115432c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConditionDTO.LocationDTO locationDTO, Continuation continuation) {
            super(2, continuation);
            this.f115432c = locationDTO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LocationConditionScreenViewState q(boolean z2, boolean z3, ConditionDTO.LocationDTO locationDTO, LocationConditionScreenViewModel locationConditionScreenViewModel, LocationConditionScreenViewState locationConditionScreenViewState) {
            GeoAddressDTO geoAddressDTOE;
            return LocationConditionScreenViewState.b(locationConditionScreenViewState, false, z2, null, LocationConfigurationViewState.d(locationConditionScreenViewState.c(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z3), null, null, null, (locationDTO == null || (geoAddressDTOE = locationDTO.e()) == null) ? null : locationConditionScreenViewModel.C(geoAddressDTOE.q(), geoAddressDTOE.i()), 3932159, null), 5, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LocationConditionScreenViewModel.this.new AnonymousClass1(this.f115432c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115430a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StrictModeRepository strictModeRepositoryT0 = LocationConditionScreenViewModel.this.t0();
                Long lW = LocationConditionScreenViewModel.this.w();
                this.f115430a = 1;
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
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            ConditionDTO.LocationDTO locationDTO = this.f115432c;
            final boolean z2 = (locationDTO != null ? locationDTO.e() : null) != null && zBooleanValue;
            final boolean zS = LocationConditionScreenViewModel.this.S();
            final LocationConditionScreenViewModel locationConditionScreenViewModel = LocationConditionScreenViewModel.this;
            final ConditionDTO.LocationDTO locationDTO2 = this.f115432c;
            locationConditionScreenViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.i1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LocationConditionScreenViewModel.AnonymousClass1.q(z2, zS, locationDTO2, locationConditionScreenViewModel, (LocationConditionScreenViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocationConditionScreenViewModel(Application application, ConditionDTO.LocationDTO locationDTO, Long l3, boolean z2, PremiumRepositoryV2 premiumRepository) {
        super(application, new LocationConditionScreenViewState(l3 == null, false, TimeConditionViewModelKt.b(application, locationDTO != null ? locationDTO.f() : null, premiumRepository.J().g(), (locationDTO != null ? locationDTO.f() : null) == null, premiumRepository.J().f(Product.TIMES)), new LocationConfigurationViewState(locationDTO != null ? locationDTO.e() : null), 2, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        final Qualifier qualifier = null;
        Object[] objArr = 0;
        this.f115421o = l3;
        this.f115422p = z2;
        this.f115423q = premiumRepository;
        FusedLocationProviderClient fusedLocationProviderClientA = LocationServices.a(application);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClientA, "getFusedLocationProviderClient(...)");
        this.f115424r = fusedLocationProviderClientA;
        LocationRequest locationRequestP2 = LocationRequest.M().R2(100).Q2(5000L).P2(1000L);
        Intrinsics.checkNotNullExpressionValue(locationRequestP2, "setFastestInterval(...)");
        this.f115425s = locationRequestP2;
        this.f115428v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LocationConditionScreenViewModel.X0();
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr2 = objArr == true ? 1 : 0;
        this.f115429w = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$special$$inlined$inject$default$1
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
        BuildersKt__Builders_commonKt.d(B0(), null, null, new AnonymousClass1(locationDTO, null), 3, null);
    }

    public static final /* synthetic */ LocationConditionScreenViewState U0(LocationConditionScreenViewModel locationConditionScreenViewModel) {
        return (LocationConditionScreenViewState) locationConditionScreenViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex X0() {
        return MutexKt.b(false, 1, null);
    }

    private final void Y0(TimeConditionViewEvent timeConditionViewEvent) {
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
        } else {
            if (Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnCloseClicked.f115751a) || Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnSaveClicked.f115760a)) {
                return;
            }
            if (!Intrinsics.areEqual(timeConditionViewEvent, TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a)) {
                throw new NoWhenBranchMatchedException();
            }
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationConditionScreenViewState a1(LocationConfigurationViewState locationConfigurationViewState, LocationConditionScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LocationConditionScreenViewState.b(updateState, false, false, null, locationConfigurationViewState, 7, null);
    }

    private final void b1() {
        ConditionDTO.LocationDTO locationDTOD;
        ConditionDTO.TimeDTO timeDTOB = ((LocationConditionScreenViewState) I0()).d().b();
        if (timeDTOB == null) {
            h0();
            return;
        }
        ConditionDTO.LocationDTO locationDTOB = ((LocationConditionScreenViewState) I0()).c().b();
        if (locationDTOB == null || (locationDTOD = ConditionDTO.LocationDTO.d(locationDTOB, null, timeDTOB, 1, null)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.d(B0(), null, null, new LocationConditionScreenViewModel$onSaveClicked$1(this, locationDTOD, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationConditionScreenViewState c1(TimeConditionConfigurationViewState timeConditionConfigurationViewState, LocationConditionScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LocationConditionScreenViewState.b(updateState, false, false, timeConditionConfigurationViewState, null, 11, null);
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
        return this.f115426t;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public LocationRequest H() {
        return this.f115425s;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public Mutex L() {
        return (Mutex) this.f115428v.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public CoroutineScope N() {
        return F0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((LocationConditionScreenViewState) I0()).g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void P(Job job) {
        this.f115427u = job;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public Job Q() {
        return this.f115427u;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ boolean S() {
        return super.S();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public FusedLocationProviderClient V() {
        return this.f115424r;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f115422p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(LocationConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof LocationConditionViewEvent.LocationTimeConditionViewEvent) {
            Y0(((LocationConditionViewEvent.LocationTimeConditionViewEvent) event).a());
            return;
        }
        if (event instanceof LocationConditionViewEvent.OnSharedLocationConditionViewEvent) {
            o0(((LocationConditionViewEvent.OnSharedLocationConditionViewEvent) event).a());
        } else if (Intrinsics.areEqual(event, LocationConditionViewEvent.OnCloseClicked.f115450a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new LocationConditionScreenViewModel$onEvent$1(this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, LocationConditionViewEvent.OnSaveClicked.f115451a)) {
                throw new NoWhenBranchMatchedException();
            }
            b1();
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public CoroutineScope a() {
        return C0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void a0(IntervalDTO intervalDTO) {
        super.a0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void c(int i3) {
        G0(new LocationConditionScreenViewModel$onShowSnackbar$1(this, i3, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void f(boolean z2, DayOfWeek dayOfWeek) {
        super.f(z2, dayOfWeek);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void f0(final LocationConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationConditionScreenViewModel.a1(newState, (LocationConditionScreenViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void g(IntervalDTO intervalDTO, long j3, long j4) {
        super.g(intervalDTO, j3, j4);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public Context getContext() {
        return A0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public CoroutineScope getScope() {
        return B0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void h0() {
        super.h0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean isPremium() {
        return this.f115423q.J().g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void m() {
        super.m();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public void n0(final TimeConditionConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationConditionScreenViewModel.c1(newState, (LocationConditionScreenViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public LocationConfigurationViewState o() {
        return ((LocationConditionScreenViewState) I0()).c();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void o0(SharedLocationConditionViewEvent sharedLocationConditionViewEvent) {
        super.o0(sharedLocationConditionViewEvent);
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        t();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p(IntervalDTO intervalDTO) {
        super.p(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p0(IntervalDTO intervalDTO) {
        super.p0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public void q0(LocationCallback locationCallback) {
        this.f115426t = locationCallback;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler
    public /* bridge */ void t() {
        super.t();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public StrictModeRepository t0() {
        return (StrictModeRepository) this.f115429w.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f115421o;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void x() {
        super.x();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public TimeConditionConfigurationViewState x0() {
        return ((LocationConditionScreenViewState) I0()).d();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }
}
