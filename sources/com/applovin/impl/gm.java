package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class gm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.e f60012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinPostbackListener f60013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final tm.b f60014j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AppLovinPostbackListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i3) {
            gm.this.e();
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            if (gm.this.f60013i != null) {
                gm.this.f60013i.onPostbackSuccess(gm.this.f60012h.f());
            }
        }
    }

    public gm(com.applovin.impl.sdk.network.e eVar, tm.b bVar, com.applovin.impl.sdk.j jVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", jVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f60012h = eVar;
        this.f60013i = appLovinPostbackListener;
        this.f60014j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b bVar = new b(this.f60012h, b());
        bVar.a(this.f60014j);
        b().i0().a(bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (StringUtils.isValidString(this.f60012h.f())) {
            if (this.f60012h.u()) {
                b().p0().a(this.f60012h, new a());
                return;
            } else {
                e();
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.d(this.f65232b, "Requested URL is not valid; nothing to do...");
        }
        AppLovinPostbackListener appLovinPostbackListener = this.f60013i;
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f60012h.f(), AppLovinErrorCodes.INVALID_URL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b extends dn {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final String f60016n;

        b(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
            this.f60016n = gm.this.f60012h.f();
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, Object obj, int i3) {
            if (obj instanceof String) {
                for (String str2 : this.f65231a.c(sj.f63774o0)) {
                    if (str2.startsWith(str2)) {
                        String str3 = (String) obj;
                        if (TextUtils.isEmpty(str3)) {
                            continue;
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                e4.c(jSONObject, this.f65231a);
                                e4.b(jSONObject, this.f65231a);
                                e4.a(jSONObject, this.f65231a);
                                break;
                            } catch (JSONException unused) {
                                continue;
                            }
                        }
                    }
                }
            }
            if (gm.this.f60013i != null) {
                gm.this.f60013i.onPostbackSuccess(this.f60016n);
            }
            if (gm.this.f60012h.t()) {
                this.f65231a.q().a(gm.this.f60012h.s(), this.f60016n, i3, obj, null, true);
            }
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, Object obj) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Failed to dispatch postback. Error code: " + i3 + " URL: " + this.f60016n);
            }
            if (gm.this.f60013i != null) {
                gm.this.f60013i.onPostbackFailure(this.f60016n, i3);
            }
            if (gm.this.f60012h.t()) {
                this.f65231a.q().a(gm.this.f60012h.s(), this.f60016n, i3, obj, str2, false);
            }
        }
    }
}
