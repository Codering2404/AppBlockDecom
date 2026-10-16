package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class HandlerExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f34151a;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f34151a.post((Runnable) Preconditions.h(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f34151a + " is shutting down");
        }
    }
}
