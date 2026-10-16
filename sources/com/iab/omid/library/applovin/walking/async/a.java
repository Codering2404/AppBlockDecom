package com.iab.omid.library.applovin.walking.async;

import com.iab.omid.library.applovin.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f92218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f92219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f92220e;

    public a(b.InterfaceC0172b interfaceC0172b, HashSet<String> hashSet, JSONObject jSONObject, long j3) {
        super(interfaceC0172b);
        this.f92218c = new HashSet<>(hashSet);
        this.f92219d = jSONObject;
        this.f92220e = j3;
    }
}
