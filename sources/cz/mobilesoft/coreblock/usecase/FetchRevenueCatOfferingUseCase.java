package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumDTOsKt;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceStore;
import cz.mobilesoft.coreblock.util.paywalltrace.RuleOutcome;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
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
public final class FetchRevenueCatOfferingUseCase extends FlowUseCase<Params, DataState<? extends Offering>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127049d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FetchOfferingsSource {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FetchOfferingsSource[] $VALUES;
        public static final FetchOfferingsSource TrialCheck = new FetchOfferingsSource("TrialCheck", 0);
        public static final FetchOfferingsSource PurchaseScreen = new FetchOfferingsSource("PurchaseScreen", 1);
        public static final FetchOfferingsSource ReferralScreen = new FetchOfferingsSource("ReferralScreen", 2);

        private static final /* synthetic */ FetchOfferingsSource[] $values() {
            return new FetchOfferingsSource[]{TrialCheck, PurchaseScreen, ReferralScreen};
        }

        static {
            FetchOfferingsSource[] fetchOfferingsSourceArr$values = $values();
            $VALUES = fetchOfferingsSourceArr$values;
            $ENTRIES = EnumEntriesKt.a(fetchOfferingsSourceArr$values);
        }

        private FetchOfferingsSource(String str, int i3) {
        }

        public static EnumEntries<FetchOfferingsSource> getEntries() {
            return $ENTRIES;
        }

        public static FetchOfferingsSource valueOf(String str) {
            return (FetchOfferingsSource) Enum.valueOf(FetchOfferingsSource.class, str);
        }

        public static FetchOfferingsSource[] values() {
            return (FetchOfferingsSource[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RevenueCatPlacement f127050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FetchOfferingsSource f127051b;

        public Params(RevenueCatPlacement revenueCatPlacement, FetchOfferingsSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f127050a = revenueCatPlacement;
            this.f127051b = source;
        }

        public final RevenueCatPlacement a() {
            return this.f127050a;
        }

        public final FetchOfferingsSource b() {
            return this.f127051b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f127050a == params.f127050a && this.f127051b == params.f127051b;
        }

        public int hashCode() {
            RevenueCatPlacement revenueCatPlacement = this.f127050a;
            return ((revenueCatPlacement == null ? 0 : revenueCatPlacement.hashCode()) * 31) + this.f127051b.hashCode();
        }

        public String toString() {
            return "Params(placement=" + this.f127050a + ", source=" + this.f127051b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchRevenueCatOfferingUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127046a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$special$$inlined$inject$default$1
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
        this.f127047b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$special$$inlined$inject$default$2
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
        this.f127048c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127049d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr6, objArr7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        if (r11 == r1) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[Catch: PurchasesException -> 0x003c, TRY_ENTER, TryCatch #0 {PurchasesException -> 0x003c, blocks: (B:14:0x0037, B:38:0x00bb, B:35:0x00a4), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.revenuecat.purchases.Purchases, cz.mobilesoft.coreblock.enums.RevenueCatOffering, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.revenuecat.purchases.Purchases, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(com.revenuecat.purchases.Purchases r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase.h(com.revenuecat.purchases.Purchases, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Long i(Offering offering) {
        PricingPhase introPhase;
        Price price;
        Package annual = offering.getAnnual();
        StoreProduct product = annual != null ? annual.getProduct() : null;
        GoogleStoreProduct googleStoreProduct = product instanceof GoogleStoreProduct ? (GoogleStoreProduct) product : null;
        if (googleStoreProduct == null) {
            return null;
        }
        Object obj = offering.getMetadata().get("introOffer");
        GoogleSubscriptionOption googleSubscriptionOptionA = PremiumDTOsKt.a(googleStoreProduct, obj instanceof String ? (String) obj : null, false);
        if (googleSubscriptionOptionA == null || (introPhase = googleSubscriptionOptionA.getIntroPhase()) == null || (price = introPhase.getPrice()) == null) {
            return null;
        }
        return Long.valueOf(price.getAmountMicros());
    }

    private final DevDataStore j() {
        return (DevDataStore) this.f127047b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore k() {
        return (DiscountDataStore) this.f127048c.getValue();
    }

    private final DiscountRepository l() {
        return (DiscountRepository) this.f127049d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 m() {
        return (PremiumRepositoryV2) this.f127046a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(Offering offering, Offering offering2) {
        Long lI = i(offering);
        if (lI == null) {
            return false;
        }
        long jLongValue = lI.longValue();
        Long lI2 = i(offering2);
        return lI2 == null || jLongValue < lI2.longValue();
    }

    private final boolean p(Offering offering) {
        PresentedOfferingContext presentedOfferingContext;
        Package r12 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
        return ((r12 == null || (presentedOfferingContext = r12.getPresentedOfferingContext()) == null) ? null : presentedOfferingContext.getPlacementIdentifier()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(com.revenuecat.purchases.Purchases r5, java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$placementOffering$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$placementOffering$1 r0 = (cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$placementOffering$1) r0
            int r1 = r0.f127076f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127076f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$placementOffering$1 r0 = new cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$placementOffering$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f127074c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127076f
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.f127073b
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.f127072a
            com.revenuecat.purchases.Purchases r5 = (com.revenuecat.purchases.Purchases) r5
            kotlin.ResultKt.b(r7)
            goto L4e
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f127072a = r7
            r0.f127073b = r6
            r0.f127076f = r3
            java.lang.Object r7 = com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitOfferings(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            com.revenuecat.purchases.Offerings r7 = (com.revenuecat.purchases.Offerings) r7
            if (r6 != 0) goto L54
            java.lang.String r6 = ""
        L54:
            com.revenuecat.purchases.Offering r5 = r7.getCurrentOfferingForPlacement(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase.q(com.revenuecat.purchases.Purchases, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(RevenueCatPlacement revenueCatPlacement, FetchOfferingsSource fetchOfferingsSource, Offering offering, List list) {
        String id;
        List listA;
        boolean zP = p(offering);
        long jCurrentTimeMillis = System.currentTimeMillis();
        PaywallTrace.Stage stage = PaywallTrace.Stage.OfferingResolution;
        String identifier = offering.getIdentifier();
        String str = zP ? "" : " (No Placement)";
        if (revenueCatPlacement == null || (id = revenueCatPlacement.getId()) == null) {
            id = "no placement";
        }
        String str2 = identifier + str + " for " + id;
        Set setEmptySet = null;
        String id2 = revenueCatPlacement != null ? revenueCatPlacement.getId() : null;
        String identifier2 = offering.getIdentifier();
        Boolean boolValueOf = Boolean.valueOf(zP);
        List listPlus = CollectionsKt.plus((Collection<? extends RuleOutcome>) list, new RuleOutcome("requested from", fetchOfferingsSource.name(), false, 4, null));
        CustomerInfo customerInfoB = m().B();
        if (customerInfoB != null && (listA = RevenueCatExtKt.a(customerInfoB)) != null) {
            List list2 = listA;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Entitlement) it.next()).getId());
            }
            setEmptySet = CollectionsKt.toSet(arrayList);
        }
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        PaywallTrace paywallTrace = new PaywallTrace(jCurrentTimeMillis, stage, str2, id2, null, identifier2, boolValueOf, listPlus, null, setEmptySet, 0, 1296, null);
        if (fetchOfferingsSource == FetchOfferingsSource.TrialCheck) {
            PaywallTraceStore.f128981a.d(paywallTrace);
        } else {
            PaywallTraceStore.f128981a.c(paywallTrace);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Offering s(Offering offering, String str) {
        return str == null ? offering : offering.copy(new PresentedOfferingContext(offering.getIdentifier(), str, null));
    }

    public Flow o(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new FetchRevenueCatOfferingUseCase$invoke$1(this, params, null));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
