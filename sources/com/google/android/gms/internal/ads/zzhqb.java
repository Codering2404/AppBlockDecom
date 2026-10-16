package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqb extends zzhqe {
    private final zzhqc zza;
    private final zzibb zzb;

    private zzhqb(zzhqc zzhqcVar, zzibb zzibbVar) {
        this.zza = zzhqcVar;
        this.zzb = zzibbVar;
    }

    public static zzhqb zzc(zzhqc zzhqcVar, zzibb zzibbVar) throws GeneralSecurityException {
        if (zzhqcVar.zzc() == zzibbVar.zzd()) {
            return new zzhqb(zzhqcVar, zzibbVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.ads.zzhqe, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return null;
    }

    public final zzibb zzd() {
        return this.zzb;
    }
}
