package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class TrialExpiringNotificationJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f123508k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f123509l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(String str) {
            Log.d(JobPlanner.class.getSimpleName(), str);
        }

        public final void b(long j3) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (j3 <= jCurrentTimeMillis) {
                a("Trying to schedule job for trial expiring, but scheduled time is " + (jCurrentTimeMillis - j3) + " ms in the past");
                JobHelper.j();
                return;
            }
            long j4 = j3 - jCurrentTimeMillis;
            JobRequest jobRequestW = new JobRequest.Builder("TAG_TRIAL_EXPIRING").z(j4).H(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            a("Job scheduled for expiring trial after " + j4 + " ms");
        }

        private Companion() {
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        String simpleName = TrialExpiringNotificationJob.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, "Job fired for trial expiring");
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextC = c();
        Intrinsics.checkNotNullExpressionValue(contextC, "getContext(...)");
        notificationHelper.N(contextC);
        return Job.Result.SUCCESS;
    }
}
