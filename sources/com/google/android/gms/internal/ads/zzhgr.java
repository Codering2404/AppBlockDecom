package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzhgr implements zzhne {
    static final /* synthetic */ zzhgr zza = new zzhgr();

    private /* synthetic */ zzhgr() {
    }

    @Override // com.google.android.gms.internal.ads.zzhne
    public final /* synthetic */ Object zza(zzhdq zzhdqVar) throws GeneralSecurityException {
        zzhhc zzhhcVar = (zzhhc) zzhdqVar;
        int i3 = zzhgt.zza;
        String strZzb = zzhhcVar.zze().zzb();
        zzheu zzheuVarZzd = zzhhcVar.zze().zzd();
        zzhdi zzhdiVarZzb = zzhef.zza(strZzb).zzb();
        int i4 = zzhgq.zza;
        try {
            return zzhju.zzc(new zzhgq(zzhst.zzd(zzhen.zza(zzheuVarZzd), zzido.zza()), zzhdiVarZzb), zzhhcVar.zzc());
        } catch (zziet e3) {
            throw new GeneralSecurityException(e3);
        }
    }
}
