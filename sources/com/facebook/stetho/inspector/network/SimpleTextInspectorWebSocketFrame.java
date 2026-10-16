package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.network.NetworkEventReporter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleTextInspectorWebSocketFrame implements NetworkEventReporter.InspectorWebSocketFrame {
    private final String mPayload;
    private final String mRequestId;

    public SimpleTextInspectorWebSocketFrame(String str, String str2) {
        this.mRequestId = str;
        this.mPayload = str2;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public boolean mask() {
        return false;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public int opcode() {
        return 1;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public String payloadData() {
        return this.mPayload;
    }

    @Override // com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorWebSocketFrame
    public String requestId() {
        return this.mRequestId;
    }
}
