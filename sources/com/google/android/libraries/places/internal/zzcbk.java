package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f77408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CyclicBarrier f77409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzcat f77410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f77411d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzcbp f77412f;

    zzcbk(zzcbp zzcbpVar, CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier, zzcat zzcatVar, CountDownLatch countDownLatch2) {
        this.f77408a = countDownLatch;
        this.f77409b = cyclicBarrier;
        this.f77410c = zzcatVar;
        this.f77411d = countDownLatch2;
        Objects.requireNonNull(zzcbpVar);
        this.f77412f = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbp zzcbpVar;
        zzcbn zzcbnVar;
        zzcfh zzcfhVarC = zzcfl.c(new zzcbj(this));
        try {
            try {
                try {
                    this.f77408a.await();
                    this.f77409b.await(1000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    zzcbp zzcbpVar2 = this.f77412f;
                    zzcbpVar2.r(new zzcbn(zzcbpVar2, zzcbpVar2.h().b(zzcfhVarC, true)));
                    this.f77411d.countDown();
                    throw th;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (BrokenBarrierException | TimeoutException unused2) {
                zzcbpVar = this.f77412f;
                zzcbpVar.a0(0, zzccv.INTERNAL_ERROR, zzbnp.f76496m.e("Timed out waiting for second handshake thread. The transport executor pool may have run out of threads"));
                zzcbnVar = new zzcbn(zzcbpVar, zzcbpVar.h().b(zzcfhVarC, true));
                zzcbpVar.r(zzcbnVar);
                this.f77411d.countDown();
            }
            zzcbp zzcbpVar3 = this.f77412f;
            zzbki zzbkiVar = zzcbpVar3.P;
            if (zzbkiVar == null) {
                zzcbpVar3.d0(zzcbpVar3.x().createSocket(zzcbpVar3.f().getAddress(), zzcbpVar3.f().getPort()));
            } else {
                if (!(zzbkiVar.c() instanceof InetSocketAddress)) {
                    zzbnp zzbnpVar = zzbnp.f76495l;
                    String strValueOf = String.valueOf(zzbkiVar.c().getClass());
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 41);
                    sb.append("Unsupported SocketAddress implementation ");
                    sb.append(strValueOf);
                    throw new zzbnq(zzbnpVar.e(sb.toString()), null);
                }
                zzcbpVar3.d0(zzcbpVar3.Y(zzbkiVar.d(), (InetSocketAddress) zzbkiVar.c(), zzbkiVar.b(), zzbkiVar.a()));
            }
            if (zzcbpVar3.y() != null) {
                SSLSocketFactory sSLSocketFactoryY = zzcbpVar3.y();
                HostnameVerifier hostnameVerifierZ = zzcbpVar3.z();
                Socket socketC0 = zzcbpVar3.c0();
                String strR = zzcbpVar3.R();
                int iS = zzcbpVar3.S();
                zzcch zzcchVarC = zzcbpVar3.C();
                List list = zzcbw.f77474a;
                Preconditions.u(sSLSocketFactoryY, "sslSocketFactory");
                Preconditions.u(socketC0, "socket");
                Preconditions.u(zzcchVarC, "spec");
                SSLSocket sSLSocket = (SSLSocket) sSLSocketFactoryY.createSocket(socketC0, strR, iS, true);
                zzcchVarC.b(sSLSocket, false);
                String strA = zzcbu.d().a(sSLSocket, strR, zzcchVarC.a() ? zzcbw.f77474a : null);
                List list2 = zzcbw.f77474a;
                boolean zContains = list2.contains(zzccs.a(strA));
                String strValueOf2 = String.valueOf(list2);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 50);
                sb2.append("Only ");
                sb2.append(strValueOf2);
                sb2.append(" are supported, but negotiated protocol is %s");
                Preconditions.D(zContains, sb2.toString(), strA);
                if (!hostnameVerifierZ.verify((strR.startsWith("[") && strR.endsWith("]")) ? strR.substring(1, strR.length() - 1) : strR, sSLSocket.getSession())) {
                    throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(strR));
                }
                zzcbpVar3.f0(sSLSocket.getSession());
                zzcbpVar3.d0(sSLSocket);
            }
            zzcbpVar3.c0().setTcpNoDelay(true);
            zzcfh zzcfhVarC2 = zzcfl.c(zzcfl.b(zzcbpVar3.c0()));
            this.f77410c.b(zzcfl.a(zzcbpVar3.c0()), zzcbpVar3.c0());
            zzbim zzbimVarC = zzcbpVar3.s().c();
            zzbimVarC.a(zzbkg.f76317a, zzcbpVar3.c0().getRemoteSocketAddress());
            zzbimVarC.a(zzbkg.f76318b, zzcbpVar3.c0().getLocalSocketAddress());
            zzbimVarC.a(zzbkg.f76319c, zzcbpVar3.e0());
            zzbimVarC.a(zzbsr.f76800a, zzcbpVar3.e0() == null ? zzbni.NONE : zzbni.PRIVACY_AND_INTEGRITY);
            zzcbpVar3.t(zzbimVarC.c());
            zzcbpVar3.r(new zzcbn(zzcbpVar3, zzcbpVar3.h().b(zzcfhVarC2, true)));
            this.f77411d.countDown();
            synchronized (zzcbpVar3.l()) {
                try {
                    zzcbpVar3.A((Socket) Preconditions.u(zzcbpVar3.c0(), "socket"));
                    if (zzcbpVar3.e0() != null) {
                    }
                } finally {
                }
            }
        } catch (zzbnq e3) {
            this.f77412f.a0(0, zzccv.INTERNAL_ERROR, e3.a());
            zzcbpVar = this.f77412f;
            zzcbnVar = new zzcbn(zzcbpVar, zzcbpVar.h().b(zzcfhVarC, true));
            zzcbpVar.r(zzcbnVar);
            this.f77411d.countDown();
        } catch (Exception e4) {
            zzcbp zzcbpVar4 = this.f77412f;
            zzcbpVar4.d(e4);
            zzcbpVar = zzcbpVar4;
            zzcbnVar = new zzcbn(zzcbpVar, zzcbpVar.h().b(zzcfhVarC, true));
            zzcbpVar.r(zzcbnVar);
            this.f77411d.countDown();
        }
    }
}
