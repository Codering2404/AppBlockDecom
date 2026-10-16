package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SerialExecutorImpl implements SerialExecutor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f55166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f55167c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f55165a = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f55168d = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Task implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SerialExecutorImpl f55169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f55170b;

        Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.f55169a = serialExecutorImpl;
            this.f55170b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f55170b.run();
                synchronized (this.f55169a.f55168d) {
                    this.f55169a.a();
                }
            } catch (Throwable th) {
                synchronized (this.f55169a.f55168d) {
                    this.f55169a.a();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.f55166b = executor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.SerialExecutor
    public boolean U0() {
        boolean z2;
        synchronized (this.f55168d) {
            z2 = !this.f55165a.isEmpty();
        }
        return z2;
    }

    void a() {
        Runnable runnable = (Runnable) this.f55165a.poll();
        this.f55167c = runnable;
        if (runnable != null) {
            this.f55166b.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f55168d) {
            try {
                this.f55165a.add(new Task(this, runnable));
                if (this.f55167c == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
