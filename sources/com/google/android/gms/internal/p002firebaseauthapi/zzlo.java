package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlo implements zzlr {
    private final zzjf zza;
    private final int zzb;

    public zzlo(zzjf zzjfVar) {
        this.zza = zzjfVar;
        this.zzb = zzjfVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i3) throws GeneralSecurityException {
        if (bArr2.length < i3) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return zzyx.zza(zzja.zzc().zza(this.zza).zza(zzaal.zza(bArr, zzbf.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i3, bArr2.length), zzln.zza);
    }
}
