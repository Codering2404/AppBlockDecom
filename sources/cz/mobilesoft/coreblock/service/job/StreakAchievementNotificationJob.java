package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.PermissionException;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
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
public final class StreakAchievementNotificationJob extends DailyJob implements CoroutineScope, KoinComponent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f123454p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f123455q = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CoroutineContext f123456m = Dispatchers.b().plus(JobKt__JobKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f123457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f123458o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            Context contextG = LockieApplication.g();
            PermissionsManager permissionsManager = PermissionsManager.f129021a;
            Intrinsics.checkNotNull(contextG);
            if (!permissionsManager.C(contextG)) {
                Log.d("StreakAchievementNotificationJob", "Skipping schedule because SCHEDULE_EXACT_ALARM is not granted");
                return;
            }
            TimeUnit timeUnit = TimeUnit.HOURS;
            try {
                DailyJob.y(new JobRequest.Builder("TAG_STREAK_ACHIEVEMENT_NOTIFICATION").H(true), timeUnit.toMillis(StreakAchievementNotificationPlanner.f120097e.a().getHour()), timeUnit.toMillis(11L));
                Log.d("StreakAchievementNotificationJob", "Streak achievement job scheduled");
            } catch (PermissionException e3) {
                CrashHelper.j(e3);
                if (BuildConfig.f95357b.booleanValue()) {
                    e3.printStackTrace();
                }
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreakAchievementNotificationJob() {
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123457n = LazyKt.a(lazyThreadSafetyModeB, new Function0<StreakAchievementNotificationPlanner>() { // from class: cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakAchievementNotificationPlanner.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123458o = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StreakDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.StreakAchievementNotificationJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakDataStore.class), objArr2, objArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakAchievementNotificationPlanner D() {
        return (StreakAchievementNotificationPlanner) this.f123457n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakDataStore E() {
        return (StreakDataStore) this.f123458o.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f123456m;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.DailyJob
    protected DailyJob.DailyJobResult x(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Log.d("StreakAchievementNotificationJob", "Job for the streak achievement notification fired");
        BuildersKt__Builders_commonKt.d(this, null, null, new StreakAchievementNotificationJob$onRunDailyJob$1(this, null), 3, null);
        return DailyJob.DailyJobResult.SUCCESS;
    }
}
