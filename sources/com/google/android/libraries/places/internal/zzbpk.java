package com.google.android.libraries.places.internal;

import com.facebook.GraphRequest;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpk extends zzbix {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Logger f76606o = Logger.getLogger(zzbpk.class.getName());

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final double f76607p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbml f76608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f76609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f76610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbpb f76611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbjs f76612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbpe f76613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f76614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbis f76615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbpl f76616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f76617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f76618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ScheduledExecutorService f76619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private zzbjy f76620m = zzbjy.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzbur f76621n;

    static {
        "gzip".getBytes(Charset.forName("US-ASCII"));
        f76607p = TimeUnit.SECONDS.toNanos(1L);
    }

    zzbpk(zzbml zzbmlVar, Executor executor, zzbis zzbisVar, zzbur zzburVar, ScheduledExecutorService scheduledExecutorService, zzbpb zzbpbVar, zzbkq zzbkqVar) {
        int i3 = zzbjk.f76280c;
        this.f76608a = zzbmlVar;
        zzbmlVar.b();
        System.identityHashCode(this);
        int i4 = zzcew.f77735a;
        if (executor == MoreExecutors.a()) {
            this.f76609b = new zzbzm();
            this.f76610c = true;
        } else {
            this.f76609b = new zzbzq(executor);
            this.f76610c = false;
        }
        this.f76611d = zzbpbVar;
        this.f76612e = zzbjs.a();
        this.f76614g = zzbmlVar.a() == zzbmj.UNARY || zzbmlVar.a() == zzbmj.SERVER_STREAMING;
        this.f76615h = zzbisVar;
        this.f76621n = zzburVar;
        this.f76619l = scheduledExecutorService;
    }

    static final /* synthetic */ void q(zzbiw zzbiwVar, zzbnp zzbnpVar, zzbmg zzbmgVar) {
        try {
            zzbiwVar.c(zzbnpVar, zzbmgVar);
        } catch (RuntimeException e3) {
            f76606o.logp(Level.WARNING, "io.grpc.internal.ClientCallImpl", "closeObserver", "Exception thrown by onClose() in ClientCall", (Throwable) e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final zzbjv g() {
        zzbjv zzbjvVarB = this.f76615h.b();
        if (zzbjvVarB == null) {
            return null;
        }
        return zzbjvVarB;
    }

    private final void s(Object obj) {
        Preconditions.A(this.f76616i != null, "Not started");
        Preconditions.A(!this.f76617j, "call was cancelled");
        Preconditions.A(!this.f76618k, "call was half-closed");
        try {
            zzbpl zzbplVar = this.f76616i;
            if (zzbplVar instanceof zzbzf) {
                ((zzbzf) zzbplVar).W(obj);
            } else {
                zzbplVar.f(this.f76608a.e(obj));
            }
            if (this.f76614g) {
                return;
            }
            this.f76616i.zzu();
        } catch (Error e3) {
            this.f76616i.c(zzbnp.f76489f.e("Client sendMessage() failed with Error"));
            throw e3;
        } catch (RuntimeException e4) {
            this.f76616i.c(zzbnp.f76489f.d(e4).e("Failed to stream message"));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, zzbmg zzbmgVar) {
        zzbpl zzbuqVar;
        int i3 = zzcew.f77735a;
        Preconditions.A(this.f76616i == null, "Already started");
        Preconditions.A(!this.f76617j, "call was cancelled");
        Preconditions.u(zzbiwVar, "observer");
        Preconditions.u(zzbmgVar, "headers");
        zzbjs zzbjsVar = this.f76612e;
        zzbis zzbisVar = this.f76615h;
        zzbir zzbirVar = zzbvz.f77050g;
        zzbvz zzbvzVar = (zzbvz) zzbisVar.i(zzbirVar);
        if (zzbvzVar != null) {
            Long l3 = zzbvzVar.f77051a;
            if (l3 != null) {
                zzbjv zzbjvVarA = zzbjv.a(l3.longValue(), TimeUnit.NANOSECONDS);
                zzbjv zzbjvVarB = this.f76615h.b();
                if (zzbjvVarB == null || zzbjvVarA.compareTo(zzbjvVarB) < 0) {
                    this.f76615h = this.f76615h.a(zzbjvVarA);
                }
            }
            Boolean bool = zzbvzVar.f77052b;
            if (bool != null) {
                this.f76615h = bool.booleanValue() ? this.f76615h.c() : this.f76615h.d();
            }
            Integer num = zzbvzVar.f77053c;
            if (num != null) {
                Integer numN = this.f76615h.n();
                if (numN != null) {
                    this.f76615h = this.f76615h.l(Math.min(numN.intValue(), num.intValue()));
                } else {
                    this.f76615h = this.f76615h.l(num.intValue());
                }
            }
            Integer num2 = zzbvzVar.f77054d;
            if (num2 != null) {
                Integer numO = this.f76615h.o();
                if (numO != null) {
                    this.f76615h = this.f76615h.m(Math.min(numO.intValue(), num2.intValue()));
                } else {
                    this.f76615h = this.f76615h.m(num2.intValue());
                }
            }
        }
        zzbji zzbjiVar = zzbjh.f76278a;
        zzbjy zzbjyVar = this.f76620m;
        zzbmgVar.d(zzbsz.f76827h);
        zzbmgVar.d(zzbsz.f76823d);
        zzbmc zzbmcVar = zzbsz.f76824e;
        zzbmgVar.d(zzbmcVar);
        byte[] bArrA = zzbks.a(zzbjyVar);
        if (bArrA.length != 0) {
            zzbmgVar.c(zzbmcVar, bArrA);
        }
        zzbmgVar.d(zzbsz.f76825f);
        zzbmgVar.d(zzbsz.f76826g);
        zzbjv zzbjvVarG = g();
        boolean z2 = zzbjvVarG != null && zzbjvVarG.equals(null);
        zzbpe zzbpeVar = new zzbpe(this, zzbjvVarG, z2);
        this.f76613f = zzbpeVar;
        if (zzbjvVarG == null || zzbpeVar.d() > 0) {
            zzbta zzbtaVar = null;
            zzbur zzburVar = this.f76621n;
            zzbml zzbmlVar = this.f76608a;
            zzbis zzbisVar2 = this.f76615h;
            zzbvr zzbvrVar = zzburVar.f76917b;
            if (zzbvrVar.O()) {
                zzbvz zzbvzVar2 = (zzbvz) zzbisVar2.i(zzbirVar);
                zzbzg zzbzgVar = zzbvzVar2 == null ? null : zzbvzVar2.f77055e;
                if (zzbvzVar2 != null) {
                    zzbtaVar = zzbvzVar2.f77056f;
                }
                zzbuqVar = new zzbuq(zzburVar, zzbmlVar, zzbmgVar, zzbisVar2, zzbzgVar, zzbtaVar, zzbjsVar);
            } else {
                zzbje[] zzbjeVarArrF = zzbsz.f(zzbisVar2, zzbmgVar, 0, false, false);
                zzbjs zzbjsVarB = zzbjsVar.b();
                try {
                    zzbuqVar = zzbvrVar.s().e(zzbmlVar, zzbmgVar, zzbisVar2, zzbjeVarArrF);
                } finally {
                    zzbjsVar.c(zzbjsVarB);
                }
            }
            this.f76616i = zzbuqVar;
        } else {
            zzbje[] zzbjeVarArrF2 = zzbsz.f(this.f76615h, zzbmgVar, 0, false, false);
            String str = true != z2 ? "CallOptions" : "Context";
            Long l4 = (Long) this.f76615h.i(zzbje.f76277a);
            double d3 = this.f76613f.d();
            double d4 = f76607p;
            this.f76616i = new zzbsi(zzbnp.f76491h.e(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, Double.valueOf(d3 / d4), Double.valueOf(l4 == null ? 0.0d : l4.longValue() / d4))), zzbpm.PROCESSED, zzbjeVarArrF2);
        }
        if (this.f76610c) {
            this.f76616i.zzr();
        }
        if (this.f76615h.n() != null) {
            this.f76616i.zzc(this.f76615h.n().intValue());
        }
        if (this.f76615h.o() != null) {
            this.f76616i.zzb(this.f76615h.o().intValue());
        }
        if (zzbjvVarG != null) {
            this.f76616i.h(zzbjvVarG);
        }
        this.f76616i.b(zzbjiVar);
        this.f76616i.e(this.f76620m);
        this.f76611d.a();
        this.f76616i.a(new zzbpj(this, zzbiwVar));
        this.f76613f.a();
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void b(Object obj) {
        int i3 = zzcew.f77735a;
        s(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void c(int i3) {
        int i4 = zzcew.f77735a;
        Preconditions.A(this.f76616i != null, "Not started");
        Preconditions.e(true, "Number requested must be non-negative");
        this.f76616i.zzs(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void d() {
        int i3 = zzcew.f77735a;
        Preconditions.A(this.f76616i != null, "Not started");
        Preconditions.A(!this.f76617j, "call was cancelled");
        Preconditions.A(!this.f76618k, "call already half-closed");
        this.f76618k = true;
        this.f76616i.zzk();
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public final void e(String str, Throwable th) {
        int i3 = zzcew.f77735a;
        if (str == null && th == null) {
            CancellationException cancellationException = new CancellationException("Cancelled without a message or cause");
            f76606o.logp(Level.WARNING, "io.grpc.internal.ClientCallImpl", "cancelInternal", "Cancelling without a message or cause is suboptimal", (Throwable) cancellationException);
            th = cancellationException;
        }
        if (this.f76617j) {
            return;
        }
        this.f76617j = true;
        try {
            if (this.f76616i != null) {
                zzbnp zzbnpVar = zzbnp.f76489f;
                zzbnp zzbnpVarE = str != null ? zzbnpVar.e(str) : zzbnpVar.e("Call cancelled without message");
                if (th != null) {
                    zzbnpVarE = zzbnpVarE.d(th);
                }
                this.f76616i.c(zzbnpVarE);
            }
            zzbpe zzbpeVar = this.f76613f;
            if (zzbpeVar != null) {
                zzbpeVar.b();
            }
        } finally {
        }
    }

    final zzbpk f(zzbjy zzbjyVar) {
        this.f76620m = zzbjyVar;
        return this;
    }

    final /* synthetic */ zzbml i() {
        return this.f76608a;
    }

    final /* synthetic */ Executor j() {
        return this.f76609b;
    }

    final /* synthetic */ zzbpb k() {
        return this.f76611d;
    }

    final /* synthetic */ zzbjs l() {
        return this.f76612e;
    }

    final /* synthetic */ zzbpe m() {
        return this.f76613f;
    }

    final /* synthetic */ zzbis n() {
        return this.f76615h;
    }

    final /* synthetic */ zzbpl o() {
        return this.f76616i;
    }

    final /* synthetic */ ScheduledExecutorService p() {
        return this.f76619l;
    }

    public final String toString() {
        return MoreObjects.c(this).d(GraphRequest.BATCH_METHOD_PARAM, this.f76608a).toString();
    }
}
