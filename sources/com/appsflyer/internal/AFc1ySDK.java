package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AFc1ySDK {
    AFb1gSDK AFInAppEventParameterName();

    ExecutorService AFInAppEventType();

    AFb1fSDK AFKeystoreWrapper();

    AFe1rSDK AFLogger();

    AFd1xSDK AFLogger$LogLevel();

    AFf1iSDK AFVersionDeclaration();

    AFa1cSDK AppsFlyer2dXConversionCallback();

    PurchaseHandler afDebugLog();

    AFe1hSDK afErrorLog();

    AFb1ySDK afErrorLogForExcManagerOnly();

    AFb1wSDK afInfoLog();

    AFf1cSDK afRDLog();

    AFc1zSDK afWarnLog();

    AFe1pSDK getLevel();

    AFf1rSDK init();

    AFd1ySDK onAppOpenAttributionNative();

    AFb1iSDK onAttributionFailureNative();

    AFb1sSDK onInstallConversionDataLoadedNative();

    AFf1tSDK onInstallConversionFailureNative();

    AFc1vSDK onResponseErrorNative();

    AFc1oSDK valueOf();

    ScheduledExecutorService values();
}
