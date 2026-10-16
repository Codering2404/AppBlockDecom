package com.applovin.impl.sdk;

import com.applovin.impl.sj;
import com.applovin.impl.ze;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f63417j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63418a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f63420c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f63423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f63424g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f63419b = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f63421d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f63422e = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f63425h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f63426i = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f63427a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f63428b;

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f63427a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a((Object) this) && b() == aVar.b() && a() == aVar.a();
        }

        public int hashCode() {
            long jB = b();
            return ((((int) (jB ^ (jB >>> 32))) + 59) * 59) + a();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + b() + ", attemptCount=" + a() + ")";
        }

        static /* synthetic */ int a(a aVar) {
            int i3 = aVar.f63428b;
            aVar.f63428b = i3 + 1;
            return i3;
        }

        public int a() {
            return this.f63428b;
        }
    }

    m(j jVar) {
        this.f63418a = jVar;
    }

    public boolean c() {
        return this.f63419b.get();
    }

    public boolean d() {
        return this.f63422e.get();
    }

    public void a(boolean z2) {
        synchronized (this.f63421d) {
            try {
                this.f63422e.set(z2);
                if (z2) {
                    this.f63423f = System.currentTimeMillis();
                    this.f63418a.I();
                    if (n.a()) {
                        this.f63418a.I().a("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f63423f);
                    }
                    final Long l3 = (Long) this.f63418a.a(sj.Q1);
                    if (l3.longValue() >= 0) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.e1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f63272a.a(l3);
                            }
                        }, l3.longValue());
                    }
                } else {
                    this.f63423f = 0L;
                    this.f63418a.I();
                    if (n.a()) {
                        this.f63418a.I().a("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long b() {
        return this.f63420c;
    }

    public void c(String str) {
        synchronized (this.f63426i) {
            try {
                a aVar = (a) this.f63425h.get(str);
                if (aVar == null) {
                    aVar = new a();
                    this.f63425h.put(str, aVar);
                }
                aVar.f63427a = System.currentTimeMillis();
                a.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Object obj) {
        if (!ze.a(obj) && this.f63419b.compareAndSet(true, false)) {
            this.f63424g = null;
            this.f63418a.I();
            if (n.a()) {
                this.f63418a.I().a("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public a b(String str) {
        a aVar;
        synchronized (this.f63426i) {
            aVar = (a) this.f63425h.get(str);
            if (aVar == null) {
                aVar = f63417j;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l3) {
        if (d() && System.currentTimeMillis() - this.f63423f >= l3.longValue()) {
            this.f63418a.I();
            if (n.a()) {
                this.f63418a.I().a("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.f63422e.set(false);
        }
    }

    public Object a() {
        return this.f63424g;
    }

    public void a(final Object obj) {
        if (!ze.a(obj) && this.f63419b.compareAndSet(false, true)) {
            this.f63424g = obj;
            this.f63420c = System.currentTimeMillis();
            this.f63418a.I();
            if (n.a()) {
                this.f63418a.I().a("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f63420c);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final Long l3 = (Long) this.f63418a.a(sj.R1);
            if (l3.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.d1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63263a.a(l3, obj);
                    }
                }, l3.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l3, Object obj) {
        if (this.f63419b.get() && System.currentTimeMillis() - this.f63420c >= l3.longValue()) {
            this.f63418a.I();
            if (n.a()) {
                this.f63418a.I().a("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            b(obj);
        }
    }

    public void a(String str) {
        synchronized (this.f63426i) {
            this.f63425h.remove(str);
        }
    }
}
