package com.facebook.stetho.websocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WriteHandler {
    private final BufferedOutputStream mBufferedOutput;

    public WriteHandler(OutputStream outputStream) {
        this.mBufferedOutput = new BufferedOutputStream(outputStream, 1024);
    }

    public synchronized void write(Frame frame, WriteCallback writeCallback) {
        try {
            frame.writeTo(this.mBufferedOutput);
            this.mBufferedOutput.flush();
            writeCallback.onSuccess();
        } catch (IOException e3) {
            writeCallback.onFailure(e3);
        }
    }
}
