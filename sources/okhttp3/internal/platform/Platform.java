package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

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
public class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f144818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Platform f144819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f144820c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Platform d() {
            AndroidLog.f144825a.b();
            Platform platformA = Android10Platform.f144788e.a();
            if (platformA != null) {
                return platformA;
            }
            Platform platformA2 = AndroidPlatform.f144791f.a();
            Intrinsics.checkNotNull(platformA2);
            return platformA2;
        }

        private final Platform e() {
            OpenJSSEPlatform openJSSEPlatformA;
            BouncyCastlePlatform bouncyCastlePlatformA;
            ConscryptPlatform conscryptPlatformB;
            if (j() && (conscryptPlatformB = ConscryptPlatform.f144800e.b()) != null) {
                return conscryptPlatformB;
            }
            if (i() && (bouncyCastlePlatformA = BouncyCastlePlatform.f144797e.a()) != null) {
                return bouncyCastlePlatformA;
            }
            if (k() && (openJSSEPlatformA = OpenJSSEPlatform.f144815e.a()) != null) {
                return openJSSEPlatformA;
            }
            Jdk9Platform jdk9PlatformA = Jdk9Platform.f144813d.a();
            if (jdk9PlatformA != null) {
                return jdk9PlatformA;
            }
            Platform platformA = Jdk8WithJettyBootPlatform.f144804i.a();
            return platformA != null ? platformA : new Platform();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Platform f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            return Intrinsics.areEqual("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return Intrinsics.areEqual("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return Intrinsics.areEqual("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List b(List protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                arrayList2.add(((Protocol) obj2).toString());
            }
            return arrayList2;
        }

        public final byte[] c(List protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            Buffer buffer = new Buffer();
            for (String str : b(protocols)) {
                buffer.writeByte(str.length());
                buffer.C0(str);
            }
            return buffer.D1();
        }

        public final Platform g() {
            return Platform.f144819b;
        }

        public final boolean h() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        f144818a = companion;
        f144819b = companion.f();
        f144820c = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static /* synthetic */ void l(Platform platform, String str, int i3, Throwable th, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i4 & 2) != 0) {
            i3 = 4;
        }
        if ((i4 & 4) != 0) {
            th = null;
        }
        platform.k(str, i3, th);
    }

    public void b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public CertificateChainCleaner c(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(d(trustManager));
    }

    public TrustRootIndex d(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public void f(Socket socket, InetSocketAddress address, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, i3);
    }

    public final String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public Object i(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        if (f144820c.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean j(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public void k(String message, int i3, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        f144820c.log(i3 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void m(String message, Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (obj == null) {
            message = Intrinsics.stringPlus(message, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        k(message, 5, (Throwable) obj);
    }

    public SSLContext n() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory o(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext sSLContextN = n();
            sSLContextN.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextN.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e3) {
            throw new AssertionError(Intrinsics.stringPlus("No System TLS: ", e3), e3);
        }
    }

    public X509TrustManager p() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                if (trustManager != null) {
                    return (X509TrustManager) trustManager;
                }
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
        }
        String string = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected default trust managers: ", string).toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
