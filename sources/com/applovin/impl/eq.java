package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class eq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List f59530f = Arrays.asList("video/mp4", "video/webm", "video/3gpp", "video/x-matroska");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59531a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f59533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f59534d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List f59532b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f59535e = System.currentTimeMillis();

    public eq(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        this.f59531a = jVar;
        this.f59533c = jSONObject;
        this.f59534d = jSONObject2;
    }

    public List a() {
        return this.f59532b;
    }

    public JSONObject b() {
        return this.f59533c;
    }

    public long c() {
        return this.f59535e;
    }

    public int d() {
        return this.f59532b.size();
    }

    public JSONObject e() {
        return this.f59534d;
    }

    public List f() {
        List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(this.f59533c, "vast_preferred_video_types", null));
        return !listExplode.isEmpty() ? listExplode : f59530f;
    }

    public int g() {
        return yp.a(JsonUtils.getInt(this.f59533c, "video_completion_percent", -1));
    }
}
