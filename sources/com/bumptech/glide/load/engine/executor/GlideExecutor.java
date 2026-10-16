package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import f.b;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GlideExecutor implements ExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f66627b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f66628c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f66629a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f66630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f66631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f66632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ThreadFactory f66633d = new DefaultPriorityThreadFactory();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private UncaughtThrowableStrategy f66634e = UncaughtThrowableStrategy.f66648d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f66635f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f66636g;

        Builder(boolean z2) {
            this.f66630a = z2;
        }

        public GlideExecutor a() {
            if (TextUtils.isEmpty(this.f66635f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f66635f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f66631b, this.f66632c, this.f66636g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f66633d, this.f66635f, this.f66634e, this.f66630a));
            if (this.f66636g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new GlideExecutor(threadPoolExecutor);
        }

        public Builder b(String str) {
            this.f66635f = str;
            return this;
        }

        public Builder c(int i3) {
            this.f66631b = i3;
            this.f66632c = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private DefaultPriorityThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultPriorityThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DefaultThreadFactory implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadFactory f66638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f66639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final UncaughtThrowableStrategy f66640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f66641d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f66642f = new AtomicInteger();

        DefaultThreadFactory(ThreadFactory threadFactory, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z2) {
            this.f66638a = threadFactory;
            this.f66639b = str;
            this.f66640c = uncaughtThrowableStrategy;
            this.f66641d = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Thread threadNewThread = this.f66638a.newThread(new Runnable() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DefaultThreadFactory.this.f66641d) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.f66640c.a(th);
                    }
                }
            });
            threadNewThread.setName("glide-" + this.f66639b + "-thread-" + this.f66642f.getAndIncrement());
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UncaughtThrowableStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f66645a = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void a(Throwable th) {
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f66646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f66647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f66648d;

        static {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void a(Throwable th) {
                    if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                        return;
                    }
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            };
            f66646b = uncaughtThrowableStrategy;
            f66647c = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void a(Throwable th) {
                    if (th != null) {
                        throw new RuntimeException("Request threw uncaught throwable", th);
                    }
                }
            };
            f66648d = uncaughtThrowableStrategy;
        }

        void a(Throwable th);
    }

    GlideExecutor(ExecutorService executorService) {
        this.f66629a = executorService;
    }

    static int a() {
        return b() >= 4 ? 2 : 1;
    }

    public static int b() {
        if (f66628c == 0) {
            f66628c = Math.min(4, RuntimeCompat.a());
        }
        return f66628c;
    }

    public static Builder c() {
        return new Builder(true).c(a()).b("animation");
    }

    public static GlideExecutor f() {
        return c().a();
    }

    public static Builder i() {
        return new Builder(true).c(1).b("disk-cache");
    }

    public static GlideExecutor j() {
        return i().a();
    }

    public static Builder k() {
        return new Builder(false).c(b()).b("source");
    }

    public static GlideExecutor l() {
        return k().a();
    }

    public static GlideExecutor m() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, f66627b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(), "source-unlimited", UncaughtThrowableStrategy.f66648d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        return this.f66629a.awaitTermination(j3, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        b.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f66629a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f66629a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f66629a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f66629a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f66629a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f66629a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.f66629a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f66629a.submit(runnable);
    }

    public String toString() {
        return this.f66629a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f66629a.invokeAll(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f66629a.invokeAny(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f66629a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f66629a.submit(callable);
    }
}
