package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqz extends zzbrt {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzblj f76686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbjs f76687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzbje[] f76688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile zzbnp f76689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ zzbrb f76690n;

    /* synthetic */ zzbqz(zzbrb zzbrbVar, zzblj zzbljVar, zzbje[] zzbjeVarArr, byte[] bArr) {
        Objects.requireNonNull(zzbrbVar);
        this.f76690n = zzbrbVar;
        this.f76687k = zzbjs.a();
        this.f76686j = zzbljVar;
        this.f76688l = zzbjeVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbrt, com.google.android.libraries.places.internal.zzbpl
    public final void c(zzbnp zzbnpVar) {
        super.c(zzbnpVar);
        zzbrb zzbrbVar = this.f76690n;
        synchronized (zzbrbVar.g()) {
            try {
                if (zzbrbVar.j() != null) {
                    boolean zRemove = zzbrbVar.m().remove(this);
                    if (!zzbrbVar.d() && zRemove) {
                        zzbrbVar.h().a(zzbrbVar.i());
                        if (zzbrbVar.n().f76693b != null) {
                            zzbrbVar.h().a(zzbrbVar.j());
                            zzbrbVar.k(null);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f76690n.h().zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbrt
    protected final void d(zzbnp zzbnpVar) {
        int i3 = 0;
        while (true) {
            zzbje[] zzbjeVarArr = this.f76688l;
            if (i3 >= zzbjeVarArr.length) {
                return;
            }
            zzbje zzbjeVar = zzbjeVarArr[i3];
            i3++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbrt, com.google.android.libraries.places.internal.zzbpl
    public final void g(zzbtf zzbtfVar) {
        if (this.f76686j.a().k()) {
            zzbtfVar.a("wait_for_ready");
            zzbnp zzbnpVar = this.f76689m;
            if (zzbnpVar != null && !zzbnpVar.j()) {
                zzbtfVar.b("Last Pick Failure", zzbnpVar);
            }
        }
        super.g(zzbtfVar);
    }

    final /* synthetic */ Runnable p(zzbpo zzbpoVar, String str) {
        zzbjs zzbjsVarB = this.f76687k.b();
        try {
            zzblj zzbljVar = this.f76686j;
            zzbpl zzbplVarE = zzbpoVar.e(zzbljVar.c(), zzbljVar.b(), zzbljVar.a(), this.f76688l);
            this.f76687k.c(zzbjsVarB);
            return m(zzbplVarE);
        } catch (Throwable th) {
            this.f76687k.c(zzbjsVarB);
            throw th;
        }
    }

    final /* synthetic */ zzblj q() {
        return this.f76686j;
    }

    final /* synthetic */ zzbje[] r() {
        return this.f76688l;
    }

    final /* synthetic */ void s(zzbnp zzbnpVar) {
        this.f76689m = zzbnpVar;
    }
}
