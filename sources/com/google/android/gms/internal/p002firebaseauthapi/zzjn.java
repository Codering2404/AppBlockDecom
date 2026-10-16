package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjn implements zzbe {
    private final zzpl<zzjo> zza;
    private final zzoo zzb;

    public zzjn(zzjo zzjoVar, zzpl<zzjo> zzplVar, zzoo zzooVar, zzoo zzooVar2) {
        this.zza = zzplVar;
        this.zzb = zzooVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzjo zzjoVar : this.zza.zza(bArr)) {
            try {
                byte[] bArrZza = zzjoVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzjoVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
