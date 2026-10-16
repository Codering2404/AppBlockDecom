package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcch {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzccf[] f77548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzcch f77549f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f77550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f77551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f77552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f77553d;

    static {
        zzccf[] zzccfVarArr = {zzccf.TLS_AES_128_GCM_SHA256, zzccf.TLS_AES_256_GCM_SHA384, zzccf.TLS_CHACHA20_POLY1305_SHA256, zzccf.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zzccf.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zzccf.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zzccf.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zzccf.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zzccf.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, zzccf.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, zzccf.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, zzccf.TLS_RSA_WITH_AES_128_GCM_SHA256, zzccf.TLS_RSA_WITH_AES_256_GCM_SHA384, zzccf.TLS_RSA_WITH_AES_128_CBC_SHA, zzccf.TLS_RSA_WITH_AES_256_CBC_SHA, zzccf.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f77548e = zzccfVarArr;
        zzccg zzccgVar = new zzccg(true);
        zzccgVar.a(zzccfVarArr);
        zzcct zzcctVar = zzcct.TLS_1_3;
        zzcct zzcctVar2 = zzcct.TLS_1_2;
        zzccgVar.c(zzcctVar, zzcctVar2);
        zzccgVar.e(true);
        zzcch zzcchVar = new zzcch(zzccgVar);
        f77549f = zzcchVar;
        zzccg zzccgVar2 = new zzccg(zzcchVar);
        zzccgVar2.c(zzcctVar, zzcctVar2, zzcct.TLS_1_1, zzcct.TLS_1_0);
        zzccgVar2.e(true);
    }

    private zzcch(zzccg zzccgVar) {
        this.f77550a = true;
        this.f77551b = zzccgVar.g();
        this.f77552c = zzccgVar.h();
        this.f77553d = zzccgVar.i();
    }

    public final boolean a() {
        return this.f77553d;
    }

    public final void b(SSLSocket sSLSocket, boolean z2) {
        String[] strArr = this.f77551b;
        String[] strArr2 = strArr != null ? (String[]) zzccu.b(String.class, strArr, sSLSocket.getEnabledCipherSuites()) : null;
        String[] strArr3 = (String[]) zzccu.b(String.class, this.f77552c, sSLSocket.getEnabledProtocols());
        zzccg zzccgVar = new zzccg(this);
        zzccgVar.b(strArr2);
        zzccgVar.d(strArr3);
        zzcch zzcchVar = new zzcch(zzccgVar);
        sSLSocket.setEnabledProtocols(zzcchVar.f77552c);
        String[] strArr4 = zzcchVar.f77551b;
        if (strArr4 != null) {
            sSLSocket.setEnabledCipherSuites(strArr4);
        }
    }

    final /* synthetic */ String[] c() {
        return this.f77551b;
    }

    final /* synthetic */ String[] d() {
        return this.f77552c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcch)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzcch zzcchVar = (zzcch) obj;
        return Arrays.equals(this.f77551b, zzcchVar.f77551b) && Arrays.equals(this.f77552c, zzcchVar.f77552c) && this.f77553d == zzcchVar.f77553d;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f77551b) + 527) * 31) + Arrays.hashCode(this.f77552c)) * 31) + (!this.f77553d ? 1 : 0);
    }

    public final String toString() {
        List listA;
        zzcct zzcctVar;
        String[] strArr = this.f77551b;
        if (strArr == null) {
            listA = null;
        } else {
            zzccf[] zzccfVarArr = new zzccf[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                zzccf zzccfVar = zzccf.TLS_RSA_WITH_NULL_MD5;
                zzccfVarArr[i3] = str.startsWith("SSL_") ? zzccf.a("TLS_".concat(String.valueOf(str.substring(4)))) : zzccf.a(str);
            }
            listA = zzccu.a(zzccfVarArr);
        }
        String string = listA == null ? "[use default]" : listA.toString();
        String[] strArr2 = this.f77552c;
        zzcct[] zzcctVarArr = new zzcct[strArr2.length];
        for (int i4 = 0; i4 < strArr2.length; i4++) {
            String str2 = strArr2[i4];
            boolean zEquals = "TLSv1.3".equals(str2);
            zzcct zzcctVar2 = zzcct.TLS_1_3;
            if (zEquals) {
                zzcctVar = zzcct.TLS_1_3;
            } else if ("TLSv1.2".equals(str2)) {
                zzcctVar = zzcct.TLS_1_2;
            } else if ("TLSv1.1".equals(str2)) {
                zzcctVar = zzcct.TLS_1_1;
            } else if ("TLSv1".equals(str2)) {
                zzcctVar = zzcct.TLS_1_0;
            } else {
                if (!"SSLv3".equals(str2)) {
                    throw new IllegalArgumentException("Unexpected TLS version: ".concat(String.valueOf(str2)));
                }
                zzcctVar = zzcct.SSL_3_0;
            }
            zzcctVarArr[i4] = zzcctVar;
        }
        String strValueOf = String.valueOf(zzccu.a(zzcctVarArr));
        boolean z2 = this.f77553d;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 42 + strValueOf.length() + 24 + String.valueOf(z2).length() + 1);
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(string);
        sb.append(", tlsVersions=");
        sb.append(strValueOf);
        sb.append(", supportsTlsExtensions=");
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }

    /* synthetic */ zzcch(zzccg zzccgVar, byte[] bArr) {
        this(zzccgVar);
    }
}
