package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Http1xStream implements HttpStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreamAllocation f93325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSource f93326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BufferedSink f93327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpEngine f93328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f93329e = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class AbstractSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final ForwardingTimeout f93330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f93331b;

        private AbstractSource() {
            this.f93330a = new ForwardingTimeout(Http1xStream.this.f93326b.v());
        }

        protected final void a() {
            if (Http1xStream.this.f93329e != 5) {
                throw new IllegalStateException("state: " + Http1xStream.this.f93329e);
            }
            Http1xStream.this.n(this.f93330a);
            Http1xStream.this.f93329e = 6;
            if (Http1xStream.this.f93325a != null) {
                Http1xStream.this.f93325a.q(Http1xStream.this);
            }
        }

        protected final void b() {
            if (Http1xStream.this.f93329e == 6) {
                return;
            }
            Http1xStream.this.f93329e = 6;
            if (Http1xStream.this.f93325a != null) {
                Http1xStream.this.f93325a.k();
                Http1xStream.this.f93325a.q(Http1xStream.this);
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f93330a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ChunkedSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f93333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f93334b;

        private ChunkedSink() {
            this.f93333a = new ForwardingTimeout(Http1xStream.this.f93327c.v());
        }

        @Override // okio.Sink
        public void H0(Buffer buffer, long j3) {
            if (this.f93334b) {
                throw new IllegalStateException("closed");
            }
            if (j3 == 0) {
                return;
            }
            Http1xStream.this.f93327c.e2(j3);
            Http1xStream.this.f93327c.C0("\r\n");
            Http1xStream.this.f93327c.H0(buffer, j3);
            Http1xStream.this.f93327c.C0("\r\n");
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f93334b) {
                return;
            }
            this.f93334b = true;
            Http1xStream.this.f93327c.C0("0\r\n\r\n");
            Http1xStream.this.n(this.f93333a);
            Http1xStream.this.f93329e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f93334b) {
                return;
            }
            Http1xStream.this.f93327c.flush();
        }

        @Override // okio.Sink
        public Timeout v() {
            return this.f93333a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ChunkedSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f93336d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f93337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HttpEngine f93338g;

        ChunkedSource(HttpEngine httpEngine) {
            super();
            this.f93336d = -1L;
            this.f93337f = true;
            this.f93338g = httpEngine;
        }

        private void c() throws IOException {
            if (this.f93336d != -1) {
                Http1xStream.this.f93326b.Q0();
            }
            try {
                this.f93336d = Http1xStream.this.f93326b.F2();
                String strTrim = Http1xStream.this.f93326b.Q0().trim();
                if (this.f93336d < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f93336d + strTrim + "\"");
                }
                if (this.f93336d == 0) {
                    this.f93337f = false;
                    this.f93338g.s(Http1xStream.this.u());
                    a();
                }
            } catch (NumberFormatException e3) {
                throw new ProtocolException(e3.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f93331b) {
                return;
            }
            if (this.f93337f && !Util.g(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f93331b = true;
        }

        @Override // okio.Source
        public long t2(Buffer buffer, long j3) throws IOException {
            if (j3 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
            if (this.f93331b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f93337f) {
                return -1L;
            }
            long j4 = this.f93336d;
            if (j4 == 0 || j4 == -1) {
                c();
                if (!this.f93337f) {
                    return -1L;
                }
            }
            long jT2 = Http1xStream.this.f93326b.t2(buffer, Math.min(j3, this.f93336d));
            if (jT2 != -1) {
                this.f93336d -= jT2;
                return jT2;
            }
            b();
            throw new ProtocolException("unexpected end of stream");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FixedLengthSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f93340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f93341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f93342c;

        @Override // okio.Sink
        public void H0(Buffer buffer, long j3) throws ProtocolException {
            if (this.f93341b) {
                throw new IllegalStateException("closed");
            }
            Util.a(buffer.size(), 0L, j3);
            if (j3 <= this.f93342c) {
                Http1xStream.this.f93327c.H0(buffer, j3);
                this.f93342c -= j3;
                return;
            }
            throw new ProtocolException("expected " + this.f93342c + " bytes but received " + j3);
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (this.f93341b) {
                return;
            }
            this.f93341b = true;
            if (this.f93342c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1xStream.this.n(this.f93340a);
            Http1xStream.this.f93329e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f93341b) {
                return;
            }
            Http1xStream.this.f93327c.flush();
        }

        @Override // okio.Sink
        public Timeout v() {
            return this.f93340a;
        }

        private FixedLengthSink(long j3) {
            this.f93340a = new ForwardingTimeout(Http1xStream.this.f93327c.v());
            this.f93342c = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class FixedLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f93344d;

        public FixedLengthSource(long j3) {
            super();
            this.f93344d = j3;
            if (j3 == 0) {
                a();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f93331b) {
                return;
            }
            if (this.f93344d != 0 && !Util.g(this, 100, TimeUnit.MILLISECONDS)) {
                b();
            }
            this.f93331b = true;
        }

        @Override // okio.Source
        public long t2(Buffer buffer, long j3) throws ProtocolException {
            if (j3 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
            if (this.f93331b) {
                throw new IllegalStateException("closed");
            }
            if (this.f93344d == 0) {
                return -1L;
            }
            long jT2 = Http1xStream.this.f93326b.t2(buffer, Math.min(this.f93344d, j3));
            if (jT2 == -1) {
                b();
                throw new ProtocolException("unexpected end of stream");
            }
            long j4 = this.f93344d - jT2;
            this.f93344d = j4;
            if (j4 == 0) {
                a();
            }
            return jT2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class UnknownLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f93346d;

        private UnknownLengthSource() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f93331b) {
                return;
            }
            if (!this.f93346d) {
                b();
            }
            this.f93331b = true;
        }

        @Override // okio.Source
        public long t2(Buffer buffer, long j3) {
            if (j3 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
            if (this.f93331b) {
                throw new IllegalStateException("closed");
            }
            if (this.f93346d) {
                return -1L;
            }
            long jT2 = Http1xStream.this.f93326b.t2(buffer, j3);
            if (jT2 != -1) {
                return jT2;
            }
            this.f93346d = true;
            a();
            return -1L;
        }
    }

    public Http1xStream(StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f93325a = streamAllocation;
        this.f93326b = bufferedSource;
        this.f93327c = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutK = forwardingTimeout.k();
        forwardingTimeout.l(Timeout.f145128e);
        timeoutK.b();
        timeoutK.c();
    }

    private Source o(Response response) {
        if (!HttpEngine.m(response)) {
            return s(0L);
        }
        if ("chunked".equalsIgnoreCase(response.p("Transfer-Encoding"))) {
            return q(this.f93328d);
        }
        long jE = OkHeaders.e(response);
        return jE != -1 ? s(jE) : t();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void a() {
        this.f93327c.flush();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink b(Request request, long j3) {
        if ("chunked".equalsIgnoreCase(request.h("Transfer-Encoding"))) {
            return p();
        }
        if (j3 != -1) {
            return r(j3);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void c(Request request) {
        this.f93328d.B();
        w(request.i(), RequestLine.a(request, this.f93328d.j().a().b().type()));
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void d(RetryableSink retryableSink) {
        if (this.f93329e == 1) {
            this.f93329e = 3;
            retryableSink.b(this.f93327c);
        } else {
            throw new IllegalStateException("state: " + this.f93329e);
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder e() {
        return v();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody f(Response response) {
        return new RealResponseBody(response.r(), Okio.d(o(response)));
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void g(HttpEngine httpEngine) {
        this.f93328d = httpEngine;
    }

    public Sink p() {
        if (this.f93329e == 1) {
            this.f93329e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.f93329e);
    }

    public Source q(HttpEngine httpEngine) {
        if (this.f93329e == 4) {
            this.f93329e = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.f93329e);
    }

    public Sink r(long j3) {
        if (this.f93329e == 1) {
            this.f93329e = 2;
            return new FixedLengthSink(j3);
        }
        throw new IllegalStateException("state: " + this.f93329e);
    }

    public Source s(long j3) {
        if (this.f93329e == 4) {
            this.f93329e = 5;
            return new FixedLengthSource(j3);
        }
        throw new IllegalStateException("state: " + this.f93329e);
    }

    public Source t() {
        if (this.f93329e != 4) {
            throw new IllegalStateException("state: " + this.f93329e);
        }
        StreamAllocation streamAllocation = this.f93325a;
        if (streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f93329e = 5;
        streamAllocation.k();
        return new UnknownLengthSource();
    }

    public Headers u() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String strQ0 = this.f93326b.Q0();
            if (strQ0.length() == 0) {
                return builder.e();
            }
            Internal.f93098b.a(builder, strQ0);
        }
    }

    public Response.Builder v() throws IOException {
        StatusLine statusLineA;
        Response.Builder builderT;
        int i3 = this.f93329e;
        if (i3 != 1 && i3 != 3) {
            throw new IllegalStateException("state: " + this.f93329e);
        }
        do {
            try {
                statusLineA = StatusLine.a(this.f93326b.Q0());
                builderT = new Response.Builder().x(statusLineA.f93418a).q(statusLineA.f93419b).u(statusLineA.f93420c).t(u());
            } catch (EOFException e3) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f93325a);
                iOException.initCause(e3);
                throw iOException;
            }
        } while (statusLineA.f93419b == 100);
        this.f93329e = 4;
        return builderT;
    }

    public void w(Headers headers, String str) {
        if (this.f93329e != 0) {
            throw new IllegalStateException("state: " + this.f93329e);
        }
        this.f93327c.C0(str).C0("\r\n");
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            this.f93327c.C0(headers.d(i3)).C0(": ").C0(headers.g(i3)).C0("\r\n");
        }
        this.f93327c.C0("\r\n");
        this.f93329e = 1;
    }
}
