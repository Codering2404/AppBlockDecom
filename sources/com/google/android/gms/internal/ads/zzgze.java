package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgze extends zzgzg {
    private zzgze(zzgzc zzgzcVar, Character ch) {
        super(zzgzcVar, ch);
        zzgtj.zza(zzgzcVar.zzf().length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    final void zza(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzgtj.zzo(0, i4, bArr.length);
        for (int i6 = i4; i6 >= 3; i6 -= 3) {
            int i7 = bArr[i5] & 255;
            int i8 = bArr[i5 + 1] & 255;
            int i9 = bArr[i5 + 2] & 255;
            zzgzc zzgzcVar = this.zzb;
            int i10 = (i8 << 8) | (i7 << 16) | i9;
            appendable.append(zzgzcVar.zza(i10 >>> 18));
            appendable.append(zzgzcVar.zza((i10 >>> 12) & 63));
            appendable.append(zzgzcVar.zza((i10 >>> 6) & 63));
            appendable.append(zzgzcVar.zza(i10 & 63));
            i5 += 3;
        }
        if (i5 < i4) {
            zze(appendable, bArr, i5, i4 - i5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
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
        int i3 = 0;
        int i4 = 0;
        while (i3 < charSequenceZzg.length()) {
            int i5 = i4 + 1;
            int iZzc = (zzgzcVar.zzc(charSequenceZzg.charAt(i3 + 1)) << 12) | (zzgzcVar.zzc(charSequenceZzg.charAt(i3)) << 18);
            bArr[i4] = (byte) (iZzc >>> 16);
            int i6 = i3 + 2;
            if (i6 < charSequenceZzg.length()) {
                int i7 = i3 + 3;
                int iZzc2 = iZzc | (zzgzcVar.zzc(charSequenceZzg.charAt(i6)) << 6);
                int i8 = i4 + 2;
                bArr[i5] = (byte) ((iZzc2 >>> 8) & 255);
                if (i7 < charSequenceZzg.length()) {
                    i3 += 4;
                    i4 += 3;
                    bArr[i8] = (byte) ((iZzc2 | zzgzcVar.zzc(charSequenceZzg.charAt(i7))) & 255);
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

    @Override // com.google.android.gms.internal.ads.zzgzg
    final zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgze(zzgzcVar, ch);
    }

    zzgze(String str, String str2, Character ch) {
        this(new zzgzc(str, str2.toCharArray()), ch);
    }
}
