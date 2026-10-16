package cz.mobilesoft.coreblock.util.superwall;

import android.app.Activity;
import android.util.Log;
import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.Period;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.delegate.PurchaseResult;
import com.superwall.sdk.delegate.RestorationResult;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SuperwallPurchaseController implements PurchaseController, KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f129753g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f129754h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f129755a = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f129756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f129757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f129758d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile PurchaseInfo f129759f;

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
    public static final class PurchaseInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f129760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f129761b;

        public PurchaseInfo(boolean z2, int i3) {
            this.f129760a = z2;
            this.f129761b = i3;
        }

        public final int a() {
            return this.f129761b;
        }

        public final boolean b() {
            return this.f129760a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PurchaseInfo)) {
                return false;
            }
            PurchaseInfo purchaseInfo = (PurchaseInfo) obj;
            return this.f129760a == purchaseInfo.f129760a && this.f129761b == purchaseInfo.f129761b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f129760a) * 31) + Integer.hashCode(this.f129761b);
        }

        public String toString() {
            return "PurchaseInfo(wasTrialPurchased=" + this.f129760a + ", trialDays=" + this.f129761b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f129762a;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f129762a = iArr;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$purchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController", f = "SuperwallPurchaseController.kt", l = {88, 154}, m = "purchase", v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f129780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f129781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f129782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f129783d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f129784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f129785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f129786h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f129787i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f129788j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f129789k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f129791m;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f129789k = obj;
            this.f129791m |= Integer.MIN_VALUE;
            return SuperwallPurchaseController.this.purchase((Activity) null, (ProductDetails) null, (String) null, (String) null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SuperwallPurchaseController() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f129756b = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f129757c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<MakeRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$special$$inlined$inject$default$2
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
        this.f129758d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<RestoreRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$special$$inlined$inject$default$3
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
    }

    private final String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (str2 != null) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2);
        }
        return sb.toString();
    }

    private final MakeRevenueCatPurchaseUseCase g() {
        return (MakeRevenueCatPurchaseUseCase) this.f129757c.getValue();
    }

    private final PremiumRepositoryV2 h() {
        return (PremiumRepositoryV2) this.f129756b.getValue();
    }

    private final RestoreRevenueCatPurchaseUseCase i() {
        return (RestoreRevenueCatPurchaseUseCase) this.f129758d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(CustomerInfo customerInfo) {
        SubscriptionStatus active;
        if (Superwall.Companion.getInitialized()) {
            List listA = RevenueCatExtKt.a(customerInfo);
            if (listA.isEmpty()) {
                active = SubscriptionStatus.Inactive.INSTANCE;
            } else {
                List list = listA;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Entitlement(((cz.mobilesoft.coreblock.enums.Entitlement) it.next()).getId(), Entitlement.Type.SERVICE_LEVEL));
                }
                active = new SubscriptionStatus.Active(CollectionsKt.toSet(arrayList));
            }
            Log.d("SuperwallPurchaseCtrl", "Syncing subscription status to Superwall: " + active);
            Superwall.Companion.getInstance().setSubscriptionStatus(active);
        }
    }

    public final PurchaseInfo f() {
        return this.f129759f;
    }

    public final void j() {
        FlowExtKt.i(h().C(), this.f129755a, new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$startSyncingSubscriptionStatus$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(CustomerInfo customerInfo, Continuation continuation) {
                if (customerInfo != null) {
                    this.f129817a.k(customerInfo);
                }
                return Unit.f139807a;
            }
        });
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    public /* bridge */ Object purchase(Activity activity, StoreProduct storeProduct, String str, String str2, Continuation continuation) {
        return PurchaseController.DefaultImpls.purchase(this, activity, storeProduct, str, str2, (Continuation<? super PurchaseResult>) continuation);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    public Object restorePurchases(Continuation continuation) {
        this.f129759f = null;
        final Flow flowE = i().e(RestoreRevenueCatPurchaseUseCase.Params.f127233a);
        return FlowKt.D(new Flow<RestorationResult>() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f129797a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ SuperwallPurchaseController f129798b;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2", f = "SuperwallPurchaseController.kt", l = {64}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f129799a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f129800b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f129801c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f129803f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f129804g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f129805h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    Object f129806i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    int f129807j;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f129799a = obj;
                        this.f129800b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, SuperwallPurchaseController superwallPurchaseController) {
                    this.f129797a = flowCollector;
                    this.f129798b = superwallPurchaseController;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2$1 r0 = (cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f129800b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f129800b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2$1 r0 = new cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f129799a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f129800b
                        r3 = 1
                        if (r2 == 0) goto L3e
                        if (r2 != r3) goto L36
                        java.lang.Object r7 = r0.f129806i
                        com.superwall.sdk.delegate.RestorationResult r7 = (com.superwall.sdk.delegate.RestorationResult) r7
                        java.lang.Object r7 = r0.f129805h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f129803f
                        cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1$2$1 r7 = (cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto Laa
                    L36:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L3e:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f129797a
                        r2 = r7
                        cz.mobilesoft.coreblock.util.DataState r2 = (cz.mobilesoft.coreblock.util.DataState) r2
                        boolean r4 = r2 instanceof cz.mobilesoft.coreblock.util.DataState.Success
                        if (r4 == 0) goto L5d
                        cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController r4 = r6.f129798b
                        cz.mobilesoft.coreblock.util.DataState$Success r2 = (cz.mobilesoft.coreblock.util.DataState.Success) r2
                        java.lang.Object r2 = r2.a()
                        com.revenuecat.purchases.CustomerInfo r2 = (com.revenuecat.purchases.CustomerInfo) r2
                        cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController.c(r4, r2)
                        com.superwall.sdk.delegate.RestorationResult$Restored r2 = new com.superwall.sdk.delegate.RestorationResult$Restored
                        r2.<init>()
                        goto L7e
                    L5d:
                        boolean r4 = r2 instanceof cz.mobilesoft.coreblock.util.DataState.Error
                        if (r4 == 0) goto L7d
                        com.superwall.sdk.delegate.RestorationResult$Failed r4 = new com.superwall.sdk.delegate.RestorationResult$Failed
                        cz.mobilesoft.coreblock.util.DataState$Error r2 = (cz.mobilesoft.coreblock.util.DataState.Error) r2
                        java.lang.Throwable r5 = r2.c()
                        if (r5 != 0) goto L78
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r2 = r2.b()
                        if (r2 != 0) goto L75
                        java.lang.String r2 = "Restore failed"
                    L75:
                        r5.<init>(r2)
                    L78:
                        r4.<init>(r5)
                        r2 = r4
                        goto L7e
                    L7d:
                        r2 = 0
                    L7e:
                        if (r2 == 0) goto Laa
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f129801c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f129803f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f129804g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f129805h = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
                        r0.f129806i = r7
                        r7 = 0
                        r0.f129807j = r7
                        r0.f129800b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto Laa
                        return r1
                    Laa:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$restorePurchases$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = flowE.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(com.superwall.sdk.paywall.presentation.PaywallInfo r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$tagCustomerWithSuperwallExperiment$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$tagCustomerWithSuperwallExperiment$1 r0 = (cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$tagCustomerWithSuperwallExperiment$1) r0
            int r1 = r0.f129823g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129823g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$tagCustomerWithSuperwallExperiment$1 r0 = new cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController$tagCustomerWithSuperwallExperiment$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f129821d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129823g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f129820c
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r1 = r0.f129819b
            com.revenuecat.purchases.Purchases r1 = (com.revenuecat.purchases.Purchases) r1
            java.lang.Object r0 = r0.f129818a
            com.superwall.sdk.paywall.presentation.PaywallInfo r0 = (com.superwall.sdk.paywall.presentation.PaywallInfo) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Exception -> L35
            goto L95
        L35:
            r7 = move-exception
            goto Lac
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r8 = 0
            java.lang.String r8 = com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW.RnG
            r7.<init>(r8)
            throw r7
        L41:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r8 = r6.h()
            com.revenuecat.purchases.Purchases r8 = r8.L()
            if (r8 != 0) goto L51
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L51:
            if (r7 != 0) goto L56
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L56:
            java.lang.String r2 = "superwall_paywall_id"
            java.lang.String r4 = r7.getIdentifier()
            kotlin.Pair r2 = kotlin.TuplesKt.a(r2, r4)
            com.superwall.sdk.models.triggers.Experiment r4 = r7.getExperiment()
            if (r4 == 0) goto L6b
            java.lang.String r4 = r4.getId()
            goto L6c
        L6b:
            r4 = 0
        L6c:
            java.lang.String r5 = "superwall_experiment_id"
            kotlin.Pair r4 = kotlin.TuplesKt.a(r5, r4)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r4}
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r2)
            r8.setAttributes(r2)     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)     // Catch: java.lang.Exception -> L35
            r0.f129818a = r7     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: java.lang.Exception -> L35
            r0.f129819b = r7     // Catch: java.lang.Exception -> L35
            r0.f129820c = r2     // Catch: java.lang.Exception -> L35
            r0.f129823g = r3     // Catch: java.lang.Exception -> L35
            java.lang.Object r7 = com.revenuecat.purchases.CoroutinesExtensionsKt.awaitSyncAttributesAndOfferingsIfNeeded(r8, r0)     // Catch: java.lang.Exception -> L35
            if (r7 != r1) goto L94
            return r1
        L94:
            r7 = r2
        L95:
            java.lang.String r8 = "SuperwallPurchaseCtrl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r0.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "Tagged RevenueCat customer with "
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            r0.append(r7)     // Catch: java.lang.Exception -> L35
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Exception -> L35
            android.util.Log.d(r8, r7)     // Catch: java.lang.Exception -> L35
            goto Laf
        Lac:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r7)
        Laf:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController.l(com.superwall.sdk.paywall.presentation.PaywallInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object purchase(android.app.Activity r19, com.android.billingclient.api.ProductDetails r20, java.lang.String r21, java.lang.String r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController.purchase(android.app.Activity, com.android.billingclient.api.ProductDetails, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
