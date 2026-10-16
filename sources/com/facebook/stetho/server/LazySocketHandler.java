package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LazySocketHandler implements SocketHandler {

    @Nullable
    private SocketHandler mSocketHandler;
    private final SocketHandlerFactory mSocketHandlerFactory;

    public LazySocketHandler(SocketHandlerFactory socketHandlerFactory) {
        this.mSocketHandlerFactory = socketHandlerFactory;
    }

    @Nonnull
    private synchronized SocketHandler getSocketHandler() {
        try {
            if (this.mSocketHandler == null) {
                this.mSocketHandler = this.mSocketHandlerFactory.create();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mSocketHandler;
    }

    @Override // com.facebook.stetho.server.SocketHandler
    public void onAccepted(LocalSocket localSocket) throws IOException {
        getSocketHandler().onAccepted(localSocket);
    }
}
