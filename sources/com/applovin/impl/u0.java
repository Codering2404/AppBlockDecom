package com.applovin.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class u0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final u0 f64020l = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f64022b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f64024d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.applovin.impl.sdk.j f64027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Thread f64028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f64029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f64030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f64031k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f64021a = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerThread f64023c = new HandlerThread("AppLovinSdk:anr_detector");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f64025e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f64026f = new AtomicBoolean();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (u0.this.f64025e.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - u0.this.f64021a.get();
            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > u0.this.f64029i) {
                u0.this.a();
                if (u0.this.f64028h == null || u0.this.f64028h.getStackTrace().length <= 0) {
                    str = "None";
                } else {
                    StackTraceElement stackTraceElement = u0.this.f64028h.getStackTrace()[0];
                    str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                }
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - com.applovin.impl.sdk.j.l());
                HashMap map = new HashMap(3);
                map.put("top_main_method", str);
                map.put("source", u0.this.f64027g.r0() ? "non_first_session" : "first_session");
                map.put("details", "seconds_since_app_launch=" + seconds);
                u0.this.f64027g.D().a(ka.M, (Map) map);
            }
            u0.this.f64024d.postDelayed(this, u0.this.f64031k);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.f64025e.get()) {
                return;
            }
            u0.this.f64021a.set(System.currentTimeMillis());
            u0.this.f64022b.postDelayed(this, u0.this.f64030j);
        }
    }

    private u0() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f64029i = timeUnit.toMillis(4L);
        this.f64030j = timeUnit.toMillis(3L);
        this.f64031k = timeUnit.toMillis(3L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f64026f.get()) {
            this.f64025e.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f64028h = Thread.currentThread();
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (((Boolean) jVar.a(sj.M5)).booleanValue() && !yp.c(jVar)) {
                f64020l.a(jVar);
            } else {
                f64020l.a();
            }
        }
    }

    private void a(com.applovin.impl.sdk.j jVar) {
        if (this.f64026f.compareAndSet(false, true)) {
            this.f64027g = jVar;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.b60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58570a.b();
                }
            });
            this.f64029i = ((Long) jVar.a(sj.N5)).longValue();
            this.f64030j = ((Long) jVar.a(sj.O5)).longValue();
            this.f64031k = ((Long) jVar.a(sj.P5)).longValue();
            this.f64022b = new Handler(com.applovin.impl.sdk.j.m().getMainLooper());
            this.f64023c.start();
            this.f64022b.post(new c());
            Handler handler = new Handler(this.f64023c.getLooper());
            this.f64024d = handler;
            handler.postDelayed(new b(), this.f64031k / 2);
        }
    }
}
