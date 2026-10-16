package com.applovin.impl;

import android.graphics.Color;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f58637a;

    public bd(JSONObject jSONObject) {
        this.f58637a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public int a() {
        String string = JsonUtils.getString(this.f58637a, "background_color", null);
        if (string != null) {
            return Color.parseColor(string);
        }
        return -16777216;
    }

    public long b() {
        return JsonUtils.getLong(this.f58637a, "close_button_delay_ms", 3000L);
    }

    public int c() {
        return JsonUtils.getInt(this.f58637a, "close_button_extended_touch_area_size", 10);
    }

    public int d() {
        return JsonUtils.getInt(this.f58637a, "close_button_h_margin", 5);
    }

    public int e() {
        return JsonUtils.getInt(this.f58637a, "close_button_size", 30);
    }

    public int f() {
        return JsonUtils.getInt(this.f58637a, "close_button_top_margin", 20);
    }
}
