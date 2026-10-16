package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.vi;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class zl extends yl {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            e4.a(i3, this.f65231a);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            zl.this.a(jSONObject);
        }
    }

    zl(com.applovin.impl.sdk.j jVar) {
        super("TaskApiSubmitData", jVar);
    }

    private void b(JSONObject jSONObject) {
        if (((Boolean) this.f65231a.a(sj.B4)).booleanValue()) {
            JsonUtils.putJSONObjectIfValid(jSONObject, "stats", this.f65231a.C().c());
        }
    }

    private void c(JSONObject jSONObject) {
        com.applovin.impl.sdk.k kVarX = this.f65231a.x();
        Map mapM = kVarX.m();
        yp.a("platform", "type", mapM);
        yp.a("api_level", "sdk_version", mapM);
        JsonUtils.putObject(jSONObject, DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(mapM));
        Map mapB = kVarX.B();
        yp.a("sdk_version", "applovin_sdk_version", mapB);
        yp.a("ia", "installed_at", mapB);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapB));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.d(this.f65232b, "Submitting user data...");
        }
        Map mapC = e4.c(this.f65231a);
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        b(jSONObject);
        if (((Boolean) this.f65231a.a(sj.t5)).booleanValue() || ((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a(mapC, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f65231a.g0().a(sj.f63741g, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f65231a.g0().a(sj.f63757k, JsonUtils.getString(jSONObject2, "device_token", ""));
        e4.a(jSONObject2, this.f65231a);
        this.f65231a.C().b();
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f65231a).b(e4.b("2.0/device", this.f65231a)).a(e4.a("2.0/device", this.f65231a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f65231a.a(sj.A5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f65231a.a(sj.b3)).intValue()).a(vi.a.a(((Integer) this.f65231a.a(sj.l5)).intValue())).a(), this.f65231a);
        aVar.c(sj.f63792t0);
        aVar.b(sj.f63795u0);
        this.f65231a.i0().a(aVar);
    }
}
