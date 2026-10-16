package com.superwall.sdk.paywall.request;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.TrackingResult;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.paywall.IntroOfferEligibility;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductVariable;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

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
public final class PaywallLogic {
    public static final PaywallLogic INSTANCE = new PaywallLogic();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntroOfferEligibility.values().length];
            try {
                iArr[IntroOfferEligibility.INELIGIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntroOfferEligibility.ELIGIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IntroOfferEligibility.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallLogic$handlePaywallError$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallLogic$handlePaywallError$1", f = "PaywallLogic.kt", l = {62}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Trackable, Continuation<? super Result<? extends TrackingResult>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Trackable trackable, Continuation<? super Result<TrackingResult>> continuation) {
            return ((AnonymousClass1) create(trackable, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objTrack;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Trackable trackable = (Trackable) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                objTrack = TrackingKt.track(companion, trackable, this);
                if (objTrack == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objTrack = ((Result) obj).j();
            }
            return Result.a(objTrack);
        }
    }

    private PaywallLogic() {
    }

    private final boolean computeHasFreeTrial(List<ProductItem> list, Map<String, StoreProduct> map, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility) {
        CustomerInfo customerInfo2;
        IntroOfferEligibility introOfferEligibility2;
        boolean zIsWebTrialAvailable;
        List<ProductItem> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (ProductItem productItem : list2) {
            ProductItem.StoreProductType type = productItem.getType();
            if ((type instanceof ProductItem.StoreProductType.PlayStore) || (type instanceof ProductItem.StoreProductType.AppStore) || (type instanceof ProductItem.StoreProductType.Other)) {
                customerInfo2 = customerInfo;
                introOfferEligibility2 = introOfferEligibility;
                StoreProduct storeProduct = map.get(productItem.getFullProductId());
                zIsWebTrialAvailable = storeProduct != null && storeProduct.getHasFreeTrial();
            } else if (type instanceof ProductItem.StoreProductType.Stripe) {
                customerInfo2 = customerInfo;
                introOfferEligibility2 = introOfferEligibility;
                zIsWebTrialAvailable = INSTANCE.isWebTrialAvailable(productItem.getName(), ((ProductItem.StoreProductType.Stripe) type).getProduct().getTrialDays(), productItem.getEntitlements(), customerInfo2, introOfferEligibility2);
            } else {
                customerInfo2 = customerInfo;
                introOfferEligibility2 = introOfferEligibility;
                if (type instanceof ProductItem.StoreProductType.Paddle) {
                    zIsWebTrialAvailable = INSTANCE.isWebTrialAvailable(productItem.getName(), ((ProductItem.StoreProductType.Paddle) type).getProduct().getTrialDays(), productItem.getEntitlements(), customerInfo2, introOfferEligibility2);
                } else {
                    if (!(type instanceof ProductItem.StoreProductType.Custom)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StoreProduct storeProduct2 = map.get(productItem.getFullProductId());
                    zIsWebTrialAvailable = INSTANCE.isWebTrialAvailable(productItem.getName(), Integer.valueOf(storeProduct2 != null ? storeProduct2.getTrialPeriodDays() : 0), productItem.getEntitlements(), customerInfo2, introOfferEligibility2);
                }
            }
            if (zIsWebTrialAvailable) {
                return true;
            }
            customerInfo = customerInfo2;
            introOfferEligibility = introOfferEligibility2;
        }
        return false;
    }

    public static /* synthetic */ ProductProcessingOutcome getVariablesAndFreeTrial$default(PaywallLogic paywallLogic, List list, Map map, Boolean bool, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            introOfferEligibility = IntroOfferEligibility.AUTOMATIC;
        }
        return paywallLogic.getVariablesAndFreeTrial(list, map, bool, customerInfo, introOfferEligibility);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Throwable handlePaywallError$default(PaywallLogic paywallLogic, Throwable th, EventData eventData, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        return paywallLogic.handlePaywallError(th, eventData, function2);
    }

    private final boolean hasEverHadEntitlement(Set<Entitlement> set, CustomerInfo customerInfo) {
        if (customerInfo.isPlaceholder$superwall_release()) {
            return true;
        }
        Set setU = SequencesKt.U(SequencesKt.M(SequencesKt.A(CollectionsKt.asSequence(customerInfo.getEntitlements()), new Function1() { // from class: com.superwall.sdk.paywall.request.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PaywallLogic.hasEverHadEntitlement$lambda$2((Entitlement) obj));
            }
        }), new Function1() { // from class: com.superwall.sdk.paywall.request.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallLogic.hasEverHadEntitlement$lambda$3((Entitlement) obj);
            }
        }));
        Set<Entitlement> set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            if (setU.contains(((Entitlement) it.next()).getId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasEverHadEntitlement$lambda$2(Entitlement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLatestProductId() != null || it.getStore() == Store.SUPERWALL || it.isActive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hasEverHadEntitlement$lambda$3(Entitlement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    public static /* synthetic */ boolean isFreeTrialEligibleForCustomProduct$default(PaywallLogic paywallLogic, StoreProduct storeProduct, Set set, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            introOfferEligibility = IntroOfferEligibility.AUTOMATIC;
        }
        return paywallLogic.isFreeTrialEligibleForCustomProduct(storeProduct, set, customerInfo, introOfferEligibility);
    }

    private final boolean isWebTrialAvailable(String str, Integer num, Set<Entitlement> set, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility) {
        int i3;
        if ((num != null ? num.intValue() : 0) <= 0 || (i3 = WhenMappings.$EnumSwitchMapping$0[introOfferEligibility.ordinal()]) == 1) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!set.isEmpty()) {
            return !hasEverHadEntitlement(set, customerInfo);
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallPresentation, str + " has trialDays > 0 but no entitlements — skipping trial eligibility check", (Map) null, (Throwable) null, 24, (Object) null);
        return false;
    }

    public static /* synthetic */ String requestHash$default(PaywallLogic paywallLogic, String str, EventData eventData, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            eventData = null;
        }
        return paywallLogic.requestHash(str, eventData, str2, str3);
    }

    public final ProductProcessingOutcome getVariablesAndFreeTrial(List<ProductItem> productItems, Map<String, StoreProduct> productsByFullId, Boolean bool, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility) {
        Intrinsics.checkNotNullParameter(productItems, "productItems");
        Intrinsics.checkNotNullParameter(productsByFullId, "productsByFullId");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(introOfferEligibility, "introOfferEligibility");
        ArrayList arrayList = new ArrayList();
        for (ProductItem productItem : productItems) {
            StoreProduct storeProduct = productsByFullId.get(productItem.getFullProductId());
            if (storeProduct != null) {
                arrayList.add(new ProductVariable(productItem.getName(), storeProduct.getAttributes()));
            }
        }
        return new ProductProcessingOutcome(arrayList, bool != null ? bool.booleanValue() : computeHasFreeTrial(productItems, productsByFullId, customerInfo, introOfferEligibility));
    }

    public final Throwable handlePaywallError(Throwable error, EventData eventData, Function2<? super Trackable, ? super Continuation<? super Result<TrackingResult>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (function2 == null) {
            new AnonymousClass1(null);
        }
        return new Exception("Not Found");
    }

    public final boolean isFreeTrialEligibleForCustomProduct(StoreProduct product, Set<Entitlement> entitlements, CustomerInfo customerInfo, IntroOfferEligibility introOfferEligibility) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(introOfferEligibility, "introOfferEligibility");
        return isWebTrialAvailable(product.getFullIdentifier(), Integer.valueOf(product.getTrialPeriodDays()), entitlements, customerInfo, introOfferEligibility);
    }

    public final String requestHash(String str, EventData eventData, String locale, String str2) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (str == null) {
            str = eventData != null ? eventData.getName() : null;
            if (str == null) {
                str = "$called_manually";
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        return str + "_" + locale + "_" + ((Object) str2);
    }
}
