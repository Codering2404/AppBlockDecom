package com.applovin.impl;

import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ml implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f61909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f61910c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f61908a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f61911d = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f61912f = new Object();

    ml(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f61909b = str;
        this.f61910c = new WeakReference(appLovinCommunicatorSubscriber);
    }

    public AppLovinCommunicatorSubscriber a() {
        return (AppLovinCommunicatorSubscriber) this.f61910c.get();
    }

    public String b() {
        return this.f61909b;
    }

    public boolean c() {
        return this.f61908a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ml)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.f61910c.get();
        ml mlVar = (ml) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = (AppLovinCommunicatorSubscriber) mlVar.f61910c.get();
        return b().equals(mlVar.b()) && (appLovinCommunicatorSubscriber == null ? appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2 : appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2));
    }

    public int hashCode() {
        int iHashCode = this.f61909b.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.f61910c.get();
        return (iHashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        boolean z2;
        if (a() == null) {
            com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        synchronized (this.f61912f) {
            try {
                if (this.f61911d.contains(communicatorMessageImpl.getUniqueId())) {
                    z2 = false;
                } else {
                    this.f61911d.add(communicatorMessageImpl.getUniqueId());
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            a().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }

    public void a(boolean z2) {
        this.f61908a = z2;
    }
}
