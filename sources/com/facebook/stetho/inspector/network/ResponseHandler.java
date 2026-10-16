package com.facebook.stetho.inspector.network;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ResponseHandler {
    void onEOF();

    void onError(IOException iOException);

    void onRead(int i3);

    void onReadDecoded(int i3);
}
