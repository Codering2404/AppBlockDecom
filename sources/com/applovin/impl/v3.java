package com.applovin.impl;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class v3 extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f64373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f64374i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z2) {
            super(aVar, jVar, z2);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            this.f65231a.q().a(v3.this.f64373h, v3.this.f64374i.f(), i3, jSONObject, str2, false);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            this.f65231a.q().a(v3.this.f64373h, v3.this.f64374i.f(), i3, jSONObject, null, true);
        }
    }

    public v3(String str, com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        super("CommunicatorRequestTask", jVar, str);
        this.f64373h = str;
        this.f64374i = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f65231a.i0().a(new a(this.f64374i, this.f65231a, d()));
    }
}
