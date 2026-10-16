package com.applovin.impl;

import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class fi {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f59702h = new Executor() { // from class: com.applovin.impl.zw
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Executor f59703i = new androidx.credentials.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f59705b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f59709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f59710g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f59704a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f59706c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f59707d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f59708e = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(boolean z2, Object obj, Object obj2);
    }

    public fi(String str) {
        this.f59705b = str;
    }

    public void a(Executor executor, b bVar) {
        Runnable runnableC = c(executor, bVar);
        synchronized (this.f59704a) {
            try {
                if (this.f59707d) {
                    runnableC.run();
                } else {
                    this.f59706c.add(runnableC);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        String str;
        if (!this.f59707d) {
            str = "Waiting";
        } else if (this.f59708e) {
            str = "Success -> " + this.f59709f;
        } else {
            str = "Failed -> " + this.f59710g;
        }
        return "Promise(" + b() + ": " + str + ")";
    }

    public String b() {
        String str = this.f59705b;
        return str != null ? str : super.toString();
    }

    public boolean c() {
        return this.f59707d;
    }

    public boolean d() {
        return this.f59707d && !this.f59708e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Executor executor, final b bVar) {
        try {
            executor.execute(new Runnable() { // from class: com.applovin.impl.vw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f64513a.a(bVar);
                }
            });
        } catch (Throwable th) {
            a(th);
        }
    }

    private Runnable c(final Executor executor, final b bVar) {
        return new Runnable() { // from class: com.applovin.impl.ww
            @Override // java.lang.Runnable
            public final void run() {
                this.f64745a.b(executor, bVar);
            }
        };
    }

    public fi b(Object obj) {
        a(true, obj, null);
        return this;
    }

    public void a(Executor executor, final a aVar) {
        a(executor, new b() { // from class: com.applovin.impl.yw
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z2, Object obj, Object obj2) {
                fi.a(aVar, z2, obj, obj2);
            }
        });
    }

    public void a(Executor executor, final Runnable runnable) {
        a(executor, new b() { // from class: com.applovin.impl.xw
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z2, Object obj, Object obj2) {
                fi.a(runnable, z2, obj, obj2);
            }
        });
    }

    public Object a() {
        p6.a(d());
        return this.f59710g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, boolean z2, Object obj, Object obj2) {
        if (z2) {
            return;
        }
        aVar.a(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, boolean z2, Object obj, Object obj2) {
        if (z2) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        try {
            bVar.a(this.f59708e, this.f59709f, this.f59710g);
        } catch (Throwable th) {
            a(th);
        }
    }

    private void a(Throwable th) {
        p6.a(th);
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f63329u0;
        if (jVar != null) {
            jVar.D().a("Promise", "PromiseCallback: " + b(), th);
        }
    }

    public fi a(Object obj) {
        a(false, null, obj);
        return this;
    }

    private void a(boolean z2, Object obj, Object obj2) {
        synchronized (this.f59704a) {
            try {
                if (this.f59707d) {
                    return;
                }
                this.f59709f = obj;
                this.f59710g = obj2;
                this.f59708e = z2;
                this.f59707d = true;
                Iterator it = this.f59706c.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                this.f59706c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static fi a(String str, Object obj) {
        return new fi(str).b(obj);
    }
}
