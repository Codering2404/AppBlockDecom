package com.squareup.okhttp.internal.io;

import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.common.Constants;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RealConnection implements Connection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Route f93428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Socket f93429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f93430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handshake f93431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Protocol f93432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile FramedConnection f93433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f93434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BufferedSource f93435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BufferedSink f93436i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f93438k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f93437j = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f93439l = Long.MAX_VALUE;

    public RealConnection(Route route) {
        this.f93428a = route;
    }

    private void d(int i3, int i4, int i5, ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        this.f93429b.setSoTimeout(i4);
        try {
            Platform.f().d(this.f93429b, this.f93428a.c(), i3);
            this.f93435h = Okio.d(Okio.m(this.f93429b));
            this.f93436i = Okio.c(Okio.i(this.f93429b));
            if (this.f93428a.a().j() != null) {
                e(i4, i5, connectionSpecSelector);
            } else {
                this.f93432e = Protocol.HTTP_1_1;
                this.f93430c = this.f93429b;
            }
            Protocol protocol = this.f93432e;
            if (protocol == Protocol.SPDY_3 || protocol == Protocol.HTTP_2) {
                this.f93430c.setSoTimeout(0);
                FramedConnection framedConnectionI = new FramedConnection.Builder(true).k(this.f93430c, this.f93428a.a().m().q(), this.f93435h, this.f93436i).j(this.f93432e).i();
                framedConnectionI.o1();
                this.f93433f = framedConnectionI;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.f93428a.c());
        }
    }

    private void e(int i3, int i4, ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        SSLSocket sSLSocket;
        if (this.f93428a.d()) {
            f(i3, i4);
        }
        Address addressA = this.f93428a.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) addressA.j().createSocket(this.f93429b, addressA.k(), addressA.l(), true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
        try {
            ConnectionSpec connectionSpecA = connectionSpecSelector.a(sSLSocket);
            if (connectionSpecA.j()) {
                Platform.f().c(sSLSocket, addressA.k(), addressA.f());
            }
            sSLSocket.startHandshake();
            Handshake handshakeC = Handshake.c(sSLSocket.getSession());
            if (addressA.e().verify(addressA.k(), sSLSocket.getSession())) {
                addressA.b().a(addressA.k(), handshakeC.e());
                String strH = connectionSpecA.j() ? Platform.f().h(sSLSocket) : null;
                this.f93430c = sSLSocket;
                this.f93435h = Okio.d(Okio.m(sSLSocket));
                this.f93436i = Okio.c(Okio.i(this.f93430c));
                this.f93431d = handshakeC;
                this.f93432e = strH != null ? Protocol.a(strH) : Protocol.HTTP_1_1;
                Platform.f().a(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) handshakeC.e().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + addressA.k() + " not verified:\n    certificate: " + CertificatePinner.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.a(x509Certificate));
        } catch (AssertionError e4) {
            e = e4;
            if (!Util.o(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                Platform.f().a(sSLSocket2);
            }
            Util.d(sSLSocket2);
            throw th;
        }
    }

    private void f(int i3, int i4) throws IOException {
        Request requestG = g();
        HttpUrl httpUrlK = requestG.k();
        String str = "CONNECT " + httpUrlK.q() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + httpUrlK.A() + " HTTP/1.1";
        do {
            Http1xStream http1xStream = new Http1xStream(null, this.f93435h, this.f93436i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f93435h.v().h(i3, timeUnit);
            this.f93436i.v().h(i4, timeUnit);
            http1xStream.w(requestG.i(), str);
            http1xStream.a();
            Response responseM = http1xStream.v().y(requestG).m();
            long jE = OkHeaders.e(responseM);
            if (jE == -1) {
                jE = 0;
            }
            Source sourceS = http1xStream.s(jE);
            Util.r(sourceS, Api.BaseClientBuilder.API_PRIORITY_OTHER, timeUnit);
            sourceS.close();
            int iN = responseM.n();
            if (iN == 200) {
                if (!this.f93435h.s().G1() || !this.f93436i.s().G1()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else {
                if (iN != 407) {
                    throw new IOException("Unexpected response code for CONNECT: " + responseM.n());
                }
                requestG = OkHeaders.j(this.f93428a.a().a(), responseM, this.f93428a.b());
            }
        } while (requestG != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request g() {
        return new Request.Builder().l(this.f93428a.a().m()).h("Host", Util.i(this.f93428a.a().m())).h("Proxy-Connection", "Keep-Alive").h(GraphRequest.USER_AGENT_HEADER, Version.a()).g();
    }

    @Override // com.squareup.okhttp.Connection
    public Route a() {
        return this.f93428a;
    }

    public int b() {
        FramedConnection framedConnection = this.f93433f;
        if (framedConnection != null) {
            return framedConnection.w0();
        }
        return 1;
    }

    public void c(int i3, int i4, int i5, List list, boolean z2) {
        if (this.f93432e != null) {
            throw new IllegalStateException("already connected");
        }
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Proxy proxyB = this.f93428a.b();
        Address addressA = this.f93428a.a();
        if (this.f93428a.a().j() == null && !list.contains(ConnectionSpec.f92900h)) {
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        RouteException routeException = null;
        while (this.f93432e == null) {
            try {
                this.f93429b = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? addressA.i().createSocket() : new Socket(proxyB);
                d(i3, i4, i5, connectionSpecSelector);
            } catch (IOException e3) {
                Util.d(this.f93430c);
                Util.d(this.f93429b);
                this.f93430c = null;
                this.f93429b = null;
                this.f93435h = null;
                this.f93436i = null;
                this.f93431d = null;
                this.f93432e = null;
                if (routeException == null) {
                    routeException = new RouteException(e3);
                } else {
                    routeException.a(e3);
                }
                if (!z2) {
                    throw routeException;
                }
                if (!connectionSpecSelector.b(e3)) {
                    throw routeException;
                }
            }
        }
    }

    public Handshake h() {
        return this.f93431d;
    }

    public Socket i() {
        return this.f93430c;
    }

    public boolean j(boolean z2) {
        if (this.f93430c.isClosed() || this.f93430c.isInputShutdown() || this.f93430c.isOutputShutdown()) {
            return false;
        }
        if (this.f93433f == null && z2) {
            try {
                int soTimeout = this.f93430c.getSoTimeout();
                try {
                    this.f93430c.setSoTimeout(1);
                    return !this.f93435h.G1();
                } finally {
                    this.f93430c.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f93428a.a().m().q());
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(this.f93428a.a().m().A());
        sb.append(", proxy=");
        sb.append(this.f93428a.b());
        sb.append(" hostAddress=");
        sb.append(this.f93428a.c());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f93431d;
        sb.append(handshake != null ? handshake.a() : IntegrityManager.INTEGRITY_TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.f93432e);
        sb.append('}');
        return sb.toString();
    }
}
