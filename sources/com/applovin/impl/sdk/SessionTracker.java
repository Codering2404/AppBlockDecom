package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.ba;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j f63156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f63157b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f63158c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f63159d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f63160e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicLong f63161f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f63162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Date f63163h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends com.applovin.impl.p {
        a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            SessionTracker.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (yp.g()) {
                    SessionTracker.this.b();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                SessionTracker.this.a();
            }
        }
    }

    SessionTracker(j jVar) {
        this.f63156a = jVar;
        Application application = (Application) j.m();
        application.registerActivityLifecycleCallbacks(new a());
        application.registerComponentCallbacks(new b());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new c(), intentFilter);
    }

    private void d() {
        this.f63156a.I();
        if (n.a()) {
            this.f63156a.I().a("SessionTracker", "Application Resumed");
        }
        this.f63161f.set(System.currentTimeMillis());
        boolean zBooleanValue = ((Boolean) this.f63156a.a(sj.v3)).booleanValue();
        long jLongValue = ((Long) this.f63156a.a(sj.w3)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.f63157b.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(jLongValue);
        if (this.f63163h == null || System.currentTimeMillis() - this.f63163h.getTime() >= millis) {
            this.f63156a.z().trackEvent("resumed");
            if (zBooleanValue) {
                this.f63163h = new Date();
            }
        }
        if (!zBooleanValue) {
            this.f63163h = new Date();
        }
        this.f63156a.C().c(ba.f58618p);
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.f63160e.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.f63161f.get();
    }

    public int getLastTrimMemoryLevel() {
        return this.f63159d.get();
    }

    public boolean isApplicationPaused() {
        return this.f63158c.get();
    }

    public void pauseForClick() {
        this.f63157b.set(true);
    }

    public void resumeForClick() {
        this.f63157b.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f63158c.compareAndSet(false, true)) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f63158c.compareAndSet(true, false)) {
            d();
        }
    }

    private void c() {
        this.f63156a.I();
        if (n.a()) {
            this.f63156a.I().a("SessionTracker", "Application Paused");
        }
        this.f63160e.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.f63157b.get()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.f63156a.a(sj.v3)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f63156a.a(sj.x3)).longValue());
        if (this.f63162g == null || System.currentTimeMillis() - this.f63162g.getTime() >= millis) {
            this.f63156a.z().trackEvent("paused");
            if (zBooleanValue) {
                this.f63162g = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.f63162g = new Date();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            SessionTracker.this.f63159d.set(i3);
            if (i3 == 20) {
                SessionTracker.this.a();
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }
}
