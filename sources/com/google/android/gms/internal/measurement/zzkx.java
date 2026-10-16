package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i3, zzkw zzkwVar) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return zzb(b3, bArr, i4, zzkwVar);
        }
        zzkwVar.zza = b3;
        return i4;
    }

    static int zzb(int i3, byte[] bArr, int i4, zzkw zzkwVar) {
        byte b3 = bArr[i4];
        int i5 = i4 + 1;
        int i6 = i3 & 127;
        if (b3 >= 0) {
            zzkwVar.zza = i6 | (b3 << 7);
            return i5;
        }
        int i7 = i6 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzkwVar.zza = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzkwVar.zza = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            zzkwVar.zza = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                zzkwVar.zza = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int zzc(byte[] bArr, int i3, zzkw zzkwVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzkwVar.zzb = j3;
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
        zzkwVar.zzb = j4;
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

    static int zzf(byte[] bArr, int i3, zzkw zzkwVar) throws zzmr {
        int i4;
        int iZza = zza(bArr, i3, zzkwVar);
        int i5 = zzkwVar.zza;
        if (i5 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i5 == 0) {
            zzkwVar.zzc = "";
            return iZza;
        }
        int i6 = zzos.zza;
        int length = bArr.length;
        if ((((length - iZza) - i5) | iZza | i5) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZza), Integer.valueOf(i5)));
        }
        int i7 = iZza + i5;
        char[] cArr = new char[i5];
        int i8 = 0;
        while (iZza < i7) {
            byte b3 = bArr[iZza];
            if (!zzoq.zza(b3)) {
                break;
            }
            iZza++;
            cArr[i8] = (char) b3;
            i8++;
        }
        int i9 = i8;
        while (iZza < i7) {
            int i10 = iZza + 1;
            byte b4 = bArr[iZza];
            if (zzoq.zza(b4)) {
                cArr[i9] = (char) b4;
                i9++;
                iZza = i10;
                while (iZza < i7) {
                    byte b5 = bArr[iZza];
                    if (zzoq.zza(b5)) {
                        iZza++;
                        cArr[i9] = (char) b5;
                        i9++;
                    }
                }
            } else {
                if (b4 < -32) {
                    if (i10 >= i7) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i4 = i9 + 1;
                    iZza += 2;
                    zzoq.zzb(b4, bArr[i10], cArr, i9);
                } else if (b4 < -16) {
                    if (i10 >= i7 - 1) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i4 = i9 + 1;
                    int i11 = iZza + 2;
                    iZza += 3;
                    zzoq.zzc(b4, bArr[i10], bArr[i11], cArr, i9);
                } else {
                    if (i10 >= i7 - 2) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    byte b6 = bArr[i10];
                    int i12 = iZza + 3;
                    byte b7 = bArr[iZza + 2];
                    iZza += 4;
                    zzoq.zzd(b4, b6, b7, bArr[i12], cArr, i9);
                    i9 += 2;
                }
                i9 = i4;
            }
        }
        zzkwVar.zzc = new String(cArr, 0, i9);
        return i7;
    }

    static int zzg(byte[] bArr, int i3, zzkw zzkwVar) throws zzmr {
        int iZza = zza(bArr, i3, zzkwVar);
        int i4 = zzkwVar.zza;
        if (i4 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 > bArr.length - iZza) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i4 == 0) {
            zzkwVar.zzc = zzlh.zzb;
            return iZza;
        }
        zzkwVar.zzc = zzlh.zzh(bArr, iZza, i4);
        return iZza + i4;
    }

    static int zzh(zznx zznxVar, byte[] bArr, int i3, int i4, zzkw zzkwVar) throws IOException {
        Object objZza = zznxVar.zza();
        int iZzj = zzj(objZza, zznxVar, bArr, i3, i4, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzj;
    }

    static int zzi(zznx zznxVar, byte[] bArr, int i3, int i4, int i5, zzkw zzkwVar) throws IOException {
        Object objZza = zznxVar.zza();
        int iZzk = zzk(objZza, zznxVar, bArr, i3, i4, i5, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzk;
    }

    static int zzj(Object obj, zznx zznxVar, byte[] bArr, int i3, int i4, zzkw zzkwVar) throws IOException {
        int iZzb = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iZzb = zzb(i5, bArr, iZzb, zzkwVar);
            i5 = zzkwVar.zza;
        }
        int i6 = iZzb;
        if (i5 < 0 || i5 > i4 - i6) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = zzkwVar.zze + 1;
        zzkwVar.zze = i7;
        zzq(i7);
        int i8 = i6 + i5;
        zznxVar.zzi(obj, bArr, i6, i8, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return i8;
    }

    static int zzk(Object obj, zznx zznxVar, byte[] bArr, int i3, int i4, int i5, zzkw zzkwVar) throws IOException {
        int i6 = zzkwVar.zze + 1;
        zzkwVar.zze = i6;
        zzq(i6);
        int iZzh = ((zznp) zznxVar).zzh(obj, bArr, i3, i4, i5, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return iZzh;
    }

    static int zzl(int i3, byte[] bArr, int i4, int i5, zzmo zzmoVar, zzkw zzkwVar) {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i4, zzkwVar);
        zzmgVar.zzh(zzkwVar.zza);
        while (iZza < i5) {
            int iZza2 = zza(bArr, iZza, zzkwVar);
            if (i3 != zzkwVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        return iZza;
    }

    static int zzm(byte[] bArr, int i3, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i3, zzkwVar);
        int i4 = zzkwVar.zza + iZza;
        while (iZza < i4) {
            iZza = zza(bArr, iZza, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        if (iZza == i4) {
            return iZza;
        }
        throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzn(zznx zznxVar, int i3, byte[] bArr, int i4, int i5, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        int iZzh = zzh(zznxVar, bArr, i4, i5, zzkwVar);
        zzmoVar.add(zzkwVar.zzc);
        while (iZzh < i5) {
            int iZza = zza(bArr, iZzh, zzkwVar);
            if (i3 != zzkwVar.zza) {
                break;
            }
            iZzh = zzh(zznxVar, bArr, iZza, i5, zzkwVar);
            zzmoVar.add(zzkwVar.zzc);
        }
        return iZzh;
    }

    static int zzo(int i3, byte[] bArr, int i4, int i5, zzoj zzojVar, zzkw zzkwVar) throws zzmr {
        if ((i3 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int iZzc = zzc(bArr, i4, zzkwVar);
            zzojVar.zzk(i3, Long.valueOf(zzkwVar.zzb));
            return iZzc;
        }
        if (i6 == 1) {
            zzojVar.zzk(i3, Long.valueOf(zze(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int iZza = zza(bArr, i4, zzkwVar);
            int i7 = zzkwVar.zza;
            if (i7 < 0) {
                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i7 > bArr.length - iZza) {
                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i7 == 0) {
                zzojVar.zzk(i3, zzlh.zzb);
            } else {
                zzojVar.zzk(i3, zzlh.zzh(bArr, iZza, i7));
            }
            return iZza + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw new zzmr("Protocol message contained an invalid tag (zero).");
            }
            zzojVar.zzk(i3, Integer.valueOf(zzd(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzoj zzojVarZzb = zzoj.zzb();
        int i9 = zzkwVar.zze + 1;
        zzkwVar.zze = i9;
        zzq(i9);
        int i10 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iZza2 = zza(bArr, i4, zzkwVar);
            int i11 = zzkwVar.zza;
            if (i11 == i8) {
                i10 = i11;
                i4 = iZza2;
                break;
            }
            i4 = zzo(i11, bArr, iZza2, i5, zzojVarZzb, zzkwVar);
            i10 = i11;
        }
        zzkwVar.zze--;
        if (i4 > i5 || i10 != i8) {
            throw new zzmr("Failed to parse the message.");
        }
        zzojVar.zzk(i3, zzojVarZzb);
        return i4;
    }

    static int zzp(int i3, byte[] bArr, int i4, int i5, zzkw zzkwVar) throws zzmr {
        if ((i3 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            return zzc(bArr, i4, zzkwVar);
        }
        if (i6 == 1) {
            return i4 + 8;
        }
        if (i6 == 2) {
            return zza(bArr, i4, zzkwVar) + zzkwVar.zza;
        }
        if (i6 != 3) {
            if (i6 == 5) {
                return i4 + 4;
            }
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (i4 < i5) {
            i4 = zza(bArr, i4, zzkwVar);
            i8 = zzkwVar.zza;
            if (i8 == i7) {
                break;
            }
            i4 = zzp(i8, bArr, i4, i5, zzkwVar);
        }
        if (i4 > i5 || i8 != i7) {
            throw new zzmr("Failed to parse the message.");
        }
        return i4;
    }

    private static void zzq(int i3) throws zzmr {
        if (i3 >= zzb) {
            throw new zzmr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
