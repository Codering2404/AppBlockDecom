package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class SafeLoggingExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f69352a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SafeLoggingRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f69353a;

        SafeLoggingRunnable(Runnable runnable) {
            this.f69353a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f69353a.run();
            } catch (Exception e3) {
                Logging.c("Executor", "Background execution failure.", e3);
            }
        }
    }

    SafeLoggingExecutor(Executor executor) {
        this.f69352a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f69352a.execute(new SafeLoggingRunnable(runnable));
    }
}
