package com.google.android.gms.internal.gtm;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztq {
    static int zza(byte[] bArr, int i3, zztp zztpVar) throws zzyg {
        int iZzi = zzi(bArr, i3, zztpVar);
        int i4 = zztpVar.zza;
        if (i4 < 0) {
            throw zzyg.zzf();
        }
        if (i4 > bArr.length - iZzi) {
            throw zzyg.zzj();
        }
        if (i4 == 0) {
            zztpVar.zzc = zzud.zzb;
            return iZzi;
        }
        zztpVar.zzc = zzud.zzl(bArr, iZzi, i4);
        return iZzi + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzzt zzztVar, byte[] bArr, int i3, int i4, int i5, zztp zztpVar) throws IOException {
        Object objZze = zzztVar.zze();
        int iZzm = zzm(objZze, zzztVar, bArr, i3, i4, i5, zztpVar);
        zzztVar.zzf(objZze);
        zztpVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzzt zzztVar, byte[] bArr, int i3, int i4, zztp zztpVar) throws IOException {
        Object objZze = zzztVar.zze();
        int iZzn = zzn(objZze, zzztVar, bArr, i3, i4, zztpVar);
        zzztVar.zzf(objZze);
        zztpVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzzt zzztVar, int i3, byte[] bArr, int i4, int i5, zzyd zzydVar, zztp zztpVar) throws IOException {
        int iZzd = zzd(zzztVar, bArr, i4, i5, zztpVar);
        zzydVar.add(zztpVar.zzc);
        while (iZzd < i5) {
            int iZzi = zzi(bArr, iZzd, zztpVar);
            if (i3 != zztpVar.zza) {
                break;
            }
            iZzd = zzd(zzztVar, bArr, iZzi, i5, zztpVar);
            zzydVar.add(zztpVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i3, zzyd zzydVar, zztp zztpVar) throws IOException {
        zzxw zzxwVar = (zzxw) zzydVar;
        int iZzi = zzi(bArr, i3, zztpVar);
        int i4 = zztpVar.zza + iZzi;
        while (iZzi < i4) {
            iZzi = zzi(bArr, iZzi, zztpVar);
            zzxwVar.zzh(zztpVar.zza);
        }
        if (iZzi == i4) {
            return iZzi;
        }
        throw zzyg.zzj();
    }

    static int zzg(byte[] bArr, int i3, zztp zztpVar) throws zzyg {
        int iZzi = zzi(bArr, i3, zztpVar);
        int i4 = zztpVar.zza;
        if (i4 < 0) {
            throw zzyg.zzf();
        }
        if (i4 == 0) {
            zztpVar.zzc = "";
            return iZzi;
        }
        zztpVar.zzc = new String(bArr, iZzi, i4, zzye.zzb);
        return iZzi + i4;
    }

    static int zzh(int i3, byte[] bArr, int i4, int i5, zzaal zzaalVar, zztp zztpVar) throws zzyg {
        if ((i3 >>> 3) == 0) {
            throw zzyg.zzc();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzl = zzl(bArr, i4, zztpVar);
            zzaalVar.zzj(i3, Long.valueOf(zztpVar.zzb));
            return iZzl;
        }
        if (i6 == 1) {
            zzaalVar.zzj(i3, Long.valueOf(zzp(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZzi = zzi(bArr, i4, zztpVar);
            int i7 = zztpVar.zza;
            if (i7 < 0) {
                throw zzyg.zzf();
            }
            if (i7 > bArr.length - iZzi) {
                throw zzyg.zzj();
            }
            if (i7 == 0) {
                zzaalVar.zzj(i3, zzud.zzb);
            } else {
                zzaalVar.zzj(i3, zzud.zzl(bArr, iZzi, i7));
            }
            return iZzi + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw zzyg.zzc();
            }
            zzaalVar.zzj(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzaal zzaalVarZzf = zzaal.zzf();
        int i9 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZzi2 = zzi(bArr, i4, zztpVar);
            i9 = zztpVar.zza;
            if (i9 == i8) {
                i4 = iZzi2;
                break;
            }
            i4 = zzh(i9, bArr, iZzi2, i5, zzaalVarZzf, zztpVar);
        }
        if (i4 > i5 || i9 != i8) {
            throw zzyg.zzg();
        }
        zzaalVar.zzj(i3, zzaalVarZzf);
        return i4;
    }

    static int zzi(byte[] bArr, int i3, zztp zztpVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzj(b3, bArr, i4, zztpVar);
        }
        zztpVar.zza = b3;
        return i4;
    }

    static int zzj(int i3, byte[] bArr, int i4, zztp zztpVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zztpVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zztpVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zztpVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zztpVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zztpVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzk(int i3, byte[] bArr, int i4, int i5, zzyd zzydVar, zztp zztpVar) {
        zzxw zzxwVar = (zzxw) zzydVar;
        int iZzi = zzi(bArr, i4, zztpVar);
        zzxwVar.zzh(zztpVar.zza);
        while (iZzi < i5) {
            int iZzi2 = zzi(bArr, iZzi, zztpVar);
            if (i3 != zztpVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zztpVar);
            zzxwVar.zzh(zztpVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i3, zztp zztpVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zztpVar.zzb = j3;
            return i4;
        }
        int i5 = i3 + 2;
        byte b3 = bArr[i4];
        long j4 = (j3 & 127) | (((long) (b3 & Ascii.DEL)) << 7);
        int i6 = 7;
        while (b3 < 0) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            i6 += 7;
            j4 |= ((long) (b4 & Ascii.DEL)) << i6;
            b3 = b4;
            i5 = i7;
        }
        zztpVar.zzb = j4;
        return i5;
    }

    static int zzm(Object obj, zzzt zzztVar, byte[] bArr, int i3, int i4, int i5, zztp zztpVar) throws IOException {
        int iZzc = ((zzzj) zzztVar).zzc(obj, bArr, i3, i4, i5, zztpVar);
        zztpVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzzt zzztVar, byte[] bArr, int i3, int i4, zztp zztpVar) throws IOException {
        int iZzj = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzj = zzj(i5, bArr, iZzj, zztpVar);
            i5 = zztpVar.zza;
        }
        int i6 = iZzj;
        if (i5 < 0 || i5 > i4 - i6) {
            throw zzyg.zzj();
        }
        int i7 = i6 + i5;
        zzztVar.zzi(obj, bArr, i6, i7, zztpVar);
        zztpVar.zzc = obj;
        return i7;
    }

    static int zzo(int i3, byte[] bArr, int i4, int i5, zztp zztpVar) throws zzyg {
        if ((i3 >>> 3) == 0) {
            throw zzyg.zzc();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzl(bArr, i4, zztpVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zzi(bArr, i4, zztpVar) + zztpVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw zzyg.zzc();
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zzi(bArr, i4, zztpVar);
            i8 = zztpVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zzo(i8, bArr, i4, i5, zztpVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw zzyg.zzg();
        }
        return i4;
    }

    static long zzp(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }
}
