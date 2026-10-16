package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f59086a;

    public d5(JSONObject jSONObject) {
        this.f59086a = jSONObject;
    }

    protected Integer a() {
        return JsonUtils.getInteger(this.f59086a, "dark_mode_toolbar_color", null);
    }

    protected String b() {
        return JsonUtils.getString(this.f59086a, "digital_asset_link_url", null);
    }

    protected Boolean c() {
        return JsonUtils.getBoolean(this.f59086a, "instant_apps_enabled", null);
    }

    protected String d() {
        return JsonUtils.getString(this.f59086a, "referrer", null);
    }

    protected Integer e() {
        return JsonUtils.getInteger(this.f59086a, "session_url_relation", null);
    }

    protected Integer f() {
        return JsonUtils.getInteger(this.f59086a, "share_state", null);
    }

    protected Boolean g() {
        return JsonUtils.getBoolean(this.f59086a, "should_show_title", null);
    }

    protected Integer h() {
        return JsonUtils.getInteger(this.f59086a, "toolbar_color", null);
    }

    protected Boolean i() {
        return JsonUtils.getBoolean(this.f59086a, "url_bar_hiding_enabled", null);
    }
}
