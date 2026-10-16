package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ge extends me {
    public ge(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i3, map, jSONObject, jSONObject2, null, jVar);
    }

    @Override // com.applovin.impl.fe
    public fe a(com.applovin.impl.mediation.g gVar) {
        return new ge(this, gVar);
    }

    public long n0() {
        long jA = a("ad_refresh_ms", -1L);
        return jA >= 0 ? jA : b("ad_refresh_ms", ((Long) this.f62260a.a(ue.O6)).longValue());
    }

    public long o0() {
        return yp.d(a(AppIntroBaseFragmentKt.ARG_BG_COLOR, (String) null));
    }

    public int p0() {
        int iA = a("ad_view_height", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public long q0() {
        return a("viewability_imp_delay_ms", ((Long) this.f62260a.a(sj.f63799v1)).longValue());
    }

    public int r0() {
        int iA = a("ad_view_width", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public boolean s0() {
        return n0() >= 0;
    }

    public boolean t0() {
        return a("proe", (Boolean) this.f62260a.a(ue.p7)).booleanValue();
    }

    private ge(ge geVar, com.applovin.impl.mediation.g gVar) {
        super(geVar.J(), geVar.i(), geVar.a(), geVar.g(), gVar, geVar.f62260a);
    }
}
