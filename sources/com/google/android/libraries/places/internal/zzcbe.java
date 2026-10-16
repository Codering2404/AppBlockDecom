package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbe implements zzbod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcbg f77394a;

    zzcbe(zzcbg zzcbgVar) {
        Objects.requireNonNull(zzcbgVar);
        this.f77394a = zzcbgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbod
    public final void a(zzbnp zzbnpVar) {
        int i3 = zzcew.f77735a;
        zzcbg zzcbgVar = this.f77394a;
        synchronized (zzcbgVar.A().S()) {
            zzcbgVar.A().P(zzbnpVar, true, null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbod
    public final void b(zzcam zzcamVar, boolean z2, boolean z3, int i3) {
        zzcff zzcffVarB;
        int i4 = zzcew.f77735a;
        if (zzcamVar == null) {
            zzcffVarB = zzcbg.f77398q;
        } else {
            zzcffVarB = ((zzcbx) zzcamVar).b();
            int iZzb = (int) zzcffVarB.zzb();
            if (iZzb > 0) {
                this.f77394a.k(iZzb);
            }
        }
        zzcbg zzcbgVar = this.f77394a;
        synchronized (zzcbgVar.A().S()) {
            zzcbgVar.A().Q(zzcffVarB, z2, z3);
            zzcbgVar.p().c(i3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbod
    public final void c(zzbmg zzbmgVar, byte[] bArr) {
        int i3 = zzcew.f77735a;
        zzcbg zzcbgVar = this.f77394a;
        String strB = zzcbgVar.w().b();
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 1);
        sb.append("/");
        sb.append(strB);
        String string = sb.toString();
        synchronized (zzcbgVar.A().S()) {
            zzcbgVar.A().R(zzbmgVar, string);
        }
    }
}
