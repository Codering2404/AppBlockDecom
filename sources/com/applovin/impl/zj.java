package com.applovin.impl;

import com.applovin.impl.xj;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zj extends oe {
    public zj(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
    }

    public boolean A() {
        return a("use_cached_adapter", Boolean.TRUE).booleanValue();
    }

    public xj.b t() {
        return xj.b.values()[a("signal_cache_level", ((Integer) this.f62260a.a(ue.f7)).intValue())];
    }

    @Override // com.applovin.impl.oe
    public String toString() {
        return "SignalProviderSpec{adObject=" + a() + '}';
    }

    public long u() {
        return a("signal_expiration_ms", ((Long) this.f62260a.a(ue.e7)).longValue());
    }

    public boolean v() {
        return a("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean w() {
        return a("prefer_collect_signal_when_initialized", Boolean.TRUE).booleanValue();
    }

    public boolean x() {
        return a("fail_collection_for_empty_signal", (Boolean) this.f62260a.a(ue.L7)).booleanValue();
    }

    public boolean y() {
        return a("ignore_init_failure", Boolean.FALSE).booleanValue();
    }

    public boolean z() {
        return a("initialize_before_collecting_signal", Boolean.TRUE).booleanValue();
    }
}
