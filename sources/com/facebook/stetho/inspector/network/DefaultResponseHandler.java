package com.facebook.stetho.inspector.network;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultResponseHandler implements ResponseHandler {
    private int mBytesRead = 0;
    private int mDecodedBytesRead = -1;
    private final NetworkEventReporter mEventReporter;
    private final String mRequestId;

    public DefaultResponseHandler(NetworkEventReporter networkEventReporter, String str) {
        this.mEventReporter = networkEventReporter;
        this.mRequestId = str;
    }

    private void reportDataReceived() {
        NetworkEventReporter networkEventReporter = this.mEventReporter;
        String str = this.mRequestId;
        int i3 = this.mBytesRead;
        int i4 = this.mDecodedBytesRead;
        if (i4 < 0) {
            i4 = i3;
        }
        networkEventReporter.dataReceived(str, i3, i4);
    }

    @Override // com.facebook.stetho.inspector.network.ResponseHandler
    public void onEOF() {
        reportDataReceived();
        this.mEventReporter.responseReadFinished(this.mRequestId);
    }

    @Override // com.facebook.stetho.inspector.network.ResponseHandler
    public void onError(IOException iOException) {
        reportDataReceived();
        this.mEventReporter.responseReadFailed(this.mRequestId, iOException.toString());
    }

    @Override // com.facebook.stetho.inspector.network.ResponseHandler
    public void onRead(int i3) {
        this.mBytesRead += i3;
    }

    @Override // com.facebook.stetho.inspector.network.ResponseHandler
    public void onReadDecoded(int i3) {
        if (this.mDecodedBytesRead == -1) {
            this.mDecodedBytesRead = 0;
        }
        this.mDecodedBytesRead += i3;
    }
}
