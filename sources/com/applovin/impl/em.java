package com.applovin.impl;

import com.applovin.impl.l0;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class em extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f59524h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(l0.a aVar);
    }

    public em(com.applovin.impl.sdk.j jVar, a aVar) {
        super("TaskCollectAdvertisingId", jVar, true);
        this.f59524h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f59524h.a(this.f65231a.x().f());
    }
}
