package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzes {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzes(byte[] bArr, int i3) {
        this.zza = bArr;
        this.zzd = i3;
    }

    private final void zzq() {
        int i3;
        int i4 = this.zzb;
        boolean z2 = false;
        if (i4 >= 0 && (i4 < (i3 = this.zzd) || (i4 == i3 && this.zzc == 0))) {
            z2 = true;
        }
        zzgtj.zzi(z2);
    }

    public final void zza(zzet zzetVar) {
        zzb(zzetVar.zzi(), zzetVar.zze());
        zzf(zzetVar.zzg() * 8);
    }

    public final void zzb(byte[] bArr, int i3) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i3;
    }

    public final int zzc() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzd() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zze() {
        zzgtj.zzi(this.zzc == 0);
        return this.zzb;
    }

    public final void zzf(int i3) {
        int i4 = i3 / 8;
        this.zzb = i4;
        this.zzc = i3 - (i4 * 8);
        zzq();
    }

    public final void zzg() {
        int i3 = this.zzc + 1;
        this.zzc = i3;
        if (i3 == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzq();
    }

    public final void zzh(int i3) {
        int i4 = i3 / 8;
        int i5 = this.zzb + i4;
        this.zzb = i5;
        int i6 = this.zzc + (i3 - (i4 * 8));
        this.zzc = i6;
        if (i6 > 7) {
            this.zzb = i5 + 1;
            this.zzc = i6 - 8;
        }
        zzq();
    }

    public final boolean zzi() {
        int i3 = this.zza[this.zzb] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.zzc);
        zzg();
        return i3 != 0;
    }

    public final int zzj(int i3) {
        int i4;
        if (i3 == 0) {
            return 0;
        }
        this.zzc += i3;
        int i5 = 0;
        while (true) {
            i4 = this.zzc;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.zzc = i6;
            byte[] bArr = this.zza;
            int i7 = this.zzb;
            this.zzb = i7 + 1;
            i5 |= (bArr[i7] & 255) << i6;
        }
        byte[] bArr2 = this.zza;
        int i8 = this.zzb;
        int i9 = i5 | ((bArr2[i8] & 255) >> (8 - i4));
        int i10 = 32 - i3;
        if (i4 == 8) {
            this.zzc = 0;
            this.zzb = i8 + 1;
        }
        int i11 = ((-1) >>> i10) & i9;
        zzq();
        return i11;
    }

    public final long zzk(int i3) {
        if (i3 <= 32) {
            int iZzj = zzj(i3);
            String str = zzfl.zza;
            return 4294967295L & ((long) iZzj);
        }
        int iZzj2 = zzj(i3 - 32);
        int iZzj3 = zzj(32);
        String str2 = zzfl.zza;
        return (4294967295L & ((long) iZzj3)) | ((((long) iZzj2) & 4294967295L) << 32);
    }

    public final void zzl(byte[] bArr, int i3, int i4) {
        int i5;
        int i6 = 0;
        while (true) {
            i5 = i4 >> 3;
            if (i6 >= i5) {
                break;
            }
            byte[] bArr2 = this.zza;
            int i7 = this.zzb;
            int i8 = i7 + 1;
            this.zzb = i8;
            byte b3 = bArr2[i7];
            int i9 = this.zzc;
            byte b4 = (byte) (b3 << i9);
            bArr[i6] = b4;
            bArr[i6] = (byte) (((bArr2[i8] & 255) >> (8 - i9)) | b4);
            i6++;
        }
        int i10 = i4 & 7;
        if (i10 == 0) {
            return;
        }
        byte b5 = (byte) (bArr[i5] & (255 >> i10));
        bArr[i5] = b5;
        int i11 = this.zzc;
        if (i11 + i10 > 8) {
            byte[] bArr3 = this.zza;
            int i12 = this.zzb;
            this.zzb = i12 + 1;
            b5 = (byte) (b5 | ((bArr3[i12] & 255) << i11));
            bArr[i5] = b5;
            i11 -= 8;
        }
        int i13 = i11 + i10;
        this.zzc = i13;
        byte[] bArr4 = this.zza;
        int i14 = this.zzb;
        bArr[i5] = (byte) (((byte) (((255 & bArr4[i14]) >> (8 - i13)) << (8 - i10))) | b5);
        if (i13 == 8) {
            this.zzc = 0;
            this.zzb = i14 + 1;
        }
        zzq();
    }

    public final void zzm() {
        if (this.zzc == 0) {
            return;
        }
        this.zzc = 0;
        this.zzb++;
        zzq();
    }

    public final void zzn(byte[] bArr, int i3, int i4) {
        zzgtj.zzi(this.zzc == 0);
        System.arraycopy(this.zza, this.zzb, bArr, 0, i4);
        this.zzb += i4;
        zzq();
    }

    public final void zzo(int i3) {
        zzgtj.zzi(this.zzc == 0);
        this.zzb += i3;
        zzq();
    }

    public final void zzp(int i3, int i4) {
        int iMin = Math.min(8 - this.zzc, 14);
        int i5 = this.zzc;
        int i6 = (8 - i5) - iMin;
        byte[] bArr = this.zza;
        int i7 = this.zzb;
        byte b3 = (byte) (((65280 >> i5) | ((1 << i6) - 1)) & bArr[i7]);
        bArr[i7] = b3;
        int i8 = 14 - iMin;
        int i9 = i3 & 16383;
        bArr[i7] = (byte) (b3 | ((i9 >>> i8) << i6));
        int i10 = i7 + 1;
        while (i8 > 8) {
            i8 -= 8;
            this.zza[i10] = (byte) (i9 >>> i8);
            i10++;
        }
        byte[] bArr2 = this.zza;
        byte b4 = (byte) (bArr2[i10] & ((1 << r0) - 1));
        bArr2[i10] = b4;
        bArr2[i10] = (byte) (((i9 & ((1 << i8) - 1)) << (8 - i8)) | b4);
        zzh(14);
        zzq();
    }

    public zzes() {
        this.zza = zzfl.zzb;
    }
}
