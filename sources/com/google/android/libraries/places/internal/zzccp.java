package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzccp extends zzccr {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f77575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f77576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Method f77577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class f77578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class f77579i;

    public zzccp(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
        super(provider);
        this.f77575e = method;
        this.f77576f = method2;
        this.f77577g = method3;
        this.f77578h = cls;
        this.f77579i = cls2;
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final void a(SSLSocket sSLSocket, String str, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzccs zzccsVar = (zzccs) list.get(i3);
            if (zzccsVar != zzccs.HTTP_1_0) {
                arrayList.add(zzccsVar.toString());
            }
        }
        try {
            this.f77575e.invoke(null, sSLSocket, Proxy.newProxyInstance(zzccr.class.getClassLoader(), new Class[]{this.f77578h, this.f77579i}, new zzccq(arrayList)));
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final String b(SSLSocket sSLSocket) {
        try {
            zzccq zzccqVar = (zzccq) Proxy.getInvocationHandler(this.f77576f.invoke(null, sSLSocket));
            if (!zzccqVar.a() && zzccqVar.b() == null) {
                zzccr.f77583b.logp(Level.INFO, "io.grpc.okhttp.internal.Platform$JdkWithJettyBootPlatform", "getSelectedProtocol", "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            }
            if (zzccqVar.a()) {
                return null;
            }
            return zzccqVar.b();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final int c() {
        return 1;
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final void d(SSLSocket sSLSocket) {
        try {
            this.f77577g.invoke(null, sSLSocket);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException e3) {
            zzccr.f77583b.logp(Level.FINE, "io.grpc.okhttp.internal.Platform$JdkWithJettyBootPlatform", "afterHandshake", "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e3);
        }
    }
}
