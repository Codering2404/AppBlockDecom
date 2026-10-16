package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.pairip.VMRunner;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class WifiConditionViewModel extends BaseStatefulViewModel<WifiConditionViewState, WifiConditionViewEvent, WifiConditionViewCommand> implements TimeConditionHandler, WifiConditionHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f116045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f116046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PremiumRepositoryV2 f116047q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f116048r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f116049s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f116050t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f116051u;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$1", f = "WifiConditionViewModel.kt", l = {97, 101, 102}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f116052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f116053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f116054c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ConditionDTO.WifisDTO f116056f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConditionDTO.WifisDTO wifisDTO, Continuation continuation) {
            super(2, continuation);
            this.f116056f = wifisDTO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WifiConditionViewState q(WifiConditionViewModel wifiConditionViewModel, boolean z2, boolean z3, WifiConditionViewState wifiConditionViewState) {
            ImmutableSet immutableSetK = ((WifiConditionViewState) wifiConditionViewModel.L0()).d().k();
            ImmutableList<Wifi> immutableListE = wifiConditionViewState.d().e();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableListE, 10));
            for (Wifi wifi : immutableListE) {
                arrayList.add(Wifi.b(wifi, null, null, false, false, z3 && immutableSetK.contains(wifi.c()), false, 47, null));
            }
            ImmutableList immutableListH = ExtensionsKt.h(arrayList);
            return WifiConditionViewState.b(wifiConditionViewState, z2, false, null, WifiConfigurationViewState.d(wifiConditionViewState.d(), null, false, false, null, null, wifiConditionViewModel.j0(immutableListH, wifiConditionViewState.d().j()), immutableListH, false, false, false, 927, null), 6, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return WifiConditionViewModel.this.new AnonymousClass1(this.f116056f, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r9.f116054c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2f
                if (r1 == r5) goto L2b
                if (r1 == r4) goto L23
                if (r1 != r3) goto L1b
                int r0 = r9.f116053b
                boolean r1 = r9.f116052a
                kotlin.ResultKt.b(r10)
                goto L97
            L1b:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L23:
                int r1 = r9.f116053b
                boolean r4 = r9.f116052a
                kotlin.ResultKt.b(r10)
                goto L78
            L2b:
                kotlin.ResultKt.b(r10)
                goto L47
            L2f:
                kotlin.ResultKt.b(r10)
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel r10 = cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.this
                cz.mobilesoft.coreblock.repository.StrictModeRepository r10 = r10.t0()
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel r1 = cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.this
                java.lang.Long r1 = r1.w()
                r9.f116054c = r5
                java.lang.Object r10 = r10.q(r1, r9)
                if (r10 != r0) goto L47
                goto L94
            L47:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$WifisDTO r1 = r9.f116056f
                if (r1 == 0) goto L55
                if (r10 == 0) goto L55
                r1 = r5
                goto L56
            L55:
                r1 = r2
            L56:
                java.lang.Boolean r6 = cz.mobilesoft.coreblock.BuildConfig.f95357b
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L9b
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel r6 = cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r6 = cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.W0(r6)
                kotlinx.coroutines.flow.Flow r6 = r6.m1()
                r9.f116052a = r10
                r9.f116053b = r1
                r9.f116054c = r4
                java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.D(r6, r9)
                if (r4 != r0) goto L75
                goto L94
            L75:
                r8 = r4
                r4 = r10
                r10 = r8
            L78:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L9a
                java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS
                r6 = 10
                long r6 = r10.toMillis(r6)
                r9.f116052a = r4
                r9.f116053b = r1
                r9.f116054c = r3
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
                if (r10 != r0) goto L95
            L94:
                return r0
            L95:
                r0 = r1
                r1 = r4
            L97:
                r10 = r1
                r1 = r0
                goto L9b
            L9a:
                r10 = r4
            L9b:
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel r0 = cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.this
                if (r1 == 0) goto La0
                r2 = r5
            La0:
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.q1 r1 = new cz.mobilesoft.coreblock.scene.schedule.condition.wifi.q1
                r1.<init>()
                cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.Y0(r0, r1)
                kotlin.Unit r10 = kotlin.Unit.f139807a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WifiConditionViewModel(Application application, ConditionDTO.WifisDTO wifisDTO, Long l3, boolean z2, PremiumRepositoryV2 premiumRepository) {
        super(application, WifiConditionViewModelKt.b(application, wifisDTO, z2, premiumRepository));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f116045o = l3;
        this.f116046p = z2;
        this.f116047q = premiumRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f116048r = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f116049s = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr2, objArr3);
            }
        });
        this.f116050t = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.o1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WifiConditionViewModel.h1(this.f116163a);
            }
        });
        this.f116051u = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WifiConditionViewModel.g1(this.f116173a);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(wifisDTO, null), 3, null);
    }

    public static final /* synthetic */ WifiConditionViewState V0(WifiConditionViewModel wifiConditionViewModel) {
        return (WifiConditionViewState) wifiConditionViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore Z0() {
        return (DevDataStore) this.f116049s.getValue();
    }

    private final void a1(TimeConditionViewEvent timeConditionViewEvent) {
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

    private final void b1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new WifiConditionViewModel$onCloseClicked$1(this, null), 3, null);
    }

    private final void d1() {
        ConditionDTO.TimeDTO timeDTOB = ((WifiConditionViewState) I0()).c().b();
        if (timeDTOB == null) {
            h0();
        } else {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new WifiConditionViewModel$onSaveClicked$1(this, ConditionDTO.WifisDTO.d(((WifiConditionViewState) I0()).d().b(), null, timeDTOB, 1, null), null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiConditionViewState e1(TimeConditionConfigurationViewState timeConditionConfigurationViewState, WifiConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return WifiConditionViewState.b(updateState, false, false, timeConditionConfigurationViewState, null, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiConditionViewState f1(WifiConfigurationViewState wifiConfigurationViewState, WifiConditionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return WifiConditionViewState.b(updateState, false, false, null, wifiConfigurationViewState, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiManager g1(WifiConditionViewModel wifiConditionViewModel) {
        Object systemService = wifiConditionViewModel.A0().getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return (WifiManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$wifiScanReceiver$2$1] */
    public static final WifiConditionViewModel$wifiScanReceiver$2$1 h1(final WifiConditionViewModel wifiConditionViewModel) {
        return new BroadcastReceiver() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModel$wifiScanReceiver$2$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                VMRunner.invoke("XTkMmCMQHv0e5hSC", new Object[]{this, context, intent});
            }
        };
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ List A(List list, List list2) {
        return super.A(list, list2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ boolean G(String str) {
        return super.G(str);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void I() {
        super.I();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiManager J() {
        return (WifiManager) this.f116051u.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean O() {
        return ((WifiConditionViewState) I0()).g();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiConfigurationViewState R() {
        return ((WifiConditionViewState) L0()).d();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean X() {
        return this.f116046p;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public WifiConfigurationViewState Y() {
        return ((WifiConditionViewState) I0()).d();
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
        G0(new WifiConditionViewModel$onShowSnackbar$1(this, i3, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void c0() {
        G0(new WifiConditionViewModel$requestLocationPermissions$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void O0(WifiConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, WifiConditionViewEvent.OnCloseClicked.f116041a)) {
            b1();
            return;
        }
        if (Intrinsics.areEqual(event, WifiConditionViewEvent.OnSaveClicked.f116042a)) {
            d1();
        } else if (event instanceof WifiConditionViewEvent.WifiTimeConditionViewEvent) {
            a1(((WifiConditionViewEvent.WifiTimeConditionViewEvent) event).a());
        } else {
            if (!(event instanceof WifiConditionViewEvent.OnSharedWifiConditionEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            k(((WifiConditionViewEvent.OnSharedWifiConditionEvent) event).a());
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void f(boolean z2, DayOfWeek dayOfWeek) {
        super.f(z2, dayOfWeek);
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
    public /* bridge */ void h0() {
        super.h0();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public boolean isPremium() {
        return this.f116047q.J().g();
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
        G0(new WifiConditionViewModel$checkLocationServicesAvailable$1(this, null));
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
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionViewModel.e1(newState, (WifiConditionViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        try {
            A0().unregisterReceiver(z());
        } catch (Exception unused) {
        }
        super.onCleared();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p(IntervalDTO intervalDTO) {
        super.p(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void p0(IntervalDTO intervalDTO) {
        super.p0(intervalDTO);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void q(List permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        G0(new WifiConditionViewModel$requestManifestPermissions$1(this, permissions, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public void s(final WifiConfigurationViewState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionViewModel.f1(newState, (WifiConditionViewState) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ List s0(List list, List list2) {
        return super.s0(list, list2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public StrictModeRepository t0() {
        return (StrictModeRepository) this.f116048r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public /* bridge */ void u0(Wifi wifi, boolean z2) {
        super.u0(wifi, z2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public Long w() {
        return this.f116045o;
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
        return ((WifiConditionViewState) I0()).c();
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler
    public /* bridge */ void y(boolean z2) {
        super.y(z2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionHandler
    public BroadcastReceiver z() {
        return (BroadcastReceiver) this.f116050t.getValue();
    }
}
