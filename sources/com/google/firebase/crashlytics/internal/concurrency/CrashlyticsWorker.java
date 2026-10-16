package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsWorker implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f88486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f88487b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Task f88488c = Tasks.forResult(null);

    CrashlyticsWorker(ExecutorService executorService) {
        this.f88486a = executorService;
    }

    public static /* synthetic */ Task a(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    public static /* synthetic */ Task b(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public ExecutorService c() {
        return this.f88486a;
    }

    public Task d(final Runnable runnable) {
        Task taskContinueWithTask;
        synchronized (this.f88487b) {
            taskContinueWithTask = this.f88488c.continueWithTask(this.f88486a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.a(runnable, task);
                }
            });
            this.f88488c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    public Task e(final Callable callable) {
        Task taskContinueWithTask;
        synchronized (this.f88487b) {
            taskContinueWithTask = this.f88488c.continueWithTask(this.f88486a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.b
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return CrashlyticsWorker.b(callable, task);
                }
            });
            this.f88488c = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f88486a.execute(runnable);
    }
}
