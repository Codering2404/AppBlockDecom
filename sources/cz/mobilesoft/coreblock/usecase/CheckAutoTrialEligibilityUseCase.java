package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class CheckAutoTrialEligibilityUseCase extends FlowUseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f126972f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f126973g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f126974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f126975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f126976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f126977d;

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
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f126978a = new Params();

        private Params() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckAutoTrialEligibilityUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f126974a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$special$$inlined$inject$default$1
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
        this.f126975b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$special$$inlined$inject$default$2
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
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f126976c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$special$$inlined$inject$default$3
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
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f126977d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr6, objArr7);
            }
        });
    }

    private final CoreDataStore b() {
        return (CoreDataStore) this.f126976c.getValue();
    }

    private final DevDataStore c() {
        return (DevDataStore) this.f126977d.getValue();
    }

    private final DiscountDataStore d() {
        return (DiscountDataStore) this.f126975b.getValue();
    }

    private final PremiumRepositoryV2 e() {
        return (PremiumRepositoryV2) this.f126974a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(CustomerInfo customerInfo, boolean z2) {
        Collection<EntitlementInfo> collectionValues = customerInfo.getEntitlements().getAll().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Date expirationDate = ((EntitlementInfo) it.next()).getExpirationDate();
            Long lValueOf = expirationDate != null ? Long.valueOf(expirationDate.getTime()) : null;
            if (lValueOf != null) {
                arrayList.add(lValueOf);
            }
        }
        Long l3 = (Long) CollectionsKt.maxOrNull((Iterable) arrayList);
        return (((TimeHelperExt.f128663a.f() - (l3 != null ? l3.longValue() : customerInfo.getFirstSeen().getTime())) > ((!z2 || !BuildConfig.f95357b.booleanValue()) ? TimeUnit.DAYS.toMillis(180L) : TimeUnit.MINUTES.toMillis(3L)) ? 1 : ((TimeHelperExt.f128663a.f() - (l3 != null ? l3.longValue() : customerInfo.getFirstSeen().getTime())) == ((!z2 || !BuildConfig.f95357b.booleanValue()) ? TimeUnit.DAYS.toMillis(180L) : TimeUnit.MINUTES.toMillis(3L)) ? 0 : -1)) >= 0) && (customerInfo.getEntitlements().getAll().get(Entitlement.FreeMonthPremium.getId()) == null);
    }

    public Flow f(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.u(FlowKt.p(e().K(), e().C(), d().t0(), b().h2(), c().R0(), new CheckAutoTrialEligibilityUseCase$invoke$1(this, null)));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
