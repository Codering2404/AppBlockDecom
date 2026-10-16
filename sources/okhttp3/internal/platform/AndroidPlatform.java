package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

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
public final class AndroidPlatform extends Platform {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f144791f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f144792g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f144793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CloseGuard f144794e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform a() {
            if (b()) {
                return new AndroidPlatform();
            }
            return null;
        }

        public final boolean b() {
            return AndroidPlatform.f144792g;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomTrustRootIndex implements TrustRootIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f144795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f144796b;

        public CustomTrustRootIndex(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f144795a = trustManager;
            this.f144796b = findByIssuerAndSignatureMethod;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate a(X509Certificate cert) {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object objInvoke = this.f144796b.invoke(this.f144795a, cert);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e3) {
                throw new AssertionError("unable to get issues and signature", e3);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.areEqual(this.f144795a, customTrustRootIndex.f144795a) && Intrinsics.areEqual(this.f144796b, customTrustRootIndex.f144796b);
        }

        public int hashCode() {
            return (this.f144795a.hashCode() * 31) + this.f144796b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f144795a + ", findByIssuerAndSignatureMethod=" + this.f144796b + ')';
        }
    }

    static {
        boolean z2 = false;
        if (Platform.f144818a.h() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f144792g = z2;
    }

    public AndroidPlatform() {
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new SocketAdapter[]{StandardAndroidSocketAdapter.Companion.b(StandardAndroidSocketAdapter.f144847j, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.f144829f.d()), new DeferredSocketAdapter(ConscryptSocketAdapter.f144843a.a()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.f144837a.a())});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((SocketAdapter) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.f144793d = arrayList;
        this.f144794e = CloseGuard.f144839d.a();
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner c(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleanerA = AndroidCertificateChainCleaner.f144822d.a(trustManager);
        return androidCertificateChainCleanerA == null ? super.c(trustManager) : androidCertificateChainCleanerA;
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex d(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            return new CustomTrustRootIndex(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.d(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void e(SSLSocket sslSocket, String str, List protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator it = this.f144793d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SocketAdapter) next).b(sslSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter == null) {
            return;
        }
        socketAdapter.d(sslSocket, str, protocols);
    }

    @Override // okhttp3.internal.platform.Platform
    public void f(Socket socket, InetSocketAddress address, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, i3);
    }

    @Override // okhttp3.internal.platform.Platform
    public String h(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator it = this.f144793d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).b(sslSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.c(sslSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean j(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.Platform
    public void m(String message, Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.f144794e.b(obj)) {
            return;
        }
        Platform.l(this, message, 5, null, 4, null);
    }

    @Override // okhttp3.internal.platform.Platform
    public Object i(String str) {
        Intrinsics.checkNotNullParameter(str, tDEtWsFLJfe.DnBeknG);
        return this.f144794e.a(str);
    }
}
