package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzma implements zzbd {
    private static final byte[] zza = new byte[0];
    private final zzme zzb;
    private final zzmf zzc;
    private final zzmc zzd;
    private final zzly zze;
    private final int zzf;
    private final byte[] zzg;

    private zzma(zzme zzmeVar, zzmf zzmfVar, zzmc zzmcVar, zzly zzlyVar, int i3, zzaaj zzaajVar) {
        this.zzb = zzmeVar;
        this.zzc = zzmfVar;
        this.zzd = zzmcVar;
        this.zze = zzlyVar;
        this.zzf = i3;
        this.zzg = zzaajVar.zzb();
    }

    public static zzbd zza(zzki zzkiVar) throws GeneralSecurityException {
        int i3;
        zzkg zzkgVar = (zzkg) ((zzlg) zzkiVar.zza());
        zzmf zzmfVarZza = zzmh.zza(zzkgVar.zze());
        zzmc zzmcVarZza = zzmh.zza(zzkgVar.zzd());
        zzly zzlyVarZza = zzmh.zza(zzkgVar.zzb());
        zzkg.zzf zzfVarZze = zzkgVar.zze();
        zzkg.zzf zzfVar = zzkg.zzf.zzd;
        if (zzfVarZze.equals(zzfVar)) {
            i3 = 32;
        } else if (zzfVarZze.equals(zzkg.zzf.zza)) {
            i3 = 65;
        } else if (zzfVarZze.equals(zzkg.zzf.zzb)) {
            i3 = 97;
        } else {
            if (!zzfVarZze.equals(zzkg.zzf.zzc)) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            i3 = 133;
        }
        int i4 = i3;
        zzkg.zzf zzfVarZze2 = ((zzkg) ((zzlg) zzkiVar.zza())).zze();
        if (zzfVarZze2.equals(zzfVar) || zzfVarZze2.equals(zzkg.zzf.zza) || zzfVarZze2.equals(zzkg.zzf.zzb) || zzfVarZze2.equals(zzkg.zzf.zzc)) {
            return new zzma(new zzme(zzaaj.zza(zzkiVar.zzf().zza(zzbf.zza())), ((zzkq) ((zzli) zzkiVar.zzc())).zze()), zzmfVarZza, zzmcVarZza, zzlyVarZza, i4, zzkiVar.zzh());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length >= length) {
            if (zzqn.zza(bArr3, bArr)) {
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                return zzmb.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
            }
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
