package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ArchTaskExecutor f2359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f2360d = new Executor() { // from class: androidx.arch.core.executor.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.h().d(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f2361e = new Executor() { // from class: androidx.arch.core.executor.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.h().a(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TaskExecutor f2362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskExecutor f2363b;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f2363b = defaultTaskExecutor;
        this.f2362a = defaultTaskExecutor;
    }

    public static Executor g() {
        return f2361e;
    }

    public static ArchTaskExecutor h() {
        if (f2359c != null) {
            return f2359c;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (f2359c == null) {
                    f2359c = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2359c;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void a(Runnable runnable) {
        this.f2362a.a(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean c() {
        return this.f2362a.c();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void d(Runnable runnable) {
        this.f2362a.d(runnable);
    }
}
