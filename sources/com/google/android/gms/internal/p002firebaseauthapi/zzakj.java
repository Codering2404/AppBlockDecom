package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakj extends zzakh {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final int zzaa() throws IOException {
        int i3;
        int i4 = this.zzh;
        int i5 = this.zzf;
        if (i5 != i4) {
            byte[] bArr = this.zze;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.zzh = i6;
                return b3;
            }
            if (i5 - i6 >= 9) {
                int i7 = i4 + 2;
                int i8 = (bArr[i6] << 7) ^ b3;
                if (i8 < 0) {
                    i3 = i8 ^ (-128);
                } else {
                    int i9 = i4 + 3;
                    int i10 = (bArr[i7] << Ascii.SO) ^ i8;
                    if (i10 >= 0) {
                        i3 = i10 ^ 16256;
                    } else {
                        int i11 = i4 + 4;
                        int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                        if (i12 < 0) {
                            i3 = (-2080896) ^ i12;
                        } else {
                            i9 = i4 + 5;
                            byte b4 = bArr[i11];
                            int i13 = (i12 ^ (b4 << Ascii.FS)) ^ 266354560;
                            if (b4 < 0) {
                                i11 = i4 + 6;
                                if (bArr[i9] < 0) {
                                    i9 = i4 + 7;
                                    if (bArr[i11] < 0) {
                                        i11 = i4 + 8;
                                        if (bArr[i9] < 0) {
                                            i9 = i4 + 9;
                                            if (bArr[i11] < 0) {
                                                int i14 = i4 + 10;
                                                if (bArr[i9] >= 0) {
                                                    i7 = i14;
                                                    i3 = i13;
                                                }
                                            }
                                        }
                                    }
                                }
                                i3 = i13;
                            }
                            i3 = i13;
                        }
                        i7 = i11;
                    }
                    i7 = i9;
                }
                this.zzh = i7;
                return i3;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws IOException {
        int i3 = this.zzh;
        if (this.zzf - i3 < 8) {
            zzg(8);
            i3 = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i3 + 8;
        return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
    }

    private final long zzac() throws IOException {
        long j3;
        long j4;
        long j5;
        int i3 = this.zzh;
        int i4 = this.zzf;
        if (i4 != i3) {
            byte[] bArr = this.zze;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.zzh = i5;
                return b3;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b3;
                if (i7 < 0) {
                    j3 = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << Ascii.SO) ^ i7;
                    if (i9 >= 0) {
                        j3 = i9 ^ 16256;
                        i6 = i8;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                        if (i11 < 0) {
                            long j6 = (-2080896) ^ i11;
                            i6 = i10;
                            j3 = j6;
                        } else {
                            long j7 = i11;
                            i6 = i3 + 5;
                            long j8 = j7 ^ (((long) bArr[i10]) << 28);
                            if (j8 >= 0) {
                                j5 = 266354560;
                            } else {
                                int i12 = i3 + 6;
                                long j9 = j8 ^ (((long) bArr[i6]) << 35);
                                if (j9 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    i6 = i3 + 7;
                                    j8 = j9 ^ (((long) bArr[i12]) << 42);
                                    if (j8 >= 0) {
                                        j5 = 4363953127296L;
                                    } else {
                                        i12 = i3 + 8;
                                        j9 = j8 ^ (((long) bArr[i6]) << 49);
                                        if (j9 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            i6 = i3 + 9;
                                            long j10 = (j9 ^ (((long) bArr[i12]) << 56)) ^ 71499008037633920L;
                                            if (j10 < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i6] >= 0) {
                                                    i6 = i13;
                                                }
                                            }
                                            j3 = j10;
                                        }
                                    }
                                }
                                j3 = j9 ^ j4;
                                i6 = i12;
                            }
                            j3 = j8 ^ j5;
                        }
                    }
                }
                this.zzh = i6;
                return j3;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i3 = this.zzf + this.zzg;
        this.zzf = i3;
        int i4 = this.zzj + i3;
        int i5 = this.zzk;
        if (i4 <= i5) {
            this.zzg = 0;
            return;
        }
        int i6 = i4 - i5;
        this.zzg = i6;
        this.zzf = i3 - i6;
    }

    private final byte zzy() throws IOException {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i3 = this.zzh;
        this.zzh = i3 + 1;
        return bArr[i3];
    }

    private final int zzz() throws IOException {
        int i3 = this.zzh;
        if (this.zzf - i3 < 4) {
            zzg(4);
            i3 = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i3 + 4;
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzc() {
        return this.zzj + this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzd() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zze() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzf() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzg() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzh() throws IOException {
        return zzakh.zza(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzi() throws IOException {
        if (zzw()) {
            this.zzi = 0;
            return 0;
        }
        int iZzaa = zzaa();
        this.zzi = iZzaa;
        if ((iZzaa >>> 3) != 0) {
            return iZzaa;
        }
        throw zzall.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzj() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzk() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzl() throws IOException {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    final long zzm() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            byte bZzy = zzy();
            j3 |= ((long) (bZzy & Ascii.DEL)) << i3;
            if ((bZzy & 128) == 0) {
                return j3;
            }
        }
        throw zzall.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzn() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzo() throws IOException {
        return zzakh.zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final long zzp() throws IOException {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final zzajv zzq() throws IOException {
        int iZzaa = zzaa();
        int i3 = this.zzf;
        int i4 = this.zzh;
        if (iZzaa <= i3 - i4 && iZzaa > 0) {
            zzajv zzajvVarZza = zzajv.zza(this.zze, i4, iZzaa);
            this.zzh += iZzaa;
            return zzajvVarZza;
        }
        if (iZzaa == 0) {
            return zzajv.zza;
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        byte[] bArrZzj = zzj(iZzaa);
        if (bArrZzj != null) {
            return zzajv.zza(bArrZzj);
        }
        int i5 = this.zzh;
        int i6 = this.zzf;
        int length = i6 - i5;
        this.zzj += i6;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(iZzaa - length);
        byte[] bArr = new byte[iZzaa];
        System.arraycopy(this.zze, i5, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzajv.zzb(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzr() throws IOException {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzaa <= i3 - i4) {
                String str = new String(this.zze, i4, iZzaa, zzalh.zza);
                this.zzh += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        if (iZzaa > this.zzf) {
            return new String(zza(iZzaa, false), zzalh.zza);
        }
        zzg(iZzaa);
        String str2 = new String(this.zze, this.zzh, iZzaa, zzalh.zza);
        this.zzh += iZzaa;
        return str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzs() throws IOException {
        byte[] bArrZza;
        int iZzaa = zzaa();
        int i3 = this.zzh;
        int i4 = this.zzf;
        if (iZzaa <= i4 - i3 && iZzaa > 0) {
            bArrZza = this.zze;
            this.zzh = i3 + iZzaa;
        } else {
            if (iZzaa == 0) {
                return "";
            }
            if (iZzaa < 0) {
                throw zzall.zzf();
            }
            i3 = 0;
            if (iZzaa <= i4) {
                zzg(iZzaa);
                bArrZza = this.zze;
                this.zzh = iZzaa;
            } else {
                bArrZza = zza(iZzaa, false);
            }
        }
        return zzaoa.zzb(bArrZza, i3, iZzaa);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzw() throws IOException {
        return this.zzh == this.zzf && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzx() throws IOException {
        return zzac() != 0;
    }

    private zzakj(InputStream inputStream, int i3) {
        super();
        this.zzk = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        zzalh.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    private static int zza(InputStream inputStream) throws IOException {
        try {
            return inputStream.available();
        } catch (zzall e3) {
            e3.zzk();
            throw e3;
        }
    }

    private final List<byte[]> zzf(int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i3 > 0) {
            int iMin = Math.min(i3, 4096);
            byte[] bArr = new byte[iMin];
            int i4 = 0;
            while (i4 < iMin) {
                int i5 = this.zzd.read(bArr, i4, iMin - i4);
                if (i5 == -1) {
                    throw zzall.zzj();
                }
                this.zzj += i5;
                i4 += i5;
            }
            i3 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i3) throws IOException {
        if (zzi(i3)) {
            return;
        }
        if (i3 <= (this.zzb - this.zzj) - this.zzh) {
            throw zzall.zzj();
        }
        throw zzall.zzi();
    }

    private final void zzh(int i3) throws IOException {
        int i4 = this.zzf;
        int i5 = this.zzh;
        if (i3 <= i4 - i5 && i3 >= 0) {
            this.zzh = i5 + i3;
            return;
        }
        if (i3 < 0) {
            throw zzall.zzf();
        }
        int i6 = this.zzj;
        int i7 = i6 + i5 + i3;
        int i8 = this.zzk;
        if (i7 > i8) {
            zzh((i8 - i6) - i5);
            throw zzall.zzj();
        }
        this.zzj = i6 + i5;
        int i9 = i4 - i5;
        this.zzf = 0;
        this.zzh = 0;
        while (i9 < i3) {
            try {
                long j3 = i3 - i9;
                long jZza = zza(this.zzd, j3);
                if (jZza >= 0 && jZza <= j3) {
                    if (jZza == 0) {
                        break;
                    } else {
                        i9 += (int) jZza;
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + jZza + "\nThe InputStream implementation is buggy.");
                }
            } finally {
                this.zzj += i9;
                zzad();
            }
        }
        if (i9 >= i3) {
            return;
        }
        int i10 = this.zzf;
        int i11 = i10 - this.zzh;
        this.zzh = i10;
        zzg(1);
        while (true) {
            int i12 = i3 - i11;
            int i13 = this.zzf;
            if (i12 <= i13) {
                this.zzh = i12;
                return;
            } else {
                i11 += i13;
                this.zzh = i13;
                zzg(1);
            }
        }
    }

    private final byte[] zzj(int i3) throws IOException {
        if (i3 == 0) {
            return zzalh.zzb;
        }
        if (i3 < 0) {
            throw zzall.zzf();
        }
        int i4 = this.zzj;
        int i5 = this.zzh;
        int i6 = i4 + i5 + i3;
        if (i6 - this.zzb > 0) {
            throw zzall.zzi();
        }
        int i7 = this.zzk;
        if (i6 > i7) {
            zzh((i7 - i4) - i5);
            throw zzall.zzj();
        }
        int i8 = this.zzf - i5;
        int i9 = i3 - i8;
        if (i9 >= 4096 && i9 > zza(this.zzd)) {
            return null;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zze, this.zzh, bArr, 0, i8);
        this.zzj += this.zzf;
        this.zzh = 0;
        this.zzf = 0;
        while (i8 < i3) {
            int iZza = zza(this.zzd, bArr, i8, i3 - i8);
            if (iZza == -1) {
                throw zzall.zzj();
            }
            this.zzj += iZza;
            i8 += iZza;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzb(int i3) throws zzall {
        if (i3 < 0) {
            throw zzall.zzf();
        }
        int i4 = i3 + this.zzj + this.zzh;
        if (i4 < 0) {
            throw zzall.zzi();
        }
        int i5 = this.zzk;
        if (i4 > i5) {
            throw zzall.zzj();
        }
        this.zzk = i4;
        zzad();
        return i5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzc(int i3) throws zzall {
        if (this.zzi != i3) {
            throw zzall.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzd(int i3) {
        this.zzk = i3;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zze(int i3) throws IOException {
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i5 < 10) {
                    if (zzy() < 0) {
                        i5++;
                    }
                }
                throw zzall.zze();
            }
            while (i5 < 10) {
                byte[] bArr = this.zze;
                int i6 = this.zzh;
                this.zzh = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw zzall.zze();
            return true;
        }
        if (i4 == 1) {
            zzh(8);
            return true;
        }
        if (i4 == 2) {
            zzh(zzaa());
            return true;
        }
        if (i4 == 3) {
            zzv();
            zzc(((i3 >>> 3) << 3) | 4);
            return true;
        }
        if (i4 == 4) {
            zzu();
            return false;
        }
        if (i4 != 5) {
            throw zzall.zza();
        }
        zzh(4);
        return true;
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i3, int i4) throws IOException {
        try {
            return inputStream.read(bArr, i3, i4);
        } catch (zzall e3) {
            e3.zzk();
            throw e3;
        }
    }

    private final boolean zzi(int i3) throws IOException {
        int i4 = this.zzh;
        int i5 = i4 + i3;
        int i6 = this.zzf;
        if (i5 > i6) {
            int i7 = this.zzb;
            int i8 = this.zzj;
            if (i3 > (i7 - i8) - i4 || i8 + i4 + i3 > this.zzk) {
                return false;
            }
            if (i4 > 0) {
                if (i6 > i4) {
                    byte[] bArr = this.zze;
                    System.arraycopy(bArr, i4, bArr, 0, i6 - i4);
                }
                this.zzj += i4;
                this.zzf -= i4;
                this.zzh = 0;
            }
            InputStream inputStream = this.zzd;
            byte[] bArr2 = this.zze;
            int i9 = this.zzf;
            int iZza = zza(inputStream, bArr2, i9, Math.min(bArr2.length - i9, (this.zzb - this.zzj) - i9));
            if (iZza != 0 && iZza >= -1 && iZza <= this.zze.length) {
                if (iZza <= 0) {
                    return false;
                }
                this.zzf += iZza;
                zzad();
                return this.zzf >= i3 || zzi(i3);
            }
            throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + iZza + "\nThe InputStream implementation is buggy.");
        }
        throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
    }

    private static long zza(InputStream inputStream, long j3) throws IOException {
        try {
            return inputStream.skip(j3);
        } catch (zzall e3) {
            e3.zzk();
            throw e3;
        }
    }

    private final byte[] zza(int i3, boolean z2) throws IOException {
        byte[] bArrZzj = zzj(i3);
        if (bArrZzj != null) {
            return bArrZzj;
        }
        int i4 = this.zzh;
        int i5 = this.zzf;
        int length = i5 - i4;
        this.zzj += i5;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> listZzf = zzf(i3 - length);
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zze, i4, bArr, 0, length);
        for (byte[] bArr2 : listZzf) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
