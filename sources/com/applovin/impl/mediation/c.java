package com.applovin.impl.mediation;

import com.applovin.impl.he;
import com.applovin.impl.x1;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f61612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x1 f61613d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(he heVar);
    }

    c(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f61610a = jVar;
        this.f61611b = jVar.I();
        this.f61612c = aVar;
    }

    public void a(final he heVar, long j3) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61611b.a("AdHiddenCallbackTimeoutManager", "Scheduling in " + j3 + "ms...");
        }
        this.f61613d = x1.a(j3, this.f61610a, new Runnable() { // from class: com.applovin.impl.mediation.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f61846a.a(heVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(he heVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61611b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.f61612c.a(heVar);
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61611b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        x1 x1Var = this.f61613d;
        if (x1Var != null) {
            x1Var.a();
            this.f61613d = null;
        }
    }
}
