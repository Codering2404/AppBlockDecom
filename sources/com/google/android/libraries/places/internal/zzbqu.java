package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzbqu extends zzbix {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzbix f76671j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledFuture f76672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f76673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbjs f76674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f76675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbiw f76676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbix f76677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbnp f76678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f76679h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbqt f76680i;

    static {
        Logger.getLogger(zzbqu.class.getName());
        f76671j = new zzbqn();
    }

    protected zzbqu(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbjv zzbjvVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        this.f76673b = (Executor) Preconditions.u(executor, "callExecutor");
        Preconditions.u(scheduledExecutorService, "scheduler");
        this.f76674c = zzbjs.a();
        if (zzbjvVar != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jC = zzbjvVar.c(timeUnit);
            scheduledFutureSchedule = scheduledExecutorService.schedule(new zzbqg(this, jC, "CallOptions"), jC, timeUnit);
        } else {
            scheduledFutureSchedule = null;
        }
        this.f76672a = scheduledFutureSchedule;
    }

    private final void l(zzbnp zzbnpVar, boolean z2) {
        zzbiw zzbiwVar;
        boolean z3;
        synchronized (this) {
            try {
                if (this.f76677f == null) {
                    o(f76671j);
                    zzbiwVar = this.f76676e;
                    this.f76678g = zzbnpVar;
                    z3 = false;
                } else {
                    if (z2) {
                        return;
                    }
                    zzbiwVar = null;
                    z3 = true;
                }
                if (z3) {
                    m(new zzbqj(this, zzbnpVar));
                } else {
                    if (zzbiwVar != null) {
                        this.f76673b.execute(new zzbqo(this, zzbiwVar, zzbnpVar));
                    }
                    i();
                }
                g();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void m(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f76675d) {
                    runnable.run();
                } else {
                    this.f76679h.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f76679h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f76679h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f76675d = r0     // Catch: java.lang.Throwable -> L24
            com.google.android.libraries.places.internal.zzbqt r0 = r3.f76680i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f76673b
            com.google.android.libraries.places.internal.zzbqh r2 = new com.google.android.libraries.places.internal.zzbqh
            r2.<init>(r3, r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f76679h     // Catch: java.lang.Throwable -> L24
            r3.f76679h = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbqu.i():void");
    }

    private final void o(zzbix zzbixVar) {
        zzbix zzbixVar2 = this.f76677f;
        Preconditions.D(zzbixVar2 == null, "realCall already set to %s", zzbixVar2);
        ScheduledFuture scheduledFuture = this.f76672a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f76677f = zzbixVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, zzbmg zzbmgVar) {
        zzbnp zzbnpVar;
        boolean z2;
        Preconditions.A(this.f76676e == null, "already started");
        synchronized (this) {
            try {
                this.f76676e = (zzbiw) Preconditions.u(zzbiwVar, "listener");
                zzbnpVar = this.f76678g;
                z2 = this.f76675d;
                if (!z2) {
                    zzbqt zzbqtVar = new zzbqt(zzbiwVar);
                    this.f76680i = zzbqtVar;
                    zzbiwVar = zzbqtVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzbnpVar != null) {
            this.f76673b.execute(new zzbqo(this, zzbiwVar, zzbnpVar));
        } else if (z2) {
            this.f76677f.a(zzbiwVar, zzbmgVar);
        } else {
            m(new zzbqi(this, zzbiwVar, zzbmgVar));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void b(Object obj) {
        if (this.f76675d) {
            this.f76677f.b(obj);
        } else {
            m(new zzbqk(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void c(int i3) {
        if (this.f76675d) {
            this.f76677f.c(i3);
        } else {
            m(new zzbql(this, i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void d() {
        m(new zzbqm(this));
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void e(String str, Throwable th) {
        zzbnp zzbnpVar = zzbnp.f76489f;
        zzbnp zzbnpVarE = str != null ? zzbnpVar.e(str) : zzbnpVar.e("Call cancelled without message");
        if (th != null) {
            zzbnpVarE = zzbnpVarE.d(th);
        }
        l(zzbnpVarE, false);
    }

    public final Runnable f(zzbix zzbixVar) {
        synchronized (this) {
            try {
                if (this.f76677f != null) {
                    return null;
                }
                o((zzbix) Preconditions.u(zzbixVar, "call"));
                return new zzbqf(this, this.f76674c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void h(zzbnp zzbnpVar, boolean z2) {
        l(zzbnpVar, true);
    }

    final /* synthetic */ zzbjs j() {
        return this.f76674c;
    }

    final /* synthetic */ zzbix k() {
        return this.f76677f;
    }

    public final String toString() {
        return MoreObjects.c(this).d("realCall", this.f76677f).toString();
    }

    protected void g() {
    }
}
