package cz.mobilesoft.coreblock.base.viewmodel;

import android.app.Activity;
import android.app.Application;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
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
public abstract class BaseBillingViewModel<STATE extends ViewState, EVENT extends ViewEvent, COMMAND extends ViewCommand> extends BaseStatefulViewModel<STATE, EVENT, COMMAND> {
    public static final Companion A = new Companion(null);
    public static final int B = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f96349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f96350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f96351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f96352r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f96353s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f96354t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableStateFlow f96355u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableStateFlow f96356v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MutableStateFlow f96357w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MutableSharedFlow f96358x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Offering f96359y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RevenueCatPlacement f96360z;

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
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96364a;

        static {
            int[] iArr = new int[PurchasesErrorCode.values().length];
            try {
                iArr[PurchasesErrorCode.PurchaseInvalidError.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchasesErrorCode.IneligibleError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchasesErrorCode.NetworkError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchasesErrorCode.UnknownError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f96364a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseBillingViewModel(Application application, ViewState initialState) {
        super(application, initialState);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f96349o = LazyKt.a(lazyThreadSafetyModeB, new Function0<FetchRevenueCatOfferingUseCase>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchRevenueCatOfferingUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f96350p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<MakeRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(MakeRevenueCatPurchaseUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f96351q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<RestoreRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreRevenueCatPurchaseUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f96352r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f96353s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f96354t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<FacebookLogger>() { // from class: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FacebookLogger.class), objArr10, objArr11);
            }
        });
        this.f96355u = StateFlowKt.a(new RevenueCatProducts(null, null, null, 7, null));
        this.f96356v = StateFlowKt.a(Loading.f127895a);
        this.f96357w = StateFlowKt.a(Success.f128020a);
        this.f96358x = SharedFlowKt.b(0, 0, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore c1() {
        return (DevDataStore) this.f96353s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FacebookLogger d1() {
        return (FacebookLogger) this.f96354t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchRevenueCatOfferingUseCase e1() {
        return (FetchRevenueCatOfferingUseCase) this.f96349o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MakeRevenueCatPurchaseUseCase f1() {
        return (MakeRevenueCatPurchaseUseCase) this.f96350p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RestoreRevenueCatPurchaseUseCase l1() {
        return (RestoreRevenueCatPurchaseUseCase) this.f96351q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(PurchasesErrorCode purchasesErrorCode) {
        MutableSharedFlow mutableSharedFlow = this.f96358x;
        int i3 = WhenMappings.f96364a[purchasesErrorCode.ordinal()];
        z0(mutableSharedFlow, i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? purchasesErrorCode.getDescription() : A0().getString(R.string.Vz) : A0().getString(R.string.qD) : A0().getString(R.string.Sq) : A0().getString(R.string.Tq) : A0().getString(R.string.xd));
    }

    public final StateFlow b1() {
        return FlowKt.c(this.f96356v);
    }

    protected final Offering g1() {
        return this.f96359y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RevenueCatPlacement h1() {
        return this.f96360z;
    }

    protected final PremiumRepositoryV2 i1() {
        return (PremiumRepositoryV2) this.f96352r.getValue();
    }

    public final StateFlow j1() {
        return FlowKt.c(this.f96355u);
    }

    public final SharedFlow k1() {
        return FlowKt.b(this.f96358x);
    }

    public final void n1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BaseBillingViewModel$initInAppBilling$1(this, null), 3, null);
    }

    public void o1(PurchaseResult purchaseResult, boolean z2) {
        z0(this.f96357w, Success.f128020a);
    }

    public abstract void p1();

    public final void q1(Activity activity, String newProductId, GoogleSubscriptionOption googleSubscriptionOption) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newProductId, "newProductId");
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BaseBillingViewModel$purchase$1(this, newProductId, activity, googleSubscriptionOption, null), 3, null);
    }

    protected final void r1(Offering offering) {
        this.f96359y = offering;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s1(RevenueCatPlacement revenueCatPlacement) {
        this.f96360z = revenueCatPlacement;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RevenueCatProducts {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Offering f96361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f96362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f96363c;

        public RevenueCatProducts(Offering offering, Map packages, Map metadata) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.f96361a = offering;
            this.f96362b = packages;
            this.f96363c = metadata;
        }

        public final Map a() {
            return this.f96363c;
        }

        public final Offering b() {
            return this.f96361a;
        }

        public final Map c() {
            return this.f96362b;
        }

        public final boolean d() {
            return RevenueCatExtKt.f(this.f96362b.values());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RevenueCatProducts)) {
                return false;
            }
            RevenueCatProducts revenueCatProducts = (RevenueCatProducts) obj;
            return Intrinsics.areEqual(this.f96361a, revenueCatProducts.f96361a) && Intrinsics.areEqual(this.f96362b, revenueCatProducts.f96362b) && Intrinsics.areEqual(this.f96363c, revenueCatProducts.f96363c);
        }

        public int hashCode() {
            Offering offering = this.f96361a;
            return ((((offering == null ? 0 : offering.hashCode()) * 31) + this.f96362b.hashCode()) * 31) + this.f96363c.hashCode();
        }

        public String toString() {
            return "RevenueCatProducts(offering=" + this.f96361a + ", packages=" + this.f96362b + ", metadata=" + this.f96363c + ")";
        }

        public /* synthetic */ RevenueCatProducts(Offering offering, Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : offering, (i3 & 2) != 0 ? MapsKt.emptyMap() : map, (i3 & 4) != 0 ? MapsKt.emptyMap() : map2);
        }
    }
}
