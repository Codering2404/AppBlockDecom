package com.facebook.stetho.inspector.jsonrpc;

import android.database.Observable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.SimpleSession;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JsonRpcPeer {
    private long mNextRequestId;
    private final ObjectMapper mObjectMapper;
    private final SimpleSession mPeer;
    private final Map<Long, PendingRequest> mPendingRequests = new HashMap();
    private final DisconnectObservable mDisconnectObservable = new DisconnectObservable();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DisconnectObservable extends Observable<DisconnectReceiver> {
        private DisconnectObservable() {
        }

        public void onDisconnect() {
            int size = ((Observable) this).mObservers.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((DisconnectReceiver) ((Observable) this).mObservers.get(i3)).onDisconnect();
            }
        }
    }

    public JsonRpcPeer(ObjectMapper objectMapper, SimpleSession simpleSession) {
        this.mObjectMapper = objectMapper;
        this.mPeer = (SimpleSession) Util.throwIfNull(simpleSession);
    }

    private synchronized long preparePendingRequest(PendingRequestCallback pendingRequestCallback) {
        long j3;
        j3 = this.mNextRequestId;
        this.mNextRequestId = 1 + j3;
        this.mPendingRequests.put(Long.valueOf(j3), new PendingRequest(j3, pendingRequestCallback));
        return j3;
    }

    public synchronized PendingRequest getAndRemovePendingRequest(long j3) {
        return this.mPendingRequests.remove(Long.valueOf(j3));
    }

    public SimpleSession getWebSocket() {
        return this.mPeer;
    }

    public void invokeDisconnectReceivers() {
        this.mDisconnectObservable.onDisconnect();
    }

    public void invokeMethod(String str, Object obj, @Nullable PendingRequestCallback pendingRequestCallback) throws NotYetConnectedException {
        Util.throwIfNull(str);
        this.mPeer.sendText(((JSONObject) this.mObjectMapper.convertValue(new JsonRpcRequest(pendingRequestCallback != null ? Long.valueOf(preparePendingRequest(pendingRequestCallback)) : null, str, (JSONObject) this.mObjectMapper.convertValue(obj, JSONObject.class)), JSONObject.class)).toString());
    }

    public void registerDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.registerObserver(disconnectReceiver);
    }

    public void unregisterDisconnectReceiver(DisconnectReceiver disconnectReceiver) {
        this.mDisconnectObservable.unregisterObserver(disconnectReceiver);
    }
}
