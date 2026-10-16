package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class NotificationForPomodoroSession extends Job {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f123359k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f123360l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(PomodoroSession.SessionMode mode, int i3, long j3, long j4, boolean z2) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            persistableBundleCompat.j("BREAK_TIME", j3);
            persistableBundleCompat.j("ACTIVE_UNTIL", j4);
            persistableBundleCompat.i("INDEX", i3);
            persistableBundleCompat.k("POMODORO_SESSION_MODE_TAG", mode.c());
            persistableBundleCompat.h("SHOW_NOTIFICATIONS", z2);
            JobManager.v().e("TAG_POMODORO_SESSION_JOB_" + mode.c() + i3);
            JobRequest jobRequestW = new JobRequest.Builder("TAG_POMODORO_SESSION_JOB_" + mode.c() + i3).H(true).B(persistableBundleCompat).I().w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
        }

        public final void b(PomodoroSession.SessionMode mode, int i3, long j3, long j4, long j5, boolean z2) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            persistableBundleCompat.j("BREAK_TIME", j3);
            persistableBundleCompat.j("ACTIVE_UNTIL", j4);
            persistableBundleCompat.i("INDEX", i3);
            persistableBundleCompat.k("POMODORO_SESSION_MODE_TAG", mode.c());
            persistableBundleCompat.h("SHOW_NOTIFICATIONS", z2);
            JobManager.v().e("TAG_POMODORO_SESSION_JOB_" + mode.c() + i3);
            JobRequest jobRequestW = new JobRequest.Builder("TAG_POMODORO_SESSION_JOB_" + mode.c() + i3).H(true).B(persistableBundleCompat).z(j5).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
        }

        private Companion() {
        }
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        PersistableBundleCompat persistableBundleCompatA = params.a();
        Intrinsics.checkNotNullExpressionValue(persistableBundleCompatA, "getExtras(...)");
        long jE = persistableBundleCompatA.e("BREAK_TIME", -1L);
        long jE2 = persistableBundleCompatA.e("ACTIVE_UNTIL", -1L);
        int iD = persistableBundleCompatA.d("INDEX", -1);
        String strF = persistableBundleCompatA.f("POMODORO_SESSION_MODE_TAG", "");
        boolean zC = persistableBundleCompatA.c("SHOW_NOTIFICATIONS", false);
        Log.d(JobPlanner.class.getSimpleName(), "Job fired for pomodoro session");
        CoroutinesHelperExtKt.d(new NotificationForPomodoroSession$onRunJob$1(strF, iD, jE2, null));
        if (zC && iD != -1 && jE != -1) {
            Intrinsics.checkNotNull(strF);
            if (strF.length() > 0) {
                NotificationHelper notificationHelper = NotificationHelper.f128940a;
                Context contextC = c();
                Intrinsics.checkNotNullExpressionValue(contextC, "getContext(...)");
                notificationHelper.E(contextC, strF, iD + 1, jE);
            }
        }
        return Job.Result.SUCCESS;
    }
}
