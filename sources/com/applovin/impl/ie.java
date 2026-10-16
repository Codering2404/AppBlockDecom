package com.applovin.impl;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ie extends me implements i8 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f60439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f60440w;

    public ie(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i3, map, jSONObject, jSONObject2, null, jVar);
        this.f60439v = new AtomicBoolean();
        this.f60440w = new AtomicBoolean();
    }

    private long n0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f62260a.a(ue.h7)).longValue()) : jA;
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f59683o.a(maxNativeAdView);
    }

    @Override // com.applovin.impl.i8
    public long getTimeToLiveMillis() {
        return n0() - (SystemClock.elapsedRealtime() - K());
    }

    public MaxNativeAdView o0() {
        return this.f59683o.f();
    }

    public ViewGroup p0() {
        return this.f59683o.h();
    }

    public AtomicBoolean q0() {
        return this.f60439v;
    }

    public String r0() {
        return BundleUtils.getString(SDKConstants.PARAM_UPDATE_TEMPLATE, "", l());
    }

    public AtomicBoolean s0() {
        return this.f60440w;
    }

    @Override // com.applovin.impl.i8
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }

    public boolean t0() {
        return a("inacc", (Boolean) this.f62260a.a(ue.z7)).booleanValue();
    }

    public boolean u0() {
        return this.f59683o == null;
    }

    public void a(ViewGroup viewGroup) {
        this.f59683o.a(viewGroup);
    }

    @Override // com.applovin.impl.fe
    public fe a(com.applovin.impl.mediation.g gVar) {
        return new ie(this, gVar);
    }

    private ie(ie ieVar, com.applovin.impl.mediation.g gVar) {
        super(ieVar.J(), ieVar.i(), ieVar.a(), ieVar.g(), gVar, ieVar.f62260a);
        this.f60439v = new AtomicBoolean();
        this.f60440w = new AtomicBoolean();
    }
}
