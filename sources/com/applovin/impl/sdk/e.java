package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f63267b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f63269d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f63270e = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f63268c = new Object();

    e(j jVar) {
        this.f63266a = jVar;
        this.f63267b = jVar.I();
        for (com.applovin.impl.h0 h0Var : com.applovin.impl.h0.a()) {
            this.f63269d.put(h0Var, new p());
            this.f63270e.put(h0Var, new p());
        }
    }

    private p b(com.applovin.impl.h0 h0Var) {
        p pVar;
        synchronized (this.f63268c) {
            try {
                pVar = (p) this.f63270e.get(h0Var);
                if (pVar == null) {
                    pVar = new p();
                    this.f63270e.put(h0Var, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    private p c(com.applovin.impl.h0 h0Var) {
        synchronized (this.f63268c) {
            try {
                p pVarB = b(h0Var);
                if (pVarB.b() > 0) {
                    return pVarB;
                }
                return d(h0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private p d(com.applovin.impl.h0 h0Var) {
        p pVar;
        synchronized (this.f63268c) {
            try {
                pVar = (p) this.f63269d.get(h0Var);
                if (pVar == null) {
                    pVar = new p();
                    this.f63269d.put(h0Var, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    public AppLovinAdImpl a(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplA;
        synchronized (this.f63268c) {
            appLovinAdImplA = c(h0Var).a();
        }
        return appLovinAdImplA;
    }

    public AppLovinAdImpl e(com.applovin.impl.h0 h0Var) {
        com.applovin.impl.sdk.ad.c cVar;
        synchronized (this.f63268c) {
            try {
                p pVarD = d(h0Var);
                if (pVarD.b() > 0) {
                    b(h0Var).a(pVarD.a());
                    cVar = new com.applovin.impl.sdk.ad.c(h0Var, this.f63266a);
                } else {
                    cVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (cVar != null) {
            if (n.a()) {
                this.f63267b.a("AdPreloadManager", "Retrieved ad of zone " + h0Var + "...");
                return cVar;
            }
        } else if (n.a()) {
            this.f63267b.a("AdPreloadManager", "Unable to retrieve ad of zone " + h0Var + "...");
        }
        return cVar;
    }

    public AppLovinAdBase f(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplD;
        synchronized (this.f63268c) {
            appLovinAdImplD = c(h0Var).d();
        }
        return appLovinAdImplD;
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f63268c) {
            try {
                d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
                if (n.a()) {
                    this.f63267b.a("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f63268c) {
            c(appLovinAdImpl.getAdZone()).b(appLovinAdImpl);
        }
    }
}
