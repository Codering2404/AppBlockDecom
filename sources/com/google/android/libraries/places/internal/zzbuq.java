package com.google.android.libraries.places.internal;

import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuq extends zzbzf {
    final /* synthetic */ zzbml F;
    final /* synthetic */ zzbis G;
    final /* synthetic */ zzbjs H;
    final /* synthetic */ zzbur I;

    /* JADX WARN: Illegal instructions before constructor call */
    zzbuq(zzbur zzburVar, zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbzg zzbzgVar, zzbta zzbtaVar, zzbjs zzbjsVar) {
        this.F = zzbmlVar;
        this.G = zzbisVar;
        this.H = zzbjsVar;
        Objects.requireNonNull(zzburVar);
        this.I = zzburVar;
        zzbvr zzbvrVar = zzburVar.f76917b;
        super(zzbmlVar, zzbmgVar, zzbvrVar.L(), zzbvrVar.M(), zzbvrVar.N(), zzbvrVar.i0(zzbisVar), zzburVar.f76917b.o0().zzb(), zzbzgVar, zzbtaVar, zzburVar.f76916a);
    }

    @Override // com.google.android.libraries.places.internal.zzbzf
    final zzbnp T() {
        zzbvq zzbvqVarT = this.I.f76917b.t();
        synchronized (zzbvqVarT.f76972a) {
            try {
                zzbnp zzbnpVar = zzbvqVarT.f76974c;
                if (zzbnpVar != null) {
                    return zzbnpVar;
                }
                zzbvqVarT.f76973b.add(this);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbzf
    final void U() {
        zzbnp zzbnpVar;
        zzbvq zzbvqVarT = this.I.f76917b.t();
        synchronized (zzbvqVarT.f76972a) {
            try {
                zzbvqVarT.f76973b.remove(this);
                if (zzbvqVarT.f76973b.isEmpty()) {
                    zzbnpVar = zzbvqVarT.f76974c;
                    zzbvqVarT.f76973b = new HashSet();
                } else {
                    zzbnpVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzbnpVar != null) {
            zzbvqVarT.f76975d.s().a(zzbnpVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbzf
    final zzbpl V(zzbmg zzbmgVar, zzbjb zzbjbVar, int i3, boolean z2, boolean z3) {
        zzbis zzbisVarF = this.G.f(zzbjbVar);
        zzbje[] zzbjeVarArrF = zzbsz.f(zzbisVarF, zzbmgVar, i3, z2, z3);
        zzbjs zzbjsVarB = this.H.b();
        try {
            return this.I.f76917b.s().e(this.F, zzbmgVar, zzbisVarF, zzbjeVarArrF);
        } finally {
            this.H.c(zzbjsVarB);
        }
    }
}
