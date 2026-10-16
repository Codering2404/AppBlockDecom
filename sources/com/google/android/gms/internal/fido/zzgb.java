package com.google.android.gms.internal.fido;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgb {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    zzgb(String str, char[] cArr) {
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            char c3 = cArr[i3];
            boolean z2 = true;
            zzbm.zzd(c3 < 128, "Non-ASCII character: %s", c3);
            if (bArr[c3] != -1) {
                z2 = false;
            }
            zzbm.zzd(z2, "Duplicate character: %s", c3);
            bArr[c3] = (byte) i3;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzgb) {
            zzgb zzgbVar = (zzgb) obj;
            if (this.zzh == zzgbVar.zzh && Arrays.equals(this.zzf, zzgbVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzh ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    final char zza(int i3) {
        return this.zzf[i3];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    final zzgb zzb() {
        int i3;
        boolean z2;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            char[] cArr = this.zzf;
            if (i5 >= cArr.length) {
                return this;
            }
            if (zzba.zza(cArr[i5])) {
                int i6 = 0;
                while (true) {
                    if (i6 >= cArr.length) {
                        z2 = false;
                        break;
                    }
                    char c3 = cArr[i6];
                    if (c3 >= 'A' && c3 <= 'Z') {
                        z2 = true;
                        break;
                    }
                    i6++;
                }
                zzbm.zzf(!z2, "Cannot call upperCase() on a mixed-case alphabet");
                char[] cArr2 = new char[this.zzf.length];
                while (true) {
                    char[] cArr3 = this.zzf;
                    if (i4 >= cArr3.length) {
                        break;
                    }
                    char c4 = cArr3[i4];
                    if (zzba.zza(c4)) {
                        c4 ^= 32;
                    }
                    cArr2[i4] = (char) c4;
                    i4++;
                }
                zzgb zzgbVar = new zzgb(this.zze.concat(".upperCase()"), cArr2);
                if (!this.zzh || zzgbVar.zzh) {
                    return zzgbVar;
                }
                byte[] bArr = zzgbVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (i3 = 65; i3 <= 90; i3++) {
                    int i7 = i3 | 32;
                    byte[] bArr2 = zzgbVar.zzg;
                    byte b3 = bArr2[i3];
                    byte b4 = bArr2[i7];
                    if (b3 == -1) {
                        bArrCopyOf[i3] = b4;
                    } else {
                        char c5 = (char) i3;
                        char c6 = (char) i7;
                        if (b4 != -1) {
                            throw new IllegalStateException(zzbo.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c5), Character.valueOf(c6)));
                        }
                        bArrCopyOf[i7] = b3;
                    }
                }
                return new zzgb(zzgbVar.zze.concat(".ignoreCase()"), zzgbVar.zzf, bArrCopyOf, true);
            }
            i5++;
        }
    }

    public final boolean zzc(char c3) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzgb(String str, char[] cArr, byte[] bArr, boolean z2) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzgh.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i3 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i3;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i3];
            for (int i4 = 0; i4 < this.zzd; i4++) {
                zArr[zzgh.zza(i4 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z2;
        } catch (ArithmeticException e3) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e3);
        }
    }
}
