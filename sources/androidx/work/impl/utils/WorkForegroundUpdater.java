package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f55201d = Logger.i("WMFgUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskExecutor f55202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ForegroundProcessor f55203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final WorkSpecDao f55204c;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.f55203b = foregroundProcessor;
        this.f55202a = taskExecutor;
        this.f55204c = workDatabase.t();
    }

    @Override // androidx.work.ForegroundUpdater
    public ListenableFuture a(final Context context, final UUID uuid, final ForegroundInfo foregroundInfo) {
        final SettableFuture settableFutureS = SettableFuture.s();
        this.f55202a.d(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!settableFutureS.isCancelled()) {
                        String string = uuid.toString();
                        WorkSpec workSpecL = WorkForegroundUpdater.this.f55204c.l(string);
                        if (workSpecL == null || workSpecL.f55014b.b()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.f55203b.a(string, foregroundInfo);
                        context.startService(SystemForegroundDispatcher.d(context, WorkSpecKt.a(workSpecL), foregroundInfo));
                    }
                    settableFutureS.o(null);
                } catch (Throwable th) {
                    settableFutureS.p(th);
                }
            }
        });
        return settableFutureS;
    }
}
