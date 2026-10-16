package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface PeerRegistrationListener {
    void onPeerRegistered(JsonRpcPeer jsonRpcPeer);

    void onPeerUnregistered(JsonRpcPeer jsonRpcPeer);
}
