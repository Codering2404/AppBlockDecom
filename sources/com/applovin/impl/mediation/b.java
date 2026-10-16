package com.applovin.impl.mediation;

import com.applovin.impl.fc;
import com.applovin.impl.he;
import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b implements a.InterfaceC0109a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f61601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f61602c;

    public b(com.applovin.impl.sdk.j jVar) {
        this.f61600a = jVar;
        this.f61601b = new a(jVar);
        this.f61602c = new c(jVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(he heVar) {
        g gVarA;
        if (heVar == null || (gVarA = heVar.A()) == null || !heVar.w().compareAndSet(false, true)) {
            return;
        }
        fc.e(gVarA.c(), heVar);
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0109a
    public void b(final he heVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f61842a.c(heVar);
            }
        }, heVar.i0());
    }

    public void e(he heVar) {
        long jJ0 = heVar.j0();
        if (jJ0 >= 0) {
            this.f61602c.a(heVar, jJ0);
        }
        boolean z2 = Boolean.parseBoolean(this.f61600a.f0().getExtraParameters().get("should_schedule_ad_hidden_on_ad_destroy"));
        if (heVar.s0() || heVar.t0() || z2) {
            this.f61601b.a(z2);
            this.f61601b.a(heVar, this);
        }
    }

    @Override // com.applovin.impl.mediation.c.a
    public void a(he heVar) {
        c(heVar);
    }

    public void a() {
        this.f61602c.a();
        this.f61601b.a();
    }
}
