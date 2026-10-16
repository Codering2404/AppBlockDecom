package com.squareup.okhttp.internal;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class FaultHidingSink extends ForwardingSink {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f93096b;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void H0(Buffer buffer, long j3) throws EOFException {
        if (this.f93096b) {
            buffer.skip(j3);
            return;
        }
        try {
            super.H0(buffer, j3);
        } catch (IOException e3) {
            this.f93096b = true;
            a(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f93096b) {
            return;
        }
        try {
            super.close();
        } catch (IOException e3) {
            this.f93096b = true;
            a(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f93096b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e3) {
            this.f93096b = true;
            a(e3);
        }
    }

    protected void a(IOException iOException) {
    }
}
