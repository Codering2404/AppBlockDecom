package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.go;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.ue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class f implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private go f63274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f63275b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f63276c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f63277d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f63278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f63279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f63280h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void onAdRefresh();
    }

    public f(j jVar, a aVar) {
        this.f63279g = new WeakReference(aVar);
        this.f63278f = jVar;
    }

    private void e() {
        if (((Boolean) this.f63278f.a(ue.T6)).booleanValue()) {
            k();
        }
    }

    private void f() {
        if (((Boolean) this.f63278f.a(ue.T6)).booleanValue()) {
            synchronized (this.f63275b) {
                try {
                    if (this.f63277d) {
                        this.f63278f.I();
                        if (n.a()) {
                            this.f63278f.I().a("AdRefreshManager", "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                        }
                    } else if (this.f63278f.e0().isApplicationPaused()) {
                        this.f63278f.I();
                        if (n.a()) {
                            this.f63278f.I().a("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                        }
                    } else {
                        go goVar = this.f63274a;
                        if (goVar != null) {
                            goVar.e();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        l();
        a aVar = (a) this.f63279g.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    private void k() {
        synchronized (this.f63275b) {
            try {
                go goVar = this.f63274a;
                if (goVar != null) {
                    goVar.d();
                } else {
                    this.f63278f.I();
                    if (n.a()) {
                        this.f63278f.I().a("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                    }
                    this.f63276c.set(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        synchronized (this.f63275b) {
            try {
                this.f63274a = null;
                if (!((Boolean) this.f63278f.a(ue.U6)).booleanValue()) {
                    AppLovinBroadcastManager.unregisterReceiver(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n() {
        synchronized (this.f63275b) {
            try {
                go goVar = this.f63274a;
                if (goVar != null) {
                    goVar.e();
                } else {
                    this.f63276c.set(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long b() {
        long jC;
        synchronized (this.f63275b) {
            try {
                go goVar = this.f63274a;
                jC = goVar != null ? goVar.c() : -1L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jC;
    }

    public void c() {
        if (((Boolean) this.f63278f.a(ue.S6)).booleanValue()) {
            k();
        }
    }

    public void d() {
        boolean z2;
        a aVar;
        if (((Boolean) this.f63278f.a(ue.S6)).booleanValue()) {
            synchronized (this.f63275b) {
                try {
                    if (this.f63277d) {
                        this.f63278f.I();
                        if (n.a()) {
                            this.f63278f.I().a("AdRefreshManager", "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                        }
                        return;
                    }
                    if (this.f63278f.B().c()) {
                        this.f63278f.I();
                        if (n.a()) {
                            this.f63278f.I().a("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                        }
                        return;
                    }
                    if (this.f63274a != null) {
                        long jB = this.f63280h - b();
                        long jLongValue = ((Long) this.f63278f.a(ue.R6)).longValue();
                        if (jLongValue < 0 || jB <= jLongValue) {
                            this.f63274a.e();
                            z2 = false;
                        } else {
                            a();
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    if (!z2 || (aVar = (a) this.f63279g.get()) == null) {
                        return;
                    }
                    aVar.onAdRefresh();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean g() {
        return this.f63277d;
    }

    public boolean h() {
        boolean z2;
        synchronized (this.f63275b) {
            z2 = this.f63274a != null;
        }
        return z2;
    }

    public void j() {
        synchronized (this.f63275b) {
            k();
            this.f63277d = true;
        }
    }

    public void m() {
        synchronized (this.f63275b) {
            n();
            this.f63277d = false;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            c();
            return;
        }
        if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            d();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            e();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            f();
        }
    }

    public void a(long j3) {
        synchronized (this.f63275b) {
            try {
                a();
                this.f63280h = j3;
                this.f63274a = go.a(j3, this.f63278f, new Runnable() { // from class: com.applovin.impl.sdk.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63319a.i();
                    }
                });
                if (!((Boolean) this.f63278f.a(ue.U6)).booleanValue()) {
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
                }
                if (((Boolean) this.f63278f.a(ue.T6)).booleanValue() && (this.f63278f.B().c() || this.f63278f.e0().isApplicationPaused())) {
                    this.f63274a.d();
                }
                if (this.f63276c.compareAndSet(true, false) && ((Boolean) this.f63278f.a(ue.V6)).booleanValue()) {
                    this.f63278f.I();
                    if (n.a()) {
                        this.f63278f.I().a("AdRefreshManager", "Pausing refresh for a previous request.");
                    }
                    this.f63274a.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        synchronized (this.f63275b) {
            try {
                go goVar = this.f63274a;
                if (goVar != null) {
                    goVar.a();
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
