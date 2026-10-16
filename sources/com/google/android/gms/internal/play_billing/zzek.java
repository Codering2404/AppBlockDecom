package com.google.android.gms.internal.play_billing;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzek {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i3, zzej zzejVar) throws zzgc {
        int iZzi = zzi(bArr, i3, zzejVar);
        int i4 = zzejVar.zza;
        if (i4 < 0) {
            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 > bArr.length - iZzi) {
            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i4 == 0) {
            zzejVar.zzc = zzev.zza;
            return iZzi;
        }
        zzejVar.zzc = zzev.zzk(bArr, iZzi, i4);
        return iZzi + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzhl zzhlVar, byte[] bArr, int i3, int i4, int i5, zzej zzejVar) throws IOException {
        Object objZze = zzhlVar.zze();
        int iZzm = zzm(objZze, zzhlVar, bArr, i3, i4, i5, zzejVar);
        zzhlVar.zzf(objZze);
        zzejVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzhl zzhlVar, byte[] bArr, int i3, int i4, zzej zzejVar) throws IOException {
        Object objZze = zzhlVar.zze();
        int iZzn = zzn(objZze, zzhlVar, bArr, i3, i4, zzejVar);
        zzhlVar.zzf(objZze);
        zzejVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzhl zzhlVar, int i3, byte[] bArr, int i4, int i5, zzfz zzfzVar, zzej zzejVar) throws IOException {
        int iZzd = zzd(zzhlVar, bArr, i4, i5, zzejVar);
        zzfzVar.add(zzejVar.zzc);
        while (iZzd < i5) {
            int iZzi = zzi(bArr, iZzd, zzejVar);
            if (i3 != zzejVar.zza) {
                break;
            }
            iZzd = zzd(zzhlVar, bArr, iZzi, i5, zzejVar);
            zzfzVar.add(zzejVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i3, zzfz zzfzVar, zzej zzejVar) throws IOException {
        zzfv zzfvVar = (zzfv) zzfzVar;
        int iZzi = zzi(bArr, i3, zzejVar);
        int i4 = zzejVar.zza + iZzi;
        while (iZzi < i4) {
            iZzi = zzi(bArr, iZzi, zzejVar);
            zzfvVar.zzg(zzejVar.zza);
        }
        if (iZzi == i4) {
            return iZzi;
        }
        throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(byte[] bArr, int i3, zzej zzejVar) throws zzgc {
        int i4;
        int iZzi = zzi(bArr, i3, zzejVar);
        int i5 = zzejVar.zza;
        if (i5 < 0) {
            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i5 == 0) {
            zzejVar.zzc = "";
            return iZzi;
        }
        int i6 = zzin.zza;
        int length = bArr.length;
        if ((((length - iZzi) - i5) | iZzi | i5) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzi), Integer.valueOf(i5)));
        }
        int i7 = iZzi + i5;
        char[] cArr = new char[i5];
        int i8 = 0;
        while (iZzi < i7) {
            byte b3 = bArr[iZzi];
            if (!zzij.zzd(b3)) {
                break;
            }
            iZzi++;
            cArr[i8] = (char) b3;
            i8++;
        }
        int i9 = i8;
        while (iZzi < i7) {
            int i10 = iZzi + 1;
            byte b4 = bArr[iZzi];
            if (zzij.zzd(b4)) {
                cArr[i9] = (char) b4;
                i9++;
                iZzi = i10;
                while (iZzi < i7) {
                    byte b5 = bArr[iZzi];
                    if (zzij.zzd(b5)) {
                        iZzi++;
                        cArr[i9] = (char) b5;
                        i9++;
                    }
                }
            } else {
                if (b4 < -32) {
                    if (i10 >= i7) {
                        throw new zzgc("Protocol message had invalid UTF-8.");
                    }
                    i4 = i9 + 1;
                    iZzi += 2;
                    zzij.zzc(b4, bArr[i10], cArr, i9);
                } else if (b4 < -16) {
                    if (i10 >= i7 - 1) {
                        throw new zzgc("Protocol message had invalid UTF-8.");
                    }
                    i4 = i9 + 1;
                    int i11 = iZzi + 2;
                    iZzi += 3;
                    zzij.zzb(b4, bArr[i10], bArr[i11], cArr, i9);
                } else {
                    if (i10 >= i7 - 2) {
                        throw new zzgc("Protocol message had invalid UTF-8.");
                    }
                    byte b6 = bArr[i10];
                    int i12 = iZzi + 3;
                    byte b7 = bArr[iZzi + 2];
                    iZzi += 4;
                    zzij.zza(b4, b6, b7, bArr[i12], cArr, i9);
                    i9 += 2;
                }
                i9 = i4;
            }
        }
        zzejVar.zzc = new String(cArr, 0, i9);
        return i7;
    }

    static int zzh(int i3, byte[] bArr, int i4, int i5, zzic zzicVar, zzej zzejVar) throws zzgc {
        if ((i3 >>> 3) == 0) {
            throw new zzgc("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzl = zzl(bArr, i4, zzejVar);
            zzicVar.zzj(i3, Long.valueOf(zzejVar.zzb));
            return iZzl;
        }
        if (i6 == 1) {
            zzicVar.zzj(i3, Long.valueOf(zzp(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZzi = zzi(bArr, i4, zzejVar);
            int i7 = zzejVar.zza;
            if (i7 < 0) {
                throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i7 > bArr.length - iZzi) {
                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i7 == 0) {
                zzicVar.zzj(i3, zzev.zza);
            } else {
                zzicVar.zzj(i3, zzev.zzk(bArr, iZzi, i7));
            }
            return iZzi + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw new zzgc("Protocol message contained an invalid tag (zero).");
            }
            zzicVar.zzj(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzic zzicVarZzf = zzic.zzf();
        int i9 = zzejVar.zze + 1;
        zzejVar.zze = i9;
        zzq(i9);
        int i10 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZzi2 = zzi(bArr, i4, zzejVar);
            int i11 = zzejVar.zza;
            if (i11 == i8) {
                i10 = i11;
                i4 = iZzi2;
                break;
            }
            i4 = zzh(i11, bArr, iZzi2, i5, zzicVarZzf, zzejVar);
            i10 = i11;
        }
        zzejVar.zze--;
        if (i4 > i5 || i10 != i8) {
            throw new zzgc("Failed to parse the message.");
        }
        zzicVar.zzj(i3, zzicVarZzf);
        return i4;
    }

    static int zzi(byte[] bArr, int i3, zzej zzejVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzj(b3, bArr, i4, zzejVar);
        }
        zzejVar.zza = b3;
        return i4;
    }

    static int zzj(int i3, byte[] bArr, int i4, zzej zzejVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zzejVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzejVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzejVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzejVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzejVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzk(int i3, byte[] bArr, int i4, int i5, zzfz zzfzVar, zzej zzejVar) {
        zzfv zzfvVar = (zzfv) zzfzVar;
        int iZzi = zzi(bArr, i4, zzejVar);
        zzfvVar.zzg(zzejVar.zza);
        while (iZzi < i5) {
            int iZzi2 = zzi(bArr, iZzi, zzejVar);
            if (i3 != zzejVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzejVar);
            zzfvVar.zzg(zzejVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i3, zzej zzejVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzejVar.zzb = j3;
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
        zzejVar.zzb = j4;
        return i5;
    }

    static int zzm(Object obj, zzhl zzhlVar, byte[] bArr, int i3, int i4, int i5, zzej zzejVar) throws IOException {
        int i6 = zzejVar.zze + 1;
        zzejVar.zze = i6;
        zzq(i6);
        int iZzc = ((zzhe) zzhlVar).zzc(obj, bArr, i3, i4, i5, zzejVar);
        zzejVar.zze--;
        zzejVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzhl zzhlVar, byte[] bArr, int i3, int i4, zzej zzejVar) throws IOException {
        int iZzj = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzj = zzj(i5, bArr, iZzj, zzejVar);
            i5 = zzejVar.zza;
        }
        int i6 = iZzj;
        if (i5 < 0 || i5 > i4 - i6) {
            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = zzejVar.zze + 1;
        zzejVar.zze = i7;
        zzq(i7);
        int i8 = i6 + i5;
        zzhlVar.zzh(obj, bArr, i6, i8, zzejVar);
        zzejVar.zze--;
        zzejVar.zzc = obj;
        return i8;
    }

    static int zzo(int i3, byte[] bArr, int i4, int i5, zzej zzejVar) throws zzgc {
        if ((i3 >>> 3) == 0) {
            throw new zzgc("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzl(bArr, i4, zzejVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zzi(bArr, i4, zzejVar) + zzejVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw new zzgc("Protocol message contained an invalid tag (zero).");
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zzi(bArr, i4, zzejVar);
            i8 = zzejVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zzo(i8, bArr, i4, i5, zzejVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw new zzgc("Failed to parse the message.");
        }
        return i4;
    }

    static long zzp(byte[] bArr, int i3) {
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    private static void zzq(int i3) throws zzgc {
        if (i3 >= zzb) {
            throw new zzgc("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
