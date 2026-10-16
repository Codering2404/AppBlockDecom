package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzccn extends zzccr {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzccm f77568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzccm f77569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzccm f77570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzccm f77571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f77572i;

    public zzccn(zzccm zzccmVar, zzccm zzccmVar2, Method method, Method method2, zzccm zzccmVar3, zzccm zzccmVar4, Provider provider, int i3) {
        super(provider);
        this.f77568e = zzccmVar;
        this.f77569f = zzccmVar2;
        this.f77570g = zzccmVar3;
        this.f77571h = zzccmVar4;
        this.f77572i = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final void a(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f77568e.b(sSLSocket, Boolean.TRUE);
            this.f77569f.b(sSLSocket, str);
        }
        zzccm zzccmVar = this.f77571h;
        if (zzccmVar.a(sSLSocket)) {
            zzccmVar.c(sSLSocket, zzccr.g(list));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final String b(SSLSocket sSLSocket) {
        byte[] bArr;
        zzccm zzccmVar = this.f77570g;
        if (zzccmVar.a(sSLSocket) && (bArr = (byte[]) zzccmVar.c(sSLSocket, new Object[0])) != null) {
            return new String(bArr, zzccu.f77601b);
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzccr
    public final int c() {
        return this.f77572i;
    }
}
