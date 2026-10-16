package com.squareup.okhttp.internal.http;

import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpEngine {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ResponseBody f93369r = new ResponseBody() { // from class: com.squareup.okhttp.internal.http.HttpEngine.1
        @Override // com.squareup.okhttp.ResponseBody
        public long a() {
            return 0L;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource b() {
            return new Buffer();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final OkHttpClient f93370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StreamAllocation f93371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Response f93372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpStream f93373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f93374e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f93375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f93376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Request f93377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Request f93378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Response f93379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Response f93380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Sink f93381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BufferedSink f93382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f93383n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f93384o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CacheRequest f93385p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CacheStrategy f93386q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class NetworkInterceptorChain implements Interceptor.Chain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f93392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Request f93393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f93394c;

        NetworkInterceptorChain(int i3, Request request) {
            this.f93392a = i3;
            this.f93393b = request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response a(Request request) throws ProtocolException {
            this.f93394c++;
            if (this.f93392a > 0) {
                Interceptor interceptor = (Interceptor) HttpEngine.this.f93370a.A().get(this.f93392a - 1);
                Address addressA = b().a().a();
                if (!request.k().q().equals(addressA.k()) || request.k().A() != addressA.l()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
                if (this.f93394c > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.f93392a < HttpEngine.this.f93370a.A().size()) {
                NetworkInterceptorChain networkInterceptorChain = HttpEngine.this.new NetworkInterceptorChain(this.f93392a + 1, request);
                Interceptor interceptor2 = (Interceptor) HttpEngine.this.f93370a.A().get(this.f93392a);
                Response responseA = interceptor2.a(networkInterceptorChain);
                if (networkInterceptorChain.f93394c != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                }
                if (responseA != null) {
                    return responseA;
                }
                throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
            }
            HttpEngine.this.f93373d.c(request);
            HttpEngine.this.f93378i = request;
            if (HttpEngine.this.p(request) && request.f() != null) {
                BufferedSink bufferedSinkC = Okio.c(HttpEngine.this.f93373d.b(request, request.f().a()));
                request.f().c(bufferedSinkC);
                bufferedSinkC.close();
            }
            Response responseQ = HttpEngine.this.q();
            int iN = responseQ.n();
            if ((iN != 204 && iN != 205) || responseQ.k().a() <= 0) {
                return responseQ;
            }
            throw new ProtocolException("HTTP " + iN + " had non-zero Content-Length: " + responseQ.k().a());
        }

        public Connection b() {
            return HttpEngine.this.f93371b.b();
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z2, boolean z3, boolean z4, StreamAllocation streamAllocation, RetryableSink retryableSink, Response response) {
        this.f93370a = okHttpClient;
        this.f93377h = request;
        this.f93376g = z2;
        this.f93383n = z3;
        this.f93384o = z4;
        this.f93371b = streamAllocation == null ? new StreamAllocation(okHttpClient.g(), h(okHttpClient, request)) : streamAllocation;
        this.f93381l = retryableSink;
        this.f93372c = response;
    }

    private static boolean A(Response response, Response response2) {
        Date dateC;
        if (response2.n() == 304) {
            return true;
        }
        Date dateC2 = response.r().c("Last-Modified");
        return (dateC2 == null || (dateC = response2.r().c("Last-Modified")) == null || dateC.getTime() >= dateC2.getTime()) ? false : true;
    }

    private Response d(final CacheRequest cacheRequest, Response response) {
        Sink sinkBody;
        if (cacheRequest == null || (sinkBody = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource bufferedSourceB = response.k().b();
        final BufferedSink bufferedSinkC = Okio.c(sinkBody);
        return response.u().l(new RealResponseBody(response.r(), Okio.d(new Source() { // from class: com.squareup.okhttp.internal.http.HttpEngine.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f93387a;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.f93387a && !Util.g(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f93387a = true;
                    cacheRequest.abort();
                }
                bufferedSourceB.close();
            }

            @Override // okio.Source
            public long t2(Buffer buffer, long j3) throws IOException {
                try {
                    long jT2 = bufferedSourceB.t2(buffer, j3);
                    if (jT2 != -1) {
                        buffer.j(bufferedSinkC.s(), buffer.size() - jT2, jT2);
                        bufferedSinkC.o0();
                        return jT2;
                    }
                    if (!this.f93387a) {
                        this.f93387a = true;
                        bufferedSinkC.close();
                    }
                    return -1L;
                } catch (IOException e3) {
                    if (this.f93387a) {
                        throw e3;
                    }
                    this.f93387a = true;
                    cacheRequest.abort();
                    throw e3;
                }
            }

            @Override // okio.Source
            public Timeout v() {
                return bufferedSourceB.v();
            }
        }))).m();
    }

    private static Headers f(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            String strD = headers.d(i3);
            String strG = headers.g(i3);
            if ((!"Warning".equalsIgnoreCase(strD) || !strG.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) && (!OkHeaders.h(strD) || headers2.a(strD) == null)) {
                builder.b(strD, strG);
            }
        }
        int iF2 = headers2.f();
        for (int i4 = 0; i4 < iF2; i4++) {
            String strD2 = headers2.d(i4);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strD2) && OkHeaders.h(strD2)) {
                builder.b(strD2, headers2.g(i4));
            }
        }
        return builder.e();
    }

    private HttpStream g() {
        return this.f93371b.j(this.f93370a.e(), this.f93370a.t(), this.f93370a.x(), this.f93370a.u(), !this.f93378i.m().equals("GET"));
    }

    private static Address h(OkHttpClient okHttpClient, Request request) {
        SSLSocketFactory sSLSocketFactoryW;
        HostnameVerifier hostnameVerifierP;
        CertificatePinner certificatePinnerC;
        if (request.l()) {
            sSLSocketFactoryW = okHttpClient.w();
            hostnameVerifierP = okHttpClient.p();
            certificatePinnerC = okHttpClient.c();
        } else {
            sSLSocketFactoryW = null;
            hostnameVerifierP = null;
            certificatePinnerC = null;
        }
        return new Address(request.k().q(), request.k().A(), okHttpClient.k(), okHttpClient.v(), sSLSocketFactoryW, hostnameVerifierP, certificatePinnerC, okHttpClient.b(), okHttpClient.r(), okHttpClient.q(), okHttpClient.h(), okHttpClient.s());
    }

    public static boolean m(Response response) {
        if (response.w().m().equals("HEAD")) {
            return false;
        }
        int iN = response.n();
        return (((iN >= 100 && iN < 200) || iN == 204 || iN == 304) && OkHeaders.e(response) == -1 && !"chunked".equalsIgnoreCase(response.p("Transfer-Encoding"))) ? false : true;
    }

    private void n() {
        InternalCache internalCacheE = Internal.f93098b.e(this.f93370a);
        if (internalCacheE == null) {
            return;
        }
        if (CacheStrategy.a(this.f93380k, this.f93378i)) {
            this.f93385p = internalCacheE.c(y(this.f93380k));
        } else if (HttpMethod.a(this.f93378i.m())) {
            try {
                internalCacheE.e(this.f93378i);
            } catch (IOException unused) {
            }
        }
    }

    private Request o(Request request) {
        Request.Builder builderN = request.n();
        if (request.h("Host") == null) {
            builderN.h("Host", Util.i(request.k()));
        }
        if (request.h("Connection") == null) {
            builderN.h("Connection", "Keep-Alive");
        }
        if (request.h("Accept-Encoding") == null) {
            this.f93375f = true;
            builderN.h("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandlerI = this.f93370a.i();
        if (cookieHandlerI != null) {
            OkHeaders.a(builderN, cookieHandlerI.get(request.o(), OkHeaders.l(builderN.g().i(), null)));
        }
        if (request.h(GraphRequest.USER_AGENT_HEADER) == null) {
            builderN.h(GraphRequest.USER_AGENT_HEADER, Version.a());
        }
        return builderN.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response q() {
        this.f93373d.a();
        Response responseM = this.f93373d.e().y(this.f93378i).r(this.f93371b.b().h()).s(OkHeaders.f93398c, Long.toString(this.f93374e)).s(OkHeaders.f93399d, Long.toString(System.currentTimeMillis())).m();
        if (!this.f93384o) {
            responseM = responseM.u().l(this.f93373d.f(responseM)).m();
        }
        if (!"close".equalsIgnoreCase(responseM.w().h("Connection")) && !"close".equalsIgnoreCase(responseM.p("Connection"))) {
            return responseM;
        }
        this.f93371b.k();
        return responseM;
    }

    private static Response y(Response response) {
        return (response == null || response.k() == null) ? response : response.u().l(null).m();
    }

    private Response z(Response response) {
        if (!this.f93375f || !"gzip".equalsIgnoreCase(this.f93380k.p(GraphRequest.CONTENT_ENCODING_HEADER)) || response.k() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.k().b());
        Headers headersE = response.r().e().g(GraphRequest.CONTENT_ENCODING_HEADER).g(HttpHeaders.CONTENT_LENGTH).e();
        return response.u().t(headersE).l(new RealResponseBody(headersE, Okio.d(gzipSource))).m();
    }

    public void B() {
        if (this.f93374e != -1) {
            throw new IllegalStateException();
        }
        this.f93374e = System.currentTimeMillis();
    }

    public StreamAllocation e() {
        BufferedSink bufferedSink = this.f93382m;
        if (bufferedSink != null) {
            Util.c(bufferedSink);
        } else {
            Sink sink = this.f93381l;
            if (sink != null) {
                Util.c(sink);
            }
        }
        Response response = this.f93380k;
        if (response != null) {
            Util.c(response.k());
        } else {
            this.f93371b.c();
        }
        return this.f93371b;
    }

    public Request i() throws ProtocolException {
        String strP;
        HttpUrl httpUrlD;
        if (this.f93380k == null) {
            throw new IllegalStateException();
        }
        RealConnection realConnectionB = this.f93371b.b();
        Route routeA = realConnectionB != null ? realConnectionB.a() : null;
        Proxy proxyB = routeA != null ? routeA.b() : this.f93370a.r();
        int iN = this.f93380k.n();
        String strM = this.f93377h.m();
        if (iN != 307 && iN != 308) {
            if (iN != 401) {
                if (iN != 407) {
                    switch (iN) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (proxyB.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            return OkHeaders.j(this.f93370a.b(), this.f93380k, proxyB);
        }
        if (!strM.equals("GET") && !strM.equals("HEAD")) {
            return null;
        }
        if (!this.f93370a.m() || (strP = this.f93380k.p("Location")) == null || (httpUrlD = this.f93377h.k().D(strP)) == null) {
            return null;
        }
        if (!httpUrlD.E().equals(this.f93377h.k().E()) && !this.f93370a.o()) {
            return null;
        }
        Request.Builder builderN = this.f93377h.n();
        if (HttpMethod.b(strM)) {
            if (HttpMethod.c(strM)) {
                builderN.j("GET", null);
            } else {
                builderN.j(strM, null);
            }
            builderN.k("Transfer-Encoding");
            builderN.k(HttpHeaders.CONTENT_LENGTH);
            builderN.k("Content-Type");
        }
        if (!w(httpUrlD)) {
            builderN.k("Authorization");
        }
        return builderN.l(httpUrlD).g();
    }

    public Connection j() {
        return this.f93371b.b();
    }

    public Request k() {
        return this.f93377h;
    }

    public Response l() {
        Response response = this.f93380k;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    boolean p(Request request) {
        return HttpMethod.b(request.m());
    }

    public void r() throws IOException {
        Response responseQ;
        if (this.f93380k != null) {
            return;
        }
        Request request = this.f93378i;
        if (request == null && this.f93379j == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (request == null) {
            return;
        }
        if (this.f93384o) {
            this.f93373d.c(request);
            responseQ = q();
        } else if (this.f93383n) {
            BufferedSink bufferedSink = this.f93382m;
            if (bufferedSink != null && bufferedSink.s().size() > 0) {
                this.f93382m.U();
            }
            if (this.f93374e == -1) {
                if (OkHeaders.d(this.f93378i) == -1) {
                    Sink sink = this.f93381l;
                    if (sink instanceof RetryableSink) {
                        this.f93378i = this.f93378i.n().h(HttpHeaders.CONTENT_LENGTH, Long.toString(((RetryableSink) sink).a())).g();
                    }
                }
                this.f93373d.c(this.f93378i);
            }
            Sink sink2 = this.f93381l;
            if (sink2 != null) {
                BufferedSink bufferedSink2 = this.f93382m;
                if (bufferedSink2 != null) {
                    bufferedSink2.close();
                } else {
                    sink2.close();
                }
                Sink sink3 = this.f93381l;
                if (sink3 instanceof RetryableSink) {
                    this.f93373d.d((RetryableSink) sink3);
                }
            }
            responseQ = q();
        } else {
            responseQ = new NetworkInterceptorChain(0, request).a(this.f93378i);
        }
        s(responseQ.r());
        Response response = this.f93379j;
        if (response != null) {
            if (A(response, responseQ)) {
                this.f93380k = this.f93379j.u().y(this.f93377h).w(y(this.f93372c)).t(f(this.f93379j.r(), responseQ.r())).n(y(this.f93379j)).v(y(responseQ)).m();
                responseQ.k().close();
                v();
                InternalCache internalCacheE = Internal.f93098b.e(this.f93370a);
                internalCacheE.d();
                internalCacheE.b(this.f93379j, y(this.f93380k));
                this.f93380k = z(this.f93380k);
                return;
            }
            Util.c(this.f93379j.k());
        }
        Response responseM = responseQ.u().y(this.f93377h).w(y(this.f93372c)).n(y(this.f93379j)).v(y(responseQ)).m();
        this.f93380k = responseM;
        if (m(responseM)) {
            n();
            this.f93380k = z(d(this.f93385p, this.f93380k));
        }
    }

    public void s(Headers headers) throws IOException {
        CookieHandler cookieHandlerI = this.f93370a.i();
        if (cookieHandlerI != null) {
            cookieHandlerI.put(this.f93377h.o(), OkHeaders.l(headers, null));
        }
    }

    public HttpEngine t(RouteException routeException) {
        if (!this.f93371b.l(routeException) || !this.f93370a.u()) {
            return null;
        }
        return new HttpEngine(this.f93370a, this.f93377h, this.f93376g, this.f93383n, this.f93384o, e(), (RetryableSink) this.f93381l, this.f93372c);
    }

    public HttpEngine u(IOException iOException, Sink sink) {
        if (!this.f93371b.m(iOException, sink) || !this.f93370a.u()) {
            return null;
        }
        return new HttpEngine(this.f93370a, this.f93377h, this.f93376g, this.f93383n, this.f93384o, e(), (RetryableSink) sink, this.f93372c);
    }

    public void v() {
        this.f93371b.n();
    }

    public boolean w(HttpUrl httpUrl) {
        HttpUrl httpUrlK = this.f93377h.k();
        return httpUrlK.q().equals(httpUrl.q()) && httpUrlK.A() == httpUrl.A() && httpUrlK.E().equals(httpUrl.E());
    }

    public void x() {
        if (this.f93386q != null) {
            return;
        }
        if (this.f93373d != null) {
            throw new IllegalStateException();
        }
        Request requestO = o(this.f93377h);
        InternalCache internalCacheE = Internal.f93098b.e(this.f93370a);
        Response responseA = internalCacheE != null ? internalCacheE.a(requestO) : null;
        CacheStrategy cacheStrategyC = new CacheStrategy.Factory(System.currentTimeMillis(), requestO, responseA).c();
        this.f93386q = cacheStrategyC;
        this.f93378i = cacheStrategyC.f93311a;
        this.f93379j = cacheStrategyC.f93312b;
        if (internalCacheE != null) {
            internalCacheE.f(cacheStrategyC);
        }
        if (responseA != null && this.f93379j == null) {
            Util.c(responseA.k());
        }
        if (this.f93378i == null) {
            Response response = this.f93379j;
            if (response != null) {
                this.f93380k = response.u().y(this.f93377h).w(y(this.f93372c)).n(y(this.f93379j)).m();
            } else {
                this.f93380k = new Response.Builder().y(this.f93377h).w(y(this.f93372c)).x(Protocol.HTTP_1_1).q(504).u("Unsatisfiable Request (only-if-cached)").l(f93369r).m();
            }
            this.f93380k = z(this.f93380k);
            return;
        }
        HttpStream httpStreamG = g();
        this.f93373d = httpStreamG;
        httpStreamG.g(this);
        if (this.f93383n && p(this.f93378i) && this.f93381l == null) {
            long jD = OkHeaders.d(requestO);
            if (!this.f93376g) {
                this.f93373d.c(this.f93378i);
                this.f93381l = this.f93373d.b(this.f93378i, jD);
            } else {
                if (jD > 2147483647L) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (jD == -1) {
                    this.f93381l = new RetryableSink();
                } else {
                    this.f93373d.c(this.f93378i);
                    this.f93381l = new RetryableSink((int) jD);
                }
            }
        }
    }
}
