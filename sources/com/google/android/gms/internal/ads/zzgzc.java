package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzc {
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
    zzgzc(String str, char[] cArr) {
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            char c3 = cArr[i3];
            boolean z2 = true;
            zzgtj.zzc(c3 < 128, "Non-ASCII character: %s", c3);
            if (bArr[c3] != -1) {
                z2 = false;
            }
            zzgtj.zzc(z2, "Duplicate character: %s", c3);
            bArr[c3] = (byte) i3;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgzc) {
            zzgzc zzgzcVar = (zzgzc) obj;
            if (this.zzi == zzgzcVar.zzi && Arrays.equals(this.zzf, zzgzcVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzi ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    final char zza(int i3) {
        return this.zzf[i3];
    }

    final boolean zzb(int i3) {
        return this.zzh[i3 % this.zzc];
    }

    final int zzc(char c3) throws zzgzf {
        if (c3 > 127) {
            throw new zzgzf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c3))));
        }
        byte b3 = this.zzg[c3];
        if (b3 != -1) {
            return b3;
        }
        if (c3 <= ' ' || c3 == 127) {
            throw new zzgzf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c3))));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(c3).length() + 24);
        sb.append("Unrecognized character: ");
        sb.append(c3);
        throw new zzgzf(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    final zzgzc zzd() {
        boolean z2;
        int i3 = 0;
        while (true) {
            char[] cArr = this.zzf;
            int length = cArr.length;
            if (i3 >= length) {
                return this;
            }
            if (zzgss.zzd(cArr[i3])) {
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z2 = false;
                        break;
                    }
                    if (zzgss.zzc(cArr[i4])) {
                        z2 = true;
                        break;
                    }
                    i4++;
                }
                zzgtj.zzj(!z2, "Cannot call lowerCase() on a mixed-case alphabet");
                char[] cArr2 = new char[cArr.length];
                for (int i5 = 0; i5 < cArr.length; i5++) {
                    char c3 = cArr[i5];
                    if (zzgss.zzd(c3)) {
                        c3 ^= 32;
                    }
                    cArr2[i5] = (char) c3;
                }
                zzgzc zzgzcVar = new zzgzc(this.zze.concat(".lowerCase()"), cArr2);
                if (!this.zzi || zzgzcVar.zzi) {
                    return zzgzcVar;
                }
                byte[] bArr = zzgzcVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (int i6 = 65; i6 <= 90; i6++) {
                    int i7 = i6 | 32;
                    byte b3 = bArr[i6];
                    byte b4 = bArr[i7];
                    if (b3 == -1) {
                        bArrCopyOf[i6] = b4;
                    } else {
                        char c4 = (char) i6;
                        char c5 = (char) i7;
                        if (b4 != -1) {
                            throw new IllegalStateException(zzgua.zzd("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c4), Character.valueOf(c5)));
                        }
                        bArrCopyOf[i7] = b3;
                    }
                }
                return new zzgzc(zzgzcVar.zze.concat(".ignoreCase()"), zzgzcVar.zzf, bArrCopyOf, true);
            }
            i3++;
        }
    }

    public final boolean zze(char c3) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    final /* synthetic */ char[] zzf() {
        return this.zzf;
    }

    private zzgzc(String str, char[] cArr, byte[] bArr, boolean z2) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZza = zzgzz.zza(length, RoundingMode.UNNECESSARY);
            this.zzb = iZza;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZza);
            int i3 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i3;
            this.zzd = iZza >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i3];
            for (int i4 = 0; i4 < this.zzd; i4++) {
                zArr[zzgzz.zzb(i4 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = z2;
        } catch (ArithmeticException e3) {
            int length2 = cArr.length;
            StringBuilder sb = new StringBuilder(String.valueOf(length2).length() + 24);
            sb.append("Illegal alphabet length ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString(), e3);
        }
    }
}
