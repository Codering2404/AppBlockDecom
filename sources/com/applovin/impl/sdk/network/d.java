package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.vi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f63527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f63528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f63529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f63530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map f63531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f63532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f63533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private vi.a f63534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f63535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f63536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f63537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f63538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f63539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f63540n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f63541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f63542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f63543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f63544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f63545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map f63546f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Map f63547g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private vi.a f63548h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f63549i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f63550j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f63551k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f63552l;

        public b a(vi.a aVar) {
            this.f63548h = aVar;
            return this;
        }

        public b b(String str) {
            this.f63541a = str;
            return this;
        }

        public b c(String str) {
            this.f63542b = str;
            return this;
        }

        public b d(String str) {
            this.f63543c = str;
            return this;
        }

        public b a(String str) {
            this.f63544d = str;
            return this;
        }

        public b b(Map map) {
            this.f63545e = map;
            return this;
        }

        public b c(Map map) {
            this.f63547g = map;
            return this;
        }

        public b d(boolean z2) {
            this.f63551k = z2;
            return this;
        }

        public b a(Map map) {
            this.f63546f = map;
            return this;
        }

        public b b(boolean z2) {
            this.f63552l = z2;
            return this;
        }

        public b c(boolean z2) {
            this.f63550j = z2;
            return this;
        }

        public b a(boolean z2) {
            this.f63549i = z2;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public static b b() {
        return new b();
    }

    void a() {
        Map map = CollectionUtils.map(this.f63531e);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f63531e = map;
    }

    int c() {
        return this.f63540n;
    }

    String d() {
        return this.f63530d;
    }

    String e() {
        return this.f63539m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f63527a.equals(((d) obj).f63527a);
    }

    vi.a f() {
        return this.f63534h;
    }

    Map g() {
        return this.f63532f;
    }

    String h() {
        return this.f63528b;
    }

    public int hashCode() {
        return this.f63527a.hashCode();
    }

    Map i() {
        return this.f63531e;
    }

    Map j() {
        return this.f63533g;
    }

    String k() {
        return this.f63529c;
    }

    void l() {
        this.f63540n++;
    }

    public boolean m() {
        return this.f63537k;
    }

    boolean n() {
        return this.f63535i;
    }

    boolean o() {
        return this.f63536j;
    }

    boolean p() {
        return this.f63538l;
    }

    JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f63527a);
        jSONObject.put("communicatorRequestId", this.f63539m);
        jSONObject.put("httpMethod", this.f63528b);
        jSONObject.put("targetUrl", this.f63529c);
        jSONObject.put("backupUrl", this.f63530d);
        jSONObject.put("encodingType", this.f63534h);
        jSONObject.put("isEncodingEnabled", this.f63535i);
        jSONObject.put("gzipBodyEncoding", this.f63536j);
        jSONObject.put("isAllowedPreInitEvent", this.f63537k);
        jSONObject.put("attemptNumber", this.f63540n);
        if (this.f63531e != null) {
            jSONObject.put("parameters", new JSONObject(this.f63531e));
        }
        if (this.f63532f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f63532f));
        }
        if (this.f63533g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f63533g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f63527a + "', communicatorRequestId='" + this.f63539m + "', httpMethod='" + this.f63528b + "', targetUrl='" + this.f63529c + "', backupUrl='" + this.f63530d + "', attemptNumber=" + this.f63540n + ", isEncodingEnabled=" + this.f63535i + ", isGzipBodyEncoding=" + this.f63536j + ", isAllowedPreInitEvent=" + this.f63537k + ", shouldFireInWebView=" + this.f63538l + '}';
    }

    d(JSONObject jSONObject, j jVar) throws JSONException {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        String string3 = JsonUtils.getString(jSONObject, "httpMethod", "");
        String string4 = jSONObject.getString("targetUrl");
        String string5 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i3 = jSONObject.getInt("attemptNumber");
        Map mapSynchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : new HashMap();
        Map mapSynchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : new HashMap();
        Map mapSynchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : new HashMap();
        this.f63527a = string;
        this.f63528b = string3;
        this.f63539m = string2;
        this.f63529c = string4;
        this.f63530d = string5;
        this.f63531e = mapSynchronizedMap;
        this.f63532f = mapSynchronizedMap2;
        this.f63533g = mapSynchronizedMap3;
        this.f63534h = vi.a.a(jSONObject.optInt("encodingType", vi.a.DEFAULT.b()));
        this.f63535i = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f63536j = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f63537k = jSONObject.optBoolean("isAllowedPreInitEvent", false);
        this.f63538l = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f63540n = i3;
    }

    private d(b bVar) {
        this.f63527a = UUID.randomUUID().toString();
        this.f63528b = bVar.f63542b;
        this.f63529c = bVar.f63543c;
        this.f63530d = bVar.f63544d;
        this.f63531e = bVar.f63545e;
        this.f63532f = bVar.f63546f;
        this.f63533g = bVar.f63547g;
        this.f63534h = bVar.f63548h;
        this.f63535i = bVar.f63549i;
        this.f63536j = bVar.f63550j;
        this.f63537k = bVar.f63551k;
        this.f63538l = bVar.f63552l;
        this.f63539m = bVar.f63541a;
        this.f63540n = 0;
    }
}
