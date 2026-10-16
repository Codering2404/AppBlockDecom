package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RetryableSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f93404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f93405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Buffer f93406c;

    public RetryableSink(int i3) {
        this.f93406c = new Buffer();
        this.f93405b = i3;
    }

    @Override // okio.Sink
    public void H0(Buffer buffer, long j3) throws ProtocolException {
        if (this.f93404a) {
            throw new IllegalStateException("closed");
        }
        Util.a(buffer.size(), 0L, j3);
        if (this.f93405b == -1 || this.f93406c.size() <= ((long) this.f93405b) - j3) {
            this.f93406c.H0(buffer, j3);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f93405b + " bytes");
    }

    public long a() {
        return this.f93406c.size();
    }

    public void b(Sink sink) {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f93406c;
        buffer2.j(buffer, 0L, buffer2.size());
        sink.H0(buffer, buffer.size());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws ProtocolException {
        if (this.f93404a) {
            return;
        }
        this.f93404a = true;
        if (this.f93406c.size() >= this.f93405b) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.f93405b + " bytes, but received " + this.f93406c.size());
    }

    @Override // okio.Sink
    public Timeout v() {
        return Timeout.f145128e;
    }

    public RetryableSink() {
        this(-1);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }
}
