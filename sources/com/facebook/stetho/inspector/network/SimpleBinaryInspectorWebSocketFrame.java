package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleBinaryInspectorWebSocketFrame implements NetworkEventReporter.InspectorWebSocketFrame {
    private final byte[] mPayload;
    private final String mRequestId;

    public SimpleBinaryInspectorWebSocketFrame(String str, byte[] bArr) {
        this.mRequestId = str;
        this.mPayload = bArr;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public boolean mask() {
        return false;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public int opcode() {
        return 2;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public String payloadData() {
        try {
            return new String(this.mPayload, Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public String requestId() {
        return this.mRequestId;
    }
}
