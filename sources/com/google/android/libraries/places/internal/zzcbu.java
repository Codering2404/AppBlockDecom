package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzcbu {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f77469b = Logger.getLogger(zzcbu.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzccr f77470c = zzccr.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcbu f77471d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzccr f77472a;

    static {
        zzcbu zzcbuVar;
        ClassLoader classLoader = zzcbu.class.getClassLoader();
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e3) {
            f77469b.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator", "createNegotiator", "Unable to find Conscrypt. Skipping", (Throwable) e3);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e4) {
                f77469b.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator", "createNegotiator", "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e4);
                zzcbuVar = new zzcbu(f77470c);
            }
        }
        zzcbuVar = new zzcbt(f77470c);
        f77471d = zzcbuVar;
    }

    zzcbu(zzccr zzccrVar) {
        this.f77472a = (zzccr) Preconditions.u(zzccrVar, "platform");
    }

    public static zzcbu d() {
        return f77471d;
    }

    public String a(SSLSocket sSLSocket, String str, List list) {
        if (list != null) {
            b(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strC = c(sSLSocket);
            if (strC != null) {
                return strC;
            }
            String strValueOf = String.valueOf(list);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 44);
            sb.append("TLS ALPN negotiation failed with protocols: ");
            sb.append(strValueOf);
            throw new RuntimeException(sb.toString());
        } finally {
            this.f77472a.d(sSLSocket);
        }
    }

    protected void b(SSLSocket sSLSocket, String str, List list) {
        this.f77472a.a(sSLSocket, str, list);
    }

    public String c(SSLSocket sSLSocket) {
        return this.f77472a.b(sSLSocket);
    }
}
