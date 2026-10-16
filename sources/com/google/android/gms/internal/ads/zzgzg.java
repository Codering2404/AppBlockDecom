package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzgzg extends zzgzh {
    private volatile zzgzh zza;
    final zzgzc zzb;
    final Character zzc;

    zzgzg(zzgzc zzgzcVar, Character ch) {
        this.zzb = zzgzcVar;
        boolean z2 = true;
        if (ch != null && zzgzcVar.zze('=')) {
            z2 = false;
        }
        zzgtj.zzf(z2, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgzg) {
            zzgzg zzgzgVar = (zzgzg) obj;
            if (this.zzb.equals(zzgzgVar.zzb) && Objects.equals(this.zzc, zzgzgVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgzc zzgzcVar = this.zzb;
        sb.append(zzgzcVar);
        if (8 % zzgzcVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    void zza(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzgtj.zzo(0, i4, bArr.length);
        while (i5 < i4) {
            int i6 = this.zzb.zzd;
            zze(appendable, bArr, i5, Math.min(i6, i4 - i5));
            i5 += i6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
        int i3;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgzc zzgzcVar = this.zzb;
        if (!zzgzcVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length2).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length2);
            throw new zzgzf(sb.toString());
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < charSequenceZzg.length()) {
            long jZzc = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i3 = zzgzcVar.zzc;
                if (i6 >= i3) {
                    break;
                }
                jZzc <<= zzgzcVar.zzb;
                if (i4 + i6 < charSequenceZzg.length()) {
                    jZzc |= (long) zzgzcVar.zzc(charSequenceZzg.charAt(i7 + i4));
                    i7++;
                }
                i6++;
            }
            int i8 = zzgzcVar.zzd;
            int i9 = i7 * zzgzcVar.zzb;
            int i10 = (i8 - 1) * 8;
            while (i10 >= (i8 * 8) - i9) {
                bArr[i5] = (byte) ((jZzc >>> i10) & 255);
                i10 -= 8;
                i5++;
            }
            i4 += i3;
        }
        return i5;
    }

    zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgzg(zzgzcVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    final int zzd(int i3) {
        zzgzc zzgzcVar = this.zzb;
        return zzgzcVar.zzc * zzgzz.zzb(i3, zzgzcVar.zzd, RoundingMode.CEILING);
    }

    final void zze(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        zzgtj.zzo(i3, i3 + i4, bArr.length);
        zzgzc zzgzcVar = this.zzb;
        int i5 = zzgzcVar.zzd;
        int i6 = 0;
        zzgtj.zza(i4 <= i5);
        long j3 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            j3 = (j3 | ((long) (bArr[i3 + i7] & 255))) << 8;
        }
        int i8 = (i4 + 1) * 8;
        int i9 = zzgzcVar.zzb;
        while (i6 < i4 * 8) {
            appendable.append(zzgzcVar.zza(zzgzcVar.zza & ((int) (j3 >>> ((i8 - i9) - i6)))));
            i6 += i9;
        }
        if (this.zzc != null) {
            while (i6 < i5 * 8) {
                appendable.append('=');
                i6 += i9;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    final int zzf(int i3) {
        return (int) (((((long) this.zzb.zzb) * ((long) i3)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzc == null) {
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

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzh zzh() {
        return this.zzc == null ? this : zzc(this.zzb, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzh zzi() {
        zzgzh zzgzhVarZzc = this.zza;
        if (zzgzhVarZzc == null) {
            zzgzc zzgzcVar = this.zzb;
            zzgzc zzgzcVarZzd = zzgzcVar.zzd();
            zzgzhVarZzc = zzgzcVarZzd == zzgzcVar ? this : zzc(zzgzcVarZzd, this.zzc);
            this.zza = zzgzhVarZzc;
        }
        return zzgzhVarZzc;
    }

    zzgzg(String str, String str2, Character ch) {
        this(new zzgzc(str, str2.toCharArray()), ch);
    }
}
