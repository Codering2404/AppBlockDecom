package com.squareup.okhttp.internal.framed;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.HKJ.pnxuebdT;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import kotlin.comparisons.xn.YvFRmou;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FramedStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f93213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f93214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FramedConnection f93215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f93216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f93217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FramedDataSource f93218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final FramedDataSink f93219h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f93212a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final StreamTimeout f93220i = new StreamTimeout();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final StreamTimeout f93221j = new StreamTimeout();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ErrorCode f93222k = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class FramedDataSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f93223a = new Buffer();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f93224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f93225c;

        FramedDataSink() {
        }

        /* JADX WARN: Finally extract failed */
        private void f(boolean z2) throws IOException {
            long jMin;
            FramedStream framedStream;
            synchronized (FramedStream.this) {
                FramedStream.this.f93221j.x();
                while (true) {
                    try {
                        FramedStream framedStream2 = FramedStream.this;
                        if (framedStream2.f93213b > 0 || this.f93225c || this.f93224b || framedStream2.f93222k != null) {
                            break;
                        } else {
                            FramedStream.this.z();
                        }
                    } catch (Throwable th) {
                        FramedStream.this.f93221j.E();
                        throw th;
                    }
                }
                FramedStream.this.f93221j.E();
                FramedStream.this.k();
                jMin = Math.min(FramedStream.this.f93213b, this.f93223a.size());
                framedStream = FramedStream.this;
                framedStream.f93213b -= jMin;
            }
            framedStream.f93221j.x();
            try {
                FramedStream.this.f93215d.w1(FramedStream.this.f93214c, z2 && jMin == this.f93223a.size(), this.f93223a, jMin);
                FramedStream.this.f93221j.E();
            } catch (Throwable th2) {
                FramedStream.this.f93221j.E();
                throw th2;
            }
        }

        @Override // okio.Sink
        public void H0(Buffer buffer, long j3) throws IOException {
            this.f93223a.H0(buffer, j3);
            while (this.f93223a.size() >= 16384) {
                f(false);
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (FramedStream.this) {
                try {
                    if (this.f93224b) {
                        return;
                    }
                    if (!FramedStream.this.f93219h.f93225c) {
                        if (this.f93223a.size() > 0) {
                            while (this.f93223a.size() > 0) {
                                f(true);
                            }
                        } else {
                            FramedStream.this.f93215d.w1(FramedStream.this.f93214c, true, null, 0L);
                        }
                    }
                    synchronized (FramedStream.this) {
                        this.f93224b = true;
                    }
                    FramedStream.this.f93215d.flush();
                    FramedStream.this.j();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (FramedStream.this) {
                FramedStream.this.k();
            }
            while (this.f93223a.size() > 0) {
                f(false);
                FramedStream.this.f93215d.flush();
            }
        }

        @Override // okio.Sink
        public Timeout v() {
            return FramedStream.this.f93221j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FramedDataSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f93227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Buffer f93228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f93229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f93230d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f93231f;

        private void f() throws IOException {
            if (this.f93230d) {
                throw new IOException("stream closed");
            }
            if (FramedStream.this.f93222k == null) {
                return;
            }
            throw new IOException("stream was reset: " + FramedStream.this.f93222k);
        }

        private void j() throws IOException {
            FramedStream.this.f93220i.x();
            while (this.f93228b.size() == 0 && !this.f93231f && !this.f93230d && FramedStream.this.f93222k == null) {
                try {
                    FramedStream.this.z();
                } finally {
                    FramedStream.this.f93220i.E();
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (FramedStream.this) {
                this.f93230d = true;
                this.f93228b.a();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.j();
        }

        void i(BufferedSource bufferedSource, long j3) throws EOFException {
            boolean z2;
            boolean z3;
            while (j3 > 0) {
                synchronized (FramedStream.this) {
                    z2 = this.f93231f;
                    z3 = this.f93228b.size() + j3 > this.f93229c;
                }
                if (z3) {
                    bufferedSource.skip(j3);
                    FramedStream.this.n(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z2) {
                    bufferedSource.skip(j3);
                    return;
                }
                long jT2 = bufferedSource.t2(this.f93227a, j3);
                if (jT2 == -1) {
                    throw new EOFException();
                }
                j3 -= jT2;
                synchronized (FramedStream.this) {
                    try {
                        boolean z4 = this.f93228b.size() == 0;
                        this.f93228b.K0(this.f93227a);
                        if (z4) {
                            FramedStream.this.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // okio.Source
        public long t2(Buffer buffer, long j3) {
            if (j3 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
            synchronized (FramedStream.this) {
                try {
                    j();
                    f();
                    if (this.f93228b.size() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.f93228b;
                    long jT2 = buffer2.t2(buffer, Math.min(j3, buffer2.size()));
                    FramedStream framedStream = FramedStream.this;
                    long j4 = framedStream.f93212a + jT2;
                    framedStream.f93212a = j4;
                    if (j4 >= framedStream.f93215d.f93162q.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2) {
                        FramedStream.this.f93215d.L1(FramedStream.this.f93214c, FramedStream.this.f93212a);
                        FramedStream.this.f93212a = 0L;
                    }
                    synchronized (FramedStream.this.f93215d) {
                        try {
                            FramedStream.this.f93215d.f93160o += jT2;
                            if (FramedStream.this.f93215d.f93160o >= FramedStream.this.f93215d.f93162q.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2) {
                                FramedStream.this.f93215d.L1(0, FramedStream.this.f93215d.f93160o);
                                FramedStream.this.f93215d.f93160o = 0L;
                            }
                        } finally {
                        }
                    }
                    return jT2;
                } finally {
                }
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return FramedStream.this.f93220i;
        }

        private FramedDataSource(long j3) {
            this.f93227a = new Buffer();
            this.f93228b = new Buffer();
            this.f93229c = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        protected void D() {
            FramedStream.this.n(ErrorCode.CANCEL);
        }

        public void E() throws IOException {
            if (y()) {
                throw z(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException z(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    FramedStream(int i3, FramedConnection framedConnection, boolean z2, boolean z3, List list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f93214c = i3;
        this.f93215d = framedConnection;
        this.f93213b = framedConnection.f93163r.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        FramedDataSource framedDataSource = new FramedDataSource(framedConnection.f93162q.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        this.f93218g = framedDataSource;
        FramedDataSink framedDataSink = new FramedDataSink();
        this.f93219h = framedDataSink;
        framedDataSource.f93231f = z3;
        framedDataSink.f93225c = z2;
        this.f93216e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        boolean z2;
        boolean zT;
        synchronized (this) {
            try {
                z2 = !this.f93218g.f93231f && this.f93218g.f93230d && (this.f93219h.f93225c || this.f93219h.f93224b);
                zT = t();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            l(ErrorCode.CANCEL);
        } else {
            if (zT) {
                return;
            }
            this.f93215d.i1(this.f93214c);
        }
    }

    private boolean m(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f93222k != null) {
                    return false;
                }
                if (this.f93218g.f93231f && this.f93219h.f93225c) {
                    return false;
                }
                this.f93222k = errorCode;
                notifyAll();
                this.f93215d.i1(this.f93214c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public Timeout A() {
        return this.f93221j;
    }

    void i(long j3) {
        this.f93213b += j3;
        if (j3 > 0) {
            notifyAll();
        }
    }

    public void l(ErrorCode errorCode) {
        if (m(errorCode)) {
            this.f93215d.I1(this.f93214c, errorCode);
        }
    }

    public void n(ErrorCode errorCode) {
        if (m(errorCode)) {
            this.f93215d.K1(this.f93214c, errorCode);
        }
    }

    public int o() {
        return this.f93214c;
    }

    public synchronized List p() {
        List list;
        try {
            this.f93220i.x();
            while (this.f93217f == null && this.f93222k == null) {
                try {
                    z();
                } catch (Throwable th) {
                    this.f93220i.E();
                    throw th;
                }
            }
            this.f93220i.E();
            list = this.f93217f;
            if (list == null) {
                throw new IOException(pnxuebdT.AXKvXPDVIHOkQMw + this.f93222k);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return list;
    }

    public Sink q() {
        synchronized (this) {
            try {
                if (this.f93217f == null && !s()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f93219h;
    }

    public Source r() {
        return this.f93218g;
    }

    public boolean s() {
        return this.f93215d.f93148b == ((this.f93214c & 1) == 1);
    }

    public synchronized boolean t() {
        try {
            if (this.f93222k != null) {
                return false;
            }
            if (this.f93218g.f93231f || this.f93218g.f93230d) {
                if (this.f93219h.f93225c || this.f93219h.f93224b) {
                    if (this.f93217f != null) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public Timeout u() {
        return this.f93220i;
    }

    void v(BufferedSource bufferedSource, int i3) throws EOFException {
        this.f93218g.i(bufferedSource, i3);
    }

    void w() {
        boolean zT;
        synchronized (this) {
            this.f93218g.f93231f = true;
            zT = t();
            notifyAll();
        }
        if (zT) {
            return;
        }
        this.f93215d.i1(this.f93214c);
    }

    void x(List list, HeadersMode headersMode) {
        ErrorCode errorCode;
        boolean zT;
        synchronized (this) {
            try {
                errorCode = null;
                zT = true;
                if (this.f93217f == null) {
                    if (headersMode.a()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f93217f = list;
                        zT = t();
                        notifyAll();
                    }
                } else if (headersMode.b()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f93217f);
                    arrayList.addAll(list);
                    this.f93217f = arrayList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (errorCode != null) {
            n(errorCode);
        } else {
            if (zT) {
                return;
            }
            this.f93215d.i1(this.f93214c);
        }
    }

    synchronized void y(ErrorCode errorCode) {
        if (this.f93222k == null) {
            this.f93222k = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        if (this.f93219h.f93224b) {
            throw new IOException("stream closed");
        }
        if (this.f93219h.f93225c) {
            throw new IOException("stream finished");
        }
        if (this.f93222k == null) {
            return;
        }
        throw new IOException(YvFRmou.oUrScTwQ + this.f93222k);
    }
}
