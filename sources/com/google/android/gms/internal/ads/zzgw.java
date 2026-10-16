package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgw {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze = 0;

    public zzgw(byte[] bArr, int i3, int i4) {
        this.zza = bArr;
        this.zzc = i3;
        this.zzd = i3;
        this.zzb = i4;
        zzk();
    }

    private final int zzi() {
        int i3 = 0;
        while (!zze()) {
            i3++;
        }
        return ((1 << i3) - 1) + (i3 > 0 ? zzf(i3) : 0);
    }

    private final boolean zzj(int i3) {
        int i4 = i3 - 2;
        if (this.zzc > i4 || i3 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i3] == 3 && bArr[i4] == 0 && bArr[i3 + (-1)] == 0;
    }

    private final void zzk() {
        int i3;
        int i4 = this.zzd;
        boolean z2 = false;
        if (i4 >= 0 && (i4 < (i3 = this.zzb) || (i4 == i3 && this.zze == 0))) {
            z2 = true;
        }
        zzgtj.zzi(z2);
    }

    public final void zza() {
        int i3 = this.zze + 1;
        this.zze = i3;
        if (i3 == 8) {
            this.zze = 0;
            int i4 = this.zzd;
            this.zzd = i4 + (true == zzj(i4 + 1) ? 2 : 1);
        }
        zzk();
    }

    public final void zzb(int i3) {
        int i4 = this.zzd;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        this.zzd = i6;
        int i7 = this.zze + (i3 - (i5 * 8));
        this.zze = i7;
        if (i7 > 7) {
            this.zzd = i6 + 1;
            this.zze = i7 - 8;
        }
        while (true) {
            i4++;
            if (i4 > this.zzd) {
                zzk();
                return;
            } else if (zzj(i4)) {
                this.zzd++;
                i4 += 2;
            }
        }
    }

    public final void zzc() {
        int i3 = this.zze;
        if (i3 > 0) {
            zzb(8 - i3);
        }
    }

    public final boolean zzd(int i3) {
        int i4 = this.zzd;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        int i7 = (this.zze + i3) - (i5 * 8);
        if (i7 > 7) {
            i6++;
            i7 -= 8;
        }
        while (true) {
            i4++;
            if (i4 > i6 || i6 > this.zzb) {
                break;
            }
            if (zzj(i4)) {
                i6++;
                i4 += 2;
            }
        }
        int i8 = this.zzb;
        if (i6 >= i8) {
            return i6 == i8 && i7 == 0;
        }
        return true;
    }

    public final boolean zze() {
        int i3 = this.zza[this.zzd] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.zze);
        zza();
        return i3 != 0;
    }

    public final int zzf(int i3) {
        int i4;
        this.zze += i3;
        int i5 = 0;
        while (true) {
            i4 = this.zze;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.zze = i6;
            byte[] bArr = this.zza;
            int i7 = this.zzd;
            i5 |= (bArr[i7] & 255) << i6;
            if (true != zzj(i7 + 1)) {
                i = 1;
            }
            this.zzd = i7 + i;
        }
        byte[] bArr2 = this.zza;
        int i8 = this.zzd;
        int i9 = i5 | ((bArr2[i8] & 255) >> (8 - i4));
        int i10 = 32 - i3;
        if (i4 == 8) {
            this.zze = 0;
            this.zzd = i8 + (true != zzj(i8 + 1) ? 1 : 2);
        }
        int i11 = ((-1) >>> i10) & i9;
        zzk();
        return i11;
    }

    public final int zzg() {
        return zzi();
    }

    public final int zzh() {
        int iZzi = zzi();
        return (iZzi % 2 == 0 ? -1 : 1) * ((iZzi + 1) / 2);
    }
}
