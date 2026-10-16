package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidi extends zzidj {
    private final byte[] zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private final OutputStream zzg;

    zzidi(OutputStream outputStream, int i3) {
        super(null);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
        if (i3 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i3, 20)];
        this.zzc = bArr;
        this.zzd = bArr.length;
    }

    private final void zzK(int i3) throws IOException {
        if (this.zzd - this.zze < i3) {
            zzL();
        }
    }

    private final void zzL() throws IOException {
        this.zzg.write(this.zzc, 0, this.zze);
        this.zze = 0;
    }

    final void zzA(long j3) {
        if (zzidj.zzc) {
            long j4 = this.zze;
            while (true) {
                int i3 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr = this.zzc;
                    int i4 = this.zze;
                    this.zze = i4 + 1;
                    zziha.zzo(bArr, i4, (byte) i3);
                    this.zzf += (int) (((long) this.zze) - j4);
                    return;
                }
                byte[] bArr2 = this.zzc;
                int i5 = this.zze;
                this.zze = i5 + 1;
                zziha.zzo(bArr2, i5, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
        } else {
            while (true) {
                int i6 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr3 = this.zzc;
                    int i7 = this.zze;
                    this.zze = i7 + 1;
                    bArr3[i7] = (byte) i6;
                    this.zzf++;
                    return;
                }
                byte[] bArr4 = this.zzc;
                int i8 = this.zze;
                this.zze = i8 + 1;
                bArr4[i8] = (byte) (i6 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzf++;
                j3 >>>= 7;
            }
        }
    }

    final void zzB(int i3) {
        int i4 = this.zze;
        byte[] bArr = this.zzc;
        bArr[i4] = (byte) i3;
        bArr[i4 + 1] = (byte) (i3 >> 8);
        bArr[i4 + 2] = (byte) (i3 >> 16);
        bArr[i4 + 3] = (byte) (i3 >> 24);
        this.zze = i4 + 4;
        this.zzf += 4;
    }

    final void zzC(long j3) {
        int i3 = this.zze;
        byte[] bArr = this.zzc;
        bArr[i3] = (byte) j3;
        bArr[i3 + 1] = (byte) (j3 >> 8);
        bArr[i3 + 2] = (byte) (j3 >> 16);
        bArr[i3 + 3] = (byte) (j3 >> 24);
        bArr[i3 + 4] = (byte) (j3 >> 32);
        bArr[i3 + 5] = (byte) (j3 >> 40);
        bArr[i3 + 6] = (byte) (j3 >> 48);
        bArr[i3 + 7] = (byte) (j3 >> 56);
        this.zze = i3 + 8;
        this.zzf += 8;
    }

    public final void zzD(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.zzd;
        int i6 = this.zze;
        int i7 = i5 - i6;
        if (i7 >= i4) {
            System.arraycopy(bArr, i3, this.zzc, i6, i4);
            this.zze += i4;
            this.zzf += i4;
            return;
        }
        byte[] bArr2 = this.zzc;
        System.arraycopy(bArr, i3, bArr2, i6, i7);
        int i8 = i3 + i7;
        this.zze = i5;
        this.zzf += i7;
        zzL();
        int i9 = i4 - i7;
        if (i9 <= i5) {
            System.arraycopy(bArr, i8, bArr2, 0, i9);
            this.zze = i9;
        } else {
            this.zzg.write(bArr, i8, i9);
        }
        this.zzf += i9;
    }

    @Override // com.google.android.gms.internal.ads.zzicr
    public final void zza(byte[] bArr, int i3, int i4) throws IOException {
        zzD(bArr, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzb(int i3, int i4) throws IOException {
        zzr((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzc(int i3, int i4) throws IOException {
        zzK(20);
        zzz(i3 << 3);
        if (i4 >= 0) {
            zzz(i4);
        } else {
            zzA(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzd(int i3, int i4) throws IOException {
        zzK(20);
        zzz(i3 << 3);
        zzz(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zze(int i3, int i4) throws IOException {
        zzK(14);
        zzz((i3 << 3) | 5);
        zzB(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzf(int i3, long j3) throws IOException {
        zzK(20);
        zzz(i3 << 3);
        zzA(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzg(int i3, long j3) throws IOException {
        zzK(18);
        zzz((i3 << 3) | 1);
        zzC(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzh(int i3, boolean z2) throws IOException {
        zzK(11);
        zzz(i3 << 3);
        zzv(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzi(int i3, String str) throws IOException {
        zzr((i3 << 3) | 2);
        zzw(str);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzj(int i3, zzida zzidaVar) throws IOException {
        zzr((i3 << 3) | 2);
        zzk(zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzk(zzida zzidaVar) throws IOException {
        zzr(zzidaVar.zzb());
        zzidaVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzl(byte[] bArr, int i3, int i4) throws IOException {
        zzr(i4);
        zzD(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzm(int i3, zzifp zzifpVar) throws IOException {
        zzr(11);
        zzd(2, i3);
        zzr(26);
        zzo(zzifpVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzn(int i3, zzida zzidaVar) throws IOException {
        zzr(11);
        zzd(2, i3);
        zzj(3, zzidaVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzo(zzifp zzifpVar) throws IOException {
        zzr(zzifpVar.zzbr());
        zzifpVar.zzcX(this);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzp(byte b3) throws IOException {
        if (this.zze == this.zzd) {
            zzL();
        }
        zzv(b3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzq(int i3) throws IOException {
        if (i3 >= 0) {
            zzr(i3);
        } else {
            zzt(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzr(int i3) throws IOException {
        zzK(5);
        zzz(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzs(int i3) throws IOException {
        zzK(4);
        zzB(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzt(long j3) throws IOException {
        zzK(10);
        zzA(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzu(long j3) throws IOException {
        zzK(8);
        zzC(j3);
    }

    final void zzv(byte b3) {
        byte[] bArr = this.zzc;
        int i3 = this.zze;
        bArr[i3] = b3;
        this.zze = i3 + 1;
        this.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzw(String str) throws IOException {
        int iZzc;
        int length = str.length() * 3;
        int iZzF = zzidj.zzF(length);
        int i3 = iZzF + length;
        int i4 = this.zzd;
        if (i3 > i4) {
            byte[] bArr = new byte[length];
            int iZzd = zzihf.zzd(str, bArr, 0, length);
            zzr(iZzd);
            zzD(bArr, 0, iZzd);
            return;
        }
        if (i3 > i4 - this.zze) {
            zzL();
        }
        int iZzF2 = zzidj.zzF(str.length());
        int i5 = this.zze;
        try {
            if (iZzF2 == iZzF) {
                int i6 = i5 + iZzF2;
                this.zze = i6;
                int iZzd2 = zzihf.zzd(str, this.zzc, i6, i4 - i6);
                this.zze = i5;
                iZzc = (iZzd2 - i5) - iZzF2;
                zzz(iZzc);
                this.zze = iZzd2;
            } else {
                iZzc = zzihf.zzc(str);
                zzz(iZzc);
                this.zze = zzihf.zzd(str, this.zzc, this.zze, iZzc);
            }
            this.zzf += iZzc;
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw new zzidh(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final void zzx() throws IOException {
        if (this.zze > 0) {
            zzL();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidj
    public final int zzy() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    final void zzz(int i3) {
        if (!zzidj.zzc) {
            while ((i3 & (-128)) != 0) {
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = i4 + 1;
                bArr[i4] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzf++;
                i3 >>>= 7;
            }
            byte[] bArr2 = this.zzc;
            int i5 = this.zze;
            this.zze = i5 + 1;
            bArr2[i5] = (byte) i3;
            this.zzf++;
            return;
        }
        long j3 = this.zze;
        while ((i3 & (-128)) != 0) {
            byte[] bArr3 = this.zzc;
            int i6 = this.zze;
            this.zze = i6 + 1;
            zziha.zzo(bArr3, i6, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            i3 >>>= 7;
        }
        byte[] bArr4 = this.zzc;
        int i7 = this.zze;
        this.zze = i7 + 1;
        zziha.zzo(bArr4, i7, (byte) i3);
        this.zzf += (int) (((long) this.zze) - j3);
    }
}
