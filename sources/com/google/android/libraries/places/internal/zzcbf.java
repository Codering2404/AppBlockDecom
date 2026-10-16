package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbf extends zzbtc implements zzcbz {
    private final zzcff A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private final zzcav G;
    private final zzccd H;
    private final zzcbp I;
    private boolean J;
    private final zzcex K;
    private zzcca L;
    private int M;
    final /* synthetic */ zzcbg N;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f77395x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Object f77396y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List f77397z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcbf(zzcbg zzcbgVar, int i3, zzcaa zzcaaVar, Object obj, zzcav zzcavVar, zzccd zzccdVar, zzcbp zzcbpVar, int i4, String str, zzbis zzbisVar) {
        super(i3, zzcaaVar, zzcbgVar.p(), zzbisVar);
        Objects.requireNonNull(zzcbgVar);
        this.N = zzcbgVar;
        this.A = new zzcff();
        this.B = false;
        this.C = false;
        this.D = false;
        this.J = true;
        this.M = -1;
        this.f77396y = Preconditions.u(obj, "lock");
        this.G = zzcavVar;
        this.H = zzccdVar;
        this.I = zzcbpVar;
        this.E = i4;
        this.F = i4;
        this.f77395x = i4;
        this.K = zzcew.a(str);
    }

    private final void T(zzbnp zzbnpVar, boolean z2, zzbmg zzbmgVar) throws EOFException {
        if (this.D) {
            return;
        }
        this.D = true;
        if (!this.J) {
            this.I.T(this.M, zzbnpVar, zzbpm.PROCESSED, z2, zzccv.CANCEL, zzbmgVar);
            return;
        }
        this.I.Q(this.N);
        this.f77397z = null;
        zzcff zzcffVar = this.A;
        zzcffVar.x0(zzcffVar.zzb());
        this.J = false;
        if (zzbmgVar == null) {
            zzbmgVar = new zzbmg();
        }
        x(zzbnpVar, zzbpm.PROCESSED, true, zzbmgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbtc
    protected final void I(zzbnp zzbnpVar, boolean z2, zzbmg zzbmgVar) throws EOFException {
        T(zzbnpVar, false, zzbmgVar);
    }

    public final void J(int i3) {
        Preconditions.B(this.M == -1, "the stream has been started with id %s", i3);
        this.M = i3;
        zzccd zzccdVar = this.H;
        this.L = zzccdVar.e(this, i3);
        zzcbg zzcbgVar = this.N;
        zzcbf zzcbfVarA = zzcbgVar.A();
        super.m();
        zzcbfVarA.o().a();
        if (this.J) {
            this.G.D0(false, false, this.M, 0, this.f77397z);
            zzcbgVar.y().b();
            this.f77397z = null;
            zzcff zzcffVar = this.A;
            if (zzcffVar.zzb() > 0) {
                zzccdVar.c(this.B, this.L, zzcffVar, this.C);
            }
            this.J = false;
        }
    }

    public final void K(List list, boolean z2) {
        if (z2) {
            E(zzcce.b(list));
        } else {
            C(zzcce.a(list));
        }
    }

    public final void L(zzcff zzcffVar, boolean z2, int i3) {
        int iZzb = this.E - (((int) zzcffVar.zzb()) + i3);
        this.E = iZzb;
        this.F -= i3;
        if (iZzb >= 0) {
            super.D(new zzcbv(zzcffVar), z2);
        } else {
            this.G.G(this.M, zzccv.FLOW_CONTROL_ERROR);
            this.I.T(this.M, zzbnp.f76495l.e("Received data size exceeded our receiving window size"), zzbpm.PROCESSED, false, null, null);
        }
    }

    final zzcex M() {
        return this.K;
    }

    final int N() {
        return this.M;
    }

    final zzcca O() {
        zzcca zzccaVar;
        synchronized (this.f77396y) {
            zzccaVar = this.L;
        }
        return zzccaVar;
    }

    final /* synthetic */ void P(zzbnp zzbnpVar, boolean z2, zzbmg zzbmgVar) throws EOFException {
        T(zzbnpVar, true, null);
    }

    final /* synthetic */ void Q(zzcff zzcffVar, boolean z2, boolean z3) {
        if (this.D) {
            return;
        }
        if (!this.J) {
            Preconditions.A(this.M != -1, "streamId should be set");
            this.H.c(z2, this.L, zzcffVar, z3);
        } else {
            this.A.i2(zzcffVar, (int) zzcffVar.zzb());
            this.B |= z2;
            this.C |= z3;
        }
    }

    final /* synthetic */ void R(zzbmg zzbmgVar, String str) {
        zzcbp zzcbpVar = this.I;
        boolean zO = zzcbpVar.O();
        zzccz zzcczVar = zzcax.f77365a;
        Preconditions.u(zzbmgVar, "headers");
        Preconditions.u(str, "defaultPath");
        zzcbg zzcbgVar = this.N;
        String strZ = zzcbgVar.z();
        Preconditions.u(strZ, "authority");
        zzbmgVar.d(zzbsz.f76828i);
        zzbmgVar.d(zzbsz.f76829j);
        zzbmc zzbmcVar = zzbsz.f76830k;
        zzbmgVar.d(zzbmcVar);
        ArrayList arrayList = new ArrayList(zzbkw.d(zzbmgVar) + 7);
        if (zO) {
            arrayList.add(zzcax.f77366b);
        } else {
            arrayList.add(zzcax.f77365a);
        }
        arrayList.add(zzcax.f77367c);
        String strX = zzcbgVar.x();
        zzcfj zzcfjVar = zzccz.f77626h;
        zzcfj zzcfjVar2 = zzcfj.f77742d;
        arrayList.add(new zzccz(zzcfjVar, zzcfi.a(strZ)));
        arrayList.add(new zzccz(zzccz.f77624f, zzcfi.a(str)));
        arrayList.add(new zzccz(zzbmcVar.d(), strX));
        arrayList.add(zzcax.f77369e);
        arrayList.add(zzcax.f77370f);
        byte[][] bArrA = zzcah.a(zzbmgVar);
        for (int i3 = 0; i3 < bArrA.length; i3 += 2) {
            zzcfj zzcfjVarB = zzcfi.b(bArrA[i3]);
            if (zzcfjVarB.a().length != 0 && zzcfjVarB.a()[0] != 58) {
                arrayList.add(new zzccz(zzcfjVarB, zzcfi.b(bArrA[i3 + 1])));
            }
        }
        this.f77397z = arrayList;
        zzcbpVar.P(zzcbgVar, zzcbgVar.z());
    }

    final /* synthetic */ Object S() {
        return this.f77396y;
    }

    @Override // com.google.android.libraries.places.internal.zzbwe
    public final void b(int i3) {
        int i4 = this.F - i3;
        this.F = i4;
        int i5 = this.f77395x;
        if (i4 <= i5 * 0.5f) {
            int i6 = i5 - i4;
            this.E += i6;
            this.F = i4 + i6;
            this.G.E1(this.M, i6);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbom
    public final void c(Runnable runnable) {
        synchronized (this.f77396y) {
            runnable.run();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwe
    public final void d(Throwable th) throws EOFException {
        T(zzbnp.b(th), true, new zzbmg());
    }

    @Override // com.google.android.libraries.places.internal.zzbof, com.google.android.libraries.places.internal.zzbwe
    public final void zzb(boolean z2) {
        if (t()) {
            this.I.T(this.M, null, zzbpm.PROCESSED, false, null, null);
        } else {
            this.I.T(this.M, null, zzbpm.PROCESSED, false, zzccv.CANCEL, null);
        }
        super.zzb(z2);
    }
}
