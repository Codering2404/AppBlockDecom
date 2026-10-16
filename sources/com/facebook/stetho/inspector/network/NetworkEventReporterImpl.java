package com.facebook.stetho.inspector.network;

import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkEventReporterImpl implements NetworkEventReporter {
    private static NetworkEventReporter sInstance;
    private final AtomicInteger mNextRequestId = new AtomicInteger(0);

    @Nullable
    private ResourceTypeHelper mResourceTypeHelper;

    private NetworkEventReporterImpl() {
    }

    private static Network.WebSocketFrame convertFrame(NetworkEventReporter.InspectorWebSocketFrame inspectorWebSocketFrame) {
        Network.WebSocketFrame webSocketFrame = new Network.WebSocketFrame();
        webSocketFrame.opcode = inspectorWebSocketFrame.opcode();
        webSocketFrame.mask = inspectorWebSocketFrame.mask();
        webSocketFrame.payloadData = inspectorWebSocketFrame.payloadData();
        return webSocketFrame;
    }

    @Nullable
    static AsyncPrettyPrinter createPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse inspectorResponse, @Nullable AsyncPrettyPrinterRegistry asyncPrettyPrinterRegistry) {
        if (asyncPrettyPrinterRegistry == null) {
            return null;
        }
        int iHeaderCount = inspectorResponse.headerCount();
        for (int i3 = 0; i3 < iHeaderCount; i3++) {
            AsyncPrettyPrinterFactory asyncPrettyPrinterFactoryLookup = asyncPrettyPrinterRegistry.lookup(inspectorResponse.headerName(i3));
            if (asyncPrettyPrinterFactoryLookup != null) {
                return asyncPrettyPrinterFactoryLookup.getInstance(inspectorResponse.headerName(i3), inspectorResponse.headerValue(i3));
            }
        }
        return null;
    }

    private static Page.ResourceType determineResourceType(AsyncPrettyPrinter asyncPrettyPrinter, String str, ResourceTypeHelper resourceTypeHelper) {
        return asyncPrettyPrinter != null ? asyncPrettyPrinter.getPrettifiedType().getResourceType() : str != null ? resourceTypeHelper.determineResourceType(str) : Page.ResourceType.OTHER;
    }

    private static JSONObject formatHeadersAsJSON(NetworkEventReporter.InspectorHeaders inspectorHeaders) {
        JSONObject jSONObject = new JSONObject();
        for (int i3 = 0; i3 < inspectorHeaders.headerCount(); i3++) {
            String strHeaderName = inspectorHeaders.headerName(i3);
            String strHeaderValue = inspectorHeaders.headerValue(i3);
            try {
                if (jSONObject.has(strHeaderName)) {
                    jSONObject.put(strHeaderName, jSONObject.getString(strHeaderName) + "\n" + strHeaderValue);
                } else {
                    jSONObject.put(strHeaderName, strHeaderValue);
                }
            } catch (JSONException e3) {
                throw new RuntimeException(e3);
            }
        }
        return jSONObject;
    }

    public static synchronized NetworkEventReporter get() {
        try {
            if (sInstance == null) {
                sInstance = new NetworkEventReporterImpl();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @Nullable
    private String getContentType(NetworkEventReporter.InspectorHeaders inspectorHeaders) {
        return inspectorHeaders.firstHeaderValue("Content-Type");
    }

    @Nullable
    private NetworkPeerManager getPeerManagerIfEnabled() {
        NetworkPeerManager instanceOrNull = NetworkPeerManager.getInstanceOrNull();
        if (instanceOrNull == null || !instanceOrNull.hasRegisteredPeers()) {
            return null;
        }
        return instanceOrNull;
    }

    @Nonnull
    private ResourceTypeHelper getResourceTypeHelper() {
        if (this.mResourceTypeHelper == null) {
            this.mResourceTypeHelper = new ResourceTypeHelper();
        }
        return this.mResourceTypeHelper;
    }

    @Nullable
    private static AsyncPrettyPrinter initAsyncPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse inspectorResponse, NetworkPeerManager networkPeerManager) {
        AsyncPrettyPrinter asyncPrettyPrinterCreatePrettyPrinterForResponse = createPrettyPrinterForResponse(inspectorResponse, networkPeerManager.getAsyncPrettyPrinterRegistry());
        if (asyncPrettyPrinterCreatePrettyPrinterForResponse != null) {
            networkPeerManager.getResponseBodyFileManager().associateAsyncPrettyPrinterWithId(inspectorResponse.requestId(), asyncPrettyPrinterCreatePrettyPrinterForResponse);
        }
        return asyncPrettyPrinterCreatePrettyPrinterForResponse;
    }

    private void loadingFailed(String str, String str2) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.LoadingFailedParams loadingFailedParams = new Network.LoadingFailedParams();
            loadingFailedParams.requestId = str;
            loadingFailedParams.timestamp = stethoNow() / 1000.0d;
            loadingFailedParams.errorText = str2;
            loadingFailedParams.type = Page.ResourceType.OTHER;
            peerManagerIfEnabled.sendNotificationToPeers("Network.loadingFailed", loadingFailedParams);
        }
    }

    private void loadingFinished(String str) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.LoadingFinishedParams loadingFinishedParams = new Network.LoadingFinishedParams();
            loadingFinishedParams.requestId = str;
            loadingFinishedParams.timestamp = stethoNow() / 1000.0d;
            peerManagerIfEnabled.sendNotificationToPeers("Network.loadingFinished", loadingFinishedParams);
        }
    }

    @Nullable
    private static String readBodyAsString(NetworkPeerManager networkPeerManager, NetworkEventReporter.InspectorRequest inspectorRequest) {
        try {
            byte[] bArrBody = inspectorRequest.body();
            if (bArrBody != null) {
                return new String(bArrBody, Utf8Charset.INSTANCE);
            }
            return null;
        } catch (IOException | OutOfMemoryError e3) {
            CLog.writeToConsole(networkPeerManager, Console.MessageLevel.WARNING, Console.MessageSource.NETWORK, "Could not reproduce POST body: " + e3);
            return null;
        }
    }

    private static long stethoNow() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void dataReceived(String str, int i3, int i4) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.DataReceivedParams dataReceivedParams = new Network.DataReceivedParams();
            dataReceivedParams.requestId = str;
            dataReceivedParams.timestamp = stethoNow() / 1000.0d;
            dataReceivedParams.dataLength = i3;
            dataReceivedParams.encodedDataLength = i4;
            peerManagerIfEnabled.sendNotificationToPeers("Network.dataReceived", dataReceivedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void dataSent(String str, int i3, int i4) {
        dataReceived(str, i3, i4);
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void httpExchangeFailed(String str, String str2) {
        loadingFailed(str, str2);
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public InputStream interpretResponseStream(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream, ResponseHandler responseHandler) {
        String str4;
        InputStream inputStream2;
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled == null) {
            return inputStream;
        }
        if (inputStream == null) {
            responseHandler.onEOF();
            return null;
        }
        Page.ResourceType resourceTypeDetermineResourceType = str2 != null ? getResourceTypeHelper().determineResourceType(str2) : null;
        boolean z2 = resourceTypeDetermineResourceType != null && resourceTypeDetermineResourceType == Page.ResourceType.IMAGE;
        try {
            str4 = str;
            inputStream2 = inputStream;
            try {
                return DecompressionHelper.teeInputWithDecompression(peerManagerIfEnabled, str4, inputStream2, peerManagerIfEnabled.getResponseBodyFileManager().openResponseBodyFile(str, z2), str3, responseHandler);
            } catch (IOException unused) {
                CLog.writeToConsole(peerManagerIfEnabled, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Error writing response body data for request #" + str4);
                return inputStream2;
            }
        } catch (IOException unused2) {
            str4 = str;
            inputStream2 = inputStream;
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public boolean isEnabled() {
        return getPeerManagerIfEnabled() != null;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public String nextRequestId() {
        return String.valueOf(this.mNextRequestId.getAndIncrement());
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void requestWillBeSent(NetworkEventReporter.InspectorRequest inspectorRequest) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.Request request = new Network.Request();
            request.url = inspectorRequest.url();
            request.method = inspectorRequest.method();
            request.headers = formatHeadersAsJSON(inspectorRequest);
            request.postData = readBodyAsString(peerManagerIfEnabled, inspectorRequest);
            String strFriendlyName = inspectorRequest.friendlyName();
            Integer numFriendlyNameExtra = inspectorRequest.friendlyNameExtra();
            Network.Initiator initiator = new Network.Initiator();
            initiator.type = Network.InitiatorType.SCRIPT;
            ArrayList arrayList = new ArrayList();
            initiator.stackTrace = arrayList;
            arrayList.add(new Console.CallFrame(strFriendlyName, strFriendlyName, numFriendlyNameExtra != null ? numFriendlyNameExtra.intValue() : 0, 0));
            Network.RequestWillBeSentParams requestWillBeSentParams = new Network.RequestWillBeSentParams();
            requestWillBeSentParams.requestId = inspectorRequest.id();
            requestWillBeSentParams.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            requestWillBeSentParams.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            requestWillBeSentParams.documentURL = inspectorRequest.url();
            requestWillBeSentParams.request = request;
            requestWillBeSentParams.timestamp = stethoNow() / 1000.0d;
            requestWillBeSentParams.initiator = initiator;
            requestWillBeSentParams.redirectResponse = null;
            requestWillBeSentParams.type = Page.ResourceType.OTHER;
            peerManagerIfEnabled.sendNotificationToPeers("Network.requestWillBeSent", requestWillBeSentParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void responseHeadersReceived(NetworkEventReporter.InspectorResponse inspectorResponse) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.Response response = new Network.Response();
            response.url = inspectorResponse.url();
            response.status = inspectorResponse.statusCode();
            response.statusText = inspectorResponse.reasonPhrase();
            response.headers = formatHeadersAsJSON(inspectorResponse);
            String contentType = getContentType(inspectorResponse);
            response.mimeType = contentType != null ? getResourceTypeHelper().stripContentExtras(contentType) : "application/octet-stream";
            response.connectionReused = inspectorResponse.connectionReused();
            response.connectionId = inspectorResponse.connectionId();
            response.fromDiskCache = Boolean.valueOf(inspectorResponse.fromDiskCache());
            Network.ResponseReceivedParams responseReceivedParams = new Network.ResponseReceivedParams();
            responseReceivedParams.requestId = inspectorResponse.requestId();
            responseReceivedParams.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            responseReceivedParams.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            responseReceivedParams.timestamp = stethoNow() / 1000.0d;
            responseReceivedParams.response = response;
            responseReceivedParams.type = determineResourceType(initAsyncPrettyPrinterForResponse(inspectorResponse, peerManagerIfEnabled), contentType, getResourceTypeHelper());
            peerManagerIfEnabled.sendNotificationToPeers("Network.responseReceived", responseReceivedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void responseReadFailed(String str, String str2) {
        loadingFailed(str, str2);
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void responseReadFinished(String str) {
        loadingFinished(str);
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketClosed(String str) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketClosedParams webSocketClosedParams = new Network.WebSocketClosedParams();
            webSocketClosedParams.requestId = str;
            webSocketClosedParams.timestamp = stethoNow() / 1000.0d;
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketClosed", webSocketClosedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketCreated(String str, String str2) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketCreatedParams webSocketCreatedParams = new Network.WebSocketCreatedParams();
            webSocketCreatedParams.requestId = str;
            webSocketCreatedParams.url = str2;
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketCreated", webSocketCreatedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketFrameError(String str, String str2) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketFrameErrorParams webSocketFrameErrorParams = new Network.WebSocketFrameErrorParams();
            webSocketFrameErrorParams.requestId = str;
            webSocketFrameErrorParams.timestamp = stethoNow() / 1000.0d;
            webSocketFrameErrorParams.errorMessage = str2;
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketFrameError", webSocketFrameErrorParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketFrameReceived(NetworkEventReporter.InspectorWebSocketFrame inspectorWebSocketFrame) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketFrameReceivedParams webSocketFrameReceivedParams = new Network.WebSocketFrameReceivedParams();
            webSocketFrameReceivedParams.requestId = inspectorWebSocketFrame.requestId();
            webSocketFrameReceivedParams.timestamp = stethoNow() / 1000.0d;
            webSocketFrameReceivedParams.response = convertFrame(inspectorWebSocketFrame);
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketFrameReceived", webSocketFrameReceivedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketFrameSent(NetworkEventReporter.InspectorWebSocketFrame inspectorWebSocketFrame) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketFrameSentParams webSocketFrameSentParams = new Network.WebSocketFrameSentParams();
            webSocketFrameSentParams.requestId = inspectorWebSocketFrame.requestId();
            webSocketFrameSentParams.timestamp = stethoNow() / 1000.0d;
            webSocketFrameSentParams.response = convertFrame(inspectorWebSocketFrame);
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketFrameSent", webSocketFrameSentParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketHandshakeResponseReceived(NetworkEventReporter.InspectorWebSocketResponse inspectorWebSocketResponse) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketHandshakeResponseReceivedParams webSocketHandshakeResponseReceivedParams = new Network.WebSocketHandshakeResponseReceivedParams();
            webSocketHandshakeResponseReceivedParams.requestId = inspectorWebSocketResponse.requestId();
            webSocketHandshakeResponseReceivedParams.timestamp = stethoNow() / 1000.0d;
            Network.WebSocketResponse webSocketResponse = new Network.WebSocketResponse();
            webSocketResponse.headers = formatHeadersAsJSON(inspectorWebSocketResponse);
            webSocketResponse.headersText = null;
            if (inspectorWebSocketResponse.requestHeaders() != null) {
                webSocketResponse.requestHeaders = formatHeadersAsJSON(inspectorWebSocketResponse.requestHeaders());
                webSocketResponse.requestHeadersText = null;
            }
            webSocketResponse.status = inspectorWebSocketResponse.statusCode();
            webSocketResponse.statusText = inspectorWebSocketResponse.reasonPhrase();
            webSocketHandshakeResponseReceivedParams.response = webSocketResponse;
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketHandshakeResponseReceived", webSocketHandshakeResponseReceivedParams);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter
    public void webSocketWillSendHandshakeRequest(NetworkEventReporter.InspectorWebSocketRequest inspectorWebSocketRequest) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Network.WebSocketWillSendHandshakeRequestParams webSocketWillSendHandshakeRequestParams = new Network.WebSocketWillSendHandshakeRequestParams();
            webSocketWillSendHandshakeRequestParams.requestId = inspectorWebSocketRequest.id();
            webSocketWillSendHandshakeRequestParams.timestamp = stethoNow() / 1000.0d;
            webSocketWillSendHandshakeRequestParams.wallTime = System.currentTimeMillis() / 1000.0d;
            Network.WebSocketRequest webSocketRequest = new Network.WebSocketRequest();
            webSocketRequest.headers = formatHeadersAsJSON(inspectorWebSocketRequest);
            webSocketWillSendHandshakeRequestParams.request = webSocketRequest;
            peerManagerIfEnabled.sendNotificationToPeers("Network.webSocketWillSendHandshakeRequest", webSocketWillSendHandshakeRequestParams);
        }
    }
}
