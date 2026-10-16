package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzccr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f77583b = Logger.getLogger(zzccr.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f77584c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzccr f77585d = h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f77586a;

    public zzccr(Provider provider) {
        this.f77586a = provider;
    }

    public static zzccr e() {
        return f77585d;
    }

    public static byte[] g(List list) {
        zzcff zzcffVar = new zzcff();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzccs zzccsVar = (zzccs) list.get(i3);
            if (zzccsVar != zzccs.HTTP_1_0) {
                zzcffVar.a(zzccsVar.toString().length());
                zzcffVar.N(zzccsVar.toString());
            }
        }
        return zzcffVar.zzr(zzcffVar.zzb());
    }

    private static zzccr h() throws NoSuchMethodException {
        Provider provider;
        Provider provider2;
        Method method;
        Method method2;
        Method method3;
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        int i3 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                provider = null;
                break;
            }
            Provider provider3 = providers[i3];
            String[] strArr = f77584c;
            int length2 = strArr.length;
            for (int i4 = 0; i4 < 5; i4++) {
                String str = strArr[i4];
                if (str.equals(provider3.getClass().getName())) {
                    f77583b.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "getAndroidSecurityProvider", "Found registered provider {0}", str);
                    provider = provider3;
                    break loop0;
                }
            }
            i3++;
        }
        if (provider != null) {
            zzccm zzccmVar = new zzccm(null, "setUseSessionTickets", Boolean.TYPE);
            zzccm zzccmVar2 = new zzccm(null, "setHostname", String.class);
            zzccm zzccmVar3 = new zzccm(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            zzccm zzccmVar4 = new zzccm(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = method;
                    method3 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = method;
                    method3 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            int i5 = 1;
            if (!provider.getName().equals("GmsCore_OpenSSL") && !provider.getName().equals("Conscrypt") && !provider.getName().equals("Ssl_Guard")) {
                try {
                    zzccr.class.getClassLoader().loadClass("android.net.Network");
                } catch (ClassNotFoundException e3) {
                    f77583b.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "isAtLeastAndroid5", "Can't find class", (Throwable) e3);
                    try {
                        zzccr.class.getClassLoader().loadClass("android.app.ActivityOptions");
                        i5 = 2;
                    } catch (ClassNotFoundException e4) {
                        f77583b.logp(Level.FINE, "io.grpc.okhttp.internal.Platform", "isAtLeastAndroid41", "Can't find class", (Throwable) e4);
                        i5 = 3;
                    }
                }
            }
            return new zzccn(zzccmVar, zzccmVar2, method2, method3, zzccmVar3, zzccmVar4, provider, i5);
        }
        try {
            Provider provider4 = SSLContext.getDefault().getProvider();
            try {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS", provider4);
                    sSLContext.init(null, null, null);
                    SSLEngine.class.getMethod("getApplicationProtocol", null).invoke(sSLContext.createSSLEngine(), null);
                    return new zzcco(provider4, SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null), null);
                } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                    provider2 = provider4;
                    return new zzccr(provider2);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException unused4) {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                StringBuilder sb = new StringBuilder(36);
                sb.append("org.eclipse.jetty.alpn.ALPN");
                sb.append("$Provider");
                Class<?> cls3 = Class.forName(sb.toString());
                StringBuilder sb2 = new StringBuilder(42);
                sb2.append("org.eclipse.jetty.alpn.ALPN");
                sb2.append("$ClientProvider");
                Class<?> cls4 = Class.forName(sb2.toString());
                StringBuilder sb3 = new StringBuilder(42);
                sb3.append("org.eclipse.jetty.alpn.ALPN");
                sb3.append("$ServerProvider");
                try {
                    return new zzccp(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), cls4, Class.forName(sb3.toString()), provider4);
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    provider2 = provider4;
                    return new zzccr(provider2);
                }
            }
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public int c() {
        return 3;
    }

    public final Provider f() {
        return this.f77586a;
    }

    public void d(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List list) {
    }
}
