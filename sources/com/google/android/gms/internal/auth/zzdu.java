package com.google.android.gms.internal.auth;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdu {
    static int zza(byte[] bArr, int i3, zzdt zzdtVar) throws zzfb {
        int iZzh = zzh(bArr, i3, zzdtVar);
        int i4 = zzdtVar.zza;
        if (i4 < 0) {
            throw zzfb.zzc();
        }
        if (i4 > bArr.length - iZzh) {
            throw zzfb.zzf();
        }
        if (i4 == 0) {
            zzdtVar.zzc = zzef.zzb;
            return iZzh;
        }
        zzdtVar.zzc = zzef.zzk(bArr, iZzh, i4);
        return iZzh + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzgi zzgiVar, byte[] bArr, int i3, int i4, int i5, zzdt zzdtVar) throws IOException {
        Object objZzd = zzgiVar.zzd();
        int iZzl = zzl(objZzd, zzgiVar, bArr, i3, i4, i5, zzdtVar);
        zzgiVar.zze(objZzd);
        zzdtVar.zzc = objZzd;
        return iZzl;
    }

    static int zzd(zzgi zzgiVar, byte[] bArr, int i3, int i4, zzdt zzdtVar) throws IOException {
        Object objZzd = zzgiVar.zzd();
        int iZzm = zzm(objZzd, zzgiVar, bArr, i3, i4, zzdtVar);
        zzgiVar.zze(objZzd);
        zzdtVar.zzc = objZzd;
        return iZzm;
    }

    static int zze(zzgi zzgiVar, int i3, byte[] bArr, int i4, int i5, zzez zzezVar, zzdt zzdtVar) throws IOException {
        int iZzd = zzd(zzgiVar, bArr, i4, i5, zzdtVar);
        zzezVar.add(zzdtVar.zzc);
        while (iZzd < i5) {
            int iZzh = zzh(bArr, iZzd, zzdtVar);
            if (i3 != zzdtVar.zza) {
                break;
            }
            iZzd = zzd(zzgiVar, bArr, iZzh, i5, zzdtVar);
            zzezVar.add(zzdtVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i3, zzez zzezVar, zzdt zzdtVar) throws IOException {
        zzew zzewVar = (zzew) zzezVar;
        int iZzh = zzh(bArr, i3, zzdtVar);
        int i4 = zzdtVar.zza + iZzh;
        while (iZzh < i4) {
            iZzh = zzh(bArr, iZzh, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        if (iZzh == i4) {
            return iZzh;
        }
        throw zzfb.zzf();
    }

    static int zzg(int i3, byte[] bArr, int i4, int i5, zzha zzhaVar, zzdt zzdtVar) throws zzfb {
        if ((i3 >>> 3) == 0) {
            throw zzfb.zza();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzk = zzk(bArr, i4, zzdtVar);
            zzhaVar.zzh(i3, Long.valueOf(zzdtVar.zzb));
            return iZzk;
        }
        if (i6 == 1) {
            zzhaVar.zzh(i3, Long.valueOf(zzn(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZzh = zzh(bArr, i4, zzdtVar);
            int i7 = zzdtVar.zza;
            if (i7 < 0) {
                throw zzfb.zzc();
            }
            if (i7 > bArr.length - iZzh) {
                throw zzfb.zzf();
            }
            if (i7 == 0) {
                zzhaVar.zzh(i3, zzef.zzb);
            } else {
                zzhaVar.zzh(i3, zzef.zzk(bArr, iZzh, i7));
            }
            return iZzh + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw zzfb.zza();
            }
            zzhaVar.zzh(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzha zzhaVarZzd = zzha.zzd();
        int i9 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZzh2 = zzh(bArr, i4, zzdtVar);
            i9 = zzdtVar.zza;
            if (i9 == i8) {
                i4 = iZzh2;
                break;
            }
            i4 = zzg(i9, bArr, iZzh2, i5, zzhaVarZzd, zzdtVar);
        }
        if (i4 > i5 || i9 != i8) {
            throw zzfb.zzd();
        }
        zzhaVar.zzh(i3, zzhaVarZzd);
        return i4;
    }

    static int zzh(byte[] bArr, int i3, zzdt zzdtVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzi(b3, bArr, i4, zzdtVar);
        }
        zzdtVar.zza = b3;
        return i4;
    }

    static int zzi(int i3, byte[] bArr, int i4, zzdt zzdtVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zzdtVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzdtVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzdtVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzdtVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzdtVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzj(int i3, byte[] bArr, int i4, int i5, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int iZzh = zzh(bArr, i4, zzdtVar);
        zzewVar.zze(zzdtVar.zza);
        while (iZzh < i5) {
            int iZzh2 = zzh(bArr, iZzh, zzdtVar);
            if (i3 != zzdtVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i3, zzdt zzdtVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzdtVar.zzb = j3;
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
        zzdtVar.zzb = j4;
        return i5;
    }

    static int zzl(Object obj, zzgi zzgiVar, byte[] bArr, int i3, int i4, int i5, zzdt zzdtVar) throws IOException {
        int iZzb = ((zzga) zzgiVar).zzb(obj, bArr, i3, i4, i5, zzdtVar);
        zzdtVar.zzc = obj;
        return iZzb;
    }

    static int zzm(Object obj, zzgi zzgiVar, byte[] bArr, int i3, int i4, zzdt zzdtVar) throws IOException {
        int iZzi = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzi = zzi(i5, bArr, iZzi, zzdtVar);
            i5 = zzdtVar.zza;
        }
        int i6 = iZzi;
        if (i5 < 0 || i5 > i4 - i6) {
            throw zzfb.zzf();
        }
        int i7 = i6 + i5;
        zzgiVar.zzg(obj, bArr, i6, i7, zzdtVar);
        zzdtVar.zzc = obj;
        return i7;
    }

    static long zzn(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }
}
