package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface TaskExecutor {
    Executor a();

    default CoroutineDispatcher b() {
        return ExecutorsKt.b(c());
    }

    SerialExecutor c();

    default void d(Runnable runnable) {
        c().execute(runnable);
    }
}
