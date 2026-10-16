package cz.mobilesoft.coreblock.util.updates;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.service.job.JobPlanner;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.KoinJavaComponent;

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
public final class InAppUpdatePendingNotificationJob extends Job {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f129853k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f129854l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(long j3) {
            JobRequest jobRequestW = new JobRequest.Builder("IN_APP_UPDATE_PENDING_NOTIFICATION").H(true).z(j3).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job for pending inApp update scheduled to fire in " + j3);
        }

        private Companion() {
        }
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        InAppUpdatesDataStore inAppUpdatesDataStore = (InAppUpdatesDataStore) KoinJavaComponent.c(InAppUpdatesDataStore.class, null, null, 6, null);
        int iIntValue = ((Number) new BlockingFlowProperty(inAppUpdatesDataStore.D()).b()).intValue();
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextC = c();
        Intrinsics.checkNotNullExpressionValue(contextC, "getContext(...)");
        notificationHelper.A(contextC, iIntValue, (Integer) new BlockingFlowProperty(inAppUpdatesDataStore.F()).b());
        return Job.Result.SUCCESS;
    }
}
