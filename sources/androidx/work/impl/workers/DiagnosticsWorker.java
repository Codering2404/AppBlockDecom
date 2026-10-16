package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        WorkManagerImpl workManagerImplR = WorkManagerImpl.r(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImplR, "getInstance(applicationContext)");
        WorkDatabase workDatabaseW = workManagerImplR.w();
        Intrinsics.checkNotNullExpressionValue(workDatabaseW, "workManager.workDatabase");
        WorkSpecDao workSpecDaoT = workDatabaseW.t();
        WorkNameDao workNameDaoR = workDatabaseW.r();
        WorkTagDao workTagDaoU = workDatabaseW.u();
        SystemIdInfoDao systemIdInfoDaoQ = workDatabaseW.q();
        List listF = workSpecDaoT.f(workManagerImplR.p().a().currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List listY = workSpecDaoT.y();
        List listQ = workSpecDaoT.q(200);
        if (!listF.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f55270a, "Recently completed work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f55270a, DiagnosticsWorkerKt.d(workNameDaoR, workTagDaoU, systemIdInfoDaoQ, listF));
        }
        if (!listY.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f55270a, "Running work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f55270a, DiagnosticsWorkerKt.d(workNameDaoR, workTagDaoU, systemIdInfoDaoQ, listY));
        }
        if (!listQ.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f55270a, "Enqueued work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f55270a, DiagnosticsWorkerKt.d(workNameDaoR, workTagDaoU, systemIdInfoDaoQ, listQ));
        }
        ListenableWorker.Result resultC = ListenableWorker.Result.c();
        Intrinsics.checkNotNullExpressionValue(resultC, "success()");
        return resultC;
    }
}
