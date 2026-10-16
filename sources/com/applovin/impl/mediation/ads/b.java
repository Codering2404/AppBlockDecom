package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.ar;
import com.applovin.impl.br;
import com.applovin.impl.ie;
import com.applovin.impl.mediation.ads.a;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b implements br.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ie f61554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final br f61555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ar f61556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a.InterfaceC0110a f61557e;

    public b(ie ieVar, ViewGroup viewGroup, a.InterfaceC0110a interfaceC0110a, com.applovin.impl.sdk.j jVar) {
        this.f61553a = jVar;
        this.f61554b = ieVar;
        this.f61557e = interfaceC0110a;
        this.f61556d = new ar(viewGroup, jVar);
        br brVar = new br(viewGroup, jVar, this);
        this.f61555c = brVar;
        brVar.a(ieVar);
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void a() {
        this.f61555c.b();
    }

    public ie b() {
        return this.f61554b;
    }

    public void c() {
        this.f61553a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f61553a.I().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.f61554b.q0().compareAndSet(false, true)) {
            this.f61553a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61553a.I().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.f61554b.getNativeAd().isExpired()) {
                com.applovin.impl.sdk.n.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f61553a.f().a(this.f61554b);
            }
            this.f61553a.P().processRawAdImpression(this.f61554b, this.f61557e);
        }
    }

    @Override // com.applovin.impl.br.a
    public void onLogVisibilityImpression() {
        a(this.f61556d.a(this.f61554b));
    }

    private void a(long j3) {
        if (this.f61554b.s0().compareAndSet(false, true)) {
            this.f61553a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61553a.I().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f61553a.P().processViewabilityAdImpressionPostback(this.f61554b, j3, this.f61557e);
        }
    }
}
