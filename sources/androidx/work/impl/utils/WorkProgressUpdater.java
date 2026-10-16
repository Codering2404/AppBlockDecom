package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkProgressUpdater implements ProgressUpdater {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f55210c = Logger.i("WorkProgressUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WorkDatabase f55211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskExecutor f55212b;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.f55211a = workDatabase;
        this.f55212b = taskExecutor;
    }

    @Override // androidx.work.ProgressUpdater
    public ListenableFuture a(Context context, final UUID uuid, final Data data) {
        final SettableFuture settableFutureS = SettableFuture.s();
        this.f55212b.d(new Runnable() { // from class: androidx.work.impl.utils.WorkProgressUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                WorkSpec workSpecL;
                String string = uuid.toString();
                Logger loggerE = Logger.e();
                String str = WorkProgressUpdater.f55210c;
                loggerE.a(str, "Updating progress for " + uuid + " (" + data + ")");
                WorkProgressUpdater.this.f55211a.beginTransaction();
                try {
                    workSpecL = WorkProgressUpdater.this.f55211a.t().l(string);
                } finally {
                    try {
                    } finally {
                    }
                }
                if (workSpecL == null) {
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                if (workSpecL.f55014b == WorkInfo.State.RUNNING) {
                    WorkProgressUpdater.this.f55211a.s().d(new WorkProgress(string, data));
                } else {
                    Logger.e().k(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
                }
                settableFutureS.o(null);
                WorkProgressUpdater.this.f55211a.setTransactionSuccessful();
            }
        });
        return settableFutureS;
    }
}
