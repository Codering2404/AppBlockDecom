package com.iab.omid.library.applovin.walking;

import com.iab.omid.library.applovin.walking.async.b;
import com.iab.omid.library.applovin.walking.async.d;
import com.iab.omid.library.applovin.walking.async.e;
import com.iab.omid.library.applovin.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class b implements b.InterfaceC0172b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f92227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.applovin.walking.async.c f92228b;

    public b(com.iab.omid.library.applovin.walking.async.c cVar) {
        this.f92228b = cVar;
    }

    @Override // com.iab.omid.library.applovin.walking.async.b.InterfaceC0172b
    public JSONObject a() {
        return this.f92227a;
    }

    public void b() {
        this.f92228b.b(new d(this));
    }

    @Override // com.iab.omid.library.applovin.walking.async.b.InterfaceC0172b
    public void a(JSONObject jSONObject) {
        this.f92227a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j3) {
        this.f92228b.b(new f(this, hashSet, jSONObject, j3));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j3) {
        this.f92228b.b(new e(this, hashSet, jSONObject, j3));
    }
}
