package com.appsflyer.internal;

import android.net.TrafficStats;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFd1uSDK<Result> implements Comparable<AFd1uSDK<?>>, Callable<AFc1bSDK> {
    private static final AtomicInteger AFLogger = new AtomicInteger();
    public final AFd1tSDK AFInAppEventParameterName;
    public volatile int AFInAppEventType;
    public AFc1bSDK AFKeystoreWrapper;
    private boolean AFVersionDeclaration;
    private final int afDebugLog;
    private final String afErrorLog;
    private Throwable afInfoLog;
    private long afRDLog;
    public final Set<AFd1tSDK> valueOf;
    public final Set<AFd1tSDK> values;

    public AFd1uSDK(AFd1tSDK aFd1tSDK, AFd1tSDK[] aFd1tSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.valueOf = hashSet;
        this.values = new HashSet();
        int iIncrementAndGet = AFLogger.incrementAndGet();
        this.afDebugLog = iIncrementAndGet;
        this.AFVersionDeclaration = false;
        this.AFInAppEventType = 0;
        this.AFInAppEventParameterName = aFd1tSDK;
        Collections.addAll(hashSet, aFd1tSDKArr);
        if (str != null) {
            this.afErrorLog = str;
        } else {
            this.afErrorLog = String.valueOf(iIncrementAndGet);
        }
    }

    public void AFInAppEventParameterName() {
        this.AFVersionDeclaration = true;
    }

    protected abstract long AFInAppEventType();

    protected abstract AFc1bSDK AFKeystoreWrapper() throws Exception;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: afDebugLog, reason: merged with bridge method [inline-methods] */
    public final AFc1bSDK call() throws Exception {
        TrafficStats.setThreadStatsTag(82339054);
        this.AFKeystoreWrapper = null;
        this.afInfoLog = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.AFInAppEventType++;
        try {
            AFc1bSDK aFc1bSDKAFKeystoreWrapper = AFKeystoreWrapper();
            this.AFKeystoreWrapper = aFc1bSDKAFKeystoreWrapper;
            return aFc1bSDKAFKeystoreWrapper;
        } finally {
        }
    }

    protected final boolean afErrorLog() {
        return this.AFVersionDeclaration;
    }

    public final Throwable afInfoLog() {
        return this.afInfoLog;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1uSDK aFd1uSDK = (AFd1uSDK) obj;
        if (this.AFInAppEventParameterName != aFd1uSDK.AFInAppEventParameterName) {
            return false;
        }
        return this.afErrorLog.equals(aFd1uSDK.afErrorLog);
    }

    public final int hashCode() {
        return (this.AFInAppEventParameterName.hashCode() * 31) + this.afErrorLog.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.AFInAppEventParameterName);
        sb.append("-");
        sb.append(this.afErrorLog);
        String string = sb.toString();
        if (String.valueOf(this.afDebugLog).equals(this.afErrorLog)) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("-");
        sb2.append(this.afDebugLog);
        return sb2.toString();
    }

    protected abstract boolean valueOf();

    protected void values() {
    }

    protected void values(Throwable th) {
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AFd1uSDK<?> aFd1uSDK) {
        int i3 = this.AFInAppEventParameterName.onInstallConversionFailureNative - aFd1uSDK.AFInAppEventParameterName.onInstallConversionFailureNative;
        if (i3 != 0) {
            return i3;
        }
        if (this.afErrorLog.equals(aFd1uSDK.afErrorLog)) {
            return 0;
        }
        return this.afDebugLog - aFd1uSDK.afDebugLog;
    }
}
