package com.facebook.stetho.inspector.protocol.module;

import com.facebook.GraphRequest;
import com.facebook.stetho.inspector.console.ConsolePeerManager;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Console implements ChromeDevtoolsDomain {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CallFrame {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int columnNumber;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String functionName;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int lineNumber;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String url;

        public CallFrame() {
        }

        public CallFrame(String str, String str2, int i3, int i4) {
            this.functionName = str;
            this.url = str2;
            this.lineNumber = i3;
            this.columnNumber = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ConsoleMessage {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public MessageLevel level;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public MessageSource source;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String text;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MessageAddedRequest {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public ConsoleMessage message;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MessageLevel {
        LOG("log"),
        WARNING(GraphRequest.DEBUG_SEVERITY_WARNING),
        ERROR("error"),
        DEBUG(GraphRequest.DEBUG_PARAM);

        private final String mProtocolValue;

        MessageLevel(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MessageSource {
        XML("xml"),
        JAVASCRIPT("javascript"),
        NETWORK("network"),
        CONSOLE_API("console-api"),
        STORAGE("storage"),
        APPCACHE("appcache"),
        RENDERING("rendering"),
        CSS("css"),
        SECURITY("security"),
        OTHER("other");

        private final String mProtocolValue;

        MessageSource(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().addPeer(jsonRpcPeer);
    }
}
