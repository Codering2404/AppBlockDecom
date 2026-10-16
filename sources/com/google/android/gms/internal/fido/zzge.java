package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzge extends zzgf {

    @CheckForNull
    private volatile zzgf zza;
    final zzgb zzb;

    @CheckForNull
    final Character zzc;

    zzge(zzgb zzgbVar, @CheckForNull Character ch) {
        this.zzb = zzgbVar;
        if (ch != null && zzgbVar.zzc('=')) {
            throw new IllegalArgumentException(zzbo.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzge) {
            zzge zzgeVar = (zzge) obj;
            if (this.zzb.equals(zzgeVar.zzb) && Objects.equals(this.zzc, zzgeVar.zzc)) {
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
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    zzgf zza(zzgb zzgbVar, @CheckForNull Character ch) {
        return new zzge(zzgbVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        zzbm.zze(0, i4, bArr.length);
        while (i5 < i4) {
            zze(appendable, bArr, i5, Math.min(this.zzb.zzd, i4 - i5));
            i5 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    final int zzc(int i3) {
        zzgb zzgbVar = this.zzb;
        return zzgbVar.zzc * zzgh.zza(i3, zzgbVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    public final zzgf zzd() {
        zzgf zzgfVarZza = this.zza;
        if (zzgfVarZza == null) {
            zzgb zzgbVar = this.zzb;
            zzgb zzgbVarZzb = zzgbVar.zzb();
            zzgfVarZza = zzgbVarZzb == zzgbVar ? this : zza(zzgbVarZzb, this.zzc);
            this.zza = zzgfVarZza;
        }
        return zzgfVarZza;
    }

    final void zze(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException {
        zzbm.zze(i3, i3 + i4, bArr.length);
        int i5 = 0;
        zzbm.zzc(i4 <= this.zzb.zzd);
        long j3 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            j3 = (j3 | ((long) (bArr[i3 + i6] & 255))) << 8;
        }
        int i7 = (i4 + 1) * 8;
        zzgb zzgbVar = this.zzb;
        while (i5 < i4 * 8) {
            long j4 = j3 >>> ((i7 - zzgbVar.zzb) - i5);
            zzgb zzgbVar2 = this.zzb;
            appendable.append(zzgbVar2.zza(((int) j4) & zzgbVar2.zza));
            i5 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i5 < this.zzb.zzd * 8) {
                this.zzc.getClass();
                appendable.append('=');
                i5 += this.zzb.zzb;
            }
        }
    }

    zzge(String str, String str2, @CheckForNull Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
