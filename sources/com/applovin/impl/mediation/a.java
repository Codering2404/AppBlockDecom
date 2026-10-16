package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.jE.vxrlPPpdv;
import com.applovin.impl.he;
import com.applovin.impl.yp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a extends com.applovin.impl.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.q f61465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f61467c = yp.l(com.applovin.impl.sdk.j.m());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0109a f61468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private he f61469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f61470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f61471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f61472h;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InterfaceC0109a {
        void b(he heVar);
    }

    a(com.applovin.impl.sdk.j jVar) {
        this.f61466b = jVar.I();
        this.f61465a = jVar.e();
    }

    public void a(boolean z2) {
        this.f61470f = z2;
    }

    @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass().getName().equals(this.f61467c) && (this.f61469e.t0() || this.f61470f)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61466b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
            }
            if (this.f61468d != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61466b.a("AdActivityObserver", "Invoking callback...");
                }
                this.f61468d.b(this.f61469e);
            }
            a();
            return;
        }
        if (!this.f61472h) {
            this.f61472h = true;
        }
        this.f61471g++;
        if (com.applovin.impl.sdk.n.a()) {
            this.f61466b.a("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f61471g);
        }
    }

    public void a(he heVar, InterfaceC0109a interfaceC0109a) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61466b.a("AdActivityObserver", "Starting for ad " + heVar.getAdUnitId() + "...");
        }
        a();
        this.f61468d = interfaceC0109a;
        this.f61469e = heVar;
        this.f61465a.a(this);
    }

    @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f61472h) {
            this.f61471g--;
            if (com.applovin.impl.sdk.n.a()) {
                this.f61466b.a("AdActivityObserver", "Destroyed Activity: " + activity + vxrlPPpdv.CoDaYWrCJJZBFN + this.f61471g);
            }
            if (this.f61471g <= 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61466b.a("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.f61468d != null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61466b.a("AdActivityObserver", "Invoking callback...");
                    }
                    this.f61468d.b(this.f61469e);
                }
                a();
            }
        }
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61466b.a("AdActivityObserver", "Cancelling...");
        }
        this.f61465a.b(this);
        this.f61468d = null;
        this.f61469e = null;
        this.f61471g = 0;
        this.f61472h = false;
    }
}
