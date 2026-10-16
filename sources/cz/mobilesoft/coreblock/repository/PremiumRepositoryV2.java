package cz.mobilesoft.coreblock.repository;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.StoreProduct;
import com.singular.sdk.Singular;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase;
import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.subscription.RevenueCatExtKt;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.Koin;
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
public final class PremiumRepositoryV2 implements KoinComponent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f97693p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f97694q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f97695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f97696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f97697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f97698d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f97699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f97700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f97701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f97702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PremiumExpiringManager f97703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableStateFlow f97704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final StateFlow f97705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MutableStateFlow f97706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final StateFlow f97707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final UpdatedCustomerInfoListener f97708o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PremiumExpiringFlowState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PremiumExpiringFlowState[] $VALUES;
        public static final Companion Companion;
        public static final PremiumExpiringFlowState Show = new PremiumExpiringFlowState("Show", 0);
        public static final PremiumExpiringFlowState DoNotShow = new PremiumExpiringFlowState("DoNotShow", 1);
        public static final PremiumExpiringFlowState Unset = new PremiumExpiringFlowState("Unset", 2);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PremiumExpiringFlowState a(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return Intrinsics.areEqual(name, "Show") ? PremiumExpiringFlowState.Show : Intrinsics.areEqual(name, "DoNotShow") ? PremiumExpiringFlowState.DoNotShow : PremiumExpiringFlowState.Unset;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PremiumExpiringFlowState[] $values() {
            return new PremiumExpiringFlowState[]{Show, DoNotShow, Unset};
        }

        static {
            PremiumExpiringFlowState[] premiumExpiringFlowStateArr$values = $values();
            $VALUES = premiumExpiringFlowStateArr$values;
            $ENTRIES = EnumEntriesKt.a(premiumExpiringFlowStateArr$values);
            Companion = new Companion(null);
        }

        private PremiumExpiringFlowState(String str, int i3) {
        }

        public static EnumEntries<PremiumExpiringFlowState> getEntries() {
            return $ENTRIES;
        }

        public static PremiumExpiringFlowState valueOf(String str) {
            return (PremiumExpiringFlowState) Enum.valueOf(PremiumExpiringFlowState.class, str);
        }

        public static PremiumExpiringFlowState[] values() {
            return (PremiumExpiringFlowState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PremiumExpiringManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StateFlow f97709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StateFlow f97710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StateFlow f97711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Flow f97712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ConcurrentHashMap f97713e;

        public PremiumExpiringManager() {
            Flow flowY0 = PremiumRepositoryV2.this.E().Y0();
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            SharingStarted.Companion companion = SharingStarted.f142210a;
            SharingStarted sharingStartedC = companion.c();
            Boolean bool = Boolean.FALSE;
            StateFlow stateFlowH0 = FlowKt.h0(flowY0, applicationScope, sharingStartedC, bool);
            this.f97709a = stateFlowH0;
            Flow flowZ0 = PremiumRepositoryV2.this.E().Z0();
            CoroutineScope applicationScope2 = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope2, "applicationScope");
            this.f97710b = FlowKt.h0(flowZ0, applicationScope2, companion.c(), bool);
            Flow flowI = FlowKt.I(new PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1(PremiumRepositoryV2.this.C(), null, this));
            CoroutineScope applicationScope3 = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope3, "applicationScope");
            StateFlow stateFlowH02 = FlowKt.h0(flowI, applicationScope3, companion.c(), bool);
            this.f97711c = stateFlowH02;
            this.f97712d = FlowKt.n(stateFlowH0, PremiumRepositoryV2.this.A().m3(), stateFlowH02, new PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1(null));
            this.f97713e = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f() {
            EntitlementInfos entitlements;
            Map<String, EntitlementInfo> all;
            CustomerInfo customerInfoB = PremiumRepositoryV2.this.B();
            if (customerInfoB == null || (entitlements = customerInfoB.getEntitlements()) == null || (all = entitlements.getAll()) == null || all.isEmpty()) {
                return false;
            }
            Iterator<Map.Entry<String, EntitlementInfo>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Date expirationDate = it.next().getValue().getExpirationDate();
                if (ComparableExtKt.c(expirationDate != null ? Long.valueOf(expirationDate.getTime()) : null, Long.valueOf(TimeHelperExt.f128663a.f() - TimeUnit.DAYS.toMillis(30L)))) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean g() {
            Long lH = h();
            if (lH != null) {
                TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
                if (ComparableExtKt.a(lH, Long.valueOf(timeHelperExt.f()), Long.valueOf(timeHelperExt.f() + TimeUnit.DAYS.toMillis(2L)))) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StateFlow k(PremiumRepositoryV2 premiumRepositoryV2, PremiumExpiringManager premiumExpiringManager, boolean z2, Boolean it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Flow flowA = PremiumRepositoryV2Kt.a(premiumRepositoryV2.C(), premiumRepositoryV2.K(), premiumRepositoryV2.A().n3(), premiumExpiringManager.f97710b, premiumExpiringManager.f97709a, z2);
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            return FlowKt.h0(flowA, applicationScope, SharingStarted.f142210a.c(), Boolean.FALSE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StateFlow l(Function1 function1, Object obj) {
            return (StateFlow) function1.invoke(obj);
        }

        public final Integer e() {
            Long lH = h();
            if (((Boolean) this.f97709a.getValue()).booleanValue()) {
                return 7;
            }
            if (lH == null) {
                return null;
            }
            TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
            if (timeHelperExt.z(lH.longValue())) {
                return null;
            }
            return Integer.valueOf((int) TimeUnit.MILLISECONDS.toDays(lH.longValue() - timeHelperExt.f()));
        }

        public final Long h() {
            EntitlementInfo entitlementInfoA;
            Date expirationDate;
            if (((Boolean) this.f97709a.getValue()).booleanValue()) {
                return Long.valueOf(TimeHelperExt.f128663a.f() + TimeUnit.DAYS.toMillis(7L));
            }
            CustomerInfo customerInfoB = PremiumRepositoryV2.this.B();
            if (customerInfoB == null || (entitlementInfoA = RevenueCatExtKt.a(customerInfoB)) == null || (expirationDate = entitlementInfoA.getExpirationDate()) == null) {
                return null;
            }
            return Long.valueOf(expirationDate.getTime());
        }

        public final Flow i() {
            return this.f97712d;
        }

        public final StateFlow j(final boolean z2) {
            ConcurrentHashMap concurrentHashMap = this.f97713e;
            Boolean boolValueOf = Boolean.valueOf(z2);
            final PremiumRepositoryV2 premiumRepositoryV2 = PremiumRepositoryV2.this;
            final Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.repository.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumRepositoryV2.PremiumExpiringManager.k(premiumRepositoryV2, this, z2, (Boolean) obj);
                }
            };
            Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(boolValueOf, new Function() { // from class: cz.mobilesoft.coreblock.repository.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return PremiumRepositoryV2.PremiumExpiringManager.l(function1, obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(objComputeIfAbsent, "computeIfAbsent(...)");
            return (StateFlow) objComputeIfAbsent;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PremiumRepositoryV2() {
        CoroutineScope coroutineScopeA = CoroutinesHelperExtKt.a(Dispatchers.b());
        this.f97695a = coroutineScopeA;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f97696b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f97697c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$2
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
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f97698d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<FacebookLogger>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FacebookLogger.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f97699f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f97700g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<RestoreRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreRevenueCatPurchaseUseCase.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f97701h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<FetchRevenueCatOfferingUseCase>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchRevenueCatOfferingUseCase.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f97702i = LazyKt.a(lazyThreadSafetyModeB7, new Function0<DeterminePremiumStateUseCase>() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DeterminePremiumStateUseCase.class), objArr12, objArr13);
            }
        });
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(null);
        this.f97704k = mutableStateFlowA;
        Flow flowM = FlowKt.m(C(), E().r1(), new PremiumRepositoryV2$isTrialActiveFlow$1(null));
        SharingStarted.Companion companion = SharingStarted.f142210a;
        SharingStarted sharingStartedC = companion.c();
        Boolean bool = Boolean.FALSE;
        this.f97705l = FlowKt.h0(flowM, coroutineScopeA, sharingStartedC, bool);
        MutableStateFlow mutableStateFlowA2 = StateFlowKt.a(bool);
        this.f97706m = mutableStateFlowA2;
        this.f97707n = FlowKt.h0(FlowKt.m0(FlowKt.n(mutableStateFlowA2, mutableStateFlowA, E().O0(), new PremiumRepositoryV2$premiumStateFlow$1(null)), new PremiumRepositoryV2$special$$inlined$flatMapLatest$1(null, this)), coroutineScopeA, companion.c(), PremiumState.None.INSTANCE);
        this.f97708o = new UpdatedCustomerInfoListener() { // from class: cz.mobilesoft.coreblock.repository.m
            @Override // com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener
            public final void onReceived(CustomerInfo customerInfo) {
                PremiumRepositoryV2.Y(this.f98429a, customerInfo);
            }
        };
        this.f97703j = new PremiumExpiringManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore A() {
        return (CoreDataStore) this.f97696b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeterminePremiumStateUseCase D() {
        return (DeterminePremiumStateUseCase) this.f97702i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore E() {
        return (DevDataStore) this.f97697c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore F() {
        return (DiscountDataStore) this.f97699f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FacebookLogger G() {
        return (FacebookLogger) this.f97698d.getValue();
    }

    private final FetchRevenueCatOfferingUseCase H() {
        return (FetchRevenueCatOfferingUseCase) this.f97701h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RestoreRevenueCatPurchaseUseCase M() {
        return (RestoreRevenueCatPurchaseUseCase) this.f97700g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Log.d("PremiumRepository", "Firebase app instance ID: " + it.getResult());
        Purchases.Companion companion = Purchases.Companion;
        companion.getSharedInstance().setFirebaseAppInstanceID((String) it.getResult());
        companion.getSharedInstance().collectDeviceIdentifiers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(PremiumRepositoryV2 premiumRepositoryV2, CustomerInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.d(premiumRepositoryV2.f97695a, null, null, new PremiumRepositoryV2$initialize$6$1(premiumRepositoryV2, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object V(cz.mobilesoft.coreblock.util.SessionManager.SignInState r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onSignedInStateChanged$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onSignedInStateChanged$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onSignedInStateChanged$1) r0
            int r1 = r0.f97796h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97796h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onSignedInStateChanged$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onSignedInStateChanged$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f97794f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97796h
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.f97792c
            com.revenuecat.purchases.Purchases r5 = (com.revenuecat.purchases.Purchases) r5
            java.lang.Object r5 = r0.f97791b
            com.revenuecat.purchases.Purchases r5 = (com.revenuecat.purchases.Purchases) r5
            java.lang.Object r5 = r0.f97790a
            cz.mobilesoft.coreblock.util.SessionManager$SignInState r5 = (cz.mobilesoft.coreblock.util.SessionManager.SignInState) r5
            kotlin.ResultKt.b(r6)
            goto L8f
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.b(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "Sign in state changed: "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r2 = "PremiumRepository"
            android.util.Log.d(r2, r6)
            com.revenuecat.purchases.Purchases r6 = r4.L()
            if (r6 == 0) goto L8f
            boolean r2 = r5 instanceof cz.mobilesoft.coreblock.util.SessionManager.SignedIn
            if (r2 == 0) goto L7d
            r2 = r5
            cz.mobilesoft.coreblock.util.SessionManager$SignedIn r2 = (cz.mobilesoft.coreblock.util.SessionManager.SignedIn) r2
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f97790a = r5
            r0.f97791b = r6
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f97792c = r5
            r5 = 0
            r0.f97793d = r5
            r0.f97796h = r3
            java.lang.Object r5 = r4.W(r6, r2, r0)
            if (r5 != r1) goto L8f
            return r1
        L7d:
            cz.mobilesoft.coreblock.util.SessionManager$SignedOut r6 = cz.mobilesoft.coreblock.util.SessionManager.SignedOut.f127925a
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L89
            r4.X()
            goto L8f
        L89:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L8f:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.V(cz.mobilesoft.coreblock.util.SessionManager$SignInState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011f, code lost:
    
        if (r10.d0(r9, (java.lang.String) r11, r0) != r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x015a, code lost:
    
        if (r11 == r1) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6 A[Catch: PurchasesException -> 0x0056, TryCatch #0 {PurchasesException -> 0x0056, blocks: (B:18:0x0051, B:23:0x006f, B:42:0x0100, B:26:0x007d, B:36:0x00b6, B:38:0x00d6, B:33:0x009f), top: B:52:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object W(com.revenuecat.purchases.Purchases r9, cz.mobilesoft.coreblock.util.SessionManager.SignedIn r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.W(com.revenuecat.purchases.Purchases, cz.mobilesoft.coreblock.util.SessionManager$SignedIn, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void X() {
        Singular.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(PremiumRepositoryV2 premiumRepositoryV2, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        premiumRepositoryV2.e0(customerInfo);
    }

    public static /* synthetic */ void b0(PremiumRepositoryV2 premiumRepositoryV2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = new Function0() { // from class: cz.mobilesoft.coreblock.repository.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumRepositoryV2.c0();
                }
            };
        }
        premiumRepositoryV2.a0(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d0(com.revenuecat.purchases.Purchases r7, java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncTestTargetingGroup$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncTestTargetingGroup$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncTestTargetingGroup$1) r0
            int r1 = r0.f97852f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97852f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncTestTargetingGroup$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncTestTargetingGroup$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f97850c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97852f
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f97849b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f97848a
            com.revenuecat.purchases.Purchases r7 = (com.revenuecat.purchases.Purchases) r7
            kotlin.ResultKt.b(r9)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            goto L7b
        L31:
            r0 = move-exception
            r7 = r0
            r1 = r7
            goto L71
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.b(r9)
            java.lang.CharSequence r9 = kotlin.text.StringsKt.t1(r8)
            java.lang.String r9 = r9.toString()
            int r2 = r9.length()
            if (r2 != 0) goto L4f
            r9 = 0
        L4f:
            java.lang.String r2 = "test_targeting_group"
            kotlin.Pair r9 = kotlin.TuplesKt.a(r2, r9)
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r9)
            r7.setAttributes(r9)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r0.f97848a = r9     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r0.f97849b = r8     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r0.f97852f = r3     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            java.lang.Object r7 = com.revenuecat.purchases.CoroutinesExtensionsKt.awaitSyncAttributesAndOfferingsIfNeeded(r7, r0)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            if (r7 != r1) goto L7b
            return r1
        L71:
            cz.mobilesoft.coreblock.util.CrashHelper r0 = cz.mobilesoft.coreblock.util.CrashHelper.f127788a
            r4 = 2
            r5 = 0
            java.lang.String r2 = "Error syncing test targeting group"
            r3 = 0
            cz.mobilesoft.coreblock.util.CrashHelper.m(r0, r1, r2, r3, r4, r5)
        L7b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.d0(com.revenuecat.purchases.Purchases, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(CustomerInfo customerInfo) {
        this.f97704k.setValue(customerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
    
        if (r9.collect(r2, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$1) r0
            int r1 = r0.f97744d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97744d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f97742b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97744d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L97
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L34:
            long r4 = r0.f97741a
            kotlin.ResultKt.b(r9)
            goto L62
        L3a:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.enums.PremiumState r9 = r8.J()
            boolean r9 = r9.g()
            if (r9 == 0) goto L4a
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L4a:
            long r5 = java.lang.System.currentTimeMillis()
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r9 = r8.F()
            kotlinx.coroutines.flow.Flow r9 = r9.L0()
            r0.f97741a = r5
            r0.f97744d = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L61
            goto L96
        L61:
            r4 = r5
        L62:
            java.lang.Number r9 = (java.lang.Number) r9
            long r6 = r9.longValue()
            long r4 = r4 - r6
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.DAYS
            r6 = 1
            long r6 = r9.toMillis(r6)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L78
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L78:
            cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase r9 = r8.H()
            cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$Params r2 = new cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$Params
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r4 = cz.mobilesoft.coreblock.enums.RevenueCatPlacement.General
            cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$FetchOfferingsSource r5 = cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase.FetchOfferingsSource.TrialCheck
            r2.<init>(r4, r5)
            kotlinx.coroutines.flow.Flow r9 = r9.o(r2)
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$2 r2 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkTrialEligibility$2
            r2.<init>()
            r0.f97744d = r3
            java.lang.Object r9 = r9.collect(r2, r0)
            if (r9 != r1) goto L97
        L96:
            return r1
        L97:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(com.revenuecat.purchases.CustomerInfo r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$1) r0
            int r1 = r0.f97752d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97752d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f97750b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97752d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f97749a
            com.revenuecat.purchases.CustomerInfo r7 = (com.revenuecat.purchases.CustomerInfo) r7
            kotlin.ResultKt.b(r8)
            goto L4b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = r6.A()
            kotlinx.coroutines.flow.Flow r8 = r8.E3()
            r0.f97749a = r7
            r0.f97752d = r3
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L56
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L56:
            java.lang.String r8 = "PremiumRepository"
            java.lang.String r0 = "Checking subscriptions..."
            android.util.Log.d(r8, r0)
            java.util.Map r7 = r7.getAllExpirationDatesByProduct()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L76
            kotlinx.coroutines.CoroutineScope r0 = r6.f97695a
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$2 r3 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$checkWasSubscriptionBoughtInThePast$2
            r7 = 0
            r3.<init>(r6, r7)
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            kotlinx.coroutines.BuildersKt.d(r0, r1, r2, r3, r4, r5)
        L76:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.v(com.revenuecat.purchases.CustomerInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object y(PremiumRepositoryV2 premiumRepositoryV2, CacheFetchPolicy cacheFetchPolicy, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.CACHED_OR_FETCHED;
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1() { // from class: cz.mobilesoft.coreblock.repository.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PremiumRepositoryV2.z((CustomerInfo) obj2);
                }
            };
        }
        return premiumRepositoryV2.x(cacheFetchPolicy, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(CustomerInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final CustomerInfo B() {
        return (CustomerInfo) this.f97704k.getValue();
    }

    public final StateFlow C() {
        return this.f97704k;
    }

    public final PremiumExpiringManager I() {
        return this.f97703j;
    }

    public final PremiumState J() {
        return (PremiumState) this.f97707n.getValue();
    }

    public final StateFlow K() {
        return this.f97707n;
    }

    public final Purchases L() {
        Purchases.Companion companion = Purchases.Companion;
        if (companion.isConfigured()) {
            return companion.getSharedInstance();
        }
        return null;
    }

    public final String N() {
        Purchases purchasesL = L();
        if (purchasesL != null) {
            return purchasesL.getAppUserID();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0177, code lost:
    
        if (y(r1, null, r3, r4, 1, null) != r0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(android.content.Context r13, java.lang.String r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.O(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean R() {
        return ((Boolean) this.f97705l.getValue()).booleanValue();
    }

    public final StateFlow S() {
        return this.f97705l;
    }

    public final void T(PurchaseResult purchaseResult, StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        CoroutinesHelperExtKt.d(new PremiumRepositoryV2$onPurchaseFinished$1(purchaseResult, this, product, null));
    }

    public final void U(String productId, Function1 onPurchasesRestored, Function1 onRestoreFailed) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onPurchasesRestored, "onPurchasesRestored");
        Intrinsics.checkNotNullParameter(onRestoreFailed, "onRestoreFailed");
        CoroutinesHelperExtKt.d(new PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1(productId, this, onPurchasesRestored, onRestoreFailed, null));
    }

    public final void Z() {
        Purchases purchasesL = L();
        if (purchasesL != null) {
            purchasesL.setAttributes(MapsKt.mapOf(TuplesKt.a("paywall_mode", "hard_paywall")));
        }
    }

    public final void a0(Function0 onSuccess) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        BuildersKt__Builders_commonKt.d(this.f97695a, null, null, new PremiumRepositoryV2$syncPurchases$2(onSuccess, this, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void w() {
        this.f97706m.setValue(Boolean.TRUE);
        e0(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(com.revenuecat.purchases.CacheFetchPolicy r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$fetchCustomerInfo$1
            if (r0 == 0) goto L13
            r0 = r14
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$fetchCustomerInfo$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$fetchCustomerInfo$1) r0
            int r1 = r0.f97761h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97761h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$fetchCustomerInfo$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$fetchCustomerInfo$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.f97759f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97761h
            r3 = 1
            java.lang.String r4 = "PremiumRepository"
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r12 = r0.f97757c
            com.revenuecat.purchases.Purchases r12 = (com.revenuecat.purchases.Purchases) r12
            java.lang.Object r12 = r0.f97756b
            r13 = r12
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            java.lang.Object r12 = r0.f97755a
            com.revenuecat.purchases.CacheFetchPolicy r12 = (com.revenuecat.purchases.CacheFetchPolicy) r12
            kotlin.ResultKt.b(r14)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            goto L6d
        L38:
            r0 = move-exception
            r12 = r0
            r6 = r12
            goto L76
        L3c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L44:
            kotlin.ResultKt.b(r14)
            com.revenuecat.purchases.Purchases r14 = r11.L()
            if (r14 == 0) goto L95
            r2 = 0
            java.lang.String r2 = kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC.mAE
            android.util.Log.d(r4, r2)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r0.f97755a = r2     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r0.f97756b = r13     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r0.f97757c = r2     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r2 = 0
            r0.f97758d = r2     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r0.f97761h = r3     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            java.lang.Object r14 = com.revenuecat.purchases.CoroutinesExtensionsKt.awaitCustomerInfo(r14, r12, r0)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            if (r14 != r1) goto L6d
            return r1
        L6d:
            com.revenuecat.purchases.CustomerInfo r14 = (com.revenuecat.purchases.CustomerInfo) r14     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r11.e0(r14)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            r13.invoke(r14)     // Catch: com.revenuecat.purchases.PurchasesException -> L38
            goto L9e
        L76:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Error fetching customer info: "
            r12.append(r13)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            android.util.Log.e(r4, r12)
            cz.mobilesoft.coreblock.util.CrashHelper r5 = cz.mobilesoft.coreblock.util.CrashHelper.f127788a
            r9 = 2
            r10 = 0
            java.lang.String r7 = "Error fetching customer info"
            r8 = 0
            cz.mobilesoft.coreblock.util.CrashHelper.m(r5, r6, r7, r8, r9, r10)
            goto L9e
        L95:
            java.lang.String r12 = "Purchases instance is not initialized, unable to update customer info!"
            int r12 = android.util.Log.e(r4, r12)
            kotlin.coroutines.jvm.internal.Boxing.d(r12)
        L9e:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.x(com.revenuecat.purchases.CacheFetchPolicy, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
