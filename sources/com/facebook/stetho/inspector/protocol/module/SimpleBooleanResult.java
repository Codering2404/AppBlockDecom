package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleBooleanResult implements JsonRpcResult {

    @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public boolean result;

    public SimpleBooleanResult() {
    }

    public SimpleBooleanResult(boolean z2) {
        this.result = z2;
    }
}
