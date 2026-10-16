package okhttp3.internal.connection;

import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f144465t = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RealConnectionPool f144466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Route f144467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Socket f144468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Socket f144469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handshake f144470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Protocol f144471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Http2Connection f144472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BufferedSource f144473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BufferedSink f144474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f144475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f144476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f144477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f144478o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f144479p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f144480q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List f144481r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f144482s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f144483a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            f144483a = iArr;
        }
    }

    public RealConnection(RealConnectionPool connectionPool, Route route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.f144466c = connectionPool;
        this.f144467d = route;
        this.f144480q = 1;
        this.f144481r = new ArrayList();
        this.f144482s = Long.MAX_VALUE;
    }

    private final boolean C(List list) {
        List<Route> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (Route route : list2) {
            Proxy.Type type = route.b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f144467d.b().type() == type2 && Intrinsics.areEqual(this.f144467d.d(), route.d())) {
                return true;
            }
        }
        return false;
    }

    private final void G(int i3) throws SocketException {
        Socket socket = this.f144469f;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.f144473j;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.f144474k;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        Http2Connection http2ConnectionA = new Http2Connection.Builder(true, TaskRunner.f144398i).s(socket, this.f144467d.a().l().i(), bufferedSource, bufferedSink).k(this).l(i3).a();
        this.f144472i = http2ConnectionA;
        this.f144480q = Http2Connection.D.a().d();
        Http2Connection.T1(http2ConnectionA, false, null, 3, null);
    }

    private final boolean H(HttpUrl httpUrl) {
        Handshake handshake;
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        HttpUrl httpUrlL = this.f144467d.a().l();
        if (httpUrl.n() != httpUrlL.n()) {
            return false;
        }
        if (Intrinsics.areEqual(httpUrl.i(), httpUrlL.i())) {
            return true;
        }
        if (!this.f144476m && (handshake = this.f144470g) != null) {
            Intrinsics.checkNotNull(handshake);
            if (f(httpUrl, handshake)) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(HttpUrl httpUrl, Handshake handshake) {
        List listD = handshake.d();
        return !listD.isEmpty() && OkHostnameVerifier.f144863a.e(httpUrl.i(), (X509Certificate) listD.get(0));
    }

    private final void i(int i3, int i4, Call call, EventListener eventListener) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.f144467d.b();
        Address addressA = this.f144467d.a();
        Proxy.Type type = proxyB.type();
        int i5 = type == null ? -1 : WhenMappings.f144483a[type.ordinal()];
        if (i5 == 1 || i5 == 2) {
            socketCreateSocket = addressA.j().createSocket();
            Intrinsics.checkNotNull(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.f144468e = socketCreateSocket;
        eventListener.j(call, this.f144467d.d(), proxyB);
        socketCreateSocket.setSoTimeout(i4);
        try {
            Platform.f144818a.g().f(socketCreateSocket, this.f144467d.d(), i3);
            try {
                this.f144473j = Okio.d(Okio.m(socketCreateSocket));
                this.f144474k = Okio.c(Okio.i(socketCreateSocket));
            } catch (NullPointerException e3) {
                if (Intrinsics.areEqual(e3.getMessage(), "throw with null exception")) {
                    throw new IOException(e3);
                }
            }
        } catch (ConnectException e4) {
            ConnectException connectException = new ConnectException(Intrinsics.stringPlus("Failed to connect to ", this.f144467d.d()));
            connectException.initCause(e4);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void j(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        final Address addressA = this.f144467d.a();
        SSLSocketFactory sSLSocketFactoryK = addressA.k();
        SSLSocket sSLSocket = null;
        try {
            Intrinsics.checkNotNull(sSLSocketFactoryK);
            Socket socketCreateSocket = sSLSocketFactoryK.createSocket(this.f144468e, addressA.l().i(), addressA.l().n(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ConnectionSpec connectionSpecA = connectionSpecSelector.a(sSLSocket2);
                if (connectionSpecA.h()) {
                    Platform.f144818a.g().e(sSLSocket2, addressA.l().i(), addressA.f());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.f144074e;
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                final Handshake handshakeA = companion.a(sslSocketSession);
                HostnameVerifier hostnameVerifierE = addressA.e();
                Intrinsics.checkNotNull(hostnameVerifierE);
                if (hostnameVerifierE.verify(addressA.l().i(), sslSocketSession)) {
                    final CertificatePinner certificatePinnerA = addressA.a();
                    Intrinsics.checkNotNull(certificatePinnerA);
                    this.f144470g = new Handshake(handshakeA.e(), handshakeA.a(), handshakeA.c(), new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List invoke() {
                            CertificateChainCleaner certificateChainCleanerD = certificatePinnerA.d();
                            Intrinsics.checkNotNull(certificateChainCleanerD);
                            return certificateChainCleanerD.a(handshakeA.d(), addressA.l().i());
                        }
                    });
                    certificatePinnerA.b(addressA.l().i(), new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List invoke() {
                            Handshake handshake = this.f144487a.f144470g;
                            Intrinsics.checkNotNull(handshake);
                            List listD = handshake.d();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD, 10));
                            Iterator it = listD.iterator();
                            while (it.hasNext()) {
                                arrayList.add((X509Certificate) ((Certificate) it.next()));
                            }
                            return arrayList;
                        }
                    });
                    String strH = connectionSpecA.h() ? Platform.f144818a.g().h(sSLSocket2) : null;
                    this.f144469f = sSLSocket2;
                    this.f144473j = Okio.d(Okio.m(sSLSocket2));
                    this.f144474k = Okio.c(Okio.i(sSLSocket2));
                    this.f144471h = strH != null ? Protocol.f144198b.a(strH) : Protocol.HTTP_1_1;
                    Platform.f144818a.g().b(sSLSocket2);
                    return;
                }
                List listD = handshakeA.d();
                if (listD.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + addressA.l().i() + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) listD.get(0);
                throw new SSLPeerUnverifiedException(StringsKt.p("\n              |Hostname " + addressA.l().i() + " not verified:\n              |    certificate: " + CertificatePinner.f143935c.a(x509Certificate) + "\n              |    DN: " + ((Object) x509Certificate.getSubjectDN().getName()) + "\n              |    subjectAltNames: " + OkHostnameVerifier.f144863a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.f144818a.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void k(int i3, int i4, int i5, Call call, EventListener eventListener) throws IOException {
        Request requestM = m();
        HttpUrl httpUrlK = requestM.k();
        int i6 = 0;
        while (i6 < 21) {
            i6++;
            i(i3, i4, call, eventListener);
            requestM = l(i4, i5, requestM, httpUrlK);
            if (requestM == null) {
                return;
            }
            Socket socket = this.f144468e;
            if (socket != null) {
                Util.n(socket);
            }
            this.f144468e = null;
            this.f144474k = null;
            this.f144473j = null;
            eventListener.h(call, this.f144467d.d(), this.f144467d.b(), null);
        }
    }

    private final Request l(int i3, int i4, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.T(httpUrl, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.f144473j;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.f144474k;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.v().h(i3, timeUnit);
            bufferedSink.v().h(i4, timeUnit);
            http1ExchangeCodec.A(request.f(), str);
            http1ExchangeCodec.a();
            Response.Builder builderG = http1ExchangeCodec.g(false);
            Intrinsics.checkNotNull(builderG);
            Response responseC = builderG.s(request).c();
            http1ExchangeCodec.z(responseC);
            int i5 = responseC.i();
            if (i5 == 200) {
                if (bufferedSource.u().G1() && bufferedSink.u().G1()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (i5 != 407) {
                throw new IOException(Intrinsics.stringPlus("Unexpected response code for CONNECT: ", Integer.valueOf(responseC.i())));
            }
            Request requestA = this.f144467d.a().h().a(this.f144467d, responseC);
            if (requestA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (StringsKt.F("close", Response.n(responseC, "Connection", null, 2, null), true)) {
                return requestA;
            }
            request = requestA;
        }
    }

    private final Request m() {
        Request requestB = new Request.Builder().r(this.f144467d.a().l()).h("CONNECT", null).f("Host", Util.T(this.f144467d.a().l(), true)).f("Proxy-Connection", "Keep-Alive").f(GraphRequest.USER_AGENT_HEADER, "okhttp/4.11.0").b();
        Request requestA = this.f144467d.a().h().a(this.f144467d, new Response.Builder().s(requestB).q(Protocol.HTTP_1_1).g(407).n("Preemptive Authenticate").b(Util.f144276c).t(-1L).r(-1L).k("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return requestA == null ? requestB : requestA;
    }

    private final void n(ConnectionSpecSelector connectionSpecSelector, int i3, Call call, EventListener eventListener) throws Throwable {
        if (this.f144467d.a().k() != null) {
            eventListener.C(call);
            j(connectionSpecSelector);
            eventListener.B(call, this.f144470g);
            if (this.f144471h == Protocol.HTTP_2) {
                G(i3);
                return;
            }
            return;
        }
        List listF = this.f144467d.a().f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(protocol)) {
            this.f144469f = this.f144468e;
            this.f144471h = Protocol.HTTP_1_1;
        } else {
            this.f144469f = this.f144468e;
            this.f144471h = protocol;
            G(i3);
        }
    }

    public final synchronized void A() {
        this.f144475l = true;
    }

    public Route B() {
        return this.f144467d;
    }

    public final void D(long j3) {
        this.f144482s = j3;
    }

    public final void E(boolean z2) {
        this.f144475l = z2;
    }

    public Socket F() {
        Socket socket = this.f144469f;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    public final synchronized void I(RealCall call, IOException iOException) {
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).f144786a == ErrorCode.REFUSED_STREAM) {
                    int i3 = this.f144479p + 1;
                    this.f144479p = i3;
                    if (i3 > 1) {
                        this.f144475l = true;
                        this.f144477n++;
                    }
                } else if (((StreamResetException) iOException).f144786a != ErrorCode.CANCEL || !call.C()) {
                    this.f144475l = true;
                    this.f144477n++;
                }
            } else if (!w() || (iOException instanceof ConnectionShutdownException)) {
                this.f144475l = true;
                if (this.f144478o == 0) {
                    if (iOException != null) {
                        h(call.m(), this.f144467d, iOException);
                    }
                    this.f144477n++;
                }
            }
        } finally {
        }
    }

    @Override // okhttp3.Connection
    public Protocol a() {
        Protocol protocol = this.f144471h;
        Intrinsics.checkNotNull(protocol);
        return protocol;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void b(Http2Connection connection, Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.f144480q = settings.d();
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void c(Http2Stream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.d(ErrorCode.REFUSED_STREAM, null);
    }

    public final void e() {
        Socket socket = this.f144468e;
        if (socket == null) {
            return;
        }
        Util.n(socket);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
    
        if (r12.f144467d.c() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00db, code lost:
    
        if (r12.f144468e == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ea, code lost:
    
        throw new okhttp3.internal.connection.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00eb, code lost:
    
        r12.f144482s = java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0141 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r13, int r14, int r15, int r16, boolean r17, okhttp3.Call r18, okhttp3.EventListener r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.g(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void h(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.b().type() != Proxy.Type.DIRECT) {
            Address addressA = failedRoute.a();
            addressA.i().connectFailed(addressA.l().s(), failedRoute.b().address(), failure);
        }
        client.u().b(failedRoute);
    }

    public final List o() {
        return this.f144481r;
    }

    public final long p() {
        return this.f144482s;
    }

    public final boolean q() {
        return this.f144475l;
    }

    public final int r() {
        return this.f144477n;
    }

    public Handshake s() {
        return this.f144470g;
    }

    public final synchronized void t() {
        this.f144478o++;
    }

    public String toString() {
        CipherSuite cipherSuiteA;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f144467d.a().l().i());
        sb.append(':');
        sb.append(this.f144467d.a().l().n());
        sb.append(", proxy=");
        sb.append(this.f144467d.b());
        sb.append(" hostAddress=");
        sb.append(this.f144467d.d());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f144470g;
        Object obj = IntegrityManager.INTEGRITY_TYPE_NONE;
        if (handshake != null && (cipherSuiteA = handshake.a()) != null) {
            obj = cipherSuiteA;
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f144471h);
        sb.append('}');
        return sb.toString();
    }

    public final boolean u(Address address, List list) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.f144481r.size() >= this.f144480q || this.f144475l || !this.f144467d.a().d(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.l().i(), B().a().l().i())) {
            return true;
        }
        if (this.f144472i == null || list == null || !C(list) || address.e() != OkHostnameVerifier.f144863a || !H(address.l())) {
            return false;
        }
        try {
            CertificatePinner certificatePinnerA = address.a();
            Intrinsics.checkNotNull(certificatePinnerA);
            String strI = address.l().i();
            Handshake handshakeS = s();
            Intrinsics.checkNotNull(handshakeS);
            certificatePinnerA.a(strI, handshakeS.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean v(boolean z2) {
        long jP;
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.f144468e;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.f144469f;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.f144473j;
        Intrinsics.checkNotNull(bufferedSource);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f144472i;
        if (http2Connection != null) {
            return http2Connection.a1(jNanoTime);
        }
        synchronized (this) {
            jP = jNanoTime - p();
        }
        if (jP < 10000000000L || !z2) {
            return true;
        }
        return Util.G(socket2, bufferedSource);
    }

    public final boolean w() {
        return this.f144472i != null;
    }

    public final ExchangeCodec x(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.f144469f;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.f144473j;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.f144474k;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection = this.f144472i;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.k());
        Timeout timeoutV = bufferedSource.v();
        long jH = chain.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeoutV.h(jH, timeUnit);
        bufferedSink.v().h(chain.j(), timeUnit);
        return new Http1ExchangeCodec(client, this, bufferedSource, bufferedSink);
    }

    public final RealWebSocket.Streams y(final Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.f144469f;
        Intrinsics.checkNotNull(socket);
        final BufferedSource bufferedSource = this.f144473j;
        Intrinsics.checkNotNull(bufferedSource);
        final BufferedSink bufferedSink = this.f144474k;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        A();
        return new RealWebSocket.Streams(bufferedSink, exchange) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ BufferedSink f144489f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Exchange f144490g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true, this.f144488d, bufferedSink);
                this.f144489f = bufferedSink;
                this.f144490g = exchange;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f144490g.a(-1L, true, true, null);
            }
        };
    }

    public final synchronized void z() {
        this.f144476m = true;
    }
}
