package cz.mobilesoft.coreblock.usecase;

import android.util.Log;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.Store;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import cz.mobilesoft.coreblock.util.monetization.EntitlementResolver;
import cz.mobilesoft.coreblock.util.monetization.EntitlementSnapshot;
import cz.mobilesoft.coreblock.util.monetization.PremiumEntitlement;
import cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class DeterminePremiumStateUseCase extends SuspendUseCase<Params, PremiumState> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127025c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomerInfo f127026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PremiumDevState f127027b;

        public Params(CustomerInfo currentCustomerInfo, PremiumDevState devPremiumState) {
            Intrinsics.checkNotNullParameter(currentCustomerInfo, "currentCustomerInfo");
            Intrinsics.checkNotNullParameter(devPremiumState, "devPremiumState");
            this.f127026a = currentCustomerInfo;
            this.f127027b = devPremiumState;
        }

        public final CustomerInfo a() {
            return this.f127026a;
        }

        public final PremiumDevState b() {
            return this.f127027b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127026a, params.f127026a) && this.f127027b == params.f127027b;
        }

        public int hashCode() {
            return (this.f127026a.hashCode() * 31) + this.f127027b.hashCode();
        }

        public String toString() {
            return "Params(currentCustomerInfo=" + this.f127026a + ", devPremiumState=" + this.f127027b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeterminePremiumStateUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127023a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase$special$$inlined$inject$default$1
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
        this.f127024b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127025c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumStateChangeReactor>() { // from class: cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumStateChangeReactor.class), objArr4, objArr5);
            }
        });
    }

    private final PremiumState a(PremiumDevState premiumDevState) {
        if (!BuildConfig.f95357b.booleanValue() || premiumDevState == PremiumDevState.REAL_STATE) {
            return null;
        }
        PremiumState state = premiumDevState.getState();
        return state == null ? PremiumState.None.INSTANCE : state;
    }

    private final CoreDataStore b() {
        return (CoreDataStore) this.f127023a.getValue();
    }

    private final PremiumRepositoryV2 c() {
        return (PremiumRepositoryV2) this.f127024b.getValue();
    }

    private final PremiumStateChangeReactor d() {
        return (PremiumStateChangeReactor) this.f127025c.getValue();
    }

    private final void f(EntitlementSnapshot entitlementSnapshot) {
        PremiumEntitlement premiumEntitlementB = entitlementSnapshot.b();
        if (premiumEntitlementB != null && premiumEntitlementB.c() && Product.Companion.a(premiumEntitlementB.a()) == null) {
            PremiumState premiumStateA = EntitlementResolver.f128866a.a(premiumEntitlementB.a());
            Log.w("DeterminePremiumStateUseCase", "Unrecognized product id \"" + premiumEntitlementB.a() + "\", inferred " + premiumStateA + " from its name");
            CrashHelper crashHelper = CrashHelper.f127788a;
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized RevenueCat product id, inferred ");
            sb.append(premiumStateA);
            crashHelper.h(sb.toString(), new IllegalStateException("Unrecognized product id: " + premiumEntitlementB.a()));
        }
    }

    private final EntitlementSnapshot g(CustomerInfo customerInfo) {
        PremiumEntitlement premiumEntitlement;
        List listA = RevenueCatExtKt.a(customerInfo);
        EntitlementInfo entitlementInfoC = RevenueCatExtKt.c(customerInfo);
        if (entitlementInfoC != null) {
            premiumEntitlement = new PremiumEntitlement(entitlementInfoC.getProductIdentifier(), entitlementInfoC.getStore().name(), entitlementInfoC.getStore() == Store.PLAY_STORE);
        } else {
            premiumEntitlement = null;
        }
        return new EntitlementSnapshot(listA, premiumEntitlement);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase.Params r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase.e(cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
