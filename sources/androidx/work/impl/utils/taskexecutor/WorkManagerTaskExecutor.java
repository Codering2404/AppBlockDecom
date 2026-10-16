package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SerialExecutorImpl f55259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineDispatcher f55260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Handler f55261c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f55262d = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.f55261c.post(runnable);
        }
    };

    public WorkManagerTaskExecutor(Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.f55259a = serialExecutorImpl;
        this.f55260b = ExecutorsKt.b(serialExecutorImpl);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor a() {
        return this.f55262d;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public CoroutineDispatcher b() {
        return this.f55260b;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public SerialExecutorImpl c() {
        return this.f55259a;
    }
}
