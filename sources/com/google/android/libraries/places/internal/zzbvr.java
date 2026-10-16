package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvr extends zzblw implements zzbkt {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    static final Logger f76976e0 = Logger.getLogger(zzbvr.class.getName());

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    static final zzbnp f76977f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    static final zzbnp f76978g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    static final zzbnp f76979h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final zzbwb f76980i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final zzbkq f76981j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final zzblh f76982k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final zzbix f76983l0;
    private Collection A;
    private final Object B;
    private final Set C;
    private final zzbrb D;
    private final zzbvq E;
    private final AtomicBoolean F;
    private boolean G;
    private boolean H;
    private volatile boolean I;
    private final CountDownLatch J;
    private final zzbpa K;
    private final zzbpb L;
    private final zzbpd M;
    private final zzbiv N;
    private final zzbkn O;
    private final zzbvl P;
    private zzbwb Q;
    private boolean R;
    private final boolean S;
    private final zzbyo T;
    private final long U;
    private final long V;
    private final boolean W;
    private final zzbwc X;
    final zzbte Y;
    private final zzbur Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbku f76984a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final zzbxv f76985a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76986b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final zzbmo f76987b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final URI f76988c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f76989c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbmz f76990d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final zzbsg f76991d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbmr f76992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbov f76993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbpq f76994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbvm f76995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f76996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbwo f76997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbuv f76998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzbuv f76999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzcag f77000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final zzbnx f77001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final zzbjy f77002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Supplier f77003p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f77004q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final zzbqc f77005r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final zzbit f77006s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f77007t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f77008u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private zzbmy f77009v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f77010w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private zzbuz f77011x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f77012y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Set f77013z;

    static {
        zzbnp zzbnpVar = zzbnp.f76496m;
        f76977f0 = zzbnpVar.e("Channel shutdownNow invoked");
        f76978g0 = zzbnpVar.e("Channel shutdown invoked");
        f76979h0 = zzbnpVar.e("Subchannel shutdown invoked");
        f76980i0 = new zzbwb(null, new HashMap(), new HashMap(), null, null, null);
        f76981j0 = new zzbui();
        f76982k0 = new zzbun();
        f76983l0 = new zzbup();
    }

    zzbvr(zzbvw zzbvwVar, zzbpq zzbpqVar, URI uri, zzbmz zzbmzVar, zzbsg zzbsgVar, zzbwo zzbwoVar, Supplier supplier, List list, zzcag zzcagVar) {
        zzbnx zzbnxVar = new zzbnx(new zzbuo(this));
        this.f77001n = zzbnxVar;
        this.f77005r = new zzbqc();
        this.f77013z = new HashSet(16, 0.75f);
        this.B = new Object();
        this.C = new HashSet(1, 0.75f);
        byte[] bArr = null;
        this.E = new zzbvq(this, bArr);
        this.F = new AtomicBoolean(false);
        this.J = new CountDownLatch(1);
        this.f76989c0 = 1;
        this.Q = f76980i0;
        this.R = false;
        this.T = new zzbyo();
        int i3 = zzbjv.f76300i;
        zzbuu zzbuuVar = new zzbuu(this, bArr);
        this.X = zzbuuVar;
        this.Y = new zzbuw(this, null);
        this.Z = new zzbur(this, null);
        String str = (String) Preconditions.u(zzbvwVar.f77029f, "target");
        this.f76986b = str;
        zzbku zzbkuVarB = zzbku.b("Channel", str);
        this.f76984a = zzbkuVarB;
        this.f77000m = (zzcag) Preconditions.u(zzcagVar, "timeProvider");
        zzbwo zzbwoVar2 = (zzbwo) Preconditions.u(zzbvwVar.f77024a, "executorPool");
        this.f76997j = zzbwoVar2;
        Executor executor = (Executor) Preconditions.u((Executor) zzbwoVar2.zza(), "executor");
        this.f76996i = executor;
        zzbuv zzbuvVar = new zzbuv((zzbwo) Preconditions.u(zzbvwVar.f77025b, "offloadExecutorPool"));
        this.f76999l = zzbuvVar;
        zzboz zzbozVar = new zzboz(zzbpqVar, null, zzbuvVar);
        this.f76994g = zzbozVar;
        new zzboz(zzbpqVar, null, zzbuvVar);
        zzbvm zzbvmVar = new zzbvm(zzbozVar.zzb(), null);
        this.f76995h = zzbvmVar;
        long jZza = zzcagVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 14);
        sb.append("Channel for '");
        sb.append(str);
        sb.append("'");
        zzbpd zzbpdVar = new zzbpd(zzbkuVarB, 0, jZza, sb.toString());
        this.M = zzbpdVar;
        zzbpc zzbpcVar = new zzbpc(zzbpdVar, zzcagVar);
        this.N = zzbpcVar;
        zzbnh zzbnhVar = zzbsz.f76832m;
        this.W = true;
        zzbov zzbovVar = new zzbov(zzblt.a(), zzbvwVar.f77031h);
        this.f76993f = zzbovVar;
        this.f76988c = (URI) Preconditions.u(uri, "targetUri");
        this.f76990d = (zzbmz) Preconditions.u(zzbmzVar, "nameResolverProvider");
        zzbzl zzbzlVar = new zzbzl(true, 5, 5, zzbovVar);
        zzbwm zzbwmVar = new zzbwm(zzbvwVar.f77036m, zzbmn.a());
        this.f76987b0 = zzbwmVar;
        zzbmq zzbmqVarG = zzbmr.g();
        zzbvwVar.d();
        zzbmqVarG.a(443);
        zzbmqVarG.b(zzbnhVar);
        zzbmqVarG.c(zzbnxVar);
        zzbmqVarG.d(zzbvmVar);
        zzbmqVarG.e(zzbzlVar);
        zzbmqVarG.f(zzbpcVar);
        zzbmqVarG.g(zzbuvVar);
        zzbmqVarG.h(zzbwmVar);
        zzbmqVarG.i(zzbvwVar.f77027d);
        zzbmr zzbmrVarJ = zzbmqVarG.j();
        this.f76992e = zzbmrVarJ;
        this.f77009v = Y(uri, null, zzbmzVar, zzbmrVarJ);
        this.f76998k = new zzbuv(zzbwoVar);
        zzbrb zzbrbVar = new zzbrb(executor, zzbnxVar);
        this.D = zzbrbVar;
        zzbrbVar.b(zzbuuVar);
        this.f76991d0 = zzbsgVar;
        this.S = true;
        zzbvl zzbvlVar = new zzbvl(this, this.f77009v.a(), null);
        this.P = zzbvlVar;
        this.f77006s = zzbja.a(zzbvlVar, list);
        this.f77007t = new ArrayList(zzbvwVar.f77028e);
        this.f77003p = (Supplier) Preconditions.u(supplier, "stopwatchSupplier");
        long j3 = zzbvwVar.f77034k;
        if (j3 == -1) {
            this.f77004q = -1L;
        } else {
            Preconditions.k(j3 >= zzbvw.f77018r, "invalid idleTimeoutMillis %s", j3);
            this.f77004q = zzbvwVar.f77034k;
        }
        this.f76985a0 = new zzbxv(new zzbux(this, null), zzbnxVar, zzbozVar.zzb(), Stopwatch.d());
        this.f77002o = (zzbjy) Preconditions.u(zzbvwVar.f77032i, "decompressorRegistry");
        this.f77008u = zzbvwVar.f77030g;
        this.V = 16777216L;
        this.U = 1048576L;
        zzbuk zzbukVar = new zzbuk(this, zzcagVar);
        this.K = zzbukVar;
        this.L = zzbukVar.zza();
        zzbkn zzbknVar = (zzbkn) Preconditions.t(zzbvwVar.f77035l);
        this.O = zzbknVar;
        zzbknVar.c(this);
    }

    private final void V(boolean z2) {
        this.f77001n.b();
        if (z2) {
            Preconditions.A(this.f77010w, "nameResolver is not started");
            Preconditions.A(this.f77011x != null, "lbHelper is null");
        }
        zzbmy zzbmyVar = this.f77009v;
        if (zzbmyVar != null) {
            zzbmyVar.c();
            this.f77010w = false;
            if (z2) {
                this.f77009v = Y(this.f76988c, null, this.f76990d, this.f76992e);
            } else {
                this.f77009v = null;
            }
        }
        zzbuz zzbuzVar = this.f77011x;
        if (zzbuzVar != null) {
            zzbuzVar.f76933a.b();
            this.f77011x = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void f0() {
        long j3 = this.f77004q;
        if (j3 == -1) {
            return;
        }
        this.f76985a0.a(j3, TimeUnit.MILLISECONDS);
    }

    static zzbmy Y(URI uri, String str, zzbmz zzbmzVar, zzbmr zzbmrVar) {
        zzbmy zzbmyVarA = zzbmzVar.a(uri, zzbmrVar);
        if (zzbmyVarA != null) {
            return new zzbzk(zzbmyVarA, new zzbox(new zzbsg(), zzbmrVar.d(), zzbmrVar.c()), zzbmrVar.c());
        }
        throw new IllegalArgumentException("cannot create a NameResolver for ".concat(String.valueOf(uri)));
    }

    final /* synthetic */ zzbpa A() {
        return this.K;
    }

    final /* synthetic */ zzbpb B() {
        return this.L;
    }

    final /* synthetic */ zzbpd C() {
        return this.M;
    }

    final /* synthetic */ zzbiv D() {
        return this.N;
    }

    final /* synthetic */ zzbkn E() {
        return this.O;
    }

    final /* synthetic */ zzbvl F() {
        return this.P;
    }

    final /* synthetic */ zzbwb G() {
        return this.Q;
    }

    final /* synthetic */ void H(zzbwb zzbwbVar) {
        this.Q = zzbwbVar;
    }

    final /* synthetic */ boolean I() {
        return this.R;
    }

    final /* synthetic */ void J(boolean z2) {
        this.R = true;
    }

    final /* synthetic */ boolean K() {
        return this.S;
    }

    final /* synthetic */ zzbyo L() {
        return this.T;
    }

    final /* synthetic */ long M() {
        return this.U;
    }

    final /* synthetic */ long N() {
        return this.V;
    }

    final /* synthetic */ boolean O() {
        return this.W;
    }

    final /* synthetic */ zzbur P() {
        return this.Z;
    }

    final /* synthetic */ zzbmo Q() {
        return this.f76987b0;
    }

    final /* synthetic */ int S() {
        return this.f76989c0;
    }

    final /* synthetic */ void T(int i3) {
        this.f76989c0 = i3;
    }

    final /* synthetic */ zzbsg U() {
        return this.f76991d0;
    }

    final void X() {
        this.f77001n.b();
        if (this.F.get() || this.f77012y) {
            return;
        }
        if (this.Y.b()) {
            this.f76985a0.b(false);
        } else {
            f0();
        }
        if (this.f77011x == null) {
            this.N.a(2, "Exiting idle mode");
            zzbuz zzbuzVar = new zzbuz(this, null);
            zzbuzVar.f76933a = new zzboq(this.f76993f, zzbuzVar);
            this.f77011x = zzbuzVar;
            this.f77005r.a(zzbjn.CONNECTING);
            this.f77009v.b(new zzbvb(this, zzbuzVar, this.f77009v));
            this.f77010w = true;
        }
    }

    public final zzbvr Z() {
        zzbiv zzbivVar = this.N;
        zzbivVar.a(1, "shutdownNow() called");
        zzbivVar.a(1, "shutdown() called");
        if (this.F.compareAndSet(false, true)) {
            zzbnx zzbnxVar = this.f77001n;
            zzbnxVar.a(new zzbul(this));
            zzbnxVar.zza();
            zzbvl zzbvlVar = this.P;
            zzbnx zzbnxVar2 = zzbvlVar.f76957d.f77001n;
            zzbnxVar2.a(new zzbvd(zzbvlVar));
            zzbnxVar2.zza();
            zzbnxVar.a(new zzbuj(this));
            zzbnxVar.zza();
        }
        zzbvl zzbvlVar2 = this.P;
        zzbnx zzbnxVar3 = zzbvlVar2.f76957d.f77001n;
        zzbnxVar3.a(new zzbve(zzbvlVar2));
        zzbnxVar3.zza();
        zzbnx zzbnxVar4 = this.f77001n;
        zzbnxVar4.a(new zzbum(this));
        zzbnxVar4.zza();
        return this;
    }

    final void a0(Throwable th) {
        if (this.f77012y) {
            return;
        }
        this.f77012y = true;
        try {
            this.f76985a0.b(true);
            V(false);
        } finally {
            this.D.f(new zzblf(zzbli.c(zzbnp.f76495l.e("Panic! This is a bug!").d(th))));
            this.P.g(null);
            this.N.a(4, "PANIC! Entering TRANSIENT_FAILURE");
            this.f77005r.a(zzbjn.TRANSIENT_FAILURE);
        }
    }

    final /* synthetic */ void b0() {
        if (this.G) {
            Iterator it = this.f77013z.iterator();
            while (it.hasNext()) {
                ((zzbua) it.next()).c(f76977f0);
            }
            Iterator it2 = this.C.iterator();
            if (it2.hasNext()) {
                throw null;
            }
        }
    }

    final /* synthetic */ void c0(boolean z2) {
        V(false);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final zzbix d(zzbml zzbmlVar, zzbis zzbisVar) {
        return this.f77006s.d(zzbmlVar, zzbisVar);
    }

    final /* synthetic */ void d0() {
        V(true);
        zzbrb zzbrbVar = this.D;
        zzbrbVar.f(null);
        this.N.a(2, "Entering IDLE state");
        this.f77005r.a(zzbjn.IDLE);
        if (this.Y.c(this.B, zzbrbVar)) {
            X();
        }
    }

    final /* synthetic */ void e0(boolean z2) {
        this.f76985a0.b(true);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final String f() {
        return this.f77006s.f();
    }

    @Override // com.google.android.libraries.places.internal.zzblw
    public final /* bridge */ /* synthetic */ zzblw g() {
        Z();
        return this;
    }

    final /* synthetic */ void g0() {
        this.f77001n.b();
        if (this.f77010w) {
            this.f77009v.d();
        }
    }

    final /* synthetic */ Supplier h() {
        return this.f77003p;
    }

    final /* synthetic */ void h0(zzbln zzblnVar) {
        this.D.f(zzblnVar);
    }

    final /* synthetic */ zzbqc i() {
        return this.f77005r;
    }

    final /* synthetic */ Executor i0(zzbis zzbisVar) {
        Executor executorJ = zzbisVar.j();
        return executorJ == null ? this.f76996i : executorJ;
    }

    final /* synthetic */ List j() {
        return this.f77007t;
    }

    final /* synthetic */ void j0() {
        if (!this.I && this.F.get() && this.f77013z.isEmpty() && this.C.isEmpty()) {
            this.N.a(2, "Terminated");
            this.O.f(this);
            this.f76997j.zzb(this.f76996i);
            this.f76998k.b();
            this.f76999l.b();
            this.f76994g.close();
            this.I = true;
            this.J.countDown();
        }
    }

    final /* synthetic */ String k() {
        return this.f77008u;
    }

    final /* synthetic */ zzbmy l() {
        return this.f77009v;
    }

    final /* synthetic */ zzbuz m() {
        return this.f77011x;
    }

    final /* synthetic */ boolean n() {
        return this.f77012y;
    }

    final /* synthetic */ String n0() {
        return this.f76986b;
    }

    final /* synthetic */ Set o() {
        return this.f77013z;
    }

    final /* synthetic */ zzbpq o0() {
        return this.f76994g;
    }

    final /* synthetic */ Collection p() {
        return this.A;
    }

    final /* synthetic */ zzbvm p0() {
        return this.f76995h;
    }

    final /* synthetic */ void q(Collection collection) {
        this.A = collection;
    }

    final /* synthetic */ Executor q0() {
        return this.f76996i;
    }

    final /* synthetic */ Object r() {
        return this.B;
    }

    final /* synthetic */ zzcag r0() {
        return this.f77000m;
    }

    final /* synthetic */ zzbrb s() {
        return this.D;
    }

    final /* synthetic */ zzbjy s0() {
        return this.f77002o;
    }

    final /* synthetic */ zzbvq t() {
        return this.E;
    }

    public final String toString() {
        return MoreObjects.c(this).c("logId", this.f76984a.c()).d("target", this.f76986b).toString();
    }

    final /* synthetic */ AtomicBoolean u() {
        return this.F;
    }

    final /* synthetic */ boolean v() {
        return this.G;
    }

    final /* synthetic */ void w(boolean z2) {
        this.G = true;
    }

    final /* synthetic */ boolean x() {
        return this.H;
    }

    final /* synthetic */ void y(boolean z2) {
        this.H = true;
    }

    final /* synthetic */ boolean z() {
        return this.I;
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        return this.f76984a;
    }
}
