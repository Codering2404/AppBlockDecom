package com.google.android.gms.internal.gtm;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzul extends zzuq {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzul(int i3) {
        super(null);
        if (i3 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i3, 20)];
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final int zzb() {
        throw null;
    }

    final void zzc(byte b3) {
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        this.zza[i3] = b3;
        this.zzd++;
    }

    final void zzd(int i3) {
        int i4 = this.zzc;
        int i5 = i4 + 1;
        this.zzc = i5;
        byte[] bArr = this.zza;
        bArr[i4] = (byte) (i3 & 255);
        int i6 = i4 + 2;
        this.zzc = i6;
        bArr[i5] = (byte) ((i3 >> 8) & 255);
        int i7 = i4 + 3;
        this.zzc = i7;
        bArr[i6] = (byte) ((i3 >> 16) & 255);
        this.zzc = i4 + 4;
        bArr[i7] = (byte) ((i3 >> 24) & 255);
        this.zzd += 4;
    }

    final void zze(long j3) {
        int i3 = this.zzc;
        int i4 = i3 + 1;
        this.zzc = i4;
        byte[] bArr = this.zza;
        bArr[i3] = (byte) (j3 & 255);
        int i5 = i3 + 2;
        this.zzc = i5;
        bArr[i4] = (byte) ((j3 >> 8) & 255);
        int i6 = i3 + 3;
        this.zzc = i6;
        bArr[i5] = (byte) ((j3 >> 16) & 255);
        int i7 = i3 + 4;
        this.zzc = i7;
        bArr[i6] = (byte) (255 & (j3 >> 24));
        int i8 = i3 + 5;
        this.zzc = i8;
        bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
        int i9 = i3 + 6;
        this.zzc = i9;
        bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
        int i10 = i3 + 7;
        this.zzc = i10;
        bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
        this.zzc = i3 + 8;
        bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
        this.zzd += 8;
    }

    final void zzf(int i3) {
        if (!zzuq.zzb) {
            while ((i3 & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzd++;
                i3 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            bArr2[i5] = (byte) i3;
            this.zzd++;
            return;
        }
        long j3 = this.zzc;
        while ((i3 & (-128)) != 0) {
            byte[] bArr3 = this.zza;
            int i6 = this.zzc;
            this.zzc = i6 + 1;
            zzaau.zzn(bArr3, i6, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            i3 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        zzaau.zzn(bArr4, i7, (byte) i3);
        this.zzd += (int) (((long) this.zzc) - j3);
    }

    final void zzg(long j3) {
        if (zzuq.zzb) {
            long j4 = this.zzc;
            while (true) {
                int i3 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr = this.zza;
                    int i4 = this.zzc;
                    this.zzc = i4 + 1;
                    zzaau.zzn(bArr, i4, (byte) i3);
                    this.zzd += (int) (((long) this.zzc) - j4);
                    return;
                }
                byte[] bArr2 = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzaau.zzn(bArr2, i5, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
        } else {
            while (true) {
                int i6 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr3 = this.zza;
                    int i7 = this.zzc;
                    this.zzc = i7 + 1;
                    bArr3[i7] = (byte) i6;
                    this.zzd++;
                    return;
                }
                byte[] bArr4 = this.zza;
                int i8 = this.zzc;
                this.zzc = i8 + 1;
                bArr4[i8] = (byte) ((i6 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzd++;
                j3 >>>= 7;
            }
        }
    }
}
