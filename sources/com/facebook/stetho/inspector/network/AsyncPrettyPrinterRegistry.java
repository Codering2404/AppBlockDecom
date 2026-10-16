package com.facebook.stetho.inspector.network;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AsyncPrettyPrinterRegistry {
    private final Map<String, AsyncPrettyPrinterFactory> mRegistry = new HashMap();

    @Nullable
    public synchronized AsyncPrettyPrinterFactory lookup(String str) {
        return this.mRegistry.get(str);
    }

    public synchronized void register(String str, AsyncPrettyPrinterFactory asyncPrettyPrinterFactory) {
        this.mRegistry.put(str, asyncPrettyPrinterFactory);
    }

    public synchronized boolean unregister(String str) {
        return this.mRegistry.remove(str) != null;
    }
}
