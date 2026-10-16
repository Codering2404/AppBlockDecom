package androidx.media3.exoplayer.util;

import androidx.media3.common.util.Consumer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ReleasableExecutor extends Executor {
    static ReleasableExecutor A0(final Executor executor, final Consumer consumer) {
        return new ReleasableExecutor() { // from class: androidx.media3.exoplayer.util.ReleasableExecutor.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(runnable);
            }

            @Override // androidx.media3.exoplayer.util.ReleasableExecutor
            public void release() {
                consumer.accept(executor);
            }
        };
    }

    void release();
}
