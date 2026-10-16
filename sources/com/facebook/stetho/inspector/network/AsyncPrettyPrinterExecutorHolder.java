package com.facebook.stetho.inspector.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AsyncPrettyPrinterExecutorHolder {
    private static ExecutorService sExecutorService;

    private AsyncPrettyPrinterExecutorHolder() {
    }

    public static void ensureInitialized() {
        if (sExecutorService == null) {
            sExecutorService = Executors.newCachedThreadPool();
        }
    }

    @Nullable
    public static ExecutorService getExecutorService() {
        return sExecutorService;
    }

    public static void shutdown() {
        sExecutorService.shutdown();
        sExecutorService = null;
    }
}
