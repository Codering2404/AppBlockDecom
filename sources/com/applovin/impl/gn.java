package com.applovin.impl;

import com.applovin.impl.d4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class gn extends in {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements d4.e {
        a() {
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            gn.this.a(i3);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            gn.this.b(jSONObject);
        }
    }

    protected gn(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private JSONObject a(eh ehVar) {
        JSONObject jSONObjectE = e();
        JsonUtils.putString(jSONObjectE, "result", ehVar.b());
        Map mapA = ehVar.a();
        if (mapA != null) {
            JsonUtils.putJSONObject(jSONObjectE, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(mapA));
        }
        return jSONObjectE;
    }

    protected abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.in
    protected int g() {
        return ((Integer) this.f65231a.a(sj.f63743g1)).intValue();
    }

    protected abstract eh h();

    protected abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        eh ehVarH = h();
        if (ehVarH == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Pending reward not found");
            }
            i();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Reporting pending reward: " + ehVarH + "...");
        }
        a(a(ehVarH), new a());
    }
}
