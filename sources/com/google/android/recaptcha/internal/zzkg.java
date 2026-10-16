package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzkg extends zzkh {
    final zzkd zza;

    @CheckForNull
    final Character zzb;

    zzkg(zzkd zzkdVar, @CheckForNull Character ch) {
        this.zza = zzkdVar;
        if (ch != null && zzkdVar.zzd('=')) {
            throw new IllegalArgumentException(zzji.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzb = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzkg) {
            zzkg zzkgVar = (zzkg) obj;
            if (this.zza.equals(zzkgVar.zza) && Objects.equals(this.zzb, zzkgVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzb;
        return Objects.hashCode(ch) ^ this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zza);
        if (8 % this.zza.zzb != 0) {
            if (this.zzb == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzb);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    int zza(byte[] bArr, CharSequence charSequence) throws zzkf {
        zzkd zzkdVar;
        CharSequence charSequenceZze = zze(charSequence);
        if (!this.zza.zzc(charSequenceZze.length())) {
            throw new zzkf("Invalid input length " + charSequenceZze.length());
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < charSequenceZze.length()) {
            long jZzb = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                zzkdVar = this.zza;
                if (i5 >= zzkdVar.zzc) {
                    break;
                }
                jZzb <<= zzkdVar.zzb;
                if (i3 + i5 < charSequenceZze.length()) {
                    jZzb |= (long) this.zza.zzb(charSequenceZze.charAt(i6 + i3));
                    i6++;
                }
                i5++;
            }
            int i7 = zzkdVar.zzd;
            int i8 = i6 * zzkdVar.zzb;
            int i9 = (i7 - 1) * 8;
            while (i9 >= (i7 * 8) - i8) {
                bArr[i4] = (byte) ((jZzb >>> i9) & 255);
                i9 -= 8;
                i4++;
            }
            i3 += this.zza.zzc;
        }
        return i4;
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzjf.zzd(0, i4, bArr.length);
        while (i5 < i4) {
            zzf(appendable, bArr, i5, Math.min(this.zza.zzd, i4 - i5));
            i5 += this.zza.zzd;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    final int zzc(int i3) {
        return (int) (((((long) this.zza.zzb) * ((long) i3)) + 7) / 8);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    final int zzd(int i3) {
        zzkd zzkdVar = this.zza;
        return zzkdVar.zzc * zzkj.zza(i3, zzkdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzb == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    final void zzf(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        zzjf.zzd(i3, i3 + i4, bArr.length);
        int i5 = 0;
        zzjf.zza(i4 <= this.zza.zzd);
        long j3 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            j3 = (j3 | ((long) (bArr[i3 + i6] & 255))) << 8;
        }
        int i7 = (i4 + 1) * 8;
        zzkd zzkdVar = this.zza;
        while (i5 < i4 * 8) {
            long j4 = j3 >>> ((i7 - zzkdVar.zzb) - i5);
            zzkd zzkdVar2 = this.zza;
            appendable.append(zzkdVar2.zza(((int) j4) & zzkdVar2.zza));
            i5 += this.zza.zzb;
        }
        if (this.zzb != null) {
            while (i5 < this.zza.zzd * 8) {
                this.zzb.getClass();
                appendable.append('=');
                i5 += this.zza.zzb;
            }
        }
    }

    zzkg(String str, String str2, @CheckForNull Character ch) {
        this(new zzkd(str, str2.toCharArray()), ch);
    }
}
