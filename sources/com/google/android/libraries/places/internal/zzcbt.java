package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbt extends zzcbu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzccm f77456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzccm f77457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzccm f77458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzccm f77459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzccm f77460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzccm f77461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Method f77462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Method f77463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Method f77464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Method f77465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Method f77466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Method f77467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Constructor f77468q;

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:72|3)|(6:74|4|68|5|64|6)|(2:76|7)|44|70|45|66|46|62|63|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0122, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0124, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0126, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0128, code lost:
    
        com.google.android.libraries.places.internal.zzcbu.f77469b.logp(java.util.logging.Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0138, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013a, code lost:
    
        com.google.android.libraries.places.internal.zzcbu.f77469b.logp(java.util.logging.Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r0);
     */
    static {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcbt.<clinit>():void");
    }

    zzcbt(zzccr zzccrVar) {
        super(zzccrVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcbu
    public final String a(SSLSocket sSLSocket, String str, List list) {
        String strC = c(sSLSocket);
        return strC == null ? super.a(sSLSocket, str, list) : strC;
    }

    @Override // com.google.android.libraries.places.internal.zzcbu
    protected final void b(SSLSocket sSLSocket, String str, List list) {
        Constructor constructor;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzccs) it.next()).toString());
        }
        boolean z2 = false;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (!str.contains("_")) {
                        try {
                            Preconditions.m(zzbsz.b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
                            Method method2 = f77462k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f77456e.b(sSLSocket, Boolean.TRUE);
                            } else {
                                f77463l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f77467p;
                            if (method3 == null || (constructor = f77468q) == null || InetAddresses.f(HostAndPort.a(str).b())) {
                                f77457f.b(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException(e5);
            }
        }
        Method method4 = f77466o;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, null);
                f77464m.invoke(sSLParameters, strArr);
                z2 = true;
            } catch (InvocationTargetException e6) {
                if (!(e6.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e6;
                }
                zzcbu.f77469b.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "configureTlsExtensions", "setApplicationProtocol unsupported, will try old methods");
            }
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z2 && (method = f77465n) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
            return;
        }
        Object[] objArr = {zzccr.g(list)};
        zzccr zzccrVar = this.f77472a;
        if (zzccrVar.c() == 1) {
            f77459h.c(sSLSocket, objArr);
        }
        if (zzccrVar.c() == 3) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        f77461j.c(sSLSocket, objArr);
    }

    @Override // com.google.android.libraries.places.internal.zzcbu
    public final String c(SSLSocket sSLSocket) {
        Method method = f77466o;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e4);
                }
                zzcbu.f77469b.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        if (this.f77472a.c() == 1) {
            try {
                byte[] bArr = (byte[]) f77458g.c(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, zzccu.f77601b);
                }
            } catch (Exception e5) {
                zzcbu.f77469b.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getAlpnSelectedProtocol()", (Throwable) e5);
            }
        }
        if (this.f77472a.c() != 3) {
            try {
                byte[] bArr2 = (byte[]) f77460i.c(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, zzccu.f77601b);
                }
            } catch (Exception e6) {
                zzcbu.f77469b.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getNpnSelectedProtocol()", (Throwable) e6);
            }
        }
        return null;
    }
}
