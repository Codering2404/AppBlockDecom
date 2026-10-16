package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class he extends fe implements i8 {
    private boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Bundle f60186v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f60187w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f60188x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f60189y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f60190z;

    public he(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i3, map, jSONObject, jSONObject2, null, jVar);
        this.f60186v = new Bundle();
        this.f60189y = new AtomicBoolean();
        this.f60187w = new AtomicReference();
        this.f60188x = new AtomicBoolean();
    }

    private long g0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f62260a.a(ue.g7)).longValue()) : jA;
    }

    public void a(boolean z2) {
        this.f60190z = z2;
    }

    public void f0() {
        this.f60188x.set(true);
    }

    @Override // com.applovin.impl.i8
    public long getTimeToLiveMillis() {
        return g0() - (SystemClock.elapsedRealtime() - K());
    }

    public long h0() {
        return a("ahdm", ((Long) this.f62260a.a(ue.a7)).longValue());
    }

    public long i0() {
        long jA = a("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f62260a.a(ue.o7)).longValue());
    }

    public long j0() {
        long jA = a("ad_hidden_timeout_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_timeout_ms", ((Long) this.f62260a.a(ue.l7)).longValue());
    }

    public eh k0() {
        return (eh) this.f60187w.getAndSet(null);
    }

    public long l0() {
        if (K() > 0) {
            return SystemClock.elapsedRealtime() - K();
        }
        return -1L;
    }

    public Bundle m0() {
        return this.f60186v;
    }

    public long n0() {
        long jA = a("fullscreen_display_delay_ms", -1L);
        return jA >= 0 ? jA : ((Long) this.f62260a.a(ue.Y6)).longValue();
    }

    public String o0() {
        return b("mcode", "");
    }

    public AtomicBoolean p0() {
        return this.f60189y;
    }

    public boolean q0() {
        return this.f60190z;
    }

    public boolean r0() {
        return this.f60188x.get();
    }

    public boolean s0() {
        if (a("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f62260a.a(ue.m7)).booleanValue();
    }

    @Override // com.applovin.impl.i8
    public void setExpired() {
        this.A = true;
    }

    public boolean t0() {
        if (a("schedule_ad_hidden_on_single_task_app_relaunch", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.f62260a.a(ue.n7)).booleanValue();
    }

    public boolean u0() {
        return a("susaode", (Boolean) this.f62260a.a(ue.Z6)).booleanValue();
    }

    public void a(eh ehVar) {
        this.f60187w.set(ehVar);
    }

    @Override // com.applovin.impl.fe
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (bundle == null || (bundle2 = bundle.getBundle("applovin_ad_view_info")) == null) {
            return;
        }
        this.f60186v.putBundle("applovin_ad_view_info", bundle2);
    }

    private he(he heVar, com.applovin.impl.mediation.g gVar) {
        super(heVar.J(), heVar.i(), heVar.a(), heVar.g(), gVar, heVar.f62260a);
        this.f60186v = new Bundle();
        this.f60189y = new AtomicBoolean();
        this.f60187w = heVar.f60187w;
        this.f60188x = heVar.f60188x;
    }

    @Override // com.applovin.impl.fe
    public fe a(com.applovin.impl.mediation.g gVar) {
        return new he(this, gVar);
    }
}
