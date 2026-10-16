package com.squareup.okhttp.internal.http;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Http2xStream implements HttpStream {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ByteString f93348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ByteString f93349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ByteString f93350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ByteString f93351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ByteString f93352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ByteString f93353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ByteString f93354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ByteString f93355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final List f93356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final List f93357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List f93358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final List f93359p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreamAllocation f93360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FramedConnection f93361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpEngine f93362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FramedStream f93363d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class StreamFinishingSource extends ForwardingSource {
        public StreamFinishingSource(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2xStream.this.f93360a.q(Http2xStream.this);
            super.close();
        }
    }

    static {
        ByteString byteStringE = ByteString.e("connection");
        f93348e = byteStringE;
        ByteString byteStringE2 = ByteString.e(DiagnosticsTracker.HOST_KEY);
        f93349f = byteStringE2;
        ByteString byteStringE3 = ByteString.e("keep-alive");
        f93350g = byteStringE3;
        ByteString byteStringE4 = ByteString.e("proxy-connection");
        f93351h = byteStringE4;
        ByteString byteStringE5 = ByteString.e("transfer-encoding");
        f93352i = byteStringE5;
        ByteString byteStringE6 = ByteString.e("te");
        f93353j = byteStringE6;
        ByteString byteStringE7 = ByteString.e("encoding");
        f93354k = byteStringE7;
        ByteString byteStringE8 = ByteString.e("upgrade");
        f93355l = byteStringE8;
        ByteString byteString = Header.f93235e;
        ByteString byteString2 = Header.f93236f;
        ByteString byteString3 = Header.f93237g;
        ByteString byteString4 = Header.f93238h;
        ByteString byteString5 = Header.f93239i;
        ByteString byteString6 = Header.f93240j;
        f93356m = Util.k(byteStringE, byteStringE2, byteStringE3, byteStringE4, byteStringE5, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f93357n = Util.k(byteStringE, byteStringE2, byteStringE3, byteStringE4, byteStringE5);
        f93358o = Util.k(byteStringE, byteStringE2, byteStringE3, byteStringE4, byteStringE6, byteStringE5, byteStringE7, byteStringE8, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f93359p = Util.k(byteStringE, byteStringE2, byteStringE3, byteStringE4, byteStringE6, byteStringE5, byteStringE7, byteStringE8);
    }

    public Http2xStream(StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.f93360a = streamAllocation;
        this.f93361b = framedConnection;
    }

    public static List i(Request request) {
        Headers headersI = request.i();
        ArrayList arrayList = new ArrayList(headersI.f() + 4);
        arrayList.add(new Header(Header.f93235e, request.m()));
        arrayList.add(new Header(Header.f93236f, RequestLine.c(request.k())));
        arrayList.add(new Header(Header.f93238h, Util.i(request.k())));
        arrayList.add(new Header(Header.f93237g, request.k().E()));
        int iF = headersI.f();
        for (int i3 = 0; i3 < iF; i3++) {
            ByteString byteStringE = ByteString.e(headersI.d(i3).toLowerCase(Locale.US));
            if (!f93358o.contains(byteStringE)) {
                arrayList.add(new Header(byteStringE, headersI.g(i3)));
            }
        }
        return arrayList;
    }

    private static String j(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static Response.Builder k(List list) throws ProtocolException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        for (int i3 = 0; i3 < size; i3++) {
            ByteString byteString = ((Header) list.get(i3)).f93241a;
            String strI = ((Header) list.get(i3)).f93242b.I();
            if (byteString.equals(Header.f93234d)) {
                str = strI;
            } else if (!f93359p.contains(byteString)) {
                builder.b(byteString.I(), strI);
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine statusLineA = StatusLine.a("HTTP/1.1 " + str);
        return new Response.Builder().x(Protocol.HTTP_2).q(statusLineA.f93419b).u(statusLineA.f93420c).t(builder.e());
    }

    public static Response.Builder l(List list) throws ProtocolException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        for (int i3 = 0; i3 < size; i3++) {
            ByteString byteString = ((Header) list.get(i3)).f93241a;
            String strI = ((Header) list.get(i3)).f93242b.I();
            int i4 = 0;
            while (i4 < strI.length()) {
                int iIndexOf = strI.indexOf(0, i4);
                if (iIndexOf == -1) {
                    iIndexOf = strI.length();
                }
                String strSubstring = strI.substring(i4, iIndexOf);
                if (byteString.equals(Header.f93234d)) {
                    str = strSubstring;
                } else if (byteString.equals(Header.f93240j)) {
                    str2 = strSubstring;
                } else if (!f93357n.contains(byteString)) {
                    builder.b(byteString.I(), strSubstring);
                }
                i4 = iIndexOf + 1;
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine statusLineA = StatusLine.a(str2 + " " + str);
        return new Response.Builder().x(Protocol.SPDY_3).q(statusLineA.f93419b).u(statusLineA.f93420c).t(builder.e());
    }

    public static List m(Request request) {
        Headers headersI = request.i();
        ArrayList arrayList = new ArrayList(headersI.f() + 5);
        arrayList.add(new Header(Header.f93235e, request.m()));
        arrayList.add(new Header(Header.f93236f, RequestLine.c(request.k())));
        arrayList.add(new Header(Header.f93240j, "HTTP/1.1"));
        arrayList.add(new Header(Header.f93239i, Util.i(request.k())));
        arrayList.add(new Header(Header.f93237g, request.k().E()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int iF = headersI.f();
        for (int i3 = 0; i3 < iF; i3++) {
            ByteString byteStringE = ByteString.e(headersI.d(i3).toLowerCase(Locale.US));
            if (!f93356m.contains(byteStringE)) {
                String strG = headersI.g(i3);
                if (linkedHashSet.add(byteStringE)) {
                    arrayList.add(new Header(byteStringE, strG));
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= arrayList.size()) {
                            break;
                        }
                        if (((Header) arrayList.get(i4)).f93241a.equals(byteStringE)) {
                            arrayList.set(i4, new Header(byteStringE, j(((Header) arrayList.get(i4)).f93242b.I(), strG)));
                            break;
                        }
                        i4++;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void a() {
        this.f93363d.q().close();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink b(Request request, long j3) {
        return this.f93363d.q();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void c(Request request) {
        if (this.f93363d != null) {
            return;
        }
        this.f93362c.B();
        FramedStream framedStreamA0 = this.f93361b.A0(this.f93361b.j0() == Protocol.HTTP_2 ? i(request) : m(request), this.f93362c.p(request), true);
        this.f93363d = framedStreamA0;
        Timeout timeoutU = framedStreamA0.u();
        long jT = this.f93362c.f93370a.t();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeoutU.h(jT, timeUnit);
        this.f93363d.A().h(this.f93362c.f93370a.x(), timeUnit);
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void d(RetryableSink retryableSink) {
        retryableSink.b(this.f93363d.q());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder e() {
        return this.f93361b.j0() == Protocol.HTTP_2 ? k(this.f93363d.p()) : l(this.f93363d.p());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody f(Response response) {
        return new RealResponseBody(response.r(), Okio.d(new StreamFinishingSource(this.f93363d.r())));
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void g(HttpEngine httpEngine) {
        this.f93362c = httpEngine;
    }
}
