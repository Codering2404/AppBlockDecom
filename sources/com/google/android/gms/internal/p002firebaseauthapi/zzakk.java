package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakk extends zzakh {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() throws IOException {
        int i3;
        int i4 = this.zzg;
        int i5 = this.zze;
        if (i5 != i4) {
            byte[] bArr = this.zzd;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.zzg = i6;
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
                this.zzg = i7;
                return i3;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws IOException {
        int i3 = this.zzg;
        if (this.zze - i3 < 8) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i3 + 8;
        return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
    }

    private final long zzac() throws IOException {
        long j3;
        long j4;
        long j5;
        int i3 = this.zzg;
        int i4 = this.zze;
        if (i4 != i3) {
            byte[] bArr = this.zzd;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.zzg = i5;
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
                this.zzg = i6;
                return j3;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i3 = this.zze + this.zzf;
        this.zze = i3;
        int i4 = i3 - this.zzh;
        int i5 = this.zzj;
        if (i4 <= i5) {
            this.zzf = 0;
            return;
        }
        int i6 = i4 - i5;
        this.zzf = i6;
        this.zze = i3 - i6;
    }

    private final byte zzy() throws IOException {
        int i3 = this.zzg;
        if (i3 == this.zze) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i3 + 1;
        return bArr[i3];
    }

    private final int zzz() throws IOException {
        int i3 = this.zzg;
        if (this.zze - i3 < 4) {
            throw zzall.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i3 + 4;
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
        return this.zzg - this.zzh;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzajv zzq() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzaa()
            if (r0 <= 0) goto L19
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.firebase-auth-api.zzajv r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza(r1, r2, r0)
            int r2 = r3.zzg
            int r2 = r2 + r0
            r3.zzg = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzg = r0
            byte[] r1 = r3.zzd
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zzb
        L37:
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase-auth-api.zzall r0 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.firebase-auth-api.zzall r0 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakk.zzq():com.google.android.gms.internal.firebase-auth-api.zzajv");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzr() throws IOException {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (iZzaa <= i3 - i4) {
                String str = new String(this.zzd, i4, iZzaa, zzalh.zza);
                this.zzg += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzall.zzf();
        }
        throw zzall.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final String zzs() throws IOException {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (iZzaa <= i3 - i4) {
                String strZzb = zzaoa.zzb(this.zzd, i4, iZzaa);
                this.zzg += iZzaa;
                return strZzb;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa <= 0) {
            throw zzall.zzf();
        }
        throw zzall.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzw() throws IOException {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zzx() throws IOException {
        return zzac() != 0;
    }

    private zzakk(byte[] bArr, int i3, int i4, boolean z2) {
        super();
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzd = bArr;
        this.zze = i4 + i3;
        this.zzg = i3;
        this.zzh = i3;
    }

    private final void zzf(int i3) throws IOException {
        if (i3 >= 0) {
            int i4 = this.zze;
            int i5 = this.zzg;
            if (i3 <= i4 - i5) {
                this.zzg = i5 + i3;
                return;
            }
        }
        if (i3 >= 0) {
            throw zzall.zzj();
        }
        throw zzall.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final int zzb(int i3) throws zzall {
        if (i3 < 0) {
            throw zzall.zzf();
        }
        int iZzc = i3 + zzc();
        if (iZzc < 0) {
            throw zzall.zzi();
        }
        int i4 = this.zzj;
        if (iZzc > i4) {
            throw zzall.zzj();
        }
        this.zzj = iZzc;
        zzad();
        return i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzc(int i3) throws zzall {
        if (this.zzi != i3) {
            throw zzall.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final void zzd(int i3) {
        this.zzj = i3;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final boolean zze(int i3) throws IOException {
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.zze - this.zzg < 10) {
                while (i5 < 10) {
                    if (zzy() < 0) {
                        i5++;
                    }
                }
                throw zzall.zze();
            }
            while (i5 < 10) {
                byte[] bArr = this.zzd;
                int i6 = this.zzg;
                this.zzg = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw zzall.zze();
            return true;
        }
        if (i4 == 1) {
            zzf(8);
            return true;
        }
        if (i4 == 2) {
            zzf(zzaa());
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
        zzf(4);
        return true;
    }
}
