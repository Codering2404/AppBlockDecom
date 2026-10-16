package com.google.android.gms.internal.gtm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuf extends zzuj {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    /* synthetic */ zzuf(byte[] bArr, int i3, int i4, boolean z2, zzue zzueVar) {
        super(null);
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = i4;
        this.zzh = 0;
    }

    private final void zzI() {
        int i3 = this.zzf + this.zzg;
        this.zzf = i3;
        int i4 = this.zzj;
        if (i3 <= i4) {
            this.zzg = 0;
            return;
        }
        int i5 = i3 - i4;
        this.zzg = i5;
        this.zzf = i3 - i5;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final void zzA(int i3) {
        this.zzj = i3;
        zzI();
    }

    public final void zzB(int i3) throws IOException {
        if (i3 >= 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (i3 <= i4 - i5) {
                this.zzh = i5 + i3;
                return;
            }
        }
        if (i3 >= 0) {
            throw zzyg.zzj();
        }
        throw zzyg.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
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
            if (this.zzf - this.zzh < 10) {
                while (i5 < 10) {
                    if (zza() < 0) {
                        i5++;
                    }
                }
                throw zzyg.zze();
            }
            while (i5 < 10) {
                byte[] bArr = this.zze;
                int i6 = this.zzh;
                this.zzh = i6 + 1;
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
        int i3 = this.zzh;
        if (i3 == this.zzf) {
            throw zzyg.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i3 + 1;
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
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final int zze(int i3) throws zzyg {
        if (i3 < 0) {
            throw zzyg.zzf();
        }
        int i4 = i3 + this.zzh;
        if (i4 < 0) {
            throw zzyg.zzg();
        }
        int i5 = this.zzj;
        if (i4 > i5) {
            throw zzyg.zzj();
        }
        this.zzj = i4;
        zzI();
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
        int i3 = this.zzh;
        if (this.zzf - i3 < 4) {
            throw zzyg.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    public final int zzj() throws IOException {
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
            this.zzi = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzi = iZzj;
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
        int i3 = this.zzh;
        if (this.zzf - i3 < 8) {
            throw zzyg.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long j3;
        long j4;
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
                this.zzh = i6;
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
        if (iZzj > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzj <= i3 - i4) {
                zzud zzudVarZzl = zzud.zzl(this.zze, i4, iZzj);
                this.zzh += iZzj;
                return zzudVarZzl;
            }
        }
        if (iZzj == 0) {
            return zzud.zzb;
        }
        if (iZzj > 0) {
            int i5 = this.zzf;
            int i6 = this.zzh;
            if (iZzj <= i5 - i6) {
                int i7 = iZzj + i6;
                this.zzh = i7;
                return new zzua(Arrays.copyOfRange(this.zze, i6, i7));
            }
        }
        if (iZzj <= 0) {
            throw zzyg.zzf();
        }
        throw zzyg.zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final String zzx() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzj <= i3 - i4) {
                String str = new String(this.zze, i4, iZzj, zzye.zzb);
                this.zzh += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw zzyg.zzf();
        }
        throw zzyg.zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final String zzy() throws IOException {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzj <= i3 - i4) {
                String strZzd = zzaaz.zzd(this.zze, i4, iZzj);
                this.zzh += iZzj;
                return strZzd;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj <= 0) {
            throw zzyg.zzf();
        }
        throw zzyg.zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzuj
    public final void zzz(int i3) throws zzyg {
        if (this.zzi != i3) {
            throw zzyg.zzb();
        }
    }
}
