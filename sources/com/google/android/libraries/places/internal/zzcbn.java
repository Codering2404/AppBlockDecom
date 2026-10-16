package com.google.android.libraries.places.internal;

import com.facebook.AuthenticationToken;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbn implements Runnable, zzccw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcbs f77416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzccx f77417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f77418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzcbp f77419d;

    zzcbn(zzcbp zzcbpVar, zzccx zzccxVar) {
        Objects.requireNonNull(zzcbpVar);
        this.f77419d = zzcbpVar;
        this.f77416a = new zzcbs(Level.FINE, zzcbp.class);
        this.f77418c = true;
        this.f77417b = zzccxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void G(int i3, zzccv zzccvVar) {
        boolean z2 = true;
        this.f77416a.c(1, i3, zzccvVar);
        zzbnp zzbnpVarF = zzcbp.W(zzccvVar).f("Rst Stream");
        if (zzbnpVarF.g() != zzbnm.CANCELLED && zzbnpVarF.g() != zzbnm.DEADLINE_EXCEEDED) {
            z2 = false;
        }
        boolean z3 = z2;
        zzcbp zzcbpVar = this.f77419d;
        synchronized (zzcbpVar.l()) {
            try {
                zzcbg zzcbgVar = (zzcbg) zzcbpVar.m().get(Integer.valueOf(i3));
                if (zzcbgVar != null) {
                    zzcbgVar.B().M();
                    int i4 = zzcew.f77735a;
                    zzcbpVar.T(i3, zzbnpVarF, zzccvVar == zzccv.REFUSED_STREAM ? zzbpm.REFUSED : zzbpm.PROCESSED, z3, null, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void H(boolean z2, int i3, zzcfh zzcfhVar, int i4, int i5) {
        this.f77416a.a(1, i3, zzcfhVar.zze(), i4, z2);
        zzcbp zzcbpVar = this.f77419d;
        zzcbg zzcbgVarV = zzcbpVar.V(i3);
        if (zzcbgVarV != null) {
            long j3 = i4;
            zzcfhVar.zzg(j3);
            zzcff zzcffVar = new zzcff();
            zzcffVar.i2(zzcfhVar.zze(), j3);
            zzcbgVarV.B().M();
            int i6 = zzcew.f77735a;
            synchronized (this.f77419d.l()) {
                zzcbgVarV.B().L(zzcffVar, z2, i5 - i4);
            }
        } else {
            if (!zzcbpVar.U(i3)) {
                zzcbp zzcbpVar2 = this.f77419d;
                zzccv zzccvVar = zzccv.PROTOCOL_ERROR;
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 34);
                sb.append("Received data for unknown stream: ");
                sb.append(i3);
                zzcbpVar2.Z(zzccvVar, sb.toString());
                return;
            }
            synchronized (zzcbpVar.l()) {
                zzcbpVar.j().G(i3, zzccv.STREAM_CLOSED);
            }
            zzcfhVar.x0(i4);
        }
        zzcbp zzcbpVar3 = this.f77419d;
        zzcbpVar3.p(zzcbpVar3.o() + i5);
        if (zzcbpVar3.o() >= zzcbpVar3.g() * 0.5f) {
            synchronized (zzcbpVar3.l()) {
                zzcbpVar3.j().E1(0, zzcbpVar3.o());
            }
            this.f77419d.p(0);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void I(boolean z2, boolean z3, int i3, int i4, List list, int i5) {
        boolean z4 = true;
        this.f77416a.b(1, i3, list, z3);
        zzcbp zzcbpVar = this.f77419d;
        zzbnp zzbnpVarE = null;
        if (zzcbpVar.F() != Integer.MAX_VALUE) {
            long j3 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                zzccz zzcczVar = (zzccz) list.get(i6);
                j3 += (long) (zzcczVar.f77627a.j() + 32 + zzcczVar.f77628b.j());
            }
            int iMin = (int) Math.min(j3, 2147483647L);
            if (iMin > zzcbpVar.F()) {
                zzbnpVarE = zzbnp.f76493j.e(String.format(Locale.US, "Response %s metadata larger than %d: %d", true != z3 ? AuthenticationToken.HEADER_KEY : "trailer", Integer.valueOf(zzcbpVar.F()), Integer.valueOf(iMin)));
            }
        }
        synchronized (zzcbpVar.l()) {
            try {
                zzcbg zzcbgVar = (zzcbg) zzcbpVar.m().get(Integer.valueOf(i3));
                if (zzcbgVar == null) {
                    if (zzcbpVar.U(i3)) {
                        zzcbpVar.j().G(i3, zzccv.STREAM_CLOSED);
                    }
                } else if (zzbnpVarE == null) {
                    zzcbgVar.B().M();
                    int i7 = zzcew.f77735a;
                    zzcbgVar.B().K(list, z3);
                } else {
                    if (!z3) {
                        zzcbpVar.j().G(i3, zzccv.CANCEL);
                    }
                    zzcbgVar.B().x(zzbnpVarE, zzbpm.PROCESSED, false, new zzbmg());
                }
                z4 = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            zzcbp zzcbpVar2 = this.f77419d;
            zzccv zzccvVar = zzccv.PROTOCOL_ERROR;
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 36);
            sb.append("Received header for unknown stream: ");
            sb.append(i3);
            zzcbpVar2.Z(zzccvVar, sb.toString());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void J(boolean z2, int i3, int i4) {
        zzbtd zzbtdVar;
        long j3 = (((long) i3) << 32) | (((long) i4) & 4294967295L);
        this.f77416a.f(1, j3);
        if (!z2) {
            zzcbp zzcbpVar = this.f77419d;
            synchronized (zzcbpVar.l()) {
                zzcbpVar.j().L0(true, i3, i4);
            }
            return;
        }
        zzcbp zzcbpVar2 = this.f77419d;
        synchronized (zzcbpVar2.l()) {
            try {
                zzbtdVar = null;
                if (zzcbpVar2.v() == null) {
                    zzcbp.S.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", "Received unexpected ping ack. No ping outstanding");
                } else if (zzcbpVar2.v().a() == j3) {
                    zzbtd zzbtdVarV = zzcbpVar2.v();
                    zzcbpVar2.w(null);
                    zzbtdVar = zzbtdVarV;
                } else {
                    zzcbp.S.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(zzcbpVar2.v().a()), Long.valueOf(j3)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzbtdVar != null) {
            zzbtdVar.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzccw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void K(int r6, long r7) {
        /*
            r5 = this;
            com.google.android.libraries.places.internal.zzcbs r0 = r5.f77416a
            r1 = 1
            r0.j(r1, r6, r7)
            com.google.android.libraries.places.internal.zzcbp r0 = r5.f77419d
            java.lang.Object r2 = r0.l()
            monitor-enter(r2)
            if (r6 != 0) goto L1c
            com.google.android.libraries.places.internal.zzccd r6 = r0.k()     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            int r7 = (int) r7     // Catch: java.lang.Throwable -> L1a
            r6.b(r0, r7)     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            return
        L1a:
            r6 = move-exception
            goto L6b
        L1c:
            java.util.Map r3 = r0.m()     // Catch: java.lang.Throwable -> L1a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L1a
            com.google.android.libraries.places.internal.zzcbg r3 = (com.google.android.libraries.places.internal.zzcbg) r3     // Catch: java.lang.Throwable -> L1a
            r4 = 0
            if (r3 == 0) goto L3f
            com.google.android.libraries.places.internal.zzccd r0 = r0.k()     // Catch: java.lang.Throwable -> L1a
            com.google.android.libraries.places.internal.zzcbf r1 = r3.B()     // Catch: java.lang.Throwable -> L1a
            com.google.android.libraries.places.internal.zzcca r1 = r1.O()     // Catch: java.lang.Throwable -> L1a
            int r7 = (int) r7     // Catch: java.lang.Throwable -> L1a
            r0.b(r1, r7)     // Catch: java.lang.Throwable -> L1a
        L3d:
            r1 = r4
            goto L45
        L3f:
            boolean r7 = r0.U(r6)     // Catch: java.lang.Throwable -> L1a
            if (r7 != 0) goto L3d
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L6a
            com.google.android.libraries.places.internal.zzcbp r7 = r5.f77419d
            com.google.android.libraries.places.internal.zzccv r8 = com.google.android.libraries.places.internal.zzccv.PROTOCOL_ERROR
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 43
            r1.<init>(r0)
            java.lang.String r0 = "Received window_update for unknown stream: "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r7.Z(r8, r6)
        L6a:
            return
        L6b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcbn.K(int, long):void");
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void L(int i3, zzccv zzccvVar, zzcfj zzcfjVar) {
        this.f77416a.i(1, i3, zzccvVar, zzcfjVar);
        if (zzccvVar == zzccv.ENHANCE_YOUR_CALM) {
            String strE = zzcfjVar.e();
            boolean z2 = zzcbp.T;
            zzcbp.S.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "goAway", String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strE));
            if ("too_many_pings".equals(strE)) {
                this.f77419d.E().run();
            }
        }
        zzbnp zzbnpVarF = zzbsx.a(zzccvVar.f77621a).f("Received Goaway");
        if (zzcfjVar.j() > 0) {
            zzbnpVarF = zzbnpVarF.f(zzcfjVar.e());
        }
        this.f77419d.a0(i3, null, zzbnpVarF);
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void M(boolean z2, zzcdk zzcdkVar) {
        boolean zA;
        this.f77416a.e(1, zzcdkVar);
        zzcbp zzcbpVar = this.f77419d;
        synchronized (zzcbpVar.l()) {
            try {
                if (zzcdkVar.b(4)) {
                    zzcbpVar.B(zzcdkVar.c(4));
                }
                if (zzcdkVar.b(7)) {
                    zA = zzcbpVar.k().a(zzcdkVar.c(7));
                } else {
                    zA = false;
                }
                if (this.f77418c) {
                    zzbwc zzbwcVarI = zzcbpVar.i();
                    zzbio zzbioVarS = zzcbpVar.s();
                    zzbwcVarI.b(zzbioVarS);
                    zzcbpVar.t(zzbioVarS);
                    zzcbpVar.i().zzb();
                    this.f77418c = false;
                }
                zzcbpVar.j().v2(zzcdkVar);
                if (zA) {
                    zzcbpVar.k().f();
                }
                zzcbpVar.X();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccw
    public final void N(int i3, int i4, List list) {
        this.f77416a.h(1, i3, i4, list);
        zzcbp zzcbpVar = this.f77419d;
        synchronized (zzcbpVar.l()) {
            zzcbpVar.j().G(i3, zzccv.PROTOCOL_ERROR);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbnp zzbnpVarU;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.f77417b.a0(this)) {
            try {
                zzcbp zzcbpVar = this.f77419d;
                if (zzcbpVar.D() != null) {
                    zzcbpVar.D().a();
                }
            } catch (Throwable th) {
                try {
                    this.f77419d.a0(0, zzccv.PROTOCOL_ERROR, zzbnp.f76495l.e("error in frame handler").d(th));
                } catch (Throwable th2) {
                    try {
                        this.f77417b.close();
                    } catch (IOException e3) {
                        zzcbp.S.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e3);
                    } catch (RuntimeException e4) {
                        if (!"bio == null".equals(e4.getMessage())) {
                            throw e4;
                        }
                    }
                    this.f77419d.i().zze();
                    Thread.currentThread().setName(name);
                    throw th2;
                }
            }
        }
        zzcbp zzcbpVar2 = this.f77419d;
        synchronized (zzcbpVar2.l()) {
            zzbnpVarU = zzcbpVar2.u();
        }
        if (zzbnpVarU == null) {
            zzbnpVarU = zzbnp.f76496m.e("End of stream or IOException");
        }
        this.f77419d.a0(0, zzccv.INTERNAL_ERROR, zzbnpVarU);
        try {
            this.f77417b.close();
        } catch (IOException e5) {
            zzcbp.S.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e5);
        } catch (RuntimeException e6) {
            if (!"bio == null".equals(e6.getMessage())) {
                throw e6;
            }
        }
        this.f77419d.i().zze();
        Thread.currentThread().setName(name);
    }
}
