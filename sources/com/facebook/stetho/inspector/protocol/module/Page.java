package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.screencast.ScreencastDispatcher;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Page implements ChromeDevtoolsDomain {
    public static final String BANNER = "_____/\\\\\\\\\\\\\\\\\\\\\\_______________________________________________/\\\\\\_______________________\n ___/\\\\\\/////////\\\\\\____________________________________________\\/\\\\\\_______________________\n  __\\//\\\\\\______\\///______/\\\\\\_________________________/\\\\\\______\\/\\\\\\_______________________\n   ___\\////\\\\\\__________/\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\_____________/\\\\\\\\\\____\n    ______\\////\\\\\\______\\////\\\\\\////____/\\\\\\/////\\\\\\_\\////\\\\\\////__\\/\\\\\\\\\\\\\\\\\\\\____/\\\\\\///\\\\\\__\n     _________\\////\\\\\\______\\/\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\______\\/\\\\\\/////\\\\\\__/\\\\\\__\\//\\\\\\_\n      __/\\\\\\______\\//\\\\\\_____\\/\\\\\\_/\\\\__\\//\\\\///////______\\/\\\\\\_/\\\\__\\/\\\\\\___\\/\\\\\\_\\//\\\\\\__/\\\\\\__\n       _\\///\\\\\\\\\\\\\\\\\\\\\\/______\\//\\\\\\\\\\____\\//\\\\\\\\\\\\\\\\\\\\____\\//\\\\\\\\\\___\\/\\\\\\___\\/\\\\\\__\\///\\\\\\\\\\/___\n        ___\\///////////_________\\/////______\\//////////______\\/////____\\///____\\///_____\\/////_____\n         Welcome to Stetho";
    private final Context mContext;
    private final String mMessage;
    private final ObjectMapper mObjectMapper;
    private ScreencastDispatcher mScreencastDispatcher;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExecutionContextCreatedParams {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public ExecutionContextDescription context;

        private ExecutionContextCreatedParams() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExecutionContextDescription {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String frameId;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int id;

        private ExecutionContextDescription() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Frame {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String id;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String loaderId;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String mimeType;

        @JsonProperty
        public String name;

        @JsonProperty
        public String parentId;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String securityOrigin;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String url;

        private Frame() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameResourceTree {

        @JsonProperty
        public List<FrameResourceTree> childFrames;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public Frame frame;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public List<Resource> resources;

        private FrameResourceTree() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetResourceTreeParams implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public FrameResourceTree frameTree;

        private GetResourceTreeParams() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Resource {
        private Resource() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ResourceType {
        DOCUMENT("Document"),
        STYLESHEET("Stylesheet"),
        IMAGE("Image"),
        FONT("Font"),
        SCRIPT("Script"),
        XHR("XHR"),
        WEBSOCKET("WebSocket"),
        OTHER("Other");

        private final String mProtocolValue;

        ResourceType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ScreencastFrameEvent {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String data;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public ScreencastFrameEventMetadata metadata;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ScreencastFrameEventMetadata {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int deviceHeight;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int deviceWidth;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int offsetTop;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int pageScaleFactor;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int scrollOffsetX;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int scrollOffsetY;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StartScreencastRequest {

        @JsonProperty
        public String format;

        @JsonProperty
        public int maxHeight;

        @JsonProperty
        public int maxWidth;

        @JsonProperty
        public int quality;
    }

    public Page(Context context) {
        this(context, BANNER);
    }

    private static FrameResourceTree createSimpleFrameResourceTree(String str, String str2, String str3, String str4) {
        Frame frame = new Frame();
        frame.id = str;
        frame.parentId = str2;
        frame.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        frame.name = str3;
        frame.url = "";
        frame.securityOrigin = str4;
        frame.mimeType = "text/plain";
        FrameResourceTree frameResourceTree = new FrameResourceTree();
        frameResourceTree.frame = frame;
        frameResourceTree.resources = Collections.EMPTY_LIST;
        frameResourceTree.childFrames = null;
        return frameResourceTree;
    }

    private void sendWelcomeMessage(JsonRpcPeer jsonRpcPeer) {
        Console.ConsoleMessage consoleMessage = new Console.ConsoleMessage();
        consoleMessage.source = Console.MessageSource.JAVASCRIPT;
        consoleMessage.level = Console.MessageLevel.LOG;
        consoleMessage.text = this.mMessage + "\n          Attached to " + ProcessUtil.getProcessName() + "\n";
        Console.MessageAddedRequest messageAddedRequest = new Console.MessageAddedRequest();
        messageAddedRequest.message = consoleMessage;
        jsonRpcPeer.invokeMethod("Console.messageAdded", messageAddedRequest, null);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult canScreencast(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return new SimpleBooleanResult(true);
    }

    @ChromeDevtoolsMethod
    public void clearDeviceOrientationOverride(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void clearGeolocationOverride(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        notifyExecutionContexts(jsonRpcPeer);
        sendWelcomeMessage(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getResourceTree(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        Iterator<String> it = SharedPreferencesHelper.getSharedPreferenceTags(this.mContext).iterator();
        FrameResourceTree frameResourceTreeCreateSimpleFrameResourceTree = createSimpleFrameResourceTree(AppEventsConstants.EVENT_PARAM_VALUE_YES, null, "Stetho", it.hasNext() ? it.next() : "");
        if (frameResourceTreeCreateSimpleFrameResourceTree.childFrames == null) {
            frameResourceTreeCreateSimpleFrameResourceTree.childFrames = new ArrayList();
        }
        int i3 = 1;
        while (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("1.");
            int i4 = i3 + 1;
            sb.append(i3);
            String string = sb.toString();
            frameResourceTreeCreateSimpleFrameResourceTree.childFrames.add(createSimpleFrameResourceTree(string, AppEventsConstants.EVENT_PARAM_VALUE_YES, "Child #" + string, it.next()));
            i3 = i4;
        }
        GetResourceTreeParams getResourceTreeParams = new GetResourceTreeParams();
        getResourceTreeParams.frameTree = frameResourceTreeCreateSimpleFrameResourceTree;
        return getResourceTreeParams;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult hasTouchInputs(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return new SimpleBooleanResult(false);
    }

    @ChromeDevtoolsMethod
    public void screencastFrameAck(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void setDeviceMetricsOverride(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void setEmulatedMedia(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void setShowViewportSizeOnResize(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void setTouchEmulationEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void startScreencast(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        StartScreencastRequest startScreencastRequest = (StartScreencastRequest) this.mObjectMapper.convertValue(jSONObject, StartScreencastRequest.class);
        if (this.mScreencastDispatcher == null) {
            ScreencastDispatcher screencastDispatcher = new ScreencastDispatcher();
            this.mScreencastDispatcher = screencastDispatcher;
            screencastDispatcher.startScreencast(jsonRpcPeer, startScreencastRequest);
        }
    }

    @ChromeDevtoolsMethod
    public void stopScreencast(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ScreencastDispatcher screencastDispatcher = this.mScreencastDispatcher;
        if (screencastDispatcher != null) {
            screencastDispatcher.stopScreencast();
            this.mScreencastDispatcher = null;
        }
    }

    public Page(Context context, String str) {
        this.mObjectMapper = new ObjectMapper();
        this.mContext = context;
        this.mMessage = str;
    }

    private void notifyExecutionContexts(JsonRpcPeer jsonRpcPeer) {
        ExecutionContextDescription executionContextDescription = new ExecutionContextDescription();
        executionContextDescription.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        executionContextDescription.id = 1;
        ExecutionContextCreatedParams executionContextCreatedParams = new ExecutionContextCreatedParams();
        executionContextCreatedParams.context = executionContextDescription;
        jsonRpcPeer.invokeMethod(oUcQRqOVfOC.CtYPRjSYmYVrF, executionContextCreatedParams, null);
    }
}
