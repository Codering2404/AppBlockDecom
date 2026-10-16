package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmd implements zzbg {
    private zzmd(zzaaj zzaajVar, zzmf zzmfVar, zzmc zzmcVar, zzly zzlyVar, zzaaj zzaajVar2) {
        zzaajVar.zzb();
        zzaajVar2.zzb();
    }

    public static zzbg zza(zzkq zzkqVar) throws GeneralSecurityException {
        zzkg zzkgVar = (zzkg) ((zzlg) zzkqVar.zza());
        return new zzmd(zzkqVar.zze(), zzmh.zza(zzkgVar.zze()), zzmh.zza(zzkgVar.zzd()), zzmh.zza(zzkgVar.zzb()), zzkqVar.zzd());
    }
}
