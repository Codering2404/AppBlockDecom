package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzla implements zzbd {
    private final zzpl<zzlb> zza;
    private final zzoo zzb;

    public zzla(zzpl<zzlb> zzplVar, zzoo zzooVar) {
        this.zza = zzplVar;
        this.zzb = zzooVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzlb zzlbVar : this.zza.zza(bArr)) {
            try {
                byte[] bArrZza = zzlbVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzlbVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
