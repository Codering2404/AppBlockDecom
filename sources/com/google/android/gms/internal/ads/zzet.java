package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzet {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzgww zzc = zzgww.zzm(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    private static final AtomicBoolean zzd = new AtomicBoolean();
    private byte[] zze;
    private int zzf;
    private int zzg;

    public zzet(byte[] bArr, int i3) {
        this.zze = bArr;
        this.zzg = i3;
    }

    private final char zzS(ByteOrder byteOrder, int i3) {
        zzW(2);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.zze;
            int i4 = this.zzf + i3;
            return zzhad.zza(bArr[i4], bArr[i4 + 1]);
        }
        byte[] bArr2 = this.zze;
        int i5 = this.zzf + i3;
        return zzhad.zza(bArr2[i5 + 1], bArr2[i5]);
    }

    private final char zzT(Charset charset, char[] cArr) {
        int iZzU;
        if (zzd() >= zzV(charset) && (iZzU = zzU(charset)) != 0) {
            if (!Character.isSupplementaryCodePoint(i)) {
                long j3 = i;
                char c3 = (char) j3;
                zzgtj.zze(((long) c3) == j3, "Out of range: %s", j3);
                for (char c4 : cArr) {
                    if (c4 == c3) {
                        this.zzf += zzhah.zza(iZzU & 255);
                        return c3;
                    }
                }
            }
        }
        return (char) 0;
    }

    private final int zzU(Charset charset) {
        int codePoint;
        int i3;
        int unsignedInt;
        zzgtj.zzf(zzc.contains(charset), "Unsupported charset: %s", charset);
        if (zzd() < zzV(charset)) {
            int i4 = this.zzf;
            int i5 = this.zzg;
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 17 + String.valueOf(i5).length());
            sb.append("position=");
            sb.append(i4);
            sb.append(", limit=");
            sb.append(i5);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i6 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b3 = this.zze[this.zzf];
            if ((b3 & 128) == 0) {
                codePoint = Byte.toUnsignedInt(b3);
                return (codePoint << 8) | i6;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b4 = this.zze[this.zzf];
            if ((b4 & 128) == 0) {
                i3 = 1;
            } else if ((b4 & 224) == 192 && zzd() >= 2 && zzX(this.zze[this.zzf + 1])) {
                i3 = 2;
            } else {
                if ((this.zze[this.zzf] & 240) == 224 && zzd() >= 3) {
                    byte[] bArr = this.zze;
                    int i7 = this.zzf;
                    if (zzX(bArr[i7 + 1]) && zzX(bArr[i7 + 2])) {
                        i3 = 3;
                    }
                }
                if ((this.zze[this.zzf] & 248) == 240 && zzd() >= 4) {
                    byte[] bArr2 = this.zze;
                    int i8 = this.zzf;
                    if (zzX(bArr2[i8 + 1]) && zzX(bArr2[i8 + 2]) && zzX(bArr2[i8 + 3])) {
                        i3 = 4;
                    }
                }
                i3 = 0;
            }
            if (i3 == 1) {
                unsignedInt = Byte.toUnsignedInt(this.zze[this.zzf]);
            } else if (i3 == 2) {
                byte[] bArr3 = this.zze;
                int i9 = this.zzf;
                unsignedInt = zzY(0, 0, bArr3[i9], bArr3[i9 + 1]);
            } else {
                if (i3 != 3) {
                    if (i3 == 4) {
                        byte[] bArr4 = this.zze;
                        int i10 = this.zzf;
                        unsignedInt = zzY(bArr4[i10], bArr4[i10 + 1], bArr4[i10 + 2], bArr4[i10 + 3]);
                    }
                    return 0;
                }
                byte[] bArr5 = this.zze;
                int i11 = this.zzf;
                unsignedInt = zzY(0, bArr5[i11] & Ascii.SI, bArr5[i11 + 1], bArr5[i11 + 2]);
            }
            i6 = i3;
            codePoint = unsignedInt;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cZzS = zzS(byteOrder, 0);
            if (!Character.isHighSurrogate(cZzS) || zzd() < 4) {
                codePoint = cZzS;
                i6 = 2;
            } else {
                codePoint = Character.toCodePoint(cZzS, zzS(byteOrder, 2));
                i6 = 4;
            }
        }
        return (codePoint << 8) | i6;
    }

    private static int zzV(Charset charset) {
        zzgtj.zzf(zzc.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    private final void zzW(int i3) {
        if (!zzd.get() || zzd() >= i3) {
            return;
        }
        int iZzd = zzd();
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 25 + String.valueOf(iZzd).length());
        sb.append("bytesNeeded= ");
        sb.append(i3);
        sb.append(", bytesLeft=");
        sb.append(iZzd);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    private static boolean zzX(byte b3) {
        return (b3 & 192) == 128;
    }

    private static int zzY(int i3, int i4, int i5, int i6) {
        return zzhah.zze((byte) 0, zzhal.zza(((i3 & 7) << 2) | ((i4 & 48) >> 4)), zzhal.zza(((i5 & 60) >> 2) | ((i4 & 15) << 4)), zzhal.zza((i6 & 63) | ((i5 & 3) << 6)));
    }

    public final long zzA() {
        zzW(4);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        long j3 = bArr[i3];
        int i5 = i3 + 2;
        this.zzf = i5;
        long j4 = bArr[i4];
        int i6 = i3 + 3;
        this.zzf = i6;
        long j5 = bArr[i5];
        this.zzf = i3 + 4;
        return ((((long) bArr[i6]) & 255) << 24) | (255 & j3) | ((j4 & 255) << 8) | ((j5 & 255) << 16);
    }

    public final int zzB() {
        zzW(4);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        int i6 = i3 + 2;
        this.zzf = i6;
        int i7 = bArr[i4] & 255;
        int i8 = i3 + 3;
        this.zzf = i8;
        int i9 = bArr[i6] & 255;
        this.zzf = i3 + 4;
        return (bArr[i8] & 255) | (i5 << 24) | (i7 << 16) | (i9 << 8);
    }

    public final int zzC() {
        zzW(4);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        int i6 = i3 + 2;
        this.zzf = i6;
        int i7 = bArr[i4] & 255;
        int i8 = i3 + 3;
        this.zzf = i8;
        int i9 = bArr[i6] & 255;
        this.zzf = i3 + 4;
        return ((bArr[i8] & 255) << 24) | (i7 << 8) | i5 | (i9 << 16);
    }

    public final long zzD() {
        zzW(8);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        long j3 = bArr[i3];
        int i5 = i3 + 2;
        this.zzf = i5;
        long j4 = bArr[i4];
        int i6 = i3 + 3;
        this.zzf = i6;
        long j5 = bArr[i5];
        int i7 = i3 + 4;
        this.zzf = i7;
        long j6 = bArr[i6];
        int i8 = i3 + 5;
        this.zzf = i8;
        long j7 = bArr[i7];
        int i9 = i3 + 6;
        this.zzf = i9;
        long j8 = bArr[i8];
        int i10 = i3 + 7;
        this.zzf = i10;
        long j9 = bArr[i9];
        this.zzf = i3 + 8;
        return ((j9 & 255) << 8) | ((j3 & 255) << 56) | ((j4 & 255) << 48) | ((j5 & 255) << 40) | ((j6 & 255) << 32) | ((j7 & 255) << 24) | ((j8 & 255) << 16) | (((long) bArr[i10]) & 255);
    }

    public final long zzE() {
        zzW(8);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        long j3 = bArr[i3];
        int i5 = i3 + 2;
        this.zzf = i5;
        long j4 = bArr[i4];
        int i6 = i3 + 3;
        this.zzf = i6;
        long j5 = bArr[i5];
        int i7 = i3 + 4;
        this.zzf = i7;
        long j6 = bArr[i6];
        int i8 = i3 + 5;
        this.zzf = i8;
        long j7 = bArr[i7];
        int i9 = i3 + 6;
        this.zzf = i9;
        long j8 = bArr[i8];
        int i10 = i3 + 7;
        this.zzf = i10;
        long j9 = bArr[i9];
        this.zzf = i3 + 8;
        return ((j9 & 255) << 48) | (j3 & 255) | ((j4 & 255) << 8) | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((j7 & 255) << 32) | ((j8 & 255) << 40) | ((((long) bArr[i10]) & 255) << 56);
    }

    public final int zzF() {
        zzW(4);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        this.zzf = i3 + 2;
        int i6 = bArr[i4] & 255;
        this.zzf = i3 + 4;
        return (i5 << 8) | i6;
    }

    public final int zzG() {
        return (zzs() << 21) | (zzs() << 14) | (zzs() << 7) | zzs();
    }

    public final int zzH() {
        int iZzB = zzB();
        if (iZzB >= 0) {
            return iZzB;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 18);
        sb.append("Top bit not zero: ");
        sb.append(iZzB);
        throw new IllegalStateException(sb.toString());
    }

    public final int zzI() {
        int iZzC = zzC();
        if (iZzC >= 0) {
            return iZzC;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzC).length() + 18);
        sb.append("Top bit not zero: ");
        sb.append(iZzC);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzJ() {
        long jZzD = zzD();
        if (jZzD >= 0) {
            return jZzD;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(jZzD).length() + 18);
        sb.append("Top bit not zero: ");
        sb.append(jZzD);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzK(int i3, Charset charset) {
        zzW(i3);
        byte[] bArr = this.zze;
        int i4 = this.zzf;
        String str = new String(bArr, i4, i3, charset);
        this.zzf = i4 + i3;
        return str;
    }

    public final String zzL(int i3) {
        zzW(i3);
        if (i3 == 0) {
            return "";
        }
        int i4 = this.zzf;
        int i5 = (i4 + i3) - 1;
        String strZzk = zzfl.zzk(this.zze, i4, (i5 >= this.zzg || this.zze[i5] != 0) ? i3 : i3 - 1);
        this.zzf += i3;
        return strZzk;
    }

    public final String zzM(char c3) {
        if (zzd() == 0) {
            return null;
        }
        int i3 = this.zzf;
        while (i3 < this.zzg && this.zze[i3] != 0) {
            i3++;
        }
        byte[] bArr = this.zze;
        int i4 = this.zzf;
        String strZzk = zzfl.zzk(bArr, i4, i3 - i4);
        this.zzf = i3;
        if (i3 < this.zzg) {
            this.zzf = i3 + 1;
        }
        return strZzk;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzN(java.nio.charset.Charset r5) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzet.zzN(java.nio.charset.Charset):java.lang.String");
    }

    public final long zzO() {
        int i3;
        zzW(1);
        long j3 = this.zze[this.zzf];
        int i4 = 7;
        while (true) {
            i3 = 0;
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j3) != 0) {
                i4--;
            } else if (i4 < 6) {
                j3 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        if (i3 == 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 35);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j3);
            throw new NumberFormatException(sb.toString());
        }
        zzW(i3);
        for (int i6 = 1; i6 < i3; i6++) {
            byte b3 = this.zze[this.zzf + i6];
            if ((b3 & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(j3).length() + 42);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j3);
                throw new NumberFormatException(sb2.toString());
            }
            j3 = (j3 << 6) | ((long) (b3 & 63));
        }
        this.zzf += i3;
        return j3;
    }

    public final long zzP() {
        long j3 = 0;
        for (int i3 = 0; i3 < 9; i3++) {
            if (this.zzf == this.zzg) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long jZzs = zzs();
            j3 |= (127 & jZzs) << (i3 * 7);
            if ((jZzs & 128) == 0) {
                return j3;
            }
        }
        return j3;
    }

    public final void zzQ() {
        while ((zzs() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
        }
    }

    public final Charset zzR() {
        if (zzd() >= 3) {
            byte[] bArr = this.zze;
            int i3 = this.zzf;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.zzf = i3 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (zzd() < 2) {
            return null;
        }
        byte[] bArr2 = this.zze;
        int i4 = this.zzf;
        byte b3 = bArr2[i4];
        if (b3 == -2) {
            if (bArr2[i4 + 1] != -1) {
                return null;
            }
            this.zzf = i4 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b3 != -1 || bArr2[i4 + 1] != -2) {
            return null;
        }
        this.zzf = i4 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void zza(int i3) {
        byte[] bArr = this.zze;
        if (bArr.length < i3) {
            bArr = new byte[i3];
        }
        zzb(bArr, i3);
    }

    public final void zzb(byte[] bArr, int i3) {
        this.zze = bArr;
        this.zzg = i3;
        this.zzf = 0;
    }

    public final void zzc(int i3) {
        byte[] bArr = this.zze;
        if (i3 > bArr.length) {
            this.zze = Arrays.copyOf(bArr, i3);
        }
    }

    public final int zzd() {
        return Math.max(this.zzg - this.zzf, 0);
    }

    public final int zze() {
        return this.zzg;
    }

    public final void zzf(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= this.zze.length) {
            z2 = true;
        }
        zzgtj.zza(z2);
        this.zzg = i3;
    }

    public final int zzg() {
        return this.zzf;
    }

    public final void zzh(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= this.zzg) {
            z2 = true;
        }
        zzgtj.zza(z2);
        this.zzf = i3;
    }

    public final byte[] zzi() {
        return this.zze;
    }

    public final int zzj() {
        return this.zze.length;
    }

    public final void zzk(int i3) {
        zzh(this.zzf + i3);
    }

    public final void zzl(zzes zzesVar, int i3) {
        zzm(zzesVar.zza, 0, i3);
        zzesVar.zzf(0);
    }

    public final void zzm(byte[] bArr, int i3, int i4) {
        zzW(i4);
        System.arraycopy(this.zze, this.zzf, bArr, i3, i4);
        this.zzf += i4;
    }

    public final int zzn() {
        zzW(1);
        return this.zze[this.zzf] & 255;
    }

    public final char zzo() {
        return zzS(ByteOrder.BIG_ENDIAN, 0);
    }

    public final int zzp(Charset charset) {
        if (zzU(charset) != 0) {
            return zzhah.zza(r3 >>> 8);
        }
        return 1114112;
    }

    public final int zzq() {
        if (zzd() >= 3) {
            this.zzf -= 3;
            return zzx();
        }
        int i3 = this.zzf;
        int i4 = this.zzg;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 17 + String.valueOf(i4).length());
        sb.append("position=");
        sb.append(i3);
        sb.append(", limit=");
        sb.append(i4);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int zzr() {
        if (zzd() >= 4) {
            this.zzf -= 4;
            return zzB();
        }
        int i3 = this.zzf;
        int i4 = this.zzg;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 17 + String.valueOf(i4).length());
        sb.append("position=");
        sb.append(i3);
        sb.append(", limit=");
        sb.append(i4);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int zzs() {
        zzW(1);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        this.zzf = i3 + 1;
        return bArr[i3] & 255;
    }

    public final int zzt() {
        zzW(2);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        this.zzf = i3 + 2;
        return (bArr[i4] & 255) | (i5 << 8);
    }

    public final int zzu() {
        zzW(2);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        this.zzf = i3 + 2;
        return ((bArr[i4] & 255) << 8) | i5;
    }

    public final short zzv() {
        zzW(2);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        this.zzf = i3 + 2;
        return (short) ((bArr[i4] & 255) | (i5 << 8));
    }

    public final short zzw() {
        zzW(2);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        this.zzf = i3 + 2;
        return (short) (((bArr[i4] & 255) << 8) | i5);
    }

    public final int zzx() {
        zzW(3);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        int i6 = i3 + 2;
        this.zzf = i6;
        int i7 = bArr[i4] & 255;
        this.zzf = i3 + 3;
        return (bArr[i6] & 255) | (i5 << 16) | (i7 << 8);
    }

    public final int zzy() {
        zzW(3);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        int i5 = bArr[i3] & 255;
        int i6 = i3 + 2;
        this.zzf = i6;
        int i7 = bArr[i4] & 255;
        this.zzf = i3 + 3;
        return (bArr[i6] & 255) | ((i5 << 24) >> 8) | (i7 << 8);
    }

    public final long zzz() {
        zzW(4);
        byte[] bArr = this.zze;
        int i3 = this.zzf;
        int i4 = i3 + 1;
        this.zzf = i4;
        long j3 = bArr[i3];
        int i5 = i3 + 2;
        this.zzf = i5;
        long j4 = bArr[i4];
        int i6 = i3 + 3;
        this.zzf = i6;
        long j5 = bArr[i5];
        this.zzf = i3 + 4;
        return (((long) bArr[i6]) & 255) | ((j3 & 255) << 24) | ((j4 & 255) << 16) | ((j5 & 255) << 8);
    }

    public zzet() {
        this.zze = zzfl.zzb;
    }

    public zzet(int i3) {
        this.zze = new byte[i3];
        this.zzg = i3;
    }

    public zzet(byte[] bArr) {
        this.zze = bArr;
        this.zzg = bArr.length;
    }
}
