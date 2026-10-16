package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;
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
public final class IntervalStartJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f123296o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f123297p = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f123301n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(long j3, long j4, boolean z2, boolean z3, Integer num) {
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            if (num != null) {
                persistableBundleCompat.i("DAY_FLAGS", num.intValue());
            }
            persistableBundleCompat.j("INTERVAL_ID", j3);
            persistableBundleCompat.j("START_TIME", j4);
            long jI = j4 - DateHelper.i();
            if (z2) {
                jI += 86400000;
            }
            JobRequest.Builder builder = new JobRequest.Builder((z3 ? "INTERVAL_END_" : "INTERVAL_START_") + j3);
            BlockingFlowProperty blockingFlowProperty = new BlockingFlowProperty(((NotificationDataStore) KoinJavaComponent.c(NotificationDataStore.class, null, null, 6, null)).O());
            if (jI > 0 && !z3 && ((Number) blockingFlowProperty.b()).intValue() > 0) {
                JobManager.v().e("TAG_BEFORE_PROFILE_START_JOB_" + j3);
                Calendar calendar = Calendar.getInstance();
                if (z2) {
                    calendar.add(6, 1);
                }
                DayFlags dayFlagsE = DayFlags.Companion.e(calendar.get(7));
                if (dayFlagsE != null && num != null) {
                    if ((dayFlagsE.getValue() & num.intValue()) > 0) {
                        long millis = jI - TimeUnit.MINUTES.toMillis(((Number) blockingFlowProperty.b()).intValue());
                        if (millis > 0) {
                            NotificationBeforeProfileStartJob.x(j3, millis);
                        }
                    }
                }
            }
            persistableBundleCompat.h("INTERVAL_ALREADY_RUNNING", jI < 0);
            if (jI < 0) {
                builder.I();
            } else {
                builder.z(jI);
            }
            JobRequest jobRequestW = builder.H(true).B(persistableBundleCompat).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled for interval " + j3 + (z3 ? " to end in " : " to start in ") + jI + " ms");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntervalStartJob() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123298k = LazyKt.a(lazyThreadSafetyModeB, new Function0<IntervalDao>() { // from class: cz.mobilesoft.coreblock.service.job.IntervalStartJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IntervalDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123299l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.job.IntervalStartJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123300m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.IntervalStartJob$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f123301n = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.service.job.IntervalStartJob$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr6, objArr7);
            }
        });
    }

    private final StreakActivityTracker C() {
        return (StreakActivityTracker) this.f123301n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0187, code lost:
    
        if (r2.l(r10, r14, r16, r7) != r3) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r24, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r25, boolean r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.IntervalStartJob.D(cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final IntervalDao A() {
        return (IntervalDao) this.f123298k.getValue();
    }

    public final ProfileDao B() {
        return (ProfileDao) this.f123299l.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt__BuildersKt.b(null, new IntervalStartJob$onRunJob$1(params, this, null), 1, null);
        return Job.Result.SUCCESS;
    }

    public final EventDataStore z() {
        return (EventDataStore) this.f123300m.getValue();
    }
}
