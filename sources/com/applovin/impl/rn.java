package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class rn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f62886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f62887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f62888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f62889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f62890e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        TCF_VENDOR,
        ATP_NETWORK,
        OTHER;

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(int i3) {
            return i3 != 0 ? i3 != 1 ? OTHER : ATP_NETWORK : TCF_VENDOR;
        }
    }

    public rn(JSONObject jSONObject, String str) {
        this.f62889d = str;
        this.f62886a = a.b(JsonUtils.getInt(jSONObject, "type", a.OTHER.ordinal()));
        this.f62887b = JsonUtils.getInteger(jSONObject, "id", null);
        this.f62888c = JsonUtils.getString(jSONObject, "name", null);
    }

    public Boolean a() {
        return this.f62890e;
    }

    public String b() {
        return this.f62889d;
    }

    public String c() {
        return this.f62888c;
    }

    public Integer d() {
        return this.f62887b;
    }

    public String e() {
        Boolean bool = this.f62890e;
        return "\n" + this.f62889d + " - " + (bool != null ? String.valueOf(bool) : a4.b().a(com.applovin.impl.sdk.j.m()));
    }

    public a f() {
        return this.f62886a;
    }

    public void a(Boolean bool) {
        this.f62890e = bool;
    }
}
