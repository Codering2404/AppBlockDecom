package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvk extends zzbqu {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final zzbjs f76949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final zzbml f76950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final zzbis f76951m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f76952n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ zzbvl f76953o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbvk(zzbvl zzbvlVar, zzbjs zzbjsVar, zzbml zzbmlVar, zzbis zzbisVar) {
        super(zzbvlVar.f76957d.i0(zzbisVar), zzbvlVar.f76957d.p0(), zzbisVar.b());
        Objects.requireNonNull(zzbvlVar);
        this.f76953o = zzbvlVar;
        this.f76949k = zzbjsVar;
        this.f76950l = zzbmlVar;
        this.f76951m = zzbisVar;
        this.f76952n = System.nanoTime();
    }

    @Override // com.google.android.libraries.places.internal.zzbqu
    protected final void g() {
        zzbvj zzbvjVar = new zzbvj(this);
        zzbnx zzbnxVar = this.f76953o.f76957d.f77001n;
        zzbnxVar.a(zzbvjVar);
        zzbnxVar.zza();
    }

    final void p() {
        zzbjs zzbjsVarB = this.f76949k.b();
        try {
            zzbix zzbixVarI = this.f76953o.i(this.f76950l, this.f76951m.h(zzbje.f76277a, Long.valueOf(System.nanoTime() - this.f76952n)));
            this.f76949k.c(zzbjsVarB);
            Runnable runnableF = f(zzbixVarI);
            if (runnableF != null) {
                zzbvl zzbvlVar = this.f76953o;
                zzbvlVar.f76957d.i0(this.f76951m).execute(new zzbvi(this, runnableF));
            } else {
                zzbvl zzbvlVar2 = this.f76953o;
                zzbvj zzbvjVar = new zzbvj(this);
                zzbnx zzbnxVar = zzbvlVar2.f76957d.f77001n;
                zzbnxVar.a(zzbvjVar);
                zzbnxVar.zza();
            }
        } catch (Throwable th) {
            this.f76949k.c(zzbjsVarB);
            throw th;
        }
    }
}
