package com.facebook.stetho.inspector;

import com.facebook.GraphRequest;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequest;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.CloseCodes;
import com.facebook.stetho.websocket.SimpleEndpoint;
import com.facebook.stetho.websocket.SimpleSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ChromeDevtoolsServer implements SimpleEndpoint {
    public static final String PATH = "/inspector";
    private static final String TAG = "ChromeDevtoolsServer";
    private final MethodDispatcher mMethodDispatcher;
    private final ObjectMapper mObjectMapper;
    private final Map<SimpleSession, JsonRpcPeer> mPeers = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.facebook.stetho.inspector.ChromeDevtoolsServer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode;

        static {
            int[] iArr = new int[JsonRpcError.ErrorCode.values().length];
            $SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode = iArr;
            try {
                iArr[JsonRpcError.ErrorCode.METHOD_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ChromeDevtoolsServer(Iterable<ChromeDevtoolsDomain> iterable) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mObjectMapper = objectMapper;
        this.mMethodDispatcher = new MethodDispatcher(objectMapper, iterable);
    }

    private void closeSafely(SimpleSession simpleSession, int i3, String str) {
        simpleSession.close(i3, str);
    }

    private void handleRemoteMessage(JsonRpcPeer jsonRpcPeer, String str) throws Throwable {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(GraphRequest.BATCH_METHOD_PARAM)) {
            handleRemoteRequest(jsonRpcPeer, jSONObject);
        } else {
            if (jSONObject.has("result")) {
                handleRemoteResponse(jsonRpcPeer, jSONObject);
                return;
            }
            throw new MessageHandlingException("Improper JSON-RPC message: " + str);
        }
    }

    private void handleRemoteRequest(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws Throwable {
        JSONObject jSONObject2;
        JSONObject jSONObjectDispatch;
        String string;
        JsonRpcRequest jsonRpcRequest = (JsonRpcRequest) this.mObjectMapper.convertValue(jSONObject, JsonRpcRequest.class);
        try {
            jSONObjectDispatch = this.mMethodDispatcher.dispatch(jsonRpcPeer, jsonRpcRequest.method, jsonRpcRequest.params);
            jSONObject2 = null;
        } catch (JsonRpcException e3) {
            logDispatchException(e3);
            jSONObject2 = (JSONObject) this.mObjectMapper.convertValue(e3.getErrorMessage(), JSONObject.class);
            jSONObjectDispatch = null;
        }
        if (jsonRpcRequest.id != null) {
            JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
            jsonRpcResponse.id = jsonRpcRequest.id.longValue();
            jsonRpcResponse.result = jSONObjectDispatch;
            jsonRpcResponse.error = jSONObject2;
            try {
                string = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            } catch (OutOfMemoryError e4) {
                jsonRpcResponse.result = null;
                jsonRpcResponse.error = (JSONObject) this.mObjectMapper.convertValue(e4.getMessage(), JSONObject.class);
                string = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            }
            jsonRpcPeer.getWebSocket().sendText(string);
        }
    }

    private void handleRemoteResponse(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws MismatchedResponseException {
        JsonRpcResponse jsonRpcResponse = (JsonRpcResponse) this.mObjectMapper.convertValue(jSONObject, JsonRpcResponse.class);
        PendingRequest andRemovePendingRequest = jsonRpcPeer.getAndRemovePendingRequest(jsonRpcResponse.id);
        if (andRemovePendingRequest == null) {
            throw new MismatchedResponseException(jsonRpcResponse.id);
        }
        PendingRequestCallback pendingRequestCallback = andRemovePendingRequest.callback;
        if (pendingRequestCallback != null) {
            pendingRequestCallback.onResponse(jsonRpcPeer, jsonRpcResponse);
        }
    }

    private static void logDispatchException(JsonRpcException jsonRpcException) {
        JsonRpcError errorMessage = jsonRpcException.getErrorMessage();
        if (AnonymousClass1.$SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode[errorMessage.code.ordinal()] != 1) {
            LogRedirector.w(TAG, "Error processing remote message", jsonRpcException);
            return;
        }
        LogRedirector.d(TAG, "Method not implemented: " + errorMessage.message);
    }

    @Override // com.facebook.stetho.websocket.SimpleEndpoint
    public void onClose(SimpleSession simpleSession, int i3, String str) {
        LogRedirector.d(TAG, "onClose: reason=" + i3 + " " + str);
        JsonRpcPeer jsonRpcPeerRemove = this.mPeers.remove(simpleSession);
        if (jsonRpcPeerRemove != null) {
            jsonRpcPeerRemove.invokeDisconnectReceivers();
        }
    }

    @Override // com.facebook.stetho.websocket.SimpleEndpoint
    public void onError(SimpleSession simpleSession, Throwable th) {
        LogRedirector.e(TAG, "onError: ex=" + th.toString());
    }

    @Override // com.facebook.stetho.websocket.SimpleEndpoint
    public void onMessage(SimpleSession simpleSession, byte[] bArr, int i3) {
        LogRedirector.d(TAG, "Ignoring binary message of length " + i3);
    }

    @Override // com.facebook.stetho.websocket.SimpleEndpoint
    public void onOpen(SimpleSession simpleSession) {
        LogRedirector.d(TAG, "onOpen");
        this.mPeers.put(simpleSession, new JsonRpcPeer(this.mObjectMapper, simpleSession));
    }

    @Override // com.facebook.stetho.websocket.SimpleEndpoint
    public void onMessage(SimpleSession simpleSession, String str) throws Throwable {
        if (LogRedirector.isLoggable(TAG, 2)) {
            LogRedirector.v(TAG, "onMessage: message=" + str);
        }
        try {
            JsonRpcPeer jsonRpcPeer = this.mPeers.get(simpleSession);
            Util.throwIfNull(jsonRpcPeer);
            handleRemoteMessage(jsonRpcPeer, str);
        } catch (MessageHandlingException e3) {
            LogRedirector.i(TAG, "Message could not be processed by implementation: " + e3);
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e3.getClass().getSimpleName());
        } catch (IOException e4) {
            if (LogRedirector.isLoggable(TAG, 2)) {
                LogRedirector.v(TAG, "Unexpected I/O exception processing message: " + e4);
            }
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e4.getClass().getSimpleName());
        } catch (JSONException e5) {
            LogRedirector.v(TAG, "Unexpected JSON exception processing message", e5);
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, e5.getClass().getSimpleName());
        }
    }
}
