package com.squareup.okhttp;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class OkHttpClient implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RouteDatabase f92965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dispatcher f92966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Proxy f92967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f92968d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f92969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f92970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f92971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ProxySelector f92972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CookieHandler f92973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InternalCache f92974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Cache f92975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private SocketFactory f92976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SSLSocketFactory f92977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HostnameVerifier f92978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CertificatePinner f92979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Authenticator f92980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ConnectionPool f92981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Dns f92982s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f92983t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f92984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f92985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f92986w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f92987x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f92988y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final List f92964z = Util.k(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static final List A = Util.k(ConnectionSpec.f92898f, ConnectionSpec.f92899g, ConnectionSpec.f92900h);

    static {
        Internal.f93098b = new Internal() { // from class: com.squareup.okhttp.OkHttpClient.1
            @Override // com.squareup.okhttp.internal.Internal
            public void a(Headers.Builder builder, String str) {
                builder.c(str);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void b(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z2) {
                connectionSpec.e(sSLSocket, z2);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public boolean c(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.b(realConnection);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public RealConnection d(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.c(address, streamAllocation);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public InternalCache e(OkHttpClient okHttpClient) {
                return okHttpClient.z();
            }

            @Override // com.squareup.okhttp.internal.Internal
            public void f(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.e(realConnection);
            }

            @Override // com.squareup.okhttp.internal.Internal
            public RouteDatabase g(ConnectionPool connectionPool) {
                return connectionPool.f92895f;
            }
        };
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        ArrayList arrayList = new ArrayList();
        this.f92970g = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f92971h = arrayList2;
        this.f92983t = true;
        this.f92984u = true;
        this.f92985v = true;
        this.f92986w = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        this.f92987x = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        this.f92988y = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        this.f92965a = okHttpClient.f92965a;
        this.f92966b = okHttpClient.f92966b;
        this.f92967c = okHttpClient.f92967c;
        this.f92968d = okHttpClient.f92968d;
        this.f92969f = okHttpClient.f92969f;
        arrayList.addAll(okHttpClient.f92970g);
        arrayList2.addAll(okHttpClient.f92971h);
        this.f92972i = okHttpClient.f92972i;
        this.f92973j = okHttpClient.f92973j;
        Cache cache = okHttpClient.f92975l;
        this.f92975l = cache;
        this.f92974k = cache != null ? cache.f92768a : okHttpClient.f92974k;
        this.f92976m = okHttpClient.f92976m;
        this.f92977n = okHttpClient.f92977n;
        this.f92978o = okHttpClient.f92978o;
        this.f92979p = okHttpClient.f92979p;
        this.f92980q = okHttpClient.f92980q;
        this.f92981r = okHttpClient.f92981r;
        this.f92982s = okHttpClient.f92982s;
        this.f92983t = okHttpClient.f92983t;
        this.f92984u = okHttpClient.f92984u;
        this.f92985v = okHttpClient.f92985v;
        this.f92986w = okHttpClient.f92986w;
        this.f92987x = okHttpClient.f92987x;
        this.f92988y = okHttpClient.f92988y;
    }

    public List A() {
        return this.f92971h;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public OkHttpClient clone() {
        return new OkHttpClient(this);
    }

    public Authenticator b() {
        return this.f92980q;
    }

    public CertificatePinner c() {
        return this.f92979p;
    }

    public int e() {
        return this.f92986w;
    }

    public ConnectionPool g() {
        return this.f92981r;
    }

    public List h() {
        return this.f92969f;
    }

    public CookieHandler i() {
        return this.f92973j;
    }

    public Dispatcher j() {
        return this.f92966b;
    }

    public Dns k() {
        return this.f92982s;
    }

    public boolean m() {
        return this.f92984u;
    }

    public boolean o() {
        return this.f92983t;
    }

    public HostnameVerifier p() {
        return this.f92978o;
    }

    public List q() {
        return this.f92968d;
    }

    public Proxy r() {
        return this.f92967c;
    }

    public ProxySelector s() {
        return this.f92972i;
    }

    public int t() {
        return this.f92987x;
    }

    public boolean u() {
        return this.f92985v;
    }

    public SocketFactory v() {
        return this.f92976m;
    }

    public SSLSocketFactory w() {
        return this.f92977n;
    }

    public int x() {
        return this.f92988y;
    }

    public List y() {
        return this.f92970g;
    }

    InternalCache z() {
        return this.f92974k;
    }
}
