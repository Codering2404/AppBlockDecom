package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f63573a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f63574b = new Object();

    p() {
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f63574b) {
            try {
                if (b() <= 25) {
                    this.f63573a.offer(appLovinAdImpl);
                } else {
                    n.h("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    int b() {
        int size;
        synchronized (this.f63574b) {
            size = this.f63573a.size();
        }
        return size;
    }

    boolean c() {
        boolean z2;
        synchronized (this.f63574b) {
            z2 = b() == 0;
        }
        return z2;
    }

    AppLovinAdImpl d() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f63574b) {
            appLovinAdImpl = (AppLovinAdImpl) this.f63573a.peek();
        }
        return appLovinAdImpl;
    }

    void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f63574b) {
            this.f63573a.remove(appLovinAdImpl);
        }
    }

    AppLovinAdImpl a() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f63574b) {
            try {
                appLovinAdImpl = !c() ? (AppLovinAdImpl) this.f63573a.poll() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appLovinAdImpl;
    }
}
