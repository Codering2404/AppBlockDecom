package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PeersRegisteredListener implements PeerRegistrationListener {
    private AtomicInteger mPeers = new AtomicInteger(0);

    protected abstract void onFirstPeerRegistered();

    protected abstract void onLastPeerUnregistered();

    @Override // com.facebook.stetho.inspector.helper.PeerRegistrationListener
    public final void onPeerRegistered(JsonRpcPeer jsonRpcPeer) {
        if (this.mPeers.incrementAndGet() == 1) {
            onFirstPeerRegistered();
        }
        onPeerAdded(jsonRpcPeer);
    }

    @Override // com.facebook.stetho.inspector.helper.PeerRegistrationListener
    public final void onPeerUnregistered(JsonRpcPeer jsonRpcPeer) {
        if (this.mPeers.decrementAndGet() == 0) {
            onLastPeerUnregistered();
        }
        onPeerRemoved(jsonRpcPeer);
    }

    protected void onPeerAdded(JsonRpcPeer jsonRpcPeer) {
    }

    protected void onPeerRemoved(JsonRpcPeer jsonRpcPeer) {
    }
}
