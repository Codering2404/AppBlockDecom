package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbc implements zzbpq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbwo f77374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Executor f77375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbwo f77376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ScheduledExecutorService f77377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzcaj f77378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final SSLSocketFactory f77379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final zzcch f77380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzboo f77381i = new zzboo("keepalive time nanos", Long.MAX_VALUE);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f77382j;

    /* synthetic */ zzcbc(zzbwo zzbwoVar, zzbwo zzbwoVar2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, zzcch zzcchVar, int i3, boolean z2, long j3, long j4, int i4, boolean z3, int i5, zzcaj zzcajVar, boolean z4, zzbiu zzbiuVar, byte[] bArr) {
        this.f77374a = zzbwoVar;
        this.f77375b = (Executor) zzbwoVar.zza();
        this.f77376c = zzbwoVar2;
        this.f77377d = (ScheduledExecutorService) zzbwoVar2.zza();
        this.f77379g = sSLSocketFactory;
        this.f77380h = zzcchVar;
        this.f77378f = (zzcaj) Preconditions.u(zzcajVar, "transportTracerFactory");
    }

    @Override // com.google.android.libraries.places.internal.zzbpq, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f77382j) {
            return;
        }
        this.f77382j = true;
        this.f77374a.zzb(this.f77375b);
        this.f77376c.zzb(this.f77377d);
    }

    @Override // com.google.android.libraries.places.internal.zzbpq
    public final zzbqa l1(SocketAddress socketAddress, zzbpp zzbppVar, zzbiv zzbivVar) {
        if (this.f77382j) {
            throw new IllegalStateException("The transport factory is closed.");
        }
        return new zzcbp(this, (InetSocketAddress) socketAddress, zzbppVar.a(), zzbppVar.e(), zzbppVar.c(), zzbppVar.g(), new zzcbb(this, this.f77381i.a()), null);
    }

    @Override // com.google.android.libraries.places.internal.zzbpq
    public final ScheduledExecutorService zzb() {
        return this.f77377d;
    }
}
