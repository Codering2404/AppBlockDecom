package com.google.firebase.auth;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GetTokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f87775b;

    public GetTokenResult(String str, Map map) {
        this.f87774a = str;
        this.f87775b = map;
    }

    public Map a() {
        return this.f87775b;
    }

    public String b() {
        Map map = (Map) this.f87775b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String c() {
        return this.f87774a;
    }
}
