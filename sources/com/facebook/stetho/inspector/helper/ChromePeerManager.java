package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequestCallback;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ChromePeerManager {
    private static final String TAG = "ChromePeerManager";
    private PeerRegistrationListener mListener;
    private final Map<JsonRpcPeer, DisconnectReceiver> mReceivingPeers = new HashMap();
    private JsonRpcPeer[] mReceivingPeersSnapshot;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class UnregisterOnDisconnect implements DisconnectReceiver {
        private final JsonRpcPeer mPeer;

        public UnregisterOnDisconnect(JsonRpcPeer jsonRpcPeer) {
            this.mPeer = jsonRpcPeer;
        }

        @Override // com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver
        public void onDisconnect() {
            ChromePeerManager.this.removePeer(this.mPeer);
        }
    }

    private synchronized JsonRpcPeer[] getReceivingPeersSnapshot() {
        try {
            if (this.mReceivingPeersSnapshot == null) {
                this.mReceivingPeersSnapshot = (JsonRpcPeer[]) this.mReceivingPeers.keySet().toArray(new JsonRpcPeer[this.mReceivingPeers.size()]);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mReceivingPeersSnapshot;
    }

    private void sendMessageToPeers(String str, Object obj, @Nullable PendingRequestCallback pendingRequestCallback) {
        for (JsonRpcPeer jsonRpcPeer : getReceivingPeersSnapshot()) {
            try {
                jsonRpcPeer.invokeMethod(str, obj, pendingRequestCallback);
            } catch (NotYetConnectedException e3) {
                LogRedirector.e(TAG, "Error delivering data to Chrome", e3);
            }
        }
    }

    public synchronized boolean addPeer(JsonRpcPeer jsonRpcPeer) {
        if (this.mReceivingPeers.containsKey(jsonRpcPeer)) {
            return false;
        }
        UnregisterOnDisconnect unregisterOnDisconnect = new UnregisterOnDisconnect(jsonRpcPeer);
        jsonRpcPeer.registerDisconnectReceiver(unregisterOnDisconnect);
        this.mReceivingPeers.put(jsonRpcPeer, unregisterOnDisconnect);
        this.mReceivingPeersSnapshot = null;
        PeerRegistrationListener peerRegistrationListener = this.mListener;
        if (peerRegistrationListener != null) {
            peerRegistrationListener.onPeerRegistered(jsonRpcPeer);
        }
        return true;
    }

    public synchronized boolean hasRegisteredPeers() {
        return !this.mReceivingPeers.isEmpty();
    }

    public void invokeMethodOnPeers(String str, Object obj, PendingRequestCallback pendingRequestCallback) {
        Util.throwIfNull(pendingRequestCallback);
        sendMessageToPeers(str, obj, pendingRequestCallback);
    }

    public synchronized void removePeer(JsonRpcPeer jsonRpcPeer) {
        if (this.mReceivingPeers.remove(jsonRpcPeer) != null) {
            this.mReceivingPeersSnapshot = null;
            PeerRegistrationListener peerRegistrationListener = this.mListener;
            if (peerRegistrationListener != null) {
                peerRegistrationListener.onPeerUnregistered(jsonRpcPeer);
            }
        }
    }

    public void sendNotificationToPeers(String str, Object obj) {
        sendMessageToPeers(str, obj, null);
    }

    public synchronized void setListener(PeerRegistrationListener peerRegistrationListener) {
        this.mListener = peerRegistrationListener;
    }
}
