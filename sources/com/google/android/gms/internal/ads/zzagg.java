package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagg {
    public static boolean zza(zzet zzetVar, zzagl zzaglVar, int i3, zzagf zzagfVar) {
        int iZzg = zzetVar.zzg();
        long jZzz = zzetVar.zzz();
        long j3 = jZzz >>> 16;
        if (j3 != i3) {
            return false;
        }
        boolean z2 = (j3 & 1) == 1;
        long j4 = jZzz >> 12;
        long j5 = jZzz >> 8;
        long j6 = jZzz >> 4;
        long j7 = jZzz >> 1;
        long j8 = jZzz & 1;
        int i4 = (int) (j6 & 15);
        if (i4 <= 7) {
            if (i4 != zzaglVar.zzg - 1) {
                return false;
            }
        } else if (i4 > 10 || zzaglVar.zzg != 2) {
            return false;
        }
        int i5 = (int) (j7 & 7);
        if ((i5 != 0 && i5 != zzaglVar.zzi) || j8 == 1 || !zzd(zzetVar, zzaglVar, z2, zzagfVar)) {
            return false;
        }
        long j9 = zzagfVar.zza;
        int iZzc = zzc(zzetVar, (int) (j4 & 15));
        long j10 = zzaglVar.zzj;
        boolean z3 = j10 == 0 || j9 + ((long) iZzc) >= j10;
        if (iZzc == -1) {
            return false;
        }
        if ((!z3 && iZzc < zzaglVar.zza) || iZzc > zzaglVar.zzb) {
            return false;
        }
        int i6 = zzaglVar.zze;
        int i7 = (int) (j5 & 15);
        if (i7 != 0) {
            if (i7 <= 11) {
                if (i7 != zzaglVar.zzf) {
                    return false;
                }
            } else if (i7 == 12) {
                if (zzetVar.zzs() * 1000 != i6) {
                    return false;
                }
            } else {
                if (i7 > 14) {
                    return false;
                }
                int iZzt = zzetVar.zzt();
                if (i7 == 14) {
                    iZzt *= 10;
                }
                if (iZzt != i6) {
                    return false;
                }
            }
        }
        if (zzetVar.zzs() != zzfl.zzL(zzetVar.zzi(), iZzg, zzetVar.zzg() - 1, 0)) {
            return false;
        }
        if (zzetVar.zzd() != 0) {
            int iZzn = zzetVar.zzn();
            if ((iZzn & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                return false;
            }
            int i8 = (iZzn & 126) >> 1;
            if ((i8 >= 2 && i8 <= 7) || (i8 >= 13 && i8 <= 31)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 57);
                sb.append("Ignoring frame where first subframe has a reserved type: ");
                sb.append(i8);
                zzeg.zzb("FlacFrameReader", sb.toString());
                return false;
            }
        }
        return true;
    }

    public static long zzb(zzafz zzafzVar, zzagl zzaglVar) throws IOException {
        zzafzVar.zzl();
        zzafzVar.zzk(1);
        byte[] bArr = new byte[1];
        zzafzVar.zzi(bArr, 0, 1);
        int i3 = bArr[0] & 1;
        boolean z2 = 1 == i3;
        zzafzVar.zzk(2);
        int i4 = 1 != i3 ? 6 : 7;
        zzet zzetVar = new zzet(i4);
        zzetVar.zzf(zzagc.zzb(zzafzVar, zzetVar.zzi(), 0, i4));
        zzafzVar.zzl();
        zzagf zzagfVar = new zzagf();
        if (zzd(zzetVar, zzaglVar, z2, zzagfVar)) {
            return zzagfVar.zza;
        }
        throw zzat.zzb(null, null);
    }

    public static int zzc(zzet zzetVar, int i3) {
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i3 - 2);
            case 6:
                return zzetVar.zzs() + 1;
            case 7:
                return zzetVar.zzt() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return Function.MAX_NARGS << (i3 - 8);
            default:
                return -1;
        }
    }

    private static boolean zzd(zzet zzetVar, zzagl zzaglVar, boolean z2, zzagf zzagfVar) {
        try {
            long jZzO = zzetVar.zzO();
            if (!z2) {
                jZzO *= (long) zzaglVar.zzb;
            }
            long j3 = zzaglVar.zzj;
            if (j3 != 0 && jZzO > j3) {
                return false;
            }
            zzagfVar.zza = jZzO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
