package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
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
public final class CalculateYearlySavingsUseCase extends SuspendUseCase<Params, YearlySavingsData> implements KoinComponent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f126952d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f126953f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f126954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f126955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f126956c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YearlySavingsData a(Offering offering) {
            StoreProduct product;
            Price price;
            Package annual;
            StoreProduct product2;
            Price price2;
            Intrinsics.checkNotNullParameter(offering, "offering");
            Package monthly = offering.getMonthly();
            if (monthly == null || (product = monthly.getProduct()) == null || (price = product.getPrice()) == null || (annual = offering.getAnnual()) == null || (product2 = annual.getProduct()) == null || (price2 = product2.getPrice()) == null) {
                return null;
            }
            long amountMicros = price.getAmountMicros() * ((long) 12);
            long amountMicros2 = amountMicros - price2.getAmountMicros();
            if (amountMicros2 <= 0) {
                return null;
            }
            String currencyCode = price2.getCurrencyCode();
            return new YearlySavingsData(StringHelper.b(currencyCode, (int) (amountMicros2 / ((long) 1000000))), (int) ((((long) 100) * amountMicros2) / amountMicros), MathKt.c((amountMicros2 * ((double) 100)) / amountMicros), StringHelper.a(currencyCode, price2.getAmountMicros() / ((double) 1000000)), StringHelper.a(currencyCode, price2.getAmountMicros() / ((double) 12000000)));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f126957a = new Params();

        private Params() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CalculateYearlySavingsUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f126954a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase$special$$inlined$inject$default$1
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
        this.f126955b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f126956c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr4, objArr5);
            }
        });
    }

    private final CoreDataStore a() {
        return (CoreDataStore) this.f126956c.getValue();
    }

    private final DiscountRepository b() {
        return (DiscountRepository) this.f126955b.getValue();
    }

    private final PremiumRepositoryV2 c() {
        return (PremiumRepositoryV2) this.f126954a.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
    
        if (r11 != r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase.Params r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase.d(cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
