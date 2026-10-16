package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzajr {
    private static volatile int zza = 100;

    static double zza(byte[] bArr, int i3) {
        return Double.longBitsToDouble(zzd(bArr, i3));
    }

    static float zzb(byte[] bArr, int i3) {
        return Float.intBitsToFloat(zzc(bArr, i3));
    }

    static int zzc(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    static int zzd(byte[] bArr, int i3, zzaju zzajuVar) {
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        if (j3 >= 0) {
            zzajuVar.zzb = j3;
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
        zzajuVar.zzb = j4;
        return i5;
    }

    static int zza(byte[] bArr, int i3, zzaju zzajuVar) throws zzall {
        int iZzc = zzc(bArr, i3, zzajuVar);
        int i4 = zzajuVar.zza;
        if (i4 < 0) {
            throw zzall.zzf();
        }
        if (i4 > bArr.length - iZzc) {
            throw zzall.zzj();
        }
        if (i4 == 0) {
            zzajuVar.zzc = zzajv.zza;
            return iZzc;
        }
        zzajuVar.zzc = zzajv.zza(bArr, iZzc, i4);
        return iZzc + i4;
    }

    static int zzb(zzanb<?> zzanbVar, int i3, byte[] bArr, int i4, int i5, zzalm<?> zzalmVar, zzaju zzajuVar) throws IOException {
        int iZza = zza(zzanbVar, bArr, i4, i5, zzajuVar);
        zzalmVar.add(zzajuVar.zzc);
        while (iZza < i5) {
            int iZzc = zzc(bArr, iZza, zzajuVar);
            if (i3 != zzajuVar.zza) {
                break;
            }
            iZza = zza(zzanbVar, bArr, iZzc, i5, zzajuVar);
            zzalmVar.add(zzajuVar.zzc);
        }
        return iZza;
    }

    static int zzc(byte[] bArr, int i3, zzaju zzajuVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zza(b3, bArr, i4, zzajuVar);
        }
        zzajuVar.zza = b3;
        return i4;
    }

    static long zzd(byte[] bArr, int i3) {
        return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
    }

    static int zzb(byte[] bArr, int i3, zzaju zzajuVar) throws zzall {
        int iZzc = zzc(bArr, i3, zzajuVar);
        int i4 = zzajuVar.zza;
        if (i4 < 0) {
            throw zzall.zzf();
        }
        if (i4 == 0) {
            zzajuVar.zzc = "";
            return iZzc;
        }
        zzajuVar.zzc = zzaoa.zzb(bArr, iZzc, i4);
        return iZzc + i4;
    }

    static int zza(int i3, byte[] bArr, int i4, int i5, Object obj, zzamm zzammVar, zzanu<zzanx, zzanx> zzanuVar, zzaju zzajuVar) throws IOException {
        if (zzajuVar.zzd.zza(zzammVar, i3 >>> 3) == null) {
            return zza(i3, bArr, i4, i5, zzamq.zzc(obj), zzajuVar);
        }
        zzalf.zzd zzdVar = (zzalf.zzd) obj;
        zzdVar.zza();
        zzakx<zzalf.zzc> zzakxVar = zzdVar.zzc;
        throw new NoSuchMethodError();
    }

    private static <T> int zza(zzanb<T> zzanbVar, byte[] bArr, int i3, int i4, int i5, zzaju zzajuVar) throws IOException {
        T tZza = zzanbVar.zza();
        int iZza = zza(tZza, zzanbVar, bArr, i3, i4, i5, zzajuVar);
        zzanbVar.zzd(tZza);
        zzajuVar.zzc = tZza;
        return iZza;
    }

    static int zza(zzanb<?> zzanbVar, int i3, byte[] bArr, int i4, int i5, zzalm<Object> zzalmVar, zzaju zzajuVar) throws IOException {
        int i6 = (i3 & (-8)) | 4;
        int iZza = zza(zzanbVar, bArr, i4, i5, i6, zzajuVar);
        zzalmVar.add(zzajuVar.zzc);
        while (iZza < i5) {
            int iZzc = zzc(bArr, iZza, zzajuVar);
            if (i3 != zzajuVar.zza) {
                break;
            }
            iZza = zza(zzanbVar, bArr, iZzc, i5, i6, zzajuVar);
            zzalmVar.add(zzajuVar.zzc);
        }
        return iZza;
    }

    static <T> int zza(zzanb<T> zzanbVar, byte[] bArr, int i3, int i4, zzaju zzajuVar) throws IOException {
        T tZza = zzanbVar.zza();
        int iZza = zza(tZza, zzanbVar, bArr, i3, i4, zzajuVar);
        zzanbVar.zzd(tZza);
        zzajuVar.zzc = tZza;
        return iZza;
    }

    static int zza(byte[] bArr, int i3, zzalm<?> zzalmVar, zzaju zzajuVar) throws IOException {
        zzali zzaliVar = (zzali) zzalmVar;
        int iZzc = zzc(bArr, i3, zzajuVar);
        int i4 = zzajuVar.zza + iZzc;
        while (iZzc < i4) {
            iZzc = zzc(bArr, iZzc, zzajuVar);
            zzaliVar.zzc(zzajuVar.zza);
        }
        if (iZzc == i4) {
            return iZzc;
        }
        throw zzall.zzj();
    }

    static int zza(int i3, byte[] bArr, int i4, int i5, zzanx zzanxVar, zzaju zzajuVar) throws zzall {
        if ((i3 >>> 3) == 0) {
            throw zzall.zzc();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzd = zzd(bArr, i4, zzajuVar);
            zzanxVar.zza(i3, Long.valueOf(zzajuVar.zzb));
            return iZzd;
        }
        if (i6 == 1) {
            zzanxVar.zza(i3, Long.valueOf(zzd(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZzc = zzc(bArr, i4, zzajuVar);
            int i7 = zzajuVar.zza;
            if (i7 >= 0) {
                if (i7 > bArr.length - iZzc) {
                    throw zzall.zzj();
                }
                if (i7 == 0) {
                    zzanxVar.zza(i3, zzajv.zza);
                } else {
                    zzanxVar.zza(i3, zzajv.zza(bArr, iZzc, i7));
                }
                return iZzc + i7;
            }
            throw zzall.zzf();
        }
        if (i6 != 3) {
            if (i6 == 5) {
                zzanxVar.zza(i3, Integer.valueOf(zzc(bArr, i4)));
                return i4 + 4;
            }
            throw zzall.zzc();
        }
        zzanx zzanxVarZzd = zzanx.zzd();
        int i8 = (i3 & (-8)) | 4;
        int i9 = zzajuVar.zze + 1;
        zzajuVar.zze = i9;
        zza(i9);
        int i10 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZzc2 = zzc(bArr, i4, zzajuVar);
            i10 = zzajuVar.zza;
            if (i10 == i8) {
                i4 = iZzc2;
                break;
            }
            i4 = zza(i10, bArr, iZzc2, i5, zzanxVarZzd, zzajuVar);
        }
        zzajuVar.zze--;
        if (i4 <= i5 && i10 == i8) {
            zzanxVar.zza(i3, zzanxVarZzd);
            return i4;
        }
        throw zzall.zzg();
    }

    static int zza(int i3, byte[] bArr, int i4, zzaju zzajuVar) {
        int i5 = i3 & 127;
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzajuVar.zza = i5 | (b3 << 7);
            return i6;
        }
        int i7 = i5 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzajuVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzajuVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzajuVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzajuVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zza(int i3, byte[] bArr, int i4, int i5, zzalm<?> zzalmVar, zzaju zzajuVar) {
        zzali zzaliVar = (zzali) zzalmVar;
        int iZzc = zzc(bArr, i4, zzajuVar);
        zzaliVar.zzc(zzajuVar.zza);
        while (iZzc < i5) {
            int iZzc2 = zzc(bArr, iZzc, zzajuVar);
            if (i3 != zzajuVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzajuVar);
            zzaliVar.zzc(zzajuVar.zza);
        }
        return iZzc;
    }

    static <T> int zza(Object obj, zzanb<T> zzanbVar, byte[] bArr, int i3, int i4, int i5, zzaju zzajuVar) throws IOException {
        int i6 = zzajuVar.zze + 1;
        zzajuVar.zze = i6;
        zza(i6);
        int iZza = ((zzamq) zzanbVar).zza(obj, bArr, i3, i4, i5, zzajuVar);
        zzajuVar.zze--;
        zzajuVar.zzc = obj;
        return iZza;
    }

    static <T> int zza(Object obj, zzanb<T> zzanbVar, byte[] bArr, int i3, int i4, zzaju zzajuVar) throws IOException {
        int iZza = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZza = zza(i5, bArr, iZza, zzajuVar);
            i5 = zzajuVar.zza;
        }
        int i6 = iZza;
        if (i5 >= 0 && i5 <= i4 - i6) {
            int i7 = zzajuVar.zze + 1;
            zzajuVar.zze = i7;
            zza(i7);
            int i8 = i6 + i5;
            zzanbVar.zza(obj, bArr, i6, i8, zzajuVar);
            zzajuVar.zze--;
            zzajuVar.zzc = obj;
            return i8;
        }
        throw zzall.zzj();
    }

    static int zza(int i3, byte[] bArr, int i4, int i5, zzaju zzajuVar) throws zzall {
        if ((i3 >>> 3) == 0) {
            throw zzall.zzc();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzd(bArr, i4, zzajuVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zzc(bArr, i4, zzajuVar) + zzajuVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw zzall.zzc();
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zzc(bArr, i4, zzajuVar);
            i8 = zzajuVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zza(i8, bArr, i4, i5, zzajuVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw zzall.zzg();
        }
        return i4;
    }

    private static void zza(int i3) throws zzall {
        if (i3 >= zza) {
            throw zzall.zzh();
        }
    }
}
