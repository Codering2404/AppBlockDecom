package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class ShouldShowLimitedTimerUseCase extends UseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f122554a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f122555c = StrictModeStateDto.f121484k;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f122556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StrictModeStateDto f122557b;

        public Params(boolean z2, StrictModeStateDto strictModeStateDto) {
            Intrinsics.checkNotNullParameter(strictModeStateDto, "strictModeStateDto");
            this.f122556a = z2;
            this.f122557b = strictModeStateDto;
        }

        public final StrictModeStateDto a() {
            return this.f122557b;
        }

        public final boolean b() {
            return this.f122556a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f122556a == params.f122556a && Intrinsics.areEqual(this.f122557b, params.f122557b);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f122556a) * 31) + this.f122557b.hashCode();
        }

        public String toString() {
            return "Params(isAnyProfileActive=" + this.f122556a + ", strictModeStateDto=" + this.f122557b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShouldShowLimitedTimerUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122554a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ShouldShowLimitedTimerUseCase$special$$inlined$inject$default$1
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
    }

    private final PremiumRepositoryV2 a() {
        return (PremiumRepositoryV2) this.f122554a.getValue();
    }

    public Boolean b(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        boolean zF = a().J().f(Product.STRICT_MODE);
        long millis = TimeUnit.HOURS.toMillis(Limit.STRICT_MODE_LIMIT.getLimitValue());
        return Boolean.valueOf(params.b() && !zF && (!(params.a().b() instanceof AccessMethodConfiguration.Timer) || ((AccessMethodConfiguration.Timer) params.a().b()).b() >= millis) && !(params.a().b() instanceof AccessMethodConfiguration.Schedules) && ((ProfileWithIntervals) CollectionsKt.first(params.a().h())).b().w() < TimeHelperExt.f128663a.f() + millis);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
