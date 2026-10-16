package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JsonRpcRequest {

    @JsonProperty
    public Long id;

    @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public String method;

    @JsonProperty
    public JSONObject params;

    public JsonRpcRequest() {
    }

    public JsonRpcRequest(Long l3, String str, JSONObject jSONObject) {
        this.id = l3;
        this.method = str;
        this.params = jSONObject;
    }
}
