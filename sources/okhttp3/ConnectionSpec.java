package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

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
public final class ConnectionSpec {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f144020e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CipherSuite[] f144021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CipherSuite[] f144022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConnectionSpec f144023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConnectionSpec f144024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConnectionSpec f144025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConnectionSpec f144026k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f144028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f144029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f144030d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.f143991o1;
        CipherSuite cipherSuite2 = CipherSuite.f143994p1;
        CipherSuite cipherSuite3 = CipherSuite.f143997q1;
        CipherSuite cipherSuite4 = CipherSuite.f143949a1;
        CipherSuite cipherSuite5 = CipherSuite.f143961e1;
        CipherSuite cipherSuite6 = CipherSuite.f143952b1;
        CipherSuite cipherSuite7 = CipherSuite.f143964f1;
        CipherSuite cipherSuite8 = CipherSuite.f143982l1;
        CipherSuite cipherSuite9 = CipherSuite.f143979k1;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        f144021f = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.L0, CipherSuite.M0, CipherSuite.f143975j0, CipherSuite.f143978k0, CipherSuite.H, CipherSuite.L, CipherSuite.f143980l};
        f144022g = cipherSuiteArr2;
        Builder builderC = new Builder(true).c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f144023h = builderC.j(tlsVersion, tlsVersion2).h(true).a();
        f144024i = new Builder(true).c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).j(tlsVersion, tlsVersion2).h(true).a();
        f144025j = new Builder(true).c((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).j(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).h(true).a();
        f144026k = new Builder(false).a();
    }

    public ConnectionSpec(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f144027a = z2;
        this.f144028b = z3;
        this.f144029c = strArr;
        this.f144030d = strArr2;
    }

    private final ConnectionSpec g(SSLSocket sSLSocket, boolean z2) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        if (this.f144029c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = Util.E(enabledCipherSuites, this.f144029c, CipherSuite.f143950b.c());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f144030d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = Util.E(enabledProtocols, this.f144030d, ComparisonsKt.g());
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int iX = Util.x(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.f143950b.c());
        if (z2 && iX != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iX];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = Util.o(cipherSuitesIntersection, str);
        }
        Builder builder = new Builder(this);
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        Builder builderB = builder.b((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        return builderB.i((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).a();
    }

    public final void c(SSLSocket sslSocket, boolean z2) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        ConnectionSpec connectionSpecG = g(sslSocket, z2);
        if (connectionSpecG.i() != null) {
            sslSocket.setEnabledProtocols(connectionSpecG.f144030d);
        }
        if (connectionSpecG.d() != null) {
            sslSocket.setEnabledCipherSuites(connectionSpecG.f144029c);
        }
    }

    public final List d() {
        String[] strArr = this.f144029c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.f143950b.b(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean e(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.f144027a) {
            return false;
        }
        String[] strArr = this.f144030d;
        if (strArr != null && !Util.u(strArr, socket.getEnabledProtocols(), ComparisonsKt.g())) {
            return false;
        }
        String[] strArr2 = this.f144029c;
        return strArr2 == null || Util.u(strArr2, socket.getEnabledCipherSuites(), CipherSuite.f143950b.c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.f144027a;
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (z2 != connectionSpec.f144027a) {
            return false;
        }
        return !z2 || (Arrays.equals(this.f144029c, connectionSpec.f144029c) && Arrays.equals(this.f144030d, connectionSpec.f144030d) && this.f144028b == connectionSpec.f144028b);
    }

    public final boolean f() {
        return this.f144027a;
    }

    public final boolean h() {
        return this.f144028b;
    }

    public int hashCode() {
        if (!this.f144027a) {
            return 17;
        }
        String[] strArr = this.f144029c;
        int iHashCode = (527 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.f144030d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f144028b ? 1 : 0);
    }

    public final List i() {
        String[] strArr = this.f144030d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.f144266b.a(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public String toString() {
        if (!this.f144027a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + ((Object) Objects.toString(d(), "[all enabled]")) + ", tlsVersions=" + ((Object) Objects.toString(i(), "[all enabled]")) + ", supportsTlsExtensions=" + this.f144028b + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f144031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f144032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f144033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f144034d;

        public Builder(boolean z2) {
            this.f144031a = z2;
        }

        public final ConnectionSpec a() {
            return new ConnectionSpec(this.f144031a, this.f144034d, this.f144032b, this.f144033c);
        }

        public final Builder b(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!d()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if (cipherSuites.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            e((String[]) cipherSuites.clone());
            return this;
        }

        public final Builder c(CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!d()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (CipherSuite cipherSuite : cipherSuites) {
                arrayList.add(cipherSuite.c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            return b((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final boolean d() {
            return this.f144031a;
        }

        public final void e(String[] strArr) {
            this.f144032b = strArr;
        }

        public final void f(boolean z2) {
            this.f144034d = z2;
        }

        public final void g(String[] strArr) {
            this.f144033c = strArr;
        }

        public final Builder h(boolean z2) {
            if (!d()) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections");
            }
            f(z2);
            return this;
        }

        public final Builder i(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!d()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if (tlsVersions.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            g((String[]) tlsVersions.clone());
            return this;
        }

        public final Builder j(TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (!d()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                arrayList.add(tlsVersion.b());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            return i((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public Builder(ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.f144031a = connectionSpec.f();
            this.f144032b = connectionSpec.f144029c;
            this.f144033c = connectionSpec.f144030d;
            this.f144034d = connectionSpec.h();
        }
    }
}
