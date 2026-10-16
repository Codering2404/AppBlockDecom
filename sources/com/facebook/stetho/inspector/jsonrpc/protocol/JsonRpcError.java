package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JsonRpcError {

    @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public ErrorCode code;

    @JsonProperty
    public JSONObject data;

    @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public String message;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ErrorCode {
        PARSER_ERROR(-32700),
        INVALID_REQUEST(-32600),
        METHOD_NOT_FOUND(-32601),
        INVALID_PARAMS(-32602),
        INTERNAL_ERROR(-32603);

        private final int mProtocolValue;

        ErrorCode(int i3) {
            this.mProtocolValue = i3;
        }

        @JsonValue
        public int getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public JsonRpcError() {
    }

    public JsonRpcError(ErrorCode errorCode, String str, @Nullable JSONObject jSONObject) {
        this.code = errorCode;
        this.message = str;
        this.data = jSONObject;
    }
}
