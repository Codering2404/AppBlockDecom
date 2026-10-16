package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzidb extends zzide {
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private final int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzidb(byte[] bArr, int i3, int i4, boolean z2, byte[] bArr2) {
        super(null);
        this.zzl = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzf = bArr;
        this.zzg = i4 + i3;
        this.zzi = i3;
        this.zzj = i3;
    }

    private final void zzP() {
        int i3 = this.zzg + this.zzh;
        this.zzg = i3;
        int i4 = i3 - this.zzj;
        int i5 = this.zzl;
        if (i4 <= i5) {
            this.zzh = 0;
            return;
        }
        int i6 = i4 - i5;
        this.zzh = i6;
        this.zzg = i3 - i6;
    }

    public final long zzA() throws IOException {
        int i3 = this.zzi;
        if (this.zzg - i3 < 8) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzi = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzB(int i3) throws zziet {
        if (i3 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = i3 + (this.zzi - this.zzj);
        if (i4 < 0) {
            throw new zziet("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i4;
        zzP();
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final void zzC(int i3) {
        this.zzl = i3;
        zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzD() throws IOException {
        return this.zzi == this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzE() {
        return this.zzi - this.zzj;
    }

    public final byte zzF() throws IOException {
        int i3 = this.zzi;
        if (i3 == this.zzg) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzi = i3 + 1;
        return bArr[i3];
    }

    public final void zzG(int i3) throws IOException {
        if (i3 >= 0) {
            int i4 = this.zzg;
            int i5 = this.zzi;
            if (i3 <= i4 - i5) {
                this.zzi = i5 + i3;
                return;
            }
        }
        if (i3 >= 0) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zza() throws IOException {
        if (zzD()) {
            this.zzk = 0;
            return 0;
        }
        int iZzu = zzu();
        this.zzk = iZzu;
        if ((iZzu >>> 3) != 0) {
            return iZzu;
        }
        throw new zziet("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final void zzb(int i3) throws zziet {
        if (this.zzk != i3) {
            throw new zziet("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzc(int i3) throws IOException {
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i5 < 10) {
                    if (zzF() < 0) {
                        i5++;
                    }
                }
                throw new zziet("CodedInputStream encountered a malformed varint.");
            }
            while (i5 < 10) {
                byte[] bArr = this.zzf;
                int i6 = this.zzi;
                this.zzi = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw new zziet("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i4 == 1) {
            zzG(8);
            return true;
        }
        if (i4 == 2) {
            zzG(zzu());
            return true;
        }
        if (i4 == 3) {
            zzL();
            zzb(((i3 >>> 3) << 3) | 4);
            return true;
        }
        if (i4 == 4) {
            zzK();
            return false;
        }
        if (i4 != 5) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
        zzG(4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzA());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzf() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzg() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzh() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzi() throws IOException {
        return zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzj() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzk() throws IOException {
        return zzx() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzl() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i3 = this.zzg;
            int i4 = this.zzi;
            if (iZzu <= i3 - i4) {
                String str = new String(this.zzf, i4, iZzu, StandardCharsets.UTF_8);
                this.zzi += iZzu;
                return str;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzm() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i3 = this.zzg;
            int i4 = this.zzi;
            if (iZzu <= i3 - i4) {
                String strZze = zzihf.zze(this.zzf, i4, iZzu);
                this.zzi += iZzu;
                return strZze;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu <= 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final zzida zzn() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i3 = this.zzg;
            int i4 = this.zzi;
            if (iZzu <= i3 - i4) {
                zzida zzidaVarZzu = zzida.zzu(this.zzf, i4, iZzu, false);
                this.zzi += iZzu;
                return zzidaVarZzu;
            }
        }
        if (iZzu == 0) {
            return zzida.zza;
        }
        if (iZzu > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (iZzu <= i5 - i6) {
                int i7 = iZzu + i6;
                this.zzi = i7;
                return zzida.zzw(Arrays.copyOfRange(this.zzf, i6, i7), false);
            }
        }
        if (iZzu <= 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzo() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzp() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzq() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzr() throws IOException {
        return zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzs() throws IOException {
        return zzide.zzM(zzu());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzt() throws IOException {
        return zzide.zzN(zzx());
    }

    protected abstract int zzu() throws IOException;

    protected abstract int zzv() throws IOException;

    protected final int zzw() throws IOException {
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
        return (int) zzy();
    }

    public final long zzx() throws IOException {
        long j3;
        long j4;
        long j5;
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
                            long j6 = (-2080896) ^ i11;
                            i6 = i10;
                            j3 = j6;
                        } else {
                            i8 = i3 + 5;
                            long j7 = (((long) bArr[i10]) << 28) ^ ((long) i11);
                            if (j7 >= 0) {
                                j3 = j7 ^ 266354560;
                            } else {
                                i6 = i3 + 6;
                                long j8 = (((long) bArr[i8]) << 35) ^ j7;
                                if (j8 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    int i12 = i3 + 7;
                                    long j9 = j8 ^ (((long) bArr[i6]) << 42);
                                    if (j9 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i3 + 8;
                                        j8 = j9 ^ (((long) bArr[i12]) << 49);
                                        if (j8 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i12 = i3 + 9;
                                            j9 = j8 ^ (((long) bArr[i6]) << 56);
                                            if (j9 >= 0) {
                                                j4 = 71499008037633920L;
                                            } else {
                                                i6 = i3 + 10;
                                                long j10 = j9 ^ (((long) bArr[i12]) << 63);
                                                if (j10 >= 0) {
                                                    j3 = j10 ^ (-9151873028817141888L);
                                                }
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
                    i6 = i8;
                }
                this.zzi = i6;
                return j3;
            }
        }
        return zzy();
    }

    final long zzy() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            byte bZzF = zzF();
            j3 |= ((long) (bZzF & Ascii.DEL)) << i3;
            if ((bZzF & 128) == 0) {
                return j3;
            }
        }
        throw new zziet("CodedInputStream encountered a malformed varint.");
    }

    public final int zzz() throws IOException {
        int i3 = this.zzi;
        if (this.zzg - i3 < 4) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzi = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }
}
