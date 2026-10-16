package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcco extends zzccr {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f77573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f77574f;

    /* synthetic */ zzcco(Provider provider, Method method, Method method2, byte[] bArr) {
        super(provider);
        this.f77573e = method;
        this.f77574f = method2;
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final void a(SSLSocket sSLSocket, String str, List list) {
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzccs zzccsVar = (zzccs) it.next();
            if (zzccsVar != zzccs.HTTP_1_0) {
                arrayList.add(zzccsVar.toString());
            }
        }
        try {
            this.f77573e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final String b(SSLSocket sSLSocket) {
        try {
            return (String) this.f77574f.invoke(sSLSocket, null);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final int c() {
        return 1;
    }
}
