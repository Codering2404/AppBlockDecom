package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkForegroundRunnable implements Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f55192h = Logger.i("WorkForegroundRunnable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SettableFuture f55193a = SettableFuture.s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Context f55194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final WorkSpec f55195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ListenableWorker f55196d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ForegroundUpdater f55197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TaskExecutor f55198g;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.f55194b = context;
        this.f55195c = workSpec;
        this.f55196d = listenableWorker;
        this.f55197f = foregroundUpdater;
        this.f55198g = taskExecutor;
    }

    public static /* synthetic */ void a(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        if (workForegroundRunnable.f55193a.isCancelled()) {
            settableFuture.cancel(true);
        } else {
            settableFuture.q(workForegroundRunnable.f55196d.getForegroundInfoAsync());
        }
    }

    public ListenableFuture b() {
        return this.f55193a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f55195c.f55029q || Build.VERSION.SDK_INT >= 31) {
            this.f55193a.o(null);
            return;
        }
        final SettableFuture settableFutureS = SettableFuture.s();
        this.f55198g.a().execute(new Runnable() { // from class: androidx.work.impl.utils.g
            @Override // java.lang.Runnable
            public final void run() {
                WorkForegroundRunnable.a(this.f55257a, settableFutureS);
            }
        });
        settableFutureS.addListener(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (WorkForegroundRunnable.this.f55193a.isCancelled()) {
                    return;
                }
                try {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) settableFutureS.get();
                    if (foregroundInfo == null) {
                        throw new IllegalStateException("Worker was marked important (" + WorkForegroundRunnable.this.f55195c.f55015c + ") but did not provide ForegroundInfo");
                    }
                    Logger.e().a(WorkForegroundRunnable.f55192h, "Updating notification for " + WorkForegroundRunnable.this.f55195c.f55015c);
                    WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                    workForegroundRunnable.f55193a.q(workForegroundRunnable.f55197f.a(workForegroundRunnable.f55194b, workForegroundRunnable.f55196d.getId(), foregroundInfo));
                } catch (Throwable th) {
                    WorkForegroundRunnable.this.f55193a.p(th);
                }
            }
        }, this.f55198g.a());
    }
}
