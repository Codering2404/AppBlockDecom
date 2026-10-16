package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class hr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f60245f = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f60246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f60248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f60249d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Timer f60250e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends TimerTask {

        /* JADX INFO: renamed from: com.applovin.impl.hr$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0105a implements AppLovinBroadcastManager.Receiver {
            C0105a() {
            }

            @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
            public void onReceive(Intent intent, Map map) {
                AppLovinBroadcastManager.unregisterReceiver(this);
                hr.this.c();
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!hr.this.f60247b.e0().isApplicationPaused() || hr.this.f60246a) {
                hr.this.c();
            } else {
                AppLovinBroadcastManager.registerReceiver(new C0105a(), new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
        }
    }

    private hr(long j3, boolean z2, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        Timer timer = new Timer();
        this.f60250e = timer;
        if (j3 < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j3);
        }
        if (jVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
        this.f60246a = z2;
        this.f60247b = jVar;
        this.f60248c = runnable;
        f60245f.add(this);
        timer.schedule(b(), j3);
    }

    private TimerTask b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Runnable runnable = this.f60248c;
        if (runnable != null) {
            runnable.run();
            a();
        }
    }

    public void a() {
        synchronized (this.f60249d) {
            this.f60250e.cancel();
            this.f60248c = null;
            f60245f.remove(this);
        }
    }

    public static hr a(long j3, boolean z2, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new hr(j3, z2, jVar, runnable);
    }
}
