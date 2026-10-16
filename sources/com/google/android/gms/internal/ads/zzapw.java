package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapw {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
    private boolean zze;
    private int zzf;

    public zzapw(int i3) {
    }

    public final void zza() {
        this.zze = false;
        this.zza = 0;
        this.zzf = 0;
    }

    public final boolean zzb(int i3, int i4) {
        int i5 = this.zzf;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i3 == 179 || i3 == 181) {
                            this.zza -= i4;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i3 & 240) != 32) {
                        zzeg.zzc("H263Reader", "Unexpected start code value");
                        zza();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i3 > 31) {
                    zzeg.zzc("H263Reader", "Unexpected start code value");
                    zza();
                } else {
                    this.zzf = 3;
                }
            } else if (i3 != 181) {
                zzeg.zzc("H263Reader", "Unexpected start code value");
                zza();
            } else {
                this.zzf = 2;
            }
        } else if (i3 == 176) {
            this.zzf = 1;
            this.zze = true;
        }
        zzc(zzd, 0, 3);
        return false;
    }

    public final void zzc(byte[] bArr, int i3, int i4) {
        if (this.zze) {
            int i5 = i4 - i3;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i6 = this.zza + i5;
            if (length < i6) {
                this.zzc = Arrays.copyOf(bArr2, i6 + i6);
            }
            System.arraycopy(bArr, i3, this.zzc, this.zza, i5);
            this.zza += i5;
        }
    }
}
