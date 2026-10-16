package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzha {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzha(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final boolean zza() {
        int i3 = (this.zza[this.zzc] & 255) >> this.zzd;
        zzc(1);
        return 1 == (i3 & 1);
    }

    public final int zzb(int i3) {
        int i4 = this.zzc;
        int i5 = 8 - this.zzd;
        int i6 = i4 + 1;
        byte[] bArr = this.zza;
        int iMin = Math.min(i3, i5);
        int i7 = ((bArr[i4] & 255) >> this.zzd) & (255 >> (8 - iMin));
        while (iMin < i3) {
            i7 |= (bArr[i6] & 255) << iMin;
            iMin += 8;
            i6++;
        }
        int i8 = i7 & ((-1) >>> (32 - i3));
        zzc(i3);
        return i8;
    }

    public final void zzc(int i3) {
        int i4;
        int i5 = i3 / 8;
        int i6 = this.zzc + i5;
        this.zzc = i6;
        int i7 = this.zzd + (i3 - (i5 * 8));
        this.zzd = i7;
        if (i7 > 7) {
            i6++;
            this.zzc = i6;
            i7 -= 8;
            this.zzd = i7;
        }
        boolean z2 = false;
        if (i6 >= 0 && (i6 < (i4 = this.zzb) || (i6 == i4 && i7 == 0))) {
            z2 = true;
        }
        zzgtj.zzi(z2);
    }

    public final int zzd() {
        return (this.zzc * 8) + this.zzd;
    }
}
