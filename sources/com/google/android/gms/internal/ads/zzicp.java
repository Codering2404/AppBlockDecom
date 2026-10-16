package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzicp {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i3, zzico zzicoVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzb(b3, bArr, i4, zzicoVar);
        }
        zzicoVar.zza = b3;
        return i4;
    }

    static int zzb(int i3, byte[] bArr, int i4, zzico zzicoVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zzicoVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzicoVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzicoVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzicoVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzicoVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzc(byte[] bArr, int i3, zzico zzicoVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzicoVar.zzb = j3;
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
        zzicoVar.zzb = j4;
        return i5;
    }

    static int zzd(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static long zze(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    static int zzf(byte[] bArr, int i3, zzico zzicoVar) throws zziet {
        int iZza = zza(bArr, i3, zzicoVar);
        int i4 = zzicoVar.zza;
        if (i4 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            zzicoVar.zzc = "";
            return iZza;
        }
        zzicoVar.zzc = zzihf.zze(bArr, iZza, i4);
        return iZza + i4;
    }

    static int zzg(byte[] bArr, int i3, zzico zzicoVar) throws zziet {
        int iZza = zza(bArr, i3, zzicoVar);
        int i4 = zzicoVar.zza;
        if (i4 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 > bArr.length - iZza) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i4 == 0) {
            zzicoVar.zzc = zzida.zza;
            return iZza;
        }
        zzicoVar.zzc = zzida.zzt(bArr, iZza, i4);
        return iZza + i4;
    }

    static int zzh(zzigh zzighVar, byte[] bArr, int i3, int i4, zzico zzicoVar) throws IOException {
        Object objZza = zzighVar.zza();
        int iZzj = zzj(objZza, zzighVar, bArr, i3, i4, zzicoVar);
        zzighVar.zzk(objZza);
        zzicoVar.zzc = objZza;
        return iZzj;
    }

    static int zzi(zzigh zzighVar, byte[] bArr, int i3, int i4, int i5, zzico zzicoVar) throws IOException {
        Object objZza = zzighVar.zza();
        int iZzk = zzk(objZza, zzighVar, bArr, i3, i4, i5, zzicoVar);
        zzighVar.zzk(objZza);
        zzicoVar.zzc = objZza;
        return iZzk;
    }

    static int zzj(Object obj, zzigh zzighVar, byte[] bArr, int i3, int i4, zzico zzicoVar) throws IOException {
        int iZzb = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzb = zzb(i5, bArr, iZzb, zzicoVar);
            i5 = zzicoVar.zza;
        }
        int i6 = iZzb;
        if (i5 < 0 || i5 > i4 - i6) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = zzicoVar.zze + 1;
        zzicoVar.zze = i7;
        zzq(i7);
        int i8 = i6 + i5;
        zzighVar.zzj(obj, bArr, i6, i8, zzicoVar);
        zzicoVar.zze--;
        zzicoVar.zzc = obj;
        return i8;
    }

    static int zzk(Object obj, zzigh zzighVar, byte[] bArr, int i3, int i4, int i5, zzico zzicoVar) throws IOException {
        int i6 = zzicoVar.zze + 1;
        zzicoVar.zze = i6;
        zzq(i6);
        int iZzi = ((zzifs) zzighVar).zzi(obj, bArr, i3, i4, i5, zzicoVar);
        zzicoVar.zze--;
        zzicoVar.zzc = obj;
        return iZzi;
    }

    static int zzl(int i3, byte[] bArr, int i4, int i5, zzieq zzieqVar, zzico zzicoVar) {
        zzief zziefVar = (zzief) zzieqVar;
        int iZza = zza(bArr, i4, zzicoVar);
        zziefVar.zzi(zzicoVar.zza);
        while (iZza < i5) {
            int iZza2 = zza(bArr, iZza, zzicoVar);
            if (i3 != zzicoVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzicoVar);
            zziefVar.zzi(zzicoVar.zza);
        }
        return iZza;
    }

    static int zzm(byte[] bArr, int i3, zzieq zzieqVar, zzico zzicoVar) throws IOException {
        zzief zziefVar = (zzief) zzieqVar;
        int iZza = zza(bArr, i3, zzicoVar);
        int i4 = zzicoVar.zza + iZza;
        while (iZza < i4) {
            iZza = zza(bArr, iZza, zzicoVar);
            zziefVar.zzi(zzicoVar.zza);
        }
        if (iZza == i4) {
            return iZza;
        }
        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzn(zzigh zzighVar, int i3, byte[] bArr, int i4, int i5, zzieq zzieqVar, zzico zzicoVar) throws IOException {
        int iZzh = zzh(zzighVar, bArr, i4, i5, zzicoVar);
        zzieqVar.add(zzicoVar.zzc);
        while (iZzh < i5) {
            int iZza = zza(bArr, iZzh, zzicoVar);
            if (i3 != zzicoVar.zza) {
                break;
            }
            iZzh = zzh(zzighVar, bArr, iZza, i5, zzicoVar);
            zzieqVar.add(zzicoVar.zzc);
        }
        return iZzh;
    }

    static int zzo(int i3, byte[] bArr, int i4, int i5, zzigu zziguVar, zzico zzicoVar) throws zziet {
        if ((i3 >>> 3) == 0) {
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzc = zzc(bArr, i4, zzicoVar);
            zziguVar.zzk(i3, Long.valueOf(zzicoVar.zzb));
            return iZzc;
        }
        if (i6 == 1) {
            zziguVar.zzk(i3, Long.valueOf(zze(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZza = zza(bArr, i4, zzicoVar);
            int i7 = zzicoVar.zza;
            if (i7 < 0) {
                throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i7 > bArr.length - iZza) {
                throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i7 == 0) {
                zziguVar.zzk(i3, zzida.zza);
            } else {
                zziguVar.zzk(i3, zzida.zzt(bArr, iZza, i7));
            }
            return iZza + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw new zziet("Protocol message contained an invalid tag (zero).");
            }
            zziguVar.zzk(i3, Integer.valueOf(zzd(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzigu zziguVarZzb = zzigu.zzb();
        int i9 = zzicoVar.zze + 1;
        zzicoVar.zze = i9;
        zzq(i9);
        int i10 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZza2 = zza(bArr, i4, zzicoVar);
            int i11 = zzicoVar.zza;
            if (i11 == i8) {
                i10 = i11;
                i4 = iZza2;
                break;
            }
            i4 = zzo(i11, bArr, iZza2, i5, zziguVarZzb, zzicoVar);
            i10 = i11;
        }
        zzicoVar.zze--;
        if (i4 > i5 || i10 != i8) {
            throw new zziet("Failed to parse the message.");
        }
        zziguVar.zzk(i3, zziguVarZzb);
        return i4;
    }

    static int zzp(int i3, byte[] bArr, int i4, int i5, zzico zzicoVar) throws zziet {
        if ((i3 >>> 3) == 0) {
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzc(bArr, i4, zzicoVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zza(bArr, i4, zzicoVar) + zzicoVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zza(bArr, i4, zzicoVar);
            i8 = zzicoVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zzp(i8, bArr, i4, i5, zzicoVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw new zziet("Failed to parse the message.");
        }
        return i4;
    }

    private static void zzq(int i3) throws zziet {
        if (i3 >= zzb) {
            throw new zziet("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
