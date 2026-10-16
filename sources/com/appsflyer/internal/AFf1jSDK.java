package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFf1jSDK extends Observable {
    final Runnable AFInAppEventParameterName;
    long AFLogger;
    public final String afInfoLog;
    public final String values;
    public final Map<String, Object> valueOf = new HashMap();
    public AFa1vSDK afDebugLog = AFa1vSDK.NOT_STARTED;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFf1jSDK$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass3 implements Observer {
        AnonymousClass3() {
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            AFf1jSDK.this.AFInAppEventParameterName.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AFa1vSDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public AFf1jSDK(String str, String str2, Runnable runnable) {
        this.AFInAppEventParameterName = runnable;
        this.values = str2;
        this.afInfoLog = str;
    }

    public final void AFKeystoreWrapper() {
        this.valueOf.put("source", this.values);
        this.valueOf.put("type", this.afInfoLog);
        this.valueOf.put("latency", Long.valueOf(System.currentTimeMillis() - this.AFLogger));
        this.afDebugLog = AFa1vSDK.FINISHED;
        setChanged();
        notifyObservers();
    }

    public abstract void valueOf(Context context);
}
