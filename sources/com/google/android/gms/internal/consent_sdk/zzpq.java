package com.google.android.gms.internal.consent_sdk;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzpq extends zzpv {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzpq(int i3) {
        super(null);
        if (i3 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i3, 20)];
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final int zzb() {
        throw null;
    }

    final void zzc(byte b3) {
        byte[] bArr = this.zza;
        int i3 = this.zzc;
        bArr[i3] = b3;
        this.zzc = i3 + 1;
        this.zzd++;
    }

    final void zzd(int i3) {
        int i4 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i4] = (byte) i3;
        bArr[i4 + 1] = (byte) (i3 >> 8);
        bArr[i4 + 2] = (byte) (i3 >> 16);
        bArr[i4 + 3] = (byte) (i3 >> 24);
        this.zzc = i4 + 4;
        this.zzd += 4;
    }

    final void zze(long j3) {
        int i3 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i3] = (byte) j3;
        bArr[i3 + 1] = (byte) (j3 >> 8);
        bArr[i3 + 2] = (byte) (j3 >> 16);
        bArr[i3 + 3] = (byte) (j3 >> 24);
        bArr[i3 + 4] = (byte) (j3 >> 32);
        bArr[i3 + 5] = (byte) (j3 >> 40);
        bArr[i3 + 6] = (byte) (j3 >> 48);
        bArr[i3 + 7] = (byte) (j3 >> 56);
        this.zzc = i3 + 8;
        this.zzd += 8;
    }

    final void zzf(int i3) {
        if (!zzpv.zzb) {
            while ((i3 & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                bArr[i4] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
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
            zzsw.zzn(bArr3, i6, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            i3 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        zzsw.zzn(bArr4, i7, (byte) i3);
        this.zzd += (int) (((long) this.zzc) - j3);
    }

    final void zzg(long j3) {
        if (zzpv.zzb) {
            long j4 = this.zzc;
            while (true) {
                int i3 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr = this.zza;
                    int i4 = this.zzc;
                    this.zzc = i4 + 1;
                    zzsw.zzn(bArr, i4, (byte) i3);
                    this.zzd += (int) (((long) this.zzc) - j4);
                    return;
                }
                byte[] bArr2 = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzsw.zzn(bArr2, i5, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
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
                bArr4[i8] = (byte) (i6 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.zzd++;
                j3 >>>= 7;
            }
        }
    }
}
