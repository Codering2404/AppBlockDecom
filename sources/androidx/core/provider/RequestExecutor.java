package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class RequestExecutor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f34223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34224b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ProcessPriorityThread extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f34225a;

            ProcessPriorityThread(Runnable runnable, String str, int i3) {
                super(runnable, str);
                this.f34225a = i3;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f34225a);
                super.run();
            }
        }

        DefaultThreadFactory(String str, int i3) {
            this.f34223a = str;
            this.f34224b = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f34223a, this.f34224b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class HandlerExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f34226a;

        HandlerExecutor(Handler handler) {
            this.f34226a = (Handler) Preconditions.h(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f34226a.post((Runnable) Preconditions.h(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f34226a + " is shutting down");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ReplyRunnable<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Callable f34227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Consumer f34228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f34229c;

        ReplyRunnable(Handler handler, Callable callable, Consumer consumer) {
            this.f34227a = callable;
            this.f34228b = consumer;
            this.f34229c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final Object objCall;
            try {
                objCall = this.f34227a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            final Consumer consumer = this.f34228b;
            this.f34229c.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(objCall);
                }
            });
        }
    }

    static ThreadPoolExecutor a(String str, int i3, int i4) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i4, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i3));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(Handler handler) {
        return new HandlerExecutor(handler);
    }

    static void c(Executor executor, Callable callable, Consumer consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    static Object d(ExecutorService executorService, Callable callable, int i3) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (ExecutionException e4) {
            throw new RuntimeException(e4);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
