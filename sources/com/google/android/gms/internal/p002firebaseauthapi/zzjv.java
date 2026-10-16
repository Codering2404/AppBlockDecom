package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjv implements zzbe {
    private final zzbe zza;
    private final zzxz zzb;
    private final byte[] zzc;

    private zzjv(zzbe zzbeVar, zzxz zzxzVar, byte[] bArr) {
        this.zza = zzbeVar;
        this.zzb = zzxzVar;
        this.zzc = bArr;
    }

    public static zzbe zza(zzof zzofVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzqb zzqbVarZza = zzofVar.zza(zzbf.zza());
        zzbe zzbeVar = (zzbe) zznq.zza().zza(zzqbVarZza.zzf(), zzbe.class).zzb(zzqbVarZza.zzd());
        zzxz zzxzVarZzb = zzqbVarZza.zzb();
        int i3 = zzjy.zza[zzxzVarZzb.ordinal()];
        if (i3 == 1) {
            bArrZzb = zzpe.zza.zzb();
        } else if (i3 == 2 || i3 == 3) {
            bArrZzb = zzpe.zza(zzofVar.zzb().intValue()).zzb();
        } else {
            if (i3 != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + zzxzVarZzb.zza());
            }
            bArrZzb = zzpe.zzb(zzofVar.zzb().intValue()).zzb();
        }
        return new zzjv(zzbeVar, zzxzVarZzb, bArrZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzxz.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
