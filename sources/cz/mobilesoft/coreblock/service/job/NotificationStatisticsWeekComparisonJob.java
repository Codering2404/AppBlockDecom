package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.PermissionException;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class NotificationStatisticsWeekComparisonJob extends DailyJob implements CoroutineScope, KoinComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f123401n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f123402o = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CoroutineContext f123403m = Dispatchers.b().plus(JobKt__JobKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b());

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
                Log.d(JobPlanner.class.getSimpleName(), "Skipping schedule of notification statistics week comparison job because SCHEDULE_EXACT_ALARM is not granted");
                return;
            }
            TimeUnit timeUnit = TimeUnit.HOURS;
            long millis = timeUnit.toMillis(9L);
            TimeUnit timeUnit2 = TimeUnit.MINUTES;
            try {
                DailyJob.y(new JobRequest.Builder("TAG_NOTIFICATION_STATISTICS_WEEK_COMPARISON").H(true), millis + timeUnit2.toMillis(0L), timeUnit.toMillis(23L) + timeUnit2.toMillis(59L));
            } catch (PermissionException e3) {
                if (BuildConfig.f95357b.booleanValue()) {
                    e3.printStackTrace();
                }
            }
        }

        private Companion() {
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f123403m;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.DailyJob
    protected DailyJob.DailyJobResult x(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Log.d(JobPlanner.class.getSimpleName(), "Job for notification with statistics week comparison fired");
        BuildersKt__Builders_commonKt.d(this, null, null, new NotificationStatisticsWeekComparisonJob$onRunDailyJob$1(this, null), 3, null);
        return DailyJob.DailyJobResult.SUCCESS;
    }
}
