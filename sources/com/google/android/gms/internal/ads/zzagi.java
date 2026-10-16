package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagi {
    public static zzap zza(zzafz zzafzVar, boolean z2) throws IOException {
        zzap zzapVarZza = new zzagt().zza(zzafzVar, z2 ? null : zzajn.zza, 0);
        if (zzapVarZza == null || zzapVarZza.zza() == 0) {
            return null;
        }
        return zzapVarZza;
    }

    public static boolean zzb(zzafz zzafzVar, zzagh zzaghVar) throws IOException {
        zzafzVar.zzl();
        zzes zzesVar = new zzes(new byte[4], 4);
        zzafzVar.zzi(zzesVar.zza, 0, 4);
        boolean zZzi = zzesVar.zzi();
        int iZzj = zzesVar.zzj(7);
        int iZzj2 = zzesVar.zzj(24) + 4;
        if (iZzj == 0) {
            byte[] bArr = new byte[38];
            zzafzVar.zzc(bArr, 0, 38);
            zzaghVar.zza = new zzagl(bArr, 4);
            return zZzi;
        }
        zzagl zzaglVar = zzaghVar.zza;
        if (zzaglVar == null) {
            throw new IllegalArgumentException();
        }
        if (iZzj == 3) {
            zzet zzetVar = new zzet(iZzj2);
            zzafzVar.zzc(zzetVar.zzi(), 0, iZzj2);
            zzaghVar.zza = zzaglVar.zze(zzc(zzetVar));
            return zZzi;
        }
        if (iZzj == 4) {
            zzet zzetVar2 = new zzet(iZzj2);
            zzafzVar.zzc(zzetVar2.zzi(), 0, iZzj2);
            zzetVar2.zzk(4);
            zzaghVar.zza = new zzagl(zzaglVar.zza, zzaglVar.zzb, zzaglVar.zzc, zzaglVar.zzd, zzaglVar.zze, zzaglVar.zzg, zzaglVar.zzh, zzaglVar.zzj, zzaglVar.zzk, zzaglVar.zzd(zzahm.zzb(Arrays.asList(zzhe.zzb(zzetVar2, false, false).zza))));
            return zZzi;
        }
        if (iZzj != 6) {
            zzafzVar.zzf(iZzj2);
            return zZzi;
        }
        zzet zzetVar3 = new zzet(iZzj2);
        zzafzVar.zzc(zzetVar3.zzi(), 0, iZzj2);
        zzetVar3.zzk(4);
        zzaghVar.zza = new zzagl(zzaglVar.zza, zzaglVar.zzb, zzaglVar.zzc, zzaglVar.zzd, zzaglVar.zze, zzaglVar.zzg, zzaglVar.zzh, zzaglVar.zzj, zzaglVar.zzk, zzaglVar.zzd(new zzap(zzgwm.zzj(zzajc.zzb(zzetVar3)))));
        return zZzi;
    }

    public static zzagk zzc(zzet zzetVar) {
        zzetVar.zzk(1);
        int iZzx = zzetVar.zzx();
        long jZzg = zzetVar.zzg();
        long j3 = iZzx;
        int i3 = iZzx / 18;
        long[] jArrCopyOf = new long[i3];
        long[] jArrCopyOf2 = new long[i3];
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            long jZzD = zzetVar.zzD();
            if (jZzD == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                break;
            }
            jArrCopyOf[i4] = jZzD;
            jArrCopyOf2[i4] = zzetVar.zzD();
            zzetVar.zzk(2);
            i4++;
        }
        zzetVar.zzk((int) ((jZzg + j3) - ((long) zzetVar.zzg())));
        return new zzagk(jArrCopyOf, jArrCopyOf2);
    }
}
