package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1xSDK implements AFc1ySDK {
    private static final int AFKeystoreWrapper = (int) TimeUnit.SECONDS.toMillis(30);
    private ExecutorService AFInAppEventParameterName;
    private ExecutorService AFInAppEventType;
    private AFb1wSDK AFLogger;
    private AFf1cSDK AFLogger$LogLevel;
    private AFd1xSDK AFVersionDeclaration;
    private AFe1pSDK AppsFlyer2dXConversionCallback;
    private PurchaseHandler afDebugLog;
    private AFe1hSDK afErrorLog;
    private AFf1iSDK afErrorLogForExcManagerOnly;
    private AFc1sSDK afInfoLog;
    private AFb1gSDK afRDLog;
    private AFb1ySDK afWarnLog;
    private AFe1rSDK getLevel;
    private AFa1cSDK init;
    private AFf1rSDK onAppOpenAttribution;
    private AFc1wSDK onAppOpenAttributionNative;
    private AFb1cSDK onAttributionFailureNative;
    private AFb1sSDK onConversionDataSuccess;
    private AFb1iSDK onDeepLinkingNative;
    private AFf1tSDK onInstallConversionDataLoadedNative;
    private AFd1ySDK onInstallConversionFailureNative;
    private AFb1tSDK onResponse;
    private AFa1kSDK onResponseErrorNative;
    private AFa1gSDK onResponseNative;
    public final AFc1zSDK valueOf = new AFc1zSDK();
    private ScheduledExecutorService values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AFa1vSDK implements ThreadFactory {
        private static final AtomicInteger AFInAppEventType = new AtomicInteger();
        private final AtomicInteger valueOf = new AtomicInteger();

        public AFa1vSDK() {
            AFInAppEventType.incrementAndGet();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int i3 = AFInAppEventType.get();
            int iIncrementAndGet = this.valueOf.incrementAndGet();
            StringBuilder sb = new StringBuilder("queue-");
            sb.append(i3);
            sb.append("-");
            sb.append(iIncrementAndGet);
            return new Thread(runnable, sb.toString());
        }
    }

    private synchronized AFb1tSDK onConversionDataSuccess() {
        try {
            if (this.onResponse == null) {
                this.onResponse = new AFb1tSDK(afWarnLog(), AFInAppEventParameterName());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFc1ySDK
    /* JADX INFO: renamed from: onDeepLinking, reason: merged with bridge method [inline-methods] */
    public synchronized AFc1wSDK onResponseErrorNative() {
        try {
            if (this.onAppOpenAttributionNative == null) {
                this.onAppOpenAttributionNative = new AFc1wSDK(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onAppOpenAttributionNative;
    }

    private synchronized AFc1sSDK onDeepLinkingNative() {
        try {
            if (this.afInfoLog == null) {
                this.afInfoLog = new AFc1sSDK(new AFc1lSDK(AFKeystoreWrapper), AFInAppEventType());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afInfoLog;
    }

    private synchronized ExecutorService onResponseNative() {
        try {
            if (this.AFInAppEventParameterName == null) {
                this.AFInAppEventParameterName = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFInAppEventParameterName;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFb1gSDK AFInAppEventParameterName() {
        try {
            if (this.afRDLog == null) {
                AFc1zSDK aFc1zSDKAfWarnLog = afWarnLog();
                Context context = this.valueOf.values;
                if (context == null) {
                    throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                }
                this.afRDLog = new AFb1gSDK(aFc1zSDKAfWarnLog, new AFb1eSDK(AFa1bSDK.valueOf(context)));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afRDLog;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized ExecutorService AFInAppEventType() {
        try {
            if (this.AFInAppEventType == null) {
                this.AFInAppEventType = Executors.newCachedThreadPool();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFInAppEventType;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFb1fSDK AFKeystoreWrapper() {
        Context context = this.valueOf.values;
        if (context != null) {
            return new AFb1eSDK(AFa1bSDK.valueOf(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFe1rSDK AFLogger() {
        if (this.getLevel == null) {
            Context context = this.valueOf.values;
            if (context == null) {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
            if (this.onInstallConversionDataLoadedNative == null) {
                this.onInstallConversionDataLoadedNative = new AFf1mSDK();
            }
            AFf1tSDK aFf1tSDK = this.onInstallConversionDataLoadedNative;
            if (this.onAttributionFailureNative == null) {
                this.onAttributionFailureNative = new com.appsflyer.internal.AFa1vSDK();
            }
            AFb1cSDK aFb1cSDK = this.onAttributionFailureNative;
            if (this.AFLogger$LogLevel == null) {
                Context context2 = this.valueOf.values;
                if (context2 == null) {
                    throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                }
                this.AFLogger$LogLevel = new AFf1dSDK(context2);
            }
            AFf1cSDK aFf1cSDK = this.AFLogger$LogLevel;
            if (this.onResponseErrorNative == null) {
                this.onResponseErrorNative = new AFa1jSDK();
            }
            AFa1kSDK aFa1kSDK = this.onResponseErrorNative;
            AFe1hSDK aFe1hSDKAfErrorLog = afErrorLog();
            AFb1fSDK aFb1fSDKAFKeystoreWrapper = AFKeystoreWrapper();
            AFb1gSDK aFb1gSDKAFInAppEventParameterName = AFInAppEventParameterName();
            if (this.onResponseNative == null) {
                this.onResponseNative = new AFa1gSDK();
            }
            this.getLevel = new AFe1tSDK(context, aFf1tSDK, aFb1cSDK, aFf1cSDK, aFa1kSDK, aFe1hSDKAfErrorLog, aFb1fSDKAFKeystoreWrapper, aFb1gSDKAFInAppEventParameterName, this.onResponseNative, getLevel(), new AFb1xSDK(), afWarnLog(), onConversionDataSuccess());
        }
        return this.getLevel;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFd1xSDK AFLogger$LogLevel() {
        try {
            if (this.AFVersionDeclaration == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() { // from class: com.appsflyer.internal.AFc1xSDK.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
                    /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
                    public boolean offer(Runnable runnable) {
                        if (isEmpty()) {
                            return super.offer(runnable);
                        }
                        return false;
                    }
                }, new AFa1vSDK());
                threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.appsflyer.internal.s
                    @Override // java.util.concurrent.RejectedExecutionHandler
                    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        AFc1xSDK.AFInAppEventParameterName(runnable, threadPoolExecutor2);
                    }
                });
                this.AFVersionDeclaration = new AFd1xSDK(threadPoolExecutor);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFVersionDeclaration;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFf1iSDK AFVersionDeclaration() {
        try {
            if (this.afErrorLogForExcManagerOnly == null) {
                this.afErrorLogForExcManagerOnly = new AFf1iSDK();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFa1cSDK AppsFlyer2dXConversionCallback() {
        try {
            if (this.init == null) {
                this.init = new AFa1hSDK(afWarnLog());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.init;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized PurchaseHandler afDebugLog() {
        try {
            if (this.afDebugLog == null) {
                this.afDebugLog = new PurchaseHandler(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afDebugLog;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFe1hSDK afErrorLog() {
        try {
            if (this.afErrorLog == null) {
                this.afErrorLog = new AFe1hSDK(AFKeystoreWrapper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afErrorLog;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFb1ySDK afErrorLogForExcManagerOnly() {
        try {
            if (this.afWarnLog == null) {
                this.afWarnLog = new AFb1vSDK();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFb1wSDK afInfoLog() {
        try {
            if (this.AFLogger == null) {
                AFb1uSDK aFb1uSDK = new AFb1uSDK(AFKeystoreWrapper());
                this.AFLogger = new AFb1wSDK(new AFe1xSDK(), AFInAppEventParameterName(), getLevel(), aFb1uSDK, new AFc1oSDK(onDeepLinkingNative(), AFInAppEventParameterName(), AppsFlyerProperties.getInstance(), onAppOpenAttributionNative()), new AFe1uSDK(AFInAppEventParameterName(), aFb1uSDK), AFLogger$LogLevel());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFLogger;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFc1zSDK afWarnLog() {
        return this.valueOf;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFe1pSDK getLevel() {
        try {
            if (this.AppsFlyer2dXConversionCallback == null) {
                this.AppsFlyer2dXConversionCallback = new AFe1pSDK(afWarnLog(), new AFe1ySDK());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFf1rSDK init() {
        if (this.onAppOpenAttribution == null) {
            this.onAppOpenAttribution = new AFf1sSDK();
        }
        return this.onAppOpenAttribution;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFd1ySDK onAppOpenAttributionNative() {
        try {
            if (this.onInstallConversionFailureNative == null) {
                this.onInstallConversionFailureNative = new AFd1ySDK(AFInAppEventParameterName(), AFKeystoreWrapper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onInstallConversionFailureNative;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFb1iSDK onAttributionFailureNative() {
        if (this.onDeepLinkingNative == null) {
            ExecutorService executorServiceOnResponseNative = onResponseNative();
            AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative = onInstallConversionDataLoadedNative();
            if (this.onAppOpenAttribution == null) {
                this.onAppOpenAttribution = new AFf1sSDK();
            }
            this.onDeepLinkingNative = new AFb1lSDK(executorServiceOnResponseNative, aFb1sSDKOnInstallConversionDataLoadedNative, this.onAppOpenAttribution);
        }
        return this.onDeepLinkingNative;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized AFb1sSDK onInstallConversionDataLoadedNative() {
        try {
            if (this.onConversionDataSuccess == null) {
                this.onConversionDataSuccess = new AFb1sSDK(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onConversionDataSuccess;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFf1tSDK onInstallConversionFailureNative() {
        if (this.onInstallConversionDataLoadedNative == null) {
            this.onInstallConversionDataLoadedNative = new AFf1mSDK();
        }
        return this.onInstallConversionDataLoadedNative;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFc1oSDK valueOf() {
        return new AFc1oSDK(onDeepLinkingNative(), AFInAppEventParameterName(), AppsFlyerProperties.getInstance(), onAppOpenAttributionNative());
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final synchronized ScheduledExecutorService values() {
        try {
            if (this.values == null) {
                this.values = Executors.newScheduledThreadPool(2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.values;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final AFf1cSDK afRDLog() {
        if (this.AFLogger$LogLevel == null) {
            Context context = this.valueOf.values;
            if (context == null) {
                throw new IllegalStateException(MrGIhy.ERXUqpWtLBvt);
            }
            this.AFLogger$LogLevel = new AFf1dSDK(context);
        }
        return this.AFLogger$LogLevel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void AFInAppEventParameterName(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e3) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e3);
            Thread.currentThread().interrupt();
        }
    }
}
