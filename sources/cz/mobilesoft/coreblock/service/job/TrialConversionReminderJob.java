package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public final class TrialConversionReminderJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f123489n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f123490o = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123493m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            JobManager.v().e("TAG_TRIAL_CONVERSION_REMINDER");
        }

        public final void b(long j3) {
            long jG = RangesKt.g(j3, 1L);
            JobRequest.Builder builder = new JobRequest.Builder("TAG_TRIAL_CONVERSION_REMINDER");
            if (!BuildConfig.f95357b.booleanValue() || jG >= TimeUnit.MINUTES.toMillis(1L)) {
                builder.A(jG, TimeUnit.HOURS.toMillis(6L) + jG);
            } else {
                builder.I();
            }
            JobRequest jobRequestW = builder.y(TimeUnit.MINUTES.toMillis(30L), JobRequest.BackoffPolicy.EXPONENTIAL).H(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Trial conversion reminder scheduled in " + jG + "ms");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrialConversionReminderJob() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123491k = LazyKt.a(lazyThreadSafetyModeB, new Function0<TrialConversionDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.TrialConversionReminderJob$special$$inlined$inject$default$1
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
        this.f123492l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.TrialConversionReminderJob$special$$inlined$inject$default$2
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
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123493m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.job.TrialConversionReminderJob$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore B() {
        return (CoreDataStore) this.f123492l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialConversionDataStore C() {
        return (TrialConversionDataStore) this.f123491k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 D() {
        return (PremiumRepositoryV2) this.f123493m.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return (Job.Result) BuildersKt__BuildersKt.b(null, new TrialConversionReminderJob$onRunJob$1(this, null), 1, null);
    }
}
