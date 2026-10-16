package com.applovin.impl;

import com.applovin.impl.tm;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f62231a;

    public static void a() {
        f62231a = true;
    }

    public static void b(final com.applovin.impl.sdk.j jVar) {
        Long l3 = (Long) jVar.a(ue.D7);
        if (l3.longValue() <= 0) {
            return;
        }
        jVar.i0().a(new jn(jVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.h00
            @Override // java.lang.Runnable
            public final void run() {
                ob.a(jVar);
            }
        }), tm.b.OTHER, TimeUnit.SECONDS.toMillis(l3.longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.j jVar) {
        if (f62231a) {
            return;
        }
        jVar.D().a(ka.V, "no_ads_loaded");
    }
}
