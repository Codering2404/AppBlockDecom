package com.applovin.impl;

import com.applovin.impl.d4;
import com.applovin.impl.l0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.vi;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class mm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d4.e f61913h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z2) {
            super(aVar, jVar, z2);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            mm.this.f61913h.a(str, i3, str2, jSONObject);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            mm.this.f61913h.a(str, jSONObject, i3);
        }
    }

    public mm(d4.e eVar, com.applovin.impl.sdk.j jVar) {
        super("TaskFetchMediationDebuggerInfo", jVar, true);
        this.f61913h = eVar;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", ze.a(this.f65231a));
        l0.a aVarF = this.f65231a.x().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarF.b().b());
        JsonUtils.putStringIfValid(jSONObject, "idfa", aVarF.a());
        return jSONObject;
    }

    protected Map f() {
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f65231a.a(sj.a5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f65231a.a0());
        }
        Map mapB = this.f65231a.x().B();
        map.put("package_name", String.valueOf(mapB.get("package_name")));
        map.put("app_version", String.valueOf(mapB.get("app_version")));
        Map mapH = this.f65231a.x().H();
        map.put("platform", String.valueOf(mapH.get("platform")));
        map.put("os", String.valueOf(mapH.get("os")));
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map mapF = f();
        JSONObject jSONObjectE = e();
        if (((Boolean) this.f65231a.a(sj.q5)).booleanValue() || ((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
            JsonUtils.putAll(jSONObjectE, (Map<String, ?>) mapF);
            mapF = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f65231a).c("POST").b(pe.i(this.f65231a)).a(pe.h(this.f65231a)).b(mapF).a(jSONObjectE).a((Object) new JSONObject()).c(((Long) this.f65231a.a(ue.J6)).intValue()).a(vi.a.a(((Integer) this.f65231a.a(sj.h5)).intValue())).a(), this.f65231a, d());
        aVar.c(ue.F6);
        aVar.b(ue.G6);
        this.f65231a.i0().a(aVar);
    }
}
