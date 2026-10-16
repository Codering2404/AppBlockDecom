package com.appsflyer.internal;

import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1wSDK extends TimerTask {
    private final Thread AFInAppEventType;

    public AFd1wSDK(Thread thread) {
        this.AFInAppEventType = thread;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.AFInAppEventType.interrupt();
    }
}
