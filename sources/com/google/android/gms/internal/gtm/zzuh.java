package com.google.android.gms.internal.gtm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuh extends zzuj {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzuh(InputStream inputStream, int i3, zzug zzugVar) {
        super(null);
        this.zzl = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        byte[] bArr = zzye.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i3 > 0) {
            int iMin = Math.min(i3, 4096);
            byte[] bArr = new byte[iMin];
            int i4 = 0;
            while (i4 < iMin) {
                int i5 = this.zze.read(bArr, i4, iMin - i4);
                if (i5 == -1) {
                    throw zzyg.zzj();
                }
                this.zzk += i5;
                i4 += i5;
            }
            i3 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i3 = this.zzg + this.zzh;
        this.zzg = i3;
        int i4 = this.zzk + i3;
        int i5 = this.zzl;
        if (i4 <= i5) {
            this.zzh = 0;
            return;
        }
        int i6 = i4 - i5;
        this.zzh = i6;
        this.zzg = i3 - i6;
    }

    private final void zzK(int i3) throws IOException {
        if (zzL(i3)) {
            return;
        }
        if (i3 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.zzk) - this.zzi) {
            throw zzyg.zzj();
        }
        throw zzyg.zzi();
    }

    private final boolean zzL(int i3) throws IOException {
        int i4 = this.zzi;
        int i5 = i4 + i3;
        int i6 = this.zzg;
        if (i5 <= i6) {
            throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
        }
        int i7 = this.zzk;
        if (i3 > (Api.BaseClientBuilder.API_PRIORITY_OTHER - i7) - i4 || i7 + i4 + i3 > this.zzl) {
            return false;
        }
        if (i4 > 0) {
            if (i6 > i4) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i4, bArr, 0, i6 - i4);
            }
            i7 = this.zzk + i4;
            this.zzk = i7;
            i6 = this.zzg - i4;
            this.zzg = i6;
            this.zzi = 0;
        }
        try {
            int i8 = this.zze.read(this.zzf, i6, Math.min(4096 - i6, (Api.BaseClientBuilder.API_PRIORITY_OTHER - i7) - i6));
            if (i8 == 0 || i8 < -1 || i8 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
            }
            if (i8 <= 0) {
                return false;
            }
            this.zzg += i8;
            zzJ();
            if (this.zzg >= i3) {
                return true;
            }
            return zzL(i3);
        } catch (zzyg e3) {
            e3.zzk();
            throw e3;
        }
    }

    private final byte[] zzM(int i3, boolean z2) throws IOException {
        byte[] bArrZzN = zzN(i3);
        if (bArrZzN != null) {
            return bArrZzN;
        }
        int i4 = this.zzi;
        int i5 = this.zzg;
        int i6 = i5 - i4;
        this.zzk += i5;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(i3 - i6);
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zzf, i4, bArr, 0, i6);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i6, length);
            i6 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i3) throws IOException {
        if (i3 == 0) {
            return zzye.zzd;
        }
        if (i3 < 0) {
            throw zzyg.zzf();
        }
        int i4 = this.zzk;
        int i5 = this.zzi;
        int i6 = i4 + i5 + i3;
        if ((-2147483647) + i6 > 0) {
            throw zzyg.zzi();
        }
        int i7 = this.zzl;
        if (i6 > i7) {
            zzB((i7 - i4) - i5);
            throw zzyg.zzj();
        }
        int i8 = this.zzg - i5;
        int i9 = i3 - i8;
        if (i9 >= 4096) {
            try {
                if (i9 > this.zze.available()) {
                    return null;
                }
            } catch (zzyg e3) {
                e3.zzk();
                throw e3;
            }
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i8);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i8 < i3) {
            try {
                int i10 = this.zze.read(bArr, i8, i3 - i8);
                if (i10 == -1) {
                    throw zzyg.zzj();
                }
                this.zzk += i10;
                i8 += i10;
            } catch (zzyg e4) {
                e4.zzk();
                throw e4;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final void zzA(int i3) {
        this.zzl = i3;
        zzJ();
    }

    public final void zzB(int i3) throws IOException {
        int i4 = this.zzg;
        int i5 = this.zzi;
        int i6 = i4 - i5;
        if (i3 <= i6 && i3 >= 0) {
            this.zzi = i5 + i3;
            return;
        }
        if (i3 < 0) {
            throw zzyg.zzf();
        }
        int i7 = this.zzk;
        int i8 = i7 + i5;
        int i9 = this.zzl;
        if (i8 + i3 > i9) {
            zzB((i9 - i7) - i5);
            throw zzyg.zzj();
        }
        this.zzk = i8;
        this.zzg = 0;
        this.zzi = 0;
        while (i6 < i3) {
            try {
                long j3 = i3 - i6;
                try {
                    long jSkip = this.zze.skip(j3);
                    if (jSkip < 0 || jSkip > j3) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i6 += (int) jSkip;
                    }
                } catch (zzyg e3) {
                    e3.zzk();
                    throw e3;
                }
            } catch (Throwable th) {
                this.zzk += i6;
                zzJ();
                throw th;
            }
        }
        this.zzk += i6;
        zzJ();
        if (i6 >= i3) {
            return;
        }
        int i10 = this.zzg;
        int i11 = i10 - this.zzi;
        this.zzi = i10;
        zzK(1);
        while (true) {
            int i12 = i3 - i11;
            int i13 = this.zzg;
            if (i12 <= i13) {
                this.zzi = i12;
                return;
            } else {
                i11 += i13;
                this.zzi = i13;
                zzK(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final boolean zzE(int i3) throws IOException {
        int iZzm;
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i5 < 10) {
                    if (zza() < 0) {
                        i5++;
                    }
                }
                throw zzyg.zze();
            }
            while (i5 < 10) {
                byte[] bArr = this.zzf;
                int i6 = this.zzi;
                this.zzi = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw zzyg.zze();
            return true;
        }
        if (i4 == 1) {
            zzB(8);
            return true;
        }
        if (i4 == 2) {
            zzB(zzj());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw zzyg.zza();
            }
            zzB(4);
            return true;
        }
        do {
            iZzm = zzm();
            if (iZzm == 0) {
                break;
            }
        } while (zzE(iZzm));
        zzz(((i3 >>> 3) << 3) | 4);
        return true;
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzK(1);
        }
        byte[] bArr = this.zzf;
        int i3 = this.zzi;
        this.zzi = i3 + 1;
        return bArr[i3];
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zze(int i3) throws zzyg {
        if (i3 < 0) {
            throw zzyg.zzf();
        }
        int i4 = this.zzk + this.zzi;
        int i5 = this.zzl;
        int i6 = i3 + i4;
        if (i6 > i5) {
            throw zzyg.zzj();
        }
        this.zzl = i6;
        zzJ();
        return i5;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i3 = this.zzi;
        if (this.zzg - i3 < 4) {
            zzK(4);
            i3 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    public final int zzj() throws IOException {
        int i3;
        int i4 = this.zzi;
        int i5 = this.zzg;
        if (i5 != i4) {
            byte[] bArr = this.zzf;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.zzi = i6;
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
                this.zzi = i7;
                return i3;
            }
        }
        return (int) zzs();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzl() throws IOException {
        return zzuj.zzF(zzj());
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzj = iZzj;
        if ((iZzj >>> 3) != 0) {
            return iZzj;
        }
        throw zzyg.zzc();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i3 = this.zzi;
        if (this.zzg - i3 < 8) {
            zzK(8);
            i3 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long j3;
        long j4;
        int i3 = this.zzi;
        int i4 = this.zzg;
        if (i4 != i3) {
            byte[] bArr = this.zzf;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.zzi = i5;
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
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                        if (i11 < 0) {
                            long j5 = (-2080896) ^ i11;
                            i6 = i10;
                            j3 = j5;
                        } else {
                            i8 = i3 + 5;
                            long j6 = (((long) bArr[i10]) << 28) ^ ((long) i11);
                            if (j6 >= 0) {
                                j3 = j6 ^ 266354560;
                            } else {
                                i6 = i3 + 6;
                                long j7 = (((long) bArr[i8]) << 35) ^ j6;
                                if (j7 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    int i12 = i3 + 7;
                                    long j8 = j7 ^ (((long) bArr[i6]) << 42);
                                    if (j8 >= 0) {
                                        j3 = j8 ^ 4363953127296L;
                                    } else {
                                        i6 = i3 + 8;
                                        j7 = j8 ^ (((long) bArr[i12]) << 49);
                                        if (j7 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            i12 = i3 + 9;
                                            long j9 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j9 < 0) {
                                                i6 = i3 + 10;
                                                if (bArr[i12] >= 0) {
                                                    j3 = j9;
                                                }
                                            } else {
                                                j3 = j9;
                                            }
                                        }
                                    }
                                    i6 = i12;
                                }
                                j3 = j7 ^ j4;
                            }
                        }
                    }
                    i6 = i8;
                }
                this.zzi = i6;
                return j3;
            }
        }
        return zzs();
    }

    final long zzs() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            byte bZza = zza();
            j3 |= ((long) (bZza & Ascii.DEL)) << i3;
            if ((bZza & 128) == 0) {
                return j3;
            }
        }
        throw zzyg.zze();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final long zzu() throws IOException {
        return zzuj.zzG(zzr());
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final zzud zzw() throws IOException {
        int iZzj = zzj();
        int i3 = this.zzg;
        int i4 = this.zzi;
        if (iZzj <= i3 - i4 && iZzj > 0) {
            zzud zzudVarZzl = zzud.zzl(this.zzf, i4, iZzj);
            this.zzi += iZzj;
            return zzudVarZzl;
        }
        if (iZzj == 0) {
            return zzud.zzb;
        }
        byte[] bArrZzN = zzN(iZzj);
        if (bArrZzN != null) {
            return zzud.zzl(bArrZzN, 0, bArrZzN.length);
        }
        int i5 = this.zzi;
        int i6 = this.zzg;
        int i7 = i6 - i5;
        this.zzk += i6;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(iZzj - i7);
        byte[] bArr = new byte[iZzj];
        System.arraycopy(this.zzf, i5, bArr, 0, i7);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i7, length);
            i7 += length;
        }
        return new zzua(bArr);
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final String zzx() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i3 = this.zzg;
            int i4 = this.zzi;
            if (iZzj <= i3 - i4) {
                String str = new String(this.zzf, i4, iZzj, zzye.zzb);
                this.zzi += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj > this.zzg) {
            return new String(zzM(iZzj, false), zzye.zzb);
        }
        zzK(iZzj);
        String str2 = new String(this.zzf, this.zzi, iZzj, zzye.zzb);
        this.zzi += iZzj;
        return str2;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final String zzy() throws IOException {
        byte[] bArrZzM;
        int iZzj = zzj();
        int i3 = this.zzi;
        int i4 = this.zzg;
        if (iZzj <= i4 - i3 && iZzj > 0) {
            bArrZzM = this.zzf;
            this.zzi = i3 + iZzj;
        } else {
            if (iZzj == 0) {
                return "";
            }
            i3 = 0;
            if (iZzj <= i4) {
                zzK(iZzj);
                bArrZzM = this.zzf;
                this.zzi = iZzj;
            } else {
                bArrZzM = zzM(iZzj, false);
            }
        }
        return zzaaz.zzd(bArrZzM, i3, iZzj);
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final void zzz(int i3) throws zzyg {
        if (this.zzj != i3) {
            throw zzyg.zzb();
        }
    }
}
