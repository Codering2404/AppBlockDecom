package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface NetworkEventReporter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorHeaders {
        @Nullable
        String firstHeaderValue(String str);

        int headerCount();

        String headerName(int i3);

        String headerValue(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorRequest extends InspectorRequestCommon {
        @Nullable
        byte[] body() throws IOException;

        @Nullable
        Integer friendlyNameExtra();

        String method();

        String url();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorRequestCommon extends InspectorHeaders {
        String friendlyName();

        String id();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorResponse extends InspectorResponseCommon {
        int connectionId();

        boolean connectionReused();

        boolean fromDiskCache();

        String url();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorResponseCommon extends InspectorHeaders {
        String reasonPhrase();

        String requestId();

        int statusCode();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorWebSocketFrame {
        public static final int OPCODE_BINARY = 2;
        public static final int OPCODE_CONNECTION_CLOSE = 8;
        public static final int OPCODE_CONTINUATION = 0;
        public static final int OPCODE_PING = 9;
        public static final int OPCODE_PONG = 10;
        public static final int OPCODE_TEXT = 1;

        boolean mask();

        int opcode();

        String payloadData();

        String requestId();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorWebSocketRequest extends InspectorRequestCommon {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InspectorWebSocketResponse extends InspectorResponseCommon {
        @Nullable
        InspectorHeaders requestHeaders();
    }

    void dataReceived(String str, int i3, int i4);

    void dataSent(String str, int i3, int i4);

    void httpExchangeFailed(String str, String str2);

    @Nullable
    InputStream interpretResponseStream(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream, ResponseHandler responseHandler);

    boolean isEnabled();

    String nextRequestId();

    void requestWillBeSent(InspectorRequest inspectorRequest);

    void responseHeadersReceived(InspectorResponse inspectorResponse);

    void responseReadFailed(String str, String str2);

    void responseReadFinished(String str);

    void webSocketClosed(String str);

    void webSocketCreated(String str, String str2);

    void webSocketFrameError(String str, String str2);

    void webSocketFrameReceived(InspectorWebSocketFrame inspectorWebSocketFrame);

    void webSocketFrameSent(InspectorWebSocketFrame inspectorWebSocketFrame);

    void webSocketHandshakeResponseReceived(InspectorWebSocketResponse inspectorWebSocketResponse);

    void webSocketWillSendHandshakeRequest(InspectorWebSocketRequest inspectorWebSocketRequest);
}
