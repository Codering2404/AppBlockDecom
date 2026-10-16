package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.vi;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class hm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final h0 f60223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f60224i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            hm.this.a(i3, str2);
            this.f65231a.D().a("fetchAd", str, i3, CollectionUtils.hashMap("error_message", str2));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            if (i3 == 200) {
                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f59273m.a());
                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f59273m.b());
                HashMap map = new HashMap(5);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
                CollectionUtils.putStringIfValid("code", String.valueOf(i3), map);
                CollectionUtils.putStringIfValid("ad_zone_id", hm.this.f60223h.e(), map);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f59273m.a()), map);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f59273m.b()), map);
                this.f65231a.D().a(ka.f60954g, (Map) map);
                hm.this.b(jSONObject);
                return;
            }
            hm.this.a(i3, MaxAdapterError.NO_FILL.getErrorMessage());
        }
    }

    public hm(h0 h0Var, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f60223h = h0Var;
        this.f60224i = jVar.b();
    }

    private void a(ca caVar) {
        ba baVar = ba.f58609g;
        long jB = caVar.b(baVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.f65231a.a(sj.u3)).intValue())) {
            caVar.b(baVar, jCurrentTimeMillis);
            caVar.a(ba.f58610h);
            caVar.a(ba.f58611i);
        }
    }

    private Map g() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.f60223h.e());
        if (this.f60223h.f() != null) {
            map.put("AppLovin-Ad-Size", this.f60223h.f().getLabel());
        }
        if (this.f60223h.g() != null) {
            map.put("AppLovin-Ad-Type", this.f60223h.g().getLabel());
        }
        return map;
    }

    protected abstract yl a(JSONObject jSONObject);

    protected void b(JSONObject jSONObject) {
        e4.c(jSONObject, this.f65231a);
        e4.b(jSONObject, this.f65231a);
        e4.a(jSONObject, this.f65231a);
        h0.a(jSONObject);
        this.f65231a.i0().a(a(jSONObject));
    }

    protected abstract String e();

    protected abstract String f();

    protected Map h() {
        HashMap map = new HashMap(4);
        map.put(AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f60223h.e());
        if (this.f60223h.f() != null) {
            map.put("size", this.f60223h.f().getLabel());
        }
        if (this.f60223h.g() != null) {
            map.put("require", this.f60223h.g().getLabel());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        vi.a aVarA;
        Map map;
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Fetching next ad of zone: " + this.f60223h);
        }
        if (((Boolean) this.f65231a.a(sj.S3)).booleanValue() && yp.j() && com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "User is connected to a VPN");
        }
        yp.a(this.f65231a, this.f65232b);
        JSONObject jSONObject = null;
        this.f65231a.D().a(ka.f60953f, this.f60223h, (AppLovinError) null);
        ca caVarC = this.f65231a.C();
        caVarC.c(ba.f58606d);
        ba baVar = ba.f58609g;
        if (caVarC.b(baVar) == 0) {
            caVarC.b(baVar, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.f65231a.j().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f65231a.a(sj.j3)).booleanValue()) {
                vi.a aVarA2 = vi.a.a(((Integer) this.f65231a.a(sj.i5)).intValue());
                JSONObject jSONObject2 = new JSONObject(this.f65231a.x().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f65231a.a(sj.r5)).booleanValue() && !((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f65231a.a(sj.a5)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f65231a.a0());
                }
                JsonUtils.putAll(jSONObject2, andResetCustomPostBody);
                aVarA = aVarA2;
                jSONObject = jSONObject2;
            } else {
                aVarA = vi.a.a(((Integer) this.f65231a.a(sj.j5)).intValue());
                Map mapA = yp.a(this.f65231a.x().a(h(), false, false));
                if (andResetCustomPostBody != null) {
                    jSONObject = andResetCustomPostBody;
                } else {
                    str = "GET";
                }
                map = mapA;
            }
            if (yp.f(a())) {
                map.putAll(this.f65231a.j().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.f60224i)) {
                map.put("sts", this.f60224i);
            }
            a(caVarC);
            a.C0125a c0125aF = com.applovin.impl.sdk.network.a.a(this.f65231a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f65231a.a(sj.Y2)).intValue()).c(((Boolean) this.f65231a.a(sj.Z2)).booleanValue()).d(((Boolean) this.f65231a.a(sj.a3)).booleanValue()).c(((Integer) this.f65231a.a(sj.X2)).intValue()).a(aVarA).f(true);
            if (jSONObject != null) {
                c0125aF.a(jSONObject);
                c0125aF.b(((Boolean) this.f65231a.a(sj.B5)).booleanValue());
            }
            a aVar = new a(c0125aF.a(), this.f65231a);
            aVar.c(sj.f63786r0);
            aVar.b(sj.f63789s0);
            this.f65231a.i0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unable to fetch ad for zone id: " + this.f60223h, th);
            }
            a(0, th.getMessage());
        }
    }

    protected void a(int i3, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Unable to fetch " + this.f60223h + " ad: server returned " + i3);
        }
        if (i3 == -800) {
            this.f65231a.C().c(ba.f58615m);
        }
        this.f65231a.D().a(ka.f60955h, this.f60223h, new AppLovinError(i3, str));
    }
}
