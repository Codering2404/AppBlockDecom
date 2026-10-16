package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HeapProfiler implements ChromeDevtoolsDomain {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProfileHeader {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String title;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int uid;

        private ProfileHeader() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProfileHeaderResponse implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public List<ProfileHeader> headers;

        private ProfileHeaderResponse() {
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getProfileHeaders(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ProfileHeaderResponse profileHeaderResponse = new ProfileHeaderResponse();
        profileHeaderResponse.headers = Collections.EMPTY_LIST;
        return profileHeaderResponse;
    }
}
