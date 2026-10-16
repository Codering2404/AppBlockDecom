package com.google.android.recaptcha.internal;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzke extends zzkg {
    zzke(String str, String str2, @CheckForNull Character ch) {
        zzkd zzkdVar = new zzkd(str, str2.toCharArray());
        super(zzkdVar, ch);
        zzjf.zza(zzkdVar.zzf.length == 64);
    }

    @Override // com.google.android.recaptcha.internal.zzkg, com.google.android.recaptcha.internal.zzkh
    final int zza(byte[] bArr, CharSequence charSequence) throws zzkf {
        CharSequence charSequenceZze = zze(charSequence);
        if (!this.zza.zzc(charSequenceZze.length())) {
            throw new zzkf("Invalid input length " + charSequenceZze.length());
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < charSequenceZze.length()) {
            int i5 = i4 + 1;
            int iZzb = (this.zza.zzb(charSequenceZze.charAt(i3)) << 18) | (this.zza.zzb(charSequenceZze.charAt(i3 + 1)) << 12);
            bArr[i4] = (byte) (iZzb >>> 16);
            int i6 = i3 + 2;
            if (i6 < charSequenceZze.length()) {
                int i7 = i3 + 3;
                int iZzb2 = iZzb | (this.zza.zzb(charSequenceZze.charAt(i6)) << 6);
                int i8 = i4 + 2;
                bArr[i5] = (byte) ((iZzb2 >>> 8) & 255);
                if (i7 < charSequenceZze.length()) {
                    i3 += 4;
                    i4 += 3;
                    bArr[i8] = (byte) ((iZzb2 | this.zza.zzb(charSequenceZze.charAt(i7))) & 255);
                } else {
                    i4 = i8;
                    i3 = i7;
                }
            } else {
                i3 = i6;
                i4 = i5;
            }
        }
        return i4;
    }

    @Override // com.google.android.recaptcha.internal.zzkg, com.google.android.recaptcha.internal.zzkh
    final void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzjf.zzd(0, i4, bArr.length);
        for (int i6 = i4; i6 >= 3; i6 -= 3) {
            int i7 = bArr[i5] & 255;
            int i8 = ((bArr[i5 + 1] & 255) << 8) | (i7 << 16) | (bArr[i5 + 2] & 255);
            appendable.append(this.zza.zza(i8 >>> 18));
            appendable.append(this.zza.zza((i8 >>> 12) & 63));
            appendable.append(this.zza.zza((i8 >>> 6) & 63));
            appendable.append(this.zza.zza(i8 & 63));
            i5 += 3;
        }
        if (i5 < i4) {
            zzf(appendable, bArr, i5, i4 - i5);
        }
    }
}
