package cz.mobilesoft.coreblock.scene.premium.host;

import android.app.Application;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.scene.premium.NotInitializedException;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.usecase.YearlySavingsData;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class MySubscriptionPaywallViewModel extends PaywallHostViewModel {
    private final Lazy Z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f113147b;

        static {
            int[] iArr = new int[Product.SubscriptionPeriod.values().length];
            try {
                iArr[Product.SubscriptionPeriod.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Product.SubscriptionPeriod.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Product.SubscriptionPeriod.LIFETIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f113146a = iArr;
            int[] iArr2 = new int[Store.values().length];
            try {
                iArr2[Store.APP_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Store.PLAY_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Store.MAC_APP_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Store.STRIPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Store.PROMOTIONAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Store.UNKNOWN_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Store.AMAZON.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Store.RC_BILLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Store.EXTERNAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Store.PADDLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[Store.TEST_STORE.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            f113147b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MySubscriptionPaywallViewModel(Application application, PaywallTarget.MySubscription target, PaywallSpec spec, final PaywallHostViewModel.Launch launch) {
        super(application, target, spec, launch);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(launch, "launch");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.Z = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel$special$$inlined$inject$default$1
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
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.host.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MySubscriptionPaywallViewModel.O2(launch, (PremiumScreenViewState) obj);
            }
        });
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState O2(PaywallHostViewModel.Launch launch, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, new ProductPlanScreenTypeViewState(null, "", "", false, false, null, launch.c(), launch.d(), 57, null), null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2, 1, null);
    }

    private final Map P2() {
        Product.SubscriptionPeriod subscriptionPeriod = Product.SubscriptionPeriod.YEAR;
        return MapsKt.mapOf(TuplesKt.a("pro_01j9xk76mczaz22x8w8dxhq8x3", subscriptionPeriod), TuplesKt.a("pro_01j9xkbpyznbwwc975ycrf348a", subscriptionPeriod), TuplesKt.a("pro_01j9xjjchvcw4y4h8rdh9472g8", Product.SubscriptionPeriod.LIFETIME), TuplesKt.a("pro_01j9xk2g227ns4ejkakw74mher", Product.SubscriptionPeriod.MONTH));
    }

    private final String Q2(Store store) {
        switch (WhenMappings.f113147b[store.ordinal()]) {
            case 1:
                return "App Store";
            case 2:
                return "Google Play";
            case 3:
                return "Mac App Store";
            case 4:
                return "Stripe";
            case 5:
                return D0(R.string.nC);
            case 6:
                return "Unknown store";
            case 7:
                return "Amazon";
            case 8:
                return "RevenueCat Billing";
            case 9:
            case 10:
                return D0(R.string.oC);
            case 11:
                return "Test Store";
            default:
                return store.name();
        }
    }

    private final CoreDataStore R1() {
        return (CoreDataStore) this.Z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState R2(EntitlementInfo entitlementInfo, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, (entitlementInfo == null || entitlementInfo.getPeriodType() == PeriodType.TRIAL) ? false : true, false, false, -1073741825, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState S2(List list, String str, String str2, YearlySavingsData yearlySavingsData, EntitlementInfo entitlementInfo, MySubscriptionPaywallViewModel mySubscriptionPaywallViewModel, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, new ProductPlanScreenTypeViewState(list, str, str2, yearlySavingsData == null && entitlementInfo.getStore() == Store.PLAY_STORE && !updateState.w().isEmpty(), false, yearlySavingsData, mySubscriptionPaywallViewModel.F2().c(), mySubscriptionPaywallViewModel.F2().d(), 16, null), null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState T2(MySubscriptionPaywallViewModel mySubscriptionPaywallViewModel, List list, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, new ProductPlanScreenTypeViewState(CollectionsKt.listOf(TuplesKt.a(mySubscriptionPaywallViewModel.D0(R.string.Cq), list)), mySubscriptionPaywallViewModel.D0(R.string.iC), ExternalLinksHelper.f127866a.b(), !updateState.w().isEmpty(), true, null, mySubscriptionPaywallViewModel.F2().c(), mySubscriptionPaywallViewModel.F2().d(), 32, null), null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2, 1, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected void i2() {
        AnswersHelper.f128199a.g4();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel, cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: j2 */
    public void O0(PremiumScreenViewEvent event) throws NotInitializedException {
        Intrinsics.checkNotNullParameter(event, "event");
        super.O0(event);
        if (event instanceof PremiumScreenViewEvent.ManageSubscriptionClicked) {
            PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewStateX = ((PremiumScreenViewState) I0()).x();
            ProductPlanScreenTypeViewState productPlanScreenTypeViewState = premiumScreenTypeViewStateX instanceof ProductPlanScreenTypeViewState ? (ProductPlanScreenTypeViewState) premiumScreenTypeViewStateX : null;
            if (productPlanScreenTypeViewState != null) {
                ExternalLinksHelper.f127866a.d(A0(), productPlanScreenTypeViewState.l());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02af  */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object u2(com.revenuecat.purchases.CustomerInfo r20, java.util.List r21, com.revenuecat.purchases.Offering r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel.u2(com.revenuecat.purchases.CustomerInfo, java.util.List, com.revenuecat.purchases.Offering, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object z2(Offering offering, Continuation continuation) {
        return Intrinsics.areEqual(i1().J(), PremiumState.None.INSTANCE) ? super.z2(offering, continuation) : Boxing.a(false);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProductPlanScreenTypeViewState extends PremiumScreenViewState.PremiumScreenTypeViewState {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List f113136j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f113137k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f113138l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f113139m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f113140n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final YearlySavingsData f113141o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final boolean f113142p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f113143q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f113144r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final boolean f113145s;

        public ProductPlanScreenTypeViewState(List productPlanInfo, String productPlanManagementSubtitle, String productPlanManagementUrl, boolean z2, boolean z3, YearlySavingsData yearlySavingsData, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(productPlanInfo, "productPlanInfo");
            Intrinsics.checkNotNullParameter(productPlanManagementSubtitle, "productPlanManagementSubtitle");
            Intrinsics.checkNotNullParameter(productPlanManagementUrl, "productPlanManagementUrl");
            this.f113136j = productPlanInfo;
            this.f113137k = productPlanManagementSubtitle;
            this.f113138l = productPlanManagementUrl;
            this.f113139m = z2;
            this.f113140n = z3;
            this.f113141o = yearlySavingsData;
            this.f113142p = z4;
            this.f113143q = z5;
            this.f113144r = z4;
            this.f113145s = z5;
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean c() {
            return this.f113144r;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProductPlanScreenTypeViewState)) {
                return false;
            }
            ProductPlanScreenTypeViewState productPlanScreenTypeViewState = (ProductPlanScreenTypeViewState) obj;
            return Intrinsics.areEqual(this.f113136j, productPlanScreenTypeViewState.f113136j) && Intrinsics.areEqual(this.f113137k, productPlanScreenTypeViewState.f113137k) && Intrinsics.areEqual(this.f113138l, productPlanScreenTypeViewState.f113138l) && this.f113139m == productPlanScreenTypeViewState.f113139m && this.f113140n == productPlanScreenTypeViewState.f113140n && Intrinsics.areEqual(this.f113141o, productPlanScreenTypeViewState.f113141o) && this.f113142p == productPlanScreenTypeViewState.f113142p && this.f113143q == productPlanScreenTypeViewState.f113143q;
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean f() {
            return this.f113140n;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.f113136j.hashCode() * 31) + this.f113137k.hashCode()) * 31) + this.f113138l.hashCode()) * 31) + Boolean.hashCode(this.f113139m)) * 31) + Boolean.hashCode(this.f113140n)) * 31;
            YearlySavingsData yearlySavingsData = this.f113141o;
            return ((((iHashCode + (yearlySavingsData == null ? 0 : yearlySavingsData.hashCode())) * 31) + Boolean.hashCode(this.f113142p)) * 31) + Boolean.hashCode(this.f113143q);
        }

        @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
        public boolean i() {
            return this.f113145s;
        }

        public final List j() {
            return this.f113136j;
        }

        public final String k() {
            return this.f113137k;
        }

        public final String l() {
            return this.f113138l;
        }

        public final boolean m() {
            return this.f113139m;
        }

        public final YearlySavingsData n() {
            return this.f113141o;
        }

        public String toString() {
            return "ProductPlanScreenTypeViewState(productPlanInfo=" + this.f113136j + ", productPlanManagementSubtitle=" + this.f113137k + ", productPlanManagementUrl=" + this.f113138l + ", withOtherOptionsButton=" + this.f113139m + ", showAllAvailableOptions=" + this.f113140n + ", yearlySavings=" + this.f113141o + ", closeButton=" + this.f113142p + ", skipText=" + this.f113143q + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ ProductPlanScreenTypeViewState(java.util.List r2, java.lang.String r3, java.lang.String r4, boolean r5, boolean r6, cz.mobilesoft.coreblock.usecase.YearlySavingsData r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r1 = this;
                r11 = r10 & 1
                if (r11 == 0) goto L8
                java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            L8:
                r11 = r10 & 8
                r0 = 0
                if (r11 == 0) goto Le
                r5 = r0
            Le:
                r11 = r10 & 16
                if (r11 == 0) goto L13
                r6 = r0
            L13:
                r11 = r10 & 32
                if (r11 == 0) goto L18
                r7 = 0
            L18:
                r11 = r10 & 64
                if (r11 == 0) goto L1d
                r8 = 1
            L1d:
                r10 = r10 & 128(0x80, float:1.8E-43)
                if (r10 == 0) goto L2b
                r11 = r0
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                goto L34
            L2b:
                r11 = r9
                r10 = r8
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
            L34:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState.<init>(java.util.List, java.lang.String, java.lang.String, boolean, boolean, cz.mobilesoft.coreblock.usecase.YearlySavingsData, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
