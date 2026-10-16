package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgd extends zzge {
    private zzgd(zzgb zzgbVar, @CheckForNull Character ch) {
        super(zzgbVar, ch);
        zzbm.zzc(zzgbVar.zzf.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzge
    final zzgf zza(zzgb zzgbVar, @CheckForNull Character ch) {
        return new zzgd(zzgbVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzge, com.google.android.gms.internal.fido.zzgf
    final void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzbm.zze(0, i4, bArr.length);
        for (int i6 = i4; i6 >= 3; i6 -= 3) {
            int i7 = bArr[i5] & 255;
            int i8 = ((bArr[i5 + 1] & 255) << 8) | (i7 << 16) | (bArr[i5 + 2] & 255);
            appendable.append(this.zzb.zza(i8 >>> 18));
            appendable.append(this.zzb.zza((i8 >>> 12) & 63));
            appendable.append(this.zzb.zza((i8 >>> 6) & 63));
            appendable.append(this.zzb.zza(i8 & 63));
            i5 += 3;
        }
        if (i5 < i4) {
            zze(appendable, bArr, i5, i4 - i5);
        }
    }

    zzgd(String str, String str2, @CheckForNull Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
