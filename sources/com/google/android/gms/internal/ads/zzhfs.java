package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzhfs implements zzhln {
    static final /* synthetic */ zzhfs zza = new zzhfs();

    private /* synthetic */ zzhfs() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfx zzhfxVar = (zzhfx) zzhehVar;
        int i3 = zzhfu.zza;
        if (zzhfxVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzhfp zzhfpVar = new zzhfp(null);
        zzhfpVar.zza(zzhfxVar);
        zzhfpVar.zzc(num);
        zzhfpVar.zzb(zzibb.zzb(zzhfxVar.zzc()));
        return zzhfpVar.zzd();
    }
}
