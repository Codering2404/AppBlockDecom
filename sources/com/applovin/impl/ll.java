package com.applovin.impl;

import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f61237a = new HashSet(32);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f61238b = new Object();

    public boolean a(String str) {
        synchronized (this.f61238b) {
            try {
                Iterator it = this.f61237a.iterator();
                while (it.hasNext()) {
                    if (str.equals(((ml) it.next()).b())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        ml mlVarA;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f61238b) {
                mlVarA = a(str, appLovinCommunicatorSubscriber);
            }
            if (mlVarA != null) {
                mlVarA.a(false);
                AppLovinBroadcastManager.unregisterReceiver(mlVarA);
            }
        }
    }

    private ml a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (ml mlVar : this.f61237a) {
            if (str.equals(mlVar.b()) && appLovinCommunicatorSubscriber.equals(mlVar.a())) {
                return mlVar;
            }
        }
        return null;
    }

    public boolean a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber != null && StringUtils.isValidString(str)) {
            synchronized (this.f61238b) {
                try {
                    ml mlVarA = a(str, appLovinCommunicatorSubscriber);
                    if (mlVarA != null) {
                        com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
                        if (!mlVarA.c()) {
                            mlVarA.a(true);
                            AppLovinBroadcastManager.registerReceiver(mlVarA, new IntentFilter(str));
                        }
                        return true;
                    }
                    ml mlVar = new ml(str, appLovinCommunicatorSubscriber);
                    this.f61237a.add(mlVar);
                    AppLovinBroadcastManager.registerReceiver(mlVar, new IntentFilter(str));
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
        return false;
    }
}
