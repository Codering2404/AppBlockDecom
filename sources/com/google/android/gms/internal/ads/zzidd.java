package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidd extends zzide {
    private final InputStream zzf;
    private final byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    /* synthetic */ zzidd(InputStream inputStream, int i3, byte[] bArr) {
        super(null);
        this.zzm = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzf = inputStream;
        this.zzg = new byte[4096];
        this.zzh = 0;
        this.zzj = 0;
        this.zzl = 0;
    }

    private final void zzF() {
        int i3 = this.zzh + this.zzi;
        this.zzh = i3;
        int i4 = this.zzl + i3;
        int i5 = this.zzm;
        if (i4 <= i5) {
            this.zzi = 0;
            return;
        }
        int i6 = i4 - i5;
        this.zzi = i6;
        this.zzh = i3 - i6;
    }

    private final void zzG(int i3) throws IOException {
        if (zzP(i3)) {
            return;
        }
        if (i3 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.zzl) - this.zzj) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zziet("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzP(int i3) throws IOException {
        int i4 = this.zzj;
        int i5 = i4 + i3;
        int i6 = this.zzh;
        if (i5 <= i6) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 66);
            sb.append("refillBuffer() called when ");
            sb.append(i3);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i7 = this.zzl;
        if (i3 > (Api.BaseClientBuilder.API_PRIORITY_OTHER - i7) - i4 || i7 + i4 + i3 > this.zzm) {
            return false;
        }
        if (i4 > 0) {
            if (i6 > i4) {
                byte[] bArr = this.zzg;
                System.arraycopy(bArr, i4, bArr, 0, i6 - i4);
            }
            i7 = this.zzl + i4;
            this.zzl = i7;
            i6 = this.zzh - i4;
            this.zzh = i6;
            this.zzj = 0;
        }
        try {
            int i8 = this.zzf.read(this.zzg, i6, Math.min(4096 - i6, (Api.BaseClientBuilder.API_PRIORITY_OTHER - i7) - i6));
            if (i8 != 0 && i8 >= -1 && i8 <= 4096) {
                if (i8 <= 0) {
                    return false;
                }
                this.zzh += i8;
                zzF();
                return this.zzh >= i3 || zzP(i3);
            }
            String strValueOf = String.valueOf(this.zzf.getClass());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 39 + String.valueOf(i8).length() + 41);
            sb2.append(strValueOf);
            sb2.append("#read(byte[]) returned invalid result: ");
            sb2.append(i8);
            sb2.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb2.toString());
        } catch (zziet e3) {
            e3.zza();
            throw e3;
        }
    }

    private final byte[] zzQ(int i3, boolean z2) throws IOException {
        byte[] bArrZzR = zzR(i3);
        if (bArrZzR != null) {
            return bArrZzR;
        }
        int i4 = this.zzj;
        int i5 = this.zzh;
        int i6 = i5 - i4;
        this.zzl += i5;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzS = zzS(i3 - i6);
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zzg, i4, bArr, 0, i6);
        for (byte[] bArr2 : listZzS) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i6, length);
            i6 += length;
        }
        return bArr;
    }

    private final byte[] zzR(int i3) throws IOException {
        if (i3 == 0) {
            return zzier.zza;
        }
        int i4 = this.zzl;
        int i5 = this.zzj;
        int i6 = i4 + i5 + i3;
        if ((-2147483647) + i6 > 0) {
            throw new zziet("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i7 = this.zzm;
        if (i6 > i7) {
            zzA((i7 - i4) - i5);
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i8 = this.zzh - i5;
        int i9 = i3 - i8;
        if (i9 >= 4096) {
            try {
                if (i9 > this.zzf.available()) {
                    return null;
                }
            } catch (zziet e3) {
                e3.zza();
                throw e3;
            }
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.zzg, this.zzj, bArr, 0, i8);
        this.zzl += this.zzh;
        this.zzj = 0;
        this.zzh = 0;
        while (i8 < i3) {
            try {
                int i10 = this.zzf.read(bArr, i8, i3 - i8);
                if (i10 == -1) {
                    throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzl += i10;
                i8 += i10;
            } catch (zziet e4) {
                e4.zza();
                throw e4;
            }
        }
        return bArr;
    }

    private final List zzS(int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i3 > 0) {
            int iMin = Math.min(i3, 4096);
            byte[] bArr = new byte[iMin];
            int i4 = 0;
            while (i4 < iMin) {
                try {
                    int i5 = this.zzf.read(bArr, i4, iMin - i4);
                    if (i5 == -1) {
                        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    this.zzl += i5;
                    i4 += i5;
                } catch (zziet e3) {
                    e3.zza();
                    throw e3;
                }
            }
            i3 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final void zzA(int i3) throws IOException {
        int i4 = this.zzh;
        int i5 = this.zzj;
        int i6 = i4 - i5;
        if (i3 <= i6 && i3 >= 0) {
            this.zzj = i5 + i3;
            return;
        }
        if (i3 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i7 = this.zzl;
        int i8 = i7 + i5;
        int i9 = this.zzm;
        if (i8 + i3 > i9) {
            zzA((i9 - i7) - i5);
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i8;
        this.zzh = 0;
        this.zzj = 0;
        while (i6 < i3) {
            try {
                long j3 = i3 - i6;
                try {
                    long jSkip = this.zzf.skip(j3);
                    if (jSkip < 0 || jSkip > j3) {
                        String strValueOf = String.valueOf(this.zzf.getClass());
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i6 += (int) jSkip;
                    }
                } catch (zziet e3) {
                    e3.zza();
                    throw e3;
                }
            } catch (Throwable th) {
                this.zzl += i6;
                zzF();
                throw th;
            }
        }
        this.zzl += i6;
        zzF();
        if (i6 >= i3) {
            return;
        }
        int i10 = this.zzh;
        int i11 = i10 - this.zzj;
        this.zzj = i10;
        zzG(1);
        while (true) {
            int i12 = i3 - i11;
            int i13 = this.zzh;
            if (i12 <= i13) {
                this.zzj = i12;
                return;
            } else {
                i11 += i13;
                this.zzj = i13;
                zzG(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzB(int i3) throws zziet {
        if (i3 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = i3 + this.zzl + this.zzj;
        if (i4 < 0) {
            throw new zziet("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.zzm;
        if (i4 > i5) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzm = i4;
        zzF();
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final void zzC(int i3) {
        this.zzm = i3;
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzD() throws IOException {
        return this.zzj == this.zzh && !zzP(1);
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzE() {
        return this.zzl + this.zzj;
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
            if (this.zzh - this.zzj < 10) {
                while (i5 < 10) {
                    if (zzz() < 0) {
                        i5++;
                    }
                }
                throw new zziet("CodedInputStream encountered a malformed varint.");
            }
            while (i5 < 10) {
                byte[] bArr = this.zzg;
                int i6 = this.zzj;
                this.zzj = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw new zziet("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i4 == 1) {
            zzA(8);
            return true;
        }
        if (i4 == 2) {
            zzA(zzu());
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
        zzA(4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzg() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzh() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzj() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzk() throws IOException {
        return zzv() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzl() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i3 = this.zzh;
            int i4 = this.zzj;
            if (iZzu <= i3 - i4) {
                String str = new String(this.zzg, i4, iZzu, StandardCharsets.UTF_8);
                this.zzj += iZzu;
                return str;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iZzu > this.zzh) {
            return new String(zzQ(iZzu, false), StandardCharsets.UTF_8);
        }
        zzG(iZzu);
        String str2 = new String(this.zzg, this.zzj, iZzu, StandardCharsets.UTF_8);
        this.zzj += iZzu;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzm() throws IOException {
        byte[] bArrZzQ;
        int iZzu = zzu();
        int i3 = this.zzj;
        int i4 = this.zzh;
        if (iZzu <= i4 - i3 && iZzu > 0) {
            bArrZzQ = this.zzg;
            this.zzj = i3 + iZzu;
        } else {
            if (iZzu == 0) {
                return "";
            }
            if (iZzu < 0) {
                throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i3 = 0;
            if (iZzu <= i4) {
                zzG(iZzu);
                bArrZzQ = this.zzg;
                this.zzj = iZzu;
            } else {
                bArrZzQ = zzQ(iZzu, false);
            }
        }
        return zzihf.zze(bArrZzQ, i3, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final zzida zzn() throws IOException {
        int iZzu = zzu();
        int i3 = this.zzh;
        int i4 = this.zzj;
        if (iZzu <= i3 - i4 && iZzu > 0) {
            zzida zzidaVarZzu = zzida.zzu(this.zzg, i4, iZzu, false);
            this.zzj += iZzu;
            return zzidaVarZzu;
        }
        if (iZzu == 0) {
            return zzida.zza;
        }
        if (iZzu < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzR = zzR(iZzu);
        if (bArrZzR != null) {
            return zzida.zzu(bArrZzR, 0, bArrZzR.length, false);
        }
        int i5 = this.zzj;
        int i6 = this.zzh;
        int i7 = i6 - i5;
        this.zzl += i6;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzS = zzS(iZzu - i7);
        byte[] bArr = new byte[iZzu];
        System.arraycopy(this.zzg, i5, bArr, 0, i7);
        for (byte[] bArr2 : listZzS) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i7, length);
            i7 += length;
        }
        return zzida.zzv(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzo() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzp() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzr() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzs() throws IOException {
        return zzide.zzM(zzu());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzt() throws IOException {
        return zzide.zzN(zzv());
    }

    public final int zzu() throws IOException {
        int i3;
        int i4 = this.zzj;
        int i5 = this.zzh;
        if (i5 != i4) {
            byte[] bArr = this.zzg;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.zzj = i6;
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
                this.zzj = i7;
                return i3;
            }
        }
        return (int) zzw();
    }

    public final long zzv() throws IOException {
        long j3;
        long j4;
        long j5;
        int i3 = this.zzj;
        int i4 = this.zzh;
        if (i4 != i3) {
            byte[] bArr = this.zzg;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.zzj = i5;
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
                this.zzj = i6;
                return j3;
            }
        }
        return zzw();
    }

    final long zzw() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            byte bZzz = zzz();
            j3 |= ((long) (bZzz & Ascii.DEL)) << i3;
            if ((bZzz & 128) == 0) {
                return j3;
            }
        }
        throw new zziet("CodedInputStream encountered a malformed varint.");
    }

    public final int zzx() throws IOException {
        int i3 = this.zzj;
        if (this.zzh - i3 < 4) {
            zzG(4);
            i3 = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    public final long zzy() throws IOException {
        int i3 = this.zzj;
        if (this.zzh - i3 < 8) {
            zzG(8);
            i3 = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    public final byte zzz() throws IOException {
        if (this.zzj == this.zzh) {
            zzG(1);
        }
        byte[] bArr = this.zzg;
        int i3 = this.zzj;
        this.zzj = i3 + 1;
        return bArr[i3];
    }
}
