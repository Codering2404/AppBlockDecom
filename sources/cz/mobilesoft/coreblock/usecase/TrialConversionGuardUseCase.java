package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TrialConversionGuardUseCase extends SuspendUseCase<Params, TrialGuardAction> implements KoinComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f127435c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f127436d = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f127437f = TimeUnit.DAYS.toMillis(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f127438g = TimeUnit.HOURS.toMillis(48);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127440b;

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
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomerInfo f127441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f127442b;

        public Params(CustomerInfo customerInfo, long j3) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            this.f127441a = customerInfo;
            this.f127442b = j3;
        }

        public final CustomerInfo a() {
            return this.f127441a;
        }

        public final long b() {
            return this.f127442b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127441a, params.f127441a) && this.f127442b == params.f127442b;
        }

        public int hashCode() {
            return (this.f127441a.hashCode() * 31) + Long.hashCode(this.f127442b);
        }

        public String toString() {
            return "Params(customerInfo=" + this.f127441a + ", nowMillis=" + this.f127442b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrialConversionGuardUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127439a = LazyKt.a(lazyThreadSafetyModeB, new Function0<TrialConversionDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialConversionDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127440b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
    }

    private final CoreDataStore a() {
        return (CoreDataStore) this.f127440b.getValue();
    }

    private final TrialConversionDataStore b() {
        return (TrialConversionDataStore) this.f127439a.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x027f, code lost:
    
        if (r0.w(r1) == r3) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02de, code lost:
    
        if (r0.w(r1) == r3) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01c6, code lost:
    
        if (r14.D(true, r1) == r3) goto L130;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0197 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022b  */
    /* JADX WARN: Type inference failed for: r0v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r4v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v29, types: [int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase.Params r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase.c(cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
