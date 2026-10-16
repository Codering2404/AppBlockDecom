package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Preconditions;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbof extends zzboj {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcaa f76529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f76530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzbpn f76531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzbjy f76532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f76533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Runnable f76534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f76535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f76536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f76537q;

    protected zzbof(int i3, zzcaa zzcaaVar, zzcal zzcalVar, zzbis zzbisVar) {
        super(i3, zzcaaVar, zzcalVar);
        this.f76532l = zzbjy.a();
        this.f76533m = false;
        this.f76529i = (zzcaa) Preconditions.u(zzcaaVar, "statsTraceCtx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final void A(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        if (this.f76530j) {
            return;
        }
        this.f76530j = true;
        this.f76529i.e(zzbnpVar);
        if (o() != null) {
            o().b(zzbnpVar.j());
        }
        this.f76531k.b(zzbnpVar, zzbpmVar, zzbmgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzboj
    protected final /* synthetic */ zzcad g() {
        return this.f76531k;
    }

    public final void s(zzbpn zzbpnVar) {
        Preconditions.A(this.f76531k == null, "Already called setListener");
        this.f76531k = (zzbpn) Preconditions.u(zzbpnVar, "listener");
    }

    protected final boolean t() {
        return this.f76535o;
    }

    protected final void u(zzbmg zzbmgVar) {
        Preconditions.A(!this.f76536p, "Received headers on closed stream");
        this.f76529i.c(zzbmgVar);
        String str = (String) zzbmgVar.b(zzbsz.f76823d);
        if (str != null) {
            zzbjw zzbjwVarC = this.f76532l.c(str);
            if (zzbjwVarC == null) {
                d(new zzbns(zzbnp.f76495l.e(String.format("Can't find decompressor for %s", str)), null));
                return;
            } else if (zzbjwVarC != zzbjh.f76278a) {
                l(zzbjwVarC);
            }
        }
        this.f76531k.a(zzbmgVar);
    }

    protected final void v(zzbxo zzbxoVar) throws Throwable {
        Preconditions.u(zzbxoVar, "frame");
        boolean z2 = true;
        try {
            if (this.f76536p) {
                zzbog.f76538g.logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundDataReceived", "Received data on closed stream");
                zzbxoVar.close();
                return;
            } else {
                try {
                    k(zzbxoVar);
                    return;
                } catch (Throwable th) {
                    th = th;
                    z2 = false;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (z2) {
            zzbxoVar.close();
        }
        throw th;
    }

    protected final void w(zzbmg zzbmgVar, zzbnp zzbnpVar) {
        Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        Preconditions.u(zzbmgVar, "trailers");
        if (!this.f76536p) {
            this.f76529i.d(zzbmgVar);
            x(zzbnpVar, zzbpm.PROCESSED, false, zzbmgVar);
        } else {
            int i3 = zzbog.f76539h;
            zzbog.f76538g.logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundTrailersReceived", "Received trailers on closed stream:\n {1}\n {2}", new Object[]{zzbnpVar, zzbmgVar});
        }
    }

    public final void x(zzbnp zzbnpVar, zzbpm zzbpmVar, boolean z2, zzbmg zzbmgVar) {
        Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        Preconditions.u(zzbmgVar, "trailers");
        if (this.f76536p) {
            if (!z2) {
                return;
            } else {
                z2 = true;
            }
        }
        this.f76536p = true;
        this.f76537q = zzbnpVar.j();
        n();
        if (this.f76533m) {
            this.f76534n = null;
            A(zzbnpVar, zzbpmVar, zzbmgVar);
        } else {
            this.f76534n = new zzboe(this, zzbnpVar, zzbpmVar, zzbmgVar);
            j(z2);
        }
    }

    final /* synthetic */ void y(zzbjy zzbjyVar) {
        Preconditions.A(this.f76531k == null, "Already called start");
        this.f76532l = (zzbjy) Preconditions.u(zzbjyVar, "decompressorRegistry");
    }

    final /* synthetic */ void z() {
        this.f76535o = true;
    }

    @Override // com.google.android.libraries.places.internal.zzbwe
    public void zzb(boolean z2) {
        Preconditions.A(this.f76536p, "status should have been reported on deframer closed");
        this.f76533m = true;
        if (this.f76537q && z2) {
            x(zzbnp.f76495l.e("Encountered end-of-stream mid-frame"), zzbpm.PROCESSED, true, new zzbmg());
        }
        Runnable runnable = this.f76534n;
        if (runnable != null) {
            runnable.run();
            this.f76534n = null;
        }
    }
}
