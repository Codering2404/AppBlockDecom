package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafl {
    public static void zza(long j3, zzet zzetVar, zzahk[] zzahkVarArr) {
        int iZzB;
        while (true) {
            if (zzetVar.zzd() <= 1) {
                return;
            }
            int iZzc = zzc(zzetVar);
            int iZzc2 = zzc(zzetVar);
            int iZzg = zzetVar.zzg() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzetVar.zzd()) {
                zzeg.zzc("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzg = zzetVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzs = zzetVar.zzs();
                int iZzt = zzetVar.zzt();
                if (iZzt == 49) {
                    iZzB = zzetVar.zzB();
                    iZzt = 49;
                } else {
                    iZzB = 0;
                }
                int iZzs2 = zzetVar.zzs();
                if (iZzt == 47) {
                    zzetVar.zzk(1);
                    iZzt = 47;
                }
                boolean z2 = iZzs == 181 && (iZzt == 49 || iZzt == 47) && iZzs2 == 3;
                if (iZzt == 49) {
                    z2 &= iZzB == 1195456820;
                }
                if (z2) {
                    zzb(j3, zzetVar, zzahkVarArr);
                }
            }
            zzetVar.zzh(iZzg);
        }
    }

    public static void zzb(long j3, zzet zzetVar, zzahk[] zzahkVarArr) {
        int iZzs = zzetVar.zzs();
        if ((iZzs & 64) != 0) {
            int i3 = iZzs & 31;
            zzetVar.zzk(1);
            int iZzg = zzetVar.zzg();
            for (zzahk zzahkVar : zzahkVarArr) {
                int i4 = i3 * 3;
                zzetVar.zzh(iZzg);
                zzahkVar.zzc(zzetVar, i4);
                zzgtj.zzi(j3 != -9223372036854775807L);
                zzahkVar.zze(j3, 1, i4, 0, null);
            }
        }
    }

    private static int zzc(zzet zzetVar) {
        int i3 = 0;
        while (zzetVar.zzd() != 0) {
            int iZzs = zzetVar.zzs();
            i3 += iZzs;
            if (iZzs != 255) {
                return i3;
            }
        }
        return -1;
    }
}
