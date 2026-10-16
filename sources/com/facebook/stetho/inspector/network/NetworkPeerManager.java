package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkPeerManager extends ChromePeerManager {
    private static NetworkPeerManager sInstance;
    private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
    private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
    private final ResponseBodyFileManager mResponseBodyFileManager;
    private final PeersRegisteredListener mTempFileCleanup;

    public NetworkPeerManager(ResponseBodyFileManager responseBodyFileManager) {
        PeersRegisteredListener peersRegisteredListener = new PeersRegisteredListener() { // from class: com.facebook.stetho.inspector.network.NetworkPeerManager.1
            @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
            protected void onFirstPeerRegistered() {
                AsyncPrettyPrinterExecutorHolder.ensureInitialized();
                if (NetworkPeerManager.this.mAsyncPrettyPrinterRegistry == null && NetworkPeerManager.this.mPrettyPrinterInitializer != null) {
                    NetworkPeerManager.this.mAsyncPrettyPrinterRegistry = new AsyncPrettyPrinterRegistry();
                    NetworkPeerManager.this.mPrettyPrinterInitializer.populatePrettyPrinters(NetworkPeerManager.this.mAsyncPrettyPrinterRegistry);
                }
                NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
            }

            @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
            protected void onLastPeerUnregistered() {
                NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
                AsyncPrettyPrinterExecutorHolder.shutdown();
            }
        };
        this.mTempFileCleanup = peersRegisteredListener;
        this.mResponseBodyFileManager = responseBodyFileManager;
        setListener(peersRegisteredListener);
    }

    @Nullable
    public static synchronized NetworkPeerManager getInstanceOrNull() {
        return sInstance;
    }

    public static synchronized NetworkPeerManager getOrCreateInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new NetworkPeerManager(new ResponseBodyFileManager(context.getApplicationContext()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @Nullable
    public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry() {
        return this.mAsyncPrettyPrinterRegistry;
    }

    public ResponseBodyFileManager getResponseBodyFileManager() {
        return this.mResponseBodyFileManager;
    }

    public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer asyncPrettyPrinterInitializer) {
        Util.throwIfNotNull(this.mPrettyPrinterInitializer);
        this.mPrettyPrinterInitializer = (AsyncPrettyPrinterInitializer) Util.throwIfNull(asyncPrettyPrinterInitializer);
    }
}
