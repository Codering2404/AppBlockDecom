package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamw extends zzamz {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzamw() {
    }

    public static boolean zzd(zzet zzetVar) {
        return zzk(zzetVar, zza);
    }

    private static boolean zzk(zzet zzetVar, byte[] bArr) {
        if (zzetVar.zzd() < 8) {
            return false;
        }
        int iZzg = zzetVar.zzg();
        byte[] bArr2 = new byte[8];
        zzetVar.zzm(bArr2, 0, 8);
        zzetVar.zzh(iZzg);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zza(boolean z2) {
        super.zza(z2);
        if (z2) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final long zzb(zzet zzetVar) {
        return zzi(zzgv.zzd(zzetVar.zzi()));
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    @EnsuresNonNullIf
    protected final boolean zzc(zzet zzetVar, long j3, zzamx zzamxVar) throws zzat {
        if (zzk(zzetVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzetVar.zzi(), zzetVar.zze());
            int i3 = bArrCopyOf[9] & 255;
            List listZza = zzgv.zza(bArrCopyOf);
            if (zzamxVar.zza != null) {
                return true;
            }
            zzt zztVar = new zzt();
            zztVar.zzn("audio/ogg");
            zztVar.zzo("audio/opus");
            zztVar.zzG(i3);
            zztVar.zzH(48000);
            zztVar.zzr(listZza);
            zzamxVar.zza = zztVar.zzO();
            return true;
        }
        if (!zzk(zzetVar, zzb)) {
            zzamxVar.zza.getClass();
            return false;
        }
        zzamxVar.zza.getClass();
        if (this.zzc) {
            return true;
        }
        this.zzc = true;
        zzetVar.zzk(8);
        zzap zzapVarZzb = zzahm.zzb(zzgwm.zzr(zzhe.zzb(zzetVar, false, false).zza));
        if (zzapVarZzb == null) {
            return true;
        }
        zzt zztVarZza = zzamxVar.zza.zza();
        zztVarZza.zzl(zzapVarZzb.zzf(zzamxVar.zza.zzl));
        zzamxVar.zza = zztVarZza.zzO();
        return true;
    }
}
