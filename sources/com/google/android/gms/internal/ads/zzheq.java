package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzheq implements zzhnk {
    static final /* synthetic */ zzheq zza = new zzheq();

    private /* synthetic */ zzheq() {
    }

    @Override // com.google.android.gms.internal.ads.zzhnk
    public final /* synthetic */ Object zza(zzhdz zzhdzVar) throws GeneralSecurityException {
        zzhdq zzhdqVarZza = zzhdzVar.zza();
        if (zzhdqVarZza instanceof zzhey) {
            return zzhzu.zzb((zzhey) zzhdqVarZza);
        }
        if (zzhdqVarZza instanceof zzhfq) {
            return zzhzh.zzb((zzhfq) zzhdqVarZza);
        }
        if (zzhdqVarZza instanceof zzhfz) {
            return zzhkn.zzb((zzhfz) zzhdqVarZza);
        }
        if (zzhdqVarZza instanceof zzhfi) {
            return zzhzg.zzb((zzhfi) zzhdqVarZza);
        }
        if (zzhdqVarZza instanceof zzhgh) {
            zzhgh zzhghVar = (zzhgh) zzhdqVarZza;
            return zzhjh.zzd() ? zzhjh.zzb(zzhghVar) : zzhzm.zzb(zzhghVar);
        }
        if (zzhdqVarZza instanceof zzhic) {
            zzhic zzhicVar = (zzhic) zzhdqVarZza;
            return zzhjh.zzd() ? zzhkf.zzb(zzhicVar) : zziay.zzb(zzhicVar);
        }
        if (zzhdqVarZza instanceof zzhhw) {
            return zzhjz.zzb((zzhhw) zzhdqVarZza);
        }
        throw new GeneralSecurityException("Unknown key class: ".concat(String.valueOf(zzhdqVarZza.getClass())));
    }
}
