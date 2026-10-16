package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
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
public final class WorkManagerImplExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List b(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler schedulerC = Schedulers.c(context, workDatabase, configuration);
        Intrinsics.checkNotNullExpressionValue(schedulerC, "createBestAvailableBackg…kDatabase, configuration)");
        return CollectionsKt.listOf((Object[]) new Scheduler[]{schedulerC, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor)});
    }

    public static final WorkManagerImpl c(Context context, Configuration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return e(context, configuration, null, null, null, null, null, 124, null);
    }

    public static final WorkManagerImpl d(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, Function6 schedulersCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(schedulersCreator, "schedulersCreator");
        return new WorkManagerImpl(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase, (List) schedulersCreator.k(context, configuration, workTaskExecutor, workDatabase, trackers, processor), processor, trackers);
    }

    public static /* synthetic */ WorkManagerImpl e(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, Function6 function6, int i3, Object obj) {
        Trackers trackers2;
        if ((i3 & 4) != 0) {
            taskExecutor = new WorkManagerTaskExecutor(configuration.m());
        }
        TaskExecutor taskExecutor2 = taskExecutor;
        if ((i3 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.f54663a;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            SerialExecutor serialExecutorC = taskExecutor2.c();
            Intrinsics.checkNotNullExpressionValue(serialExecutorC, "workTaskExecutor.serialTaskExecutor");
            workDatabase = companion.b(applicationContext, serialExecutorC, configuration.a(), context.getResources().getBoolean(R.bool.f54561a));
        }
        if ((i3 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
            trackers2 = new Trackers(applicationContext2, taskExecutor2, null, null, null, null, 60, null);
        } else {
            trackers2 = trackers;
        }
        return d(context, configuration, taskExecutor2, workDatabase, trackers2, (i3 & 32) != 0 ? new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase) : processor, (i3 & 64) != 0 ? WorkManagerImplExtKt$WorkManagerImpl$1.f54699a : function6);
    }
}
