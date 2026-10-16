package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ConnectionSpec {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CipherSuite[] f92897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConnectionSpec f92898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConnectionSpec f92899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConnectionSpec f92900h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f92901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f92902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f92903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f92904d;

    static {
        CipherSuite[] cipherSuiteArr = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f92897e = cipherSuiteArr;
        Builder builderF = new Builder(true).f(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_2;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_1;
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        ConnectionSpec connectionSpecE = builderF.i(tlsVersion, tlsVersion2, tlsVersion3).h(true).e();
        f92898f = connectionSpecE;
        f92899g = new Builder(connectionSpecE).i(tlsVersion3).h(true).e();
        f92900h = new Builder(false).e();
    }

    private static boolean h(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                if (Util.f(strArr2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private ConnectionSpec i(SSLSocket sSLSocket, boolean z2) {
        String[] strArr = this.f92903c;
        String[] enabledCipherSuites = strArr != null ? (String[]) Util.n(String.class, strArr, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] strArr2 = this.f92904d;
        String[] enabledProtocols = strArr2 != null ? (String[]) Util.n(String.class, strArr2, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z2 && Util.f(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = Util.e(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).g(enabledCipherSuites).j(enabledProtocols).e();
    }

    void e(SSLSocket sSLSocket, boolean z2) {
        ConnectionSpec connectionSpecI = i(sSLSocket, z2);
        String[] strArr = connectionSpecI.f92904d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = connectionSpecI.f92903c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z2 = this.f92901a;
        if (z2 != connectionSpec.f92901a) {
            return false;
        }
        return !z2 || (Arrays.equals(this.f92903c, connectionSpec.f92903c) && Arrays.equals(this.f92904d, connectionSpec.f92904d) && this.f92902b == connectionSpec.f92902b);
    }

    public List f() {
        String[] strArr = this.f92903c;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.f92903c;
            if (i3 >= strArr2.length) {
                return Util.k(cipherSuiteArr);
            }
            cipherSuiteArr[i3] = CipherSuite.a(strArr2[i3]);
            i3++;
        }
    }

    public boolean g(SSLSocket sSLSocket) {
        if (!this.f92901a) {
            return false;
        }
        String[] strArr = this.f92904d;
        if (strArr != null && !h(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f92903c;
        return strArr2 == null || h(strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public int hashCode() {
        if (this.f92901a) {
            return ((((527 + Arrays.hashCode(this.f92903c)) * 31) + Arrays.hashCode(this.f92904d)) * 31) + (!this.f92902b ? 1 : 0);
        }
        return 17;
    }

    public boolean j() {
        return this.f92902b;
    }

    public List k() {
        String[] strArr = this.f92904d;
        if (strArr == null) {
            return null;
        }
        TlsVersion[] tlsVersionArr = new TlsVersion[strArr.length];
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.f92904d;
            if (i3 >= strArr2.length) {
                return Util.k(tlsVersionArr);
            }
            tlsVersionArr[i3] = TlsVersion.a(strArr2[i3]);
            i3++;
        }
    }

    public String toString() {
        if (!this.f92901a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f92903c != null ? f().toString() : "[all enabled]") + ", tlsVersions=" + (this.f92904d != null ? k().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f92902b + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f92905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f92906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f92907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f92908d;

        Builder(boolean z2) {
            this.f92905a = z2;
        }

        public ConnectionSpec e() {
            return new ConnectionSpec(this);
        }

        public Builder f(CipherSuite... cipherSuiteArr) {
            if (!this.f92905a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i3 = 0; i3 < cipherSuiteArr.length; i3++) {
                strArr[i3] = cipherSuiteArr[i3].f92888a;
            }
            return g(strArr);
        }

        public Builder g(String... strArr) {
            if (!this.f92905a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f92906b = (String[]) strArr.clone();
            return this;
        }

        public Builder h(boolean z2) {
            if (!this.f92905a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f92908d = z2;
            return this;
        }

        public Builder i(TlsVersion... tlsVersionArr) {
            if (!this.f92905a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i3 = 0; i3 < tlsVersionArr.length; i3++) {
                strArr[i3] = tlsVersionArr[i3].f93046a;
            }
            return j(strArr);
        }

        public Builder j(String... strArr) {
            if (!this.f92905a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f92907c = (String[]) strArr.clone();
            return this;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f92905a = connectionSpec.f92901a;
            this.f92906b = connectionSpec.f92903c;
            this.f92907c = connectionSpec.f92904d;
            this.f92908d = connectionSpec.f92902b;
        }
    }

    private ConnectionSpec(Builder builder) {
        this.f92901a = builder.f92905a;
        this.f92903c = builder.f92906b;
        this.f92904d = builder.f92907c;
        this.f92902b = builder.f92908d;
    }
}
