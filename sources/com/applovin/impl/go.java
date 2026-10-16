package com.applovin.impl;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class go {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f60020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f60021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f60022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f60023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f60024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f60025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f60026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f60027i = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                go.this.f60025g.run();
                synchronized (go.this.f60027i) {
                    try {
                        if (go.this.f60024f) {
                            go.this.f60021c = System.currentTimeMillis();
                            go goVar = go.this;
                            goVar.f60022d = goVar.f60023e;
                        } else {
                            go.this.f60020b = null;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    if (go.this.f60019a != null) {
                        go.this.f60019a.I();
                        if (com.applovin.impl.sdk.n.a()) {
                            go.this.f60019a.I().a("Timer", "Encountered error while executing timed task", th);
                        }
                        go.this.f60019a.D().a("Timer", "executingTimedTask", th);
                    }
                    synchronized (go.this.f60027i) {
                        try {
                            if (go.this.f60024f) {
                                go.this.f60021c = System.currentTimeMillis();
                                go goVar2 = go.this;
                                goVar2.f60022d = goVar2.f60023e;
                            } else {
                                go.this.f60020b = null;
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (go.this.f60027i) {
                        try {
                            if (go.this.f60024f) {
                                go.this.f60021c = System.currentTimeMillis();
                                go goVar3 = go.this;
                                goVar3.f60022d = goVar3.f60023e;
                            } else {
                                go.this.f60020b = null;
                            }
                            throw th2;
                        } finally {
                        }
                    }
                }
            }
        }
    }

    private go(com.applovin.impl.sdk.j jVar, Runnable runnable) {
        this.f60019a = jVar;
        this.f60025g = runnable;
    }

    public long c() {
        if (this.f60020b == null) {
            return this.f60022d - this.f60026h;
        }
        return this.f60022d - (System.currentTimeMillis() - this.f60021c);
    }

    public void d() {
        synchronized (this.f60027i) {
            Timer timer = this.f60020b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f60026h = Math.max(1L, System.currentTimeMillis() - this.f60021c);
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f60019a;
                        if (jVar != null) {
                            jVar.I();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f60019a.I();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f60019a.I().a("Timer", "Encountered error while pausing timer", th);
                                }
                            }
                        }
                        this.f60020b = null;
                    } finally {
                        this.f60020b = null;
                    }
                }
            }
        }
    }

    public void e() {
        go goVar;
        synchronized (this.f60027i) {
            try {
                try {
                    long j3 = this.f60026h;
                    if (j3 > 0) {
                        try {
                            long j4 = this.f60022d - j3;
                            this.f60022d = j4;
                            if (j4 < 0) {
                                this.f60022d = 0L;
                            }
                            this.f60020b = new Timer();
                            goVar = this;
                        } catch (Throwable th) {
                            th = th;
                            goVar = this;
                        }
                        try {
                            goVar.a(b(), this.f60022d, this.f60024f, this.f60023e);
                            goVar.f60021c = System.currentTimeMillis();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.applovin.impl.sdk.j jVar = goVar.f60019a;
                                if (jVar != null) {
                                    jVar.I();
                                    if (com.applovin.impl.sdk.n.a()) {
                                        goVar.f60019a.I();
                                        if (com.applovin.impl.sdk.n.a()) {
                                            goVar.f60019a.I().a("Timer", "Encountered error while resuming timer", th);
                                        }
                                    }
                                }
                                goVar.f60026h = 0L;
                            } finally {
                                goVar.f60026h = 0L;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    private TimerTask b() {
        return new a();
    }

    public void a() {
        synchronized (this.f60027i) {
            Timer timer = this.f60020b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f60020b = null;
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.j jVar = this.f60019a;
                        if (jVar != null) {
                            jVar.I();
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f60019a.I();
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f60019a.I().a("Timer", "Encountered error while cancelling timer", th);
                                }
                            }
                        }
                        this.f60020b = null;
                    } catch (Throwable th2) {
                        this.f60020b = null;
                        this.f60026h = 0L;
                        throw th2;
                    }
                }
                this.f60026h = 0L;
            }
        }
    }

    public static go a(long j3, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return a(j3, false, jVar, runnable);
    }

    public static go a(long j3, boolean z2, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j3 + ".");
        }
        if (runnable != null) {
            go goVar = new go(jVar, runnable);
            goVar.f60021c = System.currentTimeMillis();
            goVar.f60022d = j3;
            goVar.f60024f = z2;
            goVar.f60023e = j3;
            try {
                goVar.f60020b = new Timer();
                goVar.a(goVar.b(), j3, z2, goVar.f60023e);
                return goVar;
            } catch (OutOfMemoryError e3) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Timer", "Failed to create timer due to OOM error", e3);
                }
                return goVar;
            }
        }
        throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
    }

    private void a(TimerTask timerTask, long j3, boolean z2, long j4) {
        if (z2) {
            this.f60020b.schedule(timerTask, j3, j4);
        } else {
            this.f60020b.schedule(timerTask, j3);
        }
    }
}
