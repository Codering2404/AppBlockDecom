package okhttp3;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

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
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion F = new Companion(null);
    private static final List G = Util.w(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List H = Util.w(ConnectionSpec.f144024i, ConnectionSpec.f144026k);
    private final int A;
    private final int B;
    private final int C;
    private final long D;
    private final RouteDatabase E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dispatcher f144145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionPool f144146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f144147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f144148d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventListener.Factory f144149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f144150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Authenticator f144151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f144152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f144153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CookieJar f144154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Cache f144155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Dns f144156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Proxy f144157n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ProxySelector f144158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Authenticator f144159p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final SocketFactory f144160q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final SSLSocketFactory f144161r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final X509TrustManager f144162s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f144163t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List f144164u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final HostnameVerifier f144165v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final CertificatePinner f144166w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CertificateChainCleaner f144167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f144168y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f144169z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        private int A;
        private int B;
        private long C;
        private RouteDatabase D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Dispatcher f144170a = new Dispatcher();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConnectionPool f144171b = new ConnectionPool();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144172c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f144173d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private EventListener.Factory f144174e = Util.g(EventListener.f144066b);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f144175f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Authenticator f144176g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f144177h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f144178i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private CookieJar f144179j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Cache f144180k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Dns f144181l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Proxy f144182m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private ProxySelector f144183n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Authenticator f144184o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private SocketFactory f144185p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private SSLSocketFactory f144186q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private X509TrustManager f144187r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private List f144188s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private List f144189t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private HostnameVerifier f144190u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private CertificatePinner f144191v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private CertificateChainCleaner f144192w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f144193x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f144194y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f144195z;

        public Builder() {
            Authenticator authenticator = Authenticator.y8;
            this.f144176g = authenticator;
            this.f144177h = true;
            this.f144178i = true;
            this.f144179j = CookieJar.f144052b;
            this.f144181l = Dns.f144063b;
            this.f144184o = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.f144185p = socketFactory;
            Companion companion = OkHttpClient.F;
            this.f144188s = companion.a();
            this.f144189t = companion.b();
            this.f144190u = OkHostnameVerifier.f144863a;
            this.f144191v = CertificatePinner.f143936d;
            this.f144194y = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
            this.f144195z = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
            this.A = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
            this.C = 1024L;
        }

        public final Proxy A() {
            return this.f144182m;
        }

        public final Authenticator B() {
            return this.f144184o;
        }

        public final ProxySelector C() {
            return this.f144183n;
        }

        public final int D() {
            return this.f144195z;
        }

        public final boolean E() {
            return this.f144175f;
        }

        public final RouteDatabase F() {
            return this.D;
        }

        public final SocketFactory G() {
            return this.f144185p;
        }

        public final SSLSocketFactory H() {
            return this.f144186q;
        }

        public final int I() {
            return this.A;
        }

        public final X509TrustManager J() {
            return this.f144187r;
        }

        public final Builder K(boolean z2) {
            O(z2);
            return this;
        }

        public final void L(Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.f144176g = authenticator;
        }

        public final void M(int i3) {
            this.f144193x = i3;
        }

        public final void N(int i3) {
            this.f144194y = i3;
        }

        public final void O(boolean z2) {
            this.f144175f = z2;
        }

        public final Builder a(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            v().add(interceptor);
            return this;
        }

        public final Builder b(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            x().add(interceptor);
            return this;
        }

        public final Builder c(Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "authenticator");
            L(authenticator);
            return this;
        }

        public final OkHttpClient d() {
            return new OkHttpClient(this);
        }

        public final Builder f(long j3, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            N(Util.k("timeout", j3, unit));
            return this;
        }

        public final Authenticator g() {
            return this.f144176g;
        }

        public final Cache h() {
            return this.f144180k;
        }

        public final int i() {
            return this.f144193x;
        }

        public final CertificateChainCleaner j() {
            return this.f144192w;
        }

        public final CertificatePinner k() {
            return this.f144191v;
        }

        public final int l() {
            return this.f144194y;
        }

        public final ConnectionPool m() {
            return this.f144171b;
        }

        public final List n() {
            return this.f144188s;
        }

        public final CookieJar o() {
            return this.f144179j;
        }

        public final Dispatcher p() {
            return this.f144170a;
        }

        public final Dns q() {
            return this.f144181l;
        }

        public final EventListener.Factory r() {
            return this.f144174e;
        }

        public final boolean s() {
            return this.f144177h;
        }

        public final boolean t() {
            return this.f144178i;
        }

        public final HostnameVerifier u() {
            return this.f144190u;
        }

        public final List v() {
            return this.f144172c;
        }

        public final long w() {
            return this.C;
        }

        public final List x() {
            return this.f144173d;
        }

        public final int y() {
            return this.B;
        }

        public final List z() {
            return this.f144189t;
        }

        public final Builder e(long j3, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, pMpIcGE.rIEffNmxe);
            M(Util.k("timeout", j3, timeUnit));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return OkHttpClient.H;
        }

        public final List b() {
            return OkHttpClient.G;
        }

        private Companion() {
        }
    }

    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelectorC;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f144145a = builder.p();
        this.f144146b = builder.m();
        this.f144147c = Util.V(builder.v());
        this.f144148d = Util.V(builder.x());
        this.f144149f = builder.r();
        this.f144150g = builder.E();
        this.f144151h = builder.g();
        this.f144152i = builder.s();
        this.f144153j = builder.t();
        this.f144154k = builder.o();
        this.f144155l = builder.h();
        this.f144156m = builder.q();
        this.f144157n = builder.A();
        if (builder.A() != null) {
            proxySelectorC = NullProxySelector.f144850a;
        } else {
            proxySelectorC = builder.C();
            proxySelectorC = proxySelectorC == null ? ProxySelector.getDefault() : proxySelectorC;
            if (proxySelectorC == null) {
                proxySelectorC = NullProxySelector.f144850a;
            }
        }
        this.f144158o = proxySelectorC;
        this.f144159p = builder.B();
        this.f144160q = builder.G();
        List listN = builder.n();
        this.f144163t = listN;
        this.f144164u = builder.z();
        this.f144165v = builder.u();
        this.f144168y = builder.i();
        this.f144169z = builder.l();
        this.A = builder.D();
        this.B = builder.I();
        this.C = builder.y();
        this.D = builder.w();
        RouteDatabase routeDatabaseF = builder.F();
        this.E = routeDatabaseF == null ? new RouteDatabase() : routeDatabaseF;
        List list = listN;
        if ((list instanceof Collection) && list.isEmpty()) {
            this.f144161r = null;
            this.f144167x = null;
            this.f144162s = null;
            this.f144166w = CertificatePinner.f143936d;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).f()) {
                    if (builder.H() != null) {
                        this.f144161r = builder.H();
                        CertificateChainCleaner certificateChainCleanerJ = builder.j();
                        Intrinsics.checkNotNull(certificateChainCleanerJ);
                        this.f144167x = certificateChainCleanerJ;
                        X509TrustManager x509TrustManagerJ = builder.J();
                        Intrinsics.checkNotNull(x509TrustManagerJ);
                        this.f144162s = x509TrustManagerJ;
                        CertificatePinner certificatePinnerK = builder.k();
                        Intrinsics.checkNotNull(certificateChainCleanerJ);
                        this.f144166w = certificatePinnerK.e(certificateChainCleanerJ);
                    } else {
                        Platform.Companion companion = Platform.f144818a;
                        X509TrustManager x509TrustManagerP = companion.g().p();
                        this.f144162s = x509TrustManagerP;
                        Platform platformG = companion.g();
                        Intrinsics.checkNotNull(x509TrustManagerP);
                        this.f144161r = platformG.o(x509TrustManagerP);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.f144862a;
                        Intrinsics.checkNotNull(x509TrustManagerP);
                        CertificateChainCleaner certificateChainCleanerA = companion2.a(x509TrustManagerP);
                        this.f144167x = certificateChainCleanerA;
                        CertificatePinner certificatePinnerK2 = builder.k();
                        Intrinsics.checkNotNull(certificateChainCleanerA);
                        this.f144166w = certificatePinnerK2.e(certificateChainCleanerA);
                    }
                }
            }
            this.f144161r = null;
            this.f144167x = null;
            this.f144162s = null;
            this.f144166w = CertificatePinner.f143936d;
        }
        I();
    }

    private final void I() {
        if (this.f144147c.contains(null)) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null interceptor: ", w()).toString());
        }
        if (this.f144148d.contains(null)) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null network interceptor: ", x()).toString());
        }
        List list = this.f144163t;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).f()) {
                    if (this.f144161r == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.f144167x == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.f144162s == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.f144161r != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f144167x != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f144162s != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!Intrinsics.areEqual(this.f144166w, CertificatePinner.f143936d)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Proxy A() {
        return this.f144157n;
    }

    public final Authenticator B() {
        return this.f144159p;
    }

    public final ProxySelector D() {
        return this.f144158o;
    }

    public final int E() {
        return this.A;
    }

    public final boolean F() {
        return this.f144150g;
    }

    public final SocketFactory G() {
        return this.f144160q;
    }

    public final SSLSocketFactory H() {
        SSLSocketFactory sSLSocketFactory = this.f144161r;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int J() {
        return this.B;
    }

    @Override // okhttp3.Call.Factory
    public Call a(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    public final Authenticator e() {
        return this.f144151h;
    }

    public final Cache g() {
        return this.f144155l;
    }

    public final int h() {
        return this.f144168y;
    }

    public final CertificatePinner i() {
        return this.f144166w;
    }

    public final int j() {
        return this.f144169z;
    }

    public final ConnectionPool k() {
        return this.f144146b;
    }

    public final List m() {
        return this.f144163t;
    }

    public final CookieJar o() {
        return this.f144154k;
    }

    public final Dispatcher p() {
        return this.f144145a;
    }

    public final Dns q() {
        return this.f144156m;
    }

    public final EventListener.Factory r() {
        return this.f144149f;
    }

    public final boolean s() {
        return this.f144152i;
    }

    public final boolean t() {
        return this.f144153j;
    }

    public final RouteDatabase u() {
        return this.E;
    }

    public final HostnameVerifier v() {
        return this.f144165v;
    }

    public final List w() {
        return this.f144147c;
    }

    public final List x() {
        return this.f144148d;
    }

    public final int y() {
        return this.C;
    }

    public final List z() {
        return this.f144164u;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
