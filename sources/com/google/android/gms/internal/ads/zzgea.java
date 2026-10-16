package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgea {
    public static String zza(byte[] bArr, boolean z2) {
        return zzc(z2).zzj(bArr, 0, bArr.length);
    }

    public static byte[] zzb(String str, boolean z2) throws IllegalArgumentException {
        byte[] bArrZzk = zzc(z2).zzk(str);
        if (bArrZzk.length != 0 || str.length() <= 0) {
            return bArrZzk;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }

    private static zzgzh zzc(boolean z2) {
        return z2 ? zzgzh.zzm().zzh() : zzgzh.zzl();
    }
}
