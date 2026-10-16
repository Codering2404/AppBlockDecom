package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.PermissionException;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
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
public final class DailyInsightsMotivationJob extends DailyJob implements CoroutineScope, KoinComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f123204n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f123205o = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CoroutineContext f123206m = Dispatchers.b().plus(JobKt__JobKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String startTime) {
            long millis;
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Context contextG = LockieApplication.g();
            PermissionsManager permissionsManager = PermissionsManager.f129021a;
            Intrinsics.checkNotNull(contextG);
            if (!permissionsManager.C(contextG)) {
                Log.d("DailyInsightsMotivationJob", "Skipping schedule because SCHEDULE_EXACT_ALARM is not granted");
                return;
            }
            Regex regex = new Regex("^(?:[01]\\d|2[0-3]):[0-5]\\d$");
            if (startTime.length() <= 0 || !regex.k(startTime)) {
                millis = TimeUnit.MINUTES.toMillis(0L) + TimeUnit.HOURS.toMillis(20L);
            } else {
                millis = TimeUnit.HOURS.toMillis(Long.parseLong((String) StringsKt.V0(startTime, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, null).get(0))) + TimeUnit.MINUTES.toMillis(Long.parseLong((String) StringsKt.V0(startTime, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, null).get(1)));
            }
            try {
                DailyJob.y(new JobRequest.Builder("TAG_DAILY_INSIGHTS_MOTIVATION_JOB").H(true), millis, TimeUnit.HOURS.toMillis(23L) + TimeUnit.MINUTES.toMillis(59L));
                Log.d("DailyInsightsMotivationJob", "Job scheduled after " + TimeHelperExt.f128663a.k(contextG, millis));
            } catch (PermissionException e3) {
                CrashHelper.j(e3);
                Log.d("DailyInsightsMotivationJob", "Job schedule crashed (startTime=" + TimeHelperExt.f128663a.k(contextG, millis) + "), e=" + e3);
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
        return this.f123206m;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.DailyJob
    protected DailyJob.DailyJobResult x(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Log.d(JobPlanner.class.getSimpleName(), "Job for notification with daily insights motivation fired");
        BuildersKt__Builders_commonKt.d(this, null, null, new DailyInsightsMotivationJob$onRunDailyJob$1(this, null), 3, null);
        return DailyJob.DailyJobResult.SUCCESS;
    }
}
