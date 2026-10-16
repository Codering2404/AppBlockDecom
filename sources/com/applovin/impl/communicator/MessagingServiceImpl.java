package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f58987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f58988b = new Object();

    @Override // com.applovin.communicator.AppLovinCommunicatorMessagingService
    public void publish(final AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = a();
        this.f58987a = scheduledThreadPoolExecutorA;
        scheduledThreadPoolExecutorA.execute(new Runnable() { // from class: com.applovin.impl.communicator.a
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinBroadcastManager.sendBroadcastSync(appLovinCommunicatorMessage, null);
            }
        });
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }

    private ScheduledThreadPoolExecutor a() {
        synchronized (this.f58988b) {
            try {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f58987a;
                if (scheduledThreadPoolExecutor != null) {
                    return scheduledThreadPoolExecutor;
                }
                return new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.applovin.impl.communicator.b
                    @Override // java.util.concurrent.ThreadFactory
                    public final Thread newThread(Runnable runnable) {
                        return MessagingServiceImpl.a(runnable);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:communicator");
        thread.setPriority(1);
        thread.setDaemon(true);
        return thread;
    }
}
