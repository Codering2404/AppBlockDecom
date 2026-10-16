package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f62192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f62193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f62194c;

    o6(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f62192a = JsonUtils.getString(jSONObject, "name", "");
        this.f62193b = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.f62194c = yp.a(list);
        } else {
            this.f62194c = yp.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
    }

    public String a() {
        return this.f62193b;
    }

    public String b() {
        return this.f62192a;
    }

    public boolean c() {
        return this.f62194c;
    }

    public static boolean a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || yp.a(str2, str) != 1) {
            return str3 == null || yp.a(str3, str) != -1;
        }
        return false;
    }
}
