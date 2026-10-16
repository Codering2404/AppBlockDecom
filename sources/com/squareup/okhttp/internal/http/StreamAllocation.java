package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class StreamAllocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f93421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionPool f93422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RouteSelector f93423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RealConnection f93424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f93425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f93426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HttpStream f93427g;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.f93422b = connectionPool;
        this.f93421a = address;
    }

    private void d(IOException iOException) {
        synchronized (this.f93422b) {
            try {
                if (this.f93423c != null) {
                    RealConnection realConnection = this.f93424d;
                    if (realConnection.f93434g == 0) {
                        this.f93423c.a(realConnection.a(), iOException);
                    } else {
                        this.f93423c = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(boolean r3, boolean r4, boolean r5) {
        /*
            r2 = this;
            com.squareup.okhttp.ConnectionPool r0 = r2.f93422b
            monitor-enter(r0)
            r1 = 0
            if (r5 == 0) goto Lb
            r2.f93427g = r1     // Catch: java.lang.Throwable -> L9
            goto Lb
        L9:
            r3 = move-exception
            goto L5d
        Lb:
            r5 = 1
            if (r4 == 0) goto L10
            r2.f93425e = r5     // Catch: java.lang.Throwable -> L9
        L10:
            com.squareup.okhttp.internal.io.RealConnection r4 = r2.f93424d     // Catch: java.lang.Throwable -> L9
            if (r4 == 0) goto L52
            if (r3 == 0) goto L18
            r4.f93438k = r5     // Catch: java.lang.Throwable -> L9
        L18:
            com.squareup.okhttp.internal.http.HttpStream r3 = r2.f93427g     // Catch: java.lang.Throwable -> L9
            if (r3 != 0) goto L52
            boolean r3 = r2.f93425e     // Catch: java.lang.Throwable -> L9
            if (r3 != 0) goto L24
            boolean r3 = r4.f93438k     // Catch: java.lang.Throwable -> L9
            if (r3 == 0) goto L52
        L24:
            r2.o(r4)     // Catch: java.lang.Throwable -> L9
            com.squareup.okhttp.internal.io.RealConnection r3 = r2.f93424d     // Catch: java.lang.Throwable -> L9
            int r4 = r3.f93434g     // Catch: java.lang.Throwable -> L9
            if (r4 <= 0) goto L2f
            r2.f93423c = r1     // Catch: java.lang.Throwable -> L9
        L2f:
            java.util.List r3 = r3.f93437j     // Catch: java.lang.Throwable -> L9
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L9
            if (r3 == 0) goto L4e
            com.squareup.okhttp.internal.io.RealConnection r3 = r2.f93424d     // Catch: java.lang.Throwable -> L9
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L9
            r3.f93439l = r4     // Catch: java.lang.Throwable -> L9
            com.squareup.okhttp.internal.Internal r3 = com.squareup.okhttp.internal.Internal.f93098b     // Catch: java.lang.Throwable -> L9
            com.squareup.okhttp.ConnectionPool r4 = r2.f93422b     // Catch: java.lang.Throwable -> L9
            com.squareup.okhttp.internal.io.RealConnection r5 = r2.f93424d     // Catch: java.lang.Throwable -> L9
            boolean r3 = r3.c(r4, r5)     // Catch: java.lang.Throwable -> L9
            if (r3 == 0) goto L4e
            com.squareup.okhttp.internal.io.RealConnection r3 = r2.f93424d     // Catch: java.lang.Throwable -> L9
            goto L4f
        L4e:
            r3 = r1
        L4f:
            r2.f93424d = r1     // Catch: java.lang.Throwable -> L9
            r1 = r3
        L52:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            if (r1 == 0) goto L5c
            java.net.Socket r3 = r1.i()
            com.squareup.okhttp.internal.Util.d(r3)
        L5c:
            return
        L5d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.StreamAllocation.e(boolean, boolean, boolean):void");
    }

    private RealConnection f(int i3, int i4, int i5, boolean z2) {
        synchronized (this.f93422b) {
            try {
                if (this.f93425e) {
                    throw new IllegalStateException("released");
                }
                if (this.f93427g != null) {
                    throw new IllegalStateException("stream != null");
                }
                if (this.f93426f) {
                    throw new IOException("Canceled");
                }
                RealConnection realConnection = this.f93424d;
                if (realConnection != null && !realConnection.f93438k) {
                    return realConnection;
                }
                RealConnection realConnectionD = Internal.f93098b.d(this.f93422b, this.f93421a, this);
                if (realConnectionD != null) {
                    this.f93424d = realConnectionD;
                    return realConnectionD;
                }
                if (this.f93423c == null) {
                    this.f93423c = new RouteSelector(this.f93421a, p());
                }
                RealConnection realConnection2 = new RealConnection(this.f93423c.g());
                a(realConnection2);
                synchronized (this.f93422b) {
                    Internal.f93098b.f(this.f93422b, realConnection2);
                    this.f93424d = realConnection2;
                    if (this.f93426f) {
                        throw new IOException("Canceled");
                    }
                }
                realConnection2.c(i3, i4, i5, this.f93421a.c(), z2);
                p().a(realConnection2.a());
                return realConnection2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private RealConnection g(int i3, int i4, int i5, boolean z2, boolean z3) {
        while (true) {
            RealConnection realConnectionF = f(i3, i4, i5, z2);
            synchronized (this.f93422b) {
                try {
                    if (realConnectionF.f93434g == 0) {
                        return realConnectionF;
                    }
                    if (realConnectionF.j(z3)) {
                        return realConnectionF;
                    }
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean h(RouteException routeException) {
        IOException iOExceptionC = routeException.c();
        if (iOExceptionC instanceof ProtocolException) {
            return false;
        }
        return iOExceptionC instanceof InterruptedIOException ? iOExceptionC instanceof SocketTimeoutException : (((iOExceptionC instanceof SSLHandshakeException) && (iOExceptionC.getCause() instanceof CertificateException)) || (iOExceptionC instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean i(IOException iOException) {
        return ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    private void o(RealConnection realConnection) {
        int size = realConnection.f93437j.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((Reference) realConnection.f93437j.get(i3)).get() == this) {
                realConnection.f93437j.remove(i3);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private RouteDatabase p() {
        return Internal.f93098b.g(this.f93422b);
    }

    public void a(RealConnection realConnection) {
        realConnection.f93437j.add(new WeakReference(this));
    }

    public synchronized RealConnection b() {
        return this.f93424d;
    }

    public void c() {
        e(true, false, true);
    }

    public HttpStream j(int i3, int i4, int i5, boolean z2, boolean z3) throws RouteException {
        HttpStream http1xStream;
        try {
            RealConnection realConnectionG = g(i3, i4, i5, z2, z3);
            try {
                if (realConnectionG.f93433f != null) {
                    http1xStream = new Http2xStream(this, realConnectionG.f93433f);
                } else {
                    realConnectionG.i().setSoTimeout(i4);
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    realConnectionG.f93435h.v().h(i4, timeUnit);
                    realConnectionG.f93436i.v().h(i5, timeUnit);
                    http1xStream = new Http1xStream(this, realConnectionG.f93435h, realConnectionG.f93436i);
                }
                synchronized (this.f93422b) {
                    realConnectionG.f93434g++;
                    this.f93427g = http1xStream;
                }
                return http1xStream;
            } catch (IOException e3) {
                e = e3;
                throw new RouteException(e);
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    public void k() {
        e(true, false, false);
    }

    public boolean l(RouteException routeException) {
        if (this.f93424d != null) {
            d(routeException.c());
        }
        RouteSelector routeSelector = this.f93423c;
        return (routeSelector == null || routeSelector.c()) && h(routeException);
    }

    public boolean m(IOException iOException, Sink sink) {
        RealConnection realConnection = this.f93424d;
        if (realConnection != null) {
            int i3 = realConnection.f93434g;
            d(iOException);
            if (i3 == 1) {
                return false;
            }
        }
        boolean z2 = sink == null || (sink instanceof RetryableSink);
        RouteSelector routeSelector = this.f93423c;
        return (routeSelector == null || routeSelector.c()) && i(iOException) && z2;
    }

    public void n() {
        e(false, true, false);
    }

    public void q(HttpStream httpStream) {
        synchronized (this.f93422b) {
            if (httpStream != null) {
                if (httpStream == this.f93427g) {
                }
            }
            throw new IllegalStateException("expected " + this.f93427g + " but was " + httpStream);
        }
        e(false, false, true);
    }

    public String toString() {
        return this.f93421a.toString();
    }
}
