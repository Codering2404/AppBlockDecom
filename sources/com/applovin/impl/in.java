package com.applovin.impl;

import com.applovin.impl.d4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.vi;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class in extends yl {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ d4.e f60518n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, d4.e eVar) {
            super(aVar, jVar);
            this.f60518n = eVar;
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            this.f60518n.a(str, i3, str2, jSONObject);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            this.f60518n.a(str, jSONObject, i3);
        }
    }

    protected in(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    protected void a(int i3) {
        e4.a(i3, this.f65231a);
    }

    protected abstract void a(JSONObject jSONObject);

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String strC = this.f65231a.o0().c();
        if (((Boolean) this.f65231a.a(sj.C3)).booleanValue() && StringUtils.isValidString(strC)) {
            JsonUtils.putString(jSONObject, "cuid", strC);
        }
        if (((Boolean) this.f65231a.a(sj.E3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f65231a.r());
        }
        if (((Boolean) this.f65231a.a(sj.G3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f65231a.Z());
        }
        a(jSONObject);
        return jSONObject;
    }

    protected abstract String f();

    protected abstract int g();

    void a(JSONObject jSONObject, d4.e eVar) {
        Map mapC = e4.c(this.f65231a);
        if (((Boolean) this.f65231a.a(sj.u5)).booleanValue() || ((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f65231a).b(e4.b(f(), this.f65231a)).a(e4.a(f(), this.f65231a)).b(mapC).a(jSONObject).c("POST").b(((Boolean) this.f65231a.a(sj.D5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(vi.a.a(((Integer) this.f65231a.a(sj.m5)).intValue())).a(), this.f65231a, eVar);
        aVar.c(sj.f63792t0);
        aVar.b(sj.f63795u0);
        this.f65231a.i0().a(aVar);
    }
}
