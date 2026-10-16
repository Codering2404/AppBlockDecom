package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ThreadFactory f40301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final BlockingQueue f40302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Executor f40303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static InternalHandler f40304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile Executor f40305k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkerRunnable f40306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FutureTask f40307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Status f40308c = Status.PENDING;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f40309d = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicBoolean f40310f = new AtomicBoolean();

    /* JADX INFO: renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40314a;

        static {
            int[] iArr = new int[Status.values().length];
            f40314a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40314a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AsyncTaskResult<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ModernAsyncTask f40315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f40316b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Object... objArr) {
            this.f40315a = modernAsyncTask;
            this.f40316b = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i3 = message.what;
            if (i3 == 1) {
                asyncTaskResult.f40315a.d(asyncTaskResult.f40316b[0]);
            } else {
                if (i3 != 2) {
                    return;
                }
                asyncTaskResult.f40315a.k(asyncTaskResult.f40316b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f40321a;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AtomicInteger f40311a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f40311a.getAndIncrement());
            }
        };
        f40301g = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f40302h = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        f40303i = threadPoolExecutor;
        f40305k = threadPoolExecutor;
    }

    ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            @Override // java.util.concurrent.Callable
            public Object call() {
                ModernAsyncTask.this.f40310f.set(true);
                Object objB = null;
                try {
                    Process.setThreadPriority(10);
                    objB = ModernAsyncTask.this.b(this.f40321a);
                    Binder.flushPendingCommands();
                    return objB;
                } finally {
                }
            }
        };
        this.f40306a = workerRunnable;
        this.f40307b = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    ModernAsyncTask.this.m(get());
                } catch (InterruptedException e3) {
                    Log.w("AsyncTask", e3);
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.m(null);
                } catch (ExecutionException e4) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler e() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (f40304j == null) {
                    f40304j = new InternalHandler();
                }
                internalHandler = f40304j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return internalHandler;
    }

    public final boolean a(boolean z2) {
        this.f40309d.set(true);
        return this.f40307b.cancel(z2);
    }

    protected abstract Object b(Object... objArr);

    public final ModernAsyncTask c(Executor executor, Object... objArr) {
        if (this.f40308c == Status.PENDING) {
            this.f40308c = Status.RUNNING;
            j();
            this.f40306a.f40321a = objArr;
            executor.execute(this.f40307b);
            return this;
        }
        int i3 = AnonymousClass4.f40314a[this.f40308c.ordinal()];
        if (i3 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i3 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    void d(Object obj) {
        if (f()) {
            h(obj);
        } else {
            i(obj);
        }
        this.f40308c = Status.FINISHED;
    }

    public final boolean f() {
        return this.f40309d.get();
    }

    protected void h(Object obj) {
        g();
    }

    Object l(Object obj) {
        e().obtainMessage(1, new AsyncTaskResult(this, obj)).sendToTarget();
        return obj;
    }

    void m(Object obj) {
        if (this.f40310f.get()) {
            return;
        }
        l(obj);
    }

    protected void g() {
    }

    protected void j() {
    }

    protected void i(Object obj) {
    }

    protected void k(Object... objArr) {
    }
}
