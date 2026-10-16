package com.google.firebase.messaging.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PoolableExecutors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorFactory f89602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ExecutorFactory f89603b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultExecutorFactory implements ExecutorFactory {
        private DefaultExecutorFactory() {
        }

        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService a(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return b(1, threadFactory, threadPriority);
        }

        public ExecutorService b(int i3, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i3, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        DefaultExecutorFactory defaultExecutorFactory = new DefaultExecutorFactory();
        f89602a = defaultExecutorFactory;
        f89603b = defaultExecutorFactory;
    }

    public static ExecutorFactory a() {
        return f89603b;
    }
}
