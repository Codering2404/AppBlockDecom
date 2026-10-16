package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.ll;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AppLovinCommunicator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AppLovinCommunicator f57878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f57879f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f57880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f57881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ll f57882c = new ll();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MessagingServiceImpl f57883d = new MessagingServiceImpl();

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f57879f) {
            try {
                if (f57878e == null) {
                    f57878e = new AppLovinCommunicator();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f57878e;
    }

    public void a(j jVar) {
        this.f57880a = jVar;
        this.f57881b = jVar.I();
        a("Attached SDK instance: " + jVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f57883d;
    }

    public boolean hasSubscriber(String str) {
        return this.f57882c.a(str);
    }

    public boolean respondsToTopic(String str) {
        return this.f57880a.q().a(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f57880a + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            if (!this.f57882c.a(appLovinCommunicatorSubscriber, str)) {
                a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + str);
            }
        }
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + str);
            this.f57882c.b(appLovinCommunicatorSubscriber, str);
        }
    }

    private void a(String str) {
        if (this.f57881b == null || !n.a()) {
            return;
        }
        this.f57881b.a("AppLovinCommunicator", str);
    }
}
