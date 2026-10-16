package com.google.android.recaptcha.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    zzkd(String str, char[] cArr) {
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            char c3 = cArr[i3];
            boolean z2 = true;
            zzjf.zzc(c3 < 128, "Non-ASCII character: %s", c3);
            if (bArr[c3] != -1) {
                z2 = false;
            }
            zzjf.zzc(z2, "Duplicate character: %s", c3);
            bArr[c3] = (byte) i3;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return (obj instanceof zzkd) && Arrays.equals(this.zzf, ((zzkd) obj).zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + 1237;
    }

    public final String toString() {
        return this.zze;
    }

    final char zza(int i3) {
        return this.zzf[i3];
    }

    final int zzb(char c3) throws zzkf {
        if (c3 > 127) {
            throw new zzkf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c3))));
        }
        byte b3 = this.zzg[c3];
        if (b3 != -1) {
            return b3;
        }
        if (c3 <= ' ' || c3 == 127) {
            throw new zzkf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c3))));
        }
        throw new zzkf("Unrecognized character: " + c3);
    }

    final boolean zzc(int i3) {
        return this.zzh[i3 % this.zzc];
    }

    public final boolean zzd(char c3) {
        return this.zzg[61] != -1;
    }

    private zzkd(String str, char[] cArr, byte[] bArr, boolean z2) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzkj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i3 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i3;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i3];
            for (int i4 = 0; i4 < this.zzd; i4++) {
                zArr[zzkj.zza(i4 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = false;
        } catch (ArithmeticException e3) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e3);
        }
    }
}
