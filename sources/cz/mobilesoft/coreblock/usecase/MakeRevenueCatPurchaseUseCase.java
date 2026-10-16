package cz.mobilesoft.coreblock.usecase;

import android.app.Activity;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class MakeRevenueCatPurchaseUseCase extends FlowUseCase<Params, DataState<? extends PurchaseResult>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127192b;

    /* JADX WARN: Multi-variable type inference failed */
    public MakeRevenueCatPurchaseUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127191a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase$special$$inlined$inject$default$1
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
        this.f127192b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.MakeRevenueCatPurchaseUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr2, objArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore c() {
        return (DiscountDataStore) this.f127192b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 d() {
        return (PremiumRepositoryV2) this.f127191a.getValue();
    }

    public Flow e(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new MakeRevenueCatPurchaseUseCase$invoke$1(params, this, null));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f127193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Package f127194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SubscriptionOption f127195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final StoreProduct f127196d;

        public Params(Activity activity, Package r3, SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f127193a = activity;
            this.f127194b = r3;
            this.f127195c = subscriptionOption;
            this.f127196d = storeProduct;
        }

        public final Activity a() {
            return this.f127193a;
        }

        public final Package b() {
            return this.f127194b;
        }

        public final StoreProduct c() {
            return this.f127196d;
        }

        public final SubscriptionOption d() {
            return this.f127195c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127193a, params.f127193a) && Intrinsics.areEqual(this.f127194b, params.f127194b) && Intrinsics.areEqual(this.f127195c, params.f127195c) && Intrinsics.areEqual(this.f127196d, params.f127196d);
        }

        public int hashCode() {
            int iHashCode = this.f127193a.hashCode() * 31;
            Package r12 = this.f127194b;
            int iHashCode2 = (iHashCode + (r12 == null ? 0 : r12.hashCode())) * 31;
            SubscriptionOption subscriptionOption = this.f127195c;
            int iHashCode3 = (iHashCode2 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31;
            StoreProduct storeProduct = this.f127196d;
            return iHashCode3 + (storeProduct != null ? storeProduct.hashCode() : 0);
        }

        public String toString() {
            return "Params(activity=" + this.f127193a + ", packageToPurchase=" + this.f127194b + ", subscriptionOption=" + this.f127195c + ", storeProduct=" + this.f127196d + ")";
        }

        public /* synthetic */ Params(Activity activity, Package r3, SubscriptionOption subscriptionOption, StoreProduct storeProduct, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(activity, (i3 & 2) != 0 ? null : r3, (i3 & 4) != 0 ? null : subscriptionOption, (i3 & 8) != 0 ? null : storeProduct);
        }
    }
}
