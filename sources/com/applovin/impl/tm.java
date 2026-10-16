package com.applovin.impl;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class tm {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ExecutorService f63954o = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f63955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f63956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f63963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f63964j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f63965k = new ArrayList(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f63966l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f63967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f63968n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f63969a;

        static {
            int[] iArr = new int[b.values().length];
            f63969a = iArr;
            try {
                iArr[b.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63969a[b.CACHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63969a[b.MEDIATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63969a[b.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        CORE,
        CACHING,
        MEDIATION,
        TIMEOUT,
        OTHER
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f63976a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements Thread.UncaughtExceptionHandler {
            a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                com.applovin.impl.sdk.n unused = tm.this.f63956b;
                if (com.applovin.impl.sdk.n.a()) {
                    tm.this.f63956b.a("TaskManager", "Caught unhandled exception", th);
                }
            }
        }

        c(String str) {
            this.f63976a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f63976a);
            thread.setDaemon(true);
            thread.setPriority(((Integer) tm.this.f63955a.a(sj.S)).intValue());
            thread.setUncaughtExceptionHandler(new a());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f63979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f63980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f63981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final yl f63982d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f63983f;

        public d(com.applovin.impl.sdk.j jVar, yl ylVar, b bVar) {
            this.f63979a = jVar;
            this.f63981c = jVar.I();
            this.f63980b = ylVar.c();
            this.f63982d = ylVar;
            this.f63983f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = QaXmqxvjHhxVy.rcSTpLINTYIjFw;
            try {
                z3.a();
                if (!this.f63979a.v0() || this.f63982d.d()) {
                    ScheduledFuture scheduledFutureB = this.f63982d.b(Thread.currentThread(), ((Long) this.f63979a.a(sj.f63806y)).longValue());
                    this.f63982d.run();
                    if (scheduledFutureB != null) {
                        scheduledFutureB.cancel(false);
                    }
                } else {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f63981c.d(this.f63980b, "Task re-scheduled...");
                    }
                    this.f63979a.i0().a(this.f63982d, this.f63983f, 2000L);
                }
            } catch (Throwable th) {
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f63981c.a(this.f63980b, "Task failed execution", th);
                    }
                    this.f63982d.a(th);
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f63981c.d(this.f63980b, this.f63983f + str + this.f63982d.c());
                    }
                } finally {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f63981c.d(this.f63980b, this.f63983f + str + this.f63982d.c());
                    }
                }
            }
        }
    }

    public tm(com.applovin.impl.sdk.j jVar) {
        this.f63955a = jVar;
        this.f63956b = jVar.I();
        this.f63968n = ((Boolean) jVar.a(sj.V)).booleanValue();
        this.f63957c = b("auxiliary_operations", ((Integer) jVar.a(sj.Q)).intValue());
        this.f63958d = b("shared_thread_pool", ((Integer) jVar.a(sj.P)).intValue());
        this.f63959e = b("core", ((Integer) jVar.a(sj.W)).intValue());
        this.f63961g = b("caching", ((Integer) jVar.a(sj.X)).intValue());
        this.f63962h = b("mediation", ((Integer) jVar.a(sj.Y)).intValue());
        this.f63960f = b("timeout", ((Integer) jVar.a(sj.Z)).intValue());
        this.f63963i = b("other", ((Integer) jVar.a(sj.f63720a0)).intValue());
    }

    public Executor c() {
        return this.f63968n ? this.f63959e : this.f63958d;
    }

    public boolean d() {
        return this.f63967m;
    }

    public void e() {
        synchronized (this.f63966l) {
            try {
                this.f63967m = true;
                for (d dVar : this.f63965k) {
                    a(dVar.f63982d, dVar.f63983f);
                }
                this.f63965k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        synchronized (this.f63966l) {
            this.f63967m = false;
        }
    }

    public ExecutorService a(String str, int i3) {
        return Executors.newFixedThreadPool(i3, new c(str));
    }

    public void a(yl ylVar, b bVar) {
        a(ylVar, bVar, 0L);
    }

    public ExecutorService b() {
        return this.f63968n ? this.f63961g : f63954o;
    }

    private boolean b(d dVar) {
        if (dVar.f63982d.d()) {
            return false;
        }
        synchronized (this.f63966l) {
            try {
                if (this.f63967m) {
                    return false;
                }
                this.f63965k.add(dVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(yl ylVar, b bVar, long j3) {
        a(ylVar, bVar, j3, false);
    }

    public void a(yl ylVar, b bVar, long j3, boolean z2) {
        if (ylVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j3 >= 0) {
            d dVar = new d(this.f63955a, ylVar, bVar);
            if (!b(dVar)) {
                a(dVar, j3, z2);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f63956b.d(ylVar.c(), "Task execution delayed until after init");
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Invalid delay (millis) specified: " + j3);
    }

    public void a(yl ylVar, oe oeVar) {
        String strB = oeVar.b();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = (ScheduledThreadPoolExecutor) this.f63964j.get(strB);
        if (scheduledThreadPoolExecutorB == null) {
            scheduledThreadPoolExecutorB = b(strB, 1);
            this.f63964j.put(strB, scheduledThreadPoolExecutorB);
        }
        scheduledThreadPoolExecutorB.submit(new d(this.f63955a, ylVar, b.MEDIATION));
    }

    public ScheduledFuture b(yl ylVar, b bVar, long j3) {
        if (this.f63968n) {
            return a(new d(this.f63955a, ylVar, bVar)).schedule(ylVar, j3, TimeUnit.MILLISECONDS);
        }
        return this.f63957c.schedule(ylVar, j3, TimeUnit.MILLISECONDS);
    }

    private ScheduledThreadPoolExecutor b(String str, int i3) {
        return new ScheduledThreadPoolExecutor(i3, new c(str));
    }

    public void a(Runnable runnable, b bVar) {
        if (this.f63968n) {
            com.applovin.impl.sdk.j jVar = this.f63955a;
            d dVar = new d(jVar, new jn(jVar, "auxiliaryOperation", runnable), bVar);
            a(dVar).submit(dVar);
            return;
        }
        this.f63957c.submit(runnable);
    }

    public void a(yl ylVar) {
        if (ylVar != null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f63968n ? this.f63959e : this.f63958d;
            try {
                if (yp.h()) {
                    scheduledThreadPoolExecutor.submit(new d(this.f63955a, ylVar, b.CORE));
                    return;
                }
                ScheduledFuture scheduledFutureB = ylVar.b(Thread.currentThread(), ((Long) this.f63955a.a(sj.f63806y)).longValue());
                ylVar.run();
                if (scheduledFutureB != null) {
                    scheduledFutureB.cancel(false);
                    return;
                }
                return;
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f63956b.a(ylVar.c(), "Task failed execution", th);
                }
                ylVar.a(th);
                return;
            }
        }
        throw new IllegalArgumentException("No task specified");
    }

    public ExecutorService a() {
        return this.f63968n ? this.f63963i : this.f63957c;
    }

    private void a(final d dVar, long j3, boolean z2) {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = this.f63968n ? a(dVar) : this.f63958d;
        if (j3 <= 0) {
            scheduledThreadPoolExecutorA.submit(dVar);
        } else if (z2) {
            x1.a(j3, this.f63955a, new Runnable() { // from class: com.applovin.impl.u50
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledThreadPoolExecutorA.execute(dVar);
                }
            });
        } else {
            scheduledThreadPoolExecutorA.schedule(dVar, j3, TimeUnit.MILLISECONDS);
        }
    }

    private ScheduledThreadPoolExecutor a(d dVar) {
        int i3 = a.f63969a[dVar.f63983f.ordinal()];
        if (i3 == 1) {
            return this.f63959e;
        }
        if (i3 == 2) {
            return this.f63961g;
        }
        if (i3 == 3) {
            return this.f63962h;
        }
        if (i3 != 4) {
            return this.f63963i;
        }
        return this.f63960f;
    }

    public List a(List list, ExecutorService executorService) {
        try {
            if (com.applovin.impl.sdk.n.a()) {
                this.f63956b.a("TaskManager", "Awaiting " + list.size() + " tasks...");
            }
            return executorService.invokeAll(list);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f63956b.a("TaskManager", "Awaiting tasks were interrupted", th);
            return null;
        }
    }
}
