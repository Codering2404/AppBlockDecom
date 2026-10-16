package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgzh {
    private static final zzgzh zza = new zzgze("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzgzh zzb = new zzgze("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzgzh zzc;

    static {
        new zzgzg("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzgzg("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        zzc = new zzgzd("base16()", "0123456789ABCDEF");
    }

    zzgzh() {
    }

    public static zzgzh zzl() {
        return zza;
    }

    public static zzgzh zzm() {
        return zzb;
    }

    public static zzgzh zzn() {
        return zzc;
    }

    abstract void zza(Appendable appendable, byte[] bArr, int i3, int i4) throws IOException;

    abstract int zzb(byte[] bArr, CharSequence charSequence) throws zzgzf;

    abstract int zzd(int i3);

    abstract int zzf(int i3);

    CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public abstract zzgzh zzh();

    public abstract zzgzh zzi();

    public final String zzj(byte[] bArr, int i3, int i4) {
        zzgtj.zzo(0, i4, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i4));
        try {
            zza(sb, bArr, 0, i4);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzg = zzg(charSequence);
            int iZzf = zzf(charSequenceZzg.length());
            byte[] bArr = new byte[iZzf];
            int iZzb = zzb(bArr, charSequenceZzg);
            if (iZzb == iZzf) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZzb];
            System.arraycopy(bArr, 0, bArr2, 0, iZzb);
            return bArr2;
        } catch (zzgzf e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
