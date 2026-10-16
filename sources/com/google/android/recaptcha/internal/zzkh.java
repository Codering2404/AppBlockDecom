package com.google.android.recaptcha.internal;

import com.sun.jna.Function;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzkh {
    private static final zzkh zza = new zzke("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzkh zzb = new zzke("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    static {
        new zzkg("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzkg("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        zzkd zzkdVar = new zzkd("base16()", "0123456789ABCDEF".toCharArray());
        new zzkg(zzkdVar, null);
        char[] cArr = new char[512];
        zzjf.zza(zzkdVar.zzf.length == 16);
        for (int i3 = 0; i3 < 256; i3++) {
            cArr[i3] = zzkdVar.zza(i3 >>> 4);
            cArr[i3 | Function.MAX_NARGS] = zzkdVar.zza(i3 & 15);
        }
    }

    zzkh() {
    }

    public static zzkh zzg() {
        return zza;
    }

    public static zzkh zzh() {
        return zzb;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzkf;

    abstract void zzb(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException;

    abstract int zzc(int i3);

    abstract int zzd(int i3);

    CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i3, int i4) {
        zzjf.zzd(0, i4, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i4));
        try {
            zzb(sb, bArr, 0, i4);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence charSequenceZze = zze(charSequence);
            int iZzc = zzc(charSequenceZze.length());
            byte[] bArr = new byte[iZzc];
            int iZza = zza(bArr, charSequenceZze);
            if (iZza == iZzc) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZza];
            System.arraycopy(bArr, 0, bArr2, 0, iZza);
            return bArr2;
        } catch (zzkf e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
