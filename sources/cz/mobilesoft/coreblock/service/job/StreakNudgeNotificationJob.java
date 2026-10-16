package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
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
public final class StreakNudgeNotificationJob extends Job implements CoroutineScope, KoinComponent {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f123468m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f123469n = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CoroutineContext f123470k = Dispatchers.b().plus(JobKt__JobKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123471l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.time.ZonedDateTime, java.time.chrono.ChronoZonedDateTime] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.time.temporal.Temporal] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        private final long a() {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            ZonedDateTime zonedDateTimeAtZone = Instant.ofEpochMilli(TimeHelperExt.f128663a.f()).atZone(zoneIdSystemDefault);
            ?? AtZone = zonedDateTimeAtZone.toLocalDate().atTime(StreakNudgePlanner.f120372f.a()).atZone(zoneIdSystemDefault);
            boolean zIsAfter = AtZone.isAfter(zonedDateTimeAtZone);
            ?? PlusDays = AtZone;
            if (!zIsAfter) {
                PlusDays = AtZone.plusDays(1L);
            }
            return RangesKt.g(Duration.between(zonedDateTimeAtZone, PlusDays).toMillis(), TimeUnit.SECONDS.toMillis(1L));
        }

        public final void b() {
            JobRequest jobRequestW = new JobRequest.Builder("TAG_STREAK_NUDGE_NOTIFICATION").z(a()).H(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d("StreakNudgeNotificationJob", "Streak nudge job scheduled");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreakNudgeNotificationJob() {
        final Qualifier qualifier = null;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123471l = LazyKt.a(lazyThreadSafetyModeB, new Function0<StreakNudgePlanner>() { // from class: cz.mobilesoft.coreblock.service.job.StreakNudgeNotificationJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakNudgePlanner.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakNudgePlanner z() {
        return (StreakNudgePlanner) this.f123471l.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f123470k;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Log.d("StreakNudgeNotificationJob", "Job for the streak nudge notification fired");
        f123468m.b();
        BuildersKt__Builders_commonKt.d(this, null, null, new StreakNudgeNotificationJob$onRunJob$1(this, null), 3, null);
        return Job.Result.SUCCESS;
    }
}
