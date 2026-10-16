package androidx.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2364a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f2365b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.arch.core.executor.DefaultTaskExecutor.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2367a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f2367a.getAndIncrement());
            return thread;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f2366c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api28Impl {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private static Handler e(Looper looper) {
        return Api28Impl.a(looper);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void a(Runnable runnable) {
        this.f2365b.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void d(Runnable runnable) {
        if (this.f2366c == null) {
            synchronized (this.f2364a) {
                try {
                    if (this.f2366c == null) {
                        this.f2366c = e(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f2366c.post(runnable);
    }
}
