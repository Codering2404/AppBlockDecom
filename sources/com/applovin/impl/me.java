package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class me extends fe {
    protected me(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(i3, map, jSONObject, jSONObject2, gVar, jVar);
    }

    public float f0() {
        return b("viewability_min_alpha", ((Float) this.f62260a.a(sj.E1)).floatValue() / 100.0f);
    }

    public int g0() {
        return a("viewability_min_pixels", -1);
    }

    public int h0() {
        MaxAdFormat format = getFormat();
        sj sjVar = format == MaxAdFormat.BANNER ? sj.f63805x1 : format == MaxAdFormat.MREC ? sj.f63811z1 : format == MaxAdFormat.LEADER ? sj.B1 : format == MaxAdFormat.NATIVE ? sj.D1 : null;
        if (sjVar != null) {
            return a("viewability_min_height", ((Integer) this.f62260a.a(sjVar)).intValue());
        }
        return 0;
    }

    public float i0() {
        return b("viewability_min_percentage_dp", -1.0f);
    }

    public float j0() {
        return b("viewability_min_percentage_pixels", -1.0f);
    }

    public long k0() {
        return a("viewability_timer_min_visible_ms", ((Long) this.f62260a.a(sj.F1)).longValue());
    }

    public int l0() {
        MaxAdFormat format = getFormat();
        sj sjVar = format == MaxAdFormat.BANNER ? sj.f63802w1 : format == MaxAdFormat.MREC ? sj.f63808y1 : format == MaxAdFormat.LEADER ? sj.A1 : format == MaxAdFormat.NATIVE ? sj.C1 : null;
        if (sjVar != null) {
            return a("viewability_min_width", ((Integer) this.f62260a.a(sjVar)).intValue());
        }
        return 0;
    }

    public boolean m0() {
        return g0() >= 0 || i0() >= 0.0f || j0() >= 0.0f;
    }
}
