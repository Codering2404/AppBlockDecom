package com.applovin.impl;

import com.applovin.impl.d4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class mn extends in {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements d4.e {
        a() {
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            if (mn.this.h()) {
                com.applovin.impl.sdk.n nVar = mn.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    mn mnVar = mn.this;
                    mnVar.f65233c.b(mnVar.f65232b, "Reward validation failed with error code " + i3 + " but task was cancelled already");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n nVar2 = mn.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                mn mnVar2 = mn.this;
                mnVar2.f65233c.b(mnVar2.f65232b, "Reward validation failed with code " + i3 + " and error: " + str2);
            }
            mn.this.a(i3);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            if (mn.this.h()) {
                com.applovin.impl.sdk.n nVar = mn.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    mn mnVar = mn.this;
                    mnVar.f65233c.b(mnVar.f65232b, "Reward validation succeeded with code " + i3 + " but task was cancelled already");
                }
                com.applovin.impl.sdk.n nVar2 = mn.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    mn mnVar2 = mn.this;
                    mnVar2.f65233c.b(mnVar2.f65232b, "Response: " + jSONObject);
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n nVar3 = mn.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                mn mnVar3 = mn.this;
                mnVar3.f65233c.a(mnVar3.f65232b, "Reward validation succeeded with code " + i3 + " and response: " + jSONObject);
            }
            mn.this.c(jSONObject);
        }
    }

    protected mn(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private eh b(JSONObject jSONObject) {
        Map<String, String> stringMap;
        String string;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        e4.c(jSONObject2, this.f65231a);
        e4.b(jSONObject, this.f65231a);
        e4.a(jSONObject, this.f65231a);
        try {
            stringMap = JsonUtils.toStringMap((JSONObject) jSONObject2.get(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Throwable unused) {
            stringMap = Collections.EMPTY_MAP;
        }
        try {
            string = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            string = "network_timeout";
        }
        return eh.a(string, stringMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        eh ehVarB = b(jSONObject);
        a(ehVarB);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Pending reward handled: " + ehVarB);
        }
    }

    protected abstract void a(eh ehVar);

    @Override // com.applovin.impl.in
    protected int g() {
        return ((Integer) this.f65231a.a(sj.f63739f1)).intValue();
    }

    protected abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        a(e(), new a());
    }
}
