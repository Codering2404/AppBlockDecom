package com.applovin.impl;

import com.applovin.impl.ve;
import com.applovin.impl.we;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class xe {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap f64967b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap f64968c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap f64969d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64970a;

    public xe(com.applovin.impl.sdk.j jVar) {
        this.f64970a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l3, Long l4) {
        return l3;
    }

    private boolean a(ve veVar, we weVar, ve.a aVar) {
        if (veVar == null) {
            this.f64970a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f64970a.I().b("MediationStatsManager", "Failed to update stat, no stat provided");
            }
            return false;
        }
        if (weVar == null) {
            this.f64970a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f64970a.I().b("MediationStatsManager", "Failed to update stat, no dimension key provided");
            }
            return false;
        }
        if (aVar != null) {
            return true;
        }
        this.f64970a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64970a.I().b("MediationStatsManager", "Failed to update stat, no stat updater provided");
        }
        return false;
    }

    private void b(ve veVar, we weVar, ve.a aVar) {
        HashMap map;
        if (a(veVar, weVar, aVar)) {
            String strB = weVar.b();
            HashMap mapA = a(weVar.a());
            synchronized (mapA) {
                try {
                    if (mapA.containsKey(strB)) {
                        map = (HashMap) mapA.get(strB);
                    } else {
                        HashMap map2 = new HashMap();
                        mapA.put(strB, map2);
                        map = map2;
                    }
                    map.put(veVar, aVar.a(map.get(veVar)));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public Map a(ve veVar, we.a aVar) {
        HashMap mapA = a(aVar);
        HashMap map = new HashMap();
        synchronized (mapA) {
            try {
                for (String str : mapA.keySet()) {
                    map.put(str, ((HashMap) mapA.get(str)).get(veVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    private HashMap a(we.a aVar) {
        if (aVar == we.a.AD_UNIT_ID) {
            return f64967b;
        }
        if (aVar == we.a.AD_FORMAT) {
            return f64968c;
        }
        return f64969d;
    }

    public void a(ve veVar, we weVar) {
        b(veVar, weVar, new ve.a() { // from class: com.applovin.impl.r80
            @Override // com.applovin.impl.ve.a
            public final Object a(Object obj) {
                return xe.a((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l3) {
        return Long.valueOf(l3 != null ? 1 + l3.longValue() : 1L);
    }

    public void a(ve veVar, we weVar, final Long l3) {
        b(veVar, weVar, new ve.a() { // from class: com.applovin.impl.q80
            @Override // com.applovin.impl.ve.a
            public final Object a(Object obj) {
                return xe.a(l3, (Long) obj);
            }
        });
    }
}
