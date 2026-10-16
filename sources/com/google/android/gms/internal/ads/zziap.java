package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziap implements zzheg {
    private static final byte[] zza = {0};
    private final zzhqd zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zziap(zzhob zzhobVar) throws GeneralSecurityException {
        this.zzb = zziam.zzb(zzhqb.zzc(zzhqc.zzb(zzhobVar.zzf().zzc()), zzhobVar.zzd()));
        this.zzc = zzhobVar.zzf().zzd();
        this.zzd = zzhobVar.zze().zzc();
        if (zzhobVar.zzf().zzf().equals(zzhoh.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzheg zza(zzhob zzhobVar) throws GeneralSecurityException {
        return new zziap(zzhobVar);
    }

    public static zzheg zzb(zzhom zzhomVar) throws GeneralSecurityException {
        return new zziap(zzhomVar);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        return bArr2.length > 0 ? zzhzl.zza(this.zzd, this.zzb.zza(zzhzl.zza(bArr, bArr2), this.zzc)) : zzhzl.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zziap(zzhom zzhomVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(zzhomVar.zzf().zzg());
        this.zzb = new zziao("HMAC".concat(strValueOf), new SecretKeySpec(zzhomVar.zzd().zzc(zzhdo.zza()), "HMAC"));
        this.zzc = zzhomVar.zzf().zzd();
        this.zzd = zzhomVar.zze().zzc();
        if (zzhomVar.zzf().zzf().equals(zzhou.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zziap(zzhqd zzhqdVar, int i3) throws GeneralSecurityException {
        this.zzb = zzhqdVar;
        this.zzc = i3;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzhqdVar.zza(new byte[0], i3);
    }
}
