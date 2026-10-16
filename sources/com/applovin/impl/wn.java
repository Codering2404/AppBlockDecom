package com.applovin.impl;

import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f64721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f64722c;

    public wn(com.applovin.impl.sdk.j jVar) {
        this.f64720a = jVar;
        uj ujVar = uj.J;
        this.f64721b = ((Boolean) jVar.a(ujVar, Boolean.FALSE)).booleanValue() || t0.a(com.applovin.impl.sdk.j.m()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator() || jVar.x().M();
        jVar.c(ujVar);
    }

    private void e() {
        com.applovin.impl.sdk.i iVarQ = this.f64720a.q();
        if (this.f64721b) {
            iVarQ.b(this.f64722c);
        } else {
            iVarQ.a(this.f64722c);
        }
    }

    public void a() {
        this.f64720a.b(uj.J, Boolean.TRUE);
    }

    public List b() {
        return this.f64722c;
    }

    public boolean c() {
        return this.f64721b;
    }

    public boolean d() {
        List list = this.f64722c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public void a(List list) {
        if (list == null && this.f64722c == null) {
            return;
        }
        if (list == null || !list.equals(this.f64722c)) {
            this.f64722c = list;
            e();
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.f64721b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.k kVarX = this.f64720a.x();
        boolean zM = kVarX.M();
        String strA = kVarX.f().a();
        k.b bVarC = kVarX.C();
        this.f64721b = zM || JsonUtils.containsCaseInsensitiveString(strA, jSONArray) || JsonUtils.containsCaseInsensitiveString(bVarC != null ? bVarC.f63403a : null, jSONArray);
    }
}
