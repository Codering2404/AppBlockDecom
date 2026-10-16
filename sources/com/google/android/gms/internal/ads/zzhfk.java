package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzhfk implements zzhln {
    static final /* synthetic */ zzhfk zza = new zzhfk();

    private /* synthetic */ zzhfk() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfo zzhfoVar = (zzhfo) zzhehVar;
        int i3 = zzhfl.zza;
        if (zzhfoVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES EAX Parameters are not valid");
        }
        zzhfh zzhfhVar = new zzhfh(null);
        zzhfhVar.zza(zzhfoVar);
        zzhfhVar.zzc(num);
        zzhfhVar.zzb(zzibb.zzb(zzhfoVar.zzc()));
        return zzhfhVar.zzd();
    }
}
