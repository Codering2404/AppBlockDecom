package com.google.android.recaptcha.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzku {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i3, zzkt zzktVar) throws zznn {
        int iZzi = zzi(bArr, i3, zzktVar);
        int i4 = zzktVar.zza;
        if (i4 < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 > bArr.length - iZzi) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i4 == 0) {
            zzktVar.zzc = zzle.zzb;
            return iZzi;
        }
        zzktVar.zzc = zzle.zzk(bArr, iZzi, i4);
        return iZzi + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzow zzowVar, byte[] bArr, int i3, int i4, int i5, zzkt zzktVar) throws IOException {
        Object objZze = zzowVar.zze();
        int iZzm = zzm(objZze, zzowVar, bArr, i3, i4, i5, zzktVar);
        zzowVar.zzf(objZze);
        zzktVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzow zzowVar, byte[] bArr, int i3, int i4, zzkt zzktVar) throws IOException {
        Object objZze = zzowVar.zze();
        int iZzn = zzn(objZze, zzowVar, bArr, i3, i4, zzktVar);
        zzowVar.zzf(objZze);
        zzktVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzow zzowVar, int i3, byte[] bArr, int i4, int i5, zznk zznkVar, zzkt zzktVar) throws IOException {
        int iZzd = zzd(zzowVar, bArr, i4, i5, zzktVar);
        zznkVar.add(zzktVar.zzc);
        while (iZzd < i5) {
            int iZzi = zzi(bArr, iZzd, zzktVar);
            if (i3 != zzktVar.zza) {
                break;
            }
            iZzd = zzd(zzowVar, bArr, iZzi, i5, zzktVar);
            zznkVar.add(zzktVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i3, zznk zznkVar, zzkt zzktVar) throws IOException {
        zzne zzneVar = (zzne) zznkVar;
        int iZzi = zzi(bArr, i3, zzktVar);
        int i4 = zzktVar.zza + iZzi;
        while (iZzi < i4) {
            iZzi = zzi(bArr, iZzi, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        if (iZzi == i4) {
            return iZzi;
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzh(int i3, byte[] bArr, int i4, int i5, zzpm zzpmVar, zzkt zzktVar) throws zznn {
        if ((i3 >>> 3) == 0) {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzl = zzl(bArr, i4, zzktVar);
            zzpmVar.zzj(i3, Long.valueOf(zzktVar.zzb));
            return iZzl;
        }
        if (i6 == 1) {
            zzpmVar.zzj(i3, Long.valueOf(zzp(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZzi = zzi(bArr, i4, zzktVar);
            int i7 = zzktVar.zza;
            if (i7 < 0) {
                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i7 > bArr.length - iZzi) {
                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i7 == 0) {
                zzpmVar.zzj(i3, zzle.zzb);
            } else {
                zzpmVar.zzj(i3, zzle.zzk(bArr, iZzi, i7));
            }
            return iZzi + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw new zznn("Protocol message contained an invalid tag (zero).");
            }
            zzpmVar.zzj(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzpm zzpmVarZzf = zzpm.zzf();
        int i9 = zzktVar.zze + 1;
        zzktVar.zze = i9;
        zzq(i9);
        int i10 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZzi2 = zzi(bArr, i4, zzktVar);
            int i11 = zzktVar.zza;
            if (i11 == i8) {
                i10 = i11;
                i4 = iZzi2;
                break;
            }
            i4 = zzh(i11, bArr, iZzi2, i5, zzpmVarZzf, zzktVar);
            i10 = i11;
        }
        zzktVar.zze--;
        if (i4 > i5 || i10 != i8) {
            throw new zznn("Failed to parse the message.");
        }
        zzpmVar.zzj(i3, zzpmVarZzf);
        return i4;
    }

    static int zzi(byte[] bArr, int i3, zzkt zzktVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzj(b3, bArr, i4, zzktVar);
        }
        zzktVar.zza = b3;
        return i4;
    }

    static int zzj(int i3, byte[] bArr, int i4, zzkt zzktVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zzktVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzktVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzktVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzktVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzktVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzk(int i3, byte[] bArr, int i4, int i5, zznk zznkVar, zzkt zzktVar) {
        zzne zzneVar = (zzne) zznkVar;
        int iZzi = zzi(bArr, i4, zzktVar);
        zzneVar.zzh(zzktVar.zza);
        while (iZzi < i5) {
            int iZzi2 = zzi(bArr, iZzi, zzktVar);
            if (i3 != zzktVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzktVar);
            zzneVar.zzh(zzktVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i3, zzkt zzktVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzktVar.zzb = j3;
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
        zzktVar.zzb = j4;
        return i5;
    }

    static int zzm(Object obj, zzow zzowVar, byte[] bArr, int i3, int i4, int i5, zzkt zzktVar) throws IOException {
        int i6 = zzktVar.zze + 1;
        zzktVar.zze = i6;
        zzq(i6);
        int iZzc = ((zzol) zzowVar).zzc(obj, bArr, i3, i4, i5, zzktVar);
        zzktVar.zze--;
        zzktVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzow zzowVar, byte[] bArr, int i3, int i4, zzkt zzktVar) throws IOException {
        int iZzj = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzj = zzj(i5, bArr, iZzj, zzktVar);
            i5 = zzktVar.zza;
        }
        int i6 = iZzj;
        if (i5 < 0 || i5 > i4 - i6) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = zzktVar.zze + 1;
        zzktVar.zze = i7;
        zzq(i7);
        int i8 = i6 + i5;
        zzowVar.zzi(obj, bArr, i6, i8, zzktVar);
        zzktVar.zze--;
        zzktVar.zzc = obj;
        return i8;
    }

    static int zzo(int i3, byte[] bArr, int i4, int i5, zzkt zzktVar) throws zznn {
        if ((i3 >>> 3) == 0) {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzl(bArr, i4, zzktVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zzi(bArr, i4, zzktVar) + zzktVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zzi(bArr, i4, zzktVar);
            i8 = zzktVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zzo(i8, bArr, i4, i5, zzktVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw new zznn("Failed to parse the message.");
        }
        return i4;
    }

    static long zzp(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    private static void zzq(int i3) throws zznn {
        if (i3 >= zzb) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    static int zzg(byte[] bArr, int i3, zzkt zzktVar) throws zznn {
        int iZzi = zzi(bArr, i3, zzktVar);
        int i4 = zzktVar.zza;
        if (i4 >= 0) {
            if (i4 == 0) {
                zzktVar.zzc = "";
                return iZzi;
            }
            zzktVar.zzc = new String(bArr, iZzi, i4, zznl.zza);
            return iZzi + i4;
        }
        throw new zznn(pMpIcGE.Ahuf);
    }
}
