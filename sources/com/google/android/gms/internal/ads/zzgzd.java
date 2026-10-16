package com.google.android.gms.internal.ads;

import com.sun.jna.Function;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzd extends zzgzg {
    final char[] zza;

    private zzgzd(zzgzc zzgzcVar) {
        super(zzgzcVar, null);
        this.zza = new char[512];
        zzgtj.zza(zzgzcVar.zzf().length == 16);
        for (int i3 = 0; i3 < 256; i3++) {
            this.zza[i3] = zzgzcVar.zza(i3 >>> 4);
            this.zza[i3 | Function.MAX_NARGS] = zzgzcVar.zza(i3 & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    final void zza(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        zzgtj.zzo(0, i4, bArr.length);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = bArr[i5] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i6]);
            appendable.append(cArr[i6 | Function.MAX_NARGS]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzh
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length);
            throw new zzgzf(sb.toString());
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < charSequence.length()) {
            zzgzc zzgzcVar = this.zzb;
            bArr[i4] = (byte) (zzgzcVar.zzc(charSequence.charAt(i3 + 1)) | (zzgzcVar.zzc(charSequence.charAt(i3)) << 4));
            i3 += 2;
            i4++;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgzg
    final zzgzh zzc(zzgzc zzgzcVar, Character ch) {
        return new zzgzd(zzgzcVar);
    }

    zzgzd(String str, String str2) {
        this(new zzgzc("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
