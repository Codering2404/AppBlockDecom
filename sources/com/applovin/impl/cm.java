package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.bm;
import com.applovin.impl.f1;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class cm extends bm {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f58976r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f58977s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f58978t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements f1.a {
        a() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                if (cm.this.f58976r.M0()) {
                    cm.this.f58976r.b(cm.this.f58976r.l1().replaceFirst(cm.this.f58976r.o1(), uri.toString()));
                    com.applovin.impl.sdk.n nVar = cm.this.f65233c;
                    if (com.applovin.impl.sdk.n.a()) {
                        cm cmVar = cm.this;
                        cmVar.f65233c.a(cmVar.f65232b, "Replaced video URL with cached video URI in HTML for web video ad");
                    }
                }
                cm.this.f58976r.s1();
                cm.this.f58976r.d(uri);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements bm.e {
        b() {
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            cm.this.f58976r.b(cm.this.d(str));
            cm.this.f58976r.b(true);
            com.applovin.impl.sdk.n nVar = cm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                cm cmVar = cm.this;
                cmVar.f65233c.a(cmVar.f65232b, "Finish caching non-video resources for ad #" + cm.this.f58976r.getAdIdNumber());
            }
            cm cmVar2 = cm.this;
            cmVar2.f65233c.f(cmVar2.f65232b, "Ad updated with cachedHTML = " + cm.this.f58976r.l1());
        }
    }

    public cm(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, jVar, appLovinAdLoadListener);
        this.f58976r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (yp.h(com.applovin.impl.sdk.j.m())) {
            str = yp.c(str);
        }
        return this.f58976r.isOpenMeasurementEnabled() ? this.f65231a.V().a(str) : str;
    }

    private void m() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching HTML resources...");
        }
        this.f58976r.b(d(a(a(this.f58976r.l1(), this.f58976r.m1(), this.f58976r.t1(), this.f58976r.Y(), this.f58976r.u1()), this.f58976r.Y(), this.f58976r)));
        this.f58976r.b(true);
        a(this.f58976r);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Finish caching non-video resources for ad #" + this.f58976r.getAdIdNumber());
        }
        this.f65233c.f(this.f65232b, "Ad updated with cachedHTML = " + this.f58976r.l1());
    }

    private void n() {
        Uri uriC;
        if (l() || (uriC = c(this.f58976r.q1())) == null) {
            return;
        }
        if (this.f58976r.M0()) {
            this.f58976r.b(this.f58976r.l1().replaceFirst(this.f58976r.o1(), uriC.toString()));
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Replaced video URL with cached video URI in HTML for web video ad");
            }
        }
        this.f58976r.s1();
        this.f58976r.d(uriC);
    }

    private e1 o() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching HTML resources...");
        }
        return a(this.f58976r.l1(), this.f58976r.Y(), new b());
    }

    private f1 p() {
        return b(this.f58976r.q1(), new a());
    }

    public void b(boolean z2) {
        this.f58978t = z2;
    }

    public void c(boolean z2) {
        this.f58977s = z2;
    }

    @Override // com.applovin.impl.bm, java.lang.Runnable
    public void run() {
        super.run();
        boolean zK0 = this.f58976r.K0();
        boolean z2 = this.f58978t;
        if (zK0 || z2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Begin caching for streaming ad #" + this.f58976r.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f65231a.a(sj.I0)).booleanValue()) {
                if (!z3.f()) {
                    a(e());
                }
                ArrayList arrayList = new ArrayList();
                if (!zK0) {
                    f();
                    e1 e1VarO = o();
                    if (e1VarO != null) {
                        arrayList.add(e1VarO);
                    }
                } else if (this.f58977s) {
                    f();
                    e1 e1VarO2 = o();
                    if (e1VarO2 != null) {
                        arrayList.add(e1VarO2);
                    }
                    f1 f1VarP = p();
                    if (f1VarP != null) {
                        arrayList.add(f1VarP);
                    }
                } else {
                    e1 e1VarO3 = o();
                    if (e1VarO3 != null) {
                        a(Arrays.asList(e1VarO3));
                    }
                    f();
                    f1 f1VarP2 = p();
                    if (f1VarP2 != null) {
                        arrayList.add(f1VarP2);
                    }
                }
                a(arrayList);
                f();
            } else {
                j();
                if (zK0) {
                    if (this.f58977s) {
                        f();
                    }
                    m();
                    if (!this.f58977s) {
                        f();
                    }
                    n();
                } else {
                    f();
                    m();
                }
            }
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Begin processing for non-streaming ad #" + this.f58976r.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f65231a.a(sj.I0)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                if (!z3.f()) {
                    arrayList2.addAll(e());
                }
                e1 e1VarO4 = o();
                if (e1VarO4 != null) {
                    arrayList2.add(e1VarO4);
                }
                f1 f1VarP3 = p();
                if (f1VarP3 != null) {
                    arrayList2.add(f1VarP3);
                }
                a(arrayList2);
                f();
            } else {
                j();
                m();
                n();
                f();
            }
        }
        k();
    }
}
