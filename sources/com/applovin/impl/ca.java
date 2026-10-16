package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f58859b = new HashMap();

    public ca(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f58858a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            this.f58858a.b(uj.f64250z, c().toString());
        } catch (Throwable th) {
            this.f58858a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58858a.I().a("GlobalStatsManager", "Unable to save stats", th);
            }
        }
    }

    private void f() {
        this.f58858a.i0().a(new Runnable() { // from class: com.applovin.impl.ju
            @Override // java.lang.Runnable
            public final void run() {
                this.f60818a.d();
            }
        }, tm.b.OTHER);
    }

    public void b() {
        synchronized (this.f58859b) {
            try {
                Iterator it = ba.a().iterator();
                while (it.hasNext()) {
                    this.f58859b.remove(((ba) it.next()).b());
                }
                f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public JSONObject c() {
        JSONObject jSONObject;
        synchronized (this.f58859b) {
            try {
                jSONObject = new JSONObject();
                for (Map.Entry entry : this.f58859b.entrySet()) {
                    JsonUtils.putLong(jSONObject, (String) entry.getKey(), ((Long) entry.getValue()).longValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    public void e() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f58858a.a(uj.f64250z, JsonUtils.EMPTY_JSON));
            synchronized (this.f58859b) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        this.f58859b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f58858a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58858a.I().a("GlobalStatsManager", "Unable to load stats", th);
            }
        }
    }

    public void a() {
        synchronized (this.f58859b) {
            this.f58859b.clear();
        }
        f();
    }

    public void a(ba baVar) {
        synchronized (this.f58859b) {
            this.f58859b.remove(baVar.b());
        }
        f();
    }

    public long b(ba baVar) {
        long jLongValue;
        synchronized (this.f58859b) {
            try {
                Long l3 = (Long) this.f58859b.get(baVar.b());
                if (l3 == null) {
                    l3 = 0L;
                }
                jLongValue = l3.longValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return jLongValue;
    }

    public long c(ba baVar) {
        return a(baVar, 1L);
    }

    long a(ba baVar, long j3) {
        long jLongValue;
        synchronized (this.f58859b) {
            try {
                Long l3 = (Long) this.f58859b.get(baVar.b());
                if (l3 == null) {
                    l3 = 0L;
                }
                jLongValue = l3.longValue() + j3;
                this.f58859b.put(baVar.b(), Long.valueOf(jLongValue));
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return jLongValue;
    }

    public void b(ba baVar, long j3) {
        synchronized (this.f58859b) {
            this.f58859b.put(baVar.b(), Long.valueOf(j3));
        }
        f();
    }
}
