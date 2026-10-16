package com.google.android.gms.internal.fido;

import com.sun.jna.Function;
import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgc extends zzge {
    final char[] zza;

    private zzgc(zzgb zzgbVar) {
        super(zzgbVar, null);
        this.zza = new char[512];
        zzbm.zzc(zzgbVar.zzf.length == 16);
        for (int i3 = 0; i3 < 256; i3++) {
            this.zza[i3] = zzgbVar.zza(i3 >>> 4);
            this.zza[i3 | Function.MAX_NARGS] = zzgbVar.zza(i3 & 15);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzge
    final zzgf zza(zzgb zzgbVar, @CheckForNull Character ch) {
        return new zzgc(zzgbVar);
    }

    @Override // com.google.android.gms.internal.fido.zzge, com.google.android.gms.internal.fido.zzgf
    final void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        zzbm.zze(0, i4, bArr.length);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = bArr[i5] & 255;
            appendable.append(this.zza[i6]);
            appendable.append(this.zza[i6 | Function.MAX_NARGS]);
        }
    }

    zzgc(String str, String str2) {
        this(new zzgb("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
